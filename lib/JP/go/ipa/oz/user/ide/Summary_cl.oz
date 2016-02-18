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

// OZ DEV


/**
 * Summary
 *
 * @version  $Id$
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

abstract class Summary
{

  protected String  serverGOL;
  protected Key  theKey;

  
  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public abstract void describe();


  //--------------------------------------------------------------------
  public Key getKey()
  {
    return theKey;
  }


  //--------------------------------------------------------------------
  public String getLocation()
  {
    return serverGOL;
  }


  //--------------------------------------------------------------------
  public Summarizable retreive()
  {
    SGarage  sg;
    Summarizable  sbl;
    GarageException  ex;

    if (serverGOL == null) {
      ex => create("null GOL");
      throw ex;
    }
    sg => bind(serverGOL);
    sbl = sg->get(theKey);

    return sbl;
  }


  //--------------------------------------------------------------------
  public void setKey(Key key)
  {
    theKey = key;
  }


  //--------------------------------------------------------------------
  public void setLocation()
  {
    serverGOL = getGOL();
  }


  //--------------------------------------------------------------------
  public void setLocation(String gol)
  {
    serverGOL = gol;
  }

}


// EoF

