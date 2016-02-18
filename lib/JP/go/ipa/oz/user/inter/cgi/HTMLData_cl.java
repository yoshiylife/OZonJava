package JP.go.ipa.oz.user.inter.cgi;

public class HTMLData_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.inter.cgi.HTMLData_if {
  JP.go.ipa.oz.lib.standard._SList_if starting_tags;
  JP.go.ipa.oz.lib.standard._String_if form_id;
  int request_number;
  JP.go.ipa.oz.lib.standard._ByteArray_if binary_data;
  JP.go.ipa.oz.lib.standard._String_if request_id;
  JP.go.ipa.oz.lib.standard._Dictionary_if input_data;
  JP.go.ipa.oz.lib.standard._StringBuffer_if output;
  
  public Object _new_create () throws Exception  {
    return this;
  }
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._InputStream_if is, int req_no) throws Exception  {
// 52
    request_number = req_no;
// 53
    parse_data (is);
// 54
    if (request_number < 0) {
// 54
      return this;
    }
// 55
    JP.go.ipa.oz.lib.standard._String_if valueOf$val$8;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) form_id)) {
      try {
        valueOf$val$8 = form_id.valueOf (req_no);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      valueOf$val$8 = form_id.valueOf (req_no);
    }
// 55
    JP.go.ipa.oz.lib.standard._String_if concat$val$9;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) form_id)) {
      try {
        concat$val$9 = form_id.concat (valueOf$val$8);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$9 = form_id.concat (valueOf$val$8);
    }
// 55
    request_id = concat$val$9;
    return this;
  }
  
  public JP.go.ipa.oz.lang._Root_if getValue (JP.go.ipa.oz.lib.standard._String_if label) throws Exception  {
    checkSecureInvocation ();
    boolean bool$val$0;
    
    bool$val$0 = isGreen ();
    if (bool$val$0) {
// 69
      boolean isRed$val$10;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) input_data)) {
        try {
          isRed$val$10 = input_data.isRed ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isRed$val$10 = input_data.isRed ();
      }
      bool$val$0 = isRed$val$10;
    }
// 69
    if (bool$val$0) {
// 70
      turnGreen (input_data);
    }
// 72
    JP.go.ipa.oz.lang._Root_if get$val$11;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) input_data)) {
      try {
        get$val$11 = input_data.get (label);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      get$val$11 = input_data.get (label);
    }
// 72
    return get$val$11;
  }
  
  void skip_header (JP.go.ipa.oz.lib.standard._InputStream_if in) throws Exception  {
// 498
    while (true) {
      /* body */ _loop_1: {
// 499
        JP.go.ipa.oz.lib.standard._String_if read_one_line$val$12;
        read_one_line$val$12 = read_one_line (in);
// 499
        JP.go.ipa.oz.lib.standard._String_if trim$val$13;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) read_one_line$val$12)) {
          try {
            trim$val$13 = read_one_line$val$12.trim ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          trim$val$13 = read_one_line$val$12.trim ();
        }
// 499
        int length$val$14;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) trim$val$13)) {
          try {
            length$val$14 = trim$val$13.length ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          length$val$14 = trim$val$13.length ();
        }
// 499
        if (length$val$14 == 0) {
// 500
          return;
        }
      }
    }
  }
  
  JP.go.ipa.oz.lib.standard._String_if decode (JP.go.ipa.oz.lib.standard._String_if orig) throws Exception  {
// 631
    JP.go.ipa.oz.lib.standard._ByteArray_if getBytes$val$15;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) orig)) {
      try {
        getBytes$val$15 = orig.getBytes ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBytes$val$15 = orig.getBytes ();
    }
// 631
    JP.go.ipa.oz.lib.standard._ByteArray_if bytes = getBytes$val$15;
// 632
    int length$val$16;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) orig)) {
      try {
        length$val$16 = orig.length ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      length$val$16 = orig.length ();
    }
// 632
    int len = length$val$16;
// 633
    JP.go.ipa.oz.lib.standard._CharArray_if buf = (JP.go.ipa.oz.lib.standard._CharArray_cl) (new JP.go.ipa.oz.lib.standard._CharArray_cl ())._new_create (len);
// 635
    int pos = 0;
// 636
    /* for loop starting here */ {
      /* initialization part */
      int i = 0;
      
      for (;;) {
        /* boolean expression part */
        if (!(i < len)) break;
        
        /* body */ _loop_1: {
// 637
          char charAt$val$17;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) orig)) {
            try {
              charAt$val$17 = orig.charAt (i++);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            charAt$val$17 = orig.charAt (i++);
          }
// 637
          char ch = charAt$val$17;
// 638
          if (ch == '%') {{
// 639
              int c = 0;
// 640
              /* for loop starting here */ {
                /* initialization part */
                int j = 0;
                
                for (;;) {
                  /* boolean expression part */
                  if (!(j < 2)) break;
                  
                  /* body */ _loop_2: {
// 641
                    byte at$val$18;
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bytes)) {
                      try {
                        at$val$18 = bytes.at (i++);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      at$val$18 = bytes.at (i++);
                    }
// 641
                    int b = at$val$18;
// 642
                    if (b <= 57) {
// 643
                      b -= 48;
                    } else {
// 645
                      b = b - 65 + 10;
                    }
// 646
                    c += j == 0 ? b * 0x10 : b;
                  }
                  /* iteration part */
// 640
                  j++;
                }
              }
// 648
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
                try {
                  buf.setAt (pos, c);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                buf.setAt (pos, c);
              }
            }
          } else {
// 649
            if (ch == '+') {{
// 650
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
                  try {
                    buf.setAt (pos, ' ');
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  buf.setAt (pos, ' ');
                }
              }
            } else {
// 652
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
                try {
                  buf.setAt (pos, ch);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                buf.setAt (pos, ch);
              }
            }
          }
        }
        /* iteration part */
// 636
        pos++;
      }
    }
// 655
    JP.go.ipa.oz.lib.standard._String_if str = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed (buf, 0, pos);
// 657
    JP.go.ipa.oz.lib.standard._System_if sys = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 658
    JP.go.ipa.oz.lib.standard._String_if string$1 = (new JP.go.ipa.oz.lib.standard._String_cl("decoded: "));
    
