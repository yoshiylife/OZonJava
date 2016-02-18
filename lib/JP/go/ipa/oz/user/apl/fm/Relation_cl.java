package JP.go.ipa.oz.user.apl.fm;

public class Relation_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.apl.fm.Relation_if {
  boolean available;
  JP.go.ipa.oz.lib.standard._String_if dstRole;
  JP.go.ipa.oz.lib.standard._String_if name;
  JP.go.ipa.oz.lib.standard._String_if srcRole;
  JP.go.ipa.oz.user.apl.fm.Pointer_if src;
  protected JP.go.ipa.oz.user.apl.fm.Pointer_if dst;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._String_if name, JP.go.ipa.oz.user.apl.fm.Pointer_if src, JP.go.ipa.oz.lib.standard._String_if srcRole, JP.go.ipa.oz.user.apl.fm.Pointer_if dst, JP.go.ipa.oz.lib.standard._String_if dstRole, boolean available) throws Exception  {
// 34
    ((JP.go.ipa.oz.user.apl.fm.Relation_cl)this).name = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed (name);
// 35
    if (src != null) {{
// 36
        JP.go.ipa.oz.lib.standard._String_if getLocation$val$31;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) src)) {
          try {
            getLocation$val$31 = src.getLocation ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getLocation$val$31 = src.getLocation ();
        }
// 36
        JP.go.ipa.oz.lib.standard._String_if sloc = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed (getLocation$val$31);
// 37
        JP.go.ipa.oz.lib.standard._String_if getName$val$32;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) src)) {
          try {
            getName$val$32 = src.getName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getName$val$32 = src.getName ();
        }
// 37
        JP.go.ipa.oz.lib.standard._String_if snm = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed (getName$val$32);
// 38
        ((JP.go.ipa.oz.user.apl.fm.Relation_cl)this).src = (JP.go.ipa.oz.user.apl.fm.Pointer_cl) (new JP.go.ipa.oz.user.apl.fm.Pointer_cl ())._new_create (sloc, snm);
      }
    } else {{
// 40
        ((JP.go.ipa.oz.user.apl.fm.Relation_cl)this).src = null;
      }
    }
// 42
    ((JP.go.ipa.oz.user.apl.fm.Relation_cl)this).srcRole = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed (srcRole);
// 43
    if (dst != null) {{
// 44
        JP.go.ipa.oz.lib.standard._String_if getLocation$val$33;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dst)) {
          try {
            getLocation$val$33 = dst.getLocation ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getLocation$val$33 = dst.getLocation ();
        }
// 44
        JP.go.ipa.oz.lib.standard._String_if dloc = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed (getLocation$val$33);
// 45
        JP.go.ipa.oz.lib.standard._String_if getName$val$34;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dst)) {
          try {
            getName$val$34 = dst.getName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getName$val$34 = dst.getName ();
        }
// 45
        JP.go.ipa.oz.lib.standard._String_if dnm = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed (getName$val$34);
// 46
        ((JP.go.ipa.oz.user.apl.fm.Relation_cl)this).dst = (JP.go.ipa.oz.user.apl.fm.Pointer_cl) (new JP.go.ipa.oz.user.apl.fm.Pointer_cl ())._new_create (dloc, dnm);
      }
    } else {{
// 48
        ((JP.go.ipa.oz.user.apl.fm.Relation_cl)this).dst = null;
      }
    }
// 50
    ((JP.go.ipa.oz.user.apl.fm.Relation_cl)this).dstRole = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed (dstRole);
// 51
    ((JP.go.ipa.oz.user.apl.fm.Relation_cl)this).available = available;
    return this;
  }
  
  public Object _new_create () throws Exception  {
// 21
    name = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("UnKnown")));
// 22
    src = null;
// 23
    srcRole = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("UnKnown")));
// 24
    dst = null;
// 25
    dstRole = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("UnKnown")));
