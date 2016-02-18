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

cell addGroup{
protected void initialize(){}
protected void go(){
 System s=>create();
 Array args=>create(2);args=s->getArguments();

 String s0,s1,s2;
 s0=|args->at(0);
 if(s0->isequal("-h"))
  s->println("usage:addGroup userGroupName owner members");
 else{
  OzAuthenticationServer as=>bind("as");s->println("bound");
  s1=|args->at(1);
  s2=|args->at(2);
  Set set=>create();set->add(s2);
  as->addGroup(s0,s1,set);
 }
}
protected final void quiet(){flushCell();}
}