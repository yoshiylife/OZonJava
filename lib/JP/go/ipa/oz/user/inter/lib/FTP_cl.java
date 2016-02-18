package JP.go.ipa.oz.user.inter.lib;

public class FTP_cl extends JP.go.ipa.oz.user.inter.lib.NetworkProtocol_cl implements JP.go.ipa.oz.user.inter.lib.FTP_if {
  JP.go.ipa.oz.lib.standard._ServerSocket_if data_connection;
  JP.go.ipa.oz.lib.standard._Socket_if data_socket;
  JP.go.ipa.oz.lib.standard._String_if received_data;
  
  public Object _new_create () throws Exception  {
// 29
    super._new_create (21);
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if stor (JP.go.ipa.oz.lib.standard._String_if pathname, JP.go.ipa.oz.lib.standard._InputStream_if in) throws Exception  {
    checkSecureInvocation ();
// 177
    return send_command_and_send_data ((new JP.go.ipa.oz.lib.standard._String_cl("STOR")), pathname, in);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if port (JP.go.ipa.oz.lib.standard._String_if host_port) throws Exception  {
    checkSecureInvocation ();
// 117
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("PORT")), host_port);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if site (JP.go.ipa.oz.lib.standard._String_if str) throws Exception  {
    checkSecureInvocation ();
// 334
    return send_command_and_recv_data ((new JP.go.ipa.oz.lib.standard._String_cl("SITE")), str);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if retr (JP.go.ipa.oz.lib.standard._String_if pathname, JP.go.ipa.oz.lib.standard._OutputStream_if out) throws Exception  {
    checkSecureInvocation ();
// 166
    return send_command_and_recv_data ((new JP.go.ipa.oz.lib.standard._String_cl("RETR")), pathname, out);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if mkd (JP.go.ipa.oz.lib.standard._String_if pathname) throws Exception  {
    checkSecureInvocation ();
// 277
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("MKD")), pathname);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if allo (JP.go.ipa.oz.lib.standard._String_if integer) throws Exception  {
    checkSecureInvocation ();
// 208
    return send_command_and_send_data ((new JP.go.ipa.oz.lib.standard._String_cl("ALLO")), integer);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if abor () throws Exception  {
    checkSecureInvocation ();
// 247
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("ABOR")));
  }
  
  public JP.go.ipa.oz.lib.standard._String_if quit () throws Exception  {
    checkSecureInvocation ();
// 98
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("QUIT")));
  }
  
  public JP.go.ipa.oz.lib.standard._String_if nlst (JP.go.ipa.oz.lib.standard._String_if pathname) throws Exception  {
    checkSecureInvocation ();
// 324
    return send_command_and_recv_data ((new JP.go.ipa.oz.lib.standard._String_cl("NLST")), pathname);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if nlst () throws Exception  {
    checkSecureInvocation ();
// 314
    return nlst (null);
  }
  
  protected boolean isLastLine (JP.go.ipa.oz.lib.standard._String_if data) throws Exception  {
// 628
    if (data == null) {
// 628
      return false;
    }
// 630
    JP.go.ipa.oz.lib.standard._String_if substring$val$0;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) data)) {
      try {
        substring$val$0 = data.substring (0, 3);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      substring$val$0 = data.substring (0, 3);
    }
// 630
    JP.go.ipa.oz.lib.standard._String_if status = substring$val$0;
// 631
    JP.go.ipa.oz.lib.standard._String_if string$0 = (new JP.go.ipa.oz.lib.standard._String_cl(" "));
    
// 631
    JP.go.ipa.oz.lib.standard._String_if concat$val$1;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) status)) {
      try {
        concat$val$1 = status.concat (string$0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$1 = status.concat (string$0);
    }
// 631
    JP.go.ipa.oz.lib.standard._String_if test_pattern = concat$val$1;
// 633
    int indexOf$val$2;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) data)) {
      try {
        indexOf$val$2 = data.indexOf (test_pattern);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      indexOf$val$2 = data.indexOf (test_pattern);
    }
// 633
    if (indexOf$val$2 == 0) {
// 636
      return true;
    }
// 636
    JP.go.ipa.oz.lib.standard._String_if string$1 = (new JP.go.ipa.oz.lib.standard._String_cl("\r\n"));
    
// 636
    JP.go.ipa.oz.lib.standard._String_if concat$val$3;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$1)) {
      try {
        concat$val$3 = string$1.concat (test_pattern);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$3 = string$1.concat (test_pattern);
    }
// 636
    int lastIndexOf$val$4;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) data)) {
      try {
        lastIndexOf$val$4 = data.lastIndexOf (concat$val$3);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lastIndexOf$val$4 = data.lastIndexOf (concat$val$3);
    }
// 636
    return lastIndexOf$val$4 != -1;
  }
  
  JP.go.ipa.oz.lib.standard._String_if send_command_and_recv_data (JP.go.ipa.oz.lib.standard._String_if command) throws Exception  {
// 618
    return send_command_and_recv_data (command, null);
  }
  
  JP.go.ipa.oz.lib.standard._String_if send_command_and_recv_data (JP.go.ipa.oz.lib.standard._String_if command, JP.go.ipa.oz.lib.standard._String_if param, JP.go.ipa.oz.lib.standard._OutputStream_if out) throws Exception  {
// 605
    open_data_connection ();
// 606
    JP.go.ipa.oz.lib.standard._String_if status = sendCommand (command, param);
// 607
    if (!isOk (status)) {
// 608
      return status;
    }
// 608
    return receive_data (out);
  }
  
  JP.go.ipa.oz.lib.standard._String_if send_command_and_recv_data (JP.go.ipa.oz.lib.standard._String_if command, JP.go.ipa.oz.lib.standard._String_if param) throws Exception  {
// 589
    open_data_connection ();
// 590
    JP.go.ipa.oz.lib.standard._String_if status = sendCommand (command, param);
// 591
    if (!isOk (status)) {
// 592
      return status;
    }
// 592
    return receive_data ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if send_command_and_send_data (JP.go.ipa.oz.lib.standard._String_if command, JP.go.ipa.oz.lib.standard._InputStream_if in) throws Exception  {
// 578
    return send_command_and_send_data (command, null, in);
  }
  
  JP.go.ipa.oz.lib.standard._String_if send_command_and_send_data (JP.go.ipa.oz.lib.standard._String_if command, JP.go.ipa.oz.lib.standard._String_if param, JP.go.ipa.oz.lib.standard._InputStream_if in) throws Exception  {
// 564
    open_data_connection ();
// 565
    JP.go.ipa.oz.lib.standard._String_if status = sendCommand (command, param);
// 566
    if (!isOk (status)) {
// 567
      return status;
    }
// 567
    return send_data (in);
  }
  
  JP.go.ipa.oz.lib.standard._String_if send_command_and_send_data (JP.go.ipa.oz.lib.standard._String_if command, JP.go.ipa.oz.lib.standard._String_if data) throws Exception  {
// 551
    return send_command_and_send_data (command, null, data);
  }
  
  JP.go.ipa.oz.lib.standard._String_if send_command_and_send_data (JP.go.ipa.oz.lib.standard._String_if command, JP.go.ipa.oz.lib.standard._String_if param, JP.go.ipa.oz.lib.standard._String_if data) throws Exception  {
// 537
    open_data_connection ();
// 538
    JP.go.ipa.oz.lib.standard._String_if status = sendCommand (command, param);
// 539
    if (!isOk (status)) {
// 540
      return status;
    }
// 540
    return send_data (data);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if cwd (JP.go.ipa.oz.lib.standard._String_if pathname) throws Exception  {
    checkSecureInvocation ();
// 70
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("CWD")), pathname);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if rnfr (JP.go.ipa.oz.lib.standard._String_if pathname) throws Exception  {
    checkSecureInvocation ();
// 228
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("RNFR")), pathname);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getData () throws Exception  {
    checkSecureInvocation ();
// 482
    return received_data;
  }
  
  JP.go.ipa.oz.lib.standard._String_if receive_data (JP.go.ipa.oz.lib.standard._OutputStream_if out) throws Exception  {
// 425
    JP.go.ipa.oz.lib.standard._Socket_if accept$val$5;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) data_connection)) {
      try {
        accept$val$5 = data_connection.accept ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      accept$val$5 = data_connection.accept ();
    }
// 425
    data_socket = accept$val$5;
// 427
    JP.go.ipa.oz.lib.standard._InputStream_if getInputStream$val$6;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) data_socket)) {
      try {
        getInputStream$val$6 = data_socket.getInputStream ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getInputStream$val$6 = data_socket.getInputStream ();
    }
// 427
    JP.go.ipa.oz.lib.standard._InputStream_if in = getInputStream$val$6;
// 428
    JP.go.ipa.oz.lib.standard._ByteArray_if buf = (JP.go.ipa.oz.lib.standard._ByteArray_cl) (new JP.go.ipa.oz.lib.standard._ByteArray_cl ())._new_create (1024);
// 430
    while (true) {
      /* body */ _loop_1: {
// 431
        int read$val$7;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) in)) {
          try {
            read$val$7 = in.read (buf, 0, 1024);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          read$val$7 = in.read (buf, 0, 1024);
        }
// 431
        int size = read$val$7;
// 432
        if (size == -1) {
// 433
          break;
        }
// 434
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) out)) {
          try {
            out.write (buf, 0, size);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          out.write (buf, 0, size);
        }
      }
    }
