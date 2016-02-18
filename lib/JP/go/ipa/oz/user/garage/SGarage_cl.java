package JP.go.ipa.oz.user.garage;

public class SGarage_cl extends JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_cl implements JP.go.ipa.oz.user.garage.SGarage_if {
  static final boolean _global_ = true;
  protected JP.go.ipa.oz.user.garage.Garage_if garage;
  
  public JP.go.ipa.oz.lib.standard._Iterator_if iterator () throws Exception  {
    checkSecureInvocation ();
// 50
    JP.go.ipa.oz.user.garage.SummarizableIterator_if itr = null;
// 51
    JP.go.ipa.oz.lib.standard._Collection_if keys = null;
// 53
    JP.go.ipa.oz.lib.standard._Collection_if keys$val$12;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) garage)) {
      try {
        keys$val$12 = garage.keys ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      keys$val$12 = garage.keys ();
    }
// 53
    keys = keys$val$12;
// 54
    itr = (JP.go.ipa.oz.user.garage.SummarizableIterator_cl) (new JP.go.ipa.oz.user.garage.SummarizableIterator_cl ())._new_create (keys);
// 56
    return itr;
  }
  
  protected void go () throws Exception  {
  }
  
  public void replace (JP.go.ipa.oz.user.garage.Key_if key, JP.go.ipa.oz.user.ide.Summarizable_if sbl) throws Exception  {
    checkSecureInvocation ();
// 85
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) garage)) {
      try {
        garage.replace (key, sbl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      garage.replace (key, sbl);
    }
  }
  
  public JP.go.ipa.oz.user.ide.Summary_if getSummary (JP.go.ipa.oz.user.garage.Key_if key) throws Exception  {
    checkSecureInvocation ();
// 35
    JP.go.ipa.oz.user.ide.Summarizable_if sbl = null;
// 36
    JP.go.ipa.oz.user.ide.Summary_if sm = null;
// 38
    JP.go.ipa.oz.lang._Root_if get$val$13;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) garage)) {
      try {
        get$val$13 = garage.get (key);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      get$val$13 = garage.get (key);
    }
// 38
    sbl = (JP.go.ipa.oz.user.ide.Summarizable_if) (get$val$13);
// 39
    if (sbl != null) {{
// 40
        JP.go.ipa.oz.user.ide.Summary_if getSummary$val$14;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbl)) {
          try {
            getSummary$val$14 = sbl.getSummary ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSummary$val$14 = sbl.getSummary ();
        }
// 40
        sm = getSummary$val$14;
      }
    }
// 43
    return sm;
  }
  
  JP.go.ipa.oz.lib.standard._Collection_if summaries () throws Exception  {
// 151
    JP.go.ipa.oz.lib.standard._Set_if smSet = null;
// 152
    JP.go.ipa.oz.lib.standard._Iterator_if itr = null;
// 153
    JP.go.ipa.oz.user.ide.Summarizable_if sbl = null;
// 154
    JP.go.ipa.oz.user.ide.Summary_if smr = null;
// 156
    smSet = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create ();
// 157
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$15;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) garage)) {
      try {
        iterator$val$15 = garage.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$15 = garage.iterator ();
    }
// 157
    itr = iterator$val$15;
// 158
    while (true) {
// 158
      boolean hasMoreElements$val$16;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
        try {
          hasMoreElements$val$16 = itr.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$16 = itr.hasMoreElements ();
      }
      if (!(hasMoreElements$val$16)) break;
      
      /* body */ _loop_1: {
// 159
        JP.go.ipa.oz.lang._Root_if nextElement$val$17;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
          try {
            nextElement$val$17 = itr.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$17 = itr.nextElement ();
        }
// 159
        sbl = (JP.go.ipa.oz.user.ide.Summarizable_if) (nextElement$val$17);
// 160
        JP.go.ipa.oz.user.ide.Summary_if getSummary$val$18;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbl)) {
          try {
            getSummary$val$18 = sbl.getSummary ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSummary$val$18 = sbl.getSummary ();
        }
// 160
        smr = getSummary$val$18;
// 161
        smSet.add (smr);
      }
    }
