package JP.go.ipa.oz.user.apl.fm;

public class Pool_cl extends JP.go.ipa.oz.user.apl.fm.FMObject_cl implements JP.go.ipa.oz.user.apl.fm.Pool_if {
  JP.go.ipa.oz.user.apl.fm.PointerComparator_if pc;
  JP.go.ipa.oz.lib.standard._Set_if pool;
  
  public Object _new_create (JP.go.ipa.oz.user.apl.fm.Pool_if p) throws Exception  {
// 241
    JP.go.ipa.oz.user.apl.fm.Overseer_if over = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 242
    JP.go.ipa.oz.lib.standard._String_if getName$val$343;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) p)) {
      try {
        getName$val$343 = p.getName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getName$val$343 = p.getName ();
    }
// 242
    JP.go.ipa.oz.lib.standard._Set_if getAllRelations$val$344;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) p)) {
      try {
        getAllRelations$val$344 = p.getAllRelations ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getAllRelations$val$344 = p.getAllRelations ();
    }
// 242
    JP.go.ipa.oz.user.apl.fm.Pointer_if getIdentifier$val$345;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) p)) {
      try {
        getIdentifier$val$345 = p.getIdentifier ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getIdentifier$val$345 = p.getIdentifier ();
    }
// 242
    super._new_create (getName$val$343, getAllRelations$val$344, getIdentifier$val$345);
// 243
    JP.go.ipa.oz.user.apl.fm.PointerComparator_if fc = (JP.go.ipa.oz.user.apl.fm.PointerComparator_cl) (new JP.go.ipa.oz.user.apl.fm.PointerComparator_cl ())._new_create ();
// 244
    pool = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create (fc);
// 245
    JP.go.ipa.oz.lib.standard._Set_if getAll$val$346;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) p)) {
      try {
        getAll$val$346 = p.getAll ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getAll$val$346 = p.getAll ();
    }
// 245
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$347;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getAll$val$346)) {
      try {
        iterator$val$347 = getAll$val$346.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$347 = getAll$val$346.iterator ();
    }
// 245
    JP.go.ipa.oz.lib.standard._Iterator_if iter = iterator$val$347;
// 246
    while (true) {
// 246
      boolean hasMoreElements$val$348;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
        try {
          hasMoreElements$val$348 = iter.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$348 = iter.hasMoreElements ();
      }
      if (!(hasMoreElements$val$348)) break;
      
      /* body */ _loop_1: {
// 247
        JP.go.ipa.oz.user.apl.fm.Pointer_if point = null;
// 248
        JP.go.ipa.oz.user.apl.fm.FMObject_if o = null;
// 249
        JP.go.ipa.oz.lang._Root_if nextElement$val$349;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
          try {
            nextElement$val$349 = iter.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$349 = iter.nextElement ();
        }
// 249
        point = (JP.go.ipa.oz.user.apl.fm.Pointer_if) (nextElement$val$349);
// 250
        JP.go.ipa.oz.user.apl.fm.FMObject_if stuff$val$350;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) point)) {
          try {
            stuff$val$350 = point.stuff ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          stuff$val$350 = point.stuff ();
        }
// 250
        o = stuff$val$350;
// 251
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
          try {
            over.permit (o);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          over.permit (o);
        }
// 252
        addContent (o);
      }
    }
    return this;
  }
  
  public Object _new_create () throws Exception  {
// 13
    super._new_create ();
// 14
    pc = (JP.go.ipa.oz.user.apl.fm.PointerComparator_cl) (new JP.go.ipa.oz.user.apl.fm.PointerComparator_cl ())._new_create ();
// 15
    pool = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create (pc);
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._Set_if getContents (JP.go.ipa.oz.lib.standard._String_if name) throws Exception  {
    checkSecureInvocation ();
// 56
    JP.go.ipa.oz.user.apl.fm.Overseer_if over = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 57
    JP.go.ipa.oz.user.apl.fm.FMObjectComparator_if fc = (JP.go.ipa.oz.user.apl.fm.FMObjectComparator_cl) (new JP.go.ipa.oz.user.apl.fm.FMObjectComparator_cl ())._new_create ();
// 58
    JP.go.ipa.oz.lib.standard._Set_if result = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create (fc);
// 59
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$351;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pool)) {
      try {
        iterator$val$351 = pool.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$351 = pool.iterator ();
    }
// 59
    JP.go.ipa.oz.lib.standard._Iterator_if iter = iterator$val$351;
// 60
    JP.go.ipa.oz.user.apl.fm.FMObject_if obj = null;
// 61
    JP.go.ipa.oz.user.apl.fm.Pointer_if point = null;
// 62
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
      try {
        over.permit (name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      over.permit (name);
    }
// 64
    while (true) {
// 64
      boolean hasMoreElements$val$352;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
        try {
          hasMoreElements$val$352 = iter.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$352 = iter.hasMoreElements ();
      }
      if (!(hasMoreElements$val$352)) break;
      
      /* body */ _loop_1: {
// 65
        JP.go.ipa.oz.lang._Root_if nextElement$val$353;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
          try {
            nextElement$val$353 = iter.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$353 = iter.nextElement ();
        }
// 65
        point = (JP.go.ipa.oz.user.apl.fm.Pointer_if) (nextElement$val$353);
// 66
        JP.go.ipa.oz.user.apl.fm.FMObject_if stuff$val$354;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) point)) {
          try {
            stuff$val$354 = point.stuff ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          stuff$val$354 = point.stuff ();
        }
// 66
        obj = stuff$val$354;
// 67
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
          try {
            over.permit (obj);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          over.permit (obj);
        }
// 68
        JP.go.ipa.oz.lib.standard._String_if getName$val$355;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
          try {
            getName$val$355 = obj.getName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getName$val$355 = obj.getName ();
        }
// 68
        boolean isequal$val$356;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getName$val$355)) {
          try {
            isequal$val$356 = getName$val$355.isequal (name);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isequal$val$356 = getName$val$355.isequal (name);
        }
// 68
        if (isequal$val$356) {{
// 69
            JP.go.ipa.oz.lib.standard._Set_if add$val$357;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) result)) {
              try {
                add$val$357 = result.add (obj);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              add$val$357 = result.add (obj);
            }
          }
        }
      }
    }
