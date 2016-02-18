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

