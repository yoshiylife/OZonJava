package JP.go.ipa.oz.user.apl.fm;

public class Archiver_cl extends JP.go.ipa.oz.system.OzCell implements JP.go.ipa.oz.user.apl.fm.Archiver_if {
  static final boolean _global_ = true;
  JP.go.ipa.oz.user.apl.fm.Overseer_if overseer;
  JP.go.ipa.oz.lib.standard._Dictionary_if list;
  
  public void remove (JP.go.ipa.oz.user.apl.fm.Pointer_if ptr) throws Exception  {
    checkSecureInvocation ();
// 33
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
      try {
        overseer.permit (ptr);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      overseer.permit (ptr);
    }
// 34
    JP.go.ipa.oz.lib.standard._Dictionary_if remove$val$210;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) list)) {
      try {
        remove$val$210 = list.remove (ptr);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      remove$val$210 = list.remove (ptr);
    }
  }
  
  public void initialize () throws Exception  {
    checkSecureInvocation ();
// 16
    JP.go.ipa.oz.user.apl.fm.PointerComparator_if pc = (JP.go.ipa.oz.user.apl.fm.PointerComparator_cl) (new JP.go.ipa.oz.user.apl.fm.PointerComparator_cl ())._new_create ();
// 17
    list = (JP.go.ipa.oz.lib.standard._Dictionary_cl) (new JP.go.ipa.oz.lib.standard._Dictionary_cl ())._new_create (pc, pc);
// 18
    overseer = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
  }
  
  public void add (JP.go.ipa.oz.user.apl.fm.Pointer_if oid, JP.go.ipa.oz.user.apl.fm.Pointer_if nid) throws Exception  {
    checkSecureInvocation ();
// 26
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
      try {
        overseer.permit (oid);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      overseer.permit (oid);
    }
// 27
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
      try {
        overseer.permit (nid);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      overseer.permit (nid);
    }
// 28
    JP.go.ipa.oz.lib.standard._Association_if assoc = (JP.go.ipa.oz.lib.standard._Association_cl) (new JP.go.ipa.oz.lib.standard._Association_cl ())._new_create (oid, nid);
// 29
    JP.go.ipa.oz.lib.standard._Dictionary_if put$val$211;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) list)) {
      try {
        put$val$211 = list.put (assoc);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      put$val$211 = list.put (assoc);
    }
  }
  
  public void quiet () throws Exception  {
    checkSecureInvocation ();
// 22
    flushCell ();
  }
  
  public JP.go.ipa.oz.user.apl.fm.Pointer_if find (JP.go.ipa.oz.user.apl.fm.Pointer_if ptr) throws Exception  {
    checkSecureInvocation ();
// 38
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
      try {
        overseer.permit (ptr);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      overseer.permit (ptr);
    }
// 39
    JP.go.ipa.oz.user.apl.fm.Pointer_if rtn = null;
// 40
    JP.go.ipa.oz.lang._Root_if get$val$212;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) list)) {
      try {
        get$val$212 = list.get (ptr);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      get$val$212 = list.get (ptr);
    }
// 40
    rtn = (JP.go.ipa.oz.user.apl.fm.Pointer_if) (get$val$212);
// 41
    return rtn;
  }
  
  public Archiver_cl () { super ("JP.go.ipa.oz.user.apl.fm.Archiver_pcl"); }
  
  public Archiver_cl (String proxy_id) { super (proxy_id); }
  
}

