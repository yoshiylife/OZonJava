package JP.go.ipa.oz.user.inter.cgi;

public class CGI_cl extends JP.go.ipa.oz.lang._Runnable_cl implements JP.go.ipa.oz.user.inter.cgi.CGI_if {
  JP.go.ipa.oz.user.inter.cgi.RandezvouTable_if input_randezvou_table;
  JP.go.ipa.oz.user.inter.cgi.RandezvouTable_if output_randezvou_table;
  int request_number;
  JP.go.ipa.oz.lib.standard._Socket_if socket;
  boolean test_mode;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._Socket_if s, int req_no, JP.go.ipa.oz.user.inter.cgi.RandezvouTable_if in_table, JP.go.ipa.oz.user.inter.cgi.RandezvouTable_if out_table, boolean test) throws Exception  {
// 394
    socket = s;
// 395
    request_number = req_no;
// 396
    input_randezvou_table = in_table;
// 397
    output_randezvou_table = out_table;
// 398
    test_mode = test;
    return this;
  }
  
  public void run () throws Exception  {
    checkSecureInvocation ();
// 305
    JP.go.ipa.oz.lib.standard._InputStream_if getInputStream$val$135;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) socket)) {
      try {
        getInputStream$val$135 = socket.getInputStream ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getInputStream$val$135 = socket.getInputStream ();
    }
// 305
    JP.go.ipa.oz.lib.standard._BufferedInputStream_if is = (JP.go.ipa.oz.lib.standard._BufferedInputStream_cl) (new JP.go.ipa.oz.lib.standard._BufferedInputStream_cl ())._new_breed (getInputStream$val$135);
// 307
    if (test_mode) {{
// 308
        JP.go.ipa.oz.lib.standard._InputStreamReader_if ir = (JP.go.ipa.oz.lib.standard._InputStreamReader_cl) (new JP.go.ipa.oz.lib.standard._InputStreamReader_cl ())._new_breed (is);
// 309
        JP.go.ipa.oz.lib.standard._BufferedReader_if br = (JP.go.ipa.oz.lib.standard._BufferedReader_cl) (new JP.go.ipa.oz.lib.standard._BufferedReader_cl ())._new_breed (ir);
// 310
        JP.go.ipa.oz.lib.standard._String_if readLine$val$136;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) br)) {
          try {
            readLine$val$136 = br.readLine ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          readLine$val$136 = br.readLine ();
        }
// 310
        JP.go.ipa.oz.lib.standard._String_if str = readLine$val$136;
// 312
        JP.go.ipa.oz.lib.standard._OutputStream_if getOutputStream$val$137;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) socket)) {
          try {
            getOutputStream$val$137 = socket.getOutputStream ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getOutputStream$val$137 = socket.getOutputStream ();
        }
// 312
        JP.go.ipa.oz.lib.standard._OutputStream_if os = getOutputStream$val$137;
// 313
        JP.go.ipa.oz.lib.standard._OutputStreamWriter_if ow = (JP.go.ipa.oz.lib.standard._OutputStreamWriter_cl) (new JP.go.ipa.oz.lib.standard._OutputStreamWriter_cl ())._new_breed (os);
// 314
        int length$val$138;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) str)) {
          try {
            length$val$138 = str.length ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          length$val$138 = str.length ();
        }
// 314
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ow)) {
          try {
            ow.write (str, 0, length$val$138);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          ow.write (str, 0, length$val$138);
        }
// 315
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ow)) {
          try {
            ow.flush ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          ow.flush ();
        }
// 317
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) socket)) {
          try {
            socket.close ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          socket.close ();
        }
// 318
        return;
      }
    }
// 322
    JP.go.ipa.oz.user.inter.cgi.HTMLData_if html = (JP.go.ipa.oz.user.inter.cgi.HTMLData_cl) (new JP.go.ipa.oz.user.inter.cgi.HTMLData_cl ())._new_create (is, request_number);
// 323
    JP.go.ipa.oz.lib.standard._String_if getFormID$val$139;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        getFormID$val$139 = html.getFormID ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getFormID$val$139 = html.getFormID ();
    }
// 323
    JP.go.ipa.oz.lib.standard._String_if form_id = getFormID$val$139;
// 326
    if (form_id == null) {{
// 328
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) socket)) {
          try {
            socket.close ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          socket.close ();
        }
// 330
        return;
      }
    }
// 336
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) input_randezvou_table)) {
      try {
        input_randezvou_table.signalRandezvouPoint (form_id, html);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      input_randezvou_table.signalRandezvouPoint (form_id, html);
    }
// 339
    JP.go.ipa.oz.user.inter.cgi.RandezvouPoint_if rp = null;
// 341
    JP.go.ipa.oz.lib.standard._String_if getRequestID$val$140;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        getRequestID$val$140 = html.getRequestID ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getRequestID$val$140 = html.getRequestID ();
    }
