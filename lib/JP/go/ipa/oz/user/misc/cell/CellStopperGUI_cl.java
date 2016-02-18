package JP.go.ipa.oz.user.misc.cell;

public class CellStopperGUI_cl extends JP.go.ipa.oz.user.misc.gui.CenteredFrame_cl implements JP.go.ipa.oz.user.misc.cell.CellStopperGUI_if {
  JP.go.ipa.oz.lib.standard._TextField_if godInputView;
  JP.go.ipa.oz.lib.standard._System_if system;
  JP.go.ipa.oz.lib.standard._Button_if quitButton;
  JP.go.ipa.oz.lib.standard._Button_if stopButton;
  JP.go.ipa.oz.user.misc.cell.CellStopperCore_if csCore;
  
  public Object _new_create (JP.go.ipa.oz.user.misc.cell.CellStopperCore_if cs) throws Exception  {
// 29
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 30
    JP.go.ipa.oz.lib.standard._String_if string$9 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCellStopperGUI#create"));
    
// 30
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.debugPrintln (string$9);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.debugPrintln (string$9);
    }
// 31
    super._new_create ((new JP.go.ipa.oz.lib.standard._String_cl("OZ Cell Stopper")));
// 32
    init (cs);
    return this;
  }
  
  void init (JP.go.ipa.oz.user.misc.cell.CellStopperCore_if cs) throws Exception  {
// 51
    csCore = cs;
// 52
    initGUI ((new JP.go.ipa.oz.lib.standard._String_cl("GOD:")), 50);
// 53
    initListeners ();
  }
  
  JP.go.ipa.oz.lib.standard._Panel_if mkControlPanel () throws Exception  {
// 131
    JP.go.ipa.oz.lib.standard._Panel_if panel = null;
// 132
    JP.go.ipa.oz.lib.standard._GridBagLayout_if layout = null;
// 133
    JP.go.ipa.oz.lib.standard._GridBagConstraints_if constraints = null;
// 134
    JP.go.ipa.oz.lib.standard._Insets_if insets = null;
// 136
    stopButton = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("Stop Cell")));
// 137
    quitButton = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("Quit")));
// 138
    layout = (JP.go.ipa.oz.lib.standard._GridBagLayout_cl) (new JP.go.ipa.oz.lib.standard._GridBagLayout_cl ())._new_newGridBagLayout ();
// 139
    panel = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (layout);
// 141
    constraints = (JP.go.ipa.oz.lib.standard._GridBagConstraints_cl) (new JP.go.ipa.oz.lib.standard._GridBagConstraints_cl ())._new_newGridBagConstraints ();
// 142
    constraints.setFill (constraints.getBOTH ());
// 143
    insets = (JP.go.ipa.oz.lib.standard._Insets_cl) (new JP.go.ipa.oz.lib.standard._Insets_cl ())._new_newInsets (10, 20, 10, 20);
// 144
    constraints.setInsets (insets);
// 146
    layout.setConstraints (stopButton, constraints);
// 147
    layout.setConstraints (quitButton, constraints);
// 149
    panel.add (stopButton);
// 150
    panel.add (quitButton);
// 152
    return panel;
  }
  
  void initGUI (JP.go.ipa.oz.lib.standard._String_if label, int width) throws Exception  {
// 60
    JP.go.ipa.oz.lib.standard._Panel_if inputPanel = null, controlPanel = null;
// 61
    JP.go.ipa.oz.lib.standard._GridBagLayout_if layout = null;
// 62
    JP.go.ipa.oz.lib.standard._GridBagConstraints_if constraints = null;
// 64
    inputPanel = mkInputPanel (label, width);
// 65
    controlPanel = mkControlPanel ();
// 66
    layout = (JP.go.ipa.oz.lib.standard._GridBagLayout_cl) (new JP.go.ipa.oz.lib.standard._GridBagLayout_cl ())._new_newGridBagLayout ();
// 67
    setLayout (layout);
// 69
    constraints = (JP.go.ipa.oz.lib.standard._GridBagConstraints_cl) (new JP.go.ipa.oz.lib.standard._GridBagConstraints_cl ())._new_newGridBagConstraints ();
// 70
    constraints.setFill (constraints.getBOTH ());
// 72
    constraints.setGridwidth (constraints.getREMAINDER ());
// 73
    constraints.setWeightx (1.0);
// 74
    layout.setConstraints (inputPanel, constraints);
// 75
    layout.setConstraints (controlPanel, constraints);
// 77
    add (inputPanel);
// 78
    add (controlPanel);
// 79
    pack ();
  }
  
  void initListeners () throws Exception  {
// 86
    JP.go.ipa.oz.user.misc.cell.CellStopperListener_if listener = null;
// 87
    JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if eq = null;
// 89
    eq = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 90
    listener = (JP.go.ipa.oz.user.misc.cell.CellStopperListener_cl) (new JP.go.ipa.oz.user.misc.cell.CellStopperListener_cl ())._new_create (csCore, eq);
// 91
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) stopButton)) {
      try {
        stopButton.addActionListener (listener);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      stopButton.addActionListener (listener);
    }
// 92
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) quitButton)) {
      try {
        quitButton.addActionListener (listener);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      quitButton.addActionListener (listener);
    }
  }
  
  JP.go.ipa.oz.lib.standard._Panel_if mkInputPanel (JP.go.ipa.oz.lib.standard._String_if label, int width) throws Exception  {
// 99
    JP.go.ipa.oz.lib.standard._Panel_if panel = null;
// 100
    JP.go.ipa.oz.lib.standard._Label_if labelView = null;
// 101
    JP.go.ipa.oz.lib.standard._Insets_if insets = null;
// 102
    JP.go.ipa.oz.lib.standard._GridBagLayout_if layout = null;
// 103
    JP.go.ipa.oz.lib.standard._GridBagConstraints_if constraints = null;
// 105
    labelView = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel (label);
// 106
    godInputView = (JP.go.ipa.oz.lib.standard._TextField_cl) (new JP.go.ipa.oz.lib.standard._TextField_cl ())._new_newTextField (width);
// 107
    layout = (JP.go.ipa.oz.lib.standard._GridBagLayout_cl) (new JP.go.ipa.oz.lib.standard._GridBagLayout_cl ())._new_newGridBagLayout ();
// 108
    panel = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (layout);
// 110
    constraints = (JP.go.ipa.oz.lib.standard._GridBagConstraints_cl) (new JP.go.ipa.oz.lib.standard._GridBagConstraints_cl ())._new_newGridBagConstraints ();
// 111
    constraints.setFill (constraints.getBOTH ());
// 112
    insets = (JP.go.ipa.oz.lib.standard._Insets_cl) (new JP.go.ipa.oz.lib.standard._Insets_cl ())._new_newInsets (10, 10, 0, 2);
// 113
    constraints.setInsets (insets);
// 114
    layout.setConstraints (labelView, constraints);
// 116
    constraints.setGridwidth (constraints.getREMAINDER ());
// 117
    constraints.setWeightx (1.0);
// 118
    insets.set (10, 2, 0, 10);
// 119
    layout.setConstraints (godInputView, constraints);
// 121
    panel.add (labelView);
// 122
    panel.add (godInputView);
// 124
    return panel;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getInputGOD () throws Exception  {
    checkSecureInvocation ();
// 41
    JP.go.ipa.oz.lib.standard._String_if getText$val$10;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) godInputView)) {
      try {
        getText$val$10 = godInputView.getText ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getText$val$10 = godInputView.getText ();
    }
// 41
    return getText$val$10;
  }
  
  public CellStopperGUI_cl () throws Exception { super (); }
  
}

