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

