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
 * ApplicationGarageBrowserMenuListener
 *
 * @version  0.9
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

class ApplicationGarageBrowserMenuListener
  : *ActionListener
{

  ApplicationGarageBrowser   gBrowser;

  EventDispatchingQueue  dialogQue;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new create(ApplicationGarageBrowser gb)
  {
    EventDispatchingQueue  eq;

    eq => create();
    super => newActionListener(eq);
    gBrowser = gb;
    dialogQue => create();
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public void actionPerformed(ActionEvent evt)
  {
    String  cmd;

    cmd = evt->getActionCommand();

    if (cmd->isequal("close")) {
      execClose();
    } else if (cmd->isequal("import")) {
      execImport();
    } else if (cmd->isequal("input GOL")) {
      execInputGOL();
    } else if (cmd->isequal("refresh")) {
      execRefresh();
    } else if (cmd->isequal("remove")) {
      execRemove();
    } else if (cmd->isequal("show summary")) {
      execShowSummary();
    } else if (cmd->isequal("contact to trader")) {
    }
  }


  ////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  void handleException(String msg)
  {
    ExceptionDialog  exDialog;

    exDialog => create(gBrowser->getGUI(), msg, dialogQue);
  }


  //--------------------------------------------------------------------
  void execClose()
  {
    gBrowser->setVisible(false);
  }


  //--------------------------------------------------------------------
  void execImport()
  {
    ApplicationGarageBrowserGUI  gui;
    ApplicationSummary  summary;

    gui =| gBrowser->getGUI();
    if (gui != null) {
      summary = gui->getSelectedSummary();
      gBrowser->importApplication(summary);
    }
  }


  //--------------------------------------------------------------------
  void execInputGOL()
  {
    StringInputDialog  dialog;
    GOLInputListenerForApplication  listener;
    EventDispatchingQueue  eq;

    eq => create();
    listener => create(gBrowser, eq);
    dialog => create(gBrowser->getGUI(), "GOL Input Dialog",
                     "catalog GOL:",
                     50, true);
    dialog->addStringInputListener(listener);
    dialog->show();
  }


  //--------------------------------------------------------------------
  void execRefresh()
  {
    try {
      gBrowser->sync();
    } catch (GarageException ex) {
      handleException(ex->getMessage());
    } catch (CellNotFoundException ex) {
      handleException("catalog not found");
    } catch (Root o) {
      handleException("refresh failed");
    }
  }


  //--------------------------------------------------------------------
  void execRemove()
  {
    ApplicationGarageBrowserGUI  gui;
    ApplicationSummary  summary;

    gui =| gBrowser->getGUI();
    summary = gui->getSelectedSummary();
    if (summary != null) {
      gBrowser->remove(summary->getKey());
    }
  }


  //--------------------------------------------------------------------
  void execShowSummary()
  {
    ApplicationGarageBrowserGUI  gui;
    ApplicationSummary  summary;

    gui =| gBrowser->getGUI();
    summary = gui->getSelectedSummary();
    if (summary != null) {
      gBrowser->showSummary(summary);
    }
  }

}

// EoF

