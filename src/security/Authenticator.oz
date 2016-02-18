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

class Authenticator
{
 String myOzHome;

 new create(String myHome){myOzHome=myHome;}

public void authorize(Root obj){
  if(obj!=null && obj->isRed()){
        turnGreen(obj);
        obj->toGreen();
  }
}
public void authenticate(){
 if(!myOzHome->isequal(OzCipher->getCallerOzHome())){
  UnknownUserException e=>init();throw e;
 }
}
}
