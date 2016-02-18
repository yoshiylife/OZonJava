package JP.go.ipa.oz.user.apl.fm;

public class Organization_cl extends JP.go.ipa.oz.user.apl.fm.Actor_cl implements JP.go.ipa.oz.user.apl.fm.Organization_if {
  JP.go.ipa.oz.user.apl.fm.PointerComparator_if pc;
  JP.go.ipa.oz.lib.standard._Set_if pool;
  
  public Object _new_create (JP.go.ipa.oz.user.apl.fm.Organization_if o) throws Exception  {
// 339
    super._new_create (o);
// 340
    JP.go.ipa.oz.lib.standard._Set_if getMembersPool$val$276;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
      try {
        getMembersPool$val$276 = o.getMembersPool ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getMembersPool$val$276 = o.getMembersPool ();
    }
// 340
    JP.go.ipa.oz.lib.standard._Plural_if duplicate$val$277;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getMembersPool$val$276)) {
      try {
        duplicate$val$277 = getMembersPool$val$276.duplicate ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      duplicate$val$277 = getMembersPool$val$276.duplicate ();
    }
// 340
    pool = (JP.go.ipa.oz.lib.standard._Set_if) (duplicate$val$277);
    return this;
  }
  
  public Object _new_create () throws Exception  {
// 15
    super._new_create ();
// 16
    pc = (JP.go.ipa.oz.user.apl.fm.PointerComparator_cl) (new JP.go.ipa.oz.user.apl.fm.PointerComparator_cl ())._new_create ();
// 17
    pool = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create (pc);
    return this;
  }
  
  protected JP.go.ipa.oz.lib.standard._Set_if getContents (JP.go.ipa.oz.lib.standard._String_if name) throws Exception  {
// 48
    JP.go.ipa.oz.user.apl.fm.Overseer_if over = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 49
    JP.go.ipa.oz.user.apl.fm.FMObjectComparator_if fc = (JP.go.ipa.oz.user.apl.fm.FMObjectComparator_cl) (new JP.go.ipa.oz.user.apl.fm.FMObjectComparator_cl ())._new_create ();
// 50
    JP.go.ipa.oz.lib.standard._Set_if result = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create (fc);
// 51
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$278;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pool)) {
      try {
        iterator$val$278 = pool.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$278 = pool.iterator ();
    }
// 51
    JP.go.ipa.oz.lib.standard._Iterator_if iter = iterator$val$278;
// 52
    JP.go.ipa.oz.user.apl.fm.FMObject_if obj = null;
// 53
    JP.go.ipa.oz.user.apl.fm.Pointer_if point = null;
// 55
    while (true) {
// 55
      boolean hasMoreElements$val$279;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
        try {
          hasMoreElements$val$279 = iter.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$279 = iter.hasMoreElements ();
      }
      if (!(hasMoreElements$val$279)) break;
      
      /* body */ _loop_1: {
// 56
        JP.go.ipa.oz.lang._Root_if nextElement$val$280;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
          try {
            nextElement$val$280 = iter.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$280 = iter.nextElement ();
        }
// 56
        point = (JP.go.ipa.oz.user.apl.fm.Pointer_if) (nextElement$val$280);
// 57
        JP.go.ipa.oz.user.apl.fm.FMObject_if stuff$val$281;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) point)) {
          try {
            stuff$val$281 = point.stuff ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          stuff$val$281 = point.stuff ();
        }
// 57
        obj = stuff$val$281;
// 58
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
          try {
            over.permit (obj);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          over.permit (obj);
        }
// 60
        JP.go.ipa.oz.lib.standard._String_if getName$val$282;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
          try {
            getName$val$282 = obj.getName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getName$val$282 = obj.getName ();
        }
// 60
        boolean isequal$val$283;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getName$val$282)) {
          try {
            isequal$val$283 = getName$val$282.isequal (name);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isequal$val$283 = getName$val$282.isequal (name);
        }
// 60
        if (isequal$val$283) {{
// 61
            JP.go.ipa.oz.lib.standard._Set_if add$val$284;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) result)) {
              try {
                add$val$284 = result.add (obj);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              add$val$284 = result.add (obj);
            }
          }
        }
      }
    }
