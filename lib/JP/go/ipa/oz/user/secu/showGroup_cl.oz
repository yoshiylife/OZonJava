cell showGroup{
protected void initialize(){}
protected void go(){
 System s=>create();
  OzAuthenticationServer as=>bind("as");s->println("bound");
  as->showGroup();
}
protected final void quiet(){flushCell();}
}
