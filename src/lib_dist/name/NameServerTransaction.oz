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

  //���Υ��֥������Ȥ�1��1�Ǵ�������NameServerTransactionResource���֥�������
  NameServerTransactionResource nstr;
  String nstrGOL;

  //�����ƥ�ޥåפ��������SystemMapTransactionResource���֥�������
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

  // System�ؤ��������֤ΰ�����ɽ��
  public void debugPrint(){ nstr->debugPrint(); }

/*�֥���*/

  //path�ǻ��ꤵ�줿�ǥ��쥯�ȥ곬�ذʲ��δ�����
  //toGOL(NameServerTransactionResource����GOL)�Ǽ����줿�͡��ॵ���Ф�
  //��ž���롣���Υǥ��쥯�ȥ곬�ؤΥȥåפϥ֥����ˤʤ롣
  //path���ܥ͡��ॵ���Фδ���̾�ζ�����Ǥʤ���Ф����ʤ�
  //[path:] ��ž�֥����Υѥ�̾
  //[toGOL:] ��ư���NameServerTransactionResource�����GOL
  //�㳰NameServiceSystemMapException toGOL�Ǽ����줿�͡��ॵ���Ф�¸�ߤ���
  // �㳰NameServerOwnerMapException path������̾�ζ��ֳ�
  // �㳰PathStringIllegularException path��ʸˡŪ���
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

  // �ǥ��쥯�ȥ�dir�򡢥롼�ȥѥ�path�Υ֥����Ȥ���
  // �ܥ͡��ॵ���Ф���Ͽ���롣
  //[path:] �ѥ�̾
  //[dir:] �ǥ��쥯�ȥ�
  //�㳰NameServerOwnerMapException path���롼�ȥѥ��ǤϤʤ�
  // �㳰PathStringIllegularException path��ʸˡŪ���
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

  // �롼�ȥѥ�path�ο������ǥ��쥯�ȥ�����������֥����Ȥ���
  // �ܥ͡��ॵ���Ф���Ͽ���롣
  //[path:] �ѥ�̾
  //[dir:] �ǥ��쥯�ȥ�
  // �㳰NameServerOwnerMapException path���롼�ȥѥ��ǤϤʤ�
  // �㳰PathStringIllegularException path��ʸˡŪ���
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

  // �֥����Ǥ���path�οƥѥ����ܥ͡��ॵ���Фδ������ˤ������
  // path�Ǽ����줿�ǥ��쥯�ȥ��֥����Ǥʤ�����
  //[path:] �ѥ�̾
  // �㳰 NameServerOwnerMapException path�����οƥѥ���������
  //   �ޤ���path�Ǽ����줿�ǥ��쥯�ȥ꤬�֥����ǤϤʤ�
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

  // �ѥ�path���������͡��ॵ����(NameServerTransactionResource����)��
  // GOL���֤���
  // �㳰 NameServiceSystemMapException path��̾�ζ��ְ�æ���ޥåԥ󥰤���Ƥ���ѥ�
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

/*�͡��ॵ���д���*/

  // �ܥ͡��ॵ���Ф�͡��ॵ���ӥ�����Ͽ����
  public void addNameServer(){
    begin();
    Array res => create(2);
    res->putAt(0,smtrGOL); res->putAt(1,nstrGOL);
    lock(res);
    smtr->AddNameServer(nstrGOL);
    commit();
  }

  // �ܥ͡��ॵ���Ф�͡��ॵ���ӥ�����������
  public void removeNameServer(){
    begin();
    Array res => create(2);
    res->putAt(0,smtrGOL); res->putAt(1,nstrGOL);
    lock(res);
    smtr->RemoveNameServer(nstrGOL);
    commit();
  }

/*�ޥåԥ��*/

  // serverNSTGOL��¾�͡��ॵ���ӥ���°����NameServerTransaction����GOL��
  // path�ˡ����Υ͡��ॵ���ӥ���̾�ζ��֤Υѥ�to��ޥåԥ󥰤��롣
  // [path:]�ޥåԥ󥰸��ѥ�̾
  // [to:]�ޥåԥ���ѥ�̾
  // [serverNSTGOL:]¾�͡��ॵ���ӥ���°����NameServerTransaction����GOL
  // �㳰 NameServiceSystemMapException mapping fail
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

/*�ǥ��쥯�ȥ��̾�δ��� �Ȥ�����ꥨ��ȥ����*/

  // ���֥�������ent��ѥ�path�ǥ���ȥ�Ȥ�����Ͽ���롣
  // [path:]�ѥ�̾  [ent:]���֥�������
  // �㳰 NameServiceSystemMapException path��̾�ζ��ְ�æ
  // �㳰PathStringIllegularException path��ʸˡŪ���
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

  // path������ȥ�Ȥ���̾�ζ��֤˴ޤޤ�뤫Ĵ�٤롣
  // [path:]�ѥ�̾
  // ���� �ޤޤ���true���ޤޤ�Ƥ��ʤ���false
  // �㳰 NameServiceSystemMapException path��̾�ζ��ְ�æ
  // �㳰PathStringIllegularException path��ʸˡŪ���
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

  // path�ǻ��ꤵ�줿���֥������Ȥ򸡺������֤���
  // [path:]�ѥ�̾
  // ���� ���֥�������
  // �㳰 NameServiceSystemMapException path��̾�ζ��ְ�æ
  // �㳰PathStringIllegularException path��ʸˡŪ���
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

  // path�ǻ��ꤵ�줿���֥������Ȥ���Ͽ�����ä��롣
  // [path:]�ѥ�̾
  // ���� ����������֥�������
  // �㳰 NameServiceSystemMapException path��̾�ζ��ְ�æ
  // �㳰PathStringIllegularException path��ʸˡŪ���
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

  // source�ǻ��ꤵ�줿���֥������ȤΥѥ���target�˥�͡��ह�롣
  // source�οƥѥ���target�οƥѥ���Ʊ��Ǥʤ���Фʤ�ʤ���
  // [source:]�������ѥ�̾
  // [target:]�������åȥѥ�̾
  // �֤��� ���֥�������
  // �㳰 NameServiceSystemMapException source��target��̾�ζ��ְ�æ
  // �㳰PathStringIllegularException source��target��ʸˡŪ���
  //      �ޤ���source�οƥѥ���target�οƥѥ���Ʊ��Ǥʤ�
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

  // path�Ǽ����줿�ǥ��쥯�ȥ����Ͽ����ȥ������롣
  // [path:]�ѥ�̾
  // ���� ��Ͽ����ȥ��
  // �㳰 NameServiceSystemMapException path��̾�ζ��ְ�æ
  // �㳰PathStringIllegularException path��ʸˡŪ���
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

  // path�Ǽ����줿�ǥ��쥯�ȥ�˥���ȥ�Ȥ�����Ͽ����Ƥ���
  // ���֥������Ȥν����Set�Ȥ����֤���
  // [path:]�ѥ�̾
  // ���� ���֥������Ȥ�Set
  // �㳰 NameServiceSystemMapException path��̾�ζ��ְ�æ
  // �㳰PathStringIllegularException path��ʸˡŪ���
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

