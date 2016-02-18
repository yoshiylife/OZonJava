package JP.go.ipa.oz.user.launcher;

public class LauncherImportListener_cl extends JP.go.ipa.oz.lib.standard._ActionListener_cl implements JP.go.ipa.oz.user.launcher.LauncherImportListener_if {
  JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if dialogQue;
  JP.go.ipa.oz.user.launcher.LauncherCore_if lCore;
  JP.go.ipa.oz.user.launcher.LauncherCellInformationDialog_if cellDialog;
  
  public Object _new_create (JP.go.ipa.oz.user.launcher.LauncherCore_if lchr, JP.go.ipa.oz.user.launcher.LauncherCellInformationDialog_if dialog, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if eq) throws Exception  {
// 26
    super._new_newActionListener (eq);
// 28
    lCore = lchr;
// 29
    cellDialog = dialog;
// 30
    dialogQue = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
    return this;
  }
  
  public void actionPerformed (JP.go.ipa.oz.lib.standard._ActionEvent_if evt) throws Exception  {
    checkSecureInvocation ();
// 39
    JP.go.ipa.oz.user.ide.ApplicationGarageBrowser_if br = null;
// 40
    JP.go.ipa.oz.lib.standard._String_if gol = null;
// 42
    br = (JP.go.ipa.oz.user.ide.ApplicationGarageBrowser_cl) (new JP.go.ipa.oz.user.ide.ApplicationGarageBrowser_cl ())._new_create (cellDialog);
// 43
    JP.go.ipa.oz.lib.standard._String_if getCatalogGOL$val$18;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lCore)) {
      try {
        getCatalogGOL$val$18 = lCore.getCatalogGOL ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getCatalogGOL$val$18 = lCore.getCatalogGOL ();
    }
// 43
    gol = getCatalogGOL$val$18;
// 44
    if (gol != null) {{
// 45
        br.bindServer (gol);
      }
    }
// 47
    br.importApplication ();
  }
  
  void handleException () throws Exception  {
// 54
    JP.go.ipa.oz.user.misc.gui.ExceptionDialog_if exDialog = null;
// 56
    JP.go.ipa.oz.lib.standard._Frame_if getGUI$val$19;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lCore)) {
      try {
        getGUI$val$19 = lCore.getGUI ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getGUI$val$19 = lCore.getGUI ();
    }
// 56
    exDialog = (JP.go.ipa.oz.user.misc.gui.ExceptionDialog_cl) (new JP.go.ipa.oz.user.misc.gui.ExceptionDialog_cl ())._new_create (getGUI$val$19, (new JP.go.ipa.oz.lib.standard._String_cl("exception")), dialogQue);
  }
  
  public LauncherImportListener_cl () throws Exception { super (); }
  
}

