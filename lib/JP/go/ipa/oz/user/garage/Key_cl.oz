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

