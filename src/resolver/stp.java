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

class Stop{
public static void main(String[] args){
 try{
  Stop stp=new Stop();
//usage $OZHOME h[d]
//  stp.readOzProperties(args[0],args[1]);
  int port;port=Integer.parseInt(args[0]);
  stp.quiet(InetAddress.getLocalHost().getHostAddress(),port);
 }catch(Exception e){System.out.println(e);}
}
public void quiet(String ip,int port) throws Exception{
   Socket socket=new Socket(ip,port);
   DataOutputStream so= new DataOutputStream(socket.getOutputStream());
   so.writeUTF("S");
   so.close();
}
void readOzProperties(String OZHOME,String type){
 try{
        File fi=new File(OZHOME.concat("/lib/oz.properties"));
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
          if(type.equals("h")){
	   if(nt.equals("oz.home.resolver")){
            if(st.hasMoreTokens())hip=st.nextToken();//must be ip of this host
            else{throw new Exception("invalid IP of oz.domain.resolver");}
            if(st.hasMoreTokens()){
             hport=st.nextToken();
            }else{throw new Exception("invalid port of oz.domain.resolver");}
	   }
          }else
          if(type.equals("d")){
	   if(nt.equals("oz.domain.resolver")){
            if(st.hasMoreTokens())hip=st.nextToken();//must be ip of this host
            else{throw new Exception("invalid IP of oz.domain.resolver");}
            if(st.hasMoreTokens()){
             hport=st.nextToken();
            }else{throw new Exception("invalid port of oz.domain.resolver");}
           }
          }
         }
        }
   quiet(hip,Integer.parseInt(hport));
  }catch(Exception e){;}
}
}

