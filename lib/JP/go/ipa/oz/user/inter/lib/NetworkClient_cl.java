package JP.go.ipa.oz.user.inter.lib;

abstract public class NetworkClient_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.inter.lib.NetworkClient_if {
  int timeout;
  protected JP.go.ipa.oz.user.inter.lib.ProtocolRecord_if record;
  protected JP.go.ipa.oz.lib.standard._Socket_if server;
  protected JP.go.ipa.oz.lib.standard._String_if response_message;
  int default_port;
  
  public Object _new_create () throws Exception  {
// 80
    record = (JP.go.ipa.oz.user.inter.lib.ProtocolRecord_cl) (new JP.go.ipa.oz.user.inter.lib.ProtocolRecord_cl ())._new_create ((new JP.go.ipa.oz.lib.standard._String_cl("COMMAND PARAM")), (new JP.go.ipa.oz.lib.standard._String_cl("STATUS MESSAGE")), (new JP.go.ipa.oz.lib.standard._String_cl("\r\n")));
    return this;
  }
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._String_if send_format, JP.go.ipa.oz.lib.standard._String_if recv_format, JP.go.ipa.oz.lib.standard._String_if lt, int port) throws Exception  {
// 72
    record = (JP.go.ipa.oz.user.inter.lib.ProtocolRecord_cl) (new JP.go.ipa.oz.user.inter.lib.ProtocolRecord_cl ())._new_create (send_format, recv_format, lt);
// 73
    default_port = port;
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if sendCommand () throws Exception  {
    checkSecureInvocation ();
// 109
    JP.go.ipa.oz.lib.standard._String_if encode$val$94;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) record)) {
      try {
        encode$val$94 = record.encode ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      encode$val$94 = record.encode ();
    }
// 109
    JP.go.ipa.oz.lib.standard._String_if buf = encode$val$94;
// 111
    JP.go.ipa.oz.lib.standard._OutputStream_if getOutputStream$val$95;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) server)) {
      try {
        getOutputStream$val$95 = server.getOutputStream ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOutputStream$val$95 = server.getOutputStream ();
    }
// 111
    JP.go.ipa.oz.lib.standard._OutputStreamWriter_if out = (JP.go.ipa.oz.lib.standard._OutputStreamWriter_cl) (new JP.go.ipa.oz.lib.standard._OutputStreamWriter_cl ())._new_breed (getOutputStream$val$95);
// 112
    int length$val$96;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        length$val$96 = buf.length ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      length$val$96 = buf.length ();
    }
// 112
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) out)) {
      try {
        out.write (buf, 0, length$val$96);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      out.write (buf, 0, length$val$96);
    }
// 113
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) out)) {
      try {
        out.flush ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      out.flush ();
    }
// 115
    return readResponse ();
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getResponse () throws Exception  {
    checkSecureInvocation ();
// 138
    return response_message;
  }
  
  JP.go.ipa.oz.lib.standard._String_if read_response () throws Exception  {
// 178
    JP.go.ipa.oz.lib.standard._InputStream_if getInputStream$val$97;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) server)) {
      try {
        getInputStream$val$97 = server.getInputStream ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getInputStream$val$97 = server.getInputStream ();
    }
// 178
    JP.go.ipa.oz.lib.standard._InputStream_if in = getInputStream$val$97;
// 179
    JP.go.ipa.oz.lib.standard._ByteArray_if buf = (JP.go.ipa.oz.lib.standard._ByteArray_cl) (new JP.go.ipa.oz.lib.standard._ByteArray_cl ())._new_create (1024);
// 181
    if (timeout != 0) {
// 182
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) server)) {
        try {
          server.setSoTimeout (timeout);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        server.setSoTimeout (timeout);
      }
    }
