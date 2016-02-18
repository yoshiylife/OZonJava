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

class SystemMapValue{
  // systemmap key path on this service is tranpath on nameserverGOL
  String nameserverGOL;
  Path tranpath;
  bool ismapping;
  new create(String s){
    nameserverGOL => breed(s);
    tranpath => breed(""); // means not mapping
    ismapping = false;
  }
  new create(String s, Path p, bool tf){
    nameserverGOL => breed(s);
    tranpath => breed(p->asString()); // means mapping
    ismapping = tf;
  }
  public void debugPrint(PrintWriter pw){
    pw->print("  "); pw->print(nameserverGOL);
    pw->print("  "); pw->print(tranpath->asString());
  }
  public String nameserverGOL(){ return nameserverGOL; }
  public Path tranpath(){ return tranpath; }
  public bool ismapping() { return ismapping; }
}