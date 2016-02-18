package JP.go.ipa.oz.user.inter.cgi;

public interface HTMLData_if extends JP.go.ipa.oz.lang._Root_if {
  
  JP.go.ipa.oz.lib.standard._ByteArray_if binaryData () throws Exception ;
  void addTag (JP.go.ipa.oz.lib.standard._String_if tag) throws Exception ;
  JP.go.ipa.oz.lib.standard._Iterator_if getLabels () throws Exception ;
  void beginTag (JP.go.ipa.oz.lib.standard._String_if tag) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getFormID () throws Exception ;
  void endOutput () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getRequestID () throws Exception ;
  JP.go.ipa.oz.lang._Root_if getValue (JP.go.ipa.oz.lib.standard._String_if label) throws Exception ;
  void startOutput (JP.go.ipa.oz.lib.standard._String_if content, JP.go.ipa.oz.lib.standard._String_if name) throws Exception ;
  void startOutput (JP.go.ipa.oz.lib.standard._String_if content) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if output () throws Exception ;
  void addOutput (JP.go.ipa.oz.lib.standard._InputStream_if in, int size) throws Exception ;
  void addOutput (JP.go.ipa.oz.lib.standard._String_if str) throws Exception ;
  void endTag () throws Exception ;
}

