package JP.go.ipa.oz.user.cda;

public class _fromExecutorRunnable_cl extends JP.go.ipa.oz.lang._Runnable_cl implements JP.go.ipa.oz.user.cda._fromExecutorRunnable_if {
  JP.go.ipa.oz.lib.standard._Socket_if client;
  JP.go.ipa.oz.user.cda._TargetCDAList_if targets;
  int RetryNum;
  JP.go.ipa.oz.user.cda._DeliveryFileCache_if cache;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._Socket_if s, JP.go.ipa.oz.user.cda._DeliveryFileCache_if c, JP.go.ipa.oz.user.cda._TargetCDAList_if t) throws Exception  {
// 56
    JP.go.ipa.oz.user.cda._CDAdebug_if debug = (JP.go.ipa.oz.user.cda._CDAdebug_cl) (new JP.go.ipa.oz.user.cda._CDAdebug_cl ())._new_create ();
// 57
    client = s;
// 58
    RetryNum = 0;
// 59
    cache = c;
// 60
    targets = t;
// 61
    JP.go.ipa.oz.lib.standard._String_if string$5 = (new JP.go.ipa.oz.lib.standard._String_cl("fromExecutorRunnable created"));
    
// 61
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
      try {
        debug.println (string$5);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      debug.println (string$5);
    }
    return this;
  }
  
  public void run () throws Exception  {
    checkSecureInvocation ();
// 66
    JP.go.ipa.oz.user.cda._CDAdebug_if debug = (JP.go.ipa.oz.user.cda._CDAdebug_cl) (new JP.go.ipa.oz.user.cda._CDAdebug_cl ())._new_create ();
// 67
    JP.go.ipa.oz.lib.standard._String_if string$6 = (new JP.go.ipa.oz.lib.standard._String_cl("fromExecutorRunnable begin"));
    
// 67
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
      try {
        debug.println (string$6);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      debug.println (string$6);
    }
// 68
    JP.go.ipa.oz.lib.standard._InputStream_if getInputStream$val$1;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) client)) {
      try {
        getInputStream$val$1 = client.getInputStream ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getInputStream$val$1 = client.getInputStream ();
    }
// 68
    JP.go.ipa.oz.lib.standard._DataInputStream_if in = (JP.go.ipa.oz.lib.standard._DataInputStream_cl) (new JP.go.ipa.oz.lib.standard._DataInputStream_cl ())._new_breed (getInputStream$val$1);
// 69
    JP.go.ipa.oz.lib.standard._String_if string$7 = (new JP.go.ipa.oz.lib.standard._String_cl("DataInputStream made"));
    
// 69
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
      try {
        debug.println (string$7);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      debug.println (string$7);
    }
// 70
    JP.go.ipa.oz.lib.standard._OutputStream_if getOutputStream$val$2;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) client)) {
      try {
        getOutputStream$val$2 = client.getOutputStream ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOutputStream$val$2 = client.getOutputStream ();
    }
// 70
    JP.go.ipa.oz.lib.standard._DataOutputStream_if out = (JP.go.ipa.oz.lib.standard._DataOutputStream_cl) (new JP.go.ipa.oz.lib.standard._DataOutputStream_cl ())._new_breed (getOutputStream$val$2);
// 71
    JP.go.ipa.oz.lib.standard._String_if string$8 = (new JP.go.ipa.oz.lib.standard._String_cl("DataOutPutStream made"));
    
// 71
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
      try {
        debug.println (string$8);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      debug.println (string$8);
    }
// 72
    JP.go.ipa.oz.lib.standard._String_if readUTF$val$3;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) in)) {
      try {
        readUTF$val$3 = in.readUTF ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      readUTF$val$3 = in.readUTF ();
    }
// 72
    JP.go.ipa.oz.lib.standard._String_if protocolTag = readUTF$val$3;
// 73
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
      try {
        debug.println (protocolTag);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      debug.println (protocolTag);
    }
// 74
    JP.go.ipa.oz.lib.standard._String_if string$9 = (new JP.go.ipa.oz.lib.standard._String_cl("REQ"));
    
// 74
    boolean isequal$val$4;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) protocolTag)) {
      try {
        isequal$val$4 = protocolTag.isequal (string$9);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$4 = protocolTag.isequal (string$9);
    }
// 74
    if (isequal$val$4) {{
// 75
        JP.go.ipa.oz.lib.standard._String_if readUTF$val$5;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) in)) {
          try {
            readUTF$val$5 = in.readUTF ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          readUTF$val$5 = in.readUTF ();
        }
// 75
        JP.go.ipa.oz.lib.standard._String_if codePath = readUTF$val$5;
// 76
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
          try {
            debug.println (codePath);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          debug.println (codePath);
        }
// 78
        JP.go.ipa.oz.user.cda._DeliveryFile_if df = null;
// 79
        JP.go.ipa.oz.user.cda._DeliveryFile_if get$val$6;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cache)) {
          try {
            get$val$6 = cache.get (codePath);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          get$val$6 = cache.get (codePath);
        }
// 79
        if ((df = get$val$6) != null) {{
// 80
            JP.go.ipa.oz.lib.standard._String_if string$10 = (new JP.go.ipa.oz.lib.standard._String_cl("already"));
            
// 80
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
              try {
                debug.println (string$10);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              debug.println (string$10);
            }
          }
        } else {{
// 82
            df = getPackageFromOtherCDA (codePath);
          }
        }
// 85
        if (df == null) {{
// 86
            JP.go.ipa.oz.lib.standard._String_if string$11 = (new JP.go.ipa.oz.lib.standard._String_cl("NA"));
            
// 86
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) out)) {
              try {
                out.writeUTF (string$11);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              out.writeUTF (string$11);
            }
// 87
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) out)) {
              try {
                out.writeUTF (codePath);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              out.writeUTF (codePath);
            }
          }
        } else {{
// 89
            JP.go.ipa.oz.lib.standard._String_if getTopPackageName$val$7;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) df)) {
              try {
                getTopPackageName$val$7 = df.getTopPackageName ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getTopPackageName$val$7 = df.getTopPackageName ();
            }
// 89
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cache)) {
              try {
                cache.put (getTopPackageName$val$7, df);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              cache.put (getTopPackageName$val$7, df);
            }
// 90
            JP.go.ipa.oz.lib.standard._String_if string$12 = (new JP.go.ipa.oz.lib.standard._String_cl("socket reply begin"));
            
// 90
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
              try {
                debug.println (string$12);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              debug.println (string$12);
            }
// 91
            JP.go.ipa.oz.lib.standard._String_if string$13 = (new JP.go.ipa.oz.lib.standard._String_cl("REP"));
            
// 91
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) out)) {
              try {
                out.writeUTF (string$13);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              out.writeUTF (string$13);
            }
// 92
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) out)) {
              try {
                out.writeUTF (codePath);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              out.writeUTF (codePath);
            }
// 93
            JP.go.ipa.oz.lib.standard._String_if getTopPackageName$val$8;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) df)) {
              try {
                getTopPackageName$val$8 = df.getTopPackageName ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getTopPackageName$val$8 = df.getTopPackageName ();
            }
// 93
            JP.go.ipa.oz.lib.standard._String_if topPackageName = getTopPackageName$val$8;
// 94
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
              try {
                debug.println (topPackageName);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              debug.println (topPackageName);
            }
// 95
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) out)) {
              try {
                out.writeUTF (topPackageName);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              out.writeUTF (topPackageName);
            }
// 96
            int getLength$val$9;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) df)) {
              try {
                getLength$val$9 = df.getLength ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getLength$val$9 = df.getLength ();
            }
// 96
            int length = getLength$val$9;
// 97
            JP.go.ipa.oz.lib.standard._Integer_if I = (JP.go.ipa.oz.lib.standard._Integer_cl) (new JP.go.ipa.oz.lib.standard._Integer_cl ())._new_breed (length);
// 97
            JP.go.ipa.oz.lib.standard._String_if asString$val$10;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) I)) {
              try {
                asString$val$10 = I.asString ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              asString$val$10 = I.asString ();
            }
// 97
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
              try {
                debug.println (asString$val$10);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              debug.println (asString$val$10);
            }
// 98
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) out)) {
              try {
                out.writeInt (length);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              out.writeInt (length);
            }
// 99
            JP.go.ipa.oz.lib.standard._ByteArray_if getContents$val$11;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) df)) {
              try {
                getContents$val$11 = df.getContents ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getContents$val$11 = df.getContents ();
            }
// 99
            JP.go.ipa.oz.lib.standard._ByteArray_if buffer = getContents$val$11;
// 100
            JP.go.ipa.oz.lib.standard._String_if string$14 = (new JP.go.ipa.oz.lib.standard._String_cl("begin buffer"));
            
// 100
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
              try {
                debug.println (string$14);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              debug.println (string$14);
            }
// 101
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) out)) {
              try {
                out.write (buffer, 0, length);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              out.write (buffer, 0, length);
            }
// 102
            JP.go.ipa.oz.lib.standard._String_if string$15 = (new JP.go.ipa.oz.lib.standard._String_cl("end buffer"));
            
// 102
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
              try {
                debug.println (string$15);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              debug.println (string$15);
            }
          }
        }
      }
    }