// 436
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) data_socket)) {
      try {
        data_socket.close ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      data_socket.close ();
    }
// 438
    return readResponse ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if receive_data () throws Exception  {
// 399
    JP.go.ipa.oz.lib.standard._Socket_if accept$val$8;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) data_connection)) {
      try {
        accept$val$8 = data_connection.accept ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      accept$val$8 = data_connection.accept ();
    }
// 399
    data_socket = accept$val$8;
// 401
    JP.go.ipa.oz.lib.standard._InputStream_if getInputStream$val$9;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) data_socket)) {
      try {
        getInputStream$val$9 = data_socket.getInputStream ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getInputStream$val$9 = data_socket.getInputStream ();
    }
// 401
    JP.go.ipa.oz.lib.standard._InputStream_if in = getInputStream$val$9;
// 402
    JP.go.ipa.oz.lib.standard._ByteArray_if buf = (JP.go.ipa.oz.lib.standard._ByteArray_cl) (new JP.go.ipa.oz.lib.standard._ByteArray_cl ())._new_create (1024);
// 403
    JP.go.ipa.oz.lib.standard._StringBuffer_if sbuf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 405
    while (true) {
      /* body */ _loop_1: {
// 406
        int read$val$10;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) in)) {
          try {
            read$val$10 = in.read (buf, 0, 1024);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          read$val$10 = in.read (buf, 0, 1024);
        }
// 406
        int size = read$val$10;
// 407
        if (size == -1) {
// 408
          break;
        }
// 409
        JP.go.ipa.oz.lib.standard._String_if s = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed (buf, 0, size);
// 410
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$11;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbuf)) {
          try {
            append$val$11 = sbuf.append (s);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$11 = sbuf.append (s);
        }
      }
    }
