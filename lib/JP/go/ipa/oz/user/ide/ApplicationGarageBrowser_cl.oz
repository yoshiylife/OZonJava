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
 * ApplicationGarageBrowser
 *
 * @version  1.1
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

class ApplicationGarageBrowser
  : *GarageBrowser
{

  ApplicationGarage                catalog;
  ApplicationGarageBrowserGUI      gui;
  condition                        waitForInput;
  ApplicationSummary               summaryToExport;
  Dictionary                       summaryViewTable;
  EventDispatchingQueue            dialogQue;

  SchoolBrowser                    schoolBrowser;
  LauncherCore                     launcher;
  LauncherCellInformationDialog    launcherCellDialog;


  
  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new create()
  {
    super => create();
  }


  //--------------------------------------------------------------------
  new create(SchoolBrowser sb)
  {
    super => create();
    schoolBrowser = sb;
    launcher = null;
    init();
  }


  //--------------------------------------------------------------------
  new create(LauncherCore lc)
  {
    super => create();
    launcher = lc;
    launcherCellDialog = null;
    schoolBrowser = null;
    init();
  }


  //--------------------------------------------------------------------
  new create(LauncherCellInformationDialog ld)
  {
    super => create();
    launcher = null;
    launcherCellDialog = ld;
    schoolBrowser = null;
    init();
  }


  /////////////////////////////////////////////////////// public methods


  //--------------------------------------------------------------------
  public void bindServer(String gol)
  {
    if (gol != null) {
      super->bindServer(gol);
      catalog => bind(gol);
      if (gui != null) {
        gui->setServerGOL(gol);
        sync();
      }
    }
  }


  //--------------------------------------------------------------------
  public locked void exportReady(ApplicationSummary s)
  {
    summaryToExport = s;
    signal(waitForInput);
  }


  //--------------------------------------------------------------------
  public locked Key exportApplication(Application app)
  {
    Key  key;
    GarageException  gEx;
    GarageOperationCanceledException  gopEx;
    ApplicationSummary  summary;

    launch();
    gui->inputSummary(app);
    wait(waitForInput);
      // blocking... until the user inputs data or cancel to export

    if (summaryToExport == null) {
      gopEx => create("Export operation canceled");
      throw gopEx;
    }

    if (catalog == null) {
      requestGOL("catalog GOL:");
    }
    if (catalog == null) {
      gEx => create("Invalid GOL");
      throw gEx;
    }

    try {
      key = put(app, summaryToExport);
    } catch (CellNotFoundException ex) {
      gEx => create("Catalog access failed");
      throw gEx;
    } catch (Root o) {
      gEx => create("Catalog access failed");
      throw gEx;
    }

    summary =| catalog->getSummary(key);
    gui->add(summary);

    return key;
  }


  //--------------------------------------------------------------------
  public Frame getGUI()
  {
    return gui;
  }


  //--------------------------------------------------------------------
  public void hideSummary()
  {
    Iterator  itr;
    ApplicationSummaryBrowser  summaryBrowser;

    if (summaryViewTable != null && summaryViewTable->size() > 0) {
      itr = summaryViewTable->iterator();
      while (itr->hasMoreElements()) {
        summaryBrowser =| itr->nextElement();
        summaryBrowser->dispose();
      }
      summaryViewTable->clear();
    }
  }

  
  //--------------------------------------------------------------------
  public void hideSummary(Key key)
  {
    ApplicationSummaryBrowser  summaryBrowser;

    if (summaryViewTable != null && summaryViewTable->size() > 0) {
      summaryBrowser =| summaryViewTable->get(key);
      if (summaryBrowser != null) {
        summaryViewTable->remove(key);
        summaryBrowser->dispose();
      }
    }
  }

  
  //--------------------------------------------------------------------
  public void importApplication()
  {
    launch();
  }


  //--------------------------------------------------------------------
  public void importApplication(ApplicationSummary summary)
  {
    Application  app;
    String  cid;

    if (launcherCellDialog != null || launcher != null) {
      try {
        app = summary->retreiveApplication();
        cid = app->getClassID();
        if (launcherCellDialog != null) {
          launcherCellDialog->setCID(cid);
          launcherCellDialog->setCatalogGOL(getServerGOL());
        } else if (launcher != null) {
          launcher->createCell(cid);
        }
        quit();
      } catch (CellNotFoundException ex) {
        /* catalog is not active or not exist */
      } catch (ClassNotFoundException ex) {
        /* class file transfer failed */
      } catch (Root o) {
        /* other exception */
      }

    }
  }


  //--------------------------------------------------------------------
  public void launch()
  {
    KeyComparator  keyComp;

    if (gui == null) {
      gui => create(this);
      dialogQue => create();
      keyComp => create();
      summaryViewTable => create(keyComp);
    }

    gui->setVisible(true);
    sync();
  }


  //--------------------------------------------------------------------
  public void quit()
  {
    hideSummary();

    if (gui != null) {
      gui->dispose();
    }
    gui = null;
    summaryViewTable = null;
    catalog = null;
  }


  //--------------------------------------------------------------------
  public void remove(Key key)
  {
    hideSummary(key);
    catalog->remove(key);
    gui->remove(key);
  }


  //--------------------------------------------------------------------
  public void setVisible(boolean visible)
  {
    Iterator  itr;
    ApplicationSummaryBrowser  summaryBrowser;

    if (!visible) {
      hideSummary();
    }
      
    if (gui != null) {
      gui->setVisible(visible);
    }
  }


  //--------------------------------------------------------------------
  public void showSummary()
  {
    ApplicationSummary  summary;

    if (gui != null) {
      summary = gui->getSelectedSummary();
      if (summary != null) {
        showSummary(summary);
      }
    }
  }


  //--------------------------------------------------------------------
  public void showSummary(ApplicationSummary summary)
  {
    ApplicationSummaryBrowser  summaryBrowser;
    Key  key;

    if (gui != null && summary != null) {
      key = summary->getKey();
      summaryBrowser =| summaryViewTable->get(key);
      if (summaryBrowser == null) {
        summaryBrowser => create(summary, this);
        summaryViewTable->put(key, summaryBrowser);
        summaryBrowser->show();
      } else {
        summaryBrowser->show();
      }
    }
  }


  //--------------------------------------------------------------------
  public void sync()
  {
    Iterator  itr;
    ApplicationSummary  summary;
    Set  summarySet;

    if (catalog != null && gui != null) {
      summarySet => create();
      itr = catalog->summaryIterator();
      while (itr->hasMoreElements()) {
        summary =| itr->nextElement();
        summarySet->add(summary);
      }

      gui->list(summarySet);
      gui->toFront();
    }
  }



  ////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  void init()
  {
  }



  //--------------------------------------------------------------------
  void requestGOL(String message)
  {
    StringInputDialog  dialog;
    GOLInputListenerForApplication  listener;
    EventDispatchingQueue  eq;

    eq => create();
    listener => create(this, eq);
    dialog => create(gui, "GOL Input Dialog", message, 50, true);
    dialog->addStringInputListener(listener);
    dialog->show();
  }


  //--------------------------------------------------------------------
  void showException(String msg)
  {
    ExceptionDialog  exDialog;

    exDialog => create(gui, msg, dialogQue);
  }

}


// EoF

