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
 * SummarizableIterator
 *
 * @version  0.8
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

class SummarizableIterator
  : Iterator
{

  Collection    keyList;
  Iterator      keyItr;
  String        sgarageGOL;
  SGarage       sgarage;

  
  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new create(Collection keys)
  {
    sgarageGOL = getGOL();
    sgarage => bind(sgarageGOL);
    keyList = keys;
    keyItr = keyList->iterator();
  }


  //--------------------------------------------------------------------
  new create(String gol, Collection keys)
  {
    sgarageGOL = gol;
    sgarage => bind(gol);
    keyList = keys;
    keyItr = keyList->iterator();
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public boolean atEnd()
  {
    return keyItr->atEnd();
  }


  //--------------------------------------------------------------------
  public boolean hasMoreElements()
  {
    return keyItr->hasMoreElements();
  }


  //--------------------------------------------------------------------
  public Root nextElement()
  {
    Root  elm;
    Key  key;

    key =| keyItr->nextElement();
           // may throw "no more element" exception
    elm = sgarage->get(key);

    return elm;
  }

}


// EoF

