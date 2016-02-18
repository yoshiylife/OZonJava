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

