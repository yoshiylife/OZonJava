package JP.go.ipa.oz.user.ide;

final public class CIMethodImplementation_cl extends JP.go.ipa.oz.user.ide.CIMethod_cl implements JP.go.ipa.oz.user.ide.CIMethodImplementation_if {
  static final boolean _final_ = true;
  JP.go.ipa.oz.lib.standard._String_if code;
  JP.go.ipa.oz.lib.standard._Collection_if refCIDList;
  JP.go.ipa.oz.lib.standard._Collection_if instCIDList;
  
  public Object _new_newCIMethodImplementation (JP.go.ipa.oz.user.ide.CIAccessLevel_if acc, JP.go.ipa.oz.user.ide.CIModifier_if mod, JP.go.ipa.oz.user.ide.CIType_if retType, JP.go.ipa.oz.lib.standard._String_if name, JP.go.ipa.oz.lib.standard._Sequence_if argTypeList, JP.go.ipa.oz.lib.standard._Collection_if refCIDList, JP.go.ipa.oz.lib.standard._Collection_if instCIDList, JP.go.ipa.oz.lib.standard._String_if code, JP.go.ipa.oz.user.ide.CIPart_if decPart) throws Exception  {
// 29
    super._new_newCIMethod (acc, mod, retType, name, argTypeList, decPart);
// 30
    ((JP.go.ipa.oz.user.ide.CIMethodImplementation_cl)this).refCIDList = refCIDList;
// 31
    ((JP.go.ipa.oz.user.ide.CIMethodImplementation_cl)this).instCIDList = instCIDList;
// 32
    ((JP.go.ipa.oz.user.ide.CIMethodImplementation_cl)this).code = code;
    return this;
  }
  
  public Object _new_newCIConstructorImplementation (JP.go.ipa.oz.lib.standard._String_if name, JP.go.ipa.oz.lib.standard._Sequence_if argTypeList, JP.go.ipa.oz.lib.standard._Collection_if refCIDList, JP.go.ipa.oz.lib.standard._Collection_if instCIDList, JP.go.ipa.oz.lib.standard._String_if code, JP.go.ipa.oz.user.ide.CIPart_if decPart) throws Exception  {
// 42
    super._new_newCIConstructor (name, argTypeList, decPart);
// 43
    ((JP.go.ipa.oz.user.ide.CIMethodImplementation_cl)this).refCIDList = refCIDList;
// 44
    ((JP.go.ipa.oz.user.ide.CIMethodImplementation_cl)this).instCIDList = instCIDList;
// 45
    ((JP.go.ipa.oz.user.ide.CIMethodImplementation_cl)this).code = code;
    return this;
  }
  
  public boolean isProtected () throws Exception  {
    checkSecureInvocation ();
// 96
    boolean isProtected$val$108;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) accessLevel)) {
      try {
        isProtected$val$108 = accessLevel.isProtected ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isProtected$val$108 = accessLevel.isProtected ();
    }
// 96
    return isProtected$val$108;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getCode () throws Exception  {
    checkSecureInvocation ();
// 54
    return code;
  }
  
  public JP.go.ipa.oz.lib.standard._Iterator_if referingCIDs () throws Exception  {
    checkSecureInvocation ();
// 103
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$109;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) refCIDList)) {
      try {
        iterator$val$109 = refCIDList.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$109 = refCIDList.iterator ();
    }
// 103
    return iterator$val$109;
  }
  
  public int getInstantiatingCIDCount () throws Exception  {
    checkSecureInvocation ();
// 61
    int size$val$110;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) instCIDList)) {
      try {
        size$val$110 = instCIDList.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$110 = instCIDList.size ();
    }
// 61
    return size$val$110;
  }
  
  public boolean isAbstract () throws Exception  {
    checkSecureInvocation ();
// 82
    boolean isAbstract$val$111;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) modifier)) {
      try {
        isAbstract$val$111 = modifier.isAbstract ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isAbstract$val$111 = modifier.isAbstract ();
    }
// 82
    return isAbstract$val$111;
  }
  
  public int getReferingCIDCount () throws Exception  {
    checkSecureInvocation ();
// 68
    int size$val$112;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) refCIDList)) {
      try {
        size$val$112 = refCIDList.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$112 = refCIDList.size ();
    }
// 68
    return size$val$112;
  }
  
  public JP.go.ipa.oz.lib.standard._Iterator_if instantiatingCIDs () throws Exception  {
    checkSecureInvocation ();
// 75
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$113;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) instCIDList)) {
      try {
        iterator$val$113 = instCIDList.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$113 = instCIDList.iterator ();
    }
// 75
    return iterator$val$113;
  }
  
  public boolean isLocked () throws Exception  {
    checkSecureInvocation ();
// 89
    boolean isLocked$val$114;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) modifier)) {
      try {
        isLocked$val$114 = modifier.isLocked ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isLocked$val$114 = modifier.isLocked ();
    }
// 89
    return isLocked$val$114;
  }
  
  public CIMethodImplementation_cl () throws Exception { super (); }
  
}

