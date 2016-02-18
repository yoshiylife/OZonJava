package JP.go.ipa.oz.user.misc.cell;

public class CellStopperListener_cl extends JP.go.ipa.oz.lib.standard._ActionListener_cl implements JP.go.ipa.oz.user.misc.cell.CellStopperListener_if {
  JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if dialogQue;
  JP.go.ipa.oz.lib.standard._System_if system;
  JP.go.ipa.oz.user.misc.cell.CellStopperCore_if csCore;
  
  public Object _new_create (JP.go.ipa.oz.user.misc.cell.CellStopperCore_if cs, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if eq) throws Exception  {
// 26
    super._new_newActionListener (eq);
// 28
    csCore = cs;
// 29
    dialogQue = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 30
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 31
    JP.go.ipa.oz.lib.standard._String_if string$0 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCellStopperListener#create"));
    
// 31
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.debugPrintln (string$0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.debugPrintln (string$0);
    }
    return this;
  }
  
  void stop (JP.go.ipa.oz.lib.standard._String_if god) throws Exception  {
// 81
    JP.go.ipa.oz.user.misc.cell.Stoppable_if target = null;
// 83
    JP.go.ipa.oz.lib.standard._String_if string$1 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCellStopperListener#stopCell: GOD="));
    
// 83
    JP.go.ipa.oz.lib.standard._String_if concat$val$0;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$1)) {
      try {
        concat$val$0 = string$1.concat (god);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$0 = string$1.concat (god);
    }
// 83
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.debugPrintln (concat$val$0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.debugPrintln (concat$val$0);
    }
// 85
    try {
// 86
      target = new JP.go.ipa.oz.user.misc.cell.Stoppable_pcl (god);
// 87
      target.stop ();
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_1) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_1 = _exception_1.getOzException ();
      if (_oz_exception_1 instanceof JP.go.ipa.oz.lang._Root_if) {
        JP.go.ipa.oz.lang._Root_if ex = (JP.go.ipa.oz.lang._Root_if) _oz_exception_1;
// 94
        JP.go.ipa.oz.lib.standard._String_if string$2 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCellStopperCore#stopCell: Unknown Exception"));
        
// 94
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.debugPrintln (string$2);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.debugPrintln (string$2);
        }
// 96
        handleException ((new JP.go.ipa.oz.lib.standard._String_cl("Unknown exception caught")));
      } else throw _exception_1;
    }
    catch (JP.go.ipa.oz.system.ExCellNotFoundException _exception_ex) {
      JP.go.ipa.oz.lang._Exception_if ex = new JP.go.ipa.oz.lang._Exception_cl (_exception_ex);
      
// 89
      JP.go.ipa.oz.lib.standard._String_if string$3 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCellStopperCore#stopCell: CellNotFoundException"));
      
// 89
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.debugPrintln (string$3);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.debugPrintln (string$3);
      }
// 91
      handleException ((new JP.go.ipa.oz.lib.standard._String_cl("Cell not found")));
    }
  }
  
  public void actionPerformed (JP.go.ipa.oz.lib.standard._ActionEvent_if evt) throws Exception  {
    checkSecureInvocation ();
// 40
    JP.go.ipa.oz.lib.standard._String_if cmd = null;
// 41
    JP.go.ipa.oz.lib.standard._String_if god = null;
// 42
    JP.go.ipa.oz.user.misc.cell.CellStopperGUI_if gui = null;
// 44
    JP.go.ipa.oz.lib.standard._String_if getActionCommand$val$1;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) evt)) {
      try {
        getActionCommand$val$1 = evt.getActionCommand ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getActionCommand$val$1 = evt.getActionCommand ();
    }
// 44
    cmd = getActionCommand$val$1;
// 45
    JP.go.ipa.oz.lib.standard._String_if string$4 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCellStopperListener#actionPerformed: cmd="));
    
// 45
    JP.go.ipa.oz.lib.standard._String_if concat$val$2;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$4)) {
      try {
        concat$val$2 = string$4.concat (cmd);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$2 = string$4.concat (cmd);
    }
// 45
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.debugPrintln (concat$val$2);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.debugPrintln (concat$val$2);
    }
// 48
    JP.go.ipa.oz.lib.standard._String_if string$5 = (new JP.go.ipa.oz.lib.standard._String_cl("Stop Cell"));
    
// 48
    boolean isequal$val$3;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
      try {
        isequal$val$3 = cmd.isequal (string$5);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$3 = cmd.isequal (string$5);
    }
// 48
    if (isequal$val$3) {{
// 49
        JP.go.ipa.oz.lib.standard._Frame_if getGUI$val$4;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) csCore)) {
          try {
            getGUI$val$4 = csCore.getGUI ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getGUI$val$4 = csCore.getGUI ();
        }
// 49
        gui = (JP.go.ipa.oz.user.misc.cell.CellStopperGUI_if) (getGUI$val$4);
// 50
        JP.go.ipa.oz.lib.standard._String_if getInputGOD$val$5;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gui)) {
          try {
            getInputGOD$val$5 = gui.getInputGOD ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getInputGOD$val$5 = gui.getInputGOD ();
        }
// 50
        god = getInputGOD$val$5;
// 51
        JP.go.ipa.oz.lib.standard._String_if string$6 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCellStopperListener: GOD="));
        
// 51
        JP.go.ipa.oz.lib.standard._String_if concat$val$6;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$6)) {
          try {
            concat$val$6 = string$6.concat (god);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          concat$val$6 = string$6.concat (god);
        }
// 51
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.debugPrintln (concat$val$6);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.debugPrintln (concat$val$6);
        }
// 52
        int length$val$7;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) god)) {
          try {
            length$val$7 = god.length ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          length$val$7 = god.length ();
        }
// 52
        if (length$val$7 > 0) {{
// 53
            stop (god);
          }
        } else {{
// 55
            handleException ((new JP.go.ipa.oz.lib.standard._String_cl("Invalid GOD")));
          }
        }
      }
    } else {
// 58
      JP.go.ipa.oz.lib.standard._String_if string$7 = (new JP.go.ipa.oz.lib.standard._String_cl("Quit"));
      
// 58
      boolean isequal$val$8;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
        try {
          isequal$val$8 = cmd.isequal (string$7);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isequal$val$8 = cmd.isequal (string$7);
      }
// 58
      if (isequal$val$8) {{
// 59
          quit ();
        }
      }
    }
  }
  
  void quit () throws Exception  {
// 105
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) csCore)) {
      try {
        csCore.stop ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      csCore.stop ();
    }
  }
  
  void handleException (JP.go.ipa.oz.lib.standard._String_if msg) throws Exception  {
// 71
    JP.go.ipa.oz.user.misc.gui.ExceptionDialog_if exDialog = null;
// 73
    JP.go.ipa.oz.lib.standard._String_if string$8 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCellStopperListener#handleException"));
    
// 73
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.debugPrintln (string$8);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.debugPrintln (string$8);
    }
// 74
    JP.go.ipa.oz.lib.standard._Frame_if getGUI$val$9;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) csCore)) {
      try {
        getGUI$val$9 = csCore.getGUI ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getGUI$val$9 = csCore.getGUI ();
    }
// 74
    exDialog = (JP.go.ipa.oz.user.misc.gui.ExceptionDialog_cl) (new JP.go.ipa.oz.user.misc.gui.ExceptionDialog_cl ())._new_create (getGUI$val$9, msg, dialogQue);
  }
  
  public CellStopperListener_cl () throws Exception { super (); }
  
}

