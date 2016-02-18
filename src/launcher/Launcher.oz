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

