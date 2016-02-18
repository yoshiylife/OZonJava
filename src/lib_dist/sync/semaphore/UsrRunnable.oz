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

class UsrRunnable :* Runnable {
  String label;
  bool mode;
  ModedBinarySemaphore mbs;
  System system;
  new create(ModedBinarySemaphore s, String l, bool m) {
    system=>create();
    label = l;
    mode = m;
    mbs = s;
  }
  public void run() {
    long l = 5000; Monit m => create();
    system->println(label); system->println(" P");
    if(mode) mbs->exclusiveP(); else mbs->sharedP();
    system->println(label); system->println(" critical begin");
    m->monit(l);
    system->println(label); system->println(" critical end and V");
    mbs->V();
  }
}
