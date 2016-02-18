cell addGroupMember{
protected void initialize(){}
protected void go(){
 System s=>create();
 Array args=>create(2);args=s->getArguments();

 String s0,s1;
 s0=|args->at(0);
 if(s0->isequal("-h"))
  s->println("usage:addGroupMember userGroupName member");
 else{
  OzAuthenticationServer as=>bind("as");s->println("bound");
  s1=|args->at(1);
  as->addGroupMember(s0,s1);
 }
}
protected final void quiet(){flushCell();}
}