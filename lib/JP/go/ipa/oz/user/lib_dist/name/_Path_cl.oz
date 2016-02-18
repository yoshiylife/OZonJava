final class Path{

  String pathstring;

  new breed(String s){
    pathstring => breed(s);
  }

  public final String asString(){
    return pathstring;
  }

  public final bool isequal(Path with){
    String withS = with->asString();
    return pathstring->isequal(withS);
  }

  public final Path UpperPath(String delimiter){
    int delind = pathstring->lastIndexOf(delimiter);
    Path up;
    if(delind <= 0) up => breed("");
    else up => breed(pathstring->substring(0,delind)); 
    return up;
  }

  public final String LowerName(String delimiter){
    int delind = pathstring->lastIndexOf(delimiter);
    int size = pathstring->length();
    return pathstring->substring(delind+1);
  }

  public final Path makeLowerPath(String delimitor, String subdirname){
    String s = pathstring->concat(delimitor);
    s = s->concat(subdirname);
    Path p => breed(s);
    return p;
  }

  // called only from SystemMapTransactionResource FindOwner

  public final Path translateWith(Path from, Path to){
//    System debug => create();
//    debug->println("translateWith 1");
//    debug->println(from->asString());
//    debug->println(to->asString());
    String fromS = from->asString();
    String toS = to->asString();
    int fromSize = fromS->length();
//    debug->println("translateWith 2");
    String tail = pathstring->substring(fromSize);
//    debug->println(tail);
    String transed = toS->concat(tail);
//    debug->println(transed);
    Path ret => breed(transed);
    return ret;
  }

  public final bool isEmpty(){
    bool tf; tf = pathstring->isequal("");
    return tf;
  }

}
