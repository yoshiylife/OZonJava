package JP.go.ipa.oz.user.inter.wwps;

public class BrowseComponentThread_cl extends JP.go.ipa.oz.user.inter.cgi.ExecuteThread_cl implements JP.go.ipa.oz.user.inter.wwps.BrowseComponentThread_if {
  
  public Object _new_create (JP.go.ipa.oz.user.inter.cgi.OzCGI_if c, JP.go.ipa.oz.user.inter.cgi.HTMLData_if h) throws Exception  {
// 516
    super._new_create (c, h);
    return this;
  }
  
  void create_list (JP.go.ipa.oz.user.garage.SubjectGarage_if catalog, JP.go.ipa.oz.lib.standard._String_if catalog_name) throws Exception  {
// 440
    JP.go.ipa.oz.lib.standard._Iterator_if it = null;
// 441
    try {
// 442
      JP.go.ipa.oz.lib.standard._Iterator_if summaryIterator$val$143;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) catalog)) {
        try {
          summaryIterator$val$143 = catalog.summaryIterator ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        summaryIterator$val$143 = catalog.summaryIterator ();
      }
// 442
      it = summaryIterator$val$143;
    }
    catch (JP.go.ipa.oz.system.ExCellNotFoundException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 444
      JP.go.ipa.oz.lib.standard._String_if string$54 = (new JP.go.ipa.oz.lib.standard._String_cl("cannot found catalog: "));
      
// 444
      JP.go.ipa.oz.lib.standard._String_if concat$val$144;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$54)) {
        try {
          concat$val$144 = string$54.concat (catalog_name);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        concat$val$144 = string$54.concat (catalog_name);
      }
// 444
      sendResult (concat$val$144);
// 445
      return;
    }
// 448
    JP.go.ipa.oz.lib.standard._String_if string$55 = (new JP.go.ipa.oz.lib.standard._String_cl("text/html"));
    
// 448
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.startOutput (string$55);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.startOutput (string$55);
    }
// 449
    JP.go.ipa.oz.lib.standard._String_if string$56 = (new JP.go.ipa.oz.lib.standard._String_cl("html"));
    
// 449
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.beginTag (string$56);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.beginTag (string$56);
    }
// 450
    JP.go.ipa.oz.lib.standard._String_if string$57 = (new JP.go.ipa.oz.lib.standard._String_cl("head"));
    
// 450
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.beginTag (string$57);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.beginTag (string$57);
    }
// 451
    JP.go.ipa.oz.lib.standard._String_if string$58 = (new JP.go.ipa.oz.lib.standard._String_cl("title"));
    
// 451
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.beginTag (string$58);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.beginTag (string$58);
    }
// 452
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.addOutput (catalog_name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.addOutput (catalog_name);
    }
// 453
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.endTag ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.endTag ();
    }
// 454
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.endTag ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.endTag ();
    }
// 456
    JP.go.ipa.oz.lib.standard._String_if string$59 = (new JP.go.ipa.oz.lib.standard._String_cl("body"));
    
// 456
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.beginTag (string$59);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.beginTag (string$59);
    }
// 458
    JP.go.ipa.oz.lib.standard._String_if string$60 = (new JP.go.ipa.oz.lib.standard._String_cl("h1"));
    
// 458
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.beginTag (string$60);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.beginTag (string$60);
    }
// 459
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.addOutput (catalog_name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.addOutput (catalog_name);
    }
// 460
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.endTag ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.endTag ();
    }
// 462
    JP.go.ipa.oz.lib.standard._String_if string$61 = (new JP.go.ipa.oz.lib.standard._String_cl("dl"));
    
// 462
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.beginTag (string$61);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.beginTag (string$61);
    }
