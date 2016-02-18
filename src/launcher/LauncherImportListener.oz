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

// OZ launcher


/**
 * LauncherImportListener
 *
 * @version  1.1
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

class LauncherImportListener
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
    ApplicationGarageBrowser  br;
    String  gol;

    br => create(cellDialog);
    gol = lCore->getCatalogGOL();
    if (gol != null) {
      br->bindServer(gol);
    }
    br->importApplication();
  }


  //--------------------------------------------------------------------
  void handleException()
  {
    ExceptionDialog  exDialog;

    exDialog => create(lCore->getGUI(), "exception", dialogQue);
  }

}

// EoF

