package JP.go.ipa.oz.user.secu;

public interface Authenticator_if extends JP.go.ipa.oz.lang._Root_if {
  
  void authenticate () throws Exception ;
  void authorize (JP.go.ipa.oz.lang._Root_if obj) throws Exception ;
}

