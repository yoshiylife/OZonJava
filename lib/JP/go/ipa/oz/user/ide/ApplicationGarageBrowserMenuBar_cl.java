package JP.go.ipa.oz.user.ide;

public class ApplicationGarageBrowserMenuBar_cl extends JP.go.ipa.oz.lib.standard._MenuBar_cl implements JP.go.ipa.oz.user.ide.ApplicationGarageBrowserMenuBar_if {
  JP.go.ipa.oz.lib.standard._Menu_if menuSystem;
  JP.go.ipa.oz.lib.standard._Menu_if menuApplication;
  JP.go.ipa.oz.user.ide.ApplicationGarageBrowser_if gBrowser;
  JP.go.ipa.oz.user.ide.ApplicationGarageBrowserMenuListener_if listener;
  JP.go.ipa.oz.lib.standard._Menu_if menuCatalog;
  
  public Object _new_create (JP.go.ipa.oz.user.ide.ApplicationGarageBrowser_if gb) throws Exception  {
// 42
    super._new_newMenuBar ();
// 44
    gBrowser = gb;
// 45
    listener = (JP.go.ipa.oz.user.ide.ApplicationGarageBrowserMenuListener_cl) (new JP.go.ipa.oz.user.ide.ApplicationGarageBrowserMenuListener_cl ())._new_create (gBrowser);
// 46
    menuSystem = mkSystemMenu (listener);
// 47
    menuApplication = mkApplicationMenu (listener);
// 48
    menuCatalog = mkCatalogMenu (listener);
// 49
    add (menuSystem);
// 50
    add (menuApplication);
// 51
    add (menuCatalog);
    return this;
  }
  
  JP.go.ipa.oz.lib.standard._Menu_if mkApplicationMenu (JP.go.ipa.oz.lib.standard._ActionListener_if listener) throws Exception  {
// 80
    JP.go.ipa.oz.lib.standard._Menu_if menu = null;
// 81
    JP.go.ipa.oz.lib.standard._MenuItem_if item1 = null, item2 = null, item3 = null;
// 83
    menu = (JP.go.ipa.oz.lib.standard._Menu_cl) (new JP.go.ipa.oz.lib.standard._Menu_cl ())._new_newMenu ((new JP.go.ipa.oz.lib.standard._String_cl("Application")));
// 84
    item1 = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("show summary")));
// 85
    item2 = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("import")));
// 86
    item3 = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("remove")));
// 87
    item1.addActionListener (listener);
// 88
    item2.addActionListener (listener);
// 89
    item3.addActionListener (listener);
// 90
    menu.add (item1);
// 91
    menu.add (item2);
// 92
    menu.addSeparator ();
// 93
    menu.add (item3);
// 95
    return menu;
  }
  
  JP.go.ipa.oz.lib.standard._Menu_if mkSystemMenu (JP.go.ipa.oz.lib.standard._ActionListener_if listener) throws Exception  {
// 62
    JP.go.ipa.oz.lib.standard._Menu_if menu = null;
// 63
    JP.go.ipa.oz.lib.standard._MenuItem_if item1 = null, item2 = null, item3 = null;
// 65
    menu = (JP.go.ipa.oz.lib.standard._Menu_cl) (new JP.go.ipa.oz.lib.standard._Menu_cl ())._new_newMenu ((new JP.go.ipa.oz.lib.standard._String_cl("System")));
// 66
    item1 = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("refresh")));
// 67
    item2 = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("close")));
// 68
    item1.addActionListener (listener);
// 69
    item2.addActionListener (listener);
// 70
    menu.add (item1);
// 71
    menu.addSeparator ();
// 72
    menu.add (item2);
// 74
    return menu;
  }
  
  JP.go.ipa.oz.lib.standard._Menu_if mkCatalogMenu (JP.go.ipa.oz.lib.standard._ActionListener_if listener) throws Exception  {
// 102
    JP.go.ipa.oz.lib.standard._Menu_if menu = null, submenu = null;
// 103
    JP.go.ipa.oz.lib.standard._MenuItem_if item1 = null, item2 = null;
// 105
    menu = (JP.go.ipa.oz.lib.standard._Menu_cl) (new JP.go.ipa.oz.lib.standard._Menu_cl ())._new_newMenu ((new JP.go.ipa.oz.lib.standard._String_cl("Catalog")));
// 106
    submenu = (JP.go.ipa.oz.lib.standard._Menu_cl) (new JP.go.ipa.oz.lib.standard._Menu_cl ())._new_newMenu ((new JP.go.ipa.oz.lib.standard._String_cl("connect")));
// 107
    menu.add (submenu);
// 109
    item1 = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("input GOL")));
// 110
    item2 = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("contact to trader")));
// 111
    item1.addActionListener (listener);
// 112
    item2.addActionListener (listener);
// 113
    item2.setEnabled (false);
// 114
    submenu.add (item1);
// 115
    submenu.add (item2);
// 117
    return menu;
  }
  
  public ApplicationGarageBrowserMenuBar_cl () throws Exception { super (); }
  
}

