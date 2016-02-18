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

cell SystemMapTransactionResource :* TransactionResource {

  //パス名デリミタ
  // コンストラクション以降不変(トランザクション管理不用)
  String delimitor;

  //そのネームサービスのドメイン名
  String domainname;

  //故障中のネームサーバ(NameServerTransactionResourceのGOL)のリスト
  TroubleNameServers troubleList;

  //故障中のネームサーバが復旧したかどうかポーリングで確かめるスレッド
  PollingRunnable polling;

  NameResource nr;

  protected void initialize() {
    d=>create(); x=0;
    System system=>create(); Array args=>create(16);
    args = system->getArguments();
    String selfGOL; selfGOL =| args->at(0);
    d->setP(selfGOL);
    super->initialize("tmp0_smtr","tmp1_smtr","tmp2_smtr",selfGOL);
    domainname => breed("");
//    delimitor => breed(":");
    delimitor =| args->at(1);
    troubleList => create();
    polling => create(troubleList);
    Thread tMil => create(polling);
    createResource();
  }

  protected void go(){}

  protected void quiet(){flushCell();}

  protected void createResource(){
   nr=>create(); r=>create(nr);
  }

  public void troubleControlPollingStart(){ 
    polling->pollingStart();
  }

  public void setDomainName(String s){
    domainname => breed(s);
  }

  public void setDelimitor(String s){
    delimitor => breed(s);
  }

  public void debugPrint(){
    System system => create();
    PrintWriter pw = system->getStdout();
    pw->println("NameService ------");
    Set servers; servers =| nr->getServers();
    Iterator it = servers->iterator();
    pw->println("  serverGOL");
    while(!(it->atEnd())){
      String serverGOL; serverGOL =| it->nextElement();
      pw->print("    "); pw->println(serverGOL);
    }
    Dictionary systemmap; systemmap =| nr->getSystemmap();
    Iterator keyit = systemmap->keyIterator();
    Iterator valit = systemmap->iterator();
    pw->println("  systemmap");
    while(!(keyit->atEnd())){
      String pathname; SystemMapValue smv;
      pathname =| keyit->nextElement();
      smv =| valit->nextElement();
      pw->print("    "); pw->print(pathname);
      smv->debugPrint(pw); pw->println("");
    }
    pw->println("------");
    pw->flush();
  }

/*ネームサーバ管理*/

  //ネームサーバを登録する。
  //新生成NameServerTransactionResourceオブジェクトGOLのserversへの登録
  //[serverGOL:]登録するネームサーバのGOL
  public void AddNameServer(String serverGOL){

    //serversへの登録
    Set servers = nr->getServers();
    servers -> add(serverGOL);
    nr->setServers(servers);

    //登録serverが持っているブランチの登録
    NameServerTransactionResource nstr => bind(serverGOL);
    Set branchpathes = nstr -> getBranches();
    Iterator it = branchpathes->iterator();
    Dictionary systemmap = nr->getSystemmap();
    SystemMapValue smv => create(serverGOL);
    while(!it->atEnd()){
      Path p;
      p =| it->nextElement();
      systemmap = systemmap->put(p->asString(),smv);
    }
    nr->setSystemmap(systemmap);
  }

  public bool containServer(String serverGOL){
    Set servers = nr->getServers();
    return( servers->contains(serverGOL) );
  }

  //ネームサーバを削除する。
  //NameServerTransactionResourceオブジェクトGOLのserversからの削除
  //[server:]登録するネームサーバ
  public void RemoveNameServer(String serverGOL){

    //serversからの削除
    Set servers = nr->getServers();
    servers -> remove(serverGOL);
    nr->setServers(servers);

    //削除serverが持っているブランチの削除
    Dictionary systemmap = nr->getSystemmap();
    Iterator it = systemmap -> assocIterator();
    while(!it->atEnd()){
      Association a;
      SystemMapValue smv;
      String s;
      a =| it->nextElement();
      smv =| a->value();
      s = smv->nameserverGOL();
      if(s->equals(serverGOL)){
	systemmap = systemmap -> remove(a->key());
      }
    }
    nr->setSystemmap(systemmap);
  }

/*マッピング*/

  // serverGOLは他ネームサービスに属するNameServerTransactionセルGOL。
  // pathに、そのネームサービスの名称空間のパスtoをマッピングする。
  // [path:]マッピング元パス名
  // [to:]マッピング先パス名
  // [serverNSTGOL:]他ネームサービスに属するNameServerTransactionセルGOL
  public void addMapping(Path path, Path to, String serverNSTGOL){
    //serversへの登録
//    Set servers = nr->getServers();
//    servers -> add(serverGOL);
//    nr->setServers(servers);
    //pathをブランチとして登録
    Dictionary systemmap = nr->getSystemmap();
    SystemMapValue smv => create(serverNSTGOL,to,true);
    systemmap = systemmap->put(path->asString(),smv);
    nr->setSystemmap(systemmap);
    return;
  }

/*故障管理*/

  //ネームサーバが故障したのでシステムマップから除外し、
  //復旧待ちリストに入れる。
  //[serverNSTGOL:]故障したネームサーバのNameServerTransactionResourceセルのGOL
  public void troubleWith(String serverNSTRGOL){
    if(serverNSTRGOL!=null){
      troubleList->add(serverNSTRGOL);
      RemoveNameServer(serverNSTRGOL);
    }
  }

  //ネームサーバが故障から回復したのでシステムマップに入れ、
  //復旧待ちリストから外す。
  //[serverNSTGOL:]回復したネームサーバのNameServerTransactionResourceセルのGOL
  public void restored(String serverNSTRGOL){
    bool tf = troubleList->contains(serverNSTRGOL);
    if(tf){
      troubleList->remove(serverNSTRGOL);
      AddNameServer(serverNSTRGOL);
    }
  }

/*処理の委譲*/

  //システムマップを検索し、pathを管理するネームサーバのGOLを含む
  //SystemMapValueオブジェクトを返す。
  //pathがマッピングされている場合はNameServerTransactionセルGOLになる。
  //[path:]パス名
  //返り値 SystemMapValue : (ネームサーバのGOL,mappingpath)
  //呼び出し元のネームサーバへの逆アクセスはない
  public SystemMapValue FindOwner(Path path){
//    System debug => create();
    Dictionary systemmap = nr->getSystemmap();
    Path p => breed(path->asString());
    Path emp => breed("");
    Root obj;
//    debug->println("FindOwner 1");
    obj = systemmap->get(p->asString());
    while( obj == null){
//      debug->println(p->asString());
      p = p->UpperPath(delimitor);
//      debug->println(p->asString());
      if(p->isEmpty()){
//        debug->println("empty");
	NameServiceSystemMapException e => init();
	throw e;
      }
      obj = systemmap->get(p->asString());
//      debug->println(" loop end");
    }
//    debug->println("loop break");
    SystemMapValue smv; smv =| obj;
    String nameserverGOL = smv->nameserverGOL();
//    debug->println(nameserverGOL);
    Path tranpath = smv->tranpath();
//    debug->println(tranpath->asString());
    if(tranpath->isEmpty()) smv => create(nameserverGOL,path,false);
    else{
//      debug->println(p->asString());
//      debug->println(tranpath->asString());
//      debug->println(path->asString());
      Path origpath => breed(path->asString());
      Path mappingpath = origpath->translateWith(p,tranpath);
      smv => create(nameserverGOL,mappingpath,true);
    }
    return smv;
  }

/*一貫性維持機能 */
//というよりブランチ管理
//トランザクション機能を使う

  //ブランチがネームサーバ間で移送されたのでシステムマップを変更する
  public void putBranch(Path path, String toGOL){
//    System debug => create();
    Dictionary systemmap = nr->getSystemmap();
//    debug->println("SystemMap putBranch 1");
//    debug->println(path->asString());
    if( systemmap->containsKey(path->asString()) ){
//      debug->println("SystemMap putBranch 2");
      NameServiceSystemMapException e => init();
      throw e;
    } else{
//      debug->println("SystemMap putBranch 3");
      SystemMapValue smv => create(toGOL);
      systemmap = systemmap->put(path->asString(),smv);
    }
//    debug->println("SystemMap putBranch 4");
    nr->setSystemmap(systemmap);
  }

  public void replaceBranch(Path path, String toGOL){
//    System debug => create();
    Dictionary systemmap = nr->getSystemmap();
//    debug->println("SystemMap putBranch 1");
//    debug->println(path->asString());
//    if( systemmap->containsKey(path->asString()) ){
//      debug->println("SystemMap putBranch 3");
    SystemMapValue smv => create(toGOL);
    systemmap = systemmap->put(path->asString(),smv);
//    } else{
//      debug->println("SystemMap putBranch 2");
//      NameServiceSystemMapException e => init();
//      throw e;
//    }
//    debug->println("SystemMap putBranch 4");
    nr->setSystemmap(systemmap);
  }

  // ブランチであるpathの親パスが本ネームサーバの管理下にある時に
  // pathで示されたディレクトリをブランチでなくす。
  //[path:] パス名
  public void unBranched(Path path){
    Dictionary systemmap = nr->getSystemmap();
    systemmap = systemmap->remove(path->asString());
    nr->setSystemmap(systemmap);
  }

}

