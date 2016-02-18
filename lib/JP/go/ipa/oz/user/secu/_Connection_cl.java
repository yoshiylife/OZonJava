package JP.go.ipa.oz.user.secu;

public class _Connection_cl extends JP.go.ipa.oz.lang._Runnable_cl implements JP.go.ipa.oz.user.secu._Conncection_if {
  JP.go.ipa.oz.lib.standard._Socket_if client;
  JP.go.ipa.oz.user.secu.OzAuthenticationServer_if as;
  int x;
  JP.go.ipa.oz.user.secu.Debug_if d;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._Socket_if client, JP.go.ipa.oz.user.secu.OzAuthenticationServer_if as) throws Exception  {
// 20
    ((JP.go.ipa.oz.user.secu._Connection_cl)this).as = as;
// 20
    ((JP.go.ipa.oz.user.secu._Connection_cl)this).client = client;
// 20
    d = (JP.go.ipa.oz.user.secu.Debug_cl) (new JP.go.ipa.oz.user.secu.Debug_cl ())._new_create ();
// 20
    int getDebug$val$0;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) as)) {
      try {
        getDebug$val$0 = as.getDebug ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getDebug$val$0 = as.getDebug ();
    }
// 20
    x = getDebug$val$0;
    return this;
  }
  
  public void run () throws Exception  {
    checkSecureInvocation ();
// 24
    JP.go.ipa.oz.user.secu.Debug_if d = (JP.go.ipa.oz.user.secu.Debug_cl) (new JP.go.ipa.oz.user.secu.Debug_cl ())._new_create ();
// 24
    int getDebug$val$1;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) as)) {
      try {
        getDebug$val$1 = as.getDebug ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getDebug$val$1 = as.getDebug ();
    }
// 24
    int x = getDebug$val$1;
// 25
    JP.go.ipa.oz.lib.standard._DataInputStream_if in = null;
// 25
    JP.go.ipa.oz.lib.standard._DataOutputStream_if out = null;
// 26
    JP.go.ipa.oz.lib.standard._String_if req = null, callerOzHome = null, calleeOzHome = null;
// 27
    JP.go.ipa.oz.lib.standard._ByteArray_if b = null;
// 28
    JP.go.ipa.oz.lib.standard._OzKey_if sessionKey = null, calleeKey = null, callerTicketKey = null, calleeTicketKey = null;
// 29
    JP.go.ipa.oz.lib.standard._Ticket_if ticket = null, calleeTicket = null;
// 30
    JP.go.ipa.oz.lib.standard._Date_if date = null, edate = null;
// 31
    long nonce = 0;
// 32
    int len = 0;
// 34
    JP.go.ipa.oz.lib.standard._InputStream_if getInputStream$val$2;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) client)) {
      try {
        getInputStream$val$2 = client.getInputStream ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getInputStream$val$2 = client.getInputStream ();
    }
// 34
    in = (JP.go.ipa.oz.lib.standard._DataInputStream_cl) (new JP.go.ipa.oz.lib.standard._DataInputStream_cl ())._new_breed (getInputStream$val$2);
// 35
    JP.go.ipa.oz.lib.standard._OutputStream_if getOutputStream$val$3;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) client)) {
      try {
        getOutputStream$val$3 = client.getOutputStream ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOutputStream$val$3 = client.getOutputStream ();
    }
// 35
    out = (JP.go.ipa.oz.lib.standard._DataOutputStream_cl) (new JP.go.ipa.oz.lib.standard._DataOutputStream_cl ())._new_breed (getOutputStream$val$3);
// 36
    while (true) {
      /* body */ _loop_1: {
// 37
        try {
// 38
          int getPort$val$4;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) client)) {
            try {
              getPort$val$4 = client.getPort ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getPort$val$4 = client.getPort ();
          }
// 38
          if (getPort$val$4 < 0) {
// 38
            break;
          }
// 39
          req = in.readUTF ();
          boolean bool$val$0;
          
// 40
          int length$val$5;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) req)) {
            try {
              length$val$5 = req.length ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            length$val$5 = req.length ();
          }
          bool$val$0 = length$val$5 < 2;
          if (!bool$val$0) {
            bool$val$0 = req == null;
          }
// 40
          if (bool$val$0) {
// 40
            break;
          }
// 41
          JP.go.ipa.oz.lib.standard._String_if string$0 = (new JP.go.ipa.oz.lib.standard._String_cl("req="));
          
// 41
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
            try {
              d.write (x, string$0, req);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            d.write (x, string$0, req);
          }
// 44
          JP.go.ipa.oz.lib.standard._String_if string$1 = (new JP.go.ipa.oz.lib.standard._String_cl("LI"));
          
// 44
          boolean isequal$val$6;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) req)) {
            try {
              isequal$val$6 = req.isequal (string$1);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            isequal$val$6 = req.isequal (string$1);
          }
// 44
          if (isequal$val$6) {{
// 45
              callerOzHome = in.readUTF ();
// 46
              b = login (callerOzHome);
// 47
              if (b == null) {{
// 48
                  JP.go.ipa.oz.lib.standard._String_if string$2 = (new JP.go.ipa.oz.lib.standard._String_cl("login fault"));
                  
// 48
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                    try {
                      d.write (x, string$2);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    d.write (x, string$2);
                  }
// 49
                  out.writeUTF ((new JP.go.ipa.oz.lib.standard._String_cl("ER")));
// 49
                  out.flush ();
// 49
                  break;
                }
              } else {{
// 51
                  out.writeUTF ((new JP.go.ipa.oz.lib.standard._String_cl("RL")));
// 52
                  int length$val$7;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) b)) {
                    try {
                      length$val$7 = b.length ();
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    length$val$7 = b.length ();
                  }
// 52
                  out.writeInt (length$val$7);
// 53
                  int length$val$8;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) b)) {
                    try {
                      length$val$8 = b.length ();
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    length$val$8 = b.length ();
                  }
// 53
                  out.write (b, 0, length$val$8);
// 54
                  out.flush ();
// 55
                  JP.go.ipa.oz.lib.standard._String_if string$3 = (new JP.go.ipa.oz.lib.standard._String_cl("--sent RL:"));
                  
// 55
                  int length$val$9;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) b)) {
                    try {
                      length$val$9 = b.length ();
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    length$val$9 = b.length ();
                  }
// 55
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                    try {
                      d.write (x, string$3, length$val$9);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    d.write (x, string$3, length$val$9);
                  }
                }
              }
            }
          } else {
// 59
            JP.go.ipa.oz.lib.standard._String_if string$4 = (new JP.go.ipa.oz.lib.standard._String_cl("GC"));
            
// 59
            boolean isequal$val$10;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) req)) {
              try {
                isequal$val$10 = req.isequal (string$4);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              isequal$val$10 = req.isequal (string$4);
            }
// 59
            if (isequal$val$10) {{
// 60
                callerOzHome = in.readUTF ();
// 60
                JP.go.ipa.oz.lib.standard._String_if string$5 = (new JP.go.ipa.oz.lib.standard._String_cl("callerOzHome="));
                
// 60
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                  try {
                    d.write (x, string$5, callerOzHome);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  d.write (x, string$5, callerOzHome);
                }
// 61
                boolean isInUsers$val$11;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) as)) {
                  try {
                    isInUsers$val$11 = as.isInUsers (callerOzHome);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  isInUsers$val$11 = as.isInUsers (callerOzHome);
                }
// 61
                if (isInUsers$val$11) {{
// 63
                    JP.go.ipa.oz.lib.standard._String_if string$6 = (new JP.go.ipa.oz.lib.standard._String_cl("callerOzHome found"));
                    
// 63
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                      try {
                        d.write (x, string$6);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      d.write (x, string$6);
                    }
// 64
                    len = in.readInt ();
// 64
                    JP.go.ipa.oz.lib.standard._String_if string$7 = (new JP.go.ipa.oz.lib.standard._String_cl("read ticket"));
                    
// 64
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                      try {
                        d.write (x, string$7, len);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      d.write (x, string$7, len);
                    }
// 65
                    b = (JP.go.ipa.oz.lib.standard._ByteArray_cl) (new JP.go.ipa.oz.lib.standard._ByteArray_cl ())._new_create (len);
// 65
                    in.readFully (b);
// 66
                    JP.go.ipa.oz.lib.standard._String_if string$8 = (new JP.go.ipa.oz.lib.standard._String_cl("got ticket:"));
                    
// 66
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                      try {
                        d.write (x, string$8, len);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      d.write (x, string$8, len);
                    }
// 67
                    date = (JP.go.ipa.oz.lib.standard._Date_cl) (new JP.go.ipa.oz.lib.standard._Date_cl ())._new_breed ();
// 67
                    JP.go.ipa.oz.lib.standard._Date_if getExDate$val$12;
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) as)) {
                      try {
                        getExDate$val$12 = as.getExDate (callerOzHome);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      getExDate$val$12 = as.getExDate (callerOzHome);
                    }
// 67
                    edate = getExDate$val$12;
// 68
                    if (edate == null) {{
// 68
                        JP.go.ipa.oz.lib.standard._String_if string$9 = (new JP.go.ipa.oz.lib.standard._String_cl("invalid date of callerOzHome"));
                        
// 68
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                          try {
                            d.write (x, string$9);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          d.write (x, string$9);
                        }
                      }
                    }
// 69
                    JP.go.ipa.oz.lib.standard._String_if string$10 = (new JP.go.ipa.oz.lib.standard._String_cl("breed"));
                    
// 69
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                      try {
                        d.write (x, string$10);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      d.write (x, string$10);
                    }
// 70
                    long getTime$val$13;
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) edate)) {
                      try {
                        getTime$val$13 = edate.getTime ();
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      getTime$val$13 = edate.getTime ();
                    }
// 70
                    if (getTime$val$13 > date.getTime ()) {{
// 71
                        JP.go.ipa.oz.lib.standard._String_if string$11 = (new JP.go.ipa.oz.lib.standard._String_cl("ticket is in time"));
                        
// 71
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                          try {
                            d.write (x, string$11);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          d.write (x, string$11);
                        }
// 72
                        JP.go.ipa.oz.lib.standard._OzKey_if getTicketKey$val$14;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) as)) {
                          try {
                            getTicketKey$val$14 = as.getTicketKey (callerOzHome);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          getTicketKey$val$14 = as.getTicketKey (callerOzHome);
                        }
// 72
                        JP.go.ipa.oz.lib.standard._OzKey_if privateKey = getTicketKey$val$14;
// 73
                        if (privateKey == null) {{
// 74
                            JP.go.ipa.oz.lib.standard._String_if string$12 = (new JP.go.ipa.oz.lib.standard._String_cl("couldn't find caller privateKey"));
                            
// 74
                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                              try {
                                d.write (x, string$12);
                              } finally {
                                changeRunningToGreen ();
                              }
                            } else {
                              d.write (x, string$12);
                            }
// 75
                            out.writeUTF ((new JP.go.ipa.oz.lib.standard._String_cl("ER")));
// 75
                            out.flush ();
// 75
                            break;
                          }
                        } else {
// 77
                          JP.go.ipa.oz.lib.standard._String_if string$13 = (new JP.go.ipa.oz.lib.standard._String_cl("got private key of "));
                          
// 77
                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                            try {
                              d.write (x, string$13, callerOzHome);
                            } finally {
                              changeRunningToGreen ();
                            }
                          } else {
                            d.write (x, string$13, callerOzHome);
                          }
                        }
