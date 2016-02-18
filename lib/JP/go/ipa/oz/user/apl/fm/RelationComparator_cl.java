package JP.go.ipa.oz.user.apl.fm;

public class RelationComparator_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.apl.fm.RelationComparator_if {
  
  public Object _new_create () throws Exception  {
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._Comparator_if duplicate () throws Exception  {
    checkSecureInvocation ();
// 52
    JP.go.ipa.oz.user.apl.fm.RelationComparator_if rc = (JP.go.ipa.oz.user.apl.fm.RelationComparator_cl) (new JP.go.ipa.oz.user.apl.fm.RelationComparator_cl ())._new_create ();
// 53
    return rc;
  }
  
  public boolean compare (JP.go.ipa.oz.lang._Root_if rel1, JP.go.ipa.oz.lang._Root_if rel2) throws Exception  {
    checkSecureInvocation ();
// 10
    JP.go.ipa.oz.user.apl.fm.Relation_if r1 = null, r2 = null;
// 11
    r1 = (JP.go.ipa.oz.user.apl.fm.Relation_if) (rel1);
// 12
    r2 = (JP.go.ipa.oz.user.apl.fm.Relation_if) (rel2);
// 13
    boolean isEqualRelation$val$0;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) r1)) {
      try {
        isEqualRelation$val$0 = r1.isEqualRelation (r2);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isEqualRelation$val$0 = r1.isEqualRelation (r2);
    }
// 13
    return isEqualRelation$val$0;
  }
  
  public int hash (JP.go.ipa.oz.lang._Root_if rel) throws Exception  {
    checkSecureInvocation ();
// 18
    JP.go.ipa.oz.lib.standard._StringComparator_if sc = (JP.go.ipa.oz.lib.standard._StringComparator_cl) (new JP.go.ipa.oz.lib.standard._StringComparator_cl ())._new_create ();
// 19
    JP.go.ipa.oz.lib.standard._StringBuffer_if sb = null, sbsrc = null, sbdst = null;
// 20
    JP.go.ipa.oz.user.apl.fm.Relation_if r = null;
// 22
    r = (JP.go.ipa.oz.user.apl.fm.Relation_if) (rel);
// 23
    JP.go.ipa.oz.lib.standard._String_if getName$val$1;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) r)) {
      try {
        getName$val$1 = r.getName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getName$val$1 = r.getName ();
    }
// 23
    sb = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (getName$val$1);
// 24
    sbsrc = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 25
    sbdst = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 27
    JP.go.ipa.oz.user.apl.fm.Pointer_if getSource$val$2;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) r)) {
      try {
        getSource$val$2 = r.getSource ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSource$val$2 = r.getSource ();
    }
// 27
    JP.go.ipa.oz.user.apl.fm.Pointer_if src = getSource$val$2;
// 28
    if (src != null) {{
// 29
        JP.go.ipa.oz.lib.standard._String_if getLocation$val$3;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) src)) {
          try {
            getLocation$val$3 = src.getLocation ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getLocation$val$3 = src.getLocation ();
        }
// 29
        sbsrc = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (getLocation$val$3);
// 30
        JP.go.ipa.oz.lib.standard._String_if getName$val$4;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) src)) {
          try {
            getName$val$4 = src.getName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getName$val$4 = src.getName ();
        }
// 30
        sbsrc.append (getName$val$4);
      }
    }
// 33
    JP.go.ipa.oz.user.apl.fm.Pointer_if destination$val$5;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) r)) {
      try {
        destination$val$5 = r.destination ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      destination$val$5 = r.destination ();
    }
// 33
    JP.go.ipa.oz.user.apl.fm.Pointer_if dst = destination$val$5;
// 34
    if (dst != null) {{
// 35
        JP.go.ipa.oz.lib.standard._String_if getLocation$val$6;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dst)) {
          try {
            getLocation$val$6 = dst.getLocation ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getLocation$val$6 = dst.getLocation ();
        }
// 35
        sbdst = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (getLocation$val$6);
// 36
        JP.go.ipa.oz.lib.standard._String_if getName$val$7;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dst)) {
          try {
            getName$val$7 = dst.getName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getName$val$7 = dst.getName ();
        }
// 36
        sbdst.append (getName$val$7);
      }
    }
// 39
    JP.go.ipa.oz.lib.standard._String_if asString$val$8;
    asString$val$8 = sbsrc.asString ();
// 39
    int hash$val$9;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sc)) {
      try {
        hash$val$9 = sc.hash (asString$val$8);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      hash$val$9 = sc.hash (asString$val$8);
    }
// 39
    JP.go.ipa.oz.lib.standard._String_if asString$val$10;
    asString$val$10 = sbdst.asString ();
// 39
    int hash$val$11;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sc)) {
      try {
        hash$val$11 = sc.hash (asString$val$10);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      hash$val$11 = sc.hash (asString$val$10);
    }
// 39
    if ((hash$val$9) <= (hash$val$11)) {{
// 41
        sb.append (sbsrc);
// 42
        sb.append (sbdst);
// 43
        JP.go.ipa.oz.lib.standard._String_if asString$val$12;
        asString$val$12 = sb.asString ();
// 43
        int hash$val$13;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sc)) {
          try {
            hash$val$13 = sc.hash (asString$val$12);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          hash$val$13 = sc.hash (asString$val$12);
        }
// 43
        return hash$val$13;
      }
    } else {{
// 45
        sb.append (sbdst);
// 46
        sb.append (sbsrc);
// 47
        JP.go.ipa.oz.lib.standard._String_if asString$val$14;
        asString$val$14 = sb.asString ();
// 47
        int hash$val$15;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sc)) {
          try {
            hash$val$15 = sc.hash (asString$val$14);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          hash$val$15 = sc.hash (asString$val$14);
        }
// 47
        return hash$val$15;
      }
    }
  }
  
  public RelationComparator_cl () throws Exception { super (); }
  
}