// 464
    while (true) {
// 464
      boolean hasMoreElements$val$145;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
        try {
          hasMoreElements$val$145 = it.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$145 = it.hasMoreElements ();
      }
      if (!(hasMoreElements$val$145)) break;
      
      /* body */ _loop_1: {
// 465
        JP.go.ipa.oz.user.ide.SubjectSummary_if summary = null;
// 466
        JP.go.ipa.oz.lang._Root_if nextElement$val$146;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
          try {
            nextElement$val$146 = it.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$146 = it.nextElement ();
        }
// 466
        summary = (JP.go.ipa.oz.user.ide.SubjectSummary_if) (nextElement$val$146);
// 468
        JP.go.ipa.oz.lib.standard._String_if getName$val$147;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summary)) {
          try {
            getName$val$147 = summary.getName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getName$val$147 = summary.getName ();
        }
// 468
        JP.go.ipa.oz.lib.standard._String_if name = getName$val$147;
// 469
        if (name == null) {
// 469
          break _loop_1;
        }
// 471
        JP.go.ipa.oz.lib.standard._String_if string$62 = (new JP.go.ipa.oz.lib.standard._String_cl("dt"));
        
// 471
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
          try {
            html.addTag (string$62);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          html.addTag (string$62);
        }
// 473
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
          try {
            html.addOutput (name);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          html.addOutput (name);
        }
// 474
        JP.go.ipa.oz.lib.standard._String_if string$63 = (new JP.go.ipa.oz.lib.standard._String_cl(" "));
        
// 474
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
          try {
            html.addOutput (string$63);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          html.addOutput (string$63);
        }
// 475
        JP.go.ipa.oz.lib.standard._StringBuffer_if buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("a href=\"oz.cgi?.formId=WWPS_COMPONENT&command=browse_subject&mode=look&subject=")));
// 476
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$148;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$148 = buf.append (name);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$148 = buf.append (name);
        }
// 477
        JP.go.ipa.oz.lib.standard._String_if string$64 = (new JP.go.ipa.oz.lib.standard._String_cl("&key="));
        
// 477
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$149;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$149 = buf.append (string$64);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$149 = buf.append (string$64);
        }
// 478
        JP.go.ipa.oz.user.garage.Key_if getKey$val$150;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summary)) {
          try {
            getKey$val$150 = summary.getKey ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getKey$val$150 = summary.getKey ();
        }
// 478
        JP.go.ipa.oz.lib.standard._String_if asString$val$151;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getKey$val$150)) {
          try {
            asString$val$151 = getKey$val$150.asString ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          asString$val$151 = getKey$val$150.asString ();
        }
// 478
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$152;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$152 = buf.append (asString$val$151);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$152 = buf.append (asString$val$151);
        }
// 479
        JP.go.ipa.oz.lib.standard._String_if string$65 = (new JP.go.ipa.oz.lib.standard._String_cl("&catalog="));
        
// 479
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$153;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$153 = buf.append (string$65);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$153 = buf.append (string$65);
        }
// 480
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$154;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$154 = buf.append (catalog_name);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$154 = buf.append (catalog_name);
        }
// 481
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$155;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$155 = buf.append ('\"');
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$155 = buf.append ('\"');
        }
// 482
        JP.go.ipa.oz.lib.standard._String_if asString$val$156;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            asString$val$156 = buf.asString ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          asString$val$156 = buf.asString ();
        }
// 482
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
          try {
            html.beginTag (asString$val$156);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          html.beginTag (asString$val$156);
        }
// 483
        JP.go.ipa.oz.lib.standard._String_if string$66 = (new JP.go.ipa.oz.lib.standard._String_cl("Look"));
        
// 483
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
          try {
            html.addOutput (string$66);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          html.addOutput (string$66);
        }
// 484
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
          try {
            html.endTag ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          html.endTag ();
        }
// 485
        JP.go.ipa.oz.lib.standard._String_if string$67 = (new JP.go.ipa.oz.lib.standard._String_cl(" "));
        
// 485
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
          try {
            html.addOutput (string$67);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          html.addOutput (string$67);
        }
// 486
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            buf.setLength (0);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          buf.setLength (0);
        }
// 487
        buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("a href=\"oz.cgi?.formId=WWPS_COMPONENT&command=browse_subject&mode=get&subject=")));
// 488
        buf.append (name);
// 489
        buf.append ((new JP.go.ipa.oz.lib.standard._String_cl("&key=")));
