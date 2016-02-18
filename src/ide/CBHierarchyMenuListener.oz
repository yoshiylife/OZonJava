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
 * CBHierarchyMenuListener
 *
 * @version  $Id$
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

final class CBHierarchyMenuListener
  : *ActionListener
{

  CBPartView               partView;
  EventDispatchingQueue    dialogQue;

  System  system;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new newCBHierarchyMenuListener(CBPartView pv, EventDispatchingQueue evtQue)
  {
    super => newActionListener(evtQue);
    partView = pv;
    dialogQue => create();

    system => create();
    if (isGreen()) {
      system->debugPrintln("\tCBhierarchyMenuListener#new: green");
    } else {
      system->debugPrintln("\tCBHierarchyMenuListener#new: red");
    }
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public void actionPerformed(ActionEvent evt)
  {
    String  cmd;
    ClassBrowser  cb;

    cmd = evt->getActionCommand();

    if (cmd->isequal("ancestors")) {
      try {
        partView->showLocalHierarchy();
      } catch (CIException ex) {
          // nothing
      }
    }
  }

}

// EoF

