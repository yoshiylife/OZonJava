package JP.go.ipa.oz.user.ide;

final public class CBIGraphNode_cl extends JP.go.ipa.oz.lib.standard._Rectangle_cl implements JP.go.ipa.oz.user.ide.CBIGraphNode_if {
  static final boolean _final_ = true;
  int level;
  boolean marked;
  JP.go.ipa.oz.lib.standard._SList_if superNodeList;
  JP.go.ipa.oz.lib.standard._SList_if subNodeList;
  JP.go.ipa.oz.user.ide.CIPart_if thisPart;
  
  public Object _new_newCBIGraphNode (JP.go.ipa.oz.user.ide.CIPart_if part) throws Exception  {
// 28
    super._new_newRectangle (0, 0, 0, 0);
// 29
    thisPart = part;
// 30
    marked = false;
// 31
    superNodeList = (JP.go.ipa.oz.lib.standard._SList_cl) (new JP.go.ipa.oz.lib.standard._SList_cl ())._new_create ();
// 32
    subNodeList = (JP.go.ipa.oz.lib.standard._SList_cl) (new JP.go.ipa.oz.lib.standard._SList_cl ())._new_create ();
// 33
    level = 0;
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getLabelName () throws Exception  {
    checkSecureInvocation ();
// 67
    JP.go.ipa.oz.lib.standard._String_if getLabelName$val$337;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) thisPart)) {
      try {
        getLabelName$val$337 = thisPart.getLabelName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getLabelName$val$337 = thisPart.getLabelName ();
    }
// 67
    return getLabelName$val$337;
  }
  
  public void setMark (boolean mk) throws Exception  {
    checkSecureInvocation ();
// 109
    marked = mk;
  }
  
  public void setLevel (int lv) throws Exception  {
    checkSecureInvocation ();
// 102
    ((JP.go.ipa.oz.user.ide.CBIGraphNode_cl)this).level = lv;
  }
  
  public int getSuperClassCount () throws Exception  {
    checkSecureInvocation ();
// 81
    int size$val$338;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) superNodeList)) {
      try {
        size$val$338 = superNodeList.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$338 = superNodeList.size ();
    }
// 81
    return size$val$338;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getCID () throws Exception  {
    checkSecureInvocation ();
// 60
    JP.go.ipa.oz.lib.standard._String_if getCID$val$339;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) thisPart)) {
      try {
        getCID$val$339 = thisPart.getCID ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getCID$val$339 = thisPart.getCID ();
    }
// 60
    return getCID$val$339;
  }
  
  public JP.go.ipa.oz.lib.standard._Iterator_if subNodes () throws Exception  {
    checkSecureInvocation ();
// 116
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$340;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subNodeList)) {
      try {
        iterator$val$340 = subNodeList.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$340 = subNodeList.iterator ();
    }
// 116
    return iterator$val$340;
  }
  
  public boolean isMarked () throws Exception  {
    checkSecureInvocation ();
// 95
    return marked;
  }
  
  public int getLevel () throws Exception  {
    checkSecureInvocation ();
// 88
    return level;
  }
  
  public int getSubClassCount () throws Exception  {
    checkSecureInvocation ();
// 74
    int size$val$341;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subNodeList)) {
      try {
        size$val$341 = subNodeList.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$341 = subNodeList.size ();
    }
// 74
    return size$val$341;
  }
  
  public void addSuperNode (JP.go.ipa.oz.user.ide.CBIGraphNode_if nd) throws Exception  {
    checkSecureInvocation ();
// 51
    boolean contains$val$342;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) superNodeList)) {
      try {
        contains$val$342 = superNodeList.contains (nd);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      contains$val$342 = superNodeList.contains (nd);
    }
// 51
    if (!(contains$val$342)) {{
// 52
        JP.go.ipa.oz.lib.standard._SList_if pushBack$val$343;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) superNodeList)) {
          try {
            pushBack$val$343 = superNodeList.pushBack (nd);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          pushBack$val$343 = superNodeList.pushBack (nd);
        }
      }
    }
  }
  
  public JP.go.ipa.oz.lib.standard._Iterator_if superNodes () throws Exception  {
    checkSecureInvocation ();
// 123
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$344;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) superNodeList)) {
      try {
        iterator$val$344 = superNodeList.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$344 = superNodeList.iterator ();
    }
// 123
    return iterator$val$344;
  }
  
  public void addSubNode (JP.go.ipa.oz.user.ide.CBIGraphNode_if nd) throws Exception  {
    checkSecureInvocation ();
// 42
    boolean contains$val$345;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subNodeList)) {
      try {
        contains$val$345 = subNodeList.contains (nd);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      contains$val$345 = subNodeList.contains (nd);
    }
// 42
    if (!(contains$val$345)) {{
// 43
        JP.go.ipa.oz.lib.standard._SList_if pushBack$val$346;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subNodeList)) {
          try {
            pushBack$val$346 = subNodeList.pushBack (nd);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          pushBack$val$346 = subNodeList.pushBack (nd);
        }
      }
    }
  }
  
  public CBIGraphNode_cl () throws Exception { super (); }
  
}