// 26
    enable ();
    return this;
  }
  
  public void detach () throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 155
      if (isAvailable () != true) {{
// 156
          enableWithoutLock (false);
// 157
          JP.go.ipa.oz.user.apl.fm.FMObject_if obj = getObj ();
// 158
          if (obj != null) {{
// 159
              JP.go.ipa.oz.user.apl.fm.Relation_if getRelation$val$35;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
                try {
                  getRelation$val$35 = obj.getRelation (this);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                getRelation$val$35 = obj.getRelation (this);
              }
// 159
              JP.go.ipa.oz.user.apl.fm.Relation_if r = getRelation$val$35;
// 160
              if (r != null) {{
// 161
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) r)) {
                    try {
                      r.disable ();
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    r.disable ();
                  }
// 162
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
              }
            }
          }
        }
      }
    } finally {
      leave ();
    }
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getRole (JP.go.ipa.oz.user.apl.fm.Pointer_if ptr) throws Exception  {
    checkSecureInvocation ();
// 261
    boolean equals$val$36;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ptr)) {
      try {
        equals$val$36 = ptr.equals (src);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      equals$val$36 = ptr.equals (src);
    }
// 261
    if (equals$val$36) {
// 262
      return getSrcRole ();
    }
// 263
    boolean equals$val$37;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ptr)) {
      try {
        equals$val$37 = ptr.equals (dst);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      equals$val$37 = ptr.equals (dst);
    }
// 263
    if (equals$val$37) {
// 265
      return getDstRole ();
    }
// 265
    return null;
  }
  
  public void disable () throws Exception  {
    checkSecureInvocation ();
// 310
    enable (false);
  }
  
  public JP.go.ipa.oz.user.apl.fm.FMObject_if get () throws Exception  {
    checkSecureInvocation ();
// 93
    if (available) {{
// 94
        return getObj ();
      }
    }
// 97
    return null;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getDstRole () throws Exception  {
    checkSecureInvocation ();
// 237
    return dstRole;
  }
  
  public void setName (JP.go.ipa.oz.lib.standard._String_if n) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 192
      name = n;
    } finally {
      leave ();
    }
  }
  
  public void setSrcRole (JP.go.ipa.oz.lib.standard._String_if n) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 210
      srcRole = n;
    } finally {
      leave ();
    }
  }
  
  public void toGreen () throws Exception  {
    checkSecureInvocation ();
// 411
    JP.go.ipa.oz.user.apl.fm.Overseer_if overseer = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 412
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
      try {
        overseer.permit (name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      overseer.permit (name);
    }
// 413
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
      try {
        overseer.permit (src);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      overseer.permit (src);
    }
// 414
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
      try {
        overseer.permit (srcRole);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      overseer.permit (srcRole);
    }
// 415
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
      try {
        overseer.permit (dst);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      overseer.permit (dst);
    }
// 416
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
      try {
        overseer.permit (dstRole);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      overseer.permit (dstRole);
    }
  }
  
  public boolean isAvailable () throws Exception  {
    checkSecureInvocation ();
// 319
    return available;
  }
  
  public void setRole (JP.go.ipa.oz.lib.standard._String_if n, JP.go.ipa.oz.user.apl.fm.Pointer_if ptr) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 247
      boolean equals$val$38;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ptr)) {
        try {
          equals$val$38 = ptr.equals (src);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        equals$val$38 = ptr.equals (src);
      }
// 247
      if (equals$val$38) {
// 248
        srcRole = n;
      } else {
// 249
        boolean equals$val$39;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ptr)) {
          try {
            equals$val$39 = ptr.equals (dst);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          equals$val$39 = ptr.equals (dst);
        }
// 249
        if (equals$val$39) {
// 250
          dstRole = n;
        }
      }
    } finally {
      leave ();
    }
  }
  
  protected JP.go.ipa.oz.user.apl.fm.FMObject_if getObj () throws Exception  {
// 103
    if (dst != null) {{
// 104
        JP.go.ipa.oz.user.apl.fm.FMContainer_if container$val$40;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dst)) {
          try {
            container$val$40 = dst.container ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          container$val$40 = dst.container ();
        }
// 104
        JP.go.ipa.oz.user.apl.fm.FMContainer_if fed = container$val$40;
// 105
        if (fed != null) {{
// 106
            JP.go.ipa.oz.user.apl.fm.Overseer_if overseer = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 107
            JP.go.ipa.oz.user.apl.fm.FMObject_if rtn = null;
// 108
            JP.go.ipa.oz.user.apl.fm.FMObject_if get$val$41;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fed)) {
              try {
                get$val$41 = fed.get (dst);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              get$val$41 = fed.get (dst);
            }
// 108
            rtn = get$val$41;
// 109
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
              try {
                overseer.permit (rtn);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              overseer.permit (rtn);
            }
// 110
            return rtn;
          }
        }
      }
    }