// 79
                        JP.go.ipa.oz.lib.standard._CredentialRequest_if cr = JP.go.ipa.oz.lib.standard._CredentialRequest_cl._static_unpack (b, privateKey);
// 80
                        JP.go.ipa.oz.lib.standard._String_if getCalleeOzHome$val$15;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cr)) {
                          try {
                            getCalleeOzHome$val$15 = cr.getCalleeOzHome ();
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          getCalleeOzHome$val$15 = cr.getCalleeOzHome ();
                        }
// 80
                        calleeOzHome = getCalleeOzHome$val$15;
// 81
                        long getNonce$val$16;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cr)) {
                          try {
                            getNonce$val$16 = cr.getNonce ();
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          getNonce$val$16 = cr.getNonce ();
                        }
// 81
                        nonce = getNonce$val$16;
// 82
                        if (calleeOzHome == null) {{
// 83
                            JP.go.ipa.oz.lib.standard._String_if string$14 = (new JP.go.ipa.oz.lib.standard._String_cl("couldn't got calleeOzHome"));
                            
// 83
                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                              try {
                                d.write (x, string$14);
                              } finally {
                                changeRunningToGreen ();
                              }
                            } else {
                              d.write (x, string$14);
                            }
// 84
                            out.writeUTF ((new JP.go.ipa.oz.lib.standard._String_cl("ER")));
// 84
                            out.flush ();
// 84
                            break;
                          }
                        } else {
// 86
                          JP.go.ipa.oz.lib.standard._String_if string$15 = (new JP.go.ipa.oz.lib.standard._String_cl("calleeOzHome="));
                          
// 86
                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                            try {
                              d.write (x, string$15, calleeOzHome);
                            } finally {
                              changeRunningToGreen ();
                            }
                          } else {
                            d.write (x, string$15, calleeOzHome);
                          }
                        }
