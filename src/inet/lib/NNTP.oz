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
 * $Id: NNTP.oz,v 0.2 1997-12-05 14:20:44+09 otokawa Exp $
 */

/**
  * a class representing NNTP protocol
  */

class NNTP : *NetworkProtocol {
  /**
    * create new one
    */
  new create () {
    super=>create (119);
  }

  /**
    * ARTICLE command
    *
    * @param msg secified message
    * @return status
    */
  public String article (String msg) {
    String status = sendCommand ("ARTICLE", msg);
    if (!isOk (status) || status->isequal ("223"))
      return status;

    return recvMultilineResponse ();
  }

  /**
    * ARTICLE command (current message)
    *
    * @return status
    */
  public String article () {
    return article (null);
  }

  /**
    * BODY command
    *
    * @param msg secified message
    * @return status
    */
  public String body (String msg) {
    String status = sendCommand ("BODY", msg);
    if (!isOk (status) || status->isequal ("223"))
      return status;

    return recvMultilineResponse ();
  }

  /**
    * BODY command (current message)
    *
    * @return status
    */
  public String body () {
    return body (null);
  }

  /**
    * HEAD command
    *
    * @param msg secified message
    * @return status
    */
  public String head (String msg) {
    String status = sendCommand ("HEAD", msg);
    if (!isOk (status) || status->isequal ("223"))
      return status;

    return recvMultilineResponse ();
  }

  /**
    * HEAD command (current message)
    *
    * @return status
    */
  public String head() {
    return head (null);
  }

  /**
    * STAT command
    *
    * @param msg secified message
    * @return status
    */
  public String stat (String msg) {
    String status = sendCommand ("STAT", msg);
    if (!isOk (status) || status->isequal ("223"))
      return status;

    return recvMultilineResponse ();
  }

  /**
    * STAT command (current message)
    *
    * @return status
    */
  public String stat () {
    return stat (null);
  }

  /**
    * GROUP command
    *
    * @param group specified group
    * @return status
    */
  public String group (String group) {
    return sendCommand ("GROUP", group);
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
    * IHAVE command
    *
    * @param msg specified message
    * @param contents article contents
    * @return status
    */
  public String ihave (String msg, String contents) {
    String status = sendCommand ("IHAVE", msg);
    if (!isOk (status) || status->charAt (0) != '3')
      return status;

    return sendData (contents);
  }

  /**
    * LAST command
    *
    * @return status
    */
  public String last () {
    return sendCommand ("LAST");
  }

  /**
    * LIST command
    *
    * @return status
    */
  public String list () {
    sendCommand ("LIST");
    return recvMultilineResponse ();
  }

  /**
    * NEWGROUPS command
    *
    * @param param date, time, "GMT" (opt.) and distributinos (opt.)
    * @return status
    */
  public String newgroups (String param) {
    sendCommand ("NEWGROUPS", param);
    return recvMultilineResponse ();
  }

  /**
    * NEWNEWS command
    *
    * @param param date, time, "GMT" (opt.) and distributinos (opt.)
    * @return status
    */
  public String newnews (String param) {
    sendCommand ("NEWNEWS", param);
    return recvMultilineResponse ();
  }

  /**
    * NEXT command
    *
    * @return status
    */
  public String next () {
    return sendCommand ("NEXT");
  }

  /**
    * POST command
    *
    * @param contents article contents
    * @return status
    */
  public String post (String contents) {
    String status = sendCommand ("POST");

    if (!isOk (status) || status->charAt (0) != '3')
      return status;

    return sendData (contents);
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
    * SLAVE command
    *
    * @return status
    */
  public String slave () {
    return sendCommand ("SLAVE");
  }

  /**
    * override
    *
    * @param data response data
    * @return if ok (last line is '.') true, otherwise false
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

  /**
    * check if status is ok
    *
    * @param status status code
    * @return if so true, otherwise false
    */
  boolean isOk (String status) { 
    char c = status->charAt (0);
    return c == '2' || c == '3';
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

    while (true) {
      String line = lr->readLine ();
      if (line == null)
	break;

      if (line->length () > 0) {
	if (line->charAt (0) == '.')
	  buf->append ('.');

	buf->append (line);
      }
      buf->append ("\r\n");
    }

    buf->append (".\r\n");

    return buf->asString ();
  }
}

/* EOF */
