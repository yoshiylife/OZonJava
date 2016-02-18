package JP.go.ipa.oz.user.cda;

public class _DeliveryFileCache_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.cda._DeliveryFileCache_if {
  JP.go.ipa.oz.lib.standard._Dictionary_if defi;
  
  public Object _new_create () throws Exception  {
// 611
    JP.go.ipa.oz.lib.standard._StringComparator_if sc = (JP.go.ipa.oz.lib.standard._StringComparator_cl) (new JP.go.ipa.oz.lib.standard._StringComparator_cl ())._new_create ();
// 612
    defi = (JP.go.ipa.oz.lib.standard._Dictionary_cl) (new JP.go.ipa.oz.lib.standard._Dictionary_cl ())._new_create (sc);
    return this;
  }
  
  protected boolean below (JP.go.ipa.oz.lib.standard._String_if topPackageName, JP.go.ipa.oz.lib.standard._String_if codePath) throws Exception  {
// 651
    int lastIndexOf$val$88;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) codePath)) {
      try {
        lastIndexOf$val$88 = codePath.lastIndexOf (topPackageName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lastIndexOf$val$88 = codePath.lastIndexOf (topPackageName);
    }
// 651
    if (lastIndexOf$val$88 > -1) {
// 651
      return true;
    } else {{
// 654
        return false;
      }
    }
  }
  
  public void put (JP.go.ipa.oz.lib.standard._String_if topPackageName, JP.go.ipa.oz.user.cda._DeliveryFile_if df) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 659
      JP.go.ipa.oz.lib.standard._Dictionary_if put$val$89;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) defi)) {
        try {
          put$val$89 = defi.put (topPackageName, df);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        put$val$89 = defi.put (topPackageName, df);
      }
// 659
      defi = put$val$89;
    } finally {
      leave ();
    }
  }
  
  public JP.go.ipa.oz.user.cda._DeliveryFile_if get (JP.go.ipa.oz.lib.standard._String_if codePath) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 631
      JP.go.ipa.oz.user.cda._DeliveryFile_if df = null;
// 632
      JP.go.ipa.oz.lib.standard._Iterator_if keyIterator$val$90;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) defi)) {
        try {
          keyIterator$val$90 = defi.keyIterator ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        keyIterator$val$90 = defi.keyIterator ();
      }
// 632
      JP.go.ipa.oz.lib.standard._Iterator_if ite = keyIterator$val$90;
// 633
      int size$val$91;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) defi)) {
        try {
          size$val$91 = defi.size ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        size$val$91 = defi.size ();
      }
// 633
      int size = size$val$91;
// 634
      JP.go.ipa.oz.lib.standard._String_if topPackageName = null;
// 635
      /* for loop starting here */ {
        /* initialization part */
        int i = 0;
        
        for (;;) {
          /* boolean expression part */
          if (!(i < size)) break;
          
          /* body */ _loop_1: {
// 636
            JP.go.ipa.oz.lang._Root_if nextElement$val$92;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ite)) {
              try {
                nextElement$val$92 = ite.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$92 = ite.nextElement ();
            }
// 636
            topPackageName = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$92);
// 637
            if (below (topPackageName, codePath)) {{
// 638
                JP.go.ipa.oz.lang._Root_if get$val$93;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) defi)) {
                  try {
                    get$val$93 = defi.get (topPackageName);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  get$val$93 = defi.get (topPackageName);
                }
// 638
                df = (JP.go.ipa.oz.user.cda._DeliveryFile_if) (get$val$93);
// 639
                break;
              }
            }
          }
          /* iteration part */
// 635
          i++;
        }
      }
// 642
      return df;
    } finally {
      leave ();
    }
  }
  
  public _DeliveryFileCache_cl () throws Exception { super (); }
  
}

