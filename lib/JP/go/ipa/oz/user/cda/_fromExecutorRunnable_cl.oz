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

class ServerSocketRunnable :* Runnable{
  int port;
  DeliveryFileCache cache;
  TargetCDAList targets;
  ServerSocket listen;
  new create(int i, DeliveryFileCache c, TargetCDAList t){
    port=i; cache=c; targets=t;
  }
  public void close(){
    listen->close();
  }
  public void run(){
    System system=>create();
    CDAdebug debug=>create();
    try{
      listen => breed(port);
    } catch(IOException e){
      system->println("can not breed ServerSocket");
    }
    try{
      while(true){
        system->println("listening");
        Socket client = listen->accept();
        debug->println("accept");
        fromExecutorRunnable fromE => create(client,cache,targets);
        Thread t => create(fromE);
      }
    } catch(Exception e){
      system->println("ClassDeliveryAgent failed to accept from executor or reply to executor, or server socket closed");
    } catch(UserException e){
      system->println("ClassDeliveryAgent failed to accept from executor or reply to executor, or server socket closed");
    }
  }
}

class fromExecutorRunnable :* Runnable{
  Socket client;
  int RetryNum;
  DeliveryFileCache cache;
  TargetCDAList targets;

  new create(Socket s, DeliveryFileCache c, TargetCDAList t){
    CDAdebug debug=>create();
    client=s;
    RetryNum = 0;
    cache=c;
    targets=t;
    debug->println("fromExecutorRunnable created");
  }

  public void run(){
  /* executorからのリクエストを受けて他CDAと通信 */
    CDAdebug debug=>create();
    debug->println("fromExecutorRunnable begin");
    DataInputStream in => breed(client->getInputStream());
    debug->println("DataInputStream made");
    DataOutputStream out => breed(client->getOutputStream());
    debug->println("DataOutPutStream made");
    String protocolTag = in->readUTF();
    debug->println(protocolTag);
    if(protocolTag->isequal("REQ")){
      String codePath = in->readUTF();
      debug->println(codePath);

      DeliveryFile df;
      if( (df = cache->get(codePath)) != null){
        debug->println("already");
      } else {
        df = getPackageFromOtherCDA(codePath);
      }

      if(df==null){
        out->writeUTF("NA");
        out->writeUTF(codePath);
      } else{
        cache->put(df->getTopPackageName(),df);
        debug->println("socket reply begin");
        out->writeUTF("REP");
        out->writeUTF(codePath);
        String topPackageName = df->getTopPackageName();
        debug->println(topPackageName);
        out->writeUTF(topPackageName);
        int length = df->getLength();
        Integer I => breed(length); debug->println(I->asString());
        out->writeInt(length);
        ByteArray buffer = df->getContents();
        debug->println("begin buffer");
        out->write(buffer,0,length);
        debug->println("end buffer");
      }
    }
    in->close();
    out->close();
  }

  /* 他CDAと通信 */
  protected DeliveryFile getPackageFromOtherCDA(String codePath){
//    CDAdebug debug=>create();
    DeliveryFile df;
    String targetCDAGOL;
    df = null;
//    debug->println("getPackageFromOtherCDA");
    if( (targetCDAGOL = targets->leaveToWhom()) != null ){
//      debug->println("target leave to");
      ClassDeliveryAgent targetCDA; targetCDA => bind(targetCDAGOL);
      if(targetCDA != null)
        df = targetCDA->leaveToSearchAndDelivery(codePath);
    } else{
//      debug->println("target not leave to");
      while( (targetCDAGOL = targets->next(RetryNum)) != null ){
//        debug->println(targetCDAGOL);
        ClassDeliveryAgent targetCDA; targetCDA => bind(targetCDAGOL);
        if(targetCDA != null){
//          debug->println("binded");
          df = targetCDA->searchAndDelivery(codePath);
//          debug->println("searched");
        }
        if(df!=null) break;
        RetryNum++;
      }
    }
//    if(df==null) debug->println("getPackageFromOtherCDA end null");
//    else debug->println("getPackageFromOtherCDA end not null");
    return df;
  }

}

class PollingRunnable :* Runnable{
  int interval; /*msec*/
  MillorTarget millors; /* millorServerCDAGOL -- (topPackageName -- time) */
  DeliveryFileCache dfCache;
  protected condition cond;

  new create(MillorTarget mil, DeliveryFileCache cache){
    interval = 60000;
    millors = mil;
    dfCache = cache;
  }

  public void setInterval(int i){
    interval = i;
  }