// 490
        JP.go.ipa.oz.user.garage.Key_if getKey$val$157;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summary)) {
          try {
            getKey$val$157 = summary.getKey ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getKey$val$157 = summary.getKey ();
        }
// 490
        JP.go.ipa.oz.lib.standard._String_if asString$val$158;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getKey$val$157)) {
          try {
            asString$val$158 = getKey$val$157.asString ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          asString$val$158 = getKey$val$157.asString ();
        }
// 490
        buf.append (asString$val$158);
// 491
        buf.append ((new JP.go.ipa.oz.lib.standard._String_cl("&catalog=")));
// 492
        buf.append (catalog_name);
// 493
        buf.append ('\"');
// 494
        JP.go.ipa.oz.lib.standard._String_if asString$val$159;
        asString$val$159 = buf.asString ();
// 494
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
          try {
            html.beginTag (asString$val$159);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          html.beginTag (asString$val$159);
        }
// 495
        JP.go.ipa.oz.lib.standard._String_if string$68 = (new JP.go.ipa.oz.lib.standard._String_cl("Get"));
        
// 495
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
          try {
            html.addOutput (string$68);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          html.addOutput (string$68);
        }
// 496
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
          try {
            html.endTag ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          html.endTag ();
        }
// 498
        JP.go.ipa.oz.lib.standard._String_if string$69 = (new JP.go.ipa.oz.lib.standard._String_cl("dd"));
        
// 498
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
          try {
            html.addTag (string$69);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          html.addTag (string$69);
        }
// 499
        JP.go.ipa.oz.lib.standard._String_if getDescription$val$160;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summary)) {
          try {
            getDescription$val$160 = summary.getDescription ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getDescription$val$160 = summary.getDescription ();
        }
// 499
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
          try {
            html.addOutput (getDescription$val$160);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          html.addOutput (getDescription$val$160);
        }
      }
    }
// 502
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.endTag ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.endTag ();
    }
// 503
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.endTag ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.endTag ();
    }
// 504
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.endOutput ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.endOutput ();
    }
// 506
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cgi)) {
      try {
        cgi.sendResult (html);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      cgi.sendResult (html);
    }
  }
  
  void create_list (JP.go.ipa.oz.user.garage.SubjectGarage_if catalog, JP.go.ipa.oz.lib.standard._String_if catalog_name, JP.go.ipa.oz.lib.standard._String_if subject_name) throws Exception  {
// 339
    JP.go.ipa.oz.lib.standard._String_if sbj_key = null;
// 340
    JP.go.ipa.oz.lib.standard._String_if string$70 = (new JP.go.ipa.oz.lib.standard._String_cl("key"));
    
// 340
    JP.go.ipa.oz.lang._Root_if getValue$val$161;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        getValue$val$161 = html.getValue (string$70);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getValue$val$161 = html.getValue (string$70);
    }
// 340
    sbj_key = (JP.go.ipa.oz.lib.standard._String_if) (getValue$val$161);
// 341
    int parseInt$val$162;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbj_key)) {
      try {
        parseInt$val$162 = sbj_key.parseInt ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      parseInt$val$162 = sbj_key.parseInt ();
    }
// 341
    JP.go.ipa.oz.user.garage.Key_if key = (JP.go.ipa.oz.user.garage.Key_cl) (new JP.go.ipa.oz.user.garage.Key_cl ())._new_create (parseInt$val$162);
// 343
    JP.go.ipa.oz.user.ide.Subject_if sbj = null;
// 345
    try {
// 346
      JP.go.ipa.oz.user.ide.Subject_if getSubject$val$163;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) catalog)) {
        try {
          getSubject$val$163 = catalog.getSubject (key);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getSubject$val$163 = catalog.getSubject (key);
      }
// 346
      sbj = getSubject$val$163;
    }
    catch (JP.go.ipa.oz.system.ExCellNotFoundException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 348
      JP.go.ipa.oz.lib.standard._String_if string$71 = (new JP.go.ipa.oz.lib.standard._String_cl("cannot found catalog: "));
      
// 348
      JP.go.ipa.oz.lib.standard._String_if concat$val$164;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$71)) {
        try {
          concat$val$164 = string$71.concat (catalog_name);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        concat$val$164 = string$71.concat (catalog_name);
      }
// 348
      sendResult (concat$val$164);
// 349
      return;
    }
