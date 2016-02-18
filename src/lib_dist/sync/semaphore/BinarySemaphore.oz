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

class BinarySemaphore {

  protected int sem; // -1 -> exclusive only one thread in critical
                     //  0 -> empty in critical
                     // >0 -> number of cooperative in critical
  condition co, ex;
  bool notCoEmpty;	
  // System system;

  public locked void P() {
    P(true);
  }

  protected void P(bool mode) { // mode==true -> exclusive
    // Integer I;
    // I=>breed(sem); system->println(I->asString());
    if(sem==0) {
      if(mode) sem=-1;
      else sem++;
    } else if( sem==-1 ){
      if( mode ){ wait(ex); sem=-1; }
      else { notCoEmpty = true; wait(co); sem++; }
    } else {
      if( mode ) { wait(ex); sem=-1; }
      else sem++;
    }
  }

  public locked void V(){
    // Integer I;
    // I=>breed(sem); system->println(I->asString());
    if(sem==-1){
      sem=0;
      if(notCoEmpty) signalAll(co);
      else signal(ex);
    } else if(sem==1){
      sem=0;
      notCoEmpty = false;
      signal(ex);
    } else {
      sem--;
    }
  }

  new create(){
    sem = 0;
    notCoEmpty = false;
    // system=>create();
  }

}
