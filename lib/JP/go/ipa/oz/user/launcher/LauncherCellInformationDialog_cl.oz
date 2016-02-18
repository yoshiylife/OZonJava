// OZ launcher


/**
 * LauncherCellInformationDialog
 *
 * @version  1.1
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

class LauncherCellInformationDialog
  : *CenteredDialog
{

  LauncherCore     lCore;
  TextField        cellGODView, cellCIDView;
  Button           okButton, cancelButton;
  Button           importButton;
  GODOperator      godOp;



  ///////////////////////////////////////////////////////// Constructors

  //--------------------------------------------------------------------
  new create(LauncherCore lchr, String godPrefix)
  {
    Frame  parent;

    lCore = lchr;
    parent = lCore->getGUI();
    super => create(parent, "Cell Information Dialog", true);
    initGUI();

    if (godPrefix != null) {
      cellGODView->setText(godPrefix);
      cellGODView->setCaretPosition(godPrefix->length());
    }
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public String getInputCID()
  {
    return cellCIDView->getText();
  }


  //--------------------------------------------------------------------
  public String getInputGOD()
  {
    return cellGODView->getText();
  }


  //--------------------------------------------------------------------
  public void setCatalogGOL(String gol)
  {
    lCore->setCatalogGOL(gol);
  }


  //--------------------------------------------------------------------
  public void setGOD(String god)
  {
    if (god != null) {
      cellGODView->setText(god);
    }
  }


  //--------------------------------------------------------------------
  public void setCID(String cid)
  {
    if (cid != null) {
      cellCIDView->setText(cid);
    }
  }


  ////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  void initGUI()
  {
    Panel  inputPanel, controlPanel;
    GridBagLayout  layout;
    GridBagConstraints  constraints;

    inputPanel = mkInputPanel();
    controlPanel = mkControlPanel();

    layout => newGridBagLayout();
    setLayout(layout);
    constraints => newGridBagConstraints();
    constraints->setFill(constraints->getBOTH());

    constraints->setGridwidth(constraints->getREMAINDER());
    constraints->setWeightx(1.0);
    layout->setConstraints(inputPanel, constraints);
    layout->setConstraints(controlPanel, constraints);

    add(inputPanel);
    add(controlPanel);
    pack();
  }


  //--------------------------------------------------------------------
  Panel mkInputPanel()
  {
    Panel  panel;
    Label  labelGOD, labelCID;
    int  width = 50;
    Insets  insets;
    GridBagLayout  layout;
    GridBagConstraints  constraints;
    EventDispatchingQueue  importEq;
    LauncherImportListener  importListener;

    // layout manager
    layout => newGridBagLayout();

    // components
    panel => newPanel(layout);
    labelGOD => newLabel("GOD:");
    cellGODView => newTextField(50);
    labelCID => newLabel("class ID:");
    cellCIDView => newTextField(50);

    importEq => create();
    importListener => create(lCore, this, importEq);
    importButton => newButton("import");
    importButton->addActionListener(importListener);

    // layout
    constraints => newGridBagConstraints();
    constraints->setFill(constraints->getBOTH());

    insets => newInsets(5, 10, 0, 2);
    constraints->setInsets(insets);
    layout->setConstraints(labelGOD, constraints);
    layout->setConstraints(labelCID, constraints);

    constraints->setWeightx(1.0);
    insets->set(5, 2, 0, 10);
    constraints->setInsets(insets);
    layout->setConstraints(cellCIDView, constraints);

    constraints->setGridwidth(constraints->getREMAINDER());
    layout->setConstraints(cellGODView, constraints);

    constraints->setWeightx(0.0);
    layout->setConstraints(importButton, constraints);

    panel->add(labelGOD);
    panel->add(cellGODView);
    panel->add(labelCID);
    panel->add(cellCIDView);
    panel->add(importButton);

    return panel;
  }


  //--------------------------------------------------------------------
  Panel mkControlPanel()
  {
    Panel  panel;
    GridBagLayout  layout;
    GridBagConstraints  constraints;
    Insets  insets;
    EventDispatchingQueue  eq;
    LauncherCellInformationListener  listener;

    // components
    layout => newGridBagLayout();
    panel => newPanel(layout);
    okButton => newButton("OK");
    cancelButton => newButton("Cancel");
    eq => create();
    listener => create(lCore, this, eq);
    okButton->addActionListener(listener);
    cancelButton->addActionListener(listener);

    // layout
    constraints => newGridBagConstraints();
    constraints->setFill(constraints->getBOTH());
    insets => newInsets(10, 20, 10, 20);
    constraints->setInsets(insets);

    layout->setConstraints(okButton, constraints);
    layout->setConstraints(cancelButton, constraints);
    panel->add(okButton);
    panel->add(cancelButton);

    return panel;
  }

}

// EoF

