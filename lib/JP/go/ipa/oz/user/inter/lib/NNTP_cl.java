package JP.go.ipa.oz.user.inter.lib;

public class NNTP_cl extends JP.go.ipa.oz.user.inter.lib.NetworkProtocol_cl implements JP.go.ipa.oz.user.inter.lib.NNTP_if {
  
  public Object _new_create () throws Exception  {
// 14
    super._new_create (119);
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if post (JP.go.ipa.oz.lib.standard._String_if contents) throws Exception  {
    checkSecureInvocation ();
// 201
    JP.go.ipa.oz.lib.standard._String_if status = sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("POST")));
    boolean bool$val$2;
    
    bool$val$2 = !isOk (status);
    if (!bool$val$2) {
// 203
      char charAt$val$69;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) status)) {
        try {
          charAt$val$69 = status.charAt (0);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        charAt$val$69 = status.charAt (0);
      }
      bool$val$2 = charAt$val$69 != '3';
    }
// 203
    if (bool$val$2) {
// 206
      return status;
    }
// 206
    return sendData (contents);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if next () throws Exception  {
    checkSecureInvocation ();
// 191
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("NEXT")));
  }
  
  public JP.go.ipa.oz.lib.standard._String_if group (JP.go.ipa.oz.lib.standard._String_if group) throws Exception  {
    checkSecureInvocation ();
// 116
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("GROUP")), group);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if head () throws Exception  {
    checkSecureInvocation ();
// 83
    return head (null);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if head (JP.go.ipa.oz.lib.standard._String_if msg) throws Exception  {
    checkSecureInvocation ();
// 70
    JP.go.ipa.oz.lib.standard._String_if status = sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("HEAD")), msg);
    boolean bool$val$3;
    
    bool$val$3 = !isOk (status);
    if (!bool$val$3) {
// 71
      JP.go.ipa.oz.lib.standard._String_if string$12 = (new JP.go.ipa.oz.lib.standard._String_cl("223"));
      
// 71
      boolean isequal$val$70;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) status)) {
        try {
          isequal$val$70 = status.isequal (string$12);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isequal$val$70 = status.isequal (string$12);
      }
      bool$val$3 = isequal$val$70;
    }
// 71
    if (bool$val$3) {
// 74
      return status;
    }
// 74
    return recvMultilineResponse ();
  }
  
  public JP.go.ipa.oz.lib.standard._String_if newgroups (JP.go.ipa.oz.lib.standard._String_if param) throws Exception  {
    checkSecureInvocation ();
// 170
    sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("NEWGROUPS")), param);
// 171
    return recvMultilineResponse ();
  }
  
  protected JP.go.ipa.oz.lib.standard._String_if decodeResponse (JP.go.ipa.oz.lib.standard._String_if data) throws Exception  {
// 244
    JP.go.ipa.oz.lib.standard._StringReader_if sr = (JP.go.ipa.oz.lib.standard._StringReader_cl) (new JP.go.ipa.oz.lib.standard._StringReader_cl ())._new_breed (data);
// 245
    JP.go.ipa.oz.lib.standard._BufferedReader_if lr = (JP.go.ipa.oz.lib.standard._BufferedReader_cl) (new JP.go.ipa.oz.lib.standard._BufferedReader_cl ())._new_breed (sr);
// 246
    JP.go.ipa.oz.lib.standard._StringBuffer_if buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 247
    JP.go.ipa.oz.lib.standard._System_if sys = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 249
    while (true) {
      /* body */ _loop_1: {
// 250
        JP.go.ipa.oz.lib.standard._String_if readLine$val$71;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lr)) {
          try {
            readLine$val$71 = lr.readLine ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          readLine$val$71 = lr.readLine ();
        }
// 250
        JP.go.ipa.oz.lib.standard._String_if line = readLine$val$71;
// 251
        if (line == null) {
// 252
          break;
        }
        boolean bool$val$4;
        
// 254
        JP.go.ipa.oz.lib.standard._String_if string$13 = (new JP.go.ipa.oz.lib.standard._String_cl(".\r\n"));
        
// 254
        boolean startsWith$val$72;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) line)) {
          try {
            startsWith$val$72 = line.startsWith (string$13);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          startsWith$val$72 = line.startsWith (string$13);
        }
        bool$val$4 = startsWith$val$72;
        if (bool$val$4) {
// 254
          char charAt$val$73;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) line)) {
            try {
              charAt$val$73 = line.charAt (0);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            charAt$val$73 = line.charAt (0);
          }
          bool$val$4 = charAt$val$73 == '.';
        }
