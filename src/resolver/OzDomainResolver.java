/*
 Copyrightx(c) 1996-1998
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

final class OzDomainResolver extends Server{
 int SendByte=100;
 int InitTime=30000;//[milli sec]initializing timeout for $BEPO?(B
 int MaxConncection=1000;

 ComAddr comAddr;//comAddr of this    
 ComAddr parentResolver;
 ComAddr apgw;//Application Gate Way

 Vector ozDomainResolvers;//$BB>$N(Bdomain$B$H(BOzDomainResolver$B$N(BComAddr:OzDomainCom
 Vector ozHomeResolvers;//$B4IM}$9$k(BOzHomeName$B$H(BOZHomeResolver$B$N(BComAddr:OzHomeCom
 public boolean parent;//$B?F$J$i(Btrue
 String OZHOME;
 String domain;
 Vector ozHomeIDcash;//$B%-%c%C%7%e!'8!:wBP>](BozhomeID+OzHomeResolver$B$N(BID


//-------------------MAIN------------------

public static void main(String[] args){
 try{
  String domain="",apgwAddr="d",parentAddr="d";
  int port;boolean parent=false,debug=false;
//args=domain,port,apgw[,d]
//args=domain,port,-p,parent[,d]
  if(args.length>=2){
    domain=args[0];
    port=Integer.parseInt(args[1]);
   if(args.length>=3){
    if(args[2].equals("-p")){
      parentAddr=args[3];
      if(args.length==5 && args[4].equals("d"))debug=true;
    }
    else{
     if(args[2].equals("d"))debug=true;
     else if(!args[2].equals(null))apgwAddr=args[2];
     if(args.length==4 && args[3].equals("d"))debug=true;}
   }
//System.out.println("domain="+domain+" port="+port+" apgwAddr="+apgwAddr+" debug="+debug);
    new OzDomainResolver(domain,port,apgwAddr,parentAddr,debug);
  }
  else{System.out.println("invalid argument");}
 }catch(Exception e){
  System.out.println(e);
 }
}
//--------------------------------------------------------
protected void saveStatus(){//stop$BD>A0$K8F$P$l$k(B
 saveObject("ozdr.hr",ozHomeResolvers);
 saveObject("ozdr.dr",ozDomainResolvers);
}
protected void loadStatus(){
 if((ozHomeResolvers=(Vector)loadObject("ozdr.hr"))==null)
  ozHomeResolvers=new Vector();
  d.println("ozdr.hr loaded:"+ozHomeResolvers.size());
 if((ozDomainResolvers=(Vector)loadObject("ozdr.dr"))==null)
  ozDomainResolvers=new Vector();
  d.println("ozdr.dr loaded:"+ozDomainResolvers.size());
}
//----------CONSTRUCTOR------------------
OzDomainResolver(String domain,int port,String apgwAddr,String parentAddr,boolean debug){
 super();
 try{
  d=new Debug(debug);   
  loadStatus();loadCash("ozdr.cashe");
  this.domain=domain;
  comAddr=new ComAddr(InetAddress.getLocalHost().getHostAddress(),port);
  if(parentAddr.equals("d")){parent=true;
   if(!apgwAddr.equals("d")){
    apgw=getComAddr(apgwAddr);d.println("apgw="+apgw.ip+":"+apgw.port);
   }
  }else{
   parent=false;parentResolver=getComAddr(parentAddr);
   d.println("parent="+parentResolver.ip+":"+parentResolver.port);
  }
  d.println("OzDomainResolver:"+"parent="+parent);
  d.println("domain="+domain+" port="+port+" apgwAddr="+apgwAddr);
//------------
  Timer timer=new Timer(InitTime);//timer start
  if(!parent){//$B;R$J$i?F$KEPO?(B
   Socket socket=new Socket(parentResolver.ip,parentResolver.port);//to send
   DataOutputStream op=new DataOutputStream(socket.getOutputStream());
   op.writeUTF("DR"); op.writeUTF(this.domain);
   op.writeUTF(comAddr.ip);op.writeInt(comAddr.port);
   d.println("sent to DR:From "+comAddr.ip+":"+comAddr.port+"to"+parentResolver.ip+":"+parentResolver.port);
   //$BEPO?$5$l$k$^$GBT$D(B
   DataInputStream din = null;
   din = new DataInputStream(socket.getInputStream());
   String req;boolean b=false;
   d.println("waiting for parent DomainResolver");
   for(;;){
    req=din.readUTF();d.println(req); 
    if(req.equals(null))break;
    else if(req.equals("RD")){//from OzDomainResolver     
    int others=0;
    if((others=din.readInt())>=0){//$BB>$N;R$N?t(B
     d.println("ComAddr of this(child) added.others="+others);
     String otherDomain,ip;int tport;
     for(int i=0;i<others;i++){//$BB>$N;R$N%"%I%l%9$r<+?H$KEPO?(B
      if((otherDomain=din.readUTF())==null)break;
      ip=din.readUTF();tport=din.readInt();
      OzDomainCom odc=new OzDomainCom(otherDomain,ip,port);
      ozDomainResolvers.addElement(odc);
      d.println("parent added other DR:"+otherDomain);
     }
     op.close();//$BEPO?$5$l$?$N$G%;%C%7%g%s$r@Z$k(B
     break;
    }else{//$BB>$N;R$N?t(B<0
     d.println("parent couldn't add this(child)");
     break;
    }
   }//DR
  }//for
  din.close();d.println("Connection closed");
 }else 
  d.println("---waiting for add from ozhr or ozdrs.");
  super.newListen(comAddr.port);
  this.start();
  timer.cancel();
 }catch(Exception e){System.out.println(e);
 }
}

ComAddr getComAddr(String s){
 String tip="",tport="";
 StringTokenizer st=new StringTokenizer(s,"=:\n");
 try{
  if(st.hasMoreTokens()){
   tip=st.nextToken();
   if(tip!=null)tport=st.nextToken();
    if(tport!=null){
      ComAddr com=new ComAddr(tip,Integer.parseInt(tport));return com;
    }
  }
  throw new Exception("invalid format:"+s);
 }catch(Exception e){System.out.println(e);return null;}
}

//$BB>$N;R(BDR$B$KEPO?$7$?;R(BDR$B$N%"%I%l%9$rDLCN(B
synchronized void alarmToOtherDR(OzDomainCom cdr,DataOutputStream o2){
 OzDomainCom dr;
 try{
 d.println("alarmToOtherDR kicked:"+cdr.domain);
 int j=0;Socket s,s2;DataOutputStream o=null;
 for(int i=0;i<ozDomainResolvers.size();i++){
  dr=(OzDomainCom)ozDomainResolvers.elementAt(i);
  d.println("added domain="+dr.domain);
  if(!dr.domain.equals(cdr.domain)){
  //$BB>$N;R$K:#EPO?$7$?;R$N%"%I%l%9$rEO$9(B
  d.println("goint to send to "+dr.domain);
   s=new Socket(dr.com.ip,dr.com.port);//to send
   o=new DataOutputStream(s.getOutputStream());
   o.writeUTF("CH");o.writeUTF(cdr.domain);
   o.writeUTF(cdr.com.ip);o.writeInt(cdr.com.port);
   o.flush();o.close();
   d.println("sent slave just added domain:"+cdr.domain+" to "+dr.domain);
  //$B:#EPO?$7$?;R$KB>$N;R$N%"%I%l%9$rEO$9(B
  d.println("goint to send to "+cdr.domain);
   o2.writeUTF(dr.domain);
   o2.writeUTF(dr.com.ip);o2.writeInt(dr.com.port);
   o2.flush();
   d.println("sent slave already added domain:"+dr.domain+" to "+cdr.domain);
  }//if
 }
 }catch(Exception e){d.println(e);}
}
//----------GET ADDRESS------------------------------

synchronized ComAddr getOzHomeResolver(String ozhomeID){
 d.println("getOzHomeResolver:"+ozhomeID);
 OzHomeCom hcom;
 for(int i=0;i<ozHomeResolvers.size();i++){//ID$B$N0lCW$r8!:w(B
  hcom=(OzHomeCom)ozHomeResolvers.elementAt(i);
  d.println(i+":"+hcom.ozhomeID);
  if(hcom!=null)
   if(hcom.ozhomeID.equals(ozhomeID)){
    d.println("matched"+hcom.com.ip+":"+hcom.com.port);
    return hcom.com;
   }
 }
 d.println(" unmatched");
 return null;
}

synchronized ComAddr getOzDomainResolver(String domain){
 d.println("getOzDomainResolver:"+domain);
 OzDomainCom dcom;
 for(int i=0;i<ozDomainResolvers.size();i++){
  dcom=(OzDomainCom)ozDomainResolvers.elementAt(i);
  if(dcom.domain.equals(domain))return dcom.com;
 }
 return null;
}
//----------ADD Vector-------------------------------
synchronized void addOzHomeResolver(OzHomeCom c){
 try{
 if(c!=null)
  if(!ozHomeResolvers.contains(c)){//$B=EJ#%A%'%C%/(B
   ozHomeResolvers.addElement(c);d.println("added "+c.ozhomeID);
  }
 }catch(Exception e){d.println("addOzHomeResolver:"+e);
 }
}
synchronized void addOzDomainResolver(OzDomainCom c){
 try{
  if(!ozDomainResolvers.contains(c)){ //$B=EJ#%A%'%C%/(B
   ozDomainResolvers.addElement(c);
   d.println("added to OzDomainResolver");
  }
 }catch(Exception e){d.println("addOzDomainResolver:"+e);
 }
}
synchronized void printVector(){//print each ComAddr of Vedtor
 for(int i=0;i<ozHomeResolvers.size();i++){
 ComAddr com=(ComAddr)ozHomeResolvers.elementAt(i);
//  System.out.println(com.ip+":"+com.port+"/"+i);
 }
}

synchronized boolean isMine(String otherDomain){
 OzDomainCom dr;
 for(int i=0;i<ozDomainResolvers.size();i++){
  dr=(OzDomainCom)ozDomainResolvers.elementAt(i);
  if(dr.domain.equals(otherDomain))return true;
 }
 return false;
}

//------Server start$B;~$K8F$P$l!"%3%M%/%7%g%s$r<u$1IU$1$k(B--------------

protected Object getConnection(Socket client_socket){
 OzDomainResolverConnection c = new OzDomainResolverConnection(client_socket,this);
 return c;
}

}




