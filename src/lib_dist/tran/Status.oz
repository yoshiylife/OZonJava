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
class Status{
 String gol;//gol of resource
 SList lockingTransaction;//排他なら1つ、共有なら複数のTIDのキュー
 SList blockingTransaction;//有限個のTIDのキュー
 int commit;//preComited=1,commited=2;
 int waitUnlock;//for recover 2pc hole
 int lockingTimeLimit;//リソースのロックを許す最長時間
 int MaxLockingTransaction;//共有ロックを行なう最大数
 int MaxBlockingTransaction;//ブロックを行なう最大数
 int lockMode;//0:unlock,1:共有モード,2:排他モード
 Debug d;int x;

//-----------CREATE/INIT---------------
new create(int ml,int mb,String g,int i){
 d=>create();init(ml,mb);x=i;gol=g;
// d->write(x," resource created");
}
public final void init(int ml,int mb){
  MaxLockingTransaction=ml;MaxBlockingTransaction=mb;
  init0();
}
public final void init0(){
  TIDComparator tc;tc=>create();
  lockingTransaction=>create(tc);
  blockingTransaction=>create(tc);
  init();
}
public final void init(){
  lockMode=0;
  commit=0;
  waitUnlock=0;
//file2->flush();
}

//------------SET/GET-----------------------
public final int getLockingTransactionSize(){
 return lockingTransaction->size();
}
public final bool setBlockingTransaction(TID t){
 int i;i=blockingTransaction->size();
 if(i==MaxBlockingTransaction)return false;
 else
  blockingTransaction->pushBack(t);return true;
}
public final void setCommit(int i){commit=i;}
public final int  getCommit(){return commit;}
public final void setWaitUnlock(int i){waitUnlock=i;}
public final int  getWaitUnlock(){return waitUnlock;}
public final void setLockingTimeLimit(int i){lockingTimeLimit=i;}
public final int  getLockingTimeLimit(){return lockingTimeLimit;}
public final void setMaxLockingTransaction(int i){MaxLockingTransaction=i;}
public final int  getMaxLockingTransaction(){return MaxLockingTransaction;}
public final void setMaxBlockingTransaction(int i){MaxBlockingTransaction=i;}
public final int  getMaxBlockingTransaction(){return MaxBlockingTransaction;}
public final void setLockMode(int i){lockMode=i;}
public final int  getLockMode(){return lockMode;}
public final SList getLockingTransaction(){return lockingTransaction;}
public final SList getBlockingTransaction(){return blockingTransaction;}

//---------------PRIMITIVE MNAGEMENT----------------
public final void unlock(TID t){
 try{
 lockingTransaction=|lockingTransaction->remove(t);
 int i;i=lockingTransaction->size();
 d->write(x," after unlocked,lockingTranSize=",i);
 if(i==0){init();
  d->write(x," inited.lockMode=",getLockMode());
  blockToLock();
 }else
 d->write(x," unlocked,but not inited.lockMode=",getLockMode());
 }catch(Exception e){d->write(1,"Exception occured");}
}
public final void blockToLock(){//unlockされたとき呼ばれる
 try{
 int i;i=blockingTransaction->size();
 if(i>0){
  TID tid;tid=|blockingTransaction->first();
 d->write(x," blockToLock:next transaction=",tid->getTidGOL(),tid->getID());
  if(tid!=null)blockingTransaction=blockingTransaction->popFront();
  i=lockBody(tid,tid->getLockMode());
  String s;s=tid->getTidGOL();Transaction t;t=>bind(s);
  d->write(x," bind to ",s);
  t->setLockingResource(gol);
 }
 }catch(Exception e){d->write(1,"Exception occured");}
}
public final int lockBody(TID t,int i){
 d->write(x," lockBody:",t->getTidGOL(),t->getID());
 try{
 if(lockMode==0||(i==1 && lockMode==1))//sharedLockは重複を許す
  lockMode=i; //lockMode:2:exclusive,1:shared,0:unlock
 if(lockMode>0){ 
  d->write(x," lockMode=",i);
  int j;j=lockingTransaction->size();
  if(j<MaxLockingTransaction){
   lockingTransaction->pushBack(t);//TID重複チェックはTransactionResource側で
   return 1;//locked
   }else{
    d->write(x,"LockingTransaction queue is over limit."); return 0;
   }
 }else return 0;//not locked
 }catch(Exception e){d->write(1,"Exception occured");return 0;}
}
public final bool isInLockingTransaction(TID t){
 try{
  int i;i=lockingTransaction->indexOf(t);
//  TID tt;tt=>create();tt=|lockingTransaction->first();
//  d->write(1," isIn=",lockingTransaction->size(),i);
  if(i==-1) return false;
  else return true;
 }catch(Exception e){d->write(1,"Exception occured");return false;}
}

}



