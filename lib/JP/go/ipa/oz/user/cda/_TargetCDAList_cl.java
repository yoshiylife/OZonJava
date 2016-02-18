package JP.go.ipa.oz.user.cda;

public class _TargetCDAList_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.cda._TargetCDAList_if {
  JP.go.ipa.oz.lib.standard._Array_if targetList;
  int targetListSize;
  JP.go.ipa.oz.lib.standard._String_if leaveTo;
  
  public Object _new_create () throws Exception  {
// 670
    JP.go.ipa.oz.lib.standard._StringComparator_if sc = (JP.go.ipa.oz.lib.standard._StringComparator_cl) (new JP.go.ipa.oz.lib.standard._StringComparator_cl ())._new_create ();
// 671
    targetList = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (256, sc);
// 672
    targetListSize = 0;
// 673
    leaveTo = null;
// 674
    setDefaults ();
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if leaveToWhom () throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 680
      return leaveTo;
    } finally {
      leave ();
    }
  }
  
  public void setLeaveTo (JP.go.ipa.oz.lib.standard._String_if s) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 684
      if (s != null) {{
// 685
          leaveTo = s;
        }
      }
    } finally {
      leave ();
    }
  }
  
  public int targetsSize () throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 694
      return targetListSize;
    } finally {
      leave ();
    }
  }
  
  public void remove (JP.go.ipa.oz.lib.standard._String_if target) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 725
      if (target != null) {{
// 726
          int indexOf$val$94;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetList)) {
            try {
              indexOf$val$94 = targetList.indexOf (target);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            indexOf$val$94 = targetList.indexOf (target);
          }
// 726
          int ind = indexOf$val$94;
// 727
          if (ind > -1) {{
// 728
              /* for loop starting here */ {
                /* initialization part */
                int i = ind;
                
                for (;;) {
                  /* boolean expression part */
                  if (!(i < targetListSize - 1)) break;
                  
                  /* body */ _loop_1: {
// 729
                    JP.go.ipa.oz.lib.standard._String_if s = null;
// 730
                    JP.go.ipa.oz.lang._Root_if at$val$95;
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetList)) {
                      try {
                        at$val$95 = targetList.at (i + 1);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      at$val$95 = targetList.at (i + 1);
                    }
// 730
                    s = (JP.go.ipa.oz.lib.standard._String_if) (at$val$95);
// 731
                    JP.go.ipa.oz.lib.standard._Array_if putAt$val$96;
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetList)) {
                      try {
                        putAt$val$96 = targetList.putAt (i, s);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      putAt$val$96 = targetList.putAt (i, s);
                    }
// 731
                    targetList = putAt$val$96;
                  }
                  /* iteration part */
// 728
                  i++;
                }
              }
// 733
              JP.go.ipa.oz.lib.standard._Array_if putAt$val$97;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetList)) {
                try {
                  putAt$val$97 = targetList.putAt (targetListSize - 1, null);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                putAt$val$97 = targetList.putAt (targetListSize - 1, null);
              }
// 733
              targetList = putAt$val$97;
// 734
              targetListSize = targetListSize - 1;
            }
          }
        }
      }
    } finally {
      leave ();
    }
  }
  
  public JP.go.ipa.oz.lib.standard._Array_if targets () throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 690
      return targetList;
    } finally {
      leave ();
    }
  }
  
  public JP.go.ipa.oz.lib.standard._String_if next (int RetryNum) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 701
      if (leaveTo != null) {
// 701
        return null;
      }
// 702
      if (RetryNum >= targetListSize) {{
// 704
          return null;
        }
      } else {{
// 705
          JP.go.ipa.oz.lib.standard._String_if s = null;
// 705
          JP.go.ipa.oz.lang._Root_if at$val$98;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetList)) {
            try {
              at$val$98 = targetList.at (RetryNum);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            at$val$98 = targetList.at (RetryNum);
          }
// 705
          s = (JP.go.ipa.oz.lib.standard._String_if) (at$val$98);
// 705
          return s;
        }
      }
    } finally {
      leave ();
    }
  }
  
  public void setDefaults () throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
    } finally {
      leave ();
    }
  }
  
  public int putAt (int at, JP.go.ipa.oz.lib.standard._String_if target) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 713
      if (target == null) {
// 713
        return targetListSize;
      }
// 714
      if (at >= targetListSize) {{
// 715
          JP.go.ipa.oz.lib.standard._Array_if putAt$val$99;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetList)) {
            try {
              putAt$val$99 = targetList.putAt (targetListSize, target);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            putAt$val$99 = targetList.putAt (targetListSize, target);
          }
// 715
          targetList = putAt$val$99;
// 716
          targetListSize = targetListSize + 1;
        }
      } else {
// 717
        if (at >= 0) {{
// 718
            JP.go.ipa.oz.lib.standard._Array_if putAt$val$100;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetList)) {
              try {
                putAt$val$100 = targetList.putAt (at, target);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              putAt$val$100 = targetList.putAt (at, target);
            }
// 718
            targetList = putAt$val$100;
          }
        }
      }
// 720
      return targetListSize;
    } finally {
      leave ();
    }
  }
  
  public int put (JP.go.ipa.oz.lib.standard._String_if target) throws Exception  {
    checkSecureInvocation ();
// 709
    return putAt (targetListSize, target);
  }
  
  public _TargetCDAList_cl () throws Exception { super (); }
  
}

