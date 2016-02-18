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
 * ApplicationSummaryBrowserMenuListener
 *
 * @version  0.9
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

final class ApplicationSummaryBrowserMenuListener
  : *ActionListener
{

  ApplicationSummaryBrowser  sBrowser;
  ApplicationGarageBrowser   gBrowser;

  EventDispatchingQueue  dialogQue;
  System  system;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new create(ApplicationGarageBrowser gb, ApplicationSummaryBrowser sb)
  {
    EventDispatchingQueue  eq;

    eq => create();
    super => newActionListener(eq);
    system => create();
    dialogQue => create();
    gBrowser = gb;
    sBrowser = sb;
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public void actionPerformed(ActionEvent evt)
  {
    String  cmd;

    cmd = evt->getActionCommand();
    system->debugPrintln("\tApplicationSummaryBrowserMenuListener#actionPerformed");

    if (cmd != null) {
      system->debugPrintln("\t\tcmd="->concat(cmd));
    }

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
    gBrowser->exportReady(null);
    sBrowser->dispose();
  }


  //--------------------------------------------------------------------
  void doClose()
  {
    Key  key;

    key = sBrowser->getKey();
    gBrowser->hideSummary(key);
  }


  //--------------------------------------------------------------------
  void doImport()
  {
    ApplicationSummary  summary;

    summary = sBrowser->getSummary();
    gBrowser->importApplication(summary);
  }


  //--------------------------------------------------------------------
  void doExport()
  {
    ApplicationSummary  summary;

    summary = sBrowser->getInputSummary();
    if (isLegalInput(summary)) {
      gBrowser->exportReady(summary);
      sBrowser->dispose();
    } else {
      handleException("Insufficient input !  Please input at least one character in each field.");
    }
  }


  //--------------------------------------------------------------------
  void doSave()
  {
    Key  key;
    ApplicationSummary  summary;

    summary = sBrowser->getInputSummary();
    if (isLegalInput(summary)) {
      key = sBrowser->getKey();
      gBrowser->replaceSummary(key, summary);
    } else {
      handleException("Insufficient input !\nPlease input at least one character in each field.");
    }
  }


  //--------------------------------------------------------------------
  boolean isLegalInput(ApplicationSummary summary)
  {
    if (((summary->getName())->length() > 0) &&
    ((summary->getDescription())->length() > 0)) {
      return true;
    } else {
      return false;
    }
  }


  //--------------------------------------------------------------------
  void handleException(String msg)
  {
    ExceptionDialog  exDialog;

    exDialog => create(sBrowser, msg, dialogQue);
  }


}

// EoF

