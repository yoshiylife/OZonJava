package JP.go.ipa.oz.user.misc.gui;

public class CenteredDialog_cl extends JP.go.ipa.oz.lib.standard._Dialog_cl implements JP.go.ipa.oz.user.misc.gui.CenteredDialog_if {
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._Frame_if parent, JP.go.ipa.oz.lib.standard._String_if title, boolean modal) throws Exception  {
// 22
    super._new_newDialog (parent, title, modal);
    return this;
  }
  
  public void pack () throws Exception  {
    checkSecureInvocation ();
// 31
    JP.go.ipa.oz.lib.standard._Toolkit_if tk = null;
// 32
    JP.go.ipa.oz.lib.standard._Dimension_if dim = null;
// 33
    JP.go.ipa.oz.lib.standard._Dimension_if mySize = null;
// 35
    super.pack ();
// 38
    tk = (JP.go.ipa.oz.lib.standard._Toolkit_cl) (new JP.go.ipa.oz.lib.standard._Toolkit_cl ())._new_newToolkit ();
// 39
    dim = tk.getScreenSize ();
// 40
    mySize = getSize ();
// 41
    int getWidth$val$0;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dim)) {
      try {
        getWidth$val$0 = dim.getWidth ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getWidth$val$0 = dim.getWidth ();
    }
// 41
    int getWidth$val$1;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) mySize)) {
      try {
        getWidth$val$1 = mySize.getWidth ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getWidth$val$1 = mySize.getWidth ();
    }
// 42
    int getHeight$val$2;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dim)) {
      try {
        getHeight$val$2 = dim.getHeight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHeight$val$2 = dim.getHeight ();
    }
// 42
    int getHeight$val$3;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) mySize)) {
      try {
        getHeight$val$3 = mySize.getHeight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHeight$val$3 = mySize.getHeight ();
    }
// 41
    setLocation (getWidth$val$0 / 2 - getWidth$val$1 / 2, getHeight$val$2 / 2 - getHeight$val$3 / 2);
  }
  
  public CenteredDialog_cl () throws Exception { super (); }
  
}

