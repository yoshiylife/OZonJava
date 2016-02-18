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

// OZ


/**
 * ApplicationSummaryBrowser
 *
 * @version  1.1
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

class ApplicationSummaryBrowser
: *Frame
{

  ApplicationGarageBrowser        gBrowser;
  TextField                       nameView;
  TextArea                        descView;
  Application                     targetComponent;
  ApplicationSummary              targetSummary;
  boolean                         asEditor;
  ApplicationSummaryBrowserMenuBar    menubar;
  String                          titlePrefix;


  
  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new create(ApplicationSummary summary, ApplicationGarageBrowser gb)
  {
    super => newFrame("Application Summary Browser");
    gBrowser = gb;
    asEditor = false;
    initGUI();
    initMenubar();

    show(summary);
    setVisible(true);
  }


  //--------------------------------------------------------------------
  new createEditor(Application app, ApplicationGarageBrowser gb)
  {
    super => newFrame("Application Summary Editor");
    gBrowser = gb;
    targetComponent = app;
    asEditor = true;

    initGUI();
    initMenubar();
    setVisible(true);
  }


  /////////////////////////////////////////////////////// public methods


  //--------------------------------------------------------------------
  public ApplicationSummary getInputSummary()
  {
    ApplicationSummary  app;

    app => create(nameView->getText(), descView->getText());

    return app;
  }


  //--------------------------------------------------------------------
  public Key getKey()
  {
    if (targetSummary != null) {
      return targetSummary->getKey();
    } else {
      return null;
    }
  }


  //--------------------------------------------------------------------
  public ApplicationSummary getSummary()
  {
    return targetSummary;
  }


  //--------------------------------------------------------------------
  public void show(ApplicationSummary summary)
  {
    String  name, desc;

    if (summary != null) {
      name = summary->getName();
      desc = summary->getDescription();
      if (name != null && desc != null) {
        targetSummary = summary;
        if (!asEditor) {
          setTitle(titlePrefix->concat(name));
        }
        nameView->setText(name);
        descView->setText(desc);
      }
    }
  }


  ////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  void initGUI()
  {
    Panel  namePanel, descPanel;
    GridBagLayout  layout;
    GridBagConstraints  constraints;
    Insets  insets;

    if (asEditor) {
      titlePrefix => breed("Application Summary Editor");
    } else {
      titlePrefix => breed("Application Summary Browser - ");
    }
    setTitle(titlePrefix);

    layout => newGridBagLayout();
    setLayout(layout);

    namePanel = mkNamePanel();
    descPanel = mkDescPanel();

    constraints => newGridBagConstraints();
    insets => newInsets(15, 5, 5, 5);
    constraints->setInsets(insets);
    constraints->setFill(constraints->getBOTH());
    constraints->setGridwidth(constraints->getREMAINDER());
    constraints->setWeightx(1.0);
    layout->setConstraints(namePanel, constraints);
    insets->set(5, 5, 15, 5);
    layout->setConstraints(descPanel, constraints);

    add(namePanel);
    add(descPanel);
    pack();
  }


  //--------------------------------------------------------------------
  void initMenubar()
  {
    if (asEditor) {
      menubar => createExportMenu(gBrowser, this);
    } else {
      menubar => createBrowseMenu(gBrowser, this);
    }
    setMenuBar(menubar);
  }


  //--------------------------------------------------------------------
  Panel mkNamePanel()
  {
    Panel  panel;
    Label  label;
    Insets  insets;
    GridBagLayout  layout;
    GridBagConstraints  constraints;

    layout => newGridBagLayout();

    panel => newPanel(layout);
    label => newLabel("name:");
    nameView => newTextField();

    constraints => newGridBagConstraints();
    constraints->setFill(constraints->getBOTH());
    constraints->setGridwidth(constraints->getREMAINDER());
    constraints->setWeightx(1.0);
    layout->setConstraints(label, constraints);
    layout->setConstraints(nameView, constraints);
    panel->add(label);
    panel->add(nameView);

    return panel;
  }


  //--------------------------------------------------------------------
  Panel mkDescPanel()
  {
    Panel  panel;
    Label  label;
    Insets  insets;
    GridBagLayout  layout;
    GridBagConstraints  constraints;

    layout => newGridBagLayout();

    panel => newPanel(layout);
    label => newLabel("description:");
    descView => newTextArea();

    constraints => newGridBagConstraints();
    constraints->setFill(constraints->getBOTH());
    constraints->setGridwidth(constraints->getREMAINDER());
    constraints->setWeightx(1.0);
    layout->setConstraints(label, constraints);
    layout->setConstraints(descView, constraints);
    panel->add(label);
    panel->add(descView);

    return panel;
  }

}


// EoF

