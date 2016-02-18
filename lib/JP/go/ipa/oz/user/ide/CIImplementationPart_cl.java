package JP.go.ipa.oz.user.ide;

final public class CIImplementationPart_cl extends JP.go.ipa.oz.user.ide.CIPart_cl implements JP.go.ipa.oz.user.ide.CIImplementationPart_if {
  static final boolean _final_ = true;
  JP.go.ipa.oz.lib.standard._String_if OZCELL_CID;
  JP.go.ipa.oz.user.ide.CIAccessLevel_if accessLevel;
  JP.go.ipa.oz.lib.standard._SList_if publicMethodList;
  JP.go.ipa.oz.lib.standard._SList_if constructorList;
  JP.go.ipa.oz.lib.standard._SList_if attributeList;
  JP.go.ipa.oz.lib.standard._SList_if protectedMethodList;
  JP.go.ipa.oz.lib.standard._SList_if privateMethodList;
  JP.go.ipa.oz.lib.standard._String_if ifCID;
  JP.go.ipa.oz.lib.standard._String_if superImplCID;
  
  public Object _new_newCIImplementationPart (JP.go.ipa.oz.lib.standard._String_if cid, JP.go.ipa.oz.user.ide.CIAccessLevel_if acc, JP.go.ipa.oz.user.ide.CIModifier_if mod, JP.go.ipa.oz.lib.standard._String_if ifCID, JP.go.ipa.oz.lib.standard._String_if superImplCID) throws Exception  {
// 34
    super.initParams (cid, mod);
// 35
    ((JP.go.ipa.oz.user.ide.CIImplementationPart_cl)this).accessLevel = acc;
// 36
    ((JP.go.ipa.oz.user.ide.CIImplementationPart_cl)this).ifCID = ifCID;
// 37
    ((JP.go.ipa.oz.user.ide.CIImplementationPart_cl)this).superImplCID = superImplCID;
// 39
    ((JP.go.ipa.oz.user.ide.CIImplementationPart_cl)this).attributeList = (JP.go.ipa.oz.lib.standard._SList_cl) (new JP.go.ipa.oz.lib.standard._SList_cl ())._new_create ();
// 40
    ((JP.go.ipa.oz.user.ide.CIImplementationPart_cl)this).constructorList = (JP.go.ipa.oz.lib.standard._SList_cl) (new JP.go.ipa.oz.lib.standard._SList_cl ())._new_create ();
// 41
    ((JP.go.ipa.oz.user.ide.CIImplementationPart_cl)this).publicMethodList = (JP.go.ipa.oz.lib.standard._SList_cl) (new JP.go.ipa.oz.lib.standard._SList_cl ())._new_create ();
// 42
    ((JP.go.ipa.oz.user.ide.CIImplementationPart_cl)this).protectedMethodList = (JP.go.ipa.oz.lib.standard._SList_cl) (new JP.go.ipa.oz.lib.standard._SList_cl ())._new_create ();
// 43
    ((JP.go.ipa.oz.user.ide.CIImplementationPart_cl)this).privateMethodList = (JP.go.ipa.oz.lib.standard._SList_cl) (new JP.go.ipa.oz.lib.standard._SList_cl ())._new_create ();
// 45
    OZCELL_CID = (new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz.system.OzCell"));
    return this;
  }
  
  public boolean isProtected () throws Exception  {
    checkSecureInvocation ();
// 166
    boolean isProtected$val$0;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) accessLevel)) {
      try {
        isProtected$val$0 = accessLevel.isProtected ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isProtected$val$0 = accessLevel.isProtected ();
    }
// 166
    return isProtected$val$0;
  }
  
  public int getConstructorCount () throws Exception  {
    checkSecureInvocation ();
// 96
    int size$val$1;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) constructorList)) {
      try {
        size$val$1 = constructorList.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$1 = constructorList.size ();
    }
// 96
    return size$val$1;
  }
  
  public void addMember (JP.go.ipa.oz.user.ide.CIMember_if mbr) throws Exception  {
    checkSecureInvocation ();
// 54
    boolean isAttribute$val$2;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) mbr)) {
      try {
        isAttribute$val$2 = mbr.isAttribute ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isAttribute$val$2 = mbr.isAttribute ();
    }
// 54
    if (isAttribute$val$2) {{
// 55
        JP.go.ipa.oz.user.ide.CIAttribute_if att = null;
// 56
        att = (JP.go.ipa.oz.user.ide.CIAttribute_if) (mbr);
// 57
        addAttribute (att);
      }
    } else {
// 59
      boolean isConstructor$val$3;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) mbr)) {
        try {
          isConstructor$val$3 = mbr.isConstructor ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isConstructor$val$3 = mbr.isConstructor ();
      }
// 59
      if (isConstructor$val$3) {{
// 60
          JP.go.ipa.oz.user.ide.CIMethod_if cnst = null;
// 61
          cnst = (JP.go.ipa.oz.user.ide.CIMethod_if) (mbr);
// 62
          addConstructor (cnst);
        }
      } else {
// 64
        boolean isMethod$val$4;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) mbr)) {
          try {
            isMethod$val$4 = mbr.isMethod ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isMethod$val$4 = mbr.isMethod ();
        }
// 64
        if (isMethod$val$4) {{
// 65
            JP.go.ipa.oz.user.ide.CIMethod_if method = null;
// 66
            method = (JP.go.ipa.oz.user.ide.CIMethod_if) (mbr);
// 67
            addMethod (method);
          }
        }
      }
    }
  }
  
  public JP.go.ipa.oz.lib.standard._Iterator_if constructors () throws Exception  {
    checkSecureInvocation ();
// 89
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$5;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) constructorList)) {
      try {
        iterator$val$5 = constructorList.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$5 = constructorList.iterator ();
    }
// 89
    return iterator$val$5;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getInterfaceCID () throws Exception  {
    checkSecureInvocation ();
// 145
    return ifCID;
  }
  
  public boolean isRoot () throws Exception  {
    checkSecureInvocation ();
// 173
    boolean rv = false;
// 175
    rv = super.isRoot ();
// 176
    if (rv == false) {{
// 177
        boolean isequal$val$6;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) superImplCID)) {
          try {
            isequal$val$6 = superImplCID.isequal (OZCELL_CID);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isequal$val$6 = superImplCID.isequal (OZCELL_CID);
        }
// 177
        if (isequal$val$6) {{
// 178
            rv = true;
          }
        }
      }
    }
