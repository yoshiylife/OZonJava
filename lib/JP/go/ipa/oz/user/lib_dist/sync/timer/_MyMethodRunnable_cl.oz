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

class MyMethodRunnable :* MethodRunnable {
  MyFoo obj; int i; String s;
  new create(Timer t){ super=>create(t); }
  public void set(MyFoo Obj,int I,String S){
    obj=Obj; i=I; s=S;
  }
  protected Root MyMethod(){
   int ret=obj->foo(i,s);
   Integer I=>breed(ret);
   return I;
  }
}
