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
/*
 Runnable class for Transaction
*/
class TranTimer{
 protected bool isDone;
 protected condition end;
 new create(){}
 protected locked void endWait(int time){if(!isDone)wait(end,time);}
 public locked void MethodDone(){isDone=true;signal(end);}
 public TransactionResource invoke(TranRun mr,int time){
  isDone=false;
  Thread t=>create(mr);
  endWait(time);
  if(isDone) return(mr->getResult());
  else{TimeOutException e=>init();throw e;}
 }
}
class TranRun :* Runnable{
 TranTimer timer;
 TransactionResource result;
 Transaction tran;String rg;
 new create(TranTimer t){timer=t;}
 public TransactionResource getResult(){return result;}
 public void run(){
  result=tran->getResource(rg);
  timer->MethodDone();
 }
 public final void set(Transaction tran1,String rg1){tran=tran1;rg=rg1;}
}
//-------FOR BLOCK-------------------------
class TransactionWaitLock : *Runnable{
 Debug d;
 int i;
 Transaction t;
 new create(Transaction tran){d=>create();t=tran;}
 public final void set(int j){i=j;}
 public final void run(){
  condition dummy;
  while(!t->isLock()){
   d->write("waiting");
   wait(dummy,10);//wait 10milli sec
 }
   if(t->isLock())d->write(1," waiting for lock end",t->getLx());
   else d->write(1," waiting for lock not end",t->getLx());
  }
}
