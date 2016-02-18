package JP.go.ipa.oz.user.ide;

final public class CIInterfacePart_cl extends JP.go.ipa.oz.user.ide.CIPart_cl implements JP.go.ipa.oz.user.ide.CIInterfacePart_if {
  static final boolean _final_ = true;
  JP.go.ipa.oz.lib.standard._Collection_if superIfCIDList;
  
  public Object _new_newCIInterfacePart (JP.go.ipa.oz.lib.standard._String_if cid, JP.go.ipa.oz.user.ide.CIModifier_if modifier, JP.go.ipa.oz.lib.standard._Collection_if superIfCIDList) throws Exception  {
// 22
    super.initParams (cid, modifier);
// 23
    ((JP.go.ipa.oz.user.ide.CIInterfacePart_cl)this).superIfCIDList = superIfCIDList;
    return this;
  }
  
  public boolean isInterface () throws Exception  {
    checkSecureInvocation ();
// 46
    return true;
  }
  
  public JP.go.ipa.oz.lib.standard._Iterator_if superInterfaceCIDs () throws Exception  {
    checkSecureInvocation ();
// 60
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$54;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) superIfCIDList)) {
      try {
        iterator$val$54 = superIfCIDList.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$54 = superIfCIDList.iterator ();
    }
// 60
    return iterator$val$54;
  }
  
  public void addMember (JP.go.ipa.oz.user.ide.CIMember_if mbr) throws Exception  {
    checkSecureInvocation ();
// 32
    JP.go.ipa.oz.user.ide.CIMethod_if method = null;
// 34
    try {
// 35
      method = (JP.go.ipa.oz.user.ide.CIMethod_if) (mbr);
// 36
      addMethod (method);
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_1) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_1 = _exception_1.getOzException ();
      if (_oz_exception_1 instanceof JP.go.ipa.oz.lang._Root_if) {
        JP.go.ipa.oz.lang._Root_if ex = (JP.go.ipa.oz.lang._Root_if) _oz_exception_1;
      } else throw _exception_1;
    }
  }
  
  public int getSuperInterfaceCIDCount () throws Exception  {
    checkSecureInvocation ();
// 53
    int size$val$55;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) superIfCIDList)) {
      try {
        size$val$55 = superIfCIDList.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$55 = superIfCIDList.size ();
    }
// 53
    return size$val$55;
  }
  
  public CIInterfacePart_cl () throws Exception { super (); }
  
}

