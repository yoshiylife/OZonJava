/*
 * $Id: SMTP.oz,v 0.2 1997-12-05 14:20:51+09 otokawa Exp $
 */

/**
  * a class representing SMTP protocol
  */

class SMTP : *NetworkProtocol {
  /**
    * create new one
    */
  new create () {
    super=>create (25);
  }

  /**
    * HELO command
    * 
    * @param domain domain name
    * @return status 
    */
  public String helo (String domain) {
    return sendCommand ("HELO", domain);
  }

  /**
    * MAIL command 
    *
    * @param from from parameter
    * @return status 
    */
  public String mail (String from) {
    return sendCommand ("MAIL", from);
  }

  /**
    * RCPT command 
    *
    * @param to to parameter
    * @return status 
    */
  public String rcpt (String to) {
    return sendCommand ("RCPT", to);
  }

  /**
    * DATA command 
    *
    * @param contents contents data
    * @return status 
    */
  public String data (String contents) {
    String buf = sendCommand ("DATA");
    if (buf->charAt (0) != '3')
      return response_message;

    return sendData (contents);
  }

  /**
    * SEND command 
    *
    * @param from parameter
    * @return status 
    */
  public String send (String from) {
    return sendCommand ("SEND", from);
  }

  /**
    * SOML command 
    *
    * @param from parameter
    * @return status 
    */
  public String soml (String from) {
    return sendCommand ("SOML", from);
  }

  /**
    * SAML command 
    *
    * @param from from parameter
    * @return status 
    */
  public String saml (String from) {
    return sendCommand ("SAML", from);
  }

  /**
    * RSET command 
    *
    * @return status 
    */
  public String rset () {
    return sendCommand ("RSET");
  }

  /**
    * VRFY command 
    *
    * @param  user user name
    * @return status 
    */
  public String vrfy (String user) {
    return sendCommand ("VRFY", user);
  }
  
  /**
    * EXPN command 
    *
    * @param ml mailing list address
    * @return status 
    */
  public String expn (String ml) {
    return sendCommand ("EXPN", ml);
  }

  /**
    * HELP command 
    *
    * @return status 
    */
  public String help () {
    sendCommand ("HELP");
    return recvMultilineResponse ();
  }

  /**
    * HELP command 
    *
    * @param str
    * @return status 
    */
  public String help (String str) {
    sendCommand ("HELP", str);
    return recvMultilineResponse ();
  }

  /**
    * NOOP command 
    *
    * @return status 
    */
  public String noop () {
    return sendCommand ("NOOP");
  }

  /**
    * QUIT command 
    *
    * @return status 
    */
  public String quit () {
    return sendCommand ("QUIT");
  }

  /**
    * TURN command 
    *
    * @return status 
    */
  public String turn () {
    return sendCommand ("turn");
  }

  /**
    * override
    *
    * @param data response data
    * @return if ok true, otherwise false
    */
  protected boolean isLastLine (String data) {
    if (data == null) return false;

    String status = data->substring (0, 3);
    String test_pattern = "\r\n"->concat (status)->concat (" ");

    return data->lastIndexOf (test_pattern) != -1;
  }

  /**
    * override
    *
    * check each line top of contents data 
    *
    * @param contents data
    * @return checked data
    */
  protected String encodeData (String data) {
    StringReader sr=>breed (data);
    BufferedReader lr=>breed (sr);
    StringBuffer buf=>breed ();
    System sys=>create ();

    while (true) {
      String line = lr->readLine ();
      if (line == null)
	break;

      if (line->charAt (0) == '.')
	buf->append ('.');

      buf->append (line);
      buf->append ("\r\n");
    }

    buf->append (".\r\n");

    return buf->asString ();
  }
}

/* EOF */
