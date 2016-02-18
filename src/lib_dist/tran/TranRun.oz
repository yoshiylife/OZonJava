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
