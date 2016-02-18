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
cell TransactionResource{
 int init;
 int MaxLockingTransaction;
 int MaxBlockingTransaction;
 protected Status st;
 protected Resource r; //attributes and any resources to be update
 protected Resource r2;//for rollback Resource r
 String sf;  //fileName to be save Status
 String rf;  //fileName to be save Resource first
 String r2f; //fileName to be save Resource second
 int j;
 protected Debug d;protected int x;//if x=1 debug on
 String gol;//gol of this
 int ScanTime;//scanning time for checkTimeOut;

//-----------------------INIT/RECOVER-------------------------------------
protected final void initialize(String f0,String f1,String f2,String g){
 gol=g;sf=f0;rf=f1;r2f=f2; recover();
}
final void recover(){
 d->write(x,"check status file:",sf);
 try{
 st=loadStatus(sf);
 d->write(x,"status loaded");
 if(st==null){//�鵯ư���ǥե���Ȥ�����
  init();
 }
 else{
  r=loadResource(rf);if(r==null)init();
  int i;i=st->getLockMode(); 
  d->write(x,"Resource loaded,LockMode=",i);
  if(i>0){
   //wait(waitingTime);Transaction����ؼ����褿�餽�λؼ��˽���
   //else
   st->setWaitUnlock(1);rollbackFromFile();
   d->write(1,"Transaction didn't complete,self-rollbacked."); 
  }
  else
   d->write(1,"Resource file is valid,needless to recover.");
 }
 }catch(Exception e){d->write(1,"Exception occured");}
}
final void init(){
 try{
  MaxLockingTransaction=5;//default 
  MaxBlockingTransaction=5;//default 
  st=>create(MaxLockingTransaction,MaxBlockingTransaction,gol,x);
//  r=>create();
  ScanTime=10;st->setLockingTimeLimit(100);//millisec,default
  saveStatus(st,sf);
  saveResource(r,rf);//save object r to file rf
  d->write(1,"There's no resource file to load,new resource created.");
 }catch(Exception e){d->write(1,"Exception occured");}
}
protected void createResource(Root userResource){
 r=>create(userResource);
}

//---------------------GO/QUIET-------------------
protected void go(){}
protected void quiet(){flushCell();}

//----------------------SET/GET------------------------------
protected final void setMaxBlockingTransaction(int n){
 st->setMaxBlockingTransaction(n);
}
protected final int getMaxBlockingTransaction(){
 return st->getMaxBlockingTransaction();
}
protected final void setLockingTimeLimit(int time){
 st->setLockingTimeLimit(time);
}
protected final int getLockingTimeLimit(){
 return st->getLockingTimeLimit();
}
public final int getLockMode(){return st->getLockMode();}
//called by t->checkDeadLock

public final SList getLockingTransaction(){
 return st->getLockingTransaction();}

public String test(){return "RESOURCE";}

//-------------Save/Load Resource----------------------
protected void saveResource(Resource res,String fileName){//save Resource r
 try{
    FileOutputStream fs;fs=>breed(fileName);
    ObjectOutputStream os;os=>breed(fs);
    os->writeObject(res);
    os->flush();
    fs->close();
    d->write(x,"resource saved to ",fileName);
 }catch(Exception e){d->write(1,"Exception occured");}
}
protected Resource loadResource(String fileName){//load Resource r
 try{
    File f=>breed(fileName);
    if(!f->exists()){return null;}
    FileInputStream fs;fs=>breed(fileName);
    ObjectInputStream os;os=>breed(fs);
    Resource res;
    res=|os->readObject();
    return res;
 }catch(IOException e){d->write(1,"IOException. cannot load.");return null;}
  catch(ClassNotFoundException e){
   d->write(1,"ClassNotFoundException. cannot load");
   return null;
 }
 catch(Exception e){d->write(1,"Exception occured");return null;}
}
final void saveStatus(Status res,String fileName){//save Resource r
 try{
    FileOutputStream fs;fs=>breed(fileName);
    ObjectOutputStream os;os=>breed(fs);
    os->writeObject(res);
    os->flush();
    fs->close();
    d->write(x,"status saved to ",fileName);
 }catch(Exception e){d->write(1,"Exception occured");}
}
final Status loadStatus(String fileName){//load Status
 try{
    File f=>breed(fileName);
    if(!f->exists()){return null;}
    FileInputStream fs;fs=>breed(fileName);
    ObjectInputStream os;os=>breed(fs);
    Status res;
    res=|os->readObject();
    return res;
 }catch(IOException e){d->write(1,"IOException. cannot load.");return null;}
  catch(ClassNotFoundException e){
   d->write(1,"ClassNotFoundException. cannot load");
   return null;
  }
 catch(Exception e){d->write(1,"Exception occured");return null;}
}
//-----------------------LOCK/BLOCK-----------------------------------
/*
��¾��å�:(lockMode=2)
������¾��å�����Ƥ�����ʤˤ⤷�ʤ���
��å�����Ƥ��ʤ�����С���¾��å����롣
���˶�ͭ��å�����Ƥ���¾�˶�ͭ��å����Ƥ���ȥ�󥶥�����󤬤ʤ�����
��å��⡼�ɤ���¾�⡼�ɤ����ؤ���
*/
public final void checkLockingTimeBody(){//��å�����Ƥ�����֤�����å����롣
 try{
 condition c;int i;i=st->getLockMode();
 while(i>0){wait(c,ScanTime);i=st->getLockMode();
  d->write(x,"checkLockMode=",i);
 }
 }catch(Exception e){d->write(1,"Exception occured");}
}
final void checkLockingTime(){
 d->write(x,"checkLockingTime:");
 Timer t=>create();CheckLockingTime mmr=>create(t);mmr->set(this);
 int i;i=st->getLockingTimeLimit();d->write(x,"lockingTimeLimit=",i);
 try{
  t->invoke(mmr,i);
 }catch(TimeOutException e){
  d->write(x,"Resource locking timed out.");abortTran();}
 catch(Exception e){d->write(1,"Exception occured");}
}

public final int lock(TID t){ //return 0:unlocked,1:locked,2:blocked
 d->write(x,"lock:",t->getTidGOL(),t->getID());
 int ret;
 try{
//   TimeOutException e=>init();
   if(st->getLockMode() == 0)
    ret=st->lockBody(t,2);//��¾��å�
   else
    if(st->isInLockingTransaction(t) && st->getLockMode()==1 && st->getLockingTransactionSize()==1){
     st->setLockMode(2);//��ʬ�˶�ͭ����Ƥ�������ʤΤ���¾�⡼�ɤ��ѹ�
     d->write(x,"lockMode=2");
     ret=1;
    }
    else
     if(st->isInLockingTransaction(t) && st->getLockMode()==2)
      ret=1;
     else
      return block(t,2);
   if(ret==1){
//    checkLockingTime();//start timer
    saveStatus(st,sf);
    r2=r;//copy memory1 to memory2
    return 1;
   }
   else return 0; 
  }
  catch(TimeOutException e){
   d->write(1,"Lock timed out.");
//   st->init();
   return 0;
  }
 catch(Exception e){d->write(1,"Exception occured");return 0;}
}
/*
��ͭ��å�:(lockMode=1)
������¾��å�����Ƥ�����֥�å����롣
��å�����Ƥ��ʤ�����t�ʳ��Ƕ�ͭ��å�����Ƥ����顢
t��lockingTransaction���ɲä��롣
*/
public final int sharedLock(TID t){//return 0:unlocked,1:locked,2:blocked
 d->write(x,"sharedLock:",t->getTidGOL(),t->getID());
 try{
  TimeOutException e=>init();checkLockingTime();
   if(st->getLockMode()==0){ 
     r2=r;//copy memory1 to memory2
    return st->lockBody(t,1);
   }
   if(st->isInLockingTransaction(t)){
    saveStatus(st,sf);
     return 1;
   }else  return block(t,1);
  }
  catch(TimeOutException e){
   d->write(1,"sharedLock timeout.");
   st->init();
   return 0;
  }
 catch(Exception e){d->write(1,"Exception occured");return 0;}
}
public final int block(TID t,int lockMode){
 d->write(x,"block:",t->getTidGOL(),t->getID());
 try{
  TimeOutException e=>init();
  t->setLockMode(lockMode);
  if(st->setBlockingTransaction(t))
   return 2;//blocked,unlock���lock�˲󤵤��
  else{//block���������ۤ���
   d->write(1,"cannot block:block over limit");
   return 0;
  }
 }
 catch(TimeOutException e){
  d->write(1,"block:time out");return 0;}
 catch(Exception e){d->write(1,"Exception occured");return 0;}
}
public final void unlock(TID t){
 d->write(x,"unlock:",t->getTidGOL(),t->getID());
 try{
  if(st->isInLockingTransaction(t)){ 
  TimeOutException e=>init();
  st->unlock(t);
  saveStatus(st,sf);
  //r2=null;r2f.flush();
  }
  else d->write(1,"Invalid transaction,cannot unlock.");
 }catch(TimeOutException e){//������������ॢ���Ȥ��뤳�ȤϹͤ����ʤ�
  d->write(1,"unlock fault");
 }
 catch(Exception e){d->write(1,"Exception occured");}
}
//---------------------PRE/COMMIT--------------------------------------

public final bool isReadyToCommit(TID t){
 d->write(x,"preCommit:",t->getTidGOL(),t->getID());
 try{
  if(st->isInLockingTransaction(t)){//Transaction��ǧ��
   TimeOutException e=>init();
   if(st->getLockMode()==2){
    saveResource(r,rf); //save r to rf
    saveResource(r2,r2f);//save r2 to r2f
   }
   st->setCommit(1);
   saveStatus(st,sf);
   return true;
  }else{
   d->write(1,"cannot preCommit unlocked transaction.");
   return false;}
 }
 catch(TimeOutException e){
  st->init();
  d->write(1,"preCommit fault.init.");
  return false;
 }
 catch(Exception e){d->write(1,"Exception occured");return false;}
}

public final boolean commit(TID t){
 d->write(x,"commit:",t->getTidGOL(),t->getID());
 try{
  TimeOutException e=>init();
  CommitUnlockedResourceException e1=>init();
  CommitBeforePreCommitException e2=>init();
  if(st->getLockMode()==0){//throw e1;
   d->write(1,"cannot commit unlocked resource.");
   return false;
  }
  else if(st->getCommit()!=1){//throw e2;
   d->write(1,"cannot commit before pre-commit.");
   return false;
  }
  else{//commit
   if(st->isInLockingTransaction(t)){
    d->write(x,"commited");//���拾�ߥåȤϲ��⤷�ʤ���
    saveStatus(st,sf); 
    return true;
    }
    else{
     d->write(1,"cannot commit unlocked resource.");
     return false;
    }
  }
 }catch(TimeOutException e){
   userRecover(t);//recover by user's dicision
   return false;
 }
 catch(CommitUnlockedResourceException e1){
  d->write(1,"cannot commit unlocked resource.");
  return false;
 }
 catch(CommitBeforePreCommitException e2){
  d->write(1,"cannot commit before pre-commit.");
  return false;
 }
 catch(Exception e){d->write(1,"Exception occured");return false;}
}
//--------------ROLLBACK-----------------------

public final void rollback(TID t){
 try{
 if(st->isInLockingTransaction(t)){ 
  if((st->getCommit()) > 0){
   if(st->getLockMode()==2)
    r=r2;//copy memory2 to memory1
    d->write(x,"rollbacked");}
  else{st->init();d->write(x,"rollbacked(init)");}
 }
 }catch(Exception e){d->write(1,"Exception occured");}
}
final void rollbackFromFile(){
 try{
 int i;i=st->getCommit();
 if(i > 0) r=loadResource(r2f);//load from r2f
 else st->init0();//reflesh queue
// d->write(1,"self rollbacked from file.");
 }catch(Exception e){d->write(1,"Exception occured");}
}
protected final void rollbackForRecover(TID t){
// check(//if caller is this.UserRecover);
 rollback(t);
}
//---------�����ॢ���Ȼ���transaction�򥢥ܡ���-----------------
final void abortTran(){
 d->write(x,"abort:");
 try{
 SList lt;TID tid;String s;Transaction t;int size;
 while(true){
  lt=st->getLockingTransaction();
  size=lt->size();d->write(x,"size=",size);
  tid=|lt->first();
  s=tid->getTidGOL();t=>bind(s);d->write(x,"bind to ",s);
  t->abortTran(gol);d->write(x,"bind by ",gol);
  lt=lt->popFront();
  if(size==0)break;
 }
 st->init();
 }catch(Exception e){d->write(1,"Exception occured");}
}
//------�桼��������ꥫ�Х����ˡ-----------------------------------
protected void userRecover(TID t){//Must be over ride in TransactionResource
 rollbackForRecover(t);d->write(1,"self rollbacked");
 //unlockForRecover();d->write(1,"self unlocked");
 try{
  OverTimeException e=>init();
  //sleep(TIME); //�������Transaction�λؼ����Ԥ�
   }
   catch(OverTimeException e){
    st->init();
   }
 catch(Exception e){d->write(1,"Exception occured");}
}

}
//-------�����ॢ���ȷ�¬��----------------
class CheckLockingTime :* MethodRunnable {
  TransactionResource tr;
  new create(Timer t){ super=>create(t); }
  public void set(TransactionResource atr){tr=atr;}
  protected Root MyMethod(){
   tr->checkLockingTimeBody();return null;
  }
}




