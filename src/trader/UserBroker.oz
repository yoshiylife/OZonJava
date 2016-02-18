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

//TestServiceを返すブローカ
class UserBroker : *Broker{
 Debug d;int x;
 new create(){}
 new create(String str){
  d=>create();x=1;//for debug
  serviceName=str;}
 public Root getService(UserServiceRequest req){
  //ここはアクセススタブを返してもよい
  return getService();
 }
 public Root getService(){
  TestService ts=>create();
  return ts;
 }
 public void refreshServerInfo(){
  TestService ts;ts=|getService();
  if(ts==null){
   d->write(x,"Can't create service instance.");
  }
 }
 //サービスの条件
 public bool keyWordSearch(){return true;} 
 public bool wholeText(){return true;} 
 public bool japanese(){return true;} 
}
class TestService{
 new create(){}
 public String getName(){return "TestService";}
}

