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
import JP.go.ipa.oz.system.OzCommAddress;

import java.io.*;

class Request{
 String  ozhomeID;
 String gol;
 String ip;
 int port;
Request(String ozhomeID,String gol,String ip,int port){
 this.ozhomeID=ozhomeID;this.gol=gol;this.ip=ip;this.port=port;
}
}