// 254
        if (bool$val$4) {
// 255
          JP.go.ipa.oz.lib.standard._String_if substring$val$74;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) line)) {
            try {
              substring$val$74 = line.substring (1);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            substring$val$74 = line.substring (1);
          }
// 255
          JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$75;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
            try {
              append$val$75 = buf.append (substring$val$74);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            append$val$75 = buf.append (substring$val$74);
          }
        } else {
// 257
          JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$76;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
            try {
              append$val$76 = buf.append (line);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            append$val$76 = buf.append (line);
          }
        }
// 258
        JP.go.ipa.oz.lib.standard._String_if string$14 = (new JP.go.ipa.oz.lib.standard._String_cl("\r\n"));
        
// 258
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$77;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$77 = buf.append (string$14);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$77 = buf.append (string$14);
        }
      }
    }
// 261
    JP.go.ipa.oz.lib.standard._String_if asString$val$78;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        asString$val$78 = buf.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$78 = buf.asString ();
    }
// 261
    return asString$val$78;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if newnews (JP.go.ipa.oz.lib.standard._String_if param) throws Exception  {
    checkSecureInvocation ();
// 181
    sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("NEWNEWS")), param);
// 182
    return recvMultilineResponse ();
  }
  
  public JP.go.ipa.oz.lib.standard._String_if help () throws Exception  {
    checkSecureInvocation ();
// 125
    sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("HELP")));
// 126
    return recvMultilineResponse ();
  }
  
  public JP.go.ipa.oz.lib.standard._String_if slave () throws Exception  {
    checkSecureInvocation ();
// 224
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("SLAVE")));
  }
  
  protected JP.go.ipa.oz.lib.standard._String_if encodeData (JP.go.ipa.oz.lib.standard._String_if data) throws Exception  {
// 284
    JP.go.ipa.oz.lib.standard._StringReader_if sr = (JP.go.ipa.oz.lib.standard._StringReader_cl) (new JP.go.ipa.oz.lib.standard._StringReader_cl ())._new_breed (data);
// 285
    JP.go.ipa.oz.lib.standard._BufferedReader_if lr = (JP.go.ipa.oz.lib.standard._BufferedReader_cl) (new JP.go.ipa.oz.lib.standard._BufferedReader_cl ())._new_breed (sr);
// 286
    JP.go.ipa.oz.lib.standard._StringBuffer_if buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 288
    while (true) {
      /* body */ _loop_1: {
// 289
        JP.go.ipa.oz.lib.standard._String_if readLine$val$79;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lr)) {
          try {
            readLine$val$79 = lr.readLine ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          readLine$val$79 = lr.readLine ();
        }
// 289
        JP.go.ipa.oz.lib.standard._String_if line = readLine$val$79;
// 290
        if (line == null) {
// 291
          break;
        }
// 293
        int length$val$80;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) line)) {
          try {
            length$val$80 = line.length ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          length$val$80 = line.length ();
        }
// 293
        if (length$val$80 > 0) {{
// 294
            char charAt$val$81;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) line)) {
              try {
                charAt$val$81 = line.charAt (0);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              charAt$val$81 = line.charAt (0);
            }
// 294
            if (charAt$val$81 == '.') {
// 295
              JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$82;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
                try {
                  append$val$82 = buf.append ('.');
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                append$val$82 = buf.append ('.');
              }
            }
// 297
            JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$83;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
              try {
                append$val$83 = buf.append (line);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              append$val$83 = buf.append (line);
            }
          }
        }
// 299
        JP.go.ipa.oz.lib.standard._String_if string$15 = (new JP.go.ipa.oz.lib.standard._String_cl("\r\n"));
        
// 299
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$84;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$84 = buf.append (string$15);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$84 = buf.append (string$15);
        }
      }
    }
// 302
    JP.go.ipa.oz.lib.standard._String_if string$16 = (new JP.go.ipa.oz.lib.standard._String_cl(".\r\n"));
    
// 302
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$85;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        append$val$85 = buf.append (string$16);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$85 = buf.append (string$16);
    }
// 304
    JP.go.ipa.oz.lib.standard._String_if asString$val$86;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        asString$val$86 = buf.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$86 = buf.asString ();
    }
// 304
    return asString$val$86;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if stat () throws Exception  {
    checkSecureInvocation ();
// 106
    return stat (null);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if stat (JP.go.ipa.oz.lib.standard._String_if msg) throws Exception  {
    checkSecureInvocation ();
// 93
    JP.go.ipa.oz.lib.standard._String_if status = sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("STAT")), msg);
    boolean bool$val$5;
    
    bool$val$5 = !isOk (status);
    if (!bool$val$5) {
// 94
      JP.go.ipa.oz.lib.standard._String_if string$17 = (new JP.go.ipa.oz.lib.standard._String_cl("223"));
      
// 94
      boolean isequal$val$87;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) status)) {
        try {
          isequal$val$87 = status.isequal (string$17);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isequal$val$87 = status.isequal (string$17);
      }
      bool$val$5 = isequal$val$87;
    }
