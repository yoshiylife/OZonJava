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