// 113
    return null;
  }
  
  public void attach (JP.go.ipa.oz.user.apl.fm.Pointer_if ptr) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 124
      JP.go.ipa.oz.user.apl.fm.Overseer_if over = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 125
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
        try {
          over.permit (ptr);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        over.permit (ptr);
      }
// 126
      JP.go.ipa.oz.user.apl.fm.FMObject_if stuff$val$42;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ptr)) {
        try {
          stuff$val$42 = ptr.stuff ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        stuff$val$42 = ptr.stuff ();
      }
// 126
      JP.go.ipa.oz.user.apl.fm.FMObject_if obj = stuff$val$42;
// 129
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
        try {
          over.permit (ptr);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        over.permit (ptr);
      }
// 130
      if (obj != null) {{
// 131
          JP.go.ipa.oz.user.apl.fm.Relation_if getRelation$val$43;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
            try {
              getRelation$val$43 = obj.getRelation (this);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getRelation$val$43 = obj.getRelation (this);
          }
// 131
          JP.go.ipa.oz.user.apl.fm.Relation_if r = getRelation$val$43;
// 133
          if (r == null) {{
// 134
              dst = ptr;
// 135
              r = cloneRelation ();
// 137
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) r)) {
                try {
                  r.setSource (dst);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                r.setSource (dst);
              }
// 138
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) r)) {
                try {
                  r.setDestination (src);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                r.setDestination (src);
              }
// 139
              JP.go.ipa.oz.lib.standard._String_if getSrcRole$val$44;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) r)) {
                try {
                  getSrcRole$val$44 = r.getSrcRole ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                getSrcRole$val$44 = r.getSrcRole ();
              }
// 139
              JP.go.ipa.oz.lib.standard._String_if s = getSrcRole$val$44;
// 140
              JP.go.ipa.oz.lib.standard._String_if getDstRole$val$45;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) r)) {
                try {
                  getDstRole$val$45 = r.getDstRole ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                getDstRole$val$45 = r.getDstRole ();
              }
// 140
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) r)) {
                try {
                  r.setSrcRole (getDstRole$val$45);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                r.setSrcRole (getDstRole$val$45);
              }
// 141
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) r)) {
                try {
                  r.setDstRole (s);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                r.setDstRole (s);
              }
// 143
              JP.go.ipa.oz.lib.standard._String_if string$2 = (new JP.go.ipa.oz.lib.standard._String_cl("_"));
              
// 143
              JP.go.ipa.oz.lib.standard._String_if getName$val$46;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) r)) {
                try {
                  getName$val$46 = r.getName ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                getName$val$46 = r.getName ();
              }
// 143
              JP.go.ipa.oz.lib.standard._String_if concat$val$47;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$2)) {
                try {
                  concat$val$47 = string$2.concat (getName$val$46);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                concat$val$47 = string$2.concat (getName$val$46);
              }
// 143
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) r)) {
                try {
                  r.setName (concat$val$47);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                r.setName (concat$val$47);
              }
// 144
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
                try {
                  obj.add (r);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                obj.add (r);
              }
// 145
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
          }
        }
      }
    } finally {
      leave ();
    }
  }
  
  public JP.go.ipa.oz.user.apl.fm.Pointer_if destination () throws Exception  {
    checkSecureInvocation ();
// 174
    return dst;
  }
  
  public void setSource (JP.go.ipa.oz.user.apl.fm.Pointer_if s) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 75
      src = s;
    } finally {
      leave ();
    }
  }
  
  void enableWithoutLock (boolean b) throws Exception  {
// 287
    available = b;
// 288
    JP.go.ipa.oz.user.apl.fm.FMObject_if obj = getObj ();
// 289
    if (obj != null) {{
// 290
        JP.go.ipa.oz.user.apl.fm.Relation_if getRelation$val$48;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
          try {
            getRelation$val$48 = obj.getRelation (this);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getRelation$val$48 = obj.getRelation (this);
        }
// 290
        JP.go.ipa.oz.user.apl.fm.Relation_if r = getRelation$val$48;
// 291
        if (r != null) {{
// 292
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) r)) {
              try {
                r.enable (b);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              r.enable (b);
            }
// 293
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
        }
      }
    }
  }
  
  public JP.go.ipa.oz.lib.standard._String_if asString () throws Exception  {
    checkSecureInvocation ();
// 393
    JP.go.ipa.oz.lib.standard._StringBuffer_if rtn = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("[name=")));
