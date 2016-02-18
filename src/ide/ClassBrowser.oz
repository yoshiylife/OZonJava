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

// OZ: class browser


/**
 * ClassBrowser
 *
 * @version  0.2.4
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

final class ClassBrowser
{

  School  school;
  CILoader  ciLoader;
  Dictionary  partList;       // Dictionary<String:cid, CIPart>
  Dictionary  partViewList;   // Dictionary<String:cid, CBPartView>
  Dictionary  superPartList;  // Dictionary<SList:superPartList>
  String  ROOT_IF_CID, ROOT_CL_CID;

  System  system;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new newClassBrowser(School sc)
  {
    initParams(sc);
    //system->debugPrintln("\tClassBrowser#newClassBrowser");
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public void dispose(String cid)
  {
    //system->debugPrintln("\tClassBrowser#dispose"->concat(cid));
    disposePartView(cid);
  }


  //--------------------------------------------------------------------
  public void disposeAll()
  {
    String  cid;
    Iterator  itr;

    //system->debugPrintln("\tClassBrowser#disposeAll");
    itr = partViewList->keyIterator();
    while (itr->hasMoreElements()) {
      cid =| itr->nextElement();
      dispose(cid);
    }
  }


  //--------------------------------------------------------------------
  public Collection getAncestorCIDsOf(String cid)
  {
    Set  cidList;  // Set<String:CID>
    StringComparator  sc;
    Collection  parts;
    Iterator  itr;
    CIPart  part;

    part = loadCI(cid);
    parts = getAncestorPartsOf(part);

    sc => create();
    cidList => create(sc);
    itr = parts->iterator();
    while (itr->hasMoreElements()) {
      part =| itr->nextElement();
      cidList->add(part->getCID());
    }

    return cidList;
  }


  //--------------------------------------------------------------------
  public Collection getAncestorPartsOf(CIPart part)
  {
    Set  rv;
    Array  seedList;
    Collection  basePartList, superPartList;

    rv => create();
    seedList => create(1);
    seedList->putAt(0, part);
    basePartList = seedList;
    while (!(basePartList->isEmpty())) {
      superPartList =| getSuperPartsOf(basePartList);
      rv = rv->union(superPartList);
      basePartList = superPartList;
    }

    return rv;
  }


  //--------------------------------------------------------------------
  /* @return  cid list which is instantiated in the methods
   *          defined in the class
   * @exception  CIException  if CI is not found or CID stands for interface
   */
  public Collection getInstantiatingCIDsOf(String cid)
  {
    Set  cidList;
    StringComparator  sc;
    String  instCID;
    CIPart  part;
    CIMethodImplementation  methodImpl;
    CIImplementationPart  implPart;
    Iterator  itr, cidItr;

    part = loadCI(cid);
    if (part->isInterface()) {
      CIException  ex;
      ex => newCIException("class ID not for implementation part", cid);
      throw ex;
    }

    implPart =| part;
    sc => create();
    cidList => create(sc);

    // check the classes instantiated in each method
    itr = implPart->methods();
    while (itr->hasMoreElements()) {
      methodImpl =| itr->nextElement();
      cidItr = methodImpl->instantiatingCIDs();
      while (cidItr->hasMoreElements()) {
        instCID =| cidItr->nextElement();
        cidList->add(instCID);
      }
    }

    // check the classes instantiated in each constructor
    itr = implPart->constructors();
    while (itr->hasMoreElements()) {
      methodImpl =| itr->nextElement();
      cidItr = methodImpl->instantiatingCIDs();
      while (cidItr->hasMoreElements()) {
        instCID =| cidItr->nextElement();
        cidList->add(instCID);
      }
    }

    return cidList;
  }


  //--------------------------------------------------------------------
  public String getLabelNameOf(CIPart part)
  {
    String  name = null;
    String  subjectName;

    if (school != null) {
      if (part->isInterface()) {
        name = school->getNameOfInterface(part->getCID());
      } else {
        name = school->getNameOfImplementation(part->getCID());
      }
    }
    if (name != null) {
      //system->debugPrintln("\tClassBrowser#getLabelNameOf: "->concat(name));
      subjectName = school->getOzLabel(name)->getSubjectName();
      //system->println("\tClassBrowser#getLabelNameOf: subject="->concat(subjectName));
    } else {
      //system->debugPrintln("\tClassBrowser#getLabelNameOf: null");
    }

    return name;
  }


  //--------------------------------------------------------------------
  public CIPart getPart(String cid)
  {
    CIPart  part;

    part = loadCI(cid);

    return part;
  }


  //--------------------------------------------------------------------
  /* @return  CID list which is refered in the methods
   *          defined in the class
   * @exception  CIException  if CI is not found or CID stands for interface
   */
  public Collection getReferingCIDsOf(String cid)
  {
    Set  cidList;
    StringComparator  sc;
    String  refCID;
    CIPart  part;
    CIMethodImplementation  methodImpl;
    CIImplementationPart  implPart;
    Iterator  itr, cidItr;

    //system->debugPrintln("\tClassBrowser#getReferingCIDsOf: "->concat(cid));

    part = loadCI(cid);
    if (part->isInterface()) {
      CIException  ex;
      ex => newCIException("class ID not for implementation part", cid);
      throw ex;
    }
    implPart =| part;
    sc => create();
    cidList => create(sc);

    // check the classes refered in each method
    itr = implPart->methods();
    while (itr->hasMoreElements()) {
      methodImpl =| itr->nextElement();
      cidItr = methodImpl->referingCIDs();
      while (cidItr->hasMoreElements()) {
        refCID =| cidItr->nextElement();
        cidList->add(refCID);
      }
    }

    // check the classes refered in each constructor
    itr = implPart->constructors();
    while (itr->hasMoreElements()) {
      methodImpl =| itr->nextElement();
      cidItr = methodImpl->referingCIDs();
      while (cidItr->hasMoreElements()) {
        refCID =| cidItr->nextElement();
        cidList->add(refCID);
      }
    }

    return cidList;
  }


  //--------------------------------------------------------------------
  public School getSchool()
  {
    return school;
  }


  //--------------------------------------------------------------------
  public Collection getSuperCIDsOf(String cid)
  {
    Set  cidList;
    StringComparator  sc;
    Collection  superPartList;
    Iterator  itr;
    CIPart  part;

    sc => create();
    cidList => create(sc);

    part = loadCI(cid);
    superPartList = getSuperPartsOf(part);
    itr = superPartList->iterator();
    while (itr->hasMoreElements()) {
      cidList->add(itr->nextElement());
    }

    return cidList;
  }


  //--------------------------------------------------------------------
  public Collection getSuperPartsOf(Collection parts)
  {
    Iterator  itr;
    CIPart  part;
    Set  rv, supers;

    rv => create();
    itr = parts->iterator();
    while (itr->hasMoreElements()) {
      part =| itr->nextElement();
      rv = rv->union(getSuperPartsOf(part));
    }

    return rv;
  }


  //--------------------------------------------------------------------
  public Collection getSuperPartsOf(CIPart part)
  {
    Collection  rv;

    rv =| superPartList->get(part->getCID());
    if (rv == null) {
      rv = loadSuperCIsOf(part);
    }

    return rv;
  }


  //--------------------------------------------------------------------
  public void show(String cid)
  {
    CIPart  part;
    Collection  ancestorParts;

    //system->debugPrintln("\tClassBrowser#show: "->concat(cid));

    if (isOzInternalClass(cid)) {
      //system->debugPrintln("\tClassBrowser#show: internal class");
      return;
    }

    part = loadCI(cid);
    ancestorParts = getAncestorPartsOf(part);

    if (ancestorParts == null) {
      //system->debugPrintln("\tClassBrowser#show: ancestorParts is null !!!");
    }
    //system->debugPrintln("\tClassBrowser#show: loading completed");
    showPartView(part, ancestorParts);
  }


  //--------------------------------------------------------------------
  public void refresh()
  {
  }


  //--------------------------------------------------------------------
  public void refresh(String cid)
  {
  }


  //--------------------------------------------------------------------
  public void showHierarchy()
  {
  }


  //--------------------------------------------------------------------
  public void disposeHierarchy()
  {
  }


  //--------------------------------------------------------------------
  public void refreshHierarchy()
  {
  }


  ////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  void disposePartView(String cid)
  {
    CBPartView  pv;

    pv =| partViewList->get(cid);
    if (pv != null) {
      partViewList->remove(cid);
      pv->dispose();
      /*
      pv->setVisible(false);
      */
    }
  }


  //--------------------------------------------------------------------
  void initParams(School sc)
  {
    StringComparator  strComp;

    this->school = sc;
    strComp => create();
    partList => create(strComp);
    partViewList => create(strComp);
    superPartList => create(strComp);
    this->ciLoader => newCILoader();

    ROOT_IF_CID = "JP.go.ipa.oz.lang._Root_if";
    ROOT_CL_CID = "JP.go.ipa.oz.lang._Root_cl";

    system => create();
  }


  //--------------------------------------------------------------------
  boolean isOzInternalClass(String cid)
  {
    if (cid->startsWith("JP.go.ipa.oz.system.") ||
        cid->startsWith("java.")) {
      //system->debugPrintln("\tClassBrowser#isOzInternalClass");
      return true;
    }

    return false;
  }


  //--------------------------------------------------------------------
  boolean isRootCID(String cid)
  {
    if (cid->isequal(ROOT_IF_CID) || cid->isequal(ROOT_CL_CID)) {
      return true;
    } else {
      return false;
    }
  }


  //--------------------------------------------------------------------
  locked CIPart loadCI(String cid)
  {
    CIPart  part;
    OzLabel  label;

    //system->debugPrintln("\tClassBrowser#loadCI: "->concat(cid));

    part =| partList->get(cid);
    if (part == null) {
      // load the CI
      part = ciLoader->load(cid);
      part->setLabelName(getLabelNameOf(part));
      partList->put(cid, part);
      //system->debugPrintln("\tClassBrowser#loadCI: "->concat(cid)->concat(" loaded"));
      //partDumper->dump(part);
    }

    return part;
  }


  //--------------------------------------------------------------------
  Collection loadSuperCIsOf(CIPart part)
  {
    SList  rv;
    CIImplementationPart  implPart;
    CIInterfacePart  ifPart;
    String  superCID;
    CIPart  superPart;
    Iterator  itr;

    rv =| superPartList->get(part->getCID());
    if (rv == null) {
      rv => create();
      if (!(part->isRoot())) {
        if (part->isInterface()) {
          ifPart =| part;
          itr = ifPart->superInterfaceCIDs();
          while (itr->hasMoreElements()) {
            superCID =| itr->nextElement();
            superPart = loadCI(superCID);
            rv->pushBack(superPart);
          }
        } else {
          implPart =| part;
          superCID = implPart->getSuperImplementationCID();
          superPart = loadCI(superCID);
          rv->pushBack(superPart);
        }
      }
      superPartList->put(part->getCID(), rv);
    }

    return rv;
  }


  //--------------------------------------------------------------------
  void showPartView(CIPart part, Collection ancestorParts)
  {
    CBPartView  pv;
    String  cid;

    cid = part->getCID();
    //system->debugPrintln("\tClassBrowser#showPartView: cid="->concat(cid));
    pv =| partViewList->get(cid);
    if (pv == null) {
      pv => newCBPartView(part, ancestorParts, this);
      partViewList->put(part->getCID(), pv);
      pv->toFront();
    } else {
      pv->setVisible(true);
      pv->toFront();
    }
  }

}

// EoF

