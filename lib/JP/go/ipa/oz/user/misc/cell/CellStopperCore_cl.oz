// OZ Cell Stopper


/**
 * CellStopperCore
 *
 * @version  0.2
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

class CellStopperCore
{

  CellStopperGUI          gui;

  System                  system;


  ///////////////////////////////////////////////////////// constructors

  new create()
  {
    system => create();
    system->debugPrintln("\tCellStopperCore#create");
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public Frame getGUI()
  {
    return gui;
  }


  //--------------------------------------------------------------------
  public void launch()
  {
    if (gui == null) {
      system->debugPrintln("\tCellStopperCore#launch");
      gui => create(this);
    }
    gui->show();
  }
  

  //--------------------------------------------------------------------
  public void quit()
  {
    system->debugPrintln("\tCellStopperCore#quit");
    if (gui != null) {
      gui->dispose();
      gui = null;
    }
  }

  //--------------------------------------------------------------------
  public void stop()
  {
    stopCell();
  }


  ////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  void init()
  {
  }

}


// EoF

