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
 * ApplicationGarage
 *
 * @version  0.9
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

cell ApplicationGarage
: *SGarage
{

  ClassLoader  classLoader;


  /////////////////////////////////////////////////////// public methods


  //--------------------------------------------------------------------
  public Application getApplication(Key key)
  {
    Application  app;

    app =| super->get(key);

    return app;
  }


  //--------------------------------------------------------------------
  // @exception ClassNotFoundException
  //           if the class loader cannot find a definition for the class. 
  public Key putApplication(Application app)
  {
    String  cid;

    cid = app->getClassID();
    try {
      classLoader->loadClass(cid);
    } catch (ClassNotFoundException ex) {
      throw ex;
    }

    return super->put(app);
  }


  //--------------------------------------------------------------------
  public void replaceApplication(Key key, Application app)
  {
    super->replace(key, app);
  }



  //////////////////////////////////////////////////// protected methods

  //--------------------------------------------------------------------
  protected void initialize()
  {
    super->initialize();
  }


  //--------------------------------------------------------------------
  protected void go()
  {
    classLoader => create();
    super->go();
  }


  //--------------------------------------------------------------------
  protected void quiet()
  {
    classLoader = null;
    super->quiet();
  }


  ////////////////////////////////////////////////////// private methods

}

// EoF

