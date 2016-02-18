// DEV: Class Browser


/**
 * CBExceptionDialogListener
 *
 * @version  $Id$
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

final class CBExceptionDialogListener
  : *ActionListener
{

  Dialog  dialog;
  EventDispatchingQueue  dialogQue;

  System  system;


  //------------------------------------------------------------------
  new newCBExceptionDialogListener(Dialog dl, EventDispatchingQueue dlgQue)
  {
    super => newActionListener(dlgQue);
    this->dialog = dl;
    this->dialogQue = dlgQue;
    system => create();
    if (isGreen()) {
      system->debugPrintln("\tCBExceptionDialogListener#new: green");
    } else {
      system->debugPrintln("\tCBExceptionDialogListener#new: red");
    }
  }


  //------------------------------------------------------------------
  public void actionPerformed(ActionEvent evt)
  {
    dialog->dispose();
  }

}

// EoF

