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
 * KeyComparator
 *
 * @version  0.9
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

class KeyComparator
 : Comparator
{

  ///////////////////////////////////////////////////////// constructors

  new create()
  {
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public boolean compare(Root key1, Root key2)
  {
    Key  k1, k2;

    k1 =| key1;
    k2 =| key2;

    return k1->asInt() == k2->asInt();
  }


  //--------------------------------------------------------------------
  public int hash(Root key)
  {
    Key  k;

    k =| key;

    return k->asInt();
  }


  //--------------------------------------------------------------------
  public Comparator duplicate()
  {
    KeyComparator  kc;

    kc => create();

    return kc;
  }
}


// EoF

