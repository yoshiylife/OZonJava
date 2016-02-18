/*
 * $Id: OzCGI.oz,v 0.23 1998/01/30 02:15:21 otokawa Exp $
 */

/**
  * main class (cell) of OZ CGI Server
  *
  */

cell OzCGI {

  /** 
    * table of randezvou points for input thread 
    */
  transient RandezvouTable input_randezvou_table;

  /** 
    * table of randezvou points for output thread 
    */
  transient RandezvouTable output_randezvou_table;

  /**
    * runnable from CGISocket
    */
  transient CGISocket cgi_socket;

  /**
    * version 
    *

HTMLData.oz:
     HTMLData.oz,v 0.11 1998-01-30 11:04:08+09 otokawa Exp $

OzCGIManager.oz:
     OzCGIManager.oz,v 0.1 1997-12-11 18:25:19+09 otokawa Exp $

FileProperty.oz:
     FileProperty.oz,v 0.2 1998-01-22 16:59:23+09 otokawa Exp $

FilePropertyReader.oz:
     FilePropertyReader.oz,v 0.1 1998-01-22 16:59:03+09 otokawa Exp $

    */
  String version () { return "OzCGI version 1.0"; }

  /**
    * override
    */
  protected void initialize () {}

  /**
    * override
    */
  public void go () {
    /* setup port number */

    OzCGIPropertyReader prop=>create ();
    prop->read ();
    int port = prop->getPort ();

    if (port == 0) port = 5000;

    input_randezvou_table=>create ();
    output_randezvou_table=>create ();

    Thread th=>create (cgi_socket=>create (port,
					     input_randezvou_table,
					     output_randezvou_table));

    OzCGIManager mng=>create (this);
  }

  /**
    * override
    */
  public void quiet () {
    if (input_randezvou_table != null) {
      input_randezvou_table->finish ();
    }

    if (output_randezvou_table != null) {
      output_randezvou_table->finish ();
    }

    if (cgi_socket != null)
      cgi_socket->stop ();

    flushCell ();
  }

  /**
    * receive request data from client
    *
    *	form_id: form ID
    */
  public HTMLData receiveRequest (String form_id) {
    System sys=>create ();
    sys->debugPrintln ("received request: ");
    sys->debugPrintln (form_id);
    
    RandezvouPoint rp;
    input_randezvou_table->registerRandezvouPoint (form_id, rp=>create ());

    HTMLData html = rp->getHtml ();

    return html;
  }

  /**
    * send result data for client
    *
    * 	result: result data
    */
  public void sendResult (HTMLData result) {
    String request_id = result->getRequestID ();
    output_randezvou_table->signalRandezvouPoint (request_id, result);
  }

  /**
    * is alive 
    */
  public void ping () {}

  /**
    * stop server
    */
  public void quit () {
    stopCell ();
  }
}

/**
  * A class representation randezvou point of threads 
  */

class RandezvouPoint {
  /**
    * for synchronization
    */
  condition randezvou;

  /**
    * result data 
    */
  HTMLData html_obj;

  /**
    * create new one
    */
  new create () {}

  /** 
    * access for html_obj
    *
    * @return html object
    */
  public HTMLData getHtml () { return html_obj; }

  /** 
    * set for html_obj
    *
    * @parm html html object
    */
  public void setHtml (HTMLData html) { html_obj = html; }

  /** 
    * wait for randezvou;
    */
  public locked void waitRandezvou () { wait (randezvou); }

  /** 
    * signal for randezvou;
    */
  public locked void signalRandezvou () { signal (randezvou); }
}

/**
  * A class representation of table of randezvou points of threads
  */

class RandezvouTable : *Dictionary {
  /**
    * register one randezvou point 
    *
    *	id: key value
    *	rp: randezvou point
    */
  public void registerRandezvouPoint (String id, RandezvouPoint rp) {
    if (checkAndRegister (id, rp)) {
      /* wait until signal */
      rp->waitRandezvou ();
    }

    remove (id);
  }

