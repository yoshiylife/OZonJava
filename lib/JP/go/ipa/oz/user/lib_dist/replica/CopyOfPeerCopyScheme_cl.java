package JP.go.ipa.oz.user.lib_dist.replica;

public class CopyOfPeerCopyScheme_cl extends JP.go.ipa.oz.user.lib_dist.replica.CopyScheme_cl implements JP.go.ipa.oz.user.lib_dist.replica.CopyOfPeerCopyScheme_if {
  static final boolean _global_ = true;
  
  public JP.go.ipa.oz.user.lib_dist.replica.CopyOfPeerCopyScheme_if getCopy (JP.go.ipa.oz.lib.standard._String_if cpGol) throws Exception  {
    checkSecureInvocation ();
// 129
    JP.go.ipa.oz.user.lib_dist.replica.CopyOfPeerCopyScheme_if copy = null;
// 130
    JP.go.ipa.oz.user.lib_dist.replica.CopyResource_if cpResource = null;
// 131
    JP.go.ipa.oz.lib.standard._String_if gol = null;
// 132
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$0;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) otherCopies)) {
      try {
        iterator$val$0 = otherCopies.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$0 = otherCopies.iterator ();
    }
// 132
    JP.go.ipa.oz.lib.standard._Iterator_if iterator = iterator$val$0;
// 133
    /* for loop starting here */ {
      /* initialization part */
      int i = 0;
      
      for (;;) {
        /* boolean expression part */
// 133
        boolean hasMoreElements$val$1;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iterator)) {
          try {
            hasMoreElements$val$1 = iterator.hasMoreElements ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          hasMoreElements$val$1 = iterator.hasMoreElements ();
        }
        if (!(hasMoreElements$val$1)) break;
        
        /* body */ _loop_1: {
// 134
          JP.go.ipa.oz.lang._Root_if nextElement$val$2;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iterator)) {
            try {
              nextElement$val$2 = iterator.nextElement ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            nextElement$val$2 = iterator.nextElement ();
          }
// 134
          cpResource = (JP.go.ipa.oz.user.lib_dist.replica.CopyResource_if) (nextElement$val$2);
// 135
          JP.go.ipa.oz.lib.standard._String_if getGol$val$3;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cpResource)) {
            try {
              getGol$val$3 = cpResource.getGol ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getGol$val$3 = cpResource.getGol ();
          }
// 135
          gol = getGol$val$3;
// 136
          int compareTo$val$4;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cpGol)) {
            try {
              compareTo$val$4 = cpGol.compareTo (gol);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            compareTo$val$4 = cpGol.compareTo (gol);
          }
// 136
          if (compareTo$val$4 == 0) {{
// 137
              JP.go.ipa.oz.user.lib_dist.replica.CopyScheme_if getCopy$val$5;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cpResource)) {
                try {
                  getCopy$val$5 = cpResource.getCopy ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                getCopy$val$5 = cpResource.getCopy ();
              }
// 137
              copy = (JP.go.ipa.oz.user.lib_dist.replica.CopyOfPeerCopyScheme_if) (getCopy$val$5);
            }
          }
        }
        /* iteration part */
// 133
        i++;
      }
    }