// 658
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
      try {
        sys.debugPrintln (string$1);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      sys.debugPrintln (string$1);
    }
// 659
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
      try {
        sys.debugPrintln (str);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      sys.debugPrintln (str);
    }
// 661
    return str;
  }
  
  public void addOutput (JP.go.ipa.oz.lib.standard._InputStream_if in, int size) throws Exception  {
    checkSecureInvocation ();
// 152
    binary_data = (JP.go.ipa.oz.lib.standard._ByteArray_cl) (new JP.go.ipa.oz.lib.standard._ByteArray_cl ())._new_create (size);
// 153
    int read$val$19;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) in)) {
      try {
        read$val$19 = in.read (binary_data, 0, size);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      read$val$19 = in.read (binary_data, 0, size);
    }
  }
  
  public void addOutput (JP.go.ipa.oz.lib.standard._String_if str) throws Exception  {
    checkSecureInvocation ();
// 135
    JP.go.ipa.oz.lib.standard._String_if tag = null;
// 136
    JP.go.ipa.oz.lang._Root_if first$val$20;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) starting_tags)) {
      try {
        first$val$20 = starting_tags.first ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      first$val$20 = starting_tags.first ();
    }
// 136
    tag = (JP.go.ipa.oz.lib.standard._String_if) (first$val$20);
    boolean bool$val$1;
    
    bool$val$1 = tag == null;
    if (!bool$val$1) {
// 138
      JP.go.ipa.oz.lib.standard._String_if string$2 = (new JP.go.ipa.oz.lib.standard._String_cl("<pre>"));
      
// 138
      boolean equalsIgnoreCase$val$21;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tag)) {
        try {
          equalsIgnoreCase$val$21 = tag.equalsIgnoreCase (string$2);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        equalsIgnoreCase$val$21 = tag.equalsIgnoreCase (string$2);
      }
      bool$val$1 = !equalsIgnoreCase$val$21;
    }
// 138
    if (bool$val$1) {{
// 139
        JP.go.ipa.oz.lib.standard._String_if escape$val$22;
        escape$val$22 = escape (str);
// 139
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$23;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) output)) {
          try {
            append$val$23 = output.append (escape$val$22);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$23 = output.append (escape$val$22);
        }
      }
    } else {{
// 141
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$24;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) output)) {
          try {
            append$val$24 = output.append (str);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$24 = output.append (str);
        }
      }
    }
  }
  
  JP.go.ipa.oz.lib.standard._String_if read_one_line (JP.go.ipa.oz.lib.standard._InputStream_if in) throws Exception  {
// 476
    JP.go.ipa.oz.lib.standard._StringBuffer_if buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 477
    JP.go.ipa.oz.lib.standard._CharArray_if c = (JP.go.ipa.oz.lib.standard._CharArray_cl) (new JP.go.ipa.oz.lib.standard._CharArray_cl ())._new_create (1);
// 479
    while (true) {
      /* body */ _loop_1: {
// 480
        int read$val$25;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) in)) {
          try {
            read$val$25 = in.read ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          read$val$25 = in.read ();
        }
// 480
        int b = read$val$25;
// 482
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) c)) {
          try {
            c.setAt (0, b);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          c.setAt (0, b);
        }
// 483
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$26;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$26 = buf.append (c);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$26 = buf.append (c);
        }
// 485
        if (b == 0x0a) {
// 486
          break;
        }
      }
    }
// 489
    JP.go.ipa.oz.lib.standard._String_if asString$val$27;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        asString$val$27 = buf.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$27 = buf.asString ();
    }
// 489
    return asString$val$27;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getFormID () throws Exception  {
    checkSecureInvocation ();
// 273
    return form_id;
  }
  
  JP.go.ipa.oz.lib.standard._String_if createPath (JP.go.ipa.oz.lib.standard._String_if base) throws Exception  {
// 510
    JP.go.ipa.oz.lib.standard._System_if sys = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 511
    JP.go.ipa.oz.lib.standard._String_if getOzHome$val$28;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
      try {
        getOzHome$val$28 = sys.getOzHome ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzHome$val$28 = sys.getOzHome ();
    }
// 511
    JP.go.ipa.oz.lib.standard._String_if ozhome = getOzHome$val$28;
// 512
    JP.go.ipa.oz.lib.standard._String_if string$3 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
    
// 512
    boolean startsWith$val$29;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozhome)) {
      try {
        startsWith$val$29 = ozhome.startsWith (string$3);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      startsWith$val$29 = ozhome.startsWith (string$3);
    }
// 512
    char sep = startsWith$val$29 ? '/' : '\\';
// 513
    JP.go.ipa.oz.lib.standard._StringBuffer_if path = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (ozhome);
// 515
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$30;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
      try {
        append$val$30 = path.append (sep);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$30 = path.append (sep);
    }
// 516
    JP.go.ipa.oz.lib.standard._String_if string$4 = (new JP.go.ipa.oz.lib.standard._String_cl("objects"));
    
// 516
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$31;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
      try {
        append$val$31 = path.append (string$4);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$31 = path.append (string$4);
    }
// 518
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$32;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
      try {
        append$val$32 = path.append (sep);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$32 = path.append (sep);
    }
// 519
    JP.go.ipa.oz.lib.standard._String_if getGOD$val$33;
    getGOD$val$33 = getGOD ();
// 519
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$34;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
      try {
        append$val$34 = path.append (getGOD$val$33);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$34 = path.append (getGOD$val$33);
    }
// 520
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$35;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
      try {
        append$val$35 = path.append (sep);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$35 = path.append (sep);
    }
// 521
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$36;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
      try {
        append$val$36 = path.append (base);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$36 = path.append (base);
    }
// 522
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$37;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
      try {
        append$val$37 = path.append ('.');
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$37 = path.append ('.');
    }
// 523
    JP.go.ipa.oz.lib.standard._String_if string$5 = (new JP.go.ipa.oz.lib.standard._String_cl(""));
    
// 523
    JP.go.ipa.oz.lib.standard._String_if valueOf$val$38;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$5)) {
      try {
        valueOf$val$38 = string$5.valueOf (request_number);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      valueOf$val$38 = string$5.valueOf (request_number);
    }
// 523
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$39;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
      try {
        append$val$39 = path.append (valueOf$val$38);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$39 = path.append (valueOf$val$38);
    }
// 525
    JP.go.ipa.oz.lib.standard._String_if asString$val$40;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
      try {
        asString$val$40 = path.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$40 = path.asString ();
    }
// 525
    return asString$val$40;
  }
  
  void parse_data (JP.go.ipa.oz.lib.standard._InputStream_if is) throws Exception  {
// 282
    JP.go.ipa.oz.lib.standard._System_if sys = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 283
    JP.go.ipa.oz.lib.standard._String_if string$6 = (new JP.go.ipa.oz.lib.standard._String_cl("HTMLData: parsing"));
    
// 283
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
      try {
        sys.debugPrintln (string$6);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      sys.debugPrintln (string$6);
    }
// 285
    JP.go.ipa.oz.lib.standard._StringComparator_if scomp = (JP.go.ipa.oz.lib.standard._StringComparator_cl) (new JP.go.ipa.oz.lib.standard._StringComparator_cl ())._new_create ();
// 286
    input_data = (JP.go.ipa.oz.lib.standard._Dictionary_cl) (new JP.go.ipa.oz.lib.standard._Dictionary_cl ())._new_create (scomp);
// 288
    if (request_number >= 0) {{
// 289
        JP.go.ipa.oz.lib.standard._ByteArray_if b = (JP.go.ipa.oz.lib.standard._ByteArray_cl) (new JP.go.ipa.oz.lib.standard._ByteArray_cl ())._new_create (3);
// 290
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) is)) {
          try {
            is.mark (3);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          is.mark (3);
        }
// 291
        while (true) {
          /* body */ _loop_1: {
// 292
            int available$val$41;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) is)) {
              try {
                available$val$41 = is.available ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              available$val$41 = is.available ();
            }
// 292
            int size = available$val$41;
// 294
            if (size >= 3) {
// 294
              break;
            }
          }
        }