// 64
    return result;
  }
  
  public JP.go.ipa.oz.lib.standard._Set_if getMembers (JP.go.ipa.oz.lib.standard._String_if nam) throws Exception  {
    checkSecureInvocation ();
// 243
    JP.go.ipa.oz.user.apl.fm.Overseer_if over = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 244
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
      try {
        over.permit (nam);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      over.permit (nam);
    }
// 245
    return getContents (nam);
  }
  
  public JP.go.ipa.oz.lib.standard._Set_if getMembers () throws Exception  {
    checkSecureInvocation ();
// 233
    return getAll ();
  }
  
  public int update (JP.go.ipa.oz.user.apl.fm.FMObject_if obj) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 296
      JP.go.ipa.oz.user.apl.fm.Overseer_if over = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 297
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
        try {
          over.permit (obj);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        over.permit (obj);
      }
// 298
      JP.go.ipa.oz.user.apl.fm.Organization_if org = null;
// 298
      org = (JP.go.ipa.oz.user.apl.fm.Organization_if) (obj);
// 299
      int counter = updateWithoutLock (org);
// 301
      if (pool != null) {{
// 302
          JP.go.ipa.oz.lib.standard._Set_if getMembersPool$val$285;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) org)) {
            try {
              getMembersPool$val$285 = org.getMembersPool ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getMembersPool$val$285 = org.getMembersPool ();
          }
// 302
          JP.go.ipa.oz.lib.standard._Set_if getMembersPool$val$286;
          getMembersPool$val$286 = this.getMembersPool ();
// 302
          JP.go.ipa.oz.lib.standard._Set_if difference$val$287;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getMembersPool$val$285)) {
            try {
              difference$val$287 = getMembersPool$val$285.difference (getMembersPool$val$286);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            difference$val$287 = getMembersPool$val$285.difference (getMembersPool$val$286);
          }
// 302
          JP.go.ipa.oz.lib.standard._Set_if list = difference$val$287;
// 303
          int size$val$288;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) list)) {
            try {
              size$val$288 = list.size ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            size$val$288 = list.size ();
          }
// 303
          if (0 < (size$val$288)) {{
// 304
              JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$289;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) list)) {
                try {
                  iterator$val$289 = list.iterator ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                iterator$val$289 = list.iterator ();
              }
// 304
              JP.go.ipa.oz.lib.standard._Iterator_if iter = iterator$val$289;
// 305
              while (true) {
// 305
                boolean hasMoreElements$val$290;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
                  try {
                    hasMoreElements$val$290 = iter.hasMoreElements ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  hasMoreElements$val$290 = iter.hasMoreElements ();
                }
                if (!(hasMoreElements$val$290)) break;
                
                /* body */ _loop_1: {
// 306
                  JP.go.ipa.oz.user.apl.fm.Pointer_if point = null;
// 308
                  JP.go.ipa.oz.lang._Root_if nextElement$val$291;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
                    try {
                      nextElement$val$291 = iter.nextElement ();
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    nextElement$val$291 = iter.nextElement ();
                  }
// 308
                  point = (JP.go.ipa.oz.user.apl.fm.Pointer_if) (nextElement$val$291);
// 309
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
                    try {
                      over.permit (point);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    over.permit (point);
                  }
// 310
                  JP.go.ipa.oz.lib.standard._Set_if add$val$292;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pool)) {
                    try {
                      add$val$292 = pool.add (point);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    add$val$292 = pool.add (point);
                  }
// 312
                  counter++;
                }
              }
            }
          }
// 316
          JP.go.ipa.oz.lib.standard._Set_if getMembersPool$val$293;
          getMembersPool$val$293 = getMembersPool ();
