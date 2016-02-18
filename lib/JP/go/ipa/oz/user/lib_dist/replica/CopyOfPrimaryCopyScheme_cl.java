package JP.go.ipa.oz.user.lib_dist.replica;

public class CopyOfPrimaryCopyScheme_cl extends JP.go.ipa.oz.user.lib_dist.replica.CopyScheme_cl implements JP.go.ipa.oz.user.lib_dist.replica.CopyOfPrimaryCopyScheme_if {
  static final boolean _global_ = true;
  protected JP.go.ipa.oz.user.lib_dist.replica.CopyOfPrimaryCopyScheme_if primaryCopy;
  protected JP.go.ipa.oz.lib.standard._String_if primaryGOL;
  protected boolean primaryFlag;
  
  public boolean commitAll () throws Exception  {
    checkSecureInvocation ();
// 129
    boolean rc = true;
// 132
    if (primaryFlag == false) {
// 133
      return false;
    } else {
// 135
      rc = super.commitAll ();
    }
// 136
    return rc;
  }
  
  protected void initialize () throws Exception  {
// 18
    primaryFlag = true;
// 19
    primaryCopy = null;
// 20
    primaryGOL = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("")));
// 21
    super.initialize ();
  }
  
  public boolean propagateAll () throws Exception  {
    checkSecureInvocation ();
// 110
    JP.go.ipa.oz.lib.standard._String_if string$0 = (new JP.go.ipa.oz.lib.standard._String_cl("CopyOfPrimaryCopyScheme:PropagateAll() in"));
    
// 110
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
      try {
        debug.write (debugFlag, string$0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      debug.write (debugFlag, string$0);
    }
// 111
    boolean rc = true;
// 114
    if (primaryFlag == false) {
// 115
      return false;
    }
// 116
    rc = super.propagateAllCP (3);
// 117
    JP.go.ipa.oz.lib.standard._String_if string$1 = (new JP.go.ipa.oz.lib.standard._String_cl("CopyOfPrimaryCopyScheme:PropagateAll() out"));
    
// 117
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
      try {
        debug.write (debugFlag, string$1);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      debug.write (debugFlag, string$1);
    }
// 118
    return rc;
  }
  
  public JP.go.ipa.oz.user.lib_dist.replica.CopyOfPrimaryCopyScheme_if getClientStub () throws Exception  {
    checkSecureInvocation ();
// 168
    if (primaryFlag == false) {
// 169
      return null;
    }
// 171
    JP.go.ipa.oz.user.lib_dist.replica.CopyOfPrimaryCopyScheme_if minCopy = null;
// 172
    minCopy = (JP.go.ipa.oz.user.lib_dist.replica.CopyOfPrimaryCopyScheme_if) (super.getClientStubCP ());
// 173
    return minCopy;
  }
  
  public void setPrimaryGOL (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception  {
    checkSecureInvocation ();
// 208
    if (primaryFlag == true) {
// 209
      return;
    }
// 210
    primaryGOL = gol;
  }
  
  public boolean newSecondaryCopyAt (JP.go.ipa.oz.user.lib_dist.replica.CopyOfPrimaryCopyScheme_if copy, JP.go.ipa.oz.lib.standard._String_if gol) throws Exception  {
    checkSecureInvocation ();
// 38
    if (primaryFlag == false) {
// 39
      return false;
    }
// 41
    JP.go.ipa.oz.lib.standard._String_if string$2 = (new JP.go.ipa.oz.lib.standard._String_cl("CopyOfPrimaryCopyScheme:newSecondaryCopyAt() in"));
    
// 41
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
      try {
        debug.write (debugFlag, string$2);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      debug.write (debugFlag, string$2);
    }
// 42
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
      try {
        debug.write (debugFlag, gol);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      debug.write (debugFlag, gol);
    }
// 45
    if (mgrFlag == false) {{
// 46
        mgrFlag = true;
// 47
        super.setCpManeger ();
      }
    }
// 50
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) copy)) {
      try {
        copy.setPrimaryFlag (false);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      copy.setPrimaryFlag (false);
    }
// 52
    idnum++;
// 53
    if (idnum > MAX_ID) {
// 54
      idnum = 1;
    }
// 55
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) copy)) {
      try {
        copy.setTid (idnum);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      copy.setTid (idnum);
    }
// 58
    JP.go.ipa.oz.user.lib_dist.replica.CopyResource_if cpResource = null;
// 59
    cpResource = (JP.go.ipa.oz.user.lib_dist.replica.CopyResource_cl) (new JP.go.ipa.oz.user.lib_dist.replica.CopyResource_cl ())._new_create (copy, gol);
// 60
    JP.go.ipa.oz.lib.standard._Set_if add$val$0;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) otherCopies)) {
      try {
        add$val$0 = otherCopies.add (cpResource);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$0 = otherCopies.add (cpResource);
    }
// 63
    setAllPrimaryCopy (this, ownGOL);
// 65
    JP.go.ipa.oz.lib.standard._String_if string$3 = (new JP.go.ipa.oz.lib.standard._String_cl("CopyOfPrimaryCopyScheme:newSecondaryCopyAt() out"));
    
// 65
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
      try {
        debug.write (debugFlag, string$3);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      debug.write (debugFlag, string$3);
    }
// 66
    return true;
  }
  
  protected void quiet () throws Exception  {
// 25
    flushCell ();
  }
  
  public JP.go.ipa.oz.user.lib_dist.replica.CopyOfPrimaryCopyScheme_if getPrimaryCopy () throws Exception  {
    checkSecureInvocation ();
// 220
    return primaryCopy;
  }
  
  public void setPrimaryFlag (boolean flag) throws Exception  {
    checkSecureInvocation ();
// 184
    primaryFlag = flag;
  }
  
  public void setAllPrimaryCopy (JP.go.ipa.oz.user.lib_dist.replica.CopyOfPrimaryCopyScheme_if newprim) throws Exception  {
    checkSecureInvocation ();
// 250
    JP.go.ipa.oz.user.lib_dist.replica.CopyResource_if cpResource = null;
// 251
    JP.go.ipa.oz.user.lib_dist.replica.CopyOfPrimaryCopyScheme_if secondary = null;
// 252
    JP.go.ipa.oz.lib.standard._Iterator_if iterator = null;
// 253
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$1;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) otherCopies)) {
      try {
        iterator$val$1 = otherCopies.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$1 = otherCopies.iterator ();
    }
// 253
    iterator = iterator$val$1;
// 254
    while (true) {
// 254
      boolean hasMoreElements$val$2;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iterator)) {
        try {
          hasMoreElements$val$2 = iterator.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$2 = iterator.hasMoreElements ();
      }
      if (!(hasMoreElements$val$2)) break;
      
      /* body */ _loop_1: {
// 255
        JP.go.ipa.oz.lang._Root_if nextElement$val$3;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iterator)) {
          try {
            nextElement$val$3 = iterator.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$3 = iterator.nextElement ();
        }
// 255
        cpResource = (JP.go.ipa.oz.user.lib_dist.replica.CopyResource_if) (nextElement$val$3);
// 256
        JP.go.ipa.oz.user.lib_dist.replica.CopyScheme_if getCopy$val$4;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cpResource)) {
          try {
            getCopy$val$4 = cpResource.getCopy ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getCopy$val$4 = cpResource.getCopy ();
        }
// 256
        secondary = (JP.go.ipa.oz.user.lib_dist.replica.CopyOfPrimaryCopyScheme_if) (getCopy$val$4);
// 257
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) secondary)) {
          try {
            secondary.setPrimaryCopy (newprim);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          secondary.setPrimaryCopy (newprim);
        }
      }
    }
  }
  
  public void setAllPrimaryCopy (JP.go.ipa.oz.user.lib_dist.replica.CopyOfPrimaryCopyScheme_if newprim, JP.go.ipa.oz.lib.standard._String_if gol) throws Exception  {
    checkSecureInvocation ();
// 231
    JP.go.ipa.oz.user.lib_dist.replica.CopyResource_if cpResource = null;
// 232
    JP.go.ipa.oz.user.lib_dist.replica.CopyOfPrimaryCopyScheme_if secondary = null;
// 233
    JP.go.ipa.oz.lib.standard._Iterator_if iterator = null;
// 234
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$5;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) otherCopies)) {
      try {
        iterator$val$5 = otherCopies.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$5 = otherCopies.iterator ();
    }
// 234
    iterator = iterator$val$5;
// 235
    while (true) {
// 235
      boolean hasMoreElements$val$6;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iterator)) {
        try {
          hasMoreElements$val$6 = iterator.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$6 = iterator.hasMoreElements ();
      }
      if (!(hasMoreElements$val$6)) break;
      
      /* body */ _loop_1: {
// 236
        JP.go.ipa.oz.lang._Root_if nextElement$val$7;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iterator)) {
          try {
            nextElement$val$7 = iterator.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$7 = iterator.nextElement ();
        }
// 236
        cpResource = (JP.go.ipa.oz.user.lib_dist.replica.CopyResource_if) (nextElement$val$7);
// 237
        JP.go.ipa.oz.user.lib_dist.replica.CopyScheme_if getCopy$val$8;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cpResource)) {
          try {
            getCopy$val$8 = cpResource.getCopy ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getCopy$val$8 = cpResource.getCopy ();
        }
// 237
        secondary = (JP.go.ipa.oz.user.lib_dist.replica.CopyOfPrimaryCopyScheme_if) (getCopy$val$8);
// 238
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) secondary)) {
          try {
            secondary.setPrimaryCopy (newprim);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          secondary.setPrimaryCopy (newprim);
        }
// 239
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) secondary)) {
          try {
            secondary.setPrimaryGOL (gol);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          secondary.setPrimaryGOL (gol);
        }
      }
    }
  }
  
  public boolean lockAll () throws Exception  {
    checkSecureInvocation ();
// 93
    boolean rc = true;
// 95
    if (primaryFlag == false) {
// 96
      return false;
    } else {
// 98
      rc = super.lockAll ();
    }
// 99
    return rc;
  }
  
  public void primaryUpdate () throws Exception  {
    checkSecureInvocation ();
// 153
    if (primaryFlag == true) {
// 154
      return;
    }
// 155
    JP.go.ipa.oz.lib.standard._String_if string$4 = (new JP.go.ipa.oz.lib.standard._String_cl("CopyOfPrimaryCopyScheme:primaryUpdate() in"));
    
// 155
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
      try {
        debug.write (debugFlag, string$4);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      debug.write (debugFlag, string$4);
    }
// 156
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) primaryCopy)) {
      try {
        primaryCopy.update (primaryGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      primaryCopy.update (primaryGOL);
    }
// 157
    JP.go.ipa.oz.lib.standard._String_if string$5 = (new JP.go.ipa.oz.lib.standard._String_cl("CopyOfPrimaryCopyScheme:primaryUpdate() out"));
    
// 157
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
      try {
        debug.write (debugFlag, string$5);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      debug.write (debugFlag, string$5);
    }
  }
  
  protected void go () throws Exception  {
// 24
    ;
  }
  
  public void setPrimaryCopy (JP.go.ipa.oz.user.lib_dist.replica.CopyOfPrimaryCopyScheme_if cp) throws Exception  {
    checkSecureInvocation ();
// 195
    if (primaryFlag == true) {
// 196
      return;
    }
// 197
    primaryCopy = cp;
  }
  
  public void update (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception  {
    checkSecureInvocation ();
  }
  
  public boolean removeSecondaryCopyOf (JP.go.ipa.oz.lib.standard._String_if delGol) throws Exception  {
    checkSecureInvocation ();
// 77
    boolean rc = true;
// 79
    if (primaryFlag == false) {
// 80
      return false;
    }
// 81
    rc = super.removeCopyOf (delGol);
// 82
    return rc;
  }
  
  public CopyOfPrimaryCopyScheme_cl () { super ("JP.go.ipa.oz.user.lib_dist.replica.CopyOfPrimaryCopyScheme_pcl"); }
  
  public CopyOfPrimaryCopyScheme_cl (String proxy_id) { super (proxy_id); }
  
}