// 352
    JP.go.ipa.oz.lib.standard._String_if mode = null;
// 353
    JP.go.ipa.oz.lib.standard._String_if string$72 = (new JP.go.ipa.oz.lib.standard._String_cl("mode"));
    
// 353
    JP.go.ipa.oz.lang._Root_if getValue$val$165;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        getValue$val$165 = html.getValue (string$72);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getValue$val$165 = html.getValue (string$72);
    }
// 353
    mode = (JP.go.ipa.oz.lib.standard._String_if) (getValue$val$165);
// 355
    boolean send_file = false;
// 356
    JP.go.ipa.oz.lib.standard._String_if string$73 = (new JP.go.ipa.oz.lib.standard._String_cl("get"));
    
// 356
    boolean isequal$val$166;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) mode)) {
      try {
        isequal$val$166 = mode.isequal (string$73);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$166 = mode.isequal (string$73);
    }
// 356
    if (isequal$val$166) {
// 357
      send_file = true;
    }
// 359
    JP.go.ipa.oz.lib.standard._String_if file_name = null, school_file = null;
// 360
    JP.go.ipa.oz.lib.standard._FileWriter_if file = null;
// 361
    if (send_file) {{
// 362
        JP.go.ipa.oz.lib.standard._String_if string$74 = (new JP.go.ipa.oz.lib.standard._String_cl(".s"));
        
// 362
        JP.go.ipa.oz.lib.standard._String_if concat$val$167;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject_name)) {
          try {
            concat$val$167 = subject_name.concat (string$74);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          concat$val$167 = subject_name.concat (string$74);
        }
// 362
        file_name = concat$val$167;
// 363
        school_file = createPath (file_name);
// 364
        file = (JP.go.ipa.oz.lib.standard._FileWriter_cl) (new JP.go.ipa.oz.lib.standard._FileWriter_cl ())._new_breed (school_file);
      }
    } else {{
// 366
        JP.go.ipa.oz.lib.standard._String_if string$75 = (new JP.go.ipa.oz.lib.standard._String_cl("text/html"));
        
// 366
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
          try {
            html.startOutput (string$75);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          html.startOutput (string$75);
        }
// 367
        JP.go.ipa.oz.lib.standard._String_if string$76 = (new JP.go.ipa.oz.lib.standard._String_cl("html"));
        
// 367
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
          try {
            html.beginTag (string$76);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          html.beginTag (string$76);
        }
// 368
        JP.go.ipa.oz.lib.standard._String_if string$77 = (new JP.go.ipa.oz.lib.standard._String_cl("head"));
        
// 368
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
          try {
            html.beginTag (string$77);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          html.beginTag (string$77);
        }
// 369
        JP.go.ipa.oz.lib.standard._String_if string$78 = (new JP.go.ipa.oz.lib.standard._String_cl("title"));
        
// 369
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
          try {
            html.beginTag (string$78);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          html.beginTag (string$78);
        }
// 370
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
          try {
            html.addOutput (subject_name);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          html.addOutput (subject_name);
        }
// 371
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
          try {
            html.endTag ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          html.endTag ();
        }
// 372
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
          try {
            html.endTag ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          html.endTag ();
        }
// 374
        JP.go.ipa.oz.lib.standard._String_if string$79 = (new JP.go.ipa.oz.lib.standard._String_cl("body"));
        
// 374
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
          try {
            html.beginTag (string$79);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          html.beginTag (string$79);
        }
// 376
        JP.go.ipa.oz.lib.standard._String_if string$80 = (new JP.go.ipa.oz.lib.standard._String_cl("h1"));
        
// 376
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
          try {
            html.beginTag (string$80);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          html.beginTag (string$80);
        }
// 377
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
          try {
            html.addOutput (subject_name);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          html.addOutput (subject_name);
        }
// 378
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
          try {
            html.endTag ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          html.endTag ();
        }
// 380
        JP.go.ipa.oz.lib.standard._String_if getPackageName$val$168;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbj)) {
          try {
            getPackageName$val$168 = sbj.getPackageName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getPackageName$val$168 = sbj.getPackageName ();
        }
// 380
        JP.go.ipa.oz.lib.standard._String_if pakage = getPackageName$val$168;
// 381
        JP.go.ipa.oz.lib.standard._String_if string$81 = (new JP.go.ipa.oz.lib.standard._String_cl("h3"));
        
// 381
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
          try {
            html.beginTag (string$81);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          html.beginTag (string$81);
        }
// 382
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
          try {
            html.addOutput (pakage);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          html.addOutput (pakage);
        }
// 383
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
          try {
            html.endTag ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          html.endTag ();
        }
// 385
        JP.go.ipa.oz.lib.standard._String_if string$82 = (new JP.go.ipa.oz.lib.standard._String_cl("pre"));
        
// 385
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
          try {
            html.beginTag (string$82);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          html.beginTag (string$82);
        }
      }
    }
