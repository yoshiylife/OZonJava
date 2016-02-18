package JP.go.ipa.oz.user.apl.fm;

public class ScheduleBoard_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.apl.fm.ScheduleBoard_if {
  int initTime;
  int pieceNum;
  JP.go.ipa.oz.lib.standard._SList_if table;
  int days;
  int span;
  int grid;
  
  public Object _new_create (int date, int gd) throws Exception  {
// 18
    table = (JP.go.ipa.oz.lib.standard._SList_cl) (new JP.go.ipa.oz.lib.standard._SList_cl ())._new_create ();
// 19
    initTime = 8;
// 20
    span = 12;
// 21
    grid = gd;
// 22
    days = date;
// 24
    setTable ();
    return this;
  }
  
  protected JP.go.ipa.oz.lib.standard._String_if makePieceLabel (int number) throws Exception  {
// 91
    int now = 0;
// 92
    int currentHour = 0;
// 93
    int currentMinute = 0;
// 94
    JP.go.ipa.oz.lib.standard._Integer_if Hour = null;
// 95
    JP.go.ipa.oz.lib.standard._Integer_if Minute = null;
// 96
    JP.go.ipa.oz.lib.standard._String_if label = null;
// 98
    now = number * grid;
// 99
    currentHour = now / 60;
// 100
    currentMinute = now % 60;
// 102
    Hour = (JP.go.ipa.oz.lib.standard._Integer_cl) (new JP.go.ipa.oz.lib.standard._Integer_cl ())._new_breed (currentHour + initTime);
// 103
    Minute = (JP.go.ipa.oz.lib.standard._Integer_cl) (new JP.go.ipa.oz.lib.standard._Integer_cl ())._new_breed (currentMinute);
// 105
    JP.go.ipa.oz.lib.standard._String_if asString$val$425;
    asString$val$425 = Hour.asString ();
// 105
    JP.go.ipa.oz.lib.standard._String_if string$69 = (new JP.go.ipa.oz.lib.standard._String_cl(":"));
    
// 105
    JP.go.ipa.oz.lib.standard._String_if concat$val$426;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) asString$val$425)) {
      try {
        concat$val$426 = asString$val$425.concat (string$69);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$426 = asString$val$425.concat (string$69);
    }
// 106
    JP.go.ipa.oz.lib.standard._String_if asString$val$427;
    asString$val$427 = Minute.asString ();
// 105
    JP.go.ipa.oz.lib.standard._String_if concat$val$428;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$426)) {
      try {
        concat$val$428 = concat$val$426.concat (asString$val$427);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$428 = concat$val$426.concat (asString$val$427);
    }
// 105
    label = concat$val$428;
// 107
    return label;
  }
  
  public JP.go.ipa.oz.user.apl.fm.ScheduleBoard_if cloneSelf () throws Exception  {
    checkSecureInvocation ();
// 410
    JP.go.ipa.oz.user.apl.fm.ScheduleBoard_if clone = (JP.go.ipa.oz.user.apl.fm.ScheduleBoard_cl) (new JP.go.ipa.oz.user.apl.fm.ScheduleBoard_cl ())._new_create (getDays (), getGrid ());
// 411
    int getSpan$val$429;
    getSpan$val$429 = getSpan ();
// 411
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) clone)) {
      try {
        clone.setSpan (getSpan$val$429);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      clone.setSpan (getSpan$val$429);
    }
// 412
    int getInitTime$val$430;
    getInitTime$val$430 = getInitTime ();
// 412
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) clone)) {
      try {
        clone.setInitTime (getInitTime$val$430);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      clone.setInitTime (getInitTime$val$430);
    }
// 413
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) clone)) {
      try {
        clone.reset ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      clone.reset ();
    }
// 414
    JP.go.ipa.oz.lib.standard._SList_if getTable$val$431;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) clone)) {
      try {
        getTable$val$431 = clone.getTable ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getTable$val$431 = clone.getTable ();
    }
// 414
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$432;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getTable$val$431)) {
      try {
        iterator$val$432 = getTable$val$431.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$432 = getTable$val$431.iterator ();
    }
// 414
    JP.go.ipa.oz.lib.standard._Iterator_if iter = iterator$val$432;
// 415
    JP.go.ipa.oz.lib.standard._SList_if getTable$val$433;
    getTable$val$433 = getTable ();
// 415
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$434;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getTable$val$433)) {
      try {
        iterator$val$434 = getTable$val$433.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$434 = getTable$val$433.iterator ();
    }
// 415
    JP.go.ipa.oz.lib.standard._Iterator_if siter = iterator$val$434;
// 417
    while (true) {
// 417
      boolean hasMoreElements$val$435;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) siter)) {
        try {
          hasMoreElements$val$435 = siter.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$435 = siter.hasMoreElements ();
      }
      if (!(hasMoreElements$val$435)) break;
      
      /* body */ _loop_1: {
// 418
        JP.go.ipa.oz.lib.standard._SList_if aDay = null;
// 419
        JP.go.ipa.oz.lib.standard._SList_if saDay = null;
// 421
        JP.go.ipa.oz.lang._Root_if nextElement$val$436;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
          try {
            nextElement$val$436 = iter.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$436 = iter.nextElement ();
        }
// 421
        aDay = (JP.go.ipa.oz.lib.standard._SList_if) (nextElement$val$436);
// 422
        JP.go.ipa.oz.lang._Root_if nextElement$val$437;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) siter)) {
          try {
            nextElement$val$437 = siter.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$437 = siter.nextElement ();
        }
// 422
        saDay = (JP.go.ipa.oz.lib.standard._SList_if) (nextElement$val$437);
// 423
        JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$438;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) aDay)) {
          try {
            iterator$val$438 = aDay.iterator ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          iterator$val$438 = aDay.iterator ();
        }
// 423
        JP.go.ipa.oz.lib.standard._Iterator_if diter = iterator$val$438;
// 424
        JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$439;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) saDay)) {
          try {
            iterator$val$439 = saDay.iterator ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          iterator$val$439 = saDay.iterator ();
        }
// 424
        JP.go.ipa.oz.lib.standard._Iterator_if sditer = iterator$val$439;
// 427
        while (true) {
// 427
          boolean hasMoreElements$val$440;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sditer)) {
            try {
              hasMoreElements$val$440 = sditer.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$440 = sditer.hasMoreElements ();
          }
          if (!(hasMoreElements$val$440)) break;
          
          /* body */ _loop_2: {
// 428
            JP.go.ipa.oz.user.apl.fm.TimePiece_if tp = null;
// 429
            JP.go.ipa.oz.user.apl.fm.TimePiece_if stp = null;
// 430
            JP.go.ipa.oz.lang._Root_if nextElement$val$441;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) diter)) {
              try {
                nextElement$val$441 = diter.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$441 = diter.nextElement ();
            }
// 430
            tp = (JP.go.ipa.oz.user.apl.fm.TimePiece_if) (nextElement$val$441);
// 431
            JP.go.ipa.oz.lang._Root_if nextElement$val$442;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sditer)) {
              try {
                nextElement$val$442 = sditer.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$442 = sditer.nextElement ();
            }
// 431
            stp = (JP.go.ipa.oz.user.apl.fm.TimePiece_if) (nextElement$val$442);
// 438
            boolean isReservable$val$443;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) stp)) {
              try {
                isReservable$val$443 = stp.isReservable ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              isReservable$val$443 = stp.isReservable ();
            }
// 438
            if (isReservable$val$443) {{
// 439
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tp)) {
                  try {
                    tp.cancel ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  tp.cancel ();
                }
              }
            } else {{
// 441
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tp)) {
                  try {
                    tp.reserve ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  tp.reserve ();
                }
              }
            }
          }
        }
      }
    }
