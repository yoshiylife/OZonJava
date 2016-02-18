package JP.go.ipa.oz.user.secu;

public interface UserGroup_if extends JP.go.ipa.oz.lang._Root_if {
  
  JP.go.ipa.oz.lib.standard._Set_if getMembers () throws Exception ;
  void removeMembers (JP.go.ipa.oz.lib.standard._Set_if users) throws Exception ;
  void changeOwner (JP.go.ipa.oz.lib.standard._String_if newOwner) throws Exception ;
  void addMember (JP.go.ipa.oz.lib.standard._String_if user) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getName () throws Exception ;
  void showMembers () throws Exception ;
  void removeMember (JP.go.ipa.oz.lib.standard._String_if user) throws Exception ;
  boolean contains (JP.go.ipa.oz.lib.standard._String_if name) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getOwner () throws Exception ;
  void addMembers (JP.go.ipa.oz.lib.standard._Set_if users) throws Exception ;
}