// 90
                        JP.go.ipa.oz.lib.standard._String_if seed = null;
// 90
                        JP.go.ipa.oz.lib.standard._String_if asString$val$17;
                        asString$val$17 = date.asString ();
// 90
                        JP.go.ipa.oz.lib.standard._String_if concat$val$18;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) callerOzHome)) {
                          try {
                            concat$val$18 = callerOzHome.concat (asString$val$17);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          concat$val$18 = callerOzHome.concat (asString$val$17);
                        }
// 90
                        seed = concat$val$18;
// 91
                        JP.go.ipa.oz.lib.standard._String_if string$16 = (new JP.go.ipa.oz.lib.standard._String_cl("session key seed="));
                        
// 91
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                          try {
                            d.write (x, string$16, seed);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          d.write (x, string$16, seed);
                        }
// 92
                        JP.go.ipa.oz.lib.standard._OzCipher_if getCipher$val$19;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) as)) {
                          try {
                            getCipher$val$19 = as.getCipher ();
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          getCipher$val$19 = as.getCipher ();
                        }
// 92
                        JP.go.ipa.oz.lib.standard._OzKey_if getKey$val$20;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getCipher$val$19)) {
                          try {
                            getKey$val$20 = getCipher$val$19.getKey (seed);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          getKey$val$20 = getCipher$val$19.getKey (seed);
                        }
// 92
                        sessionKey = getKey$val$20;
// 93
                        if (sessionKey == null) {{
// 94
                            JP.go.ipa.oz.lib.standard._String_if string$17 = (new JP.go.ipa.oz.lib.standard._String_cl("invalid sessionKey"));
                            
// 94
                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                              try {
                                d.write (x, string$17);
                              } finally {
                                changeRunningToGreen ();
                              }
                            } else {
                              d.write (x, string$17);
                            }
// 95
                            out.writeUTF ((new JP.go.ipa.oz.lib.standard._String_cl("ER")));
// 95
                            out.flush ();
// 95
                            break;
                          }
                        } else {
// 97
                          JP.go.ipa.oz.lib.standard._String_if string$18 = (new JP.go.ipa.oz.lib.standard._String_cl("got sessionKey"));
                          
// 97
                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                            try {
                              d.write (x, string$18);
                            } finally {
                              changeRunningToGreen ();
                            }
                          } else {
                            d.write (x, string$18);
                          }
                        }
