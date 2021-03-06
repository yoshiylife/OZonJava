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
