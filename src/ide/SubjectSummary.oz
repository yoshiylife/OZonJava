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

// OZ DEV


/**
 * SubjectSummary
 *
 * @version  $Id$
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

class SubjectSummary
  : *Summary
{

  String  myName;
  String  myDescription;

  
  ///////////////////////////////////////////////////////// constructors

  new create()
  {
    init(null, null);
  }

  new create(String name, String dsc)
  {
    init(name, dsc);
  }
  

  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public void describe()
  {
  }


  //--------------------------------------------------------------------
  public String getDescription()
  {
    return myDescription;
  }


  //--------------------------------------------------------------------
  public String getName()
  {
    return myName;
  }


  //--------------------------------------------------------------------
  public Subject retreiveSubject()
  {
    Subject  sbj;

    sbj =| super->retreive();

    return sbj;
  }


  //--------------------------------------------------------------------
  public void setDescription(String dsc)
  {
    myDescription = dsc;
  }


  //--------------------------------------------------------------------
  public void setName(String name)
  {
    myName = name;
  }


  ////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  void init(String name, String dsc)
  {
    myName = name;
    myDescription = dsc;
  }

}


// EoF