// 316
          JP.go.ipa.oz.lib.standard._Set_if getMembersPool$val$294;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) org)) {
            try {
              getMembersPool$val$294 = org.getMembersPool ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getMembersPool$val$294 = org.getMembersPool ();
          }
// 316
          JP.go.ipa.oz.lib.standard._Set_if difference$val$295;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getMembersPool$val$293)) {
            try {
              difference$val$295 = getMembersPool$val$293.difference (getMembersPool$val$294);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            difference$val$295 = getMembersPool$val$293.difference (getMembersPool$val$294);
          }
// 316
          list = difference$val$295;
// 317
          int size$val$296;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) list)) {
            try {
              size$val$296 = list.size ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            size$val$296 = list.size ();
          }
// 317
          if (0 < (size$val$296)) {{
// 318
              JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$297;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) list)) {
                try {
                  iterator$val$297 = list.iterator ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                iterator$val$297 = list.iterator ();
              }
// 318
              JP.go.ipa.oz.lib.standard._Iterator_if iter = iterator$val$297;
// 319
              while (true) {
// 319
                boolean hasMoreElements$val$298;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
                  try {
                    hasMoreElements$val$298 = iter.hasMoreElements ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  hasMoreElements$val$298 = iter.hasMoreElements ();
                }
                if (!(hasMoreElements$val$298)) break;
                
                /* body */ _loop_1: {
// 320
                  JP.go.ipa.oz.user.apl.fm.Pointer_if point = null;
// 322
                  JP.go.ipa.oz.lang._Root_if nextElement$val$299;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
                    try {
                      nextElement$val$299 = iter.nextElement ();
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    nextElement$val$299 = iter.nextElement ();
                  }
// 322
                  point = (JP.go.ipa.oz.user.apl.fm.Pointer_if) (nextElement$val$299);
// 323
                  JP.go.ipa.oz.lib.standard._Collection_if remove$val$300;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pool)) {
                    try {
                      remove$val$300 = pool.remove (point);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    remove$val$300 = pool.remove (point);
                  }
// 324
                  counter++;
                }
              }
            }
          }
        }
      }
