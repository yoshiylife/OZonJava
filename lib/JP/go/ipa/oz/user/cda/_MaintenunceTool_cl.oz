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

cell MaintenunceTool {

  ClassDeliveryAgent CDA;
  String urPath;
  char separatorChar;
  String separatorString;

  protected void initialize(){
    System system=>create();
//    CDAdebug debug=>create();
    String ozhomeS = system->getOzHome();
    String urS => breed(".lib.JP.go.ipa.oz.user.released");
    File f => breed(ozhomeS);
    separatorChar = f->getSeparatorChar();
    separatorString = f->getSeparator();
    urS = urS->replace('.', separatorChar);
    urPath = ozhomeS->concat(urS);
//    debug->println(urPath);
  }

  protected void recursiveDir(String nowDirPath, System system){
//    CDAdebug debug=>create();
//    debug->println(nowDirPath);
    File nowDir;
    nowDir => breed(nowDirPath);
    Array nowNames;
    nowNames = nowDir->list();
//    debug->println(nowNames->asString());
    int size = nowNames->size();
    for(int i=0; i<size; i++){
      String fileName, subPath; File subFile;
      fileName =| nowNames->at(i);
      subPath = nowDirPath->concat(separatorString);
      subPath = subPath->concat(fileName);
      subFile => breed(subPath);
      if(subFile->isDirectory()){
        recursiveDir(subPath, system);
      } else if(subPath->lastIndexOf(".zip") > -1){
        system->println(subPath);
      }
    }
  }

  protected void go(){
    System system=>create();
    CDAdebug debug=>create();
    Array args=>create(16); args = system->getArguments();
    String command; command =| args->at(0);

    debug->println(command);
    if(command->isequal("setCDAGOL")){ 
      String CDAGOL; CDAGOL =| args->at(1);
      debug->println(CDAGOL);
      CDA => bind(CDAGOL);
    } else if(command->isequal("wait")){
      String s; s =| args->at(1); int i = AtoI->atoi(s);
      sleepThread(i);
    } else if(command->isequal("LocalRepository")){
      String subcommand; subcommand =| args->at(1);
      if(subcommand->isequal("zips")){
        recursiveDir(urPath,system);
      } else if(subcommand->isequal("zipentry")){
        String zipFileDirPath; zipFileDirPath =| args->at(2);
        debug->println(zipFileDirPath);
        zipFileDirPath = separatorString->concat(zipFileDirPath);
        zipFileDirPath = urPath->concat(zipFileDirPath);
        debug->println(zipFileDirPath);
        CDAZipFile zf => breed(zipFileDirPath);
//        debug->println("1");
        Array entries = zf->list();
//        debug->println(entries->asString());
        int size = entries->size();
        for(int i=0; i<size; i++){
          String entryName; entryName =| entries->at(i);
          system->println(entryName);
        }
      } else if(subcommand->isequal("get")){
        String packageName; packageName =| args->at(2);
        File f;
        try{
          f = LocalRepositoryManager->get(packageName);
          system->println(f->getPath());
        } catch(IOException e){
          system->println("get IOException");
        } catch(ClassNotFoundException e){
          system->println("get ClassNotFoundException");
        }
        if(f!=null){
          system->println(f->getName());
        }
      } else if(subcommand->isequal("remove")){
        String topPackageName; topPackageName =| args->at(2);
        try{
          LocalRepositoryManager->remove(topPackageName);
        } catch(IOException e){
          system->println("IOException");
        } catch(SecurityException e){
          system->println("SecurityException");
        }
      }
    } else if(command->isequal("SearchPolicy")){ 
      String subcommand; subcommand =| args->at(1);
      if(subcommand->isequal("getLeaveTo")){
        String s = CDA->targetsLeaveToWhom();
        if(s==null) s=>breed("null");
        system->println(s);
      } else if(subcommand->isequal("setLeaveTo")){
        String s; s =| args->at(2);
        CDA->targetsSetLeaveTo(s);
      } else if(subcommand->isequal("getTargets")){
        Array a = CDA->targetsTargets();
        system->println(a->asString());
      } else if(subcommand->isequal("removeTarget")){
        String s; s =| args->at(2);
        CDA->targetsRemove(s);
      } else if(subcommand->isequal("setTarget")){
        String s; s =| args->at(2);
        debug->println(s);
        int i = CDA->targetsPut(s);
        Integer I => breed(i); debug->println(I->asString());
      } else if(subcommand->isequal("setTargetAt")){
        String s; s =| args->at(2);
        String at; at =| args->at(3); int i = AtoI->atoi(at);
        CDA->targetsPutAt(i,s);
      }
    } else if(command->isequal("Milloring")){
      String subcommand; subcommand =| args->at(1);
      debug->println(subcommand);
      if(subcommand->isequal("setMillorServer")){
        String s; s =| args->at(2);
        CDA->millorsAdd(s);
      } else if(subcommand->isequal("setMillorClient")){
        String s; s =| args->at(2);
        CDA->millorsAdd(s);
      } else if(subcommand->isequal("setMillorPackage")){
        String s; s =| args->at(2);
        String name; name =| args->at(3);
        CDA->millorsAddTopPackageName(s, name);
      } else if(subcommand->isequal("removeMillorPackage")){
        String s; s =| args->at(2);
        String name; name =| args->at(3);
        CDA->millorsRemoveTopPackageName(s, name);
      } else if(subcommand->isequal("getMillorPackage")){
        String s; s =| args->at(2);
        Dictionary times = CDA->millorsGet(s);
        system->println(times->asString());
      } else if(subcommand->isequal("pollingStart")){
        CDA->millorsPollingStart();
      } else if(subcommand->isequal("writingStart")){
        CDA->millorsWriteStart();
      } else if(subcommand->isequal("WriteInValid")){
        CDA->modeWriteInValid();
      } else if(subcommand->isequal("CopyOnWrite")){
        CDA->modeCopyOnWrite();
      } else if(subcommand->isequal("setInterval")){
        String s; s =| args->at(2);
        int i = AtoI->atoi(s);
        CDA->setInterval(i);
      }
    }
  }
  protected void quiet(){flushCell();}
}

