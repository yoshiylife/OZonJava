package JP.go.ipa.oz.user.apl.fm;

public class Actor_cl extends JP.go.ipa.oz.user.apl.fm.FMObject_cl implements JP.go.ipa.oz.user.apl.fm.Actor_if {
  
  public Object _new_create (JP.go.ipa.oz.user.apl.fm.Actor_if a) throws Exception  {
// 124
    JP.go.ipa.oz.lib.standard._String_if getName$val$195;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) a)) {
      try {
        getName$val$195 = a.getName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getName$val$195 = a.getName ();
    }
// 124
    JP.go.ipa.oz.lib.standard._Set_if getAllRelations$val$196;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) a)) {
      try {
        getAllRelations$val$196 = a.getAllRelations ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getAllRelations$val$196 = a.getAllRelations ();
    }
// 124
    JP.go.ipa.oz.user.apl.fm.Pointer_if getIdentifier$val$197;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) a)) {
      try {
        getIdentifier$val$197 = a.getIdentifier ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getIdentifier$val$197 = a.getIdentifier ();
    }
// 124
    super._new_create (getName$val$195, getAllRelations$val$196, getIdentifier$val$197);
    return this;
  }
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._String_if nam) throws Exception  {
// 16
    super._new_create ();
// 17
    setName (nam);
    return this;
  }
  
  public Object _new_create () throws Exception  {
// 12
    super._new_create ();
    return this;
  }
  
  public void setAccess (JP.go.ipa.oz.lib.standard._String_if access) throws Exception  {
    checkSecureInvocation ();
// 62
    JP.go.ipa.oz.lib.standard._SList_if list = findRelations ((new JP.go.ipa.oz.lib.standard._String_cl("Access")));
// 63
    JP.go.ipa.oz.user.apl.fm.Relation_if rel = null;
// 64
    JP.go.ipa.oz.user.apl.fm.FMObject_if obj = null;
// 66
    if (list == null) {{
// 67
        JP.go.ipa.oz.user.apl.fm.FMContainer_if fed = federation ();
// 68
        obj = (JP.go.ipa.oz.user.apl.fm.FMObject_cl) (new JP.go.ipa.oz.user.apl.fm.FMObject_cl ())._new_create ();
// 69
        JP.go.ipa.oz.user.apl.fm.Pointer_if add$val$198;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fed)) {
          try {
            add$val$198 = fed.add (obj);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          add$val$198 = fed.add (obj);
        }
// 71
        rel = createRelation ((new JP.go.ipa.oz.lib.standard._String_cl("Access")), obj);
      }
    } else {{
// 73
        JP.go.ipa.oz.lang._Root_if first$val$199;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) list)) {
          try {
            first$val$199 = list.first ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          first$val$199 = list.first ();
        }
// 73
        rel = (JP.go.ipa.oz.user.apl.fm.Relation_if) (first$val$199);
// 74
        JP.go.ipa.oz.user.apl.fm.FMObject_if get$val$200;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rel)) {
          try {
            get$val$200 = rel.get ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          get$val$200 = rel.get ();
        }
// 74
        obj = get$val$200;
      }
    }
// 76
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
      try {
        obj.setName (access);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      obj.setName (access);
    }
// 77
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
      try {
        obj.commit ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      obj.commit ();
    }
  }
  
  public void trace (int mark) throws Exception  {
    checkSecureInvocation ();
// 128
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 129
    JP.go.ipa.oz.lib.standard._PrintWriter_if getStdout$val$201;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        getStdout$val$201 = system.getStdout ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getStdout$val$201 = system.getStdout ();
    }
// 129
    JP.go.ipa.oz.lib.standard._PrintWriter_if pw = (JP.go.ipa.oz.lib.standard._PrintWriter_cl) (new JP.go.ipa.oz.lib.standard._PrintWriter_cl ())._new_breed (getStdout$val$201, true);
// 130
    JP.go.ipa.oz.lib.standard._String_if string$32 = (new JP.go.ipa.oz.lib.standard._String_cl("Actor#trace("));
    
// 130
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.print (string$32);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.print (string$32);
    }
// 131
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.print (mark);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.print (mark);
    }
// 132
    JP.go.ipa.oz.lib.standard._String_if string$33 = (new JP.go.ipa.oz.lib.standard._String_cl(")"));
    
// 132
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.println (string$33);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.println (string$33);
    }
// 133
    JP.go.ipa.oz.lib.standard._String_if string$34 = (new JP.go.ipa.oz.lib.standard._String_cl("---- super ----"));
    
// 133
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.println (string$34);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.println (string$34);
    }
