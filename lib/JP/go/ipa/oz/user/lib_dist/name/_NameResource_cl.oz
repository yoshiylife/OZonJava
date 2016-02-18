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

  // オーナマップ(このネームサーバが管理しているディレクトリの一覧)
  // Key ディレクトリパス名String, value ディレクトリ
  Dictionary ownermap;

  // 自分が管理するディレクトリ群の各頂点(各ブランチの頂点)
  // Key ディレクトリパス名String, value ディレクトリ
  Dictionary branches;

  //全NameServerTransactionResourceのブランチを集めたもの
  //[key:]パス名String
  //[value:]そこをブランチとするNameServerTransactionResourceオブジェGOL
  // value はゆくゆくはそのNameServerのプロキシ
  Dictionary systemmap;

  //配下のネームサーバ  
  //NameServerTransactionResourceオブジェクトのGOLの集合
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


