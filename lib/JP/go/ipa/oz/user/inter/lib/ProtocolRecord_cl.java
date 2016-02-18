package JP.go.ipa.oz.user.inter.lib;

public class ProtocolRecord_cl extends JP.go.ipa.oz.lib.standard._Dictionary_cl implements JP.go.ipa.oz.user.inter.lib.ProtocolRecord_if {
  JP.go.ipa.oz.lib.standard._SList_if decoding_format;
  JP.go.ipa.oz.lib.standard._SList_if encoding_format;
  JP.go.ipa.oz.lib.standard._String_if line_terminator;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._String_if encode_format, JP.go.ipa.oz.lib.standard._String_if decode_format, JP.go.ipa.oz.lib.standard._String_if lt) throws Exception  {
// 34
    JP.go.ipa.oz.lib.standard._StringComparator_if sc = (JP.go.ipa.oz.lib.standard._StringComparator_cl) (new JP.go.ipa.oz.lib.standard._StringComparator_cl ())._new_create ();
// 35
    super._new_create (sc);
// 37
    encoding_format = (JP.go.ipa.oz.lib.standard._SList_cl) (new JP.go.ipa.oz.lib.standard._SList_cl ())._new_create (sc);
// 38
    parse_format (encode_format, encoding_format);
// 40
    decoding_format = (JP.go.ipa.oz.lib.standard._SList_cl) (new JP.go.ipa.oz.lib.standard._SList_cl ())._new_create (sc);
// 41
    parse_format (decode_format, decoding_format);
// 43
    line_terminator = lt;
    return this;
  }
  
  void parse_format (JP.go.ipa.oz.lib.standard._String_if orig, JP.go.ipa.oz.lib.standard._SList_if result) throws Exception  {
// 56
    JP.go.ipa.oz.lib.standard._ByteArray_if getBytes$val$118;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) orig)) {
      try {
        getBytes$val$118 = orig.getBytes ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBytes$val$118 = orig.getBytes ();
    }
// 56
    JP.go.ipa.oz.lib.standard._ByteArray_if bytes = getBytes$val$118;
// 57
    int length$val$119;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bytes)) {
      try {
        length$val$119 = bytes.length ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      length$val$119 = bytes.length ();
    }
// 57
    JP.go.ipa.oz.lib.standard._CharArray_if buf = (JP.go.ipa.oz.lib.standard._CharArray_cl) (new JP.go.ipa.oz.lib.standard._CharArray_cl ())._new_create (length$val$119);
// 58
    int j = 0;
// 60
    /* for loop starting here */ {
      /* initialization part */
      int i = 0;
// 60
      int length$val$120;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) orig)) {
        try {
          length$val$120 = orig.length ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        length$val$120 = orig.length ();
      }
      int len = length$val$120;
      
      for (;;) {
        /* boolean expression part */
        if (!(i < len)) break;
        
        /* body */ _loop_1: {
// 61
          byte at$val$121;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bytes)) {
            try {
              at$val$121 = bytes.at (i);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            at$val$121 = bytes.at (i);
          }
// 61
          byte b = at$val$121;
// 63
          if (isAlphaOrNumeric (b)) {{
// 64
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
                try {
                  buf.setAt (j++, b);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                buf.setAt (j++, b);
              }
            }
          } else {{
// 66
              JP.go.ipa.oz.lib.standard._String_if str = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed (buf, 0, j);
// 68
              JP.go.ipa.oz.lib.standard._SList_if pushBack$val$122;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) result)) {
                try {
                  pushBack$val$122 = result.pushBack (str);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                pushBack$val$122 = result.pushBack (str);
              }
// 69
              j = 0;
// 71
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
                try {
                  buf.setAt (j++, b);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                buf.setAt (j++, b);
              }
// 72
              if (b != 0x5c) {{
// 73
                  JP.go.ipa.oz.lib.standard._String_if str$1 = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed (buf, 0, j);
// 75
                  JP.go.ipa.oz.lib.standard._SList_if pushBack$val$123;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) result)) {
                    try {
                      pushBack$val$123 = result.pushBack (str$1);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    pushBack$val$123 = result.pushBack (str$1);
                  }
// 76
                  j = 0;
                }
              }
            }
          }
        }
        /* iteration part */
// 60
        i++;
      }
    }
