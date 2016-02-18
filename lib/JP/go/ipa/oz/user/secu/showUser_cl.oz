cell showUser{
protected void initialize(){}
protected void go(){
 System s=>create();
  OzAuthenticationServer as=>bind("as");s->println("bound");
  as->showUser();
}
protected final void quiet(){flushCell();}
}