  public void run(){
    beforePolling();
    try{
      Set targetGOLs; Iterator targetIte; int targetnum; bool b = true;
      while(b){
        sleepThread(interval);
        CDAdebug debug=>create();
//        debug->println("polling sleep end");
        targetGOLs = millors->getTargetGOLs();
        targetIte = targetGOLs->iterator();
        targetnum = targetGOLs->size();
//        Integer I => breed(targetnum); debug->println(I->asString());
        String millorServerCDAGOL;
        Dictionary times; Iterator ite; int size;
        ClassDeliveryAgent millorServerCDA;
        for(int j=0; j<targetnum; j++){
          millorServerCDAGOL =| targetIte->nextElement();
          times = millors->get(millorServerCDAGOL);
//          debug->println("millorServerCDAGOL");
          debug->println(millorServerCDAGOL);
          ite = times->keyIterator();
          size = times->size();
//          I => breed(size); debug->println(I->asString());
          millorServerCDA => bind(millorServerCDAGOL);
          if(millorServerCDA != null){
            String topPackageName;
            long time;
            DeliveryFile df;
            for(int i=0; i<size; i++){
              topPackageName =| ite->nextElement();
//              debug->println(topPackageName);
              Long L; L =| times->get(topPackageName);
              time = L->longValue();
//              debug->println(L->asString());
              df = millorServerCDA->millor(topPackageName,time);
              if(df!=null){
                try{
                  LocalRepositoryManager->remove(topPackageName); /* crit */
                }catch(IOException e){
//                  debug->println("not versionuped");
                }catch(SecurityException e){
//                  debug->println("not versionuped");
                }
                dfCache->put(topPackageName,df);
                time = df->time();
                millors->versionupTopPackage(millorServerCDAGOL,topPackageName,time);
              /* do not LocalRepositoryManager->add */
              } else{
//                debug->println("not versionuped");
              }
            }
          }
        }
      }
//    } catch(Exception e){
//      System system=>create(); system->println("polling fail");
    } catch(UserException e){
      System system=>create(); system->println("polling fail");
    }
  }

  protected locked void beforePolling(){ wait(cond); }
  public locked void pollingStart(){ 
//  never create CDAdebug here. 
    signal(cond);
  }

}

class CopyOnRightRunnable :* Runnable{
  int interval; /*msec*/
  MillorTarget millors; /* millorServerCDAGOL -- (topPackageName -- time) */
  DeliveryFileCache dfCache;
  protected condition cond;
  bool isWriteInValid;

  new create(MillorTarget mil, DeliveryFileCache cache, bool isWIV){
    CDAdebug debug=>create();
    debug->println("CopyOnRightRunnable create");
    interval = 60000;
    millors = mil;
    dfCache = cache;
    isWriteInValid = isWIV;
    debug->println("CopyOnRightRunnable created");
  }

  public void setInterval(int i){
    interval = i;
  }

  public void modeWIV(){ isWriteInValid = true; }
  public void modeCOW(){ isWriteInValid = false; }

  protected locked void beforeCopy(){ wait(cond); }
  public locked void copyStart(){ 
//    CDAdebug debug=>create(); debug->println("copyStart()");
    signal(cond);
  }

  public void run(){
    System system=>create();
//    CDAdebug debug=>create();
    beforeCopy();
    try{
      Set targetGOLs; Iterator targetIte; int targetnum; bool b = true;
      while(b){
//        debug->println("copy sleep begin");
        sleepThread(interval);
//        debug->println("copy sleep end");
        targetGOLs = millors->getTargetGOLs();
        targetIte = targetGOLs->iterator();
        targetnum = targetGOLs->size();
//        Integer I => breed(targetnum); debug->println(I->asString());
        String millorClientCDAGOL;
        Dictionary times; Iterator ite; int size;
        ClassDeliveryAgent millorClientCDA;
        for(int j=0; j<targetnum; j++){
          millorClientCDAGOL =| targetIte->nextElement();
          times = millors->get(millorClientCDAGOL);
//          debug->println("millorClientCDAGOL");
//          debug->println(millorClientCDAGOL);
          ite = times->keyIterator();
          size = times->size();
//          I => breed(size); debug->println(I->asString());
          millorClientCDA => bind(millorClientCDAGOL);
          if(millorClientCDA != null){
            String topPackageName;
            long time;
            DeliveryFile df;
            File f;
            for(int i=0; i<size; i++){
              topPackageName =| ite->nextElement();
//              debug->println(topPackageName);
              Long L; L =| times->get(topPackageName);
              time = L->longValue();
//              debug->println(L->asString());
              f = LocalRepositoryManager->get(topPackageName);
              if( (f!=null) && (isSecurityOKasMillorClient()) && 
                  (isMillorOK(topPackageName)) ){
                long lastTime = f->lastModified();
                if(lastTime != time){
                  if(!isWriteInValid){
                    int length; length =| f->length();
                    FileInputStream fis => breed(f);
                    ByteArray buffer => create(length);
                    if(fis->read(buffer) == length){
                      String fileName = f->getName();
                      df=> create(topPackageName,topPackageName,length,buffer);
                      if(df!=null){
                        df->timeStamp(lastTime);
                        bool isCopied = millorClientCDA->thisCopyOnRight(df);
                        if(isCopied){
                          millors->setTime(millorClientCDAGOL,topPackageName,lastTime);
                        }
                      }
                    }
                  } else{
                    bool isCopied = millorClientCDA->thisWriteInValid(df);
                    if(isCopied){
                      millors->setTime(millorClientCDAGOL,topPackageName,lastTime);
                    }
                  }
                }
              }
            }
          }
        }
      }
    } catch(Exception e){
      system->println("polling fail");
    } catch(UserException e){
      system->println("polling fail");
    }
  }

  protected bool isSecurityOKasMillorClient(){ return true; }
  protected bool isMillorOK(String topPackageName){ return true; }

}
