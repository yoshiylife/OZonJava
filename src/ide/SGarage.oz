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
 * SGarage
 *
 * @version  0.9
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

cell SGarage : *TransactionResource, Stoppable
{

  protected Garage  garage;
  //Set  summarySet;


  /////////////////////////////////////////////////////// public methods


  //--------------------------------------------------------------------
  public Summarizable get(Key key)
  {
    Summarizable  sbl;

    sbl =| garage->get(key);

    return sbl;
  }


  //--------------------------------------------------------------------
  public Summary getSummary(Key key)
  {
    Summarizable  sbl;
    Summary  sm = null;

    sbl =| garage->get(key);
    if (sbl != null) {
      sm = sbl->getSummary();
    }

    return sm;
  }
  

  //--------------------------------------------------------------------
  public Iterator iterator()
  {
    SummarizableIterator  itr;
    Collection  keys;

    keys = garage->keys();
    itr => create(keys);

    return itr;
  }


  //--------------------------------------------------------------------
  public Key put(Summarizable sbl)
  {
    Summary  smr;
    Key  key;

    smr = sbl->getSummary();
    key = garage->put(sbl);
    smr->setKey(key);
    smr->setLocation();

    return key;
  }


  //--------------------------------------------------------------------
  public void remove(Key key)
  {
    garage->remove(key);
  }


  //--------------------------------------------------------------------
  public void replace(Key key, Summarizable sbl)
  {
    garage->replace(key, sbl);
  }


  //--------------------------------------------------------------------
  public void replaceSummary(Key key, Summary sm)
  {
    Summarizable  sbl;

    if (sm != null) {
      sbl =| garage->get(key);
      if (sbl != null) {
        sm->setKey(key);
        sm->setLocation();
        sbl->setSummary(sm);
      }
    }
  }


  //--------------------------------------------------------------------
  public void stop()
  {
    stopCell();
  }


  //--------------------------------------------------------------------
  public Iterator summaryIterator()
  {
    SummaryIterator  itr;
    itr => create(summaries());

    return itr;
  }


  ////////////////////////////////////////////////////// protected methods

  //--------------------------------------------------------------------
  protected void initialize()
  {
    garage => create();
    stopCell();
  }


  //--------------------------------------------------------------------
  protected void go()
  {
  }


  //--------------------------------------------------------------------
  protected void quiet()
  {
    flushCell();
  }


  
  ////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  Collection summaries()
  {
    Set  smSet;
    Iterator  itr;  // for Summarizables
    Summarizable  sbl;
    Summary  smr;

    smSet => create();
    itr = garage->iterator();
    while (itr->hasMoreElements()) {
      sbl =| itr->nextElement();
      smr = sbl->getSummary();
      smSet->add(smr);
    }

    return smSet;
  }

}

// EoF

