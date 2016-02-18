package JP.go.ipa.oz.user.inter.cgi;

public class CGISocket_cl extends JP.go.ipa.oz.lang._Runnable_cl implements JP.go.ipa.oz.user.inter.cgi.CGISocket_if {
  int port;
  JP.go.ipa.oz.user.inter.cgi.RandezvouTable_if input_randezvou_table;
  JP.go.ipa.oz.lib.standard._ServerSocket_if server;
  JP.go.ipa.oz.user.inter.cgi.RandezvouTable_if output_randezvou_table;
  boolean test_mode;
  int no_requests;
  
  public Object _new_create (int p, JP.go.ipa.oz.user.inter.cgi.RandezvouTable_if in_table, JP.go.ipa.oz.user.inter.cgi.RandezvouTable_if out_table) throws Exception  {
// 490
    port = p;
// 491
    input_randezvou_table = in_table;
// 492
    output_randezvou_table = out_table;
    return this;
  }
  
  public Object _new_createForTest (int p, JP.go.ipa.oz.user.inter.cgi.RandezvouTable_if in_table, JP.go.ipa.oz.user.inter.cgi.RandezvouTable_if out_table) throws Exception  {
// 504
    port = p;
// 505
    input_randezvou_table = in_table;
// 506
    output_randezvou_table = out_table;
// 507
    test_mode = true;
    return this;
  }
  
  public void stop () throws Exception  {
    checkSecureInvocation ();
// 514
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) server)) {
      try {
        server.close ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      server.close ();
    }
  }
  
  public void run () throws Exception  {
    checkSecureInvocation ();
// 442
    JP.go.ipa.oz.lib.standard._System_if sys = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 444
    JP.go.ipa.oz.lib.standard._String_if string$37 = (new JP.go.ipa.oz.lib.standard._String_cl("server started"));
    
// 444
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
      try {
        sys.debugPrintln (string$37);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      sys.debugPrintln (string$37);
    }
// 446
    try {
// 447
      server = (JP.go.ipa.oz.lib.standard._ServerSocket_cl) (new JP.go.ipa.oz.lib.standard._ServerSocket_cl ())._new_breed (port);
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_4) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_4 = _exception_4.getOzException ();
      if (_oz_exception_4 instanceof JP.go.ipa.oz.lib.standard._IOException_if) {
        JP.go.ipa.oz.lib.standard._IOException_if e = (JP.go.ipa.oz.lib.standard._IOException_if) _oz_exception_4;
// 449
        JP.go.ipa.oz.lib.standard._System_if sys$2 = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 450
        JP.go.ipa.oz.lib.standard._String_if string$38 = (new JP.go.ipa.oz.lib.standard._String_cl("cannot open port: "));
        
// 450
        JP.go.ipa.oz.lib.standard._String_if string$39 = (new JP.go.ipa.oz.lib.standard._String_cl(""));
        
// 450
        JP.go.ipa.oz.lib.standard._String_if valueOf$val$147;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$39)) {
          try {
            valueOf$val$147 = string$39.valueOf (port);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          valueOf$val$147 = string$39.valueOf (port);
        }
// 450
        JP.go.ipa.oz.lib.standard._String_if concat$val$148;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$38)) {
          try {
            concat$val$148 = string$38.concat (valueOf$val$147);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          concat$val$148 = string$38.concat (valueOf$val$147);
        }
// 450
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys$2)) {
          try {
            sys$2.println (concat$val$148);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          sys$2.println (concat$val$148);
        }
// 451
        stopCell ();
// 452
        return;
      } else throw _exception_4;
    }
// 455
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) server)) {
      try {
        server.setSoTimeout (5000);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      server.setSoTimeout (5000);
    }
// 457
    while (true) {
      /* body */ _loop_1: {
// 458
        try {
// 459
          JP.go.ipa.oz.lib.standard._Socket_if accept$val$149;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) server)) {
            try {
              accept$val$149 = server.accept ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            accept$val$149 = server.accept ();
          }
// 459
          JP.go.ipa.oz.lib.standard._Socket_if s = accept$val$149;
// 461
          JP.go.ipa.oz.lib.standard._String_if string$40 = (new JP.go.ipa.oz.lib.standard._String_cl("connected"));
          
// 461
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
            try {
              sys.debugPrintln (string$40);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            sys.debugPrintln (string$40);
          }
// 463
          JP.go.ipa.oz.user.inter.cgi.CGI_if cgi_runnable = null;
// 464
          JP.go.ipa.oz.lang._Thread_if cgi = (JP.go.ipa.oz.lang._Thread_cl) (new JP.go.ipa.oz.lang._Thread_cl ())._new_create (cgi_runnable = (JP.go.ipa.oz.user.inter.cgi.CGI_cl) (new JP.go.ipa.oz.user.inter.cgi.CGI_cl ())._new_create (s, no_requests++, input_randezvou_table, output_randezvou_table, test_mode));
// 468
          if (test_mode) {
// 468
            break;
          }
        }
        catch (JP.go.ipa.oz.lang.OzException _exception_5) {
          JP.go.ipa.oz.lang._Root_if _oz_exception_5 = _exception_5.getOzException ();
          if (_oz_exception_5 instanceof JP.go.ipa.oz.lib.standard._IOException_if) {
            JP.go.ipa.oz.lib.standard._IOException_if e = (JP.go.ipa.oz.lib.standard._IOException_if) _oz_exception_5;
// 470
            JP.go.ipa.oz.lib.standard._String_if getMessage$val$150;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) e)) {
              try {
                getMessage$val$150 = e.getMessage ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getMessage$val$150 = e.getMessage ();
            }
// 470
            JP.go.ipa.oz.lib.standard._String_if string$41 = (new JP.go.ipa.oz.lib.standard._String_cl("Accept timed out"));
            
// 470
            boolean startsWith$val$151;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getMessage$val$150)) {
              try {
                startsWith$val$151 = getMessage$val$150.startsWith (string$41);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              startsWith$val$151 = getMessage$val$150.startsWith (string$41);
            }
// 470
            if (!startsWith$val$151) {{
// 471
                JP.go.ipa.oz.lib.standard._System_if sys$3 = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 472
                JP.go.ipa.oz.lib.standard._String_if getMessage$val$152;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) e)) {
                  try {
                    getMessage$val$152 = e.getMessage ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  getMessage$val$152 = e.getMessage ();
                }
// 472
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys$3)) {
                  try {
                    sys$3.debugPrintln (getMessage$val$152);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  sys$3.debugPrintln (getMessage$val$152);
                }
// 473
                break;
              }
            }
          } else throw _exception_5;
        }
      }
    }
  }
  
  public CGISocket_cl () throws Exception { super (); }
  
}

