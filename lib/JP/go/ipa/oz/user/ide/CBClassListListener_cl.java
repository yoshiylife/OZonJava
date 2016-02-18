package JP.go.ipa.oz.user.ide;

final public class CBClassListListener_cl extends JP.go.ipa.oz.lib.standard._ActionListener_cl implements JP.go.ipa.oz.user.ide.CBClassListListener_if {
  static final boolean _final_ = true;
  JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if dialogQue;
  JP.go.ipa.oz.lib.standard._System_if system;
  JP.go.ipa.oz.user.ide.CBPartView_if partView;
  JP.go.ipa.oz.user.ide.CBClassList_if classList;
  
  public Object _new_newCBClassListListener (JP.go.ipa.oz.user.ide.CBClassList_if list, JP.go.ipa.oz.user.ide.CBPartView_if pv, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if evtQue) throws Exception  {
// 28
    super._new_newActionListener (evtQue);
// 29
    initParam (list, pv);
// 30
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
    return this;
  }
  
  public void actionPerformed (JP.go.ipa.oz.lib.standard._ActionEvent_if evt) throws Exception  {
    checkSecureInvocation ();
// 39
    int index = 0;
// 40
    JP.go.ipa.oz.lib.standard._String_if cid = null;
// 41
    JP.go.ipa.oz.user.ide.CBExceptionDialog_if exDialog = null;
// 43
    int getSelectedIndex$val$243;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classList)) {
      try {
        getSelectedIndex$val$243 = classList.getSelectedIndex ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedIndex$val$243 = classList.getSelectedIndex ();
    }
// 43
    index = getSelectedIndex$val$243;
// 44
    if (index != -1) {{
// 45
        JP.go.ipa.oz.lib.standard._String_if getCID$val$244;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classList)) {
          try {
            getCID$val$244 = classList.getCID (index);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getCID$val$244 = classList.getCID (index);
        }
// 45
        cid = getCID$val$244;
// 46
        JP.go.ipa.oz.lib.standard._String_if string$44 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCBClassListListener#actionPerformed: "));
        
// 46
        JP.go.ipa.oz.lib.standard._String_if asString$val$245;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cid)) {
          try {
            asString$val$245 = cid.asString ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          asString$val$245 = cid.asString ();
        }
// 46
        JP.go.ipa.oz.lib.standard._String_if concat$val$246;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$44)) {
          try {
            concat$val$246 = string$44.concat (asString$val$245);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          concat$val$246 = string$44.concat (asString$val$245);
        }
// 46
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.debugPrintln (concat$val$246);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.debugPrintln (concat$val$246);
        }
// 47
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classList)) {
          try {
            classList.deselect (index);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          classList.deselect (index);
        }
// 48
        try {
// 49
          JP.go.ipa.oz.user.ide.ClassBrowser_if getClassBrowser$val$247;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) partView)) {
            try {
              getClassBrowser$val$247 = partView.getClassBrowser ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getClassBrowser$val$247 = partView.getClassBrowser ();
          }
// 49
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getClassBrowser$val$247)) {
            try {
              getClassBrowser$val$247.show (cid);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getClassBrowser$val$247.show (cid);
          }
        }
        catch (JP.go.ipa.oz.lang.OzException _exception_1) {
          JP.go.ipa.oz.lang._Root_if _oz_exception_1 = _exception_1.getOzException ();
          if (_oz_exception_1 instanceof JP.go.ipa.oz.user.ide.CIException_if) {
            JP.go.ipa.oz.user.ide.CIException_if ex = (JP.go.ipa.oz.user.ide.CIException_if) _oz_exception_1;
// 51
            JP.go.ipa.oz.lib.standard._String_if asString$val$248;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ex)) {
              try {
                asString$val$248 = ex.asString ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              asString$val$248 = ex.asString ();
            }
// 51
            exDialog = (JP.go.ipa.oz.user.ide.CBExceptionDialog_cl) (new JP.go.ipa.oz.user.ide.CBExceptionDialog_cl ())._new_newCBExceptionDialog (partView, asString$val$248, dialogQue);
          } else throw _exception_1;
        }
      }
    }
  }
  
  void initParam (JP.go.ipa.oz.user.ide.CBClassList_if list, JP.go.ipa.oz.user.ide.CBPartView_if pv) throws Exception  {
// 63
    classList = list;
// 64
    partView = pv;
// 65
    dialogQue = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
  }
  
  public CBClassListListener_cl () throws Exception { super (); }
  
}

