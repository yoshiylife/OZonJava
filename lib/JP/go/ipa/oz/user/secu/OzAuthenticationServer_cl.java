package JP.go.ipa.oz.user.secu;

public class OzAuthenticationServer_cl extends JP.go.ipa.oz.user.misc.cell.Stoppable_cl implements JP.go.ipa.oz.user.secu.OzAuthenticationServer_if {
  static final boolean _global_ = true;
  JP.go.ipa.oz.lib.standard._Set_if users;
  JP.go.ipa.oz.lib.standard._String_if userFile;
  JP.go.ipa.oz.lib.standard._OzCipher_if DEScipher;
  JP.go.ipa.oz.lib.standard._String_if myKeySeed;
  JP.go.ipa.oz.lib.standard._OzKey_if myKey;
  int x;
  JP.go.ipa.oz.lib.standard._String_if version;
  int TicketExTime;
  JP.go.ipa.oz.lib.standard._Set_if userGroups;
  JP.go.ipa.oz.user.secu.Debug_if d;
  JP.go.ipa.oz.lib.standard._OzCipher_if cipher;
  JP.go.ipa.oz.lib.standard._String_if myOzHome;
  long ticketExTime;
  int port;
  JP.go.ipa.oz.lib.standard._String_if groupFile;
  JP.go.ipa.oz.lib.standard._String_if god;
  
  public JP.go.ipa.oz.lib.standard._OzKey_if getMyKey () throws Exception  {
    checkSecureInvocation ();
// 130
    authenticateRoot ((new JP.go.ipa.oz.lib.standard._String_cl("getMyKey")));
// 131
    return myKey;
  }
  
  public JP.go.ipa.oz.lib.standard._OzCipher_if getCipher () throws Exception  {
    checkSecureInvocation ();
// 32
    return cipher;
  }
  
  public void stop () throws Exception  {
    checkSecureInvocation ();
// 116
    authenticateRoot ((new JP.go.ipa.oz.lib.standard._String_cl("stop")));
// 117
    JP.go.ipa.oz.lib.standard._String_if string$0 = (new JP.go.ipa.oz.lib.standard._String_cl("--stop--"));
    
// 117
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
      try {
        d.write (x, string$0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      d.write (x, string$0);
    }
// 118
    save (userFile, users);
// 118
    save (groupFile, userGroups);
// 119
    JP.go.ipa.oz.lib.standard._String_if string$1 = (new JP.go.ipa.oz.lib.standard._String_cl("OzAuthenticationServer stop"));
    
// 119
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
      try {
        d.write (1, string$1);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      d.write (1, string$1);
    }
// 120
    quiet ();
  }
  
  public boolean isSameGroup (JP.go.ipa.oz.lib.standard._String_if member1, JP.go.ipa.oz.lib.standard._String_if member2) throws Exception  {
    checkSecureInvocation ();
// 237
    authenticate ((new JP.go.ipa.oz.lib.standard._String_cl("isSameGroup")));
// 238
    int size$val$0;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) userGroups)) {
      try {
        size$val$0 = userGroups.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$0 = userGroups.size ();
    }
// 238
    if (size$val$0 > 0) {{
// 239
        JP.go.ipa.oz.user.secu.UserGroup_if userGroup = null;
// 240
        JP.go.ipa.oz.lib.standard._Iterator_if it = null;
// 240
        JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$1;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) userGroups)) {
          try {
            iterator$val$1 = userGroups.iterator ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          iterator$val$1 = userGroups.iterator ();
        }
// 240
        it = iterator$val$1;
// 241
        while (true) {
// 241
          boolean hasMoreElements$val$2;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
            try {
              hasMoreElements$val$2 = it.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$2 = it.hasMoreElements ();
          }
          if (!(hasMoreElements$val$2)) break;
          
          /* body */ _loop_1: {
// 242
            JP.go.ipa.oz.lang._Root_if nextElement$val$3;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
              try {
                nextElement$val$3 = it.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$3 = it.nextElement ();
            }
// 242
            userGroup = (JP.go.ipa.oz.user.secu.UserGroup_if) (nextElement$val$3);
// 243
            boolean contains$val$4;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) userGroup)) {
              try {
                contains$val$4 = userGroup.contains (member1);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              contains$val$4 = userGroup.contains (member1);
            }
// 243
            if (contains$val$4) {
// 244
              boolean contains$val$5;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) userGroup)) {
                try {
                  contains$val$5 = userGroup.contains (member2);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                contains$val$5 = userGroup.contains (member2);
              }
// 244
              if (contains$val$5) {
// 244
                return true;
              }
            }
          }
        }
      }
    }
// 247
    return false;
  }
  
  protected void initialize () throws Exception  {
// 35
    try {
// 36
      version = (new JP.go.ipa.oz.lib.standard._String_cl(" OzAuthenticationServer Ver.0.2.0"));
// 37
      d = (JP.go.ipa.oz.user.secu.Debug_cl) (new JP.go.ipa.oz.user.secu.Debug_cl ())._new_create ();
// 37
      x = 1;
// 37
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (x, version);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (x, version);
      }
// 37
      JP.go.ipa.oz.lib.standard._String_if string$2 = (new JP.go.ipa.oz.lib.standard._String_cl("as:"));
      
// 37
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.setP (string$2);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.setP (string$2);
      }
// 38
      TicketExTime = 30;
// 39
      ticketExTime = TicketExTime * 1000 * 60;
// 41
      JP.go.ipa.oz.lib.standard._System_if s = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 42
      JP.go.ipa.oz.lib.standard._Array_if args = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (3);
// 42
      JP.go.ipa.oz.lib.standard._Array_if getArguments$val$6;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s)) {
        try {
          getArguments$val$6 = s.getArguments ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getArguments$val$6 = s.getArguments ();
      }
// 42
      args = getArguments$val$6;
// 43
      JP.go.ipa.oz.lib.standard._String_if ozhome = null, sp = null, st = null;
// 44
      JP.go.ipa.oz.lang._Root_if at$val$7;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
        try {
          at$val$7 = args.at (0);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        at$val$7 = args.at (0);
      }
// 44
      ozhome = (JP.go.ipa.oz.lib.standard._String_if) (at$val$7);
// 44
      JP.go.ipa.oz.lib.standard._String_if string$3 = (new JP.go.ipa.oz.lib.standard._String_cl("ozhome="));
      
// 44
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (x, string$3, ozhome);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (x, string$3, ozhome);
      }
// 45
      JP.go.ipa.oz.lang._Root_if at$val$8;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
        try {
          at$val$8 = args.at (1);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        at$val$8 = args.at (1);
      }
// 45
      sp = (JP.go.ipa.oz.lib.standard._String_if) (at$val$8);
// 45
      JP.go.ipa.oz.lib.standard._String_if string$4 = (new JP.go.ipa.oz.lib.standard._String_cl("OS="));
      
// 45
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (x, string$4, sp);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (x, string$4, sp);
      }
// 46
      JP.go.ipa.oz.lib.standard._String_if string$5 = (new JP.go.ipa.oz.lib.standard._String_cl("unix"));
      
// 46
      boolean isequal$val$9;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sp)) {
        try {
          isequal$val$9 = sp.isequal (string$5);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isequal$val$9 = sp.isequal (string$5);
      }
// 46
      if (isequal$val$9) {
// 46
        sp = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
      } else {
// 46
        sp = (new JP.go.ipa.oz.lib.standard._String_cl("\\"));
      }
// 47
      JP.go.ipa.oz.lang._Root_if at$val$10;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
        try {
          at$val$10 = args.at (2);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        at$val$10 = args.at (2);
      }
// 47
      st = (JP.go.ipa.oz.lib.standard._String_if) (at$val$10);
// 47
      JP.go.ipa.oz.lib.standard._String_if string$6 = (new JP.go.ipa.oz.lib.standard._String_cl("d"));
      
// 47
      boolean isequal$val$11;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
        try {
          isequal$val$11 = st.isequal (string$6);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isequal$val$11 = st.isequal (string$6);
      }
// 47
      if (isequal$val$11) {
// 47
        x = 1;
      } else {
// 47
        x = 0;
      }
// 47
      JP.go.ipa.oz.lib.standard._String_if string$7 = (new JP.go.ipa.oz.lib.standard._String_cl("x="));
      
// 47
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (x, string$7, x);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (x, string$7, x);
      }