// 140
    return copy;
  }
  
  public JP.go.ipa.oz.user.lib_dist.replica.CopyOfPeerCopyScheme_if getClientStub () throws Exception  {
    checkSecureInvocation ();
// 116
    JP.go.ipa.oz.user.lib_dist.replica.CopyOfPeerCopyScheme_if minCopy = null;
// 117
    minCopy = (JP.go.ipa.oz.user.lib_dist.replica.CopyOfPeerCopyScheme_if) (super.getClientStubCP ());
// 118
    return minCopy;
  }
  
  public void update () throws Exception  {
    checkSecureInvocation ();
  }
  
  protected void go () throws Exception  {
// 17
    ;
  }
  
  public boolean propagateAll () throws Exception  {
    checkSecureInvocation ();
// 96
    JP.go.ipa.oz.lib.standard._String_if string$0 = (new JP.go.ipa.oz.lib.standard._String_cl("CopyOfPeerCopyScheme:PropagateAll() in"));
    
// 96
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
      try {
        debug.write (debugFlag, string$0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      debug.write (debugFlag, string$0);
    }
// 97
    boolean rc = true;
// 98
    rc = super.propagateAllCP (4);
// 99
    JP.go.ipa.oz.lib.standard._String_if string$1 = (new JP.go.ipa.oz.lib.standard._String_cl("CopyOfPeerCopyScheme:PropagateAll() out"));
    
// 99
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
      try {
        debug.write (debugFlag, string$1);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      debug.write (debugFlag, string$1);
    }
// 100
    return rc;
  }
  
  public void makeList (JP.go.ipa.oz.lib.standard._Set_if list, JP.go.ipa.oz.user.lib_dist.replica.CopyResource_if parent) throws Exception  {
    checkSecureInvocation ();
// 74
    otherCopies = list;
// 75
    JP.go.ipa.oz.lib.standard._Set_if add$val$6;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) otherCopies)) {
      try {
        add$val$6 = otherCopies.add (parent);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$6 = otherCopies.add (parent);
    }
  }
  
  public void newCopyAt (JP.go.ipa.oz.user.lib_dist.replica.CopyOfPeerCopyScheme_if newCopy, JP.go.ipa.oz.lib.standard._String_if gol, JP.go.ipa.oz.lib.standard._String_if mngGol) throws Exception  {
    checkSecureInvocation ();
// 29
    JP.go.ipa.oz.lib.standard._String_if string$2 = (new JP.go.ipa.oz.lib.standard._String_cl("CopyOfPeerCopyScheme:newCopyAt() in"));
    
// 29
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
      try {
        debug.write (debugFlag, string$2);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      debug.write (debugFlag, string$2);
    }
// 30
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
      try {
        debug.write (debugFlag, gol);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      debug.write (debugFlag, gol);
    }
// 33
    if (mgrFlag == false) {{
// 34
        super.setCpManeger ();
      }
    }
// 36
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) newCopy)) {
      try {
        newCopy.setCpmGol (mngGol);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      newCopy.setCpmGol (mngGol);
    }
// 37
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) newCopy)) {
      try {
        newCopy.setCpManeger ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      newCopy.setCpManeger ();
    }
// 39
    idnum++;
// 40
    if (idnum > MAX_ID) {
// 41
      idnum = 1;
    }
// 42
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) newCopy)) {
      try {
        newCopy.setTid (idnum);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      newCopy.setTid (idnum);
    }
// 45
    JP.go.ipa.oz.user.lib_dist.replica.CopyResource_if cpResource = (JP.go.ipa.oz.user.lib_dist.replica.CopyResource_cl) (new JP.go.ipa.oz.user.lib_dist.replica.CopyResource_cl ())._new_create (this, ownGOL);
// 46
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) newCopy)) {
      try {
        newCopy.makeList (otherCopies, cpResource);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      newCopy.makeList (otherCopies, cpResource);
    }
// 49
    cpResource = (JP.go.ipa.oz.user.lib_dist.replica.CopyResource_cl) (new JP.go.ipa.oz.user.lib_dist.replica.CopyResource_cl ())._new_create (newCopy, gol);
// 51
    JP.go.ipa.oz.user.lib_dist.replica.CopyOfPeerCopyScheme_if copy = null;
// 52
    JP.go.ipa.oz.user.lib_dist.replica.CopyResource_if cpRes = null;
// 53
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$7;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) otherCopies)) {
      try {
        iterator$val$7 = otherCopies.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$7 = otherCopies.iterator ();
    }
// 53
    JP.go.ipa.oz.lib.standard._Iterator_if iterator = iterator$val$7;
// 54
    while (true) {
// 54
      boolean hasMoreElements$val$8;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iterator)) {
        try {
          hasMoreElements$val$8 = iterator.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$8 = iterator.hasMoreElements ();
      }
      if (!(hasMoreElements$val$8)) break;
      
      /* body */ _loop_1: {
// 55
        JP.go.ipa.oz.lang._Root_if nextElement$val$9;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iterator)) {
          try {
            nextElement$val$9 = iterator.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$9 = iterator.nextElement ();
        }
// 55
        cpRes = (JP.go.ipa.oz.user.lib_dist.replica.CopyResource_if) (nextElement$val$9);
// 56
        JP.go.ipa.oz.user.lib_dist.replica.CopyScheme_if getCopy$val$10;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cpRes)) {
          try {
            getCopy$val$10 = cpRes.getCopy ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getCopy$val$10 = cpRes.getCopy ();
        }
// 56
        copy = (JP.go.ipa.oz.user.lib_dist.replica.CopyOfPeerCopyScheme_if) (getCopy$val$10);
// 57
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) copy)) {
          try {
            copy.addOtherCopy (cpResource);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          copy.addOtherCopy (cpResource);
        }
      }
    }
// 61
    addOtherCopy (cpResource);
// 63
    JP.go.ipa.oz.lib.standard._String_if string$3 = (new JP.go.ipa.oz.lib.standard._String_cl("CopyOfPeerCopyScheme:newCopyAt() out"));
    
// 63
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
      try {
        debug.write (debugFlag, string$3);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      debug.write (debugFlag, string$3);
    }
  }
  
  protected void quiet () throws Exception  {
// 18
    flushCell ();
  }
  
  public void addOtherCopy (JP.go.ipa.oz.user.lib_dist.replica.CopyResource_if newRes) throws Exception  {
    checkSecureInvocation ();
// 85
    JP.go.ipa.oz.lib.standard._Set_if add$val$11;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) otherCopies)) {
      try {
        add$val$11 = otherCopies.add (newRes);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$11 = otherCopies.add (newRes);
    }
  }
  
  protected void initialize () throws Exception  {
// 14
    super.initialize ();
  }
  
  public CopyOfPeerCopyScheme_cl () { super ("JP.go.ipa.oz.user.lib_dist.replica.CopyOfPeerCopyScheme_pcl"); }
  
  public CopyOfPeerCopyScheme_cl (String proxy_id) { super (proxy_id); }
  
}

