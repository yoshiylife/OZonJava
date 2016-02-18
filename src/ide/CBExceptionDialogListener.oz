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

// DEV: Class Browser


/**
 * CBExceptionDialogListener
 *
 * @version  $Id$
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

final class CBExceptionDialogListener
  : *ActionListener
{

  Dialog  dialog;
  EventDispatchingQueue  dialogQue;

  System  system;


  //------------------------------------------------------------------
  new newCBExceptionDialogListener(Dialog dl, EventDispatchingQueue dlgQue)
  {
    super => newActionListener(dlgQue);
    this->dialog = dl;
    this->dialogQue = dlgQue;
    system => create();
    if (isGreen()) {
      system->debugPrintln("\tCBExceptionDialogListener#new: green");
    } else {
      system->debugPrintln("\tCBExceptionDialogListener#new: red");
    }
  }


  //------------------------------------------------------------------
  public void actionPerformed(ActionEvent evt)
  {
    dialog->dispose();
  }

}

// EoF

