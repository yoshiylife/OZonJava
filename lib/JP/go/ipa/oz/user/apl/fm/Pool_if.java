package JP.go.ipa.oz.user.apl.fm;

public interface Pool_if extends JP.go.ipa.oz.user.apl.fm.FMObject_if {
  
  JP.go.ipa.oz.lib.standard._Set_if getContents (JP.go.ipa.oz.lib.standard._String_if name) throws Exception ;
  JP.go.ipa.oz.lib.standard._Set_if getAll () throws Exception ;
  void remove (JP.go.ipa.oz.lib.standard._String_if name) throws Exception ;
  void remove (JP.go.ipa.oz.user.apl.fm.FMObject_if obj) throws Exception ;
  void addContent (JP.go.ipa.oz.lib.standard._Point_if point) throws Exception ;
  void addContent (JP.go.ipa.oz.user.apl.fm.FMObject_if cont) throws Exception ;
  boolean contains (JP.go.ipa.oz.lib.standard._String_if name) throws Exception ;
  boolean contains (JP.go.ipa.oz.user.apl.fm.FMObject_if obj) throws Exception ;
  JP.go.ipa.oz.lib.standard._Set_if getPool () throws Exception ;
}

