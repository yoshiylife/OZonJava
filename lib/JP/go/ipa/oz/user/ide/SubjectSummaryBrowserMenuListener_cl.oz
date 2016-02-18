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
 * SubjectSummaryBrowserMenuListener
 *
 * @version  1.1
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

final class SubjectSummaryBrowserMenuListener
  : *ActionListener
{

  SubjectSummaryBrowser  ssBrowser;
  SubjectGarageBrowser   sgBrowser;

  EventDispatchingQueue  dialogQue;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new create(SubjectGarageBrowser sgb, SubjectSummaryBrowser ssb)
  {
    EventDispatchingQueue  eq;

    eq => create();
    super => newActionListener(eq);
    dialogQue => create();
    sgBrowser = sgb;
    ssBrowser = ssb;
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public void actionPerformed(ActionEvent evt)
  {
    String  cmd;

    cmd = evt->getActionCommand();

    if (cmd->isequal("close")) {
      doClose();
    } else if (cmd->isequal("cancel")) {
      doCancel();
    } else if (cmd->isequal("export")) {
      doExport();
    } else if (cmd->isequal("import")) {
      doImport();
    } else if (cmd->isequal("save")) {
      doSave();
    }
  }


  ////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  void doCancel()
  {
    sgBrowser->exportReady(null);
    ssBrowser->dispose();
  }


  //--------------------------------------------------------------------
  void doClose()
  {
    Key  key;

    key = ssBrowser->getKey();
    sgBrowser->hideSummary(key);
  }


  //--------------------------------------------------------------------
  void doImport()
  {
    SubjectSummary  ss;

    ss = ssBrowser->getSummary();
    sgBrowser->importSubject(ss);
  }


  //--------------------------------------------------------------------
  void doExport()
  {
    SubjectSummary  ss;

    ss = ssBrowser->getInputSummary();
    if (isLegalInput(ss)) {
      sgBrowser->exportReady(ss);
      ssBrowser->dispose();
    } else {
      handleException("Insufficient input !\nPlease input at least one character in each field.");
    }
  }


  //--------------------------------------------------------------------
  void doSave()
  {
    Key  key;
    SubjectSummary  ss;

    ss = ssBrowser->getInputSummary();
    if (isLegalInput(ss)) {
      key = ssBrowser->getKey();
      sgBrowser->replaceSummary(key, ss);
    } else {
      handleException("Insufficient input !\nPlease input at least one character in each field.");
    }
  }


  //--------------------------------------------------------------------
  boolean isLegalInput(SubjectSummary ss)
  {
    if (((ss->getName())->length() > 0) &&
    ((ss->getDescription())->length() > 0)) {
      return true;
    } else {
      return false;
    }
  }


  //--------------------------------------------------------------------
  void handleException(String msg)
  {
    ExceptionDialog  exDialog;

    exDialog => create(ssBrowser, msg, dialogQue);
  }


}

// EoF

