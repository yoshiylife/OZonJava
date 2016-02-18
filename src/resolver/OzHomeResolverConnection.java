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
import JP.go.ipa.oz.system.OzCommAddress;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.util.*;

class OzHomeResolverConnection extends Connection{
 static final int SendByte=100;
 protected long time;
 boolean end;
 OzHomeResolver server;

//-----------CONSTRUCTOR---------------------

public OzHomeResolverConnection(Socket client_socket,OzHomeResolver server){
 super(client_socket);
 this.server=server;
}
//------------------BODY-------------------
public void run(){
 int len;
 String req="",gol="",ip="",ozhomeID="",ozhome="";
 int    port=0;
 OzhomePath others;
 try{
  d=server.d;
  for(;;){//read inputStream
   req=in.readUTF();server.d.println(":"+req); 
   if(req== null)break;
   else if(req.equals("S")){quit();server.quit();}
   else if(req.equals("REQ")){//要求
    if((gol=in.readUTF())!=null){
        ip=in.readUTF();port=in.readInt();//失敗アドレス
        server.d.println(req+":"+ip+","+gol+","+port);
        resolve(gol,ip,port);
      }else throw new Exception("invalid stream from Executor.");
   }
   else if(req.equals("AR")){//OZHOMEからの登録要求
    //サーバへ登録し、クライアントへ返す
    ozhomeID=in.readUTF();ozhome=in.readUTF();
    others=new OzhomePath(ozhomeID,ozhome);
    if(server.addOzhome(others)) out.writeUTF("RA");
    else out.writeUTF("NG");
     out.flush();
   }
   else if(retToEx(req)); //RES,NA from OzDomainResolver
   else if(req.equals("HR")){//OzHomeResolverからの登録要求
    String id;int timeout;
    if((id=in.readUTF())!=null)
     if((ip=in.readUTF())!=null){
      port=in.readInt();timeout=in.readInt();
      server.domainRecept=true;
      //return to OzHomeResolver
      out.writeUTF("RH");out.writeBoolean(true);
      out.flush();
     }else{//HRへ失敗の返答
      out.writeUTF("RH");out.writeBoolean(false);out.flush();
      server.d.println("invalid IP address recept,can't add.");
     }
   }
   else throw new Exception("invalid stream got");
   }//fo
 }catch(EOFException e){;}
 catch(SocketException e){;}
 catch(Exception e){server.d.println(e);}
}
//------GOLを基にアドレス解決しExecutorへ返す-----------------

public void resolve(String gol,String ip,int port){
 server.d.println(" resolve:");
 try{//set data to bo
  Timer timer=new Timer(server.timeout*1000);//timer start
  ComAddr com=null;
  if((com=server.getComAddrOf(gol,ip,port))!=null)
   retRESNoCash(gol,com);//キャッシュを検索
  else{
   GOL g=separateGOL(gol);
   StringTokenizer gt=new StringTokenizer(g.god,".");
   String god="",nt="";
   while(gt.hasMoreTokens()){
     nt=gt.nextToken();
     god=god.concat(server.sp).concat(nt);
   }
//自身のドメイン？
 if(g.domain.equals(server.domain) && server.inOzhomes(g.ozhomeID)){//管理下のOZHOME？
   server.d.println("ozhomeID contained");
   //管理下のGOL?
   if((com=server.getComAddrOf(g.ozhomeID,god))!=null){//実体を検索
     retRES(gol,com);
   }else retNA(gol);
  }else{//自身のドメインでないか管理下のOZHOMEでない
  if(server.domainRecept)
    deligate(server.ozDomainResolver,gol,ip,port);
  else server.addToDomainResolver();
// throw new Exception("So domainResolver wasn't set,can't deligate to it.");
  }
 }//else
 timer.cancel();
 }catch(Exception e){server.d.println(e);}
}
public void addCash(GolCom gc){server.addCash(gc);}
}







