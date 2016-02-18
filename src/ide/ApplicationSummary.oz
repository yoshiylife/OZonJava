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

// OZ IDE


/**
 * ApplicationSummary
 *
 * @version  0.8
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

class ApplicationSummary
  : *Summary
{

  String  name;
  String  description;

  
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
    return description;
  }


  //--------------------------------------------------------------------
  public String getName()
  {
    return name;
  }


  //--------------------------------------------------------------------
  public Application retreiveApplication()
  {
    Application  app;

    app =| super->retreive();

    return app;
  }


  //--------------------------------------------------------------------
  public void setDescription(String dsc)
  {
    this->description = dsc;
  }


  //--------------------------------------------------------------------
  public void setName(String name)
  {
    this->name = name;
  }


  ////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  void init(String name, String dsc)
  {
    this->name = name;
    this->description = dsc;
  }

}


// EoF

