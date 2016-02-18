package JP.go.ipa.oz.user.secu;

public class OzAuthenticationServer_pcl extends JP.go.ipa.oz.user.misc.cell.Stoppable_pcl implements JP.go.ipa.oz.user.secu.OzAuthenticationServer_if {
  protected Object invoke (JP.go.ipa.oz.system.OzCell o) throws Exception {
    if (part != 2) return super.invoke (o);
    
    JP.go.ipa.oz.user.secu.OzAuthenticationServer_if g = (JP.go.ipa.oz.user.secu.OzAuthenticationServer_if) o;
    Object result;
    
    switch (selector) {
    case 0:
      return g.getMyKey();
      
    case 1:
      return g.getCipher();
      
    case 2:
      g.stop();
      return null;
    case 3:
      boolean rval$3 = g.isSameGroup(arg$0of3$member1, arg$1of3$member2);
      return new Boolean(rval$3);
    case 4:
      g.addGroup(arg$0of4$groupName, arg$1of4$owner, arg$2of4$members);
      return null;
    case 5:
      g.addUser(arg$0of5$userName, arg$1of5$keySeed);
      return null;
    case 6:
      g.showGroupMembers(arg$0of6$name);
      return null;
    case 7:
      g.showUser();
      return null;
    case 8:
      return g.getExDate(arg$0of8$userName);
      
    case 9:
      g.removeGroup(arg$0of9$groupName);
      return null;
    case 10:
      g.addExDate(arg$0of10$userName, arg$1of10$edate);
      return null;
    case 11:
      g.setMyKey(arg$0of11$oldKeySeed, arg$1of11$newKeySeed);
      return null;
    case 12:
      g.changeOwner(arg$0of12$groupName, arg$1of12$newOwner);
      return null;
    case 13:
      g.addGroupMembers(arg$0of13$groupName, arg$1of13$members);
      return null;
    case 14:
      g.showGroup();
      return null;
    case 15:
      int rval$15 = g.getDebug();
      return new Integer(rval$15);
    case 16:
      g.authenticateRoot(arg$0of16$s);
      return null;
    case 17:
      return g.getKey(arg$0of17$ozhomeID);
      
    case 18:
      boolean rval$18 = g.isInUsers(arg$0of18$name);
      return new Boolean(rval$18);
    case 19:
      boolean rval$19 = g.isInUserGroups(arg$0of19$name);
      return new Boolean(rval$19);
    case 20:
      boolean rval$20 = g.isAuthenticated(arg$0of20$ozhomeID, arg$1of20$ticketKey);
      return new Boolean(rval$20);
    case 21:
      long rval$21 = g.getTicketExTime();
      return new Long(rval$21);
    case 22:
      g.authenticate(arg$0of22$s);
      return null;
    case 23:
      boolean rval$23 = g.isInGroupMembers(arg$0of23$groupName, arg$1of23$member);
      return new Boolean(rval$23);
    case 24:
      return g.getUser(arg$0of24$name);
      
    case 25:
      return g.createKey(arg$0of25$str);
      
    case 26:
      g.removeGroupMembers(arg$0of26$groupName, arg$1of26$members);
      return null;
    case 27:
      g.removeGroupMember(arg$0of27$groupName, arg$1of27$member);
      return null;
    case 28:
      return g.getUserGroup(arg$0of28$name);
      
    case 29:
      g.addGroupMember(arg$0of29$groupName, arg$1of29$member);
      return null;
    case 30:
      return g.getTicketKey(arg$0of30$name);
      
    case 31:
      return g.changeKey(arg$0of31$userName, arg$1of31$newKey);
      
    case 32:
      return g.changeKey(arg$0of32$userName, arg$1of32$keySeed);
      
    case 33:
      g.remove(arg$0of33$userName);
      return null;
    case 34:
      g.addTicketKey(arg$0of34$userName, arg$1of34$ticketKey);
      return null;
    case 35:
      g.setTicketExTime(arg$0of35$time);
      return null;
    default:
      throw new Exception ("OzAuthenticationServer_pcl: invalid selector = " + selector);
    }
  }
  
  
  
