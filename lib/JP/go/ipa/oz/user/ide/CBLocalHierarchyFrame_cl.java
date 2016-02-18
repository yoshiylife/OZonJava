package JP.go.ipa.oz.user.ide;

final public class CBLocalHierarchyFrame_cl extends JP.go.ipa.oz.user.ide.CBDialog_cl implements JP.go.ipa.oz.user.ide.CBLocalHierarchyFrame_if {
  static final boolean _final_ = true;
  JP.go.ipa.oz.lib.standard._System_if system;
  JP.go.ipa.oz.lib.standard._ScrollPane_if hViewContainer;
  JP.go.ipa.oz.user.ide.CBLocalHierarchyCanvas_if hView;
  JP.go.ipa.oz.user.ide.CBPartView_if partView;
  JP.go.ipa.oz.lib.standard._Label_if titleLabel;
  
  public Object _new_newCBLocalHierarchyFrame (JP.go.ipa.oz.user.ide.CBPartView_if pv, JP.go.ipa.oz.user.ide.CBIGraph_if g) throws Exception  {
// 28
    JP.go.ipa.oz.lib.standard._String_if title = null;
// 30
    JP.go.ipa.oz.lib.standard._String_if string$25 = (new JP.go.ipa.oz.lib.standard._String_cl("Hierarchy Browser - "));
    
// 30
    JP.go.ipa.oz.lib.standard._String_if getCID$val$202;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pv)) {
      try {
        getCID$val$202 = pv.getCID ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getCID$val$202 = pv.getCID ();
    }
// 30
    JP.go.ipa.oz.lib.standard._String_if concat$val$203;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$25)) {
      try {
        concat$val$203 = string$25.concat (getCID$val$202);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$203 = string$25.concat (getCID$val$202);
    }
// 30
    title = concat$val$203;
// 31
    super._new_newCBDialog (pv, title, false);
// 33
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 34
    initParams (pv);
// 35
    initGUI (g);
    return this;
  }
  
  void layoutComponents () throws Exception  {
// 80
    JP.go.ipa.oz.lib.standard._GridBagLayout_if layout = null;
// 81
    JP.go.ipa.oz.lib.standard._GridBagConstraints_if constraints = null;
// 82
    JP.go.ipa.oz.lib.standard._Insets_if insets = null;
// 84
    layout = (JP.go.ipa.oz.lib.standard._GridBagLayout_cl) (new JP.go.ipa.oz.lib.standard._GridBagLayout_cl ())._new_newGridBagLayout ();
// 85
    constraints = (JP.go.ipa.oz.lib.standard._GridBagConstraints_cl) (new JP.go.ipa.oz.lib.standard._GridBagConstraints_cl ())._new_newGridBagConstraints ();
// 86
    constraints.setFill (constraints.getBOTH ());
// 87
    constraints.setGridwidth (constraints.getREMAINDER ());
// 88
    constraints.setWeightx (1.0);
// 89
    insets = (JP.go.ipa.oz.lib.standard._Insets_cl) (new JP.go.ipa.oz.lib.standard._Insets_cl ())._new_newInsets (4, 4, 4, 4);
// 90
    constraints.setInsets (insets);
// 91
    setLayout (layout);
// 93
    layout.setConstraints (titleLabel, constraints);
// 94
    constraints.setWeighty (1.0);
// 95
    layout.setConstraints (hViewContainer, constraints);
// 97
    add (titleLabel);
// 98
    add (hViewContainer);
// 99
    pack ();
// 100
    show ();
// 101
    toFront ();
  }
  
  void initParams (JP.go.ipa.oz.user.ide.CBPartView_if pv) throws Exception  {
// 73
    partView = pv;
  }
  
  public void dispose () throws Exception  {
    checkSecureInvocation ();
// 44
    setVisible (false);
  }
  
  void initGUI (JP.go.ipa.oz.user.ide.CBIGraph_if g) throws Exception  {
// 53
    JP.go.ipa.oz.user.ide.CBWindowClosingListener_if listener = null;
// 55
    JP.go.ipa.oz.lib.standard._String_if string$26 = (new JP.go.ipa.oz.lib.standard._String_cl("class ID:  "));
    
// 55
    JP.go.ipa.oz.lib.standard._String_if getCID$val$204;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) partView)) {
      try {
        getCID$val$204 = partView.getCID ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getCID$val$204 = partView.getCID ();
    }
// 55
    JP.go.ipa.oz.lib.standard._String_if concat$val$205;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$26)) {
      try {
        concat$val$205 = string$26.concat (getCID$val$204);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$205 = string$26.concat (getCID$val$204);
    }
// 55
    titleLabel = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel (concat$val$205);
// 56
    hView = (JP.go.ipa.oz.user.ide.CBLocalHierarchyCanvas_cl) (new JP.go.ipa.oz.user.ide.CBLocalHierarchyCanvas_cl ())._new_newCBLocalHierarchyCanvas (g);
// 58
    hViewContainer = (JP.go.ipa.oz.lib.standard._ScrollPane_cl) (new JP.go.ipa.oz.lib.standard._ScrollPane_cl ())._new_newScrollPane ();
// 59
    JP.go.ipa.oz.lib.standard._Component_if add$val$206;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) hViewContainer)) {
      try {
        add$val$206 = hViewContainer.add (hView);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$206 = hViewContainer.add (hView);
    }
// 61
    layoutComponents ();
// 63
    JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if evtQue = null;
// 64
    evtQue = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 65
    listener = (JP.go.ipa.oz.user.ide.CBWindowClosingListener_cl) (new JP.go.ipa.oz.user.ide.CBWindowClosingListener_cl ())._new_newCBWindowClosingListener (this, evtQue);
// 66
    addWindowListener (listener);
  }
  
  public CBLocalHierarchyFrame_cl () throws Exception { super (); }
  
}

