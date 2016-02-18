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

// OZ misc


/**
 * StringInputListener
 *
 * @version  1.1
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

class StringInputListener
  : *ActionListener
{

  StringInputDialog  inputDialog;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new create(EventDispatchingQueue eq)
  {
    super => newActionListener(eq);
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public StringInputDialog getDialog()
  {
    return inputDialog;
  }


  //--------------------------------------------------------------------
  public void setDialog(StringInputDialog dialog)
  {
    inputDialog = dialog;
  }


  //////////////////////////////////////////////////// protected methods

}

// EoF

