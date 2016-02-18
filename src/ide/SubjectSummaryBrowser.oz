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
 * SubjectSummaryBrowser
 *
 * @version  1.1
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

class SubjectSummaryBrowser
: *Frame
{

  SubjectGarageBrowser            sgBrowser;
  TextField                       nameView;
  TextArea                        descView;
  Subject                         targetSubject;
  SubjectSummary                  targetSummary;
  boolean                         asEditor;
  SubjectSummaryBrowserMenuBar    menubar;
  String                          browseTitlePrefix, editTitlePrefix;

  
  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new create(SubjectSummary ss, SubjectGarageBrowser sgb)
  {
    super => newFrame("Subject Summary Browser");
    sgBrowser = sgb;
    asEditor = false;
    initGUI();
    initMenubar();

    show(ss);
    setVisible(true);
  }


  //--------------------------------------------------------------------
  new createEditor(Subject sbj, SubjectGarageBrowser sgb)
  {
    super => newFrame("Subject Summary Editor");
    sgBrowser = sgb;
    targetSubject = sbj;
    asEditor = true;

    initGUI();
    initMenubar();
    setVisible(true);
  }


  /////////////////////////////////////////////////////// public methods


  //--------------------------------------------------------------------
  public SubjectSummary getInputSummary()
  {
    SubjectSummary  ss;

    ss => create(nameView->getText(), descView->getText());

    return ss;
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
  public SubjectSummary getSummary()
  {
    return targetSummary;
  }


  //--------------------------------------------------------------------
  public void show(SubjectSummary ss)
  {
    String  name, desc;

    if (ss != null) {
      name = ss->getName();
      desc = ss->getDescription();
      if (name != null && desc != null) {
        targetSummary = ss;
        if (!asEditor) {
          setTitle(browseTitlePrefix->concat(name));
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

    browseTitlePrefix => breed("Subject Summary Browser - ");
    editTitlePrefix => breed("Subject Summary Editor");
    if (asEditor) {
      setTitle(editTitlePrefix);
    } else {
      setTitle(browseTitlePrefix);
    }

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
      menubar => createExportMenu(sgBrowser, this);
    } else {
      menubar => createBrowseMenu(sgBrowser, this);
    }
    setMenuBar(menubar);
  }


  //--------------------------------------------------------------------
  Panel mkNamePanel()
  {
    Panel  panel;
    Label  label;
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

