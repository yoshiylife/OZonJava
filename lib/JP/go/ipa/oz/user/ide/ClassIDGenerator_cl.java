package JP.go.ipa.oz.user.ide;

public class ClassIDGenerator_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.ide.ClassIDGenerator_if {
  JP.go.ipa.oz.lib.standard._Array_if ruleOfImplementationID;
  JP.go.ipa.oz.lib.standard._Array_if ruleOfInterfaceID;
  
  public Object _new_create () throws Exception  {
// 44
    ruleOfInterfaceID = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (2);
// 45
    JP.go.ipa.oz.lib.standard._String_if string$145 = (new JP.go.ipa.oz.lib.standard._String_cl("sample_if."));
    
// 45
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$804;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ruleOfInterfaceID)) {
      try {
        putAt$val$804 = ruleOfInterfaceID.putAt (0, string$145);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$804 = ruleOfInterfaceID.putAt (0, string$145);
    }
// 46
    JP.go.ipa.oz.lib.standard._String_if string$146 = (new JP.go.ipa.oz.lib.standard._String_cl("_if"));
    
// 46
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$805;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ruleOfInterfaceID)) {
      try {
        putAt$val$805 = ruleOfInterfaceID.putAt (1, string$146);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$805 = ruleOfInterfaceID.putAt (1, string$146);
    }
// 47
    ruleOfImplementationID = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (2);
// 48
    JP.go.ipa.oz.lib.standard._String_if string$147 = (new JP.go.ipa.oz.lib.standard._String_cl("sample_cl."));
    
// 48
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$806;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ruleOfImplementationID)) {
      try {
        putAt$val$806 = ruleOfImplementationID.putAt (0, string$147);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$806 = ruleOfImplementationID.putAt (0, string$147);
    }
// 49
    JP.go.ipa.oz.lib.standard._String_if string$148 = (new JP.go.ipa.oz.lib.standard._String_cl("_cl"));
    
// 49
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$807;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ruleOfImplementationID)) {
      try {
        putAt$val$807 = ruleOfImplementationID.putAt (1, string$148);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$807 = ruleOfImplementationID.putAt (1, string$148);
    }
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if generateImplementationID (JP.go.ipa.oz.lib.standard._String_if label) throws Exception  {
    checkSecureInvocation ();
// 77
    JP.go.ipa.oz.lib.standard._StringBuffer_if buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 78
    JP.go.ipa.oz.lib.standard._String_if head = null, tail = null;
// 79
    JP.go.ipa.oz.lang._Root_if at$val$808;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ruleOfImplementationID)) {
      try {
        at$val$808 = ruleOfImplementationID.at (0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      at$val$808 = ruleOfImplementationID.at (0);
    }
// 79
    head = (JP.go.ipa.oz.lib.standard._String_if) (at$val$808);
// 80
    JP.go.ipa.oz.lang._Root_if at$val$809;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ruleOfImplementationID)) {
      try {
        at$val$809 = ruleOfImplementationID.at (1);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      at$val$809 = ruleOfImplementationID.at (1);
    }
// 80
    tail = (JP.go.ipa.oz.lib.standard._String_if) (at$val$809);
// 81
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$810;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        append$val$810 = buf.append (head);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$810 = buf.append (head);
    }
// 82
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$811;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        append$val$811 = buf.append (label);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$811 = buf.append (label);
    }
// 83
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$812;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        append$val$812 = buf.append (tail);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$812 = buf.append (tail);
    }
// 84
    JP.go.ipa.oz.lib.standard._String_if asString$val$813;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        asString$val$813 = buf.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$813 = buf.asString ();
    }
