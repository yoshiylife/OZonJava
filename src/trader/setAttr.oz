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

cell SetAttr{
 Debug d;int x;
 protected void initialize(){d=>create();x=1;}
 public  void go(){
  try{
   System s;s=>create();
   Array args=>create(3);args=s->getArguments();
   int intervalTime,timeOut;
   String st,ozhome;
    ozhome=|args->at(0);//d->write(x,ozhome);
    st=|args->at(1);intervalTime=st->parseInt();//d->write(x,st);
    st=|args->at(2);timeOut=st->parseInt();//d->write(x,st);

//   TraderStub ts=>create(ozhome);Trader t=ts->getTrader();    
   Trader t=>bind(ozhome);
   t->setIntervalTime(intervalTime);
   t->setTimeOut(timeOut);
   d->write(x,"intervalTime was set:",t->getIntervalTime());
   d->write(x,"TimeOut was set:",t->getTimeOut());

  }catch(Exception e){d->write(1,"Exception occured.");}
 }
 protected void quiet(){flushCell();}
}

cell AddCoTrader{
 Debug d;int x;
 protected void initialize(){d=>create();x=1;}
 public  void go(){
  try{
   System s;s=>create();
   Array args=>create(2);
   args=s->getArguments();
   String tr,ozhome;
   ozhome=|args->at(0);tr=|args->at(1);

//   TraderStub ts=>create(ozhome);Trader t=ts->getTrader();
   Trader t=>bind(ozhome);
   t->addCoWorkingTraders(tr);
  }catch(Exception e){d->write(1,"Exception occured.");}
 }
 protected void quiet(){flushCell();}
}