// 81
    if (j != 0) {{
// 82
        JP.go.ipa.oz.lib.standard._String_if str = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed (buf, 0, j);
// 84
        JP.go.ipa.oz.lib.standard._SList_if pushBack$val$124;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) result)) {
          try {
            pushBack$val$124 = result.pushBack (str);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          pushBack$val$124 = result.pushBack (str);
        }
      }
    }
  }
  
  public JP.go.ipa.oz.lib.standard._String_if encode () throws Exception  {
    checkSecureInvocation ();
// 94
    JP.go.ipa.oz.lib.standard._StringBuffer_if buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 95
    JP.go.ipa.oz.lib.standard._StringBuffer_if second_buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 98
    JP.go.ipa.oz.lib.standard._String_if prev_delimiter = null;
// 99
    /* for loop starting here */ {
      /* initialization part */
      int i = 0;
// 99
      int size$val$125;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) encoding_format)) {
        try {
          size$val$125 = encoding_format.size ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        size$val$125 = encoding_format.size ();
      }
      int size = size$val$125;
      
      for (;;) {
        /* boolean expression part */
        if (!(i < size)) break;
        
        /* body */ _loop_1: {
// 100
          JP.go.ipa.oz.lib.standard._String_if key = null;
// 101
          JP.go.ipa.oz.lang._Root_if first$val$126;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) encoding_format)) {
            try {
              first$val$126 = encoding_format.first ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            first$val$126 = encoding_format.first ();
          }
// 101
          key = (JP.go.ipa.oz.lib.standard._String_if) (first$val$126);
// 105
          JP.go.ipa.oz.lib.standard._SList_if popFront$val$127;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) encoding_format)) {
            try {
              popFront$val$127 = encoding_format.popFront ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            popFront$val$127 = encoding_format.popFront ();
          }
// 106
          JP.go.ipa.oz.lib.standard._SList_if pushBack$val$128;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) encoding_format)) {
            try {
              pushBack$val$128 = encoding_format.pushBack (key);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            pushBack$val$128 = encoding_format.pushBack (key);
          }
// 108
          if (isAlphaOrNumeric (key)) {{
// 109
              JP.go.ipa.oz.lib.standard._String_if value = get (key);
// 110
              if (value != null) {{
// 111
                  JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$129;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
                    try {
                      append$val$129 = buf.append (value);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    append$val$129 = buf.append (value);
                  }
                }
              } else {{
// 114
                  if (prev_delimiter != null) {{
// 115
                      int length$val$130;
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
                        try {
                          length$val$130 = buf.length ();
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        length$val$130 = buf.length ();
                      }
// 115
                      int length$val$131;
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prev_delimiter)) {
                        try {
                          length$val$131 = prev_delimiter.length ();
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        length$val$131 = prev_delimiter.length ();
                      }
// 115
                      int len = length$val$130 - length$val$131;
// 116
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
                        try {
                          buf.setLength (len);
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        buf.setLength (len);
                      }
                    }
                  }
                }
              }
            }
          } else {{
// 120
              prev_delimiter = key;
// 121
              JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$132;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
                try {
                  append$val$132 = buf.append (key);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                append$val$132 = buf.append (key);
              }
            }
          }
        }
        /* iteration part */
// 99
        i++;
      }
    }
// 125
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$133;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        append$val$133 = buf.append (line_terminator);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$133 = buf.append (line_terminator);
    }
// 129
    JP.go.ipa.oz.lib.standard._String_if asString$val$134;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        asString$val$134 = buf.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$134 = buf.asString ();
    }
