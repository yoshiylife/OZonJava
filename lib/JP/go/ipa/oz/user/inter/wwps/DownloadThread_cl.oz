/*
 * $Id: CompilerCGI.oz,v 0.10 1998-01-30 11:04:16+09 otokawa Exp $
 */

/**
  * a class of compile server CGI
  */
class CompilerCGI {
  /**
    * start service
    *
    * @param c OZCGI Server
    */
  public void start (OzCGI c) {
    CompileReceiver cr=>create (c, "WWPS_COMPILE");
    Thread th=>create (cr);
  }

  /**
    * start service for testing
    *
    * @param c OZCGI Server
    */
  public void startForTest (OzCGI c) {
    CompileReceiver cr=>createForTest (c, "WWPS_COMPILE");
    Thread th=>create (cr);
    th->join ();
  }

  /**
    * create new one
    */
  new create () {
  }
}

/**
  * a class for receiving compile request
  */
class CompileReceiver : *ReceiveThread {
  /**
    * compiler server 
    */
  CompilerServer compiler_server;

  /**
    * override 
    */
  protected void dispatch () {
    String command;
    command =| html->getValue ("command");

    if (command == null) {
      sendResult ("your request is illegal.");
      return;
    }    
    
    System sys=>create ();
    sys->debugPrintln (command);

    if (command->isequal ("compile")) {
      CompileThread runnable=>create (cgi, html, compiler_server);
      Thread th = createThread (runnable);
      if (test_mode) th->join ();

    } else if (command->isequal ("compile_test")) {
      CompileThread runnable=>createForTest (cgi, html, compiler_server);
      Thread th = createThread (runnable);
      th->join ();

    } else if (command->isequal ("download")) {
      DownloadThread runnable=>create (cgi, html, compiler_server);
      Thread th = createThread (runnable);
      if (test_mode) th->join ();

    } else {
      sendResult ("your request is illegal.");
    }
  }

  /**
    * create new one
    *
    * @param c OZCGI Server
    * @param sel selector string
    */
  new create (OzCGI c, String sel) { 
    super=>create (c, sel); 
    compiler_server=>create ();
  }

  /**
    * create new one for testing
    *
    * @param c OZCGI Server
    * @param sel selector string
    */
  new createForTest (OzCGI c, String sel) { 
    super=>create (c, sel); 
    compiler_server=>create ();
    test_mode = true;
  }

  /**
    * override
    */
  protected void atExit () {
    stopCell ();
  }
}

/**
  * a class for executing compilation
  */
class CompileThread : *WWPSExecuteThread {
  /**
    * school object
    */
  School school;

  /**
    * source file
    */
  String source;

  /**
    * compiler server
    */
  CompilerServer compiler_server;

  /**
    * override 
    */
  public void run () {
    try {
      Set sources=>create ();

      source = extractSource (sources);
    
      getSchool ();
 
      if (test_mode) {
	sendResult ("done");
	return;
      }

      /* invoke compile */
      StringWriter log=>breed ();

      if (sources->size () == 0) 
	compiler_server->compile (source, school, log);
      else {
	Iterator it = sources->iterator ();
	while (it->hasMoreElements ()) {
	  source =| it->nextElement ();
	  compiler_server->compile (source, school, log);
	}
      }

      sendResult (log);
    } catch (String zip) {
      sendResult ("not zip file");
    } finally {

      if (test_mode) return;

      /* if debugging, must comment-out below lines */

      File f=>breed (source);
      String dir = f->getParent ()->concat (f->getSeparator ());
      System sys=>create ();
      sys->debugPrintln ("run#"->concat (dir));
      CompilerAgent ozc=>create (dir);
      ozc->deleteAllFiles ();
      f=>breed (dir)->delete ();

      /* until here */
    }
  }

  /**
    * get a school 
    */
  void getSchool () {
    String school_name;
    school_name =| html->getValue ("school_name");
    if (school_name->length () == 0) {
      sendResult ("need school name.");
      return;
    }

    school = extractSchool (school_name, "school");
    if (school != null)
      compiler_server->registerSchool (school_name, school);
    else {
      school = compiler_server->searchSchool (school_name);
      
      if (school == null) {
	StringBuffer buf=>breed ();
	buf->append ("not found school: ");
	buf->append (school_name);
	sendResult (buf->asString ());
	return;
      }
    }
  }

  /**
    * create new one
    * 
    * @param c OZCGI Server
    * @param h reuest data
    * @param cs compiler_server
    */
  new create (OzCGI c, HTMLData h, CompilerServer cs) {
    super=>create (c, h);
    compiler_server = cs;
  }

  /**
    * create new one for testing
    * 
    * @param c OZCGI Server
    * @param h reuest data
    * @param cs compiler_server
    */
  new createForTest (OzCGI c, HTMLData h, CompilerServer cs) {
    super=>create (c, h);
    compiler_server = cs;
    test_mode = true;
  }
}

/**
  * a class for downloading class
  */
class DownloadThread : *WWPSExecuteThread {
  /**
    * compiler server
    */
  CompilerServer compiler_server;

  /**
    * class id
    */
  String class_id;
     
  /**
    * override 
    */
  public void run () {
    /* extract class id */
    extractClassID ();
    
    /* get class file from local repository*/

    try {
      sendFile ();
    } catch (FileNotFoundException e) {
      sendResult ("not found class file.");
    }
  }

  /**
    * extract class id from request
    */
  void extractClassID () {
    class_id =| html->getValue ("class");
  }

  /**
    * sending file
    */
  void sendFile () {
    int dot = class_id->lastIndexOf ('.');
    String file = class_id->substring (dot + 1)->concat (".class");
    ClassProperty cp=>create (class_id, file);

    DataInputStream in = null;
    try {
      in=>breed (cp->getInputStream ());
      int size;

      size =| cp->length ();
      sendFile (in, file, size);
    } catch (IOException e) {
      sendResult ("not found class file");
      return;
    } finally {
      if (in != null)
	in->close ();
    }
  }

  /**
    * create new one
    * 
    * @param c OZCGI Server
    * @param h reuest data
    * @param cs compiler_server
    */
  new create (OzCGI c, HTMLData h, CompilerServer cs) {
    super=>create (c, h);
    compiler_server = cs;
  }
}

/* EOF */