// 72
    return result;
  }
  
  public int update (JP.go.ipa.oz.user.apl.fm.FMObject_if obj) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 200
      JP.go.ipa.oz.user.apl.fm.Overseer_if over = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 201
      JP.go.ipa.oz.user.apl.fm.Pool_if pl = null;
// 201
      pl = (JP.go.ipa.oz.user.apl.fm.Pool_if) (obj);
// 202
      int counter = updateWithoutLock (pl);
// 204
      if (pool != null) {{
// 205
          JP.go.ipa.oz.lib.standard._Set_if getPool$val$358;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pl)) {
            try {
              getPool$val$358 = pl.getPool ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getPool$val$358 = pl.getPool ();
          }
// 205
          JP.go.ipa.oz.lib.standard._Set_if getPool$val$359;
          getPool$val$359 = this.getPool ();
// 205
          JP.go.ipa.oz.lib.standard._Set_if difference$val$360;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getPool$val$358)) {
            try {
              difference$val$360 = getPool$val$358.difference (getPool$val$359);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            difference$val$360 = getPool$val$358.difference (getPool$val$359);
          }
// 205
          JP.go.ipa.oz.lib.standard._Set_if list = difference$val$360;
// 206
          int size$val$361;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) list)) {
            try {
              size$val$361 = list.size ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            size$val$361 = list.size ();
          }
// 206
          if (0 < (size$val$361)) {{
// 207
              JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$362;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) list)) {
                try {
                  iterator$val$362 = list.iterator ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                iterator$val$362 = list.iterator ();
              }
// 207
              JP.go.ipa.oz.lib.standard._Iterator_if iter = iterator$val$362;
// 208
              while (true) {
// 208
                boolean hasMoreElements$val$363;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
                  try {
                    hasMoreElements$val$363 = iter.hasMoreElements ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  hasMoreElements$val$363 = iter.hasMoreElements ();
                }
                if (!(hasMoreElements$val$363)) break;
                
                /* body */ _loop_1: {
// 209
                  JP.go.ipa.oz.user.apl.fm.Pointer_if point = null;
// 211
                  JP.go.ipa.oz.lang._Root_if nextElement$val$364;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
                    try {
                      nextElement$val$364 = iter.nextElement ();
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    nextElement$val$364 = iter.nextElement ();
                  }
// 211
                  point = (JP.go.ipa.oz.user.apl.fm.Pointer_if) (nextElement$val$364);
// 212
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
                    try {
                      over.permit (point);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    over.permit (point);
                  }
// 213
                  JP.go.ipa.oz.lib.standard._Set_if add$val$365;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pool)) {
                    try {
                      add$val$365 = pool.add (point);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    add$val$365 = pool.add (point);
                  }
// 214
                  counter++;
                }
              }
            }
          }
