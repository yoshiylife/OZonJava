class NameDirectory {

  //直下のサブディレクトリ
  protected Dictionary SubDirs;

  //直下のオブジェクトエントリ
  protected Dictionary Entries;

  //ブランチ
  protected bool branch;

  new create(){
    StringComparator sc => create();
    Entries => create(sc);
    SubDirs => create(sc);
    branch = false;
  }

  new createBranch(){
    branch = true;
  }

  public bool debugPrint(Path path){
    try{
      System system => create();
      PrintWriter pw = system->getStdout();
      pw->print("namedirectory---"); pw->println(path->asString());
      if(branch) pw->println("branch in other nameserver cell");
      else{
        Iterator it = SubDirs->keyIterator();
        pw->println("  subdir");
        while(!(it->atEnd())){
          String subdirname;
          subdirname =| it->nextElement();
          pw->print("    "); pw->println(subdirname);
        }
        it = Entries->keyIterator();
        pw->println("  entry");
        while(!(it->atEnd())){
          String entryname;
          entryname =| it->nextElement();
          pw->print("    "); pw->println(entryname);
        }
      }
      pw->println("------");
      pw->flush();
      return true;
    } catch(SecurityException e){
      return false;
    }
  }

// ネームサーバへの逆アクセス禁止

//ディレクトリの名称管理

  // 指定したオブジェクトをディレクトリに追加する。
  // [name:]オブジェクト名  [ent:]オブジェクト
  public void putEntry (String name, Root ent){
    if(Entries->containsKey(name)) {
      NameDirectoryDuplicateNameException e => init(); throw e;
    } else {
      Entries = Entries->put(name,ent);
    }
  }

  // 指定したオブジェクトがディレクトリに含まれるか調べる。
  // [name:]オブジェクト名
  // 返値 含まれるとtrue、含まれていないとfalse
  public bool containEntry (String name){
    return( Entries->containsKey(name) );
  }

  // ディレクトリ中の指定したオブジェクトを得る
  // 存在しない場合はnullを返す
  // [name:]オブジェクト名
  // 返値 オブジェクト
  public Root getEntry (String name) {
    return ( Entries->get(name) );
  }

  // 指定したオブジェクトをディレクトリから削除する。
  // 存在しない場合は何もしない
  // [name:]オブジェクト名
  // 返値 削除したオブジェクト
  public Root removeEntry(String name){
    Root entry = Entries->get(name);
    Entries = Entries->remove(name);
    return entry;
  }

  // ディレクトリに登録されているオブジェクトの数を返す。
  // 返値 オブジェクトの数
  public int EntrySize () {
    return ( Entries->size() );
  }

  // ディレクトリに登録されているオブジェクト名を列挙する。
  // 返値 オブジェクトのコレクション RootComparator
  public Set EntryNameSet (){
    return ( Entries->keys() );
  }

  // ディレクトリに登録されているオブジェクトを列挙する。
  // 返値 オブジェクトのコレクション RootComparator
  public Set EntrySet (){
    return ( Entries->values() );
  }

//サブディレクトリ管理

  // サブディレクトリをディレクトリに追加する。上書きはしない。
  // [name:]ディレクトリ名 [dir:]追加するサブディレクトリ
  public void putDirectory(String name, NameDirectory dir) {
    if(SubDirs->containsKey(name)) {
      NameDirectoryDuplicateNameException e => init(); throw e;
    } else {
      SubDirs = SubDirs->put(name,dir);
    }
  }

  // サブディレクトリをディレクトリに追加、上書きする。
  // [name:]ディレクトリ名 [dir:]追加するサブディレクトリ
  public void overputDirectory(String name, NameDirectory dir) {
    SubDirs = SubDirs->put(name,dir);
  }

  //指定したサブディレクトリがディレクトリに含まれるか調べる。
  //[name:]サブディレクトリ名
  //返値 含まれるとtrue、含まれていないとfalse
  public bool containDirectory(String name) {
    return( SubDirs->containsKey(name) );
  }

  //指定したサブディレクトリをディレクトリから削除する。
  // 存在しない場合は何もしない
  //[name:]サブディレクトリ名
  //返値 削除したディレクトリ
  public  NameDirectory removeDirectory(String name) {
    NameDirectory subdir; subdir =| SubDirs->get(name);
    SubDirs = SubDirs->remove(name);
    return subdir;
  }

  //ディレクトリに登録されているサブディレクトリnameを列挙する。
  //返値 サブディレクトリのコレクション RootComparator
  public Set DirectoryNameSet() {
    return ( SubDirs->keys() );
  }

  //ディレクトリに登録されているサブディレクトリを列挙する。
  //返値 サブディレクトリのコレクション RootComparator
  public Set DirectorySet() {
    return ( SubDirs->values() );
  }

  // ディレクトリに登録されているサブディレクトリの数を返す。
  //返値 サブディレクトリの数
  public int DirectorySize() {
    return ( SubDirs->size() );
  }

  //ディレクトリ中の指定したサブディレクトリを得る。
  // 存在しない場合はnullを返す
  //[name:]サブディレクトリ名
  //返値 サブディレクトリ
  public NameDirectory getDirectory(String name) {
    NameDirectory nd; nd =| SubDirs->get(name);
    return nd;
  }

//ブランチ

  //nameで示されたサブディレクトリが他セルのブランチになったようにする
  //すなわち、nameをキーとするSubDirsの値をブランチにする
  //SubDirs内にnameキーが無い場合は何もしない
  //[name:] サブディレクトリ名
  public void BranchInOtherCell(String name){
    if((SubDirs->get(name))!=null){
      NameDirectory b => createBranch();
      SubDirs = SubDirs->put(name,b);
    }
  }

  public bool isBranch(){
    return branch;
  }

}
