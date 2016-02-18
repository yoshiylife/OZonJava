package JP.go.ipa.oz.user.ide;

final public class CBClassList_cl extends JP.go.ipa.oz.lib.standard._List_cl implements JP.go.ipa.oz.user.ide.CBClassList_if {
  static final boolean _final_ = true;
  boolean forLabel;
  JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if eventQue;
  JP.go.ipa.oz.user.ide.CBPartView_if partView;
  JP.go.ipa.oz.lib.standard._Array_if cidList;
  
  public Object _new_newCBClassList (int size, JP.go.ipa.oz.user.ide.CBPartView_if pv) throws Exception  {
// 26
    super._new_newList (size);
// 27
    initParams (pv);
// 28
    initGUI ();
    return this;
  }
  
  void initParams (JP.go.ipa.oz.user.ide.CBPartView_if pv) throws Exception  {
// 81
    partView = pv;
// 82
    eventQue = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
  }
  
  public void setImplementationList (JP.go.ipa.oz.lib.standard._Array_if cids, JP.go.ipa.oz.user.ide.School_if school) throws Exception  {
    checkSecureInvocation ();
// 62
    setList (cids, school, false);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getCID (int index) throws Exception  {
    checkSecureInvocation ();
// 37
    JP.go.ipa.oz.lib.standard._String_if cid = null;
// 39
    JP.go.ipa.oz.lang._Root_if at$val$249;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cidList)) {
      try {
        at$val$249 = cidList.at (index);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      at$val$249 = cidList.at (index);
    }
// 39
    cid = (JP.go.ipa.oz.lib.standard._String_if) (at$val$249);
// 41
    return cid;
  }
  
  public void setInterfaceList (JP.go.ipa.oz.lib.standard._Array_if cids, JP.go.ipa.oz.user.ide.School_if school) throws Exception  {
    checkSecureInvocation ();
// 55
    setList (cids, school, true);
  }
  
  void initGUI () throws Exception  {
// 71
    JP.go.ipa.oz.user.ide.CBClassListListener_if listener = null;
// 73
    listener = (JP.go.ipa.oz.user.ide.CBClassListListener_cl) (new JP.go.ipa.oz.user.ide.CBClassListListener_cl ())._new_newCBClassListListener (this, partView, eventQue);
// 74
    addActionListener (listener);
  }
  
  void setList (JP.go.ipa.oz.lib.standard._Array_if cids, JP.go.ipa.oz.user.ide.School_if school, boolean isInterface) throws Exception  {
// 89
    JP.go.ipa.oz.lib.standard._String_if cid = null, label = null;
// 90
    int length = 0;
// 91
    int i = 0;
// 93
    removeAll ();
// 94
    forLabel = true;
// 95
    cidList = cids;
// 96
    if (cidList != null) {{
// 97
        int size$val$250;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cidList)) {
          try {
            size$val$250 = cidList.size ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          size$val$250 = cidList.size ();
        }
// 97
        length = size$val$250;
// 98
        /* for loop starting here */ {
          /* initialization part */
// 98
          i = 0;
          
          for (;;) {
            /* boolean expression part */
            if (!(i < length)) break;
            
            /* body */ _loop_1: {
// 99
              JP.go.ipa.oz.lang._Root_if at$val$251;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cidList)) {
                try {
                  at$val$251 = cidList.at (i);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                at$val$251 = cidList.at (i);
              }
// 99
              cid = (JP.go.ipa.oz.lib.standard._String_if) (at$val$251);
// 100
              if (school == null) {{
// 101
                  add (cid);
                }
              } else {{
// 103
                  if (isInterface) {{
// 104
                      JP.go.ipa.oz.lib.standard._String_if getNameOfInterface$val$252;
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
                        try {
                          getNameOfInterface$val$252 = school.getNameOfInterface (cid);
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        getNameOfInterface$val$252 = school.getNameOfInterface (cid);
                      }
// 104
                      label = getNameOfInterface$val$252;
                    }
                  } else {{
// 106
                      JP.go.ipa.oz.lib.standard._String_if getNameOfImplementation$val$253;
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
                        try {
                          getNameOfImplementation$val$253 = school.getNameOfImplementation (cid);
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        getNameOfImplementation$val$253 = school.getNameOfImplementation (cid);
                      }
// 106
                      label = getNameOfImplementation$val$253;
                    }
                  }
// 108
                  add (label);
                }
              }
            }
            /* iteration part */
// 98
            i++;
          }
        }
      }
    }
  }
  
  public void setList (JP.go.ipa.oz.lib.standard._Array_if cids) throws Exception  {
    checkSecureInvocation ();
// 48
    setList (cids, null, false);
  }
  
  public CBClassList_cl () throws Exception { super (); }
  
}