// 84
    return asString$val$813;
  }
  
  public JP.go.ipa.oz.lib.standard._Array_if getRuleOfImplementationID () throws Exception  {
    checkSecureInvocation ();
// 113
    return ruleOfImplementationID;
  }
  
  public JP.go.ipa.oz.lib.standard._Array_if getRuleOfInterfaceID () throws Exception  {
    checkSecureInvocation ();
// 92
    return ruleOfInterfaceID;
  }
  
  public void setRuleOfImplementationID (JP.go.ipa.oz.lib.standard._Array_if rule) throws Exception  {
    checkSecureInvocation ();
// 121
    JP.go.ipa.oz.lib.standard._String_if tmp = null;
// 122
    JP.go.ipa.oz.lang._Root_if at$val$814;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rule)) {
      try {
        at$val$814 = rule.at (0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      at$val$814 = rule.at (0);
    }
// 122
    tmp = (JP.go.ipa.oz.lib.standard._String_if) (at$val$814);
// 123
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$815;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ruleOfImplementationID)) {
      try {
        putAt$val$815 = ruleOfImplementationID.putAt (0, tmp);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$815 = ruleOfImplementationID.putAt (0, tmp);
    }
// 124
    JP.go.ipa.oz.lang._Root_if at$val$816;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rule)) {
      try {
        at$val$816 = rule.at (1);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      at$val$816 = rule.at (1);
    }
// 124
    tmp = (JP.go.ipa.oz.lib.standard._String_if) (at$val$816);
// 125
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$817;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ruleOfImplementationID)) {
      try {
        putAt$val$817 = ruleOfImplementationID.putAt (1, tmp);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$817 = ruleOfImplementationID.putAt (1, tmp);
    }
  }
  
  public void setRuleOfInterfaceID (JP.go.ipa.oz.lib.standard._Array_if rule) throws Exception  {
    checkSecureInvocation ();
// 100
    JP.go.ipa.oz.lib.standard._String_if tmp = null;
// 101
    JP.go.ipa.oz.lang._Root_if at$val$818;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rule)) {
      try {
        at$val$818 = rule.at (0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      at$val$818 = rule.at (0);
    }
// 101
    tmp = (JP.go.ipa.oz.lib.standard._String_if) (at$val$818);
// 102
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$819;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ruleOfInterfaceID)) {
      try {
        putAt$val$819 = ruleOfInterfaceID.putAt (0, tmp);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$819 = ruleOfInterfaceID.putAt (0, tmp);
    }
// 103
    JP.go.ipa.oz.lang._Root_if at$val$820;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rule)) {
      try {
        at$val$820 = rule.at (1);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      at$val$820 = rule.at (1);
    }
// 103
    tmp = (JP.go.ipa.oz.lib.standard._String_if) (at$val$820);
// 104
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$821;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ruleOfInterfaceID)) {
      try {
        putAt$val$821 = ruleOfInterfaceID.putAt (1, tmp);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$821 = ruleOfInterfaceID.putAt (1, tmp);
    }
  }
  
  public JP.go.ipa.oz.lib.standard._String_if generateInterfaceID (JP.go.ipa.oz.lib.standard._String_if label) throws Exception  {
    checkSecureInvocation ();
// 61
    JP.go.ipa.oz.lib.standard._StringBuffer_if buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 62
    JP.go.ipa.oz.lib.standard._String_if head = null, tail = null;
// 63
    JP.go.ipa.oz.lang._Root_if at$val$822;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ruleOfInterfaceID)) {
      try {
        at$val$822 = ruleOfInterfaceID.at (0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      at$val$822 = ruleOfInterfaceID.at (0);
    }
// 63
    head = (JP.go.ipa.oz.lib.standard._String_if) (at$val$822);
// 64
    JP.go.ipa.oz.lang._Root_if at$val$823;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ruleOfInterfaceID)) {
      try {
        at$val$823 = ruleOfInterfaceID.at (1);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      at$val$823 = ruleOfInterfaceID.at (1);
    }
// 64
    tail = (JP.go.ipa.oz.lib.standard._String_if) (at$val$823);
// 65
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$824;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        append$val$824 = buf.append (head);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$824 = buf.append (head);
    }
// 66
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$825;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        append$val$825 = buf.append (label);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$825 = buf.append (label);
    }
// 67
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$826;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        append$val$826 = buf.append (tail);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$826 = buf.append (tail);
    }
// 68
    JP.go.ipa.oz.lib.standard._String_if asString$val$827;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        asString$val$827 = buf.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$827 = buf.asString ();
    }
// 68
    return asString$val$827;
  }
  
  public ClassIDGenerator_cl () throws Exception { super (); }
  
}

