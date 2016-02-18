package JP.go.ipa.oz.user.inter.wwps;

public class CompilerServer_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.inter.wwps.CompilerServer_if {
  JP.go.ipa.oz.lib.standard._Dictionary_if schools;
  
  public Object _new_create () throws Exception  {
// 56
    JP.go.ipa.oz.lib.standard._StringComparator_if scomp = (JP.go.ipa.oz.lib.standard._StringComparator_cl) (new JP.go.ipa.oz.lib.standard._StringComparator_cl ())._new_create ();
// 57
    schools = (JP.go.ipa.oz.lib.standard._Dictionary_cl) (new JP.go.ipa.oz.lib.standard._Dictionary_cl ())._new_create (scomp);
    return this;
  }
  
  public void compile (JP.go.ipa.oz.lib.standard._String_if file_name, JP.go.ipa.oz.user.ide.School_if school, JP.go.ipa.oz.lib.standard._Writer_if log) throws Exception  {
    checkSecureInvocation ();
// 23
    JP.go.ipa.oz.user.inter.wwps.CompilerAgent_if ca = (JP.go.ipa.oz.user.inter.wwps.CompilerAgent_cl) (new JP.go.ipa.oz.user.inter.wwps.CompilerAgent_cl ())._new_create (school);
// 24
    boolean compile$val$100;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ca)) {
      try {
        compile$val$100 = ca.compile (file_name, log);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compile$val$100 = ca.compile (file_name, log);
    }
  }
  
  public void registerSchool (JP.go.ipa.oz.lib.standard._String_if subject, JP.go.ipa.oz.user.ide.School_if school) throws Exception  {
    checkSecureInvocation ();
// 34
    boolean containsKey$val$101;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) schools)) {
      try {
        containsKey$val$101 = schools.containsKey (subject);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      containsKey$val$101 = schools.containsKey (subject);
    }
// 34
    if (containsKey$val$101) {
// 35
      JP.go.ipa.oz.lib.standard._Dictionary_if remove$val$102;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) schools)) {
        try {
          remove$val$102 = schools.remove (subject);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        remove$val$102 = schools.remove (subject);
      }
    }
// 37
    JP.go.ipa.oz.lib.standard._Dictionary_if put$val$103;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) schools)) {
      try {
        put$val$103 = schools.put (subject, school);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      put$val$103 = schools.put (subject, school);
    }
  }
  
  public JP.go.ipa.oz.user.ide.School_if searchSchool (JP.go.ipa.oz.lib.standard._String_if subject) throws Exception  {
    checkSecureInvocation ();
// 47
    JP.go.ipa.oz.user.ide.School_if s = null;
// 48
    JP.go.ipa.oz.lang._Root_if get$val$104;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) schools)) {
      try {
        get$val$104 = schools.get (subject);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      get$val$104 = schools.get (subject);
    }
// 48
    s = (JP.go.ipa.oz.user.ide.School_if) (get$val$104);
// 49
    return s;
  }
  
  public CompilerServer_cl () throws Exception { super (); }
  
}

