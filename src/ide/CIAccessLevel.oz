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

// DEV: Class Browser


/**
 * CIAccessLevel
 * 
 * @version  $Id$
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

final class CIAccessLevel
{

  boolean  iAmPublic;       // 0x0001
  boolean  iAmProtected;    // 0x0004
  int  UPPER;               // 0x4000


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new newCIAccessLevel(int mods)
  {
    initParams(mods);
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public String asString()
  {
    if (iAmPublic) {
      return "public";
    } else if (iAmProtected) {
      return "protected";
    } else {
      return "";
    }
  }


  //--------------------------------------------------------------------
  public boolean isPublic()
  {
    return iAmPublic;
  }


  //--------------------------------------------------------------------
  public boolean isProtected()
  {
    return iAmProtected;
  }


  ////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  void initParams(int mods)
  {
    int  quot, remain;

    UPPER = 0x4000;
    quot = mods % UPPER;

    remain = quot % 2;                       // 0x0001
    if (remain == 1) { iAmPublic = true; }
    quot = quot / 2;
    quot = quot / 2;
    remain = quot % 2;                       // 0x0004
    if (remain == 1) { iAmProtected = true; }
  }

}

// EoF