// 412
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) data_socket)) {
      try {
        data_socket.close ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      data_socket.close ();
    }
// 414
    JP.go.ipa.oz.lib.standard._String_if asString$val$12;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbuf)) {
      try {
        asString$val$12 = sbuf.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$12 = sbuf.asString ();
    }
// 414
    received_data = asString$val$12;
// 415
    return readResponse ();
  }
  
  public JP.go.ipa.oz.lib.standard._String_if acct (JP.go.ipa.oz.lib.standard._String_if username) throws Exception  {
    checkSecureInvocation ();
// 60
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("ACCT")), username);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if rest (JP.go.ipa.oz.lib.standard._String_if marker) throws Exception  {
    checkSecureInvocation ();
// 218
    return send_command_and_send_data ((new JP.go.ipa.oz.lib.standard._String_cl("REST")), marker);
  }
  
  JP.go.ipa.oz.lib.standard._String_if send_data (JP.go.ipa.oz.lib.standard._String_if data) throws Exception  {
// 470
    JP.go.ipa.oz.lib.standard._Socket_if accept$val$13;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) data_connection)) {
      try {
        accept$val$13 = data_connection.accept ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      accept$val$13 = data_connection.accept ();
    }
// 470
    data_socket = accept$val$13;
// 472
    JP.go.ipa.oz.lib.standard._OutputStream_if getOutputStream$val$14;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) data_socket)) {
      try {
        getOutputStream$val$14 = data_socket.getOutputStream ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOutputStream$val$14 = data_socket.getOutputStream ();
    }
// 472
    JP.go.ipa.oz.lib.standard._OutputStream_if out = getOutputStream$val$14;
// 473
    JP.go.ipa.oz.lib.standard._ByteArray_if getBytes$val$15;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) data)) {
      try {
        getBytes$val$15 = data.getBytes ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBytes$val$15 = data.getBytes ();
    }
// 473
    int length$val$16;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) data)) {
      try {
        length$val$16 = data.length ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      length$val$16 = data.length ();
    }
// 473
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) out)) {
      try {
        out.write (getBytes$val$15, 0, length$val$16);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      out.write (getBytes$val$15, 0, length$val$16);
    }
// 474
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) data_socket)) {
      try {
        data_socket.close ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      data_socket.close ();
    }
// 476
    return readResponse ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if send_data (JP.go.ipa.oz.lib.standard._InputStream_if in) throws Exception  {
// 448
    JP.go.ipa.oz.lib.standard._Socket_if accept$val$17;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) data_connection)) {
      try {
        accept$val$17 = data_connection.accept ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      accept$val$17 = data_connection.accept ();
    }
// 448
    data_socket = accept$val$17;
// 450
    JP.go.ipa.oz.lib.standard._OutputStream_if getOutputStream$val$18;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) data_socket)) {
      try {
        getOutputStream$val$18 = data_socket.getOutputStream ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOutputStream$val$18 = data_socket.getOutputStream ();
    }
// 450
    JP.go.ipa.oz.lib.standard._OutputStream_if out = getOutputStream$val$18;
// 451
    JP.go.ipa.oz.lib.standard._ByteArray_if buf = (JP.go.ipa.oz.lib.standard._ByteArray_cl) (new JP.go.ipa.oz.lib.standard._ByteArray_cl ())._new_create (1024);
// 452
    while (true) {
      /* body */ _loop_1: {
// 453
        int read$val$19;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) in)) {
          try {
            read$val$19 = in.read (buf, 0, 1024);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          read$val$19 = in.read (buf, 0, 1024);
        }
// 453
        int size = read$val$19;
// 454
        if (size == -1) {
// 455
          break;
        }
// 456
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) out)) {
          try {
            out.write (buf, 0, size);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          out.write (buf, 0, size);
        }
      }
    }
