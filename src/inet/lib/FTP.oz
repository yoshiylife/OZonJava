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
 * $Id: FTP.oz,v 0.2 1997-11-27 10:34:27+09 otokawa Exp $
 */

/**
  * a class representing FTP protocol
  */

class FTP : *NetworkProtocol {
  /**
    * data connection
    */
  ServerSocket data_connection;

  /**
    * socket of data connection  
    */
  Socket data_socket;

  /**
    * received data
    */
  String received_data;

  /**
    * create new one
    */
  new create () {
    super=>create (21);
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
    sendCommand ("PASS", password);
    return recvMultilineResponse ();
  }

  /**
    * ACCT command
    *
    * @param username
    * @return status
    */
  public String acct (String username) {
    return sendCommand ("ACCT", username);
  }

  /**
    * CWD command 
    *
    * @param pathname
    * @return status 
    */
  public String cwd (String pathname) {
    return sendCommand ("CWD", pathname);
  }

  /**
    * CDUP command 
    *
    * @return status 
    */
  public String cdup () {
    return send_command_and_recv_data ("CDUP");
  }

  /**
    * SMNT command 
    *
    * @param pathname
    * @return status 
    */
  public String smnt (String pathname) {
    return sendCommand ("SMNT", pathname);
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
    * REIN command
    *
    * @return status
    */
  public String rein () {
    return sendCommand ("REIN");
  }

  /**
    * PORT command
    *
    * @param host_port
    * @return status
    */
  public String port (String host_port) {
    return sendCommand ("PORT", host_port);
  }

  /**
    * PASV command
    *
    * @return status
    */
  public String pasv () {
    return sendCommand ("PASV");
  }

  /**
    * TYPE command
    *
    * @param type_code 
    * @return status
    */
  public String type (String type_code) {
    return sendCommand ("TYPE", type_code);
  }

  /**
    * STRU command
    *
    * @param structure 
    * @return status
    */
  public String stru (String structure) {
    return sendCommand ("STRU", structure);
  }

  /**
    * MODE command
    *
    * @param mode_code
    * @return status
    */
  public String mode (String mode_code) {
    return sendCommand ("MODE", mode_code);
  }

  /**
    * RETR command
    *
    * @param pathname
    * @return status
    */
  public String retr (String pathname, OutputStream out) {
    return send_command_and_recv_data ("RETR", pathname, out);
  }

  /**
    * STOR command
    *
    * @param pathname
    * @param data
    * @return status
    */
  public String stor (String pathname, InputStream in) {
    return send_command_and_send_data ("STOR", pathname, in);
  }

  /**
    * STOU command
    *
    * @param data
    * @return status
    */
  public String stou (InputStream in) {
    return send_command_and_send_data ("STOU", in);
  }

  /**
    * APPE command
    *
    * @param pathname
    * @param data
    * @return status
    */
  public String appe (String pathname, InputStream in) {
    return send_command_and_send_data ("APPE", pathname, in);
  }

 /**
    * ALLO command
    *
    * @param integer size
    * @return status
    */
  public String allo (String integer) {
    return send_command_and_send_data ("ALLO", integer);
  }

 /**
    * REST command
    *
    * @param marker
    * @return status
    */
  public String rest (String marker) {
    return send_command_and_send_data ("REST", marker);
  }

  /**
    * RNFR command 
    *
    * @param pathname
    * @return status 
    */
  public String rnfr (String pathname) {
    return sendCommand ("RNFR", pathname);
  }

  /**
    * RNTO command 
    *
    * @param pathname
    * @return status 
    */
  public String rnto (String pathname) {
    return sendCommand ("RNTO", pathname);
  }

  /**
    * ABOR command
    *
    * @return status
    */
  public String abor () {
    return sendCommand ("ABOR");
  }

  /**
    * DELE command 
    *
    * @param pathname
    * @return status 
    */
  public String dele (String pathname) {
    return sendCommand ("DELE", pathname);
  }

  /**
    * RMD command 
    *
    * @param pathname
    * @return status 
    */
  public String rmd (String pathname) {
    return sendCommand ("RMD", pathname);
  }

  /**
    * MKD command 
    *
    * @param pathname
    * @return status 
    */
  public String mkd (String pathname) {
    return sendCommand ("MKD", pathname);
  }

  /**
    * PWD command
    *
    * @return status
    */
  public String pwd () {
    return sendCommand ("PWD");
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
    * @param pathname
    * @return status 
    */
  public String list (String pathname) {
    return send_command_and_recv_data ("LIST", pathname);
  }

  /**
    * NLST command 
    *
    * @return status 
    */
  public String nlst () {
    return nlst (null);
  }

  /**
    * NLST command 
    *
    * @param pathname
    * @return status 
    */
  public String nlst (String pathname) {
    return send_command_and_recv_data ("NLST", pathname);
  }

  /**
    * SITE command 
    *
    * @param str string 
    * @return status 
    */
  public String site (String str) {
    return send_command_and_recv_data ("SITE", str);
  }

  /**
    * SYST command
    *
    * @return status
    */
  public String syst () {
    return sendCommand ("SYST");
  }

  /**
    * STAT command 
    *
    * @return status 
    */
  public String stat () {
    return stat (null);
  }

  /**
    * STAT command 
    *
    * @param pathname
    * @return status 
    */
  public String stat (String pathname) {
    return send_command_and_recv_data ("STAT", pathname);
  }

  /**
    * HELP command 
    *
    * @return status 
    */
  public String help () {
    return help (null);
  }

  /**
    * HELP command 
    *
    * @param str
    * @return status 
    */
  public String help (String str) {
    return sendCommand ("HELP", str);
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
    * receive data
    *
    * @return status
    */
  String receive_data () {
    data_socket = data_connection->accept ();

    InputStream in = data_socket->getInputStream ();
    ByteArray buf=>create (1024);
    StringBuffer sbuf=>breed ();

    while (true) {
      int size = in->read (buf, 0, 1024);
      if (size == -1)
	break;
      String s=>breed (buf, 0, size);
      sbuf->append (s);
    }
    data_socket->close ();

    received_data = sbuf->asString ();
    return readResponse ();
  }

  /**
    * receive data
    *
    * @param out output stream
    * @return status
    */
  String receive_data (OutputStream out) {
    data_socket = data_connection->accept ();

    InputStream in = data_socket->getInputStream ();
    ByteArray buf=>create (1024);

    while (true) {
      int size = in->read (buf, 0, 1024);
      if (size == -1)
	break;
      out->write (buf, 0, size);
    }
    data_socket->close ();

    return readResponse ();
  }

  /**
    * send data
    *
    * @param in input sream for data
    * @return status
    */
  String send_data (InputStream in) {
    data_socket = data_connection->accept ();

    OutputStream out = data_socket->getOutputStream ();
    ByteArray buf=>create (1024);
    while (true) {
      int size = in->read (buf, 0, 1024);
      if (size == -1)
	break;
      out->write (buf, 0, size);
    }
    data_socket->close ();

    return readResponse ();
  }

  /**
    * send data
    *
    * @param data
    * @return status
    */
  String send_data (String data) {
    data_socket = data_connection->accept ();

    OutputStream out = data_socket->getOutputStream ();
    out->write (data->getBytes (), 0, data->length ());
    data_socket->close ();

    return readResponse ();
  }

  /**
    * access for received data
    */
  public String getData () { return received_data; }

  /**
    * check if status is ok
    *
    * @param status status code
    * @return if so true, otherwise false
    */
  protected boolean isOk (String status) { 
    char first = status->charAt (0);
    return first == '1' || first == '2' || first == '3';
  }

  /**
    * create data connection and listent on in
    */
  void open_data_connection () {
    try {
      if (data_connection != null)
	data_connection->close ();
      data_connection=>breed (0, 1);
    } catch (IOException e) {
      System sys=>create ();
      sys->println (e->getMessage ());
    }

    send_local_port ();
  }

  /**
    * send local port
    */
  void send_local_port () {
    int port = data_connection->getLocalPort ();
    String addr = data_connection->getInetAddress ()
      ->getLocalHost ()->getHostAddress ();
    StringBuffer buf=>breed ();
    buf->append (addr->replace ('.', ','));
    buf->append (',');
    buf->append (""->valueOf (port / 256));
    buf->append (',');
    buf->append (""->valueOf (port % 256));
    port (buf->asString ());
  }

  /**
    * set command and parameter, and send it and data
    *
    * @param command command string
    * @param param parameter string
    * @param data data contents string
    * @return status code
    */
  String send_command_and_send_data (String command, String param, 
				     String data) {
    open_data_connection ();
    String status = sendCommand (command, param);
    if (!isOk (status)) return status;
    return send_data (data);
  }

  /**
    * set command and parameter, and send it and data
    *
    * @param command command string
    * @param data data contents string
    * @return status code
    */
  String send_command_and_send_data (String command, String data) {
    return send_command_and_send_data (command, null, data);
  }

  /**
    * set command and parameter, and send it and data
    *
    * @param command command string
    * @param param parameter string
    * @param in input stream for data
    * @return status code
    */
  String send_command_and_send_data (String command, String param, 
				     InputStream in) {
    open_data_connection ();
    String status = sendCommand (command, param);
    if (!isOk (status)) return status;
    return send_data (in);
  }

  /**
    * set command and parameter, and send it and data
    *
    * @param command command string
    * @param in input stream for data
    * @return status code
    */
  String send_command_and_send_data (String command, InputStream in) {
    return send_command_and_send_data (command, null, in);
  }

  /**
    * set command and parameter, and send it and receive data
    *
    * @param command command string
    * @param param parameter string
    * @return status code
    */
  String send_command_and_recv_data (String command, String param) {
    open_data_connection ();
    String status = sendCommand (command, param);
    if (!isOk (status)) return status;
    return receive_data ();
  }

  /**
    * set command and parameter, and send it and receive data
    *
    * @param command command string
    * @param param parameter string
    * @param out output stream 
    * @return status code
    */
  String send_command_and_recv_data (String command, String param, 
				     OutputStream out) {
    open_data_connection ();
    String status = sendCommand (command, param);
    if (!isOk (status)) return status;
    return receive_data (out);
  }

  /**
    * set command and parameter, and send it and receive data
    *
    * @param command command string
    * @return status code
    */
  String send_command_and_recv_data (String command) {
    return send_command_and_recv_data (command, null);
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
    String test_pattern = status->concat (" ");

    if (data->indexOf (test_pattern) == 0)
      return true;

    return data->lastIndexOf ("\r\n"->concat (test_pattern)) != -1;
  }

  /**
    * get recieved data
    */
  public String getRecvData () { return received_data; }
}

/* EOF */
