cell removeGroup{
protected void initialize(){}
protected void go(){
 System s=>create();
 Array args=>create(1);args=s->getArguments();

 String s0;
 s0=|args->at(0);
 if(s0->isequal("-h"))
  s->println("usage:removeGroup groupName");
 else{
  OzAuthenticationServer as=>bind("as");s->println("bound");
  as->removeGroup(s0);
 }
}
protected final void quiet(){flushCell();}
}