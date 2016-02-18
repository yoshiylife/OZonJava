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

package JP.go.ipa.oz.user.secu;

import java.io.*;
import java.net.*;
import java.util.*;

public class _ASProperty_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.secu._ASProperty_if {
//  JP.go.ipa.oz.lib.standard._String_if _port;
  int _port;
  JP.go.ipa.oz.lib.standard._String_if _cipher;
 
public Object _new_create (JP.go.ipa.oz.lib.standard._String_if OZHOME, JP.go.ipa.oz.lib.standard._String_if sp) throws Exception{
   String fname;
   fname=OZHOME.toString().concat(sp.toString()).concat("lib").concat(sp.toString()).concat("oz.properties");
   System.out.println(fname);
   File fi=new File(fname);//$OZHOME/lib/oz.properties
   if(!fi.isFile())
    throw new Exception(fname+":does not found");
        FileInputStream fin=new FileInputStream(fi);
        DataInputStream din= new DataInputStream(fin);
        String s,nt,ip,port,hip,hport,cipher;
        ip="";port="";hip="";hport="";cipher="";
	int flag=0;
        while((s=din.readLine())!=null){
         StringTokenizer st=new StringTokenizer(s,"=\n :");
         while(st.hasMoreTokens()){
           nt=st.nextToken();
 	   if(nt.equals("oz.authentication.server")){
            if(st.hasMoreTokens())ip=st.nextToken();
            else{throw new Exception("invalid IP");}
            if(st.hasMoreTokens()){
             port=st.nextToken();
	     //System.out.println("addr="+ip+":"+port);
	     break;
            }else{throw new Exception("invalid address");}
           }
 	   if(nt.equals("oz.authentication.server.cipher")){
            if(st.hasMoreTokens()){
             cipher=st.nextToken();
	     break;
            }else{throw new Exception("invalid cipher");}
           }
         }//readToken
        }//readLine
//_port=(JP.go.ipa.oz.lib.standard._String_if)(new JP.go.ipa.oz.lib.standard._String_cl(port));
 _port=Integer.parseInt(port);
_cipher=(JP.go.ipa.oz.lib.standard._String_if)(new JP.go.ipa.oz.lib.standard._String_cl(cipher));
    return this;
}

//public JP.go.ipa.oz.lib.standard._String_if getPort() throws Exception{
public int getPort() throws Exception{
 checkSecureInvocation ();
  return _port;
}
public JP.go.ipa.oz.lib.standard._String_if getCipher() throws Exception{
 checkSecureInvocation ();
  return _cipher;
}
}