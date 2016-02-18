package JP.go.ipa.oz.user.secu;

public interface OzAuthenticationServer_if extends JP.go.ipa.oz.user.misc.cell.Stoppable_if {
  static final boolean _global_ = true;
  
  JP.go.ipa.oz.lib.standard._OzKey_if getMyKey () throws Exception ;
  JP.go.ipa.oz.lib.standard._OzCipher_if getCipher () throws Exception ;
  boolean isSameGroup (JP.go.ipa.oz.lib.standard._String_if member1, JP.go.ipa.oz.lib.standard._String_if member2) throws Exception ;
  void addGroup (JP.go.ipa.oz.lib.standard._String_if groupName, JP.go.ipa.oz.lib.standard._String_if owner, JP.go.ipa.oz.lib.standard._Set_if members) throws Exception ;
  void addUser (JP.go.ipa.oz.lib.standard._String_if userName, JP.go.ipa.oz.lib.standard._String_if keySeed) throws Exception ;
  void showGroupMembers (JP.go.ipa.oz.lib.standard._String_if name) throws Exception ;
  void showUser () throws Exception ;
  JP.go.ipa.oz.lib.standard._Date_if getExDate (JP.go.ipa.oz.lib.standard._String_if userName) throws Exception ;
  void removeGroup (JP.go.ipa.oz.lib.standard._String_if groupName) throws Exception ;
  void addExDate (JP.go.ipa.oz.lib.standard._String_if userName, JP.go.ipa.oz.lib.standard._Date_if edate) throws Exception ;
  void setMyKey (JP.go.ipa.oz.lib.standard._String_if oldKeySeed, JP.go.ipa.oz.lib.standard._String_if newKeySeed) throws Exception ;
  void changeOwner (JP.go.ipa.oz.lib.standard._String_if groupName, JP.go.ipa.oz.lib.standard._String_if newOwner) throws Exception ;
  void addGroupMembers (JP.go.ipa.oz.lib.standard._String_if groupName, JP.go.ipa.oz.lib.standard._Set_if members) throws Exception ;
  void showGroup () throws Exception ;
  int getDebug () throws Exception ;
  void authenticateRoot (JP.go.ipa.oz.lib.standard._String_if s) throws Exception ;
  JP.go.ipa.oz.lib.standard._OzKey_if getKey (JP.go.ipa.oz.lib.standard._String_if ozhomeID) throws Exception ;
  boolean isInUsers (JP.go.ipa.oz.lib.standard._String_if name) throws Exception ;
  boolean isInUserGroups (JP.go.ipa.oz.lib.standard._String_if name) throws Exception ;
  boolean isAuthenticated (JP.go.ipa.oz.lib.standard._String_if ozhomeID, JP.go.ipa.oz.lib.standard._OzKey_if ticketKey) throws Exception ;
  long getTicketExTime () throws Exception ;
  void authenticate (JP.go.ipa.oz.lib.standard._String_if s) throws Exception ;
  boolean isInGroupMembers (JP.go.ipa.oz.lib.standard._String_if groupName, JP.go.ipa.oz.lib.standard._String_if member) throws Exception ;
  JP.go.ipa.oz.user.secu.User_if getUser (JP.go.ipa.oz.lib.standard._String_if name) throws Exception ;
  JP.go.ipa.oz.lib.standard._OzKey_if createKey (JP.go.ipa.oz.lib.standard._String_if str) throws Exception ;
  void removeGroupMembers (JP.go.ipa.oz.lib.standard._String_if groupName, JP.go.ipa.oz.lib.standard._Set_if members) throws Exception ;
  void removeGroupMember (JP.go.ipa.oz.lib.standard._String_if groupName, JP.go.ipa.oz.lib.standard._String_if member) throws Exception ;
  JP.go.ipa.oz.user.secu.UserGroup_if getUserGroup (JP.go.ipa.oz.lib.standard._String_if name) throws Exception ;
  void addGroupMember (JP.go.ipa.oz.lib.standard._String_if groupName, JP.go.ipa.oz.lib.standard._String_if member) throws Exception ;
  JP.go.ipa.oz.lib.standard._OzKey_if getTicketKey (JP.go.ipa.oz.lib.standard._String_if name) throws Exception ;
  JP.go.ipa.oz.lib.standard._OzKey_if changeKey (JP.go.ipa.oz.lib.standard._String_if userName, JP.go.ipa.oz.lib.standard._OzKey_if newKey) throws Exception ;
  JP.go.ipa.oz.lib.standard._OzKey_if changeKey (JP.go.ipa.oz.lib.standard._String_if userName, JP.go.ipa.oz.lib.standard._String_if keySeed) throws Exception ;
  void remove (JP.go.ipa.oz.lib.standard._String_if userName) throws Exception ;
  void addTicketKey (JP.go.ipa.oz.lib.standard._String_if userName, JP.go.ipa.oz.lib.standard._OzKey_if ticketKey) throws Exception ;
  void setTicketExTime (int time) throws Exception ;
}