// 458
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) data_socket)) {
      try {
        data_socket.close ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      data_socket.close ();
    }
// 460
    return readResponse ();
  }
  
  public JP.go.ipa.oz.lib.standard._String_if rnto (JP.go.ipa.oz.lib.standard._String_if pathname) throws Exception  {
    checkSecureInvocation ();
// 238
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("RNTO")), pathname);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if user (JP.go.ipa.oz.lib.standard._String_if username) throws Exception  {
    checkSecureInvocation ();
// 39
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("USER")), username);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if smnt (JP.go.ipa.oz.lib.standard._String_if pathname) throws Exception  {
    checkSecureInvocation ();
// 89
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("SMNT")), pathname);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if appe (JP.go.ipa.oz.lib.standard._String_if pathname, JP.go.ipa.oz.lib.standard._InputStream_if in) throws Exception  {
    checkSecureInvocation ();
// 198
    return send_command_and_send_data ((new JP.go.ipa.oz.lib.standard._String_cl("APPE")), pathname, in);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if syst () throws Exception  {
    checkSecureInvocation ();
// 343
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("SYST")));
  }
  
  public JP.go.ipa.oz.lib.standard._String_if rmd (JP.go.ipa.oz.lib.standard._String_if pathname) throws Exception  {
    checkSecureInvocation ();
// 267
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("RMD")), pathname);
  }
  
  protected boolean isOk (JP.go.ipa.oz.lib.standard._String_if status) throws Exception  {
// 491
    char charAt$val$20;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) status)) {
      try {
        charAt$val$20 = status.charAt (0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      charAt$val$20 = status.charAt (0);
    }
// 491
    char first = charAt$val$20;
    boolean bool$val$0;
    
    boolean bool$val$1;
    
    bool$val$1 = first == '1';
    if (!bool$val$1) {
      bool$val$1 = first == '2';
    }
    bool$val$0 = bool$val$1;
    if (!bool$val$0) {
      bool$val$0 = first == '3';
    }
// 492
    return bool$val$0;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if stru (JP.go.ipa.oz.lib.standard._String_if structure) throws Exception  {
    checkSecureInvocation ();
// 146
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("STRU")), structure);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if dele (JP.go.ipa.oz.lib.standard._String_if pathname) throws Exception  {
    checkSecureInvocation ();
// 257
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("DELE")), pathname);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if help (JP.go.ipa.oz.lib.standard._String_if str) throws Exception  {
    checkSecureInvocation ();
// 381
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("HELP")), str);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if help () throws Exception  {
    checkSecureInvocation ();
// 371
    return help (null);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if cdup () throws Exception  {
    checkSecureInvocation ();
// 79
    return send_command_and_recv_data ((new JP.go.ipa.oz.lib.standard._String_cl("CDUP")));
  }
  
  public JP.go.ipa.oz.lib.standard._String_if noop () throws Exception  {
    checkSecureInvocation ();
// 390
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("NOOP")));
  }
  
  void open_data_connection () throws Exception  {
// 499
    try {
// 500
      if (data_connection != null) {
// 501
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) data_connection)) {
          try {
            data_connection.close ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          data_connection.close ();
        }
      }