// 446
    return clone;
  }
  
  public void cancel (JP.go.ipa.oz.user.apl.fm.Reserve_if res) throws Exception  {
    checkSecureInvocation ();
// 275
    JP.go.ipa.oz.lib.standard._SList_if sch = null;
// 276
    JP.go.ipa.oz.lib.standard._Iterator_if iter = null;
// 278
    sch = getSelectedSchedule (res);
// 279
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$444;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sch)) {
      try {
        iterator$val$444 = sch.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$444 = sch.iterator ();
    }
// 279
    iter = iterator$val$444;
// 281
    while (true) {
// 281
      boolean hasMoreElements$val$445;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
        try {
          hasMoreElements$val$445 = iter.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$445 = iter.hasMoreElements ();
      }
      if (!(hasMoreElements$val$445)) break;
      
      /* body */ _loop_1: {
// 282
        JP.go.ipa.oz.user.apl.fm.TimePiece_if aPiece = null;
// 283
        JP.go.ipa.oz.lang._Root_if nextElement$val$446;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
          try {
            nextElement$val$446 = iter.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$446 = iter.nextElement ();
        }
// 283
        aPiece = (JP.go.ipa.oz.user.apl.fm.TimePiece_if) (nextElement$val$446);
// 285
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) aPiece)) {
          try {
            aPiece.cancel ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          aPiece.cancel ();
        }
      }
    }
  }
  
  protected JP.go.ipa.oz.lib.standard._SList_if makeADay () throws Exception  {
// 60
    JP.go.ipa.oz.lib.standard._SList_if aDay = null;
// 61
    aDay = (JP.go.ipa.oz.lib.standard._SList_cl) (new JP.go.ipa.oz.lib.standard._SList_cl ())._new_create ();
// 62
    /* for loop starting here */ {
      /* initialization part */
      int j = 0;
      
      for (;;) {
        /* boolean expression part */
        if (!(j < pieceNum)) break;
        
        /* body */ _loop_1: {
// 63
          JP.go.ipa.oz.user.apl.fm.TimePiece_if aPiece = null;
// 64
          aPiece = makeATimePiece (j);
// 65
          aDay.pushBack (aPiece);
        }
        /* iteration part */
// 62
        j++;
      }
    }
// 67
    return aDay;
  }
  
  public void setGrid (int gd) throws Exception  {
    checkSecureInvocation ();
// 304
    grid = gd;
// 305
    setPieceNum ();
  }
  
  public void setDays (int date) throws Exception  {
    checkSecureInvocation ();
// 295
    days = date;
  }
  
  public void toGreen () throws Exception  {
    checkSecureInvocation ();
// 391
    JP.go.ipa.oz.user.apl.fm.Overseer_if overseer = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 392
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
      try {
        overseer.permit (table);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      overseer.permit (table);
    }
// 393
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$447;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) table)) {
      try {
        iterator$val$447 = table.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$447 = table.iterator ();
    }
// 393
    JP.go.ipa.oz.lib.standard._Iterator_if iter = iterator$val$447;
// 394
    while (true) {
// 394
      boolean hasMoreElements$val$448;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
        try {
          hasMoreElements$val$448 = iter.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$448 = iter.hasMoreElements ();
      }
      if (!(hasMoreElements$val$448)) break;
      
      /* body */ _loop_1: {
// 395
        JP.go.ipa.oz.lib.standard._SList_if aDay = null;
// 395
        JP.go.ipa.oz.lang._Root_if nextElement$val$449;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
          try {
            nextElement$val$449 = iter.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$449 = iter.nextElement ();
        }
// 395
        aDay = (JP.go.ipa.oz.lib.standard._SList_if) (nextElement$val$449);
// 396
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
          try {
            overseer.permit (aDay);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          overseer.permit (aDay);
        }
// 397
        JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$450;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) aDay)) {
          try {
            iterator$val$450 = aDay.iterator ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          iterator$val$450 = aDay.iterator ();
        }
// 397
        JP.go.ipa.oz.lib.standard._Iterator_if sliter = iterator$val$450;
// 398
        while (true) {
// 398
          boolean hasMoreElements$val$451;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sliter)) {
            try {
              hasMoreElements$val$451 = sliter.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$451 = sliter.hasMoreElements ();
          }
          if (!(hasMoreElements$val$451)) break;
          
          /* body */ _loop_2: {
// 399
            JP.go.ipa.oz.user.apl.fm.TimePiece_if tp = null;
// 399
            JP.go.ipa.oz.lang._Root_if nextElement$val$452;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sliter)) {
              try {
                nextElement$val$452 = sliter.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$452 = sliter.nextElement ();
            }
// 399
            tp = (JP.go.ipa.oz.user.apl.fm.TimePiece_if) (nextElement$val$452);
// 400
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
              try {
                overseer.permit (tp);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              overseer.permit (tp);
            }
          }
        }
      }
    }
  }
  
  public int getInitTime () throws Exception  {
    checkSecureInvocation ();
// 362
    return initTime;
  }
  
  public void setInitTime (int time) throws Exception  {
    checkSecureInvocation ();
// 326
    initTime = time;
  }
  
  public JP.go.ipa.oz.lib.standard._SList_if getTable () throws Exception  {
    checkSecureInvocation ();
// 406
    return table;
  }
  
  public int timeToPiece (int hour, int minute) throws Exception  {
    checkSecureInvocation ();
// 382
    int result = 0;
// 383
    int now = 0;
// 385
    now = (hour - initTime) * 60 + minute;
// 386
    result = now / grid + 1;
// 387
    return result;
  }
  
  public int getSpan () throws Exception  {
    checkSecureInvocation ();
// 353
    return span;
  }
  
  public void reset () throws Exception  {
    checkSecureInvocation ();
// 31
    table = (JP.go.ipa.oz.lib.standard._SList_cl) (new JP.go.ipa.oz.lib.standard._SList_cl ())._new_create ();
// 32
    setTable ();
  }
  
  public boolean isEqualScheduleBoard (JP.go.ipa.oz.user.apl.fm.ScheduleBoard_if s) throws Exception  {
    checkSecureInvocation ();
// 451
    if (s == null) {
// 451
      return false;
    }
    boolean bool$val$13;
    
    boolean bool$val$14;
    
    boolean bool$val$15;
    
    boolean bool$val$16;
    
// 452
    int getInitTime$val$453;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s)) {
      try {
        getInitTime$val$453 = s.getInitTime ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getInitTime$val$453 = s.getInitTime ();
    }
    bool$val$16 = initTime != getInitTime$val$453;
    if (!bool$val$16) {
// 453
      int getSpan$val$454;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s)) {
        try {
          getSpan$val$454 = s.getSpan ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getSpan$val$454 = s.getSpan ();
      }
      bool$val$16 = span != getSpan$val$454;
    }
    bool$val$15 = bool$val$16;
    if (!bool$val$15) {
// 454
      int getPieceNum$val$455;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s)) {
        try {
          getPieceNum$val$455 = s.getPieceNum ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getPieceNum$val$455 = s.getPieceNum ();
      }
      bool$val$15 = pieceNum != getPieceNum$val$455;
    }
    bool$val$14 = bool$val$15;
    if (!bool$val$14) {
// 455
      int getDays$val$456;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s)) {
        try {
          getDays$val$456 = s.getDays ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getDays$val$456 = s.getDays ();
      }
      bool$val$14 = days != getDays$val$456;
    }
    bool$val$13 = bool$val$14;
    if (!bool$val$13) {
// 456
      int getGrid$val$457;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s)) {
        try {
          getGrid$val$457 = s.getGrid ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getGrid$val$457 = s.getGrid ();
      }
      bool$val$13 = grid != getGrid$val$457;
    }
