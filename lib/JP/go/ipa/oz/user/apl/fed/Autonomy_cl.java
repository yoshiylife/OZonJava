package JP.go.ipa.oz.user.apl.fed;

public class Autonomy_cl extends JP.go.ipa.oz.user.apl.fed.GenusCategory_cl implements JP.go.ipa.oz.user.apl.fed.Autonomy_if {
  static final boolean _global_ = true;
  protected JP.go.ipa.oz.lib.standard._Set_if cache;
  protected JP.go.ipa.oz.lib.standard._Set_if adapterPivots;
  protected JP.go.ipa.oz.lib.standard._Set_if proxies;
  protected JP.go.ipa.oz.lib.standard._Set_if surrogatePivots;
  protected JP.go.ipa.oz.lib.standard._Set_if adapters;
  protected JP.go.ipa.oz.lib.standard._Set_if federates;
  protected JP.go.ipa.oz.lib.standard._Dictionary_if resources;
  protected JP.go.ipa.oz.lib.standard._Set_if surrogates;
  
  public void setResourceProxyToCache (JP.go.ipa.oz.user.apl.fed.ResourceProxy_if proxy) throws Exception  {
    checkSecureInvocation ();
// 467
    boolean isRed$val$44;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) proxy)) {
      try {
        isRed$val$44 = proxy.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$44 = proxy.isRed ();
    }
// 467
    if (isRed$val$44) {
// 467
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auth)) {
        try {
          auth.authorize (proxy);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        auth.authorize (proxy);
      }
    }
// 468
    if (debug) {
// 468
      JP.go.ipa.oz.lib.standard._String_if string$16 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#setResourceProxyToCache() enter"));
      
// 468
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$16);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$16);
      }
    }
// 469
    JP.go.ipa.oz.lib.standard._Set_if add$val$45;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cache)) {
      try {
        add$val$45 = cache.add (proxy);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$45 = cache.add (proxy);
    }
// 470
    if (debug) {{
// 471
        JP.go.ipa.oz.lib.standard._String_if string$17 = (new JP.go.ipa.oz.lib.standard._String_cl("----- Autonomy#setResourceProxyToCache()"));
        
// 471
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.println (string$17);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.println (string$17);
        }
// 472
        JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$46;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cache)) {
          try {
            iterator$val$46 = cache.iterator ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          iterator$val$46 = cache.iterator ();
        }
// 472
        JP.go.ipa.oz.lib.standard._Iterator_if it = iterator$val$46;
// 473
        while (true) {
// 473
          boolean hasMoreElements$val$47;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
            try {
              hasMoreElements$val$47 = it.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$47 = it.hasMoreElements ();
          }
          if (!(hasMoreElements$val$47)) break;
          
          /* body */ _loop_1: {
// 474
            JP.go.ipa.oz.lang._Root_if nextElement$val$48;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
              try {
                nextElement$val$48 = it.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$48 = it.nextElement ();
            }
// 474
            JP.go.ipa.oz.lang._Root_if element = nextElement$val$48;
// 475
            JP.go.ipa.oz.lib.standard._String_if asString$val$49;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) element)) {
              try {
                asString$val$49 = element.asString ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              asString$val$49 = element.asString ();
            }
// 475
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
              try {
                system.println (asString$val$49);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              system.println (asString$val$49);
            }
          }
        }
// 477
        JP.go.ipa.oz.lib.standard._String_if string$18 = (new JP.go.ipa.oz.lib.standard._String_cl("-----"));
        
// 477
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.println (string$18);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.println (string$18);
        }
      }
    }
// 480
    if (debug) {
// 480
      JP.go.ipa.oz.lib.standard._String_if string$19 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#setResourceProxyToCache() leave"));
      
// 480
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$19);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$19);
      }
    }
  }
  
  public void removeResource (JP.go.ipa.oz.lib.standard._String_if resource) throws Exception  {
    checkSecureInvocation ();
// 77
    boolean isRed$val$50;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) resource)) {
      try {
        isRed$val$50 = resource.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$50 = resource.isRed ();
    }
// 77
    if (isRed$val$50) {
// 77
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auth)) {
        try {
          auth.authorize (resource);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        auth.authorize (resource);
      }
    }
// 78
    if (debug) {
// 78
      JP.go.ipa.oz.lib.standard._String_if string$20 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#removeResource() enter"));
      
// 78
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$20);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$20);
      }
    }
// 79
    JP.go.ipa.oz.user.apl.fed.ResourceLog_if log = null;
// 80
    JP.go.ipa.oz.lang._Root_if get$val$51;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) resources)) {
      try {
        get$val$51 = resources.get (resource);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      get$val$51 = resources.get (resource);
    }
// 80
    log = (JP.go.ipa.oz.user.apl.fed.ResourceLog_if) (get$val$51);
// 81
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) log)) {
      try {
        log.out ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      log.out ();
    }
// 82
    if (debug) {
// 82
      JP.go.ipa.oz.lib.standard._String_if string$21 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#removeResource() leave"));
      
// 82
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$21);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$21);
      }
    }
  }
  
  public JP.go.ipa.oz.user.apl.fed.ResourceProxy_if findResourceProxy (JP.go.ipa.oz.lib.standard._Set_if proxs, JP.go.ipa.oz.lib.standard._String_if resType, JP.go.ipa.oz.lib.standard._String_if autoType) throws Exception  {
    checkSecureInvocation ();
// 350
    boolean isRed$val$52;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) proxies)) {
      try {
        isRed$val$52 = proxies.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$52 = proxies.isRed ();
    }
// 350
    if (isRed$val$52) {
// 350
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auth)) {
        try {
          auth.authorize (proxies);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        auth.authorize (proxies);
      }
    }
// 351
    boolean isRed$val$53;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) resType)) {
      try {
        isRed$val$53 = resType.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$53 = resType.isRed ();
    }
// 351
    if (isRed$val$53) {
// 351
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auth)) {
        try {
          auth.authorize (resType);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        auth.authorize (resType);
      }
    }
// 352
    boolean isRed$val$54;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) autoType)) {
      try {
        isRed$val$54 = autoType.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$54 = autoType.isRed ();
    }
// 352
    if (isRed$val$54) {
// 352
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auth)) {
        try {
          auth.authorize (autoType);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        auth.authorize (autoType);
      }
    }
// 353
    if (debug) {
// 353
      JP.go.ipa.oz.lib.standard._String_if string$22 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#findResourceProxy() enter"));
      
// 353
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$22);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$22);
      }
    }
