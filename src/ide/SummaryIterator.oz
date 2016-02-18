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
 * SummaryIterator
 *
 * @version  0.9
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

final class SummaryIterator
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