// 218
          JP.go.ipa.oz.lib.standard._Set_if getPool$val$366;
          getPool$val$366 = this.getPool ();
// 218
          JP.go.ipa.oz.lib.standard._Set_if getPool$val$367;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pl)) {
            try {
              getPool$val$367 = pl.getPool ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getPool$val$367 = pl.getPool ();
          }
// 218
          JP.go.ipa.oz.lib.standard._Set_if difference$val$368;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getPool$val$366)) {
            try {
              difference$val$368 = getPool$val$366.difference (getPool$val$367);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            difference$val$368 = getPool$val$366.difference (getPool$val$367);
          }
// 218
          list = difference$val$368;
// 219
          int size$val$369;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) list)) {
            try {
              size$val$369 = list.size ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            size$val$369 = list.size ();
          }
// 219
          if (0 < (size$val$369)) {{
// 220
              JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$370;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) list)) {
                try {
                  iterator$val$370 = list.iterator ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                iterator$val$370 = list.iterator ();
              }
// 220
              JP.go.ipa.oz.lib.standard._Iterator_if iter = iterator$val$370;
// 221
              while (true) {
// 221
                boolean hasMoreElements$val$371;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
                  try {
                    hasMoreElements$val$371 = iter.hasMoreElements ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  hasMoreElements$val$371 = iter.hasMoreElements ();
                }
                if (!(hasMoreElements$val$371)) break;
                
                /* body */ _loop_1: {
// 222
                  JP.go.ipa.oz.user.apl.fm.Pointer_if point = null;
// 224
                  JP.go.ipa.oz.lang._Root_if nextElement$val$372;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
                    try {
                      nextElement$val$372 = iter.nextElement ();
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    nextElement$val$372 = iter.nextElement ();
                  }
// 224
                  point = (JP.go.ipa.oz.user.apl.fm.Pointer_if) (nextElement$val$372);
// 225
                  JP.go.ipa.oz.lib.standard._Collection_if remove$val$373;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pool)) {
                    try {
                      remove$val$373 = pool.remove (point);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    remove$val$373 = pool.remove (point);
                  }
// 226
                  counter++;
                }
              }
            }
          }
        }
      }
