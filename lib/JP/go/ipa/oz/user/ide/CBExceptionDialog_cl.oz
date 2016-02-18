// OZ DEV: Class Browser


/**
 * CBExceptionDialog
 *
 * @version  $Id$
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

final class CBExceptionDialog
  : *CBDialog
{

  EventDispatchingQueue  dialogQue;


  //------------------------------------------------------------------
  new newCBExceptionDialog(Frame pv, String message,
                           EventDispatchingQueue dlgQue)
  {
    super => newCBDialog(pv, "ClassBrowser Exception", true);  // modal
    this->dialogQue = dlgQue;
    initGUI(message);
  }


  //////////////////////////////////////////////////// public methods

  //////////////////////////////////////////////////// private methods

  //------------------------------------------------------------------
  void initGUI(String message)
  {
    Label  messageLabel;
    Button  okButton;
    Font  font;
    GridBagLayout  layout;
    GridBagConstraints  constraints;
    Insets  insets;
    CBExceptionDialogListener  listener;

    font => newFont("SansSerif", 14);

    messageLabel => newLabel(message);
    messageLabel->setFont(font);
    okButton => newButton("OK");

    listener => newCBExceptionDialogListener(this, dialogQue);
    okButton->addActionListener(listener);

    layout => newGridBagLayout();
    setLayout(layout);
    constraints => newGridBagConstraints();
    constraints->setGridwidth(constraints->getREMAINDER());
    insets => newInsets(20, 20, 10, 20);
    constraints->setInsets(insets);
    layout->setConstraints(okButton, constraints);
    layout->setConstraints(messageLabel, constraints);

    add(messageLabel);
    add(okButton);
    pack();
    show();
  }

}

// EoF

