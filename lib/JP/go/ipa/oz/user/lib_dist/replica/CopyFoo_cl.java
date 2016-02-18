package JP.go.ipa.oz.user.lib_dist.replica;

public class CopyFoo_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.lib_dist.replica.CopyFoo_if {
  
  public Object _new_create () throws Exception  {
    return this;
  }
  
  public long foo (JP.go.ipa.oz.user.lib_dist.replica.CopyScheme_if copy, int flag, JP.go.ipa.oz.lib.standard._String_if gol) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 644
      JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 645
      long aTime = 0, bTime = 0;
// 646
      JP.go.ipa.oz.lib.standard._Date_if date1 = null, date2 = null;
// 647
      long ret = 0;
// 649
      switch (flag) {
      case 1:
// 651
        boolean lock$val$54;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) copy)) {
          try {
            lock$val$54 = copy.lock ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          lock$val$54 = copy.lock ();
        }
// 652
        break;
      case 2:
// 654
        boolean lockAll$val$55;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) copy)) {
          try {
            lockAll$val$55 = copy.lockAll ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          lockAll$val$55 = copy.lockAll ();
        }
// 655
        break;
      case 3:
// 657
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) copy)) {
          try {
            copy.update (gol);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          copy.update (gol);
        }
// 658
        break;
      case 4:
// 660
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) copy)) {
          try {
            copy.update ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          copy.update ();
        }
// 661
        break;
      case 5:
// 663
        boolean commit$val$56;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) copy)) {
          try {
            commit$val$56 = copy.commit ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          commit$val$56 = copy.commit ();
        }
// 664
        break;
      case 6:
// 666
        boolean commitAll$val$57;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) copy)) {
          try {
            commitAll$val$57 = copy.commitAll ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          commitAll$val$57 = copy.commitAll ();
        }
// 667
        break;
      case 7:
// 669
        date1 = (JP.go.ipa.oz.lib.standard._Date_cl) (new JP.go.ipa.oz.lib.standard._Date_cl ())._new_breed ();
// 670
        boolean isLive$val$58;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) copy)) {
          try {
            isLive$val$58 = copy.isLive ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isLive$val$58 = copy.isLive ();
        }
// 671
        date2 = (JP.go.ipa.oz.lib.standard._Date_cl) (new JP.go.ipa.oz.lib.standard._Date_cl ())._new_breed ();
// 672
        bTime = date1.getTime ();
// 673
        aTime = date2.getTime ();
// 674
        ret = aTime - bTime;
// 675
        break;
      }
// 677
      return ret;
    } finally {
      leave ();
    }
  }
  
  public CopyFoo_cl () throws Exception { super (); }
  
}

