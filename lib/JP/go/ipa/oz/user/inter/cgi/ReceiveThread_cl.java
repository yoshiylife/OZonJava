package JP.go.ipa.oz.user.inter.cgi;

abstract public class ReceiveThread_cl extends JP.go.ipa.oz.user.inter.cgi.ExecuteThread_cl implements JP.go.ipa.oz.user.inter.cgi.ReceiveThread_if {
  JP.go.ipa.oz.lib.standard._String_if selector;
  
  public Object _new_create (JP.go.ipa.oz.user.inter.cgi.OzCGI_if c, JP.go.ipa.oz.lib.standard._String_if sel) throws Exception  {
// 565
    super._new_create (c, null);
// 566
    selector = sel;
    return this;
  }
  
  protected void atExit () throws Exception  {
  }
  
  public void run () throws Exception  {
    checkSecureInvocation ();
// 532
    JP.go.ipa.oz.lib.standard._System_if sys = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 534
    while (true) {
      /* body */ _loop_1: {
// 535
        JP.go.ipa.oz.user.inter.cgi.HTMLData_if receiveRequest$val$153;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cgi)) {
          try {
            receiveRequest$val$153 = cgi.receiveRequest (selector);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          receiveRequest$val$153 = cgi.receiveRequest (selector);
        }
// 535
        html = receiveRequest$val$153;
// 536
        if (html == null) {{
// 537
            atExit ();
// 538
            break;
          }
        }
// 541
        turnGreen (html);
// 543
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
          try {
            sys.debugPrintln (selector);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          sys.debugPrintln (selector);
        }
// 544
        JP.go.ipa.oz.lib.standard._String_if string$42 = (new JP.go.ipa.oz.lib.standard._String_cl("\t: received data"));
        
// 544
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
          try {
            sys.debugPrintln (string$42);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          sys.debugPrintln (string$42);
        }
// 546
        try {
// 547
          dispatch ();
        }
        catch (java.lang.SecurityException _exception_e) {
          JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
          
// 549
          sendResult ((new JP.go.ipa.oz.lib.standard._String_cl("OZ security error !")));
        }
        catch (java.lang.RuntimeException _exception_e) {
          JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
          
// 551
          JP.go.ipa.oz.lib.standard._String_if string$43 = (new JP.go.ipa.oz.lib.standard._String_cl("some exception occured: "));
          
// 551
          JP.go.ipa.oz.lib.standard._String_if getMessage$val$154;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) e)) {
            try {
              getMessage$val$154 = e.getMessage ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getMessage$val$154 = e.getMessage ();
          }
// 551
          JP.go.ipa.oz.lib.standard._String_if concat$val$155;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$43)) {
            try {
              concat$val$155 = string$43.concat (getMessage$val$154);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            concat$val$155 = string$43.concat (getMessage$val$154);
          }
// 551
          sendResult (concat$val$155);
        }
        boolean bool$val$6;
        
        bool$val$6 = test_mode;
        if (bool$val$6) {
          bool$val$6 = --operation_count <= 0;
        }
// 554
        if (bool$val$6) {
// 554
          return;
        }
      }
    }
  }
  
  protected abstract void dispatch () throws Exception  ;
  public ReceiveThread_cl () throws Exception { super (); }
  
}