  public JP.go.ipa.oz.lib.standard._OzKey_if getMyKey () throws Exception {
    enter ();
    try {
      part = 2;
      selector = 0;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    return (JP.go.ipa.oz.lib.standard._OzKey_if) join ();
  }
  
  
  public JP.go.ipa.oz.lib.standard._OzCipher_if getCipher () throws Exception {
    enter ();
    try {
      part = 2;
      selector = 1;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    return (JP.go.ipa.oz.lib.standard._OzCipher_if) join ();
  }
  
  
  public void stop () throws Exception {
    enter ();
    try {
      part = 2;
      selector = 2;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of3$member1;
  JP.go.ipa.oz.lib.standard._String_if arg$1of3$member2;
  
  public boolean isSameGroup (JP.go.ipa.oz.lib.standard._String_if member1, JP.go.ipa.oz.lib.standard._String_if member2) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 3;
      arg$0of3$member1 = member1;
      arg$1of3$member2 = member2;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of3$member1 = null;
      arg$1of3$member2 = null;
      leave ();
    }
    Boolean result = (Boolean) join ();
    return result.booleanValue ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of4$groupName;
  JP.go.ipa.oz.lib.standard._String_if arg$1of4$owner;
  JP.go.ipa.oz.lib.standard._Set_if arg$2of4$members;
  
  public void addGroup (JP.go.ipa.oz.lib.standard._String_if groupName, JP.go.ipa.oz.lib.standard._String_if owner, JP.go.ipa.oz.lib.standard._Set_if members) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 4;
      arg$0of4$groupName = groupName;
      arg$1of4$owner = owner;
      arg$2of4$members = members;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of4$groupName = null;
      arg$1of4$owner = null;
      arg$2of4$members = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of5$userName;
  JP.go.ipa.oz.lib.standard._String_if arg$1of5$keySeed;
  
  public void addUser (JP.go.ipa.oz.lib.standard._String_if userName, JP.go.ipa.oz.lib.standard._String_if keySeed) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 5;
      arg$0of5$userName = userName;
      arg$1of5$keySeed = keySeed;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of5$userName = null;
      arg$1of5$keySeed = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of6$name;
  
  public void showGroupMembers (JP.go.ipa.oz.lib.standard._String_if name) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 6;
      arg$0of6$name = name;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of6$name = null;
      leave ();
    }
    join ();
  }
  
  
  public void showUser () throws Exception {
    enter ();
    try {
      part = 2;
      selector = 7;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of8$userName;
  
  public JP.go.ipa.oz.lib.standard._Date_if getExDate (JP.go.ipa.oz.lib.standard._String_if userName) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 8;
      arg$0of8$userName = userName;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of8$userName = null;
      leave ();
    }
    return (JP.go.ipa.oz.lib.standard._Date_if) join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of9$groupName;
  
  public void removeGroup (JP.go.ipa.oz.lib.standard._String_if groupName) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 9;
      arg$0of9$groupName = groupName;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of9$groupName = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of10$userName;
  JP.go.ipa.oz.lib.standard._Date_if arg$1of10$edate;
  
  public void addExDate (JP.go.ipa.oz.lib.standard._String_if userName, JP.go.ipa.oz.lib.standard._Date_if edate) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 10;
      arg$0of10$userName = userName;
      arg$1of10$edate = edate;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of10$userName = null;
      arg$1of10$edate = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of11$oldKeySeed;
  JP.go.ipa.oz.lib.standard._String_if arg$1of11$newKeySeed;
  
  public void setMyKey (JP.go.ipa.oz.lib.standard._String_if oldKeySeed, JP.go.ipa.oz.lib.standard._String_if newKeySeed) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 11;
      arg$0of11$oldKeySeed = oldKeySeed;
      arg$1of11$newKeySeed = newKeySeed;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of11$oldKeySeed = null;
      arg$1of11$newKeySeed = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of12$groupName;
  JP.go.ipa.oz.lib.standard._String_if arg$1of12$newOwner;
  
  public void changeOwner (JP.go.ipa.oz.lib.standard._String_if groupName, JP.go.ipa.oz.lib.standard._String_if newOwner) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 12;
      arg$0of12$groupName = groupName;
      arg$1of12$newOwner = newOwner;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of12$groupName = null;
      arg$1of12$newOwner = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of13$groupName;
  JP.go.ipa.oz.lib.standard._Set_if arg$1of13$members;
  
  public void addGroupMembers (JP.go.ipa.oz.lib.standard._String_if groupName, JP.go.ipa.oz.lib.standard._Set_if members) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 13;
      arg$0of13$groupName = groupName;
      arg$1of13$members = members;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of13$groupName = null;
      arg$1of13$members = null;
      leave ();
    }
    join ();
  }
  
  
  public void showGroup () throws Exception {
    enter ();
    try {
      part = 2;
      selector = 14;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    join ();
  }
  
  
  public int getDebug () throws Exception {
    enter ();
    try {
      part = 2;
      selector = 15;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    Integer result = (Integer) join ();
    return result.intValue ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of16$s;
  
  public void authenticateRoot (JP.go.ipa.oz.lib.standard._String_if s) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 16;
      arg$0of16$s = s;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of16$s = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of17$ozhomeID;
  
  public JP.go.ipa.oz.lib.standard._OzKey_if getKey (JP.go.ipa.oz.lib.standard._String_if ozhomeID) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 17;
      arg$0of17$ozhomeID = ozhomeID;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of17$ozhomeID = null;
      leave ();
    }
    return (JP.go.ipa.oz.lib.standard._OzKey_if) join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of18$name;
  
  public boolean isInUsers (JP.go.ipa.oz.lib.standard._String_if name) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 18;
      arg$0of18$name = name;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of18$name = null;
      leave ();
    }
    Boolean result = (Boolean) join ();
    return result.booleanValue ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of19$name;
  
  public boolean isInUserGroups (JP.go.ipa.oz.lib.standard._String_if name) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 19;
      arg$0of19$name = name;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of19$name = null;
      leave ();
    }
    Boolean result = (Boolean) join ();
    return result.booleanValue ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of20$ozhomeID;
  JP.go.ipa.oz.lib.standard._OzKey_if arg$1of20$ticketKey;
  