// 297
        int read$val$42;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) is)) {
          try {
            read$val$42 = is.read (b, 0, 3);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          read$val$42 = is.read (b, 0, 3);
        }
// 298
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) is)) {
          try {
            is.reset ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          is.reset ();
        }
// 299
        JP.go.ipa.oz.lib.standard._String_if buf = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed (b, 0, 3);
// 301
        JP.go.ipa.oz.lib.standard._String_if string$7 = (new JP.go.ipa.oz.lib.standard._String_cl("---"));
        
// 301
        boolean startsWith$val$43;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            startsWith$val$43 = buf.startsWith (string$7);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          startsWith$val$43 = buf.startsWith (string$7);
        }
// 301
        if (startsWith$val$43) {
// 302
          parse_multipart (is);
        } else {
// 304
          parse_singlepart (is);
        }
      }
    } else {{
// 306
        if (request_number == -1) {
// 307
          JP.go.ipa.oz.lib.standard._String_if string$8 = (new JP.go.ipa.oz.lib.standard._String_cl("HTMLData: parsing"));
          
// 307
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
            try {
              sys.println (string$8);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            sys.println (string$8);
          }
        }
// 308
        parse_singlepart (is);
      }
    }
// 312
    form_id = (JP.go.ipa.oz.lib.standard._String_if) (getValue ((new JP.go.ipa.oz.lib.standard._String_cl(".formId"))));
// 314
    if (request_number == -1) {
// 315
      JP.go.ipa.oz.lib.standard._String_if string$9 = (new JP.go.ipa.oz.lib.standard._String_cl("HTMLData: parsing done"));
      
// 315
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
        try {
          sys.println (string$9);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        sys.println (string$9);
      }
    }
  }
  
  public void beginTag (JP.go.ipa.oz.lib.standard._String_if tag) throws Exception  {
    checkSecureInvocation ();
// 122
    JP.go.ipa.oz.lib.standard._String_if string$10 = (new JP.go.ipa.oz.lib.standard._String_cl("\n<"));
    
// 122
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$44;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) output)) {
      try {
        append$val$44 = output.append (string$10);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$44 = output.append (string$10);
    }
// 123
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$45;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) output)) {
      try {
        append$val$45 = output.append (tag);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$45 = output.append (tag);
    }
// 124
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$46;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) output)) {
      try {
        append$val$46 = output.append ('>');
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$46 = output.append ('>');
    }
// 126
    JP.go.ipa.oz.lib.standard._SList_if pushFront$val$47;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) starting_tags)) {
      try {
        pushFront$val$47 = starting_tags.pushFront (tag);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pushFront$val$47 = starting_tags.pushFront (tag);
    }
  }
  
  void parse_singlepart (JP.go.ipa.oz.lib.standard._InputStream_if is) throws Exception  {
// 538
    JP.go.ipa.oz.lib.standard._ByteArray_if data = (JP.go.ipa.oz.lib.standard._ByteArray_cl) (new JP.go.ipa.oz.lib.standard._ByteArray_cl ())._new_create (1024);
// 539
    JP.go.ipa.oz.lib.standard._StringBuffer_if sbuf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 541
    while (true) {
      /* body */ _loop_1: {
// 542
        int available$val$48;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) is)) {
          try {
            available$val$48 = is.available ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          available$val$48 = is.available ();
        }
// 542
        int size = available$val$48;
// 543
        if (size == 0) {
// 544
          break;
        }
// 546
        int read$val$49;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) is)) {
          try {
            read$val$49 = is.read (data);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          read$val$49 = is.read (data);
        }
// 546
        size = read$val$49;
// 547
        JP.go.ipa.oz.lib.standard._String_if str = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed (data, 0, size);
// 548
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$50;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbuf)) {
          try {
            append$val$50 = sbuf.append (str);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$50 = sbuf.append (str);
        }
      }
    }
