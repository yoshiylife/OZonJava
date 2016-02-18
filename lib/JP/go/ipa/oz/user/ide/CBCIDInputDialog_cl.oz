// OZ DEV: Class Browser


/**
 * CBCIDInputDialog
 *
 * @version  $Id$
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

final class CBCIDInputDialog
  : *CBDialog
{

  CBPartView  partView;
  TextField  CIDView;
  EventDispatchingQueue  dialogQue;


  //--------------------------------------------------------------------
  new newCBCIDInputDialog(CBPartView parent, EventDispatchingQueue dlgQue)
  {
    super => newCBDialog(parent, "ClassBrowser: CID Input Dialog", true);
    this->partView = parent;
    this->dialogQue = dlgQue;
    initGUI();
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public String getCID()
  {
    String  cid;

    cid = CIDView->getText();

    return cid;
  }


  ////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  void initGUI()
  {
    Panel  CIDPanel, buttonPanel;
    GridBagLayout  layout;
    GridBagConstraints  constraints;

    layout => newGridBagLayout();
    setLayout(layout);
    constraints => newGridBagConstraints();
    constraints->setFill(constraints->getBOTH());

    CIDPanel = mkCIDPanel();
    buttonPanel = mkButtonPanel();

    constraints->setGridwidth(constraints->getREMAINDER());
    constraints->setWeightx(1.0);
    layout->setConstraints(CIDPanel, constraints);
    layout->setConstraints(buttonPanel, constraints);

    add(CIDPanel);
    add(buttonPanel);
    pack();
    show();
  }


  //--------------------------------------------------------------------
  Panel mkCIDPanel()
  {
    Panel  CIDPanel;
    Label  CIDLabel;
    Insets  insets;
    GridBagLayout  layout;
    GridBagConstraints  constraints;

    CIDLabel => newLabel("class ID");
    CIDView => newTextField(30);

    layout => newGridBagLayout();
    constraints => newGridBagConstraints();
    constraints->setFill(constraints->getBOTH());

    CIDPanel => newPanel(layout);
    insets => newInsets(10, 10, 0, 2);
    constraints->setInsets(insets);
    layout->setConstraints(CIDLabel, constraints);
    constraints->setGridwidth(constraints->getREMAINDER());
    constraints->setWeightx(1.0);
    insets->set(10, 2, 0, 10);
    layout->setConstraints(CIDView, constraints);
    CIDPanel->add(CIDLabel);
    CIDPanel->add(CIDView);

    return CIDPanel;
  }


  //--------------------------------------------------------------------
  Panel mkButtonPanel()
  {
    Panel  buttonPanel;
    Button  okButton, cancelButton;
    GridBagLayout  layout;
    GridBagConstraints  constraints;
    Insets  insets;
    CBCIDInputDialogListener  listener;

    okButton => newButton("OK");
    cancelButton => newButton("Cancel");

    listener => newCBCIDInputDialogListener(partView, this, dialogQue);
    okButton->addActionListener(listener);
    cancelButton->addActionListener(listener);

    layout => newGridBagLayout();
    constraints => newGridBagConstraints();
    constraints->setFill(constraints->getBOTH());
    insets => newInsets(10, 20, 10, 20);
    constraints->setInsets(insets);

    buttonPanel => newPanel(layout);
    layout->setConstraints(okButton, constraints);
    layout->setConstraints(cancelButton, constraints);
    buttonPanel->add(okButton);
    buttonPanel->add(cancelButton);

    return buttonPanel;
  }

}

// EoF

