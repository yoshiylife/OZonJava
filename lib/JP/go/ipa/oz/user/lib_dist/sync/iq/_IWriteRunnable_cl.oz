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

class IWriteRunnable :* Runnable {
  IStruct is;
  String label;
  System system;
  new create(IStruct s, String S) {
    is = s;
    label = S;
    system=>create();
  }
  public void run() {
    system->println("write begin");
    is->write(label);
    system->println("write end");
  }
}
