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

// OZ Misc. GUI


/**
 * ExceptionDialogListener
 *
 * @version  1.0
 * @author   A.Nakamura <akihito@etl.go.jp>
 */


class ExceptionDialogListener
  : *ActionListener
{

  Dialog                  targetDialog;
  EventDispatchingQueue   dialogQue;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new create(Dialog dg, EventDispatchingQueue eq)
  {
    super => newActionListener(eq);
    targetDialog = dg;
    this->dialogQue = eq;
  }


  /////////////////////////////////////////////////////// public methods

  //------------------------------------------------------------------
  public void actionPerformed(ActionEvent evt)
  {
    targetDialog->dispose();
  }

}

// EoF

