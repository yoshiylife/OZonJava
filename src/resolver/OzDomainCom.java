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
import java.util.*;

class OzDomainCom{
 String domain;//domain name
 ComAddr com;
public OzDomainCom(String domain,String ip,int port){
 ComAddr c=new ComAddr(ip,port);
 this.domain=domain;com=c;
}
public OzDomainCom(String domain,ComAddr com){
 this.com=com;
}
}


