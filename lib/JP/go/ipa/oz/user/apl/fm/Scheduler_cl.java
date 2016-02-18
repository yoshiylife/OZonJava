package JP.go.ipa.oz.user.apl.fm;

public class Scheduler_cl extends JP.go.ipa.oz.user.apl.fm.FMObject_cl implements JP.go.ipa.oz.user.apl.fm.Scheduler_if {
  
  public Object _new_create (JP.go.ipa.oz.user.apl.fm.Scheduler_if s) throws Exception  {
// 79
    JP.go.ipa.oz.lib.standard._String_if getName$val$532;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s)) {
      try {
        getName$val$532 = s.getName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getName$val$532 = s.getName ();
    }
// 79
    JP.go.ipa.oz.lib.standard._Set_if getAllRelations$val$533;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s)) {
      try {
        getAllRelations$val$533 = s.getAllRelations ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getAllRelations$val$533 = s.getAllRelations ();
    }
// 79
    JP.go.ipa.oz.user.apl.fm.Pointer_if getIdentifier$val$534;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s)) {
      try {
        getIdentifier$val$534 = s.getIdentifier ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getIdentifier$val$534 = s.getIdentifier ();
    }
// 79
    super._new_create (getName$val$532, getAllRelations$val$533, getIdentifier$val$534);
    return this;
  }
  
  public Object _new_create () throws Exception  {
// 12
    super._new_create ();
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._SList_if confirm (JP.go.ipa.oz.user.apl.fm.Reserve_if res) throws Exception  {
    checkSecureInvocation ();
// 55
    JP.go.ipa.oz.user.apl.fm.Schedulable_if entity = null;
// 55
    entity = (JP.go.ipa.oz.user.apl.fm.Schedulable_if) (getRelatedObject ((new JP.go.ipa.oz.lib.standard._String_cl("Scheduling"))));
// 56
    JP.go.ipa.oz.lib.standard._SList_if confirm$val$535;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) entity)) {
      try {
        confirm$val$535 = entity.confirm (res);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      confirm$val$535 = entity.confirm (res);
    }
// 56
    return confirm$val$535;
  }
  
  public void bindEntity (JP.go.ipa.oz.user.apl.fm.Schedulable_if entity) throws Exception  {
    checkSecureInvocation ();
// 21
    JP.go.ipa.oz.user.apl.fm.Overseer_if over = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 22
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
      try {
        over.permit (entity);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      over.permit (entity);
    }
// 23
    createRelation ((new JP.go.ipa.oz.lib.standard._String_cl("Scheduling")), entity);
  }
  
  public void trace (int mark) throws Exception  {
    checkSecureInvocation ();
// 83
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 84
    JP.go.ipa.oz.lib.standard._PrintWriter_if getStdout$val$536;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        getStdout$val$536 = system.getStdout ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getStdout$val$536 = system.getStdout ();
    }
// 84
    JP.go.ipa.oz.lib.standard._PrintWriter_if pw = (JP.go.ipa.oz.lib.standard._PrintWriter_cl) (new JP.go.ipa.oz.lib.standard._PrintWriter_cl ())._new_breed (getStdout$val$536, true);
// 85
    JP.go.ipa.oz.lib.standard._String_if string$84 = (new JP.go.ipa.oz.lib.standard._String_cl("Scheduler#trace("));
    
// 85
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.print (string$84);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.print (string$84);
    }
// 86
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.print (mark);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.print (mark);
    }
// 87
    JP.go.ipa.oz.lib.standard._String_if string$85 = (new JP.go.ipa.oz.lib.standard._String_cl(")"));
    
// 87
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.println (string$85);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.println (string$85);
    }
// 88
    JP.go.ipa.oz.lib.standard._String_if string$86 = (new JP.go.ipa.oz.lib.standard._String_cl("---- super ----"));
    
// 88
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.println (string$86);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.println (string$86);
    }
// 89
    super.trace (mark);
  }
  
  public JP.go.ipa.oz.user.apl.fm.FMObject_if cloneSelf () throws Exception  {
    checkSecureInvocation ();
// 74
    JP.go.ipa.oz.user.apl.fm.Scheduler_if clone = (JP.go.ipa.oz.user.apl.fm.Scheduler_cl) (new JP.go.ipa.oz.user.apl.fm.Scheduler_cl ())._new_create (this);
// 75
    return clone;
  }
  
  public void cancel (JP.go.ipa.oz.user.apl.fm.Reserve_if res) throws Exception  {
    checkSecureInvocation ();
// 65
    JP.go.ipa.oz.user.apl.fm.Schedulable_if entity = null;
// 65
    entity = (JP.go.ipa.oz.user.apl.fm.Schedulable_if) (getRelatedObject ((new JP.go.ipa.oz.lib.standard._String_cl("Scheduling"))));
// 66
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) entity)) {
      try {
        entity.cancel (res);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      entity.cancel (res);
    }
// 67
    JP.go.ipa.oz.lib.standard._String_if string$87 = (new JP.go.ipa.oz.lib.standard._String_cl("cancel"));
    
// 67
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        res.setState (string$87);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      res.setState (string$87);
    }
// 68
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) entity)) {
      try {
        entity.commit ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      entity.commit ();
    }
// 69
    commit ();
  }
  
  public boolean reserve (JP.go.ipa.oz.user.apl.fm.Reserve_if res) throws Exception  {
    checkSecureInvocation ();
// 34
    boolean result = false;
// 35
    JP.go.ipa.oz.user.apl.fm.Schedulable_if entity = null;
// 35
    entity = (JP.go.ipa.oz.user.apl.fm.Schedulable_if) (getRelatedObject ((new JP.go.ipa.oz.lib.standard._String_cl("Scheduling"))));
// 36
    boolean reserve$val$537;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) entity)) {
      try {
        reserve$val$537 = entity.reserve (res);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      reserve$val$537 = entity.reserve (res);
    }
// 36
    result = reserve$val$537;
// 38
    if (!result) {
// 38
      return false;
    }
// 40
    JP.go.ipa.oz.lib.standard._String_if string$88 = (new JP.go.ipa.oz.lib.standard._String_cl("reserve"));
    
// 40
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        res.setState (string$88);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      res.setState (string$88);
    }
// 41
    JP.go.ipa.oz.user.apl.fm.Pointer_if getIdentifier$val$538;
    getIdentifier$val$538 = getIdentifier ();
// 41
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        res.attach (getIdentifier$val$538);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      res.attach (getIdentifier$val$538);
    }
// 42
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) entity)) {
      try {
        entity.commit ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      entity.commit ();
    }
// 43
    commit ();
// 45
    return true;
  }
  
  public Scheduler_cl () throws Exception { super (); }
  
}

