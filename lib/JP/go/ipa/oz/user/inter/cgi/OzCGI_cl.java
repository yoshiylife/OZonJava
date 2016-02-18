package JP.go.ipa.oz.user.inter.cgi;

public class OzCGI_cl extends JP.go.ipa.oz.system.OzCell implements JP.go.ipa.oz.user.inter.cgi.OzCGI_if {
  static final boolean _global_ = true;
  transient JP.go.ipa.oz.user.inter.cgi.RandezvouTable_if input_randezvou_table;
  transient JP.go.ipa.oz.user.inter.cgi.CGISocket_if cgi_socket;
  transient JP.go.ipa.oz.user.inter.cgi.RandezvouTable_if output_randezvou_table;
  
  public JP.go.ipa.oz.user.inter.cgi.HTMLData_if receiveRequest (JP.go.ipa.oz.lib.standard._String_if form_id) throws Exception  {
    checkSecureInvocation ();
// 97
    JP.go.ipa.oz.lib.standard._System_if sys = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 98
    JP.go.ipa.oz.lib.standard._String_if string$30 = (new JP.go.ipa.oz.lib.standard._String_cl("received request: "));
    
// 98
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
      try {
        sys.debugPrintln (string$30);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      sys.debugPrintln (string$30);
    }
// 99
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
      try {
        sys.debugPrintln (form_id);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      sys.debugPrintln (form_id);
    }
// 101
    JP.go.ipa.oz.user.inter.cgi.RandezvouPoint_if rp = null;
// 102
    rp = (JP.go.ipa.oz.user.inter.cgi.RandezvouPoint_cl) (new JP.go.ipa.oz.user.inter.cgi.RandezvouPoint_cl ())._new_create ();
    
// 102
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) input_randezvou_table)) {
      try {
        input_randezvou_table.registerRandezvouPoint (form_id, rp);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      input_randezvou_table.registerRandezvouPoint (form_id, rp);
    }
// 104
    JP.go.ipa.oz.user.inter.cgi.HTMLData_if html = rp.getHtml ();
// 106
    return html;
  }
  
  public void go () throws Exception  {
    checkSecureInvocation ();
// 57
    JP.go.ipa.oz.user.inter.cgi.OzCGIPropertyReader_if prop = (JP.go.ipa.oz.user.inter.cgi.OzCGIPropertyReader_cl) (new JP.go.ipa.oz.user.inter.cgi.OzCGIPropertyReader_cl ())._new_create ();
// 58
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prop)) {
      try {
        prop.read ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      prop.read ();
    }
// 59
    int getPort$val$128;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prop)) {
      try {
        getPort$val$128 = prop.getPort ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getPort$val$128 = prop.getPort ();
    }
// 59
    int port = getPort$val$128;
// 61
    if (port == 0) {
// 61
      port = 5000;
    }
// 63
    input_randezvou_table = (JP.go.ipa.oz.user.inter.cgi.RandezvouTable_cl) (new JP.go.ipa.oz.user.inter.cgi.RandezvouTable_cl ())._new_create ();
// 64
    output_randezvou_table = (JP.go.ipa.oz.user.inter.cgi.RandezvouTable_cl) (new JP.go.ipa.oz.user.inter.cgi.RandezvouTable_cl ())._new_create ();
// 66
    JP.go.ipa.oz.lang._Thread_if th = (JP.go.ipa.oz.lang._Thread_cl) (new JP.go.ipa.oz.lang._Thread_cl ())._new_create (cgi_socket = (JP.go.ipa.oz.user.inter.cgi.CGISocket_cl) (new JP.go.ipa.oz.user.inter.cgi.CGISocket_cl ())._new_create (port, input_randezvou_table, output_randezvou_table));
// 70
    JP.go.ipa.oz.user.inter.cgi.OzCGIManager_if mng = (JP.go.ipa.oz.user.inter.cgi.OzCGIManager_cl) (new JP.go.ipa.oz.user.inter.cgi.OzCGIManager_cl ())._new_create (this);
  }
  
  public void sendResult (JP.go.ipa.oz.user.inter.cgi.HTMLData_if result) throws Exception  {
    checkSecureInvocation ();
// 115
    JP.go.ipa.oz.lib.standard._String_if getRequestID$val$129;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) result)) {
      try {
        getRequestID$val$129 = result.getRequestID ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getRequestID$val$129 = result.getRequestID ();
    }
// 115
    JP.go.ipa.oz.lib.standard._String_if request_id = getRequestID$val$129;
// 116
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) output_randezvou_table)) {
      try {
        output_randezvou_table.signalRandezvouPoint (request_id, result);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      output_randezvou_table.signalRandezvouPoint (request_id, result);
    }
  }
  
  JP.go.ipa.oz.lib.standard._String_if version () throws Exception  {
// 44
    return (new JP.go.ipa.oz.lib.standard._String_cl("OzCGI version 1.0"));
  }
  
  public void quit () throws Exception  {
    checkSecureInvocation ();
// 128
    stopCell ();
  }
  
  public void quiet () throws Exception  {
    checkSecureInvocation ();
// 77
    if (input_randezvou_table != null) {{
// 78
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) input_randezvou_table)) {
          try {
            input_randezvou_table.finish ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          input_randezvou_table.finish ();
        }
      }
    }
// 81
    if (output_randezvou_table != null) {{
// 82
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) output_randezvou_table)) {
          try {
            output_randezvou_table.finish ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          output_randezvou_table.finish ();
        }
      }
    }
// 85
    if (cgi_socket != null) {
// 86
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cgi_socket)) {
        try {
          cgi_socket.stop ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        cgi_socket.stop ();
      }
    }
// 88
    flushCell ();
  }
  
  protected void initialize () throws Exception  {
  }
  
  public void ping () throws Exception  {
    checkSecureInvocation ();
  }
  
  public OzCGI_cl () { super ("JP.go.ipa.oz.user.inter.cgi.OzCGI_pcl"); }
  
  public OzCGI_cl (String proxy_id) { super (proxy_id); }
  
}

