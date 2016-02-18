// OZ Garage


/**
 * KeyGenerator
 *
 * @version  0.9
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

class KeyGenerator
{

  int  theKey;


  ///////////////////////////////////////////////////////// constructors

  new create()
  {
    theKey = 0;
  }


  /////////////////////////////////////////////////////// public methods

  public Key generate()
  {
    Key  key;

    theKey++;
    key => create(theKey);

    return key;
  }

}


// EoF

