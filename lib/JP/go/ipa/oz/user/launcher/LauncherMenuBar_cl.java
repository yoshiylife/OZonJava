package JP.go.ipa.oz.user.launcher;

public class LauncherMenuBar_cl extends JP.go.ipa.oz.lib.standard._MenuBar_cl implements JP.go.ipa.oz.user.launcher.LauncherMenuBar_if {
  JP.go.ipa.oz.user.launcher.LauncherCore_if lCore;
  JP.go.ipa.oz.lib.standard._Menu_if menuSystem;
  JP.go.ipa.oz.lib.standard._Menu_if menuCell;
  
  public Object _new_create (JP.go.ipa.oz.user.launcher.LauncherCore_if lchr) throws Exception  {
// 26
    JP.go.ipa.oz.user.launcher.LauncherMenuListener_if listener = null;
// 27
    JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if eq = null;
// 30
    super._new_newMenuBar ();
// 32
    lCore = lchr;
// 33
    eq = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 34
    listener = (JP.go.ipa.oz.user.launcher.LauncherMenuListener_cl) (new JP.go.ipa.oz.user.launcher.LauncherMenuListener_cl ())._new_create (lCore, eq);
// 36
    menuSystem = mkSystemMenu (listener);
// 37
    menuCell = mkCellMenu (listener);
// 39
    add (menuSystem);
// 40
    add (menuCell);
    return this;
  }
  
  JP.go.ipa.oz.lib.standard._Menu_if mkSystemMenu (JP.go.ipa.oz.lib.standard._ActionListener_if listener) throws Exception  {
// 51
    JP.go.ipa.oz.lib.standard._Menu_if menu = null;
// 52
    JP.go.ipa.oz.lib.standard._MenuItem_if item1 = null, item2 = null;
// 54
    menu = (JP.go.ipa.oz.lib.standard._Menu_cl) (new JP.go.ipa.oz.lib.standard._Menu_cl ())._new_newMenu ((new JP.go.ipa.oz.lib.standard._String_cl("System")));
// 56
    item1 = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("refresh")));
// 57
    item2 = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("quit")));
// 58
    item1.addActionListener (listener);
// 59
    item2.addActionListener (listener);
// 60
    menu.add (item1);
// 61
    menu.addSeparator ();
// 62
    menu.add (item2);
// 64
    return menu;
  }
  
  JP.go.ipa.oz.lib.standard._Menu_if mkCellMenu (JP.go.ipa.oz.lib.standard._ActionListener_if listener) throws Exception  {
// 71
    JP.go.ipa.oz.lib.standard._Menu_if menu = null;
// 72
    JP.go.ipa.oz.lib.standard._MenuItem_if item1 = null, item2 = null;
// 74
    menu = (JP.go.ipa.oz.lib.standard._Menu_cl) (new JP.go.ipa.oz.lib.standard._Menu_cl ())._new_newMenu ((new JP.go.ipa.oz.lib.standard._String_cl("Cell")));
// 75
    item1 = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("new cell")));
// 76
    item2 = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("start cell")));
// 77
    item1.addActionListener (listener);
// 78
    item2.addActionListener (listener);
// 79
    menu.add (item1);
// 80
    menu.add (item2);
// 82
    return menu;
  }
  
  public LauncherMenuBar_cl () throws Exception { super (); }
  
}

