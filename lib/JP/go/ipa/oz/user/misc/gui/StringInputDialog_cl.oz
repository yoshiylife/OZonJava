// OZ misc


/**
 * StringInputDialog
 *
 * @version  1.1
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

class StringInputDialog
  : *CenteredDialog
{
  TextField        textInputView;
  Button           okButton, cancelButton;


  ///////////////////////////////////////////////////////// Constructors

  //--------------------------------------------------------------------
  new create(Frame parent, String title, String label, int width,
             boolean modal)
  {
    super => create(parent, title, modal);
    initGUI(null, label, width);
  }


  //--------------------------------------------------------------------
  new create(Frame parent, String title, String message,
             String label, int width, boolean modal)
  {
    super => create(parent, title, modal);
    initGUI(message, label, width);
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public void addStringInputListener(StringInputListener listener)
  {
    listener->setDialog(this);
    okButton->addActionListener(listener);
    cancelButton->addActionListener(listener);
  }


  //--------------------------------------------------------------------
  public void clear()
  {
    textInputView->setText("");
  }


  //--------------------------------------------------------------------
  public String getInputString()
  {
    String str;

    str = textInputView->getText();

    return str;
  }


  //--------------------------------------------------------------------
  public void setString(String str)
  {
    clear();
    textInputView->setText(str);
  }


  ////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  void initGUI(String msg, String label, int width)
  {
    Panel  msgPanel, inputPanel, controlPanel;
    Label  msgLabel;
    GridBagLayout  layout;
    GridBagConstraints  constraints;

    layout => newGridBagLayout();
    setLayout(layout);
    constraints => newGridBagConstraints();
    constraints->setFill(constraints->getBOTH());

    inputPanel = mkInputPanel(msg, label, width);
    controlPanel = mkControlPanel();

    constraints->setGridwidth(constraints->getREMAINDER());
    constraints->setWeightx(1.0);
    layout->setConstraints(inputPanel, constraints);
    layout->setConstraints(controlPanel, constraints);

    add(inputPanel);
    add(controlPanel);
    pack();
    textInputView->requestFocus();
  }


  //--------------------------------------------------------------------
  Panel mkInputPanel(String msg, String label, int width)
  {
    Panel  inputPanel;
    Label  inputLabel, msgLabel;
    Insets  insets;
    GridBagLayout  layout;
    GridBagConstraints  constraints;

    layout => newGridBagLayout();
    inputPanel => newPanel(layout);
    if (label == null) {
      inputLabel => newLabel("");
    } else {
      inputLabel => newLabel(label);
    }
    textInputView => newTextField(width);

    constraints => newGridBagConstraints();
    constraints->setFill(constraints->getBOTH());

    insets => newInsets(10, 10, 5, 10);
    constraints->setInsets(insets);
    if (msg != null) {
      msgLabel => newLabel(msg);
      constraints->setWeightx(1.0);
      constraints->setGridwidth(constraints->getREMAINDER());
      layout->setConstraints(msgLabel, constraints);
      inputPanel->add(msgLabel);

      constraints->setWeightx(0.0);
      constraints->setGridwidth(constraints->getRELATIVE());
    }

    insets->set(10, 10, 0, 2);
    layout->setConstraints(inputLabel, constraints);
    constraints->setGridwidth(constraints->getREMAINDER());
    constraints->setWeightx(1.0);
    insets->set(10, 2, 0, 10);
    layout->setConstraints(textInputView, constraints);
    inputPanel->add(inputLabel);
    inputPanel->add(textInputView);

    return inputPanel;
  }


  //--------------------------------------------------------------------
  Panel mkControlPanel()
  {
    Panel  controlPanel;
    GridBagLayout  layout;
    GridBagConstraints  constraints;
    Insets  insets;

    layout => newGridBagLayout();
    controlPanel => newPanel(layout);
    okButton=>newButton("OK");
    cancelButton=>newButton("Cancel");

    constraints => newGridBagConstraints();
    constraints->setFill(constraints->getBOTH());
    insets => newInsets(10, 20, 10, 20);
    constraints->setInsets(insets);

    layout->setConstraints(okButton, constraints);
    layout->setConstraints(cancelButton, constraints);
    controlPanel->add(okButton);
    controlPanel->add(cancelButton);

    return controlPanel;
  }

}

// EoF