// 99
                        date = (JP.go.ipa.oz.lib.standard._Date_cl) (new JP.go.ipa.oz.lib.standard._Date_cl ())._new_breed ();
// 99
                        long getTicketExTime$val$21;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) as)) {
                          try {
                            getTicketExTime$val$21 = as.getTicketExTime ();
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          getTicketExTime$val$21 = as.getTicketExTime ();
                        }
// 99
                        edate = (JP.go.ipa.oz.lib.standard._Date_cl) (new JP.go.ipa.oz.lib.standard._Date_cl ())._new_breed (date.getTime () + getTicketExTime$val$21);
// 100
                        JP.go.ipa.oz.lib.standard._String_if string$19 = (new JP.go.ipa.oz.lib.standard._String_cl("set credential edate:"));
                        
// 100
                        JP.go.ipa.oz.lib.standard._String_if asString$val$22;
                        asString$val$22 = edate.asString ();
// 100
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                          try {
                            d.write (x, string$19, asString$val$22);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          d.write (x, string$19, asString$val$22);
                        }
// 101
                        JP.go.ipa.oz.lib.standard._Credential_if c = (JP.go.ipa.oz.lib.standard._Credential_cl) (new JP.go.ipa.oz.lib.standard._Credential_cl ())._new_breed (callerOzHome, sessionKey, edate);
// 102
                        JP.go.ipa.oz.lib.standard._String_if string$20 = (new JP.go.ipa.oz.lib.standard._String_cl("breed credential"));
                        
// 102
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                          try {
                            d.write (x, string$20);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          d.write (x, string$20);
                        }
// 103
                        JP.go.ipa.oz.lib.standard._OzKey_if getTicketKey$val$23;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) as)) {
                          try {
                            getTicketKey$val$23 = as.getTicketKey (calleeOzHome);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          getTicketKey$val$23 = as.getTicketKey (calleeOzHome);
                        }
// 103
                        calleeTicketKey = getTicketKey$val$23;
// 104
                        if (calleeTicketKey == null) {{
// 105
                            JP.go.ipa.oz.lib.standard._String_if string$21 = (new JP.go.ipa.oz.lib.standard._String_cl("retry callee ticketKey"));
                            
// 105
                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                              try {
                                d.write (x, string$21);
                              } finally {
                                changeRunningToGreen ();
                              }
                            } else {
                              d.write (x, string$21);
                            }
// 106
                            login (calleeOzHome);
// 107
                            JP.go.ipa.oz.lib.standard._OzKey_if getTicketKey$val$24;
                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) as)) {
                              try {
                                getTicketKey$val$24 = as.getTicketKey (calleeOzHome);
                              } finally {
                                changeRunningToGreen ();
                              }
                            } else {
                              getTicketKey$val$24 = as.getTicketKey (calleeOzHome);
                            }
