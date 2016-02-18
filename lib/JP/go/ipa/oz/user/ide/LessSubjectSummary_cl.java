package JP.go.ipa.oz.user.ide;

public class LessSubjectSummary_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.ide.LessSubjectSummary_if {
  
  public Object _new_create () throws Exception  {
    return this;
  }
  
  public boolean execute (JP.go.ipa.oz.lang._Root_if obj1, JP.go.ipa.oz.lang._Root_if obj2) throws Exception  {
    checkSecureInvocation ();
// 41
    JP.go.ipa.oz.user.ide.SubjectSummary_if sm1 = null, sm2 = null;
// 42
    JP.go.ipa.oz.lib.standard._String_if name1 = null, name2 = null;
// 44
    sm1 = (JP.go.ipa.oz.user.ide.SubjectSummary_if) (obj1);
// 45
    sm2 = (JP.go.ipa.oz.user.ide.SubjectSummary_if) (obj2);
// 46
    JP.go.ipa.oz.lib.standard._String_if getName$val$1154;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sm1)) {
      try {
        getName$val$1154 = sm1.getName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getName$val$1154 = sm1.getName ();
    }
// 46
    name1 = getName$val$1154;
// 47
    JP.go.ipa.oz.lib.standard._String_if getName$val$1155;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sm2)) {
      try {
        getName$val$1155 = sm2.getName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getName$val$1155 = sm2.getName ();
    }
// 47
    name2 = getName$val$1155;
// 48
    int compareTo$val$1156;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) name1)) {
      try {
        compareTo$val$1156 = name1.compareTo (name2);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compareTo$val$1156 = name1.compareTo (name2);
    }
// 48
    return (compareTo$val$1156 < 0);
  }
  
  public LessSubjectSummary_cl () throws Exception { super (); }
  
}