// 551
    JP.go.ipa.oz.lib.standard._String_if asString$val$51;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbuf)) {
      try {
        asString$val$51 = sbuf.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$51 = sbuf.asString ();
    }
// 551
    JP.go.ipa.oz.lib.standard._StringReader_if sr = (JP.go.ipa.oz.lib.standard._StringReader_cl) (new JP.go.ipa.oz.lib.standard._StringReader_cl ())._new_breed (asString$val$51);
// 552
    JP.go.ipa.oz.lib.standard._StreamTokenizer_if st = (JP.go.ipa.oz.lib.standard._StreamTokenizer_cl) (new JP.go.ipa.oz.lib.standard._StreamTokenizer_cl ())._new_breed (sr);
// 554
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
      try {
        st.resetSyntax ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      st.resetSyntax ();
    }
// 555
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
      try {
        st.wordChars (0x21, 0x7e);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      st.wordChars (0x21, 0x7e);
    }
// 556
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
      try {
        st.whitespaceChars (0, 0x20);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      st.whitespaceChars (0, 0x20);
    }
// 557
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
      try {
        st.ordinaryChar (0x3d);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      st.ordinaryChar (0x3d);
    }
// 558
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
      try {
        st.ordinaryChar (0x26);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      st.ordinaryChar (0x26);
    }
// 559
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
      try {
        st.eolIsSignificant (true);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      st.eolIsSignificant (true);
    }
// 561
    JP.go.ipa.oz.lib.standard._System_if sys = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 565
    boolean eof = false;
// 566
    JP.go.ipa.oz.lib.standard._String_if buf = null, value = null, label = null;
// 567
    while (true) {
      if (!(!eof)) break;
      
      /* body */ _loop_1: {
// 568
        int nextToken$val$52;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
          try {
            nextToken$val$52 = st.nextToken ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextToken$val$52 = st.nextToken ();
        }
// 570
        boolean ttypeisWORD$val$53;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
          try {
            ttypeisWORD$val$53 = st.ttypeisWORD ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          ttypeisWORD$val$53 = st.ttypeisWORD ();
        }
// 570
        if (ttypeisWORD$val$53) {{
// 571
            JP.go.ipa.oz.lib.standard._String_if getsval$val$54;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
              try {
                getsval$val$54 = st.getsval ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getsval$val$54 = st.getsval ();
            }
// 571
            JP.go.ipa.oz.lib.standard._String_if sval = getsval$val$54;
// 573
            buf = sval;
// 574
            break _loop_1;
          }
        } else {{
// 576
            int getttype$val$55;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
              try {
                getttype$val$55 = st.getttype ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getttype$val$55 = st.getttype ();
            }
// 576
            int tttype = getttype$val$55;
// 577
            if (tttype == 0x3d) {{
// 578
                label = buf;
// 579
                break _loop_1;
              }
            } else {
// 580
              if (tttype == 0x26) {{
// 581
                  value = buf;
                }
              } else {
// 582
                boolean ttypeisEOF$val$56;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
                  try {
                    ttypeisEOF$val$56 = st.ttypeisEOF ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  ttypeisEOF$val$56 = st.ttypeisEOF ();
                }
// 582
                if (ttypeisEOF$val$56) {{
// 583
                    value = buf;
// 584
                    eof = true;
                  }
                } else {{
// 586
                    break _loop_1;
                  }
                }
              }
            }
          }
        }
// 603
        JP.go.ipa.oz.lib.standard._String_if string$11 = (new JP.go.ipa.oz.lib.standard._String_cl("HTMLData: <label>"));
        
// 603
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
          try {
            sys.debugPrintln (string$11);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          sys.debugPrintln (string$11);
        }
// 604
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
          try {
            sys.debugPrintln (label);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          sys.debugPrintln (label);
        }
// 605
        JP.go.ipa.oz.lib.standard._String_if string$12 = (new JP.go.ipa.oz.lib.standard._String_cl("HTMLData: <value>"));
        
// 605
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
          try {
            sys.debugPrintln (string$12);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          sys.debugPrintln (string$12);
        }
// 606
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
          try {
            sys.debugPrintln (value);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          sys.debugPrintln (value);
        }
// 608
        if (request_number == -1) {{
// 609
            JP.go.ipa.oz.lib.standard._String_if string$13 = (new JP.go.ipa.oz.lib.standard._String_cl("HTMLData: <label>"));
            
// 609
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
              try {
                sys.println (string$13);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              sys.println (string$13);
            }
// 610
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
              try {
                sys.println (label);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              sys.println (label);
            }
// 611
            JP.go.ipa.oz.lib.standard._String_if string$14 = (new JP.go.ipa.oz.lib.standard._String_cl("HTMLData: <value>"));
            
// 611
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
              try {
                sys.println (string$14);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              sys.println (string$14);
            }
// 612
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
              try {
                sys.println (value);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              sys.println (value);
            }
          }
        }
// 615
        JP.go.ipa.oz.lib.standard._String_if decode$val$57;
        decode$val$57 = decode (value);
// 615
        JP.go.ipa.oz.lib.standard._Dictionary_if put$val$58;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) input_data)) {
          try {
            put$val$58 = input_data.put (label, decode$val$57);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          put$val$58 = input_data.put (label, decode$val$57);
        }
      }
    }
  }
  
  public JP.go.ipa.oz.lib.standard._Iterator_if getLabels () throws Exception  {
    checkSecureInvocation ();
// 81
    JP.go.ipa.oz.lib.standard._Set_if keys$val$59;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) input_data)) {
      try {
        keys$val$59 = input_data.keys ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      keys$val$59 = input_data.keys ();
    }
// 81
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$60;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) keys$val$59)) {
      try {
        iterator$val$60 = keys$val$59.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$60 = keys$val$59.iterator ();
    }
// 81
    return iterator$val$60;
  }
  
  JP.go.ipa.oz.lib.standard._String_if escape (JP.go.ipa.oz.lib.standard._String_if str) throws Exception  {
// 181
    JP.go.ipa.oz.lib.standard._StringBuffer_if buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 183
    JP.go.ipa.oz.lib.standard._CharArray_if original_chars = (JP.go.ipa.oz.lib.standard._CharArray_cl) (new JP.go.ipa.oz.lib.standard._CharArray_cl ())._new_create (4);
// 184
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) original_chars)) {
      try {
        original_chars.putAt (0, '&');
      } finally {
        changeRunningToGreen ();
      }
    } else {
      original_chars.putAt (0, '&');
    }
