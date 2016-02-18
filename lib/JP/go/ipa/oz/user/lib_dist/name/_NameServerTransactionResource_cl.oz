cell NameServerTransactionResource :* TransactionResource {

  //パス名デリミタ
  // コンストラクション以降不変(トランザクション管理不用)
  String delimitor;

  //self GOL
  String selfGOL;

  NameResource nr;

  // ネームサービスへの登録はこの中では行なわない
  // 備考 パス名デリミタは':'が使用される。
  protected void initialize() {
    d=>create(); x=0; 
    System system=>create(); Array args=>create(16);
    args = system->getArguments();
    selfGOL =| args->at(0);
    String s0 => breed("tmp0_"); s0 = s0->concat(selfGOL);
    String s1 => breed("tmp1_"); s1 = s1->concat(selfGOL);
    String s2 => breed("tmp2_"); s2 = s2->concat(selfGOL);
    d->setP(selfGOL);
    super->initialize(s0,s1,s2,selfGOL);
//    delimitor => breed(":");
    delimitor =| args->at(1);
    createResource();
  }

  protected void go(){}

  protected void quiet(){flushCell();}

  protected void createResource(){
   nr=>create(); r=>create(nr);
  }


//  public void setTransaction(NameServerTransaction anst) {
//    nst = anst;
//  }

  public bool ping() { return true; }

  public void setDelimitor(String s){
    delimitor => breed(s);
  }

  // System に内部構造の一部を出力
  public void debugPrint(){
    System system => create();
    PrintWriter pw = system->getStdout();
    pw->print("NameServer ------ "); pw->println(selfGOL);
    Dictionary ownermap; ownermap =| nr->getOwnerMap();
    Iterator it = ownermap->keyIterator();
    pw->println("  ownermap");
    while(!(it->atEnd())){
      String pathname;
      pathname =| it->nextElement();
      pw->print("    "); pw->println(pathname);
    }
    Dictionary branches; branches =| nr->getBranches();
    it = branches->keyIterator();
    pw->println("  branches");
    while(!(it->atEnd())){
      String pathname;
      pathname =| it->nextElement();
      pw->print("    "); pw->println(pathname);
    }
    pw->println("------");
    pw->flush();
  }

/*ネームサーバ管理*/

  //ネームサーバが管理しているブランチのパス名のSetを返す。
  // 返値 ネームサーバが管理しているブランチのパス名のSet
  public Set getBranches(){
    Dictionary branches = nr->getBranches();
    return branches->keys();
  }

/* @
  // ネームサーバを活性化する。
  public locked void Activate(){
    notactivate = false;
  }

  // ネームサーバを非活性化する。
  public locked void InActivate(){
    notactivate = ture;
  }
*/

/*処理の委譲*/

  //オーナマップを検索する
  // [path:]ディレクトリパス名
  // 返値 ディレクトリ
  // クラス本体をロックする動作を含んではいけない
  protected NameDirectory SearchOwnerMap(Path path){
    Dictionary ownermap = nr->getOwnerMap();
//    System debug => create();
    Root obj;
    try{
      obj = ownermap->get(path->asString());
    }catch(Exception e){
//      debug->println("SearchOwnerMap a");
      NameServerOwnerMapException ee => init();
      throw ee;
    }
    if(obj==null){
//      debug->println("SearchOwnerMap b");
      NameServerOwnerMapException e => init();
      throw e;
    } else {
      NameDirectory nd; nd =| obj;
      return nd;
    }
  }

  protected bool isBranch(Path path){
    Dictionary branch = nr->getBranches();
    return branch->containsKey(path->asString());
  }

/*ディレクトリの名称管理 というよりエントリ管理*/

  // オブジェクトentをパスpathでエントリとして登録する。
  // [path:]パス名  [ent:]オブジェクト
  // 例外 NameServerOwnerMapException pathが管理外
  // 例外PathStringIllegularException pathに文法的誤り
  public void putEntry (Path path, Root ent){
    Path dirpath; String name; NameDirectory nd;
//    System debug => create();
    try{
      dirpath = path->UpperPath(delimitor);
      name = path->LowerName(delimitor);
//      debug->println("a");
    }catch(Exception e){
//      debug->println("b");
      PathStringIllegularException ee => init(); throw ee; }
    try{
//      debug->println(dirpath->asString());
      nd = SearchOwnerMap(dirpath);
    }catch(NameServerOwnerMapException e){
//      debug->println("f");
      throw e; }
    nd->putEntry(name,ent);
//    debug->println("Entry put");
//    nd->debugPrint(dirpath);
  }

  // pathがエントリとして名称空間に含まれるか調べる。
  // [path:]パス名
  // 返値 含まれるとtrue、含まれていないとfalse
  // 例外 NameServerOwnerMapException pathが管理外
  // 例外 PathStringIllegularException pathに文法的誤り
  public bool containEntry (Path path){
    Path dirpath; String name; NameDirectory nd;
    try{
      dirpath = path->UpperPath(delimitor);
      name = path->LowerName(delimitor);
    }catch(Exception e){
      PathStringIllegularException ee => init(); throw ee; }
    try{
      nd = SearchOwnerMap(dirpath);
    }catch(NameServerOwnerMapException e){
      throw e; }
    bool tf = nd->containEntry(name);
    return tf;
  }

  // pathで指定されたオブジェクトを検索し、返す。
  // [path:]パス名
  // 返値 オブジェクト
  // 例外 NameServerOwnerMapException pathが管理外
  // 例外 PathStringIllegularException pathに文法的誤り
  public Root getEntry (Path path) {
    Path dirpath; String name; NameDirectory nd;
    try{
      dirpath = path->UpperPath(delimitor);
      name = path->LowerName(delimitor);
    } catch(Exception e){
      PathStringIllegularException ee => init(); throw ee; }
    try{
      nd = SearchOwnerMap(dirpath);
    } catch(NameServerOwnerMapException e){
      throw e; }
    Root obj = nd->getEntry(name);
    return obj;
  }

  // pathで指定されたオブジェクトの登録を抹消する。
  // [path:]パス名
  // 返値 削除したオブジェクト
  // 例外 NameServerOwnerMapException pathが管理外
  // 例外 PathStringIllegularException pathに文法的誤り
  public Root removeEntry(Path path){
    Path dirpath; String name; NameDirectory nd;
    try{
      dirpath = path->UpperPath(delimitor);
      name = path->LowerName(delimitor);
    }catch(Exception e){
      PathStringIllegularException ee => init(); throw ee; }
    try{
      nd = SearchOwnerMap(dirpath);
    }catch(NameServerOwnerMapException e){
      throw e; }
    Root obj;
    obj = nd->removeEntry(name);
//    nd->debugPrint(dirpath);
    return obj;
  }

  // sourceで指定されたオブジェクトのパスをtargetにリネームする。
  // sourceの親パスとtargetの親パスは同一でなければならない。
  // [source:]ソースパス名
  // [target:]ターゲットパス名
  // ソースがない場合は何もしない
  // 返り値 オブジェクト
  // 例外 NameServerOwnerMapException sourceが管理外
  // 例外 PathStringIllegularException sourceかtargetに文法的誤り
  //      またはsourceの親パスとtargetの親パスが同一でない
  public Root renameEntry(Path source, Path target){
    Path sourcedirpath, targetdirpath;
    String sourcename, targetname;
    NameDirectory nd;
    try{
      sourcedirpath = source->UpperPath(delimitor);
      sourcename = source->LowerName(delimitor);
      targetdirpath = target->UpperPath(delimitor);
      targetname = target->LowerName(delimitor);
    }catch(Exception e){
      PathStringIllegularException ee => init(); throw ee; }
    if(sourcedirpath->isequal(targetdirpath)){
      try{
	nd = SearchOwnerMap(sourcedirpath);
      }catch(NameServerOwnerMapException e){
	throw e; }
      Root obj = nd->removeEntry(sourcename);
      if(obj != null) nd->putEntry(targetname,obj);
//      nd->debugPrint(sourcedirpath);
      return obj;
    }else{
      PathStringIllegularException ee => init(); throw ee;
    }
  }

  // pathで示されたディレクトリの登録エントリ数を求める。
  // [path:]パス名
  // 返値 オブジェクトの数
  // 例外 NameServerOwnerMapException pathが管理外
  public int EntrySize (Path path) {
    NameDirectory nd;
    try{
      nd = SearchOwnerMap(path);
    }catch(NameServerOwnerMapException e){
      throw e; }
    int size = nd->EntrySize();
    return size;
  }

  // pathパスで示されたディレクトリにエントリとして登録されている
  // オブジェクトの集合をSetとして返す。
  // [path:]パス名
  // 返値 オブジェクトのコレクション
  // 例外 NameServerOwnerMapException pathが管理外
  public Set EntrySet (Path path){
    NameDirectory nd;
    Set names;
    try{
      nd = SearchOwnerMap(path);
    } catch (NameServerOwnerMapException e){
      throw e; }
    names = nd->EntrySet();
    return names;
  }

/*サブディレクトリ管理*/

  // ディレクトリsubdirをpathで示されたディレクトリにサブディレクトリ
  // として追加する。
  // [path:]パス名 [subdir:]追加するディレクトリ
  // 例外 NameServerOwnerMapException pathが管理外
  // 例外 PathStringIllegularException pathに文法的誤り
  public void putDirectory(Path path, NameDirectory subdir){
    Path dirpath; String subdirname; NameDirectory nd;
    try{
      dirpath = path->UpperPath(delimitor);
      subdirname = path->LowerName(delimitor);
    }catch(Exception e){
      PathStringIllegularException ee => init(); throw ee; }
    try{
      nd = SearchOwnerMap(dirpath);
    }catch(NameServerOwnerMapException e){
      throw e; }
    nd->putDirectory(subdirname,subdir);
    Dictionary ownermap = nr->getOwnerMap();
    ownermap = ownermap->put(path->asString(),subdir);
    nr->setOwnerMap(ownermap);
  }

  // 新規サブディレクトリをpathで示されたディレクトリに追加する。
  // [path:]パス名
  // 例外 NameServerOwnerMapException pathが管理外
  // 例外 PathStringIllegularException pathに文法的誤り
  public void putDirectory(Path path){
    Path dirpath; String subdirname; NameDirectory nd;
//    System debug => create();
//    debug->println(path->asString());
    try{
      dirpath = path->UpperPath(delimitor);
      subdirname = path->LowerName(delimitor);
    }catch(Exception e){
      PathStringIllegularException ee => init(); throw ee; }
    try{
//      debug->println(dirpath->asString());
      nd = SearchOwnerMap(dirpath);
    }catch(NameServerOwnerMapException e){
      throw e; }
    NameDirectory subdir => create();
    nd->putDirectory(subdirname,subdir);
    Dictionary ownermap = nr->getOwnerMap();
    ownermap = ownermap->put(path->asString(),subdir);
    nr->setOwnerMap(ownermap);
  }

  // BranchInOtherCellの生成。ユーザ不使用
  public void putBranchInOtherCell(Path path){
    Path dirpath; String subdirname; NameDirectory nd;
    try{
      dirpath = path->UpperPath(delimitor);
      subdirname = path->LowerName(delimitor);
    }catch(Exception e){
      PathStringIllegularException ee => init(); throw ee; }
    try{
      nd = SearchOwnerMap(dirpath);
    }catch(NameServerOwnerMapException e){
      throw e; }
    nd->BranchInOtherCell(subdirname);
  }

  //pathがディレクトリとして名称空間に含まれるか調べる。
  //[path:]パス名
  //返値 含まれるとtrue、含まれていないとfalse
  public bool containDirectory(Path path) {
/*
    Path dirpath; String subdirname; NameDirectory nd;
    try{
      dirpath = path->UpperPath(delimitor);
      subdirname = path->LowerName(delimitor);
    }catch(Exception e){
      PathStringIllegularException ee => init(); throw ee; }
    try{
      nd = SearchOwnerMap(dirpath);
    }catch(NameServerOwnerMapException e){
      throw e; }
    bool tf = nd->containDirectory(subdirname);
    return tf;
*/
    try{
      SearchOwnerMap(path);
    } catch(NameServerOwnerMapException e){ return false; }
    return true;
  }

  // pathで指定されたディレクトリを検索し、返す。
  //[path:]サブディレクトリ名
  //返値 サブディレクトリ
  // 例外 NameServerOwnerMapException pathが管理外
  public NameDirectory getDirectory(Path path) {
/*
    Path dirpath; String subdirname; NameDirectory nd;
    try{
      dirpath = path->UpperPath(delimitor);
      subdirname = path->LowerName(delimitor);
    }catch(Exception e){
      PathStringIllegularException ee => init(); throw ee; }
    try{
      nd = SearchOwnerMap(dirpath);
    }catch(NameServerOwnerMapException e){
      throw e; }
    NameDirectory subdir = nd->getDirectory(subdirname);
    return subdir;
*/
    return SearchOwnerMap(path);
  }

  // pathで指定されたディレクトリを削除する。
  // そのサブディレクトリの中が空でなかった場合は例外
  // 削除されるディレクトリはブランチであってはいけない
  //[path:]サブディレクトリ名
  //返値 削除したディレクトリ
  // 例外 NameServerOwnerMapException pathが管理外
  // 例外 NameDirectoryNotEmptyException ディレクトリが空でない
  // 例外 NameDirectoryBranchException ディレクトリがブランチである
  // 例外 PathStringIllegularException pathに文法的誤り
  public NameDirectory removeDirectory(Path path) {
    Path dirpath; String subdirname; NameDirectory nd;
    if(isBranch(path)){
      NameDirectoryBranchException e => init(); throw e; }
    try{
      nd = SearchOwnerMap(path);
    }catch(NameServerOwnerMapException e){
      throw e; }
    int entrysize = nd->EntrySize();
    int subdirsize = nd->DirectorySize();
    if((entrysize>0)||(subdirsize>0)){
      NameDirectoryNotEmptyException e => init(); throw e; }
    try{
      dirpath = path->UpperPath(delimitor);
      subdirname = path->LowerName(delimitor);
    }catch(Exception e){
      PathStringIllegularException ee => init(); throw ee; }
    nd = SearchOwnerMap(dirpath);
    NameDirectory subdir = nd->removeDirectory(subdirname);
    Dictionary ownermap = nr->getOwnerMap();
    ownermap = ownermap->remove(path->asString());
    nr->setOwnerMap(ownermap);
    return subdir;
  }

  // sourceで指定されたディレクトリのパスをtargetに変更する。
  // ディレクトリは空ディレクトリでなければならない。
  // ディレクトリはブランチであってはいけない。
  // sourceの親パスとtargetの親パスは同じでなければならない。
  // [source:]ソースパス名
  // [target:]ターゲットパス名
  // 例外 NameServerOwnerMapException pathが管理外
  // 例外 NameDirectoryNotEmptyException ディレクトリが空でない
  // 例外 NameDirectoryBranchException ディレクトリがブランチである
  // 例外 PathStringIllegularException pathに文法的誤り
  public NameDirectory renameDirectory(Path source, Path target){
    Path sourcedirpath; String sourcesubdirname; NameDirectory nd;
    Path targetdirpath; String targetsubdirname;
//    System debug => create();
//    debug->println("1");
    if(isBranch(source)){
      NameDirectoryBranchException e => init(); throw e; }
//    debug->println("2");
    try{
      nd = SearchOwnerMap(source);
    }catch(NameServerOwnerMapException e){
      throw e; }
//    debug->println("3");
    int entrysize = nd->EntrySize();
    int subdirsize = nd->DirectorySize();
    if((entrysize>0)||(subdirsize>0)){
      NameDirectoryNotEmptyException e => init(); throw e; }
//    debug->println("4");
    try{
      sourcedirpath = source->UpperPath(delimitor);
      sourcesubdirname = source->LowerName(delimitor);
      targetdirpath = target->UpperPath(delimitor);
      targetsubdirname = target->LowerName(delimitor);
    }catch(Exception e){
      PathStringIllegularException ee => init(); throw ee; }
//    debug->println("5");
    if(!(sourcedirpath->isequal(targetdirpath))){
      PathStringIllegularException ee => init(); throw ee; }
//    debug->println("6");
    try{
      nd = SearchOwnerMap(sourcedirpath);
    }catch(NameServerOwnerMapException e){
      throw e; }
//    debug->println("7");
    NameDirectory subdir = nd->removeDirectory(sourcesubdirname);
    nd->putDirectory(targetsubdirname,subdir);
    Dictionary ownermap = nr->getOwnerMap();
    ownermap = ownermap->remove(source->asString());
    ownermap = ownermap->put(target->asString(),subdir);
    nr->setOwnerMap(ownermap);
    return subdir;
  }

  // pathで示されたディレクトリの登録サブディレクトリ数を求める。
  // [path:]パス名
  //返値 サブディレクトリの数
  // 例外 NameServerOwnerMapException pathが管理外
  public int DirectorySize(Path path) {
    NameDirectory nd;
    try{
      nd = SearchOwnerMap(path);
    }catch(NameServerOwnerMapException e){
      throw e; }
    int num = nd->DirectorySize();
    return num;
  }

  // pathで示されたディレクトリに登録されているサブディレクトリの
  // 集合をSetとして返す。
  // [path:]パス名
  //返値 サブディレクトリのコレクション
  // 例外 NameServerOwnerMapException pathが管理外
  public Set DirectorySet(Path path) {
    NameDirectory nd;
    try{
      nd = SearchOwnerMap(path);
    }catch(NameServerOwnerMapException e){
      throw e; }
    Set subdirs = nd->DirectorySet();
    return subdirs;
  }

/*ブランチ*/
//ownermapには無い
//ブランチディレクトリトップ以下のNameDirectoryオブジェクトは別セルに移送する
//NameDirectoryオブジェクト内のブランチディレクトリトップへの参照
//  「ブランチで他セルにある」ということを示すオブジェクト

//    Dictionary branches = nr->getBranches();
// @例外

  //replaceBranchの中で使われる再帰関数
  //ownermapからサブディレクトリを再帰的に削除していく
  protected Dictionary removeSubDir(Dictionary nowownermap,Path nowpath){
    NameDirectory nd; nd =| nowownermap->get(nowpath->asString());
    Set subDirNames = nd->DirectoryNameSet();
    Iterator it = subDirNames->iterator();
    Dictionary nextownermap = nowownermap->remove(nowpath->asString());
    while(!(it->atEnd())){
      String subdirname;
      Path subdirpath;
      subdirname =| it->nextElement();
      subdirpath = nowpath->makeLowerPath(delimitor,subdirname);
      nextownermap = removeSubDir(nextownermap,subdirpath);
    }
    return nextownermap;
  }

  //指定ディレクトリ階層以下を指定ネームサーバに移転する。
  //そのディレクトリ階層のトップはブランチになる。
  // [path:]ディレクトリパス名
  // [toGOL]移転先のNameServerTransactionResourceセルGOL
  // 例外NameServerOwnerMapException pathが管理名称空間外
  // シングルネームサーバモードでは本メソッドは不使用
  public void replaceBranch( Path path, String toGOL) {
//    System debug => create();
    Root obj;
    NameServerTransactionResource to => bind(toGOL);
    NameDirectory nd;
    try{
      nd = SearchOwnerMap(path);
    }catch(NameServerOwnerMapException e){ throw e; }
    Dictionary ownermap = nr->getOwnerMap();
//    debug->println("replaceBranch1");

    //移転先へpath以下のNameDirectoryオブジェクトを移転
    //これでセル間のオブジェクトコピーはされている?
    to->putBranch(path,nd); 
//    debug->println("replaceBranch2");

    //ownermapからそれらを削除
    ownermap = removeSubDir(ownermap,path);
    nr->setOwnerMap(ownermap);
//    debug->println("replaceBranch3");

    //pathがブランチでない場合
    Dictionary branches = nr->getBranches();
    if( (obj = branches->get(path->asString())) == null){
      //pathで示されたNameDirectoryオブジェクトへの参照を
      //「ブランチで他セルにある」ということを示すオブジェクトに変更
      Path parentpath = path->UpperPath(delimitor);
      String name = path->LowerName(delimitor);
      NameDirectory parentnd; parentnd =| ownermap->get(parentpath->asString());
      parentnd->BranchInOtherCell(name);
    }

    //pathがブランチである場合
    else {
      //ブランチからpathを除去
      Dictionary branches = nr->getBranches();
      branches = branches->remove(path->asString());
      nr->setBranches(branches);
    }
  }

  //putBranchの中で使われる再帰関数
  protected Dictionary putSubDir(Dictionary ownermap,Path path,NameDirectory nd){
//    System debug => create();
//    nd->debugPrint(path);
    if(nd->isBranch()) return ownermap;
    Set subDirNames = nd->DirectoryNameSet();
    Iterator it = subDirNames->iterator();
    Dictionary nextownermap = ownermap->put(path->asString(),nd);
//    debug->println("putSubDir1");
    while(!(it->atEnd())){
//      debug->println("putSubDir3");
      String subdirname;
      Path subdirpath;
      subdirname =| it->nextElement();
//      debug->println(subdirname);
      subdirpath = path->makeLowerPath(delimitor,subdirname);
//      debug->println(subdirpath->asString());
      NameDirectory subnd; subnd =| nd->getDirectory(subdirname);
      nextownermap = putSubDir(nextownermap,subdirpath,subnd);
    }
//    debug->println("putSubDir2");
    return nextownermap;
  }

  //nd以下のNameDirectoryオブジェクトを、ndのパスをpathとして移転
  //ndをブランチとする
  //これでセル間のオブジェクトコピーはされている?
  public void putBranch(Path path, NameDirectory nd){
    Dictionary ownermap = nr->getOwnerMap();
    ownermap = putSubDir(ownermap,path,nd);
    nr->setOwnerMap(ownermap);
    Dictionary branches = nr->getBranches();
    branches = branches->put(path->asString(),nd);
    nr->setBranches(branches);
  }

  //自ネームサーバのブランチディレクトリ階層以下を、
  //親ディレクトリの属するネームサーバに戻す。
  // [path:]ディレクトリパス名
  // 備考 自ネームサーバのブランチディレクトリ階層以下は削除される。
  // putBranchで代用可能
  //public void restoreBranch(String path)

  // ネームサーバが管理するディレクトリの一貫性をはかる。
  // 要らない
  //public void makeConsistency()

  // ディレクトリをルートパスを持つブランチとして登録する
  // [path:] ディレクトリのパス名 [dir:] ディレクトリ
  // 例外NameServerOwnerMapException pathがルートパスではない
  public void putDirectoryAsBranch(Path path, NameDirectory dir){
    Path dirpath; String subdirname; NameDirectory nd;
    try{
      dirpath = path->UpperPath(delimitor);
    }catch(Exception e){
      PathStringIllegularException ee => init(); throw ee; }
/*
    try{
      nd = SearchOwnerMap(dirpath);
    }catch(NameServerOwnerMapException e){
*/
    if(dirpath->isEmpty()){
      Dictionary ownermap = nr->getOwnerMap();
      ownermap = ownermap->put(path->asString(),dir);
      nr->setOwnerMap(ownermap);
      Dictionary branches = nr->getBranches();
      branches = branches->put(path->asString(),dir);
      nr->setBranches(branches);
      return;
    }
    NameServerOwnerMapException e => init();    
    throw e;
  }

  // ルートパスの新しいディレクトリを生成し、ブランチとして登録する
  // [path:] ディレクトリのパス名
  // 例外NameServerOwnerMapException pathがルートパスではない
  public void putDirectoryAsBranch(Path path){
    Path dirpath; String subdirname; NameDirectory nd;
//    System debug => create();
    try{
      dirpath = path->UpperPath(delimitor);
    }catch(Exception e){
      PathStringIllegularException ee => init(); throw ee; }
/*
    try{
      nd = SearchOwnerMap(dirpath);
    }catch(NameServerOwnerMapException e){
*/
    if(dirpath->isEmpty()){
      NameDirectory dir => create();
      Dictionary ownermap = nr->getOwnerMap();
      ownermap = ownermap->put(path->asString(),dir);
      nr->setOwnerMap(ownermap);
      Dictionary branches = nr->getBranches();
      branches = branches->put(path->asString(),dir);
      nr->setBranches(branches);
      return;
    }
    NameServerOwnerMapException e => init();
    throw e;
  }

  // ブランチであるpathの親パスが本ネームサーバの管理下にある時に
  // pathで示されたディレクトリをブランチでなくす。
  // シングルネームサーバモードではこのメソッドは不使用
  //[path:] パス名
  // 例外 NameServerOwnerMapException pathかその親パスが管理外
  //   またはpathで示されたディレクトリがブランチではない
  public void unBranched(Path path){
    Path dirpath; String subdirname;
    NameDirectory nd; NameDirectory parent;
//    System debug => create();
//    debug->println("unBranched 1");
    try{
      dirpath = path->UpperPath(delimitor);
      subdirname = path->LowerName(delimitor);
    }catch(Exception e){
      PathStringIllegularException ee => init(); throw ee; }
//    debug->println("unBranched 2");
    try{
      nd = SearchOwnerMap(path);
      parent = SearchOwnerMap(dirpath);
    } catch(NameServerOwnerMapException e){ throw e; }
//    debug->println("unBranched 3");
    NameDirectory child = parent->getDirectory(subdirname);
    if(!(child->isBranch())){
      NameServerOwnerMapException e => init(); throw e; }
//    debug->println("unBranched 4");
    parent->overputDirectory(subdirname,nd);
//    debug->println("unBranched 5");
    Dictionary branches = nr->getBranches();
    branches = branches->remove(path->asString());
    nr->setBranches(branches);
    return;
  }

}
