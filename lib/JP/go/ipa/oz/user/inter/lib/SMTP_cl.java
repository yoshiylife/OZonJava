package JP.go.ipa.oz.user.inter.lib;

public class SMTP_cl extends JP.go.ipa.oz.user.inter.lib.NetworkProtocol_cl implements JP.go.ipa.oz.user.inter.lib.SMTP_if {
  
  public Object _new_create () throws Exception  {
// 14
    super._new_create (25);
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if data (JP.go.ipa.oz.lib.standard._String_if contents) throws Exception  {
    checkSecureInvocation ();
// 54
    JP.go.ipa.oz.lib.standard._String_if buf = sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("DATA")));
// 55
    char charAt$val$154;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        charAt$val$154 = buf.charAt (0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      charAt$val$154 = buf.charAt (0);
    }
// 55
    if (charAt$val$154 != '3') {
// 58
      return response_message;
    }
// 58
    return sendData (contents);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if turn () throws Exception  {
    checkSecureInvocation ();
// 165
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("turn")));
  }
  
  public JP.go.ipa.oz.lib.standard._String_if send (JP.go.ipa.oz.lib.standard._String_if from) throws Exception  {
    checkSecureInvocation ();
// 68
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("SEND")), from);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if saml (JP.go.ipa.oz.lib.standard._String_if from) throws Exception  {
    checkSecureInvocation ();
// 88
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("SAML")), from);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if help (JP.go.ipa.oz.lib.standard._String_if str) throws Exception  {
    checkSecureInvocation ();
// 137
    sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("HELP")), str);
// 138
    return recvMultilineResponse ();
  }
  
  public JP.go.ipa.oz.lib.standard._String_if help () throws Exception  {
    checkSecureInvocation ();
// 126
    sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("HELP")));
// 127
    return recvMultilineResponse ();
  }
  
  public JP.go.ipa.oz.lib.standard._String_if helo (JP.go.ipa.oz.lib.standard._String_if domain) throws Exception  {
    checkSecureInvocation ();
// 24
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("HELO")), domain);
  }
  
  protected JP.go.ipa.oz.lib.standard._String_if encodeData (JP.go.ipa.oz.lib.standard._String_if data) throws Exception  {
// 192
    JP.go.ipa.oz.lib.standard._StringReader_if sr = (JP.go.ipa.oz.lib.standard._StringReader_cl) (new JP.go.ipa.oz.lib.standard._StringReader_cl ())._new_breed (data);
// 193
    JP.go.ipa.oz.lib.standard._BufferedReader_if lr = (JP.go.ipa.oz.lib.standard._BufferedReader_cl) (new JP.go.ipa.oz.lib.standard._BufferedReader_cl ())._new_breed (sr);
// 194
    JP.go.ipa.oz.lib.standard._StringBuffer_if buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 195
    JP.go.ipa.oz.lib.standard._System_if sys = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 197
    while (true) {
      /* body */ _loop_1: {
// 198
        JP.go.ipa.oz.lib.standard._String_if readLine$val$155;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lr)) {
          try {
            readLine$val$155 = lr.readLine ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          readLine$val$155 = lr.readLine ();
        }
// 198
        JP.go.ipa.oz.lib.standard._String_if line = readLine$val$155;
// 199
        if (line == null) {
// 200
          break;
        }
// 202
        char charAt$val$156;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) line)) {
          try {
            charAt$val$156 = line.charAt (0);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          charAt$val$156 = line.charAt (0);
        }
// 202
        if (charAt$val$156 == '.') {
// 203
          JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$157;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
            try {
              append$val$157 = buf.append ('.');
            } finally {
              changeRunningToGreen ();
            }
          } else {
            append$val$157 = buf.append ('.');
          }
        }
// 205
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$158;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$158 = buf.append (line);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$158 = buf.append (line);
        }
// 206
        JP.go.ipa.oz.lib.standard._String_if string$25 = (new JP.go.ipa.oz.lib.standard._String_cl("\r\n"));
        
// 206
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$159;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$159 = buf.append (string$25);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$159 = buf.append (string$25);
        }
      }
    }
// 209
    JP.go.ipa.oz.lib.standard._String_if string$26 = (new JP.go.ipa.oz.lib.standard._String_cl(".\r\n"));
    
// 209
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$160;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        append$val$160 = buf.append (string$26);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$160 = buf.append (string$26);
    }
// 211
    JP.go.ipa.oz.lib.standard._String_if asString$val$161;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        asString$val$161 = buf.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$161 = buf.asString ();
    }
// 211
    return asString$val$161;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if soml (JP.go.ipa.oz.lib.standard._String_if from) throws Exception  {
    checkSecureInvocation ();
// 78
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("SOML")), from);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if mail (JP.go.ipa.oz.lib.standard._String_if from) throws Exception  {
    checkSecureInvocation ();
// 34
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("MAIL")), from);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if noop () throws Exception  {
    checkSecureInvocation ();
// 147
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("NOOP")));
  }
  
  protected boolean isLastLine (JP.go.ipa.oz.lib.standard._String_if data) throws Exception  {
// 175
    if (data == null) {
// 175
      return false;
    }
// 177
    JP.go.ipa.oz.lib.standard._String_if substring$val$162;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) data)) {
      try {
        substring$val$162 = data.substring (0, 3);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      substring$val$162 = data.substring (0, 3);
    }
// 177
    JP.go.ipa.oz.lib.standard._String_if status = substring$val$162;
// 178
    JP.go.ipa.oz.lib.standard._String_if string$27 = (new JP.go.ipa.oz.lib.standard._String_cl("\r\n"));
    
// 178
    JP.go.ipa.oz.lib.standard._String_if concat$val$163;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$27)) {
      try {
        concat$val$163 = string$27.concat (status);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$163 = string$27.concat (status);
    }
// 178
    JP.go.ipa.oz.lib.standard._String_if string$28 = (new JP.go.ipa.oz.lib.standard._String_cl(" "));
    
// 178
    JP.go.ipa.oz.lib.standard._String_if concat$val$164;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$163)) {
      try {
        concat$val$164 = concat$val$163.concat (string$28);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$164 = concat$val$163.concat (string$28);
    }
// 178
    JP.go.ipa.oz.lib.standard._String_if test_pattern = concat$val$164;
// 180
    int lastIndexOf$val$165;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) data)) {
      try {
        lastIndexOf$val$165 = data.lastIndexOf (test_pattern);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lastIndexOf$val$165 = data.lastIndexOf (test_pattern);
    }
// 180
    return lastIndexOf$val$165 != -1;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if quit () throws Exception  {
    checkSecureInvocation ();
// 156
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("QUIT")));
  }
  
  public JP.go.ipa.oz.lib.standard._String_if rcpt (JP.go.ipa.oz.lib.standard._String_if to) throws Exception  {
    checkSecureInvocation ();
// 44
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("RCPT")), to);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if vrfy (JP.go.ipa.oz.lib.standard._String_if user) throws Exception  {
    checkSecureInvocation ();
// 107
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("VRFY")), user);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if rset () throws Exception  {
    checkSecureInvocation ();
// 97
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("RSET")));
  }
  
  public JP.go.ipa.oz.lib.standard._String_if expn (JP.go.ipa.oz.lib.standard._String_if ml) throws Exception  {
    checkSecureInvocation ();
// 117
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("EXPN")), ml);
  }
  
  public SMTP_cl () throws Exception { super (); }
  
}

