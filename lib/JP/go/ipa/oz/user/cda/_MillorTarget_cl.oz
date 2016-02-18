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

cell stopCDA {
  protected void initiallize() {}
  protected void quiet() { flushCell(); }
  protected void go() {
    CDAdebug debug=>create();
    debug->println("stopCDA go begin");
    ClassDeliveryAgent CDA => bind("cda");
    debug->println("stopCDA binded");
    CDA->stop();
    debug->println("stopCDA stopped");
    stopCell();
  }
}

cell ClassDeliveryAgent :* Stoppable{

  String host;
  int port;
  DeliveryFileCache cache;
  TargetCDAList targets;
  ServerSocketRunnable ssr;
  MillorTarget millors; /* as client */
  PollingRunnable polling;
  MillorTarget millorsS; /* as server */
  CopyOnRightRunnable copyOR;
  bool millorOn;
  String millorMode;

  public void stop(){
    CDAdebug debug=>create();
    debug->println("CDA stopCDA begin");
    ssr->close();
    debug->println("server socket closed");
    stopCell();
  }
  protected void initiallize() {}
  protected void quiet() {
    super->quiet();
    flushCell();
  }
  protected void go() {
    System system=>create();
    CDAdebug debug=>create();
    Array args=>create(16); args = system->getArguments();

    /* キャッシュ生成 not in initialize */
    cache => create();

    /* 検索方針生成 not in initialize */
    targets => create();

    /* ホストとポートの設定 */
    host = CDAProperty->getHost();
    if(host==null){
      system->println("Error! -- host of oz.classloader.deliveryAgent.url in oz.properties. cda can not go.");
      stopCell();
    } else{
      port = CDAProperty->getPort();
      if(port==-1){
        system->println("Error! -- port of oz.classloader.deliveryAgent.url in oz.properties. cda can not go.");
        stopCell();
      } else{ 
//        debug->println(host);
//        Integer I => breed(port); debug->println(I->asString());

        /* urlファイル作成 */
        /* executor095aから oz.properties の oz.classloader.deliveryAgent.url
        String ozHomeProperty => breed("/export/home0/gon/oz");
        String urlFileName =
          ozHomeProperty->concat("/objects/classDeliveryAgent/url");
        FileOutputStream fs; fs=>breed(urlFileName);
        String url => breed("ozclass://"); url = url->concat(host);
        url = url->concat(":"); url = url->concat(portString);
        url = url->concat("/");
        ByteArray urlByteArray = url->getBytes();
        fs->write(urlByteArray);
        fs->close(); */

        /* サーバソケット起動して監視 */
        ssr => create(port,cache,targets);
        Thread t => create(ssr);

        /* ミラークライアントサーバ起動  */
        millors => create(true);
        millorsS => create(false);
        polling => create(millors, cache);
        Thread tMil => create(polling);
        debug->println("millor5");
        copyOR => create(millors, cache, false);
        debug->println("millor6");
        Thread tCop => create(copyOR);

        /* プロパティファイルから初期設定 */
        setInitial();

        /* 起動メッセージ表示 */
        String mes;
        system->println("CDA start.");
        mes => breed("ozclass socket host is "); mes=mes->concat(host);
        system->println(mes);
        Integer Port => breed(port);
        mes => breed("ozclass socket port is ");
        mes=mes->concat(Port->asString());
        system->println(mes);

        /* ミラースタート */
        if(millorOn){
          if(millorMode->isequal("polling")){
            sleepThread(1000);
            millorsPollingStart();
            debug->println("polling milloring start");
	  } else {
            sleepThread(1000);
            millorsWriteStart();
            debug->println("WIV or COW milloring start");
          }
        }
      }
    }
  }

  /* cdaはpollingかCOWかWIVどれかひとつのモード */
  protected void setInitial(){
    millorOn = false;
    millorMode = "polling";
    String propVal;
    CDAdebug debug=>create();
    debug->println("setInitial start");

    propVal = CDAProperty->getProp("leaveTarget");
    if(propVal!=null){
      targetsSetLeaveTo(propVal);
      debug->println("leaveTarget---"); debug->println(propVal);
    }

    propVal = CDAProperty->getProp("target");
    if(propVal!=null){
      int delind; String carS, cdrS = propVal;
      while( (delind = cdrS->indexOf(",")) > 0){
        carS = cdrS->substring(0,delind);
        cdrS = cdrS->substring(delind+1);
        String nowTarget;
        nowTarget = carS->concat(":cda");
        targetsPut(nowTarget);
        debug->println("target---"); debug->println(carS);
      }
      String nowTarget;
      nowTarget = cdrS->concat(":cda");
      targetsPut(nowTarget);
      debug->println("target---"); debug->println(cdrS);
    }

    propVal = CDAProperty->getProp("millorMode");
    if(propVal!=null){
      debug->println("millorMode---"); debug->println(propVal);
      if(propVal->isequal("writeInValidate")){
	modeWriteInValid();
	millorMode = "WIV";
        debug->println("mode---WIV");
      } else if(propVal->isequal("copyOnWrite")){
        modeCopyOnWrite();
	millorMode = "COW";
        debug->println("mode---COW");
      }
    }

    propVal = CDAProperty->getProp("millorInterval");
    if(propVal!=null){
      int interval = AtoI->atoi(propVal);
      setInterval(interval);
      debug->println("millorInterval---"); debug->println(propVal);
    }

    propVal = CDAProperty->getProp("millorStart");
    if(propVal!=null){
      if(propVal->isequal("true")) millorOn = true;
      debug->println("millorStart---"); debug->println(propVal);
    }

    propVal = CDAProperty->getProp("millor");
    if(propVal!=null){
      int delind; String carS, cdrS = propVal;
      debug->println("millor---");
      while( (delind = cdrS->indexOf("&")) > 0){
        carS = cdrS->substring(0,delind);
        cdrS = cdrS->substring(delind+1);
	int delindIn; String caarS, cadrS; String nowMT;
        delindIn = carS->indexOf(",");
        caarS = carS->substring(0,delindIn);
        nowMT = caarS->concat(":cda");
        cadrS = carS->substring(delindIn+1);
        millorsAdd(nowMT);
        debug->println(nowMT);
        while( (delindIn = cadrS->indexOf(",")) > 0){
          caarS = cadrS->substring(0,delindIn);
          cadrS = cadrS->substring(delindIn+1);
          millorsAddTopPackageName(nowMT, caarS);
          debug->println(caarS);
	}
        caarS = cadrS;
        millorsAddTopPackageName(nowMT, caarS);
        debug->println(caarS);
      }
      carS = cdrS;
      int delindIn; String caarS, cadrS; String nowMT;
      delindIn = carS->indexOf(",");
      caarS = carS->substring(0,delindIn);
      nowMT = caarS->concat(":cda");
      cadrS = carS->substring(delindIn+1);
      millorsAdd(nowMT);
      debug->println(nowMT);
      while( (delindIn = cadrS->indexOf(",")) > 0){
        caarS = cadrS->substring(0,delindIn);
        cadrS = cadrS->substring(delindIn+1);
        millorsAddTopPackageName(nowMT, caarS);
        debug->println(caarS);
      }
      caarS = cadrS;
      millorsAddTopPackageName(nowMT, caarS);
      debug->println(caarS);
    }
  }

  /* 
    他CDAからcodePathで示されたクラスの検索配送を全面委譲されて実行する。
    このメソッドをユーザが呼ぶことはない。
    Parametors: codePath - 検索配送するクラスのコードパス
    Returns: そのクラスのデリバリファイル
  */
  public DeliveryFile leaveToSearchAndDelivery(String codePath){
    DeliveryFile df = searchAndDelivery(codePath); /* first myself*/
    if( df != null ) return df;
    int RetryNum = 0;
    String targetCDAGOL;
    while( (targetCDAGOL = targets->next(RetryNum)) != null ){
      ClassDeliveryAgent targetCDA; targetCDA => bind(targetCDAGOL);
      df = targetCDA->searchAndDelivery(codePath); /* next others */
      if(df!=null) break;
      RetryNum++;
    }
    return df;
  }

  /* 
    他CDAから要求された、codePathで示されたクラスの検索配送を実行する。
    このメソッドをユーザが呼ぶことはない。
    Parametors: codePath - 検索配送するクラスのコードパス
    Returns: そのクラスのデリバリファイル
  */
  public DeliveryFile searchAndDelivery(String codePath){
    CDAdebug debug=>create();
    File f;
    try{
      f = LocalRepositoryManager->get(codePath);
/*
      if(f==null){
        debug->println("LocalRepositoryManager get return null");
        return null;
      }
*/
    } catch(ClassNotFoundException e){
        debug->println("LocalRepositoryManager can not find");
        return null;
    } catch(IOException e){
      debug->println("searchAndDelivery IO exception");
      return null;
    }
    int length; length =| f->length();
    Integer I => breed(length); debug->println(I->asString());
    FileInputStream fis => breed(f);
    ByteArray buffer => create(length);
    debug->println("begin buffer");
    if(fis->read(buffer) != length){
      debug->println("buffer fail");
      return null;
    }
    String fileName = f->getName();
    String topPackageName = getTopPackageName(codePath, fileName);
    if(topPackageName==null) return null;
    debug->println(topPackageName);
    DeliveryFile df => create(codePath,topPackageName,length,buffer);
    debug->println("end buffer");
    return df;
  }

  protected String getTopPackageName(String codePath, String fileName){
//    CDAdebug debug=>create();
    String name = fileName->substring(0,fileName->lastIndexOf("."));
//    debug->println(name);
    String topPackageName => breed(codePath);
    int ind;
    while( (ind = topPackageName->lastIndexOf(".")) > -1 ){
//      debug->println(topPackageName);
      String nameCand;
      nameCand = topPackageName->substring(1+ind);
//      debug->println(nameCand);
      if(nameCand->isequal(name)) return topPackageName;
      else topPackageName = topPackageName->substring(0,ind);
    }
    return null;
  }

  /* as server */
  /* 
    ポーリングミラーモードにおいて呼ばれる。
    ミラーサーバとして、topPackageNameで示されたパッケージがtime以降に変更
    を受けているのならそれをデリバリファイル形式で返す。
    このメソッドをユーザが呼ぶことはない。
    Parametors: topPackageName - ミラー対象のパッケージ名
                time - ミラークライアント側でのミラー対象の最終更新時刻
    Returns: ミラー対象のデリバリファイル
  */
  public DeliveryFile millor(String topPackageName, long time){
    CDAdebug debug => create();
    debug->println("millor server begin");
    debug->println(topPackageName);
    Long L => breed(time); debug->println(L->asString());
    File f = LocalRepositoryManager->get(topPackageName);
    if( (isSecurityOKasMillorClient()) && (isMillorOK(topPackageName)) ){
      long lastTime = f->lastModified();
      L => breed(lastTime); debug->println(L->asString());
      if(lastTime != time){
        DeliveryFile df = searchAndDelivery(topPackageName);
        if(df==null) return null;
        df->timeStamp(lastTime);
        debug->println("millor server end");
        return df;
      } else return null;
    } else return null;
  }


  /* as client */
  /* 
    コピーオンライトミラーモードにおいて呼ばれる。
    ミラークライアントとして、df中のクラスアーカイブファイルが最新のもの
    であるのでそれをローカルのexecutorへ反映させる。
    このメソッドをユーザが呼ぶことはない。
    Parametors: df - ミラー対象のクラスアーカイブファイルを中身とする
                     デリバリファイル
    Returns: 反映が成功した場合はtrue、そうでない場合はfalse
  */
  public bool thisCopyOnRight(DeliveryFile df){
    String topPackageName = df->getTopPackageName();
    if( (isSecurityOKasMillorServer()) && (isMillorOK(topPackageName)) ){
      try{
        LocalRepositoryManager->remove(topPackageName); /* crit */
        cache->put(topPackageName,df);
      }catch(IOException e){
        return false;
      }catch(SecurityException e){
        return false;
      }
      return true;
    } else{
      return false;
    }
  }

  /* 
    ライトインバリデートミラーモードにおいて呼ばれる。
    ミラークライアントとして、df中のクラスアーカイブファイルが最新のもの
    であるのでそのことをローカルのexecutorに通知する(即座に反映はしない)。
    このメソッドをユーザが呼ぶことはない。
    Parametors: df - ミラー対象のクラスアーカイブファイルを中身とする
                     デリバリファイル
    Returns: 通知が成功した場合はtrue、そうでない場合はfalse
  */
  public bool thisWriteInValid(DeliveryFile df){
    String topPackageName = df->getTopPackageName();
    if( (isSecurityOKasMillorServer()) && (isMillorOK(topPackageName)) ){
      try{
        LocalRepositoryManager->remove(topPackageName); /* crit */
      }catch(IOException e){
        return false;
      }catch(SecurityException e){
        return false;
      }
      return true;
    } else{
      return false;
    }
  }

  /* for maintenunce */

  /* 
    クラス配送クライアントとして、クラスの検索配送の他のCDAへの全面委譲状況
    を返す。
    Returns: 全面委譲しているのなら委譲相手のCDAのGOL、していないのならnull
  */
  public String targetsLeaveToWhom(){
    return targets->leaveToWhom();
  }

  /* 
    クラス配送クライアントとして、クラスの検索配送の他のCDAへの全面委譲
    を設定する。
    whom が null の場合は何もしない。
    Parametors: whom - 委譲相手のCDAのGOL
  */
  public void targetsSetLeaveTo(String whom){
    targets->setLeaveTo(whom);
  }

  /* 
    クラス配送クライアントとして、検索方針を表示する。
    Returns: 検索方針(検索順にならべたCDAのGOL)
  */
  public Array targetsTargets(){
    return targets->targets();
  }

  /* 
    クラス配送クライアントとして、GOLがtargetのCDAを検索方針の末尾に登録する。
    target が null の場合は何もしない。
    Parametors: whom - CDAのGOL
    Returns: 検索方針のサイズ(何個のCDAが検索方針として登録されているか)
  */
  public int targetsPut(String target){
    return targets->put(target);
  }

  /* 
    クラス配送クライアントとしてGOLがtargetのCDAを検索方針のat番目に登録する。
    target が null の場合は何もしない。
    at が 0より小さい場合は何もしない。
    atが検索方針のサイズより大きい場合はその末尾に登録する。
    Parametors: whom - CDAのGOL
                at - 検索方針の何番目に登録するか
    Returns: 検索方針のサイズ(何個のCDAが検索方針として登録されているか)
  */
  public int targetsPutAt(int at, String target){
    return targets->putAt(at,target);
  }


  /* 
    クラス配送クライアントとして、GOLがtargetのCDAを検索方針から削除する。
    target が null の場合は何もしない。
  */
  public void targetsRemove(String target){
    targets->remove(target);
  }

  /* 
    ミラークライアントとして、GOLがtargetのCDAをミラーサーバとして登録する。
    または、ミラーサーバとして、GOLがtargetのCDAをミラークライアントとして
    登録する。
    target が null の場合は何もしない。
    Parametors: target - CDAのGOL
  */
  public void millorsAdd(String target){
    millors->add(target);
  }

  /* 
    ポーリングミラーモードにおいて呼ばれる場合は、
    ミラークライアントとして、GOLがtargetのミラーサーバに対して、
    トップパッケージネームがnameのクラスアーカイブファイルのミラーサービス
    を要求する。
    コピーオンライトミラーモードやライトインバリデートミラーモードにおいて
    呼ばれる場合は、ミラーサーバとして、GOLがtargetのミラークライアントに
    対して、トップパッケージネームがnameのクラスアーカイブファイルのミラー
    サービスを行う。
    target か name が null の場合は何もしない。
    target がmillorsAddメソッドによって登録されているものでない時は何もしない。
    Parametors: target - ミラー相手のGOL
                name - ミラーサービス対象となるクラスアーカイブファイルの
                       トップパッケージネーム
  */
  public void millorsAddTopPackageName(String target, String name){
    millors->addTopPackageName(target, name);
  }

  /* 
    ポーリングミラーモードにおいて呼ばれる場合は、
    ミラークライアントとして、GOLがtargetのミラーサーバに対して、
    トップパッケージネームがnameのクラスアーカイブファイルのミラーサービス
    の要求を取り消す。
    コピーオンライトミラーモードやライトインバリデートミラーモードにおいて
    呼ばれる場合は、ミラーサーバとして、GOLがtargetのミラークライアントに
    対して、トップパッケージネームがnameのクラスアーカイブファイルのミラー
    サービスを行わないようにする。
    target か name が null の場合は何もしない。
    target がmillorsAddメソッドによって登録されているものでない時は何もしない。
    Parametors: target - ミラー相手のGOL
                name - ミラーサービス対象となるクラスアーカイブファイルの
                       トップパッケージネーム
  */
  public void millorsRemoveTopPackageName(String target, String name){
    millors->removeTopPackageName(target, name);
  }

  /* 
    ミラークライアントとして、GOLがtargetのミラーサーバに対して
    ミラーサービスを要求しているクラスアーカイブファイルがあるが、
    そのトップパッケージネームとミラークライアント側における最終更新時刻の
    対を返す。
    または、ミラーサーバとして、GOLがtargetのミラークライアントに対して
    ミラーサービスを行っているクラスアーカイブファイルがあるが、
    そのトップパッケージネームとミラーサーバ側における最終更新時刻の
    対をDictionary形式で返す。
    Parametors: target - CDAのGOL
    Returns: そのトップパッケージネームとミラークライアント側における
             最終更新時刻の対をassociationとするDeictionary
  */
  public Dictionary millorsGet(String target){
    return millors->get(target);
  }

  /* 
    ポーリングミラーモードの時に呼ばれるメソッドである。
    ミラークライアントとして、ポーリングをスタートする。
  */
  public void millorsPollingStart(){
//    CDAdebug debug=>create(); debug->println("millorsPollingStart()");
    polling->pollingStart();
  }

  /*
    ミラーサーバとして、ミラーモードをライトインバリデートにする。
  */
  public void modeWriteInValid(){
    copyOR->modeWIV();
  }

  /*
    ミラーサーバとして、ミラーモードをコピーオンライトにする。
  */
  public void modeCopyOnWrite(){
    copyOR->modeCOW();
  }

  /* 
    コピーオンライトミラーモードの時に呼ばれるメソッドである。
    ミラーサーバとして、コピーオンライトによるミラーリングをスタートする。
    あるいは、ライトインバリデートミラーモードの時に呼ばれるメソッドである。
    ミラーサーバとして、ライトインバリデートによるミラーリングをスタートする。
  */
  public void millorsWriteStart(){
    copyOR->copyStart();
  }

  /*
    ミラーリングの間隔を指定する。
    paramator: interval -  ミラーリングの間隔(msec)
  */
  public void setInterval(int interval){
    copyOR->setInterval(interval);
    polling->setInterval(interval);
  }

  /* after security manager */

  protected bool isSecurityOKasMillorClient(){ return true; }
  protected bool isSecurityOKasMillorServer(){ return true; }
  protected bool isMillorOK(String topPackageName){ return true; }

  /* for ClassProperty/ClassFile */
  /* 
    codePath で示されたクラスの name で示されたクラスプロパティを
    ローカルに探索して返す。
    このメソッドをユーザが呼ぶことはない。
    Parametors: codePath - クラスのコードパス
                name - クラスプロパティの相対ファイル名
    Returns: クラスプロパティファイル
  */
  public ClassProperty getClassProperty(String codePath,String name){
//    CDAdebug debug => create();
//    debug->println("getClassProperty begin");
    ClassProperty cp => create(codePath,name);
//    debug->println("getClassProperty end");
    return cp;
  }

  /* 
    codePath で示されたクラスファイルをローカルに探索して返す。
    このメソッドをユーザが呼ぶことはない。
    Parametors: codePath - クラスファイルのコードパス
    Returns: クラスファイル
  */
  public ClassFile getClassFile(String codePath){
//    CDAdebug debug => create();
//    debug->println("getClassFile begin");
    ClassFile cf => create(codePath);
//    debug->println("getClassFile end");
    return cf;
  }

}