// 129
    return asString$val$134;
  }
  
  public void decode (JP.go.ipa.oz.lib.standard._String_if response_data) throws Exception  {
    checkSecureInvocation ();
// 138
    JP.go.ipa.oz.lib.standard._System_if sys = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 141
    int from = 0;
// 142
    JP.go.ipa.oz.lib.standard._StringReader_if sr = (JP.go.ipa.oz.lib.standard._StringReader_cl) (new JP.go.ipa.oz.lib.standard._StringReader_cl ())._new_breed (response_data);
// 143
    JP.go.ipa.oz.lib.standard._BufferedReader_if lr = (JP.go.ipa.oz.lib.standard._BufferedReader_cl) (new JP.go.ipa.oz.lib.standard._BufferedReader_cl ())._new_breed (sr);
// 144
    JP.go.ipa.oz.lib.standard._StringBuffer_if buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 145
    JP.go.ipa.oz.lib.standard._String_if readLine$val$135;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lr)) {
      try {
        readLine$val$135 = lr.readLine ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      readLine$val$135 = lr.readLine ();
    }
// 145
    JP.go.ipa.oz.lib.standard._String_if status = readLine$val$135;
// 146
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lr)) {
      try {
        lr.close ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lr.close ();
    }
// 147
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sr)) {
      try {
        sr.close ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      sr.close ();
    }
// 149
    /* for loop starting here */ {
      /* initialization part */
      int i = 0;
// 149
      int size$val$136;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) decoding_format)) {
        try {
          size$val$136 = decoding_format.size ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        size$val$136 = decoding_format.size ();
      }
      int size = size$val$136;
      
      for (;;) {
        /* boolean expression part */
        if (!(i < size)) break;
        
        /* body */ _loop_1: {
// 150
          JP.go.ipa.oz.lib.standard._String_if key = null;
// 151
          JP.go.ipa.oz.lang._Root_if first$val$137;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) decoding_format)) {
            try {
              first$val$137 = decoding_format.first ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            first$val$137 = decoding_format.first ();
          }
// 151
          key = (JP.go.ipa.oz.lib.standard._String_if) (first$val$137);
// 153
          JP.go.ipa.oz.lib.standard._SList_if popFront$val$138;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) decoding_format)) {
            try {
              popFront$val$138 = decoding_format.popFront ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            popFront$val$138 = decoding_format.popFront ();
          }
// 154
          JP.go.ipa.oz.lib.standard._SList_if pushBack$val$139;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) decoding_format)) {
            try {
              pushBack$val$139 = decoding_format.pushBack (key);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            pushBack$val$139 = decoding_format.pushBack (key);
          }
// 156
          if (i + 1 == size) {{
// 157
              JP.go.ipa.oz.lib.standard._String_if asString$val$140;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) response_data)) {
                try {
                  asString$val$140 = response_data.asString ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                asString$val$140 = response_data.asString ();
              }
// 157
              put (key, asString$val$140);
// 158
              break;
            }
          }
// 161
          if (isAlphaOrNumeric (key)) {{
// 162
              JP.go.ipa.oz.lib.standard._String_if value = getWord (status, from);
// 163
              int length$val$141;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) value)) {
                try {
                  length$val$141 = value.length ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                length$val$141 = value.length ();
              }
// 163
              from += length$val$141;
// 168
              put (key, value);
            }
          } else {{
// 170
              int length$val$142;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) key)) {
                try {
                  length$val$142 = key.length ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                length$val$142 = key.length ();
              }
// 170
              from += length$val$142;
            }
          }
        }
        /* iteration part */
// 149
        i++;
      }
    }
  }
  
  JP.go.ipa.oz.lib.standard._String_if getWord (JP.go.ipa.oz.lib.standard._String_if str, int from) throws Exception  {
// 181
    JP.go.ipa.oz.lib.standard._ByteArray_if getBytes$val$143;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) str)) {
      try {
        getBytes$val$143 = str.getBytes ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBytes$val$143 = str.getBytes ();
    }
// 181
    JP.go.ipa.oz.lib.standard._ByteArray_if bytes = getBytes$val$143;
// 182
    int length$val$144;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bytes)) {
      try {
        length$val$144 = bytes.length ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      length$val$144 = bytes.length ();
    }
// 182
    JP.go.ipa.oz.lib.standard._CharArray_if buf = (JP.go.ipa.oz.lib.standard._CharArray_cl) (new JP.go.ipa.oz.lib.standard._CharArray_cl ())._new_create (length$val$144);
// 183
    int j = 0;
// 185
    /* for loop starting here */ {
      /* initialization part */
      int i = from;
// 185
      int length$val$145;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) str)) {
        try {
          length$val$145 = str.length ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        length$val$145 = str.length ();
      }
      int len = length$val$145;
      
      for (;;) {
        /* boolean expression part */
        if (!(i < len)) break;
        
        /* body */ _loop_1: {
// 186
          byte at$val$146;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bytes)) {
            try {
              at$val$146 = bytes.at (i);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            at$val$146 = bytes.at (i);
          }
// 186
          byte b = at$val$146;
          boolean bool$val$11;
          
          bool$val$11 = isAlphaOrNumeric (b);
          if (!bool$val$11) {
            bool$val$11 = j == 0;
          }
// 188
          if (bool$val$11) {{
// 189
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
                try {
                  buf.setAt (j++, b);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                buf.setAt (j++, b);
              }
            }
          } else {{
// 191
              break;
            }
          }
        }
        /* iteration part */
// 185
        i++;
      }
    }
// 195
    JP.go.ipa.oz.lib.standard._String_if str$2 = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed (buf, 0, j);
