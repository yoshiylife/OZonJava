package JP.go.ipa.oz.user.cda;

public class _MillorTarget_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.cda._MillorTarget_if {
  boolean isClient;
  JP.go.ipa.oz.lib.standard._Dictionary_if GOLtoTimes;
  
  public Object _new_create (boolean isC) throws Exception  {
// 747
    JP.go.ipa.oz.lib.standard._StringComparator_if sc = (JP.go.ipa.oz.lib.standard._StringComparator_cl) (new JP.go.ipa.oz.lib.standard._StringComparator_cl ())._new_create ();
// 748
    GOLtoTimes = (JP.go.ipa.oz.lib.standard._Dictionary_cl) (new JP.go.ipa.oz.lib.standard._Dictionary_cl ())._new_create (sc);
// 749
    isClient = isC;
// 750
    setDefaults ();
    return this;
  }
  
  public boolean isClient () throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 755
      return isClient;
    } finally {
      leave ();
    }
  }
  
  public void addTopPackageName (JP.go.ipa.oz.lib.standard._String_if GOL, JP.go.ipa.oz.lib.standard._String_if Name) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
      boolean bool$val$5;
      
      bool$val$5 = (GOL != null);
      if (bool$val$5) {
        bool$val$5 = (Name != null);
      }
// 766
      if (bool$val$5) {{
// 767
          JP.go.ipa.oz.lib.standard._Dictionary_if times = null;
// 767
          JP.go.ipa.oz.lang._Root_if get$val$101;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) GOLtoTimes)) {
            try {
              get$val$101 = GOLtoTimes.get (GOL);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            get$val$101 = GOLtoTimes.get (GOL);
          }
// 767
          times = (JP.go.ipa.oz.lib.standard._Dictionary_if) (get$val$101);
// 768
          JP.go.ipa.oz.lib.standard._Long_if L = (JP.go.ipa.oz.lib.standard._Long_cl) (new JP.go.ipa.oz.lib.standard._Long_cl ())._new_breed (-1);
// 769
          if (times != null) {{
// 770
              JP.go.ipa.oz.lib.standard._Dictionary_if put$val$102;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) times)) {
                try {
                  put$val$102 = times.put (Name, L);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                put$val$102 = times.put (Name, L);
              }
// 770
              times = put$val$102;
// 771
              JP.go.ipa.oz.lib.standard._Dictionary_if put$val$103;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) GOLtoTimes)) {
                try {
                  put$val$103 = GOLtoTimes.put (GOL, times);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                put$val$103 = GOLtoTimes.put (GOL, times);
              }
// 771
              GOLtoTimes = put$val$103;
            }
          }
        }
      }
    } finally {
      leave ();
    }
  }
  
  public void setTime (JP.go.ipa.oz.lib.standard._String_if GOL, JP.go.ipa.oz.lib.standard._String_if Name, long time) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 788
      JP.go.ipa.oz.lib.standard._Dictionary_if times = null;
// 788
      JP.go.ipa.oz.lang._Root_if get$val$104;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) GOLtoTimes)) {
        try {
          get$val$104 = GOLtoTimes.get (GOL);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        get$val$104 = GOLtoTimes.get (GOL);
      }
// 788
      times = (JP.go.ipa.oz.lib.standard._Dictionary_if) (get$val$104);
// 789
      JP.go.ipa.oz.lib.standard._Long_if L = (JP.go.ipa.oz.lib.standard._Long_cl) (new JP.go.ipa.oz.lib.standard._Long_cl ())._new_breed (time);
// 790
      JP.go.ipa.oz.lib.standard._Dictionary_if put$val$105;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) times)) {
        try {
          put$val$105 = times.put (Name, L);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        put$val$105 = times.put (Name, L);
      }
// 790
      times = put$val$105;
// 791
      JP.go.ipa.oz.lib.standard._Dictionary_if put$val$106;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) GOLtoTimes)) {
        try {
          put$val$106 = GOLtoTimes.put (GOL, times);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        put$val$106 = GOLtoTimes.put (GOL, times);
      }
// 791
      GOLtoTimes = put$val$106;
    } finally {
      leave ();
    }
  }
  
  public void add (JP.go.ipa.oz.lib.standard._String_if millorCDAGOL) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 758
      if (millorCDAGOL != null) {{
// 759
          JP.go.ipa.oz.lib.standard._StringComparator_if sc = (JP.go.ipa.oz.lib.standard._StringComparator_cl) (new JP.go.ipa.oz.lib.standard._StringComparator_cl ())._new_create ();
// 760
          JP.go.ipa.oz.lib.standard._Dictionary_if times = (JP.go.ipa.oz.lib.standard._Dictionary_cl) (new JP.go.ipa.oz.lib.standard._Dictionary_cl ())._new_create (sc);
// 761
          JP.go.ipa.oz.lib.standard._Dictionary_if put$val$107;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) GOLtoTimes)) {
            try {
              put$val$107 = GOLtoTimes.put (millorCDAGOL, times);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            put$val$107 = GOLtoTimes.put (millorCDAGOL, times);
          }
// 761
          GOLtoTimes = put$val$107;
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
  
  public JP.go.ipa.oz.lib.standard._Set_if getTargetGOLs () throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 807
      JP.go.ipa.oz.lib.standard._Set_if keys$val$108;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) GOLtoTimes)) {
        try {
          keys$val$108 = GOLtoTimes.keys ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        keys$val$108 = GOLtoTimes.keys ();
      }
// 807
      return keys$val$108;
    } finally {
      leave ();
    }
  }
  
  public void versionupTopPackage (JP.go.ipa.oz.lib.standard._String_if GOL, JP.go.ipa.oz.lib.standard._String_if Name, long time) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 795
      JP.go.ipa.oz.lib.standard._Dictionary_if times = null;
