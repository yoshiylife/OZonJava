package JP.go.ipa.oz.user.inter.cgi;

public class FileProperty_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.inter.cgi.FileProperty_if {
  
  public Object _new_create () throws Exception  {
    return this;
  }
  
  public void read (JP.go.ipa.oz.lib.standard._String_if file_name, JP.go.ipa.oz.user.inter.cgi.FilePropertyReader_if eval) throws Exception  {
    checkSecureInvocation ();
// 23
    JP.go.ipa.oz.lib.standard._System_if sys = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 24
    JP.go.ipa.oz.lib.standard._String_if getOzHome$val$0;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
      try {
        getOzHome$val$0 = sys.getOzHome ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzHome$val$0 = sys.getOzHome ();
    }
// 24
    JP.go.ipa.oz.lib.standard._String_if ozhome = getOzHome$val$0;
// 25
    JP.go.ipa.oz.lib.standard._String_if string$0 = (new JP.go.ipa.oz.lib.standard._String_cl("/lib/"));
    
// 25
    JP.go.ipa.oz.lib.standard._String_if concat$val$1;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozhome)) {
      try {
        concat$val$1 = ozhome.concat (string$0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$1 = ozhome.concat (string$0);
    }
// 25
    JP.go.ipa.oz.lib.standard._String_if concat$val$2;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$1)) {
      try {
        concat$val$2 = concat$val$1.concat (file_name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$2 = concat$val$1.concat (file_name);
    }
// 25
    JP.go.ipa.oz.lib.standard._String_if prop = concat$val$2;
// 26
    JP.go.ipa.oz.lib.standard._FileReader_if in = (JP.go.ipa.oz.lib.standard._FileReader_cl) (new JP.go.ipa.oz.lib.standard._FileReader_cl ())._new_breed (prop);
// 27
    JP.go.ipa.oz.lib.standard._StreamTokenizer_if st = (JP.go.ipa.oz.lib.standard._StreamTokenizer_cl) (new JP.go.ipa.oz.lib.standard._StreamTokenizer_cl ())._new_breed (in);
// 29
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
      try {
        st.resetSyntax ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      st.resetSyntax ();
    }
// 30
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
      try {
        st.wordChars (0x21, 0x7e);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      st.wordChars (0x21, 0x7e);
    }
// 31
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
      try {
        st.whitespaceChars (0, 0x20);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      st.whitespaceChars (0, 0x20);
    }
// 32
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
      try {
        st.ordinaryChar (0x3d);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      st.ordinaryChar (0x3d);
    }
// 33
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
      try {
        st.eolIsSignificant (true);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      st.eolIsSignificant (true);
    }
// 35
    boolean eof = false;
// 36
    JP.go.ipa.oz.lib.standard._String_if buf = null, value = null, label = null;
// 38
    while (true) {
      if (!(!eof)) break;
      
      /* body */ _loop_1: {
// 39
        int nextToken$val$3;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
          try {
            nextToken$val$3 = st.nextToken ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextToken$val$3 = st.nextToken ();
        }
// 41
        boolean ttypeisWORD$val$4;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
          try {
            ttypeisWORD$val$4 = st.ttypeisWORD ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          ttypeisWORD$val$4 = st.ttypeisWORD ();
        }
// 41
        if (ttypeisWORD$val$4) {{
// 42
            JP.go.ipa.oz.lib.standard._String_if getsval$val$5;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
              try {
                getsval$val$5 = st.getsval ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getsval$val$5 = st.getsval ();
            }
// 42
            JP.go.ipa.oz.lib.standard._String_if sval = getsval$val$5;
// 44
            buf = sval;
// 45
            break _loop_1;
          }
        } else {{
// 47
            int getttype$val$6;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
              try {
                getttype$val$6 = st.getttype ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getttype$val$6 = st.getttype ();
            }
// 47
            int tttype = getttype$val$6;
// 48
            if (tttype == 0x3d) {{
// 49
                label = buf;
// 50
                break _loop_1;
              }
            } else {
// 51
              boolean ttypeisEOF$val$7;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
                try {
                  ttypeisEOF$val$7 = st.ttypeisEOF ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                ttypeisEOF$val$7 = st.ttypeisEOF ();
              }
// 51
              if (ttypeisEOF$val$7) {{
// 52
                  value = buf;
// 53
                  eof = true;
                }
              } else {{
// 55
                  break _loop_1;
                }
              }
            }
          }
        }
// 64
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) eval)) {
          try {
            eval.eval (label, value);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          eval.eval (label, value);
        }
      }
    }
// 67
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) in)) {
      try {
        in.close ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      in.close ();
    }
  }
  
  public FileProperty_cl () throws Exception { super (); }
  
}

