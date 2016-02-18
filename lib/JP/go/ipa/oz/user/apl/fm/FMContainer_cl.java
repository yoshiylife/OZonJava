package JP.go.ipa.oz.user.apl.fm;

public class FMContainer_cl extends JP.go.ipa.oz.system.OzCell implements JP.go.ipa.oz.user.apl.fm.FMContainer_if {
  static final boolean _global_ = true;
  int seqNumber;
  JP.go.ipa.oz.lib.standard._Dictionary_if elements;
  JP.go.ipa.oz.user.apl.fm.Archiver_if arch;
  JP.go.ipa.oz.user.apl.fm.Overseer_if overseer;
  
  void removeWithoutLock (JP.go.ipa.oz.user.apl.fm.Pointer_if ptr) throws Exception  {
// 153
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
      try {
        overseer.permit (ptr);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      overseer.permit (ptr);
    }
// 154
    JP.go.ipa.oz.lib.standard._String_if getName$val$223;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ptr)) {
      try {
        getName$val$223 = ptr.getName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getName$val$223 = ptr.getName ();
    }
// 154
    JP.go.ipa.oz.lib.standard._String_if key = getName$val$223;
// 155
    JP.go.ipa.oz.lib.standard._Dictionary_if remove$val$224;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) elements)) {
      try {
        remove$val$224 = elements.remove (key);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      remove$val$224 = elements.remove (key);
    }
// 156
    flushCell ();
  }
  
  public JP.go.ipa.oz.user.apl.fm.Karte_if getKarte (JP.go.ipa.oz.user.apl.fm.Pointer_if ptr) throws Exception  {
    checkSecureInvocation ();
// 224
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
      try {
        overseer.permit (ptr);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      overseer.permit (ptr);
    }
// 226
    JP.go.ipa.oz.lib.standard._String_if getName$val$225;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ptr)) {
      try {
        getName$val$225 = ptr.getName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getName$val$225 = ptr.getName ();
    }
// 226
    JP.go.ipa.oz.lib.standard._String_if key = getName$val$225;
// 227
    JP.go.ipa.oz.user.apl.fm.Karte_if rtn = null;
// 227
    JP.go.ipa.oz.lang._Root_if get$val$226;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) elements)) {
      try {
        get$val$226 = elements.get (key);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      get$val$226 = elements.get (key);
    }
// 227
    rtn = (JP.go.ipa.oz.user.apl.fm.Karte_if) (get$val$226);
// 228
    return rtn;
  }
  
  public void commit (JP.go.ipa.oz.user.apl.fm.FMObject_if obj) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 198
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
        try {
          overseer.permit (obj);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        overseer.permit (obj);
      }
// 202
      JP.go.ipa.oz.user.apl.fm.Pointer_if getIdentifier$val$227;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
        try {
          getIdentifier$val$227 = obj.getIdentifier ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getIdentifier$val$227 = obj.getIdentifier ();
      }
// 202
      JP.go.ipa.oz.user.apl.fm.Pointer_if ptr = getIdentifier$val$227;
// 204
      JP.go.ipa.oz.user.apl.fm.FMObject_if value = get (ptr);
