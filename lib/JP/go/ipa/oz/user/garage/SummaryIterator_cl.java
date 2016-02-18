package JP.go.ipa.oz.user.garage;

public class SummaryIterator_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.garage.SummaryIterator_if {
  JP.go.ipa.oz.lib.standard._Iterator_if summaryItr;
  JP.go.ipa.oz.lib.standard._Collection_if summaryList;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._Collection_if summaries) throws Exception  {
// 22
    summaryList = summaries;
// 23
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$30;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summaryList)) {
      try {
        iterator$val$30 = summaryList.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$30 = summaryList.iterator ();
    }
// 23
    summaryItr = iterator$val$30;
    return this;
  }
  
  public JP.go.ipa.oz.lang._Root_if nextElement () throws Exception  {
    checkSecureInvocation ();
// 46
    JP.go.ipa.oz.lang._Root_if nextElement$val$31;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summaryItr)) {
      try {
        nextElement$val$31 = summaryItr.nextElement ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      nextElement$val$31 = summaryItr.nextElement ();
    }
// 46
    return nextElement$val$31;
  }
  
  public boolean hasMoreElements () throws Exception  {
    checkSecureInvocation ();
// 39
    boolean hasMoreElements$val$32;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summaryItr)) {
      try {
        hasMoreElements$val$32 = summaryItr.hasMoreElements ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      hasMoreElements$val$32 = summaryItr.hasMoreElements ();
    }
// 39
    return hasMoreElements$val$32;
  }
  
  public boolean atEnd () throws Exception  {
    checkSecureInvocation ();
// 32
    boolean atEnd$val$33;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summaryItr)) {
      try {
        atEnd$val$33 = summaryItr.atEnd ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      atEnd$val$33 = summaryItr.atEnd ();
    }
// 32
    return atEnd$val$33;
  }
  
  public SummaryIterator_cl () throws Exception { super (); }
  
}

