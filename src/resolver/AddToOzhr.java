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

public final class AddToOzhr{
 int timeout;//oz.resolve.timeout
 int InitTime=300;//[sec]
 int DefaultTimeOut=30;//[sec]
 String OZHOME; //$OZHOME shell scriptで渡されるpath
 String ozhomeID;//OZHOME識別子
 String DNS;
 String sp;//ディレクトリセパレータ = "\"or "/"
 String ip;//IP addr of OzHomeResolver
 int port; //port number of OzHomeResolver
 Debug d;

//------------------MAIN---------------------------------
// ozhomeIDとOZHOMEのパスをozhrに登録する

public static void main(String[] args){
 try{
 String sp="",ozhome,inetAddr;int port = 0;boolean debug=false;
 if(args.length<2){
//  System.err.println("argument needs:unix[nt] $OZHOME [d]");
 }else{
  if(args[0].equals("unix"))sp="/";
  else if(args[0].equals("nt"))sp="\\";
  ozhome=args[1];
  if(args[2].equals("d"))debug=true;
//  System.out.println("args="+sp+":"+ozhome+debug);
  new AddToOzhr(sp,ozhome,debug);
 }
 }catch(Exception e){//System.err.println(e);
 }
}
//---------------CONSTRUCTOR---------------------------------------

public AddToOzhr(String sp,String ozhome,boolean debug){
 d=new Debug(debug);//DEBUG ON
 this.sp=sp;
 OZHOME=ozhome;
 try{
  Timer timer=new Timer(InitTime);//timer start
  if(readOzProperties()){  
   Socket socket=new Socket(ip,port);
   DataOutputStream so= new DataOutputStream(socket.getOutputStream());
   so.writeUTF("AR");//登録要求
   so.writeUTF(ozhomeID);//d.println(ozhomeID);
   so.writeUTF(OZHOME);//d.println(OZHOME);
   so.flush();
//   d.println("sent ozhomeID,$OZHOME to ozHomeResolver:");
   DataInputStream din = null;
   din = new DataInputStream(socket.getInputStream());
   String req;boolean b=false;
   for(;;){//登録されるまで待つ
    req=din.readUTF();//d.println(req); 
    if(req.equals(null))break;
    else if(req.equals("RA")){//OzHomeResolverからの返答
      System.out.println("OZHOME was set to OzHomeResolver.");
      so.close();break;//登録されたのでセッションを切る
    }else{
      System.out.println("OzHomeResolver already added your OZHOME");
      break;
    }
   }din.close();//for
  }//endif
  else throw new Exception("OzHomeResolver can't add your OZHOME");
  timer.cancel();
 }catch(Exception e){
  System.err.println(e);
 }
}

//--------- oz.propertiesを読む --------------------

boolean readOzProperties(){
   try{
    String fname=OZHOME.concat(sp).concat("lib").concat(sp).concat("oz.properties");
    File fi=new File(fname);
        if(!fi.isFile())
         throw new Exception("$OZHOME/lib/oz.properties does not found");
        FileInputStream fin=new FileInputStream(fi);
        DataInputStream din= new DataInputStream(fin);
        String s,nt;
	int flag=0;
        while((s=din.readLine())!=null){
         StringTokenizer st=new StringTokenizer(s,"=\n :");
         while(st.hasMoreTokens()){
           nt=st.nextToken();
	   if(nt.equals("oz.home.name")){
            if(st.hasMoreTokens())this.DNS=st.nextToken();
            else{throw new Exception("invalid DNS in oz.home.name.");}
            if(st.hasMoreTokens())ozhomeID=st.nextToken();
            else{throw new Exception("invalid OZHOME in oz.home.name.");}
//            d.println("set DNS="+DNS+",ozhomeID="+ozhomeID);
           }
           else if(nt.equals("oz.home.resolver")){
            if(st.hasMoreTokens())ip=st.nextToken();
            else{throw new Exception("invalid IP of oz.home.resolver");}
            if(st.hasMoreTokens()){port=Integer.parseInt(st.nextToken());
	     d.println("oz.home.resolver="+ip+":"+port);
            }else{throw new Exception("invalid port of oz.home.resolver");}
	   }
         }//while
	}//while
        din.close();
        return true;
     }catch(IOException e){
        System.err.println("Cannot access file."+e);
        return false;
     }catch(Exception e){return false;}
}

}