// 107
                            calleeTicketKey = getTicketKey$val$24;
// 108
                            JP.go.ipa.oz.lib.standard._String_if string$22 = (new JP.go.ipa.oz.lib.standard._String_cl("got callee ticketKey"));
                            
// 108
                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                              try {
                                d.write (x, string$22);
                              } finally {
                                changeRunningToGreen ();
                              }
                            } else {
                              d.write (x, string$22);
                            }
                          }
                        } else {
// 110
                          JP.go.ipa.oz.lib.standard._String_if string$23 = (new JP.go.ipa.oz.lib.standard._String_cl("got callee ticketKey"));
                          
// 110
                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                            try {
                              d.write (x, string$23);
                            } finally {
                              changeRunningToGreen ();
                            }
                          } else {
                            d.write (x, string$23);
                          }
                        }
// 111
                        JP.go.ipa.oz.lib.standard._ByteArray_if pack$val$25;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) c)) {
                          try {
                            pack$val$25 = c.pack (calleeTicketKey);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          pack$val$25 = c.pack (calleeTicketKey);
                        }
// 111
                        b = pack$val$25;
// 112
                        JP.go.ipa.oz.lib.standard._String_if string$24 = (new JP.go.ipa.oz.lib.standard._String_cl("credential packed"));
                        
// 112
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                          try {
                            d.write (x, string$24);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          d.write (x, string$24);
                        }
// 113
                        JP.go.ipa.oz.lib.standard._CredentialPack_if cp = (JP.go.ipa.oz.lib.standard._CredentialPack_cl) (new JP.go.ipa.oz.lib.standard._CredentialPack_cl ())._new_breed (b, nonce, sessionKey, edate);
// 114
                        JP.go.ipa.oz.lib.standard._String_if string$25 = (new JP.go.ipa.oz.lib.standard._String_cl("breed credential pack"));
                        
// 114
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                          try {
                            d.write (x, string$25);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          d.write (x, string$25);
                        }
// 115
                        JP.go.ipa.oz.lib.standard._OzKey_if getTicketKey$val$26;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) as)) {
                          try {
                            getTicketKey$val$26 = as.getTicketKey (callerOzHome);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          getTicketKey$val$26 = as.getTicketKey (callerOzHome);
                        }
// 115
                        callerTicketKey = getTicketKey$val$26;
// 116
                        if (callerTicketKey == null) {{
// 117
                            JP.go.ipa.oz.lib.standard._String_if string$26 = (new JP.go.ipa.oz.lib.standard._String_cl("retry caller ticketKey"));
                            
// 117
                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                              try {
                                d.write (x, string$26);
                              } finally {
                                changeRunningToGreen ();
                              }
                            } else {
                              d.write (x, string$26);
                            }
// 118
                            login (callerOzHome);
// 119
                            JP.go.ipa.oz.lib.standard._OzKey_if getTicketKey$val$27;
                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) as)) {
                              try {
                                getTicketKey$val$27 = as.getTicketKey (callerOzHome);
                              } finally {
                                changeRunningToGreen ();
                              }
                            } else {
                              getTicketKey$val$27 = as.getTicketKey (callerOzHome);
                            }
// 119
                            callerTicketKey = getTicketKey$val$27;
// 120
                            JP.go.ipa.oz.lib.standard._String_if string$27 = (new JP.go.ipa.oz.lib.standard._String_cl("got ticketKey callerTicketKey"));
                            
// 120
                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                              try {
                                d.write (x, string$27);
                              } finally {
                                changeRunningToGreen ();
                              }
                            } else {
                              d.write (x, string$27);
                            }
                          }
                        } else {
// 122
                          JP.go.ipa.oz.lib.standard._String_if string$28 = (new JP.go.ipa.oz.lib.standard._String_cl("got ticketKey callerTicketKey"));
                          
// 122
                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                            try {
                              d.write (x, string$28);
                            } finally {
                              changeRunningToGreen ();
                            }
                          } else {
                            d.write (x, string$28);
                          }
                        }