// 388
    JP.go.ipa.oz.lib.standard._Dictionary_if getOzLabels$val$169;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbj)) {
      try {
        getOzLabels$val$169 = sbj.getOzLabels ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzLabels$val$169 = sbj.getOzLabels ();
    }
// 388
    JP.go.ipa.oz.lib.standard._Dictionary_if labels = getOzLabels$val$169;
// 389
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$170;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) labels)) {
      try {
        iterator$val$170 = labels.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$170 = labels.iterator ();
    }
// 389
    JP.go.ipa.oz.lib.standard._Iterator_if it = iterator$val$170;
// 390
    JP.go.ipa.oz.lib.standard._StringBuffer_if buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 391
    while (true) {
// 391
      boolean hasMoreElements$val$171;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
        try {
          hasMoreElements$val$171 = it.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$171 = it.hasMoreElements ();
      }
      if (!(hasMoreElements$val$171)) break;
      
      /* body */ _loop_1: {
// 392
        JP.go.ipa.oz.user.ide.OzLabel_if ozlabel = null;
// 393
        JP.go.ipa.oz.lang._Root_if nextElement$val$172;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
          try {
            nextElement$val$172 = it.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$172 = it.nextElement ();
        }
// 393
        ozlabel = (JP.go.ipa.oz.user.ide.OzLabel_if) (nextElement$val$172);
// 394
        JP.go.ipa.oz.lib.standard._String_if getOzLabelName$val$173;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozlabel)) {
          try {
            getOzLabelName$val$173 = ozlabel.getOzLabelName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getOzLabelName$val$173 = ozlabel.getOzLabelName ();
        }
// 394
        JP.go.ipa.oz.lib.standard._String_if label = getOzLabelName$val$173;
// 395
        JP.go.ipa.oz.lib.standard._String_if getInterfaceID$val$174;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozlabel)) {
          try {
            getInterfaceID$val$174 = ozlabel.getInterfaceID ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getInterfaceID$val$174 = ozlabel.getInterfaceID ();
        }
// 395
        JP.go.ipa.oz.lib.standard._String_if if_id = getInterfaceID$val$174;
// 396
        JP.go.ipa.oz.lib.standard._String_if getImplementationID$val$175;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozlabel)) {
          try {
            getImplementationID$val$175 = ozlabel.getImplementationID ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getImplementationID$val$175 = ozlabel.getImplementationID ();
        }
// 396
        JP.go.ipa.oz.lib.standard._String_if impl_id = getImplementationID$val$175;
// 398
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$176;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$176 = buf.append ('\"');
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$176 = buf.append ('\"');
        }
// 399
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$177;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$177 = buf.append (label);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$177 = buf.append (label);
        }
// 400
        JP.go.ipa.oz.lib.standard._String_if string$83 = (new JP.go.ipa.oz.lib.standard._String_cl("\",\""));
        
// 400
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$178;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$178 = buf.append (string$83);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$178 = buf.append (string$83);
        }
// 401
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$179;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$179 = buf.append (if_id);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$179 = buf.append (if_id);
        }
// 402
        JP.go.ipa.oz.lib.standard._String_if string$84 = (new JP.go.ipa.oz.lib.standard._String_cl("\",\""));
        
// 402
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$180;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$180 = buf.append (string$84);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$180 = buf.append (string$84);
        }
// 403
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$181;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$181 = buf.append (impl_id);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$181 = buf.append (impl_id);
        }
