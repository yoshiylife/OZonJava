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
 * SubjectSummaryBrowserMenuBar
 *
 * @version  0.9
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

class SubjectSummaryBrowserMenuBar
  : *MenuBar
{

  SubjectGarageBrowser     sgBrowser;
  SubjectSummaryBrowser    ssBrowser;

  Menu                     menuSystem;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new createBrowseMenu(SubjectGarageBrowser sgb, SubjectSummaryBrowser ssb)
  {
    super => newMenuBar();

    sgBrowser = sgb;
    ssBrowser = ssb;
    menuSystem = mkSystemMenu(true);
    add(menuSystem);
  }


  //--------------------------------------------------------------------
  new createExportMenu(SubjectGarageBrowser sgb, SubjectSummaryBrowser ssb)
  {
    super => newMenuBar();

    sgBrowser = sgb;
    ssBrowser = ssb;
    menuSystem = mkSystemMenu(false);
    add(menuSystem);
  }


  /////////////////////////////////////////////////////// public methods

  ////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  Menu mkSystemMenu(boolean forBrowse)
  {
    Menu  menu;
    MenuItem  itemSave;
    MenuItem  item1, item2;
    SubjectSummaryBrowserMenuListener  listener;

    listener => create(sgBrowser, ssBrowser);

    menu => newMenu("System");
    if (forBrowse) {
      itemSave => newMenuItem("save");
      item1 => newMenuItem("import");
      item2 => newMenuItem("close");
      itemSave->addActionListener(listener);
      itemSave->setEnabled(true);
      /**
       * "save" item is required only when the contents is modified.
       * However, in this version, I don't care.
       */
      menu->add(itemSave);
      menu->add(item1);
      menu->addSeparator();
      menu->add(item2);

    } else {
      item1 => newMenuItem("export");
      item2 => newMenuItem("cancel");
      menu->add(item1);
      menu->addSeparator();
      menu->add(item2);
    }

    item1->addActionListener(listener);
    item2->addActionListener(listener);

    return menu;
  }

}

// EoF

