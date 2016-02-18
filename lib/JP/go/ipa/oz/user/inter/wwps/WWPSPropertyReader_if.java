package JP.go.ipa.oz.user.inter.wwps;

public interface WWPSPropertyReader_if extends JP.go.ipa.oz.user.inter.cgi.FilePropertyReader_if {
  
  JP.go.ipa.oz.lib.standard._String_if getOzCGI () throws Exception ;
  void read () throws Exception ;
}