// 354
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$55;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) proxs)) {
      try {
        iterator$val$55 = proxs.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$55 = proxs.iterator ();
    }
// 354
    JP.go.ipa.oz.lib.standard._Iterator_if iter = iterator$val$55;
// 355
    while (true) {
// 355
      boolean hasMoreElements$val$56;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
        try {
          hasMoreElements$val$56 = iter.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$56 = iter.hasMoreElements ();
      }
      if (!(hasMoreElements$val$56)) break;
      
      /* body */ _loop_1: {
// 356
        JP.go.ipa.oz.user.apl.fed.ResourceProxy_if proxy = null;
// 357
        JP.go.ipa.oz.lang._Root_if nextElement$val$57;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
          try {
            nextElement$val$57 = iter.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$57 = iter.nextElement ();
        }
// 357
        proxy = (JP.go.ipa.oz.user.apl.fed.ResourceProxy_if) (nextElement$val$57);
// 358
        boolean isAcceptable$val$58;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) proxy)) {
          try {
            isAcceptable$val$58 = proxy.isAcceptable (autoType, resType);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isAcceptable$val$58 = proxy.isAcceptable (autoType, resType);
        }
// 358
        if (isAcceptable$val$58) {{
// 359
            if (debug) {
// 359
              JP.go.ipa.oz.lib.standard._String_if string$23 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#findResourceProxy() leave"));
              
// 359
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                try {
                  system.println (string$23);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                system.println (string$23);
              }
            }
// 360
            return proxy;
          }
        }
      }
    }
// 363
    if (debug) {
// 363
      JP.go.ipa.oz.lib.standard._String_if string$24 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#findResourceProxy() leave with null"));
      
// 363
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$24);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$24);
      }
    }
// 364
    return null;
  }
  
  public JP.go.ipa.oz.user.apl.fed.ResourceProxy_if getResourceProxyByCache (JP.go.ipa.oz.lib.standard._String_if resGol) throws Exception  {
    checkSecureInvocation ();
// 428
    boolean isRed$val$59;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) resGol)) {
      try {
        isRed$val$59 = resGol.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$59 = resGol.isRed ();
    }
// 428
    if (isRed$val$59) {
// 428
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auth)) {
        try {
          auth.authorize (resGol);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        auth.authorize (resGol);
      }
    }
// 429
    if (debug) {
// 429
      JP.go.ipa.oz.lib.standard._String_if string$25 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#getResourceProxyByCache() enter"));
      
// 429
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$25);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$25);
      }
    }
// 430
    if (debug) {{
// 431
        if (resGol != null) {
// 432
          JP.go.ipa.oz.lib.standard._String_if string$26 = (new JP.go.ipa.oz.lib.standard._String_cl("resGol = "));
          
// 432
          JP.go.ipa.oz.lib.standard._String_if concat$val$60;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$26)) {
            try {
              concat$val$60 = string$26.concat (resGol);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            concat$val$60 = string$26.concat (resGol);
          }
// 432
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
            try {
              system.println (concat$val$60);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            system.println (concat$val$60);
          }
        } else {
// 434
          JP.go.ipa.oz.lib.standard._String_if string$27 = (new JP.go.ipa.oz.lib.standard._String_cl("resGol = null"));
          
// 434
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
            try {
              system.println (string$27);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            system.println (string$27);
          }
        }
      }
    }
// 436
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$61;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cache)) {
      try {
        iterator$val$61 = cache.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$61 = cache.iterator ();
    }
// 436
    JP.go.ipa.oz.lib.standard._Iterator_if iter = iterator$val$61;
// 437
    while (true) {
// 437
      boolean hasMoreElements$val$62;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
        try {
          hasMoreElements$val$62 = iter.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$62 = iter.hasMoreElements ();
      }
      if (!(hasMoreElements$val$62)) break;
      
      /* body */ _loop_1: {
// 438
        JP.go.ipa.oz.user.apl.fed.ResourceProxy_if proxy = null;
// 439
        JP.go.ipa.oz.lang._Root_if nextElement$val$63;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
          try {
            nextElement$val$63 = iter.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$63 = iter.nextElement ();
        }
// 439
        proxy = (JP.go.ipa.oz.user.apl.fed.ResourceProxy_if) (nextElement$val$63);
// 440
        if (debug) {{
// 441
            JP.go.ipa.oz.lib.standard._String_if getResource$val$64;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) proxy)) {
              try {
                getResource$val$64 = proxy.getResource ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getResource$val$64 = proxy.getResource ();
            }
// 441
            if (getResource$val$64 != null) {
// 442
              JP.go.ipa.oz.lib.standard._String_if string$28 = (new JP.go.ipa.oz.lib.standard._String_cl("cache = "));
              
// 442
              JP.go.ipa.oz.lib.standard._String_if getResource$val$65;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) proxy)) {
                try {
                  getResource$val$65 = proxy.getResource ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                getResource$val$65 = proxy.getResource ();
              }
// 442
              JP.go.ipa.oz.lib.standard._String_if concat$val$66;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$28)) {
                try {
                  concat$val$66 = string$28.concat (getResource$val$65);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                concat$val$66 = string$28.concat (getResource$val$65);
              }
// 442
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                try {
                  system.println (concat$val$66);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                system.println (concat$val$66);
              }
            } else {
// 444
              JP.go.ipa.oz.lib.standard._String_if string$29 = (new JP.go.ipa.oz.lib.standard._String_cl("cache = null"));
              
// 444
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                try {
                  system.println (string$29);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                system.println (string$29);
              }
            }
          }
        }
// 446
        JP.go.ipa.oz.lib.standard._String_if getResource$val$67;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) proxy)) {
          try {
            getResource$val$67 = proxy.getResource ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getResource$val$67 = proxy.getResource ();
        }
// 446
        boolean isequal$val$68;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) resGol)) {
          try {
            isequal$val$68 = resGol.isequal (getResource$val$67);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isequal$val$68 = resGol.isequal (getResource$val$67);
        }
// 446
        if (isequal$val$68) {{
// 447
            if (debug) {
// 447
              JP.go.ipa.oz.lib.standard._String_if string$30 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#getResourceProxyByCache() leave"));
              
// 447
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                try {
                  system.println (string$30);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                system.println (string$30);
              }
            }
// 448
            return proxy;
          }
        }
      }
    }
// 451
    if (debug) {{
// 452
        JP.go.ipa.oz.lib.standard._String_if string$31 = (new JP.go.ipa.oz.lib.standard._String_cl("----- Autonomy#getResourceProxyByCache()"));
        
// 452
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.println (string$31);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.println (string$31);
        }
// 453
        JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$69;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cache)) {
          try {
            iterator$val$69 = cache.iterator ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          iterator$val$69 = cache.iterator ();
        }
// 453
        JP.go.ipa.oz.lib.standard._Iterator_if it = iterator$val$69;
// 454
        while (true) {
// 454
          boolean hasMoreElements$val$70;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
            try {
              hasMoreElements$val$70 = it.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$70 = it.hasMoreElements ();
          }
          if (!(hasMoreElements$val$70)) break;
          
          /* body */ _loop_1: {
// 455
            JP.go.ipa.oz.lang._Root_if nextElement$val$71;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
              try {
                nextElement$val$71 = it.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$71 = it.nextElement ();
            }
// 455
            JP.go.ipa.oz.lang._Root_if element = nextElement$val$71;
// 456
            JP.go.ipa.oz.lib.standard._String_if asString$val$72;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) element)) {
              try {
                asString$val$72 = element.asString ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              asString$val$72 = element.asString ();
            }
// 456
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
              try {
                system.println (asString$val$72);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              system.println (asString$val$72);
            }
          }
        }
// 458
        JP.go.ipa.oz.lib.standard._String_if string$32 = (new JP.go.ipa.oz.lib.standard._String_cl("-----"));
        
