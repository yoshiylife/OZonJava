package JP.go.ipa.oz.user.apl.fm;

public class Karte_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.apl.fm.Karte_if {
  JP.go.ipa.oz.lib.standard._SList_if dates;
  JP.go.ipa.oz.lang._Root_if value;
  
  public Object _new_create (JP.go.ipa.oz.lang._Root_if value) throws Exception  {
// 14
    ((JP.go.ipa.oz.user.apl.fm.Karte_cl)this).value = value;
// 15
    JP.go.ipa.oz.lib.standard._DateComparator_if dc = (JP.go.ipa.oz.lib.standard._DateComparator_cl) (new JP.go.ipa.oz.lib.standard._DateComparator_cl ())._new_create ();
// 16
    dates = (JP.go.ipa.oz.lib.standard._SList_cl) (new JP.go.ipa.oz.lib.standard._SList_cl ())._new_create (dc);
// 17
    JP.go.ipa.oz.lib.standard._Date_if d = (JP.go.ipa.oz.lib.standard._Date_cl) (new JP.go.ipa.oz.lib.standard._Date_cl ())._new_breed ();
// 18
    JP.go.ipa.oz.lib.standard._SList_if pushBack$val$213;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dates)) {
      try {
        pushBack$val$213 = dates.pushBack (d);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pushBack$val$213 = dates.pushBack (d);
    }
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if asString () throws Exception  {
    checkSecureInvocation ();
// 38
    JP.go.ipa.oz.lib.standard._String_if asString$val$214;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) value)) {
      try {
        asString$val$214 = value.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$214 = value.asString ();
    }
// 38
    JP.go.ipa.oz.lib.standard._StringBuffer_if rtn = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (asString$val$214);
// 39
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$215;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dates)) {
      try {
        iterator$val$215 = dates.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$215 = dates.iterator ();
    }
// 39
    JP.go.ipa.oz.lib.standard._Iterator_if iter = iterator$val$215;
// 40
    while (true) {
// 40
      boolean hasMoreElements$val$216;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
        try {
          hasMoreElements$val$216 = iter.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$216 = iter.hasMoreElements ();
      }
      if (!(hasMoreElements$val$216)) break;
      
      /* body */ _loop_1: {
// 41
        JP.go.ipa.oz.lib.standard._Date_if d = null;
// 41
        JP.go.ipa.oz.lang._Root_if nextElement$val$217;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
          try {
            nextElement$val$217 = iter.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$217 = iter.nextElement ();
        }
// 41
        d = (JP.go.ipa.oz.lib.standard._Date_if) (nextElement$val$217);
// 42
        JP.go.ipa.oz.lib.standard._String_if string$37 = (new JP.go.ipa.oz.lib.standard._String_cl("\n"));
        
// 42
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$218;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rtn)) {
          try {
            append$val$218 = rtn.append (string$37);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$218 = rtn.append (string$37);
        }
// 42
        JP.go.ipa.oz.lib.standard._String_if asString$val$219;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
          try {
            asString$val$219 = d.asString ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          asString$val$219 = d.asString ();
        }
// 42
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$220;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) append$val$218)) {
          try {
            append$val$220 = append$val$218.append (asString$val$219);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$220 = append$val$218.append (asString$val$219);
        }
      }
    }
// 44
    JP.go.ipa.oz.lib.standard._String_if asString$val$221;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rtn)) {
      try {
        asString$val$221 = rtn.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$221 = rtn.asString ();
    }
// 44
    return asString$val$221;
  }
  
  public JP.go.ipa.oz.lib.standard._SList_if getDates () throws Exception  {
    checkSecureInvocation ();
// 35
    return dates;
  }
  
  public JP.go.ipa.oz.lang._Root_if getValue () throws Exception  {
    checkSecureInvocation ();
// 31
    return value;
  }
  
  public void add () throws Exception  {
    checkSecureInvocation ();
// 24
    JP.go.ipa.oz.lib.standard._Date_if d = (JP.go.ipa.oz.lib.standard._Date_cl) (new JP.go.ipa.oz.lib.standard._Date_cl ())._new_breed ();
// 25
    JP.go.ipa.oz.lib.standard._SList_if pushBack$val$222;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dates)) {
      try {
        pushBack$val$222 = dates.pushBack (d);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pushBack$val$222 = dates.pushBack (d);
    }
  }
  
  public Karte_cl () throws Exception { super (); }
  
}