/*���֥ǥ��쥯�ȥ��̾�δ���*/

  // �ǥ��쥯�ȥ�subdir��path�Ǽ����줿�ǥ��쥯�ȥ�˥��֥ǥ��쥯�ȥ�
  // �Ȥ����ɲä��롣
  // [path:]�ѥ�̾ [subdir:]�ɲä���ǥ��쥯�ȥ�
  // �㳰 NameServiceSystemMapException path��̾�ζ��ְ�æ
  // �㳰PathStringIllegularException path��ʸˡŪ���
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

  // �������֥ǥ��쥯�ȥ��path�Ǽ����줿�ǥ��쥯�ȥ���ɲä��롣
  // [path:]�ѥ�̾ [subdir:]�ɲä��륵�֥ǥ��쥯�ȥ�
  // �㳰 NameServiceSystemMapException path��̾�ζ��ְ�æ
  // �㳰PathStringIllegularException path��ʸˡŪ���
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

  //path���ǥ��쥯�ȥ�Ȥ���̾�ζ��֤˴ޤޤ�뤫Ĵ�٤롣
  //[path:]�ѥ�̾
  //���� �ޤޤ���true���ޤޤ�Ƥ��ʤ���false
  // �㳰 NameServiceSystemMapException path��̾�ζ��ְ�æ
  // �㳰PathStringIllegularException path��ʸˡŪ���
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

  // path�ǻ��ꤵ�줿�ǥ��쥯�ȥ�򸡺������֤���
  //[path:]���֥ǥ��쥯�ȥ�̾
  //���� ���֥ǥ��쥯�ȥ�
  // �㳰 NameServiceSystemMapException path��̾�ζ��ְ�æ
  // �㳰PathStringIllegularException path��ʸˡŪ���
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

  // path�ǻ��ꤵ�줿�ǥ��쥯�ȥ�������롣
  // �ǥ��쥯�ȥ�϶��ǥ��쥯�ȥ�Ǥʤ���Фʤ�ʤ���
  // �ǥ��쥯�ȥ�ϥ֥����Ǥ��äƤϤ����ʤ���
  //[path:]���֥ǥ��쥯�ȥ�̾
  //���� ��������ǥ��쥯�ȥ�
  // �㳰 NameServiceSystemMapException path��̾�ζ��ְ�æ
  // �㳰 PathStringIllegularException path��ʸˡŪ���
  // �㳰 NameDirectoryNotEmptyException �ǥ��쥯�ȥ꤬���Ǥʤ�
  // �㳰 NameDirectoryBranchException �ǥ��쥯�ȥ꤬�֥����Ǥ���
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

  // �ǥ��쥯�ȥ�Υѥ���source����target���Ѥ��롣
  // �ǥ��쥯�ȥ�϶��ǥ��쥯�ȥ�Ǥʤ���Фʤ�ʤ���
  // �ǥ��쥯�ȥ�ϥ֥����Ǥ��äƤϤ����ʤ���
  //[path:]���֥ǥ��쥯�ȥ�̾
  //���� ��͡��ष���ǥ��쥯�ȥ�
  // �㳰 NameServiceSystemMapException path��̾�ζ��ְ�æ
  // �㳰 PathStringIllegularException path��ʸˡŪ���
  // �㳰 NameDirectoryNotEmptyException �ǥ��쥯�ȥ꤬���Ǥʤ�
  // �㳰 NameDirectoryBranchException �ǥ��쥯�ȥ꤬�֥����Ǥ���
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

  // path�Ǽ����줿�ǥ��쥯�ȥ����Ͽ���֥ǥ��쥯�ȥ������롣
  // [path:]�ѥ�̾
  //���� ���֥ǥ��쥯�ȥ�ο�
  // �㳰 NameServiceSystemMapException path��̾�ζ��ְ�æ
  // �㳰PathStringIllegularException path��ʸˡŪ���
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

  // path�Ǽ����줿�ǥ��쥯�ȥ����Ͽ����Ƥ���ǥ��쥯�ȥ��
  // �����Set�Ȥ����֤���
  // [path:]�ѥ�̾
  //���� �ǥ��쥯�ȥ��Set
  // �㳰 NameServiceSystemMapException path��̾�ζ��ְ�æ
  // �㳰PathStringIllegularException path��ʸˡŪ���
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
