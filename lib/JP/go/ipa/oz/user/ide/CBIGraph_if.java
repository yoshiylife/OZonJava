package JP.go.ipa.oz.user.ide;

public interface CBIGraph_if extends JP.go.ipa.oz.lang._Root_if {
  static final boolean _final_ = true;
  
  void clearMarks () throws Exception ;
  void addPart (JP.go.ipa.oz.user.ide.CIPart_if part, JP.go.ipa.oz.lib.standard._Collection_if superParts) throws Exception ;
  JP.go.ipa.oz.user.ide.CBIGraphNode_if getNode (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception ;
  int size () throws Exception ;
  JP.go.ipa.oz.lib.standard._Iterator_if nodes () throws Exception ;
  JP.go.ipa.oz.user.ide.CBIGraphNode_if getPrimaryNode () throws Exception ;
}