// 452
    if (bool$val$13) {
// 456
      return false;
    }
// 458
    JP.go.ipa.oz.lib.standard._SList_if getTable$val$458;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s)) {
      try {
        getTable$val$458 = s.getTable ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getTable$val$458 = s.getTable ();
    }
// 458
    JP.go.ipa.oz.lib.standard._SList_if stable = getTable$val$458;
    boolean bool$val$17;
    
    bool$val$17 = table == null;
    if (!bool$val$17) {
      bool$val$17 = stable == null;
    }
// 459
    if (bool$val$17) {{
        boolean bool$val$18;
        
        bool$val$18 = table == null;
        if (bool$val$18) {
          bool$val$18 = stable == null;
        }
// 460
        return (bool$val$18);
      }
    }
// 462
    int size$val$459;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) table)) {
      try {
        size$val$459 = table.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$459 = table.size ();
    }
// 462
    int size$val$460;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) stable)) {
      try {
        size$val$460 = stable.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$460 = stable.size ();
    }
// 462
    if (size$val$459 != size$val$460) {
// 462
      return false;
    }
// 463
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$461;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) table)) {
      try {
        iterator$val$461 = table.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$461 = table.iterator ();
    }
// 463
    JP.go.ipa.oz.lib.standard._Iterator_if iter = iterator$val$461;
// 464
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$462;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) stable)) {
      try {
        iterator$val$462 = stable.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$462 = stable.iterator ();
    }
// 464
    JP.go.ipa.oz.lib.standard._Iterator_if siter = iterator$val$462;
// 465
    while (true) {
// 465
      boolean hasMoreElements$val$463;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
        try {
          hasMoreElements$val$463 = iter.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$463 = iter.hasMoreElements ();
      }
      if (!(hasMoreElements$val$463)) break;
      
      /* body */ _loop_1: {
// 466
        JP.go.ipa.oz.lib.standard._SList_if aDay = null;
// 467
        JP.go.ipa.oz.lib.standard._SList_if saDay = null;
// 469
        JP.go.ipa.oz.lang._Root_if nextElement$val$464;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
          try {
            nextElement$val$464 = iter.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$464 = iter.nextElement ();
        }
// 469
        aDay = (JP.go.ipa.oz.lib.standard._SList_if) (nextElement$val$464);
// 470
        JP.go.ipa.oz.lang._Root_if nextElement$val$465;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) siter)) {
          try {
            nextElement$val$465 = siter.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$465 = siter.nextElement ();
        }
// 470
        saDay = (JP.go.ipa.oz.lib.standard._SList_if) (nextElement$val$465);
// 471
        int size$val$466;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) aDay)) {
          try {
            size$val$466 = aDay.size ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          size$val$466 = aDay.size ();
        }
// 471
        int size$val$467;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) saDay)) {
          try {
            size$val$467 = saDay.size ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          size$val$467 = saDay.size ();
        }
// 471
        if (size$val$466 != size$val$467) {
// 471
          return false;
        }
// 472
        JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$468;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) aDay)) {
          try {
            iterator$val$468 = aDay.iterator ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          iterator$val$468 = aDay.iterator ();
        }
// 472
        JP.go.ipa.oz.lib.standard._Iterator_if diter = iterator$val$468;
// 473
        JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$469;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) saDay)) {
          try {
            iterator$val$469 = saDay.iterator ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          iterator$val$469 = saDay.iterator ();
        }
// 473
        JP.go.ipa.oz.lib.standard._Iterator_if sditer = iterator$val$469;
// 474
        while (true) {
// 474
          boolean hasMoreElements$val$470;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) diter)) {
            try {
              hasMoreElements$val$470 = diter.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$470 = diter.hasMoreElements ();
          }
          if (!(hasMoreElements$val$470)) break;
          
          /* body */ _loop_2: {
// 475
            JP.go.ipa.oz.user.apl.fm.TimePiece_if tp = null;
// 476
            JP.go.ipa.oz.user.apl.fm.TimePiece_if stp = null;
// 477
            JP.go.ipa.oz.lang._Root_if nextElement$val$471;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) diter)) {
              try {
                nextElement$val$471 = diter.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$471 = diter.nextElement ();
            }
// 477
            tp = (JP.go.ipa.oz.user.apl.fm.TimePiece_if) (nextElement$val$471);
// 478
            JP.go.ipa.oz.lang._Root_if nextElement$val$472;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sditer)) {
              try {
                nextElement$val$472 = sditer.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$472 = sditer.nextElement ();
            }
// 478
            stp = (JP.go.ipa.oz.user.apl.fm.TimePiece_if) (nextElement$val$472);
// 479
            boolean isEqualTimePiece$val$473;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tp)) {
              try {
                isEqualTimePiece$val$473 = tp.isEqualTimePiece (stp);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              isEqualTimePiece$val$473 = tp.isEqualTimePiece (stp);
            }
// 479
            if (!isEqualTimePiece$val$473) {
// 479
              return false;
            }
          }
        }
      }
    }
