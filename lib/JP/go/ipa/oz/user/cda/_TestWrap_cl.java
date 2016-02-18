package JP.go.ipa.oz.user.cda;

public class _TestWrap_cl extends JP.go.ipa.oz.system.OzCell implements JP.go.ipa.oz.user.cda._TestWrap_if {
  static final boolean _global_ = true;
  JP.go.ipa.oz.lib.standard._ClassProperty_if cp;
  JP.go.ipa.oz.lib.standard._File_if F;
  
  protected void initiallize () throws Exception  {
  }
  
  protected void go () throws Exception  {
// 34
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 34
    JP.go.ipa.oz.lib.standard._System_if debug = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 35
    JP.go.ipa.oz.lib.standard._Array_if args = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (16);
// 35
    JP.go.ipa.oz.lib.standard._Array_if getArguments$val$73;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        getArguments$val$73 = system.getArguments ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getArguments$val$73 = system.getArguments ();
    }
// 35
    args = getArguments$val$73;
// 36
    JP.go.ipa.oz.lib.standard._String_if command = null;
// 36
    JP.go.ipa.oz.lang._Root_if at$val$74;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
      try {
        at$val$74 = args.at (0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      at$val$74 = args.at (0);
    }
// 36
    command = (JP.go.ipa.oz.lib.standard._String_if) (at$val$74);
// 37
    JP.go.ipa.oz.lib.standard._String_if string$30 = (new JP.go.ipa.oz.lib.standard._String_cl("Wrap Test"));
    
// 37
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.println (string$30);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.println (string$30);
    }
// 95
    JP.go.ipa.oz.lib.standard._String_if string$31 = (new JP.go.ipa.oz.lib.standard._String_cl("cf"));
    
// 95
    boolean isequal$val$75;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
      try {
        isequal$val$75 = command.isequal (string$31);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$75 = command.isequal (string$31);
    }
// 95
    if (isequal$val$75) {{
// 96
        JP.go.ipa.oz.lib.standard._ClassFile_if cf = null;
// 97
        try {
// 98
          JP.go.ipa.oz.lib.standard._String_if string$32 = (new JP.go.ipa.oz.lib.standard._String_cl("ClassFile create"));
          
// 98
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
            try {
              system.println (string$32);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            system.println (string$32);
          }
// 99
          cf = (JP.go.ipa.oz.lib.standard._ClassFile_cl) (new JP.go.ipa.oz.lib.standard._ClassFile_cl ())._new_create ((new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz.user.released.test_cda.testclass._CDATestClass_cl")));
        }
        catch (JP.go.ipa.oz.system.ExClassNotFoundException _exception_e) {
          JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
          
// 101
          JP.go.ipa.oz.lib.standard._String_if string$33 = (new JP.go.ipa.oz.lib.standard._String_cl("ClassNotFound Exception"));
          
// 101
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
            try {
              system.println (string$33);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            system.println (string$33);
          }
        }{
// 105
          JP.go.ipa.oz.lib.standard._String_if string$34 = (new JP.go.ipa.oz.lib.standard._String_cl("ClassFile getAbsolutePath"));
          
// 105
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
            try {
              system.println (string$34);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            system.println (string$34);
          }
// 106
          JP.go.ipa.oz.lib.standard._String_if s = cf.getAbsolutePath ();
// 107
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
            try {
              system.println (s);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            system.println (s);
          }
        }
      }
    }
// 111
    JP.go.ipa.oz.lib.standard._String_if string$35 = (new JP.go.ipa.oz.lib.standard._String_cl("cp"));
    
// 111
    boolean isequal$val$76;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
      try {
        isequal$val$76 = command.isequal (string$35);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$76 = command.isequal (string$35);
    }
// 111
    if (isequal$val$76) {{
// 112
        try {
// 113
          JP.go.ipa.oz.lib.standard._String_if string$36 = (new JP.go.ipa.oz.lib.standard._String_cl("ClassProperty create"));
          
// 113
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
            try {
              system.println (string$36);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            system.println (string$36);
          }
// 114
          cp = (JP.go.ipa.oz.lib.standard._ClassProperty_cl) (new JP.go.ipa.oz.lib.standard._ClassProperty_cl ())._new_create ((new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz.user.released.test_cda.testclass._CDATestClass_cl")), (new JP.go.ipa.oz.lib.standard._String_cl("_CDATestClass_cl.class")));
        }
        catch (JP.go.ipa.oz.lang.OzException _exception_1) {
          JP.go.ipa.oz.lang._Root_if _oz_exception_1 = _exception_1.getOzException ();
          if (_oz_exception_1 instanceof JP.go.ipa.oz.lib.standard._FileNotFoundException_if) {
            JP.go.ipa.oz.lib.standard._FileNotFoundException_if e = (JP.go.ipa.oz.lib.standard._FileNotFoundException_if) _oz_exception_1;
// 117
            JP.go.ipa.oz.lib.standard._String_if string$37 = (new JP.go.ipa.oz.lib.standard._String_cl("FileNotFoundException"));
            
// 117
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
              try {
                system.println (string$37);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              system.println (string$37);
            }
          } else throw _exception_1;
        }{
// 121
          JP.go.ipa.oz.lib.standard._String_if string$38 = (new JP.go.ipa.oz.lib.standard._String_cl("ClassProperty getAbsolutePath"));
          
// 121
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
            try {
              system.println (string$38);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            system.println (string$38);
          }
// 122
          JP.go.ipa.oz.lib.standard._String_if getAbsolutePath$val$77;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cp)) {
            try {
              getAbsolutePath$val$77 = cp.getAbsolutePath ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getAbsolutePath$val$77 = cp.getAbsolutePath ();
          }
// 122
          JP.go.ipa.oz.lib.standard._String_if s = getAbsolutePath$val$77;
// 123
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
            try {
              system.println (s);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            system.println (s);
          }
        }
      }
    }
// 183
    JP.go.ipa.oz.lib.standard._String_if string$39 = (new JP.go.ipa.oz.lib.standard._String_cl("lrm"));
    
// 183
    boolean isequal$val$78;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
      try {
        isequal$val$78 = command.isequal (string$39);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$78 = command.isequal (string$39);
    }
// 183
    if (isequal$val$78) {{
// 184
        JP.go.ipa.oz.lib.standard._File_if F2 = null;
// 185
        try {
// 186
          JP.go.ipa.oz.lib.standard._String_if packageName = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz.user.released.test_cda.testclass")));
// 187
          JP.go.ipa.oz.lib.standard._String_if string$40 = (new JP.go.ipa.oz.lib.standard._String_cl("LocalRepositoryManager get"));
          
// 187
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
            try {
              system.println (string$40);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            system.println (string$40);
          }
// 188
          F2 = JP.go.ipa.oz.lib.standard._LocalRepositoryManager_cl._static_get (packageName);
// 189
          JP.go.ipa.oz.lib.standard._String_if getPath$val$79;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) F2)) {
            try {
              getPath$val$79 = F2.getPath ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getPath$val$79 = F2.getPath ();
          }
// 189
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
            try {
              system.println (getPath$val$79);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            system.println (getPath$val$79);
          }
        }
        catch (JP.go.ipa.oz.lang.OzException _exception_2) {
          JP.go.ipa.oz.lang._Root_if _oz_exception_2 = _exception_2.getOzException ();
          if (_oz_exception_2 instanceof JP.go.ipa.oz.lib.standard._IOException_if) {
            JP.go.ipa.oz.lib.standard._IOException_if e = (JP.go.ipa.oz.lib.standard._IOException_if) _oz_exception_2;
// 191
            JP.go.ipa.oz.lib.standard._String_if string$41 = (new JP.go.ipa.oz.lib.standard._String_cl("IO Exception"));
            
// 191
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
              try {
                system.println (string$41);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              system.println (string$41);
            }
          } else throw _exception_2;
        }
        catch (JP.go.ipa.oz.system.ExClassNotFoundException _exception_e) {
          JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
          
// 190
          JP.go.ipa.oz.lib.standard._String_if string$42 = (new JP.go.ipa.oz.lib.standard._String_cl("ClassNotFound Exception"));
          
// 190
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
            try {
              system.println (string$42);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            system.println (string$42);
          }
        }
      }
    }
// 219
    JP.go.ipa.oz.lib.standard._String_if string$43 = (new JP.go.ipa.oz.lib.standard._String_cl("cl"));
    
// 219
    boolean isequal$val$80;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
      try {
        isequal$val$80 = command.isequal (string$43);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$80 = command.isequal (string$43);
    }
// 219
    if (isequal$val$80) {{
// 220
        try {
// 221
          JP.go.ipa.oz.lib.standard._ClassLoader_cl._static_loadClass ((new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz.user.released.test_cda.testclass._CDATestClass_cl")));
        }
        catch (JP.go.ipa.oz.system.ExClassNotFoundException _exception_e) {
          JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
          
// 222
          JP.go.ipa.oz.lib.standard._String_if string$44 = (new JP.go.ipa.oz.lib.standard._String_cl("ClassNotFound Exception"));
          
// 222
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
            try {
              system.println (string$44);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            system.println (string$44);
          }
        }
        catch (java.lang.SecurityException _exception_e) {
          JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
          
// 223
          JP.go.ipa.oz.lib.standard._String_if string$45 = (new JP.go.ipa.oz.lib.standard._String_cl("Security Exception"));
          
// 223
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
            try {
              system.println (string$45);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            system.println (string$45);
          }
        }
      }
    }
// 242
    JP.go.ipa.oz.lib.standard._String_if string$46 = (new JP.go.ipa.oz.lib.standard._String_cl("test end"));
    
// 242
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.println (string$46);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.println (string$46);
    }
  }
  
  protected void quiet () throws Exception  {
// 31
    flushCell ();
  }
  
  public _TestWrap_cl () { super ("JP.go.ipa.oz.user.cda._TestWrap_pcl"); }
  
  public _TestWrap_cl (String proxy_id) { super (proxy_id); }
  
}