// 458
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.println (string$32);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.println (string$32);
        }
      }
    }
// 461
    if (debug) {
// 461
      JP.go.ipa.oz.lib.standard._String_if string$33 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#getResourceProxyByCache() leave with null"));
      
// 461
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$33);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$33);
      }
    }
// 462
    return null;
  }
  
  public boolean containsResource (JP.go.ipa.oz.lib.standard._String_if resource) throws Exception  {
    checkSecureInvocation ();
// 87
    boolean isRed$val$73;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) resource)) {
      try {
        isRed$val$73 = resource.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$73 = resource.isRed ();
    }
// 87
    if (isRed$val$73) {
// 87
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auth)) {
        try {
          auth.authorize (resource);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        auth.authorize (resource);
      }
    }
// 88
    if (debug) {
// 88
      JP.go.ipa.oz.lib.standard._String_if string$34 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#containsResource() enter"));
      
// 88
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$34);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$34);
      }
    }
// 89
    boolean result = false;
// 90
    JP.go.ipa.oz.user.apl.fed.ResourceLog_if log = null;
// 91
    JP.go.ipa.oz.lang._Root_if get$val$74;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) resources)) {
      try {
        get$val$74 = resources.get (resource);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      get$val$74 = resources.get (resource);
    }
// 91
    log = (JP.go.ipa.oz.user.apl.fed.ResourceLog_if) (get$val$74);
    boolean bool$val$16;
    
    bool$val$16 = (log != null);
    if (bool$val$16) {
// 92
      JP.go.ipa.oz.lib.standard._Date_if getOutTime$val$75;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) log)) {
        try {
          getOutTime$val$75 = log.getOutTime ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getOutTime$val$75 = log.getOutTime ();
      }
      bool$val$16 = (getOutTime$val$75 == null);
    }
// 92
    if (bool$val$16) {
// 93
      result = true;
    }
// 94
    if (debug) {
// 94
      JP.go.ipa.oz.lib.standard._String_if string$35 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#containsResource() leave"));
      
// 94
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$35);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$35);
      }
    }
// 95
    return result;
  }
  
  public void flushCache (JP.go.ipa.oz.lib.standard._String_if resGol) throws Exception  {
    checkSecureInvocation ();
// 509
    boolean isRed$val$76;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) resGol)) {
      try {
        isRed$val$76 = resGol.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$76 = resGol.isRed ();
    }
// 509
    if (isRed$val$76) {
// 509
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auth)) {
        try {
          auth.authorize (resGol);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        auth.authorize (resGol);
      }
    }
// 510
    if (debug) {
// 510
      JP.go.ipa.oz.lib.standard._String_if string$36 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#flushCache(String) enter"));
      
// 510
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$36);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$36);
      }
    }
// 511
    JP.go.ipa.oz.user.apl.fed.ResourceProxy_if proxy = getResourceProxyByCache (resGol);
// 512
    if (proxy != null) {
// 513
      JP.go.ipa.oz.lib.standard._Collection_if remove$val$77;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cache)) {
        try {
          remove$val$77 = cache.remove (proxy);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        remove$val$77 = cache.remove (proxy);
      }
    }
// 514
    if (debug) {{
// 515
        JP.go.ipa.oz.lib.standard._String_if string$37 = (new JP.go.ipa.oz.lib.standard._String_cl("----- Autonomy#flushCache(String)"));
        
// 515
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.println (string$37);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.println (string$37);
        }
// 516
        JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$78;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cache)) {
          try {
            iterator$val$78 = cache.iterator ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          iterator$val$78 = cache.iterator ();
        }
// 516
        JP.go.ipa.oz.lib.standard._Iterator_if it = iterator$val$78;
// 517
        while (true) {
// 517
          boolean hasMoreElements$val$79;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
            try {
              hasMoreElements$val$79 = it.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$79 = it.hasMoreElements ();
          }
          if (!(hasMoreElements$val$79)) break;
          
          /* body */ _loop_1: {
// 518
            JP.go.ipa.oz.lang._Root_if nextElement$val$80;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
              try {
                nextElement$val$80 = it.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$80 = it.nextElement ();
            }
// 518
            JP.go.ipa.oz.lang._Root_if element = nextElement$val$80;
// 519
            JP.go.ipa.oz.lib.standard._String_if asString$val$81;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) element)) {
              try {
                asString$val$81 = element.asString ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              asString$val$81 = element.asString ();
            }
// 519
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
              try {
                system.println (asString$val$81);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              system.println (asString$val$81);
            }
          }
        }
// 521
        JP.go.ipa.oz.lib.standard._String_if string$38 = (new JP.go.ipa.oz.lib.standard._String_cl("-----"));
        
// 521
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.println (string$38);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.println (string$38);
        }
      }
    }
// 524
    if (debug) {
// 524
      JP.go.ipa.oz.lib.standard._String_if string$39 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#flushCache(String) leave"));
      
// 524
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$39);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$39);
      }
    }
  }
  
  public void flushCache () throws Exception  {
    checkSecureInvocation ();
// 488
    if (debug) {
// 488
      JP.go.ipa.oz.lib.standard._String_if string$40 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#flushCache() enter"));
      
// 488
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$40);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$40);
      }
    }
// 489
    JP.go.ipa.oz.user.apl.fed.ResourceProxyComparator_if rpcomp = (JP.go.ipa.oz.user.apl.fed.ResourceProxyComparator_cl) (new JP.go.ipa.oz.user.apl.fed.ResourceProxyComparator_cl ())._new_create ();
// 490
    cache = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create (rpcomp);
// 491
    if (debug) {{
// 492
        JP.go.ipa.oz.lib.standard._String_if string$41 = (new JP.go.ipa.oz.lib.standard._String_cl("----- Autonomy#flushCache()"));
        
// 492
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.println (string$41);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.println (string$41);
        }
// 493
        JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$82;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cache)) {
          try {
            iterator$val$82 = cache.iterator ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          iterator$val$82 = cache.iterator ();
        }
// 493
        JP.go.ipa.oz.lib.standard._Iterator_if it = iterator$val$82;
// 494
        while (true) {
// 494
          boolean hasMoreElements$val$83;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
            try {
              hasMoreElements$val$83 = it.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$83 = it.hasMoreElements ();
          }
          if (!(hasMoreElements$val$83)) break;
          
          /* body */ _loop_1: {
// 495
            JP.go.ipa.oz.lang._Root_if nextElement$val$84;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
              try {
                nextElement$val$84 = it.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$84 = it.nextElement ();
            }
// 495
            JP.go.ipa.oz.lang._Root_if element = nextElement$val$84;
// 496
            JP.go.ipa.oz.lib.standard._String_if asString$val$85;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) element)) {
              try {
                asString$val$85 = element.asString ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              asString$val$85 = element.asString ();
            }
// 496
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
              try {
                system.println (asString$val$85);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              system.println (asString$val$85);
            }
          }
        }
// 498
        JP.go.ipa.oz.lib.standard._String_if string$42 = (new JP.go.ipa.oz.lib.standard._String_cl("-----"));
        
// 498
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.println (string$42);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.println (string$42);
        }
      }
    }
