class NameDirectory {

  //ľ���Υ��֥ǥ��쥯�ȥ�
  protected Dictionary SubDirs;

  //ľ���Υ��֥������ȥ���ȥ�
  protected Dictionary Entries;

  //�֥���
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

// �͡��ॵ���Фؤεե��������ػ�

//�ǥ��쥯�ȥ��̾�δ���

  // ���ꤷ�����֥������Ȥ�ǥ��쥯�ȥ���ɲä��롣
  // [name:]���֥�������̾  [ent:]���֥�������
  public void putEntry (String name, Root ent){
    if(Entries->containsKey(name)) {
      NameDirectoryDuplicateNameException e => init(); throw e;
    } else {
      Entries = Entries->put(name,ent);
    }
  }

  // ���ꤷ�����֥������Ȥ��ǥ��쥯�ȥ�˴ޤޤ�뤫Ĵ�٤롣
  // [name:]���֥�������̾
  // ���� �ޤޤ���true���ޤޤ�Ƥ��ʤ���false
  public bool containEntry (String name){
    return( Entries->containsKey(name) );
  }

  // �ǥ��쥯�ȥ���λ��ꤷ�����֥������Ȥ�����
  // ¸�ߤ��ʤ�����null���֤�
  // [name:]���֥�������̾
  // ���� ���֥�������
  public Root getEntry (String name) {
    return ( Entries->get(name) );
  }

  // ���ꤷ�����֥������Ȥ�ǥ��쥯�ȥ꤫�������롣
  // ¸�ߤ��ʤ����ϲ��⤷�ʤ�
  // [name:]���֥�������̾
  // ���� ����������֥�������
  public Root removeEntry(String name){
    Root entry = Entries->get(name);
    Entries = Entries->remove(name);
    return entry;
  }

  // �ǥ��쥯�ȥ����Ͽ����Ƥ��륪�֥������Ȥο����֤���
  // ���� ���֥������Ȥο�
  public int EntrySize () {
    return ( Entries->size() );
  }

  // �ǥ��쥯�ȥ����Ͽ����Ƥ��륪�֥�������̾����󤹤롣
  // ���� ���֥������ȤΥ��쥯����� RootComparator
  public Set EntryNameSet (){
    return ( Entries->keys() );
  }

  // �ǥ��쥯�ȥ����Ͽ����Ƥ��륪�֥������Ȥ���󤹤롣
  // ���� ���֥������ȤΥ��쥯����� RootComparator
  public Set EntrySet (){
    return ( Entries->values() );
  }

//���֥ǥ��쥯�ȥ����

  // ���֥ǥ��쥯�ȥ��ǥ��쥯�ȥ���ɲä��롣��񤭤Ϥ��ʤ���
  // [name:]�ǥ��쥯�ȥ�̾ [dir:]�ɲä��륵�֥ǥ��쥯�ȥ�
  public void putDirectory(String name, NameDirectory dir) {
    if(SubDirs->containsKey(name)) {
      NameDirectoryDuplicateNameException e => init(); throw e;
    } else {
      SubDirs = SubDirs->put(name,dir);
    }
  }

  // ���֥ǥ��쥯�ȥ��ǥ��쥯�ȥ���ɲá���񤭤��롣
  // [name:]�ǥ��쥯�ȥ�̾ [dir:]�ɲä��륵�֥ǥ��쥯�ȥ�
  public void overputDirectory(String name, NameDirectory dir) {
    SubDirs = SubDirs->put(name,dir);
  }

  //���ꤷ�����֥ǥ��쥯�ȥ꤬�ǥ��쥯�ȥ�˴ޤޤ�뤫Ĵ�٤롣
  //[name:]���֥ǥ��쥯�ȥ�̾
  //���� �ޤޤ���true���ޤޤ�Ƥ��ʤ���false
  public bool containDirectory(String name) {
    return( SubDirs->containsKey(name) );
  }

  //���ꤷ�����֥ǥ��쥯�ȥ��ǥ��쥯�ȥ꤫�������롣
  // ¸�ߤ��ʤ����ϲ��⤷�ʤ�
  //[name:]���֥ǥ��쥯�ȥ�̾
  //���� ��������ǥ��쥯�ȥ�
  public  NameDirectory removeDirectory(String name) {
    NameDirectory subdir; subdir =| SubDirs->get(name);
    SubDirs = SubDirs->remove(name);
    return subdir;
  }

  //�ǥ��쥯�ȥ����Ͽ����Ƥ��륵�֥ǥ��쥯�ȥ�name����󤹤롣
  //���� ���֥ǥ��쥯�ȥ�Υ��쥯����� RootComparator
  public Set DirectoryNameSet() {
    return ( SubDirs->keys() );
  }

  //�ǥ��쥯�ȥ����Ͽ����Ƥ��륵�֥ǥ��쥯�ȥ����󤹤롣
  //���� ���֥ǥ��쥯�ȥ�Υ��쥯����� RootComparator
  public Set DirectorySet() {
    return ( SubDirs->values() );
  }

  // �ǥ��쥯�ȥ����Ͽ����Ƥ��륵�֥ǥ��쥯�ȥ�ο����֤���
  //���� ���֥ǥ��쥯�ȥ�ο�
  public int DirectorySize() {
    return ( SubDirs->size() );
  }

  //�ǥ��쥯�ȥ���λ��ꤷ�����֥ǥ��쥯�ȥ�����롣
  // ¸�ߤ��ʤ�����null���֤�
  //[name:]���֥ǥ��쥯�ȥ�̾
  //���� ���֥ǥ��쥯�ȥ�
  public NameDirectory getDirectory(String name) {
    NameDirectory nd; nd =| SubDirs->get(name);
    return nd;
  }

//�֥���

  //name�Ǽ����줿���֥ǥ��쥯�ȥ꤬¾����Υ֥����ˤʤä��褦�ˤ���
  //���ʤ����name�򥭡��Ȥ���SubDirs���ͤ�֥����ˤ���
  //SubDirs���name������̵�����ϲ��⤷�ʤ�
  //[name:] ���֥ǥ��쥯�ȥ�̾
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
