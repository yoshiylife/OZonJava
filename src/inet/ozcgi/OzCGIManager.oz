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