// 206
      int update$val$228;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) value)) {
        try {
          update$val$228 = value.update (obj);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        update$val$228 = value.update (obj);
      }
// 206
      if (0 < (update$val$228)) {{
// 207
          JP.go.ipa.oz.user.apl.fm.Karte_if karte = getKarte (ptr);
// 208
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) karte)) {
            try {
              karte.add ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            karte.add ();
          }
// 210
          flushCell ();
        }
      }
    } finally {
      leave ();
    }
  }
  
  public void trace (int mark) throws Exception  {
    checkSecureInvocation ();
// 233
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 235
    JP.go.ipa.oz.lib.standard._String_if string$38 = (new JP.go.ipa.oz.lib.standard._String_cl("FMContainer#trace("));
    
// 236
    JP.go.ipa.oz.lib.standard._String_if string$39 = (new JP.go.ipa.oz.lib.standard._String_cl(""));
    
// 236
    JP.go.ipa.oz.lib.standard._String_if valueOf$val$229;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$39)) {
      try {
        valueOf$val$229 = string$39.valueOf (mark);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      valueOf$val$229 = string$39.valueOf (mark);
    }
// 235
    JP.go.ipa.oz.lib.standard._String_if concat$val$230;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$38)) {
      try {
        concat$val$230 = string$38.concat (valueOf$val$229);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$230 = string$38.concat (valueOf$val$229);
    }
// 236
    JP.go.ipa.oz.lib.standard._String_if string$40 = (new JP.go.ipa.oz.lib.standard._String_cl(")"));
    
// 235
    JP.go.ipa.oz.lib.standard._String_if concat$val$231;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$230)) {
      try {
        concat$val$231 = concat$val$230.concat (string$40);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$231 = concat$val$230.concat (string$40);
    }
// 237
    JP.go.ipa.oz.lib.standard._String_if string$41 = (new JP.go.ipa.oz.lib.standard._String_cl(" seqNumber:"));
    
// 235
    JP.go.ipa.oz.lib.standard._String_if concat$val$232;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$231)) {
      try {
        concat$val$232 = concat$val$231.concat (string$41);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$232 = concat$val$231.concat (string$41);
    }
// 237
    JP.go.ipa.oz.lib.standard._String_if string$42 = (new JP.go.ipa.oz.lib.standard._String_cl(""));
    
// 237
    JP.go.ipa.oz.lib.standard._String_if valueOf$val$233;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$42)) {
      try {
        valueOf$val$233 = string$42.valueOf (mark);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      valueOf$val$233 = string$42.valueOf (mark);
    }
// 235
    JP.go.ipa.oz.lib.standard._String_if concat$val$234;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$232)) {
      try {
        concat$val$234 = concat$val$232.concat (valueOf$val$233);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$234 = concat$val$232.concat (valueOf$val$233);
    }
// 238
    JP.go.ipa.oz.lib.standard._String_if string$43 = (new JP.go.ipa.oz.lib.standard._String_cl(" elements:"));
    
// 235
    JP.go.ipa.oz.lib.standard._String_if concat$val$235;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$234)) {
      try {
        concat$val$235 = concat$val$234.concat (string$43);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$235 = concat$val$234.concat (string$43);
    }
// 238
    JP.go.ipa.oz.lib.standard._String_if asString$val$236;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) elements)) {
      try {
        asString$val$236 = elements.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$236 = elements.asString ();
    }
// 235
    JP.go.ipa.oz.lib.standard._String_if concat$val$237;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$235)) {
      try {
        concat$val$237 = concat$val$235.concat (asString$val$236);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$237 = concat$val$235.concat (asString$val$236);
    }
// 235
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.println (concat$val$237);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.println (concat$val$237);
    }
