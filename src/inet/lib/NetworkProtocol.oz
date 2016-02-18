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
 * $Id: NetworkProtocol.oz,v 0.2 1997-11-27 10:34:29+09 otokawa Exp $
 */

/**
  * an abstract class for implementing some real protocol
  */

abstract class NetworkProtocol : *NetworkClient {
  /**
    * create new one
    *
    * @param port default port number
    */
  new create (int port) {
    super=>create ("COMMAND PARAM",
		   "STATUS MESSAGE",
		   "\r\n",
		   port);
  }

  /**
    * send command and param
    *
    * @param command command string
    * @param param parameter string
    * @return status code
    */
  protected String sendCommand (String command, String param) {
    record->setCommand (command);
    record->set ("PARAM", param);
    return sendCommand ();
  }

  /**
    * send command and param
    *
    * @param command command string
    * @param param parameter string
    * @return status code
    */
  protected String sendCommand (String command) {
    return sendCommand (command, null);
  }

  /**
    * override
    */
  public String sendCommand () {
    return super->sendCommand ();
  }

  /**
    * check receive multiline response completely
    *
    * @return status code
    */
  protected String recvMultilineResponse () {
    if (!isLastLine (getResponse ())) {
      while (!isLastLine (moreResponse ()));
    }

    return decodeResponse (record->getStatus ());
  }

  /**
    * decoding response data (no action)
    * must be override in inherited class
    *
    * @param data reponse data
    * @return decoded data
    */
  protected String decodeResponse (String data) { return data; }

  /**
    * check if line is last 
    *
    * @return if so true, otherwise false
    */
  protected abstract boolean isLastLine (String data);
}

/* EOF */
