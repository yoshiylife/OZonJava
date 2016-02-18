/*
 Copyright(C) 1996-1998
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

public final class OzHomeResolver extends Server{
 int timeout;//oz.resolve.timeout
 int InitTime=300;//[sec]
 int DefaultTimeOut=30;//[sec]
 int DefaultPort=10000;
 int SendByte=100;
 int MaxConncection=1000;
 ComAddr comAddr;         //comAddr of this    
 ComAddr ozDomainResolver;//$B<+?H$r4IM}$9$k(BozDomainResolver
 Vector ozhomes;//$B<+?H$N4IM}$9$k(BOZ$B%[!<%`(BID$B$H$=$N%U%!%$%k%Q%9(B=OzhomePath
 String domain; //domain name of this site
 String OZHOME; //$OZHOME shell script$B$GEO$5$l$k(B
 String ozhomeID;//OZHOME$B<1JL;R(B
 String sp;//$B%G%#%l%/%H%j%;%Q%l!<%?(B = "\"or "/"
 boolean domainRecept;
 Vector req;//Request
 Vector ozhomeCash;//ozhomeID+$B$=$l$r4IM}$9$k(BOzHomeResolver$B$N(BComAddr

//------------------MAIN----------------------------------

public static void main(String[] args){
 try{
  String sp="",ozhome,inetAddr;int port = 0;boolean debug=false;
  if(args.length<2){
   System.err.println("argument needs:unix[nt] $OZHOME [d]");
  }else{
   if(args[0].equals("unix"))sp="/";
   else if(args[0].equals("nt"))sp="\\";
   ozhome=args[1];
   if(args[2].equals("d"))debug=true;
   new OzHomeResolver(sp,ozhome,debug);
 }
 }catch(Exception e){System.err.println(e);
 }
}
//------Server start$B;~$K8F$P$l!"%3%M%/%7%g%s$r<u$1IU$1$k(B--------------

public Object getConnection(Socket client_socket){
 OzHomeResolverConnection c = new OzHomeResolverConnection(client_socket,this);
 return c;
}
protected void saveStatus(){//stop$BD>A0$K8F$P$l$k(B
 saveObject("ozhr.homes",ozhomes);
}
protected void loadStatus(){
 if((ozhomes=(Vector)loadObject("ozhr.homes"))==null)ozhomes=new Vector();
  d.println("ozhomes loaded:"+ozhomes.size());
}

//---------------CONSTRUCTOR---------------------------------------
public OzHomeResolver(String sp,String ozhome,boolean debug){
 super();
 d=new Debug(debug);//DEBUG ON
 this.sp=sp;
 domainRecept=false;
 OZHOME=ozhome;
 loadStatus();loadCash("ozhr.cashe");
 try{
  Timer timer=new Timer(InitTime);//timer start
  if(readOzProperties())addToDomainResolver();
  else throw new Exception("OzDomainResolver can't add comAddr");
  timer.cancel();
 }catch(ConnectException e){
   System.out.println("domain resolver wasn't start,didn't add this to it.");}
 catch(SocketException e){;}
 catch(Exception e){
  System.err.println(e);
 }
 super.newListen(comAddr.port);//server thread new
 this.start();//DR$B$KEPO?$5$l$J$/$H$b(B
}
public void addToDomainResolver() throws Exception{
   Socket socket=new Socket(ozDomainResolver.ip,ozDomainResolver.port);
   DataOutputStream so= new DataOutputStream(socket.getOutputStream());
   so.writeUTF("HR");//$BEPO?MW5a(B
   so.writeUTF(ozhomeID);//d.println(ozhomeID);
   so.writeUTF(comAddr.ip);so.writeInt(comAddr.port);
   so.writeInt(timeout);
   so.flush();
   d.println("sent ComAddr to ozDomainResolver:"+ozDomainResolver.port); 
   DataInputStream din = null;
   din = new DataInputStream(socket.getInputStream());
   String req;boolean b=false;
   for(;;){//$BEPO?$5$l$k$^$GBT$D(B
    req=din.readUTF();d.println(req); 
    if(req.equals(null))break;
    else if(req.equals("RH")){//OzDomainResolver$B$+$i$NJVEz(B
     if(din.readBoolean()){
      d.println("ComAddr of OzDomainResolver set.");
      so.close();//$BEPO?$5$l$?$N$G%;%C%7%g%s$r@Z$k(B
      domainRecept=true;
     }else{
      throw new Exception("OzDomainResolver can't add comAddr");
     }
    }
   }din.close();//for
}
//--------- oz.properties$B$rFI$`(B --------------------

boolean readOzProperties(){
   try{
    String fname=OZHOME.concat(sp).concat("lib").concat(sp).concat("oz.properties");
    File fi=new File(fname);
        if(!fi.isFile())
         throw new Exception("$OZHOME/lib/oz.properties does not found");

        FileInputStream fin=new FileInputStream(fi);
        DataInputStream din= new DataInputStream(fin);
        String s,nt,ip,port,hip,hport;ip="";port="";hip="";hport="";
	int flag=0;
        while((s=din.readLine())!=null){
         StringTokenizer st=new StringTokenizer(s,"=\n :");
         while(st.hasMoreTokens()){
           nt=st.nextToken();
	   if(nt.equals("oz.home.name")){
            if(st.hasMoreTokens())this.domain=st.nextToken();
            else{throw new Exception("invalid domain in oz.home.name.");}
            if(st.hasMoreTokens())ozhomeID=st.nextToken();
            else{throw new Exception("invalid OZHOME in oz.home.name.");}
            OzhomePath thisPath=new OzhomePath(ozhomeID,OZHOME);
            addOzhome(thisPath);
            d.println("set domain="+domain+" ozhomeID="+ozhomeID);
	   }
	   else if(nt.equals("oz.home.resolver")){
            if(st.hasMoreTokens())hip=st.nextToken();//must be ip of this host
            else{throw new Exception("invalid IP of oz.domain.resolver");}
            if(st.hasMoreTokens()){hport=st.nextToken();
	     d.println("oz.home.resolver="+hip+":"+hport);
            }else{throw new Exception("invalid port of oz.domain.resolver");}
	   }
	   else if(nt.equals("oz.domain.resolver")){
            if(st.hasMoreTokens())ip=st.nextToken();
            else{throw new Exception("invalid IP of oz.domain.resolver");}
            if(st.hasMoreTokens()){port=st.nextToken();
	     d.println("oz.domain.rsolver="+ip+":"+port);
            }else{throw new Exception("invalid port address of oz.domain.resolver");}
	   }
	   else if(nt.equals("oz.resolve.timeout")){
            if(st.hasMoreTokens())timeout=Integer.parseInt(st.nextToken());
             if(timeout<=0)timeout=DefaultTimeOut;
           }else{timeout=DefaultTimeOut;}
         }//while
	}//while
        din.close();
        d.println("timeout="+timeout);
        comAddr=new ComAddr(hip,Integer.parseInt(hport));
        ozDomainResolver=new ComAddr(ip,Integer.parseInt(port));
        return true;
     }catch(IOException e){
        System.err.println("Cannot access file."+e);
        return false;
     }catch(Exception e){return false;}
}

//---------------.location$B$NFI$_=P$7(B--------------------

public ComAddr getComAddrOf(String ozhomeID,String god){//$B<BBN$rFI$`(B
 try{
  String ozh,go="",godir;
  if((ozh=getOzhomeOf(ozhomeID))==null)throw new Exception("ozhome not found");
  else{
   godir=ozh.concat(sp).concat("objects").concat(god);
   File godf=new File(godir);
   if(godf.isDirectory()){
    go=godir.concat(sp).concat(".location");
    d.println("found:"+go);
    FileInputStream fi=new FileInputStream(go);
    ObjectInputStream oi = new ObjectInputStream(fi);

    OzCommAddress c=(OzCommAddress)oi.readObject();
    String ip=c.getHostAddress();
    int port=c.getPort();
    //System.out.println("InetAddress="+ip+" port="+port);
    ComAddr com=new ComAddr(ip,port);
    fi.close();
    return com;
   }else
    d.println("didn't found file="+go);return null;
  }
 }catch(Exception e){System.out.println(e);
  return null;}
}

//-----ozhomeID$B$+$i(Bozhome(dir)$B$rJV$9(B--------------

public String getOzhomeOf(String ozhomeID){
 for(int i=0;i<ozhomes.size();i++){
  OzhomePath p=(OzhomePath)ozhomes.elementAt(i);
  if(p.ozhomeID.equals(ozhomeID))return p.ozhome;
 }
 return null;
}

//-----ozhomes$B$KMWAG$rDI2C(B-------------

public synchronized boolean addOzhome(OzhomePath other){
 OzhomePath p;
 for(int i=0;i<ozhomes.size();i++){
  p=(OzhomePath)ozhomes.elementAt(i);
  if(p.ozhomeID.equals(other.ozhomeID)) return false;
 }
 ozhomes.addElement(other);
 d.println("added OZHOME:"+other.ozhomeID+":"+other.ozhome);
 return true;
}

//-----ozhomeID$B$r8!:w(B--------------

public boolean searchID(String ozhomeID){
 OzhomePath p;
 for(int i=0;i<ozhomes.size();i++){
  p=(OzhomePath)ozhomes.elementAt(i);
  if(p.ozhomeID.equals(ozhomeID))return true;
 }
 return false;
}

//--------------------------------------------------
public boolean inOzhomes(String ozhomeID){//ozhomes$B$r8!:w(B
 d.println("ozhomes.size="+ozhomes.size());
 for(int i=0;i<ozhomes.size();i++){
  OzhomePath p=(OzhomePath)ozhomes.elementAt(i);
  if(p.ozhomeID.equals(ozhomeID))return true;
 }
 return false;
}
}


