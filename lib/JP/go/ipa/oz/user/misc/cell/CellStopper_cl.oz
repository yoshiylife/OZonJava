// OZ Cell Stopper


/**
 * Cell Stopper
 *
 * @version  0.2
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

cell CellStopper
{

  CellStopperCore            core;


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public void initialize()
  {
    core => create();
    stopCell();
  }


  //--------------------------------------------------------------------
  public void go()
  {
    core->launch();
  }
  

  //--------------------------------------------------------------------
  public void quiet()
  {
    core->quit();
    flushCell();
  }
  
}

// EoF

