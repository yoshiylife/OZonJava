package JP.go.ipa.oz.user.apl.fm;

public interface Organization_if extends JP.go.ipa.oz.user.apl.fm.Actor_if {
  
  JP.go.ipa.oz.lib.standard._Set_if getMembers (JP.go.ipa.oz.lib.standard._String_if nam) throws Exception ;
  JP.go.ipa.oz.lib.standard._Set_if getMembers () throws Exception ;
  boolean isBelong (JP.go.ipa.oz.lib.standard._String_if nam) throws Exception ;
  boolean isBelong (JP.go.ipa.oz.user.apl.fm.Actor_if mem) throws Exception ;
  JP.go.ipa.oz.user.apl.fm.Actor_if getMember (JP.go.ipa.oz.lib.standard._String_if nam) throws Exception ;
  JP.go.ipa.oz.user.apl.fm.Actor_if getMember (JP.go.ipa.oz.user.apl.fm.Actor_if act) throws Exception ;
  void addMember (JP.go.ipa.oz.user.apl.fm.Actor_if mem) throws Exception ;
  void removeMember (JP.go.ipa.oz.lib.standard._String_if nam) throws Exception ;
  void removeMember (JP.go.ipa.oz.user.apl.fm.Actor_if mem) throws Exception ;
  JP.go.ipa.oz.lib.standard._Set_if getMembersPool () throws Exception ;
}