// 482
    return true;
  }
  
  public JP.go.ipa.oz.lib.standard._SList_if confirm (JP.go.ipa.oz.user.apl.fm.Reserve_if res) throws Exception  {
    checkSecureInvocation ();
// 194
    return getSelectedSchedule (res);
  }
  
  protected JP.go.ipa.oz.user.apl.fm.TimePiece_if makeATimePiece (int number) throws Exception  {
// 77
    JP.go.ipa.oz.user.apl.fm.TimePiece_if aPiece = null;
// 78
    aPiece = (JP.go.ipa.oz.user.apl.fm.TimePiece_cl) (new JP.go.ipa.oz.user.apl.fm.TimePiece_cl ())._new_create ();
// 80
    aPiece.setName (makePieceLabel (number));
// 81
    return aPiece;
  }
  
  public void trace (int mark) throws Exception  {
    checkSecureInvocation ();
// 487
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 488
    JP.go.ipa.oz.lib.standard._PrintWriter_if getStdout$val$474;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        getStdout$val$474 = system.getStdout ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getStdout$val$474 = system.getStdout ();
    }
// 488
    JP.go.ipa.oz.lib.standard._PrintWriter_if pw = (JP.go.ipa.oz.lib.standard._PrintWriter_cl) (new JP.go.ipa.oz.lib.standard._PrintWriter_cl ())._new_breed (getStdout$val$474, true);
