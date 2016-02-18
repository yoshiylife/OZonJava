// OZ DEV: Class Browser


/**
 * CBMemberListView
 *
 * @version  $Id$
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

final class CBMemberListView
  : *Panel
{

  Dictionary  memberList; // Dictionary<CIMember, CBMemberView>
  CBMemberView  selectedView;
  CBPartView  partView;
  CBMethodView  methodView;
  CIPart  targetPart;
  School  targetSchool;
  CBMemberListener  memberListener;
  EventDispatchingQueue  eventQue, dialogQue;

  // components
  Panel  accessLevelPanel, modifierPanel, typePanel, namePanel,
    argumentTypePanel, declaringClassPanel;
  ScrollPane  scrollPane;
  Label  titleLabel;

  // for better performance
  boolean  isImpl;
  CIInterfacePart  targetIfPart;
  CIImplementationPart  targetImplPart;

  System  system;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new newCBIfMemberListView(CIPart part, Collection ancestorPartList,
                            CBPartView pv)
  {
    super => newPanel();
    system => create();
    system->debugPrintln("\tCBPartMemberListView#new (if)");

    initParams(part, pv);
    initGUI(ancestorPartList);
  }


  //--------------------------------------------------------------------
  new newCBImplMemberListView(CIPart part, Collection ancestorPartList,
                              CBMethodView methodView, CBPartView pv)
  {
    super => newPanel();
    system => create();
    system->debugPrintln("\tCBPartMemberListView#new (impl)");

    initParams(part, pv);
    this->methodView = methodView;
    initGUI(ancestorPartList);
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public void select(CIMember member)
  {
    CBMemberView  view;
    CIPart  decPart;
    CIType  type;

    if (member == null) {
      system->println("\tCBMemberListView#select: null argument");
      return;
    }

    view =| memberList->get(member);
    if (view != null) {
      if (view == selectedView) {
        decPart = member->getDeclaringPart();

        if (decPart == targetPart) {
          if (member->isAttribute()) {
            CIAttribute  att;
            att =| member;
            type = att->getType();

            if (!(type->isPrimitive())) {
              CIClassType  classType;
              classType =| type;
              showPart(classType->getCID());
            }

          } else {
            // CONSTRUCTOR or METHOD
            if (isImpl) {
              methodView->show(member);
            }
          }

        } else {
          // ANCESTER part
          showPart(decPart->getCID());
        }

      } else {
        // select NEW member
        selectView(view);
      }
    }
  }

  /*
  public void select(CIMember member)
  {
    CBMemberView  view;
    CIPart  decPart;
    CIAttribute  att;
    CIType  type;
    CIClassType  classType;
    CBExceptionDialog  exDialog;

    if (member == null) {
      system->println("\tCBMemberListView#select: null argument");
      return;
    }
    if (isImpl) {
      view =| memberList->get(member);
      if (view != null) {
        if (view == selectedView) {
          decPart = member->getDeclaringPart();
          if (decPart == targetPart) {
            if (member->isAttribute()) {
              att =| member;
              type = att->getType();
              if (!(type->isPrimitive())) {
                classType =| type;
                try {
                  partView->getClassBrowser()->show(classType->getCID());
                } catch (CIException ex) {
                  exDialog => newCBExceptionDialog(partView, ex->asString(),
                                                   dialogQue);
                }
              }
            } else {
              methodView->show(member);
            }

          } else {
            try {
              partView->getClassBrowser()->show(decPart->getCID());
            } catch (CIException ex) {
              exDialog => newCBExceptionDialog(partView, ex->asString(),
                                               dialogQue);
            }
          }
          
        } else {
          if (selectedView != null) {
            selectedView->deselect();
          }
          view->select();
          selectedView = view;
        }
      }
    }
  }
  */


  ////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  void initGUI(Collection ancestorPartList)
  {
    mkMemberComponents();
    layoutComponents();
    setMembers(ancestorPartList);
  }


  //--------------------------------------------------------------------
  void initParams(CIPart part, CBPartView pv)
  {
    partView = pv;
    targetPart = part;
    isImpl = !(part->isInterface());
    if (isImpl) {
      targetImplPart =| part;
    } else {
      targetIfPart =| part;
    }
    targetSchool = partView->getClassBrowser()->getSchool();
    memberList => create();
    eventQue => create();
    dialogQue => create();
    memberListener => newCBMemberListener(this, eventQue);
  }


  //--------------------------------------------------------------------
  void layoutComponents()
  {
    GridBagLayout  layout;
    GridBagConstraints  constraints;

    layout => newGridBagLayout();
    setLayout(layout);
    constraints => newGridBagConstraints();
    constraints->setFill(constraints->getBOTH());
    constraints->setGridwidth(constraints->getREMAINDER());

    constraints->setWeightx(1.0);
    layout->setConstraints(titleLabel, constraints);
    constraints->setWeighty(1.0);
    layout->setConstraints(scrollPane, constraints);

    add(titleLabel);
    add(scrollPane);
  }


  //--------------------------------------------------------------------
  void mkMemberComponents()
  {
    Panel  panel;
    GridBagLayout  layout1;
    GridBagConstraints  constraints;
    GridLayout  layout2;
    Color  bg;

    titleLabel => newLabel("members");
    scrollPane => newScrollPane();

    bg => newColorAsWhite();

    layout2 => newGridLayout(0, 1);
    accessLevelPanel => newPanel(layout2);
    accessLevelPanel->setBackground(bg);
    modifierPanel => newPanel(layout2);
    modifierPanel->setBackground(bg);
    typePanel => newPanel(layout2);
    typePanel->setBackground(bg);
    namePanel => newPanel(layout2);
    namePanel->setBackground(bg);
    argumentTypePanel => newPanel(layout2);
    argumentTypePanel->setBackground(bg);
    declaringClassPanel => newPanel(layout2);
    declaringClassPanel->setBackground(bg);

    layout1 => newGridBagLayout();
    panel => newPanel(layout1);
    panel->setBackground(bg);
    constraints => newGridBagConstraints();
    constraints->setFill(constraints->getBOTH());

    layout1->setConstraints(accessLevelPanel, constraints);
    layout1->setConstraints(modifierPanel, constraints);
    layout1->setConstraints(typePanel, constraints);
    layout1->setConstraints(namePanel, constraints);
    layout1->setConstraints(argumentTypePanel, constraints);
    constraints->setWeightx(1.0);
    layout1->setConstraints(declaringClassPanel, constraints);

    panel->add(accessLevelPanel);
    panel->add(modifierPanel);
    panel->add(typePanel);
    panel->add(namePanel);
    panel->add(argumentTypePanel);
    panel->add(declaringClassPanel);

    scrollPane->add(panel);
    
  }


  //--------------------------------------------------------------------
  void selectView(CBMemberView view)
  {
    if (selectedView != null) {
      selectedView->deselect();
    }
    view->select();
    selectedView = view;
  }


  //--------------------------------------------------------------------
  void setAttributeListOf(CIPart part)
  {
    CIImplementationPart  implPart;
    CIAttribute  att;
    Iterator  itr;
    CBMemberView  view;
    boolean  isInherited;

    if (!(part->isInterface())) {
      implPart =| part;
      isInherited = !(part == targetPart);
      itr = implPart->attributes();
      while (itr->hasMoreElements()) {
        att =| itr->nextElement();
        view => newCBMemberView(att, isInherited, targetSchool);
        view->layoutComponents(accessLevelPanel, modifierPanel, typePanel,
                               namePanel, argumentTypePanel,
                               declaringClassPanel);
        view->addMemberListener(memberListener);
        memberList->put(att, view);
      }
    }
  }


  //--------------------------------------------------------------------
  void setConstructorListOf(CIPart part)
  {
    CIMethod  method;
    Iterator  itr;
    CBMemberView  view;

    if (part == targetPart && !(part->isInterface())) {
      itr = targetImplPart->constructors();
      while (itr->hasMoreElements()) {
        method =| itr->nextElement();
        view => newCBMemberView(method, false, targetSchool);
        view->layoutComponents(accessLevelPanel, modifierPanel,
                               typePanel, namePanel, argumentTypePanel,
                               declaringClassPanel);
        view->addMemberListener(memberListener);
        memberList->put(method, view);
      }
    }
  }


  //--------------------------------------------------------------------
  void setMembers(Collection ancestorPartList)
  {
    Iterator  partItr;
    CIPart  part;

    setMembersOf(targetPart);

    partItr = ancestorPartList->iterator();
    while (partItr->hasMoreElements()) {
      part =| partItr->nextElement();
      setMembersOf(part);
    }
  }

  
  //--------------------------------------------------------------------
  void setMembersOf(CIPart part)
  {
    if (!(part->isInterface())) {
      setAttributeListOf(part);
      setConstructorListOf(part);
    }
    setMethodListOf(part);
  }


  //--------------------------------------------------------------------
  void setMethodListOf(CIPart part)
  {
    CIImplementationPart  implPart;
    CIMethod  method;
    Iterator  itr;
    CBMemberView  view;
    boolean  isInherited;

    isInherited = !(part == targetPart);
    if (!(part->isInterface())) {
      implPart =| part;
      itr = implPart->publicMethods();
      while (itr->hasMoreElements()) {
        method =| itr->nextElement();
        view => newCBMemberView(method, isInherited, targetSchool);
        view->layoutComponents(accessLevelPanel, modifierPanel,
                               typePanel, namePanel, argumentTypePanel,
                               declaringClassPanel);
        view->addMemberListener(memberListener);
        memberList->put(method, view);
      }

      itr = implPart->protectedMethods();
      while (itr->hasMoreElements()) {
        method =| itr->nextElement();
        view => newCBMemberView(method, isInherited, targetSchool);
        view->layoutComponents(accessLevelPanel, modifierPanel,
                               typePanel, namePanel, argumentTypePanel,
                               declaringClassPanel);
        view->addMemberListener(memberListener);
        memberList->put(method, view);
      }

      itr = implPart->privateMethods();
      while (itr->hasMoreElements()) {
        method =| itr->nextElement();
        view => newCBMemberView(method, isInherited, targetSchool);
        view->layoutComponents(accessLevelPanel, modifierPanel,
                               typePanel, namePanel, argumentTypePanel,
                               declaringClassPanel);
        view->addMemberListener(memberListener);
        memberList->put(method, view);
      }

    } else {
      itr = part->methods();
      while (itr->hasMoreElements()) {
        method =| itr->nextElement();
        view => newCBMemberView(method, isInherited, targetSchool);
        view->layoutComponents(accessLevelPanel, modifierPanel,
                               typePanel, namePanel, argumentTypePanel,
                               declaringClassPanel);
        view->addMemberListener(memberListener);
        memberList->put(method, view);
      }
    }
  }


  //--------------------------------------------------------------------
  void showPart(String cid)
  {
    CBExceptionDialog  exDialog;

    try {
      partView->getClassBrowser()->show(cid);
    } catch (CIException ex) {
      exDialog => newCBExceptionDialog(partView, ex->asString(),
                                       dialogQue);
    }
  }

}

// EoF