// 240
    JP.go.ipa.oz.lib.standard._Iterator_if assocIterator$val$238;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) elements)) {
      try {
        assocIterator$val$238 = elements.assocIterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      assocIterator$val$238 = elements.assocIterator ();
    }
// 240
    JP.go.ipa.oz.lib.standard._Iterator_if ite = assocIterator$val$238;
// 241
    JP.go.ipa.oz.lib.standard._Association_if asso = null;
// 242
    JP.go.ipa.oz.lib.standard._String_if key = null;
// 243
    JP.go.ipa.oz.user.apl.fm.Karte_if karte = null;
// 244
    JP.go.ipa.oz.user.apl.fm.FMObject_if obj = null;
// 245
    while (true) {
// 245
      boolean hasMoreElements$val$239;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ite)) {
        try {
          hasMoreElements$val$239 = ite.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$239 = ite.hasMoreElements ();
      }
      if (!(hasMoreElements$val$239)) break;
      
      /* body */ _loop_1: {
// 246
        JP.go.ipa.oz.lang._Root_if nextElement$val$240;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ite)) {
          try {
            nextElement$val$240 = ite.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$240 = ite.nextElement ();
        }
// 246
        asso = (JP.go.ipa.oz.lib.standard._Association_if) (nextElement$val$240);
// 247
        JP.go.ipa.oz.lang._Root_if key$val$241;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) asso)) {
          try {
            key$val$241 = asso.key ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          key$val$241 = asso.key ();
        }
// 247
        key = (JP.go.ipa.oz.lib.standard._String_if) (key$val$241);
// 248
        JP.go.ipa.oz.lang._Root_if value$val$242;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) asso)) {
          try {
            value$val$242 = asso.value ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          value$val$242 = asso.value ();
        }
// 248
        karte = (JP.go.ipa.oz.user.apl.fm.Karte_if) (value$val$242);
// 249
        JP.go.ipa.oz.lang._Root_if getValue$val$243;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) karte)) {
          try {
            getValue$val$243 = karte.getValue ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getValue$val$243 = karte.getValue ();
        }
// 249
        obj = (JP.go.ipa.oz.user.apl.fm.FMObject_if) (getValue$val$243);
// 250
        JP.go.ipa.oz.lib.standard._String_if string$44 = (new JP.go.ipa.oz.lib.standard._String_cl("FMContainer#trace elements key:"));
        
// 250
        JP.go.ipa.oz.lib.standard._String_if concat$val$244;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$44)) {
          try {
            concat$val$244 = string$44.concat (key);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          concat$val$244 = string$44.concat (key);
        }
// 252
        JP.go.ipa.oz.lib.standard._String_if string$45 = (new JP.go.ipa.oz.lib.standard._String_cl(" value:"));
        
// 250
        JP.go.ipa.oz.lib.standard._String_if concat$val$245;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$244)) {
          try {
            concat$val$245 = concat$val$244.concat (string$45);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          concat$val$245 = concat$val$244.concat (string$45);
        }
// 252
        JP.go.ipa.oz.lib.standard._String_if asString$val$246;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) karte)) {
          try {
            asString$val$246 = karte.asString ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          asString$val$246 = karte.asString ();
        }
// 250
        JP.go.ipa.oz.lib.standard._String_if concat$val$247;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$245)) {
          try {
            concat$val$247 = concat$val$245.concat (asString$val$246);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          concat$val$247 = concat$val$245.concat (asString$val$246);
        }
// 250
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.println (concat$val$247);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.println (concat$val$247);
        }
      }
    }
  }
  
  public void remove (JP.go.ipa.oz.user.apl.fm.Pointer_if ptr) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 146
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
        try {
          overseer.permit (ptr);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        overseer.permit (ptr);
      }
// 147
      JP.go.ipa.oz.lib.standard._String_if getName$val$248;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ptr)) {
        try {
          getName$val$248 = ptr.getName ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getName$val$248 = ptr.getName ();
      }
// 147
      JP.go.ipa.oz.lib.standard._String_if key = getName$val$248;
// 148
      JP.go.ipa.oz.lib.standard._Dictionary_if remove$val$249;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) elements)) {
        try {
          remove$val$249 = elements.remove (key);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        remove$val$249 = elements.remove (key);
      }
// 149
      flushCell ();
    } finally {
      leave ();
    }
  }
  
  public JP.go.ipa.oz.user.apl.fm.Pointer_if find (JP.go.ipa.oz.user.apl.fm.Pointer_if ptr) throws Exception  {
    checkSecureInvocation ();
// 82
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
      try {
        overseer.permit (ptr);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      overseer.permit (ptr);
    }
// 83
    JP.go.ipa.oz.user.apl.fm.Pointer_if find$val$250;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) arch)) {
      try {
        find$val$250 = arch.find (ptr);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      find$val$250 = arch.find (ptr);
    }
// 83
    return find$val$250;
  }
  
  public JP.go.ipa.oz.user.apl.fm.Pointer_if add (JP.go.ipa.oz.user.apl.fm.FMObject_if obj) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 125
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
        try {
          overseer.permit (obj);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        overseer.permit (obj);
      }
