package JP.go.ipa.oz.user.apl.fm;

public class Schedulable_cl extends JP.go.ipa.oz.user.apl.fm.FMObject_cl implements JP.go.ipa.oz.user.apl.fm.Schedulable_if {
  JP.go.ipa.oz.user.apl.fm.ScheduleBoard_if board;
  
  public Object _new_create (JP.go.ipa.oz.user.apl.fm.Schedulable_if s) throws Exception  {
// 121
    JP.go.ipa.oz.lib.standard._String_if getName$val$508;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s)) {
      try {
        getName$val$508 = s.getName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getName$val$508 = s.getName ();
    }
// 121
    JP.go.ipa.oz.lib.standard._Set_if getAllRelations$val$509;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s)) {
      try {
        getAllRelations$val$509 = s.getAllRelations ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getAllRelations$val$509 = s.getAllRelations ();
    }
// 121
    JP.go.ipa.oz.user.apl.fm.Pointer_if getIdentifier$val$510;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s)) {
      try {
        getIdentifier$val$510 = s.getIdentifier ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getIdentifier$val$510 = s.getIdentifier ();
    }
// 121
    super._new_create (getName$val$508, getAllRelations$val$509, getIdentifier$val$510);
// 122
    JP.go.ipa.oz.user.apl.fm.ScheduleBoard_if getBoard$val$511;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s)) {
      try {
        getBoard$val$511 = s.getBoard ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBoard$val$511 = s.getBoard ();
    }
// 122
    JP.go.ipa.oz.user.apl.fm.ScheduleBoard_if cloneSelf$val$512;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getBoard$val$511)) {
      try {
        cloneSelf$val$512 = getBoard$val$511.cloneSelf ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      cloneSelf$val$512 = getBoard$val$511.cloneSelf ();
    }
// 122
    board = cloneSelf$val$512;
    return this;
  }
  
  public Object _new_create () throws Exception  {
// 15
    super._new_create ();
// 16
    board = (JP.go.ipa.oz.user.apl.fm.ScheduleBoard_cl) (new JP.go.ipa.oz.user.apl.fm.ScheduleBoard_cl ())._new_create (30, 15);
    return this;
  }
  
  public int update (JP.go.ipa.oz.user.apl.fm.FMObject_if obj) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 99
      JP.go.ipa.oz.user.apl.fm.Schedulable_if sch = null;
// 99
      sch = (JP.go.ipa.oz.user.apl.fm.Schedulable_if) (obj);
// 100
      int counter = updateWithoutLock (sch);
// 106
      if (board != null) {{
// 107
          counter += boardUpdate (sch);
        }
      }
// 111
      return counter;
    } finally {
      leave ();
    }
  }
  
  public void cancel (JP.go.ipa.oz.user.apl.fm.Reserve_if res) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 46
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) board)) {
        try {
          board.cancel (res);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        board.cancel (res);
      }
    } finally {
      leave ();
    }
  }
  
  public JP.go.ipa.oz.user.apl.fm.ScheduleBoard_if getBoard () throws Exception  {
    checkSecureInvocation ();
// 51
    return board;
  }
  
  public void trace (int mark) throws Exception  {
    checkSecureInvocation ();
// 132
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 133
    JP.go.ipa.oz.lib.standard._PrintWriter_if getStdout$val$513;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        getStdout$val$513 = system.getStdout ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getStdout$val$513 = system.getStdout ();
    }
// 133
    JP.go.ipa.oz.lib.standard._PrintWriter_if pw = (JP.go.ipa.oz.lib.standard._PrintWriter_cl) (new JP.go.ipa.oz.lib.standard._PrintWriter_cl ())._new_breed (getStdout$val$513, true);
// 134
    JP.go.ipa.oz.lib.standard._String_if string$81 = (new JP.go.ipa.oz.lib.standard._String_cl("Schedulable#trace("));
    
// 134
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.print (string$81);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.print (string$81);
    }
// 135
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.print (mark);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.print (mark);
    }
// 136
    JP.go.ipa.oz.lib.standard._String_if string$82 = (new JP.go.ipa.oz.lib.standard._String_cl(")"));
    
// 136
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.println (string$82);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.println (string$82);
    }
// 137
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) board)) {
      try {
        board.trace (mark);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      board.trace (mark);
    }
// 138
    JP.go.ipa.oz.lib.standard._String_if string$83 = (new JP.go.ipa.oz.lib.standard._String_cl("---- super ----"));
    
// 138
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.println (string$83);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.println (string$83);
    }
