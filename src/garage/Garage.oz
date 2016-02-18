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

// OZ garage


/**
 * Garage
 *
 * @version  0.9
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

class Garage
{

  KeyGenerator     keyGen;
  Dictionary       valueTable;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new create()
  {
    KeyComparator  keyComp;

    keyGen => create();
    keyComp => create();
    valueTable => create(keyComp);
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public Root get(Key key)
  {
    return valueTable->get(key);
  }


  //--------------------------------------------------------------------
  public Iterator iterator()
  {
    return valueTable->iterator();
  }


  //--------------------------------------------------------------------
  public Collection keys()
  {
    return valueTable->keys();
  }


  //--------------------------------------------------------------------
  public Key put(Root value)
  {
    Key  key;

    key = keyGen->generate();
    valueTable->put(key, value);

    return key;
  }


  //--------------------------------------------------------------------
  public void remove(Key key)
  {
    valueTable->remove(key);
  }


  //--------------------------------------------------------------------
  public void replace(Key key, Root value)
  {
    valueTable->put(key, value);
  }


  //--------------------------------------------------------------------
  public int size()
  {
    return valueTable->size();
  }

}


// EoF

