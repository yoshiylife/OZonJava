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

abstract class MethodRunnable :* Runnable{
  Timer timer;
  Root result;
  new create(Timer t){ timer = t; }

  public Root getResult() { return(result); }
  protected abstract Root MyMethod();
  public void run(){
    result = MyMethod();
    timer->MethodDone();
  }
}
