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
 * SubjectGarageBrowser
 *
 * @version  1.2
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

class SubjectGarageBrowser
  : *GarageBrowser
{

  SubjectGarage                    sGarage;
  SubjectGarageBrowserGUI          gui;
  condition                        waitForInput;
  SubjectSummary                   ssToExport;
  Dictionary                       ssViewTable;
  EventDispatchingQueue            dialogQue;

  ClassLoader                      classLoader;
  SchoolBrowser                    schoolBrowser;

  System                           system;

  
  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new create()
  {
    super => create();
    system => create();
  }


  //--------------------------------------------------------------------
  new create(String gol)
  {
    super => create(gol);
    system => create();
    init(null, gol);
  }


  //--------------------------------------------------------------------
  new create(SchoolBrowser sb)
  {
    super => create();
    system => create();
    init(sb, null);
  }


  //--------------------------------------------------------------------
  new create(SchoolBrowser sb, String gol)
  {
    super => create(gol);
    system => create();
    init(sb, gol);
  }


  /////////////////////////////////////////////////////// public methods


  //--------------------------------------------------------------------
  public void bindServer(String gol)
  {
    if (gol != null) {
      super->bindServer(gol);
      sGarage => bind(gol);
      if (gui != null) {
        gui->setServerGOL(gol);
        sync();
      }
    }
  }


  //--------------------------------------------------------------------
  public locked void exportReady(SubjectSummary ss)
  {
    ssToExport = ss;
    signal(waitForInput);
  }


  //--------------------------------------------------------------------
  public locked Key exportSubject(Subject sbj)
  {
    Key  key;
    GarageException  gEx;
    GarageOperationCanceledException  gopEx;
    SubjectSummary  ss;

    launch();
    gui->inputSummary(sbj);
    wait(waitForInput);
      // blocking... until the user inputs data or cancel to export

    if (ssToExport == null) {
      gopEx => create("Export operation canceled");
      throw gopEx;
    }

    if (sGarage == null) {
      requestGOL("catalog GOL:");
    }
    if (sGarage == null) {
      gEx => create("Invalid GOL");
      throw gEx;
    }

    try {
      key = put(sbj, ssToExport);
    } catch (CellNotFoundException ex) {
      gEx => create("Catalog access failed");
      throw gEx;
    } catch (Root o) {
      gEx => create("Catalog access failed");
      throw gEx;
    }

    ss =| sGarage->getSummary(key);
    gui->add(ss);

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
    SubjectSummaryBrowser  ssBrowser;

    if (ssViewTable != null && ssViewTable->size() > 0) {
      itr = ssViewTable->iterator();
      while (itr->hasMoreElements()) {
        ssBrowser =| itr->nextElement();
        ssBrowser->dispose();
      }
      ssViewTable->clear();
    }
  }

  
  //--------------------------------------------------------------------
  public void hideSummary(Key key)
  {
    SubjectSummaryBrowser  ssBrowser;

    if (ssViewTable != null && ssViewTable->size() > 0) {
      ssBrowser =| ssViewTable->get(key);
      if (ssBrowser != null) {
        ssViewTable->remove(key);
        ssBrowser->dispose();
      }
    }
  }

  
  //--------------------------------------------------------------------
  public void importSubject()
  {
    launch();
  }


  //--------------------------------------------------------------------
  public void importSubject(SubjectSummary ss)
  {
    Subject  sbj;

    try {
      sbj = ss->retreiveSubject();
      fetchClassFile(sbj);
      schoolBrowser->mergeSubject(sbj);
    } catch (CellNotFoundException ex) {
      /* catalog is not active or not exist */
    } catch (ClassNotFoundException ex) {
      /* class file transfer failed */
    } catch (Root o) {
      /* other exception */
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
      ssViewTable => create(keyComp);
    }

    if (classLoader == null) {
      classLoader => create();
    }

    gui->setVisible(true);
  }


  //--------------------------------------------------------------------
  public void quit()
  {
    hideSummary();

    if (gui != null) {
      gui->dispose();
    }
    gui = null;
    ssViewTable = null;
    classLoader = null;
    sGarage = null;
  }


  //--------------------------------------------------------------------
  public void remove(Key key)
  {
    hideSummary(key);
    sGarage->remove(key);
    gui->remove(key);
  }


  //--------------------------------------------------------------------
  public void setVisible(boolean visible)
  {
    Iterator  itr;
    SubjectSummaryBrowser  ssBrowser;

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
    SubjectSummary  ss;

    if (gui != null) {
      ss = gui->getSelectedSummary();
      if (ss != null) {
        showSummary(ss);
      }
    }
  }


  //--------------------------------------------------------------------
  public void showSummary(SubjectSummary ss)
  {
    SubjectSummaryBrowser  ssBrowser;
    Key  key;

    if (gui != null && ss != null) {
      key = ss->getKey();
      ssBrowser =| ssViewTable->get(key);
      if (ssBrowser == null) {
        ssBrowser => create(ss, this);
        ssViewTable->put(key, ssBrowser);
        ssBrowser->show();
      } else {
        ssBrowser->show();
      }
    }
  }


  //--------------------------------------------------------------------
  public void sync()
  {
    Iterator  itr;
    SubjectSummary  ss;
    Set  ssSet;

    if (sGarage != null && gui != null) {
      ssSet => create();
      itr = sGarage->summaryIterator();
      while (itr->hasMoreElements()) {
        ss =| itr->nextElement();
        ssSet->add(ss);
      }

      gui->list(ssSet);
    }
  }



  ////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  void fetchClassFile(Subject sbj)
  {
    String  pkgName;

    pkgName = sbj->getPackageName();
    classLoader->loadPackage(pkgName);
  }


  //--------------------------------------------------------------------
  void init(SchoolBrowser sb, String gol)
  {
    schoolBrowser = sb;
    if (gol != null) {
      try {
        bindServer(gol);
      } catch (IllegalArgumentException ex) {
      } catch (Root o) {
        /* nothing to do */
      }
    }
  }


  //--------------------------------------------------------------------
  Key put(Subject sbj, SubjectSummary ss)
  {
    Key  key;

    sbj->setSummary(ss);
    key = sGarage->putSubject(sbj);

    return key;
  }


  //--------------------------------------------------------------------
  void requestGOL(String message)
  {
    StringInputDialog  dialog;
    GOLInputListenerForSubject  listener;
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