// 329
      return counter;
    } finally {
      leave ();
    }
  }
  
  public boolean isBelong (JP.go.ipa.oz.lib.standard._String_if nam) throws Exception  {
    checkSecureInvocation ();
// 200
    JP.go.ipa.oz.user.apl.fm.Overseer_if over = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 201
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
      try {
        over.permit (nam);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      over.permit (nam);
    }
// 202
    return contains (nam);
  }
  
  public boolean isBelong (JP.go.ipa.oz.user.apl.fm.Actor_if mem) throws Exception  {
    checkSecureInvocation ();
// 187
    JP.go.ipa.oz.user.apl.fm.Overseer_if over = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 188
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
      try {
        over.permit (mem);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      over.permit (mem);
    }
// 189
    return contains (mem);
  }
  
  public JP.go.ipa.oz.user.apl.fm.Actor_if getMember (JP.go.ipa.oz.lib.standard._String_if nam) throws Exception  {
    checkSecureInvocation ();
// 271
    JP.go.ipa.oz.user.apl.fm.Overseer_if over = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 272
    JP.go.ipa.oz.lib.standard._Set_if resultList = null;
// 273
    JP.go.ipa.oz.lib.standard._Iterator_if iter = null;
// 274
    JP.go.ipa.oz.user.apl.fm.Actor_if act = null;
// 276
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
      try {
        over.permit (nam);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      over.permit (nam);
    }
// 277
    resultList = getContents (nam);
// 278
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$301;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) resultList)) {
      try {
        iterator$val$301 = resultList.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$301 = resultList.iterator ();
    }
// 278
    iter = iterator$val$301;
// 279
    JP.go.ipa.oz.lang._Root_if nextElement$val$302;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
      try {
        nextElement$val$302 = iter.nextElement ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      nextElement$val$302 = iter.nextElement ();
    }
// 279
    act = (JP.go.ipa.oz.user.apl.fm.Actor_if) (nextElement$val$302);
// 280
    return act;
  }
  
  public JP.go.ipa.oz.user.apl.fm.Actor_if getMember (JP.go.ipa.oz.user.apl.fm.Actor_if act) throws Exception  {
    checkSecureInvocation ();
// 255
    JP.go.ipa.oz.user.apl.fm.Overseer_if over = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 256
    JP.go.ipa.oz.lib.standard._String_if nam = null;
// 258
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
      try {
        over.permit (act);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      over.permit (act);
    }
// 259
    JP.go.ipa.oz.lib.standard._String_if getName$val$303;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) act)) {
      try {
        getName$val$303 = act.getName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getName$val$303 = act.getName ();
    }
// 259
    nam = getName$val$303;
// 260
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
      try {
        over.permit (nam);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      over.permit (nam);
    }
// 261
    return getMember (nam);
  }
  
  public void addMember (JP.go.ipa.oz.user.apl.fm.Actor_if mem) throws Exception  {
    checkSecureInvocation ();
// 174
    JP.go.ipa.oz.user.apl.fm.Overseer_if over = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 175
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
      try {
        over.permit (mem);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      over.permit (mem);
    }
// 176
    addContent (mem);
  }
  
  protected JP.go.ipa.oz.lib.standard._Set_if getAll () throws Exception  {
// 71
    JP.go.ipa.oz.user.apl.fm.Overseer_if over = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 72
    JP.go.ipa.oz.lib.standard._Set_if result = null;
// 73
    JP.go.ipa.oz.lib.standard._Iterator_if iter = null;
// 74
    JP.go.ipa.oz.user.apl.fm.Pointer_if point = null;
// 75
    JP.go.ipa.oz.user.apl.fm.FMObject_if obj = null;
// 76
    JP.go.ipa.oz.user.apl.fm.FMObjectComparator_if fc = null;
// 78
    fc = (JP.go.ipa.oz.user.apl.fm.FMObjectComparator_cl) (new JP.go.ipa.oz.user.apl.fm.FMObjectComparator_cl ())._new_create ();
// 79
    result = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create (fc);
// 80
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$304;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pool)) {
      try {
        iterator$val$304 = pool.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$304 = pool.iterator ();
    }
// 80
    iter = iterator$val$304;
// 82
    while (true) {
// 82
      boolean hasMoreElements$val$305;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
        try {
          hasMoreElements$val$305 = iter.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$305 = iter.hasMoreElements ();
      }
      if (!(hasMoreElements$val$305)) break;
      
      /* body */ _loop_1: {
// 83
        JP.go.ipa.oz.lang._Root_if nextElement$val$306;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
          try {
            nextElement$val$306 = iter.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$306 = iter.nextElement ();
        }
// 83
        point = (JP.go.ipa.oz.user.apl.fm.Pointer_if) (nextElement$val$306);
// 84
        JP.go.ipa.oz.user.apl.fm.FMObject_if stuff$val$307;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) point)) {
          try {
            stuff$val$307 = point.stuff ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          stuff$val$307 = point.stuff ();
        }
// 84
        obj = stuff$val$307;
// 85
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
          try {
            over.permit (obj);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          over.permit (obj);
        }
// 86
        result.add (obj);
      }
    }