  /**
    * check if already received data,
    * 	if so get data, otherwise regiter randezvou point
    */
  locked boolean checkAndRegister (String id, RandezvouPoint rp) { 
    System sys=>create ();

    if (containsKey (id)) {
      RandezvouPoint prev;
      prev =| get (id);
      rp->setHtml (prev->getHtml ());

      return false;
    } else {
      sys->debugPrintln ("register form ID:");
      sys->debugPrintln (id);

      put (id, rp);

      return true;
    }
  }

  /**
    * signal one randezvou point and set html object
    *
    * 	id: key value
    *	html: html object
    */
  public locked void signalRandezvouPoint (String id, HTMLData html) {
    System sys=>create ();

    RandezvouPoint rp;

    rp =| get (id);

    if (rp == null) {
      sys->debugPrintln ("not registered:");
      sys->debugPrintln (id);
      rp=>create ();
      rp->setHtml (html);
      put (id, rp);
    } else {
      rp->setHtml (html);
      rp->signalRandezvou ();
    }
  }

  /**
    * signal all condition variable for exitting CGI server
    */
  public void finish () {
    Iterator it = values ()->iterator ();

    while (it->hasMoreElements ()) {
      RandezvouPoint rp;

      rp =| it->nextElement ();

      rp->signalRandezvou ();
      rp->setHtml (null);
    }
  }
  
  /**
    * create new one
    */
  new create () { 
    StringComparator scomp=>create ();
    super=>create (scomp); 
  }
}

/**
  * A class representation of thread for communication with CGI program
  */

class CGI : *Runnable {
  /**
    * communicating socket
    */
  Socket socket;

  /**
    * request number 
    */
  int request_number;

  /**
    * table of randezvou points for input
    */
  RandezvouTable input_randezvou_table;

  /**
    * table of randezvou points for output
    */
  RandezvouTable output_randezvou_table;

  /**
    * test flag
    */
  bool test_mode;

  /**
    * override 
    */
  public void run () {
    /* receive request */
    BufferedInputStream is=>breed (socket->getInputStream ());

    if (test_mode) {
      InputStreamReader ir=>breed (is);
      BufferedReader br=>breed (ir);
      String str = br->readLine ();

      OutputStream os = socket->getOutputStream ();
      OutputStreamWriter ow=>breed (os);
      ow->write (str, 0, str->length ());
      ow->flush ();

      socket->close ();
      return;
    }

    /* create html object */
    HTMLData html=>create (is, request_number);
    String form_id = html->getFormID ();

    /* illegal data (no form ID) */
    if (form_id == null) {
      /* close socket */
      socket->close ();

      return;

      /* dieing ... */
    }

    /* send request */
    input_randezvou_table->signalRandezvouPoint (form_id, html);

    /* wait result */
    RandezvouPoint rp;
    output_randezvou_table
      ->registerRandezvouPoint (html->getRequestID (), rp=>create ());

    /* send result */
    OutputStream os = socket->getOutputStream ();
    OutputStreamWriter ow=>breed (os);
    html = rp->getHtml ();

    String str;
    /* server was abort */
    if (html == null) {
      HTMLData html=>create ();
      html->startOutput ("text/html");
      html->beginTag ("html");
      html->addOutput ("OZCGI server stopped.");
      html->endOutput ();
      str = html->output ();
    } else
      str = html->output ();

    System sys=>create ();
    sys->debugPrintln ("sending data: ");
    sys->debugPrintln (str);

    ow->write (str, 0, str->length ());
    ow->flush ();

    if (html != null) {
      ByteArray buf = html->binaryData ();
      if (buf != null) {
	os->write (buf, 0, buf->length ());
      }
    }

    os->flush ();
    os->close ();

    /* close socket */
    socket->close ();

    /* dieing ... */
  }

