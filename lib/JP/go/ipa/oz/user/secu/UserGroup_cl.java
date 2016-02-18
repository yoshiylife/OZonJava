package JP.go.ipa.oz.user.secu;

public class UserGroup_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.secu.UserGroup_if {
  protected JP.go.ipa.oz.lib.standard._Set_if members;
  protected JP.go.ipa.oz.lib.standard._String_if owner;
  protected JP.go.ipa.oz.lib.standard._String_if name;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._String_if name, JP.go.ipa.oz.lib.standard._String_if owner, JP.go.ipa.oz.lib.standard._Set_if users) throws Exception  {
// 36
    ((JP.go.ipa.oz.user.secu.UserGroup_cl)this).name = name;
// 36
    ((JP.go.ipa.oz.user.secu.UserGroup_cl)this).owner = owner;
// 37
    JP.go.ipa.oz.user.secu.StringComparator_if sc = null;
// 37
    sc = (JP.go.ipa.oz.user.secu.StringComparator_cl) (new JP.go.ipa.oz.user.secu.StringComparator_cl ())._new_create ();
// 38
    members = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create (sc);
// 39
    members = users;
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._Set_if getMembers () throws Exception  {
    checkSecureInvocation ();
// 43
    return members;
  }
  
  public void removeMembers (JP.go.ipa.oz.lib.standard._Set_if users) throws Exception  {
    checkSecureInvocation ();
// 64
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$0;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) users)) {
      try {
        iterator$val$0 = users.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$0 = users.iterator ();
    }
// 64
    JP.go.ipa.oz.lib.standard._Iterator_if it = iterator$val$0;
// 65
    JP.go.ipa.oz.lib.standard._String_if user = null;
// 66
    while (true) {
// 66
      boolean hasMoreElements$val$1;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
        try {
          hasMoreElements$val$1 = it.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$1 = it.hasMoreElements ();
      }
      if (!(hasMoreElements$val$1)) break;
      
      /* body */ _loop_1: {
// 67
        JP.go.ipa.oz.lang._Root_if nextElement$val$2;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
          try {
            nextElement$val$2 = it.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$2 = it.nextElement ();
        }
// 67
        user = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$2);
// 68
        removeMember (user);
      }
    }
  }
  
  public void changeOwner (JP.go.ipa.oz.lib.standard._String_if newOwner) throws Exception  {
    checkSecureInvocation ();
// 46
    if (newOwner != null) {
// 46
      owner = newOwner;
    }
  }
  
  public void addMember (JP.go.ipa.oz.lib.standard._String_if user) throws Exception  {
    checkSecureInvocation ();
// 49
    boolean contains$val$3;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) members)) {
      try {
        contains$val$3 = members.contains (user);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      contains$val$3 = members.contains (user);
    }
// 49
    if (!contains$val$3) {
// 49
      JP.go.ipa.oz.lib.standard._Set_if add$val$4;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) members)) {
        try {
          add$val$4 = members.add (user);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        add$val$4 = members.add (user);
      }
    }
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getName () throws Exception  {
    checkSecureInvocation ();
// 41
    return name;
  }
  
  public void showMembers () throws Exception  {
    checkSecureInvocation ();
// 72
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$5;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) members)) {
      try {
        iterator$val$5 = members.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$5 = members.iterator ();
    }
// 72
    JP.go.ipa.oz.lib.standard._Iterator_if it = iterator$val$5;
// 73
    JP.go.ipa.oz.lib.standard._String_if user = null;
// 73
    JP.go.ipa.oz.lib.standard._System_if s = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 74
    while (true) {
// 74
      boolean hasMoreElements$val$6;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
        try {
          hasMoreElements$val$6 = it.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$6 = it.hasMoreElements ();
      }
      if (!(hasMoreElements$val$6)) break;
      
      /* body */ _loop_1: {
// 75
        JP.go.ipa.oz.lang._Root_if nextElement$val$7;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
          try {
            nextElement$val$7 = it.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$7 = it.nextElement ();
        }
// 75
        user = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$7);
// 76
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s)) {
          try {
            s.println (user);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          s.println (user);
        }
      }
    }
  }
  
  public void removeMember (JP.go.ipa.oz.lib.standard._String_if user) throws Exception  {
    checkSecureInvocation ();
// 61
    boolean contains$val$8;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) members)) {
      try {
        contains$val$8 = members.contains (user);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      contains$val$8 = members.contains (user);
    }
// 61
    if (contains$val$8) {
// 61
      JP.go.ipa.oz.lib.standard._Collection_if remove$val$9;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) members)) {
        try {
          remove$val$9 = members.remove (user);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        remove$val$9 = members.remove (user);
      }
    }
  }
  
  public boolean contains (JP.go.ipa.oz.lib.standard._String_if name) throws Exception  {
    checkSecureInvocation ();
// 80
    boolean contains$val$10;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) members)) {
      try {
        contains$val$10 = members.contains (name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      contains$val$10 = members.contains (name);
    }
// 80
    if (contains$val$10) {
// 80
      return true;
    } else {
// 81
      return false;
    }
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getOwner () throws Exception  {
    checkSecureInvocation ();
// 42
    return owner;
  }
  
  public void addMembers (JP.go.ipa.oz.lib.standard._Set_if users) throws Exception  {
    checkSecureInvocation ();
// 53
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$11;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) users)) {
      try {
        iterator$val$11 = users.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$11 = users.iterator ();
    }
// 53
    JP.go.ipa.oz.lib.standard._Iterator_if it = iterator$val$11;
// 54
    JP.go.ipa.oz.lib.standard._String_if user = null;
// 55
    while (true) {
// 55
      boolean hasMoreElements$val$12;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
        try {
          hasMoreElements$val$12 = it.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$12 = it.hasMoreElements ();
      }
      if (!(hasMoreElements$val$12)) break;
      
      /* body */ _loop_1: {
// 56
        JP.go.ipa.oz.lang._Root_if nextElement$val$13;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
          try {
            nextElement$val$13 = it.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$13 = it.nextElement ();
        }
// 56
        user = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$13);
// 57
        addMember (user);
      }
    }
  }
  
  public UserGroup_cl () throws Exception { super (); }
  
}

