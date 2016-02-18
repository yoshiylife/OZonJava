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