// 196
    return str$2;
  }
  
  public void setCommand (JP.go.ipa.oz.lib.standard._String_if command) throws Exception  {
    checkSecureInvocation ();
// 205
    /* for loop starting here */ {
      /* initialization part */
      int i = 0;
// 205
      int size$val$147;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) encoding_format)) {
        try {
          size$val$147 = encoding_format.size ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        size$val$147 = encoding_format.size ();
      }
      int size = size$val$147;
      
      for (;;) {
        /* boolean expression part */
        if (!(i < size)) break;
        
        /* body */ _loop_1: {
// 206
          JP.go.ipa.oz.lib.standard._String_if key = null;
// 207
          JP.go.ipa.oz.lang._Root_if first$val$148;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) encoding_format)) {
            try {
              first$val$148 = encoding_format.first ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            first$val$148 = encoding_format.first ();
          }
// 207
          key = (JP.go.ipa.oz.lib.standard._String_if) (first$val$148);
// 209
          JP.go.ipa.oz.lib.standard._SList_if popFront$val$149;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) encoding_format)) {
            try {
              popFront$val$149 = encoding_format.popFront ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            popFront$val$149 = encoding_format.popFront ();
          }
// 210
          JP.go.ipa.oz.lib.standard._SList_if pushBack$val$150;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) encoding_format)) {
            try {
              pushBack$val$150 = encoding_format.pushBack (key);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            pushBack$val$150 = encoding_format.pushBack (key);
          }
// 212
          if (isAlphaOrNumeric (key)) {
// 213
            if (containsKey (key)) {
// 213
              remove (key);
            }
          }
        }
        /* iteration part */
// 205
        i++;
      }
    }
// 216
    set ((new JP.go.ipa.oz.lib.standard._String_cl("COMMAND")), command);
  }
  
  public void set (JP.go.ipa.oz.lib.standard._String_if label, JP.go.ipa.oz.lib.standard._String_if value) throws Exception  {
    checkSecureInvocation ();
// 226
    if (value == null) {
// 227
      return;
    }
// 231
    put (label, value);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getStatus () throws Exception  {
    checkSecureInvocation ();
// 240
    return get ((new JP.go.ipa.oz.lib.standard._String_cl("STATUS")));
  }
  
  boolean isAlphaOrNumeric (byte b) throws Exception  {
    boolean bool$val$12;
    
    boolean bool$val$13;
    
    boolean bool$val$14;
    
    bool$val$14 = b == 0x5f;
    if (!bool$val$14) {
      boolean bool$val$15;
      
      bool$val$15 = b >= 0x41;
      if (bool$val$15) {
        bool$val$15 = b <= 0x5a;
      }
      bool$val$14 = (bool$val$15);
    }
    bool$val$13 = bool$val$14;
    if (!bool$val$13) {
      boolean bool$val$16;
      
      bool$val$16 = b >= 0x61;
      if (bool$val$16) {
        bool$val$16 = b <= 0x7a;
      }
      bool$val$13 = (bool$val$16);
    }
    bool$val$12 = bool$val$13;
    if (!bool$val$12) {
      boolean bool$val$17;
      
      bool$val$17 = b >= 0x30;
      if (bool$val$17) {
        bool$val$17 = b <= 0x39;
      }
      bool$val$12 = (bool$val$17);
    }
// 277
    if (bool$val$12) {
// 283
      return true;
    }
// 283
    return false;
  }
  
  boolean isAlphaOrNumeric (JP.go.ipa.oz.lib.standard._String_if str) throws Exception  {
// 263
    JP.go.ipa.oz.lib.standard._ByteArray_if getBytes$val$151;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) str)) {
      try {
        getBytes$val$151 = str.getBytes ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBytes$val$151 = str.getBytes ();
    }
// 263
    JP.go.ipa.oz.lib.standard._ByteArray_if bytes = getBytes$val$151;
// 264
    int length$val$152;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bytes)) {
      try {
        length$val$152 = bytes.length ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      length$val$152 = bytes.length ();
    }
// 264
    if (length$val$152 == 0) {
// 267
      return false;
    }
// 267
    byte at$val$153;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bytes)) {
      try {
        at$val$153 = bytes.at (0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      at$val$153 = bytes.at (0);
    }
// 267
    return isAlphaOrNumeric (at$val$153);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if get (JP.go.ipa.oz.lib.standard._String_if label) throws Exception  {
    checkSecureInvocation ();
// 250
    JP.go.ipa.oz.lib.standard._String_if buf = null;
// 251
    buf = (JP.go.ipa.oz.lib.standard._String_if) (super.get (label));
// 253
    return buf;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getLineTerminator () throws Exception  {
    checkSecureInvocation ();
// 291
    return line_terminator;
  }
  
  public ProtocolRecord_cl () throws Exception { super (); }
  
}

