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
   else if(req.equals("REQ")){//$BMW5a(B
    if((gol=in.readUTF())!=null){
        ip=in.readUTF();port=in.readInt();//$B<:GT%"%I%l%9(B
        server.d.println(req+":"+ip+","+gol+","+port);
        resolve(gol,ip,port);
      }else throw new Exception("invalid stream from Executor.");
   }
   else if(req.equals("AR")){//OZHOME$B$+$i$NEPO?MW5a(B
    //$B%5!<%P$XEPO?$7!"%/%i%$%"%s%H$XJV$9(B
    ozhomeID=in.readUTF();ozhome=in.readUTF();
    others=new OzhomePath(ozhomeID,ozhome);
    if(server.addOzhome(others)) out.writeUTF("RA");
    else out.writeUTF("NG");
     out.flush();
   }
   else if(retToEx(req)); //RES,NA from OzDomainResolver
   else if(req.equals("HR")){//OzHomeResolver$B$+$i$NEPO?MW5a(B
    String id;int timeout;
    if((id=in.readUTF())!=null)
     if((ip=in.readUTF())!=null){
      port=in.readInt();timeout=in.readInt();
      server.domainRecept=true;
      //return to OzHomeResolver
      out.writeUTF("RH");out.writeBoolean(true);
      out.flush();
     }else{//HR$B$X<:GT$NJVEz(B
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
//------GOL$B$r4p$K%"%I%l%92r7h$7(BExecutor$B$XJV$9(B-----------------

public void resolve(String gol,String ip,int port){
 server.d.println(" resolve:");
 try{//set data to bo
  Timer timer=new Timer(server.timeout*1000);//timer start
  ComAddr com=null;
  if((com=server.getComAddrOf(gol,ip,port))!=null)
   retRESNoCash(gol,com);//$B%-%c%C%7%e$r8!:w(B
  else{
   GOL g=separateGOL(gol);
   StringTokenizer gt=new StringTokenizer(g.god,".");
   String god="",nt="";
   while(gt.hasMoreTokens()){
     nt=gt.nextToken();
     god=god.concat(server.sp).concat(nt);
   }
//$B<+?H$N%I%a%$%s!)(B
 if(g.domain.equals(server.domain) && server.inOzhomes(g.ozhomeID)){//$B4IM}2<$N(BOZHOME$B!)(B
   server.d.println("ozhomeID contained");
   //$B4IM}2<$N(BGOL?
   if((com=server.getComAddrOf(g.ozhomeID,god))!=null){//$B<BBN$r8!:w(B
     retRES(gol,com);
   }else retNA(gol);
  }else{//$B<+?H$N%I%a%$%s$G$J$$$+4IM}2<$N(BOZHOME$B$G$J$$(B
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







