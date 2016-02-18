package JP.go.ipa.oz.user.secu;

public interface AccessControlList_if extends JP.go.ipa.oz.lib.standard._Set_if {
  
  void remove (JP.go.ipa.oz.user.secu.User_if u) throws Exception ;
  void authenticateSameGroup () throws Exception ;
  void add (JP.go.ipa.oz.user.secu.User_if u) throws Exception ;
  JP.go.ipa.oz.lib.standard._Set_if asSet () throws Exception ;
  void authenticate (JP.go.ipa.oz.lib.standard._String_if groupName) throws Exception ;
  void authenticate () throws Exception ;
}

