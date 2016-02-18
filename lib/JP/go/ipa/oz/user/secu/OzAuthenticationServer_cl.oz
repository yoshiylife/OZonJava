/*
 Copyright(c) 1996-1998
 IPA, ETL, AT21, FSIABC, FXIS, InArc, MRI, NUL, SBC, Sharp, TEC, TIS

 All rights reserved.  No guarantee.
 This technology is a result of the Advanced Software Enrichment 
 Project of Information-technology Promotion Agency, Japan (IPA).

 Permissions to use, copy, modify and distribute this software
 are governed by the terms and conditions set forth in the file 
 COPYRIGHT, located on the top directory of this software.
*/

//----------認証サーバ----------------------------

cell OzAuthenticationServer :* Stoppable{
 int port;//port of this
 Set users; //Set of User:userName,key
 Set userGroups;//Set of UserGroup:name,owner,members
 OzCipher cipher;
 OzCipher DEScipher;
 OzKey myKey;//key of own
 String myKeySeed;
 Debug d;int x;//for debug
 int TicketExTime;//[min]ticket expiration time
 long ticketExTime;//millisec to min
 String version;
 String userFile,groupFile,god;
 String myOzHome;

public long getTicketExTime(){return ticketExTime;}
public OzCipher getCipher(){return cipher;}

protected void initialize(){
try{
 version=" OzAuthenticationServer Ver.0.2.0";
 d=>create();x=1;d->write(x,version);d->setP("as:");
 TicketExTime=30;//[min]ticket expiration time
 ticketExTime=TicketExTime*1000*60;//millisec to min

 System s=>create();
 Array args=>create(3);args=s->getArguments();
 String ozhome,sp,st;//USAGE $OZHOME unix[nt] [d]
 ozhome=|args->at(0);d->write(x,"ozhome=",ozhome);
 sp=|args->at(1);d->write(x,"OS=",sp);
 if(sp->isequal("unix"))sp="/";else sp="\\";
 st=|args->at(2);if(st->isequal("d"))x=1;else x=0;d->write(x,"x=",x);
 god="";god=god->concat(ozhome)->concat(sp)->concat("objects")->concat(sp)->concat(god->getGOD())->concat(sp);
 userFile=god->concat("users");groupFile=god->concat("groups");
 d->write(x,"userFile=",userFile);d->write(x,"groupFile=",groupFile);

 ASProperty asp=>create(ozhome,sp);
 port=asp->getPort();d->write(x,"port=",port);
 String sCipher=asp->getCipher();d->write(x,"cipher=",sCipher);
 cipher=OzCipher->getCipher(sCipher);
 DEScipher=OzCipher->getCipher("JP.go.ipa.oz.crypt.DES.OzDESCipher");
 //load user info from file
 users=>create();userGroups=>create();
 try{if((users=load(userFile))==null)
  users=>create();d->write(1,"created users");}
  catch(Exception e){users=>create();d->write(1,"created users");}
 try{if((userGroups=load(groupFile))==null)
  userGroups=>create();d->write(1,"created userGroups");}
  catch(Exception e){userGroups=>create();d->write(1,"created userGroups");}
 myKeySeed="oz.authentication.server";
 myKey=cipher->getKey(myKeySeed);
 GetOzHome g=>create(s->getGOL());
 myOzHome=g->getOzHome();d->write(x,"myOzHome=",myOzHome);
 Password p=>create(ozhome,sp);
 addSelf(myOzHome,p->getPasswd());d->write(x,"passwd=",p->getPasswd());
 }catch(Exception e){d->write(1,"exception coccured in initialize");}
}
protected void go(){
 try{
 d->write(1,"OzAuthenticationServer start");
 server(port,this);
 }catch(Exception e){;}
}
//---------------------------------------------------------
//public void authenticateRoot(String s){}

public void authenticateRoot(String s){
 String caller=OzCipher->getCallerOzHome();
 if(!myOzHome->isequal(caller)){
 d->write(x,"UnknownRoot:",caller,s);
 UnknownUserException e=>init();throw e;
 }
 else d->write(x,"Root authorized:",caller,s);
}

//public void authenticate(String s){}

public void authenticate(String s){
 String caller=OzCipher->getCallerOzHome();
 if(!myOzHome->isequal(caller)){
 if(!isInUsers(caller)){
  d->write(x,"UnknownUser:",caller,s);
  UnknownUserException e=>init();throw e;
 }
 } else d->write(x,"authorized:",caller,s);
}

public void setMyKey(String oldKeySeed,String newKeySeed){
 authenticateRoot("setMyKey");
 if(oldKeySeed->isequal(myKeySeed)){
 myKeySeed=newKeySeed;myKey=cipher->getKey(newKeySeed);
 d->write(1,"key changed");
 }else d->write(1,"invalid key seed,couldn't change key.");
}

public void setTicketExTime(int time){ticketExTime=time*1000*60;}

protected final void quiet(){flushCell();stopCell();}

public void stop(){
 authenticateRoot("stop");
 d->write(x,"--stop--");
 save(userFile,users); save(groupFile,userGroups);
 d->write(1,"OzAuthenticationServer stop");
 quiet();
}

void server(int port,OzAuthenticationServer as){
 Server server=>create(port,as);Thread t=>create(server);
}

public int getDebug(){return x;}

public OzKey getMyKey(){
 authenticateRoot("getMyKey");
 return myKey;
}
public OzKey createKey(String str){
 return cipher->getKey(str);
}
public OzKey getKey(String ozhomeID){
 authenticateRoot("getKey");
 //search key matchies to ozhomeID=userName
 User user=getUser(ozhomeID);
 if(user!=null) return user->getKey();
 else return null;
}
public bool isAuthenticated(String ozhomeID,OzKey ticketKey){
 //ticketがマッチしたらtrue
 authenticateRoot("isAuth");
 User user=getUser(ozhomeID);
 //Ticketの比較
 if(user->getTicketKey()==ticketKey)return true;
 else return false;
}
//-------------ユーザ／グループ管理---------------
public OzKey getTicketKey(String name){
 authenticateRoot("getTK");
 User user=getUser(name);
 if(user!=null)return user->getTicketKey();
 else return null;
}

public void showUser(){
 authenticate("showUser");
 d->write(1,"--showUser--");
 if(users->size()>0){
 User user;
 Iterator it;it=users->iterator();
 while(it->hasMoreElements()){
  user=|it->nextElement();
  d->write(1,user->getName());
 }
 }
}
public User getUser(String name){
 authenticate("getUser");
 if(users->size()>0){
 User user;
 Iterator it;it=users->iterator();
 while(it->hasMoreElements()){
  user=|it->nextElement();
//  d->write(x,"getUser:",user->getName());
  if(name->isequal(user->getName())){
//  d->write(x,"found ",user->getName());
  return user;
  }
 }
 }
 return null;
}
public bool isInUsers(String name){
 authenticate("isInUsers");
 if(getUser(name)==null)return false;
 else return true;
}
public UserGroup getUserGroup(String name){
 authenticate("getUserGroup");
// d->write(x,"getUserGroups:",name,userGroups->size());
 if(userGroups->size()>0){
 UserGroup userGroup;
 Iterator it;it=userGroups->iterator();
 while(it->hasMoreElements()){
  userGroup=|it->nextElement();
// d->write(x,"getUserGroup=",userGroup->getName());
  if(name->isequal(userGroup->getName()))
  return userGroup;
 }
 }
 return null;
}
public void showGroup(){
 authenticateRoot("showGroup");
 d->write(1,"--showGroup--");
 if(userGroups->size()>0){
 UserGroup userGroup;
 Iterator it;it=userGroups->iterator();
 while(it->hasMoreElements()){
  userGroup=|it->nextElement();
  d->write(x,"Group:",userGroup->getName());
  showGroupMembers(userGroup->getName());
 }
 }
}
public bool isInUserGroups(String name){
 authenticate("isInUserGroup");
// d->write(x,"isInUserGroups:");
 if(getUserGroup(name)==null)return false;
 else return true;
}
public bool isInGroupMembers(String groupName,String member){
 authenticate("isInGroupMembers");
 if(userGroups->size()>0){
 UserGroup group=getUserGroup(groupName);
 if(group!=null)
  return group->contains(member);
 }
 return false;
}
//２者が１つでも同じグループに属していれば真
public bool isSameGroup(String member1,String member2){
 authenticate("isSameGroup");
 if(userGroups->size()>0){
 UserGroup userGroup;
 Iterator it;it=userGroups->iterator();
 while(it->hasMoreElements()){
  userGroup=|it->nextElement();
  if(userGroup->contains(member1))
  if(userGroup->contains(member2))return true;
 }
 }
 return false;
}
public void showGroupMembers(String name){
 authenticateRoot("showGroupMembers");
 d->write(x,"showGroupMembers:");
 if(userGroups->size()>0){
 UserGroup group=getUserGroup(name);
 group->showMembers();
 }
 d->write(1,"showGroupMembers:no groups");
}
//------------ADD/REMOVE Users ----------------

void addSelf(String userName,String keySeed){
 OzKey key=cipher->getKey(keySeed);
 add(userName,key);
}
public void addUser(String userName,String keySeed){
 d->write(x,"addUser:",userName);
 authenticateRoot("addUser");
 OzKey key=cipher->getKey(keySeed);
 add(userName,key);
}
void add(String userName,OzKey key){
 try{
 if(isInUsers(userName)){
  AlreadyRegisteredUserException e =>init();throw e;
 }
 User newUser=>create(userName,key);
 users->add(newUser);
 d->write(1,"added:",userName);
 }catch(Exception e){;}
}
public void addExDate(String userName,Date edate){
 authenticateRoot("addExDate");
 try{
 User user=getUser(userName);
 if(user!=null)
  user->setExDate(edate);
 else{
  d->write(1,"Unknown User");
  UnknownUserException e =>init();throw e;
 }
 }catch(Exception e){;}
}
public Date getExDate(String userName){
 authenticateRoot("getExDate");
 try{
 User user=getUser(userName);
 if(user!=null)
  return user->getExDate();
 else{
  d->write(1,"Unknown User");
  UnknownUserException e =>init();throw e;
 }
 }catch(Exception e){return null;}
}
public void addTicketKey(String userName,OzKey ticketKey){
 authenticateRoot("addTicketKey");
 try{
 User user=getUser(userName);
 if(user!=null)
  user->setTicketKey(ticketKey);
 else{
  d->write(1,"Unknown User");
  UnknownUserException e =>init();throw e;
 }
 }catch(Exception e){;}
}
public void remove(String userName){
 authenticateRoot("remove");
 d->write(x,"remove:",userName);
 try{
 User user=getUser(userName);
 if(user!=null){
  users=|users->remove(user); d->write(1,"removed:",userName);
  //UserGroupsへ反映
  Iterator it;it=userGroups->iterator();
  UserGroup group;
  while(it->hasMoreElements()){
   group=|it->nextElement();
   if(group->contains(userName)){
   d->write(x,"userName found");
   group->removeMember(userName);
   }
  }
  }else{
  d->write(1,"UnknownUser");
  UnknownUserException e=>init();throw e;
  }
  //特権ユーザ以外の起動：SecurityException;
 }catch(Exception e){;}
}
public OzKey changeKey(String userName,String keySeed){
 authenticateRoot("changeKey");
 OzKey key=cipher->getKey(keySeed);
 return changeKey(userName,key);
}
public OzKey changeKey(String userName,OzKey newKey){
 authenticateRoot("changeKey2");
 try{
 User user=getUser(userName);
 if(user!=null){
  OzKey oldKey=user->getKey();
  users=|users->remove(user);
  User newUser=>create(userName,newKey);
  users->add(newUser);
  d->write(x,"keyChanged");
  return oldKey;
  }else{
  UnknownUserException e=>init();throw e;
  }
 }catch(Exception e){return null;}
}
//------------ADD/REMOVE UserGroups ----------------

public void addGroup(String groupName,String owner,Set members){
 authenticateRoot("addGroup");
 d->write(x,"addGroup");
 try{ 
 if(isInUserGroups(groupName)){
  AlreadyRegisteredUserException e=>init();throw e;
 }
 else{
  if(isInUsers(owner)){
  UserGroup newUserGroup=>create(groupName,owner,members);
  userGroups->add(newUserGroup);
  }else{
  d->write(x,"owner desn't exist in users");
  UnknownUserException e=>init();throw e;
  }
 }
 }catch(Exception e){d->write(1,"AlreadyRegisteredUserException");}
}

public void removeGroup(String groupName){
 authenticateRoot("removeGroup");
 d->write(x,"removeGroup:",groupName);
 try{
 UserGroup group=getUserGroup(groupName);
 if(group!=null){
  userGroups->remove(group);
  d->write(1,"group removed:",groupName);
 }
 else{
  d->write(1,"UnknownUserException");
  UnknownUserException e=>init();throw e;
 }
 }catch(Exception e){;} 
}
public void addGroupMember(String groupName,String member){
 authenticateRoot("addGroupMember");
 try{
 UserGroup group=getUserGroup(groupName);
 if(group!=null){
  group->addMember(member);
  d->write(1,"added",member);
 }
 }catch(Exception e){;} 
}
public void addGroupMembers(String groupName,Set members){
 authenticateRoot("addGroupMembers");
 try{
 UserGroup group=getUserGroup(groupName);
 if(group!=null)
  group->addMembers(members);
 }catch(Exception e){;} 
}
public void removeGroupMember(String groupName,String member){
 authenticateRoot("removeGroupMember");
 try{
 UserGroup group=getUserGroup(groupName);
 if(group!=null)
  group->removeMember(member);
 }catch(Exception e){;} 
}
public void removeGroupMembers(String groupName,Set members){
 authenticateRoot("removeGroupMembers");
 try{
 UserGroup group=getUserGroup(groupName);
 if(group!=null){
  group->removeMembers(members);
  d->write(x,"members removed in group:",groupName);
 }
 }catch(Exception e){;} 
}
public void changeOwner(String groupName,String newOwner){
 authenticateRoot("changOwner");
 try{
 UserGroup group=getUserGroup(groupName);
 if(group!=null){
  group->changeOwner(newOwner);
  d->write(x,"owner changed");
 }
 }catch(Exception e){;} 
}
//--------属性の保存----------------------------------

void save(String fileName,Set sets){
 try{
  FileOutputStream fs;fs=>breed(fileName);
  ObjectOutputStream os;os=>breed(fs);
  os->writeObject(sets);os->flush();fs->close();
  d->write(x,"resource saved to ",fileName);
 }catch(Exception e){d->write(1,"Exception occured");}
}
Set load(String fileName){
 try{
  Set sets=>create();
  File f=>breed(userFile);
  if(f->exists()){
   FileInputStream fs;fs=>breed(userFile);
   ObjectInputStream os;os=>breed(fs);
   if(os!=null)sets=|os->readObject();return sets;
  }else{d->write(1," could not find:",fileName);return null;}
 }catch(IOException e){d->write(1,"IOException. cannot load.");return null;}
 catch(ClassNotFoundException e){
  d->write(1,"ClassNotFoundException. cannot load");return null;}
 catch(Exception e){d->write(1,"Exception occured");return null;}
}

}


