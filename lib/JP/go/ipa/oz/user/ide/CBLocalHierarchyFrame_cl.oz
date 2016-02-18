// OZ: class browser


/**
 * CBLocalHierarchyFrame
 *
 * @version  0.2.4
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

final class CBLocalHierarchyFrame
  : *CBDialog
{

  CBPartView  partView;
  Label  titleLabel;
  CBLocalHierarchyCanvas  hView;
  ScrollPane  hViewContainer;

  System  system;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new newCBLocalHierarchyFrame(CBPartView pv, CBIGraph g)
  {
    String  title;

    title = "Hierarchy Browser - "->concat(pv->getCID());
    super => newCBDialog(pv, title, false);  // not modal

    system => create();
    initParams(pv);
    initGUI(g);
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public void dispose()
  {
    setVisible(false);
  }


  ////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  void initGUI(CBIGraph g)
  {
    CBWindowClosingListener listener;

    titleLabel => newLabel("class ID:  "->concat(partView->getCID()));
    hView => newCBLocalHierarchyCanvas(g);
    //hViewContainer => newScrollPaneWithScrollbars();
    hViewContainer => newScrollPane();
    hViewContainer->add(hView);

    layoutComponents();

    EventDispatchingQueue  evtQue;
    evtQue => create();
    listener => newCBWindowClosingListener(this, evtQue);
    addWindowListener(listener);
  }


  //--------------------------------------------------------------------
  void initParams(CBPartView pv)
  {
    partView = pv;
  }


  //------------------------------------------------------------------
  void layoutComponents()
  {
    GridBagLayout  layout;
    GridBagConstraints  constraints;
    Insets  insets;

    layout => newGridBagLayout();
    constraints => newGridBagConstraints();
    constraints->setFill(constraints->getBOTH());
    constraints->setGridwidth(constraints->getREMAINDER());
    constraints->setWeightx(1.0);
    insets => newInsets(4, 4, 4, 4);
    constraints->setInsets(insets);
    setLayout(layout);

    layout->setConstraints(titleLabel, constraints);
    constraints->setWeighty(1.0);
    layout->setConstraints(hViewContainer, constraints);

    add(titleLabel);
    add(hViewContainer);
    pack();
    show();
    toFront();
  }


}

// EoF

