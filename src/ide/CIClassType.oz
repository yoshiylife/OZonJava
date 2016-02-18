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
 * CIClassType
 * 
 * @version  $Id$
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

final class CIClassType
  : *CIType
{

  String  cid;


  ///////////////////////////////////////////////////////// constructors
  
  //--------------------------------------------------------------------
  new newCIClassType(String cid)
  {
    initParams(cid);
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public String asString()
  {
    return cid;
  }


  //--------------------------------------------------------------------
  public boolean isPrimitive()
  {
    return false;
  }


  //--------------------------------------------------------------------
  public boolean isClass()
  {
    return true;
  }


  //--------------------------------------------------------------------
  public boolean isOzInternalClass()
  {
    if (cid->startsWith("JP.go.ipa.oz.system.") ||
        cid->startsWith("java.")) {
      return true;
    } else {
      return false;
    }
  }


  //--------------------------------------------------------------------
  public String getCID()
  {
    return cid;
  }


  ////////////////////////////////////////////////////// private methods
  
  //--------------------------------------------------------------------
  void initParams(String cid)
  {
    typeCode = 'L';
    this->cid = cid;
  }

}

// EoF