// 184
    try {
// 185
      JP.go.ipa.oz.lib.standard._StringBuffer_if sbuf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 186
      JP.go.ipa.oz.lib.standard._String_if getLineTerminator$val$98;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) record)) {
        try {
          getLineTerminator$val$98 = record.getLineTerminator ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getLineTerminator$val$98 = record.getLineTerminator ();
      }
// 186
      JP.go.ipa.oz.lib.standard._String_if line_terminator = getLineTerminator$val$98;
// 187
      while (true) {
        /* body */ _loop_1: {
// 188
          int read$val$99;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) in)) {
            try {
              read$val$99 = in.read (buf, 0, 1024);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            read$val$99 = in.read (buf, 0, 1024);
          }
// 188
          int size = read$val$99;
// 189
          if (size <= 0) {
// 189
            return (new JP.go.ipa.oz.lib.standard._String_cl("server error"));
          }
// 191
          JP.go.ipa.oz.lib.standard._String_if str = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed (buf, 0, size);
// 192
          JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$100;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbuf)) {
            try {
              append$val$100 = sbuf.append (str);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            append$val$100 = sbuf.append (str);
          }
// 194
          int indexOf$val$101;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) str)) {
            try {
              indexOf$val$101 = str.indexOf (line_terminator);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            indexOf$val$101 = str.indexOf (line_terminator);
          }
// 194
          if (indexOf$val$101 == -1) {
// 195
            break _loop_1;
          }
// 197
          JP.go.ipa.oz.lib.standard._String_if asString$val$102;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbuf)) {
            try {
              asString$val$102 = sbuf.asString ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            asString$val$102 = sbuf.asString ();
          }
// 197
          return asString$val$102;
        }
      }
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_1) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_1 = _exception_1.getOzException ();
      if (_oz_exception_1 instanceof JP.go.ipa.oz.lib.standard._IOException_if) {
        JP.go.ipa.oz.lib.standard._IOException_if e = (JP.go.ipa.oz.lib.standard._IOException_if) _oz_exception_1;
// 201
        return (new JP.go.ipa.oz.lib.standard._String_cl("server error"));
      } else throw _exception_1;
    }
  }
  
  protected JP.go.ipa.oz.lib.standard._String_if moreResponse () throws Exception  {
// 162
    JP.go.ipa.oz.lib.standard._String_if buf = read_response ();
// 163
    if (buf == null) {
// 164
      return null;
    }
// 166
    JP.go.ipa.oz.lib.standard._String_if concat$val$103;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) response_message)) {
      try {
        concat$val$103 = response_message.concat (buf);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$103 = response_message.concat (buf);
    }
// 166
    response_message = concat$val$103;
// 167
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) record)) {
      try {
        record.decode (response_message);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      record.decode (response_message);
    }
// 169
    return response_message;
  }
  
  public int getTimeout () throws Exception  {
    checkSecureInvocation ();
// 217
    return timeout;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if connect (JP.go.ipa.oz.lib.standard._String_if host) throws Exception  {
    checkSecureInvocation ();
// 100
    return connect (host, default_port);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if connect (JP.go.ipa.oz.lib.standard._String_if h, int p) throws Exception  {
    checkSecureInvocation ();
// 90
    server = (JP.go.ipa.oz.lib.standard._Socket_cl) (new JP.go.ipa.oz.lib.standard._Socket_cl ())._new_breed (h, p);
// 91
    return readResponse ();
  }
  
  public void setTimeout (int t) throws Exception  {
    checkSecureInvocation ();
// 210
    timeout = t;
  }
  
  protected JP.go.ipa.oz.lib.standard._String_if encodeData (JP.go.ipa.oz.lib.standard._String_if data) throws Exception  {
// 226
    return data;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if sendData (JP.go.ipa.oz.lib.standard._String_if data) throws Exception  {
    checkSecureInvocation ();
// 125
    JP.go.ipa.oz.lib.standard._String_if buf = encodeData (data);
// 126
    JP.go.ipa.oz.lib.standard._OutputStream_if getOutputStream$val$104;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) server)) {
      try {
        getOutputStream$val$104 = server.getOutputStream ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOutputStream$val$104 = server.getOutputStream ();
    }
// 126
    JP.go.ipa.oz.lib.standard._OutputStreamWriter_if out = (JP.go.ipa.oz.lib.standard._OutputStreamWriter_cl) (new JP.go.ipa.oz.lib.standard._OutputStreamWriter_cl ())._new_breed (getOutputStream$val$104);
// 127
    int length$val$105;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        length$val$105 = buf.length ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      length$val$105 = buf.length ();
    }
// 127
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) out)) {
      try {
        out.write (buf, 0, length$val$105);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      out.write (buf, 0, length$val$105);
    }
// 128
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) out)) {
      try {
        out.flush ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      out.flush ();
    }
// 130
    return readResponse ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if version () throws Exception  {
// 36
    return (new JP.go.ipa.oz.lib.standard._String_cl("NetworkClient version 1.0"));
  }
  
  protected JP.go.ipa.oz.lib.standard._String_if readResponse () throws Exception  {
// 146
    JP.go.ipa.oz.lib.standard._String_if buf = read_response ();
// 147
    if (buf == null) {
// 148
      return null;
    }
// 150
    response_message = buf;
// 151
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) record)) {
      try {
        record.decode (response_message);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      record.decode (response_message);
    }
// 153
    JP.go.ipa.oz.lib.standard._String_if getStatus$val$106;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) record)) {
      try {
        getStatus$val$106 = record.getStatus ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getStatus$val$106 = record.getStatus ();
    }
// 153
    return getStatus$val$106;
  }
  
  public NetworkClient_cl () throws Exception { super (); }
  
}

