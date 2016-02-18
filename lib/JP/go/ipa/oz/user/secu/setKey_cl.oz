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