// 795
      JP.go.ipa.oz.lang._Root_if get$val$109;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) GOLtoTimes)) {
        try {
          get$val$109 = GOLtoTimes.get (GOL);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        get$val$109 = GOLtoTimes.get (GOL);
      }
// 795
      times = (JP.go.ipa.oz.lib.standard._Dictionary_if) (get$val$109);
// 796
      JP.go.ipa.oz.lib.standard._Long_if L = (JP.go.ipa.oz.lib.standard._Long_cl) (new JP.go.ipa.oz.lib.standard._Long_cl ())._new_breed (time);
// 797
      JP.go.ipa.oz.lib.standard._Dictionary_if put$val$110;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) times)) {
        try {
          put$val$110 = times.put (Name, L);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        put$val$110 = times.put (Name, L);
      }
// 797
      times = put$val$110;
// 798
      JP.go.ipa.oz.lib.standard._Dictionary_if put$val$111;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) GOLtoTimes)) {
        try {
          put$val$111 = GOLtoTimes.put (GOL, times);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        put$val$111 = GOLtoTimes.put (GOL, times);
      }
// 798
      GOLtoTimes = put$val$111;
    } finally {
      leave ();
    }
  }
  
  public JP.go.ipa.oz.lib.standard._Dictionary_if get (JP.go.ipa.oz.lib.standard._String_if GOL) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 802
      JP.go.ipa.oz.lib.standard._Dictionary_if times = null;
// 802
      JP.go.ipa.oz.lang._Root_if get$val$112;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) GOLtoTimes)) {
        try {
          get$val$112 = GOLtoTimes.get (GOL);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        get$val$112 = GOLtoTimes.get (GOL);
      }
// 802
      times = (JP.go.ipa.oz.lib.standard._Dictionary_if) (get$val$112);
// 803
      return times;
    } finally {
      leave ();
    }
  }
  
  public void removeTopPackageName (JP.go.ipa.oz.lib.standard._String_if GOL, JP.go.ipa.oz.lib.standard._String_if Name) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
      boolean bool$val$6;
      
      bool$val$6 = (GOL != null);
      if (bool$val$6) {
        bool$val$6 = (Name != null);
      }
// 777
      if (bool$val$6) {{
// 778
          JP.go.ipa.oz.lib.standard._Dictionary_if times = null;
// 778
          JP.go.ipa.oz.lang._Root_if get$val$113;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) GOLtoTimes)) {
            try {
              get$val$113 = GOLtoTimes.get (GOL);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            get$val$113 = GOLtoTimes.get (GOL);
          }
// 778
          times = (JP.go.ipa.oz.lib.standard._Dictionary_if) (get$val$113);
// 779
          JP.go.ipa.oz.lib.standard._Long_if L = (JP.go.ipa.oz.lib.standard._Long_cl) (new JP.go.ipa.oz.lib.standard._Long_cl ())._new_breed (-1);
// 780
          if (times != null) {{
// 781
              JP.go.ipa.oz.lib.standard._Dictionary_if remove$val$114;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) times)) {
                try {
                  remove$val$114 = times.remove (Name);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                remove$val$114 = times.remove (Name);
              }
// 781
              times = remove$val$114;
// 782
              JP.go.ipa.oz.lib.standard._Dictionary_if put$val$115;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) GOLtoTimes)) {
                try {
                  put$val$115 = GOLtoTimes.put (GOL, times);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                put$val$115 = GOLtoTimes.put (GOL, times);
              }
// 782
              GOLtoTimes = put$val$115;
            }
          }
        }
      }
    } finally {
      leave ();
    }
  }
  
  public _MillorTarget_cl () throws Exception { super (); }
  
}