// 501
    if (debug) {
// 501
      JP.go.ipa.oz.lib.standard._String_if string$43 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#flushCache() leave"));
      
// 501
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$43);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$43);
      }
    }
  }
  
  public void init () throws Exception  {
    checkSecureInvocation ();
// 15
    super.init ();
// 16
    setClassName ((new JP.go.ipa.oz.lib.standard._String_cl("Autonomy")));
// 17
    JP.go.ipa.oz.lib.standard._StringComparator_if comp = (JP.go.ipa.oz.lib.standard._StringComparator_cl) (new JP.go.ipa.oz.lib.standard._StringComparator_cl ())._new_create ();
// 18
    JP.go.ipa.oz.user.apl.fed.ResourceProxyComparator_if rpcomp = (JP.go.ipa.oz.user.apl.fed.ResourceProxyComparator_cl) (new JP.go.ipa.oz.user.apl.fed.ResourceProxyComparator_cl ())._new_create ();
// 19
    resources = (JP.go.ipa.oz.lib.standard._Dictionary_cl) (new JP.go.ipa.oz.lib.standard._Dictionary_cl ())._new_create (comp);
// 20
    federates = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create (comp);
// 21
    cache = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create (rpcomp);
// 22
    surrogates = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create (rpcomp);
// 23
    surrogatePivots = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create (comp);
// 24
    adapters = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create (rpcomp);
// 25
    adapterPivots = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create (comp);
// 26
    proxies = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create (rpcomp);
  }
  
  public void addResourceProxy (JP.go.ipa.oz.user.apl.fed.ResourceProxy_if proxy) throws Exception  {
    checkSecureInvocation ();
// 146
    JP.go.ipa.oz.lib.standard._Set_if add$val$86;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) proxies)) {
      try {
        add$val$86 = proxies.add (proxy);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$86 = proxies.add (proxy);
    }
// 147
    boolean isRed$val$87;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) proxy)) {
      try {
        isRed$val$87 = proxy.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$87 = proxy.isRed ();
    }
// 147
    if (isRed$val$87) {
// 147
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auth)) {
        try {
          auth.authorize (proxy);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        auth.authorize (proxy);
      }
    }
// 148
    if (debug) {
// 148
      JP.go.ipa.oz.lib.standard._String_if string$44 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#addResourceProxy() enter"));
      
// 148
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$44);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$44);
      }
    }
// 149
    JP.go.ipa.oz.lib.standard._String_if getAutonomyType$val$88;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) proxy)) {
      try {
        getAutonomyType$val$88 = proxy.getAutonomyType ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getAutonomyType$val$88 = proxy.getAutonomyType ();
    }
// 149
    JP.go.ipa.oz.lib.standard._String_if autoType = getAutonomyType$val$88;
// 150
    JP.go.ipa.oz.lib.standard._String_if getResourceType$val$89;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) proxy)) {
      try {
        getResourceType$val$89 = proxy.getResourceType ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getResourceType$val$89 = proxy.getResourceType ();
    }
// 150
    JP.go.ipa.oz.lib.standard._String_if resType = getResourceType$val$89;
// 151
    if (isMemberOf (autoType)) {{
// 152
        if (debug) {
// 152
          JP.go.ipa.oz.lib.standard._String_if string$45 = (new JP.go.ipa.oz.lib.standard._String_cl("autoType is member of this autonomy"));
          
// 152
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
            try {
              system.println (string$45);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            system.println (string$45);
          }
        }
// 153
        JP.go.ipa.oz.lib.standard._Set_if add$val$90;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) surrogates)) {
          try {
            add$val$90 = surrogates.add (proxy);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          add$val$90 = surrogates.add (proxy);
        }
// 154
        JP.go.ipa.oz.lib.standard._Set_if add$val$91;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) surrogatePivots)) {
          try {
            add$val$91 = surrogatePivots.add (resType);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          add$val$91 = surrogatePivots.add (resType);
        }
      }
    } else {{
// 156
        JP.go.ipa.oz.lib.standard._Set_if add$val$92;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) adapters)) {
          try {
            add$val$92 = adapters.add (proxy);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          add$val$92 = adapters.add (proxy);
        }
// 157
        JP.go.ipa.oz.lib.standard._Set_if add$val$93;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) adapterPivots)) {
          try {
            add$val$93 = adapterPivots.add (autoType);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          add$val$93 = adapterPivots.add (autoType);
        }
      }
    }
// 159
    if (debug) {
// 159
      JP.go.ipa.oz.lib.standard._String_if string$46 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#addResourceProxy() leave"));
      
// 159
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$46);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$46);
      }
    }
  }
  
  public JP.go.ipa.oz.lib.standard._Set_if getResourceProxies () throws Exception  {
    checkSecureInvocation ();
// 58
    return proxies;
  }
  
  public JP.go.ipa.oz.lib.standard._Set_if getCache () throws Exception  {
    checkSecureInvocation ();
// 38
    return cache;
  }
  
  public void attachToFederation (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception  {
    checkSecureInvocation ();
// 103
    boolean isRed$val$94;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gol)) {
      try {
        isRed$val$94 = gol.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$94 = gol.isRed ();
    }
// 103
    if (isRed$val$94) {
// 103
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auth)) {
        try {
          auth.authorize (gol);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        auth.authorize (gol);
      }
    }
// 104
    if (debug) {
// 104
      JP.go.ipa.oz.lib.standard._String_if string$47 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#attachToFederation() enter"));
      
// 104
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$47);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$47);
      }
    }
// 105
    boolean contains$val$95;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) federates)) {
      try {
        contains$val$95 = federates.contains (gol);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      contains$val$95 = federates.contains (gol);
    }
// 105
    if (contains$val$95 == false) {{
// 106
        JP.go.ipa.oz.lib.standard._Set_if add$val$96;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) federates)) {
          try {
            add$val$96 = federates.add (gol);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          add$val$96 = federates.add (gol);
        }
// 107
        JP.go.ipa.oz.user.apl.fed.Federation_if fed = null;
// 108
        fed = new JP.go.ipa.oz.user.apl.fed.Federation_pcl (gol);
// 109
        if (debug) {
// 109
          JP.go.ipa.oz.lib.standard._String_if gol$val$97;
          gol$val$97 = this.gol ();
// 109
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
            try {
              system.println (gol$val$97);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            system.println (gol$val$97);
          }
        }
// 110
        fed.addAutonomy (this.gol ());
      }
    }
// 112
    if (debug) {
// 112
      JP.go.ipa.oz.lib.standard._String_if string$48 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#attachToFederation() leave"));
      
// 112
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$48);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$48);
      }
    }
  }
  
  public JP.go.ipa.oz.lib.standard._Set_if getSurrogatePivots () throws Exception  {
    checkSecureInvocation ();
// 46
    return surrogatePivots;
  }
  
  public void removeResourceProxy (JP.go.ipa.oz.user.apl.fed.ResourceProxy_if proxy) throws Exception  {
    checkSecureInvocation ();
// 170
    JP.go.ipa.oz.lib.standard._Collection_if remove$val$98;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) proxies)) {
      try {
        remove$val$98 = proxies.remove (proxy);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      remove$val$98 = proxies.remove (proxy);
    }
// 171
    boolean isRed$val$99;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) proxy)) {
      try {
        isRed$val$99 = proxy.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$99 = proxy.isRed ();
    }
// 171
    if (isRed$val$99) {
// 171
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auth)) {
        try {
          auth.authorize (proxy);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        auth.authorize (proxy);
      }
    }
