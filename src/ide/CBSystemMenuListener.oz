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
 * CBSystemMenuListener
 *
 * @version  $Id$
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

final class CBSystemMenuListener
  : *ActionListener
{

  CBPartView  partView;
  String  cid;
  EventDispatchingQueue  dialogQue;

  System  system;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new newCBSystemMenuListener(CBPartView pv, EventDispatchingQueue evtQue)
  {
    super => newActionListener(evtQue);
    partView = pv;
    this->cid = pv->getCID();
    dialogQue => create();

    system => create();
    if (isGreen()) {
      system->debugPrintln("\tCBSystemMenuListener#new: green");
    } else {
      system->debugPrintln("\tCBSystemMenuListener#new: red");
    }
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public void actionPerformed(ActionEvent evt)
  {
    String  cmd;
    CIPart  part;
    ClassBrowser  cb;

    cmd = evt->getActionCommand();
    system->debugPrintln("\tCBSystemMenuListener#actionPerformed: "->concat(cmd));

    if (cmd->isequal("open")) {
      CBCIDInputDialog  dialog;
      dialog => newCBCIDInputDialog(partView, dialogQue);

    } else if (cmd->isequal("close")) {
      partView->getClassBrowser()->dispose(cid);

    } else if (cmd->isequal("close all")) {
      partView->getClassBrowser()->disposeAll();

    }
  }

}

// EoF

