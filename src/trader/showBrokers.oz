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

cell ShowBrokers{
 Debug d;int x;
 protected void initialize(){d=>create();x=1;}
 public  void go(){
  try{
   System s;s=>create();
   Array args=>create(1);
   args=s->getArguments();
   String ozhome;
   ozhome=|args->at(0);

//   d->write(1,"showBroker:",ozhome);
   Trader t=>bind(ozhome);
   t->showBroker();
  }catch(Exception e){d->write(1,"Exception occured.");}
 }
 protected void quiet(){flushCell();}
}
