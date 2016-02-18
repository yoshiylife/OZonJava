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


cell TestWrap {

  File F;
  ClassProperty cp;
//  String testsort;

  protected void initiallize() {
/*
    System system=>create();
    Array args=>create(16); args = system->getArguments();
    String s; s =| args->at(0);
    testsort => breed(s);
    system->println(testsort);
*/
  }
  protected void quiet() {
    flushCell();
  }
  protected void go() {
    System system=>create(); System debug=>create();
    Array args=>create(16); args = system->getArguments();
    String command; command =| args->at(0);
    system->println("Wrap Test");

/*
    if(command->isequal("first")){
      F => breed("/export/home0/gon/oz/user/cda/testclass.zip");
    }

    String packageName=>breed("JP.go.ipa.oz.user.released.test_cda.testclass");
//    String packageName=>breed("JP.go.ipa.oz.user.cda.test_cda.testclass");
    system->println("File created");


    if(command->isequal("first")){
      ClassDeliveryAgent remoteCDA => bind("oz.ipa.go.jp:remoteoz:test_cda");
      system->println("binded");
      ClassProperty localcp = remoteCDA->getClassProperty("JP.go.ipa.oz.user.released.test_cda.testclass._CDATestClass_cl","_CDATestClass_cl.class");
      system->println("got localcp");
      try{
        String s = localcp -> getAbsolutePath();
        system->println(s);
      }catch(FileNotFoundException e){ system->println("FileNotFound"); }
      {
        String s = localcp->getSeparator();
        system->println("getSeparator");
        system->println(s);
      }
    }
*/
/*
    if(command->isequal("first")){
      ClassDeliveryAgent remoteCDA => bind("oz.ipa.go.jp:remoteoz:test_cda");
      system->println("binded");
      ClassFile localcf = remoteCDA->getClassFile("JP.go.ipa.oz.user.released.test_cda.testclass._CDATestClass_cl");
      system->println("got localcp");
      try{
        String s = localcf -> getAbsolutePath();
        system->println(s);
      }catch(FileNotFoundException e){ system->println("FileNotFound"); }
      {
        String s = localcf->getSeparator();
        system->println("getSeparator");
        system->println(s);
      }
    }
*/
/*
    if(command->isequal("first")){
      try{
        ClassFile localcf => create("JP.go.ipa.oz.user.released.test_cda.testclass._CDATestClass_cl");
        system->println("created localcp");
        try{
          String s = localcf -> getAbsolutePath();
         system->println(s);
        }catch(FileNotFoundException e){ system->println("FileNotFound"); }
      } catch(ClassNotFoundException e){ system->println("ClassNotFound"); }
    }
*/

    if(command->isequal("cf")){
      ClassFile cf;
      try{
        system->println("ClassFile create");
        cf=>create("JP.go.ipa.oz.user.released.test_cda.testclass._CDATestClass_cl");
//        cf => create("JP.go.ipa.oz.user.cda._AtoI_cl");
      }catch(ClassNotFoundException e){ system->println("ClassNotFound Exception");
      }

      {
        system->println("ClassFile getAbsolutePath");
        String s = cf -> getAbsolutePath();
        system->println(s);
      }
    }

    if(command->isequal("cp")){
      try{
        system->println("ClassProperty create");
        cp => create("JP.go.ipa.oz.user.released.test_cda.testclass._CDATestClass_cl","_CDATestClass_cl.class");
//        cp => create("JP.go.ipa.oz.user.cda._AtoI_cl","_AtoI_cl.ci");
      }catch(FileNotFoundException e){
        system->println("FileNotFoundException");
      }

      {
        system->println("ClassProperty getAbsolutePath");
        String s = cp -> getAbsolutePath();
        system->println(s);
      }
    }
/*
    {
      system->println("ClassProperty getClassName");
      String s = cp -> getClassName();
      system->println(s);
    }

    {
      system->println("ClassProperty getCodePath");
      String s = cp -> getCodePath();
      system->println(s);
    }

    try{
      system->println("ClassProperty getInputStream");
      InputStream s = cp -> getInputStream();
    }catch(IOException e){ system->println("IO Exception");
    }

    try{
      system->println("ClassProperty getOutputStream");
      OutputStream s = cp -> getOutputStream();
    }catch(IOException e){ system->println("IO Exception");
    }catch(SecurityException e){ system->println("Security Exception");
    }

    {
      system->println("ClassProperty isReleasedUserClassFile");
      if(cp -> isReleasedUserClassFile()) system->println("true");
      else system->println("false");
    }

    {
      system->println("ClassProperty isUserClassFile");
      if(cp -> isUserClassFile()) system->println("true");
      else system->println("false");
    }
*/
/*
    system->println("LocalRepositoryManager create");
    LocalRepositoryManager lrm => create();
    system->println("LocalRepositoryManager created");

    try{
      system->println("LocalRepositoryManager remove test");
      LocalRepositoryManager->remove(packageName);
    }catch(SecurityException e){ system->println("Security Exception");
    }catch(IOException e){ system->println("IO Exception");
    }

    try{
      system->println("LocalRepositoryManager add test");
      LocalRepositoryManager->add(F,packageName);
    }catch(IOException e){ system->println("IO Exception");
    }catch(SecurityException e){ system->println("Security Exception");
    }
*/
    if(command->isequal("lrm")){
      File F2;
      try{
        String packageName=>breed("JP.go.ipa.oz.user.released.test_cda.testclass");
        system->println("LocalRepositoryManager get");
        F2 = LocalRepositoryManager->get(packageName);
        system->println(F2->getPath());
      }catch(ClassNotFoundException e){ system->println("ClassNotFound Exception");
      }catch(IOException e){ system->println("IO Exception");
      }
    }
/*
    try{
      system->println("LocalRepositoryManager classPath test");
      StringComparator sc => create();
      Set set => create(sc);
      String packageName=>breed("JP.go.ipa.oz.user.released.test_cda.testclass");
      set = set->add(packageName);
      String s = LocalRepositoryManager->classPath(set);
      system->println(s);
    }catch(ClassNotFoundException e){ system->println("ClassNotFound Exception");
    }catch(IOException e){ system->println("IO Exception");
    }
*/
/*
    system->println("ClassLoader create");
    ClassLoader cl => create();
    system->println("ClassLoader created");

    try{
      system->println("LocalRepositoryManager remove test");
      LocalRepositoryManager->remove(packageName);
    }catch(SecurityException e){ system->println("Security Exception");
    }catch(IOException e){ system->println("IO Exception");
    }
*/
    if(command->isequal("cl")){
      try{
        ClassLoader->loadClass("JP.go.ipa.oz.user.released.test_cda.testclass._CDATestClass_cl");
      }catch(ClassNotFoundException e){ system->println("ClassNotFound Exception");
      }catch(SecurityException e){ system->println("Security Exception");
      }
    }
/*
    try{
      system->println("LocalRepositoryManager remove test");
      LocalRepositoryManager->remove(packageName);
    }catch(SecurityException e){ system->println("Security Exception");
    }catch(IOException e){ system->println("IO Exception");
    }
*/
/*
    try{
      String packageName=>breed("JP.go.ipa.oz.user.released.test_cda.testclass");
      ClassLoader->loadPackage(packageName);
    }catch(ClassNotFoundException e){ system->println("ClassNotFound Exception");
    }catch(SecurityException e){ system->println("Security Exception");
    }
*/
    system->println("test end");

  }
}