// 48
      god = (new JP.go.ipa.oz.lib.standard._String_cl(""));
// 48
      JP.go.ipa.oz.lib.standard._String_if concat$val$12;
      concat$val$12 = god.concat (ozhome);
// 48
      JP.go.ipa.oz.lib.standard._String_if concat$val$13;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$12)) {
        try {
          concat$val$13 = concat$val$12.concat (sp);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        concat$val$13 = concat$val$12.concat (sp);
      }
// 48
      JP.go.ipa.oz.lib.standard._String_if string$8 = (new JP.go.ipa.oz.lib.standard._String_cl("objects"));
      
// 48
      JP.go.ipa.oz.lib.standard._String_if concat$val$14;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$13)) {
        try {
          concat$val$14 = concat$val$13.concat (string$8);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        concat$val$14 = concat$val$13.concat (string$8);
      }
// 48
      JP.go.ipa.oz.lib.standard._String_if concat$val$15;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$14)) {
        try {
          concat$val$15 = concat$val$14.concat (sp);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        concat$val$15 = concat$val$14.concat (sp);
      }
// 48
      JP.go.ipa.oz.lib.standard._String_if getGOD$val$16;
      getGOD$val$16 = god.getGOD ();
// 48
      JP.go.ipa.oz.lib.standard._String_if concat$val$17;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$15)) {
        try {
          concat$val$17 = concat$val$15.concat (getGOD$val$16);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        concat$val$17 = concat$val$15.concat (getGOD$val$16);
      }
// 48
      JP.go.ipa.oz.lib.standard._String_if concat$val$18;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$17)) {
        try {
          concat$val$18 = concat$val$17.concat (sp);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        concat$val$18 = concat$val$17.concat (sp);
      }
// 48
      god = concat$val$18;
// 49
      JP.go.ipa.oz.lib.standard._String_if string$9 = (new JP.go.ipa.oz.lib.standard._String_cl("users"));
      
// 49
      JP.go.ipa.oz.lib.standard._String_if concat$val$19;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) god)) {
        try {
          concat$val$19 = god.concat (string$9);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        concat$val$19 = god.concat (string$9);
      }
// 49
      userFile = concat$val$19;
// 49
      JP.go.ipa.oz.lib.standard._String_if string$10 = (new JP.go.ipa.oz.lib.standard._String_cl("groups"));
      
// 49
      JP.go.ipa.oz.lib.standard._String_if concat$val$20;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) god)) {
        try {
          concat$val$20 = god.concat (string$10);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        concat$val$20 = god.concat (string$10);
      }
// 49
      groupFile = concat$val$20;
// 50
      JP.go.ipa.oz.lib.standard._String_if string$11 = (new JP.go.ipa.oz.lib.standard._String_cl("userFile="));
      
// 50
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (x, string$11, userFile);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (x, string$11, userFile);
      }
// 50
      JP.go.ipa.oz.lib.standard._String_if string$12 = (new JP.go.ipa.oz.lib.standard._String_cl("groupFile="));
      
// 50
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (x, string$12, groupFile);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (x, string$12, groupFile);
      }
// 52
      JP.go.ipa.oz.user.secu._ASProperty_if asp = (JP.go.ipa.oz.user.secu._ASProperty_cl) (new JP.go.ipa.oz.user.secu._ASProperty_cl ())._new_create (ozhome, sp);
// 53
      int getPort$val$21;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) asp)) {
        try {
          getPort$val$21 = asp.getPort ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getPort$val$21 = asp.getPort ();
      }
// 53
      port = getPort$val$21;
// 53
      JP.go.ipa.oz.lib.standard._String_if string$13 = (new JP.go.ipa.oz.lib.standard._String_cl("port="));
      
// 53
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (x, string$13, port);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (x, string$13, port);
      }
// 54
      JP.go.ipa.oz.lib.standard._String_if getCipher$val$22;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) asp)) {
        try {
          getCipher$val$22 = asp.getCipher ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getCipher$val$22 = asp.getCipher ();
      }
// 54
      JP.go.ipa.oz.lib.standard._String_if sCipher = getCipher$val$22;
// 54
      JP.go.ipa.oz.lib.standard._String_if string$14 = (new JP.go.ipa.oz.lib.standard._String_cl("cipher="));
      
// 54
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (x, string$14, sCipher);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (x, string$14, sCipher);
      }
// 55
      cipher = JP.go.ipa.oz.lib.standard._OzCipher_cl._static_getCipher (sCipher);
// 56
      DEScipher = JP.go.ipa.oz.lib.standard._OzCipher_cl._static_getCipher ((new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz.crypt.DES.OzDESCipher")));
// 58
      users = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create ();
// 58
      userGroups = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create ();
// 59
      try {
// 59
        if ((users = load (userFile)) == null) {
// 60
          users = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create ();
        }
// 60
        JP.go.ipa.oz.lib.standard._String_if string$15 = (new JP.go.ipa.oz.lib.standard._String_cl("created users"));
        
// 60
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
          try {
            d.write (1, string$15);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          d.write (1, string$15);
        }
      }
      catch (JP.go.ipa.oz.system.ExException _exception_e) {
        JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
        
// 61
        users = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create ();
// 61
        JP.go.ipa.oz.lib.standard._String_if string$16 = (new JP.go.ipa.oz.lib.standard._String_cl("created users"));
        
// 61
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
          try {
            d.write (1, string$16);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          d.write (1, string$16);
        }
      }
// 62
      try {
// 62
        if ((userGroups = load (groupFile)) == null) {
// 63
          userGroups = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create ();
        }
// 63
        JP.go.ipa.oz.lib.standard._String_if string$17 = (new JP.go.ipa.oz.lib.standard._String_cl("created userGroups"));
        
// 63
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
          try {
            d.write (1, string$17);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          d.write (1, string$17);
        }
      }
      catch (JP.go.ipa.oz.system.ExException _exception_e) {
        JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
        
// 64
        userGroups = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create ();
// 64
        JP.go.ipa.oz.lib.standard._String_if string$18 = (new JP.go.ipa.oz.lib.standard._String_cl("created userGroups"));
        
// 64
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
          try {
            d.write (1, string$18);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          d.write (1, string$18);
        }
      }
// 65
      myKeySeed = (new JP.go.ipa.oz.lib.standard._String_cl("oz.authentication.server"));
// 66
      JP.go.ipa.oz.lib.standard._OzKey_if getKey$val$23;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cipher)) {
        try {
          getKey$val$23 = cipher.getKey (myKeySeed);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getKey$val$23 = cipher.getKey (myKeySeed);
      }
// 66
      myKey = getKey$val$23;
// 67
      JP.go.ipa.oz.lib.standard._String_if getGOL$val$24;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s)) {
        try {
          getGOL$val$24 = s.getGOL ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getGOL$val$24 = s.getGOL ();
      }
// 67
      JP.go.ipa.oz.user.secu._GetOzHome_if g = (JP.go.ipa.oz.user.secu._GetOzHome_cl) (new JP.go.ipa.oz.user.secu._GetOzHome_cl ())._new_create (getGOL$val$24);
// 68
      JP.go.ipa.oz.lib.standard._String_if getOzHome$val$25;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) g)) {
        try {
          getOzHome$val$25 = g.getOzHome ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getOzHome$val$25 = g.getOzHome ();
      }
// 68
      myOzHome = getOzHome$val$25;
// 68
      JP.go.ipa.oz.lib.standard._String_if string$19 = (new JP.go.ipa.oz.lib.standard._String_cl("myOzHome="));
      
// 68
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (x, string$19, myOzHome);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (x, string$19, myOzHome);
      }