  public boolean isAuthenticated (JP.go.ipa.oz.lib.standard._String_if ozhomeID, JP.go.ipa.oz.lib.standard._OzKey_if ticketKey) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 20;
      arg$0of20$ozhomeID = ozhomeID;
      arg$1of20$ticketKey = ticketKey;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of20$ozhomeID = null;
      arg$1of20$ticketKey = null;
      leave ();
    }
    Boolean result = (Boolean) join ();
    return result.booleanValue ();
  }
  
  
  public long getTicketExTime () throws Exception {
    enter ();
    try {
      part = 2;
      selector = 21;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    Long result = (Long) join ();
    return result.longValue ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of22$s;
  
  public void authenticate (JP.go.ipa.oz.lib.standard._String_if s) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 22;
      arg$0of22$s = s;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of22$s = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of23$groupName;
  JP.go.ipa.oz.lib.standard._String_if arg$1of23$member;
  
  public boolean isInGroupMembers (JP.go.ipa.oz.lib.standard._String_if groupName, JP.go.ipa.oz.lib.standard._String_if member) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 23;
      arg$0of23$groupName = groupName;
      arg$1of23$member = member;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of23$groupName = null;
      arg$1of23$member = null;
      leave ();
    }
    Boolean result = (Boolean) join ();
    return result.booleanValue ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of24$name;
  
  public JP.go.ipa.oz.user.secu.User_if getUser (JP.go.ipa.oz.lib.standard._String_if name) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 24;
      arg$0of24$name = name;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of24$name = null;
      leave ();
    }
    return (JP.go.ipa.oz.user.secu.User_if) join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of25$str;
  
  public JP.go.ipa.oz.lib.standard._OzKey_if createKey (JP.go.ipa.oz.lib.standard._String_if str) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 25;
      arg$0of25$str = str;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of25$str = null;
      leave ();
    }
    return (JP.go.ipa.oz.lib.standard._OzKey_if) join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of26$groupName;
  JP.go.ipa.oz.lib.standard._Set_if arg$1of26$members;
  
  public void removeGroupMembers (JP.go.ipa.oz.lib.standard._String_if groupName, JP.go.ipa.oz.lib.standard._Set_if members) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 26;
      arg$0of26$groupName = groupName;
      arg$1of26$members = members;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of26$groupName = null;
      arg$1of26$members = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of27$groupName;
  JP.go.ipa.oz.lib.standard._String_if arg$1of27$member;
  
  public void removeGroupMember (JP.go.ipa.oz.lib.standard._String_if groupName, JP.go.ipa.oz.lib.standard._String_if member) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 27;
      arg$0of27$groupName = groupName;
      arg$1of27$member = member;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of27$groupName = null;
      arg$1of27$member = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of28$name;
  
  public JP.go.ipa.oz.user.secu.UserGroup_if getUserGroup (JP.go.ipa.oz.lib.standard._String_if name) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 28;
      arg$0of28$name = name;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of28$name = null;
      leave ();
    }
    return (JP.go.ipa.oz.user.secu.UserGroup_if) join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of29$groupName;
  JP.go.ipa.oz.lib.standard._String_if arg$1of29$member;
  
  public void addGroupMember (JP.go.ipa.oz.lib.standard._String_if groupName, JP.go.ipa.oz.lib.standard._String_if member) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 29;
      arg$0of29$groupName = groupName;
      arg$1of29$member = member;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of29$groupName = null;
      arg$1of29$member = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of30$name;
  
  public JP.go.ipa.oz.lib.standard._OzKey_if getTicketKey (JP.go.ipa.oz.lib.standard._String_if name) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 30;
      arg$0of30$name = name;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of30$name = null;
      leave ();
    }
    return (JP.go.ipa.oz.lib.standard._OzKey_if) join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of31$userName;
  JP.go.ipa.oz.lib.standard._OzKey_if arg$1of31$newKey;
  
  public JP.go.ipa.oz.lib.standard._OzKey_if changeKey (JP.go.ipa.oz.lib.standard._String_if userName, JP.go.ipa.oz.lib.standard._OzKey_if newKey) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 31;
      arg$0of31$userName = userName;
      arg$1of31$newKey = newKey;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of31$userName = null;
      arg$1of31$newKey = null;
      leave ();
    }
    return (JP.go.ipa.oz.lib.standard._OzKey_if) join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of32$userName;
  JP.go.ipa.oz.lib.standard._String_if arg$1of32$keySeed;
  
  public JP.go.ipa.oz.lib.standard._OzKey_if changeKey (JP.go.ipa.oz.lib.standard._String_if userName, JP.go.ipa.oz.lib.standard._String_if keySeed) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 32;
      arg$0of32$userName = userName;
      arg$1of32$keySeed = keySeed;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of32$userName = null;
      arg$1of32$keySeed = null;
      leave ();
    }
    return (JP.go.ipa.oz.lib.standard._OzKey_if) join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of33$userName;
  
  public void remove (JP.go.ipa.oz.lib.standard._String_if userName) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 33;
      arg$0of33$userName = userName;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of33$userName = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of34$userName;
  JP.go.ipa.oz.lib.standard._OzKey_if arg$1of34$ticketKey;
  
  public void addTicketKey (JP.go.ipa.oz.lib.standard._String_if userName, JP.go.ipa.oz.lib.standard._OzKey_if ticketKey) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 34;
      arg$0of34$userName = userName;
      arg$1of34$ticketKey = ticketKey;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of34$userName = null;
      arg$1of34$ticketKey = null;
      leave ();
    }
    join ();
  }
  
  int arg$0of35$time;
  
  public void setTicketExTime (int time) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 35;
      arg$0of35$time = time;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of35$time = 0;
      leave ();
    }
    join ();
  }
  
  public OzAuthenticationServer_pcl (JP.go.ipa.oz.lib.standard._String_if g, String c) throws Exception { super (g, c); }
  
  public OzAuthenticationServer_pcl (JP.go.ipa.oz.lib.standard._String_if g) throws Exception { super (g); }
  
  public OzAuthenticationServer_pcl () throws Exception { super (); }
  
  
}

