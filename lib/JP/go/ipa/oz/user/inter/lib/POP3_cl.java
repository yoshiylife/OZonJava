package JP.go.ipa.oz.user.inter.lib;

public class POP3_cl extends JP.go.ipa.oz.user.inter.lib.NetworkProtocol_cl implements JP.go.ipa.oz.user.inter.lib.POP3_if {
  
  public Object _new_create () throws Exception  {
// 14
    super._new_create (110);
// 15
    setTimeout (10000);
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if uidl () throws Exception  {
    checkSecureInvocation ();
// 151
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("UIDL")));
  }
  
  public JP.go.ipa.oz.lib.standard._String_if uidl (JP.go.ipa.oz.lib.standard._String_if msg) throws Exception  {
    checkSecureInvocation ();
// 142
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("UIDL")), msg);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if pass (JP.go.ipa.oz.lib.standard._String_if password) throws Exception  {
    checkSecureInvocation ();
// 35
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("PASS")), password);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if user (JP.go.ipa.oz.lib.standard._String_if username) throws Exception  {
    checkSecureInvocation ();
// 25
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("USER")), username);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if rset () throws Exception  {
    checkSecureInvocation ();
// 103
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("RSET")));
  }
  
  public JP.go.ipa.oz.lib.standard._String_if param (JP.go.ipa.oz.lib.standard._String_if param) throws Exception  {
    checkSecureInvocation ();
// 122
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("APOP")), param);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if retr (JP.go.ipa.oz.lib.standard._String_if msg) throws Exception  {
    checkSecureInvocation ();
// 83
    sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("RETR")), msg);
// 84
    return recvMultilineResponse ();
  }
  
  public JP.go.ipa.oz.lib.standard._String_if noop () throws Exception  {
    checkSecureInvocation ();
// 112
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("NOOP")));
  }
  
  public JP.go.ipa.oz.lib.standard._String_if list (JP.go.ipa.oz.lib.standard._String_if msg) throws Exception  {
    checkSecureInvocation ();
// 72
    sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("LIST")), msg);
// 73
    return recvMultilineResponse ();
  }
  
  public JP.go.ipa.oz.lib.standard._String_if list () throws Exception  {
    checkSecureInvocation ();
// 62
    return list (null);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if quit () throws Exception  {
    checkSecureInvocation ();
// 44
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("QUIT")));
  }
  
  protected JP.go.ipa.oz.lib.standard._String_if decodeResponse (JP.go.ipa.oz.lib.standard._String_if data) throws Exception  {
// 168
    JP.go.ipa.oz.lib.standard._StringReader_if sr = (JP.go.ipa.oz.lib.standard._StringReader_cl) (new JP.go.ipa.oz.lib.standard._StringReader_cl ())._new_breed (data);
// 169
    JP.go.ipa.oz.lib.standard._BufferedReader_if lr = (JP.go.ipa.oz.lib.standard._BufferedReader_cl) (new JP.go.ipa.oz.lib.standard._BufferedReader_cl ())._new_breed (sr);
// 170
    JP.go.ipa.oz.lib.standard._StringBuffer_if buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 171
    JP.go.ipa.oz.lib.standard._System_if sys = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 173
    while (true) {
      /* body */ _loop_1: {
// 174
        JP.go.ipa.oz.lib.standard._String_if readLine$val$108;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lr)) {
          try {
            readLine$val$108 = lr.readLine ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          readLine$val$108 = lr.readLine ();
        }
// 174
        JP.go.ipa.oz.lib.standard._String_if line = readLine$val$108;
// 175
        if (line == null) {
// 176
          break;
        }
        boolean bool$val$10;
        
// 178
        JP.go.ipa.oz.lib.standard._String_if string$22 = (new JP.go.ipa.oz.lib.standard._String_cl(".\r\n"));
        
// 178
        boolean startsWith$val$109;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) line)) {
          try {
            startsWith$val$109 = line.startsWith (string$22);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          startsWith$val$109 = line.startsWith (string$22);
        }
        bool$val$10 = startsWith$val$109;
        if (bool$val$10) {
// 178
          char charAt$val$110;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) line)) {
            try {
              charAt$val$110 = line.charAt (0);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            charAt$val$110 = line.charAt (0);
          }
          bool$val$10 = charAt$val$110 == '.';
        }
// 178
        if (bool$val$10) {
// 179
          JP.go.ipa.oz.lib.standard._String_if substring$val$111;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) line)) {
            try {
              substring$val$111 = line.substring (1);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            substring$val$111 = line.substring (1);
          }
// 179
          JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$112;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
            try {
              append$val$112 = buf.append (substring$val$111);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            append$val$112 = buf.append (substring$val$111);
          }
        } else {
// 181
          JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$113;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
            try {
              append$val$113 = buf.append (line);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            append$val$113 = buf.append (line);
          }
        }
// 182
        JP.go.ipa.oz.lib.standard._String_if string$23 = (new JP.go.ipa.oz.lib.standard._String_cl("\r\n"));
        
// 182
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$114;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$114 = buf.append (string$23);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$114 = buf.append (string$23);
        }
      }
    }
// 185
    JP.go.ipa.oz.lib.standard._String_if asString$val$115;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        asString$val$115 = buf.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$115 = buf.asString ();
    }
// 185
    return asString$val$115;
  }
  
  protected boolean isLastLine (JP.go.ipa.oz.lib.standard._String_if data) throws Exception  {
// 158
    if (data == null) {
// 158
      return false;
    }
// 159
    JP.go.ipa.oz.lib.standard._String_if string$24 = (new JP.go.ipa.oz.lib.standard._String_cl("\r\n.\r\n"));
    
// 159
    int lastIndexOf$val$116;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) data)) {
      try {
        lastIndexOf$val$116 = data.lastIndexOf (string$24);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lastIndexOf$val$116 = data.lastIndexOf (string$24);
    }
// 159
    int idx = lastIndexOf$val$116;
// 160
    if (idx == -1) {
// 161
      return false;
    }
// 161
    int length$val$117;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) data)) {
      try {
        length$val$117 = data.length ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      length$val$117 = data.length ();
    }
// 161
    return (idx + 5 == length$val$117);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if dele (JP.go.ipa.oz.lib.standard._String_if msg) throws Exception  {
    checkSecureInvocation ();
// 94
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("DELE")), msg);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if top (JP.go.ipa.oz.lib.standard._String_if msg) throws Exception  {
    checkSecureInvocation ();
// 132
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("TOP")), msg);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if stat () throws Exception  {
    checkSecureInvocation ();
// 53
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("STAT")));
  }
  
  public POP3_cl () throws Exception { super (); }
  
}

