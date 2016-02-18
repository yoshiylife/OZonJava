package JP.go.ipa.oz.user.apl.fm;

public interface FMObject_if extends JP.go.ipa.oz.lang._Root_if {
  
  JP.go.ipa.oz.user.apl.fm.RelationComparator_if getRelationComparator () throws Exception ;
  JP.go.ipa.oz.user.apl.fm.FMObject_if cloneSelf () throws Exception ;
  JP.go.ipa.oz.lib.standard._Set_if getRelatedObjects (JP.go.ipa.oz.lib.standard._String_if relName) throws Exception ;
  void commit () throws Exception ;
  void setName (JP.go.ipa.oz.lib.standard._String_if n) throws Exception ;
  JP.go.ipa.oz.lib.standard._SList_if findRelations (JP.go.ipa.oz.user.apl.fm.Pointer_if ptr) throws Exception ;
  JP.go.ipa.oz.lib.standard._SList_if findRelations (JP.go.ipa.oz.lib.standard._String_if s) throws Exception ;
  boolean isEqualFMObject (JP.go.ipa.oz.user.apl.fm.FMObject_if obj) throws Exception ;
  JP.go.ipa.oz.user.apl.fm.Pointer_if container () throws Exception ;
  void add (JP.go.ipa.oz.user.apl.fm.Relation_if r) throws Exception ;
  JP.go.ipa.oz.user.apl.fm.FMContainer_if federation () throws Exception ;
  void setIdentifier (JP.go.ipa.oz.user.apl.fm.Pointer_if ptr) throws Exception ;
  JP.go.ipa.oz.user.apl.fm.FMObject_if getRelatedObject (JP.go.ipa.oz.lib.standard._String_if relName) throws Exception ;
  void remove (JP.go.ipa.oz.user.apl.fm.Relation_if r) throws Exception ;
  JP.go.ipa.oz.lib.standard._Set_if getAllRelations () throws Exception ;
  void trace (int mark) throws Exception ;
  JP.go.ipa.oz.user.apl.fm.Pointer_if getIdentifier () throws Exception ;
  JP.go.ipa.oz.user.apl.fm.Relation_if getRelation (JP.go.ipa.oz.user.apl.fm.Relation_if rel) throws Exception ;
  int update (JP.go.ipa.oz.user.apl.fm.FMObject_if obj) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getName () throws Exception ;
  JP.go.ipa.oz.lib.standard._Set_if getRelations () throws Exception ;
  JP.go.ipa.oz.lib.standard._Set_if getAllRelationName () throws Exception ;
  void delete () throws Exception ;
  JP.go.ipa.oz.user.apl.fm.Relation_if createRelation (JP.go.ipa.oz.user.apl.fm.Relation_if rel, JP.go.ipa.oz.user.apl.fm.FMObject_if destObj) throws Exception ;
  JP.go.ipa.oz.user.apl.fm.Relation_if createRelation (JP.go.ipa.oz.lib.standard._String_if relName, JP.go.ipa.oz.user.apl.fm.FMObject_if destObj) throws Exception ;
}

