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

class QReadRunnable :* Runnable {
  QStruct qs;
  System system;
  new create(QStruct s) {
    qs = s;
    system=>create();
  }
  public void run() {
    Root o; String s; int i;
    for(i=0; i<10; i++){
      o = qs->read();
      s =| o;
      system->println(s);
    }
  }
}
