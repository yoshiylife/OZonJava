// OZ Misc. GUI


/**
 * ExceptionDialog
 *
 * @version  1.0
 * @author   A.Nakamura <akihito@etl.go.jp>
 */


class ExceptionDialog
  : *CenteredDialog
{

  EventDispatchingQueue  dialogQue;


  //--------------------------------------------------------------------
  new create(Frame parent, String message, EventDispatchingQueue eq)
  {
    super => create(parent, "Exception Dialog", true);  // modal
    this->dialogQue = eq;
    initGUI(message);
    show();
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
    ExceptionDialogListener  listener;

    if (message == null) {
      messageLabel => newLabel("Exception caught.");
    } else {
      messageLabel => newLabel(message);
    }
    try {
      font => newFont("SansSerif", 14);
      messageLabel->setFont(font);
    } catch (Root ex) {
      /* nothing to do */
    }

    listener => create(this, dialogQue);
    okButton => newButton("OK");
    okButton->addActionListener(listener);

    layout => newGridBagLayout();
    setLayout(layout);
    constraints => newGridBagConstraints();
    constraints->setGridwidth(constraints->getREMAINDER());
    insets => newInsets(20, 20, 10, 20);
    constraints->setInsets(insets);
    layout->setConstraints(messageLabel, constraints);
    layout->setConstraints(okButton, constraints);

    add(messageLabel);
    add(okButton);
    pack();
  }

}

// EoF

