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

class IReadRunnable :* Runnable {
  IStruct is;
  System system;
  new create(IStruct s) {
    is = s;
    system=>create();
  }
  public void run() {
    Root o; String s;
    system->println("read begin");
    o = is->read();
    s =| o;
    system->println("read end");
    system->println(s);
/*
    try{
      system->println("read again begin");
      o = is->read();
      system->println("read again end");
    } catch (IStructReadException e){
      system->println("istruct read exception");
    }
*/
  }
}
