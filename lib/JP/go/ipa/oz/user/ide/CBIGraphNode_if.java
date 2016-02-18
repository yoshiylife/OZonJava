package JP.go.ipa.oz.user.ide;

public interface CBIGraphNode_if extends JP.go.ipa.oz.lib.standard._Rectangle_if {
  static final boolean _final_ = true;
  
  JP.go.ipa.oz.lib.standard._String_if getLabelName () throws Exception ;
  void setMark (boolean mk) throws Exception ;
  void setLevel (int lv) throws Exception ;
  int getSuperClassCount () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getCID () throws Exception ;
  JP.go.ipa.oz.lib.standard._Iterator_if subNodes () throws Exception ;
  boolean isMarked () throws Exception ;
  int getLevel () throws Exception ;
  int getSubClassCount () throws Exception ;
  void addSuperNode (JP.go.ipa.oz.user.ide.CBIGraphNode_if nd) throws Exception ;
  JP.go.ipa.oz.lib.standard._Iterator_if superNodes () throws Exception ;
  void addSubNode (JP.go.ipa.oz.user.ide.CBIGraphNode_if nd) throws Exception ;
}

