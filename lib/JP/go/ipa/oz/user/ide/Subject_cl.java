package JP.go.ipa.oz.user.ide;

public class Subject_cl extends JP.go.ipa.oz.user.ide.Summarizable_cl implements JP.go.ipa.oz.user.ide.Subject_if {
  JP.go.ipa.oz.lib.standard._Dictionary_if labels;
  boolean released;
  boolean imported;
  int releaseMode;
  JP.go.ipa.oz.lib.standard._String_if subjectName;
  JP.go.ipa.oz.lib.standard._String_if ifPkgName;
  boolean using;
  JP.go.ipa.oz.lib.standard._String_if clPkgName;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._String_if sname) throws Exception  {
// 56
    subjectName = sname;
// 57
    released = false;
// 58
    imported = false;
// 59
    JP.go.ipa.oz.lib.standard._StringComparator_if sc = (JP.go.ipa.oz.lib.standard._StringComparator_cl) (new JP.go.ipa.oz.lib.standard._StringComparator_cl ())._new_create ();
// 60
    labels = (JP.go.ipa.oz.lib.standard._Dictionary_cl) (new JP.go.ipa.oz.lib.standard._Dictionary_cl ())._new_create (sc);
// 61
    releaseMode = 1;
// 62
    using = true;
    return this;
  }
  
  public Object _new_create () throws Exception  {
// 42
    subjectName = (new JP.go.ipa.oz.lib.standard._String_cl("default"));
// 43
    JP.go.ipa.oz.lib.standard._StringComparator_if sc = (JP.go.ipa.oz.lib.standard._StringComparator_cl) (new JP.go.ipa.oz.lib.standard._StringComparator_cl ())._new_create ();
// 44
    labels = (JP.go.ipa.oz.lib.standard._Dictionary_cl) (new JP.go.ipa.oz.lib.standard._Dictionary_cl ())._new_create (sc);
// 45
    released = false;
// 46
    imported = false;
// 47
    releaseMode = 1;
// 48
    using = true;
    return this;
  }
  
  public JP.go.ipa.oz.user.ide.OzLabel_if getOzLabel (JP.go.ipa.oz.lib.standard._String_if labelName) throws Exception  {
    checkSecureInvocation ();
// 200
    JP.go.ipa.oz.user.ide.OzLabel_if lbl = null;
// 201
    JP.go.ipa.oz.lang._Root_if get$val$447;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) labels)) {
      try {
        get$val$447 = labels.get (labelName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      get$val$447 = labels.get (labelName);
    }
// 201
    lbl = (JP.go.ipa.oz.user.ide.OzLabel_if) (get$val$447);
// 202
    return lbl;
  }
  
  public void removeAll () throws Exception  {
    checkSecureInvocation ();
// 270
    JP.go.ipa.oz.lib.standard._Plural_if clear$val$448;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) labels)) {
      try {
        clear$val$448 = labels.clear ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      clear$val$448 = labels.clear ();
    }
  }
  
  public void setReleaseMode (int bo) throws Exception  {
    checkSecureInvocation ();
// 157
    releaseMode = bo;
  }
  
  public boolean getUsing () throws Exception  {
    checkSecureInvocation ();
// 87
    return using;
  }
  
  public void removeOzLabel (JP.go.ipa.oz.lib.standard._String_if labelName) throws Exception  {
    checkSecureInvocation ();
// 264
    JP.go.ipa.oz.lib.standard._Dictionary_if remove$val$449;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) labels)) {
      try {
        remove$val$449 = labels.remove (labelName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      remove$val$449 = labels.remove (labelName);
    }
  }
  
  public void setPackageName (JP.go.ipa.oz.lib.standard._String_if name) throws Exception  {
    checkSecureInvocation ();
// 138
    if (releaseMode == 1) {
// 139
      ifPkgName = name;
    } else {
// 140
      if (releaseMode == 2) {
// 141
        clPkgName = name;
      } else {
// 143
        ifPkgName = name;
      }
    }
  }
  
  public JP.go.ipa.oz.user.ide.OzLabel_if getOzLabelOfInterface (JP.go.ipa.oz.lib.standard._String_if interfaceID) throws Exception  {
    checkSecureInvocation ();
// 210
    JP.go.ipa.oz.user.ide.OzLabel_if tmpOzLabel = null;
// 211
    JP.go.ipa.oz.lib.standard._Iterator_if lblIterator = null;
// 212
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$450;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) labels)) {
      try {
        iterator$val$450 = labels.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$450 = labels.iterator ();
    }
// 212
    lblIterator = iterator$val$450;
// 214
    while (true) {
// 214
      boolean hasMoreElements$val$451;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
        try {
          hasMoreElements$val$451 = lblIterator.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$451 = lblIterator.hasMoreElements ();
      }
      if (!(hasMoreElements$val$451)) break;
      
      /* body */ _loop_1: {
// 215
        JP.go.ipa.oz.lang._Root_if nextElement$val$452;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
          try {
            nextElement$val$452 = lblIterator.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$452 = lblIterator.nextElement ();
        }
// 215
        tmpOzLabel = (JP.go.ipa.oz.user.ide.OzLabel_if) (nextElement$val$452);
// 216
        JP.go.ipa.oz.lib.standard._String_if getInterfaceID$val$453;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpOzLabel)) {
          try {
            getInterfaceID$val$453 = tmpOzLabel.getInterfaceID ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getInterfaceID$val$453 = tmpOzLabel.getInterfaceID ();
        }
// 216
        int compareTo$val$454;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getInterfaceID$val$453)) {
          try {
            compareTo$val$454 = getInterfaceID$val$453.compareTo (interfaceID);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          compareTo$val$454 = getInterfaceID$val$453.compareTo (interfaceID);
        }
// 216
        if (compareTo$val$454 == 0) {
// 216
          return tmpOzLabel;
        }
      }
    }