// 126
      JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 129
      JP.go.ipa.oz.lib.standard._Integer_if n = (JP.go.ipa.oz.lib.standard._Integer_cl) (new JP.go.ipa.oz.lib.standard._Integer_cl ())._new_breed (seqNumber++);
// 130
      JP.go.ipa.oz.lib.standard._String_if asString$val$251;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) n)) {
        try {
          asString$val$251 = n.asString ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        asString$val$251 = n.asString ();
      }
// 130
      JP.go.ipa.oz.lib.standard._String_if key = asString$val$251;
// 131
      JP.go.ipa.oz.user.apl.fm.Karte_if karte = (JP.go.ipa.oz.user.apl.fm.Karte_cl) (new JP.go.ipa.oz.user.apl.fm.Karte_cl ())._new_create (obj);
// 132
      JP.go.ipa.oz.lib.standard._Dictionary_if put$val$252;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) elements)) {
        try {
          put$val$252 = elements.put (key, karte);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        put$val$252 = elements.put (key, karte);
      }
// 134
      JP.go.ipa.oz.lib.standard._String_if getGOL$val$253;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          getGOL$val$253 = system.getGOL ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getGOL$val$253 = system.getGOL ();
      }
// 134
      JP.go.ipa.oz.user.apl.fm.Pointer_if ptr = (JP.go.ipa.oz.user.apl.fm.Pointer_cl) (new JP.go.ipa.oz.user.apl.fm.Pointer_cl ())._new_create (getGOL$val$253, key);
// 135
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
        try {
          obj.setIdentifier (ptr);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        obj.setIdentifier (ptr);
      }
// 136
      flushCell ();
// 137
      return ptr;
    } finally {
      leave ();
    }
  }
  
  public JP.go.ipa.oz.user.apl.fm.Pointer_if getIdentifier (JP.go.ipa.oz.user.apl.fm.FMObject_if obj) throws Exception  {
    checkSecureInvocation ();
// 96
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
      try {
        overseer.permit (obj);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      overseer.permit (obj);
    }
// 97
    JP.go.ipa.oz.lib.standard._Iterator_if assocIterator$val$254;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) elements)) {
      try {
        assocIterator$val$254 = elements.assocIterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      assocIterator$val$254 = elements.assocIterator ();
    }
// 97
    JP.go.ipa.oz.lib.standard._Iterator_if iter = assocIterator$val$254;
// 98
    while (true) {
// 98
      boolean hasMoreElements$val$255;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
        try {
          hasMoreElements$val$255 = iter.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$255 = iter.hasMoreElements ();
      }
      if (!(hasMoreElements$val$255)) break;
      
      /* body */ _loop_1: {
// 99
        JP.go.ipa.oz.lib.standard._Association_if assoc = null;
// 99
        JP.go.ipa.oz.lang._Root_if nextElement$val$256;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
          try {
            nextElement$val$256 = iter.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$256 = iter.nextElement ();
        }
// 99
        assoc = (JP.go.ipa.oz.lib.standard._Association_if) (nextElement$val$256);
// 100
        JP.go.ipa.oz.user.apl.fm.Karte_if karte = null;
// 100
        JP.go.ipa.oz.lang._Root_if value$val$257;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) assoc)) {
          try {
            value$val$257 = assoc.value ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          value$val$257 = assoc.value ();
        }
// 100
        karte = (JP.go.ipa.oz.user.apl.fm.Karte_if) (value$val$257);
// 101
        JP.go.ipa.oz.user.apl.fm.FMObject_if fedobj = null;
// 101
        JP.go.ipa.oz.lang._Root_if getValue$val$258;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) karte)) {
          try {
            getValue$val$258 = karte.getValue ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getValue$val$258 = karte.getValue ();
        }
// 101
        fedobj = (JP.go.ipa.oz.user.apl.fm.FMObject_if) (getValue$val$258);
// 102
        boolean isEqualFMObject$val$259;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
          try {
            isEqualFMObject$val$259 = obj.isEqualFMObject (fedobj);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isEqualFMObject$val$259 = obj.isEqualFMObject (fedobj);
        }
// 102
        if (isEqualFMObject$val$259) {{
// 103
            JP.go.ipa.oz.lib.standard._String_if key = null;
// 103
            JP.go.ipa.oz.lang._Root_if key$val$260;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) assoc)) {
              try {
                key$val$260 = assoc.key ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              key$val$260 = assoc.key ();
            }
// 103
            key = (JP.go.ipa.oz.lib.standard._String_if) (key$val$260);
// 104
            JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 105
            JP.go.ipa.oz.lib.standard._String_if getGOL$val$261;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
              try {
                getGOL$val$261 = system.getGOL ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getGOL$val$261 = system.getGOL ();
            }
// 105
            JP.go.ipa.oz.user.apl.fm.Pointer_if ptr = (JP.go.ipa.oz.user.apl.fm.Pointer_cl) (new JP.go.ipa.oz.user.apl.fm.Pointer_cl ())._new_create (getGOL$val$261, key);
// 106
            return ptr;
          }
        }
      }
    }