// 123
                        JP.go.ipa.oz.lib.standard._ByteArray_if pack$val$28;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cp)) {
                          try {
                            pack$val$28 = cp.pack (callerTicketKey);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          pack$val$28 = cp.pack (callerTicketKey);
                        }
// 123
                        b = pack$val$28;
// 124
                        JP.go.ipa.oz.lib.standard._String_if string$29 = (new JP.go.ipa.oz.lib.standard._String_cl("credentialPack packed"));
                        
// 124
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                          try {
                            d.write (x, string$29);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          d.write (x, string$29);
                        }
// 125
                        out.writeUTF ((new JP.go.ipa.oz.lib.standard._String_cl("RC")));
// 125
                        out.flush ();
// 126
                        int length$val$29;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) b)) {
                          try {
                            length$val$29 = b.length ();
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          length$val$29 = b.length ();
                        }
// 126
                        out.writeInt (length$val$29);
// 127
                        int length$val$30;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) b)) {
                          try {
                            length$val$30 = b.length ();
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          length$val$30 = b.length ();
                        }
// 127
                        out.write (b, 0, length$val$30);
// 128
                        JP.go.ipa.oz.lib.standard._String_if string$30 = (new JP.go.ipa.oz.lib.standard._String_cl("--sent RC:"));
                        
// 128
                        int length$val$31;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) b)) {
                          try {
                            length$val$31 = b.length ();
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          length$val$31 = b.length ();
                        }
// 128
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                          try {
                            d.write (x, string$30, length$val$31);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          d.write (x, string$30, length$val$31);
                        }
                      }
                    } else {{
// 130
                        JP.go.ipa.oz.lib.standard._String_if string$31 = (new JP.go.ipa.oz.lib.standard._String_cl("ticket expired"));
                        
// 130
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                          try {
                            d.write (x, string$31);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          d.write (x, string$31);
                        }
// 130
                        out.writeUTF ((new JP.go.ipa.oz.lib.standard._String_cl("ER")));
// 130
                        break;
                      }
                    }
                  }
                } else {{
// 132
                    JP.go.ipa.oz.lib.standard._String_if string$32 = (new JP.go.ipa.oz.lib.standard._String_cl("caller couldn't found"));
                    
// 132
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                      try {
                        d.write (x, string$32);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      d.write (x, string$32);
                    }
// 132
                    out.writeUTF ((new JP.go.ipa.oz.lib.standard._String_cl("ER")));
// 132
                    break;
                  }
                }
// 133
                out.flush ();
              }
            } else {
// 136
              JP.go.ipa.oz.lib.standard._String_if string$33 = (new JP.go.ipa.oz.lib.standard._String_cl("GG"));
              
// 136
              boolean isequal$val$32;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) req)) {
                try {
                  isequal$val$32 = req.isequal (string$33);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                isequal$val$32 = req.isequal (string$33);
              }
// 136
              if (isequal$val$32) {{
// 137
                  out.writeUTF ((new JP.go.ipa.oz.lib.standard._String_cl("RG")));
// 138
                  JP.go.ipa.oz.lib.standard._String_if getGOL$val$33;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) req)) {
                    try {
                      getGOL$val$33 = req.getGOL ();
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    getGOL$val$33 = req.getGOL ();
                  }
// 138
                  out.writeUTF (getGOL$val$33);
// 138
                  JP.go.ipa.oz.lib.standard._String_if string$34 = (new JP.go.ipa.oz.lib.standard._String_cl("--sent "));
                  
// 138
                  JP.go.ipa.oz.lib.standard._String_if getGOL$val$34;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) req)) {
                    try {
                      getGOL$val$34 = req.getGOL ();
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    getGOL$val$34 = req.getGOL ();
                  }
// 138
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                    try {
                      d.write (x, string$34, getGOL$val$34);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    d.write (x, string$34, getGOL$val$34);
                  }
// 139
                  out.flush ();
                }
              }
            }
          }
        }
        catch (JP.go.ipa.oz.lang.OzException _exception_1) {
          JP.go.ipa.oz.lang._Root_if _oz_exception_1 = _exception_1.getOzException ();
          if (_oz_exception_1 instanceof JP.go.ipa.oz.lib.standard._EOFException_if) {
            JP.go.ipa.oz.lib.standard._EOFException_if e = (JP.go.ipa.oz.lib.standard._EOFException_if) _oz_exception_1;
// 141
            ;
          } else if (_oz_exception_1 instanceof JP.go.ipa.oz.lib.standard._IOException_if) {
            JP.go.ipa.oz.lib.standard._IOException_if e = (JP.go.ipa.oz.lib.standard._IOException_if) _oz_exception_1;
// 144
            break;
          } else throw _exception_1;
        }
        catch (JP.go.ipa.oz.system.ExException _exception_e) {
          JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
          
// 146
          d.write ((new JP.go.ipa.oz.lib.standard._String_cl("Exception")));
// 146
          break;
        }
      }
    }
