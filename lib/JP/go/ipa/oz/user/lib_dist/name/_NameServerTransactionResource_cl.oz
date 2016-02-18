cell NameServerTransactionResource :* TransactionResource {

  //�ѥ�̾�ǥ�ߥ�
  // ���󥹥ȥ饯�����ʹ�����(�ȥ�󥶥�������������)
  String delimitor;

  //self GOL
  String selfGOL;

  NameResource nr;

  // �͡��ॵ���ӥ��ؤ���Ͽ�Ϥ�����ǤϹԤʤ�ʤ�
  // ���� �ѥ�̾�ǥ�ߥ���':'�����Ѥ���롣
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

  // System ��������¤�ΰ��������
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

/*�͡��ॵ���д���*/

  //�͡��ॵ���Ф��������Ƥ���֥����Υѥ�̾��Set���֤���
  // ���� �͡��ॵ���Ф��������Ƥ���֥����Υѥ�̾��Set
  public Set getBranches(){
    Dictionary branches = nr->getBranches();
    return branches->keys();
  }

/* @
  // �͡��ॵ���Ф���������롣
  public locked void Activate(){
    notactivate = false;
  }

  // �͡��ॵ���Ф�����������롣
  public locked void InActivate(){
    notactivate = ture;
  }
*/

/*�����ΰѾ�*/

  //�����ʥޥåפ򸡺�����
  // [path:]�ǥ��쥯�ȥ�ѥ�̾
  // ���� �ǥ��쥯�ȥ�
  // ���饹���Τ��å�����ư���ޤ�ǤϤ����ʤ�
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

/*�ǥ��쥯�ȥ��̾�δ��� �Ȥ�����ꥨ��ȥ����*/

  // ���֥�������ent��ѥ�path�ǥ���ȥ�Ȥ�����Ͽ���롣
  // [path:]�ѥ�̾  [ent:]���֥�������
  // �㳰 NameServerOwnerMapException path��������
  // �㳰PathStringIllegularException path��ʸˡŪ���
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

  // path������ȥ�Ȥ���̾�ζ��֤˴ޤޤ�뤫Ĵ�٤롣
  // [path:]�ѥ�̾
  // ���� �ޤޤ���true���ޤޤ�Ƥ��ʤ���false
  // �㳰 NameServerOwnerMapException path��������
  // �㳰 PathStringIllegularException path��ʸˡŪ���
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

  // path�ǻ��ꤵ�줿���֥������Ȥ򸡺������֤���
  // [path:]�ѥ�̾
  // ���� ���֥�������
  // �㳰 NameServerOwnerMapException path��������
  // �㳰 PathStringIllegularException path��ʸˡŪ���
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

  // path�ǻ��ꤵ�줿���֥������Ȥ���Ͽ�����ä��롣
  // [path:]�ѥ�̾
  // ���� ����������֥�������
  // �㳰 NameServerOwnerMapException path��������
  // �㳰 PathStringIllegularException path��ʸˡŪ���
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

  // source�ǻ��ꤵ�줿���֥������ȤΥѥ���target�˥�͡��ह�롣
  // source�οƥѥ���target�οƥѥ���Ʊ��Ǥʤ���Фʤ�ʤ���
  // [source:]�������ѥ�̾
  // [target:]�������åȥѥ�̾
  // ���������ʤ����ϲ��⤷�ʤ�
  // �֤��� ���֥�������
  // �㳰 NameServerOwnerMapException source��������
  // �㳰 PathStringIllegularException source��target��ʸˡŪ���
  //      �ޤ���source�οƥѥ���target�οƥѥ���Ʊ��Ǥʤ�
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

  // path�Ǽ����줿�ǥ��쥯�ȥ����Ͽ����ȥ������롣
  // [path:]�ѥ�̾
  // ���� ���֥������Ȥο�
  // �㳰 NameServerOwnerMapException path��������
  public int EntrySize (Path path) {
    NameDirectory nd;
    try{
      nd = SearchOwnerMap(path);
    }catch(NameServerOwnerMapException e){
      throw e; }
    int size = nd->EntrySize();
    return size;
  }

  // path�ѥ��Ǽ����줿�ǥ��쥯�ȥ�˥���ȥ�Ȥ�����Ͽ����Ƥ���
  // ���֥������Ȥν����Set�Ȥ����֤���
  // [path:]�ѥ�̾
  // ���� ���֥������ȤΥ��쥯�����
  // �㳰 NameServerOwnerMapException path��������
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

/*���֥ǥ��쥯�ȥ����*/

  // �ǥ��쥯�ȥ�subdir��path�Ǽ����줿�ǥ��쥯�ȥ�˥��֥ǥ��쥯�ȥ�
  // �Ȥ����ɲä��롣
  // [path:]�ѥ�̾ [subdir:]�ɲä���ǥ��쥯�ȥ�
  // �㳰 NameServerOwnerMapException path��������
  // �㳰 PathStringIllegularException path��ʸˡŪ���
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

  // �������֥ǥ��쥯�ȥ��path�Ǽ����줿�ǥ��쥯�ȥ���ɲä��롣
  // [path:]�ѥ�̾
  // �㳰 NameServerOwnerMapException path��������
  // �㳰 PathStringIllegularException path��ʸˡŪ���
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

  // BranchInOtherCell���������桼���Ի���
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

  //path���ǥ��쥯�ȥ�Ȥ���̾�ζ��֤˴ޤޤ�뤫Ĵ�٤롣
  //[path:]�ѥ�̾
  //���� �ޤޤ���true���ޤޤ�Ƥ��ʤ���false
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

  // path�ǻ��ꤵ�줿�ǥ��쥯�ȥ�򸡺������֤���
  //[path:]���֥ǥ��쥯�ȥ�̾
  //���� ���֥ǥ��쥯�ȥ�
  // �㳰 NameServerOwnerMapException path��������
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

  // path�ǻ��ꤵ�줿�ǥ��쥯�ȥ�������롣
  // ���Υ��֥ǥ��쥯�ȥ���椬���Ǥʤ��ä������㳰
  // ��������ǥ��쥯�ȥ�ϥ֥����Ǥ��äƤϤ����ʤ�
  //[path:]���֥ǥ��쥯�ȥ�̾
  //���� ��������ǥ��쥯�ȥ�
  // �㳰 NameServerOwnerMapException path��������
  // �㳰 NameDirectoryNotEmptyException �ǥ��쥯�ȥ꤬���Ǥʤ�
  // �㳰 NameDirectoryBranchException �ǥ��쥯�ȥ꤬�֥����Ǥ���
  // �㳰 PathStringIllegularException path��ʸˡŪ���
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

  // source�ǻ��ꤵ�줿�ǥ��쥯�ȥ�Υѥ���target���ѹ����롣
  // �ǥ��쥯�ȥ�϶��ǥ��쥯�ȥ�Ǥʤ���Фʤ�ʤ���
  // �ǥ��쥯�ȥ�ϥ֥����Ǥ��äƤϤ����ʤ���
  // source�οƥѥ���target�οƥѥ���Ʊ���Ǥʤ���Фʤ�ʤ���
  // [source:]�������ѥ�̾
  // [target:]�������åȥѥ�̾
  // �㳰 NameServerOwnerMapException path��������
  // �㳰 NameDirectoryNotEmptyException �ǥ��쥯�ȥ꤬���Ǥʤ�
  // �㳰 NameDirectoryBranchException �ǥ��쥯�ȥ꤬�֥����Ǥ���
  // �㳰 PathStringIllegularException path��ʸˡŪ���
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

  // path�Ǽ����줿�ǥ��쥯�ȥ����Ͽ���֥ǥ��쥯�ȥ������롣
  // [path:]�ѥ�̾
  //���� ���֥ǥ��쥯�ȥ�ο�
  // �㳰 NameServerOwnerMapException path��������
  public int DirectorySize(Path path) {
    NameDirectory nd;
    try{
      nd = SearchOwnerMap(path);
    }catch(NameServerOwnerMapException e){
      throw e; }
    int num = nd->DirectorySize();
    return num;
  }

  // path�Ǽ����줿�ǥ��쥯�ȥ����Ͽ����Ƥ��륵�֥ǥ��쥯�ȥ��
  // �����Set�Ȥ����֤���
  // [path:]�ѥ�̾
  //���� ���֥ǥ��쥯�ȥ�Υ��쥯�����
  // �㳰 NameServerOwnerMapException path��������
  public Set DirectorySet(Path path) {
    NameDirectory nd;
    try{
      nd = SearchOwnerMap(path);
    }catch(NameServerOwnerMapException e){
      throw e; }
    Set subdirs = nd->DirectorySet();
    return subdirs;
  }

/*�֥���*/
//ownermap�ˤ�̵��
//�֥����ǥ��쥯�ȥ�ȥåװʲ���NameDirectory���֥������Ȥ��̥���˰�������
//NameDirectory���֥���������Υ֥����ǥ��쥯�ȥ�ȥåפؤλ���
//  �֥֥�����¾����ˤ���פȤ������Ȥ򼨤����֥�������

//    Dictionary branches = nr->getBranches();
// @�㳰

  //replaceBranch����ǻȤ���Ƶ��ؿ�
  //ownermap���饵�֥ǥ��쥯�ȥ��Ƶ�Ū�˺�����Ƥ���
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

  //����ǥ��쥯�ȥ곬�ذʲ������͡��ॵ���Ф˰�ž���롣
  //���Υǥ��쥯�ȥ곬�ؤΥȥåפϥ֥����ˤʤ롣
  // [path:]�ǥ��쥯�ȥ�ѥ�̾
  // [toGOL]��ž���NameServerTransactionResource����GOL
  // �㳰NameServerOwnerMapException path������̾�ζ��ֳ�
  // ���󥰥�͡��ॵ���Х⡼�ɤǤ��ܥ᥽�åɤ��Ի���
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

    //��ž���path�ʲ���NameDirectory���֥������Ȥ��ž
    //����ǥ���֤Υ��֥������ȥ��ԡ��Ϥ���Ƥ���?
    to->putBranch(path,nd); 
//    debug->println("replaceBranch2");

    //ownermap���餽������
    ownermap = removeSubDir(ownermap,path);
    nr->setOwnerMap(ownermap);
//    debug->println("replaceBranch3");

    //path���֥����Ǥʤ����
    Dictionary branches = nr->getBranches();
    if( (obj = branches->get(path->asString())) == null){
      //path�Ǽ����줿NameDirectory���֥������Ȥؤλ��Ȥ�
      //�֥֥�����¾����ˤ���פȤ������Ȥ򼨤����֥������Ȥ��ѹ�
      Path parentpath = path->UpperPath(delimitor);
      String name = path->LowerName(delimitor);
      NameDirectory parentnd; parentnd =| ownermap->get(parentpath->asString());
      parentnd->BranchInOtherCell(name);
    }

    //path���֥����Ǥ�����
    else {
      //�֥�������path�����
      Dictionary branches = nr->getBranches();
      branches = branches->remove(path->asString());
      nr->setBranches(branches);
    }
  }

  //putBranch����ǻȤ���Ƶ��ؿ�
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

  //nd�ʲ���NameDirectory���֥������Ȥ�nd�Υѥ���path�Ȥ��ư�ž
  //nd��֥����Ȥ���
  //����ǥ���֤Υ��֥������ȥ��ԡ��Ϥ���Ƥ���?
  public void putBranch(Path path, NameDirectory nd){
    Dictionary ownermap = nr->getOwnerMap();
    ownermap = putSubDir(ownermap,path,nd);
    nr->setOwnerMap(ownermap);
    Dictionary branches = nr->getBranches();
    branches = branches->put(path->asString(),nd);
    nr->setBranches(branches);
  }

  //���͡��ॵ���ФΥ֥����ǥ��쥯�ȥ곬�ذʲ���
  //�ƥǥ��쥯�ȥ��°����͡��ॵ���Ф��᤹��
  // [path:]�ǥ��쥯�ȥ�ѥ�̾
  // ���� ���͡��ॵ���ФΥ֥����ǥ��쥯�ȥ곬�ذʲ��Ϻ������롣
  // putBranch�����Ѳ�ǽ
  //public void restoreBranch(String path)

  // �͡��ॵ���Ф���������ǥ��쥯�ȥ�ΰ������Ϥ��롣
  // �פ�ʤ�
  //public void makeConsistency()

  // �ǥ��쥯�ȥ��롼�ȥѥ�����ĥ֥����Ȥ�����Ͽ����
  // [path:] �ǥ��쥯�ȥ�Υѥ�̾ [dir:] �ǥ��쥯�ȥ�
  // �㳰NameServerOwnerMapException path���롼�ȥѥ��ǤϤʤ�
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

  // �롼�ȥѥ��ο������ǥ��쥯�ȥ�����������֥����Ȥ�����Ͽ����
  // [path:] �ǥ��쥯�ȥ�Υѥ�̾
  // �㳰NameServerOwnerMapException path���롼�ȥѥ��ǤϤʤ�
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

  // �֥����Ǥ���path�οƥѥ����ܥ͡��ॵ���Фδ������ˤ������
  // path�Ǽ����줿�ǥ��쥯�ȥ��֥����Ǥʤ�����
  // ���󥰥�͡��ॵ���Х⡼�ɤǤϤ��Υ᥽�åɤ��Ի���
  //[path:] �ѥ�̾
  // �㳰 NameServerOwnerMapException path�����οƥѥ���������
  //   �ޤ���path�Ǽ����줿�ǥ��쥯�ȥ꤬�֥����ǤϤʤ�
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