// 69
      JP.go.ipa.oz.user.secu._Password_if p = (JP.go.ipa.oz.user.secu._Password_cl) (new JP.go.ipa.oz.user.secu._Password_cl ())._new_create (ozhome, sp);
// 70
      JP.go.ipa.oz.lib.standard._String_if getPasswd$val$26;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) p)) {
        try {
          getPasswd$val$26 = p.getPasswd ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getPasswd$val$26 = p.getPasswd ();
      }
// 70
      addSelf (myOzHome, getPasswd$val$26);
// 70
      JP.go.ipa.oz.lib.standard._String_if string$20 = (new JP.go.ipa.oz.lib.standard._String_cl("passwd="));
      
// 70
      JP.go.ipa.oz.lib.standard._String_if getPasswd$val$27;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) p)) {
        try {
          getPasswd$val$27 = p.getPasswd ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getPasswd$val$27 = p.getPasswd ();
      }
// 70
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (x, string$20, getPasswd$val$27);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (x, string$20, getPasswd$val$27);
      }
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 71
      JP.go.ipa.oz.lib.standard._String_if string$21 = (new JP.go.ipa.oz.lib.standard._String_cl("exception coccured in initialize"));
      
// 71
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (1, string$21);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (1, string$21);
      }
    }
  }
  
  void addSelf (JP.go.ipa.oz.lib.standard._String_if userName, JP.go.ipa.oz.lib.standard._String_if keySeed) throws Exception  {
// 261
    JP.go.ipa.oz.lib.standard._OzKey_if getKey$val$28;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cipher)) {
      try {
        getKey$val$28 = cipher.getKey (keySeed);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getKey$val$28 = cipher.getKey (keySeed);
    }
// 261
    JP.go.ipa.oz.lib.standard._OzKey_if key = getKey$val$28;
// 262
    add (userName, key);
  }
  
  void save (JP.go.ipa.oz.lib.standard._String_if fileName, JP.go.ipa.oz.lib.standard._Set_if sets) throws Exception  {
// 446
    try {
// 447
      JP.go.ipa.oz.lib.standard._FileOutputStream_if fs = null;
// 447
      fs = (JP.go.ipa.oz.lib.standard._FileOutputStream_cl) (new JP.go.ipa.oz.lib.standard._FileOutputStream_cl ())._new_breed (fileName);
// 448
      JP.go.ipa.oz.lib.standard._ObjectOutputStream_if os = null;
// 448
      os = (JP.go.ipa.oz.lib.standard._ObjectOutputStream_cl) (new JP.go.ipa.oz.lib.standard._ObjectOutputStream_cl ())._new_breed (fs);
// 449
      os.writeObject (sets);
// 449
      os.flush ();
// 449
      fs.close ();
// 450
      JP.go.ipa.oz.lib.standard._String_if string$22 = (new JP.go.ipa.oz.lib.standard._String_cl("resource saved to "));
      
// 450
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (x, string$22, fileName);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (x, string$22, fileName);
      }
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 451
      JP.go.ipa.oz.lib.standard._String_if string$23 = (new JP.go.ipa.oz.lib.standard._String_cl("Exception occured"));
      
// 451
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (1, string$23);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (1, string$23);
      }
    }
  }
  
  public void addGroup (JP.go.ipa.oz.lib.standard._String_if groupName, JP.go.ipa.oz.lib.standard._String_if owner, JP.go.ipa.oz.lib.standard._Set_if members) throws Exception  {
    checkSecureInvocation ();
// 364
    authenticateRoot ((new JP.go.ipa.oz.lib.standard._String_cl("addGroup")));
// 365
    JP.go.ipa.oz.lib.standard._String_if string$24 = (new JP.go.ipa.oz.lib.standard._String_cl("addGroup"));
    
// 365
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
      try {
        d.write (x, string$24);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      d.write (x, string$24);
    }
// 366
    try {
// 367
      if (isInUserGroups (groupName)) {{
// 368
          JP.go.ipa.oz.user.secu.AlreadyRegisteredUserException_if e = (JP.go.ipa.oz.user.secu.AlreadyRegisteredUserException_cl) (new JP.go.ipa.oz.user.secu.AlreadyRegisteredUserException_cl ())._new_init ();
// 368
          throw new JP.go.ipa.oz.lang.OzException (e);
        }
      } else {{
// 371
          if (isInUsers (owner)) {{
// 372
              JP.go.ipa.oz.user.secu.UserGroup_if newUserGroup = (JP.go.ipa.oz.user.secu.UserGroup_cl) (new JP.go.ipa.oz.user.secu.UserGroup_cl ())._new_create (groupName, owner, members);
// 373
              JP.go.ipa.oz.lib.standard._Set_if add$val$29;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) userGroups)) {
                try {
                  add$val$29 = userGroups.add (newUserGroup);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                add$val$29 = userGroups.add (newUserGroup);
              }
            }
          } else {{
// 375
              JP.go.ipa.oz.lib.standard._String_if string$25 = (new JP.go.ipa.oz.lib.standard._String_cl("owner desn't exist in users"));
              
// 375
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                try {
                  d.write (x, string$25);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                d.write (x, string$25);
              }
// 376
              JP.go.ipa.oz.user.secu.UnknownUserException_if e = (JP.go.ipa.oz.user.secu.UnknownUserException_cl) (new JP.go.ipa.oz.user.secu.UnknownUserException_cl ())._new_init ();
// 376
              throw new JP.go.ipa.oz.lang.OzException (e);
            }
          }
        }
      }
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 379
      JP.go.ipa.oz.lib.standard._String_if string$26 = (new JP.go.ipa.oz.lib.standard._String_cl("AlreadyRegisteredUserException"));
      
// 379
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (1, string$26);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (1, string$26);
      }
    }
  }
  
  public void addUser (JP.go.ipa.oz.lib.standard._String_if userName, JP.go.ipa.oz.lib.standard._String_if keySeed) throws Exception  {
    checkSecureInvocation ();
// 265
    JP.go.ipa.oz.lib.standard._String_if string$27 = (new JP.go.ipa.oz.lib.standard._String_cl("addUser:"));
    
// 265
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
      try {
        d.write (x, string$27, userName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      d.write (x, string$27, userName);
    }
// 266
    authenticateRoot ((new JP.go.ipa.oz.lib.standard._String_cl("addUser")));
// 267
    JP.go.ipa.oz.lib.standard._OzKey_if getKey$val$30;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cipher)) {
      try {
        getKey$val$30 = cipher.getKey (keySeed);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getKey$val$30 = cipher.getKey (keySeed);
    }
// 267
    JP.go.ipa.oz.lib.standard._OzKey_if key = getKey$val$30;
// 268
    add (userName, key);
  }
  
  public void showGroupMembers (JP.go.ipa.oz.lib.standard._String_if name) throws Exception  {
    checkSecureInvocation ();
// 250
    authenticateRoot ((new JP.go.ipa.oz.lib.standard._String_cl("showGroupMembers")));
// 251
    JP.go.ipa.oz.lib.standard._String_if string$28 = (new JP.go.ipa.oz.lib.standard._String_cl("showGroupMembers:"));
    
// 251
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
      try {
        d.write (x, string$28);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      d.write (x, string$28);
    }
// 252
    int size$val$31;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) userGroups)) {
      try {
        size$val$31 = userGroups.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$31 = userGroups.size ();
    }
// 252
    if (size$val$31 > 0) {{
// 253
        JP.go.ipa.oz.user.secu.UserGroup_if group = getUserGroup (name);
// 254
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) group)) {
          try {
            group.showMembers ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          group.showMembers ();
        }
      }
    }
