package JP.go.ipa.oz.user.ide;

public interface Subject_if extends JP.go.ipa.oz.user.ide.Summarizable_if {
  
  JP.go.ipa.oz.user.ide.OzLabel_if getOzLabel (JP.go.ipa.oz.lib.standard._String_if labelName) throws Exception ;
  void removeAll () throws Exception ;
  void setReleaseMode (int bo) throws Exception ;
  boolean getUsing () throws Exception ;
  void removeOzLabel (JP.go.ipa.oz.lib.standard._String_if labelName) throws Exception ;
  void setPackageName (JP.go.ipa.oz.lib.standard._String_if name) throws Exception ;
  JP.go.ipa.oz.user.ide.OzLabel_if getOzLabelOfInterface (JP.go.ipa.oz.lib.standard._String_if interfaceID) throws Exception ;
  void setImported (boolean bo) throws Exception ;
  void putOzLabel (JP.go.ipa.oz.lib.standard._Dictionary_if lbls) throws Exception ;
  void putOzLabel (JP.go.ipa.oz.user.ide.OzLabel_if aOzLabel) throws Exception ;
  void setReleased (boolean bo) throws Exception ;
  boolean isImported () throws Exception ;
  JP.go.ipa.oz.lib.standard._Dictionary_if getOzLabels () throws Exception ;
  void setClPackageName (JP.go.ipa.oz.lib.standard._String_if name) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getClPackageName () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getSubjectName () throws Exception ;
  boolean isReleased () throws Exception ;
  void setIfPackageName (JP.go.ipa.oz.lib.standard._String_if name) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getIfPackageName () throws Exception ;
  void setUsing (boolean bo) throws Exception ;
  int getReleaseMode () throws Exception ;
  JP.go.ipa.oz.user.ide.OzLabel_if getOzLabelOfImplementation (JP.go.ipa.oz.lib.standard._String_if implementationID) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getPackageName () throws Exception ;
  void setSubjectName (JP.go.ipa.oz.lib.standard._String_if sname) throws Exception ;
}

