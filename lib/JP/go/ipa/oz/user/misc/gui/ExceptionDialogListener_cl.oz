// OZ Misc. GUI


/**
 * ExceptionDialogListener
 *
 * @version  1.0
 * @author   A.Nakamura <akihito@etl.go.jp>
 */


class ExceptionDialogListener
  : *ActionListener
{

  Dialog                  targetDialog;
  EventDispatchingQueue   dialogQue;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new create(Dialog dg, EventDispatchingQueue eq)
  {
    super => newActionListener(eq);
    targetDialog = dg;
    this->dialogQue = eq;
  }


  /////////////////////////////////////////////////////// public methods

  //------------------------------------------------------------------
  public void actionPerformed(ActionEvent evt)
  {
    targetDialog->dispose();
  }

}

// EoF

