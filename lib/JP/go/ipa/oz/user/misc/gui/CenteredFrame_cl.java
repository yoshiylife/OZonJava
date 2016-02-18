package JP.go.ipa.oz.user.misc.gui;

public class CenteredFrame_cl extends JP.go.ipa.oz.lib.standard._Frame_cl implements JP.go.ipa.oz.user.misc.gui.CenteredFrame_if {
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._String_if title) throws Exception  {
// 29
    super._new_newFrame (title);
    return this;
  }
  
  public Object _new_create () throws Exception  {
// 22
    super._new_newFrame ();
    return this;
  }
  
  public void pack () throws Exception  {
    checkSecureInvocation ();
// 38
    JP.go.ipa.oz.lib.standard._Toolkit_if tk = null;
// 39
    JP.go.ipa.oz.lib.standard._Dimension_if scrDim = null;
// 40
    JP.go.ipa.oz.lib.standard._Dimension_if myDim = null;
// 42
    super.pack ();
// 45
    tk = (JP.go.ipa.oz.lib.standard._Toolkit_cl) (new JP.go.ipa.oz.lib.standard._Toolkit_cl ())._new_newToolkit ();
// 46
    scrDim = tk.getScreenSize ();
// 47
    myDim = getSize ();
// 48
    int getWidth$val$4;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) scrDim)) {
      try {
        getWidth$val$4 = scrDim.getWidth ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getWidth$val$4 = scrDim.getWidth ();
    }
// 48
    int getWidth$val$5;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) myDim)) {
      try {
        getWidth$val$5 = myDim.getWidth ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getWidth$val$5 = myDim.getWidth ();
    }
// 49
    int getHeight$val$6;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) scrDim)) {
      try {
        getHeight$val$6 = scrDim.getHeight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHeight$val$6 = scrDim.getHeight ();
    }
// 49
    int getHeight$val$7;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) myDim)) {
      try {
        getHeight$val$7 = myDim.getHeight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHeight$val$7 = myDim.getHeight ();
    }
// 48
    setLocation (getWidth$val$4 / 2 - getWidth$val$5 / 2, getHeight$val$6 / 2 - getHeight$val$7 / 2);
  }
  
  public CenteredFrame_cl () throws Exception { super (); }
  
}