class DeliveryFileCache {

  Dictionary defi; /* topPackageName -- deliveryFile */

  new create(){
    StringComparator sc => create();
    defi => create(sc);
  }

/*
  public bool already(String codePath){
    return defi->containsKey(codePath);
  }

  public DeliveryFile get(String codePath){
    DeliveryFile df; df =| defi->get(codePath);
    return df;
  }

  public locked void put(String codePath, DeliveryFile df){
    defi = defi->put(codePath,df);
  }
*/

  public locked DeliveryFile get(String codePath){
    DeliveryFile df = null;
    Iterator ite = defi->keyIterator();
    int size = defi->size();
    String topPackageName;
    for(int i=0; i<size; i++){
      topPackageName =| ite->nextElement();
      if(below(topPackageName,codePath)){
        df =| defi->get(topPackageName);
        break;
      }
    }
    return df;
  }

  protected bool below(String topPackageName, String codePath){
//    CDAdebug debug => create();
//    debug->println("in below");
//    debug->println(topPackageName);
//    debug->println(codePath);
//    if(topPackageName->lastIndexOf(codePath) > -1) return true;
    if(codePath->lastIndexOf(topPackageName) > -1) return true;
    else{
//      debug->println("below false");
      return false;
    }
  }

  public locked void put(String topPackageName, DeliveryFile df){
    defi = defi->put(topPackageName,df);
  }
}

