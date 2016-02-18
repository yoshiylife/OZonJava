// OZ Launcher


/**
 * LauncherCellInformationListener
 *
 * @version  0.9
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

class LauncherCellInformationListener
  : *ActionListener
{

  LauncherCore                      lCore;
  LauncherCellInformationDialog     cellDialog;
  EventDispatchingQueue             dialogQue;



  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new create(LauncherCore lchr, LauncherCellInformationDialog dialog,
             EventDispatchingQueue eq)
  {
    super => newActionListener(eq);

    lCore = lchr;
    cellDialog = dialog;
    dialogQue => create();
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public void actionPerformed(ActionEvent evt)
  {
    String  cmd;
    String  god, cid;
    boolean  needToDispose = true;

    cmd = evt->getActionCommand();

    if (cmd->isequal("OK")) {
      god = cellDialog->getInputGOD();
      cid = cellDialog->getInputCID();

      if (god->length() > 0 && cid->length() > 0) {
        cellDialog->setVisible(false);
        lCore->createCell(god, cid);

      } else {
        needToDispose = false;
        handleException();
      }
    }

    if (needToDispose) {
      cellDialog->dispose();
    }
  }


  //--------------------------------------------------------------------
  void handleException()
  {
    ExceptionDialog  exDialog;

    exDialog => create(lCore->getGUI(), "Invalid GOD or class ID", dialogQue);
  }

}

// EoF