// 185
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) original_chars)) {
      try {
        original_chars.putAt (1, '<');
      } finally {
        changeRunningToGreen ();
      }
    } else {
      original_chars.putAt (1, '<');
    }
// 186
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) original_chars)) {
      try {
        original_chars.putAt (2, '>');
      } finally {
        changeRunningToGreen ();
      }
    } else {
      original_chars.putAt (2, '>');
    }
// 187
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) original_chars)) {
      try {
        original_chars.putAt (3, '\"');
      } finally {
        changeRunningToGreen ();
      }
    } else {
      original_chars.putAt (3, '\"');
    }
// 189
    JP.go.ipa.oz.lib.standard._Array_if converted_strs = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (4);
// 190
    JP.go.ipa.oz.lib.standard._String_if string$15 = (new JP.go.ipa.oz.lib.standard._String_cl("&amp;"));
    
// 190
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$61;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) converted_strs)) {
      try {
        putAt$val$61 = converted_strs.putAt (0, string$15);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$61 = converted_strs.putAt (0, string$15);
    }
// 191
    JP.go.ipa.oz.lib.standard._String_if string$16 = (new JP.go.ipa.oz.lib.standard._String_cl("&lt;"));
    
// 191
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$62;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) converted_strs)) {
      try {
        putAt$val$62 = converted_strs.putAt (1, string$16);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$62 = converted_strs.putAt (1, string$16);
    }
// 192
    JP.go.ipa.oz.lib.standard._String_if string$17 = (new JP.go.ipa.oz.lib.standard._String_cl("&gt;"));
    
// 192
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$63;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) converted_strs)) {
      try {
        putAt$val$63 = converted_strs.putAt (2, string$17);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$63 = converted_strs.putAt (2, string$17);
    }
// 193
    JP.go.ipa.oz.lib.standard._String_if string$18 = (new JP.go.ipa.oz.lib.standard._String_cl("&quot;"));
    
// 193
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$64;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) converted_strs)) {
      try {
        putAt$val$64 = converted_strs.putAt (3, string$18);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$64 = converted_strs.putAt (3, string$18);
    }
// 195
    int length$val$65;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) original_chars)) {
      try {
        length$val$65 = original_chars.length ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      length$val$65 = original_chars.length ();
    }
// 195
    int len = length$val$65, from = 0;
// 196
    int length$val$66;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) str)) {
      try {
        length$val$66 = str.length ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      length$val$66 = str.length ();
    }
// 196
    int str_len = length$val$66;
// 197
    while (true) {
      /* body */ _loop_1: {
// 198
        int idx = str_len;
// 199
        int found_char = 0;
// 200
        /* for loop starting here */ {
          /* initialization part */
          int i = 0;
          
          for (;;) {
            /* boolean expression part */
            if (!(i < len)) break;
            
            /* body */ _loop_2: {
// 201
              char at$val$67;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) original_chars)) {
                try {
                  at$val$67 = original_chars.at (i);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                at$val$67 = original_chars.at (i);
              }
// 201
              int indexOf$val$68;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) str)) {
                try {
                  indexOf$val$68 = str.indexOf (at$val$67, from);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                indexOf$val$68 = str.indexOf (at$val$67, from);
              }
// 201
              int found = indexOf$val$68;
              boolean bool$val$2;
              
              bool$val$2 = found != -1;
              if (bool$val$2) {
                bool$val$2 = found < idx;
              }
// 202
              if (bool$val$2) {{
// 203
                  idx = found;
// 204
                  found_char = i;
                }
              }
            }
            /* iteration part */
// 200
            i++;
          }
        }
// 208
        if (idx < str_len) {{
// 209
            JP.go.ipa.oz.lib.standard._String_if substring$val$69;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) str)) {
              try {
                substring$val$69 = str.substring (from, idx);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              substring$val$69 = str.substring (from, idx);
            }
// 209
            JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$70;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
              try {
                append$val$70 = buf.append (substring$val$69);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              append$val$70 = buf.append (substring$val$69);
            }
// 210
            JP.go.ipa.oz.lang._Root_if at$val$71;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) converted_strs)) {
              try {
                at$val$71 = converted_strs.at (found_char);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              at$val$71 = converted_strs.at (found_char);
            }
// 210
            JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$72;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
              try {
                append$val$72 = buf.append (at$val$71);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              append$val$72 = buf.append (at$val$71);
            }
// 211
            from = idx + 1;
          }
        } else {{
// 213
            break;
          }
        }
      }
    }
// 217
    JP.go.ipa.oz.lib.standard._String_if substring$val$73;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) str)) {
      try {
        substring$val$73 = str.substring (from);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      substring$val$73 = str.substring (from);
    }
// 217
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$74;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        append$val$74 = buf.append (substring$val$73);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$74 = buf.append (substring$val$73);
    }
// 219
    JP.go.ipa.oz.lib.standard._String_if asString$val$75;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        asString$val$75 = buf.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$75 = buf.asString ();
    }