// 395
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$49;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rtn)) {
      try {
        append$val$49 = rtn.append (name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$49 = rtn.append (name);
    }
// 396
    JP.go.ipa.oz.lib.standard._String_if string$3 = (new JP.go.ipa.oz.lib.standard._String_cl(", src="));
    
// 396
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$50;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rtn)) {
      try {
        append$val$50 = rtn.append (string$3);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$50 = rtn.append (string$3);
    }
// 397
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$51;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rtn)) {
      try {
        append$val$51 = rtn.append (src);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$51 = rtn.append (src);
    }
// 398
    JP.go.ipa.oz.lib.standard._String_if string$4 = (new JP.go.ipa.oz.lib.standard._String_cl(", srcRole="));
    
// 398
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$52;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rtn)) {
      try {
        append$val$52 = rtn.append (string$4);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$52 = rtn.append (string$4);
    }
// 399
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$53;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rtn)) {
      try {
        append$val$53 = rtn.append (srcRole);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$53 = rtn.append (srcRole);
    }
// 400
    JP.go.ipa.oz.lib.standard._String_if string$5 = (new JP.go.ipa.oz.lib.standard._String_cl(", dst="));
    
// 400
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$54;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rtn)) {
      try {
        append$val$54 = rtn.append (string$5);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$54 = rtn.append (string$5);
    }
// 401
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$55;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rtn)) {
      try {
        append$val$55 = rtn.append (dst);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$55 = rtn.append (dst);
    }
// 402
    JP.go.ipa.oz.lib.standard._String_if string$6 = (new JP.go.ipa.oz.lib.standard._String_cl(", dstRole="));
    
// 402
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$56;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rtn)) {
      try {
        append$val$56 = rtn.append (string$6);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$56 = rtn.append (string$6);
    }
// 403
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$57;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rtn)) {
      try {
        append$val$57 = rtn.append (dstRole);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$57 = rtn.append (dstRole);
    }
// 404
    JP.go.ipa.oz.lib.standard._String_if string$7 = (new JP.go.ipa.oz.lib.standard._String_cl(", available="));
    
// 404
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$58;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rtn)) {
      try {
        append$val$58 = rtn.append (string$7);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$58 = rtn.append (string$7);
    }
// 405
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$59;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rtn)) {
      try {
        append$val$59 = rtn.append (available);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$59 = rtn.append (available);
    }
// 406
    JP.go.ipa.oz.lib.standard._String_if string$8 = (new JP.go.ipa.oz.lib.standard._String_cl("]"));
    
// 406
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$60;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rtn)) {
      try {
        append$val$60 = rtn.append (string$8);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$60 = rtn.append (string$8);
    }
// 407
    JP.go.ipa.oz.lib.standard._String_if asString$val$61;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rtn)) {
      try {
        asString$val$61 = rtn.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$61 = rtn.asString ();
    }
// 407
    return asString$val$61;
  }
  
  public void enable () throws Exception  {
    checkSecureInvocation ();
// 303
    enable (true);
  }
  
  public void enable (boolean b) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 275
      available = b;
// 276
      JP.go.ipa.oz.user.apl.fm.FMObject_if obj = getObj ();
