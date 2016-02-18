package JP.go.ipa.oz.user.inter.cgi;

abstract public class ExecuteThread_cl extends JP.go.ipa.oz.lang._Runnable_cl implements JP.go.ipa.oz.user.inter.cgi.ExecuteThread_if {
  protected int operation_count;
  protected JP.go.ipa.oz.user.inter.cgi.HTMLData_if html;
  protected JP.go.ipa.oz.user.inter.cgi.OzCGI_if cgi;
  protected boolean test_mode;
  JP.go.ipa.oz.lib.standard._Array_if threads;
  
  public Object _new_create (JP.go.ipa.oz.user.inter.cgi.OzCGI_if c, JP.go.ipa.oz.user.inter.cgi.HTMLData_if h) throws Exception  {
// 616
    cgi = c;
// 617
    html = h;
// 619
    threads = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (10);
    return this;
  }
  
  protected JP.go.ipa.oz.lib.standard._String_if createPath (JP.go.ipa.oz.lib.standard._String_if base, JP.go.ipa.oz.lib.standard._String_if god) throws Exception  {
// 701
    JP.go.ipa.oz.lib.standard._System_if sys = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 702
    JP.go.ipa.oz.lib.standard._String_if getOzHome$val$156;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
      try {
        getOzHome$val$156 = sys.getOzHome ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzHome$val$156 = sys.getOzHome ();
    }
// 702
    JP.go.ipa.oz.lib.standard._String_if ozhome = getOzHome$val$156;
// 703
    JP.go.ipa.oz.lib.standard._String_if string$44 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
    
// 703
    boolean startsWith$val$157;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozhome)) {
      try {
        startsWith$val$157 = ozhome.startsWith (string$44);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      startsWith$val$157 = ozhome.startsWith (string$44);
    }
// 703
    char sep = startsWith$val$157 ? '/' : '\\';
// 704
    JP.go.ipa.oz.lib.standard._StringBuffer_if path = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (ozhome);
// 706
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$158;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
      try {
        append$val$158 = path.append (sep);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$158 = path.append (sep);
    }
// 707
    JP.go.ipa.oz.lib.standard._String_if string$45 = (new JP.go.ipa.oz.lib.standard._String_cl("objects"));
    
// 707
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$159;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
      try {
        append$val$159 = path.append (string$45);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$159 = path.append (string$45);
    }
// 709
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$160;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
      try {
        append$val$160 = path.append (sep);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$160 = path.append (sep);
    }
// 710
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$161;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
      try {
        append$val$161 = path.append (god);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$161 = path.append (god);
    }
// 711
    JP.go.ipa.oz.lib.standard._String_if getGOD$val$162;
    getGOD$val$162 = getGOD ();
// 711
    boolean isequal$val$163;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) god)) {
      try {
        isequal$val$163 = god.isequal (getGOD$val$162);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$163 = god.isequal (getGOD$val$162);
    }
// 711
    if (isequal$val$163) {{
// 712
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$164;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
          try {
            append$val$164 = path.append (sep);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$164 = path.append (sep);
        }
// 713
        JP.go.ipa.oz.lib.standard._String_if getRequestID$val$165;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
          try {
            getRequestID$val$165 = html.getRequestID ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getRequestID$val$165 = html.getRequestID ();
        }
// 713
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$166;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
          try {
            append$val$166 = path.append (getRequestID$val$165);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$166 = path.append (getRequestID$val$165);
        }
// 714
        JP.go.ipa.oz.lib.standard._String_if asString$val$167;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
          try {
            asString$val$167 = path.asString ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          asString$val$167 = path.asString ();
        }
// 714
        JP.go.ipa.oz.lib.standard._File_if dir = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (asString$val$167);
// 715
        boolean isDirectory$val$168;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dir)) {
          try {
            isDirectory$val$168 = dir.isDirectory ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isDirectory$val$168 = dir.isDirectory ();
        }
// 715
        if (!isDirectory$val$168) {
// 716
          boolean mkdir$val$169;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dir)) {
            try {
              mkdir$val$169 = dir.mkdir ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            mkdir$val$169 = dir.mkdir ();
          }
        }
// 717
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$170;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
          try {
            append$val$170 = path.append (sep);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$170 = path.append (sep);
        }
      }
    } else {{
// 719
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$171;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
          try {
            append$val$171 = path.append (sep);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$171 = path.append (sep);
        }
      }
    }
// 722
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$172;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
      try {
        append$val$172 = path.append (base);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$172 = path.append (base);
    }
// 724
    JP.go.ipa.oz.lib.standard._String_if asString$val$173;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
      try {
        asString$val$173 = path.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$173 = path.asString ();
    }
