package JP.go.ipa.oz.user.ide;

public class CompileLog_cl extends JP.go.ipa.oz.lib.standard._PrintWriter_cl implements JP.go.ipa.oz.user.ide.CompileLog_if {
  JP.go.ipa.oz.user.ide.CompileInfoDialog_if infoDialog;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._Writer_if w, JP.go.ipa.oz.user.ide.CompileInfoDialog_if dlg) throws Exception  {
// 18
    super._new_breed (w);
// 19
    infoDialog = dlg;
    return this;
  }
  
  public void write (JP.go.ipa.oz.lib.standard._String_if s) throws Exception  {
    checkSecureInvocation ();
// 23
    JP.go.ipa.oz.lib.standard._String_if trim$val$255;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s)) {
      try {
        trim$val$255 = s.trim ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      trim$val$255 = s.trim ();
    }
// 23
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) infoDialog)) {
      try {
        infoDialog.appendText (trim$val$255);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      infoDialog.appendText (trim$val$255);
    }
  }
  
  public CompileLog_cl () throws Exception { super (); }
  
}

