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
 * CIConstructorType
 * 
 * @version  $Id$
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

final class CIConstructorType
  : *CIType
{

  ///////////////////////////////////////////////////////// constructors
  
  //--------------------------------------------------------------------
  new newCIConstructorType()
  {
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public String asString()
  {
    return "new";
  }


  //--------------------------------------------------------------------
  public boolean isClass()
  {
    return false;
  }


  //--------------------------------------------------------------------
  public boolean isPrimitive()
  {
    return false;
  }

}

// EoF