// 89
    return result;
  }
  
  public void removeMember (JP.go.ipa.oz.lib.standard._String_if nam) throws Exception  {
    checkSecureInvocation ();
// 222
    JP.go.ipa.oz.user.apl.fm.Overseer_if over = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 223
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
      try {
        over.permit (nam);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      over.permit (nam);
    }
// 224
    remove (nam);
  }
  
  public void removeMember (JP.go.ipa.oz.user.apl.fm.Actor_if mem) throws Exception  {
    checkSecureInvocation ();
// 211
    JP.go.ipa.oz.user.apl.fm.Overseer_if over = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 212
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
      try {
        over.permit (mem);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      over.permit (mem);
    }
// 213
    remove (mem);
  }
  
  public JP.go.ipa.oz.user.apl.fm.FMObject_if cloneSelf () throws Exception  {
    checkSecureInvocation ();
// 334
    JP.go.ipa.oz.user.apl.fm.Organization_if clone = (JP.go.ipa.oz.user.apl.fm.Organization_cl) (new JP.go.ipa.oz.user.apl.fm.Organization_cl ())._new_create (this);
// 335
    return clone;
  }
  
  protected void remove (JP.go.ipa.oz.lib.standard._String_if name) throws Exception  {
// 151
    JP.go.ipa.oz.user.apl.fm.Overseer_if over = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 152
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$308;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pool)) {
      try {
        iterator$val$308 = pool.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$308 = pool.iterator ();
    }
// 152
    JP.go.ipa.oz.lib.standard._Iterator_if iter = iterator$val$308;
// 153
    JP.go.ipa.oz.user.apl.fm.FMObject_if obj = null;
// 154
    JP.go.ipa.oz.user.apl.fm.Pointer_if point = null;
// 156
    while (true) {
// 156
      boolean hasMoreElements$val$309;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
        try {
          hasMoreElements$val$309 = iter.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$309 = iter.hasMoreElements ();
      }
      if (!(hasMoreElements$val$309)) break;
      
      /* body */ _loop_1: {
// 157
        JP.go.ipa.oz.lang._Root_if nextElement$val$310;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
          try {
            nextElement$val$310 = iter.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$310 = iter.nextElement ();
        }
// 157
        point = (JP.go.ipa.oz.user.apl.fm.Pointer_if) (nextElement$val$310);
// 158
        JP.go.ipa.oz.user.apl.fm.FMObject_if stuff$val$311;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) point)) {
          try {
            stuff$val$311 = point.stuff ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          stuff$val$311 = point.stuff ();
        }
// 158
        obj = stuff$val$311;
// 159
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
          try {
            over.permit (obj);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          over.permit (obj);
        }
// 160
        JP.go.ipa.oz.lib.standard._String_if getName$val$312;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
          try {
            getName$val$312 = obj.getName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getName$val$312 = obj.getName ();
        }
// 160
        boolean isequal$val$313;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getName$val$312)) {
          try {
            isequal$val$313 = getName$val$312.isequal (name);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isequal$val$313 = getName$val$312.isequal (name);
        }
// 160
        if (isequal$val$313) {{
// 161
            JP.go.ipa.oz.lib.standard._Collection_if remove$val$314;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pool)) {
              try {
                remove$val$314 = pool.remove (point);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              remove$val$314 = pool.remove (point);
            }
// 162
            break;
          }
        }
      }
    }
  }
  
  protected void remove (JP.go.ipa.oz.user.apl.fm.FMObject_if obj) throws Exception  {
// 138
    JP.go.ipa.oz.user.apl.fm.Overseer_if over = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 139
    JP.go.ipa.oz.user.apl.fm.Pointer_if point = null;
// 140
    JP.go.ipa.oz.user.apl.fm.Pointer_if getIdentifier$val$315;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
      try {
        getIdentifier$val$315 = obj.getIdentifier ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getIdentifier$val$315 = obj.getIdentifier ();
    }
// 140
    point = getIdentifier$val$315;
// 141
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
      try {
        over.permit (point);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      over.permit (point);
    }
// 142
    JP.go.ipa.oz.lib.standard._Collection_if remove$val$316;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pool)) {
      try {
        remove$val$316 = pool.remove (point);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      remove$val$316 = pool.remove (point);
    }
  }
  
  public JP.go.ipa.oz.lib.standard._Set_if getMembersPool () throws Exception  {
    checkSecureInvocation ();
// 291
    return pool;
  }
  
  protected void addContent (JP.go.ipa.oz.user.apl.fm.Pointer_if point) throws Exception  {
// 36
    JP.go.ipa.oz.user.apl.fm.Overseer_if over = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 37
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
      try {
        over.permit (point);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      over.permit (point);
    }
// 38
    JP.go.ipa.oz.lib.standard._Set_if add$val$317;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pool)) {
      try {
        add$val$317 = pool.add (point);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$317 = pool.add (point);
    }
// 39
    commit ();
  }
  
  protected void addContent (JP.go.ipa.oz.user.apl.fm.FMObject_if cont) throws Exception  {
// 26
    JP.go.ipa.oz.user.apl.fm.Pointer_if point = null;
// 27
    JP.go.ipa.oz.user.apl.fm.Overseer_if over = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 29
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
      try {
        over.permit (cont);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      over.permit (cont);
    }
// 30
    JP.go.ipa.oz.user.apl.fm.Pointer_if getIdentifier$val$318;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cont)) {
      try {
        getIdentifier$val$318 = cont.getIdentifier ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getIdentifier$val$318 = cont.getIdentifier ();
    }
// 30
    point = getIdentifier$val$318;
// 31
    JP.go.ipa.oz.lib.standard._Set_if add$val$319;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pool)) {
      try {
        add$val$319 = pool.add (point);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$319 = pool.add (point);
    }
// 32
    commit ();
  }
  
  protected boolean contains (JP.go.ipa.oz.lib.standard._String_if name) throws Exception  {
// 113
    JP.go.ipa.oz.user.apl.fm.Overseer_if over = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 114
    JP.go.ipa.oz.lib.standard._Set_if result = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create ();
// 115
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$320;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pool)) {
      try {
        iterator$val$320 = pool.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$320 = pool.iterator ();
    }
// 115
    JP.go.ipa.oz.lib.standard._Iterator_if iter = iterator$val$320;
// 116
    JP.go.ipa.oz.user.apl.fm.FMObject_if obj = null;
// 117
    JP.go.ipa.oz.user.apl.fm.Pointer_if point = null;
// 119
    while (true) {
// 119
      boolean hasMoreElements$val$321;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
        try {
          hasMoreElements$val$321 = iter.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$321 = iter.hasMoreElements ();
      }
      if (!(hasMoreElements$val$321)) break;
      
      /* body */ _loop_1: {
// 120
        JP.go.ipa.oz.lang._Root_if nextElement$val$322;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
          try {
            nextElement$val$322 = iter.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$322 = iter.nextElement ();
        }
// 120
        point = (JP.go.ipa.oz.user.apl.fm.Pointer_if) (nextElement$val$322);
// 121
        JP.go.ipa.oz.user.apl.fm.FMObject_if stuff$val$323;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) point)) {
          try {
            stuff$val$323 = point.stuff ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          stuff$val$323 = point.stuff ();
        }
// 121
        obj = stuff$val$323;
// 122
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
          try {
            over.permit (obj);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          over.permit (obj);
        }
// 123
        JP.go.ipa.oz.lib.standard._String_if getName$val$324;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
          try {
            getName$val$324 = obj.getName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getName$val$324 = obj.getName ();
        }
// 123
        boolean isequal$val$325;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getName$val$324)) {
          try {
            isequal$val$325 = getName$val$324.isequal (name);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isequal$val$325 = getName$val$324.isequal (name);
        }
// 123
        if (isequal$val$325) {{
// 124
            JP.go.ipa.oz.lib.standard._Set_if add$val$326;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) result)) {
              try {
                add$val$326 = result.add (obj);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              add$val$326 = result.add (obj);
            }
          }
        }
      }
    }
