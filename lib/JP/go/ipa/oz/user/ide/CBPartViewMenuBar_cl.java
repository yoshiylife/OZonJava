package JP.go.ipa.oz.user.ide;

final public class CBPartViewMenuBar_cl extends JP.go.ipa.oz.lib.standard._MenuBar_cl implements JP.go.ipa.oz.user.ide.CBPartViewMenuBar_if {
  static final boolean _final_ = true;
  JP.go.ipa.oz.user.ide.CBPartView_if partView;
  JP.go.ipa.oz.lib.standard._Menu_if menuSystem;
  JP.go.ipa.oz.lib.standard._Menu_if menuHierarchy;
  JP.go.ipa.oz.lib.standard._System_if system;
  JP.go.ipa.oz.user.ide.CIImplementationPart_if targetImplPart;
  JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if hierarchyEventQue;
  JP.go.ipa.oz.user.ide.CIInterfacePart_if targetIfPart;
  boolean isImpl;
  JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if systemEventQue;
  
  public Object _new_newCBPartFrameMenuBar (JP.go.ipa.oz.user.ide.CBPartView_if pv) throws Exception  {
// 33
    super._new_newMenuBar ();
// 35
    partView = pv;
// 37
    menuSystem = mkSystemMenu ();
// 38
    menuHierarchy = mkHierarchyMenu ();
// 39
    add (menuSystem);
// 40
    add (menuHierarchy);
    return this;
  }
  
  JP.go.ipa.oz.lib.standard._Menu_if mkSystemMenu () throws Exception  {
// 47
    JP.go.ipa.oz.lib.standard._Menu_if menu = null;
// 48
    JP.go.ipa.oz.lib.standard._MenuItem_if itemOpen = null, itemClose = null, itemCloseAll = null;
// 49
    JP.go.ipa.oz.user.ide.CBSystemMenuListener_if systemMenuListener = null;
// 51
    menu = (JP.go.ipa.oz.lib.standard._Menu_cl) (new JP.go.ipa.oz.lib.standard._Menu_cl ())._new_newMenu ((new JP.go.ipa.oz.lib.standard._String_cl("System")));
// 52
    itemOpen = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("open")));
// 53
    itemClose = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("close")));
// 54
    itemCloseAll = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("close all")));
// 55
    menu.add (itemOpen);
// 56
    menu.addSeparator ();
// 57
    menu.add (itemClose);
// 58
    menu.add (itemCloseAll);
// 60
    systemEventQue = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 61
    systemMenuListener = (JP.go.ipa.oz.user.ide.CBSystemMenuListener_cl) (new JP.go.ipa.oz.user.ide.CBSystemMenuListener_cl ())._new_newCBSystemMenuListener (partView, systemEventQue);
// 62
    itemOpen.addActionListener (systemMenuListener);
// 63
    itemClose.addActionListener (systemMenuListener);
// 64
    itemCloseAll.addActionListener (systemMenuListener);
// 66
    return menu;
  }
  
  JP.go.ipa.oz.lib.standard._Menu_if mkHierarchyMenu () throws Exception  {
// 73
    JP.go.ipa.oz.lib.standard._Menu_if menu = null;
// 74
    JP.go.ipa.oz.lib.standard._MenuItem_if itemAncestors = null;
// 75
    JP.go.ipa.oz.user.ide.CBHierarchyMenuListener_if hierarchyMenuListener = null;
// 77
    menu = (JP.go.ipa.oz.lib.standard._Menu_cl) (new JP.go.ipa.oz.lib.standard._Menu_cl ())._new_newMenu ((new JP.go.ipa.oz.lib.standard._String_cl("Hierarchy")));
// 78
    itemAncestors = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("ancestors")));
// 79
    menu.add (itemAncestors);
// 81
    hierarchyEventQue = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 82
    hierarchyMenuListener = (JP.go.ipa.oz.user.ide.CBHierarchyMenuListener_cl) (new JP.go.ipa.oz.user.ide.CBHierarchyMenuListener_cl ())._new_newCBHierarchyMenuListener (partView, hierarchyEventQue);
// 84
    itemAncestors.addActionListener (hierarchyMenuListener);
// 86
    return menu;
  }
  
  public CBPartViewMenuBar_cl () throws Exception { super (); }
  
}

