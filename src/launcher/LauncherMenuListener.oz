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
 * LauncherMenuListener
 *
 * @version  1.1
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

final class LauncherMenuListener
  : *ActionListener
{

  LauncherCore              lCore;
  GODOperator               godOp;

  EventDispatchingQueue     dialogQue;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new create(LauncherCore lc, EventDispatchingQueue eq)
  {
    super => newActionListener(eq);
    lCore = lc;
    dialogQue => create();
    godOp => create();

  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public void actionPerformed(ActionEvent evt)
  {
    String  cmd;

    cmd = evt->getActionCommand();

    if (cmd->isequal("quit")) {
      quit();
    } else if (cmd->isequal("refresh")) {
      refresh();
    } else if (cmd->isequal("start cell")) {
      startCell();
    } else if (cmd->isequal("new cell")) {
      newCell();
    }
  }


  ////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  void quit()
  {
    AnswerDialog  dialog;
    LauncherQuitListener  listener;
    EventDispatchingQueue  eq;

    eq => create();
    dialog => create(lCore->getGUI(), "Launcher Quit Dialog",
                     "Do you really want to quit OZ Launcher ?");
    listener => create(lCore, dialog, eq);
    dialog->show();
  }


  //--------------------------------------------------------------------
  void handleException(String msg)
  {
    ExceptionDialog  exDialog;
    EventDispatchingQueue  eq;

  }


  //--------------------------------------------------------------------
  void newCell()
  {
    lCore->createCell();
  }


  //--------------------------------------------------------------------
  void refresh()
  {
    lCore->sync();
  }


  //--------------------------------------------------------------------
  void startCell()
  {
    String  name;
    String  god;
    LauncherGUI  lGUI;

    lGUI =| lCore->getGUI();
    name = lGUI->getSelectedCell();
    if (name != null) {
      god = godOp->toGOD(lGUI->getPath(), name);
      lCore->startCell(god);
    }
  }

}

// EoF

