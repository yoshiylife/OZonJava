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
 * CBIGraph
 *
 * @version  0.2.4
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */


final class CBIGraph
{

  CBIGraphNode  primaryNode;
  Dictionary  nodeList;  // Dictionary<String:CID, CBIGraphNode>
  int  diameter;

  System  system;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new newCBIGraph(CIPart primaryPart)
  {
    StringComparator  sc;

    system => create();

    sc => create();
    nodeList => create(sc);
    primaryNode => newCBIGraphNode(primaryPart);
    nodeList->put(primaryPart->getCID(), primaryNode);
    diameter = 0;
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public void addPart(CIPart part, Collection superParts)
  {
    CBIGraphNode  baseNode, superNode;
    CIPart  superPart;
    String  thisCID, superCID;
    Iterator  itr;

    thisCID = part->getCID();
    system->debugPrintln("\tCBIGraph#addPart: "->concat(thisCID));
    baseNode =| nodeList->get(thisCID);
    if (baseNode == null) {
      baseNode => newCBIGraphNode(part);
      nodeList->put(thisCID, baseNode);
    }

    itr = superParts->iterator();
    while (itr->hasMoreElements()) {
      superPart =| itr->nextElement();
      superCID = superPart->getCID();
      superNode =| nodeList->get(superCID);
      if (superNode == null) {
        superNode => newCBIGraphNode(superPart);
        nodeList->put(superCID, superNode);
      }
      baseNode->addSuperNode(superNode);
      superNode->addSubNode(baseNode);
    }
  }


  //--------------------------------------------------------------------
  public void clearMarks()
  {
    CBIGraphNode  node;
    Iterator  itr;

    itr = nodeList->iterator();
    while (itr->hasMoreElements()) {
      node =| itr->nextElement();
      node->setMark(false);
    }
  }


  //------------------------------------------------------------------
  public CBIGraphNode getNode(String cid)
  {
    CBIGraphNode  node;

    node =| nodeList->get(cid);

    return node;
  }


  //------------------------------------------------------------------
  public CBIGraphNode getPrimaryNode()
  {
    return primaryNode;
  }


  //--------------------------------------------------------------------
  public Iterator nodes()
  {
    return nodeList->iterator();
  }


  //--------------------------------------------------------------------
  public int size()
  {
    return nodeList->size();
  }


  ////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  /*
  void addNewLevel(int newLevel)
  {
    Array  levelList = null;
    Dictionary  list;
    StringComparator  sc;
    int  idx;
    int  length;

    if (newLevel < 0) {
      if (newLevel < maxSuperLevel) {
        maxSuperLevel = newLevel;
        superLevelList->resize((maxSuperLevel * (-1)) + 1);
        levelList = superLevelList;
      }

    } else {
      if (newLevel > lowestLevel) {
        lowestLevel = newLevel;
        subLevelList->resize(maxSubLevel + 1);
        levelList = subLevelList;
      }
    }

    if (levelList != null) {
      length = levelList->size();
      for (idx = 1; idx < length; idx++) {
        if (levelList->at(idx) == null) {
          sc => create();
          list => create(sc);
          levelList->putAt(idx, list);
        }
      }
    }
      
  }
  */


  //--------------------------------------------------------------------
  /*
  void addNodeToLevel(CBIGraphNode node)
  {
    Dictionary  list;

    addNewLebel(level);
    list =| getLevelList(level);
    list->put(node->getCID(), node);
  }
  */


  //--------------------------------------------------------------------
  /*
  void removeNodeFromLevel(String cid, int level)
  {
    Dictionary  list;

    list =| getLevelList(level);
    list->remove(cid);
  }
  */


  //--------------------------------------------------------------------
  /*
  Dictionary getLevelList(int level)
  {
    Dictionary  list = null;

    if (level < 0) {
      list =| superLevelList->at(level);
    } else {
      list =| subLevelList->at(level);
    }

    return list;
  }
  */

}

// EoF