// 172
    if (debug) {
// 172
      JP.go.ipa.oz.lib.standard._String_if string$49 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#removeResourceProxy() enter"));
      
// 172
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$49);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$49);
      }
    }
// 173
    JP.go.ipa.oz.lib.standard._String_if getAutonomyType$val$100;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) proxy)) {
      try {
        getAutonomyType$val$100 = proxy.getAutonomyType ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getAutonomyType$val$100 = proxy.getAutonomyType ();
    }
// 173
    JP.go.ipa.oz.lib.standard._String_if autoType = getAutonomyType$val$100;
// 174
    JP.go.ipa.oz.lib.standard._String_if getResourceType$val$101;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) proxy)) {
      try {
        getResourceType$val$101 = proxy.getResourceType ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getResourceType$val$101 = proxy.getResourceType ();
    }
// 174
    JP.go.ipa.oz.lib.standard._String_if resType = getResourceType$val$101;
// 175
    if (isMemberOf (autoType)) {{
// 176
        JP.go.ipa.oz.lib.standard._Collection_if remove$val$102;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) surrogates)) {
          try {
            remove$val$102 = surrogates.remove (proxy);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          remove$val$102 = surrogates.remove (proxy);
        }
// 177
        JP.go.ipa.oz.lib.standard._Collection_if remove$val$103;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) surrogatePivots)) {
          try {
            remove$val$103 = surrogatePivots.remove (resType);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          remove$val$103 = surrogatePivots.remove (resType);
        }
      }
    } else {{
// 179
        JP.go.ipa.oz.lib.standard._Collection_if remove$val$104;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) adapters)) {
          try {
            remove$val$104 = adapters.remove (proxy);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          remove$val$104 = adapters.remove (proxy);
        }
// 180
        JP.go.ipa.oz.lib.standard._Collection_if remove$val$105;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) adapterPivots)) {
          try {
            remove$val$105 = adapterPivots.remove (autoType);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          remove$val$105 = adapterPivots.remove (autoType);
        }
      }
    }
// 182
    if (debug) {
// 182
      JP.go.ipa.oz.lib.standard._String_if string$50 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#removeResourceProxy() leave"));
      
// 182
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$50);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$50);
      }
    }
  }
  
  public JP.go.ipa.oz.user.apl.fed.ResourceProxy_if getResourceProxy (JP.go.ipa.oz.lib.standard._String_if resType, JP.go.ipa.oz.lib.standard._String_if pivot, JP.go.ipa.oz.lib.standard._String_if autoType) throws Exception  {
    checkSecureInvocation ();
// 302
    boolean isRed$val$106;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) resType)) {
      try {
        isRed$val$106 = resType.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$106 = resType.isRed ();
    }
// 302
    if (isRed$val$106) {
// 302
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auth)) {
        try {
          auth.authorize (resType);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        auth.authorize (resType);
      }
    }
// 303
    if (pivot != null) {{
// 304
        boolean isRed$val$107;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pivot)) {
          try {
            isRed$val$107 = pivot.isRed ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isRed$val$107 = pivot.isRed ();
        }
// 304
        if (isRed$val$107) {
// 304
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auth)) {
            try {
              auth.authorize (pivot);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            auth.authorize (pivot);
          }
        }
      }
    }
// 306
    boolean isRed$val$108;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) autoType)) {
      try {
        isRed$val$108 = autoType.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$108 = autoType.isRed ();
    }
// 306
    if (isRed$val$108) {
// 306
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auth)) {
        try {
          auth.authorize (autoType);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        auth.authorize (autoType);
      }
    }
// 307
    if (debug) {
// 307
      JP.go.ipa.oz.lib.standard._String_if string$51 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#getResourceProxy() enter"));
      
// 307
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$51);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$51);
      }
    }
// 308
    JP.go.ipa.oz.user.apl.fed.ResourceProxy_if proxy = findSurrogate (resType, autoType);
// 309
    JP.go.ipa.oz.user.apl.fed.ResourceProxy_if adapter = null;
// 310
    if (proxy == null) {{
// 311
        if (pivot != null) {{
// 312
            JP.go.ipa.oz.lib.standard._StringComparator_if sc = null;
// 313
            sc = (JP.go.ipa.oz.lib.standard._StringComparator_cl) (new JP.go.ipa.oz.lib.standard._StringComparator_cl ())._new_create ();
// 314
            JP.go.ipa.oz.lib.standard._Set_if pivots = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create (sc);
// 315
            JP.go.ipa.oz.lib.standard._Set_if add$val$109;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pivots)) {
              try {
                add$val$109 = pivots.add (pivot);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              add$val$109 = pivots.add (pivot);
            }
// 316
            adapter = getAdapter (resType, pivots);
          }
        } else {{
// 318
            JP.go.ipa.oz.lib.standard._String_if str = null;
// 319
            JP.go.ipa.oz.lib.standard._Iterator_if iter = null;
// 320
            JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$110;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) surrogatePivots)) {
              try {
                iterator$val$110 = surrogatePivots.iterator ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              iterator$val$110 = surrogatePivots.iterator ();
            }
// 320
            iter = iterator$val$110;
// 321
            JP.go.ipa.oz.lang._Root_if nextElement$val$111;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
              try {
                nextElement$val$111 = iter.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$111 = iter.nextElement ();
            }
// 321
            str = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$111);
// 322
            adapter = getAdapter (resType, surrogatePivots);
          }
        }
// 324
        if (adapter != null) {{
// 325
            JP.go.ipa.oz.lib.standard._String_if getResourceType$val$112;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) adapter)) {
              try {
                getResourceType$val$112 = adapter.getResourceType ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getResourceType$val$112 = adapter.getResourceType ();
            }
// 325
            resType = getResourceType$val$112;
// 326
            proxy = findSurrogate (resType, autoType);
// 327
            if (proxy == null) {{
// 328
                proxy = (JP.go.ipa.oz.user.apl.fed.ResourceProxy_cl) (new JP.go.ipa.oz.user.apl.fed.ResourceProxy_cl ())._new_create ();
// 329
                proxy.setResourceType (resType);
// 330
                proxy.setAutonomyType (autoType);
              }
            }
          }
        }
      }
    }
// 335
    if (proxy == null) {{
// 336
        if (debug) {
// 336
          JP.go.ipa.oz.lib.standard._String_if string$52 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#getResourceProxy() leave with null"));
          
// 336
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
            try {
              system.println (string$52);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            system.println (string$52);
          }
        }
// 337
        return null;
      }
    }
// 339
    if (debug) {
// 339
      JP.go.ipa.oz.lib.standard._String_if string$53 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#getResourceProxy() leave"));
      
// 339
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$53);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$53);
      }
    }
