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