// 256
    JP.go.ipa.oz.lib.standard._String_if string$29 = (new JP.go.ipa.oz.lib.standard._String_cl("showGroupMembers:no groups"));
    
// 256
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
      try {
        d.write (1, string$29);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      d.write (1, string$29);
    }
  }
  
  JP.go.ipa.oz.lib.standard._Set_if load (JP.go.ipa.oz.lib.standard._String_if fileName) throws Exception  {
// 454
    try {
// 455
      JP.go.ipa.oz.lib.standard._Set_if sets = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create ();
// 456
      JP.go.ipa.oz.lib.standard._File_if f = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (userFile);
// 457
      boolean exists$val$32;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) f)) {
        try {
          exists$val$32 = f.exists ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        exists$val$32 = f.exists ();
      }
// 457
      if (exists$val$32) {{
// 458
          JP.go.ipa.oz.lib.standard._FileInputStream_if fs = null;
// 458
          fs = (JP.go.ipa.oz.lib.standard._FileInputStream_cl) (new JP.go.ipa.oz.lib.standard._FileInputStream_cl ())._new_breed (userFile);
// 459
          JP.go.ipa.oz.lib.standard._ObjectInputStream_if os = null;
// 459
          os = (JP.go.ipa.oz.lib.standard._ObjectInputStream_cl) (new JP.go.ipa.oz.lib.standard._ObjectInputStream_cl ())._new_breed (fs);
// 460
          if (os != null) {
// 460
            sets = (JP.go.ipa.oz.lib.standard._Set_if) (os.readObject ());
          }
// 460
          return sets;
        }
      } else {{
// 461
          JP.go.ipa.oz.lib.standard._String_if string$30 = (new JP.go.ipa.oz.lib.standard._String_cl(" could not find:"));
          
// 461
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
            try {
              d.write (1, string$30, fileName);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            d.write (1, string$30, fileName);
          }
// 461
          return null;
        }
      }
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_1) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_1 = _exception_1.getOzException ();
      if (_oz_exception_1 instanceof JP.go.ipa.oz.lib.standard._IOException_if) {
        JP.go.ipa.oz.lib.standard._IOException_if e = (JP.go.ipa.oz.lib.standard._IOException_if) _oz_exception_1;
// 462
        JP.go.ipa.oz.lib.standard._String_if string$31 = (new JP.go.ipa.oz.lib.standard._String_cl("IOException. cannot load."));
        
// 462
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
          try {
            d.write (1, string$31);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          d.write (1, string$31);
        }
// 462
        return null;
      } else throw _exception_1;
    }
    catch (JP.go.ipa.oz.system.ExClassNotFoundException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 464
      d.write (1, (new JP.go.ipa.oz.lib.standard._String_cl("ClassNotFoundException. cannot load")));
// 464
      return null;
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 465
      d.write (1, (new JP.go.ipa.oz.lib.standard._String_cl("Exception occured")));
// 465
      return null;
    }
  }
  
  public void showUser () throws Exception  {
    checkSecureInvocation ();
// 160
    authenticate ((new JP.go.ipa.oz.lib.standard._String_cl("showUser")));
// 161
    JP.go.ipa.oz.lib.standard._String_if string$32 = (new JP.go.ipa.oz.lib.standard._String_cl("--showUser--"));
    
// 161
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
      try {
        d.write (1, string$32);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      d.write (1, string$32);
    }
// 162
    int size$val$33;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) users)) {
      try {
        size$val$33 = users.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$33 = users.size ();
    }
// 162
    if (size$val$33 > 0) {{
// 163
        JP.go.ipa.oz.user.secu.User_if user = null;
// 164
        JP.go.ipa.oz.lib.standard._Iterator_if it = null;
// 164
        JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$34;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) users)) {
          try {
            iterator$val$34 = users.iterator ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          iterator$val$34 = users.iterator ();
        }
// 164
        it = iterator$val$34;
// 165
        while (true) {
// 165
          boolean hasMoreElements$val$35;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
            try {
              hasMoreElements$val$35 = it.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$35 = it.hasMoreElements ();
          }
          if (!(hasMoreElements$val$35)) break;
          
          /* body */ _loop_1: {
// 166
            JP.go.ipa.oz.lang._Root_if nextElement$val$36;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
              try {
                nextElement$val$36 = it.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$36 = it.nextElement ();
            }
// 166
            user = (JP.go.ipa.oz.user.secu.User_if) (nextElement$val$36);
// 167
            JP.go.ipa.oz.lib.standard._String_if getName$val$37;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) user)) {
              try {
                getName$val$37 = user.getName ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getName$val$37 = user.getName ();
            }
// 167
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
              try {
                d.write (1, getName$val$37);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              d.write (1, getName$val$37);
            }
          }
        }
      }
    }
  }
  
  public JP.go.ipa.oz.lib.standard._Date_if getExDate (JP.go.ipa.oz.lib.standard._String_if userName) throws Exception  {
    checkSecureInvocation ();
// 293
    authenticateRoot ((new JP.go.ipa.oz.lib.standard._String_cl("getExDate")));
// 294
    try {
// 295
      JP.go.ipa.oz.user.secu.User_if user = getUser (userName);
// 296
      if (user != null) {
// 297
        JP.go.ipa.oz.lib.standard._Date_if getExDate$val$38;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) user)) {
          try {
            getExDate$val$38 = user.getExDate ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getExDate$val$38 = user.getExDate ();
        }
// 297
        return getExDate$val$38;
      } else {{
// 299
          JP.go.ipa.oz.lib.standard._String_if string$33 = (new JP.go.ipa.oz.lib.standard._String_cl("Unknown User"));
          
// 299
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
            try {
              d.write (1, string$33);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            d.write (1, string$33);
          }
// 300
          JP.go.ipa.oz.user.secu.UnknownUserException_if e = (JP.go.ipa.oz.user.secu.UnknownUserException_cl) (new JP.go.ipa.oz.user.secu.UnknownUserException_cl ())._new_init ();
// 300
          throw new JP.go.ipa.oz.lang.OzException (e);
        }
      }
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 302
      return null;
    }
  }
  
  public void removeGroup (JP.go.ipa.oz.lib.standard._String_if groupName) throws Exception  {
    checkSecureInvocation ();
// 383
    authenticateRoot ((new JP.go.ipa.oz.lib.standard._String_cl("removeGroup")));
// 384
    JP.go.ipa.oz.lib.standard._String_if string$34 = (new JP.go.ipa.oz.lib.standard._String_cl("removeGroup:"));
    
// 384
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
      try {
        d.write (x, string$34, groupName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      d.write (x, string$34, groupName);
    }
// 385
    try {
// 386
      JP.go.ipa.oz.user.secu.UserGroup_if group = getUserGroup (groupName);
// 387
      if (group != null) {{
// 388
          JP.go.ipa.oz.lib.standard._Collection_if remove$val$39;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) userGroups)) {
            try {
              remove$val$39 = userGroups.remove (group);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            remove$val$39 = userGroups.remove (group);
          }
// 389
          JP.go.ipa.oz.lib.standard._String_if string$35 = (new JP.go.ipa.oz.lib.standard._String_cl("group removed:"));
          
// 389
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
            try {
              d.write (1, string$35, groupName);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            d.write (1, string$35, groupName);
          }
        }
      } else {{
// 392
          JP.go.ipa.oz.lib.standard._String_if string$36 = (new JP.go.ipa.oz.lib.standard._String_cl("UnknownUserException"));
          
// 392
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
            try {
              d.write (1, string$36);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            d.write (1, string$36);
          }
// 393
          JP.go.ipa.oz.user.secu.UnknownUserException_if e = (JP.go.ipa.oz.user.secu.UnknownUserException_cl) (new JP.go.ipa.oz.user.secu.UnknownUserException_cl ())._new_init ();
// 393
          throw new JP.go.ipa.oz.lang.OzException (e);
        }
      }
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 395
      ;
    }
  }
  
  public void addExDate (JP.go.ipa.oz.lib.standard._String_if userName, JP.go.ipa.oz.lib.standard._Date_if edate) throws Exception  {
    checkSecureInvocation ();
// 281
    authenticateRoot ((new JP.go.ipa.oz.lib.standard._String_cl("addExDate")));
// 282
    try {
// 283
      JP.go.ipa.oz.user.secu.User_if user = getUser (userName);
// 284
      if (user != null) {
// 285
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) user)) {
          try {
            user.setExDate (edate);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          user.setExDate (edate);
        }
      } else {{
// 287
          JP.go.ipa.oz.lib.standard._String_if string$37 = (new JP.go.ipa.oz.lib.standard._String_cl("Unknown User"));
          
// 287
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
            try {
              d.write (1, string$37);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            d.write (1, string$37);
          }
// 288
          JP.go.ipa.oz.user.secu.UnknownUserException_if e = (JP.go.ipa.oz.user.secu.UnknownUserException_cl) (new JP.go.ipa.oz.user.secu.UnknownUserException_cl ())._new_init ();
// 288
          throw new JP.go.ipa.oz.lang.OzException (e);
        }
      }
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 290
      ;
    }
  }
  
  public void setMyKey (JP.go.ipa.oz.lib.standard._String_if oldKeySeed, JP.go.ipa.oz.lib.standard._String_if newKeySeed) throws Exception  {
    checkSecureInvocation ();
// 104
    authenticateRoot ((new JP.go.ipa.oz.lib.standard._String_cl("setMyKey")));
// 105
    boolean isequal$val$40;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) oldKeySeed)) {
      try {
        isequal$val$40 = oldKeySeed.isequal (myKeySeed);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$40 = oldKeySeed.isequal (myKeySeed);
    }
// 105
    if (isequal$val$40) {{
// 106
        myKeySeed = newKeySeed;
// 106
        JP.go.ipa.oz.lib.standard._OzKey_if getKey$val$41;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cipher)) {
          try {
            getKey$val$41 = cipher.getKey (newKeySeed);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getKey$val$41 = cipher.getKey (newKeySeed);
        }
// 106
        myKey = getKey$val$41;
// 107
        JP.go.ipa.oz.lib.standard._String_if string$38 = (new JP.go.ipa.oz.lib.standard._String_cl("key changed"));
        
// 107
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
          try {
            d.write (1, string$38);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          d.write (1, string$38);
        }
      }
    } else {
// 108
      JP.go.ipa.oz.lib.standard._String_if string$39 = (new JP.go.ipa.oz.lib.standard._String_cl("invalid key seed,couldn't change key."));
      
// 108
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (1, string$39);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (1, string$39);
      }
    }
  }
  
  public void changeOwner (JP.go.ipa.oz.lib.standard._String_if groupName, JP.go.ipa.oz.lib.standard._String_if newOwner) throws Exception  {
    checkSecureInvocation ();
// 434
    authenticateRoot ((new JP.go.ipa.oz.lib.standard._String_cl("changOwner")));
// 435
    try {
// 436
      JP.go.ipa.oz.user.secu.UserGroup_if group = getUserGroup (groupName);
// 437
      if (group != null) {{
// 438
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) group)) {
            try {
              group.changeOwner (newOwner);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            group.changeOwner (newOwner);
          }
// 439
          JP.go.ipa.oz.lib.standard._String_if string$40 = (new JP.go.ipa.oz.lib.standard._String_cl("owner changed"));
          
// 439
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
            try {
              d.write (x, string$40);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            d.write (x, string$40);
          }
        }
      }
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 441
      ;
    }
  }
  
  public void addGroupMembers (JP.go.ipa.oz.lib.standard._String_if groupName, JP.go.ipa.oz.lib.standard._Set_if members) throws Exception  {
    checkSecureInvocation ();
// 408
    authenticateRoot ((new JP.go.ipa.oz.lib.standard._String_cl("addGroupMembers")));
// 409
    try {
// 410
      JP.go.ipa.oz.user.secu.UserGroup_if group = getUserGroup (groupName);
// 411
      if (group != null) {
// 412
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) group)) {
          try {
            group.addMembers (members);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          group.addMembers (members);
        }
      }
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 413
      ;
    }
  }
  
  public void showGroup () throws Exception  {
    checkSecureInvocation ();
// 208
    authenticateRoot ((new JP.go.ipa.oz.lib.standard._String_cl("showGroup")));
// 209
    JP.go.ipa.oz.lib.standard._String_if string$41 = (new JP.go.ipa.oz.lib.standard._String_cl("--showGroup--"));
    
// 209
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
      try {
        d.write (1, string$41);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      d.write (1, string$41);
    }
// 210
    int size$val$42;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) userGroups)) {
      try {
        size$val$42 = userGroups.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$42 = userGroups.size ();
    }
// 210
    if (size$val$42 > 0) {{
// 211
        JP.go.ipa.oz.user.secu.UserGroup_if userGroup = null;
// 212
        JP.go.ipa.oz.lib.standard._Iterator_if it = null;
// 212
        JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$43;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) userGroups)) {
          try {
            iterator$val$43 = userGroups.iterator ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          iterator$val$43 = userGroups.iterator ();
        }
// 212
        it = iterator$val$43;
// 213
        while (true) {
// 213
          boolean hasMoreElements$val$44;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
            try {
              hasMoreElements$val$44 = it.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$44 = it.hasMoreElements ();
          }
          if (!(hasMoreElements$val$44)) break;
          
          /* body */ _loop_1: {
// 214
            JP.go.ipa.oz.lang._Root_if nextElement$val$45;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
              try {
                nextElement$val$45 = it.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$45 = it.nextElement ();
            }
// 214
            userGroup = (JP.go.ipa.oz.user.secu.UserGroup_if) (nextElement$val$45);
// 215
            JP.go.ipa.oz.lib.standard._String_if string$42 = (new JP.go.ipa.oz.lib.standard._String_cl("Group:"));
            
// 215
            JP.go.ipa.oz.lib.standard._String_if getName$val$46;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) userGroup)) {
              try {
                getName$val$46 = userGroup.getName ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getName$val$46 = userGroup.getName ();
            }
// 215
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
              try {
                d.write (x, string$42, getName$val$46);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              d.write (x, string$42, getName$val$46);
            }
// 216
            JP.go.ipa.oz.lib.standard._String_if getName$val$47;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) userGroup)) {
              try {
                getName$val$47 = userGroup.getName ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getName$val$47 = userGroup.getName ();
            }
// 216
            showGroupMembers (getName$val$47);
          }
        }
      }
    }
  }
  
  public int getDebug () throws Exception  {
    checkSecureInvocation ();
// 127
    return x;
  }
  
  public void authenticateRoot (JP.go.ipa.oz.lib.standard._String_if s) throws Exception  {
    checkSecureInvocation ();
// 83
    JP.go.ipa.oz.lib.standard._String_if caller = JP.go.ipa.oz.lib.standard._OzCipher_cl._static_getCallerOzHome ();
// 84
    boolean isequal$val$48;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) myOzHome)) {
      try {
        isequal$val$48 = myOzHome.isequal (caller);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$48 = myOzHome.isequal (caller);
    }
// 84
    if (!isequal$val$48) {{
// 85
        JP.go.ipa.oz.lib.standard._String_if string$43 = (new JP.go.ipa.oz.lib.standard._String_cl("UnknownRoot:"));
        
// 85
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
          try {
            d.write (x, string$43, caller, s);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          d.write (x, string$43, caller, s);
        }
// 86
        JP.go.ipa.oz.user.secu.UnknownUserException_if e = (JP.go.ipa.oz.user.secu.UnknownUserException_cl) (new JP.go.ipa.oz.user.secu.UnknownUserException_cl ())._new_init ();
// 86
        throw new JP.go.ipa.oz.lang.OzException (e);
      }
    } else {
// 88
      JP.go.ipa.oz.lib.standard._String_if string$44 = (new JP.go.ipa.oz.lib.standard._String_cl("Root authorized:"));
      
// 88
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (x, string$44, caller, s);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (x, string$44, caller, s);
      }
    }
  }
  
  public JP.go.ipa.oz.lib.standard._OzKey_if getKey (JP.go.ipa.oz.lib.standard._String_if ozhomeID) throws Exception  {
    checkSecureInvocation ();
// 137
    authenticateRoot ((new JP.go.ipa.oz.lib.standard._String_cl("getKey")));
// 139
    JP.go.ipa.oz.user.secu.User_if user = getUser (ozhomeID);
// 140
    if (user != null) {
// 140
      JP.go.ipa.oz.lib.standard._OzKey_if getKey$val$49;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) user)) {
        try {
          getKey$val$49 = user.getKey ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getKey$val$49 = user.getKey ();
      }
// 140
      return getKey$val$49;
    } else {
// 141
      return null;
    }
  }
  
  public boolean isInUsers (JP.go.ipa.oz.lib.standard._String_if name) throws Exception  {
    checkSecureInvocation ();
// 188
    authenticate ((new JP.go.ipa.oz.lib.standard._String_cl("isInUsers")));
// 189
    if (getUser (name) == null) {
// 189
      return false;
    } else {
// 190
      return true;
    }
  }
  
  public boolean isInUserGroups (JP.go.ipa.oz.lib.standard._String_if name) throws Exception  {
    checkSecureInvocation ();
// 221
    authenticate ((new JP.go.ipa.oz.lib.standard._String_cl("isInUserGroup")));
// 223
    if (getUserGroup (name) == null) {
// 223
      return false;
    } else {
// 224
      return true;
    }
  }
  
  public boolean isAuthenticated (JP.go.ipa.oz.lib.standard._String_if ozhomeID, JP.go.ipa.oz.lib.standard._OzKey_if ticketKey) throws Exception  {
    checkSecureInvocation ();
// 145
    authenticateRoot ((new JP.go.ipa.oz.lib.standard._String_cl("isAuth")));
// 146
    JP.go.ipa.oz.user.secu.User_if user = getUser (ozhomeID);
// 148
    JP.go.ipa.oz.lib.standard._OzKey_if getTicketKey$val$50;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) user)) {
      try {
        getTicketKey$val$50 = user.getTicketKey ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getTicketKey$val$50 = user.getTicketKey ();
    }
// 148
    if (getTicketKey$val$50 == ticketKey) {
// 148
      return true;
    } else {
// 149
      return false;
    }
  }
  
  public long getTicketExTime () throws Exception  {
    checkSecureInvocation ();
// 31
    return ticketExTime;
  }
  
  public void authenticate (JP.go.ipa.oz.lib.standard._String_if s) throws Exception  {
    checkSecureInvocation ();
// 94
    JP.go.ipa.oz.lib.standard._String_if caller = JP.go.ipa.oz.lib.standard._OzCipher_cl._static_getCallerOzHome ();
// 95
    boolean isequal$val$51;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) myOzHome)) {
      try {
        isequal$val$51 = myOzHome.isequal (caller);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$51 = myOzHome.isequal (caller);
    }
// 95
    if (!isequal$val$51) {{
// 96
        if (!isInUsers (caller)) {{
// 97
            JP.go.ipa.oz.lib.standard._String_if string$45 = (new JP.go.ipa.oz.lib.standard._String_cl("UnknownUser:"));
            
// 97
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
              try {
                d.write (x, string$45, caller, s);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              d.write (x, string$45, caller, s);
            }
// 98
            JP.go.ipa.oz.user.secu.UnknownUserException_if e = (JP.go.ipa.oz.user.secu.UnknownUserException_cl) (new JP.go.ipa.oz.user.secu.UnknownUserException_cl ())._new_init ();
// 98
            throw new JP.go.ipa.oz.lang.OzException (e);
          }
        }
      }
    } else {
// 100
      JP.go.ipa.oz.lib.standard._String_if string$46 = (new JP.go.ipa.oz.lib.standard._String_cl("authorized:"));
      
// 100
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (x, string$46, caller, s);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (x, string$46, caller, s);
      }
    }
  }
  
  public boolean isInGroupMembers (JP.go.ipa.oz.lib.standard._String_if groupName, JP.go.ipa.oz.lib.standard._String_if member) throws Exception  {
    checkSecureInvocation ();
// 227
    authenticate ((new JP.go.ipa.oz.lib.standard._String_cl("isInGroupMembers")));
// 228
    int size$val$52;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) userGroups)) {
      try {
        size$val$52 = userGroups.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$52 = userGroups.size ();
    }
// 228
    if (size$val$52 > 0) {{
// 229
        JP.go.ipa.oz.user.secu.UserGroup_if group = getUserGroup (groupName);
// 230
        if (group != null) {
// 231
          boolean contains$val$53;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) group)) {
            try {
              contains$val$53 = group.contains (member);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            contains$val$53 = group.contains (member);
          }
// 231
          return contains$val$53;
        }
      }
    }
