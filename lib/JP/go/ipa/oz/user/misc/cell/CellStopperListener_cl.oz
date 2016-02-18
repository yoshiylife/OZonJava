// OZ Cell Stopper


/**
 * CellStopperListener
 *
 * @version  0.2
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

class CellStopperListener
  : *ActionListener
{

  CellStopperCore                   csCore;
  EventDispatchingQueue             dialogQue;

  System                      system;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new create(CellStopperCore cs, EventDispatchingQueue eq)
  {
    super => newActionListener(eq);

    csCore = cs;
    dialogQue => create();
    system=>create();
    system->debugPrintln("\tCellStopperListener#create");
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public void actionPerformed(ActionEvent evt)
  {
    String  cmd;
    String  god;
    CellStopperGUI  gui;

    cmd = evt->getActionCommand();
    system->debugPrintln("\tCellStopperListener#actionPerformed: cmd="->concat(cmd));


    if (cmd->isequal("Stop Cell")) {
      gui =| csCore->getGUI();
      god = gui->getInputGOD();
      system->debugPrintln("\tCellStopperListener: GOD="->concat(god));
      if (god->length() > 0) {
        stop(god);
      } else {
        handleException("Invalid GOD");
      }

    } else if (cmd->isequal("Quit")) {
      quit();

    }

  }


  ////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  void handleException(String msg)
  {
    ExceptionDialog  exDialog;

    system->debugPrintln("\tCellStopperListener#handleException");
    exDialog => create(csCore->getGUI(), msg, dialogQue);
  }


  //--------------------------------------------------------------------
  void stop(String god)
  {
    Stoppable  target;

    system->debugPrintln("\tCellStopperListener#stopCell: GOD="->concat(god));

    try {
      target => bind(god);
      target->stop();
    } catch (CellNotFoundException ex) {
      system->debugPrintln("\tCellStopperCore#stopCell: CellNotFoundException");

      handleException("Cell not found");

    } catch (Root ex) {
      system->debugPrintln("\tCellStopperCore#stopCell: Unknown Exception");

      handleException("Unknown exception caught");
      
    }
  }


  //--------------------------------------------------------------------
  void quit()
  {
    csCore->stop();
  }

}

// EoF