// 219
    return asString$val$75;
  }
  
  public void startOutput (JP.go.ipa.oz.lib.standard._String_if content, JP.go.ipa.oz.lib.standard._String_if name) throws Exception  {
    checkSecureInvocation ();
// 104
    if (starting_tags == null) {
// 105
      starting_tags = (JP.go.ipa.oz.lib.standard._SList_cl) (new JP.go.ipa.oz.lib.standard._SList_cl ())._new_create ();
    }
// 107
    output = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 109
    JP.go.ipa.oz.lib.standard._String_if string$19 = (new JP.go.ipa.oz.lib.standard._String_cl("Content-Type: "));
    
// 109
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$76;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) output)) {
      try {
        append$val$76 = output.append (string$19);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$76 = output.append (string$19);
    }
// 110
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$77;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) output)) {
      try {
        append$val$77 = output.append (content);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$77 = output.append (content);
    }
// 111
    JP.go.ipa.oz.lib.standard._String_if string$20 = (new JP.go.ipa.oz.lib.standard._String_cl("\nContent-Disposition: filename="));
    
// 111
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$78;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) output)) {
      try {
        append$val$78 = output.append (string$20);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$78 = output.append (string$20);
    }
// 112
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$79;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) output)) {
      try {
        append$val$79 = output.append (name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$79 = output.append (name);
    }
// 113
    JP.go.ipa.oz.lib.standard._String_if string$21 = (new JP.go.ipa.oz.lib.standard._String_cl("\n\n"));
    
// 113
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$80;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) output)) {
      try {
        append$val$80 = output.append (string$21);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$80 = output.append (string$21);
    }
  }
  
  public void startOutput (JP.go.ipa.oz.lib.standard._String_if content) throws Exception  {
    checkSecureInvocation ();
// 88
    if (starting_tags == null) {
// 89
      starting_tags = (JP.go.ipa.oz.lib.standard._SList_cl) (new JP.go.ipa.oz.lib.standard._SList_cl ())._new_create ();
    }
// 91
    output = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 93
    if (content != null) {{
// 94
        JP.go.ipa.oz.lib.standard._String_if string$22 = (new JP.go.ipa.oz.lib.standard._String_cl("Content-Type: "));
        
// 94
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$81;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) output)) {
          try {
            append$val$81 = output.append (string$22);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$81 = output.append (string$22);
        }
// 95
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$82;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) output)) {
          try {
            append$val$82 = output.append (content);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$82 = output.append (content);
        }
// 96
        JP.go.ipa.oz.lib.standard._String_if string$23 = (new JP.go.ipa.oz.lib.standard._String_cl("\n\n"));
        
// 96
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$83;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) output)) {
          try {
            append$val$83 = output.append (string$23);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$83 = output.append (string$23);
        }
      }
    }
  }
  
  public JP.go.ipa.oz.lib.standard._ByteArray_if binaryData () throws Exception  {
    checkSecureInvocation ();
// 259
    return binary_data;
  }
  
  public void endOutput () throws Exception  {
    checkSecureInvocation ();
// 243
    /* for loop starting here */ {
      /* initialization part */
      int i = 0;
// 243
      int size$val$84;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) starting_tags)) {
        try {
          size$val$84 = starting_tags.size ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        size$val$84 = starting_tags.size ();
      }
      int size = size$val$84;
      
      for (;;) {
        /* boolean expression part */
        if (!(i < size)) break;
        
        /* body */ _loop_1: {
// 244
          endTag ();
        }
        /* iteration part */
// 243
        i++;
      }
    }
  }
  
  public JP.go.ipa.oz.lib.standard._String_if output () throws Exception  {
    checkSecureInvocation ();
// 252
    JP.go.ipa.oz.lib.standard._String_if asString$val$85;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) output)) {
      try {
        asString$val$85 = output.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$85 = output.asString ();
    }
// 252
    return asString$val$85;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getRequestID () throws Exception  {
    checkSecureInvocation ();
// 266
    return request_id;
  }
  
  void parse_multipart (JP.go.ipa.oz.lib.standard._InputStream_if input) throws Exception  {
// 324
    JP.go.ipa.oz.lib.standard._BufferedInputStream_if is = (JP.go.ipa.oz.lib.standard._BufferedInputStream_cl) (new JP.go.ipa.oz.lib.standard._BufferedInputStream_cl ())._new_breed (input);
// 325
    JP.go.ipa.oz.lib.standard._String_if read_one_line$val$86;
    read_one_line$val$86 = read_one_line (is);
// 325
    JP.go.ipa.oz.lib.standard._String_if trim$val$87;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) read_one_line$val$86)) {
      try {
        trim$val$87 = read_one_line$val$86.trim ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      trim$val$87 = read_one_line$val$86.trim ();
    }
// 325
    JP.go.ipa.oz.lib.standard._String_if delimiter = trim$val$87;
// 327
    JP.go.ipa.oz.lib.standard._System_if sys = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 328
    JP.go.ipa.oz.lib.standard._String_if string$24 = (new JP.go.ipa.oz.lib.standard._String_cl("delimiter"));
    
// 328
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
      try {
        sys.debugPrintln (string$24);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      sys.debugPrintln (string$24);
    }
// 329
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
      try {
        sys.debugPrintln (delimiter);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      sys.debugPrintln (delimiter);
    }
// 331
    while (true) {
      /* body */ _loop_1: {
// 332
        JP.go.ipa.oz.lib.standard._String_if label = null;
// 333
        boolean file_data = false;
// 335
        JP.go.ipa.oz.lib.standard._String_if read_one_line$val$88;
        read_one_line$val$88 = read_one_line (is);
// 335
        JP.go.ipa.oz.lib.standard._String_if trim$val$89;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) read_one_line$val$88)) {
          try {
            trim$val$89 = read_one_line$val$88.trim ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          trim$val$89 = read_one_line$val$88.trim ();
        }
// 335
        JP.go.ipa.oz.lib.standard._String_if one_line = trim$val$89;
// 336
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
          try {
            sys.debugPrintln (one_line);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          sys.debugPrintln (one_line);
        }
// 338
        int indexOf$val$90;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) one_line)) {
          try {
            indexOf$val$90 = one_line.indexOf (';');
          } finally {
            changeRunningToGreen ();
          }
        } else {
          indexOf$val$90 = one_line.indexOf (';');
        }
// 338
        int prev_semi = indexOf$val$90;
// 339
        while (true) {
          /* body */ _loop_2: {
// 341
            int indexOf$val$91;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) one_line)) {
              try {
                indexOf$val$91 = one_line.indexOf (';', prev_semi + 1);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              indexOf$val$91 = one_line.indexOf (';', prev_semi + 1);
            }
// 341
            int next_semi = indexOf$val$91;
// 343
            JP.go.ipa.oz.lib.standard._String_if item = null;
// 344
            if (next_semi == -1) {
// 345
              JP.go.ipa.oz.lib.standard._String_if substring$val$92;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) one_line)) {
                try {
                  substring$val$92 = one_line.substring (prev_semi + 2);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                substring$val$92 = one_line.substring (prev_semi + 2);
              }
// 345
              item = substring$val$92;
            } else {
// 347
              JP.go.ipa.oz.lib.standard._String_if substring$val$93;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) one_line)) {
                try {
                  substring$val$93 = one_line.substring (prev_semi + 2, next_semi);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                substring$val$93 = one_line.substring (prev_semi + 2, next_semi);
              }
// 347
              item = substring$val$93;
            }
