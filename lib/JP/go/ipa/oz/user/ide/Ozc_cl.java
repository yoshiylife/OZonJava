package JP.go.ipa.oz.user.ide;

public class Ozc_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.ide.Ozc_if {
  JP.go.ipa.oz.compiler.OzOzc_if ozc;
  
  public Object _new_create () throws Exception  {
// 19
    ozc = (JP.go.ipa.oz.compiler.OzOzc_cl) (new JP.go.ipa.oz.compiler.OzOzc_cl ())._new_create ();
// 20
    JP.go.ipa.oz.lib.standard._String_if string$42 = (new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz"));
    
// 20
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozc)) {
      try {
        ozc.setDomain (string$42);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      ozc.setDomain (string$42);
    }
    return this;
  }
  
  public boolean compile (JP.go.ipa.oz.lib.standard._String_if source, JP.go.ipa.oz.user.ide.School_if sc, JP.go.ipa.oz.lib.standard._Writer_if output, JP.go.ipa.oz.lib.standard._String_if dir) throws Exception  {
    checkSecureInvocation ();
// 37
    boolean compile$val$82;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozc)) {
      try {
        compile$val$82 = ozc.compile (source, sc, output, dir);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compile$val$82 = ozc.compile (source, sc, output, dir);
    }
// 37
    return compile$val$82;
  }
  
  public boolean compile (JP.go.ipa.oz.lib.standard._String_if source, JP.go.ipa.oz.user.ide.School_if sc, JP.go.ipa.oz.lib.standard._Writer_if output) throws Exception  {
    checkSecureInvocation ();
// 33
    boolean compile$val$83;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozc)) {
      try {
        compile$val$83 = ozc.compile (source, sc, output);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compile$val$83 = ozc.compile (source, sc, output);
    }
// 33
    return compile$val$83;
  }
  
  public boolean compile (JP.go.ipa.oz.lib.standard._String_if source, JP.go.ipa.oz.user.ide.School_if sc, JP.go.ipa.oz.lib.standard._String_if dir) throws Exception  {
    checkSecureInvocation ();
// 29
    boolean compile$val$84;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozc)) {
      try {
        compile$val$84 = ozc.compile (source, sc, dir);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compile$val$84 = ozc.compile (source, sc, dir);
    }
// 29
    return compile$val$84;
  }
  
  public boolean compile (JP.go.ipa.oz.lib.standard._String_if source, JP.go.ipa.oz.user.ide.School_if sc) throws Exception  {
    checkSecureInvocation ();
// 25
    boolean compile$val$85;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozc)) {
      try {
        compile$val$85 = ozc.compile (source, sc);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compile$val$85 = ozc.compile (source, sc);
    }
// 25
    return compile$val$85;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if displayUsage () throws Exception  {
    checkSecureInvocation ();
// 58
    JP.go.ipa.oz.lib.standard._String_if displayUsage$val$86;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozc)) {
      try {
        displayUsage$val$86 = ozc.displayUsage ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      displayUsage$val$86 = ozc.displayUsage ();
    }
// 58
    return displayUsage$val$86;
  }
  
  public boolean compileInterface (JP.go.ipa.oz.lib.standard._String_if source, JP.go.ipa.oz.user.ide.School_if sc, JP.go.ipa.oz.lib.standard._Writer_if output, JP.go.ipa.oz.lib.standard._String_if dir) throws Exception  {
    checkSecureInvocation ();
// 53
    boolean compileInterface$val$87;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozc)) {
      try {
        compileInterface$val$87 = ozc.compileInterface (source, sc, output, dir);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compileInterface$val$87 = ozc.compileInterface (source, sc, output, dir);
    }
// 53
    return compileInterface$val$87;
  }
  
  public boolean compileInterface (JP.go.ipa.oz.lib.standard._String_if source, JP.go.ipa.oz.user.ide.School_if sc, JP.go.ipa.oz.lib.standard._Writer_if output) throws Exception  {
    checkSecureInvocation ();
// 49
    boolean compileInterface$val$88;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozc)) {
      try {
        compileInterface$val$88 = ozc.compileInterface (source, sc, output);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compileInterface$val$88 = ozc.compileInterface (source, sc, output);
    }
// 49
    return compileInterface$val$88;
  }
  
  public boolean compileInterface (JP.go.ipa.oz.lib.standard._String_if source, JP.go.ipa.oz.user.ide.School_if sc, JP.go.ipa.oz.lib.standard._String_if dir) throws Exception  {
    checkSecureInvocation ();
// 45
    boolean compileInterface$val$89;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozc)) {
      try {
        compileInterface$val$89 = ozc.compileInterface (source, sc, dir);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compileInterface$val$89 = ozc.compileInterface (source, sc, dir);
    }
// 45
    return compileInterface$val$89;
  }
  
  public boolean compileInterface (JP.go.ipa.oz.lib.standard._String_if source, JP.go.ipa.oz.user.ide.School_if sc) throws Exception  {
    checkSecureInvocation ();
// 41
    boolean compileInterface$val$90;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozc)) {
      try {
        compileInterface$val$90 = ozc.compileInterface (source, sc);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compileInterface$val$90 = ozc.compileInterface (source, sc);
    }
// 41
    return compileInterface$val$90;
  }
  
  public Ozc_cl () throws Exception { super (); }
  
}