class TargetCDAList {

  Array targetList;
  int targetListSize;
  String leaveTo;

  new create(){
    StringComparator sc => create();
    targetList => create(256,sc);
    targetListSize = 0;
    leaveTo = null;
    setDefaults();
  }

  public locked void setDefaults(){}

  public locked String leaveToWhom(){
    return leaveTo;
  }

  public locked void setLeaveTo(String s){
    if(s!=null){
      leaveTo = s;
    }
  }

  public locked Array targets(){
    return targetList;
  }

  public locked int targetsSize(){
    return targetListSize;
  }

  public locked String next(int RetryNum){
//    CDAdebug debug=>create(); debug->println("target next");
//    Integer I => breed(targetListSize); debug->println(I->asString());
//    I => breed(RetryNum); debug->println(I->asString());
    if(leaveTo!=null) return null;
    if(RetryNum>=targetListSize){
//      debug->println("RetryNum>=targetListSize");
      return null;
    } else{ String s; s =| targetList->at(RetryNum); return s;}
  }

  public int put(String target){
    return putAt(targetListSize, target);
  }

  public locked int putAt(int at, String target){
    if(target == null) return targetListSize;
    if(at>=targetListSize) {
      targetList = targetList->putAt(targetListSize,target);
      targetListSize = targetListSize+1;
    } else if(at>=0){
      targetList = targetList->putAt(at,target);
    }
    return targetListSize;
    /* else targetList = targetList->putAt(0,target); */
  }