// 349
            JP.go.ipa.oz.lib.standard._String_if string$25 = (new JP.go.ipa.oz.lib.standard._String_cl("item"));
            
// 349
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
              try {
                sys.debugPrintln (string$25);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              sys.debugPrintln (string$25);
            }
// 350
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
              try {
                sys.debugPrintln (item);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              sys.debugPrintln (item);
            }
// 352
            int indexOf$val$94;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) item)) {
              try {
                indexOf$val$94 = item.indexOf ('=');
              } finally {
                changeRunningToGreen ();
              }
            } else {
              indexOf$val$94 = item.indexOf ('=');
            }
// 352
            int equal = indexOf$val$94;
// 353
            JP.go.ipa.oz.lib.standard._String_if substring$val$95;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) item)) {
              try {
                substring$val$95 = item.substring (0, equal);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              substring$val$95 = item.substring (0, equal);
            }
// 353
            JP.go.ipa.oz.lib.standard._String_if name = substring$val$95;
// 354
            int length$val$96;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) item)) {
              try {
                length$val$96 = item.length ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              length$val$96 = item.length ();
            }
// 354
            JP.go.ipa.oz.lib.standard._String_if substring$val$97;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) item)) {
              try {
                substring$val$97 = item.substring (equal + 2, length$val$96 - 1);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              substring$val$97 = item.substring (equal + 2, length$val$96 - 1);
            }
// 354
            JP.go.ipa.oz.lib.standard._String_if value = substring$val$97;
// 356
            if (label == null) {
// 357
              label = value;
            } else {{
// 359
                JP.go.ipa.oz.lib.standard._String_if concat$val$98;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) label)) {
                  try {
                    concat$val$98 = label.concat (name);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  concat$val$98 = label.concat (name);
                }
// 359
                JP.go.ipa.oz.lib.standard._String_if decode$val$99;
                decode$val$99 = decode (value);
// 359
                JP.go.ipa.oz.lib.standard._Dictionary_if put$val$100;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) input_data)) {
                  try {
                    put$val$100 = input_data.put (concat$val$98, decode$val$99);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  put$val$100 = input_data.put (concat$val$98, decode$val$99);
                }
// 360
                file_data = true;
              }
            }
// 363
            if (next_semi == -1) {
// 363
              break;
            }
// 365
            prev_semi = next_semi;
          }
        }
// 368
        if (file_data) {{
// 370
            JP.go.ipa.oz.lib.standard._String_if read_file_data$val$101;
            read_file_data$val$101 = read_file_data (is, label, delimiter);
// 371
            JP.go.ipa.oz.lib.standard._String_if read_one_line$val$102;
            read_one_line$val$102 = read_one_line (is);
// 370
            JP.go.ipa.oz.lib.standard._String_if concat$val$103;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) read_file_data$val$101)) {
              try {
                concat$val$103 = read_file_data$val$101.concat (read_one_line$val$102);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              concat$val$103 = read_file_data$val$101.concat (read_one_line$val$102);
            }
// 370
            JP.go.ipa.oz.lib.standard._String_if trim$val$104;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$103)) {
              try {
                trim$val$104 = concat$val$103.trim ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              trim$val$104 = concat$val$103.trim ();
            }
// 369
            one_line = trim$val$104;
          }
        } else {{
// 373
            read_one_value (is, label);
// 374
            JP.go.ipa.oz.lib.standard._String_if read_one_line$val$105;
            read_one_line$val$105 = read_one_line (is);
// 374
            JP.go.ipa.oz.lib.standard._String_if trim$val$106;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) read_one_line$val$105)) {
              try {
                trim$val$106 = read_one_line$val$105.trim ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              trim$val$106 = read_one_line$val$105.trim ();
            }
// 374
            one_line = trim$val$106;
          }
        }
// 377
        JP.go.ipa.oz.lib.standard._String_if string$26 = (new JP.go.ipa.oz.lib.standard._String_cl("--"));
        
// 377
        JP.go.ipa.oz.lib.standard._String_if concat$val$107;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) delimiter)) {
          try {
            concat$val$107 = delimiter.concat (string$26);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          concat$val$107 = delimiter.concat (string$26);
        }
// 377
        boolean startsWith$val$108;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) one_line)) {
          try {
            startsWith$val$108 = one_line.startsWith (concat$val$107);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          startsWith$val$108 = one_line.startsWith (concat$val$107);
        }
// 377
        if (startsWith$val$108) {
// 378
          break;
        }
      }
    }
  }
  
  JP.go.ipa.oz.lib.standard._String_if read_file_data (JP.go.ipa.oz.lib.standard._InputStream_if is, JP.go.ipa.oz.lib.standard._String_if label, JP.go.ipa.oz.lib.standard._String_if delimiter) throws Exception  {
// 402
    JP.go.ipa.oz.lib.standard._String_if tmp_file = createPath ((new JP.go.ipa.oz.lib.standard._String_cl("file")));
// 403
    JP.go.ipa.oz.lib.standard._File_if f = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (tmp_file);
// 406
    JP.go.ipa.oz.lib.standard._FileOutputStream_if out = (JP.go.ipa.oz.lib.standard._FileOutputStream_cl) (new JP.go.ipa.oz.lib.standard._FileOutputStream_cl ())._new_breed (f);
// 407
    skip_header (is);
// 409
    int length$val$109;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) delimiter)) {
      try {
        length$val$109 = delimiter.length ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      length$val$109 = delimiter.length ();
    }
// 409
    int len = length$val$109;
// 410
    JP.go.ipa.oz.lib.standard._ByteArray_if buf = (JP.go.ipa.oz.lib.standard._ByteArray_cl) (new JP.go.ipa.oz.lib.standard._ByteArray_cl ())._new_create (len);
// 413
    int last_cr = 0, last_lf = 0;
// 414
    JP.go.ipa.oz.lib.standard._String_if end = null;
// 416
    while (true) {
      /* body */ _loop_1: {
// 417
        int i = 0, b = 0;
// 420
        /* for loop starting here */ {
          /* initialization part */
// 420
          i = 0;
          
          for (;;) {
            /* boolean expression part */
            if (!(i < len)) break;
            
            /* body */ _loop_2: {
// 421
              int read$val$110;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) is)) {
                try {
                  read$val$110 = is.read ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                read$val$110 = is.read ();
              }
// 421
              b = read$val$110;
              boolean bool$val$3;
              
              bool$val$3 = b == 0x0a;
              if (!bool$val$3) {
                bool$val$3 = b == 0x0d;
              }
// 423
              if (bool$val$3) {
// 423
                break;
              }
// 425
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
                try {
                  buf.setAt (i, b);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                buf.setAt (i, b);
              }
            }
            /* iteration part */
// 420
            i++;
          }
        }
// 429
        if (i == len) {{
// 430
            end = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed (buf);
// 431
            if (end.startsWith (delimiter)) {
// 431
              break;
            }
          }
        }
        boolean bool$val$4;
        
        bool$val$4 = last_cr != 0;
        if (bool$val$4) {
          boolean bool$val$5;
          
          bool$val$5 = i > 0;
          if (!bool$val$5) {
            bool$val$5 = b != 0x0a;
          }
          bool$val$4 = (bool$val$5);
        }
// 435
        if (bool$val$4) {{
// 436
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) out)) {
              try {
                out.write (last_cr);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              out.write (last_cr);
            }
// 437
            last_cr = 0;
          }
        }