// 231
      return counter;
    } finally {
      leave ();
    }
  }
  
  public JP.go.ipa.oz.lib.standard._Set_if getAll () throws Exception  {
    checkSecureInvocation ();
// 79
    JP.go.ipa.oz.user.apl.fm.Overseer_if over = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 80
    JP.go.ipa.oz.lib.standard._Set_if result = null;
// 81
    JP.go.ipa.oz.lib.standard._Iterator_if iter = null;
// 82
    JP.go.ipa.oz.user.apl.fm.Pointer_if point = null;
// 83
    JP.go.ipa.oz.user.apl.fm.FMObject_if obj = null;
// 84
    JP.go.ipa.oz.user.apl.fm.FMObjectComparator_if fc = null;
// 86
    fc = (JP.go.ipa.oz.user.apl.fm.FMObjectComparator_cl) (new JP.go.ipa.oz.user.apl.fm.FMObjectComparator_cl ())._new_create ();
// 87
    result = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create (fc);
// 88
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$374;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pool)) {
      try {
        iterator$val$374 = pool.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$374 = pool.iterator ();
    }
// 88
    iter = iterator$val$374;
// 90
    while (true) {
// 90
      boolean hasMoreElements$val$375;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
        try {
          hasMoreElements$val$375 = iter.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$375 = iter.hasMoreElements ();
      }
      if (!(hasMoreElements$val$375)) break;
      
      /* body */ _loop_1: {
// 91
        JP.go.ipa.oz.lang._Root_if nextElement$val$376;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
          try {
            nextElement$val$376 = iter.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$376 = iter.nextElement ();
        }
// 91
        point = (JP.go.ipa.oz.user.apl.fm.Pointer_if) (nextElement$val$376);
// 92
        JP.go.ipa.oz.user.apl.fm.FMObject_if stuff$val$377;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) point)) {
          try {
            stuff$val$377 = point.stuff ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          stuff$val$377 = point.stuff ();
        }
// 92
        obj = stuff$val$377;
// 93
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
          try {
            over.permit (obj);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          over.permit (obj);
        }
// 94
        result.add (obj);
      }
    }