// 134
    super.trace (mark);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getPlace () throws Exception  {
    checkSecureInvocation ();
// 48
    JP.go.ipa.oz.user.apl.fm.FMObject_if obj = getRelatedObject ((new JP.go.ipa.oz.lib.standard._String_cl("Place")));
// 50
    if (obj != null) {{
// 51
        JP.go.ipa.oz.lib.standard._String_if getName$val$202;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
          try {
            getName$val$202 = obj.getName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getName$val$202 = obj.getName ();
        }
// 51
        return getName$val$202;
      }
    }
// 53
    return null;
  }
  
  public JP.go.ipa.oz.user.apl.fm.FMObject_if cloneSelf () throws Exception  {
    checkSecureInvocation ();
// 119
    JP.go.ipa.oz.user.apl.fm.Actor_if clone = (JP.go.ipa.oz.user.apl.fm.Actor_cl) (new JP.go.ipa.oz.user.apl.fm.Actor_cl ())._new_create (this);
// 120
    return clone;
  }
  
  public void setPlace (JP.go.ipa.oz.lib.standard._String_if place) throws Exception  {
    checkSecureInvocation ();
// 26
    JP.go.ipa.oz.lib.standard._SList_if list = findRelations ((new JP.go.ipa.oz.lib.standard._String_cl("Place")));
// 27
    JP.go.ipa.oz.user.apl.fm.Relation_if rel = null;
// 28
    JP.go.ipa.oz.user.apl.fm.FMObject_if obj = null;
// 30
    if (list == null) {{
// 31
        JP.go.ipa.oz.user.apl.fm.FMContainer_if fed = federation ();
// 32
        obj = (JP.go.ipa.oz.user.apl.fm.FMObject_cl) (new JP.go.ipa.oz.user.apl.fm.FMObject_cl ())._new_create ();
// 33
        JP.go.ipa.oz.user.apl.fm.Pointer_if add$val$203;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fed)) {
          try {
            add$val$203 = fed.add (obj);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          add$val$203 = fed.add (obj);
        }
// 35
        rel = createRelation ((new JP.go.ipa.oz.lib.standard._String_cl("Place")), obj);
      }
    } else {{
// 37
        JP.go.ipa.oz.lang._Root_if first$val$204;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) list)) {
          try {
            first$val$204 = list.first ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          first$val$204 = list.first ();
        }
// 37
        rel = (JP.go.ipa.oz.user.apl.fm.Relation_if) (first$val$204);
// 38
        JP.go.ipa.oz.user.apl.fm.FMObject_if get$val$205;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rel)) {
          try {
            get$val$205 = rel.get ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          get$val$205 = rel.get ();
        }
// 38
        obj = get$val$205;
      }
    }
// 40
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
      try {
        obj.setName (place);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      obj.setName (place);
    }
// 41
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
      try {
        obj.commit ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      obj.commit ();
    }
  }
  
  public void setRole (JP.go.ipa.oz.user.apl.fm.Actor_if actor) throws Exception  {
    checkSecureInvocation ();
// 112
    JP.go.ipa.oz.user.apl.fm.Relation_if rel = createRelation ((new JP.go.ipa.oz.lib.standard._String_cl("Role")), actor);
// 113
    JP.go.ipa.oz.lib.standard._String_if string$35 = (new JP.go.ipa.oz.lib.standard._String_cl("Role"));
    
// 113
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rel)) {
      try {
        rel.setDstRole (string$35);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      rel.setDstRole (string$35);
    }
// 114
    JP.go.ipa.oz.lib.standard._String_if string$36 = (new JP.go.ipa.oz.lib.standard._String_cl("ParentRole"));
    
// 114
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rel)) {
      try {
        rel.setSrcRole (string$36);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      rel.setSrcRole (string$36);
    }
  }
  
  public void setRole (JP.go.ipa.oz.lib.standard._String_if roleName) throws Exception  {
    checkSecureInvocation ();
// 98
    JP.go.ipa.oz.user.apl.fm.Actor_if actor = (JP.go.ipa.oz.user.apl.fm.Actor_cl) (new JP.go.ipa.oz.user.apl.fm.Actor_cl ())._new_create ();
// 99
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) actor)) {
      try {
        actor.setName (roleName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      actor.setName (roleName);
    }
// 100
    JP.go.ipa.oz.user.apl.fm.FMContainer_if fed = federation ();
// 101
    JP.go.ipa.oz.user.apl.fm.Pointer_if add$val$206;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fed)) {
      try {
        add$val$206 = fed.add (actor);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$206 = fed.add (actor);
    }
// 103
    setRole (actor);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getAccess () throws Exception  {
    checkSecureInvocation ();
// 84
    JP.go.ipa.oz.user.apl.fm.FMObject_if obj = getRelatedObject ((new JP.go.ipa.oz.lib.standard._String_cl("Access")));
// 86
    if (obj != null) {{
// 87
        JP.go.ipa.oz.lib.standard._String_if getName$val$207;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
          try {
            getName$val$207 = obj.getName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getName$val$207 = obj.getName ();
        }
// 87
        return getName$val$207;
      }
    }
// 89
    return null;
  }
  
  public Actor_cl () throws Exception { super (); }
  
}