// 502
      data_connection = (JP.go.ipa.oz.lib.standard._ServerSocket_cl) (new JP.go.ipa.oz.lib.standard._ServerSocket_cl ())._new_breed (0, 1);
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_1) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_1 = _exception_1.getOzException ();
      if (_oz_exception_1 instanceof JP.go.ipa.oz.lib.standard._IOException_if) {
        JP.go.ipa.oz.lib.standard._IOException_if e = (JP.go.ipa.oz.lib.standard._IOException_if) _oz_exception_1;
// 504
        JP.go.ipa.oz.lib.standard._System_if sys = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 505
        JP.go.ipa.oz.lib.standard._String_if getMessage$val$21;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) e)) {
          try {
            getMessage$val$21 = e.getMessage ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getMessage$val$21 = e.getMessage ();
        }
// 505
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
          try {
            sys.println (getMessage$val$21);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          sys.println (getMessage$val$21);
        }
      } else throw _exception_1;
    }
// 508
    send_local_port ();
  }
  
  public JP.go.ipa.oz.lib.standard._String_if pwd () throws Exception  {
    checkSecureInvocation ();
// 286
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("PWD")));
  }
  
  public JP.go.ipa.oz.lib.standard._String_if mode (JP.go.ipa.oz.lib.standard._String_if mode_code) throws Exception  {
    checkSecureInvocation ();
// 156
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("MODE")), mode_code);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if type (JP.go.ipa.oz.lib.standard._String_if type_code) throws Exception  {
    checkSecureInvocation ();
// 136
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("TYPE")), type_code);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if rein () throws Exception  {
    checkSecureInvocation ();
// 107
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("REIN")));
  }
  
  public JP.go.ipa.oz.lib.standard._String_if pasv () throws Exception  {
    checkSecureInvocation ();
// 126
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("PASV")));
  }
  
  public JP.go.ipa.oz.lib.standard._String_if list (JP.go.ipa.oz.lib.standard._String_if pathname) throws Exception  {
    checkSecureInvocation ();
// 305
    return send_command_and_recv_data ((new JP.go.ipa.oz.lib.standard._String_cl("LIST")), pathname);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if list () throws Exception  {
    checkSecureInvocation ();
// 295
    return list (null);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getRecvData () throws Exception  {
    checkSecureInvocation ();
// 642
    return received_data;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if pass (JP.go.ipa.oz.lib.standard._String_if password) throws Exception  {
    checkSecureInvocation ();
// 49
    sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("PASS")), password);
// 50
    return recvMultilineResponse ();
  }
  
  void send_local_port () throws Exception  {
// 515
    int getLocalPort$val$22;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) data_connection)) {
      try {
        getLocalPort$val$22 = data_connection.getLocalPort ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getLocalPort$val$22 = data_connection.getLocalPort ();
    }
// 515
    int port = getLocalPort$val$22;
// 516
    JP.go.ipa.oz.lib.standard._InetAddress_if getInetAddress$val$23;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) data_connection)) {
      try {
        getInetAddress$val$23 = data_connection.getInetAddress ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getInetAddress$val$23 = data_connection.getInetAddress ();
    }
// 516
    JP.go.ipa.oz.lib.standard._InetAddress_if getLocalHost$val$24;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getInetAddress$val$23)) {
      try {
        getLocalHost$val$24 = getInetAddress$val$23.getLocalHost ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getLocalHost$val$24 = getInetAddress$val$23.getLocalHost ();
    }
// 516
    JP.go.ipa.oz.lib.standard._String_if getHostAddress$val$25;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getLocalHost$val$24)) {
      try {
        getHostAddress$val$25 = getLocalHost$val$24.getHostAddress ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHostAddress$val$25 = getLocalHost$val$24.getHostAddress ();
    }
// 516
    JP.go.ipa.oz.lib.standard._String_if addr = getHostAddress$val$25;
// 518
    JP.go.ipa.oz.lib.standard._StringBuffer_if buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 519
    JP.go.ipa.oz.lib.standard._String_if replace$val$26;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) addr)) {
      try {
        replace$val$26 = addr.replace ('.', ',');
      } finally {
        changeRunningToGreen ();
      }
    } else {
      replace$val$26 = addr.replace ('.', ',');
    }
