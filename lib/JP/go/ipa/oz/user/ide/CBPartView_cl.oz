// OZ DEV: Class Browser


/**
 * CBPartView
 *
 * @version  0.2.5
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

final class CBPartView
  : *Frame
{

  CIPart  targetPart;
  Collection  ancestorPartList;  //Collection<CIPart>
  ClassBrowser  classBrowser;

  CBPartViewMenuBar  menubar;
  CBClassView  classView;
  CBMemberListView  memberListView;
  CBMethodView  methodView;
  Color  panelColor;

  CBLocalHierarchyFrame  hierarchyFrame;

  // for better performance
  String  targetCID;
  boolean  isImpl;
  CIInterfacePart  targetIfPart;
  CIImplementationPart  targetImplPart;

  System  system;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new newCBPartView(CIPart part, Collection ancestorPartList,
                    ClassBrowser cb)
  {
    School  school;
    String  titleStr;

    system => create();
    initParams(part, ancestorPartList, cb);

    school = cb->getSchool();
    if (isImpl) {
      titleStr = school->getNameOfImplementation(targetCID);
    } else {
      titleStr = school->getNameOfInterface(targetCID);
    }
    if (titleStr == null) {
      titleStr = part->getCID();
    }
    super => newFrame("Class Browser - "->concat(titleStr));

    initGUI();
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public String getCID()
  {
    return targetCID;
  }


  //--------------------------------------------------------------------
  public ClassBrowser getClassBrowser()
  {
    return classBrowser;
  }


  //--------------------------------------------------------------------
  public void showLocalHierarchy()
  {
    CBIGraph  g;

    if (hierarchyFrame == null) {
      g = mkLocalHierarchyGraph();
      hierarchyFrame => newCBLocalHierarchyFrame(this, g);
    }
    hierarchyFrame->setVisible(true);
  }


  ////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  void initGUI()
  {
    GridBagLayout  layout;
    GridBagConstraints  constraints;
    Insets  insets;

    // menu bar
    menubar => newCBPartFrameMenuBar(this);
    setMenuBar(menubar);

    // layout manager
    layout => newGridBagLayout();
    setLayout(layout);
    constraints => newGridBagConstraints();
    constraints->setFill(constraints->getBOTH());
    constraints->setGridwidth(constraints->getREMAINDER());
    constraints->setWeightx(1.0);
    insets => newInsets(4, 4, 4, 4);
    constraints->setInsets(insets);

    // class view
    classView => newCBClassView(targetPart, this);
    classView->setBackground(panelColor);
    layout->setConstraints(classView, constraints);

    // method view
    // member list view
    if (isImpl) {
      methodView => newCBMethodView(targetPart, this);
      methodView->setBackground(panelColor);
      constraints->setWeighty(0.2);
      layout->setConstraints(methodView, constraints);
      memberListView => newCBImplMemberListView(targetPart, ancestorPartList,
                                                methodView, this);
      constraints->setWeighty(0.8);
    } else {
      memberListView => newCBIfMemberListView(targetPart, ancestorPartList,
                                              this);
      constraints->setWeighty(1.0);
    }
    memberListView->setBackground(panelColor);
    layout->setConstraints(memberListView, constraints);

    // packing
    add(classView);
    add(memberListView);
    if (isImpl) {
      add(methodView);
    }
    pack();
    show();
  }


  //--------------------------------------------------------------------
  void initParams(CIPart part, Collection ancestorPartList,
                  ClassBrowser cb)
  {
    this->targetPart = part;
    this->ancestorPartList = ancestorPartList;
    this->classBrowser = cb;
    this->targetCID = part->getCID();

    this->isImpl = !(part->isInterface());
    if(isImpl) {
      this->targetImplPart =| part;
    } else {
      this->targetIfPart =| part;
    }

    panelColor => newColor(192, 192, 192);
  }


  //----------------------------------------------------------------------
  CBIGraph mkLocalHierarchyGraph()
  {
    CBIGraph  graph;
    CIPart  part;
    Set  baseParts, nextBaseParts;
    Collection  superPartList;
    Iterator  itr;

    graph => newCBIGraph(targetPart);
    baseParts => create();
    baseParts->add(targetPart);
    while (!(baseParts->isEmpty())) {
      nextBaseParts => create();
      itr = baseParts->iterator();
      while (itr->hasMoreElements()) {
        part =| itr->nextElement();
        superPartList = classBrowser->getSuperPartsOf(part);
        graph->addPart(part, superPartList);
        nextBaseParts = nextBaseParts->union(superPartList);
      }
      baseParts = nextBaseParts;
    }

    return graph;
  }

}

// EoF