// 109
    return null;
  }
  
  public boolean contains (JP.go.ipa.oz.user.apl.fm.Pointer_if ptr) throws Exception  {
    checkSecureInvocation ();
// 35
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
      try {
        overseer.permit (ptr);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      overseer.permit (ptr);
    }
// 36
    JP.go.ipa.oz.lib.standard._String_if getName$val$262;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ptr)) {
      try {
        getName$val$262 = ptr.getName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getName$val$262 = ptr.getName ();
    }
// 36
    JP.go.ipa.oz.lib.standard._String_if key = getName$val$262;
// 37
    boolean containsKey$val$263;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) elements)) {
      try {
        containsKey$val$263 = elements.containsKey (key);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      containsKey$val$263 = elements.containsKey (key);
    }
// 37
    return containsKey$val$263;
  }
  
  public void quiet () throws Exception  {
    checkSecureInvocation ();
// 24
    flushCell ();
  }
  
  public JP.go.ipa.oz.user.apl.fm.FMObject_if get (JP.go.ipa.oz.user.apl.fm.Pointer_if ptr) throws Exception  {
    checkSecureInvocation ();
// 48
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
      try {
        overseer.permit (ptr);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      overseer.permit (ptr);
    }
// 50
    JP.go.ipa.oz.user.apl.fm.FMObject_if rtn = null;
// 51
    JP.go.ipa.oz.user.apl.fm.Karte_if karte = null;
// 52
    JP.go.ipa.oz.lib.standard._String_if getName$val$264;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ptr)) {
      try {
        getName$val$264 = ptr.getName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getName$val$264 = ptr.getName ();
    }
// 52
    JP.go.ipa.oz.lib.standard._String_if key = getName$val$264;
// 54
    JP.go.ipa.oz.lang._Root_if get$val$265;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) elements)) {
      try {
        get$val$265 = elements.get (key);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      get$val$265 = elements.get (key);
    }
// 54
    karte = (JP.go.ipa.oz.user.apl.fm.Karte_if) (get$val$265);
// 57
    if (karte == null) {{
// 59
        JP.go.ipa.oz.user.apl.fm.Pointer_if find$val$266;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) arch)) {
          try {
            find$val$266 = arch.find (ptr);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          find$val$266 = arch.find (ptr);
        }
// 59
        ptr = find$val$266;
// 60
        if (ptr == null) {{
// 62
            return null;
          }
        }
// 64
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
          try {
            overseer.permit (ptr);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          overseer.permit (ptr);
        }
// 66
        JP.go.ipa.oz.user.apl.fm.FMObject_if stuff$val$267;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ptr)) {
          try {
            stuff$val$267 = ptr.stuff ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          stuff$val$267 = ptr.stuff ();
        }
// 66
        return stuff$val$267;
      }
    }
