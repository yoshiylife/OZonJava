package JP.go.ipa.oz.user.misc.cell;

public class CellStopperCore_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.misc.cell.CellStopperCore_if {
  JP.go.ipa.oz.lib.standard._System_if system;
  JP.go.ipa.oz.user.misc.cell.CellStopperGUI_if gui;
  
  public Object _new_create () throws Exception  {
// 23
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 24
    JP.go.ipa.oz.lib.standard._String_if string$10 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCellStopperCore#create"));
    
// 24
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.debugPrintln (string$10);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.debugPrintln (string$10);
    }
    return this;
  }
  
  public void stop () throws Exception  {
    checkSecureInvocation ();
// 61
    stopCell ();
  }
  
  public void launch () throws Exception  {
    checkSecureInvocation ();
// 40
    if (gui == null) {{
// 41
        JP.go.ipa.oz.lib.standard._String_if string$11 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCellStopperCore#launch"));
        
// 41
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.debugPrintln (string$11);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.debugPrintln (string$11);
        }
// 42
        gui = (JP.go.ipa.oz.user.misc.cell.CellStopperGUI_cl) (new JP.go.ipa.oz.user.misc.cell.CellStopperGUI_cl ())._new_create (this);
      }
    }
// 44
    gui.show ();
  }
  
  void init () throws Exception  {
  }
  
  public void quit () throws Exception  {
    checkSecureInvocation ();
// 51
    JP.go.ipa.oz.lib.standard._String_if string$12 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCellStopperCore#quit"));
    
// 51
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.debugPrintln (string$12);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.debugPrintln (string$12);
    }
// 52
    if (gui != null) {{
// 53
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gui)) {
          try {
            gui.dispose ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          gui.dispose ();
        }
// 54
        gui = null;
      }
    }
  }
  
  public JP.go.ipa.oz.lib.standard._Frame_if getGUI () throws Exception  {
    checkSecureInvocation ();
// 33
    return gui;
  }
  
  public CellStopperCore_cl () throws Exception { super (); }
  
}

