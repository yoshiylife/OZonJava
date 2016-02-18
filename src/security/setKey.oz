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

cell setKey{
protected void initialize(){}
protected void go(){
 System s=>create();
 Array args=>create(2);args=s->getArguments();

 String userName,keySeed;
 userName=|args->at(0);
 if(userName->isequal("-h"))
  s->println("usage:setKey oldKeySeed newKeySeed");
 else{
  OzAuthenticationServer as=>bind("as");s->println("bound");
  String oldKey,newKey;
  oldKey=|args->at(0);
  newKey=|args->at(1);
  as->setMyKey(oldKey,newKey);
 }
}
protected final void quiet(){flushCell();}
}
