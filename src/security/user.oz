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

class User{
 String name;
 OzKey key;//秘密鍵
 Date  edate; 
 OzKey ticketKey;//ticketをOzKey化したもの
 new create(String name,OzKey key){
  this->name=name;this->key=key;
 }
 public String getName(){return name;}
 public OzKey getKey(){return key;}
 public void setExDate(Date edate){this->edate=edate;}
 public Date getExDate(){return edate;}
 public void setTicketKey(OzKey ticketKey){this->ticketKey=ticketKey;}
 public OzKey getTicketKey(){return ticketKey;}
}

class UserGroup{
 protected String name;
 protected String owner;
 protected Set members;//String userNameを要素とする集合

new create(String name,String owner,Set users){
  this->name=name;this->owner=owner;
  StringComparator sc; sc=>create();
  members=>create(sc);
  members=|users;
}
public String getName(){return name;}
public String getOwner(){return owner;}
public Set getMembers(){return members;}

public void changeOwner(String newOwner){
 if(newOwner!=null)owner=newOwner;
}
public void addMember(String user){
 if(!members->contains(user))members->add(user);
}
//メンバーの追加、既にメンバーなら何も起こらない
public void addMembers(Set users){
  Iterator it=users->iterator();
  String user;
  while(it->hasMoreElements()){
    user=|it->nextElement();
    addMember(user);
  }
}
public void removeMember(String user){
 if(members->contains(user))members->remove(user);
}
public void removeMembers(Set users){
  Iterator it=users->iterator();
  String user;
  while(it->hasMoreElements()){
    user=|it->nextElement();
    removeMember(user);
  }
}
public void showMembers(){
  Iterator it=members->iterator();
  String user;System s=>create();
  while(it->hasMoreElements()){
    user=|it->nextElement();
    s->println(user);
  }
}
public bool contains(String name){
 if(members->contains(name))return true;
 else return false;
}
}

class StringComparator : Comparator{
 new create(){}
 public boolean compare(Root t1,Root t2){
  String a1,a2;a1=|t1;a2=|t2;
  if(a1->isequal(a2))return true;
  else return false;
 }
 public Comparator duplicate (){return this;}
 public int hash (Root t){return 0;}
}