// 519
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$27;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        append$val$27 = buf.append (replace$val$26);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$27 = buf.append (replace$val$26);
    }
// 520
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$28;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        append$val$28 = buf.append (',');
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$28 = buf.append (',');
    }
// 521
    JP.go.ipa.oz.lib.standard._String_if string$2 = (new JP.go.ipa.oz.lib.standard._String_cl(""));
    
// 521
    JP.go.ipa.oz.lib.standard._String_if valueOf$val$29;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$2)) {
      try {
        valueOf$val$29 = string$2.valueOf (port / 256);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      valueOf$val$29 = string$2.valueOf (port / 256);
    }
// 521
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$30;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        append$val$30 = buf.append (valueOf$val$29);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$30 = buf.append (valueOf$val$29);
    }
// 522
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$31;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        append$val$31 = buf.append (',');
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$31 = buf.append (',');
    }
// 523
    JP.go.ipa.oz.lib.standard._String_if string$3 = (new JP.go.ipa.oz.lib.standard._String_cl(""));
    
// 523
    JP.go.ipa.oz.lib.standard._String_if valueOf$val$32;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$3)) {
      try {
        valueOf$val$32 = string$3.valueOf (port % 256);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      valueOf$val$32 = string$3.valueOf (port % 256);
    }
// 523
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$33;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        append$val$33 = buf.append (valueOf$val$32);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$33 = buf.append (valueOf$val$32);
    }
// 524
    JP.go.ipa.oz.lib.standard._String_if asString$val$34;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        asString$val$34 = buf.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$34 = buf.asString ();
    }
// 524
    port (asString$val$34);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if stat (JP.go.ipa.oz.lib.standard._String_if pathname) throws Exception  {
    checkSecureInvocation ();
// 362
    return send_command_and_recv_data ((new JP.go.ipa.oz.lib.standard._String_cl("STAT")), pathname);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if stat () throws Exception  {
    checkSecureInvocation ();
// 352
    return stat (null);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if stou (JP.go.ipa.oz.lib.standard._InputStream_if in) throws Exception  {
    checkSecureInvocation ();
// 187
    return send_command_and_send_data ((new JP.go.ipa.oz.lib.standard._String_cl("STOU")), in);
  }
  
  public FTP_cl () throws Exception { super (); }
  
}

