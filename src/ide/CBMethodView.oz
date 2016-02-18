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

// OZ DEV: Class Browser


/**
 * CBMethodView
 *
 * @version  0.2.6
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

final class CBMethodView
  : *Panel
{

  CBPartView  partView;
  CIImplementationPart  targetPart;
  School  targetSchool;

  Label  titleLabel, signatureLabel;
  Label  referingClassLabel, instantiatingClassLabel;
  Label  codeLabel;
  List  signatureView;
  CBClassList  referingClassView, instantiatingClassView;
  TextArea  codeView;

  EventDispatchingQueue  eventQue;

  System  system;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new newCBMethodView(CIPart part, CBPartView pv)
  {
    super => newPanel();

    system => create();
    partView = pv;
    targetPart =| part;
    targetSchool = partView->getClassBrowser()->getSchool();
    eventQue => create();
    initGUI();
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public void show(CIMember member)
  {
    CIMethodImplementation  method;

    if (!(member->isAttribute())) {
      clear();
      method =| member;
      showMethodImplementation(method);
    }
  }


  ////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  void clear()
  {
    signatureView->removeAll();
    /*
    signatureView->setText("");
    */
    referingClassView->removeAll();
    instantiatingClassView->removeAll();
    codeView->setText("");
  }


  //--------------------------------------------------------------------
  void initGUI()
  {
    CIMethodImplementation  method;
    Iterator  itr;
    CBClassSelectListener  refListener, insListener;
    Color  bg;

    titleLabel => newLabel("method/constructor details");
    signatureLabel => newLabel("signature");
    referingClassLabel => newLabel("referring classes");
    instantiatingClassLabel => newLabel("instantiating classes");
    codeLabel => newLabel("pseudo code");

    signatureView => newList(1);
    /*
    signatureView => newTextField();
    signatureView->setEditable(false);
    */
    codeView => newTextArea();
    codeView->setEditable(false);
    bg => newColorAsWhite();
    codeView->setBackground(bg);

    referingClassView => newCBClassList(4, partView);
    instantiatingClassView => newCBClassList(4, partView);

    layoutComponents();
  }


  //--------------------------------------------------------------------
  void layoutComponents()
  {
    GridBagLayout  layout, sigLayout;
    GridBagConstraints  constraints, sigConstraints;
    Panel  sigPanel;
    int  remainder;

    // siganature Panel
    sigLayout => newGridBagLayout();
    sigPanel => newPanel(sigLayout);
    sigConstraints => newGridBagConstraints();
    sigConstraints->setFill(sigConstraints->getBOTH());
    sigLayout->setConstraints(signatureLabel, sigConstraints);
    remainder = sigConstraints->getREMAINDER();
    sigConstraints->setGridwidth(remainder);
    sigConstraints->setWeightx(1.0);
    sigLayout->setConstraints(signatureView, sigConstraints);
    sigPanel->add(signatureLabel);
    sigPanel->add(signatureView);

    // top-level Panel
    layout => newGridBagLayout();
    setLayout(layout);
    constraints => newGridBagConstraints();
    constraints->setFill(constraints->getBOTH());

    // relative
    constraints->setWeightx(0.5);
    layout->setConstraints(referingClassLabel, constraints);
    //constraints->setWeighty(0.5);
    layout->setConstraints(referingClassView, constraints);
    //constraints->setWeighty(0.0);

    // remainder
    constraints->setGridwidth(constraints->getREMAINDER());
    layout->setConstraints(instantiatingClassLabel, constraints);
    //constraints->setWeighty(0.5);
    layout->setConstraints(instantiatingClassView, constraints);
    //constraints->setWeighty(0.0);

    constraints->setWeightx(1.0);
    layout->setConstraints(sigPanel, constraints);
    layout->setConstraints(titleLabel, constraints);
    layout->setConstraints(codeLabel, constraints);
    //constraints->setWeighty(0.5);
    constraints->setWeighty(1.0);
    layout->setConstraints(codeView, constraints);

    add(titleLabel);
    add(sigPanel);
    add(referingClassLabel);
    add(instantiatingClassLabel);
    add(referingClassView);
    add(instantiatingClassView);
    add(codeLabel);
    add(codeView);
  }


  //--------------------------------------------------------------------
  void showMethodImplementation(CIMethodImplementation method)
  {
    Iterator  itr;
    String  cid;
    Array  cidList;
    int  size, i;

    // signature
    if (method->isConstructor()) {
      titleLabel->setText("constructor details");
    } else {
      titleLabel->setText("method details");
    }
    signatureView->add(method->asString(targetSchool));
    /*
    signatureView->setText(method->asString(targetSchool));
    */

    // referencing classes
    size = method->getReferingCIDCount();
    cidList => create(size);
    itr = method->referingCIDs();
    for (i = 0; itr->hasMoreElements(); i++) {
      cid =| itr->nextElement();
      cidList->putAt(i, cid);
    }
    referingClassView->setInterfaceList(cidList, targetSchool);

    // instantiating classes
    size = method->getInstantiatingCIDCount();
    cidList => create(size);
    itr = method->instantiatingCIDs();
    for (i = 0; itr->hasMoreElements(); i++) {
      cid =| itr->nextElement();
      cidList->putAt(i, cid);
    }
    instantiatingClassView->setImplementationList(cidList, targetSchool);

    // pseudo code
    codeView->setText(method->getCode());
  }

}

// EoF