// 277
      if (obj != null) {{
// 278
          JP.go.ipa.oz.user.apl.fm.Relation_if getRelation$val$62;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
            try {
              getRelation$val$62 = obj.getRelation (this);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getRelation$val$62 = obj.getRelation (this);
          }
// 278
          JP.go.ipa.oz.user.apl.fm.Relation_if r = getRelation$val$62;
// 279
          if (r != null) {{
// 280
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) r)) {
                try {
                  r.enable (b);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                r.enable (b);
              }
// 281
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
          }
        }
      }
    } finally {
      leave ();
    }
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getSrcRole () throws Exception  {
    checkSecureInvocation ();
// 219
    return srcRole;
  }
  
  public void trace (int mark) throws Exception  {
    checkSecureInvocation ();
// 420
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 421
    JP.go.ipa.oz.lib.standard._String_if string$9 = (new JP.go.ipa.oz.lib.standard._String_cl("Relation#trace("));
    
// 422
    JP.go.ipa.oz.lib.standard._String_if string$10 = (new JP.go.ipa.oz.lib.standard._String_cl(""));
    
// 422
    JP.go.ipa.oz.lib.standard._String_if valueOf$val$63;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$10)) {
      try {
        valueOf$val$63 = string$10.valueOf (mark);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      valueOf$val$63 = string$10.valueOf (mark);
    }
// 421
    JP.go.ipa.oz.lib.standard._String_if concat$val$64;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$9)) {
      try {
        concat$val$64 = string$9.concat (valueOf$val$63);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$64 = string$9.concat (valueOf$val$63);
    }
// 422
    JP.go.ipa.oz.lib.standard._String_if string$11 = (new JP.go.ipa.oz.lib.standard._String_cl(")"));
    
// 421
    JP.go.ipa.oz.lib.standard._String_if concat$val$65;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$64)) {
      try {
        concat$val$65 = concat$val$64.concat (string$11);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$65 = concat$val$64.concat (string$11);
    }
// 423
    JP.go.ipa.oz.lib.standard._String_if asString$val$66;
    asString$val$66 = asString ();
// 421
    JP.go.ipa.oz.lib.standard._String_if concat$val$67;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$65)) {
      try {
        concat$val$67 = concat$val$65.concat (asString$val$66);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$67 = concat$val$65.concat (asString$val$66);
    }
// 421
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.println (concat$val$67);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.println (concat$val$67);
    }
  }
  
  public void setDstRole (JP.go.ipa.oz.lib.standard._String_if n) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 228
      dstRole = n;
    } finally {
      leave ();
    }
  }
  
  public boolean isEqualRelation (JP.go.ipa.oz.lib.standard._String_if n) throws Exception  {
    checkSecureInvocation ();
// 388
    boolean isequal$val$68;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) n)) {
      try {
        isequal$val$68 = n.isequal (name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$68 = n.isequal (name);
    }
// 388
    return isequal$val$68;
  }
  
  public boolean isEqualRelation (JP.go.ipa.oz.user.apl.fm.Relation_if r) throws Exception  {
    checkSecureInvocation ();
// 346
    JP.go.ipa.oz.lib.standard._String_if getName$val$69;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) r)) {
      try {
        getName$val$69 = r.getName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getName$val$69 = r.getName ();
    }
// 346
    boolean isequal$val$70;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) name)) {
      try {
        isequal$val$70 = name.isequal (getName$val$69);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$70 = name.isequal (getName$val$69);
    }
// 346
    if (isequal$val$70) {{
// 347
        JP.go.ipa.oz.user.apl.fm.Pointer_if getSource$val$71;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) r)) {
          try {
            getSource$val$71 = r.getSource ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSource$val$71 = r.getSource ();
        }
// 347
        JP.go.ipa.oz.user.apl.fm.Pointer_if rsrc = getSource$val$71;
// 348
        JP.go.ipa.oz.user.apl.fm.Pointer_if destination$val$72;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) r)) {
          try {
            destination$val$72 = r.destination ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          destination$val$72 = r.destination ();
        }
// 348
        JP.go.ipa.oz.user.apl.fm.Pointer_if rdst = destination$val$72;
        boolean bool$val$2;
        
        bool$val$2 = src == null;
        if (bool$val$2) {
          bool$val$2 = dst == null;
        }
// 349
        if (bool$val$2) {{
            boolean bool$val$3;
            
            bool$val$3 = rsrc == null;
            if (bool$val$3) {
              bool$val$3 = rdst == null;
            }
// 350
            return (bool$val$3);
          }
        }
// 352
        if (src == null) {{
// 353
            if (rsrc == null) {{
// 354
                boolean isEqualPointer$val$73;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dst)) {
                  try {
                    isEqualPointer$val$73 = dst.isEqualPointer (rdst);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  isEqualPointer$val$73 = dst.isEqualPointer (rdst);
                }
// 354
                return isEqualPointer$val$73;
              }
            }
// 356
            if (rdst == null) {{
// 357
                boolean isEqualPointer$val$74;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dst)) {
                  try {
                    isEqualPointer$val$74 = dst.isEqualPointer (rsrc);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  isEqualPointer$val$74 = dst.isEqualPointer (rsrc);
                }
// 357
                return isEqualPointer$val$74;
              }
            }
// 359
            return false;
          }
        }