// 128
    int size$val$327;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) result)) {
      try {
        size$val$327 = result.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$327 = result.size ();
    }
// 128
    if ((size$val$327) > 0) {
// 129
      return true;
    }
// 129
    return false;
  }
  
  protected boolean contains (JP.go.ipa.oz.user.apl.fm.FMObject_if obj) throws Exception  {
// 99
    JP.go.ipa.oz.user.apl.fm.Overseer_if over = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 100
    JP.go.ipa.oz.user.apl.fm.Pointer_if point = null;
// 101
    JP.go.ipa.oz.user.apl.fm.Pointer_if getIdentifier$val$328;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
      try {
        getIdentifier$val$328 = obj.getIdentifier ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getIdentifier$val$328 = obj.getIdentifier ();
    }
// 101
    point = getIdentifier$val$328;
// 102
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
      try {
        over.permit (point);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      over.permit (point);
    }
// 103
    boolean contains$val$329;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pool)) {
      try {
        contains$val$329 = pool.contains (point);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      contains$val$329 = pool.contains (point);
    }
// 103
    return contains$val$329;
  }
  
  public void toGreen () throws Exception  {
    checkSecureInvocation ();
// 284
    JP.go.ipa.oz.user.apl.fm.Overseer_if overseer = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 285
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
      try {
        overseer.permit (pool);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      overseer.permit (pool);
    }
// 286
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
      try {
        overseer.permit (pc);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      overseer.permit (pc);
    }
// 287
    super.toGreen ();
  }
  
  public Organization_cl () throws Exception { super (); }
  
}

