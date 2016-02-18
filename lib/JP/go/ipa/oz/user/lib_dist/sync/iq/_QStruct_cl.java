package JP.go.ipa.oz.user.lib_dist.sync.iq;

public class _QStruct_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.lib_dist.sync.iq._QStruct_if {
  JP.go.ipa.oz.lib.standard._SList_if vals;
  JP.go.ipa.oz.system.OzCondition cond = new JP.go.ipa.oz.system.OzCondition (this);
  
  public Object _new_create () throws Exception  {
// 20
    vals = (JP.go.ipa.oz.lib.standard._SList_cl) (new JP.go.ipa.oz.lib.standard._SList_cl ())._new_create ();
    return this;
  }
  
  public void write (JP.go.ipa.oz.lang._Root_if o) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 24
      JP.go.ipa.oz.lib.standard._SList_if pushBack$val$0;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) vals)) {
        try {
          pushBack$val$0 = vals.pushBack (o);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        pushBack$val$0 = vals.pushBack (o);
      }
// 25
      signal (cond);
    } finally {
      leave ();
    }
  }
  
  public JP.go.ipa.oz.lang._Root_if read () throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 29
      JP.go.ipa.oz.lang._Root_if o = null;
// 30
      int size$val$1;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) vals)) {
        try {
          size$val$1 = vals.size ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        size$val$1 = vals.size ();
      }
// 30
      if ((size$val$1) == 0) {{
// 31
          wait (cond);
        }
      }
// 33
      JP.go.ipa.oz.lang._Root_if first$val$2;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) vals)) {
        try {
          first$val$2 = vals.first ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        first$val$2 = vals.first ();
      }
// 33
      o = first$val$2;
// 34
      JP.go.ipa.oz.lib.standard._SList_if popFront$val$3;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) vals)) {
        try {
          popFront$val$3 = vals.popFront ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        popFront$val$3 = vals.popFront ();
      }
// 35
      return o;
    } finally {
      leave ();
    }
  }
  
  public _QStruct_cl () throws Exception { super (); }
  
}

