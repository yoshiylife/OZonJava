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

class CDAdebug {

  System system;

  bool on;

  new create(){
    system=>create();
    on = false;
  }

  public void println(String s){
    if(on) system->println(s);
  }

  public void println(String s,String ss){
    if(on){
      String mes = s->concat(" "); mes = mes->concat(ss);
      if(on) system->println(mes);
    }
  }

  public void println(String s,int i){
    if(on){
      Integer I => breed(i);
      String mes = s->concat(" "); mes = mes->concat(I->asString());
      if(on) system->println(mes);
    }
  }

  public void println(String s,long l){
    if(on){
      Long L => breed(l);
      String mes = s->concat(" "); mes = mes->concat(L->asString());
      if(on) system->println(mes);
    }
  }

}
