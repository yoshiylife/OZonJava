package JP.go.ipa.oz.user.ide;

public class ApplicationSummaryBrowserMenuBar_cl extends JP.go.ipa.oz.lib.standard._MenuBar_cl implements JP.go.ipa.oz.user.ide.ApplicationSummaryBrowserMenuBar_if {
  JP.go.ipa.oz.lib.standard._Menu_if menuSystem;
  JP.go.ipa.oz.user.ide.ApplicationGarageBrowser_if gBrowser;
  JP.go.ipa.oz.user.ide.ApplicationSummaryBrowser_if sBrowser;
  
  public Object _new_createExportMenu (JP.go.ipa.oz.user.ide.ApplicationGarageBrowser_if gb, JP.go.ipa.oz.user.ide.ApplicationSummaryBrowser_if sb) throws Exception  {
// 53
    super._new_newMenuBar ();
// 55
    gBrowser = gb;
// 56
    sBrowser = sb;
// 57
    menuSystem = mkSystemMenu (false);
// 58
    add (menuSystem);
    return this;
  }
  
  public Object _new_createBrowseMenu (JP.go.ipa.oz.user.ide.ApplicationGarageBrowser_if gb, JP.go.ipa.oz.user.ide.ApplicationSummaryBrowser_if sb) throws Exception  {
// 40
    super._new_newMenuBar ();
// 42
    gBrowser = gb;
// 43
    sBrowser = sb;
// 44
    menuSystem = mkSystemMenu (true);
// 45
    add (menuSystem);
    return this;
  }
  
  JP.go.ipa.oz.lib.standard._Menu_if mkSystemMenu (boolean forBrowse) throws Exception  {
// 69
    JP.go.ipa.oz.lib.standard._Menu_if menu = null;
// 70
    JP.go.ipa.oz.lib.standard._MenuItem_if itemSave = null;
// 71
    JP.go.ipa.oz.lib.standard._MenuItem_if item1 = null, item2 = null;
// 72
    JP.go.ipa.oz.user.ide.ApplicationSummaryBrowserMenuListener_if listener = null;
// 74
    listener = (JP.go.ipa.oz.user.ide.ApplicationSummaryBrowserMenuListener_cl) (new JP.go.ipa.oz.user.ide.ApplicationSummaryBrowserMenuListener_cl ())._new_create (gBrowser, sBrowser);
// 76
    menu = (JP.go.ipa.oz.lib.standard._Menu_cl) (new JP.go.ipa.oz.lib.standard._Menu_cl ())._new_newMenu ((new JP.go.ipa.oz.lib.standard._String_cl("System")));
// 77
    if (forBrowse) {{
// 78
        itemSave = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("save")));
// 79
        item1 = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("import")));
// 80
        item2 = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("close")));
// 81
        itemSave.addActionListener (listener);
// 82
        itemSave.setEnabled (true);
// 87
        menu.add (itemSave);
// 88
        menu.add (item1);
// 89
        menu.addSeparator ();
// 90
        menu.add (item2);
      }
    } else {{
// 93
        item1 = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("export")));
// 94
        item2 = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("cancel")));
// 95
        menu.add (item1);
// 96
        menu.addSeparator ();
// 97
        menu.add (item2);
      }
    }
// 100
    item1.addActionListener (listener);
// 101
    item2.addActionListener (listener);
// 103
    return menu;
  }
  
  public ApplicationSummaryBrowserMenuBar_cl () throws Exception { super (); }
  
}

