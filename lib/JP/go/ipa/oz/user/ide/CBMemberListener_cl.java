package JP.go.ipa.oz.user.ide;

final public class CBMemberListener_cl extends JP.go.ipa.oz.lib.standard._MouseListener_cl implements JP.go.ipa.oz.user.ide.CBMemberListener_if {
  static final boolean _final_ = true;
  JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if dialogQue;
  JP.go.ipa.oz.lib.standard._System_if system;
  JP.go.ipa.oz.user.ide.CBMemberListView_if memberListView;
  
  public Object _new_newCBMemberListener (JP.go.ipa.oz.user.ide.CBMemberListView_if mv, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if evtQue) throws Exception  {
// 26
    super._new_newMouseListener (evtQue);
// 28
    memberListView = mv;
// 29
    dialogQue = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 31
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 32
    if (isGreen ()) {{
// 33
        JP.go.ipa.oz.lib.standard._String_if string$48 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCBMemberListener#new: green"));
        
// 33
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.debugPrintln (string$48);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.debugPrintln (string$48);
        }
      }
    } else {{
// 35
        JP.go.ipa.oz.lib.standard._String_if string$49 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCBMemberListener#new: red"));
        
// 35
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.debugPrintln (string$49);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.debugPrintln (string$49);
        }
      }
    }
    return this;
  }
  
  public void mouseReleased (JP.go.ipa.oz.lib.standard._MouseEvent_if evt) throws Exception  {
    checkSecureInvocation ();
// 45
    JP.go.ipa.oz.user.ide.CBMemberLabel_if source = null;
// 46
    JP.go.ipa.oz.user.ide.CIMember_if member = null;
// 48
    JP.go.ipa.oz.lang._Root_if getSource$val$268;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) evt)) {
      try {
        getSource$val$268 = evt.getSource ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSource$val$268 = evt.getSource ();
    }
// 48
    source = (JP.go.ipa.oz.user.ide.CBMemberLabel_if) (getSource$val$268);
// 49
    JP.go.ipa.oz.user.ide.CIMember_if getMember$val$269;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) source)) {
      try {
        getMember$val$269 = source.getMember ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getMember$val$269 = source.getMember ();
    }
// 49
    member = getMember$val$269;
// 50
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) memberListView)) {
      try {
        memberListView.select (member);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      memberListView.select (member);
    }
  }
  
  public CBMemberListener_cl () throws Exception { super (); }
  
}