// 233
    return false;
  }
  
  public JP.go.ipa.oz.user.secu.User_if getUser (JP.go.ipa.oz.lib.standard._String_if name) throws Exception  {
    checkSecureInvocation ();
// 172
    authenticate ((new JP.go.ipa.oz.lib.standard._String_cl("getUser")));
// 173
    int size$val$54;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) users)) {
      try {
        size$val$54 = users.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$54 = users.size ();
    }
// 173
    if (size$val$54 > 0) {{
// 174
        JP.go.ipa.oz.user.secu.User_if user = null;
// 175
        JP.go.ipa.oz.lib.standard._Iterator_if it = null;
// 175
        JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$55;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) users)) {
          try {
            iterator$val$55 = users.iterator ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          iterator$val$55 = users.iterator ();
        }
// 175
        it = iterator$val$55;
// 176
        while (true) {
// 176
          boolean hasMoreElements$val$56;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
            try {
              hasMoreElements$val$56 = it.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$56 = it.hasMoreElements ();
          }
          if (!(hasMoreElements$val$56)) break;
          
          /* body */ _loop_1: {
// 177
            JP.go.ipa.oz.lang._Root_if nextElement$val$57;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
              try {
                nextElement$val$57 = it.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$57 = it.nextElement ();
            }
// 177
            user = (JP.go.ipa.oz.user.secu.User_if) (nextElement$val$57);
// 179
            JP.go.ipa.oz.lib.standard._String_if getName$val$58;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) user)) {
              try {
                getName$val$58 = user.getName ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getName$val$58 = user.getName ();
            }
// 179
            boolean isequal$val$59;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) name)) {
              try {
                isequal$val$59 = name.isequal (getName$val$58);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              isequal$val$59 = name.isequal (getName$val$58);
            }
// 179
            if (isequal$val$59) {{
// 181
                return user;
              }
            }
          }
        }
      }
    }
