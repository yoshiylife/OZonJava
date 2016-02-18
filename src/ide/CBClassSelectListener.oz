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
 * CBClassSelectListener
 *
 * @version  $Id$
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

final class CBClassSelectListener
  : *ActionListener
{

  CBPartView  partView;
  List  classList;
  EventDispatchingQueue  dialogQue;

  System  system;


  ///////////////////////////////////////////////////////// constructors

  //------------------------------------------------------------------
  new newCBClassSelectListener(CBPartView pv, List list,
			     EventDispatchingQueue evtQue)
  {
    super => newActionListener(evtQue);

    classList = list;
    partView = pv;
    dialogQue => create();

    system => create();
    if (isGreen()) {
      system->debugPrintln("\tCBClassSelectListener#new: green");
    } else {
      system->debugPrintln("\tCBClassSelectListener#new: red");
    }
  }


  /////////////////////////////////////////////////////// public methods

  //------------------------------------------------------------------
  public void actionPerformed(ActionEvent evt)
  {
    int  index;
    String  cid;
    CBExceptionDialog  exDialog;

    index = classList->getSelectedIndex();
    if (index != -1) {
      cid = evt->getActionCommand();
      system->debugPrintln("\tCBClassSelectListener#actionPerformed: "->concat(cid));
      classList->deselect(index);
      try {
        partView->getClassBrowser()->show(cid);
      } catch (CIException ex) {
        exDialog => newCBExceptionDialog(partView, ex->asString(), dialogQue);
      }
    }
  }

}

// EoF