// 341
    rp = (JP.go.ipa.oz.user.inter.cgi.RandezvouPoint_cl) (new JP.go.ipa.oz.user.inter.cgi.RandezvouPoint_cl ())._new_create ();
    
// 340
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) output_randezvou_table)) {
      try {
        output_randezvou_table.registerRandezvouPoint (getRequestID$val$140, rp);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      output_randezvou_table.registerRandezvouPoint (getRequestID$val$140, rp);
    }
// 344
    JP.go.ipa.oz.lib.standard._OutputStream_if getOutputStream$val$141;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) socket)) {
      try {
        getOutputStream$val$141 = socket.getOutputStream ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOutputStream$val$141 = socket.getOutputStream ();
    }
// 344
    JP.go.ipa.oz.lib.standard._OutputStream_if os = getOutputStream$val$141;
// 345
    JP.go.ipa.oz.lib.standard._OutputStreamWriter_if ow = (JP.go.ipa.oz.lib.standard._OutputStreamWriter_cl) (new JP.go.ipa.oz.lib.standard._OutputStreamWriter_cl ())._new_breed (os);
// 346
    html = rp.getHtml ();
// 348
    JP.go.ipa.oz.lib.standard._String_if str = null;
// 350
    if (html == null) {{
// 351
        JP.go.ipa.oz.user.inter.cgi.HTMLData_if html$1 = (JP.go.ipa.oz.user.inter.cgi.HTMLData_cl) (new JP.go.ipa.oz.user.inter.cgi.HTMLData_cl ())._new_create ();
// 352
        JP.go.ipa.oz.lib.standard._String_if string$33 = (new JP.go.ipa.oz.lib.standard._String_cl("text/html"));
        
// 352
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html$1)) {
          try {
            html$1.startOutput (string$33);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          html$1.startOutput (string$33);
        }
// 353
        JP.go.ipa.oz.lib.standard._String_if string$34 = (new JP.go.ipa.oz.lib.standard._String_cl("html"));
        
// 353
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html$1)) {
          try {
            html$1.beginTag (string$34);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          html$1.beginTag (string$34);
        }
// 354
        JP.go.ipa.oz.lib.standard._String_if string$35 = (new JP.go.ipa.oz.lib.standard._String_cl("OZCGI server stopped."));
        
// 354
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html$1)) {
          try {
            html$1.addOutput (string$35);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          html$1.addOutput (string$35);
        }
// 355
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html$1)) {
          try {
            html$1.endOutput ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          html$1.endOutput ();
        }
// 356
        JP.go.ipa.oz.lib.standard._String_if output$val$142;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html$1)) {
          try {
            output$val$142 = html$1.output ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          output$val$142 = html$1.output ();
        }
// 356
        str = output$val$142;
      }
    } else {
// 358
      JP.go.ipa.oz.lib.standard._String_if output$val$143;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
        try {
          output$val$143 = html.output ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        output$val$143 = html.output ();
      }
// 358
      str = output$val$143;
    }
// 360
    JP.go.ipa.oz.lib.standard._System_if sys = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 361
    JP.go.ipa.oz.lib.standard._String_if string$36 = (new JP.go.ipa.oz.lib.standard._String_cl("sending data: "));
    
// 361
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
      try {
        sys.debugPrintln (string$36);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      sys.debugPrintln (string$36);
    }
// 362
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
      try {
        sys.debugPrintln (str);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      sys.debugPrintln (str);
    }
// 364
    int length$val$144;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) str)) {
      try {
        length$val$144 = str.length ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      length$val$144 = str.length ();
    }
// 364
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ow)) {
      try {
        ow.write (str, 0, length$val$144);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      ow.write (str, 0, length$val$144);
    }
// 365
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ow)) {
      try {
        ow.flush ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      ow.flush ();
    }
// 367
    if (html != null) {{
// 368
        JP.go.ipa.oz.lib.standard._ByteArray_if binaryData$val$145;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
          try {
            binaryData$val$145 = html.binaryData ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          binaryData$val$145 = html.binaryData ();
        }
// 368
        JP.go.ipa.oz.lib.standard._ByteArray_if buf = binaryData$val$145;
// 369
        if (buf != null) {{
// 370
            int length$val$146;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
              try {
                length$val$146 = buf.length ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              length$val$146 = buf.length ();
            }
// 370
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) os)) {
              try {
                os.write (buf, 0, length$val$146);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              os.write (buf, 0, length$val$146);
            }
          }
        }
      }
    }
// 374
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) os)) {
      try {
        os.flush ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      os.flush ();
    }
// 375
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) os)) {
      try {
        os.close ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      os.close ();
    }
// 378
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) socket)) {
      try {
        socket.close ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      socket.close ();
    }
  }
  
  public CGI_cl () throws Exception { super (); }
  
}

