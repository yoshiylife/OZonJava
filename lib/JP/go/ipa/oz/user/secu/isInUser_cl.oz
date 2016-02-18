cell isInUser{
protected void initialize(){}
protected void go(){
 System s=>create();
 OzAuthenticationServer as=>bind("as");
 s->println("bound");
 as->addUser("testUser","mypasswd");
 if(as->isInUsers("testUser"))s->println("found");
}
protected final void quiet(){flushCell();}
}
