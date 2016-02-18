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

//TraderのGOL取得用

class TraderStub{
 String OZHOME;
 Debug d;int x;
 new create(String ozhome){OZHOME=ozhome;//d=>create();x=0;
 }
 public final Trader getTrader(){
  Trader t=>create(getTraderGOL());
  return t;
 }
 public final String getTraderGOL(){
  try{
    String fname=>breed(OZHOME->concat("/lib/trader.gol"));
//    d->write(x,"fname=",fname);
    File f=>breed(fname);
    if(!f->exists()){return null;}
     FileInputStream fs;fs=>breed(fname);
     DataInputStream os;os=>breed(fs);
     String gol;gol=|os->readLine();
//     d->write(x,"gol=",gol);
     return gol;
  }catch(IOException e){
    d->write("IOException. cannot load trader.gol.");
    return null;
  }catch(ClassNotFoundException e){
    d->write("ClassNotFoundException. cannot load trader.gol.");
    return null;
  }
 }
}