// 68
    JP.go.ipa.oz.lang._Root_if getValue$val$268;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) karte)) {
      try {
        getValue$val$268 = karte.getValue ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getValue$val$268 = karte.getValue ();
    }
// 68
    rtn = (JP.go.ipa.oz.user.apl.fm.FMObject_if) (getValue$val$268);
// 69
    return rtn;
  }
  
  public void initialize () throws Exception  {
    checkSecureInvocation ();
// 15
    seqNumber = 0;
// 16
    JP.go.ipa.oz.lib.standard._StringComparator_if sc = (JP.go.ipa.oz.lib.standard._StringComparator_cl) (new JP.go.ipa.oz.lib.standard._StringComparator_cl ())._new_create ();
// 17
    elements = (JP.go.ipa.oz.lib.standard._Dictionary_cl) (new JP.go.ipa.oz.lib.standard._Dictionary_cl ())._new_create (sc);
// 18
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 19
    JP.go.ipa.oz.lib.standard._String_if getGOL$val$269;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        getGOL$val$269 = system.getGOL ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getGOL$val$269 = system.getGOL ();
    }
// 19
    JP.go.ipa.oz.lib.standard._String_if string$46 = (new JP.go.ipa.oz.lib.standard._String_cl("arch"));
    
// 19
    JP.go.ipa.oz.lib.standard._String_if concat$val$270;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getGOL$val$269)) {
      try {
        concat$val$270 = getGOL$val$269.concat (string$46);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$270 = getGOL$val$269.concat (string$46);
    }
// 19
    arch = new JP.go.ipa.oz.user.apl.fm.Archiver_pcl (concat$val$270, "JP.go.ipa.oz.user.apl.fm.Archiver_cl");
// 20
    overseer = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
  }
  
  public JP.go.ipa.oz.user.apl.fm.Pointer_if move (JP.go.ipa.oz.user.apl.fm.Pointer_if oid, JP.go.ipa.oz.user.apl.fm.Pointer_if fid) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 173
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
        try {
          overseer.permit (oid);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        overseer.permit (oid);
      }
// 174
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
        try {
          overseer.permit (fid);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        overseer.permit (fid);
      }
// 175
      JP.go.ipa.oz.user.apl.fm.FMObject_if obj = get (oid);
// 176
      if (obj == null) {{
// 177
          return null;
        }
      }
// 180
      removeWithoutLock (oid);
// 181
      JP.go.ipa.oz.user.apl.fm.FMContainer_if container$val$271;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fid)) {
        try {
          container$val$271 = fid.container ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        container$val$271 = fid.container ();
      }
// 181
      JP.go.ipa.oz.user.apl.fm.FMContainer_if fed = container$val$271;
// 182
      JP.go.ipa.oz.user.apl.fm.Pointer_if add$val$272;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fed)) {
        try {
          add$val$272 = fed.add (obj);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        add$val$272 = fed.add (obj);
      }
// 182
      JP.go.ipa.oz.user.apl.fm.Pointer_if dst = add$val$272;
// 183
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) arch)) {
        try {
          arch.add (oid, dst);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        arch.add (oid, dst);
      }
// 184
      return dst;
    } finally {
      leave ();
    }
  }
  
  public FMContainer_cl () { super ("JP.go.ipa.oz.user.apl.fm.FMContainer_pcl"); }
  
  public FMContainer_cl (String proxy_id) { super (proxy_id); }
  
}