// 489
    JP.go.ipa.oz.lib.standard._String_if string$70 = (new JP.go.ipa.oz.lib.standard._String_cl("ScheduleBoard#trace("));
    
// 489
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.print (string$70);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.print (string$70);
    }
// 490
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.print (mark);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.print (mark);
    }
// 491
    JP.go.ipa.oz.lib.standard._String_if string$71 = (new JP.go.ipa.oz.lib.standard._String_cl(")"));
    
// 491
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.println (string$71);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.println (string$71);
    }
// 492
    JP.go.ipa.oz.lib.standard._String_if string$72 = (new JP.go.ipa.oz.lib.standard._String_cl(" initTime:"));
    
// 492
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.print (string$72);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.print (string$72);
    }
// 493
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.print (initTime);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.print (initTime);
    }
// 494
    JP.go.ipa.oz.lib.standard._String_if string$73 = (new JP.go.ipa.oz.lib.standard._String_cl(" span:"));
    
// 494
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.print (string$73);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.print (string$73);
    }
// 495
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.print (span);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.print (span);
    }
// 496
    JP.go.ipa.oz.lib.standard._String_if string$74 = (new JP.go.ipa.oz.lib.standard._String_cl(" pieceNum:"));
    
// 496
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.print (string$74);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.print (string$74);
    }
