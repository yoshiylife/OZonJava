package JP.go.ipa.oz.user.secu;

public class changeOwner_cl extends JP.go.ipa.oz.system.OzCell implements JP.go.ipa.oz.user.secu.changeOwner_if {
  static final boolean _global_ = true;
  
  protected void initialize () throws Exception  {
  }
  
  protected final void quiet () throws Exception  {
// 17
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
    JP.go.ipa.oz.lib.standard._String_if s0 = null, s1 = null;
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
    s0 = (JP.go.ipa.oz.lib.standard._String_if) (at$val$1);
// 9
    JP.go.ipa.oz.lib.standard._String_if string$0 = (new JP.go.ipa.oz.lib.standard._String_cl("-h"));
    
// 9
    boolean isequal$val$2;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s0)) {
      try {
        isequal$val$2 = s0.isequal (string$0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$2 = s0.isequal (string$0);
    }
// 9
    if (isequal$val$2) {
// 10
      JP.go.ipa.oz.lib.standard._String_if string$1 = (new JP.go.ipa.oz.lib.standard._String_cl("usage:changeOwner groupName newOwner"));
      
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
        JP.go.ipa.oz.lang._Root_if at$val$3;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
          try {
            at$val$3 = args.at (1);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          at$val$3 = args.at (1);
        }
// 13
        s1 = (JP.go.ipa.oz.lib.standard._String_if) (at$val$3);
// 14
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) as)) {
          try {
            as.changeOwner (s0, s1);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          as.changeOwner (s0, s1);
        }
      }
    }
  }
  
  public changeOwner_cl () { super ("JP.go.ipa.oz.user.secu.changeOwner_pcl"); }
  
  public changeOwner_cl (String proxy_id) { super (proxy_id); }
  
}