// 182
    return rv;
  }
  
  void addAttribute (JP.go.ipa.oz.user.ide.CIAttribute_if att) throws Exception  {
// 191
    JP.go.ipa.oz.lib.standard._SList_if pushBack$val$7;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) attributeList)) {
      try {
        pushBack$val$7 = attributeList.pushBack (att);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pushBack$val$7 = attributeList.pushBack (att);
    }
  }
  
  public JP.go.ipa.oz.lib.standard._Iterator_if attributes () throws Exception  {
    checkSecureInvocation ();
// 75
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$8;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) attributeList)) {
      try {
        iterator$val$8 = attributeList.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$8 = attributeList.iterator ();
    }
// 75
    return iterator$val$8;
  }
  
  public int getProtectedMethodCount () throws Exception  {
    checkSecureInvocation ();
// 124
    int size$val$9;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) protectedMethodList)) {
      try {
        size$val$9 = protectedMethodList.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$9 = protectedMethodList.size ();
    }
// 124
    return size$val$9;
  }
  
  public boolean isInterface () throws Exception  {
    checkSecureInvocation ();
// 159
    return false;
  }
  
  public int getPrivateMethodCount () throws Exception  {
    checkSecureInvocation ();
// 138
    int size$val$10;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) privateMethodList)) {
      try {
        size$val$10 = privateMethodList.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$10 = privateMethodList.size ();
    }
// 138
    return size$val$10;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getSuperImplementationCID () throws Exception  {
    checkSecureInvocation ();
// 152
    return superImplCID;
  }
  
  public JP.go.ipa.oz.lib.standard._Iterator_if protectedMethods () throws Exception  {
    checkSecureInvocation ();
// 117
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$11;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) protectedMethodList)) {
      try {
        iterator$val$11 = protectedMethodList.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$11 = protectedMethodList.iterator ();
    }
// 117
    return iterator$val$11;
  }
  
  public JP.go.ipa.oz.lib.standard._Iterator_if privateMethods () throws Exception  {
    checkSecureInvocation ();
// 131
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$12;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) privateMethodList)) {
      try {
        iterator$val$12 = privateMethodList.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$12 = privateMethodList.iterator ();
    }
// 131
    return iterator$val$12;
  }
  
  public int getPublicMethodCount () throws Exception  {
    checkSecureInvocation ();
// 110
    int size$val$13;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) publicMethodList)) {
      try {
        size$val$13 = publicMethodList.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$13 = publicMethodList.size ();
    }
// 110
    return size$val$13;
  }
  
  public JP.go.ipa.oz.lib.standard._Iterator_if publicMethods () throws Exception  {
    checkSecureInvocation ();
// 103
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$14;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) publicMethodList)) {
      try {
        iterator$val$14 = publicMethodList.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$14 = publicMethodList.iterator ();
    }
// 103
    return iterator$val$14;
  }
  
  public int getAttributeCount () throws Exception  {
    checkSecureInvocation ();
// 82
    int size$val$15;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) attributeList)) {
      try {
        size$val$15 = attributeList.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$15 = attributeList.size ();
    }
// 82
    return size$val$15;
  }
  
  protected void addMethod (JP.go.ipa.oz.user.ide.CIMethod_if method) throws Exception  {
// 204
    JP.go.ipa.oz.user.ide.CIMethodImplementation_if methodImpl = null;
// 206
    super.addMethod (method);
// 208
    methodImpl = (JP.go.ipa.oz.user.ide.CIMethodImplementation_if) (method);
// 209
    boolean isPublic$val$16;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) methodImpl)) {
      try {
        isPublic$val$16 = methodImpl.isPublic ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isPublic$val$16 = methodImpl.isPublic ();
    }
// 209
    if (isPublic$val$16) {{
// 210
        JP.go.ipa.oz.lib.standard._SList_if pushBack$val$17;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) publicMethodList)) {
          try {
            pushBack$val$17 = publicMethodList.pushBack (methodImpl);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          pushBack$val$17 = publicMethodList.pushBack (methodImpl);
        }
      }
    } else {
// 211
      boolean isProtected$val$18;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) methodImpl)) {
        try {
          isProtected$val$18 = methodImpl.isProtected ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isProtected$val$18 = methodImpl.isProtected ();
      }
// 211
      if (isProtected$val$18) {{
// 212
          JP.go.ipa.oz.lib.standard._SList_if pushBack$val$19;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) protectedMethodList)) {
            try {
              pushBack$val$19 = protectedMethodList.pushBack (methodImpl);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            pushBack$val$19 = protectedMethodList.pushBack (methodImpl);
          }
        }
      } else {{
// 214
          JP.go.ipa.oz.lib.standard._SList_if pushBack$val$20;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) privateMethodList)) {
            try {
              pushBack$val$20 = privateMethodList.pushBack (methodImpl);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            pushBack$val$20 = privateMethodList.pushBack (methodImpl);
          }
        }
      }
    }
  }
  
  void addConstructor (JP.go.ipa.oz.user.ide.CIMethod_if cnst) throws Exception  {
// 198
    JP.go.ipa.oz.lib.standard._SList_if pushBack$val$21;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) constructorList)) {
      try {
        pushBack$val$21 = constructorList.pushBack (cnst);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pushBack$val$21 = constructorList.pushBack (cnst);
    }
  }
  
  public CIImplementationPart_cl () throws Exception { super (); }
  
}