// 185
    return null;
  }
  
  public JP.go.ipa.oz.lib.standard._OzKey_if createKey (JP.go.ipa.oz.lib.standard._String_if str) throws Exception  {
    checkSecureInvocation ();
// 134
    JP.go.ipa.oz.lib.standard._OzKey_if getKey$val$60;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cipher)) {
      try {
        getKey$val$60 = cipher.getKey (str);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getKey$val$60 = cipher.getKey (str);
    }
// 134
    return getKey$val$60;
  }
  
  protected final void quiet () throws Exception  {
// 113
    flushCell ();
// 113
    stopCell ();
  }
  
  void server (int port, JP.go.ipa.oz.user.secu.OzAuthenticationServer_if as) throws Exception  {
// 124
    JP.go.ipa.oz.user.secu.Server_if server = (JP.go.ipa.oz.user.secu.Server_cl) (new JP.go.ipa.oz.user.secu.Server_cl ())._new_create (port, as);
// 124
    JP.go.ipa.oz.lang._Thread_if t = (JP.go.ipa.oz.lang._Thread_cl) (new JP.go.ipa.oz.lang._Thread_cl ())._new_create (server);
  }
  
  public void removeGroupMembers (JP.go.ipa.oz.lib.standard._String_if groupName, JP.go.ipa.oz.lib.standard._Set_if members) throws Exception  {
    checkSecureInvocation ();
// 424
    authenticateRoot ((new JP.go.ipa.oz.lib.standard._String_cl("removeGroupMembers")));
// 425
    try {
// 426
      JP.go.ipa.oz.user.secu.UserGroup_if group = getUserGroup (groupName);
// 427
      if (group != null) {{
// 428
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) group)) {
            try {
              group.removeMembers (members);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            group.removeMembers (members);
          }
// 429
          JP.go.ipa.oz.lib.standard._String_if string$47 = (new JP.go.ipa.oz.lib.standard._String_cl("members removed in group:"));
          
// 429
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
            try {
              d.write (x, string$47, groupName);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            d.write (x, string$47, groupName);
          }
        }
      }
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 431
      ;
    }
  }
  
  public void removeGroupMember (JP.go.ipa.oz.lib.standard._String_if groupName, JP.go.ipa.oz.lib.standard._String_if member) throws Exception  {
    checkSecureInvocation ();
// 416
    authenticateRoot ((new JP.go.ipa.oz.lib.standard._String_cl("removeGroupMember")));
// 417
    try {
// 418
      JP.go.ipa.oz.user.secu.UserGroup_if group = getUserGroup (groupName);
// 419
      if (group != null) {
// 420
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) group)) {
          try {
            group.removeMember (member);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          group.removeMember (member);
        }
      }
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 421
      ;
    }
  }
  
  public JP.go.ipa.oz.user.secu.UserGroup_if getUserGroup (JP.go.ipa.oz.lib.standard._String_if name) throws Exception  {
    checkSecureInvocation ();
// 193
    authenticate ((new JP.go.ipa.oz.lib.standard._String_cl("getUserGroup")));
// 195
    int size$val$61;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) userGroups)) {
      try {
        size$val$61 = userGroups.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$61 = userGroups.size ();
    }
// 195
    if (size$val$61 > 0) {{
// 196
        JP.go.ipa.oz.user.secu.UserGroup_if userGroup = null;
// 197
        JP.go.ipa.oz.lib.standard._Iterator_if it = null;
// 197
        JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$62;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) userGroups)) {
          try {
            iterator$val$62 = userGroups.iterator ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          iterator$val$62 = userGroups.iterator ();
        }
// 197
        it = iterator$val$62;
// 198
        while (true) {
// 198
          boolean hasMoreElements$val$63;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
            try {
              hasMoreElements$val$63 = it.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$63 = it.hasMoreElements ();
          }
          if (!(hasMoreElements$val$63)) break;
          
          /* body */ _loop_1: {
// 199
            JP.go.ipa.oz.lang._Root_if nextElement$val$64;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
              try {
                nextElement$val$64 = it.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$64 = it.nextElement ();
            }
// 199
            userGroup = (JP.go.ipa.oz.user.secu.UserGroup_if) (nextElement$val$64);
// 201
            JP.go.ipa.oz.lib.standard._String_if getName$val$65;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) userGroup)) {
              try {
                getName$val$65 = userGroup.getName ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getName$val$65 = userGroup.getName ();
            }
// 201
            boolean isequal$val$66;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) name)) {
              try {
                isequal$val$66 = name.isequal (getName$val$65);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              isequal$val$66 = name.isequal (getName$val$65);
            }
// 201
            if (isequal$val$66) {
// 202
              return userGroup;
            }
          }
        }
      }
    }
