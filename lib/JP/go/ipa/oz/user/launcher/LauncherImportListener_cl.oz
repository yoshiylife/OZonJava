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

