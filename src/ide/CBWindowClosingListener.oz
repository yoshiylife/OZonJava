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

// DEV: Class Browser


/**
 * CBWindowClosingListener
 *
 * @version  $Id$
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

final class CBWindowClosingListener
  : *WindowListener
{

  Window  targetWindow;

  System  system;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new newCBWindowClosingListener(Window win, EventDispatchingQueue evtQue)
  {
    super => newWindowListener(evtQue);
    targetWindow = win;
    system => create();
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public void windowClosing(WindowEvent evt)
  {
    system->debugPrintln("\tCBWindowClosingListener#windowClosing");

    targetWindow->dispose();
  }

}

// EoF