// 97
    return result;
  }
  
  public JP.go.ipa.oz.user.apl.fm.FMObject_if cloneSelf () throws Exception  {
    checkSecureInvocation ();
// 236
    JP.go.ipa.oz.user.apl.fm.Pool_if clone = (JP.go.ipa.oz.user.apl.fm.Pool_cl) (new JP.go.ipa.oz.user.apl.fm.Pool_cl ())._new_create (this);
// 237
    return clone;
  }
  
  public void remove (JP.go.ipa.oz.lib.standard._String_if name) throws Exception  {
    checkSecureInvocation ();
// 167
    JP.go.ipa.oz.user.apl.fm.Overseer_if over = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 168
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$378;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pool)) {
      try {
        iterator$val$378 = pool.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$378 = pool.iterator ();
    }
// 168
    JP.go.ipa.oz.lib.standard._Iterator_if iter = iterator$val$378;
// 169
    JP.go.ipa.oz.user.apl.fm.FMObject_if obj = null;
// 170
    JP.go.ipa.oz.user.apl.fm.Pointer_if point = null;
// 172
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
      try {
        over.permit (name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      over.permit (name);
    }
// 173
    while (true) {
// 173
      boolean hasMoreElements$val$379;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
        try {
          hasMoreElements$val$379 = iter.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$379 = iter.hasMoreElements ();
      }
      if (!(hasMoreElements$val$379)) break;
      
      /* body */ _loop_1: {
// 174
        JP.go.ipa.oz.lang._Root_if nextElement$val$380;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
          try {
            nextElement$val$380 = iter.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$380 = iter.nextElement ();
        }
// 174
        point = (JP.go.ipa.oz.user.apl.fm.Pointer_if) (nextElement$val$380);
// 175
        JP.go.ipa.oz.user.apl.fm.FMObject_if stuff$val$381;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) point)) {
          try {
            stuff$val$381 = point.stuff ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          stuff$val$381 = point.stuff ();
        }
// 175
        obj = stuff$val$381;
// 176
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
          try {
            over.permit (obj);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          over.permit (obj);
        }
// 177
        JP.go.ipa.oz.lib.standard._String_if getName$val$382;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
          try {
            getName$val$382 = obj.getName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getName$val$382 = obj.getName ();
        }
// 177
        boolean isequal$val$383;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getName$val$382)) {
          try {
            isequal$val$383 = getName$val$382.isequal (name);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isequal$val$383 = getName$val$382.isequal (name);
        }
// 177
        if (isequal$val$383) {{
// 178
            JP.go.ipa.oz.lib.standard._Collection_if remove$val$384;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pool)) {
              try {
                remove$val$384 = pool.remove (point);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              remove$val$384 = pool.remove (point);
            }
// 179
            break;
          }
        }
      }
    }
  }
  
  public void remove (JP.go.ipa.oz.user.apl.fm.FMObject_if obj) throws Exception  {
    checkSecureInvocation ();
// 152
    JP.go.ipa.oz.user.apl.fm.Overseer_if over = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 153
    JP.go.ipa.oz.user.apl.fm.Pointer_if point = null;
// 155
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
      try {
        over.permit (obj);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      over.permit (obj);
    }
// 156
    JP.go.ipa.oz.user.apl.fm.Pointer_if getIdentifier$val$385;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
      try {
        getIdentifier$val$385 = obj.getIdentifier ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getIdentifier$val$385 = obj.getIdentifier ();
    }
// 156
    point = getIdentifier$val$385;
// 157
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
      try {
        over.permit (point);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      over.permit (point);
    }
// 158
    JP.go.ipa.oz.lib.standard._Collection_if remove$val$386;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pool)) {
      try {
        remove$val$386 = pool.remove (point);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      remove$val$386 = pool.remove (point);
    }
  }
  
  public void addContent (JP.go.ipa.oz.lib.standard._Point_if point) throws Exception  {
    checkSecureInvocation ();
// 44
    JP.go.ipa.oz.user.apl.fm.Overseer_if over = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 45
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
      try {
        over.permit (point);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      over.permit (point);
    }
// 46
    JP.go.ipa.oz.lib.standard._Set_if add$val$387;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pool)) {
      try {
        add$val$387 = pool.add (point);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$387 = pool.add (point);
    }
// 47
    commit ();
  }
  
  public void addContent (JP.go.ipa.oz.user.apl.fm.FMObject_if cont) throws Exception  {
    checkSecureInvocation ();
// 24
    JP.go.ipa.oz.user.apl.fm.Overseer_if over = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 25
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
      try {
        over.permit (cont);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      over.permit (cont);
    }
// 26
    addContentInternal (cont);
  }
  
  public boolean contains (JP.go.ipa.oz.lib.standard._String_if name) throws Exception  {
    checkSecureInvocation ();
// 126
    JP.go.ipa.oz.user.apl.fm.Overseer_if over = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 127
    JP.go.ipa.oz.lib.standard._Set_if result = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create ();
// 128
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$388;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pool)) {
      try {
        iterator$val$388 = pool.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$388 = pool.iterator ();
    }
// 128
    JP.go.ipa.oz.lib.standard._Iterator_if iter = iterator$val$388;
// 129
    JP.go.ipa.oz.user.apl.fm.FMObject_if obj = null;
// 130
    JP.go.ipa.oz.user.apl.fm.Pointer_if point = null;
// 132
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
      try {
        over.permit (name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      over.permit (name);
    }
// 133
    while (true) {
// 133
      boolean hasMoreElements$val$389;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
        try {
          hasMoreElements$val$389 = iter.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$389 = iter.hasMoreElements ();
      }
      if (!(hasMoreElements$val$389)) break;
      
      /* body */ _loop_1: {
// 134
        JP.go.ipa.oz.lang._Root_if nextElement$val$390;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
          try {
            nextElement$val$390 = iter.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$390 = iter.nextElement ();
        }
// 134
        point = (JP.go.ipa.oz.user.apl.fm.Pointer_if) (nextElement$val$390);
// 135
        JP.go.ipa.oz.user.apl.fm.FMObject_if stuff$val$391;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) point)) {
          try {
            stuff$val$391 = point.stuff ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          stuff$val$391 = point.stuff ();
        }
// 135
        obj = stuff$val$391;
// 136
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
          try {
            over.permit (obj);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          over.permit (obj);
        }
// 137
        JP.go.ipa.oz.lib.standard._String_if getName$val$392;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
          try {
            getName$val$392 = obj.getName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getName$val$392 = obj.getName ();
        }
// 137
        boolean isequal$val$393;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getName$val$392)) {
          try {
            isequal$val$393 = getName$val$392.isequal (name);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isequal$val$393 = getName$val$392.isequal (name);
        }
// 137
        if (isequal$val$393) {{
// 138
            JP.go.ipa.oz.lib.standard._Set_if add$val$394;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) result)) {
              try {
                add$val$394 = result.add (obj);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              add$val$394 = result.add (obj);
            }
          }
        }
      }
    }
