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