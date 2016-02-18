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
cell Transaction{
 TID tid;
 Array lockingResources;
 Array blockingResources;
 int lx;//index of lockingResources
 int bx;//index of blockingResources
 int timeOut;
 int maxLockRetry;
 int maxID;
 int maxLockingResource;
 int maxBlockingResource;
 protected Debug d;
 protected int x;
 int size;//size of lockingResources
 int ScanTime;

//---------------INIT-----------------
protected void initialize(String gol){
 lx=0;bx=0;
 tid=>create();tid->set(0,gol);//初期IDはダミーで０とする.beginで１になる
 ScanTime=100;//[milli sec] scanning time
 timeOut=5000;//[milli sec] RMI timeOut
 maxID=1000;
 maxLockingResource=100;
 maxBlockingResource=100;
 lockingResources=>create(maxLockingResource);
 blockingResources=>create(maxBlockingResource);
}
//---------------GO/QUIET-----------------
protected void go(){}
protected void quiet(){flushCell();}

//-------------SET/GET---------------- 
public final int getLx(){return lx;}
public final void setResourceTimeOut(int time){ 
 timeOut=time;
}
protected final int getResourceTimeOut(){return timeOut;}
protected final void setMaxLockRetry(int n){//ロックの試行回数
 maxLockRetry=n;
}
protected final int getMaxLockRetry(){
 return maxLockRetry;
}
public final Array getBlockingResources(){
 return blockingResources;
}
protected final TID getTID(){
 return tid;
}
public final int getMaxBlockingResource(){
 return maxBlockingResource;
}
//---------------BEGIN-----------------
protected final void begin(){createID();}
protected final void begin(int time){timeOut=time;createID();}
final void createID(){
 try{
 int i;i=tid->getID();
 if(i>maxID)tid->setID(1);//reset ID
 else {i=i+1; tid->setID(i);}
 d->write(x,"Begin:",tid->getTidGOL(),tid->getID());
 }catch(Exception e){d->write(1,"Exception occured");}
}
//-------GetResource with TimeOut-------------
public TransactionResource getResource(String rg,int time){
 d->write(x,"time=",time);
  TranTimer t=>create();TranRun l=>create(t);
  l->set(this,rg);
  return t->invoke(l,time);
}
public locked TransactionResource getResource(String rg){
 condition c;wait(c,1000);
 try{
  TransactionResource r=>bind(rg);d->write(x,"bound");
  return r;
 }catch(Exception e){d->write(x,"exception");return null;}
}
//---------------LOCK-----------------
//排他ロック
public final void lock(Array res){
 lockHead(res,2,timeOut);
}
protected final void lock(Array res,int time){
 lockHead(res,2,time);
}
/*共有ロック
既に他のトランザクションによって排他モードでロックされている場合は
アンロックされるまでブロックする。
*/
protected final void sharedLock(Array res){
 lockHead(res,1,timeOut);
}
protected final void sharedLock(Array res,int time){
 lockHead(res,1,time);
}

public final void lockHead(Array res,int lockMode,int time){
 int lockRetryTimes=0;
 try{
  lockBody(res,lockMode,time);
 }catch(TimeOutException e){
  d->write(x,"lockBody:timeOut");
  if(checkDeadLock()){  
   d->write(x,"CheckDeadLock:DeadLock found,transation aborted");
   abortTran();
  }else lockRetry(lockRetryTimes,res,lockMode,time);
 }
 catch(TransactionAbortException e){
  d->write(x,"transaction aborted");abortTran();}
 catch(Exception e){d->write(1,"Exception occured");}
}
//ロックの本体
final void lockBody(Array res,int lockMode,int time){
 d->write(x,"lockBody lx=",lx,res->size());
 try{
  String rg;//GOL of TransactionResource
  TransactionResource r;
  int j;size=res->size();
  for(int i=0;i<size;i++){
   rg=|res->at(i);
   d->write(x,"lock bind:",rg);
   r=getResource(rg,time);//r=>bind(rg);//createと合わせなければならない
   d->write(x,"lockMode=",r->getLockMode());
   if(lockMode==2)
    j=r->lock(tid);
   else
    j=r->sharedLock(tid);
   d->write(x,"(shared)locked=",j);
   if(j==1){//0:unlocked,1:locked,2:blocked
    lockingResources->putAt(lx++,rg);
   }else if(j==2){
     blockingResources->putAt(bx++,rg);//r->blockToLockを知る  
   }
  }
/*blockingTransactionがロックされる＝全てロックされるまで待つ
  condition dummy;
  while(!isLock()){
   d->write(x,"waiting for lock");wait(dummy,ScanTime);
  }
*/
 d->write(x,"lx2=",lx);
 }catch(Exception e){d->write(x,"Exception occured");}
}
public final bool isLock(){
 if(size==lx)return true;else return false;
}
public final void setLockingResource(String rg){
 try{
 d->write(x,"setLockingTransaction: called by ",rg);
 lockingResources->putAt(lx++,rg);
 blockingResources=|blockingResources->remove(rg);//removeAllでなくともよい？
 }catch(Exception e){d->write(1,"Exception occured");}
}

final void lockRetry(int lockRetryTimes,Array res,int lockMode,int time){
 try{
  LockRetryOverTimesException e=>init();
  if(lockRetryTimes++ < maxLockRetry)
   lockBody(res,lockMode,time);
  else{
    d->write(x,"LockRetryOverTimesException");
    abortTran();
   }
  }catch(LockRetryOverTimesException e){
    d->write(x,"LockRetryOverTimesException");
    abortTran();
  }
}

//--------------CHECK DEAD LOCK------------
protected final bool checkDeadLock(){//テストのため protected
 d->write(1,"checkDeadLock:");
/*
   blockingResources(bx)中のTransactionResource*1の
   lockingTransaction（排他ロック）のTrasanction*2の
   blockingResources(bx)中の lockingTransaction（排他ロック）*3
   が 自分ならデッドロック
*/
 String rg;//gol of resource
 TransactionResource r; 
try{
 TIDComparator tc;tc=>create();SList lt;lt=>create(tc);//lockingTransaction
 TID lt1;Transaction t;int max,i;

 i=bx-1;rg=|blockingResources->at(i);
  d->write(1," blocking:",rg);
  r=getResource(rg,timeOut);//r=>bind(rg);//*1

 lt=r->getLockingTransaction();
 lt1=|lt->first();rg=lt1->getTidGOL();
  d->write(1," that resource's locking by:",rg);
  t=>bind(rg);//*2

 max=t->getMaxBlockingResource();
 Array a=>create(max);
 a=t->getBlockingResources(); rg=|a->at(0);
  d->write(1," that transaction's blocking:",rg);
  r=getResource(rg,timeOut);//r=>bind(rg);//*3
 
 lt=r->getLockingTransaction();lt1=|lt->first();
  d->write(1," finally,that resource's locking by:",lt1->getTidGOL(),lt1->getID());
 if(tid->equal(lt1))return true; else return false;
 }catch(Exception e){d->write(1,"Exception occured");return false;}
}

//--------------UNLOCK--------------------
/*
final void unlock(){
 Timer t=>create();MyMethodRunnable m=>create(t);
 m->set(this,res,1,time);t->invoke(m,time);
}*/
final void unlock(){
 d->write(x,"unlock");
 try{
  TimeOutException e=>init();
  String rg;
  for(int i=0;i<lx;i++){
   rg=|lockingResources->at(i);
   TransactionResource r=getResource(rg,timeOut);//r=>bind(rg);
   r->unlock(tid);
   }
 lx=0;
 d->write(x,"unlocked");
 }catch(TimeOutException e){
  d->write(x,"unlock time out");
 }
 catch(Exception e){d->write(1,"Exception occured");}
}
//-------------COMMIT/ABORT--------------

public final void abortTran(String gol){//called by resource
 d->write(x," abort by resource:");
 try{
 int i;i=lockingResources->indexOf(gol);
 if(i==-1){
  d->write(x,"Transaction Aborted");
  TransactionAbortException e=>init();throw e;
 }else d->write(x,"Ignore invalid abort from resource.");
 }catch(Exception e){d->write(1,"Exception occured");}
}
final void abortTran(){
 d->write(x,"abort");
 try{
  TransactionResource r;
//  TimeOutException e=>init();
  String rg;
  for(int i=0;i<lx;i++){
   rg=|lockingResources->at(i);
   r=getResource(rg,timeOut);//r=>bind(rg);
   r->rollback(tid);
  }
  for(int i=0;i<lx;i++){
   rg=|lockingResources->at(i);
   r=getResource(rg,timeOut);//r=>bind(rg);
   r->unlock(tid);
  }
  d->write(x,"Transaction Aborted");
  TransactionAbortException e=>init();throw e;
  }catch(TimeOutException e){
   d->write(x,"TimeOut befor abort");
  }
 catch(Exception e){d->write(1,"Exception occured");}
}
public final void commit(){
 try{
  commitBody();
  unlock();
 }catch(TransactionAbortException e){d->write(x,"transaction aborted");}
 catch(Exception e){d->write(1,"Exception occured");}
}
final void commitBody(){
 d->write(x,"commitBody");
 try{
  TransactionResource r;
  TimeOutException e=>init();
  d->write(x,"preCommit");
  String rg;
//  d->write(x," lx=",lx);
  for(int i=0;i<lx;i++){
   rg=|lockingResources->at(i);
   r=getResource(rg,timeOut);//r=>bind(rg);
   if(!r->isReadyToCommit(tid))return;
  }
//commit
  d->write(x,"commit");
 for(int i=0;i<lx;i++){
  rg=|lockingResources->at(i);
  r=getResource(rg,timeOut);//r=>bind(rg);
  if(!r->commit(tid))return;
 }
 }catch(TimeOutException e){
  d->write(1,"Commit fault");
  abortTran();
 }
 catch(Exception e){d->write(1,"Exception occured");abortTran();}
}
}








