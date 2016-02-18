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

//新しい空の authorized users list を作る。
new create(){
 AuthComparator ac=>create();
 super=>create(ac);
}
new create(String gol){ //for authenticateGroup(),authenticate(groupName)
 asGOL=gol;
 AuthComparator ac=>create();
 super=>create(ac);
}

//そのセルのオーナだけを含んだ authorized users list を作る。
new ownerOnly(){
 super=>create();
 System s=>create();
 this->add(s->getOzHome());
}
public void add(User u){super->add(u);}
public void remove(User u){super->remove(u);}
public Set asSet(){return this;}

/*
 caller user が authorized users list に含まれているか、
 含まれていない場合、例外を上げる。
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
// 同じグループならOK
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