// 497
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.print (pieceNum);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.print (pieceNum);
    }
// 498
    JP.go.ipa.oz.lib.standard._String_if string$75 = (new JP.go.ipa.oz.lib.standard._String_cl(" days:"));
    
// 498
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.print (string$75);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.print (string$75);
    }
// 499
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.print (days);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.print (days);
    }
// 500
    JP.go.ipa.oz.lib.standard._String_if string$76 = (new JP.go.ipa.oz.lib.standard._String_cl(" grid:"));
    
// 500
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.print (string$76);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.print (string$76);
    }
// 501
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.println (grid);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.println (grid);
    }
// 502
    JP.go.ipa.oz.lib.standard._String_if string$77 = (new JP.go.ipa.oz.lib.standard._String_cl(" table:"));
    
// 502
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.print (string$77);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.print (string$77);
    }
// 503
    JP.go.ipa.oz.lib.standard._String_if asString$val$475;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) table)) {
      try {
        asString$val$475 = table.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$475 = table.asString ();
    }
// 503
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.println (asString$val$475);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.println (asString$val$475);
    }
// 504
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$476;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) table)) {
      try {
        iterator$val$476 = table.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$476 = table.iterator ();
    }
// 504
    JP.go.ipa.oz.lib.standard._Iterator_if iter = iterator$val$476;
// 505
    while (true) {
// 505
      boolean hasMoreElements$val$477;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
        try {
          hasMoreElements$val$477 = iter.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$477 = iter.hasMoreElements ();
      }
      if (!(hasMoreElements$val$477)) break;
      
      /* body */ _loop_1: {
// 506
        JP.go.ipa.oz.lib.standard._SList_if aDay = null;
// 506
        JP.go.ipa.oz.lang._Root_if nextElement$val$478;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
          try {
            nextElement$val$478 = iter.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$478 = iter.nextElement ();
        }
// 506
        aDay = (JP.go.ipa.oz.lib.standard._SList_if) (nextElement$val$478);
// 507
        JP.go.ipa.oz.lib.standard._String_if string$78 = (new JP.go.ipa.oz.lib.standard._String_cl("  aDay:"));
        
// 507
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
          try {
            pw.print (string$78);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          pw.print (string$78);
        }
// 508
        JP.go.ipa.oz.lib.standard._String_if asString$val$479;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) aDay)) {
          try {
            asString$val$479 = aDay.asString ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          asString$val$479 = aDay.asString ();
        }
// 508
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
          try {
            pw.print (asString$val$479);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          pw.print (asString$val$479);
        }
// 509
        JP.go.ipa.oz.lib.standard._String_if string$79 = (new JP.go.ipa.oz.lib.standard._String_cl(" on reserve"));
        
// 509
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
          try {
            pw.print (string$79);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          pw.print (string$79);
        }
// 510
        JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$480;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) aDay)) {
          try {
            iterator$val$480 = aDay.iterator ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          iterator$val$480 = aDay.iterator ();
        }
// 510
        JP.go.ipa.oz.lib.standard._Iterator_if sliter = iterator$val$480;
// 511
        while (true) {
// 511
          boolean hasMoreElements$val$481;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sliter)) {
            try {
              hasMoreElements$val$481 = sliter.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$481 = sliter.hasMoreElements ();
          }
          if (!(hasMoreElements$val$481)) break;
          
          /* body */ _loop_2: {
// 512
            JP.go.ipa.oz.user.apl.fm.TimePiece_if tp = null;
// 512
            JP.go.ipa.oz.lang._Root_if nextElement$val$482;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sliter)) {
              try {
                nextElement$val$482 = sliter.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$482 = sliter.nextElement ();
            }
// 512
            tp = (JP.go.ipa.oz.user.apl.fm.TimePiece_if) (nextElement$val$482);
// 513
            boolean isReservable$val$483;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tp)) {
              try {
                isReservable$val$483 = tp.isReservable ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              isReservable$val$483 = tp.isReservable ();
            }
// 513
            if (!isReservable$val$483) {{
// 514
                JP.go.ipa.oz.lib.standard._String_if string$80 = (new JP.go.ipa.oz.lib.standard._String_cl(" "));
                
// 514
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
                  try {
                    pw.print (string$80);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  pw.print (string$80);
                }
// 515
                JP.go.ipa.oz.lib.standard._String_if getName$val$484;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tp)) {
                  try {
                    getName$val$484 = tp.getName ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  getName$val$484 = tp.getName ();
                }
// 515
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
                  try {
                    pw.print (getName$val$484);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  pw.print (getName$val$484);
                }
              }
            }
          }
        }
