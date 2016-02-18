package JP.go.ipa.oz.user.inter.wwps;

public class WWPSTester_cl extends JP.go.ipa.oz.system.OzCell implements JP.go.ipa.oz.user.inter.wwps.WWPSTester_if {
  static final boolean _global_ = true;
  JP.go.ipa.oz.lib.standard._String_if log_file;
  
  protected void initialize () throws Exception  {
// 19
    JP.go.ipa.oz.lib.standard._System_if sys = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 20
    JP.go.ipa.oz.lib.standard._Array_if getArguments$val$266;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
      try {
        getArguments$val$266 = sys.getArguments ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getArguments$val$266 = sys.getArguments ();
    }
// 20
    JP.go.ipa.oz.lib.standard._Array_if args = getArguments$val$266;
// 21
    JP.go.ipa.oz.lang._Root_if at$val$267;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
      try {
        at$val$267 = args.at (0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      at$val$267 = args.at (0);
    }
// 21
    log_file = (JP.go.ipa.oz.lib.standard._String_if) (at$val$267);
// 22
    JP.go.ipa.oz.lib.standard._FileWriter_if fw = (JP.go.ipa.oz.lib.standard._FileWriter_cl) (new JP.go.ipa.oz.lib.standard._FileWriter_cl ())._new_breed (log_file);
// 23
    JP.go.ipa.oz.lib.standard._PrintWriter_if log = (JP.go.ipa.oz.lib.standard._PrintWriter_cl) (new JP.go.ipa.oz.lib.standard._PrintWriter_cl ())._new_breed (fw);
// 25
    JP.go.ipa.oz.lib.standard._String_if string$126 = (new JP.go.ipa.oz.lib.standard._String_cl("initialize"));
    
// 25
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) log)) {
      try {
        log.println (string$126);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      log.println (string$126);
    }
// 27
    int size$val$268;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
      try {
        size$val$268 = args.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$268 = args.size ();
    }
// 27
    int size = size$val$268;
// 28
    if (size > 1) {{
// 29
        JP.go.ipa.oz.lib.standard._String_if string$127 = (new JP.go.ipa.oz.lib.standard._String_cl("arguments"));
        
// 29
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) log)) {
          try {
            log.println (string$127);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          log.println (string$127);
        }
// 30
        /* for loop starting here */ {
          /* initialization part */
          int i = 1;
          
          for (;;) {
            /* boolean expression part */
            if (!(i < size)) break;
            
            /* body */ _loop_1: {
// 31
              JP.go.ipa.oz.lib.standard._String_if buf = null;
// 32
              JP.go.ipa.oz.lang._Root_if at$val$269;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
                try {
                  at$val$269 = args.at (i);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                at$val$269 = args.at (i);
              }
// 32
              buf = (JP.go.ipa.oz.lib.standard._String_if) (at$val$269);
// 33
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) log)) {
                try {
                  log.println (buf);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                log.println (buf);
              }
            }
            /* iteration part */
// 30
            i++;
          }
        }
      }
    }
// 37
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) log)) {
      try {
        log.close ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      log.close ();
    }
  }
  
  public void quiet () throws Exception  {
    checkSecureInvocation ();
// 61
    flushCell ();
  }
  
  public void go () throws Exception  {
    checkSecureInvocation ();
// 44
    JP.go.ipa.oz.lib.standard._FileWriter_if fw = (JP.go.ipa.oz.lib.standard._FileWriter_cl) (new JP.go.ipa.oz.lib.standard._FileWriter_cl ())._new_breed (log_file, true);
// 45
    JP.go.ipa.oz.lib.standard._PrintWriter_if log = (JP.go.ipa.oz.lib.standard._PrintWriter_cl) (new JP.go.ipa.oz.lib.standard._PrintWriter_cl ())._new_breed (fw);
// 47
    JP.go.ipa.oz.lib.standard._String_if string$128 = (new JP.go.ipa.oz.lib.standard._String_cl("go"));
    
// 47
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) log)) {
      try {
        log.println (string$128);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      log.println (string$128);
    }
// 49
    /* for loop starting here */ {
      /* initialization part */
      int i = 0;
      
      for (;;) {
        /* boolean expression part */
        if (!(i < 100)) break;
        
        /* body */ _loop_1: 
// 50
        JP.go.ipa.oz.lib.standard._String_if string$129 = (new JP.go.ipa.oz.lib.standard._String_cl("dummy"));
        
// 50
        JP.go.ipa.oz.lib.standard._String_if valueOf$val$270;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$129)) {
          try {
            valueOf$val$270 = string$129.valueOf (i);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          valueOf$val$270 = string$129.valueOf (i);
        }
// 50
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) log)) {
          try {
            log.println (valueOf$val$270);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          log.println (valueOf$val$270);
        }
        /* iteration part */
// 49
        i++;
      }
    }
// 52
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) log)) {
      try {
        log.close ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      log.close ();
    }
// 54
    stopCell ();
  }
  
  public WWPSTester_cl () { super ("JP.go.ipa.oz.user.inter.wwps.WWPSTester_pcl"); }
  
  public WWPSTester_cl (String proxy_id) { super (proxy_id); }
  
}

