package JP.go.ipa.oz.user.apl.fm;

public class TimePiece_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.apl.fm.TimePiece_if {
  boolean reservable;
  JP.go.ipa.oz.lib.standard._String_if name;
  
  public Object _new_create () throws Exception  {
// 14
    reservable = true;
// 15
    name = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("NoTime")));
    return this;
  }
  
  public boolean isEqualTimePiece (JP.go.ipa.oz.user.apl.fm.TimePiece_if t) throws Exception  {
    checkSecureInvocation ();
// 51
    if (t == null) {
// 51
      return false;
    }
// 52
    boolean isReservable$val$422;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) t)) {
      try {
        isReservable$val$422 = t.isReservable ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isReservable$val$422 = t.isReservable ();
    }
// 52
    if (reservable != isReservable$val$422) {
// 52
      return false;
    }
// 54
    JP.go.ipa.oz.lib.standard._String_if getName$val$423;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) t)) {
      try {
        getName$val$423 = t.getName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getName$val$423 = t.getName ();
    }
// 54
    JP.go.ipa.oz.lib.standard._String_if tname = getName$val$423;
    boolean bool$val$11;
    
    bool$val$11 = name == null;
    if (!bool$val$11) {
      bool$val$11 = tname == null;
    }
// 55
    if (bool$val$11) {{
        boolean bool$val$12;
        
        bool$val$12 = name == null;
        if (bool$val$12) {
          bool$val$12 = tname == null;
        }
// 56
        return (bool$val$12);
      }
    }
// 58
    boolean isequal$val$424;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) name)) {
      try {
        isequal$val$424 = name.isequal (tname);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$424 = name.isequal (tname);
    }
// 58
    return isequal$val$424;
  }
  
  public void setName (JP.go.ipa.oz.lib.standard._String_if nam) throws Exception  {
    checkSecureInvocation ();
// 19
    name = nam;
  }
  
  public boolean isReservable () throws Exception  {
    checkSecureInvocation ();
// 47
    return reservable;
  }
  
  public void toGreen () throws Exception  {
    checkSecureInvocation ();
// 62
    JP.go.ipa.oz.user.apl.fm.Overseer_if overseer = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 63
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
      try {
        overseer.permit (name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      overseer.permit (name);
    }
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getName () throws Exception  {
    checkSecureInvocation ();
// 23
    return name;
  }
  
  public void cancel () throws Exception  {
    checkSecureInvocation ();
// 37
    reservable = true;
  }
  
  public void reserve () throws Exception  {
    checkSecureInvocation ();
// 30
    reservable = false;
  }
  
  public TimePiece_cl () throws Exception { super (); }
  
}

