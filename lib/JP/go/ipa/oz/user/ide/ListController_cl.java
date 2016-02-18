package JP.go.ipa.oz.user.ide;

public class ListController_cl extends JP.go.ipa.oz.lib.standard._ActionListener_cl implements JP.go.ipa.oz.user.ide.ListController_if {
  JP.go.ipa.oz.user.ide.ProjectManager_if prj;
  
  public Object _new_create (JP.go.ipa.oz.user.ide.ProjectManager_if p, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if q) throws Exception  {
// 26
    super._new_newActionListener (q);
// 27
    prj = p;
    return this;
  }
  
  public void actionPerformed (JP.go.ipa.oz.lib.standard._ActionEvent_if event) throws Exception  {
    checkSecureInvocation ();
// 39
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
      try {
        prj.openEditor ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      prj.openEditor ();
    }
  }
  
  public ListController_cl () throws Exception { super (); }
  
}