// 142
    int size$val$395;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) result)) {
      try {
        size$val$395 = result.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$395 = result.size ();
    }
// 142
    if ((size$val$395) > 0) {
// 143
      return true;
    }
// 143
    return false;
  }
  
  public boolean contains (JP.go.ipa.oz.user.apl.fm.FMObject_if obj) throws Exception  {
    checkSecureInvocation ();
// 111
    JP.go.ipa.oz.user.apl.fm.Overseer_if over = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 112
    JP.go.ipa.oz.user.apl.fm.Pointer_if point = null;
// 113
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
      try {
        over.permit (obj);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      over.permit (obj);
    }
// 114
    JP.go.ipa.oz.user.apl.fm.Pointer_if getIdentifier$val$396;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
      try {
        getIdentifier$val$396 = obj.getIdentifier ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getIdentifier$val$396 = obj.getIdentifier ();
    }
// 114
    point = getIdentifier$val$396;
// 115
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
      try {
        over.permit (point);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      over.permit (point);
    }
// 116
    boolean contains$val$397;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pool)) {
      try {
        contains$val$397 = pool.contains (point);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      contains$val$397 = pool.contains (point);
    }
// 116
    return contains$val$397;
  }
  
  public JP.go.ipa.oz.lib.standard._Set_if getPool () throws Exception  {
    checkSecureInvocation ();
// 101
    return pool;
  }
  
  public void toGreen () throws Exception  {
    checkSecureInvocation ();
// 184
    JP.go.ipa.oz.user.apl.fm.Pointer_if point = null;
// 185
    JP.go.ipa.oz.user.apl.fm.Overseer_if overseer = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 187
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
      try {
        overseer.permit (pool);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      overseer.permit (pool);
    }
// 195
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
      try {
        overseer.permit (pc);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      overseer.permit (pc);
    }
// 196
    super.toGreen ();
  }
  
  protected void addContentInternal (JP.go.ipa.oz.user.apl.fm.FMObject_if cont) throws Exception  {
// 30
    JP.go.ipa.oz.user.apl.fm.Overseer_if over = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 31
    JP.go.ipa.oz.user.apl.fm.Pointer_if point = null;
// 32
    JP.go.ipa.oz.user.apl.fm.Pointer_if addpoint = null;
// 33
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
      try {
        over.permit (cont);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      over.permit (cont);
    }
// 36
    JP.go.ipa.oz.user.apl.fm.Pointer_if getIdentifier$val$398;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cont)) {
      try {
        getIdentifier$val$398 = cont.getIdentifier ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getIdentifier$val$398 = cont.getIdentifier ();
    }
// 36
    point = getIdentifier$val$398;
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
// 39
    JP.go.ipa.oz.lib.standard._Set_if add$val$399;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pool)) {
      try {
        add$val$399 = pool.add (point);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$399 = pool.add (point);
    }
// 40
    commit ();
  }
  
  public Pool_cl () throws Exception { super (); }
  
}

