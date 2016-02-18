// OZ garage


/**
 * SummaryIterator
 *
 * @version  0.9
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

class SummaryIterator
  : Iterator
{

  Collection      summaryList;
  Iterator        summaryItr;

  
  ///////////////////////////////////////////////////////// constructors
  new create(Collection summaries)
  {
    summaryList = summaries;
    summaryItr = summaryList->iterator();
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public boolean atEnd()
  {
    return summaryItr->atEnd();
  }


  //--------------------------------------------------------------------
  public boolean hasMoreElements()
  {
    return summaryItr->hasMoreElements();
  }


  //--------------------------------------------------------------------
  public Root nextElement()
  {
    return summaryItr->nextElement();
  }

}


// EoF

