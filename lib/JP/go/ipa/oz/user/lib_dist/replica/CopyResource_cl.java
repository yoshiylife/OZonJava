package JP.go.ipa.oz.user.lib_dist.replica;

public class CopyResource_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.lib_dist.replica.CopyResource_if {
  JP.go.ipa.oz.lib.standard._Date_if date;
  JP.go.ipa.oz.lib.standard._String_if gol;
  JP.go.ipa.oz.user.lib_dist.replica.CopyScheme_if copy;
  
  public Object _new_create (JP.go.ipa.oz.user.lib_dist.replica.CopyScheme_if c, JP.go.ipa.oz.lib.standard._String_if st) throws Exception  {
// 571
    copy = c;
// 572
    gol = st;
// 573
    date = null;
    return this;
  }
  
  public Object _new_create () throws Exception  {
// 566
    copy = null;
// 567
    gol = (new JP.go.ipa.oz.lib.standard._String_cl("INIT"));
// 568
    date = null;
    return this;
  }
  
  public final void setDate () throws Exception  {
    checkSecureInvocation ();
// 590
    date = (JP.go.ipa.oz.lib.standard._Date_cl) (new JP.go.ipa.oz.lib.standard._Date_cl ())._new_breed ();
  }
  
  public final JP.go.ipa.oz.user.lib_dist.replica.CopyScheme_if getCopy () throws Exception  {
    checkSecureInvocation ();
// 587
    return copy;
  }
  
  public final void setCopy (JP.go.ipa.oz.user.lib_dist.replica.CopyScheme_if c, JP.go.ipa.oz.lib.standard._String_if st) throws Exception  {
    checkSecureInvocation ();
// 584
    copy = c;
// 585
    gol = st;
  }
  
  public final JP.go.ipa.oz.lib.standard._String_if getDate () throws Exception  {
    checkSecureInvocation ();
// 589
    JP.go.ipa.oz.lib.standard._String_if asString$val$49;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) date)) {
      try {
        asString$val$49 = date.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$49 = date.asString ();
    }
// 589
    return asString$val$49;
  }
  
  public final JP.go.ipa.oz.lib.standard._String_if getGol () throws Exception  {
    checkSecureInvocation ();
// 588
    return gol;
  }
  
  public final boolean equal (JP.go.ipa.oz.user.lib_dist.replica.CopyResource_if pr) throws Exception  {
    checkSecureInvocation ();
// 576
    JP.go.ipa.oz.lib.standard._String_if gol2 = null;
// 577
    JP.go.ipa.oz.lib.standard._String_if getGol$val$50;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pr)) {
      try {
        getGol$val$50 = pr.getGol ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getGol$val$50 = pr.getGol ();
    }
// 577
    int compareTo$val$51;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gol)) {
      try {
        compareTo$val$51 = gol.compareTo (getGol$val$50);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compareTo$val$51 = gol.compareTo (getGol$val$50);
    }
// 577
    if (compareTo$val$51 == 0) {
// 578
      return true;
    } else {
// 580
      return false;
    }
  }
  
  public CopyResource_cl () throws Exception { super (); }
  
}

