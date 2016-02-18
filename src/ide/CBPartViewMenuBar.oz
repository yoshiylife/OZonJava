/*
 Copyright(c) 1996-1998
 IPA, ETL, AT21, FSIABC, FXIS, InArc, MRI, NUL, SBC, Sharp, TEC, TIS

 All rights reserved.  No guarantee.
 This technology is a result of the Advanced Software  Enrichment 
 Project of Information-technology Promotion Agency, Japan (IPA).

 Permissions  to  use,  copy, modify and distribute this software
 are governed by the terms and conditions set forth in  the  file 
 COPYRIGHT, located on the top directory of this software.
 */

// OZ DEV: Class Browser


/**
 * CBPartViewMenuBar
 *
 * @version  $Id$
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

final class CBPartViewMenuBar
  : *MenuBar
{

  CBPartView  partView;
  EventDispatchingQueue  systemEventQue, hierarchyEventQue;
                         // dispatching menu item select events
  Menu  menuSystem, menuHierarchy;

  // for better performance
  boolean  isImpl;
  CIInterfacePart  targetIfPart;
  CIImplementationPart  targetImplPart;

  System  system;


  //////////////////////////////////////////////////// constructors

  //------------------------------------------------------------------
  new newCBPartFrameMenuBar(CBPartView pv)
  {
    super => newMenuBar();

    partView = pv;

    menuSystem = mkSystemMenu();
    menuHierarchy = mkHierarchyMenu();
    add(menuSystem);
    add(menuHierarchy);
  }


  //------------------------------------------------------------------
  Menu mkSystemMenu()
  {
    Menu  menu;
    MenuItem  itemOpen, itemClose, itemCloseAll;
    CBSystemMenuListener  systemMenuListener;

    menu => newMenu("System");
    itemOpen => newMenuItem("open");
    itemClose => newMenuItem("close");
    itemCloseAll => newMenuItem("close all");
    menu->add(itemOpen);
    menu->addSeparator();
    menu->add(itemClose);
    menu->add(itemCloseAll);

    systemEventQue => create();
    systemMenuListener => newCBSystemMenuListener(partView, systemEventQue);
    itemOpen->addActionListener(systemMenuListener);
    itemClose->addActionListener(systemMenuListener);
    itemCloseAll->addActionListener(systemMenuListener);

    return menu;
  }

  
  //------------------------------------------------------------------
  Menu mkHierarchyMenu()
  {
    Menu  menu;
    MenuItem  itemAncestors;
    CBHierarchyMenuListener  hierarchyMenuListener;

    menu => newMenu("Hierarchy");
    itemAncestors => newMenuItem("ancestors");
    menu->add(itemAncestors);

    hierarchyEventQue => create();
    hierarchyMenuListener => newCBHierarchyMenuListener(partView,
                                                        hierarchyEventQue);
    itemAncestors->addActionListener(hierarchyMenuListener);

    return menu;
  }

}

// EoF