// 340
    return proxy.instanciate (adapter);
  }
  
  public JP.go.ipa.oz.lib.standard._Set_if getFederations () throws Exception  {
    checkSecureInvocation ();
// 34
    return federates;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if asString () throws Exception  {
    checkSecureInvocation ();
// 528
    JP.go.ipa.oz.lib.standard._String_if string$54 = (new JP.go.ipa.oz.lib.standard._String_cl("["));
    
// 528
    JP.go.ipa.oz.lib.standard._String_if concat$val$113;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$54)) {
      try {
        concat$val$113 = string$54.concat (className);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$113 = string$54.concat (className);
    }
// 528
    JP.go.ipa.oz.lib.standard._String_if string$55 = (new JP.go.ipa.oz.lib.standard._String_cl("]"));
    
// 528
    JP.go.ipa.oz.lib.standard._String_if concat$val$114;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$113)) {
      try {
        concat$val$114 = concat$val$113.concat (string$55);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$114 = concat$val$113.concat (string$55);
    }
// 529
    JP.go.ipa.oz.lib.standard._String_if string$56 = (new JP.go.ipa.oz.lib.standard._String_cl("Category : "));
    
// 528
    JP.go.ipa.oz.lib.standard._String_if concat$val$115;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$114)) {
      try {
        concat$val$115 = concat$val$114.concat (string$56);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$115 = concat$val$114.concat (string$56);
    }
// 528
    JP.go.ipa.oz.lib.standard._String_if concat$val$116;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$115)) {
      try {
        concat$val$116 = concat$val$115.concat (categoryName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$116 = concat$val$115.concat (categoryName);
    }
// 530
    JP.go.ipa.oz.lib.standard._String_if string$57 = (new JP.go.ipa.oz.lib.standard._String_cl("Type : "));
    
// 528
    JP.go.ipa.oz.lib.standard._String_if concat$val$117;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$116)) {
      try {
        concat$val$117 = concat$val$116.concat (string$57);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$117 = concat$val$116.concat (string$57);
    }
// 528
    JP.go.ipa.oz.lib.standard._String_if concat$val$118;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$117)) {
      try {
        concat$val$118 = concat$val$117.concat (type);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$118 = concat$val$117.concat (type);
    }
// 528
    return concat$val$118;
  }
  
  public void addResource (JP.go.ipa.oz.lib.standard._String_if resource) throws Exception  {
    checkSecureInvocation ();
// 67
    boolean isRed$val$119;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) resource)) {
      try {
        isRed$val$119 = resource.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$119 = resource.isRed ();
    }
// 67
    if (isRed$val$119) {
// 67
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auth)) {
        try {
          auth.authorize (resource);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        auth.authorize (resource);
      }
    }
// 68
    if (debug) {
// 68
      JP.go.ipa.oz.lib.standard._String_if string$58 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#addResource() enter"));
      
// 68
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$58);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$58);
      }
    }
// 69
    JP.go.ipa.oz.user.apl.fed.ResourceLog_if log = (JP.go.ipa.oz.user.apl.fed.ResourceLog_cl) (new JP.go.ipa.oz.user.apl.fed.ResourceLog_cl ())._new_create ();
// 70
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) log)) {
      try {
        log.in ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      log.in ();
    }
// 71
    JP.go.ipa.oz.lib.standard._Dictionary_if put$val$120;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) resources)) {
      try {
        put$val$120 = resources.put (resource, log);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      put$val$120 = resources.put (resource, log);
    }
// 72
    if (debug) {
// 72
      JP.go.ipa.oz.lib.standard._String_if string$59 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#addResource() leave"));
      
// 72
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$59);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$59);
      }
    }
  }
  
  public JP.go.ipa.oz.user.apl.fed.ResourceProxy_if findSurrogate (JP.go.ipa.oz.lib.standard._String_if resType, JP.go.ipa.oz.lib.standard._String_if autoType) throws Exception  {
    checkSecureInvocation ();
// 373
    boolean isRed$val$121;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) resType)) {
      try {
        isRed$val$121 = resType.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$121 = resType.isRed ();
    }
// 373
    if (isRed$val$121) {
// 373
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auth)) {
        try {
          auth.authorize (resType);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        auth.authorize (resType);
      }
    }
// 374
    boolean isRed$val$122;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) autoType)) {
      try {
        isRed$val$122 = autoType.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$122 = autoType.isRed ();
    }
// 374
    if (isRed$val$122) {
// 374
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auth)) {
        try {
          auth.authorize (autoType);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        auth.authorize (autoType);
      }
    }
// 375
    if (debug) {
// 375
      JP.go.ipa.oz.lib.standard._String_if string$60 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#findSurrogate() enter"));
      
// 375
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$60);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$60);
      }
    }
// 376
    JP.go.ipa.oz.user.apl.fed.ResourceProxy_if proxy = findResourceProxy (surrogates, resType, autoType);
// 377
    if (debug) {
// 377
      JP.go.ipa.oz.lib.standard._String_if string$61 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#findSurrogate() leave"));
      
// 377
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$61);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$61);
      }
    }
// 378
    return proxy;
  }
  
  public JP.go.ipa.oz.lib.standard._Set_if getAdapters () throws Exception  {
    checkSecureInvocation ();
// 50
    return adapters;
  }
  
  public JP.go.ipa.oz.user.apl.fed.ResourceProxy_if exportResource (JP.go.ipa.oz.lib.standard._Set_if pivots) throws Exception  {
    checkSecureInvocation ();
// 235
    JP.go.ipa.oz.lib.standard._Iterator_if it = null;
// 236
    JP.go.ipa.oz.lib.standard._String_if str = null;
// 237
    JP.go.ipa.oz.lib.standard._String_if pivot = null;
// 238
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$123;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pivots)) {
      try {
        iterator$val$123 = pivots.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$123 = pivots.iterator ();
    }
// 238
    it = iterator$val$123;
// 239
    JP.go.ipa.oz.lang._Root_if nextElement$val$124;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
      try {
        nextElement$val$124 = it.nextElement ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      nextElement$val$124 = it.nextElement ();
    }
// 239
    pivot = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$124);
// 241
    boolean isRed$val$125;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pivots)) {
      try {
        isRed$val$125 = pivots.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$125 = pivots.isRed ();
    }
// 241
    if (isRed$val$125) {
// 241
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auth)) {
        try {
          auth.authorize (pivots);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        auth.authorize (pivots);
      }
    }
// 242
    if (debug) {
// 242
      JP.go.ipa.oz.lib.standard._String_if string$62 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#exportResource() enter"));
      
// 242
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$62);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$62);
      }
    }
// 244
    if (debug) {{
// 245
        JP.go.ipa.oz.lib.standard._String_if string$63 = (new JP.go.ipa.oz.lib.standard._String_cl("----- Autonomy#exportResource()"));
        
// 245
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.println (string$63);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.println (string$63);
        }
// 246
        JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$126;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pivots)) {
          try {
            iterator$val$126 = pivots.iterator ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          iterator$val$126 = pivots.iterator ();
        }
// 246
        JP.go.ipa.oz.lib.standard._Iterator_if it$1 = iterator$val$126;
// 247
        JP.go.ipa.oz.lang._Root_if element = null;
// 248
        while (true) {
// 248
          boolean hasMoreElements$val$127;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it$1)) {
            try {
              hasMoreElements$val$127 = it$1.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$127 = it$1.hasMoreElements ();
          }
          if (!(hasMoreElements$val$127)) break;
          
          /* body */ _loop_1: {
// 249
            JP.go.ipa.oz.lang._Root_if nextElement$val$128;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it$1)) {
              try {
                nextElement$val$128 = it$1.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$128 = it$1.nextElement ();
            }
// 249
            element = nextElement$val$128;
// 250
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
              try {
                system.println (element);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              system.println (element);
            }
          }
        }
