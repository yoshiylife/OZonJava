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
 * CBCIDInputDialogListener
 *
 * @version  $Id$
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

final class CBCIDInputDialogListener
  : *ActionListener
{

  CBCIDInputDialog  targetDialog;
  CBPartView  partView;
  EventDispatchingQueue  dialogQue;

  System  system;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new newCBCIDInputDialogListener(CBPartView pv, CBCIDInputDialog dl,
                                  EventDispatchingQueue dlgQue)
  {
    super => newActionListener(dlgQue);

    partView = pv;
    targetDialog = dl;
    dialogQue => create();

    system => create();
    if (isGreen()) {
      system->debugPrintln("\tCBCIDInputDialogListener#new: green");
    } else {
      system->debugPrintln("\tCBCIDInputDialogListener#new: red");
    }
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public void actionPerformed(ActionEvent evt)
  {
    String  cmd;
    String  cid;
    StringBuffer  msg;
    CBExceptionDialog  exDialog;

    cmd = evt->getActionCommand();

    if (cmd->isequal("OK")) {
      cid = targetDialog->getCID();
      if (cid->length() > 0) {
	try {
          partView->getClassBrowser()->show(cid);
	} catch (CIException ex) {
	  exDialog => newCBExceptionDialog(partView, ex->asString(),
                                           dialogQue);
        /*
	} catch (FileNotFoundException ex) {
	  msg => breed("CI file not found (ID=\"");
	  msg->append(cid)->append("\").");
	  exDialog => newCBExceptionDialog(partView, msg->asString(),
                                           dialogQue);
        */
	}
      }
    }
    targetDialog->dispose();
  }

}

// EoF