class TroubleNameServers{

  Dictionary list;

  new create(){
    StringComparator sc => create();
    list => create(sc);
  }

  public locked void add(String serverNSTRGOL){
    Integer Zero => breed(0);
    list = list->put(serverNSTRGOL,Zero);
  }

  public locked void remove(String serverNSTRGOL){
    list = list->remove(serverNSTRGOL);
  }

  public locked void replace(String serverNSTRGOL, Integer pn){
    list = list->remove(serverNSTRGOL);
    list = list->put(serverNSTRGOL,pn);
  }

  public locked bool contains(String serverNSTRGOL){
    return list->contains(serverNSTRGOL);
  }

  public Dictionary get(){
    return list;
  }

}

class PollingRunnable :* Runnable{

  int interval; /*msec*/

  /* 復旧待ちリスト NSTRGOL -- pollingNum */
  TroubleNameServers troubleList; 

  protected condition cond;

  /*この値を越えてポーリングが成されたら復旧待ちリストから除外 */
  int maxPollingNum; 

  new create(TroubleNameServers t){
    interval = 60000; /* default */
    troubleList = t;
    maxPollingNum = 60; /* default */
  }

  protected locked void beforePolling(){ wait(cond); }
  public locked void pollingStart(){ 
    signal(cond);
  }

  public void run(){
    System system=>create();
    System debug=>create();
    beforePolling();
    system->println("trouble control polling start.");
    try{
      bool b = true;
      while(b){
//        debug->println("polling sleep begin");
        Dictionary nowList; Iterator ite; int size;
        sleepThread(interval);
        nowList = troubleList->get();
        ite = nowList->keyIterator();
        size = nowList->size();
        for(int i=0; i<size; i++){
          String troubleNSTRGOL; NameServerTransactionResource troubleNSTR;
          bool tf;
          troubleNSTRGOL =| ite->nextElement();
          troubleNSTR =>bind(troubleNSTRGOL);
          tf=false; tf=troubleNSTR->ping();
          if(tf) troubleList->remove(troubleNSTRGOL);
          else{
            Integer pollingNum;
            pollingNum =| nowList->get(troubleNSTRGOL);
            int pn = pollingNum->intValue();
            if(pn > maxPollingNum)
              troubleList->remove(troubleNSTRGOL);
            else{
              pollingNum => breed(pn + 1);
              troubleList->replace(troubleNSTRGOL,pollingNum);
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
}
