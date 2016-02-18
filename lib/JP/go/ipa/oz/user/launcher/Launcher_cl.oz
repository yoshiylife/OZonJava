// OZ Launcher


/**
 * Launcher
 *
 * @version  0.8
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

cell Launcher
{

  LauncherCore            core;


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

