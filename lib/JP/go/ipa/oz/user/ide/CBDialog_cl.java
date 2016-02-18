package JP.go.ipa.oz.user.ide;

abstract public class CBDialog_cl extends JP.go.ipa.oz.lib.standard._Dialog_cl implements JP.go.ipa.oz.user.ide.CBDialog_if {
  
  public Object _new_newCBDialog (JP.go.ipa.oz.lib.standard._Frame_if parent, JP.go.ipa.oz.lib.standard._String_if title, boolean modal) throws Exception  {
// 20
    super._new_newDialog (parent, title, modal);
    return this;
  }
  
  public void pack () throws Exception  {
    checkSecureInvocation ();
// 28
    JP.go.ipa.oz.lib.standard._Toolkit_if tk = null;
// 29
    JP.go.ipa.oz.lib.standard._Dimension_if dim = null;
// 30
    JP.go.ipa.oz.lib.standard._Dimension_if mySize = null;
// 32
    super.pack ();
// 35
    tk = (JP.go.ipa.oz.lib.standard._Toolkit_cl) (new JP.go.ipa.oz.lib.standard._Toolkit_cl ())._new_newToolkit ();
// 36
    dim = tk.getScreenSize ();
// 37
    mySize = getSize ();
// 38
    int getWidth$val$145;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dim)) {
      try {
        getWidth$val$145 = dim.getWidth ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getWidth$val$145 = dim.getWidth ();
    }
// 38
    int getWidth$val$146;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) mySize)) {
      try {
        getWidth$val$146 = mySize.getWidth ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getWidth$val$146 = mySize.getWidth ();
    }
// 39
    int getHeight$val$147;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dim)) {
      try {
        getHeight$val$147 = dim.getHeight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHeight$val$147 = dim.getHeight ();
    }
// 39
    int getHeight$val$148;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) mySize)) {
      try {
        getHeight$val$148 = mySize.getHeight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHeight$val$148 = mySize.getHeight ();
    }
// 38
    setLocation (getWidth$val$145 / 2 - getWidth$val$146 / 2, getHeight$val$147 / 2 - getHeight$val$148 / 2);
  }
  
  public CBDialog_cl () throws Exception { super (); }
  
}

