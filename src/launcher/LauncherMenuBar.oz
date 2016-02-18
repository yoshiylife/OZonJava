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

// OZ DEV


/**
 * LauncherMenuBar
 *
 * @version  0.9
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

class LauncherMenuBar
  : *MenuBar
{

  LauncherCore             lCore;

  Menu                     menuSystem;
  Menu                     menuCell;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new create(LauncherCore lchr)
  {
    LauncherMenuListener     listener;
    EventDispatchingQueue    eq;
                         // dispatching menu item select events

    super => newMenuBar();

    lCore = lchr;
    eq => create();
    listener => create(lCore, eq);

    menuSystem = mkSystemMenu(listener);
    menuCell = mkCellMenu(listener);

    add(menuSystem);
    add(menuCell);
  }


  /////////////////////////////////////////////////////// public methods

  ////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  Menu mkSystemMenu(ActionListener listener)
  {
    Menu  menu;
    MenuItem  item1, item2;

    menu => newMenu("System");

    item1 => newMenuItem("refresh");
    item2 => newMenuItem("quit");
    item1->addActionListener(listener);
    item2->addActionListener(listener);
    menu->add(item1);
    menu->addSeparator();
    menu->add(item2);

    return menu;
  }


  //--------------------------------------------------------------------
  Menu mkCellMenu(ActionListener listener)
  {
    Menu  menu;
    MenuItem  item1, item2;

    menu => newMenu("Cell");
    item1 => newMenuItem("new cell");
    item2 => newMenuItem("start cell");
    item1->addActionListener(listener);
    item2->addActionListener(listener);
    menu->add(item1);
    menu->add(item2);

    return menu;
  }

}

// EoF