// 148
    in.close ();
// 148
    out.close ();
// 148
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) client)) {
      try {
        client.close ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      client.close ();
    }
  }
  
  JP.go.ipa.oz.lib.standard._ByteArray_if login (JP.go.ipa.oz.lib.standard._String_if ozHome) throws Exception  {
// 152
    try {
// 153
      JP.go.ipa.oz.lib.standard._Date_if date = null, edate = null;
// 154
      JP.go.ipa.oz.user.secu.User_if getUser$val$35;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) as)) {
        try {
          getUser$val$35 = as.getUser (ozHome);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getUser$val$35 = as.getUser (ozHome);
      }
// 154
      JP.go.ipa.oz.user.secu.User_if user = getUser$val$35;
// 154
      JP.go.ipa.oz.lib.standard._String_if string$35 = (new JP.go.ipa.oz.lib.standard._String_cl("ozHome="));
      
// 154
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (x, string$35, ozHome);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (x, string$35, ozHome);
      }
// 155
      if (user != null) {{
// 156
          JP.go.ipa.oz.lib.standard._String_if string$36 = (new JP.go.ipa.oz.lib.standard._String_cl("userName="));
          
// 156
          JP.go.ipa.oz.lib.standard._String_if getName$val$36;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) user)) {
            try {
              getName$val$36 = user.getName ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getName$val$36 = user.getName ();
          }
// 156
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
            try {
              d.write (x, string$36, getName$val$36);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            d.write (x, string$36, getName$val$36);
          }
// 158
          JP.go.ipa.oz.lib.standard._String_if string$37 = (new JP.go.ipa.oz.lib.standard._String_cl("making ticket"));
          
// 158
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
            try {
              d.write (x, string$37);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            d.write (x, string$37);
          }
// 160
          date = (JP.go.ipa.oz.lib.standard._Date_cl) (new JP.go.ipa.oz.lib.standard._Date_cl ())._new_breed ();
// 160
          long getTicketExTime$val$37;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) as)) {
            try {
              getTicketExTime$val$37 = as.getTicketExTime ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getTicketExTime$val$37 = as.getTicketExTime ();
          }
// 160
          edate = (JP.go.ipa.oz.lib.standard._Date_cl) (new JP.go.ipa.oz.lib.standard._Date_cl ())._new_breed (date.getTime () + getTicketExTime$val$37);
// 161
          JP.go.ipa.oz.lib.standard._String_if string$38 = (new JP.go.ipa.oz.lib.standard._String_cl("set ticket edate:"));
          
// 161
          JP.go.ipa.oz.lib.standard._String_if asString$val$38;
          asString$val$38 = edate.asString ();
// 161
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
            try {
              d.write (x, string$38, asString$val$38);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            d.write (x, string$38, asString$val$38);
          }
// 162
          JP.go.ipa.oz.lib.standard._Ticket_if ticket = (JP.go.ipa.oz.lib.standard._Ticket_cl) (new JP.go.ipa.oz.lib.standard._Ticket_cl ())._new_breed (ozHome, edate);
// 162
          JP.go.ipa.oz.lib.standard._String_if string$39 = (new JP.go.ipa.oz.lib.standard._String_cl("breed ticket"));
          
// 162
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
            try {
              d.write (x, string$39);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            d.write (x, string$39);
          }
// 163
          if (ticket == null) {{
// 163
              JP.go.ipa.oz.lib.standard._String_if string$40 = (new JP.go.ipa.oz.lib.standard._String_cl("ticket couldn't create"));
              
// 163
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                try {
                  d.write (x, string$40);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                d.write (x, string$40);
              }
// 163
              return null;
            }
          }
// 164
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) as)) {
            try {
              as.addExDate (ozHome, edate);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            as.addExDate (ozHome, edate);
          }
// 164
          JP.go.ipa.oz.lib.standard._String_if string$41 = (new JP.go.ipa.oz.lib.standard._String_cl("added ticket"));
          
// 164
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
            try {
              d.write (x, string$41);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            d.write (x, string$41);
          }
// 166
          JP.go.ipa.oz.lib.standard._OzKey_if getMyKey$val$39;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) as)) {
            try {
              getMyKey$val$39 = as.getMyKey ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getMyKey$val$39 = as.getMyKey ();
          }
// 166
          JP.go.ipa.oz.lib.standard._ByteArray_if pack$val$40;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ticket)) {
            try {
              pack$val$40 = ticket.pack (getMyKey$val$39);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            pack$val$40 = ticket.pack (getMyKey$val$39);
          }
// 166
          JP.go.ipa.oz.lib.standard._ByteArray_if b = pack$val$40;
// 167
          if (b == null) {{
// 167
              JP.go.ipa.oz.lib.standard._String_if string$42 = (new JP.go.ipa.oz.lib.standard._String_cl("pack ticket fault"));
              
// 167
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                try {
                  d.write (x, string$42);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                d.write (x, string$42);
              }
// 167
              return null;
            }
          } else {
// 168
            JP.go.ipa.oz.lib.standard._String_if string$43 = (new JP.go.ipa.oz.lib.standard._String_cl("packed"));
            
// 168
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
              try {
                d.write (x, string$43);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              d.write (x, string$43);
            }
          }
// 169
          JP.go.ipa.oz.lib.standard._OzCipher_if getCipher$val$41;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) as)) {
            try {
              getCipher$val$41 = as.getCipher ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getCipher$val$41 = as.getCipher ();
          }
// 169
          JP.go.ipa.oz.lib.standard._String_if asString$val$42;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) b)) {
            try {
              asString$val$42 = b.asString ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            asString$val$42 = b.asString ();
          }
// 169
          JP.go.ipa.oz.lib.standard._OzKey_if getKey$val$43;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getCipher$val$41)) {
            try {
              getKey$val$43 = getCipher$val$41.getKey (asString$val$42);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getKey$val$43 = getCipher$val$41.getKey (asString$val$42);
          }
// 169
          JP.go.ipa.oz.lib.standard._OzKey_if ticketKey = getKey$val$43;
// 170
          if (ticketKey == null) {{
// 170
              JP.go.ipa.oz.lib.standard._String_if string$44 = (new JP.go.ipa.oz.lib.standard._String_cl("ticket key couldn't create"));
              
// 170
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                try {
                  d.write (x, string$44);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                d.write (x, string$44);
              }
// 170
              return null;
            }
          } else {
// 171
            JP.go.ipa.oz.lib.standard._String_if string$45 = (new JP.go.ipa.oz.lib.standard._String_cl("got ticketKey"));
            
// 171
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
              try {
                d.write (x, string$45);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              d.write (x, string$45);
            }
          }
// 172
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) as)) {
            try {
              as.addTicketKey (ozHome, ticketKey);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            as.addTicketKey (ozHome, ticketKey);
          }
// 173
          JP.go.ipa.oz.lib.standard._String_if string$46 = (new JP.go.ipa.oz.lib.standard._String_cl("made ticket"));
          
// 173
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
            try {
              d.write (x, string$46);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            d.write (x, string$46);
          }
// 175
          JP.go.ipa.oz.lib.standard._TicketPack_if tp = (JP.go.ipa.oz.lib.standard._TicketPack_cl) (new JP.go.ipa.oz.lib.standard._TicketPack_cl ())._new_breed (edate, ticketKey);
// 176
          if (tp == null) {{
// 176
              JP.go.ipa.oz.lib.standard._String_if string$47 = (new JP.go.ipa.oz.lib.standard._String_cl("ticket pack fault"));
              
// 176
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                try {
                  d.write (x, string$47);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                d.write (x, string$47);
              }
// 176
              return null;
            }
          } else {
// 177
            JP.go.ipa.oz.lib.standard._OzKey_if getKey$val$44;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) as)) {
              try {
                getKey$val$44 = as.getKey (ozHome);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getKey$val$44 = as.getKey (ozHome);
            }
// 177
            JP.go.ipa.oz.lib.standard._ByteArray_if pack$val$45;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tp)) {
              try {
                pack$val$45 = tp.pack (getKey$val$44);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              pack$val$45 = tp.pack (getKey$val$44);
            }
// 177
            return pack$val$45;
          }
        }
      } else {{
// 179
          JP.go.ipa.oz.lib.standard._String_if string$48 = (new JP.go.ipa.oz.lib.standard._String_cl("user not found."));
          
// 179
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
            try {
              d.write (1, string$48);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            d.write (1, string$48);
          }
// 179
          return null;
        }
      }
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 182
      JP.go.ipa.oz.lib.standard._String_if string$49 = (new JP.go.ipa.oz.lib.standard._String_cl("exception occured whil login."));
      
// 182
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (1, string$49);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (1, string$49);
      }
// 182
      return null;
    }
  }
  
  public _Connection_cl () throws Exception { super (); }
  
}

