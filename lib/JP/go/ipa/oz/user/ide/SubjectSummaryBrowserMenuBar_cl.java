package JP.go.ipa.oz.user.ide;

public class SubjectSummaryBrowserMenuBar_cl extends JP.go.ipa.oz.lib.standard._MenuBar_cl implements JP.go.ipa.oz.user.ide.SubjectSummaryBrowserMenuBar_if {
  JP.go.ipa.oz.lib.standard._Menu_if menuSystem;
  JP.go.ipa.oz.user.ide.SubjectGarageBrowser_if sgBrowser;
  JP.go.ipa.oz.user.ide.SubjectSummaryBrowser_if ssBrowser;
  
  public Object _new_createExportMenu (JP.go.ipa.oz.user.ide.SubjectGarageBrowser_if sgb, JP.go.ipa.oz.user.ide.SubjectSummaryBrowser_if ssb) throws Exception  {
// 51
    super._new_newMenuBar ();
// 53
    sgBrowser = sgb;
// 54
    ssBrowser = ssb;
// 55
    menuSystem = mkSystemMenu (false);
// 56
    add (menuSystem);
    return this;
  }
  
  public Object _new_createBrowseMenu (JP.go.ipa.oz.user.ide.SubjectGarageBrowser_if sgb, JP.go.ipa.oz.user.ide.SubjectSummaryBrowser_if ssb) throws Exception  {
// 39
    super._new_newMenuBar ();
// 41
    sgBrowser = sgb;
// 42
    ssBrowser = ssb;
// 43
    menuSystem = mkSystemMenu (true);
// 44
    add (menuSystem);
    return this;
  }
  
  JP.go.ipa.oz.lib.standard._Menu_if mkSystemMenu (boolean forBrowse) throws Exception  {
// 67
    JP.go.ipa.oz.lib.standard._Menu_if menu = null;
// 68
    JP.go.ipa.oz.lib.standard._MenuItem_if itemSave = null;
// 69
    JP.go.ipa.oz.lib.standard._MenuItem_if item1 = null, item2 = null;
// 70
    JP.go.ipa.oz.user.ide.SubjectSummaryBrowserMenuListener_if listener = null;
// 72
    listener = (JP.go.ipa.oz.user.ide.SubjectSummaryBrowserMenuListener_cl) (new JP.go.ipa.oz.user.ide.SubjectSummaryBrowserMenuListener_cl ())._new_create (sgBrowser, ssBrowser);
// 74
    menu = (JP.go.ipa.oz.lib.standard._Menu_cl) (new JP.go.ipa.oz.lib.standard._Menu_cl ())._new_newMenu ((new JP.go.ipa.oz.lib.standard._String_cl("System")));
// 75
    if (forBrowse) {{
// 76
        itemSave = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("save")));
// 77
        item1 = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("import")));
// 78
        item2 = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("close")));
// 79
        itemSave.addActionListener (listener);
// 80
        itemSave.setEnabled (true);
// 85
        menu.add (itemSave);
// 86
        menu.add (item1);
// 87
        menu.addSeparator ();
// 88
        menu.add (item2);
      }
    } else {{
// 91
        item1 = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("export")));
// 92
        item2 = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("cancel")));
// 93
        menu.add (item1);
// 94
        menu.addSeparator ();
// 95
        menu.add (item2);
      }
    }
// 98
    item1.addActionListener (listener);
// 99
    item2.addActionListener (listener);
// 101
    return menu;
  }
  
  public SubjectSummaryBrowserMenuBar_cl () throws Exception { super (); }
  
}

