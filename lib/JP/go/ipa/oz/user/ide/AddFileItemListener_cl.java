package JP.go.ipa.oz.user.ide;

public class AddFileItemListener_cl extends JP.go.ipa.oz.lib.standard._ItemListener_cl implements JP.go.ipa.oz.user.ide.AddFileItemListener_if {
  JP.go.ipa.oz.user.ide.AddFileDialog_if dlg;
  
  public Object _new_create (JP.go.ipa.oz.user.ide.AddFileDialog_if a, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if q) throws Exception  {
// 26
    super._new_newItemListener (q);
// 27
    dlg = a;
    return this;
  }
  
  public void itemStateChanged (JP.go.ipa.oz.lib.standard._ItemEvent_if event) throws Exception  {
    checkSecureInvocation ();
// 39
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
      try {
        dlg.changeDrive ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      dlg.changeDrive ();
    }
  }
  
  public AddFileItemListener_cl () throws Exception { super (); }
  
}

