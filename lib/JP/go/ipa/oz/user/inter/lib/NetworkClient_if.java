package JP.go.ipa.oz.user.inter.lib;

public interface NetworkClient_if extends JP.go.ipa.oz.lang._Root_if {
  
  JP.go.ipa.oz.lib.standard._String_if sendCommand () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if connect (JP.go.ipa.oz.lib.standard._String_if host) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if connect (JP.go.ipa.oz.lib.standard._String_if h, int p) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getResponse () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if sendData (JP.go.ipa.oz.lib.standard._String_if data) throws Exception ;
  int getTimeout () throws Exception ;
  void setTimeout (int t) throws Exception ;
}