// 439
        if (last_lf != 0) {{
// 440
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) out)) {
              try {
                out.write (last_lf);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              out.write (last_lf);
            }
// 441
            last_lf = 0;
          }
        }
// 444
        if (b == 0x0d) {
// 445
          last_cr = b;
        } else {
// 446
          if (b == 0x0a) {
// 447
            last_lf = b;
          }
        }
// 449
        if (i > 0) {
// 450
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) out)) {
            try {
              out.write (buf, 0, i);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            out.write (buf, 0, i);
          }
        }
      }
    }
// 453
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) out)) {
      try {
        out.close ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      out.close ();
    }
// 456
    int size = 0;
// 457
    long length$val$111;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) f)) {
      try {
        length$val$111 = f.length ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      length$val$111 = f.length ();
    }
// 457
    size = (int) (length$val$111);
// 458
    buf = (JP.go.ipa.oz.lib.standard._ByteArray_cl) (new JP.go.ipa.oz.lib.standard._ByteArray_cl ())._new_create (size);
// 459
    JP.go.ipa.oz.lib.standard._FileInputStream_if fin = (JP.go.ipa.oz.lib.standard._FileInputStream_cl) (new JP.go.ipa.oz.lib.standard._FileInputStream_cl ())._new_breed (f);
// 460
    int read$val$112;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fin)) {
      try {
        read$val$112 = fin.read (buf, 0, size);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      read$val$112 = fin.read (buf, 0, size);
    }
// 461
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fin)) {
      try {
        fin.close ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      fin.close ();
    }
// 462
    boolean delete$val$113;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) f)) {
      try {
        delete$val$113 = f.delete ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      delete$val$113 = f.delete ();
    }
// 464
    JP.go.ipa.oz.lib.standard._Dictionary_if put$val$114;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) input_data)) {
      try {
        put$val$114 = input_data.put (label, buf);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      put$val$114 = input_data.put (label, buf);
    }
// 466
    return end;
  }
  
  public void endTag () throws Exception  {
    checkSecureInvocation ();
// 226
    JP.go.ipa.oz.lib.standard._String_if tag = null;
// 228
    JP.go.ipa.oz.lang._Root_if first$val$115;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) starting_tags)) {
      try {
        first$val$115 = starting_tags.first ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      first$val$115 = starting_tags.first ();
    }
// 228
    tag = (JP.go.ipa.oz.lib.standard._String_if) (first$val$115);
// 230
    if (tag == null) {
// 230
      return;
    }
// 232
    JP.go.ipa.oz.lib.standard._SList_if popFront$val$116;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) starting_tags)) {
      try {
        popFront$val$116 = starting_tags.popFront ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      popFront$val$116 = starting_tags.popFront ();
    }
// 234
    JP.go.ipa.oz.lib.standard._String_if string$27 = (new JP.go.ipa.oz.lib.standard._String_cl("</"));
    
// 234
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$117;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) output)) {
      try {
        append$val$117 = output.append (string$27);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$117 = output.append (string$27);
    }
// 235
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$118;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) output)) {
      try {
        append$val$118 = output.append (tag);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$118 = output.append (tag);
    }
// 236
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$119;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) output)) {
      try {
        append$val$119 = output.append ('>');
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$119 = output.append ('>');
    }
  }
  
  public void addTag (JP.go.ipa.oz.lib.standard._String_if tag) throws Exception  {
    checkSecureInvocation ();
// 162
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$120;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) output)) {
      try {
        append$val$120 = output.append ('<');
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$120 = output.append ('<');
    }
// 163
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$121;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) output)) {
      try {
        append$val$121 = output.append (tag);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$121 = output.append (tag);
    }
// 164
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$122;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) output)) {
      try {
        append$val$122 = output.append ('>');
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$122 = output.append ('>');
    }
  }
  
  void read_one_value (JP.go.ipa.oz.lib.standard._InputStream_if is, JP.go.ipa.oz.lib.standard._String_if label) throws Exception  {
// 389
    skip_header (is);
// 391
    JP.go.ipa.oz.lib.standard._String_if read_one_line$val$123;
    read_one_line$val$123 = read_one_line (is);
// 391
    JP.go.ipa.oz.lib.standard._String_if trim$val$124;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) read_one_line$val$123)) {
      try {
        trim$val$124 = read_one_line$val$123.trim ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      trim$val$124 = read_one_line$val$123.trim ();
    }
// 391
    JP.go.ipa.oz.lib.standard._Dictionary_if put$val$125;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) input_data)) {
      try {
        put$val$125 = input_data.put (label, trim$val$124);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      put$val$125 = input_data.put (label, trim$val$124);
    }
  }
  
  public HTMLData_cl () throws Exception { super (); }
  
}

