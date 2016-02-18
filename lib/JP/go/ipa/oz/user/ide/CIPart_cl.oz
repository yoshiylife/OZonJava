// OZ: class browser


/**
 * CIPart
 * 
 * @version  0.2.4
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

abstract class CIPart
{

  protected String        labelName;
  protected String        cid;
  protected CIModifier    modifier;
  protected SList         methodList;  // SList<CIMethod>  // all the methods
  protected String        ROOT_IF_CID, ROOT_CL_CID;


  /////////////////////////////////////////////////////// public methods


  //--------------------------------------------------------------------
  public abstract void addMember(CIMember mbr);


  //--------------------------------------------------------------------
  public String getCID()
  {
    return cid;
  }


  //--------------------------------------------------------------------
  public String getLabelName()
  {
    return labelName;
  }


  //--------------------------------------------------------------------
  public boolean isAbstract()
  {
    return modifier->isAbstract();
  }

  
  //--------------------------------------------------------------------
  public boolean isCell()
  {
    return modifier->isCell();
  }


  //--------------------------------------------------------------------
  public boolean isFinal()
  {
    return modifier->isFinal();
  }


  //--------------------------------------------------------------------
  public abstract boolean isInterface();


  //--------------------------------------------------------------------
  public boolean isRoot()
  {
    if (cid->isequal(ROOT_IF_CID) || cid->isequal(ROOT_CL_CID)) {
      return true;
    } else {
      return false;
    }
  }


  //--------------------------------------------------------------------
  public Iterator methods()
  {
    return methodList->iterator();
  }


  //--------------------------------------------------------------------
  public int getMethodCount()
  {
    return methodList->size();
  }



  //--------------------------------------------------------------------
  public void setLabelName(String label)
  {
    this->labelName = label;
  }


  //////////////////////////////////////////////////// protected methods

  //--------------------------------------------------------------------
  protected void initParams(String cid, CIModifier mod)
  {
    this->cid = cid;
    this->modifier = mod;
    this->methodList => create();

    ROOT_IF_CID = "JP.go.ipa.oz.lang._Root_if";
    ROOT_CL_CID = "JP.go.ipa.oz.lang._Root_cl";
  }


  //--------------------------------------------------------------------
  protected void addMethod(CIMethod method)
  {
    methodList->pushBack(method);
  }

}

// EoF

