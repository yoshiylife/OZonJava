package JP.go.ipa.oz.user.inter.cgi;

public class RandezvouTable_cl extends JP.go.ipa.oz.lib.standard._Dictionary_cl implements JP.go.ipa.oz.user.inter.cgi.RandezvouTable_if {
  
  public Object _new_create () throws Exception  {
// 265
    JP.go.ipa.oz.lib.standard._StringComparator_if scomp = (JP.go.ipa.oz.lib.standard._StringComparator_cl) (new JP.go.ipa.oz.lib.standard._StringComparator_cl ())._new_create ();
// 266
    super._new_create (scomp);
    return this;
  }
  
  public void finish () throws Exception  {
    checkSecureInvocation ();
// 249
    JP.go.ipa.oz.lib.standard._Set_if values$val$130;
    values$val$130 = values ();
// 249
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$131;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) values$val$130)) {
      try {
        iterator$val$131 = values$val$130.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$131 = values$val$130.iterator ();
    }
// 249
    JP.go.ipa.oz.lib.standard._Iterator_if it = iterator$val$131;
// 251
    while (true) {
// 251
      boolean hasMoreElements$val$132;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
        try {
          hasMoreElements$val$132 = it.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$132 = it.hasMoreElements ();
      }
      if (!(hasMoreElements$val$132)) break;
      
      /* body */ _loop_1: {
// 252
        JP.go.ipa.oz.user.inter.cgi.RandezvouPoint_if rp = null;
// 254
        JP.go.ipa.oz.lang._Root_if nextElement$val$133;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
          try {
            nextElement$val$133 = it.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$133 = it.nextElement ();
        }
// 254
        rp = (JP.go.ipa.oz.user.inter.cgi.RandezvouPoint_if) (nextElement$val$133);
// 256
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rp)) {
          try {
            rp.signalRandezvou ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          rp.signalRandezvou ();
        }
// 257
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rp)) {
          try {
            rp.setHtml (null);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          rp.setHtml (null);
        }
      }
    }
  }
  
  public void registerRandezvouPoint (JP.go.ipa.oz.lib.standard._String_if id, JP.go.ipa.oz.user.inter.cgi.RandezvouPoint_if rp) throws Exception  {
    checkSecureInvocation ();
// 189
    if (checkAndRegister (id, rp)) {{
// 191
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rp)) {
          try {
            rp.waitRandezvou ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          rp.waitRandezvou ();
        }
      }
    }
// 194
    remove (id);
  }
  
  boolean checkAndRegister (JP.go.ipa.oz.lib.standard._String_if id, JP.go.ipa.oz.user.inter.cgi.RandezvouPoint_if rp) throws Exception  {
    enter ();
    try {
// 202
      JP.go.ipa.oz.lib.standard._System_if sys = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 204
      if (containsKey (id)) {{
// 205
          JP.go.ipa.oz.user.inter.cgi.RandezvouPoint_if prev = null;
// 206
          prev = (JP.go.ipa.oz.user.inter.cgi.RandezvouPoint_if) (get (id));
// 207
          JP.go.ipa.oz.user.inter.cgi.HTMLData_if getHtml$val$134;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prev)) {
            try {
              getHtml$val$134 = prev.getHtml ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getHtml$val$134 = prev.getHtml ();
          }
// 207
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rp)) {
            try {
              rp.setHtml (getHtml$val$134);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            rp.setHtml (getHtml$val$134);
          }
// 209
          return false;
        }
      } else {{
// 211
          JP.go.ipa.oz.lib.standard._String_if string$31 = (new JP.go.ipa.oz.lib.standard._String_cl("register form ID:"));
          
// 211
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
            try {
              sys.debugPrintln (string$31);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            sys.debugPrintln (string$31);
          }
// 212
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
            try {
              sys.debugPrintln (id);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            sys.debugPrintln (id);
          }
// 214
          put (id, rp);
// 216
          return true;
        }
      }
    } finally {
      leave ();
    }
  }
  
  public void signalRandezvouPoint (JP.go.ipa.oz.lib.standard._String_if id, JP.go.ipa.oz.user.inter.cgi.HTMLData_if html) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 227
      JP.go.ipa.oz.lib.standard._System_if sys = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 229
      JP.go.ipa.oz.user.inter.cgi.RandezvouPoint_if rp = null;
// 231
      rp = (JP.go.ipa.oz.user.inter.cgi.RandezvouPoint_if) (get (id));
// 233
      if (rp == null) {{
// 234
          JP.go.ipa.oz.lib.standard._String_if string$32 = (new JP.go.ipa.oz.lib.standard._String_cl("not registered:"));
          
// 234
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
            try {
              sys.debugPrintln (string$32);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            sys.debugPrintln (string$32);
          }
// 235
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
            try {
              sys.debugPrintln (id);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            sys.debugPrintln (id);
          }
// 236
          rp = (JP.go.ipa.oz.user.inter.cgi.RandezvouPoint_cl) (new JP.go.ipa.oz.user.inter.cgi.RandezvouPoint_cl ())._new_create ();
// 237
          rp.setHtml (html);
// 238
          put (id, rp);
        }
      } else {{
// 240
          rp.setHtml (html);
// 241
          rp.signalRandezvou ();
        }
      }
    } finally {
      leave ();
    }
  }
  
  public RandezvouTable_cl () throws Exception { super (); }
  
}

