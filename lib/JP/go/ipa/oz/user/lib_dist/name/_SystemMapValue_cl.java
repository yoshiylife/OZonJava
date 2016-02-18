package JP.go.ipa.oz.user.lib_dist.name;

public class _SystemMapValue_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if {
  JP.go.ipa.oz.user.lib_dist.name._Path_if tranpath;
  JP.go.ipa.oz.lib.standard._String_if nameserverGOL;
  boolean ismapping;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._String_if s, JP.go.ipa.oz.user.lib_dist.name._Path_if p, boolean tf) throws Exception  {
// 12
    nameserverGOL = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed (s);
// 13
    JP.go.ipa.oz.lib.standard._String_if asString$val$443;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) p)) {
      try {
        asString$val$443 = p.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$443 = p.asString ();
    }
// 13
    tranpath = (JP.go.ipa.oz.user.lib_dist.name._Path_cl) (new JP.go.ipa.oz.user.lib_dist.name._Path_cl ())._new_breed (asString$val$443);
// 14
    ismapping = tf;
    return this;
  }
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._String_if s) throws Exception  {
// 7
    nameserverGOL = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed (s);
// 8
    tranpath = (JP.go.ipa.oz.user.lib_dist.name._Path_cl) (new JP.go.ipa.oz.user.lib_dist.name._Path_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("")));
// 9
    ismapping = false;
    return this;
  }
  
  public void debugPrint (JP.go.ipa.oz.lib.standard._PrintWriter_if pw) throws Exception  {
    checkSecureInvocation ();
// 17
    JP.go.ipa.oz.lib.standard._String_if string$114 = (new JP.go.ipa.oz.lib.standard._String_cl("  "));
    
// 17
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.print (string$114);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.print (string$114);
    }
// 17
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.print (nameserverGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.print (nameserverGOL);
    }
// 18
    JP.go.ipa.oz.lib.standard._String_if string$115 = (new JP.go.ipa.oz.lib.standard._String_cl("  "));
    
// 18
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.print (string$115);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.print (string$115);
    }
// 18
    JP.go.ipa.oz.lib.standard._String_if asString$val$444;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tranpath)) {
      try {
        asString$val$444 = tranpath.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$444 = tranpath.asString ();
    }
// 18
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.print (asString$val$444);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.print (asString$val$444);
    }
  }
  
  public JP.go.ipa.oz.user.lib_dist.name._Path_if tranpath () throws Exception  {
    checkSecureInvocation ();
// 21
    return tranpath;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if nameserverGOL () throws Exception  {
    checkSecureInvocation ();
// 20
    return nameserverGOL;
  }
  
  public boolean ismapping () throws Exception  {
    checkSecureInvocation ();
// 22
    return ismapping;
  }
  
  public _SystemMapValue_cl () throws Exception { super (); }
  
}

