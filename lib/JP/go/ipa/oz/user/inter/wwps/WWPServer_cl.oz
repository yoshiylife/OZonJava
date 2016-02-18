/*
 * $Id: WWPServer.oz,v 0.24 1998/01/30 02:16:47 otokawa Exp $
 */

/**
  * main class (cell) of World Wide Programming Server
  */

cell WWPServer {
  /**
    * OZCGI Server
    */
  OzCGI cgi;

  /**
    * version 
    *

CompilerAgent.oz:
     CompilerAgent.oz,v 0.3 1998-01-30 11:04:15+09 otokawa Exp $

CompilerCGI.oz:
     CompilerCGI.oz,v 0.10 1998-01-30 11:04:16+09 otokawa Exp $

CompilerServer.oz:
     CompilerServer.oz,v 0.1 1997-11-06 16:44:51+09 otokawa Exp $

ComponentServer.oz:
     ComponentServer.oz,v 0.10 1998-01-30 11:04:17+09 otokawa Exp $

RemoteExecutor.oz:
     RemoteExecutor.oz,v 0.8 1998-01-30 11:04:18+09 otokawa Exp $

    */
  String version () { return "WWPServer version 1.0"; }

  /**
    * override
    */
  protected void initialize () {}

  /**
    * override
    */
  public void go () {
    WWPSPropertyReader prop=>create ();
    prop->read ();
    String gol = prop->getOzCGI ();
    if (gol == null)
      gol = "OZCGI";

    cgi=>bind (gol);
    
    try {
      cgi->ping ();
    } catch (CellNotFoundException e) {
      System sys=>create ();
      StringBuffer msg=>breed ("Not found cell: ");
      msg->append (gol);
      sys->println (msg->asString ());
      stopCell ();
    }

    CompilerCGI ccgi=>create ();
    RemoteExecutor remote=>create ();
    ComponentServer cserver=>create ();

    ccgi->start (cgi);
    remote->start (cgi);
    cserver->start (cgi);
  }

  /**
    * override
    */
  public void quiet () {
    flushCell ();
  }
}

class WWPSPropertyReader : FilePropertyReader {
  /**
    * OZCGI GOD
    */
  String ozcgi_god;

  /**
    * create new one
    */
  new create () {
  }

  /**
    * read contents (property file is $OZHOME/lib/wwps.properties)
    */
  public void read () {
    FileProperty fp=>create ();
    fp->read ("wwps.properties", this);
  }

  /**
    * get OZCGI GOD
    *
    * @return OZCGI GOD
    */
  public String getOzCGI () { return ozcgi_god; }

  /**
    * override
    */
  public void eval (String label, String value) {
    if (label->isequal ("ozcgi.god")) {
      ozcgi_god = value;
    }
  }
}

abstract class WWPSExecuteThread : *ExecuteThread {
  /**
    * extract school data
    *
    * @param school_name subject name
    * @param school_tag school tag value
    */
  protected School extractSchool (String school_name, String school_tag) {
    ByteArray school_src;
    school_src =| html->getValue (school_tag);

    System sys=>create ();
    sys->debugPrintln (school_name);

    if (school_src->length () == 0)
      return null;

    String school_src_name = createPath ("school.s");
    FileOutputStream file=>breed (school_src_name);
    file->write (school_src);
    file->close ();

    /* convert from file */
    School school=>create ();
    Subject sub=>create (school_name);
    school->putSubject (sub);
    school->loadFromFile (school_src_name, school_name);

    /* if debugging, must comment-out below lines */

    if (!test_mode) {
      File f=>breed (school_src_name);
      f->delete ();
    }

    /* until here */


    return school;
  }

  /**
    * extract source data
    * 
    * @param sources source files
    * @return source file name
    */
  protected String extractSource (Set sources) {
    ByteArray src;
    src =| html->getValue ("src");

    String filename;
    filename =| html->getValue ("srcfilename");

    if (filename->endsWith (".oz"))
      return extractOne (filename, src);
    else {
      extractZipped (src, sources);
      return null;
    }
  }

  /** 
    * extract one source file
    *
    * @param file_name file name
    * @param src source data
    * @return source file name
    */
  String extractOne (String file_name, ByteArray src) {
    System sys=>create ();

    int bs = file_name->lastIndexOf ('\\');
    if (bs < 0)
      bs = file_name->lastIndexOf ('/');
    if (bs != -1) {
      int len = file_name->length ();
      file_name = file_name->substring (bs + 1, len);
    }
    
    String source = createPath (file_name);

    sys->debugPrintln (source);
    
    FileOutputStream file=>breed (source);
    file->write (src);
    file->close ();

    return source;
  }

  /** 
    * extract zipped source files
    *
    * @param src source data (zipped data)
    * @param sources source files
    */
  String extractZipped (ByteArray src, Set sources) {
    String source = createPath ("wwps.zip");
    
    System sys=>create ();
    sys->debugPrintln (source);

    FileOutputStream file=>breed (source);
    file->write (src);
    file->close ();

    try {
      ZipArchive zip=>create (source);
      Iterator it = zip->list ()->iterator ();
      while (it->hasMoreElements ()) {
	String ozsrc;
	ozsrc =| it->nextElement ();

	sys->debugPrintln (ozsrc);

	File f=>breed (ozsrc);
	String src = createPath (f->getName ());

	zip->extract (src, ozsrc);
	sources->add (src);
      }
    } catch (ZipException e) {
      sys->debugPrintln (e->getMessage ());

      throw source;
    } catch (FileNotFoundException e) {
      sys->debugPrintln (e->getMessage ());

      throw source;
    } catch (IOException e) {
      sys->debugPrintln (e->getMessage ());

      throw source;
    }

    return source;
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
}

/* EOF */