// 252
        JP.go.ipa.oz.lib.standard._String_if string$64 = (new JP.go.ipa.oz.lib.standard._String_cl("-----"));
        
// 252
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.println (string$64);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.println (string$64);
        }
// 253
        JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$129;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) adapterPivots)) {
          try {
            iterator$val$129 = adapterPivots.iterator ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          iterator$val$129 = adapterPivots.iterator ();
        }
// 253
        it$1 = iterator$val$129;
// 254
        while (true) {
// 254
          boolean hasMoreElements$val$130;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it$1)) {
            try {
              hasMoreElements$val$130 = it$1.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$130 = it$1.hasMoreElements ();
          }
          if (!(hasMoreElements$val$130)) break;
          
          /* body */ _loop_1: {
// 255
            JP.go.ipa.oz.lang._Root_if nextElement$val$131;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it$1)) {
              try {
                nextElement$val$131 = it$1.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$131 = it$1.nextElement ();
            }
// 255
            element = nextElement$val$131;
// 256
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
              try {
                system.println (element);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              system.println (element);
            }
          }
        }
// 258
        JP.go.ipa.oz.lib.standard._String_if string$65 = (new JP.go.ipa.oz.lib.standard._String_cl("-----"));
        
// 258
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.println (string$65);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.println (string$65);
        }
      }
    }
// 262
    JP.go.ipa.oz.lib.standard._Set_if list = null;
// 263
    list = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create ();
// 264
    boolean contains$val$132;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) adapterPivots)) {
      try {
        contains$val$132 = adapterPivots.contains (pivot);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      contains$val$132 = adapterPivots.contains (pivot);
    }
// 264
    if (contains$val$132) {{
// 265
        list.add (pivot);
      }
    }
// 268
    if (list.size () > 0) {{
// 269
        it = list.iterator ();
// 270
        JP.go.ipa.oz.lang._Root_if nextElement$val$133;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
          try {
            nextElement$val$133 = it.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$133 = it.nextElement ();
        }
// 270
        str = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$133);
      }
    }
// 273
    if (0 < list.size ()) {{
// 275
        if (debug) {
// 275
          JP.go.ipa.oz.lib.standard._String_if string$66 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#exportResource() found"));
          
// 275
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
            try {
              system.println (string$66);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            system.println (string$66);
          }
        }
// 276
        JP.go.ipa.oz.lib.standard._Iterator_if iter = list.iterator ();
// 277
        JP.go.ipa.oz.lib.standard._String_if pivot$2 = null;
// 278
        JP.go.ipa.oz.lang._Root_if nextElement$val$134;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
          try {
            nextElement$val$134 = iter.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$134 = iter.nextElement ();
        }
// 278
        pivot$2 = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$134);
// 279
        JP.go.ipa.oz.user.apl.fed.ResourceProxy_if adapter = findAdapter (getType (), pivot$2);
// 280
        if (adapter != null) {{
// 281
            JP.go.ipa.oz.user.apl.fed.ResourceProxy_if instanciate$val$135;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) adapter)) {
              try {
                instanciate$val$135 = adapter.instanciate ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              instanciate$val$135 = adapter.instanciate ();
            }
// 281
            adapter = instanciate$val$135;
// 282
            if (debug) {
// 282
              JP.go.ipa.oz.lib.standard._String_if string$67 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#exportResource() leave"));
              
// 282
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                try {
                  system.println (string$67);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                system.println (string$67);
              }
            }
// 283
            return adapter;
          }
        }
      }
    }
// 286
    if (debug) {
// 286
      JP.go.ipa.oz.lib.standard._String_if string$68 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#exportResource() leave with null"));
      
// 286
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$68);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$68);
      }
    }
// 287
    return null;
  }
  
  public JP.go.ipa.oz.user.apl.fed.ResourceProxy_if getAdapter (JP.go.ipa.oz.lib.standard._String_if resType, JP.go.ipa.oz.lib.standard._Set_if pivots) throws Exception  {
    checkSecureInvocation ();
// 402
    boolean isRed$val$136;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) resType)) {
      try {
        isRed$val$136 = resType.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$136 = resType.isRed ();
    }
// 402
    if (isRed$val$136) {
// 402
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auth)) {
        try {
          auth.authorize (resType);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        auth.authorize (resType);
      }
    }
// 403
    if (pivots != null) {{
// 404
        boolean isRed$val$137;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pivots)) {
          try {
            isRed$val$137 = pivots.isRed ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isRed$val$137 = pivots.isRed ();
        }
// 404
        if (isRed$val$137) {
// 404
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auth)) {
            try {
              auth.authorize (pivots);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            auth.authorize (pivots);
          }
        }
      }
    }
// 406
    if (debug) {
// 406
      JP.go.ipa.oz.lib.standard._String_if string$69 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#getAdapter() enter"));
      
// 406
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$69);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$69);
      }
    }
// 407
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$138;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) federates)) {
      try {
        iterator$val$138 = federates.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$138 = federates.iterator ();
    }
// 407
    JP.go.ipa.oz.lib.standard._Iterator_if iter = iterator$val$138;
// 408
    JP.go.ipa.oz.user.apl.fed.ResourceProxy_if adapter = null;
// 409
    while (true) {
// 409
      boolean hasMoreElements$val$139;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
        try {
          hasMoreElements$val$139 = iter.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$139 = iter.hasMoreElements ();
      }
      if (!(hasMoreElements$val$139)) break;
      
      /* body */ _loop_1: {
// 410
        JP.go.ipa.oz.lib.standard._String_if gol = null;
// 411
        JP.go.ipa.oz.lang._Root_if nextElement$val$140;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
          try {
            nextElement$val$140 = iter.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$140 = iter.nextElement ();
        }
// 411
        gol = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$140);
// 412
        JP.go.ipa.oz.user.apl.fed.Federation_if fed = new JP.go.ipa.oz.user.apl.fed.Federation_pcl (gol);
// 413
        JP.go.ipa.oz.user.apl.fed.ResourceProxy_if getAdapter$val$141;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fed)) {
          try {
            getAdapter$val$141 = fed.getAdapter (resType, pivots);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getAdapter$val$141 = fed.getAdapter (resType, pivots);
        }
// 413
        adapter = getAdapter$val$141;
// 414
        if (adapter != null) {{
// 415
            if (debug) {
// 415
              JP.go.ipa.oz.lib.standard._String_if string$70 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#getAdapter() leave"));
              
// 415
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                try {
                  system.println (string$70);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                system.println (string$70);
              }
            }
// 416
            return adapter;
          }
        }
      }
    }
// 419
    if (debug) {
// 419
      JP.go.ipa.oz.lib.standard._String_if string$71 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#getAdapter() leave with null"));
      
// 419
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$71);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$71);
      }
    }
