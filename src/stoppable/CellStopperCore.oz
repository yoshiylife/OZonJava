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

