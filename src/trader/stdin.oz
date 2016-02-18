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


cell Maintenance{
 System s;
 protected void initialize(){}

public  void go(){
 try{
  String str,str2;
  s=>create();PrintWriter o=s->getStdout();
  CharArray sa=>create(1);
  o->print(">");o->flush();int i=0;
  while(true){
   if((i=s->getStdin()->read(sa,0,1))==0){
    s->println("read fault");break;
   }
   for(int j=0;j<i;j++){
    o=s->getStdout();o->print("[");o->print(sa->at(j));o->print("]");o->flush();
   }
   str=sa->asString()->trim();
   if(sa->at(0)=='q')break;
   if(str->compareTo("q")==0)break;
   if(str->compareTo("q\n")==0)break;
  }
  s->println("end");
  }catch(Exception e){s->println("Exception occured.");}
}
 protected void quiet(){flushCell();}
}

