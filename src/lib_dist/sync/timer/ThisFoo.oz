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

class ThisFoo {
  System system;
  condition dummy;
  new create() { system=>create(); }
  public locked int foo( int i, String S){ 
    system->println("method foo start");
    wait(dummy,3000);
    // wait(dummy,1000);
    system->println("method foo end");
    return i ;
  }
}