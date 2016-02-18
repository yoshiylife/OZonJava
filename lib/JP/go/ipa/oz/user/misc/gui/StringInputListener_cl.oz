// OZ misc


/**
 * StringInputListener
 *
 * @version  1.1
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

class StringInputListener
  : *ActionListener
{

  StringInputDialog  inputDialog;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new create(EventDispatchingQueue eq)
  {
    super => newActionListener(eq);
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public StringInputDialog getDialog()
  {
    return inputDialog;
  }


  //--------------------------------------------------------------------
  public void setDialog(StringInputDialog dialog)
  {
    inputDialog = dialog;
  }


  //////////////////////////////////////////////////// protected methods

}

// EoF

