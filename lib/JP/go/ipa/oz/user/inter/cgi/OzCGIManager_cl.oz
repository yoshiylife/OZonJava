/*
 * $Id: OzCGIManager.oz,v 0.1 1997-12-11 18:25:19+09 otokawa Exp $
 */

/**
  * a class for managgin OZCGI server by WWW client
  */

class OzCGIManager {
  /**
    * create new one
    */
  new create (OzCGI cgi) {
    OzCGIManagerThread run=>create (cgi);
    Thread th=>create (run);
  }
}

class OzCGIManagerThread : *ReceiveThread {
  /**
    * create new one
    *
    * @param c OZCGI Server
    */
  new create (OzCGI c) {
    super=>create (c, "OZCGI_MANAGE");
  }

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
    
    if (command->isequal ("quit")) {
      cgi->quit ();
      sendResult ("OZCGI stopping...");
    } else {
      sendResult ("your request is illegal.");
    }
  }
}
