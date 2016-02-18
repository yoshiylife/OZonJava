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
 * SubjectGarageBrowserMenuListener
 *
 * @version  1.1
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

class SubjectGarageBrowserMenuListener
  : *ActionListener
{

  SubjectGarageBrowser   sgBrowser;
  EventDispatchingQueue  dialogQue;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new create(SubjectGarageBrowser sgb)
  {
    EventDispatchingQueue  eq;

    eq => create();
    super => newActionListener(eq);
    sgBrowser = sgb;
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

    exDialog => create(sgBrowser->getGUI(), msg, dialogQue);
  }


  //--------------------------------------------------------------------
  void execClose()
  {
    sgBrowser->setVisible(false);
  }


  //--------------------------------------------------------------------
  void execImport()
  {
    sgBrowser->importSubject();
  }


  //--------------------------------------------------------------------
  void execInputGOL()
  {
    StringInputDialog  dialog;
    GOLInputListenerForSubject  listener;
    EventDispatchingQueue  eq;

    eq => create();
    listener => create(sgBrowser, eq);
    dialog => create(sgBrowser->getGUI(), "GOL Input Dialog",
                     "catalog GOL:", 50, true);
    dialog->addStringInputListener(listener);
    dialog->show();
  }


  //--------------------------------------------------------------------
  void execRefresh()
  {
    try {
      sgBrowser->sync();
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
    SubjectGarageBrowserGUI  gui;
    SubjectSummary  ss;

    gui =| sgBrowser->getGUI();
    ss = gui->getSelectedSummary();
    if (ss != null) {
      sgBrowser->remove(ss->getKey());
    }
  }


  //--------------------------------------------------------------------
  void execShowSummary()
  {
    SubjectGarageBrowserGUI  gui;
    SubjectSummary  ss;

    gui =| sgBrowser->getGUI();
    ss = gui->getSelectedSummary();
    if (ss != null) {
      sgBrowser->showSummary(ss);
    }
  }

}

// EoF

