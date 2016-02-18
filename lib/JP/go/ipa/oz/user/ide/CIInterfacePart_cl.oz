// OZ: class browser


/**
 * CIInterfacePart
 * 
 * @version  0.2.4
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

final class CIInterfacePart
  : *CIPart
{

  Collection  superIfCIDList;  // Collection<String:CID>


  //--------------------------------------------------------------------
  new newCIInterfacePart(String cid, CIModifier modifier,
                         Collection superIfCIDList)
  {
    super->initParams(cid, modifier);
    this->superIfCIDList = superIfCIDList;
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public void addMember(CIMember mbr)
  {
    CIMethod  method;

    try {
      method =| mbr;
      addMethod(method);
    } catch (Root ex) {
      // interface part has only public methods
    }
  }


  //--------------------------------------------------------------------
  public boolean isInterface()
  {
    return true;
  }


  //--------------------------------------------------------------------
  public int getSuperInterfaceCIDCount()
  {
    return superIfCIDList->size();
  }


  //--------------------------------------------------------------------
  public Iterator superInterfaceCIDs()
  {
    return superIfCIDList->iterator();
  }

}

// EoF

