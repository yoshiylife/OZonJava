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

class Connection :* Runnable{
 OzAuthenticationServer as; 
 Socket client;
 Debug d;int x;//for debug

 new create(Socket client,OzAuthenticationServer as){
  this->as=as;this->client=client;d=>create();x=as->getDebug();
 }

public void run(){
 Debug d=>create();int x=as->getDebug();
 DataInputStream in;DataOutputStream out;
 String req,callerOzHome,calleeOzHome;
 ByteArray b;
 OzKey sessionKey,calleeKey,callerTicketKey,calleeTicketKey;
 Ticket ticket,calleeTicket;
 Date date,edate;//expiration date
 long nonce;
 int len;//転送バイト数

 in=>breed(client->getInputStream());
 out=>breed(client->getOutputStream());
 while(true){
 try{
  if(client->getPort()<0)break;
  req=in->readUTF(); 
  if( req->length()<2 || req==null)break;
  d->write(x,"req=",req);

//--------LOGIN----------
 if(req->isequal("LI")){
  callerOzHome=in->readUTF();//caller's ozhomeID
  b=login(callerOzHome);
  if(b==null){
   d->write(x,"login fault");
   out->writeUTF("ER");out->flush();break;
  }else{
   out->writeUTF("RL");//return Login
   out->writeInt(b->length());//ticket pack
   out->write(b,0,b->length());
   out->flush();
   d->write(x,"--sent RL:",b->length());
  }
 }
//--------GetCredential---------
 else if(req->isequal("GC")){
  callerOzHome=in->readUTF();d->write(x,"callerOzHome=",callerOzHome);
  if(as->isInUsers(callerOzHome)){
  //DECODE
   d->write(x,"callerOzHome found");
   len=in->readInt();d->write(x,"read ticket",len);
   b=>create(len);in->readFully(b);//PTs{Gr,N}
    d->write(x,"got ticket:",len);
   date=>breed();edate=as->getExDate(callerOzHome);
   if(edate==null){d->write(x,"invalid date of callerOzHome");}
    d->write(x,"breed");
   if(edate->getTime()>date->getTime()){//in time
     d->write(x,"ticket is in time");
    OzKey privateKey=as->getTicketKey(callerOzHome);
    if(privateKey==null){
     d->write(x,"couldn't find caller privateKey");
     out->writeUTF("ER");out->flush();break;
    }
    else d->write(x,"got private key of ",callerOzHome);

    CredentialRequest cr=CredentialRequest->unpack(b,privateKey);
    calleeOzHome=cr->getCalleeOzHome();
    nonce=cr->getNonce();
    if(calleeOzHome==null){
     d->write(x,"couldn't got calleeOzHome");
     out->writeUTF("ER");out->flush();break;
    }
    else d->write(x,"calleeOzHome=",calleeOzHome);

   //ENCODE
    //sessionKey=as->getKey(callerOzHome);
    String seed;seed=callerOzHome->concat(date->asString());
    d->write(x,"session key seed=",seed);
    sessionKey=as->getCipher()->getKey(seed);
    if(sessionKey==null){   
     d->write(x,"invalid sessionKey");
     out->writeUTF("ER");out->flush();break;
    }
    else d->write(x,"got sessionKey");
    //有効期限を設定
    date=>breed();edate=>breed(date->getTime()+as->getTicketExTime());
    d->write(x,"set credential edate:",edate->asString());
    Credential c=>breed(callerOzHome,sessionKey,edate);
    d->write(x,"breed credential");
    calleeTicketKey=|as->getTicketKey(calleeOzHome);
     if(calleeTicketKey==null){
      d->write(x,"retry callee ticketKey");
      login(calleeOzHome);
      calleeTicketKey=|as->getTicketKey(calleeOzHome);
      d->write(x,"got callee ticketKey");
     }
     else d->write(x,"got callee ticketKey");
     b=c->pack(calleeTicketKey);//PTr{Gs,SKr,Te}
     d->write(x,"credential packed");
    CredentialPack cp=>breed(b,nonce,sessionKey,edate);
     d->write(x,"breed credential pack");
     callerTicketKey=|as->getTicketKey(callerOzHome);
     if(callerTicketKey==null){
      d->write(x,"retry caller ticketKey");
      login(callerOzHome);
      callerTicketKey=|as->getTicketKey(callerOzHome);
      d->write(x,"got ticketKey callerTicketKey");
     }
     else d->write(x,"got ticketKey callerTicketKey");
     b=cp->pack(callerTicketKey);//PTs{{credential},N,SKr,Te}
     d->write(x,"credentialPack packed");
     out->writeUTF("RC");out->flush();
     out->writeInt(b->length());
     out->write(b,0,b->length());
     d->write(x,"--sent RC:",b->length());
   }
   else{d->write(x,"ticket expired");out->writeUTF("ER");break;}
  }
  else{d->write(x,"caller couldn't found");out->writeUTF("ER");break;}
  out->flush();
 }
//Get GOL
 else if(req->isequal("GG")){
  out->writeUTF("RG");
  out->writeUTF(req->getGOL());d->write(x,"--sent ",req->getGOL());
  out->flush();
 }
 }catch(EOFException e){;}
  catch(IOException e){
   //d->write("IO Exception");
   break;}
  catch(Exception e){
   d->write("Exception");break;}
 }//while
  in->close();out->close();client->close();
}

ByteArray login(String ozHome){
 try{
  Date date,edate;
  User user=as->getUser(ozHome);d->write(x,"ozHome=",ozHome);
  if(user!=null){
   d->write(x,"userName=",user->getName());
  //MAKE Ticket
    d->write(x,"making ticket");
   //ticketの有効期限を設定
   date=>breed();edate=>breed(date->getTime()+as->getTicketExTime());
    d->write(x,"set ticket edate:",edate->asString());
   Ticket ticket=>breed(ozHome,edate);d->write(x,"breed ticket");
   if(ticket==null){d->write(x,"ticket couldn't create");return null;}
   as->addExDate(ozHome,edate);d->write(x,"added ticket");
//   String seed;seed=as->getMyKeySeed->concat(date->asString());
   ByteArray b=ticket->pack(as->getMyKey());//PKa{Gs,Te}
   if(b==null){d->write(x,"pack ticket fault");return null;}
   else d->write(x,"packed");
   OzKey ticketKey=as->getCipher()->getKey(b->asString());
   if(ticketKey==null){d->write(x,"ticket key couldn't create");return null;}
   else d->write(x,"got ticketKey");
   as->addTicketKey(ozHome,ticketKey);
    d->write(x,"made ticket");
  //MAKE TicketPack
   TicketPack tp=>breed(edate,ticketKey);
   if(tp==null){d->write(x,"ticket pack fault");return null;}
   else return tp->pack(as->getKey(ozHome));//PKs{Te,PKa{Gs,Te}}
  }else{
   d->write(1,"user not found.");return null;
  }
 }catch(Exception e){
   d->write(1,"exception occured whil login.");return null;
 }
}
}