  /**
    * create new one for testing
    *
    *	s: communicatig socket
    *	req_no: request number 
    *	in_table: table of randezvou points for input
    *	out_table: table of randezvou points for output
    *	test: test flag
    */
  new create (Socket s, int req_no,
	      RandezvouTable in_table, RandezvouTable out_table, bool test) {
    socket = s;
    request_number = req_no;
    input_randezvou_table = in_table;
    output_randezvou_table = out_table;
    test_mode = test;
  }
}

/**
  * A class representation of thread for management of communcation 
  * with CGI program
  */

class CGISocket : *Runnable {
  /**
    * waiting port number 
    */
  int port;

  /**
    * number of received request (to assign request ID)
    */
  int no_requests;

  /**
    * table of randezvou points for input
    */
  RandezvouTable input_randezvou_table;

  /**
    * table of randezvou points for output
    */
  RandezvouTable output_randezvou_table;

  /**
    * socket with waiting port
    */
  ServerSocket server;

  /**
    * test flag
    */
  bool test_mode;

  /**
    * override 
    */
  public void run () {
    System sys=>create ();

    sys->debugPrintln ("server started");

    try {
      server=>breed (port);
    } catch (IOException e) {
      System sys=>create ();
      sys->println ("cannot open port: "->concat (""->valueOf (port)));
      stopCell ();
      return;
    }

    server->setSoTimeout (5000);

    while (true) {
      try {
	Socket s = server->accept ();

	sys->debugPrintln ("connected");

	CGI cgi_runnable;
	Thread cgi=>create (cgi_runnable=>create (s, no_requests++,
						  input_randezvou_table, 
						  output_randezvou_table, 
						  test_mode));
	if (test_mode) break;
      } catch (IOException e) {
	if (!e->getMessage ()->startsWith ("Accept timed out")) {
	  System sys=>create ();
	  sys->debugPrintln (e->getMessage ());
	  break;
	}
      }
    }
    
    /* not reached */
  }

  /**
    * create new one 
    *
    *	p: port number 
    *	in_table: table of randezvou points for input
    *	out_table: table of randezvou points for output
    */
  new create (int p,
	      RandezvouTable in_table, RandezvouTable out_table) {
    port = p; 
    input_randezvou_table = in_table;
    output_randezvou_table = out_table;
  }

  /**
    * create new one for testing
    *
    *	p: port number 
    *	in_table: table of randezvou points for input
    *	out_table: table of randezvou points for output
    */
  new createForTest (int p,
		     RandezvouTable in_table, RandezvouTable out_table) {
    port = p; 
    input_randezvou_table = in_table;
    output_randezvou_table = out_table;
    test_mode = true;
  }

  /**
    * stop because OZCGI was stopping
    */
  public void stop () {
    server->close ();
  }
}


/**
  * a class of receving request 
  */
abstract class ReceiveThread : *ExecuteThread {
  /** 
    * selector string
    */
  String selector;

  /**
    * override 
    */
  public void run () {
    System sys=>create ();

    while (true) {
      html = cgi->receiveRequest (selector);
      if (html == null) {
	atExit ();
	break;
      }

      turnGreen (html);

      sys->debugPrintln (selector);
      sys->debugPrintln ("\t: received data");
      
      try {
	dispatch ();
      } catch (SecurityException e) {
	sendResult ("OZ security error !");
      } catch (RuntimeException e) {
	sendResult ("some exception occured: "->concat (e->getMessage ()));
      }

      if (test_mode && --operation_count <= 0) return;
    }
  }

  /**
    * create new one
    *
    * @param c OZCGI Server
    * @param sel selector string
    */
  new create (OzCGI c, String sel) { 
    super=>create (c, null);
    selector = sel;
  }

  /**
    * dispathing request 
    */
  protected abstract void dispatch ();

  /**
    * execute on exiting
    */
  protected void atExit () {}
}

/**
  * a class of executing request
  */
