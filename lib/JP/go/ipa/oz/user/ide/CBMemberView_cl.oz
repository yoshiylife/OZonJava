// OZ DEV: Class Browser


/**
 * CBMemberView
 *
 * @version  $Id$
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

final class CBMemberView
{

  CIMember  targetMember;
  School  targetSchool;
  CBMemberLabel  accessLevelView, modifierView, typeView, nameView,
    argumentTypeView, declaringClassView;
  Color  attributeColor, constructorColor, methodColor;
  Color  selectedBgColor, selectedFgColor;
  Color  deselectedBgColor, deselectedFgColor;

  boolean  isInherited;
  boolean  isSelected;

  System  system;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new newCBMemberView(CIMember m)
  {
    initParams(m, false, null);
    initGUI();
  }


  //--------------------------------------------------------------------
  new newCBMemberView(CIMember m, School s)
  {
    initParams(m, false, s);
    initGUI();
  }


  //--------------------------------------------------------------------
  new newCBMemberView(CIMember m, boolean isInherited)
  {
    initParams(m, isInherited, null);
    initGUI();
  }


  //--------------------------------------------------------------------
  new newCBMemberView(CIMember m, boolean isInherited, School s)
  {
    initParams(m, isInherited, s);
    initGUI();
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public void addMemberListener(CBMemberListener listener)
  {
    //system->println("\tCBMemberView#addMemberListener");
    accessLevelView->addMouseListener(listener);
    modifierView->addMouseListener(listener);
    typeView->addMouseListener(listener);
    nameView->addMouseListener(listener);
    argumentTypeView->addMouseListener(listener);
    declaringClassView->addMouseListener(listener);
  }


  //--------------------------------------------------------------------
  public void deselect()
  {
    isSelected = false;

    accessLevelView->setBackground(deselectedBgColor);
    modifierView->setBackground(deselectedBgColor);
    typeView->setBackground(deselectedBgColor);
    nameView->setBackground(deselectedBgColor);
    argumentTypeView->setBackground(deselectedBgColor);
    declaringClassView->setBackground(deselectedBgColor);

    accessLevelView->setForeground(deselectedFgColor);
    modifierView->setForeground(deselectedFgColor);
    typeView->setForeground(deselectedFgColor);
    argumentTypeView->setForeground(deselectedFgColor);
    declaringClassView->setForeground(deselectedFgColor);
    // style
    if (targetMember->isAttribute()) {
      nameView->setForeground(attributeColor);
    } else if (targetMember->isConstructor()) {
      nameView->setForeground(constructorColor);
    } else {
      nameView->setForeground(methodColor);
    }
  }


  //--------------------------------------------------------------------
  public CIMember getMember()
  {
    return targetMember;
  }


  //--------------------------------------------------------------------
  public void layoutComponents(Panel accPanel, Panel modPanel, Panel typePanel,
                               Panel namePanel, Panel argPanel, Panel decPanel)
  {
    accPanel->add(accessLevelView);
    modPanel->add(modifierView);
    typePanel->add(typeView);
    namePanel->add(nameView);
    argPanel->add(argumentTypeView);
    decPanel->add(declaringClassView);
  }


  //--------------------------------------------------------------------
  public void select()
  {
    if (isSelected) {
      deselect();
    } else {
      isSelected = true;

      accessLevelView->setBackground(selectedBgColor);
      modifierView->setBackground(selectedBgColor);
      typeView->setBackground(selectedBgColor);
      nameView->setBackground(selectedBgColor);
      argumentTypeView->setBackground(selectedBgColor);
      declaringClassView->setBackground(selectedBgColor);

      accessLevelView->setForeground(selectedFgColor);
      modifierView->setForeground(selectedFgColor);
      typeView->setForeground(selectedFgColor);
      nameView->setForeground(selectedFgColor);
      argumentTypeView->setForeground(selectedFgColor);
      declaringClassView->setForeground(selectedFgColor);
    }
  }


  ////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  void initGUI()
  {
    mkComponents();
  }


  //--------------------------------------------------------------------
  void mkComponents()
  {
    String  strType, decPartCID, decPartLabel;
    CIPart  decPart;
    StringBuffer  strArg;
    Color  fg;
    Font  font;

    accessLevelView => newCBMemberLabel(targetMember->getAccessLevelAsString());
    modifierView => newCBMemberLabel(targetMember->getModifierAsString());
    nameView => newCBMemberLabel(targetMember->getName());

    if (targetMember->isAttribute()) {
      CIAttribute  att;
      att =| targetMember;
      strType = att->getTypeAsString(targetSchool);
      argumentTypeView => newCBMemberLabel("");
    } else {
      CIMethod  method;
      method =| targetMember;
      strType = method->getReturnTypeAsString(targetSchool);
      strArg => breed();
      strArg->append("(")
        ->append(method->getArgumentTypeAsString(targetSchool))->append(")");
      argumentTypeView => newCBMemberLabel(strArg->asString());
    }
    typeView => newCBMemberLabel(strType);

    if (isInherited) {
      decPart = targetMember->getDeclaringPart();
      decPartCID = decPart->getCID();
      if (targetSchool != null) {
        if (decPart->isInterface()) {
          decPartLabel = targetSchool->getNameOfInterface(decPartCID);
        } else {
          decPartLabel = targetSchool->getNameOfImplementation(decPartCID);
        }
      } else {
        decPartLabel = decPartCID;
      }
      declaringClassView => newCBMemberLabel(decPartLabel);
    } else {
      declaringClassView => newCBMemberLabel("*");
    }

    if (!isInherited) {
      font => newFontAsBold("sansserif", 12);
      nameView->setFont(font);
    }

    accessLevelView->setMember(targetMember);
    modifierView->setMember(targetMember);
    typeView->setMember(targetMember);
    nameView->setMember(targetMember);
    argumentTypeView->setMember(targetMember);
    declaringClassView->setMember(targetMember);

    deselect();
  }


  //--------------------------------------------------------------------
  void initParams(CIMember m, boolean isInherited, School s)
  {
    targetMember = m;
    targetSchool = s;
    this->isInherited = isInherited;
    system => create();

    attributeColor => newColorAsRed();
    constructorColor => newColorAsMagenta();
    methodColor => newColorAsBlue();
    selectedBgColor => newColor(0, 0, 128);
    selectedFgColor => newColorAsWhite();
    deselectedBgColor => newColorAsWhite();
    deselectedFgColor => newColorAsBlack();
  }

}

// EoF

