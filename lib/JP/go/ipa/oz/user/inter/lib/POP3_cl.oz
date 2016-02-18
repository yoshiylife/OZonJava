/*
 * $Id: POP3.oz,v 0.2 1997-12-05 14:20:49+09 otokawa Exp $
 */

/**
  * a class representing POP3 protocol
  */

class POP3 : *NetworkProtocol {
  /**
    * create new one
    */
  new create () {
    super=>create (110);
    setTimeout (10000);
  }

  /**
    * USER command
    *
    * @param username
    * @return status
    */
  public String user (String username) {
    return sendCommand ("USER", username);
  }

  /**
    * PASS command
    *
    * @param password
    * @return status
    */
  public String pass (String password) {
    return sendCommand ("PASS", password);
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
    * STAT command
    *
    * @return status
    */
  public String stat () {
    return sendCommand ("STAT");
  }

  /**
    * LIST command 
    *
    * @return status 
    */
  public String list () {
    return list (null);
  }

  /**
    * LIST command 
    *
    * @param msg messsage number
    * @return status 
    */
  public String list (String msg) {
    sendCommand ("LIST", msg);
    return recvMultilineResponse ();
  }

  /**
    * RETR command 
    *
    * @param msg messsage number
    * @return status 
    */
  public String retr (String msg) {
    sendCommand ("RETR", msg);
    return recvMultilineResponse ();
  }

  /**
    * DELE command 
    *
    * @param msg messsage number
    * @return status 
    */
  public String dele (String msg) {
    return sendCommand ("DELE", msg);
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
    * NOOP command 
    *
    * @return status 
    */
  public String noop () {
    return sendCommand ("NOOP");
  }

  /**
    * APOP command 
    *
    * @param param name and digest string
    * @return status 
    */
  public String param (String param) {
    return sendCommand ("APOP", param);
  }

  /**
    * TOP command 
    *
    * @param msg messsage number and line nubmer
    * @return status 
    */
  public String top (String msg) {
    return sendCommand ("TOP", msg);
  }

  /**
    * UIDL command 
    *
    * @param msg messsage number
    * @return status 
    */
  public String uidl (String msg) {
    return sendCommand ("UIDL", msg);
  }

  /**
    * UIDL command 
    *
    * @return status 
    */
  public String uidl () {
    return sendCommand ("UIDL");
  }

  /**
    * override
    */
  protected boolean isLastLine (String data) {
    if (data == null) return false;
    int idx = data->lastIndexOf ("\r\n.\r\n");
    if (idx == -1) return false;
    return (idx + 5 == data->length ());
  }

  /**
    * override 
    */
  protected String decodeResponse (String data) {
    StringReader sr=>breed (data);
    BufferedReader lr=>breed (sr);
    StringBuffer buf=>breed ();
    System sys=>create ();

    while (true) {
      String line = lr->readLine ();
      if (line == null)
	break;

      if (line->startsWith (".\r\n") && line->charAt (0) == '.')
	buf->append (line->substring (1));
      else
	buf->append (line);
      buf->append ("\r\n");
    }

    return buf->asString ();
  }
}

/* EOF */