  public locked void remove(String target){
    if(target != null){
      int ind = targetList->indexOf(target);
      if(ind>-1){
        for(int i=ind; i< targetListSize-1; i++){
          String s;
          s =| targetList->at(i+1);
          targetList = targetList->putAt(i,s);
        }
        targetList = targetList->putAt(targetListSize-1,null);
        targetListSize = targetListSize-1;
      }
    }
  }

}

class MillorTarget{/* millorServer/ClientCDAGOL -- (topPackageName -- time) */

  Dictionary GOLtoTimes;
  bool isClient;

  new create(bool isC){
    StringComparator sc => create();
    GOLtoTimes => create(sc);
    isClient = isC;
    setDefaults();
  }

  public locked void setDefaults(){}

  public locked bool isClient(){ return isClient; }

  public locked void add(String millorCDAGOL){
    if(millorCDAGOL != null){
      StringComparator sc => create();
      Dictionary times => create(sc);
      GOLtoTimes = GOLtoTimes->put(millorCDAGOL,times);
    }
  }

  public locked void addTopPackageName(String GOL, String Name){
    if( (GOL != null) && (Name != null) ){
      Dictionary times; times =| GOLtoTimes->get(GOL);
      Long L => breed(-1);
      if(times != null){
        times = times->put(Name,L);
        GOLtoTimes = GOLtoTimes->put(GOL,times);
     }
    }
  }

  public locked void removeTopPackageName(String GOL, String Name){
    if( (GOL != null) && (Name != null) ){
      Dictionary times; times =| GOLtoTimes->get(GOL);
      Long L => breed(-1);
      if(times != null){
        times = times->remove(Name);
        GOLtoTimes = GOLtoTimes->put(GOL,times);
      }
    }
  }

  public locked void setTime(String GOL, String Name, long time){
    Dictionary times; times =| GOLtoTimes->get(GOL);
    Long L => breed(time);
    times = times->put(Name,L);
    GOLtoTimes = GOLtoTimes->put(GOL,times);
  }

  public locked void versionupTopPackage(String GOL, String Name, long time){
    Dictionary times; times =| GOLtoTimes->get(GOL);
    Long L => breed(time);
    times = times->put(Name,L);
    GOLtoTimes = GOLtoTimes->put(GOL,times);
  }

  public locked Dictionary get(String GOL){
    Dictionary times; times =| GOLtoTimes->get(GOL); 
    return times;
  }

  public locked Set getTargetGOLs(){
    return GOLtoTimes->keys();
  }

}