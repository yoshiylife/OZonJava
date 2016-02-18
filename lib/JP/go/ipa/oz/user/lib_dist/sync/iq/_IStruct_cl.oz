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

class IStruct {

  int flag; // read(-1)<-->empty(0)<-->written(1)
  Root val;
  condition cond;

  new create(){
    flag = 0;
  }

  public locked void write(Root o) {
    if(flag==1){
      IStructWriteException e => init();
      throw e;
    } else {
      val = o;
      if(flag==0){
        flag = 1;
      } else {
        flag = 0;
        signal(cond);
      }
    }
  }

  public locked Root read() {
    if(flag==-1){
      IStructReadException e => init();
      throw e;
    } else {
      if(flag==0){
        flag = -1;
        wait(cond);
      }
      flag = 0;
      return val;
    }
  }

}
