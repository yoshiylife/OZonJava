package JP.go.ipa.oz.user.inter.wwps;

public class WWPServer_cl extends JP.go.ipa.oz.system.OzCell implements JP.go.ipa.oz.user.inter.wwps.WWPServer_if {
  static final boolean _global_ = true;
  JP.go.ipa.oz.user.inter.cgi.OzCGI_if cgi;
  
  JP.go.ipa.oz.lib.standard._String_if version () throws Exception  {
// 35
    return (new JP.go.ipa.oz.lib.standard._String_cl("WWPServer version 1.0"));
  }
  
  protected void initialize () throws Exception  {
  }
  
  public void quiet () throws Exception  {
    checkSecureInvocation ();
// 77
    flushCell ();
  }
  
  public void go () throws Exception  {
    checkSecureInvocation ();
// 46
    JP.go.ipa.oz.user.inter.wwps.WWPSPropertyReader_if prop = (JP.go.ipa.oz.user.inter.wwps.WWPSPropertyReader_cl) (new JP.go.ipa.oz.user.inter.wwps.WWPSPropertyReader_cl ())._new_create ();
// 47
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prop)) {
      try {
        prop.read ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      prop.read ();
    }
// 48
    JP.go.ipa.oz.lib.standard._String_if getOzCGI$val$135;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prop)) {
      try {
        getOzCGI$val$135 = prop.getOzCGI ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzCGI$val$135 = prop.getOzCGI ();
    }
// 48
    JP.go.ipa.oz.lib.standard._String_if gol = getOzCGI$val$135;
// 49
    if (gol == null) {
// 50
      gol = (new JP.go.ipa.oz.lib.standard._String_cl("OZCGI"));
    }
// 52
    cgi = new JP.go.ipa.oz.user.inter.cgi.OzCGI_pcl (gol);
// 54
    try {
// 55
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cgi)) {
        try {
          cgi.ping ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        cgi.ping ();
      }
    }
    catch (JP.go.ipa.oz.system.ExCellNotFoundException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 57
      JP.go.ipa.oz.lib.standard._System_if sys = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 58
      JP.go.ipa.oz.lib.standard._StringBuffer_if msg = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("Not found cell: ")));
// 59
      JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$136;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) msg)) {
        try {
          append$val$136 = msg.append (gol);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        append$val$136 = msg.append (gol);
      }
// 60
      JP.go.ipa.oz.lib.standard._String_if asString$val$137;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) msg)) {
        try {
          asString$val$137 = msg.asString ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        asString$val$137 = msg.asString ();
      }
// 60
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
        try {
          sys.println (asString$val$137);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        sys.println (asString$val$137);
      }
// 61
      stopCell ();
    }
// 64
    JP.go.ipa.oz.user.inter.wwps.CompilerCGI_if ccgi = (JP.go.ipa.oz.user.inter.wwps.CompilerCGI_cl) (new JP.go.ipa.oz.user.inter.wwps.CompilerCGI_cl ())._new_create ();
// 65
    JP.go.ipa.oz.user.inter.wwps.RemoteExecutor_if remote = (JP.go.ipa.oz.user.inter.wwps.RemoteExecutor_cl) (new JP.go.ipa.oz.user.inter.wwps.RemoteExecutor_cl ())._new_create ();
// 66
    JP.go.ipa.oz.user.inter.wwps.ComponentServer_if cserver = (JP.go.ipa.oz.user.inter.wwps.ComponentServer_cl) (new JP.go.ipa.oz.user.inter.wwps.ComponentServer_cl ())._new_create ();
// 68
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ccgi)) {
      try {
        ccgi.start (cgi);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      ccgi.start (cgi);
    }
// 69
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) remote)) {
      try {
        remote.start (cgi);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      remote.start (cgi);
    }
// 70
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cserver)) {
      try {
        cserver.start (cgi);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      cserver.start (cgi);
    }
  }
  
  public WWPServer_cl () { super ("JP.go.ipa.oz.user.inter.wwps.WWPServer_pcl"); }
  
  public WWPServer_cl (String proxy_id) { super (proxy_id); }
  
}

