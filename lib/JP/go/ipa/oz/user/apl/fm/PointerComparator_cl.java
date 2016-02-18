package JP.go.ipa.oz.user.apl.fm;

public class PointerComparator_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.apl.fm.PointerComparator_if {
  
  public Object _new_create () throws Exception  {
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._Comparator_if duplicate () throws Exception  {
    checkSecureInvocation ();
// 38
    JP.go.ipa.oz.user.apl.fm.PointerComparator_if pc = null;
// 39
    pc = (JP.go.ipa.oz.user.apl.fm.PointerComparator_cl) (new JP.go.ipa.oz.user.apl.fm.PointerComparator_cl ())._new_create ();
// 41
    return pc;
  }
  
  public boolean compare (JP.go.ipa.oz.lang._Root_if src1, JP.go.ipa.oz.lang._Root_if src2) throws Exception  {
    checkSecureInvocation ();
// 10
    JP.go.ipa.oz.user.apl.fm.Pointer_if po1 = null, po2 = null;
// 11
    po1 = (JP.go.ipa.oz.user.apl.fm.Pointer_if) (src1);
// 12
    po2 = (JP.go.ipa.oz.user.apl.fm.Pointer_if) (src2);
// 13
    JP.go.ipa.oz.user.apl.fm.Overseer_if over = null;
// 14
    over = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 15
    over.permit (po1);
// 16
    over.permit (po2);
// 17
    boolean isEqualPointer$val$208;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) po1)) {
      try {
        isEqualPointer$val$208 = po1.isEqualPointer (po2);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isEqualPointer$val$208 = po1.isEqualPointer (po2);
    }
// 17
    return isEqualPointer$val$208;
  }
  
  public int hash (JP.go.ipa.oz.lang._Root_if obj) throws Exception  {
    checkSecureInvocation ();
// 21
    JP.go.ipa.oz.lib.standard._StringComparator_if strcmp = null;
// 22
    JP.go.ipa.oz.user.apl.fm.Pointer_if point = null;
// 23
    JP.go.ipa.oz.lib.standard._String_if str = null;
// 24
    JP.go.ipa.oz.user.apl.fm.Overseer_if over = null;
// 26
    over = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 29
    point = (JP.go.ipa.oz.user.apl.fm.Pointer_if) (obj);
// 30
    strcmp = (JP.go.ipa.oz.lib.standard._StringComparator_cl) (new JP.go.ipa.oz.lib.standard._StringComparator_cl ())._new_create ();
// 32
    over.permit (point);
// 33
    JP.go.ipa.oz.lib.standard._String_if asString$val$209;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) point)) {
      try {
        asString$val$209 = point.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$209 = point.asString ();
    }
// 33
    str = asString$val$209;
// 34
    return strcmp.hash (str);
  }
  
  public PointerComparator_cl () throws Exception { super (); }
  
}