// 420
    return null;
  }
  
  public JP.go.ipa.oz.lib.standard._Set_if getAdapterPivots () throws Exception  {
    checkSecureInvocation ();
// 54
    return adapterPivots;
  }
  
  public JP.go.ipa.oz.lib.standard._Dictionary_if getResources () throws Exception  {
    checkSecureInvocation ();
// 30
    return resources;
  }
  
  public JP.go.ipa.oz.user.apl.fed.ResourceProxy_if findAdapter (JP.go.ipa.oz.lib.standard._String_if autoType, JP.go.ipa.oz.lib.standard._String_if resType) throws Exception  {
    checkSecureInvocation ();
// 387
    boolean isRed$val$142;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) resType)) {
      try {
        isRed$val$142 = resType.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$142 = resType.isRed ();
    }
// 387
    if (isRed$val$142) {
// 387
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auth)) {
        try {
          auth.authorize (resType);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        auth.authorize (resType);
      }
    }
// 388
    boolean isRed$val$143;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) autoType)) {
      try {
        isRed$val$143 = autoType.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$143 = autoType.isRed ();
    }
// 388
    if (isRed$val$143) {
// 388
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auth)) {
        try {
          auth.authorize (autoType);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        auth.authorize (autoType);
      }
    }
// 389
    if (debug) {
// 389
      JP.go.ipa.oz.lib.standard._String_if string$72 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#findAdapter() enter"));
      
// 389
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$72);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$72);
      }
    }
// 390
    JP.go.ipa.oz.user.apl.fed.ResourceProxy_if proxy = findResourceProxy (adapters, autoType, resType);
// 391
    if (debug) {
// 391
      JP.go.ipa.oz.lib.standard._String_if string$73 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#findAdapter() leave"));
      
// 391
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$73);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$73);
      }
    }
// 392
    return proxy;
  }
  
  public void detachFromFederation (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception  {
    checkSecureInvocation ();
// 117
    boolean isRed$val$144;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gol)) {
      try {
        isRed$val$144 = gol.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$144 = gol.isRed ();
    }
// 117
    if (isRed$val$144) {
// 117
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auth)) {
        try {
          auth.authorize (gol);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        auth.authorize (gol);
      }
    }
// 118
    if (debug) {
// 118
      JP.go.ipa.oz.lib.standard._String_if string$74 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#detachFromFederation() enter"));
      
// 118
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$74);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$74);
      }
    }
// 119
    boolean contains$val$145;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) federates)) {
      try {
        contains$val$145 = federates.contains (gol);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      contains$val$145 = federates.contains (gol);
    }
// 119
    if (contains$val$145) {{
// 120
        JP.go.ipa.oz.lib.standard._Collection_if remove$val$146;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) federates)) {
          try {
            remove$val$146 = federates.remove (gol);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          remove$val$146 = federates.remove (gol);
        }
// 121
        JP.go.ipa.oz.user.apl.fed.Federation_if fed = new JP.go.ipa.oz.user.apl.fed.Federation_pcl (gol);
// 122
        if (debug) {
// 122
          JP.go.ipa.oz.lib.standard._String_if gol$val$147;
          gol$val$147 = this.gol ();
// 122
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
            try {
              system.println (gol$val$147);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            system.println (gol$val$147);
          }
        }
// 123
        JP.go.ipa.oz.lib.standard._String_if gol$val$148;
        gol$val$148 = this.gol ();
// 123
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fed)) {
          try {
            fed.removeAutonomy (gol$val$148);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          fed.removeAutonomy (gol$val$148);
        }
      }
    }
// 125
    if (debug) {
// 125
      JP.go.ipa.oz.lib.standard._String_if string$75 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#detachFromFederation() leave"));
      
// 125
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$75);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$75);
      }
    }
  }
  
  public JP.go.ipa.oz.lib.standard._Set_if getSurrogates () throws Exception  {
    checkSecureInvocation ();
// 42
    return surrogates;
  }
  
  public JP.go.ipa.oz.user.apl.fed.ResourceProxy_if importResource (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception  {
    checkSecureInvocation ();
// 223
    boolean isRed$val$149;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gol)) {
      try {
        isRed$val$149 = gol.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$149 = gol.isRed ();
    }
// 223
    if (isRed$val$149) {
// 223
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auth)) {
        try {
          auth.authorize (gol);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        auth.authorize (gol);
      }
    }
// 224
    if (debug) {
// 224
      JP.go.ipa.oz.lib.standard._String_if string$76 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#importResource() enter & leave"));
      
// 224
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$76);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$76);
      }
    }
// 225
    return importResource (gol, null);
  }
  
  public JP.go.ipa.oz.user.apl.fed.ResourceProxy_if importResource (JP.go.ipa.oz.lib.standard._String_if resGol, JP.go.ipa.oz.lib.standard._String_if pivot) throws Exception  {
    checkSecureInvocation ();
// 199
    boolean isRed$val$150;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) resGol)) {
      try {
        isRed$val$150 = resGol.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$150 = resGol.isRed ();
    }
// 199
    if (isRed$val$150) {
// 199
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auth)) {
        try {
          auth.authorize (resGol);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        auth.authorize (resGol);
      }
    }
// 200
    if (pivot != null) {{
// 201
        boolean isRed$val$151;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pivot)) {
          try {
            isRed$val$151 = pivot.isRed ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isRed$val$151 = pivot.isRed ();
        }
// 201
        if (isRed$val$151) {
// 201
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auth)) {
            try {
              auth.authorize (pivot);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            auth.authorize (pivot);
          }
        }
      }
    }
// 203
    if (debug) {
// 203
      JP.go.ipa.oz.lib.standard._String_if string$77 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#importResource() enter"));
      
// 203
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$77);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$77);
      }
    }
// 204
    JP.go.ipa.oz.user.apl.fed.ResourceProxy_if proxy = getResourceProxyByCache (resGol);
// 205
    if (proxy == null) {{
// 206
        JP.go.ipa.oz.user.apl.fed.FedRoot_if res = new JP.go.ipa.oz.user.apl.fed.FedRoot_pcl (resGol);
// 207
        JP.go.ipa.oz.lib.standard._String_if getClassName$val$152;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
          try {
            getClassName$val$152 = res.getClassName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getClassName$val$152 = res.getClassName ();
        }
// 207
        JP.go.ipa.oz.lib.standard._String_if resType = getClassName$val$152;
// 208
        proxy = getResourceProxy (resType, pivot, getType ());
// 209
        if (proxy != null) {{
// 210
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) proxy)) {
              try {
                proxy.setResource (resGol);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              proxy.setResource (resGol);
            }
// 211
            setResourceProxyToCache (proxy);
          }
        }
      }
    }
// 214
    if (debug) {
// 214
      JP.go.ipa.oz.lib.standard._String_if string$78 = (new JP.go.ipa.oz.lib.standard._String_cl("Autonomy#importResource() leave"));
      
// 214
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$78);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$78);
      }
    }
// 215
    return proxy;
  }
  
  public Autonomy_cl () { super ("JP.go.ipa.oz.user.apl.fed.Autonomy_pcl"); }
  
  public Autonomy_cl (String proxy_id) { super (proxy_id); }
  
}

