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

public class _ReadLine_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.secu._ReadLine_if {

public Object _new_create(){return this;}

public JP.go.ipa.oz.lib.standard._String_if readLine(){
 try{
  DataInputStream in=new DataInputStream(System.in);
  String line;line=in.readLine();
  return (JP.go.ipa.oz.lib.standard._String_if)(new JP.go.ipa.oz.lib.standard._String_cl(line));
 }catch(Exception e){System.err.println(e);return null;}
}

}

