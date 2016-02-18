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

