package JP.go.ipa.oz.user.secu;

public class setKey_cl extends JP.go.ipa.oz.system.OzCell implements JP.go.ipa.oz.user.secu.setKey_if {
  static final boolean _global_ = true;
  
  protected void initialize () throws Exception  {
  }
  
  protected final void quiet () throws Exception  {
// 19
    flushCell ();
  }
  
  protected void go () throws Exception  {
// 4
    JP.go.ipa.oz.lib.standard._System_if s = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 5
    JP.go.ipa.oz.lib.standard._Array_if args = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (2);
// 5
    JP.go.ipa.oz.lib.standard._Array_if getArguments$val$0;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s)) {
      try {
        getArguments$val$0 = s.getArguments ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getArguments$val$0 = s.getArguments ();
    }
// 5
    args = getArguments$val$0;
// 7
    JP.go.ipa.oz.lib.standard._String_if userName = null, keySeed = null;
// 8
    JP.go.ipa.oz.lang._Root_if at$val$1;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
      try {
        at$val$1 = args.at (0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      at$val$1 = args.at (0);
    }
// 8
    userName = (JP.go.ipa.oz.lib.standard._String_if) (at$val$1);
// 9
    JP.go.ipa.oz.lib.standard._String_if string$0 = (new JP.go.ipa.oz.lib.standard._String_cl("-h"));
    
// 9
    boolean isequal$val$2;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) userName)) {
      try {
        isequal$val$2 = userName.isequal (string$0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$2 = userName.isequal (string$0);
    }
// 9
    if (isequal$val$2) {
// 10
      JP.go.ipa.oz.lib.standard._String_if string$1 = (new JP.go.ipa.oz.lib.standard._String_cl("usage:setKey oldKeySeed newKeySeed"));
      
// 10
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s)) {
        try {
          s.println (string$1);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        s.println (string$1);
      }
    } else {{
// 12
        JP.go.ipa.oz.user.secu.OzAuthenticationServer_if as = new JP.go.ipa.oz.user.secu.OzAuthenticationServer_pcl ((new JP.go.ipa.oz.lib.standard._String_cl("as")));
// 12
        JP.go.ipa.oz.lib.standard._String_if string$2 = (new JP.go.ipa.oz.lib.standard._String_cl("bound"));
        
// 12
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s)) {
          try {
            s.println (string$2);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          s.println (string$2);
        }
// 13
        JP.go.ipa.oz.lib.standard._String_if oldKey = null, newKey = null;
// 14
        JP.go.ipa.oz.lang._Root_if at$val$3;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
          try {
            at$val$3 = args.at (0);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          at$val$3 = args.at (0);
        }
// 14
        oldKey = (JP.go.ipa.oz.lib.standard._String_if) (at$val$3);
// 15
        JP.go.ipa.oz.lang._Root_if at$val$4;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
          try {
            at$val$4 = args.at (1);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          at$val$4 = args.at (1);
        }
// 15
        newKey = (JP.go.ipa.oz.lib.standard._String_if) (at$val$4);
// 16
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) as)) {
          try {
            as.setMyKey (oldKey, newKey);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          as.setMyKey (oldKey, newKey);
        }
      }
    }
  }
  
  public setKey_cl () { super ("JP.go.ipa.oz.user.secu.setKey_pcl"); }
  
  public setKey_cl (String proxy_id) { super (proxy_id); }
  
}

