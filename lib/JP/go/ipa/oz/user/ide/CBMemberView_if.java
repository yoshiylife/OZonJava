package JP.go.ipa.oz.user.ide;

public interface CBMemberView_if extends JP.go.ipa.oz.lang._Root_if {
  static final boolean _final_ = true;
  
  void addMemberListener (JP.go.ipa.oz.user.ide.CBMemberListener_if listener) throws Exception ;
  void layoutComponents (JP.go.ipa.oz.lib.standard._Panel_if accPanel, JP.go.ipa.oz.lib.standard._Panel_if modPanel, JP.go.ipa.oz.lib.standard._Panel_if typePanel, JP.go.ipa.oz.lib.standard._Panel_if namePanel, JP.go.ipa.oz.lib.standard._Panel_if argPanel, JP.go.ipa.oz.lib.standard._Panel_if decPanel) throws Exception ;
  void deselect () throws Exception ;
  void select () throws Exception ;
  JP.go.ipa.oz.user.ide.CIMember_if getMember () throws Exception ;
}

