// OZ Cell Stopper


/**
 * CellStopperGUI
 *
 * @version  0.2
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

class CellStopperGUI
: *CenteredFrame
{

  CellStopperCore          csCore;

  // view parts
  TextField                godInputView;
  Button                   stopButton, quitButton;

  System  system;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new create(CellStopperCore cs)
  {
    system => create();
    system->debugPrintln("\tCellStopperGUI#create");
    super => create("OZ Cell Stopper");
    init(cs);
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public String getInputGOD()
  {
    return godInputView->getText();
  }


  ////////////////////////////////////////////////////// private methods


  //--------------------------------------------------------------------
  void init(CellStopperCore cs)
  {
    csCore = cs;
    initGUI("GOD:", 50);
    initListeners();
  }


  //--------------------------------------------------------------------
  void initGUI(String label, int width)
  {
    Panel  inputPanel, controlPanel;
    GridBagLayout  layout;
    GridBagConstraints  constraints;

    inputPanel = mkInputPanel(label, width);
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
  void initListeners()
  {
    CellStopperListener  listener;
    EventDispatchingQueue  eq;

    eq => create();
    listener => create(csCore, eq);
    stopButton->addActionListener(listener);
    quitButton->addActionListener(listener);
  }


  //--------------------------------------------------------------------
  Panel mkInputPanel(String label, int width)
  {
    Panel  panel;
    Label  labelView;
    Insets  insets;
    GridBagLayout  layout;
    GridBagConstraints  constraints;

    labelView => newLabel(label);
    godInputView => newTextField(width);
    layout => newGridBagLayout();
    panel => newPanel(layout);

    constraints => newGridBagConstraints();
    constraints->setFill(constraints->getBOTH());
    insets => newInsets(10, 10, 0, 2);
    constraints->setInsets(insets);
    layout->setConstraints(labelView, constraints);

    constraints->setGridwidth(constraints->getREMAINDER());
    constraints->setWeightx(1.0);
    insets->set(10, 2, 0, 10);
    layout->setConstraints(godInputView, constraints);

    panel->add(labelView);
    panel->add(godInputView);

    return panel;
  }


  //--------------------------------------------------------------------
  Panel mkControlPanel()
  {
    Panel  panel;
    GridBagLayout  layout;
    GridBagConstraints  constraints;
    Insets  insets;

    stopButton=>newButton("Stop Cell");
    quitButton=>newButton("Quit");
    layout => newGridBagLayout();
    panel => newPanel(layout);

    constraints => newGridBagConstraints();
    constraints->setFill(constraints->getBOTH());
    insets => newInsets(10, 20, 10, 20);
    constraints->setInsets(insets);

    layout->setConstraints(stopButton, constraints);
    layout->setConstraints(quitButton, constraints);

    panel->add(stopButton);
    panel->add(quitButton);

    return panel;
  }

}

// EoF

