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

// OZ Garage


/**
 * Key
 *
 * @version  0.9
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

class Key
{

  int  value;

  
  ///////////////////////////////////////////////////////// constructors
  new create(int v)
  {
    value = v;
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public int asInt()
  {
    return value;
  }


  //--------------------------------------------------------------------
  public String asString()
  {
    String  str, keyStr;

    str => breed();
    keyStr = str->valueOf(value);

    return keyStr;
  }

}


// EoF

