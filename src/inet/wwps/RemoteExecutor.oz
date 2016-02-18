/*
 Copyright(c) 1996-1998
 IPA, ETL, AT21, FSIABC, FXIS, InArc, MRI, NUL, SBC, Sharp, TEC, TIS

 All rights reserved.  No guarantee.
 This technology is a result of the Advanced Software  Enrichment 
 Project of Information-technology Promotion Agency, Japan (IPA).

 Permissions  to  use,  copy, modify and distribute this software
 are governed by the terms and conditions set forth in  the  file 
 COPYRIGHT, located on the top directory of this software.
 */

/*
 * $Id: RemoteExecutor.oz,v 0.8 1998-01-30 11:04:18+09 otokawa Exp $
 */

/**
  * a class of remote executor
  */

class RemoteExecutor {
  /**
    * statring service
    *
    * @param c OZCGI Server
    */
  public void start (OzCGI c) {
    RemoteReceiver rr=>create (c, "WWPS_EXECUTE");
    Thread th=>create (rr);
  }

  /**
    * statring service for test
    *
    * @param c OZCGI Server
    */
  public void startForTest (OzCGI c) {
    RemoteReceiver rr=>createForTest (c, "WWPS_EXECUTE");
    Thread th=>create (rr);

    th->join ();
  }

  /**
    * create new one
    */
  new create () {
  }
}

/**
  * a clas for receiving remote execution request
  */
class RemoteReceiver : *ReceiveThread {
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
    
    if (command->isequal ("execute")) {
      /* remote execute */
      RemoteExecuteThread runnable=>create (cgi, html);
      Thread th = createThread (runnable);
      if (test_mode) th->join ();

    } else if (command->isequal ("execute_test")) {
      /* remote execute */
      RemoteExecuteThread runnable=>createForTest (cgi, html);
      Thread th = createThread (runnable);
      th->join ();

    } else {
      sendResult ("your request is illegal.");
      return;
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

  }

  /**
    * create new one for testing
    *
    * @param c OZCGI Server
    * @param sel selector string
    */
  new createForTest (OzCGI c, String sel) { 
    super=>create (c, sel); 
    test_mode = true;
  }
}

/**
  * a class for remote execution
  */
class RemoteExecuteThread : *ExecuteThread {
  /**
    * override 
    */
  public void run () {
    String cid = extractClassID ();
    if (cid == null) {
      sendResult ("cannot find class ID");
      return;
    }

    exec (cid);
  }

  /**
    * extract class ID
    */
  String extractClassID () {
    String cid;
    cid =| html->getValue ("class");

    if (cid->startsWith (".")) 
      return "JP.go.ipa.oz"->concat (cid);

    return cid;
  }

  /**
    * execute
    */
  void exec (String cid) {
    try {
      ClassLoader cl=>create ();
      cl->loadClass (cid);
    } catch (ClassNotFoundException e) {
      sendResult ("cannot execute that class for some reason: "->concat (cid));
      return;
    }

    /* create script file */
    String exec_file = createPath ("exec");
    String exec_log = createPath ("exec.log", html->getRequestID ());

    Writer file;
    FileWriter fw;
    StringWriter sw;

    if (test_mode) {
      sw =>breed ();
      file = sw;
    } else {
      fw=>breed (exec_file);
      file = fw;
    }

    StringBuffer command;
    File f=>breed (exec_file);
    StringBuffer path=>breed ("\"");
    if (f->getSeparatorChar () == '/') {
      command=>breed ("oz -f ");
      path->append (exec_log);
    } else {
      command=>breed ("oz.bat -f ");

      int backslash, prev_backslash = 0;
      while (true) {
	backslash = exec_log->indexOf ('\\', prev_backslash);
	if (backslash == -1) {
	  path->append (exec_log->substring (prev_backslash));
	  break;
	} else
	  path->append (exec_log->substring (prev_backslash, backslash));
	path->append ("\\\\");
	prev_backslash = backslash + 1;
      }

    }

    path->append ('\"');
    writeScript (file, cid, path->asString ());

    command->append (exec_file);

    if (!test_mode)
      fw->close ();

    if (test_mode) {
      sendResult (sw->asString ());
      return;
    }

    try {
      Process process=>create (command->asString ());

      /* wait for end */
      process->waitFor ();

      FileReader fr=>breed (exec_log);
      BufferedReader in=>breed (fr);
      StringWriter out=>breed ();
      while (true) {
	String line = in->readLine ();
	if (line == null)
	  break;

	out->write (line);
	out->write ("\n");
      }
      in->close ();

      if (out->getBuffer ()->length () == 0)
	out->write ("no output");

      sendResult (out);
    } finally {
      /* if debugging, must comment-out below lines */
      f->delete ();
      f=>breed (f->getParent ())->delete ();
      f=>breed (exec_log);
      f->delete ();
    }
  }

  /**
    * write script contents
    */
  void writeScript (Writer file, String cid, String log_file) {
    String param;
    param =| html->getValue ("param");
    String gid = html->getRequestID ();
    StringBuffer buf=>breed ("create ");

    buf->append (gid);
    buf->append (" ");
    buf->append (cid);
    buf->append (' ');
    buf->append (log_file);
    if (param != null) {
      buf->append (' ');
      buf->append (param);
    }
    buf->append (";\n");
    file->write (buf->asString (), 0, buf->length ());

    buf->setLength (0);
    buf->append ("stop ");
    buf->append (gid);
    buf->append (";\n");
    file->write (buf->asString (), 0, buf->length ());

    buf->setLength (0);
    buf->append ("go ");
    buf->append (gid);
    buf->append (";\n");
    file->write (buf->asString (), 0, buf->length ());

    buf->setLength (0);
    buf->append ("remove ");
    buf->append (gid);
    buf->append (";\n");
    file->write (buf->asString (), 0, buf->length ());
  }

  /**
    * create new one
    * 
    * @param c OZCGI Server
    * @param h reuest data
    */
  new create (OzCGI c, HTMLData h) {
    super=>create (c, h);
  }

  /**
    * create new one for test
    * 
    * @param c OZCGI Server
    * @param h reuest data
    */
  new createForTest (OzCGI c, HTMLData h) {
    super=>create (c, h);
    test_mode = true;
  }
}

/* EOF */
