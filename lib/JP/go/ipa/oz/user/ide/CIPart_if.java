package JP.go.ipa.oz.user.ide;

public interface CIPart_if extends JP.go.ipa.oz.lang._Root_if {
  
  boolean isFinal () throws Exception ;
  JP.go.ipa.oz.lib.standard._Iterator_if methods () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getLabelName () throws Exception ;
  int getMethodCount () throws Exception ;
  void addMember (JP.go.ipa.oz.user.ide.CIMember_if mbr) throws Exception ;
  boolean isAbstract () throws Exception ;
  boolean isInterface () throws Exception ;
  boolean isRoot () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getCID () throws Exception ;
  boolean isCell () throws Exception ;
  void setLabelName (JP.go.ipa.oz.lib.standard._String_if label) throws Exception ;
}

