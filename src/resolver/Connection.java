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
package JP.go.ipa.oz.user.res;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.util.*;

class Connection extends Thread{
 protected Socket client;
 protected DataInputStream in;
 protected DataOutputStream out;
 protected Debug d;

public Connection(Socket client_socket){
 try { 
  client = client_socket; 
  in = new DataInputStream(client.getInputStream());
  out = new DataOutputStream(client.getOutputStream());
 }
 catch (IOException e) {
     try { client.close(); } catch (IOException e2) { ; }
     System.err.println("Exception while getting socket streams: " + e);
     return;
 }
 this.start();
}
public void run(){
 //must be overriden
}
public void quit() throws Exception{
 in.close();out.close();
}

//------------------return to executor-----------------------

protected void retRES(String gol,ComAddr com) throws Exception{
 retRES(gol,com.ip,com.port);
}
protected void retRESNoCash(String gol,ComAddr com) throws Exception{
 retRESNoCash(gol,com.ip,com.port);
}
protected void retRES(String gol,String ip,int port) throws Exception{
 retRESNoCash(gol,ip,port);
 GolCom gc=new GolCom(gol,ip,port);addCash(gc);
}
protected void retRESNoCash(String gol,String ip,int port) throws Exception{
    out.writeUTF("RES");out.writeUTF(gol);
    out.writeUTF(ip);out.writeInt(port);
    out.flush();
    d.println("return RES:"+gol+":"+port);
}
protected void retNA(String gol) throws Exception{
    //そのままExecutorへ返す
    out.writeUTF("NA");out.writeUTF(gol);out.flush();
    d.println("return NA to executor");
}

//他のResolverに要求を委譲し、結果をExecutorに返す
public void deligate(ComAddr hrcom,String gol,String ip,int port){
 try{
  Socket socket=new Socket(hrcom.ip,hrcom.port);
  DataOutputStream o=new DataOutputStream(socket.getOutputStream());
   o.writeUTF("REQ");o.writeUTF(gol);
   o.writeUTF(ip);o.writeInt(port);o.flush();
   d.println("sent REQ:"+gol+" to "+hrcom.port);
  DataInputStream din=new DataInputStream(socket.getInputStream());
  String req;GolCom gc;
  for(;;){//OzHomeResolverからの返答を待つ
   req=din.readUTF();d.println("|"+req); 
   if(req== null)break;
   else if(retToEx(req,din))break;
  }//for
    d.println("sent ComAddr to another ozHomeResolver.");
 }catch(Exception e){d.println(e);}
}
public boolean retToEx(String req) throws Exception{
 return retToEx(req,in);
}
public boolean retToEx(String req,DataInputStream din) throws Exception{
   String gol="",ip="";int port;
   if(req.equals("RES")){//OzHomeResolverからの返答：成功
    //そのままExecutorへ返す
    gol=din.readUTF();ip=din.readUTF();port=din.readInt();
    retRES(gol,ip,port);
    return true;
   }else if(req.equals("NA")){//OzDomainResolverからの返答：失敗
    retNA(gol);
   return true;
   }
  return false;
}
protected void addCash(GolCom gc){}

//GOLを分解する
public GOL separateGOL(String gol) throws Exception{
  StringTokenizer st=new StringTokenizer(gol,":"); 
  String domain="",ozhome="",god="";
  if(st.hasMoreTokens())domain=st.nextToken();
   else throw new Exception("GOL of domain in request didn't find");
  if(st.hasMoreTokens())ozhome=st.nextToken();
   else throw new Exception("GOL of ozhomeID in request didn't find");
  if(st.hasMoreTokens())god=st.nextToken();
   else throw new Exception("GOL of god in request didn't find");
  d.println(" GOL="+domain+":"+ozhome+":"+god);
  GOL sgol=new GOL(domain,ozhome,god);
  return sgol;
}
}




