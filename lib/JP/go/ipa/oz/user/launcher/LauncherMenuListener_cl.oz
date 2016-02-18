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

