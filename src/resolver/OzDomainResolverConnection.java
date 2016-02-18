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

class OzDomainResolverConnection extends Connection{
 ComAddr comAddr;//comAddr of this    
 OzDomainCom ozDomainResolver;//他のOzDomainResolverのdomain+CommAddr
 OzHomeCom ozHomeResolver;//自身の管理するOZHomeResolverのID+CommAddr
 static final int SendByte=100;
 OzDomainResolver server;
 int timeout;

//------------CONSTRUCTOR-----------------------
public OzDomainResolverConnection(Socket client_socket,OzDomainResolver server){
 super(client_socket);
 this.server=server;
}
//---------------BODY-----------------------
//要求の転送はせずozhomeIDを知っているHRを教えるだけ

public void run(){
 int len;
 String req,gol,domain,ip,id;
 int    port;
 try{
  server.d.println("---start---");
  d=server.d;
  for(;;){//read inputStream
   req=in.readUTF();server.d.println(":"+req); 
   if(req== null)break;
   else if(req.equals("S")){quit();server.quit();}
   else
   if(req.equals("HR")){//OzHomeResolverからの登録要求
    if((id=in.readUTF())!=null)
     if((ip=in.readUTF())!=null){
      port=in.readInt();timeout=in.readInt();
      server.d.println(id+":"+port+" timeout="+timeout);
      ComAddr com=new ComAddr(ip,port);
      ozHomeResolver=new OzHomeCom(id,com);
      server.addOzHomeResolver(ozHomeResolver);
      //return to OzHomeResolver
      out.writeUTF("RH");out.writeBoolean(true);
      out.flush();
     }else{//HRへ失敗の返答
      out.writeUTF("RH");out.writeBoolean(false);out.flush();
      server.d.println("invalid IP address recept,can't add.");
     }
    }else if(req.equals("REQ")){//APGateway or OzHomeResolver
     gol=in.readUTF();ip=in.readUTF();port=in.readInt();
     server.d.println(req+":"+gol+":"+ip+":"+port);
     resolve(gol,ip,port);
    }

    if(server.parent){//親なら
     //子の登録要求を受ける
     if(req.equals("DR")){
      if((domain=in.readUTF())!=null)
      if((ip=in.readUTF())!=null)
       if((port=in.readInt())!=0){
        ozDomainResolver=new OzDomainCom(domain,ip,port);
        server.addOzDomainResolver(ozDomainResolver);
        server.d.println("set OzDomainResolver:"+domain+":"+ip+":"+port);
        //子に登録結果を返す
        out.writeUTF("RD");//out.writeBoolean(true);
	out.writeInt(server.ozDomainResolvers.size()-1);//自身は数にいれない
        out.flush();
        server.d.println("sent DR to slaveDomainResolver:"+domain);
        //他の子に登録情報を渡すとともに今登録した子にも渡す
	server.alarmToOtherDR(ozDomainResolver,out);
       }else{
        out.writeUTF("RD");out.writeBoolean(false);out.flush();
        server.d.println("DR:invalid IP address recept");
       }
     }
    }else{//子なら
     if(req.equals("CH")){//親から登録された子のアドレスを受信
      domain=in.readUTF();ip=in.readUTF();port=in.readInt();
      OzDomainCom dc=new OzDomainCom(domain,ip,port);
      server.addOzDomainResolver(dc);
      server.d.println("other child added:"+domain);
     }//else System.out.println("invalid request:"+req);
    }
   }//for
 }catch(SocketException e){;}
  catch(EOFException e1){;}
  catch(Exception e2){server.d.println(e2);}
}//run

//------------------------------------------------------
public void resolve(String gol,String ip,int port){
 server.d.println("resolve:"+gol+":"+ip+":"+port);
 try{//set data to bo
  Timer timer=new Timer(timeout*1000);//timer start
  ComAddr com=null,hrcom=null;
  if((com=server.getComAddrOf(gol,ip,port))!=null)
   retRESNoCash(gol,com);//キャッシュを検索
  else{
   GOL g=separateGOL(gol);
  //自身のドメイン？ 
  if(g.domain.equals(server.domain)){
   server.d.println("domain matched"); 
   //要求者以外の該当するOzHomeResolverに聞く
  if((hrcom=server.getOzHomeResolver(g.ozhomeID))!=null){
    deligate(hrcom,gol,ip,port);//if REQ or RES or NA
  }
  else{//失敗
    server.d.println("There's no other ozHomeResolver to deligate!");
    retNA(gol);
  }
  }else{//自身のドメインでない
   server.d.println("unmathced to this domain");
   //要求者以外の該当するOzDomainResolverに聞く
   if((hrcom=server.getOzDomainResolver(g.domain))!=null)
    deligate(hrcom,gol,ip,port);//if REQ or RES or NA
   else//自身のサイトでない  
    if(server.parent){
     //APGWのアドレスを返す
     retRES(gol,server.apgw);
     server.d.println("return apgw addr to ozHomeResolver.");
    }
   else//child
    deligate(server.parentResolver,gol,ip,port);
  }
 }
 timer.cancel();
 }catch(Exception e){server.d.println(e);}
}
public void addCash(GolCom gc){server.addCash(gc);}
}



