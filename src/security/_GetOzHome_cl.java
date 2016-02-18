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

public class _GetOzHome_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.secu._GetOzHome_if {

  JP.go.ipa.oz.lib.standard._String_if _ozhome;

public Object _new_create(JP.go.ipa.oz.lib.standard._String_if GOL) throws Exception{
         String ozhome="";
         StringTokenizer st=new StringTokenizer(GOL.toString(),"=\n :");
         while(st.hasMoreTokens()){
           ozhome=st.nextToken();
            if(st.hasMoreTokens()){
             ozhome=ozhome.concat(":").concat(st.nextToken());
             break;
            }
            else{throw new Exception("invalid GOL");}
         }
 _ozhome=(JP.go.ipa.oz.lib.standard._String_if)(new JP.go.ipa.oz.lib.standard._String_cl(ozhome));
 return this;
}
public JP.go.ipa.oz.lib.standard._String_if getOzHome() throws Exception{
 checkSecureInvocation();
  return _ozhome;
}

}