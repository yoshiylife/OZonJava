package JP.go.ipa.oz.user.misc.gui;

public interface StringInputDialog_if extends JP.go.ipa.oz.user.misc.gui.CenteredDialog_if {
  
  void setString (JP.go.ipa.oz.lib.standard._String_if str) throws Exception ;
  void clear () throws Exception ;
  void addStringInputListener (JP.go.ipa.oz.user.misc.gui.StringInputListener_if listener) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getInputString () throws Exception ;
}

