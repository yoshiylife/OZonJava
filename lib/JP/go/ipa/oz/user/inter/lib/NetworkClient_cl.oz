/*
 * $Id: NetworkClient.oz,v 0.9 1998/01/30 02:19:18 otokawa Exp $
 */

/**
  * an abstract class implementing communication protocol
  */

abstract class NetworkClient {
  /*
   * version:

FTP.oz:
     FTP.oz,v 0.2 1997-11-27 10:34:27+09 otokawa Exp $

FTPClient.oz:
     FTPClient.oz,v 0.1 1997-11-26 11:38:45+09 otokawa Exp $

NNTP.oz:
     NNTP.oz,v 0.2 1997-12-05 14:20:44+09 otokawa Exp $

NetworkProtocol.oz:
     NetworkProtocol.oz,v 0.2 1997-11-27 10:34:29+09 otokawa Exp $

POP3.oz:
     POP3.oz,v 0.2 1997-12-05 14:20:49+09 otokawa Exp $

ProtocolRecord.oz:
     ProtocolRecord.oz,v 0.1 1997-11-26 11:38:55+09 otokawa Exp $

SMTP.oz:
     SMTP.oz,v 0.2 1997-12-05 14:20:51+09 otokawa Exp $

    */
  
  String version () { return "NetworkClient version 1.0"; }

  /**
    * connection 
    */
  protected Socket server;

  /**
    * protocol record
    */
  protected ProtocolRecord record;

  /**
    * response message
    */
  protected String response_message;

  /**
    * read timeout from server
    */
  int timeout;

  /**
    * default port
    */
  int default_port;

  /**
    * create new one
    *
    * @param send_format sending data format
    * @param recv_format receiving data format
    * @param lt line terminator string
    * @param port default port number
    */
  new create (String send_format, String recv_format, String lt, int port) {
    record=>create (send_format, recv_format, lt);
    default_port = port;
  }

  /**
    * create new one for testing
    */
  new create () {
    record=>create ("COMMAND PARAM", "STATUS MESSAGE", "\r\n");
  }

  /**
    * connect to server
    *
    * @param h server host name
    * @param p server port number
    */
  public String connect (String h, int p) {
    server=>breed (h, p);
    return readResponse ();
  }
  
  /**
    * connect to server
    *
    * @param host server host name
    */
  public String connect (String host) {
    return connect (host, default_port);
  }
  
  /**
    * send command data and recieve reposnse data
    *
    * @return status code
    */
  public String sendCommand () {
    String buf = record->encode ();

    OutputStreamWriter out=>breed (server->getOutputStream ());
    out->write (buf, 0, buf->length ());
    out->flush ();

    return readResponse ();
  }

  /**
    * send contents data and recieve reposnse data
    *
    * @param data contents data
    * @return status code
    */
  public String sendData (String data) {
    String buf = encodeData (data);
    OutputStreamWriter out=>breed (server->getOutputStream ());
    out->write (buf, 0, buf->length ());
    out->flush ();

    return readResponse ();
  }

  /**
    * access for response_message
    *
    * @return string
    */
  public String getResponse () { return response_message; }

  /**
    * read response 
    *
    * @return status
    */
  protected String readResponse () {
    String buf = read_response ();
    if (buf == null) 
      return null;

    response_message = buf;
    record->decode (response_message);

    return record->getStatus ();
  }

  /**
    * more read response for multiline one
    *
    * @return read data
    */
  protected String moreResponse () {
    String buf = read_response ();
    if (buf == null)
      return null;

    response_message = response_message->concat (buf);
    record->decode (response_message);

    return response_message;
  }

  /**
    * read response primitive
    *
    * @return read data
    */
  String read_response () {
    InputStream in = server->getInputStream ();
    ByteArray buf=>create (1024);

    if (timeout != 0)
      server->setSoTimeout (timeout);

    try {
      StringBuffer sbuf=>breed ();
      String line_terminator = record->getLineTerminator ();
      while (true) {
	int size = in->read (buf, 0, 1024);
	if (size <= 0) return "server error";

	String str=>breed (buf, 0, size);
	sbuf->append (str);

	if (str->indexOf (line_terminator) == -1)
	  continue;

	return sbuf->asString ();
      }
    } catch (IOException e) {
      
      return "server error";
    }
  }

  /**
    * set timeout value
    *
    * @param t timeout value
    */
  public void setTimeout (int t) { timeout = t; }

  /**
    * get timeout value
    *
    * @return timeout value
    */
  public int getTimeout () { return timeout; }

  /**
    * encoding sending data (no action)
    * must be override in inherited class
    *
    * @param data sending data
    * @return encoded data
    */
  protected String encodeData (String data) { return data; }
}

/* EOF */

