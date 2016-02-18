cell changeKey{
protected void initialize(){}
protected void go(){
 System s=>create();
 Array args=>create(2);args=s->getArguments();

 String userName,keySeed;
 userName=|args->at(0);
 if(userName->isequal("-h"))
  s->println("usage:changeKey userName keySeed");
 else{
  OzAuthenticationServer as=>bind("as");s->println("bound");
  keySeed=|args->at(1);
  as->changeKey(userName,keySeed);
 }
}
protected final void quiet(){flushCell();}
}