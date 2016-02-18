package JP.go.ipa.oz.user.ide;

abstract public class CIPart_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.ide.CIPart_if {
  protected JP.go.ipa.oz.lib.standard._String_if ROOT_IF_CID;
  protected JP.go.ipa.oz.lib.standard._String_if labelName;
  protected JP.go.ipa.oz.lib.standard._String_if cid;
  protected JP.go.ipa.oz.lib.standard._String_if ROOT_CL_CID;
  protected JP.go.ipa.oz.lib.standard._SList_if methodList;
  protected JP.go.ipa.oz.user.ide.CIModifier_if modifier;
  
  protected void initParams (JP.go.ipa.oz.lib.standard._String_if cid, JP.go.ipa.oz.user.ide.CIModifier_if mod) throws Exception  {
// 105
    ((JP.go.ipa.oz.user.ide.CIPart_cl)this).cid = cid;
// 106
    ((JP.go.ipa.oz.user.ide.CIPart_cl)this).modifier = mod;
// 107
    ((JP.go.ipa.oz.user.ide.CIPart_cl)this).methodList = (JP.go.ipa.oz.lib.standard._SList_cl) (new JP.go.ipa.oz.lib.standard._SList_cl ())._new_create ();
// 109
    ROOT_IF_CID = (new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz.lang._Root_if"));
// 110
    ROOT_CL_CID = (new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz.lang._Root_cl"));
  }
  
  public boolean isFinal () throws Exception  {
    checkSecureInvocation ();
// 59
    boolean isFinal$val$46;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) modifier)) {
      try {
        isFinal$val$46 = modifier.isFinal ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isFinal$val$46 = modifier.isFinal ();
    }
// 59
    return isFinal$val$46;
  }
  
  public JP.go.ipa.oz.lib.standard._Iterator_if methods () throws Exception  {
    checkSecureInvocation ();
// 81
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$47;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) methodList)) {
      try {
        iterator$val$47 = methodList.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$47 = methodList.iterator ();
    }
// 81
    return iterator$val$47;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getLabelName () throws Exception  {
    checkSecureInvocation ();
// 38
    return labelName;
  }
  
  public int getMethodCount () throws Exception  {
    checkSecureInvocation ();
// 88
    int size$val$48;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) methodList)) {
      try {
        size$val$48 = methodList.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$48 = methodList.size ();
    }
// 88
    return size$val$48;
  }
  
  public abstract void addMember (JP.go.ipa.oz.user.ide.CIMember_if mbr) throws Exception  ;
  public boolean isAbstract () throws Exception  {
    checkSecureInvocation ();
// 45
    boolean isAbstract$val$49;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) modifier)) {
      try {
        isAbstract$val$49 = modifier.isAbstract ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isAbstract$val$49 = modifier.isAbstract ();
    }
// 45
    return isAbstract$val$49;
  }
  
  public abstract boolean isInterface () throws Exception  ;
  public boolean isRoot () throws Exception  {
    checkSecureInvocation ();
    boolean bool$val$9;
    
// 70
    boolean isequal$val$50;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cid)) {
      try {
        isequal$val$50 = cid.isequal (ROOT_IF_CID);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$50 = cid.isequal (ROOT_IF_CID);
    }
    bool$val$9 = isequal$val$50;
    if (!bool$val$9) {
// 70
      boolean isequal$val$51;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cid)) {
        try {
          isequal$val$51 = cid.isequal (ROOT_CL_CID);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isequal$val$51 = cid.isequal (ROOT_CL_CID);
      }
      bool$val$9 = isequal$val$51;
    }
// 70
    if (bool$val$9) {{
// 71
        return true;
      }
    } else {{
// 73
        return false;
      }
    }
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getCID () throws Exception  {
    checkSecureInvocation ();
// 31
    return cid;
  }
  
  public boolean isCell () throws Exception  {
    checkSecureInvocation ();
// 52
    boolean isCell$val$52;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) modifier)) {
      try {
        isCell$val$52 = modifier.isCell ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isCell$val$52 = modifier.isCell ();
    }
// 52
    return isCell$val$52;
  }
  
  public void setLabelName (JP.go.ipa.oz.lib.standard._String_if label) throws Exception  {
    checkSecureInvocation ();
// 96
    ((JP.go.ipa.oz.user.ide.CIPart_cl)this).labelName = label;
  }
  
  protected void addMethod (JP.go.ipa.oz.user.ide.CIMethod_if method) throws Exception  {
// 117
    JP.go.ipa.oz.lib.standard._SList_if pushBack$val$53;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) methodList)) {
      try {
        pushBack$val$53 = methodList.pushBack (method);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pushBack$val$53 = methodList.pushBack (method);
    }
  }
  
  public CIPart_cl () throws Exception { super (); }
  
}

