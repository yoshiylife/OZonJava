cell stopAS{
protected void initialize(){}
protected void go(){
 System s=>create();
  OzAuthenticationServer as=>bind("as");s->println("bound");
  as->stop();
}
protected final void quiet(){flushCell();}
}