// 139
    super.trace (mark);
  }
  
  public JP.go.ipa.oz.user.apl.fm.FMObject_if cloneSelf () throws Exception  {
    checkSecureInvocation ();
// 116
    JP.go.ipa.oz.user.apl.fm.Schedulable_if clone = (JP.go.ipa.oz.user.apl.fm.Schedulable_cl) (new JP.go.ipa.oz.user.apl.fm.Schedulable_cl ())._new_create (this);
// 117
    return clone;
  }
  
  public boolean reserve (JP.go.ipa.oz.user.apl.fm.Reserve_if res) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 27
      boolean reserve$val$514;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) board)) {
        try {
          reserve$val$514 = board.reserve (res);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        reserve$val$514 = board.reserve (res);
      }
// 27
      return reserve$val$514;
    } finally {
      leave ();
    }
  }
  
  protected int boardUpdate (JP.go.ipa.oz.user.apl.fm.Schedulable_if sch) throws Exception  {
// 55
    int counter = 0;
// 57
    JP.go.ipa.oz.user.apl.fm.ScheduleBoard_if getBoard$val$515;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sch)) {
      try {
        getBoard$val$515 = sch.getBoard ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBoard$val$515 = sch.getBoard ();
    }
// 57
    JP.go.ipa.oz.user.apl.fm.ScheduleBoard_if sboard = getBoard$val$515;
// 58
    JP.go.ipa.oz.lib.standard._SList_if getTable$val$516;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) board)) {
      try {
        getTable$val$516 = board.getTable ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getTable$val$516 = board.getTable ();
    }
// 58
    JP.go.ipa.oz.lib.standard._SList_if table = getTable$val$516;
// 59
    JP.go.ipa.oz.lib.standard._SList_if getTable$val$517;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sboard)) {
      try {
        getTable$val$517 = sboard.getTable ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getTable$val$517 = sboard.getTable ();
    }
// 59
    JP.go.ipa.oz.lib.standard._SList_if stable = getTable$val$517;
// 60
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$518;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) table)) {
      try {
        iterator$val$518 = table.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$518 = table.iterator ();
    }
// 60
    JP.go.ipa.oz.lib.standard._Iterator_if iter = iterator$val$518;
// 61
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$519;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) stable)) {
      try {
        iterator$val$519 = stable.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$519 = stable.iterator ();
    }
// 61
    JP.go.ipa.oz.lib.standard._Iterator_if siter = iterator$val$519;
// 64
    while (true) {
// 64
      boolean hasMoreElements$val$520;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
        try {
          hasMoreElements$val$520 = iter.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$520 = iter.hasMoreElements ();
      }
      if (!(hasMoreElements$val$520)) break;
      
      /* body */ _loop_1: {
// 65
        JP.go.ipa.oz.lib.standard._SList_if aDay = null;
// 66
        JP.go.ipa.oz.lib.standard._SList_if saDay = null;
// 68
        JP.go.ipa.oz.lang._Root_if nextElement$val$521;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
          try {
            nextElement$val$521 = iter.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$521 = iter.nextElement ();
        }
// 68
        aDay = (JP.go.ipa.oz.lib.standard._SList_if) (nextElement$val$521);
// 69
        JP.go.ipa.oz.lang._Root_if nextElement$val$522;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) siter)) {
          try {
            nextElement$val$522 = siter.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$522 = siter.nextElement ();
        }
// 69
        saDay = (JP.go.ipa.oz.lib.standard._SList_if) (nextElement$val$522);
// 70
        JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$523;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) aDay)) {
          try {
            iterator$val$523 = aDay.iterator ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          iterator$val$523 = aDay.iterator ();
        }
// 70
        JP.go.ipa.oz.lib.standard._Iterator_if diter = iterator$val$523;
// 71
        JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$524;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) saDay)) {
          try {
            iterator$val$524 = saDay.iterator ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          iterator$val$524 = saDay.iterator ();
        }
// 71
        JP.go.ipa.oz.lib.standard._Iterator_if sditer = iterator$val$524;
// 74
        while (true) {
// 74
          boolean hasMoreElements$val$525;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) diter)) {
            try {
              hasMoreElements$val$525 = diter.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$525 = diter.hasMoreElements ();
          }
          if (!(hasMoreElements$val$525)) break;
          
          /* body */ _loop_2: {
// 75
            JP.go.ipa.oz.user.apl.fm.TimePiece_if tp = null;
// 76
            JP.go.ipa.oz.user.apl.fm.TimePiece_if stp = null;
// 77
            JP.go.ipa.oz.lang._Root_if nextElement$val$526;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) diter)) {
              try {
                nextElement$val$526 = diter.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$526 = diter.nextElement ();
            }
// 77
            tp = (JP.go.ipa.oz.user.apl.fm.TimePiece_if) (nextElement$val$526);
// 78
            JP.go.ipa.oz.lang._Root_if nextElement$val$527;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sditer)) {
              try {
                nextElement$val$527 = sditer.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$527 = sditer.nextElement ();
            }
// 78
            stp = (JP.go.ipa.oz.user.apl.fm.TimePiece_if) (nextElement$val$527);
// 80
            boolean isReservable$val$528;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tp)) {
              try {
                isReservable$val$528 = tp.isReservable ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              isReservable$val$528 = tp.isReservable ();
            }
// 80
            boolean isReservable$val$529;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) stp)) {
              try {
                isReservable$val$529 = stp.isReservable ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              isReservable$val$529 = stp.isReservable ();
            }
// 80
            if (isReservable$val$528 != isReservable$val$529) {{
// 81
                boolean isReservable$val$530;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) stp)) {
                  try {
                    isReservable$val$530 = stp.isReservable ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  isReservable$val$530 = stp.isReservable ();
                }
// 81
                if (isReservable$val$530) {{
// 82
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
// 85
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
// 88
                counter++;
              }
            }
          }
        }
      }
    }
// 92
    return counter;
  }
  
  public void toGreen () throws Exception  {
    checkSecureInvocation ();
// 126
    JP.go.ipa.oz.user.apl.fm.Overseer_if overseer = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 127
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
      try {
        overseer.permit (board);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      overseer.permit (board);
    }
// 128
    super.toGreen ();
  }
  
  public JP.go.ipa.oz.lib.standard._SList_if confirm (JP.go.ipa.oz.user.apl.fm.Reserve_if res) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 37
      JP.go.ipa.oz.lib.standard._SList_if confirm$val$531;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) board)) {
        try {
          confirm$val$531 = board.confirm (res);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        confirm$val$531 = board.confirm (res);
      }
// 37
      return confirm$val$531;
    } finally {
      leave ();
    }
  }
  
  public Schedulable_cl () throws Exception { super (); }
  
}

