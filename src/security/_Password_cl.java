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

public class _Password_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.secu._Password_if {
  JP.go.ipa.oz.lib.standard._String_if _passwd;
 
public Object _new_create (JP.go.ipa.oz.lib.standard._String_if OZHOME, JP.go.ipa.oz.lib.standard._String_if sp) throws Exception{
   String fname;
   fname=OZHOME.toString().concat(sp.toString()).concat("secure").concat(sp.toString()).concat("password");
   System.out.println(fname);
   File fi=new File(fname);//$OZHOME/lib/oz.properties
   if(!fi.isFile())
    throw new Exception(fname+":does not found");
        FileInputStream fin=new FileInputStream(fi);
        DataInputStream din= new DataInputStream(fin);
        String s;
        if((s=din.readLine())==null) 
         throw new Exception("no password");
_passwd=(JP.go.ipa.oz.lib.standard._String_if)(new JP.go.ipa.oz.lib.standard._String_cl(s));
    return this;
}
public JP.go.ipa.oz.lib.standard._String_if getPasswd() throws Exception{
 checkSecureInvocation ();
  return _passwd;
}
}