// 404
        JP.go.ipa.oz.lib.standard._String_if string$85 = (new JP.go.ipa.oz.lib.standard._String_cl("\"\n"));
        
// 404
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$182;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$182 = buf.append (string$85);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$182 = buf.append (string$85);
        }
// 406
        if (send_file) {
// 407
          JP.go.ipa.oz.lib.standard._String_if asString$val$183;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
            try {
              asString$val$183 = buf.asString ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            asString$val$183 = buf.asString ();
          }
// 407
          int length$val$184;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
            try {
              length$val$184 = buf.length ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            length$val$184 = buf.length ();
          }
// 407
          file.write (asString$val$183, 0, length$val$184);
        } else {
// 409
          JP.go.ipa.oz.lib.standard._String_if asString$val$185;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
            try {
              asString$val$185 = buf.asString ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            asString$val$185 = buf.asString ();
          }
// 409
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
            try {
              html.addOutput (asString$val$185);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            html.addOutput (asString$val$185);
          }
        }
// 411
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            buf.setLength (0);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          buf.setLength (0);
        }
      }
    }
// 414
    if (send_file) {{
// 415
        file.close ();
// 417
        JP.go.ipa.oz.lib.standard._File_if f = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (school_file);
// 418
        JP.go.ipa.oz.lib.standard._FileInputStream_if in = (JP.go.ipa.oz.lib.standard._FileInputStream_cl) (new JP.go.ipa.oz.lib.standard._FileInputStream_cl ())._new_breed (f);
// 419
        int size = 0;
// 420
        long length$val$186;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) f)) {
          try {
            length$val$186 = f.length ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          length$val$186 = f.length ();
        }
// 420
        size = (int) (length$val$186);
// 421
        sendFile (in, file_name, size);
// 423
        boolean delete$val$187;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) f)) {
          try {
            delete$val$187 = f.delete ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          delete$val$187 = f.delete ();
        }
// 424
        JP.go.ipa.oz.lib.standard._String_if getParent$val$188;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) f)) {
          try {
            getParent$val$188 = f.getParent ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getParent$val$188 = f.getParent ();
        }
// 424
        (f = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (getParent$val$188)).delete ();
      }
    } else {{
// 426
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
          try {
            html.endTag ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          html.endTag ();
        }
// 427
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
          try {
            html.endTag ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          html.endTag ();
        }
// 428
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
          try {
            html.endOutput ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          html.endOutput ();
        }
// 429
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cgi)) {
          try {
            cgi.sendResult (html);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          cgi.sendResult (html);
        }
      }
    }
  }
  
  public void run () throws Exception  {
    checkSecureInvocation ();
// 318
    JP.go.ipa.oz.lib.standard._String_if catalog_name = null;
// 319
    JP.go.ipa.oz.lib.standard._String_if string$86 = (new JP.go.ipa.oz.lib.standard._String_cl("catalog"));
    
// 319
    JP.go.ipa.oz.lang._Root_if getValue$val$189;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        getValue$val$189 = html.getValue (string$86);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getValue$val$189 = html.getValue (string$86);
    }
// 319
    catalog_name = (JP.go.ipa.oz.lib.standard._String_if) (getValue$val$189);
// 320
    JP.go.ipa.oz.user.garage.SubjectGarage_if catalog = new JP.go.ipa.oz.user.garage.SubjectGarage_pcl (catalog_name);
// 322
    JP.go.ipa.oz.lib.standard._String_if subject_name = null;
// 323
    JP.go.ipa.oz.lib.standard._String_if string$87 = (new JP.go.ipa.oz.lib.standard._String_cl("subject"));
    
// 323
    JP.go.ipa.oz.lang._Root_if getValue$val$190;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        getValue$val$190 = html.getValue (string$87);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getValue$val$190 = html.getValue (string$87);
    }
// 323
    subject_name = (JP.go.ipa.oz.lib.standard._String_if) (getValue$val$190);
// 324
    if (subject_name == null) {
// 325
      create_list (catalog, catalog_name);
    } else {
// 327
      create_list (catalog, catalog_name, subject_name);
    }
  }
  
  public BrowseComponentThread_cl () throws Exception { super (); }
  
}

