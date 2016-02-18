// OZ DEV: Class Browser


/**
 * CBClassView
 *
 * @version  $Id$
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

final class CBClassView
  : *Panel
{

  CBPartView  partView;
  CIPart  targetPart;

  // view components
  TextField  CIDView;
  List  ifCIDView, superCIDView;
  EventDispatchingQueue  eventQue;

  // for better performance
  boolean  isImpl;
  CIInterfacePart  targetIfPart;
  CIImplementationPart  targetImplPart;

  System  system;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new newCBClassView(CIPart part, CBPartView pv)
  {
    super => newPanel();
    system => create();
    initParams(part, pv);
    initGUI();
  }


  ////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  void initGUI()
  {
    Panel  CIDsPanel, modifierPanel;
    GridBagLayout  layout;
    GridBagConstraints  constraints;

    CIDsPanel = mkCIDsPanel();
    modifierPanel = mkModifierPanel();

    layout => newGridBagLayout();
    setLayout(layout);
    constraints => newGridBagConstraints();
    constraints->setFill(constraints->getBOTH());

    constraints->setWeightx(0.8);
    layout->setConstraints(CIDsPanel, constraints);
    constraints->setWeightx(0.2);
    layout->setConstraints(modifierPanel, constraints);

    add(CIDsPanel);
    add(modifierPanel);
  }


  //--------------------------------------------------------------------
  void initParams(CIPart part, CBPartView pv)
  {
    targetPart = part;
    partView = pv;
    isImpl = !(targetPart->isInterface());
    if (isImpl) {
      targetImplPart =| part;
    } else {
      targetIfPart =| part;
    }
    eventQue => create();
  }


  //--------------------------------------------------------------------
  Panel mkCIDsPanel()
  {
    Panel  panel;
    Label  CIDLabel, ifCIDLabel, superCIDLabel;
    GridBagLayout  layout;
    GridBagConstraints  constraints;

    CIDLabel => newLabel("class ID");
    CIDView = mkCIDView();

    if (isImpl) {
      ifCIDLabel => newLabel("interface class");
      ifCIDView = mkIfCIDView();
      superCIDLabel => newLabel("super class (cl)");
    } else {
      superCIDLabel => newLabel("super classes (if)");
    }
    superCIDView = mkSuperCIDView();

    // layout
    layout => newGridBagLayout();
    panel => newPanel(layout);
    constraints => newGridBagConstraints();
    constraints->setFill(constraints->getBOTH());

    // relative
    layout->setConstraints(CIDLabel, constraints);
    if (isImpl) {
      layout->setConstraints(ifCIDLabel, constraints);
    }
    layout->setConstraints(superCIDLabel, constraints);

    // remainder
    constraints->setGridwidth(constraints->getREMAINDER());
    constraints->setWeightx(1.0);
    layout->setConstraints(CIDView, constraints);
    if (isImpl) {
      layout->setConstraints(ifCIDView, constraints);
    }
    layout->setConstraints(superCIDView, constraints);

    panel->add(CIDLabel);
    panel->add(CIDView);
    if (isImpl) {
      panel->add(ifCIDLabel);
      panel->add(ifCIDView);
    }
    panel->add(superCIDLabel);
    panel->add(superCIDView);

    return panel;
  }


  //--------------------------------------------------------------------
  TextField mkCIDView()
  {
    TextField  view;
    Color  fg, bg;
    Font  font;

    view => newTextField(targetPart->getCID());
    view->setEditable(false);
    fg => newColorAsBlue();
    bg => newColorAsWhite();
    view->setForeground(fg);
    view->setBackground(bg);
    try {
      font => newFont("Helvetica", 14);
      view->setFont(font);
    } catch (Root ex) {
      ;
    }

    return view;
  }


  //--------------------------------------------------------------------
  List mkIfCIDView()
  {
    List  view;  // List is easy to bind double-click event !!!
    CBClassSelectListener  listener;

    view => newList(1);
    view->add(targetImplPart->getInterfaceCID());

    listener => newCBClassSelectListener(partView, view, eventQue);
    view->addActionListener(listener);

    return view;
  }


  //--------------------------------------------------------------------
  List mkSuperCIDView()
  {
    List  view;
    Iterator  itr;
    String  superCID;
    CBClassSelectListener  listener;

    if (isImpl) {
      view => newList(1);
      if (!(targetPart->isRoot())) {
        view->add(targetImplPart->getSuperImplementationCID());
      }

    } else {
      view => newList(2);
      if (!(targetPart->isRoot())) {
        itr = targetIfPart->superInterfaceCIDs();
        while (itr->hasMoreElements()) {
          superCID =| itr->nextElement();
          view->add(superCID);
        }
      }
    }

    if (!(targetPart->isRoot())) {
      listener => newCBClassSelectListener(partView, view, eventQue);
      view->addActionListener(listener);
    }

    return view;
  }


  //--------------------------------------------------------------------
  Panel mkModifierPanel()
  {
    Panel  panel;
    Checkbox  protectedCB, cellCB, abstractCB, finalCB;
    Label  protectedLabel, cellLabel, abstractLabel, finalLabel;
    GridBagLayout  layout;
    GridBagConstraints  constraints;
    
    layout => newGridBagLayout();
    panel => newPanel(layout);
    constraints => newGridBagConstraints();
    constraints->setFill(constraints->getBOTH());

    if (isImpl) {
      protectedCB => newCheckbox("", targetImplPart->isProtected());
      protectedCB->setEnabled(false);
      protectedLabel => newLabel("protected");
    }

    cellCB => newCheckbox("", targetPart->isCell());
    cellCB->setEnabled(false);
    cellLabel => newLabel("cell");
    abstractCB => newCheckbox("", targetPart->isAbstract());
    abstractCB->setEnabled(false);
    abstractLabel => newLabel("abstract");
    finalCB => newCheckbox("", targetPart->isFinal());
    finalCB->setEnabled(false);
    finalLabel => newLabel("final");

    if (isImpl) {
      layout->setConstraints(protectedCB, constraints);
    }
    layout->setConstraints(cellCB, constraints);
    layout->setConstraints(abstractCB, constraints);
    layout->setConstraints(finalCB, constraints);

    constraints->setGridwidth(constraints->getREMAINDER());
    if (isImpl) {
      layout->setConstraints(protectedLabel, constraints);
    }
    layout->setConstraints(cellLabel, constraints);
    layout->setConstraints(abstractLabel, constraints);
    layout->setConstraints(finalLabel, constraints);

    if (isImpl) {
      panel->add(protectedCB);
      panel->add(protectedLabel);
    }
    panel->add(cellCB);
    panel->add(cellLabel);
    panel->add(abstractCB);
    panel->add(abstractLabel);
    panel->add(finalCB);
    panel->add(finalLabel);

    return panel;
  }

}

// EoF