// 361
        if (dst == null) {{
// 362
            if (rdst == null) {{
// 363
                boolean isEqualPointer$val$75;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) src)) {
                  try {
                    isEqualPointer$val$75 = src.isEqualPointer (rsrc);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  isEqualPointer$val$75 = src.isEqualPointer (rsrc);
                }
// 363
                return isEqualPointer$val$75;
              }
            }
// 365
            if (rsrc == null) {{
// 366
                boolean isEqualPointer$val$76;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) src)) {
                  try {
                    isEqualPointer$val$76 = src.isEqualPointer (rdst);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  isEqualPointer$val$76 = src.isEqualPointer (rdst);
                }
// 366
                return isEqualPointer$val$76;
              }
            }
// 368
            return false;
          }
        }
        boolean bool$val$4;
        
        boolean bool$val$5;
        
// 370
        boolean isEqualPointer$val$77;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) src)) {
          try {
            isEqualPointer$val$77 = src.isEqualPointer (rsrc);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isEqualPointer$val$77 = src.isEqualPointer (rsrc);
        }
        bool$val$5 = isEqualPointer$val$77;
        if (bool$val$5) {
// 371
          boolean isEqualPointer$val$78;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dst)) {
            try {
              isEqualPointer$val$78 = dst.isEqualPointer (rdst);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            isEqualPointer$val$78 = dst.isEqualPointer (rdst);
          }
          bool$val$5 = isEqualPointer$val$78;
        }
        bool$val$4 = (bool$val$5);
        if (!bool$val$4) {
          boolean bool$val$6;
          
// 372
          boolean isEqualPointer$val$79;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) src)) {
            try {
              isEqualPointer$val$79 = src.isEqualPointer (rdst);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            isEqualPointer$val$79 = src.isEqualPointer (rdst);
          }
          bool$val$6 = isEqualPointer$val$79;
          if (bool$val$6) {
// 373
            boolean isEqualPointer$val$80;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dst)) {
              try {
                isEqualPointer$val$80 = dst.isEqualPointer (rsrc);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              isEqualPointer$val$80 = dst.isEqualPointer (rsrc);
            }
            bool$val$6 = isEqualPointer$val$80;
          }
          bool$val$4 = (bool$val$6);
        }
// 370
        if (bool$val$4) {{
// 374
            return true;
          }
        }
      }
    }
// 377
    return false;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getName () throws Exception  {
    checkSecureInvocation ();
// 201
    return name;
  }
  
  public JP.go.ipa.oz.user.apl.fm.Pointer_if getSource () throws Exception  {
    checkSecureInvocation ();
// 84
    return src;
  }
  
  public void delete () throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 60
      JP.go.ipa.oz.user.apl.fm.FMObject_if obj = getObj ();
// 61
      if (obj != null) {{
// 62
          JP.go.ipa.oz.user.apl.fm.Relation_if getRelation$val$81;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
            try {
              getRelation$val$81 = obj.getRelation (this);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getRelation$val$81 = obj.getRelation (this);
          }
// 62
          JP.go.ipa.oz.user.apl.fm.Relation_if r = getRelation$val$81;
// 63
          if (r != null) {{
// 64
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
                try {
                  obj.remove (r);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                obj.remove (r);
              }
            }
          }
        }
      }
    } finally {
      leave ();
    }
  }
  
  public void setDestination (JP.go.ipa.oz.user.apl.fm.Pointer_if d) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 183
      dst = d;
    } finally {
      leave ();
    }
  }
  
  public JP.go.ipa.oz.user.apl.fm.Relation_if cloneRelation () throws Exception  {
    checkSecureInvocation ();
// 332
    JP.go.ipa.oz.user.apl.fm.Relation_if r = (JP.go.ipa.oz.user.apl.fm.Relation_cl) (new JP.go.ipa.oz.user.apl.fm.Relation_cl ())._new_create (name, src, srcRole, dst, dstRole, available);
// 334
    return r;
  }
  
  public Relation_cl () throws Exception { super (); }
  
}

