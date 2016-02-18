// OZ garage


/**
 * SubjectGarage
 *
 * @version  0.9
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

cell SubjectGarage
: *SGarage
{

  ClassLoader  classLoader;


  /////////////////////////////////////////////////////// public methods


  //--------------------------------------------------------------------
  public Subject getSubject(Key key)
  {
    Subject  sbj;

    sbj =| super->get(key);

    return sbj;
  }


  //--------------------------------------------------------------------
  // @exception ClassNotFoundException
  //           if the class loader cannot find a definition for the class. 
  public Key putSubject(Subject sbj)
  {
    String  pkgName;

    pkgName = sbj->getPackageName();
    try {
      classLoader->loadPackage(pkgName);
    } catch (ClassNotFoundException ex) {
      throw ex;
    }

    return super->put(sbj);
  }


  //--------------------------------------------------------------------
  public void replaceSubject(Key key, Subject sbj)
  {
    super->replace(key, sbj);
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

