package JP.go.ipa.oz.user.ide;

final public class CBIGraph_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.ide.CBIGraph_if {
  static final boolean _final_ = true;
  int diameter;
  JP.go.ipa.oz.lib.standard._System_if system;
  JP.go.ipa.oz.user.ide.CBIGraphNode_if primaryNode;
  JP.go.ipa.oz.lib.standard._Dictionary_if nodeList;
  
  public Object _new_newCBIGraph (JP.go.ipa.oz.user.ide.CIPart_if primaryPart) throws Exception  {
// 27
    JP.go.ipa.oz.lib.standard._StringComparator_if sc = null;
// 29
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 31
    sc = (JP.go.ipa.oz.lib.standard._StringComparator_cl) (new JP.go.ipa.oz.lib.standard._StringComparator_cl ())._new_create ();
// 32
    nodeList = (JP.go.ipa.oz.lib.standard._Dictionary_cl) (new JP.go.ipa.oz.lib.standard._Dictionary_cl ())._new_create (sc);
// 33
    primaryNode = (JP.go.ipa.oz.user.ide.CBIGraphNode_cl) (new JP.go.ipa.oz.user.ide.CBIGraphNode_cl ())._new_newCBIGraphNode (primaryPart);
// 34
    JP.go.ipa.oz.lib.standard._String_if getCID$val$347;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) primaryPart)) {
      try {
        getCID$val$347 = primaryPart.getCID ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getCID$val$347 = primaryPart.getCID ();
    }
// 34
    JP.go.ipa.oz.lib.standard._Dictionary_if put$val$348;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nodeList)) {
      try {
        put$val$348 = nodeList.put (getCID$val$347, primaryNode);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      put$val$348 = nodeList.put (getCID$val$347, primaryNode);
    }
// 35
    diameter = 0;
    return this;
  }
  
  public void clearMarks () throws Exception  {
    checkSecureInvocation ();
// 75
    JP.go.ipa.oz.user.ide.CBIGraphNode_if node = null;
// 76
    JP.go.ipa.oz.lib.standard._Iterator_if itr = null;
// 78
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$349;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nodeList)) {
      try {
        iterator$val$349 = nodeList.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$349 = nodeList.iterator ();
    }
// 78
    itr = iterator$val$349;
// 79
    while (true) {
// 79
      boolean hasMoreElements$val$350;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
        try {
          hasMoreElements$val$350 = itr.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$350 = itr.hasMoreElements ();
      }
      if (!(hasMoreElements$val$350)) break;
      
      /* body */ _loop_1: {
// 80
        JP.go.ipa.oz.lang._Root_if nextElement$val$351;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
          try {
            nextElement$val$351 = itr.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$351 = itr.nextElement ();
        }
// 80
        node = (JP.go.ipa.oz.user.ide.CBIGraphNode_if) (nextElement$val$351);
// 81
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) node)) {
          try {
            node.setMark (false);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          node.setMark (false);
        }
      }
    }
  }
  
  public void addPart (JP.go.ipa.oz.user.ide.CIPart_if part, JP.go.ipa.oz.lib.standard._Collection_if superParts) throws Exception  {
    checkSecureInvocation ();
// 44
    JP.go.ipa.oz.user.ide.CBIGraphNode_if baseNode = null, superNode = null;
// 45
    JP.go.ipa.oz.user.ide.CIPart_if superPart = null;
// 46
    JP.go.ipa.oz.lib.standard._String_if thisCID = null, superCID = null;
// 47
    JP.go.ipa.oz.lib.standard._Iterator_if itr = null;
// 49
    JP.go.ipa.oz.lib.standard._String_if getCID$val$352;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) part)) {
      try {
        getCID$val$352 = part.getCID ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getCID$val$352 = part.getCID ();
    }
// 49
    thisCID = getCID$val$352;
// 50
    JP.go.ipa.oz.lib.standard._String_if string$55 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCBIGraph#addPart: "));
    
// 50
    JP.go.ipa.oz.lib.standard._String_if concat$val$353;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$55)) {
      try {
        concat$val$353 = string$55.concat (thisCID);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$353 = string$55.concat (thisCID);
    }
// 50
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.debugPrintln (concat$val$353);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.debugPrintln (concat$val$353);
    }
