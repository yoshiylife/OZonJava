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
 * SGSummarizableIterator
 *
 * @version  $Id$
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

final class SGSummarizableIterator
  : Iterator
{

  Set  keySet;
  Iterator  keyIterator;
  String  sgarageGOL;
  SGarage  sgarage;

  
  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new newSGSummarizableIterator(Set keys)
  {
    sgarageGOL = getGOL();
    sgarage=>bind(sgarageGOL);
    this->keySet = keys;
    keyIterator = keySet->iterator();
  }


  //--------------------------------------------------------------------
  new newSGSummarizableIterator(String gol, Set keys)
  {
    sgarageGOL = gol;
    sgarage=>bind(gol);
    this->keySet = keys;
    keyIterator = keySet->iterator();
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public boolean atEnd()
  {
    return keyIterator->atEnd();
  }


  //--------------------------------------------------------------------
  public boolean hasMoreElements()
  {
    return keyIterator->hasMoreElements();
  }


  //--------------------------------------------------------------------
  public Root nextElement()
  {
    Root  elm;
    Key  key;

    key =| keyIterator->nextElement();
           // may throw "no more element" exception
    elm = sgarage->get(key);

    return elm;
  }

}


// EoF

