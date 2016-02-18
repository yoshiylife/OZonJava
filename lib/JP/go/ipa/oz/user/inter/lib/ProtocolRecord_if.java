package JP.go.ipa.oz.user.inter.lib;

public interface ProtocolRecord_if extends JP.go.ipa.oz.lib.standard._Dictionary_if {
  
  void set (JP.go.ipa.oz.lib.standard._String_if label, JP.go.ipa.oz.lib.standard._String_if value) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getLineTerminator () throws Exception ;
  void setCommand (JP.go.ipa.oz.lib.standard._String_if command) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getStatus () throws Exception ;
  void decode (JP.go.ipa.oz.lib.standard._String_if response_data) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if get (JP.go.ipa.oz.lib.standard._String_if label) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if encode () throws Exception ;
}

