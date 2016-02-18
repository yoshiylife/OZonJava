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
class AccessControlList :*Set{
 String asGOL;

//$B?7$7$$6u$N(B authorized users list $B$r:n$k!#(B
new create(){
 AuthComparator ac=>create();
 super=>create(ac);
}
new create(String gol){ //for authenticateGroup(),authenticate(groupName)
 asGOL=gol;
 AuthComparator ac=>create();
 super=>create(ac);
}

//$B$=$N%;%k$N%*!<%J$@$1$r4^$s$@(B authorized users list $B$r:n$k!#(B
new ownerOnly(){
 super=>create();
 System s=>create();
 this->add(s->getOzHome());
}
public void add(User u){super->add(u);}
public void remove(User u){super->remove(u);}
public Set asSet(){return this;}

/*
 caller user $B$,(B authorized users list $B$K4^$^$l$F$$$k$+!"(B
 $B4^$^$l$F$$$J$$>l9g!"Nc30$r>e$2$k!#(B
*/
public void authenticate(){
 if(!contains(OzCipher->getCallerOzHome())){
  UnknownUserException e=>init();throw e;
 }
}
public void authenticate(String groupName){
 authenticate();
 OzAuthenticationServer as=>bind(asGOL);
 if(!as->isInGroupMembers(groupName,OzCipher->getCallerOzHome())){
  UnknownUserException e=>init();throw e;
 }
}
// $BF1$8%0%k!<%W$J$i(BOK
public void authenticateSameGroup(){
 authenticate(); System s=>create();
 OzAuthenticationServer as=>bind(asGOL);
 if(as->isSameGroup(s->getOzHome(),OzCipher->getCallerOzHome())){
  UnknownUserException e=>init();throw e;
 }
}
}

class AuthComparator : Comparator{
 new create(){}
 public final boolean compare(Root t1,Root t2){
  String a1,a2;a1=|t1;a2=|t2;
  if(a1->isequal(a2))return true;
  else return false;
 }
 public final Comparator duplicate(){return this;}
 public final int hash (Root t){return 0;}
}



