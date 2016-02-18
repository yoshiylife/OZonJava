package JP.go.ipa.oz.user.apl.fm;

public class FMObjectComparator_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.apl.fm.FMObjectComparator_if {
  
  public Object _new_create () throws Exception  {
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._Comparator_if duplicate () throws Exception  {
    checkSecureInvocation ();
// 29
    JP.go.ipa.oz.user.apl.fm.FMObjectComparator_if fc = null;
// 30
    fc = (JP.go.ipa.oz.user.apl.fm.FMObjectComparator_cl) (new JP.go.ipa.oz.user.apl.fm.FMObjectComparator_cl ())._new_create ();
// 32
    return fc;
  }
  
  public boolean compare (JP.go.ipa.oz.lang._Root_if src1, JP.go.ipa.oz.lang._Root_if src2) throws Exception  {
    checkSecureInvocation ();
// 10
    JP.go.ipa.oz.user.apl.fm.FMObject_if fm1 = null, fm2 = null;
// 11
    fm1 = (JP.go.ipa.oz.user.apl.fm.FMObject_if) (src1);
// 12
    fm2 = (JP.go.ipa.oz.user.apl.fm.FMObject_if) (src2);
// 13
    boolean isEqualFMObject$val$273;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fm1)) {
      try {
        isEqualFMObject$val$273 = fm1.isEqualFMObject (fm2);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isEqualFMObject$val$273 = fm1.isEqualFMObject (fm2);
    }
// 13
    return isEqualFMObject$val$273;
  }
  
  public int hash (JP.go.ipa.oz.lang._Root_if obj) throws Exception  {
    checkSecureInvocation ();
// 17
    JP.go.ipa.oz.lib.standard._StringComparator_if strcmp = null;
// 18
    JP.go.ipa.oz.user.apl.fm.FMObject_if fmobj = null;
// 19
    JP.go.ipa.oz.lib.standard._String_if str = null;
// 21
    fmobj = (JP.go.ipa.oz.user.apl.fm.FMObject_if) (obj);
// 22
    strcmp = (JP.go.ipa.oz.lib.standard._StringComparator_cl) (new JP.go.ipa.oz.lib.standard._StringComparator_cl ())._new_create ();
// 24
    JP.go.ipa.oz.user.apl.fm.Pointer_if getIdentifier$val$274;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fmobj)) {
      try {
        getIdentifier$val$274 = fmobj.getIdentifier ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getIdentifier$val$274 = fmobj.getIdentifier ();
    }
// 24
    JP.go.ipa.oz.lib.standard._String_if asString$val$275;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getIdentifier$val$274)) {
      try {
        asString$val$275 = getIdentifier$val$274.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$275 = getIdentifier$val$274.asString ();
    }
// 24
    str = asString$val$275;
// 25
    return strcmp.hash (str);
  }
  
  public FMObjectComparator_cl () throws Exception { super (); }
  
}

