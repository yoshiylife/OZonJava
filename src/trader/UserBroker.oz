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

// $B%5!<%S%9Ds6!<T$O%V%m!<%+$H%5!<%S%9MW5a%/%i%9$rDs6!$9$k!#(B

// UserBroker$B$KBP$7$F(BUserServiceRequest$B$rDs6!$9$kNc!'(B 

//TestService$B$rJV$9%V%m!<%+(B
class UserBroker : *Broker{
 Debug d;int x;
 new create(){}
 new create(String str){
  d=>create();x=1;//for debug
  serviceName=str;}
 public Root getService(UserServiceRequest req){
  //$B$3$3$O%"%/%;%9%9%?%V$rJV$7$F$b$h$$(B
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
 //$B%5!<%S%9$N>r7o(B
 public bool keyWordSearch(){return true;} 
 public bool wholeText(){return true;} 
 public bool japanese(){return true;} 
}
class TestService{
 new create(){}
 public String getName(){return "TestService";}
}

