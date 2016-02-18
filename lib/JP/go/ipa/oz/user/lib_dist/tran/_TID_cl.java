package JP.go.ipa.oz.user.lib_dist.tran;

public class _TID_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.lib_dist.tran._TID_if {
  JP.go.ipa.oz.lib.standard._String_if GOL;
  int id;
  int lockMode;
  
  public Object _new_create (int i, JP.go.ipa.oz.lib.standard._String_if s) throws Exception  {
// 16
    id = i;
// 16
    GOL = s;
    return this;
  }
  
  public Object _new_create () throws Exception  {
// 15
    id = 0;
// 15
    GOL = (new JP.go.ipa.oz.lib.standard._String_cl(""));
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getTidGOL () throws Exception  {
    checkSecureInvocation ();
// 24
    return GOL;
  }
  
  public boolean equal (JP.go.ipa.oz.user.lib_dist.tran._TID_if tid) throws Exception  {
    checkSecureInvocation ();
    boolean bool$val$0;
    
// 26
    int getID$val$0;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tid)) {
      try {
        getID$val$0 = tid.getID ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getID$val$0 = tid.getID ();
    }
    bool$val$0 = (id == getID$val$0);
    if (bool$val$0) {
// 26
      JP.go.ipa.oz.lib.standard._String_if getTidGOL$val$1;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tid)) {
        try {
          getTidGOL$val$1 = tid.getTidGOL ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getTidGOL$val$1 = tid.getTidGOL ();
      }
// 26
      int compareTo$val$2;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getTidGOL$val$1)) {
        try {
          compareTo$val$2 = getTidGOL$val$1.compareTo (GOL);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        compareTo$val$2 = getTidGOL$val$1.compareTo (GOL);
      }
      bool$val$0 = (compareTo$val$2 == 0);
    }
// 26
    if (bool$val$0) {
// 26
      return true;
    } else {
// 27
      return false;
    }
  }
  
  public void init () throws Exception  {
    checkSecureInvocation ();
// 29
    id = 0;
// 29
    GOL = (new JP.go.ipa.oz.lib.standard._String_cl(""));
  }
  
  public void setID (int i) throws Exception  {
    checkSecureInvocation ();
// 22
    id = i;
  }
  
  public void set (int i, JP.go.ipa.oz.lib.standard._String_if s) throws Exception  {
    checkSecureInvocation ();
// 21
    id = i;
// 21
    GOL = s;
  }
  
  public int getID () throws Exception  {
    checkSecureInvocation ();
// 23
    return id;
  }
  
  public int getLockMode () throws Exception  {
    checkSecureInvocation ();
// 31
    return lockMode;
  }
  
  public void setLockMode (int i) throws Exception  {
    checkSecureInvocation ();
// 30
    lockMode = i;
  }
  
  public _TID_cl () throws Exception { super (); }
  
}