// 218
    return null;
  }
  
  public void setImported (boolean bo) throws Exception  {
    checkSecureInvocation ();
// 118
    imported = bo;
  }
  
  public void putOzLabel (JP.go.ipa.oz.lib.standard._Dictionary_if lbls) throws Exception  {
    checkSecureInvocation ();
// 249
    JP.go.ipa.oz.lib.standard._String_if labelName = null;
// 250
    JP.go.ipa.oz.user.ide.OzLabel_if tmpOzLabel = null;
// 251
    JP.go.ipa.oz.lib.standard._Iterator_if lblIterator = null;
// 252
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$455;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lbls)) {
      try {
        iterator$val$455 = lbls.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$455 = lbls.iterator ();
    }
// 252
    lblIterator = iterator$val$455;
// 253
    while (true) {
// 253
      boolean hasMoreElements$val$456;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
        try {
          hasMoreElements$val$456 = lblIterator.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$456 = lblIterator.hasMoreElements ();
      }
      if (!(hasMoreElements$val$456)) break;
      
      /* body */ _loop_1: {
// 254
        JP.go.ipa.oz.lang._Root_if nextElement$val$457;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
          try {
            nextElement$val$457 = lblIterator.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$457 = lblIterator.nextElement ();
        }
// 254
        tmpOzLabel = (JP.go.ipa.oz.user.ide.OzLabel_if) (nextElement$val$457);
// 255
        JP.go.ipa.oz.lib.standard._String_if getOzLabelName$val$458;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpOzLabel)) {
          try {
            getOzLabelName$val$458 = tmpOzLabel.getOzLabelName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getOzLabelName$val$458 = tmpOzLabel.getOzLabelName ();
        }
// 255
        labelName = getOzLabelName$val$458;
// 256
        JP.go.ipa.oz.lib.standard._Dictionary_if put$val$459;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) labels)) {
          try {
            put$val$459 = labels.put (labelName, tmpOzLabel);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          put$val$459 = labels.put (labelName, tmpOzLabel);
        }
      }
    }
  }
  
  public void putOzLabel (JP.go.ipa.oz.user.ide.OzLabel_if aOzLabel) throws Exception  {
    checkSecureInvocation ();
// 240
    JP.go.ipa.oz.lib.standard._String_if labelName = null;
// 241
    JP.go.ipa.oz.lib.standard._String_if getOzLabelName$val$460;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) aOzLabel)) {
      try {
        getOzLabelName$val$460 = aOzLabel.getOzLabelName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzLabelName$val$460 = aOzLabel.getOzLabelName ();
    }
// 241
    labelName = getOzLabelName$val$460;
// 242
    JP.go.ipa.oz.lib.standard._Dictionary_if put$val$461;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) labels)) {
      try {
        put$val$461 = labels.put (labelName, aOzLabel);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      put$val$461 = labels.put (labelName, aOzLabel);
    }
  }
  
  public void setReleased (boolean bo) throws Exception  {
    checkSecureInvocation ();
// 105
    released = bo;
  }
  
  public boolean isImported () throws Exception  {
    checkSecureInvocation ();
// 112
    return imported;
  }
  
  public JP.go.ipa.oz.lib.standard._Dictionary_if getOzLabels () throws Exception  {
    checkSecureInvocation ();
// 192
    return labels;
  }
  
  public void setClPackageName (JP.go.ipa.oz.lib.standard._String_if name) throws Exception  {
    checkSecureInvocation ();
// 185
    clPkgName = name;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getClPackageName () throws Exception  {
    checkSecureInvocation ();
// 178
    return clPkgName;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getSubjectName () throws Exception  {
    checkSecureInvocation ();
// 73
    return subjectName;
  }
  
  public boolean isReleased () throws Exception  {
    checkSecureInvocation ();
// 99
    return released;
  }
  
  public void setIfPackageName (JP.go.ipa.oz.lib.standard._String_if name) throws Exception  {
    checkSecureInvocation ();
// 171
    ifPkgName = name;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getIfPackageName () throws Exception  {
    checkSecureInvocation ();
// 164
    return ifPkgName;
  }
  
  public void setUsing (boolean bo) throws Exception  {
    checkSecureInvocation ();
// 93
    using = bo;
  }
  
  public int getReleaseMode () throws Exception  {
    checkSecureInvocation ();
// 150
    return releaseMode;
  }
  
  public JP.go.ipa.oz.user.ide.OzLabel_if getOzLabelOfImplementation (JP.go.ipa.oz.lib.standard._String_if implementationID) throws Exception  {
    checkSecureInvocation ();
// 226
    JP.go.ipa.oz.user.ide.OzLabel_if tmpOzLabel = null;
// 227
    JP.go.ipa.oz.lib.standard._Iterator_if lblIterator = null;
// 228
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$462;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) labels)) {
      try {
        iterator$val$462 = labels.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$462 = labels.iterator ();
    }
// 228
    lblIterator = iterator$val$462;
// 229
    while (true) {
// 229
      boolean hasMoreElements$val$463;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
        try {
          hasMoreElements$val$463 = lblIterator.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$463 = lblIterator.hasMoreElements ();
      }
      if (!(hasMoreElements$val$463)) break;
      
      /* body */ _loop_1: {
// 230
        JP.go.ipa.oz.lang._Root_if nextElement$val$464;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
          try {
            nextElement$val$464 = lblIterator.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$464 = lblIterator.nextElement ();
        }
// 230
        tmpOzLabel = (JP.go.ipa.oz.user.ide.OzLabel_if) (nextElement$val$464);
// 231
        JP.go.ipa.oz.lib.standard._String_if getImplementationID$val$465;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpOzLabel)) {
          try {
            getImplementationID$val$465 = tmpOzLabel.getImplementationID ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getImplementationID$val$465 = tmpOzLabel.getImplementationID ();
        }
// 231
        int compareTo$val$466;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) (getImplementationID$val$465))) {
          try {
            compareTo$val$466 = (getImplementationID$val$465).compareTo (implementationID);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          compareTo$val$466 = (getImplementationID$val$465).compareTo (implementationID);
        }
// 231
        if ((compareTo$val$466) == 0) {
// 231
          return tmpOzLabel;
        }
      }
    }
// 233
    return null;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getPackageName () throws Exception  {
    checkSecureInvocation ();
// 125
    if (releaseMode == 1) {
// 126
      return ifPkgName;
    } else {
// 127
      if (releaseMode == 2) {
// 128
        return clPkgName;
      } else {
// 129
        if (releaseMode == 3) {
// 131
          return ifPkgName;
        }
      }
    }
// 131
    return (new JP.go.ipa.oz.lib.standard._String_cl(""));
  }
  
  public void setSubjectName (JP.go.ipa.oz.lib.standard._String_if sname) throws Exception  {
    checkSecureInvocation ();
// 81
    subjectName = sname;
  }
  
  public Subject_cl () throws Exception { super (); }
  
}

