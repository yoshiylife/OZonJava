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
cell Trader :* Stoppable{
 Set brokers;//serviceName/Broker compalatorでserviceName検索
 int MaxBrokers;//Max number of brokers
 SList removedBr;//for reuse removed broker's ID
 int bx;//index of brokers=Array index
 int intervalTime;//for refresh broker's information
 int timeOut;//default timeOut for interworking
 Set coWorkingTraders;//array of GOL(String) for inter-working
 int MaxCoWorkingTraders;
 int underMente;int time;//maintenance mode & waiting time
 Debug d;int x;//for debug

//--------INIT------------------- 
 protected final void initialize(){
  d=>create();
  MaxBrokers=100;x=1;
  B_IDComparator bc=>create();brokers=>create(bc);bx=0;
  removedBr=>create();
  MaxCoWorkingTraders=100;
  coWorkingTraders=>create();
  timeOut=10000;//for inter-working
  underMente=0;time=100;//waiting time while mentenacing
  //refreshServerInfo();
//  d->write(1,"Trader start:",d->getGOL());
 }
 protected void go(){}
 protected final void quiet(){flushCell();}
 public void stop(){d->write(1,"Trader stop");stopCell();}
//--------SET/GET-------------------  
//callerの認証にセキュリティサーバを使う 
public final void setMaxBrokers(int i){MaxBrokers=i;}
public final int  getMaxBrokers(){return MaxBrokers;}
public final void setMaxCoWorkingTraders(int i){MaxCoWorkingTraders=i;}
public final int  getMaxCoWorkingTraders(){return MaxCoWorkingTraders;}
public final void setIntervalTime(int time){intervalTime=time;}
public final int  getIntervalTime(){return intervalTime;}
public final void setTimeOut(int time){timeOut=time;}
public final int  getTimeOut(){return timeOut;}
public final void setCoWorkingTraders(Set trad){coWorkingTraders=trad;}
public final void addCoWorkingTraders(String trad){//GOL
 coWorkingTraders=coWorkingTraders->add(trad);
 d->write(x,"added coWorkingTrader:",trad);
}
// set means change
public final Set getCoWorkingTraders(){return coWorkingTraders;}
//---------------------------  
public int getSizeOfBrokers(){
  int size;size=brokers->size();
  return size; 
}

//ブローカの登録
public final int putBroker(UserBroker br){
 d->write(x,"put:");
 try{
  underMente=1;
   int id;id=bx;
   if(bx==MaxBrokers){
    if(removedBr->size()>0){
     Integer i;i=|removedBr->first();id=i->intValue();
     removedBr=removedBr->popFront();
    }else{
     d->write(1,"MaxBoker is over limit.Can't put a broker.");
     return -1;
    }
   }
//   ここでbrokerを緑にすると赤からsetIDできない。
   br->setID(bx);brokers->add(br);bx++;
  underMente=0;
  return id;
 }catch(Exception e){d->write(1,"couldn't put a broker."); return 0;}
}
//ブローカの削除
public final void removeBroker(int ID){
 d->write(x,"remove:",ID);
 try{
//  condition end;
//  while(underMente==1) wait(end,time);//don't set time_out
  UserBroker br=>create();br->setID(ID);
//  int i;i=brokers->indexOf(br);
//  d->write(x,"i=",i);
//  if(i>=0){
   int size,size2;size=brokers->size();
   brokers=|brokers->remove(br);size2=brokers->size();
  if(size>size2){
   Integer j;j=>breed(ID);removedBr->pushBack(j);
   d->write(x,"removed a broker ID=",ID);
   return;
  }
  d->write(x,"invalid ID,Can't remove a broker.");
 }catch(Exception e){d->write(1,"couldn't remove a broker.");}
}
//登録されている全てのブローカのIDとserviceNameを表示。
public final void showBroker(){
 d->write(x,"---show all brokers---");
 try{
    UserBroker br;
    Iterator it;it=brokers->iterator();
    while(it->hasMoreElements()){
     br=|it->nextElement();
     d->write(1,br->getServiceName()->concat(":"),br->getID());
    }
 }catch(Exception e){d->write(1,"couldn't remove a broker.");}
}

//必須条件を満たすブローカ群から最適なサービスを選択
public final Root getService(UserServiceRequest req){
 ServiceWithPrefer sp;
 sp=getServiceWithPrefer(req);
 return sp->getService();
}

//サービスと優先条件満足度を返す
public final ServiceWithPrefer getServiceWithPrefer(UserServiceRequest req){
  d->write(x,"getService:");
  try{
   //for interWorking
   int max;Set brs=>create();
   if(bx>0){//ブローカが登録されていたら
     brs=|getBrokers(req);max=brs->size();//必須条件によるブローカ群の選択
   }else{    
    d->write(x,"no broker registered.");max=0;
   }
   if(max==0){
    d->write(x,"Can't find a suitable broker.");
    int sx;int cmax=coWorkingTraders->size();
    d->write(x,"cmax=",cmax);
    if(cmax>0){
      //インターワーキング
      return getBestServiceFromOthers(searchOthers(req));
    }else{
      d->write(x,"There's no coWorkingTraders.");
      return null;  
    }
   }else
     return getBestService(brs,req);
  }catch(Exception e){d->write(1,"couldn't get service."); return null;}
 } 

//優先条件によるサービスの選択
final ServiceWithPrefer getBestService(Set brs,UserServiceRequest req){
  d->write(x,"getBestService:");
  try{
    UserBroker br,br2;int p,p2;p=0;
    Iterator it;it=brokers->iterator();
    while(it->hasMoreElements()){
     br=|it->nextElement();
     p2=req->preference(br);
     if(p2>p){p=p2;br2=br;}//優先条件の比較
    }
    if(p2==0||br2==null){
     br2=br;d->write(x,"There isn't a best broker.");
     return null;
    }
    ServiceWithPrefer sp;sp=>create(br2->getService(req),p2);
   return sp;//最適なサービスを返す
  }catch(Exception e){d->write(1,"couldn't get best service.");return null;}
}

//coTraderから得たサービスの優先条件の比較し最適なものを返す
final ServiceWithPrefer getBestServiceFromOthers(Set asp){
 int max;max=asp->size();
 int p,p2;ServiceWithPrefer sp,sp2;
 Iterator it;it=asp->iterator();
 while(it->hasMoreElements()){
  sp=|it->nextElement();
  p=sp->getPrefer();
  if(p>p2){p2=p;sp2=sp;}
 }
 return sp2;
}

//必須条件によるブローカ群の選択
final Set getBrokers(ServiceRequest req){
 d->write(x,"getBrokers:");
 try{
// condition end;
// while(underMente==1) wait(end,time);//タイムアウトは設定していない
  UserBroker br;Set brs=>create();
  String s1,s2;   s1=req->getServiceName();
  Set result=>create();
  Iterator it;it=brokers->iterator();
  while(it->hasMoreElements()){
   br=|it->nextElement();
   s2=br->getServiceName();
   if(s1->isequal(s2)){//サービス名が一致したブローカ配列を返す
    result->add(br);
   }
  }
  return result;
 }catch(Exception e){d->write(x,"couldn't get brokders.");return null;}
}

//coWorkingTradersを検索し、サービスを返す
final ServiceWithPrefer getServiceFromOthers(String tr,UserServiceRequest req,int time){
   Timer t=>create();GetServiceRunnable r=>create(t);
   r->set(this,tr,req);
   ServiceWithPrefer svc;svc=|t->invoke(r,time);
   return svc;
}
public final ServiceWithPrefer getServiceFromOthers(String tr,UserServiceRequest req){
   Trader otr;otr=>bind(tr);
   ServiceWithPrefer osvc;osvc=|otr->getServiceWithPrefer(req);
   return osvc;
}

//登録されている全てのcoWorkingTradersを検索し、サービス配列を返す
public final Set searchOthers(UserServiceRequest req){
 d->write(x,"searchOtherTraders:");
 try{
  String tr;int sx;
  Set svc;svc=>create();
  Iterator it;it=coWorkingTraders->iterator();
  while(it->hasMoreElements()){
   tr=|it->nextElement();
   d->write(x,"coWoker=",tr);
   ServiceWithPrefer osvc;
   osvc=getServiceFromOthers(tr,req,timeOut);
   if(osvc!=null){
    svc->add(osvc);d->write(x,"got service from others.");
   }
  }
  return svc;
 }catch(TimeOutException e){
   d->write(x,"InterWork:timed out");return null;}
}

//各ブローカのサーバ情報をリフレッシュ
public final void refreshServerInfo(){
 try{
  while(true){
   UserBroker br;condition c;
   Iterator it;it=brokers->iterator();
   while(it->hasMoreElements()){
    br=|it->nextElement();
    br->refreshServerInfo();
   }
   wait(c,intervalTime);
  }
  }catch(Exception e){d->write(x,"refreshServerInfo:exception occured.");}
}

}

class ServiceWithPrefer{//for inter-working
 Root service;
 int prefer;//優先条件満足度
 new create(Root svc,int p){service=svc;prefer=p;}
 public Root getService(){return service;}
 public int getPrefer(){return prefer;}
}

//タイムアウトつきgetServiceFromOthers用
class GetServiceRunnable :* MethodRunnable {
  Trader tr;
  String gol;UserServiceRequest req;
  new create(Timer t){super=>create(t);}
  public final void set(Trader t,String g,UserServiceRequest r){tr=t;gol=g;req=r;}
  protected final Root MyMethod(){
   return tr->getServiceFromOthers(gol,req);
  }
}


