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

// OZ


/**
 * SubjectGarageBrowserMenuBar
 *
 * @version  0.9
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

class SubjectGarageBrowserMenuBar
  : *MenuBar
{

  SubjectGarageBrowser     sgBrowser;

  Menu                     menuSystem;
  Menu                     menuSubject;
  Menu                     menuCatalog;
  SubjectGarageBrowserMenuListener  listener;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new create(SubjectGarageBrowser sgb)
  {

    super => newMenuBar();

    sgBrowser = sgb;
    listener => create(sgBrowser);
    menuSystem = mkSystemMenu(listener);
    menuSubject = mkSubjectMenu(listener);
    menuCatalog = mkCatalogMenu(listener);
    add(menuSystem);
    add(menuSubject);
    add(menuCatalog);
  }


  /////////////////////////////////////////////////////// public methods

  ////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  Menu mkSystemMenu(ActionListener listener)
  {
    Menu  menu;
    MenuItem  item1, item2, item3;

    menu => newMenu("System");
    item1 => newMenuItem("refresh");
    item2 => newMenuItem("close");
    item1->addActionListener(listener);
    item2->addActionListener(listener);
    menu->add(item1);
    menu->addSeparator();
    menu->add(item2);

    return menu;
  }

  //--------------------------------------------------------------------
  Menu mkSubjectMenu(ActionListener listener)
  {
    Menu  menu;
    MenuItem  item1, item2, item3;

    menu => newMenu("Subject");
    item1 => newMenuItem("show summary");
    item2 => newMenuItem("import");
    item3 => newMenuItem("remove");
    item1->addActionListener(listener);
    item2->addActionListener(listener);
    item3->addActionListener(listener);
    menu->add(item1);
    menu->add(item2);
    menu->addSeparator();
    menu->add(item3);

    return menu;
  }


  //--------------------------------------------------------------------
  Menu mkCatalogMenu(ActionListener listener)
  {
    Menu  menu, submenu;
    MenuItem  item1, item2;

    menu => newMenu("Catalog");
    submenu => newMenu("connect");
    menu->add(submenu);

    item1 => newMenuItem("input GOL");
    item2 => newMenuItem("contact to trader");
    item1->addActionListener(listener);
    item2->addActionListener(listener);
    item2->setEnabled(false);
    submenu->add(item1);
    submenu->add(item2);

    return menu;
  }

}

// EoF

