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
 * CBIGraphNode
 *
 * @version  0.2.4
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */


final class CBIGraphNode
  : *Rectangle
{

  CIPart          thisPart;
  SList           superNodeList;  // SList<CBIGraphNode>
  SList           subNodeList;    // SList<CBIGraphNode>
  boolean         marked;
  int             level;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new newCBIGraphNode(CIPart part)
  {
    super => newRectangle(0, 0, 0, 0);
    thisPart = part;
    marked = false;
    superNodeList => create();
    subNodeList => create();
    level = 0;
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public void addSubNode(CBIGraphNode nd)
  {
    if (!(subNodeList->contains(nd))) {
      subNodeList->pushBack(nd);
    }
  }


  //--------------------------------------------------------------------
  public void addSuperNode(CBIGraphNode nd)
  {
    if (!(superNodeList->contains(nd))) {
      superNodeList->pushBack(nd);
    }
  }


  //--------------------------------------------------------------------
  public String getCID()
  {
    return thisPart->getCID();
  }


  //--------------------------------------------------------------------
  public String getLabelName()
  {
    return thisPart->getLabelName();
  }


  //--------------------------------------------------------------------
  public int getSubClassCount()
  {
    return subNodeList->size();
  }


  //--------------------------------------------------------------------
  public int getSuperClassCount()
  {
    return superNodeList->size();
  }


  //--------------------------------------------------------------------
  public int getLevel()
  {
    return level;
  }


  //--------------------------------------------------------------------
  public boolean isMarked()
  {
    return marked;
  }


  //--------------------------------------------------------------------
  public void setLevel(int lv)
  {
    this->level = lv;
  }


  //------------------------------------------------------------------
  public void setMark(boolean mk)
  {
    marked = mk;
  }


  //------------------------------------------------------------------
  public Iterator subNodes()
  {
    return subNodeList->iterator();
  }


  //------------------------------------------------------------------
  public Iterator superNodes()
  {
    return superNodeList->iterator();
  }

}

// EoF

