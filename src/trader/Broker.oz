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

abstract class Broker{
 protected int ID;
 protected String serviceName;
// protected Root getService(ServiceRequest req){return null;}
// protected abstract Root getService(ServiceRequest req);
 public final void setID(int id){ID=id;}
 //Traderに登録されたBrokerを改竄することはできない。
 public final int getID(){return ID;}
 public final String getServiceName(){return serviceName;}
 public final bool equal(Broker br){
  if(ID==br->getID())return true;else return false;
 }
 public final bool equalServiceName(Broker br){
  if(serviceName==br->getServiceName())return true;else return false;
 }
 public void refreshServerInfo(){}//must be over wridden
}
class B_IDComparator : Comparator{
 new create(){}
 public final boolean compare(Root t1,Root t2){
  UserBroker a1,a2;a1=|t1;a2=|t2;
  if(a1->equal(a2))return true;
  else return false;
 }
 public final Comparator duplicate(){return this;}
 public final int hash (Root t){return 0;}
}
class B_ServiceNameComparator : Comparator{
 new create(){}
 public final boolean compare(Root t1,Root t2){
  UserBroker a1,a2;a1=|t1;a2=|t2;
  if(a1->equalServiceName(a2))return true;
  else return false;
 }
 public final Comparator duplicate (){return this;}
 public final int hash (Root t){return 0;}
}