abstract class ExecuteThread : *Runnable {
  /**
    * OZCGI Server
    */
  protected OzCGI cgi;
  
  /**
    * reuquest data
    */
  protected HTMLData html;

  /**
    * threads
    */
  Array threads;

  /**
    * test flag
    */
  protected bool test_mode;
  
  /**
    * operation count
    */
  protected int operation_count;

  /**
    * create new one
    * 
    * @param c OZCGI Server
    * @param h reuest data
    */
  new create (OzCGI c, HTMLData h) {
    cgi = c;
    html = h;
    
    threads=>create (10);
  }

  /**
    * sending result
    *
    * @param str messgae string 
    */
  protected void sendResult (String str) {
    html->startOutput ("text/html");

    html->beginTag ("html");
    html->beginTag ("head");
    html->beginTag ("title");
    html->addOutput (str);
    html->endTag ();
    html->endTag ();

    html->beginTag ("body");
    html->addOutput (str);
    html->endTag ();

    html->endOutput ();

    cgi->sendResult (html);
  }

  /**
    * sending result
    *
    * @param log logged data
    */
  protected void sendResult (Writer log) {
    html->startOutput ("text/html");

    html->beginTag ("html");
    html->beginTag ("head");
    html->beginTag ("title");
    html->addOutput ("Result");
    html->endTag ();
    html->endTag ();

    html->beginTag ("body");
    html->beginTag ("pre");
    html->addOutput (log->asString ());
    html->endTag ();
    html->endTag ();

    html->endOutput ();

    cgi->sendResult (html);
  }

  /**
    * sending file 
    *
    * @param data input stream of sending contents
    * @param name file name
    * @param size data size
    */
  protected void sendFile (InputStream data, String name, int size) {
    html->startOutput ("application/octet-stream", name);
    html->addOutput (data, size);
    cgi->sendResult (html);
  }

  /**
    * create a source path name 
    *
    * @param base base string
    */
  protected String createPath (String base) {
    return createPath (base, getGOD ());
  }

  /**
    * create a source path name 
    *
    * @param base base string
    * @param god cell name
    */
  protected String createPath (String base, String god) {
    System sys=>create ();
    String ozhome = sys->getOzHome ();
    char sep = ozhome->startsWith ("/") ? '/' : '\\';
    StringBuffer path=>breed (ozhome);

    path->append (sep);
    path->append ("objects");

    path->append (sep);
    path->append (god);
    if (god->isequal (getGOD ())) {
      path->append (sep);
      path->append (html->getRequestID ());
      File dir=>breed (path->asString ());
      if (!dir->isDirectory ())
	dir->mkdir ();
      path->append (sep);
    } else {
      path->append (sep); 
    }

    path->append (base);

    return path->asString ();
  }

  protected Thread createThread (Runnable run) {
    Thread th;
    return th=>create (run);

    /*
    for (int i = 0, size = threads->size (); i < size; i++) {
      Thead buf =| threads->at (i);
      if (buf == null) {
	if (th == null) {
	  th=>create (run);
	  threads->putAt (i, th);
	} 
      } else {
	if (!buf->isAlive ()) {
	  buf->join ();
	  threads->putAt (i, null);
	}
      }
    }

    if (th == null)
      sendResult ("busy");

    return th;
    */

  }
}

class OzCGIPropertyReader : FilePropertyReader {
  /**
    * port number
    */
  int port;

  /**
    * create new one
    */
  new create () {
  }

  /**
    * read contents (property file is $OZHOME/lib/ozcgi.properties)
    */
  public void read () {
    FileProperty fp=>create ();
    fp->read ("ozcgi.properties", this);
  }

  /**
    * get port number
    *
    * @return port number
    */
  public int getPort () { return port; }

  /**
    * override
    */
  public void eval (String label, String value) {
    if (label->isequal ("port")) {
      try {
	port = value->parseInt ();
      } catch (NumberFormatException e) {
	port = 0;
      }
    }
  }
}

/* EOF */