// 518
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
          try {
            pw.println ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          pw.println ();
        }
      }
    }
  }
  
  public boolean reserve (int date, int start, int end) throws Exception  {
    checkSecureInvocation ();
// 153
    boolean result = false;
// 154
    JP.go.ipa.oz.lib.standard._SList_if selected = null;
// 155
    JP.go.ipa.oz.lib.standard._Iterator_if iter = null;
// 161
    selected = getSelectedSchedule (date, start, end);
// 162
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$485;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) selected)) {
      try {
        iterator$val$485 = selected.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$485 = selected.iterator ();
    }
// 162
    iter = iterator$val$485;
// 164
    result = true;
// 165
    while (true) {
// 165
      boolean hasMoreElements$val$486;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
        try {
          hasMoreElements$val$486 = iter.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$486 = iter.hasMoreElements ();
      }
      if (!(hasMoreElements$val$486)) break;
      
      /* body */ _loop_1: {
// 166
        JP.go.ipa.oz.user.apl.fm.TimePiece_if aPiece = null;
// 167
        JP.go.ipa.oz.lang._Root_if nextElement$val$487;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
          try {
            nextElement$val$487 = iter.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$487 = iter.nextElement ();
        }
// 167
        aPiece = (JP.go.ipa.oz.user.apl.fm.TimePiece_if) (nextElement$val$487);
// 168
        boolean isReservable$val$488;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) aPiece)) {
          try {
            isReservable$val$488 = aPiece.isReservable ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isReservable$val$488 = aPiece.isReservable ();
        }
// 168
        result = isReservable$val$488;
// 169
        if (!result) {
// 169
          break;
        }
      }
    }
// 172
    if (!result) {{
// 173
        return false;
      }
    } else {{
// 175
        JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$489;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) selected)) {
          try {
            iterator$val$489 = selected.iterator ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          iterator$val$489 = selected.iterator ();
        }
// 175
        iter = iterator$val$489;
// 176
        while (true) {
// 176
          boolean hasMoreElements$val$490;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
            try {
              hasMoreElements$val$490 = iter.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$490 = iter.hasMoreElements ();
          }
          if (!(hasMoreElements$val$490)) break;
          
          /* body */ _loop_1: {
// 177
            JP.go.ipa.oz.user.apl.fm.TimePiece_if aPiece = null;
// 178
            JP.go.ipa.oz.lang._Root_if nextElement$val$491;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
              try {
                nextElement$val$491 = iter.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$491 = iter.nextElement ();
            }
// 178
            aPiece = (JP.go.ipa.oz.user.apl.fm.TimePiece_if) (nextElement$val$491);
// 179
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) aPiece)) {
              try {
                aPiece.reserve ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              aPiece.reserve ();
            }
          }
        }
      }
    }
// 183
    return true;
  }
  
  public boolean reserve (JP.go.ipa.oz.user.apl.fm.Reserve_if res) throws Exception  {
    checkSecureInvocation ();
// 118
    int start = 0;
// 119
    int end = 0;
// 120
    boolean result = false;
// 122
    int getStartHour$val$492;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        getStartHour$val$492 = res.getStartHour ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getStartHour$val$492 = res.getStartHour ();
    }
// 122
    int getStartMinute$val$493;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        getStartMinute$val$493 = res.getStartMinute ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getStartMinute$val$493 = res.getStartMinute ();
    }
// 122
    start = timeToPiece (getStartHour$val$492, getStartMinute$val$493);
// 123
    int getEndHour$val$494;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        getEndHour$val$494 = res.getEndHour ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getEndHour$val$494 = res.getEndHour ();
    }
// 123
    int eh = getEndHour$val$494;
// 124
    int getEndMinute$val$495;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        getEndMinute$val$495 = res.getEndMinute ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getEndMinute$val$495 = res.getEndMinute ();
    }
// 124
    int em = getEndMinute$val$495;
// 125
    if (em > 0) {{
// 126
        em--;
      }
    } else {{
// 128
        if (eh > 0) {{
// 129
            eh--;
// 130
            em = 60 - 1;
          }
        } else {{
// 133
            ;
          }
        }
      }
    }
// 136
    end = timeToPiece (eh, em);
// 138
    int getDay$val$496;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        getDay$val$496 = res.getDay ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getDay$val$496 = res.getDay ();
    }
// 138
    result = reserve (getDay$val$496, start, end);