// 724
    return asString$val$173;
  }
  
  protected JP.go.ipa.oz.lib.standard._String_if createPath (JP.go.ipa.oz.lib.standard._String_if base) throws Exception  {
// 691
    return createPath (base, getGOD ());
  }
  
  protected JP.go.ipa.oz.lang._Thread_if createThread (JP.go.ipa.oz.lang._Runnable_if run) throws Exception  {
// 728
    JP.go.ipa.oz.lang._Thread_if th = null;
// 729
    return th = (JP.go.ipa.oz.lang._Thread_cl) (new JP.go.ipa.oz.lang._Thread_cl ())._new_create (run);
  }
  
  protected void sendFile (JP.go.ipa.oz.lib.standard._InputStream_if data, JP.go.ipa.oz.lib.standard._String_if name, int size) throws Exception  {
// 680
    JP.go.ipa.oz.lib.standard._String_if string$46 = (new JP.go.ipa.oz.lib.standard._String_cl("application/octet-stream"));
    
// 680
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.startOutput (string$46, name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.startOutput (string$46, name);
    }
// 681
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.addOutput (data, size);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.addOutput (data, size);
    }
// 682
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
  
  protected void sendResult (JP.go.ipa.oz.lib.standard._Writer_if log) throws Exception  {
// 652
    JP.go.ipa.oz.lib.standard._String_if string$47 = (new JP.go.ipa.oz.lib.standard._String_cl("text/html"));
    
// 652
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.startOutput (string$47);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.startOutput (string$47);
    }
// 654
    JP.go.ipa.oz.lib.standard._String_if string$48 = (new JP.go.ipa.oz.lib.standard._String_cl("html"));
    
// 654
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.beginTag (string$48);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.beginTag (string$48);
    }
// 655
    JP.go.ipa.oz.lib.standard._String_if string$49 = (new JP.go.ipa.oz.lib.standard._String_cl("head"));
    
// 655
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.beginTag (string$49);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.beginTag (string$49);
    }
// 656
    JP.go.ipa.oz.lib.standard._String_if string$50 = (new JP.go.ipa.oz.lib.standard._String_cl("title"));
    
// 656
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.beginTag (string$50);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.beginTag (string$50);
    }
// 657
    JP.go.ipa.oz.lib.standard._String_if string$51 = (new JP.go.ipa.oz.lib.standard._String_cl("Result"));
    
// 657
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.addOutput (string$51);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.addOutput (string$51);
    }
// 658
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.endTag ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.endTag ();
    }
// 659
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.endTag ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.endTag ();
    }
// 661
    JP.go.ipa.oz.lib.standard._String_if string$52 = (new JP.go.ipa.oz.lib.standard._String_cl("body"));
    
// 661
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.beginTag (string$52);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.beginTag (string$52);
    }
// 662
    JP.go.ipa.oz.lib.standard._String_if string$53 = (new JP.go.ipa.oz.lib.standard._String_cl("pre"));
    
// 662
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.beginTag (string$53);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.beginTag (string$53);
    }
// 663
    JP.go.ipa.oz.lib.standard._String_if asString$val$174;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) log)) {
      try {
        asString$val$174 = log.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$174 = log.asString ();
    }
// 663
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.addOutput (asString$val$174);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.addOutput (asString$val$174);
    }
// 664
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.endTag ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.endTag ();
    }
// 665
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.endTag ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.endTag ();
    }
// 667
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.endOutput ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.endOutput ();
    }
// 669
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
  
  protected void sendResult (JP.go.ipa.oz.lib.standard._String_if str) throws Exception  {
// 628
    JP.go.ipa.oz.lib.standard._String_if string$54 = (new JP.go.ipa.oz.lib.standard._String_cl("text/html"));
    
// 628
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.startOutput (string$54);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.startOutput (string$54);
    }
// 630
    JP.go.ipa.oz.lib.standard._String_if string$55 = (new JP.go.ipa.oz.lib.standard._String_cl("html"));
    
// 630
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.beginTag (string$55);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.beginTag (string$55);
    }
// 631
    JP.go.ipa.oz.lib.standard._String_if string$56 = (new JP.go.ipa.oz.lib.standard._String_cl("head"));
    
// 631
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.beginTag (string$56);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.beginTag (string$56);
    }
// 632
    JP.go.ipa.oz.lib.standard._String_if string$57 = (new JP.go.ipa.oz.lib.standard._String_cl("title"));
    
// 632
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.beginTag (string$57);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.beginTag (string$57);
    }
// 633
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.addOutput (str);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.addOutput (str);
    }
// 634
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.endTag ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.endTag ();
    }
// 635
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.endTag ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.endTag ();
    }
// 637
    JP.go.ipa.oz.lib.standard._String_if string$58 = (new JP.go.ipa.oz.lib.standard._String_cl("body"));
    
// 637
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.beginTag (string$58);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.beginTag (string$58);
    }
// 638
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.addOutput (str);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.addOutput (str);
    }
// 639
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.endTag ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.endTag ();
    }
// 641
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.endOutput ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.endOutput ();
    }
// 643
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
  
  public ExecuteThread_cl () throws Exception { super (); }
  
}

