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

class DeliveryFile {

  String codePath;
  String topPackageName;
  int length;
  ByteArray contents;
  long time;

  new create( String c, String t, int i, ByteArray con){
    codePath = c;
    topPackageName = t;
    length = i;
    contents = con;
  }

  public void timeStamp(long l){ time = l; }

  public long time() { return time; }

  public String getPackageName(){
    return codePath;
  }

  public String getTopPackageName(){
    return topPackageName;
  }

  public int getLength(){
    return length;
  }

  public ByteArray getContents(){
    return contents;
  }

}