// 94
    if (bool$val$5) {
// 97
      return status;
    }
// 97
    return recvMultilineResponse ();
  }
  
  public JP.go.ipa.oz.lib.standard._String_if article () throws Exception  {
    checkSecureInvocation ();
// 37
    return article (null);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if article (JP.go.ipa.oz.lib.standard._String_if msg) throws Exception  {
    checkSecureInvocation ();
// 24
    JP.go.ipa.oz.lib.standard._String_if status = sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("ARTICLE")), msg);
    boolean bool$val$6;
    
    bool$val$6 = !isOk (status);
    if (!bool$val$6) {
// 25
      JP.go.ipa.oz.lib.standard._String_if string$18 = (new JP.go.ipa.oz.lib.standard._String_cl("223"));
      
// 25
      boolean isequal$val$88;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) status)) {
        try {
          isequal$val$88 = status.isequal (string$18);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isequal$val$88 = status.isequal (string$18);
      }
      bool$val$6 = isequal$val$88;
    }
// 25
    if (bool$val$6) {
// 28
      return status;
    }
// 28
    return recvMultilineResponse ();
  }
  
  public JP.go.ipa.oz.lib.standard._String_if body () throws Exception  {
    checkSecureInvocation ();
// 60
    return body (null);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if body (JP.go.ipa.oz.lib.standard._String_if msg) throws Exception  {
    checkSecureInvocation ();
// 47
    JP.go.ipa.oz.lib.standard._String_if status = sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("BODY")), msg);
    boolean bool$val$7;
    
    bool$val$7 = !isOk (status);
    if (!bool$val$7) {
// 48
      JP.go.ipa.oz.lib.standard._String_if string$19 = (new JP.go.ipa.oz.lib.standard._String_cl("223"));
      
// 48
      boolean isequal$val$89;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) status)) {
        try {
          isequal$val$89 = status.isequal (string$19);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isequal$val$89 = status.isequal (string$19);
      }
      bool$val$7 = isequal$val$89;
    }
// 48
    if (bool$val$7) {
// 51
      return status;
    }
// 51
    return recvMultilineResponse ();
  }
  
  protected boolean isLastLine (JP.go.ipa.oz.lib.standard._String_if data) throws Exception  {
// 234
    if (data == null) {
// 234
      return false;
    }
// 235
    JP.go.ipa.oz.lib.standard._String_if string$20 = (new JP.go.ipa.oz.lib.standard._String_cl("\r\n.\r\n"));
    
// 235
    int lastIndexOf$val$90;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) data)) {
      try {
        lastIndexOf$val$90 = data.lastIndexOf (string$20);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lastIndexOf$val$90 = data.lastIndexOf (string$20);
    }
// 235
    int idx = lastIndexOf$val$90;
// 236
    if (idx == -1) {
// 237
      return false;
    }
// 237
    int length$val$91;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) data)) {
      try {
        length$val$91 = data.length ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      length$val$91 = data.length ();
    }
// 237
    return (idx + 5 == length$val$91);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if quit () throws Exception  {
    checkSecureInvocation ();
// 215
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("QUIT")));
  }
  
  public JP.go.ipa.oz.lib.standard._String_if last () throws Exception  {
    checkSecureInvocation ();
// 150
    return sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("LAST")));
  }
  
  public JP.go.ipa.oz.lib.standard._String_if ihave (JP.go.ipa.oz.lib.standard._String_if msg, JP.go.ipa.oz.lib.standard._String_if contents) throws Exception  {
    checkSecureInvocation ();
// 137
    JP.go.ipa.oz.lib.standard._String_if status = sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("IHAVE")), msg);
    boolean bool$val$8;
    
    bool$val$8 = !isOk (status);
    if (!bool$val$8) {
// 138
      char charAt$val$92;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) status)) {
        try {
          charAt$val$92 = status.charAt (0);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        charAt$val$92 = status.charAt (0);
      }
      bool$val$8 = charAt$val$92 != '3';
    }
// 138
    if (bool$val$8) {
// 141
      return status;
    }
// 141
    return sendData (contents);
  }
  
  boolean isOk (JP.go.ipa.oz.lib.standard._String_if status) throws Exception  {
// 271
    char charAt$val$93;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) status)) {
      try {
        charAt$val$93 = status.charAt (0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      charAt$val$93 = status.charAt (0);
    }
// 271
    char c = charAt$val$93;
    boolean bool$val$9;
    
    bool$val$9 = c == '2';
    if (!bool$val$9) {
      bool$val$9 = c == '3';
    }
// 272
    return bool$val$9;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if list () throws Exception  {
    checkSecureInvocation ();
// 159
    sendCommand ((new JP.go.ipa.oz.lib.standard._String_cl("LIST")));
// 160
    return recvMultilineResponse ();
  }
  
  public NNTP_cl () throws Exception { super (); }
  
}

