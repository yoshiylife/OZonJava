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

