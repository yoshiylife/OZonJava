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
 OzDomainCom ozDomainResolver;//$BB>$N(BOzDomainResolver$B$N(Bdomain+CommAddr
 OzHomeCom ozHomeResolver;//$B<+?H$N4IM}$9$k(BOZHomeResolver$B$N(BID+CommAddr
 static final int SendByte=100;
 OzDomainResolver server;
 int timeout;

//------------CONSTRUCTOR-----------------------
public OzDomainResolverConnection(Socket client_socket,OzDomainResolver server){
 super(client_socket);
 this.server=server;
}
//---------------BODY-----------------------
//$BMW5a$NE>Aw$O$;$:(BozhomeID$B$rCN$C$F$$$k(BHR$B$r65$($k$@$1(B

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
   if(req.equals("HR")){//OzHomeResolver$B$+$i$NEPO?MW5a(B
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
     }else{//HR$B$X<:GT$NJVEz(B
      out.writeUTF("RH");out.writeBoolean(false);out.flush();
      server.d.println("invalid IP address recept,can't add.");
     }
    }else if(req.equals("REQ")){//APGateway or OzHomeResolver
     gol=in.readUTF();ip=in.readUTF();port=in.readInt();
     server.d.println(req+":"+gol+":"+ip+":"+port);
     resolve(gol,ip,port);
    }

    if(server.parent){//$B?F$J$i(B
     //$B;R$NEPO?MW5a$r<u$1$k(B
     if(req.equals("DR")){
      if((domain=in.readUTF())!=null)
      if((ip=in.readUTF())!=null)
       if((port=in.readInt())!=0){
        ozDomainResolver=new OzDomainCom(domain,ip,port);
        server.addOzDomainResolver(ozDomainResolver);
        server.d.println("set OzDomainResolver:"+domain+":"+ip+":"+port);
        //$B;R$KEPO?7k2L$rJV$9(B
        out.writeUTF("RD");//out.writeBoolean(true);
	out.writeInt(server.ozDomainResolvers.size()-1);//$B<+?H$O?t$K$$$l$J$$(B
        out.flush();
        server.d.println("sent DR to slaveDomainResolver:"+domain);
        //$BB>$N;R$KEPO?>pJs$rEO$9$H$H$b$K:#EPO?$7$?;R$K$bEO$9(B
	server.alarmToOtherDR(ozDomainResolver,out);
       }else{
        out.writeUTF("RD");out.writeBoolean(false);out.flush();
        server.d.println("DR:invalid IP address recept");
       }
     }
    }else{//$B;R$J$i(B
     if(req.equals("CH")){//$B?F$+$iEPO?$5$l$?;R$N%"%I%l%9$r<u?.(B
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
   retRESNoCash(gol,com);//$B%-%c%C%7%e$r8!:w(B
  else{
   GOL g=separateGOL(gol);
  //$B<+?H$N%I%a%$%s!)(B 
  if(g.domain.equals(server.domain)){
   server.d.println("domain matched"); 
   //$BMW5a<T0J30$N3:Ev$9$k(BOzHomeResolver$B$KJ9$/(B
  if((hrcom=server.getOzHomeResolver(g.ozhomeID))!=null){
    deligate(hrcom,gol,ip,port);//if REQ or RES or NA
  }
  else{//$B<:GT(B
    server.d.println("There's no other ozHomeResolver to deligate!");
    retNA(gol);
  }
  }else{//$B<+?H$N%I%a%$%s$G$J$$(B
   server.d.println("unmathced to this domain");
   //$BMW5a<T0J30$N3:Ev$9$k(BOzDomainResolver$B$KJ9$/(B
   if((hrcom=server.getOzDomainResolver(g.domain))!=null)
    deligate(hrcom,gol,ip,port);//if REQ or RES or NA
   else//$B<+?H$N%5%$%H$G$J$$(B  
    if(server.parent){
     //APGW$B$N%"%I%l%9$rJV$9(B
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