// 164
    return smSet;
  }
  
  public void stop () throws Exception  {
    checkSecureInvocation ();
// 108
    stopCell ();
  }
  
  public void remove (JP.go.ipa.oz.user.garage.Key_if key) throws Exception  {
    checkSecureInvocation ();
// 78
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) garage)) {
      try {
        garage.remove (key);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      garage.remove (key);
    }
  }
  
  public void replaceSummary (JP.go.ipa.oz.user.garage.Key_if key, JP.go.ipa.oz.user.ide.Summary_if sm) throws Exception  {
    checkSecureInvocation ();
// 92
    JP.go.ipa.oz.user.ide.Summarizable_if sbl = null;
// 94
    if (sm != null) {{
// 95
        JP.go.ipa.oz.lang._Root_if get$val$19;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) garage)) {
          try {
            get$val$19 = garage.get (key);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          get$val$19 = garage.get (key);
        }
// 95
        sbl = (JP.go.ipa.oz.user.ide.Summarizable_if) (get$val$19);
// 96
        if (sbl != null) {{
// 97
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sm)) {
              try {
                sm.setKey (key);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              sm.setKey (key);
            }
// 98
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sm)) {
              try {
                sm.setLocation ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              sm.setLocation ();
            }
// 99
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbl)) {
              try {
                sbl.setSummary (sm);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              sbl.setSummary (sm);
            }
          }
        }
      }
    }
  }
  
  protected void quiet () throws Exception  {
// 141
    flushCell ();
  }
  
  protected void initialize () throws Exception  {
// 127
    garage = (JP.go.ipa.oz.user.garage.Garage_cl) (new JP.go.ipa.oz.user.garage.Garage_cl ())._new_create ();
// 128
    stopCell ();
  }
  
  public JP.go.ipa.oz.lib.standard._Iterator_if summaryIterator () throws Exception  {
    checkSecureInvocation ();
// 115
    JP.go.ipa.oz.user.garage.SummaryIterator_if itr = null;
// 116
    itr = (JP.go.ipa.oz.user.garage.SummaryIterator_cl) (new JP.go.ipa.oz.user.garage.SummaryIterator_cl ())._new_create (summaries ());
// 118
    return itr;
  }
  
  public JP.go.ipa.oz.user.ide.Summarizable_if get (JP.go.ipa.oz.user.garage.Key_if key) throws Exception  {
    checkSecureInvocation ();
// 24
    JP.go.ipa.oz.user.ide.Summarizable_if sbl = null;
// 26
    JP.go.ipa.oz.lang._Root_if get$val$20;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) garage)) {
      try {
        get$val$20 = garage.get (key);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      get$val$20 = garage.get (key);
    }
// 26
    sbl = (JP.go.ipa.oz.user.ide.Summarizable_if) (get$val$20);
// 28
    return sbl;
  }
  
  public JP.go.ipa.oz.user.garage.Key_if put (JP.go.ipa.oz.user.ide.Summarizable_if sbl) throws Exception  {
    checkSecureInvocation ();
// 63
    JP.go.ipa.oz.user.ide.Summary_if smr = null;
// 64
    JP.go.ipa.oz.user.garage.Key_if key = null;
// 66
    JP.go.ipa.oz.user.ide.Summary_if getSummary$val$21;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbl)) {
      try {
        getSummary$val$21 = sbl.getSummary ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSummary$val$21 = sbl.getSummary ();
    }
// 66
    smr = getSummary$val$21;
// 67
    JP.go.ipa.oz.user.garage.Key_if put$val$22;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) garage)) {
      try {
        put$val$22 = garage.put (sbl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      put$val$22 = garage.put (sbl);
    }
// 67
    key = put$val$22;
// 68
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smr)) {
      try {
        smr.setKey (key);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      smr.setKey (key);
    }
// 69
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smr)) {
      try {
        smr.setLocation ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      smr.setLocation ();
    }
// 71
    return key;
  }
  
  public SGarage_cl () { super ("JP.go.ipa.oz.user.garage.SGarage_pcl"); }
  
  public SGarage_cl (String proxy_id) { super (proxy_id); }
  
}

