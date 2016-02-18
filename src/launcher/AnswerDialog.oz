/*
 Copyright(c) 1996-1998
 IPA, ETL, AT21, FSIABC, FXIS, InArc, MRI, NUL, SBC, Sharp, TEC, TIS

 All rights reserved.  No guarantee.
 This technology is a result of the Advanced Software  Enrichment 
 Project of Information-technology Promotion Agency, Japan (IPA).

 Permissions  to  use,  copy, modify and distribute this software
 are governed by the terms and conditions set forth in  the  file 
 COPYRIGHT, located on the top directory of this software.
 */

// OZ Launcher


/**
 * AnswerDialog
 *
 * @version  0.8
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

class AnswerDialog
  : *CenteredDialog
{
  protected Button           okButton, cancelButton;


  ///////////////////////////////////////////////////////// Constructors

  //--------------------------------------------------------------------
  new create(Frame parent, String title, String message)
  {
    super => create(parent, title, true);
    initGUI(message);
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public void addActionListener(ActionListener al)
  {
    okButton->addActionListener(al);
    cancelButton->addActionListener(al);
  }


  ////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  void initGUI(String message)
  {
    Panel  msgPanel, controlPanel;
    GridBagLayout  layout;
    GridBagConstraints  constraints;

    msgPanel = mkMessagePanel(message);
    controlPanel = mkControlPanel();

    layout => newGridBagLayout();
    setLayout(layout);
    constraints => newGridBagConstraints();
    constraints->setFill(constraints->getBOTH());
    constraints->setGridwidth(constraints->getREMAINDER());
    constraints->setWeightx(1.0);
    layout->setConstraints(msgPanel, constraints);
    layout->setConstraints(controlPanel, constraints);

    add(msgPanel);
    add(controlPanel);
    pack();
  }


  //--------------------------------------------------------------------
  Panel mkMessagePanel(String message)
  {
    Panel  panel;
    Label  msgLabel;
    Insets  insets;
    GridBagLayout  layout;
    GridBagConstraints  constraints;

    // layout manager
    layout => newGridBagLayout();

    // components
    panel => newPanel(layout);
    msgLabel => newLabel(message);

    // layout
    constraints => newGridBagConstraints();
    constraints->setFill(constraints->getBOTH());
    constraints->setGridwidth(constraints->getREMAINDER());
    constraints->setWeightx(1.0);
    insets => newInsets(10, 10, 10, 10);
    constraints->setInsets(insets);
    layout->setConstraints(msgLabel, constraints);

    panel->add(msgLabel);

    return panel;
  }


  //--------------------------------------------------------------------
  Panel mkControlPanel()
  {
    Panel  panel;
    GridBagLayout  layout;
    GridBagConstraints  constraints;
    Insets  insets;

    // components
    layout => newGridBagLayout();
    panel => newPanel(layout);
    okButton => newButton("OK");
    cancelButton => newButton("Cancel");

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

