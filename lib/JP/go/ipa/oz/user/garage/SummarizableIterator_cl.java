package JP.go.ipa.oz.user.garage;

public class SummarizableIterator_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.garage.SummarizableIterator_if {
  JP.go.ipa.oz.lib.standard._Collection_if keyList;
  JP.go.ipa.oz.lib.standard._String_if sgarageGOL;
  JP.go.ipa.oz.lib.standard._Iterator_if keyItr;
  JP.go.ipa.oz.user.garage.SGarage_if sgarage;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._String_if gol, JP.go.ipa.oz.lib.standard._Collection_if keys) throws Exception  {
// 36
    sgarageGOL = gol;
// 37
    sgarage = new JP.go.ipa.oz.user.garage.SGarage_pcl (gol);
// 38
    keyList = keys;
// 39
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$24;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) keyList)) {
      try {
        iterator$val$24 = keyList.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$24 = keyList.iterator ();
    }
// 39
    keyItr = iterator$val$24;
    return this;
  }
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._Collection_if keys) throws Exception  {
// 26
    sgarageGOL = getGOL ();
// 27
    sgarage = new JP.go.ipa.oz.user.garage.SGarage_pcl (sgarageGOL);
// 28
    keyList = keys;
// 29
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$25;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) keyList)) {
      try {
        iterator$val$25 = keyList.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$25 = keyList.iterator ();
    }
// 29
    keyItr = iterator$val$25;
    return this;
  }
  
  public JP.go.ipa.oz.lang._Root_if nextElement () throws Exception  {
    checkSecureInvocation ();
// 62
    JP.go.ipa.oz.lang._Root_if elm = null;
// 63
    JP.go.ipa.oz.user.garage.Key_if key = null;
// 65
    JP.go.ipa.oz.lang._Root_if nextElement$val$26;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) keyItr)) {
      try {
        nextElement$val$26 = keyItr.nextElement ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      nextElement$val$26 = keyItr.nextElement ();
    }
// 65
    key = (JP.go.ipa.oz.user.garage.Key_if) (nextElement$val$26);
// 67
    JP.go.ipa.oz.user.ide.Summarizable_if get$val$27;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sgarage)) {
      try {
        get$val$27 = sgarage.get (key);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      get$val$27 = sgarage.get (key);
    }
// 67
    elm = get$val$27;
// 69
    return elm;
  }
  
  public boolean hasMoreElements () throws Exception  {
    checkSecureInvocation ();
// 55
    boolean hasMoreElements$val$28;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) keyItr)) {
      try {
        hasMoreElements$val$28 = keyItr.hasMoreElements ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      hasMoreElements$val$28 = keyItr.hasMoreElements ();
    }
// 55
    return hasMoreElements$val$28;
  }
  
  public boolean atEnd () throws Exception  {
    checkSecureInvocation ();
// 48
    boolean atEnd$val$29;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) keyItr)) {
      try {
        atEnd$val$29 = keyItr.atEnd ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      atEnd$val$29 = keyItr.atEnd ();
    }
// 48
    return atEnd$val$29;
  }
  
  public SummarizableIterator_cl () throws Exception { super (); }
  
}

