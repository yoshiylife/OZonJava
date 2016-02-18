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

class NameResource {

  // �����ʥޥå�(���Υ͡��ॵ���Ф��������Ƥ���ǥ��쥯�ȥ�ΰ���)
  // Key �ǥ��쥯�ȥ�ѥ�̾String, value �ǥ��쥯�ȥ�
  Dictionary ownermap;

  // ��ʬ����������ǥ��쥯�ȥ귲�γ�ĺ��(�ƥ֥�����ĺ��)
  // Key �ǥ��쥯�ȥ�ѥ�̾String, value �ǥ��쥯�ȥ�
  Dictionary branches;

  //��NameServerTransactionResource�Υ֥����򽸤᤿���
  //[key:]�ѥ�̾String
  //[value:]������֥����Ȥ���NameServerTransactionResource���֥���GOL
  // value �Ϥ椯�椯�Ϥ���NameServer�Υץ���
  Dictionary systemmap;

  //�۲��Υ͡��ॵ����  
  //NameServerTransactionResource���֥������Ȥ�GOL�ν���
  Set servers;

  new create(){
    StringComparator sc => create();
//    PathComparator pc => create();
    ownermap=>create(sc); branches=>create(sc);
    systemmap=>create(sc); servers=>create(sc);
  }
  public final Dictionary getOwnerMap(){return ownermap;}
  public final Dictionary getBranches(){return branches;}
  public final Dictionary getSystemmap(){return systemmap;}
  public final Set getServers(){return servers;}
  public final void setOwnerMap(Dictionary om){ownermap=om;}
  public final void setBranches(Dictionary br){branches=br;}
  public final void setSystemmap(Dictionary sm){systemmap=sm;}
  public final void setServers(Set s){servers=s;}
}


