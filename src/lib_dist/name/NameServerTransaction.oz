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

cell NameServerTransaction :* Transaction {

  //このオブジェクトが1対1で管理するNameServerTransactionResourceオブジェクト
  NameServerTransactionResource nstr;
  String nstrGOL;

  //システムマップを管理するSystemMapTransactionResourceオブジェクト
  SystemMapTransactionResource smtr;
  String smtrGOL;

  // self GOL
  String selfGOL;

  protected void initialize() {
    d=>create(); x=0;
    System system=>create(); Array args=>create(16);
    args = system->getArguments();
    selfGOL =| args->at(0);
    d->setP(selfGOL);
    super->initialize(selfGOL);
    nstrGOL =| args->at(1);
    nstr => bind(nstrGOL);
    smtrGOL =| args->at(2);
    smtr => bind(smtrGOL);
  }

  protected void go(){}

  protected void quiet(){flushCell();}

  public void setNameServerTransactionResource(String s) {
    nstrGOL => breed(s);
    nstr =>bind(nstrGOL);
  }

  public void setSystemMapTransactionResource(String s) {
    smtrGOL => breed(s);
    smtr =>bind(smtrGOL);
  }

  // Systemへの内部状態の一部を表示
  public void debugPrint(){ nstr->debugPrint(); }

/*ブランチ*/

  //pathで指定されたディレクトリ階層以下の管理を
  //toGOL(NameServerTransactionResourceセルGOL)で示されたネームサーバに
  //移転する。そのディレクトリ階層のトップはブランチになる。
  //pathは本ネームサーバの管理名称空間内でなければいけない
  //[path:] 移転ブランチのパス名
  //[toGOL:] 移動先のNameServerTransactionResourceセルのGOL
  //例外NameServiceSystemMapException toGOLで示されたネームサーバが存在せず
  // 例外NameServerOwnerMapException pathが管理名称空間外
  // 例外PathStringIllegularException pathに文法的誤り
  public void moveBranch( Path path, String toGOL) {
//    System debug => create();
//    debug -> println("moveBranch1");
    begin();
    Array res => create(3);
    res->putAt(0,smtrGOL); res->putAt(1,nstrGOL); res->putAt(2,toGOL);
//    debug -> println("moveBranch2");
    lock(res);
    if(!(smtr->containServer(toGOL))){
//      debug -> println("moveBranch4");
      NameServiceSystemMapException e =>init(); throw e;
    }
//    debug -> println("moveBranch3");
    nstr->replaceBranch(path,toGOL);
//    debug -> println("moveBranch5");
    smtr->replaceBranch(path,toGOL);
    commit();
//    debug -> println("moveBranch6");
  }

  // ディレクトリdirを、ルートパスpathのブランチとして
  // 本ネームサーバに登録する。
  //[path:] パス名
  //[dir:] ディレクトリ
  //例外NameServerOwnerMapException pathがルートパスではない
  // 例外PathStringIllegularException pathに文法的誤り
  public void putDirectoryAsBranch(Path path, NameDirectory dir){
    begin();
    Array res => create(2);
    res->putAt(0,"smtr"); res->putAt(1,nstrGOL);
    lock(res);
//    SystemMapTransactionResource smtr => bind("smtr");
    try{
      nstr->putDirectoryAsBranch(path,dir);
      smtr->putBranch(path,nstrGOL);
    }catch(NameServerOwnerMapException e){ throw e; }
    commit();
  }

  // ルートパスpathの新しいディレクトリを生成し、ブランチとして
  // 本ネームサーバに登録する。
  //[path:] パス名
  //[dir:] ディレクトリ
  // 例外NameServerOwnerMapException pathがルートパスではない
  // 例外PathStringIllegularException pathに文法的誤り
  public void putDirectoryAsBranch(Path path){
    begin();
    Array res => create(2);
    res->putAt(0,smtrGOL); res->putAt(1,nstrGOL);
    lock(res);
//    SystemMapTransactionResource smtr => bind("smtr");
    try{
      nstr->putDirectoryAsBranch(path);
      smtr->putBranch(path,nstrGOL);
    }catch(NameServerOwnerMapException e){ throw e; }
    commit();
  }

  // ブランチであるpathの親パスが本ネームサーバの管理下にある時に
  // pathで示されたディレクトリをブランチでなくす。
  //[path:] パス名
  // 例外 NameServerOwnerMapException pathかその親パスが管理外
  //   またはpathで示されたディレクトリがブランチではない
  public void unBranched(Path path){
//    System debug => create();
    begin();
    Array res => create(2);
    res->putAt(0,smtrGOL); res->putAt(1,nstrGOL);
    lock(res);
//    debug->println("zzz");
    try{
      nstr->unBranched(path);
      smtr->unBranched(path);
    }catch(NameServerOwnerMapException e){ throw e; }
    commit();
  }

  // パスpathを管理するネームサーバ(NameServerTransactionResourceセル)の
  // GOLを返す。
  // 例外 NameServiceSystemMapException pathが名称空間逸脱かマッピングされているパス
  public String OwnerNSTR(Path path){
    begin();
    Array res => create(1);
    res->putAt(0,smtrGOL);
    lock(res);
    SystemMapValue smv = smtr->FindOwner(path);
    if(smv->ismapping()){
      NameServiceSystemMapException e => init(); throw e; }
    String ownerGOL = smv->nameserverGOL();
    commit();
    return ownerGOL;
  }

/*ネームサーバ管理*/

  // 本ネームサーバをネームサービスに登録する
  public void addNameServer(){
    begin();
    Array res => create(2);
    res->putAt(0,smtrGOL); res->putAt(1,nstrGOL);
    lock(res);
    smtr->AddNameServer(nstrGOL);
    commit();
  }

  // 本ネームサーバをネームサービスから削除する
  public void removeNameServer(){
    begin();
    Array res => create(2);
    res->putAt(0,smtrGOL); res->putAt(1,nstrGOL);
    lock(res);
    smtr->RemoveNameServer(nstrGOL);
    commit();
  }

/*マッピンング*/

  // serverNSTGOLは他ネームサービスに属するNameServerTransactionセルGOL。
  // pathに、そのネームサービスの名称空間のパスtoをマッピングする。
  // [path:]マッピング元パス名
  // [to:]マッピング先パス名
  // [serverNSTGOL:]他ネームサービスに属するNameServerTransactionセルGOL
  // 例外 NameServiceSystemMapException mapping fail
  public void putDirectoryAsMapping(Path path, Path to, String serverNSTGOL){
//    System debug => create();
    begin();
    Array res => create(2);
    res->putAt(0,smtrGOL); res->putAt(1,nstrGOL); lock(res);
    try{
      nstr->putBranchInOtherCell(path);
    }catch(NameServerOwnerMapException e) {
//      res->putAt(0,smtrGOL); lock(res);
      try{
	SystemMapValue smv = smtr->FindOwner(path);
        String ownerGOL = smv->nameserverGOL();
        path = smv->tranpath();
	res->putAt(1,ownerGOL); lock(res);
	NameServerTransactionResource owner => bind(ownerGOL);
	owner->putBranchInOtherCell(path);
      }catch(NameServiceSystemMapException ee){ throw ee;
      }catch(NameServerOwnerMapException ee) {
        NameServiceSystemMapException eee => init(); throw eee;
      }
    }
//    debug->println("putDirectoryAsMapping 1");
    smtr->addMapping(path, to, serverNSTGOL);
    commit();
  }

/*ディレクトリの名称管理 というよりエントリ管理*/

  // オブジェクトentをパスpathでエントリとして登録する。
  // [path:]パス名  [ent:]オブジェクト
  // 例外 NameServiceSystemMapException pathが名称空間逸脱
  // 例外PathStringIllegularException pathに文法的誤り
  public void putEntry(Path path, Root ent){
    begin();
    Array res => create(1);
    res->putAt(0,nstrGOL); lock(res);
    try{
//      System debug => create();
      nstr->putEntry(path,ent);
//      debug->println("putEntry a");
      commit();
//      debug->println("putEntry b");
    }catch(NameServerOwnerMapException e) {
//      Array res2 => create(2);
//      res2->putAt(0,nstrGOL); res2->putAt(1,smtrGOL); lock(res2);
      res->putAt(0,smtrGOL); lock(res);
      try{
	SystemMapValue smv = smtr->FindOwner(path);
        String ownerGOL = smv->nameserverGOL();
        path = smv->tranpath();
        if(smv->ismapping()){
          NameServerTransaction owner => bind(ownerGOL);
  	  owner->putEntry(path,ent);
        } else{
	  res->putAt(0,ownerGOL); lock(res);
  	  NameServerTransactionResource owner => bind(ownerGOL);
  	  owner->putEntry(path,ent);
        }
      }catch(NameServiceSystemMapException ee){ throw ee;
      }catch(NameServerOwnerMapException ee) {
        NameServiceSystemMapException eee => init(); throw eee;
      }
      commit();
    }
  }

  // pathがエントリとして名称空間に含まれるか調べる。
  // [path:]パス名
  // 返値 含まれるとtrue、含まれていないとfalse
  // 例外 NameServiceSystemMapException pathが名称空間逸脱
  // 例外PathStringIllegularException pathに文法的誤り
  public bool containEntry(Path path){
    bool tf;
    begin();
    Array res => create(1);
    res->putAt(0,nstrGOL); lock(res);
    try{
      tf = nstr->containEntry(path);
    }catch(NameServerOwnerMapException e) {
      res->putAt(0,smtrGOL); lock(res);
      try{
	SystemMapValue smv = smtr->FindOwner(path);
        String ownerGOL = smv->nameserverGOL();
        path = smv->tranpath();
        if(smv->ismapping()){
          NameServerTransaction owner => bind(ownerGOL);
	  tf = owner->containEntry(path);
        } else{
  	  res->putAt(0,ownerGOL); lock(res);
  	  NameServerTransactionResource owner => bind(ownerGOL);
	  tf = owner->containEntry(path);
        }
      }catch(NameServiceSystemMapException ee){ throw ee;
      }catch(NameServerOwnerMapException ee) {
        NameServiceSystemMapException eee => init(); throw eee;
      }
    }
    commit();
    return tf;
  }

  // pathで指定されたオブジェクトを検索し、返す。
  // [path:]パス名
  // 返値 オブジェクト
  // 例外 NameServiceSystemMapException pathが名称空間逸脱
  // 例外PathStringIllegularException pathに文法的誤り
  public Root getEntry(Path path){
    Root obj;
    begin();
    Array res => create(1);
    res->putAt(0,nstrGOL); lock(res);
    try{
      obj = nstr->getEntry(path);
    }catch(NameServerOwnerMapException e) {
      res->putAt(0,smtrGOL); lock(res);
      try{
	SystemMapValue smv = smtr->FindOwner(path);
        String ownerGOL = smv->nameserverGOL();
        path = smv->tranpath();
        if(smv->ismapping()){
          NameServerTransaction owner => bind(ownerGOL);
	  obj = owner->getEntry(path);
        } else{
	  res->putAt(0,ownerGOL); lock(res);
	  NameServerTransactionResource owner => bind(ownerGOL);
	  obj = owner->getEntry(path);
        }
      }catch(NameServiceSystemMapException ee){ throw ee;
      }catch(NameServerOwnerMapException ee) {
        NameServiceSystemMapException eee => init(); throw eee;
      }
    }
    commit();
    return obj;
  }

  // pathで指定されたオブジェクトの登録を抹消する。
  // [path:]パス名
  // 返値 削除したオブジェクト
  // 例外 NameServiceSystemMapException pathが名称空間逸脱
  // 例外PathStringIllegularException pathに文法的誤り
  public Root removeEntry(Path path){
//    System debug => create();
    Root obj;
    begin();
    Array res => create(1);
    res->putAt(0,nstrGOL); lock(res);
//    debug->println("DW 1");
    try{
      obj = nstr->removeEntry(path);
    }catch(NameServerOwnerMapException e) {
//      debug->println("DW 2");
      res->putAt(0,smtrGOL); lock(res);
      try{
	SystemMapValue smv = smtr->FindOwner(path);
//        debug->println("DW 3");
        String ownerGOL = smv->nameserverGOL();
        path = smv->tranpath();
        if(smv->ismapping()){
//          debug->println("DW 4");
          NameServerTransaction owner => bind(ownerGOL);
	  obj = owner->removeEntry(path);
        } else{
//          debug->println("DW 5");
	  res->putAt(0,ownerGOL); lock(res);
	  NameServerTransactionResource owner => bind(ownerGOL);
	  obj = owner->removeEntry(path);
        }
      }catch(NameServiceSystemMapException ee){ throw ee;
      }catch(NameServerOwnerMapException ee) {
        NameServiceSystemMapException eee => init(); throw eee;
      }
    }
    commit();
    return obj;
  }

  // sourceで指定されたオブジェクトのパスをtargetにリネームする。
  // sourceの親パスとtargetの親パスは同一でなければならない。
  // [source:]ソースパス名
  // [target:]ターゲットパス名
  // 返り値 オブジェクト
  // 例外 NameServiceSystemMapException sourceかtargetが名称空間逸脱
  // 例外PathStringIllegularException sourceかtargetに文法的誤り
  //      またはsourceの親パスとtargetの親パスが同一でない
  public Root renameEntry(Path source, Path target){
    Root obj;
    begin();
    Array res => create(1);
    res->putAt(0,nstrGOL); lock(res);
    try{
      obj = nstr->renameEntry(source,target);
    }catch(NameServerOwnerMapException e) {
      res->putAt(0,smtrGOL); lock(res);
      try{
	SystemMapValue smv = smtr->FindOwner(source);
        String ownerGOL = smv->nameserverGOL();
        source = smv->tranpath();
	smv = smtr->FindOwner(target);
        target = smv->tranpath();
        if(smv->ismapping()){
          NameServerTransaction owner => bind(ownerGOL);
	  obj = owner->renameEntry(source,target);
        } else{
	  res->putAt(0,ownerGOL); lock(res);
	  NameServerTransactionResource owner => bind(ownerGOL);
	  obj = owner->renameEntry(source,target);
        }
      }catch(NameServiceSystemMapException ee){ throw ee;
      }catch(NameServerOwnerMapException ee) {
        NameServiceSystemMapException eee => init(); throw eee;
      }
    }
    commit();
    return obj;
  }

  // pathで示されたディレクトリの登録エントリ数を求める。
  // [path:]パス名
  // 返値 登録エントリ数
  // 例外 NameServiceSystemMapException pathが名称空間逸脱
  // 例外PathStringIllegularException pathに文法的誤り
  public int EntrySize(Path path){
    int size;
    begin();
    Array res => create(1);
    res->putAt(0,nstrGOL); lock(res);
    try{
      size = nstr->EntrySize(path);
    }catch(NameServerOwnerMapException e) {
      res->putAt(0,smtrGOL); lock(res);
      try{
	SystemMapValue smv = smtr->FindOwner(path);
        String ownerGOL = smv->nameserverGOL();
        path = smv->tranpath();
        if(smv->ismapping()){
          NameServerTransaction owner => bind(ownerGOL);
	  size = owner->EntrySize(path);
        } else{
	  res->putAt(0,ownerGOL); lock(res);
	  NameServerTransactionResource owner => bind(ownerGOL);
	  size = owner->EntrySize(path);
        }
      }catch(NameServiceSystemMapException ee){ throw ee;
      }catch(NameServerOwnerMapException ee) {
        NameServiceSystemMapException eee => init(); throw eee;
      }
    }
    commit();
    return size;
  }

  // pathで示されたディレクトリにエントリとして登録されている
  // オブジェクトの集合をSetとして返す。
  // [path:]パス名
  // 返値 オブジェクトのSet
  // 例外 NameServiceSystemMapException pathが名称空間逸脱
  // 例外PathStringIllegularException pathに文法的誤り
  public Set EntrySet(Path path){
    Set entries;
    begin();
    Array res => create(1);
    res->putAt(0,nstrGOL); lock(res);
    try{
      entries = nstr->EntrySet(path);
    }catch(NameServerOwnerMapException e) {
      res->putAt(0,smtrGOL); lock(res);
      try{
	SystemMapValue smv = smtr->FindOwner(path);
        String ownerGOL = smv->nameserverGOL();
        path = smv->tranpath();
        if(smv->ismapping()){
          NameServerTransaction owner => bind(ownerGOL);
	  entries = owner->EntrySet(path);
        } else{
	  res->putAt(0,ownerGOL); lock(res);
	  NameServerTransactionResource owner => bind(ownerGOL);
	  entries = owner->EntrySet(path);
        }
      }catch(NameServiceSystemMapException ee){ throw ee;
      }catch(NameServerOwnerMapException ee) {
        NameServiceSystemMapException eee => init(); throw eee;
      }
    }
    commit();
    return entries;
  }

/*サブディレクトリの名称管理*/

  // ディレクトリsubdirをpathで示されたディレクトリにサブディレクトリ
  // として追加する。
  // [path:]パス名 [subdir:]追加するディレクトリ
  // 例外 NameServiceSystemMapException pathが名称空間逸脱
  // 例外PathStringIllegularException pathに文法的誤り
  public void putDirectory(Path path, NameDirectory subdir){
//    System debug => create();
//    debug->println("putDirectory 0");
    begin();
    Array res => create(1);
    res->putAt(0,nstrGOL); lock(res);
//    debug->println("putDirectory 1");
    try{
      nstr->putDirectory(path,subdir);
//      debug->println("putDirectory 2");
    }catch(NameServerOwnerMapException e) {
//      debug->println("putDirectory 3");
      res->putAt(0,smtrGOL); lock(res);
//      debug->println("putDirectory 4");
      try{
	SystemMapValue smv = smtr->FindOwner(path);
        String ownerGOL = smv->nameserverGOL();
        path = smv->tranpath();
        if(smv->ismapping()){
          NameServerTransaction owner => bind(ownerGOL);
	  owner->putDirectory(path,subdir);
        } else{
	  res->putAt(0,ownerGOL); lock(res);
	  NameServerTransactionResource owner => bind(ownerGOL);
	  owner->putDirectory(path,subdir);
        }
      }catch(NameServiceSystemMapException ee){ throw ee;
      }catch(NameServerOwnerMapException ee) {
        NameServiceSystemMapException eee => init(); throw eee;
      }
    }
    commit();
  }

  // 新規サブディレクトリをpathで示されたディレクトリに追加する。
  // [path:]パス名 [subdir:]追加するサブディレクトリ
  // 例外 NameServiceSystemMapException pathが名称空間逸脱
  // 例外PathStringIllegularException pathに文法的誤り
  public void putDirectory(Path path){
//    System debug => create();
//    debug->println("putDirectory 0");
    begin();
    Array res => create(1);
    res->putAt(0,nstrGOL); lock(res);
//    debug->println("putDirectory 1");
    try{
      nstr->putDirectory(path);
//      debug->println("putDirectory 2");
    }catch(NameServerOwnerMapException e) {
//      debug->println("putDirectory 3");
      res->putAt(0,smtrGOL); lock(res);
//      debug->println("putDirectory 4");
      try{
	SystemMapValue smv = smtr->FindOwner(path);
//        debug->println("putDirectory 4.1");
        String ownerGOL = smv->nameserverGOL();
//        debug->println(ownerGOL);
        path = smv->tranpath();
        if(smv->ismapping()){
          NameServerTransaction owner => bind(ownerGOL);
	  owner->putDirectory(path);
        } else{
//          debug->println(path->asString());
//          debug->println("putDirectory 5");
	  res->putAt(0,ownerGOL); lock(res);
//          debug->println("putDirectory 6");
	  NameServerTransactionResource owner => bind(ownerGOL);
	  owner->putDirectory(path);
//          debug->println("putDirectory 7");
        }
      }catch(NameServiceSystemMapException ee){ throw ee;
      }catch(NameServerOwnerMapException ee) {
        NameServiceSystemMapException eee => init(); throw eee;
      }
    }
    commit();
  }

  //pathがディレクトリとして名称空間に含まれるか調べる。
  //[path:]パス名
  //返値 含まれるとtrue、含まれていないとfalse
  // 例外 NameServiceSystemMapException pathが名称空間逸脱
  // 例外PathStringIllegularException pathに文法的誤り
  public bool containDirectory(Path path){
    bool tf;
    begin();
    Array res => create(1);
    res->putAt(0,nstrGOL); lock(res);
/*
    try{
      tf = nstr->containDirectory(path);
    }catch(NameServerOwnerMapException e) {
*/
    tf = nstr->containDirectory(path);
    if(!tf){
      res->putAt(0,smtrGOL); lock(res);
      try{
	SystemMapValue smv = smtr->FindOwner(path);
        String ownerGOL = smv->nameserverGOL();
        path = smv->tranpath();
        if(smv->ismapping()){
          NameServerTransaction owner => bind(ownerGOL);
	  tf = owner->containDirectory(path);
        } else{
  	  res->putAt(0,ownerGOL); lock(res);
	  NameServerTransactionResource owner => bind(ownerGOL);
	  tf = owner->containDirectory(path);
        }
/*
      }catch(NameServiceSystemMapException ee){ throw ee;
      }catch(NameServerOwnerMapException ee) {
        NameServiceSystemMapException eee => init(); throw eee;
      }
*/
      }catch(NameServiceSystemMapException ee){ tf = false;
      }catch(NameServerOwnerMapException ee) { tf = false;
      }
    }
    commit();
    return tf;
  }

  // pathで指定されたディレクトリを検索し、返す。
  //[path:]サブディレクトリ名
  //返値 サブディレクトリ
  // 例外 NameServiceSystemMapException pathが名称空間逸脱
  // 例外PathStringIllegularException pathに文法的誤り
  public NameDirectory getDirectory(Path path){
    NameDirectory nd;
    begin();
    Array res => create(1);
    res->putAt(0,nstrGOL); lock(res);
    try{
      nd = nstr->getDirectory(path);
    }catch(NameServerOwnerMapException e) {
      res->putAt(0,smtrGOL); lock(res);
      try{
	SystemMapValue smv = smtr->FindOwner(path);
        String ownerGOL = smv->nameserverGOL();
        path = smv->tranpath();
        if(smv->ismapping()){
          NameServerTransaction owner => bind(ownerGOL);
	  nd = owner->getDirectory(path);
        } else{
	  res->putAt(0,ownerGOL); lock(res);
	  NameServerTransactionResource owner => bind(ownerGOL);
	  nd = owner->getDirectory(path);
        }
      }catch(NameServiceSystemMapException ee){ throw ee;
      }catch(NameServerOwnerMapException ee) {
        NameServiceSystemMapException eee => init(); throw eee;
      }
    }
    commit();
    return nd;
  }

  // pathで指定されたディレクトリを削除する。
  // ディレクトリは空ディレクトリでなければならない。
  // ディレクトリはブランチであってはいけない。
  //[path:]サブディレクトリ名
  //返値 削除したディレクトリ
  // 例外 NameServiceSystemMapException pathが名称空間逸脱
  // 例外 PathStringIllegularException pathに文法的誤り
  // 例外 NameDirectoryNotEmptyException ディレクトリが空でない
  // 例外 NameDirectoryBranchException ディレクトリがブランチである
  public NameDirectory removeDirectory(Path path){
    NameDirectory nd;
    begin();
    Array res => create(1);
    res->putAt(0,nstrGOL); lock(res);
    try{
      nd = nstr->removeDirectory(path);
    }catch(NameServerOwnerMapException e) {
      res->putAt(0,smtrGOL); lock(res);
      try{
	SystemMapValue smv = smtr->FindOwner(path);
        String ownerGOL = smv->nameserverGOL();
        path = smv->tranpath();
        if(smv->ismapping()){
          NameServerTransaction owner => bind(ownerGOL);
	  nd = owner->removeDirectory(path);
        } else{
	  res->putAt(0,ownerGOL); lock(res);
	  NameServerTransactionResource owner => bind(ownerGOL);
	  nd = owner->removeDirectory(path);
        }
      }catch(NameServiceSystemMapException ee){ throw ee;
      }catch(NameServerOwnerMapException ee) {
        NameServiceSystemMapException eee => init(); throw eee;
      }
    }
    commit();
    return nd;
  }

  // ディレクトリのパスをsourceからtargetに変える。
  // ディレクトリは空ディレクトリでなければならない。
  // ディレクトリはブランチであってはいけない。
  //[path:]サブディレクトリ名
  //返値 リネームしたディレクトリ
  // 例外 NameServiceSystemMapException pathが名称空間逸脱
  // 例外 PathStringIllegularException pathに文法的誤り
  // 例外 NameDirectoryNotEmptyException ディレクトリが空でない
  // 例外 NameDirectoryBranchException ディレクトリがブランチである
  public NameDirectory renameDirectory(Path source,Path target){
    NameDirectory nd;
    begin();
    Array res => create(1);
    res->putAt(0,nstrGOL); lock(res);
    try{
      nd = nstr->renameDirectory(source,target);
    }catch(NameServerOwnerMapException e) {
      res->putAt(0,smtrGOL); lock(res);
      try{
	SystemMapValue smv = smtr->FindOwner(source);
        String ownerGOL = smv->nameserverGOL();
        source = smv->tranpath();
        smv = smtr->FindOwner(target);
        target = smv->tranpath();
        if(smv->ismapping()){
          NameServerTransaction owner => bind(ownerGOL);
	  nd = owner->renameDirectory(source,target);
        } else{
	  res->putAt(0,ownerGOL); lock(res);
	  NameServerTransactionResource owner => bind(ownerGOL);
	  nd = owner->renameDirectory(source,target);
        }
      }catch(NameServiceSystemMapException ee){ throw ee;
      }catch(NameServerOwnerMapException ee) {
        NameServiceSystemMapException eee => init(); throw eee;
      }
    }
    commit();
    return nd;
  }

  // pathで示されたディレクトリの登録サブディレクトリ数を求める。
  // [path:]パス名
  //返値 サブディレクトリの数
  // 例外 NameServiceSystemMapException pathが名称空間逸脱
  // 例外PathStringIllegularException pathに文法的誤り
  public int DirectorySize(Path path){
    int size;
    begin();
    Array res => create(1);
    res->putAt(0,nstrGOL); lock(res);
    try{
      size = nstr->DirectorySize(path);
    }catch(NameServerOwnerMapException e) {
      res->putAt(0,smtrGOL); lock(res);
      try{
	SystemMapValue smv = smtr->FindOwner(path);
        String ownerGOL = smv->nameserverGOL();
        path = smv->tranpath();
        if(smv->ismapping()){
          NameServerTransaction owner => bind(ownerGOL);
	  size = owner->DirectorySize(path);
        } else{
	  res->putAt(0,ownerGOL); lock(res);
	  NameServerTransactionResource owner => bind(ownerGOL);
	  size = owner->DirectorySize(path);
        }
      }catch(NameServiceSystemMapException ee){ throw ee;
      }catch(NameServerOwnerMapException ee) {
        NameServiceSystemMapException eee => init(); throw eee;
      }
    }
    commit();
    return size;
  }

  // pathで示されたディレクトリに登録されているディレクトリの
  // 集合をSetとして返す。
  // [path:]パス名
  //返値 ディレクトリのSet
  // 例外 NameServiceSystemMapException pathが名称空間逸脱
  // 例外PathStringIllegularException pathに文法的誤り
  public Set DirectorySet(Path path){
    Set dirs;
    begin();
    Array res => create(1);
    res->putAt(0,nstrGOL); lock(res);
    try{
      dirs = nstr->DirectorySet(path);
    }catch(NameServerOwnerMapException e) {
      res->putAt(0,smtrGOL); lock(res);
      try{
	SystemMapValue smv = smtr->FindOwner(path);
        String ownerGOL = smv->nameserverGOL();
        path = smv->tranpath();
        if(smv->ismapping()){
          NameServerTransaction owner => bind(ownerGOL);
	  dirs = owner->DirectorySet(path);
        } else{
	  res->putAt(0,ownerGOL); lock(res);
	  NameServerTransactionResource owner => bind(ownerGOL);
	  dirs = owner->DirectorySet(path);
        }
      }catch(NameServiceSystemMapException ee){ throw ee;
      }catch(NameServerOwnerMapException ee) {
        NameServiceSystemMapException eee => init(); throw eee;
      }
    }
    commit();
    return dirs;
  }

}  
