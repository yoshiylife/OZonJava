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

// OZ Launcher


/**
 * LauncherCellSelectListener
 *
 * @version  1.1
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

class LauncherCellSelectListener
  : *ActionListener
{

  LauncherCore             lCore;
  GODOperator              godOp;
  EventDispatchingQueue    dialogQue;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new create(LauncherCore lchr, EventDispatchingQueue eq)
  {
    super => newActionListener(eq);
    lCore = lchr;
    //lGUI =| lCore->getGUI();
    godOp => create();
    dialogQue => create();
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public void actionPerformed(ActionEvent evt)
  {
    String  name;
    String  god;
    LauncherGUI  lGUI;

    name = evt->getActionCommand();

    lGUI =| lCore->getGUI();
    god = godOp->toGOD(lGUI->getPath(), name);
    lCore->startCell(god);
  }

}

// EoF

