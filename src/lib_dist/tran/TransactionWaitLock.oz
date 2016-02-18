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