// 140
    return result;
  }
  
  public int getPieceNum () throws Exception  {
    checkSecureInvocation ();
// 371
    return pieceNum;
  }
  
  public JP.go.ipa.oz.lib.standard._SList_if getSelectedSchedule (int date, int start, int end) throws Exception  {
    checkSecureInvocation ();
// 244
    JP.go.ipa.oz.lib.standard._SList_if days = null;
// 245
    JP.go.ipa.oz.lib.standard._SList_if result = null;
// 248
    JP.go.ipa.oz.lib.standard._Sequence_if infix$val$497;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) table)) {
      try {
        infix$val$497 = table.infix (date - 1, date);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      infix$val$497 = table.infix (date - 1, date);
    }
// 248
    JP.go.ipa.oz.lang._Root_if first$val$498;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) infix$val$497)) {
      try {
        first$val$498 = infix$val$497.first ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      first$val$498 = infix$val$497.first ();
    }
// 248
    days = (JP.go.ipa.oz.lib.standard._SList_if) (first$val$498);
// 250
    JP.go.ipa.oz.lib.standard._Sequence_if infix$val$499;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) days)) {
      try {
        infix$val$499 = days.infix (start - 1, end);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      infix$val$499 = days.infix (start - 1, end);
    }
// 250
    result = (JP.go.ipa.oz.lib.standard._SList_if) (infix$val$499);
// 263
    return result;
  }
  
  public JP.go.ipa.oz.lib.standard._SList_if getSelectedSchedule (JP.go.ipa.oz.user.apl.fm.Reserve_if res) throws Exception  {
    checkSecureInvocation ();
// 204
    int start = 0;
// 205
    int end = 0;
// 206
    JP.go.ipa.oz.lib.standard._SList_if result = null;
// 208
    int getStartHour$val$500;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        getStartHour$val$500 = res.getStartHour ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getStartHour$val$500 = res.getStartHour ();
    }
// 208
    int getStartMinute$val$501;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        getStartMinute$val$501 = res.getStartMinute ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getStartMinute$val$501 = res.getStartMinute ();
    }
// 208
    start = timeToPiece (getStartHour$val$500, getStartMinute$val$501);
// 209
    int getEndHour$val$502;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        getEndHour$val$502 = res.getEndHour ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getEndHour$val$502 = res.getEndHour ();
    }
// 209
    int getEndMinute$val$503;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        getEndMinute$val$503 = res.getEndMinute ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getEndMinute$val$503 = res.getEndMinute ();
    }
// 209
    end = timeToPiece (getEndHour$val$502, getEndMinute$val$503);
// 210
    int getEndHour$val$504;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        getEndHour$val$504 = res.getEndHour ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getEndHour$val$504 = res.getEndHour ();
    }
// 210
    int eh = getEndHour$val$504;
// 211
    int getEndMinute$val$505;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        getEndMinute$val$505 = res.getEndMinute ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getEndMinute$val$505 = res.getEndMinute ();
    }
// 211
    int em = getEndMinute$val$505;
// 212
    if (em > 0) {{
// 213
        em--;
      }
    } else {{
// 215
        if (eh > 0) {{
// 216
            eh--;
// 217
            em = 60 - 1;
          }
        } else {{
// 220
            ;
          }
        }
      }
    }
// 223
    end = timeToPiece (eh, em);
// 225
    int getDay$val$506;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        getDay$val$506 = res.getDay ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getDay$val$506 = res.getDay ();
    }
// 225
    result = getSelectedSchedule (getDay$val$506, start, end);
// 227
    return result;
  }
  
  protected void setPieceNum () throws Exception  {
// 51
    pieceNum = span * 60 / grid;
  }
  
  public void setSpan (int sp) throws Exception  {
    checkSecureInvocation ();
// 315
    span = sp;
// 316
    setPieceNum ();
  }
  
  public int getGrid () throws Exception  {
    checkSecureInvocation ();
// 344
    return grid;
  }
  
  protected void setTable () throws Exception  {
// 39
    setPieceNum ();
// 40
    /* for loop starting here */ {
      /* initialization part */
      int i = 0;
      
      for (;;) {
        /* boolean expression part */
        if (!(i < days)) break;
        
        /* body */ _loop_1: {
// 41
          JP.go.ipa.oz.lib.standard._SList_if aDay = null;
// 42
          aDay = makeADay ();
// 43
          JP.go.ipa.oz.lib.standard._SList_if pushBack$val$507;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) table)) {
            try {
              pushBack$val$507 = table.pushBack (aDay);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            pushBack$val$507 = table.pushBack (aDay);
          }
        }
        /* iteration part */
// 40
        i++;
      }
    }
  }
  
  public int getDays () throws Exception  {
    checkSecureInvocation ();
// 335
    return days;
  }
  
  public ScheduleBoard_cl () throws Exception { super (); }
  
}