// 105
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) in)) {
      try {
        in.close ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      in.close ();
    }
// 106
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) out)) {
      try {
        out.close ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      out.close ();
    }
  }
  
  protected JP.go.ipa.oz.user.cda._DeliveryFile_if getPackageFromOtherCDA (JP.go.ipa.oz.lib.standard._String_if codePath) throws Exception  {
// 112
    JP.go.ipa.oz.user.cda._DeliveryFile_if df = null;
// 113
    JP.go.ipa.oz.lib.standard._String_if targetCDAGOL = null;
// 114
    df = null;
// 116
    JP.go.ipa.oz.lib.standard._String_if leaveToWhom$val$12;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targets)) {
      try {
        leaveToWhom$val$12 = targets.leaveToWhom ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      leaveToWhom$val$12 = targets.leaveToWhom ();
    }
// 116
    if ((targetCDAGOL = leaveToWhom$val$12) != null) {{
// 118
        JP.go.ipa.oz.user.cda._ClassDeliveryAgent_if targetCDA = null;
// 118
        targetCDA = new JP.go.ipa.oz.user.cda._ClassDeliveryAgent_pcl (targetCDAGOL);
// 119
        if (targetCDA != null) {
// 120
          df = targetCDA.leaveToSearchAndDelivery (codePath);
        }
      }
    } else {{
// 123
        while (true) {
// 123
          JP.go.ipa.oz.lib.standard._String_if next$val$13;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targets)) {
            try {
              next$val$13 = targets.next (RetryNum);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            next$val$13 = targets.next (RetryNum);
          }
          if (!((targetCDAGOL = next$val$13) != null)) break;
          
          /* body */ _loop_1: {
// 125
            JP.go.ipa.oz.user.cda._ClassDeliveryAgent_if targetCDA = null;
// 125
            targetCDA = new JP.go.ipa.oz.user.cda._ClassDeliveryAgent_pcl (targetCDAGOL);
// 126
            if (targetCDA != null) {{
// 128
                df = targetCDA.searchAndDelivery (codePath);
              }
            }
// 131
            if (df != null) {
// 131
              break;
            }
// 132
            RetryNum++;
          }
        }
      }
    }
// 137
    return df;
  }
  
  public _fromExecutorRunnable_cl () throws Exception { super (); }
  
}

