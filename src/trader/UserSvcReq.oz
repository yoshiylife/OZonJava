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


// サービス提供者はブローカとサービス要求クラスを提供する。

// UserBrokerに対してUserServiceRequestを提供する例：

class UserServiceRequest :*ServiceRequest{
 new create(){super=>create();}
 public bool requirement(UserBroker br){
  return br->keyWordSearch();
 }
 //優先条件
 public int preference(UserBroker br){
  int i,j;
  if(br->wholeText())i=1;else i=0;
  if(br->japanese())j=1;else j=0;
  return i*2+j;
 }
}