// 205
    return null;
  }
  
  public void addGroupMember (JP.go.ipa.oz.lib.standard._String_if groupName, JP.go.ipa.oz.lib.standard._String_if member) throws Exception  {
    checkSecureInvocation ();
// 398
    authenticateRoot ((new JP.go.ipa.oz.lib.standard._String_cl("addGroupMember")));
// 399
    try {
// 400
      JP.go.ipa.oz.user.secu.UserGroup_if group = getUserGroup (groupName);
// 401
      if (group != null) {{
// 402
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) group)) {
            try {
              group.addMember (member);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            group.addMember (member);
          }
// 403
          JP.go.ipa.oz.lib.standard._String_if string$48 = (new JP.go.ipa.oz.lib.standard._String_cl("added"));
          
// 403
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
            try {
              d.write (1, string$48, member);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            d.write (1, string$48, member);
          }
        }
      }
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 405
      ;
    }
  }
  
  public JP.go.ipa.oz.lib.standard._OzKey_if getTicketKey (JP.go.ipa.oz.lib.standard._String_if name) throws Exception  {
    checkSecureInvocation ();
// 153
    authenticateRoot ((new JP.go.ipa.oz.lib.standard._String_cl("getTK")));
// 154
    JP.go.ipa.oz.user.secu.User_if user = getUser (name);
// 155
    if (user != null) {
// 155
      JP.go.ipa.oz.lib.standard._OzKey_if getTicketKey$val$67;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) user)) {
        try {
          getTicketKey$val$67 = user.getTicketKey ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getTicketKey$val$67 = user.getTicketKey ();
      }
// 155
      return getTicketKey$val$67;
    } else {
// 156
      return null;
    }
  }
  
  public JP.go.ipa.oz.lib.standard._OzKey_if changeKey (JP.go.ipa.oz.lib.standard._String_if userName, JP.go.ipa.oz.lib.standard._OzKey_if newKey) throws Exception  {
    checkSecureInvocation ();
// 346
    authenticateRoot ((new JP.go.ipa.oz.lib.standard._String_cl("changeKey2")));
// 347
    try {
// 348
      JP.go.ipa.oz.user.secu.User_if user = getUser (userName);
// 349
      if (user != null) {{
// 350
          JP.go.ipa.oz.lib.standard._OzKey_if getKey$val$68;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) user)) {
            try {
              getKey$val$68 = user.getKey ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getKey$val$68 = user.getKey ();
          }
// 350
          JP.go.ipa.oz.lib.standard._OzKey_if oldKey = getKey$val$68;
// 351
          JP.go.ipa.oz.lib.standard._Collection_if remove$val$69;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) users)) {
            try {
              remove$val$69 = users.remove (user);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            remove$val$69 = users.remove (user);
          }
// 351
          users = (JP.go.ipa.oz.lib.standard._Set_if) (remove$val$69);
// 352
          JP.go.ipa.oz.user.secu.User_if newUser = (JP.go.ipa.oz.user.secu.User_cl) (new JP.go.ipa.oz.user.secu.User_cl ())._new_create (userName, newKey);
// 353
          JP.go.ipa.oz.lib.standard._Set_if add$val$70;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) users)) {
            try {
              add$val$70 = users.add (newUser);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            add$val$70 = users.add (newUser);
          }
// 354
          JP.go.ipa.oz.lib.standard._String_if string$49 = (new JP.go.ipa.oz.lib.standard._String_cl("keyChanged"));
          
// 354
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
            try {
              d.write (x, string$49);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            d.write (x, string$49);
          }
// 355
          return oldKey;
        }
      } else {{
// 357
          JP.go.ipa.oz.user.secu.UnknownUserException_if e = (JP.go.ipa.oz.user.secu.UnknownUserException_cl) (new JP.go.ipa.oz.user.secu.UnknownUserException_cl ())._new_init ();
// 357
          throw new JP.go.ipa.oz.lang.OzException (e);
        }
      }
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 359
      return null;
    }
  }
  
  public JP.go.ipa.oz.lib.standard._OzKey_if changeKey (JP.go.ipa.oz.lib.standard._String_if userName, JP.go.ipa.oz.lib.standard._String_if keySeed) throws Exception  {
    checkSecureInvocation ();
// 341
    authenticateRoot ((new JP.go.ipa.oz.lib.standard._String_cl("changeKey")));
// 342
    JP.go.ipa.oz.lib.standard._OzKey_if getKey$val$71;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cipher)) {
      try {
        getKey$val$71 = cipher.getKey (keySeed);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getKey$val$71 = cipher.getKey (keySeed);
    }
// 342
    JP.go.ipa.oz.lib.standard._OzKey_if key = getKey$val$71;
// 343
    return changeKey (userName, key);
  }
  
  protected void go () throws Exception  {
// 74
    try {
// 75
      JP.go.ipa.oz.lib.standard._String_if string$50 = (new JP.go.ipa.oz.lib.standard._String_cl("OzAuthenticationServer start"));
      
// 75
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (1, string$50);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (1, string$50);
      }
// 76
      server (port, this);
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 77
      ;
    }
  }
  
  public void remove (JP.go.ipa.oz.lib.standard._String_if userName) throws Exception  {
    checkSecureInvocation ();
// 317
    authenticateRoot ((new JP.go.ipa.oz.lib.standard._String_cl("remove")));
// 318
    JP.go.ipa.oz.lib.standard._String_if string$51 = (new JP.go.ipa.oz.lib.standard._String_cl("remove:"));
    
// 318
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
      try {
        d.write (x, string$51, userName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      d.write (x, string$51, userName);
    }
// 319
    try {
// 320
      JP.go.ipa.oz.user.secu.User_if user = getUser (userName);
// 321
      if (user != null) {{
// 322
          JP.go.ipa.oz.lib.standard._Collection_if remove$val$72;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) users)) {
            try {
              remove$val$72 = users.remove (user);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            remove$val$72 = users.remove (user);
          }
// 322
          users = (JP.go.ipa.oz.lib.standard._Set_if) (remove$val$72);
// 322
          JP.go.ipa.oz.lib.standard._String_if string$52 = (new JP.go.ipa.oz.lib.standard._String_cl("removed:"));
          
// 322
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
            try {
              d.write (1, string$52, userName);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            d.write (1, string$52, userName);
          }
// 324
          JP.go.ipa.oz.lib.standard._Iterator_if it = null;
// 324
          JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$73;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) userGroups)) {
            try {
              iterator$val$73 = userGroups.iterator ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            iterator$val$73 = userGroups.iterator ();
          }
// 324
          it = iterator$val$73;
// 325
          JP.go.ipa.oz.user.secu.UserGroup_if group = null;
// 326
          while (true) {
// 326
            boolean hasMoreElements$val$74;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
              try {
                hasMoreElements$val$74 = it.hasMoreElements ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              hasMoreElements$val$74 = it.hasMoreElements ();
            }
            if (!(hasMoreElements$val$74)) break;
            
            /* body */ _loop_1: {
// 327
              JP.go.ipa.oz.lang._Root_if nextElement$val$75;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
                try {
                  nextElement$val$75 = it.nextElement ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                nextElement$val$75 = it.nextElement ();
              }
// 327
              group = (JP.go.ipa.oz.user.secu.UserGroup_if) (nextElement$val$75);
// 328
              boolean contains$val$76;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) group)) {
                try {
                  contains$val$76 = group.contains (userName);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                contains$val$76 = group.contains (userName);
              }
// 328
              if (contains$val$76) {{
// 329
                  JP.go.ipa.oz.lib.standard._String_if string$53 = (new JP.go.ipa.oz.lib.standard._String_cl("userName found"));
                  
// 329
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                    try {
                      d.write (x, string$53);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    d.write (x, string$53);
                  }
// 330
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) group)) {
                    try {
                      group.removeMember (userName);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    group.removeMember (userName);
                  }
                }
              }
            }
          }
        }
      } else {{
// 334
          JP.go.ipa.oz.lib.standard._String_if string$54 = (new JP.go.ipa.oz.lib.standard._String_cl("UnknownUser"));
          
// 334
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
            try {
              d.write (1, string$54);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            d.write (1, string$54);
          }
// 335
          JP.go.ipa.oz.user.secu.UnknownUserException_if e = (JP.go.ipa.oz.user.secu.UnknownUserException_cl) (new JP.go.ipa.oz.user.secu.UnknownUserException_cl ())._new_init ();
// 335
          throw new JP.go.ipa.oz.lang.OzException (e);
        }
      }
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 338
      ;
    }
  }
  
  void add (JP.go.ipa.oz.lib.standard._String_if userName, JP.go.ipa.oz.lib.standard._OzKey_if key) throws Exception  {
// 271
    try {
// 272
      if (isInUsers (userName)) {{
// 273
          JP.go.ipa.oz.user.secu.AlreadyRegisteredUserException_if e = (JP.go.ipa.oz.user.secu.AlreadyRegisteredUserException_cl) (new JP.go.ipa.oz.user.secu.AlreadyRegisteredUserException_cl ())._new_init ();
// 273
          throw new JP.go.ipa.oz.lang.OzException (e);
        }
      }
// 275
      JP.go.ipa.oz.user.secu.User_if newUser = (JP.go.ipa.oz.user.secu.User_cl) (new JP.go.ipa.oz.user.secu.User_cl ())._new_create (userName, key);
// 276
      JP.go.ipa.oz.lib.standard._Set_if add$val$77;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) users)) {
        try {
          add$val$77 = users.add (newUser);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        add$val$77 = users.add (newUser);
      }
// 277
      JP.go.ipa.oz.lib.standard._String_if string$55 = (new JP.go.ipa.oz.lib.standard._String_cl("added:"));
      
// 277
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (1, string$55, userName);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (1, string$55, userName);
      }
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 278
      ;
    }
  }
  
  public void addTicketKey (JP.go.ipa.oz.lib.standard._String_if userName, JP.go.ipa.oz.lib.standard._OzKey_if ticketKey) throws Exception  {
    checkSecureInvocation ();
// 305
    authenticateRoot ((new JP.go.ipa.oz.lib.standard._String_cl("addTicketKey")));
// 306
    try {
// 307
      JP.go.ipa.oz.user.secu.User_if user = getUser (userName);
// 308
      if (user != null) {
// 309
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) user)) {
          try {
            user.setTicketKey (ticketKey);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          user.setTicketKey (ticketKey);
        }
      } else {{
// 311
          JP.go.ipa.oz.lib.standard._String_if string$56 = (new JP.go.ipa.oz.lib.standard._String_cl("Unknown User"));
          
// 311
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
            try {
              d.write (1, string$56);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            d.write (1, string$56);
          }
// 312
          JP.go.ipa.oz.user.secu.UnknownUserException_if e = (JP.go.ipa.oz.user.secu.UnknownUserException_cl) (new JP.go.ipa.oz.user.secu.UnknownUserException_cl ())._new_init ();
// 312
          throw new JP.go.ipa.oz.lang.OzException (e);
        }
      }
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 314
      ;
    }
  }
  
  public void setTicketExTime (int time) throws Exception  {
    checkSecureInvocation ();
// 111
    ticketExTime = time * 1000 * 60;
  }
  
  public OzAuthenticationServer_cl () { super ("JP.go.ipa.oz.user.secu.OzAuthenticationServer_pcl"); }
  
  public OzAuthenticationServer_cl (String proxy_id) { super (proxy_id); }
  
}