// 51
    JP.go.ipa.oz.lang._Root_if get$val$354;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nodeList)) {
      try {
        get$val$354 = nodeList.get (thisCID);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      get$val$354 = nodeList.get (thisCID);
    }
// 51
    baseNode = (JP.go.ipa.oz.user.ide.CBIGraphNode_if) (get$val$354);
// 52
    if (baseNode == null) {{
// 53
        baseNode = (JP.go.ipa.oz.user.ide.CBIGraphNode_cl) (new JP.go.ipa.oz.user.ide.CBIGraphNode_cl ())._new_newCBIGraphNode (part);
// 54
        JP.go.ipa.oz.lib.standard._Dictionary_if put$val$355;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nodeList)) {
          try {
            put$val$355 = nodeList.put (thisCID, baseNode);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          put$val$355 = nodeList.put (thisCID, baseNode);
        }
      }
    }
// 57
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$356;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) superParts)) {
      try {
        iterator$val$356 = superParts.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$356 = superParts.iterator ();
    }
// 57
    itr = iterator$val$356;
// 58
    while (true) {
// 58
      boolean hasMoreElements$val$357;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
        try {
          hasMoreElements$val$357 = itr.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$357 = itr.hasMoreElements ();
      }
      if (!(hasMoreElements$val$357)) break;
      
      /* body */ _loop_1: {
// 59
        JP.go.ipa.oz.lang._Root_if nextElement$val$358;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
          try {
            nextElement$val$358 = itr.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$358 = itr.nextElement ();
        }
// 59
        superPart = (JP.go.ipa.oz.user.ide.CIPart_if) (nextElement$val$358);
// 60
        JP.go.ipa.oz.lib.standard._String_if getCID$val$359;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) superPart)) {
          try {
            getCID$val$359 = superPart.getCID ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getCID$val$359 = superPart.getCID ();
        }
// 60
        superCID = getCID$val$359;
// 61
        JP.go.ipa.oz.lang._Root_if get$val$360;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nodeList)) {
          try {
            get$val$360 = nodeList.get (superCID);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          get$val$360 = nodeList.get (superCID);
        }
// 61
        superNode = (JP.go.ipa.oz.user.ide.CBIGraphNode_if) (get$val$360);
// 62
        if (superNode == null) {{
// 63
            superNode = (JP.go.ipa.oz.user.ide.CBIGraphNode_cl) (new JP.go.ipa.oz.user.ide.CBIGraphNode_cl ())._new_newCBIGraphNode (superPart);
// 64
            JP.go.ipa.oz.lib.standard._Dictionary_if put$val$361;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nodeList)) {
              try {
                put$val$361 = nodeList.put (superCID, superNode);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              put$val$361 = nodeList.put (superCID, superNode);
            }
          }
        }
// 66
        baseNode.addSuperNode (superNode);
// 67
        superNode.addSubNode (baseNode);
      }
    }
  }
  
  public JP.go.ipa.oz.user.ide.CBIGraphNode_if getNode (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception  {
    checkSecureInvocation ();
// 89
    JP.go.ipa.oz.user.ide.CBIGraphNode_if node = null;
// 91
    JP.go.ipa.oz.lang._Root_if get$val$362;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nodeList)) {
      try {
        get$val$362 = nodeList.get (cid);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      get$val$362 = nodeList.get (cid);
    }
// 91
    node = (JP.go.ipa.oz.user.ide.CBIGraphNode_if) (get$val$362);
// 93
    return node;
  }
  
  public int size () throws Exception  {
    checkSecureInvocation ();
// 114
    int size$val$363;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nodeList)) {
      try {
        size$val$363 = nodeList.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$363 = nodeList.size ();
    }
// 114
    return size$val$363;
  }
  
  public JP.go.ipa.oz.lib.standard._Iterator_if nodes () throws Exception  {
    checkSecureInvocation ();
// 107
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$364;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nodeList)) {
      try {
        iterator$val$364 = nodeList.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$364 = nodeList.iterator ();
    }
// 107
    return iterator$val$364;
  }
  
  public JP.go.ipa.oz.user.ide.CBIGraphNode_if getPrimaryNode () throws Exception  {
    checkSecureInvocation ();
// 100
    return primaryNode;
  }
  
  public CBIGraph_cl () throws Exception { super (); }
  
}

