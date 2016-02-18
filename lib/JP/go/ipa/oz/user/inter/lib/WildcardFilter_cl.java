package JP.go.ipa.oz.user.inter.lib;

public class WildcardFilter_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.inter.lib.WildcardFilter_if {
  JP.go.ipa.oz.lib.standard._String_if wildcard;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._String_if w) throws Exception  {
// 333
    wildcard = w;
    return this;
  }
  
  public boolean accept (JP.go.ipa.oz.lib.standard._File_if dir, JP.go.ipa.oz.lib.standard._String_if name) throws Exception  {
    checkSecureInvocation ();
// 339
    int ast = -1, prev_ast = 0;
// 340
    int length$val$61;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) name)) {
      try {
        length$val$61 = name.length ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      length$val$61 = name.length ();
    }
// 340
    int len = length$val$61;
// 344
    while (true) {
      /* body */ _loop_1: {
// 345
        prev_ast = ast;
// 346
        int indexOf$val$62;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) wildcard)) {
          try {
            indexOf$val$62 = wildcard.indexOf ('*', prev_ast + 1);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          indexOf$val$62 = wildcard.indexOf ('*', prev_ast + 1);
        }
// 346
        ast = indexOf$val$62;
// 348
        if (ast == -1) {
// 348
          break;
        }
// 349
        if (len < ast) {
// 349
          return false;
        }
// 350
        if (ast == prev_ast) {
// 350
          break _loop_1;
        }
// 355
        JP.go.ipa.oz.lib.standard._String_if substring$val$63;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) name)) {
          try {
            substring$val$63 = name.substring (prev_ast + 1, ast);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          substring$val$63 = name.substring (prev_ast + 1, ast);
        }
// 356
        JP.go.ipa.oz.lib.standard._String_if substring$val$64;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) wildcard)) {
          try {
            substring$val$64 = wildcard.substring (prev_ast + 1, ast);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          substring$val$64 = wildcard.substring (prev_ast + 1, ast);
        }
// 355
        boolean endsWith$val$65;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) substring$val$63)) {
          try {
            endsWith$val$65 = substring$val$63.endsWith (substring$val$64);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          endsWith$val$65 = substring$val$63.endsWith (substring$val$64);
        }
// 355
        if (!endsWith$val$65) {{
// 357
            return false;
          }
        }
      }
    }
// 361
    int length$val$66;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) wildcard)) {
      try {
        length$val$66 = wildcard.length ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      length$val$66 = wildcard.length ();
    }
// 361
    int wlen = length$val$66;
// 362
    if (prev_ast + 1 != wlen) {{
// 364
        JP.go.ipa.oz.lib.standard._String_if substring$val$67;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) wildcard)) {
          try {
            substring$val$67 = wildcard.substring (prev_ast + 1, wlen);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          substring$val$67 = wildcard.substring (prev_ast + 1, wlen);
        }
// 364
        boolean endsWith$val$68;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) name)) {
          try {
            endsWith$val$68 = name.endsWith (substring$val$67);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          endsWith$val$68 = name.endsWith (substring$val$67);
        }
// 364
        if (!endsWith$val$68) {
// 365
          return false;
        }
      }
    }
// 370
    return true;
  }
  
  public WildcardFilter_cl () throws Exception { super (); }
  
}

