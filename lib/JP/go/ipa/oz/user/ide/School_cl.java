package JP.go.ipa.oz.user.ide;

public class School_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.ide.School_if {
  JP.go.ipa.oz.lib.standard._Dictionary_if duplicates;
  JP.go.ipa.oz.lib.standard._Dictionary_if subjects;
  
  public Object _new_create () throws Exception  {
// 43
    JP.go.ipa.oz.lib.standard._StringComparator_if sc = (JP.go.ipa.oz.lib.standard._StringComparator_cl) (new JP.go.ipa.oz.lib.standard._StringComparator_cl ())._new_create ();
// 44
    subjects = (JP.go.ipa.oz.lib.standard._Dictionary_cl) (new JP.go.ipa.oz.lib.standard._Dictionary_cl ())._new_create (sc);
// 45
    duplicates = (JP.go.ipa.oz.lib.standard._Dictionary_cl) (new JP.go.ipa.oz.lib.standard._Dictionary_cl ())._new_create (sc);
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getNameOfInterface (JP.go.ipa.oz.lib.standard._String_if interfaceID) throws Exception  {
    checkSecureInvocation ();
// 124
    JP.go.ipa.oz.user.ide.OzLabel_if label = null;
// 125
    JP.go.ipa.oz.lib.standard._String_if ifID = null;
// 127
    JP.go.ipa.oz.lib.standard._String_if string$79 = (new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz.user.released."));
    
// 127
    boolean startsWith$val$534;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) interfaceID)) {
      try {
        startsWith$val$534 = interfaceID.startsWith (string$79);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      startsWith$val$534 = interfaceID.startsWith (string$79);
    }
// 127
    if (startsWith$val$534) {
// 128
      JP.go.ipa.oz.lib.standard._String_if substring$val$535;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) interfaceID)) {
        try {
          substring$val$535 = interfaceID.substring (27);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        substring$val$535 = interfaceID.substring (27);
      }
// 128
      ifID = substring$val$535;
    } else {
// 129
      JP.go.ipa.oz.lib.standard._String_if string$80 = (new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz.user."));
      
// 129
      boolean startsWith$val$536;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) interfaceID)) {
        try {
          startsWith$val$536 = interfaceID.startsWith (string$80);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        startsWith$val$536 = interfaceID.startsWith (string$80);
      }
// 129
      if (startsWith$val$536) {
// 130
        JP.go.ipa.oz.lib.standard._String_if substring$val$537;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) interfaceID)) {
          try {
            substring$val$537 = interfaceID.substring (18);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          substring$val$537 = interfaceID.substring (18);
        }
// 130
        ifID = substring$val$537;
      } else {
        boolean bool$val$22;
        
// 131
        JP.go.ipa.oz.lib.standard._String_if string$81 = (new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz.lib."));
        
// 131
        boolean startsWith$val$538;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) interfaceID)) {
          try {
            startsWith$val$538 = interfaceID.startsWith (string$81);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          startsWith$val$538 = interfaceID.startsWith (string$81);
        }
        bool$val$22 = startsWith$val$538;
        if (!bool$val$22) {
// 131
          JP.go.ipa.oz.lib.standard._String_if string$82 = (new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz.lang."));
          
// 131
          boolean startsWith$val$539;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) interfaceID)) {
            try {
              startsWith$val$539 = interfaceID.startsWith (string$82);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            startsWith$val$539 = interfaceID.startsWith (string$82);
          }
          bool$val$22 = startsWith$val$539;
        }
// 131
        if (bool$val$22) {
// 132
          JP.go.ipa.oz.lib.standard._String_if substring$val$540;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) interfaceID)) {
            try {
              substring$val$540 = interfaceID.substring (12);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            substring$val$540 = interfaceID.substring (12);
          }
// 132
          ifID = substring$val$540;
        }
      }
    }
// 134
    label = getOzLabelOfInterface (ifID);
// 135
    if (label == null) {
// 136
      return null;
    }
// 136
    JP.go.ipa.oz.lib.standard._String_if getOzLabelName$val$541;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) label)) {
      try {
        getOzLabelName$val$541 = label.getOzLabelName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzLabelName$val$541 = label.getOzLabelName ();
    }
// 136
    return getOzLabelName$val$541;
  }
  
  public JP.go.ipa.oz.user.ide.OzLabel_if getOzLabel (JP.go.ipa.oz.lib.standard._String_if labelName) throws Exception  {
    checkSecureInvocation ();
// 193
    JP.go.ipa.oz.user.ide.OzLabel_if lbl = null;
// 194
    JP.go.ipa.oz.lib.standard._Dictionary_if getAllLabels$val$542;
    getAllLabels$val$542 = getAllLabels ();
// 194
    JP.go.ipa.oz.lang._Root_if get$val$543;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getAllLabels$val$542)) {
      try {
        get$val$543 = getAllLabels$val$542.get (labelName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      get$val$543 = getAllLabels$val$542.get (labelName);
    }
// 194
    lbl = (JP.go.ipa.oz.user.ide.OzLabel_if) (get$val$543);
// 195
    return lbl;
  }
  
  public void setDuplicates (JP.go.ipa.oz.lib.standard._Dictionary_if dict) throws Exception  {
    checkSecureInvocation ();
// 564
    duplicates = dict;
  }
  
  public void loadFromFile (JP.go.ipa.oz.lib.standard._String_if fileName, JP.go.ipa.oz.lib.standard._String_if subjectName) throws Exception  {
    checkSecureInvocation ();
// 573
    JP.go.ipa.oz.user.ide.SchoolUtility_if schoolUtility = (JP.go.ipa.oz.user.ide.SchoolUtility_cl) (new JP.go.ipa.oz.user.ide.SchoolUtility_cl ())._new_create (subjects);
// 574
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) schoolUtility)) {
      try {
        schoolUtility.loadFromFile (fileName, subjectName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      schoolUtility.loadFromFile (fileName, subjectName);
    }
  }
  
  public JP.go.ipa.oz.user.ide.School_if putSubject (JP.go.ipa.oz.user.ide.Subject_if aSubject) throws Exception  {
    checkSecureInvocation ();
// 282
    JP.go.ipa.oz.lib.standard._String_if subjectName = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ();
// 283
    JP.go.ipa.oz.lib.standard._String_if getSubjectName$val$544;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) aSubject)) {
      try {
        getSubjectName$val$544 = aSubject.getSubjectName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSubjectName$val$544 = aSubject.getSubjectName ();
    }
// 283
    subjectName = getSubjectName$val$544;
// 284
    JP.go.ipa.oz.lib.standard._Dictionary_if put$val$545;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subjects)) {
      try {
        put$val$545 = subjects.put (subjectName, aSubject);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      put$val$545 = subjects.put (subjectName, aSubject);
    }
// 285
    return this;
  }
  
  public JP.go.ipa.oz.user.ide.School_if removeOzLabel (JP.go.ipa.oz.lib.standard._String_if labelName, JP.go.ipa.oz.lib.standard._String_if subjectName) throws Exception  {
    checkSecureInvocation ();
// 255
    JP.go.ipa.oz.user.ide.Subject_if subject = null;
// 256
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$546;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subjects)) {
      try {
        iterator$val$546 = subjects.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$546 = subjects.iterator ();
    }
// 256
    JP.go.ipa.oz.lib.standard._Iterator_if sbjIterator = iterator$val$546;
// 257
    while (true) {
// 257
      boolean hasMoreElements$val$547;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbjIterator)) {
        try {
          hasMoreElements$val$547 = sbjIterator.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$547 = sbjIterator.hasMoreElements ();
      }
      if (!(hasMoreElements$val$547)) break;
      
      /* body */ _loop_1: {
// 258
        JP.go.ipa.oz.lang._Root_if nextElement$val$548;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbjIterator)) {
          try {
            nextElement$val$548 = sbjIterator.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$548 = sbjIterator.nextElement ();
        }
// 258
        subject = (JP.go.ipa.oz.user.ide.Subject_if) (nextElement$val$548);
// 259
        JP.go.ipa.oz.lib.standard._String_if getSubjectName$val$549;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
          try {
            getSubjectName$val$549 = subject.getSubjectName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSubjectName$val$549 = subject.getSubjectName ();
        }
// 259
        int compareTo$val$550;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSubjectName$val$549)) {
          try {
            compareTo$val$550 = getSubjectName$val$549.compareTo (subjectName);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          compareTo$val$550 = getSubjectName$val$549.compareTo (subjectName);
        }
// 259
        if (compareTo$val$550 == 0) {{
// 260
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
              try {
                subject.removeOzLabel (labelName);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              subject.removeOzLabel (labelName);
            }
// 261
            return this;
          }
        }
      }
    }
// 264
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getNameOfImplementation (JP.go.ipa.oz.lib.standard._String_if implementationID) throws Exception  {
    checkSecureInvocation ();
// 145
    JP.go.ipa.oz.user.ide.OzLabel_if label = null;
// 146
    JP.go.ipa.oz.lib.standard._String_if clID = null;
// 148
    JP.go.ipa.oz.lib.standard._String_if string$83 = (new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz.user.released."));
    
// 148
    boolean startsWith$val$551;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) implementationID)) {
      try {
        startsWith$val$551 = implementationID.startsWith (string$83);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      startsWith$val$551 = implementationID.startsWith (string$83);
    }
// 148
    if (startsWith$val$551) {
// 149
      JP.go.ipa.oz.lib.standard._String_if substring$val$552;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) implementationID)) {
        try {
          substring$val$552 = implementationID.substring (27);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        substring$val$552 = implementationID.substring (27);
      }
// 149
      clID = substring$val$552;
    } else {
// 150
      JP.go.ipa.oz.lib.standard._String_if string$84 = (new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz.user."));
      
// 150
      boolean startsWith$val$553;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) implementationID)) {
        try {
          startsWith$val$553 = implementationID.startsWith (string$84);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        startsWith$val$553 = implementationID.startsWith (string$84);
      }
// 150
      if (startsWith$val$553) {
// 151
        JP.go.ipa.oz.lib.standard._String_if substring$val$554;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) implementationID)) {
          try {
            substring$val$554 = implementationID.substring (18);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          substring$val$554 = implementationID.substring (18);
        }
// 151
        clID = substring$val$554;
      } else {
        boolean bool$val$23;
        
// 152
        JP.go.ipa.oz.lib.standard._String_if string$85 = (new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz.lib."));
        
// 152
        boolean startsWith$val$555;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) implementationID)) {
          try {
            startsWith$val$555 = implementationID.startsWith (string$85);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          startsWith$val$555 = implementationID.startsWith (string$85);
        }
        bool$val$23 = startsWith$val$555;
        if (!bool$val$23) {
// 152
          JP.go.ipa.oz.lib.standard._String_if string$86 = (new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz.lang."));
          
// 152
          boolean startsWith$val$556;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) implementationID)) {
            try {
              startsWith$val$556 = implementationID.startsWith (string$86);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            startsWith$val$556 = implementationID.startsWith (string$86);
          }
          bool$val$23 = startsWith$val$556;
        }
// 152
        if (bool$val$23) {
// 153
          JP.go.ipa.oz.lib.standard._String_if substring$val$557;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) implementationID)) {
            try {
              substring$val$557 = implementationID.substring (12);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            substring$val$557 = implementationID.substring (12);
          }
// 153
          clID = substring$val$557;
        }
      }
    }
// 155
    label = getOzLabelOfImplementation (clID);
// 156
    if (label == null) {
// 157
      return null;
    }
// 157
    JP.go.ipa.oz.lib.standard._String_if getOzLabelName$val$558;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) label)) {
      try {
        getOzLabelName$val$558 = label.getOzLabelName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzLabelName$val$558 = label.getOzLabelName ();
    }
// 157
    return getOzLabelName$val$558;
  }
  
  public JP.go.ipa.oz.user.ide.OzLabel_if getOzLabelOfInterface (JP.go.ipa.oz.lib.standard._String_if interfaceID) throws Exception  {
    checkSecureInvocation ();
// 204
    JP.go.ipa.oz.user.ide.OzLabel_if tmpOzLabel = null;
// 205
    JP.go.ipa.oz.lib.standard._Iterator_if lblIterator = null;
// 206
    JP.go.ipa.oz.lib.standard._Dictionary_if getAllLabels$val$559;
    getAllLabels$val$559 = getAllLabels ();
// 206
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$560;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getAllLabels$val$559)) {
      try {
        iterator$val$560 = getAllLabels$val$559.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$560 = getAllLabels$val$559.iterator ();
    }
// 206
    lblIterator = iterator$val$560;
// 208
    while (true) {
// 208
      boolean hasMoreElements$val$561;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
        try {
          hasMoreElements$val$561 = lblIterator.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$561 = lblIterator.hasMoreElements ();
      }
      if (!(hasMoreElements$val$561)) break;
      
      /* body */ _loop_1: {
// 209
        JP.go.ipa.oz.lang._Root_if nextElement$val$562;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
          try {
            nextElement$val$562 = lblIterator.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$562 = lblIterator.nextElement ();
        }
// 209
        tmpOzLabel = (JP.go.ipa.oz.user.ide.OzLabel_if) (nextElement$val$562);
// 210
        JP.go.ipa.oz.lib.standard._String_if getInterfaceID$val$563;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpOzLabel)) {
          try {
            getInterfaceID$val$563 = tmpOzLabel.getInterfaceID ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getInterfaceID$val$563 = tmpOzLabel.getInterfaceID ();
        }
// 210
        int compareTo$val$564;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getInterfaceID$val$563)) {
          try {
            compareTo$val$564 = getInterfaceID$val$563.compareTo (interfaceID);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          compareTo$val$564 = getInterfaceID$val$563.compareTo (interfaceID);
        }
// 210
        if (compareTo$val$564 == 0) {
// 210
          return tmpOzLabel;
        }
      }
    }
// 212
    return null;
  }
  
  public int getNumOfLabels (JP.go.ipa.oz.lib.standard._String_if subjectName) throws Exception  {
    checkSecureInvocation ();
// 422
    JP.go.ipa.oz.lib.standard._Dictionary_if getOzLabels$val$565;
    getOzLabels$val$565 = getOzLabels (subjectName);
// 422
    int size$val$566;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getOzLabels$val$565)) {
      try {
        size$val$566 = getOzLabels$val$565.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$566 = getOzLabels$val$565.size ();
    }
// 422
    return size$val$566;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getLabelPath (JP.go.ipa.oz.lib.standard._String_if labelName) throws Exception  {
    checkSecureInvocation ();
// 354
    JP.go.ipa.oz.lib.standard._String_if ozHome = null;
// 355
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 356
    JP.go.ipa.oz.lib.standard._String_if getOzHome$val$567;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        getOzHome$val$567 = system.getOzHome ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzHome$val$567 = system.getOzHome ();
    }
// 356
    ozHome = getOzHome$val$567;
// 357
    JP.go.ipa.oz.lib.standard._StringBuffer_if fullPath = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 359
    JP.go.ipa.oz.lib.standard._String_if string$87 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
    
// 359
    boolean startsWith$val$568;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozHome)) {
      try {
        startsWith$val$568 = ozHome.startsWith (string$87);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      startsWith$val$568 = ozHome.startsWith (string$87);
    }
// 359
    if (startsWith$val$568) {{
// 360
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$569;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fullPath)) {
          try {
            append$val$569 = fullPath.append (ozHome);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$569 = fullPath.append (ozHome);
        }
// 361
        JP.go.ipa.oz.lib.standard._String_if string$88 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
        
// 361
        boolean endsWith$val$570;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozHome)) {
          try {
            endsWith$val$570 = ozHome.endsWith (string$88);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          endsWith$val$570 = ozHome.endsWith (string$88);
        }
// 361
        if (!(endsWith$val$570)) {
// 362
          JP.go.ipa.oz.lib.standard._String_if string$89 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
          
// 362
          JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$571;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fullPath)) {
            try {
              append$val$571 = fullPath.append (string$89);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            append$val$571 = fullPath.append (string$89);
          }
        }
// 363
        JP.go.ipa.oz.lib.standard._String_if string$90 = (new JP.go.ipa.oz.lib.standard._String_cl("lib/"));
        
// 363
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$572;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fullPath)) {
          try {
            append$val$572 = fullPath.append (string$90);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$572 = fullPath.append (string$90);
        }
      }
    } else {{
// 365
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$573;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fullPath)) {
          try {
            append$val$573 = fullPath.append (ozHome);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$573 = fullPath.append (ozHome);
        }
// 366
        JP.go.ipa.oz.lib.standard._String_if string$91 = (new JP.go.ipa.oz.lib.standard._String_cl("\\"));
        
// 366
        boolean endsWith$val$574;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozHome)) {
          try {
            endsWith$val$574 = ozHome.endsWith (string$91);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          endsWith$val$574 = ozHome.endsWith (string$91);
        }
// 366
        if (!(endsWith$val$574)) {
// 367
          JP.go.ipa.oz.lib.standard._String_if string$92 = (new JP.go.ipa.oz.lib.standard._String_cl("\\"));
          
// 367
          JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$575;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fullPath)) {
            try {
              append$val$575 = fullPath.append (string$92);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            append$val$575 = fullPath.append (string$92);
          }
        }
// 368
        JP.go.ipa.oz.lib.standard._String_if string$93 = (new JP.go.ipa.oz.lib.standard._String_cl("lib\\"));
        
// 368
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$576;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fullPath)) {
          try {
            append$val$576 = fullPath.append (string$93);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$576 = fullPath.append (string$93);
        }
      }
    }
// 372
    JP.go.ipa.oz.lib.standard._String_if cid = null;
// 373
    JP.go.ipa.oz.lib.standard._String_if string$94 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
    
// 373
    boolean startsWith$val$577;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozHome)) {
      try {
        startsWith$val$577 = ozHome.startsWith (string$94);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      startsWith$val$577 = ozHome.startsWith (string$94);
    }
// 373
    if (startsWith$val$577) {
// 374
      JP.go.ipa.oz.lib.standard._String_if getInterfaceID$val$578;
      getInterfaceID$val$578 = getInterfaceID (labelName);
// 374
      JP.go.ipa.oz.lib.standard._String_if replace$val$579;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getInterfaceID$val$578)) {
        try {
          replace$val$579 = getInterfaceID$val$578.replace ('.', '/');
        } finally {
          changeRunningToGreen ();
        }
      } else {
        replace$val$579 = getInterfaceID$val$578.replace ('.', '/');
      }
// 374
      cid = replace$val$579;
    } else {
// 376
      JP.go.ipa.oz.lib.standard._String_if getInterfaceID$val$580;
      getInterfaceID$val$580 = getInterfaceID (labelName);
// 376
      JP.go.ipa.oz.lib.standard._String_if replace$val$581;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getInterfaceID$val$580)) {
        try {
          replace$val$581 = getInterfaceID$val$580.replace ('.', '\\');
        } finally {
          changeRunningToGreen ();
        }
      } else {
        replace$val$581 = getInterfaceID$val$580.replace ('.', '\\');
      }
// 376
      cid = replace$val$581;
    }
// 378
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$582;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fullPath)) {
      try {
        append$val$582 = fullPath.append (cid);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$582 = fullPath.append (cid);
    }
// 380
    JP.go.ipa.oz.lib.standard._String_if path = null;
// 381
    JP.go.ipa.oz.lib.standard._String_if asString$val$583;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fullPath)) {
      try {
        asString$val$583 = fullPath.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$583 = fullPath.asString ();
    }
// 381
    path = asString$val$583;
// 382
    JP.go.ipa.oz.lib.standard._String_if string$95 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
    
// 382
    boolean startsWith$val$584;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozHome)) {
      try {
        startsWith$val$584 = ozHome.startsWith (string$95);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      startsWith$val$584 = ozHome.startsWith (string$95);
    }
// 382
    if (startsWith$val$584) {
// 383
      JP.go.ipa.oz.lib.standard._String_if string$96 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
      
// 383
      int lastIndexOf$val$585;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
        try {
          lastIndexOf$val$585 = path.lastIndexOf (string$96);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        lastIndexOf$val$585 = path.lastIndexOf (string$96);
      }
// 383
      JP.go.ipa.oz.lib.standard._String_if substring$val$586;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
        try {
          substring$val$586 = path.substring (0, lastIndexOf$val$585 + 1);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        substring$val$586 = path.substring (0, lastIndexOf$val$585 + 1);
      }
// 383
      path = substring$val$586;
    } else {
// 385
      JP.go.ipa.oz.lib.standard._String_if string$97 = (new JP.go.ipa.oz.lib.standard._String_cl("\\"));
      
// 385
      int lastIndexOf$val$587;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
        try {
          lastIndexOf$val$587 = path.lastIndexOf (string$97);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        lastIndexOf$val$587 = path.lastIndexOf (string$97);
      }
// 385
      JP.go.ipa.oz.lib.standard._String_if substring$val$588;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
        try {
          substring$val$588 = path.substring (0, lastIndexOf$val$587 + 1);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        substring$val$588 = path.substring (0, lastIndexOf$val$587 + 1);
      }
// 385
      path = substring$val$588;
    }
// 387
    return path;
  }
  
  public JP.go.ipa.oz.lib.standard._Dictionary_if getDuplicates () throws Exception  {
    checkSecureInvocation ();
// 560
    return duplicates;
  }
  
  public JP.go.ipa.oz.user.ide.School_if putOzLabel (JP.go.ipa.oz.user.ide.OzLabel_if aOzLabel, JP.go.ipa.oz.lib.standard._String_if subjectName) throws Exception  {
    checkSecureInvocation ();
// 237
    JP.go.ipa.oz.user.ide.Subject_if subject = null;
// 238
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$589;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subjects)) {
      try {
        iterator$val$589 = subjects.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$589 = subjects.iterator ();
    }
// 238
    JP.go.ipa.oz.lib.standard._Iterator_if sbjIterator = iterator$val$589;
// 239
    while (true) {
// 239
      boolean hasMoreElements$val$590;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbjIterator)) {
        try {
          hasMoreElements$val$590 = sbjIterator.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$590 = sbjIterator.hasMoreElements ();
      }
      if (!(hasMoreElements$val$590)) break;
      
      /* body */ _loop_1: {
// 240
        JP.go.ipa.oz.lang._Root_if nextElement$val$591;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbjIterator)) {
          try {
            nextElement$val$591 = sbjIterator.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$591 = sbjIterator.nextElement ();
        }
// 240
        subject = (JP.go.ipa.oz.user.ide.Subject_if) (nextElement$val$591);
// 241
        JP.go.ipa.oz.lib.standard._String_if getSubjectName$val$592;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
          try {
            getSubjectName$val$592 = subject.getSubjectName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSubjectName$val$592 = subject.getSubjectName ();
        }
// 241
        int compareTo$val$593;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSubjectName$val$592)) {
          try {
            compareTo$val$593 = getSubjectName$val$592.compareTo (subjectName);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          compareTo$val$593 = getSubjectName$val$592.compareTo (subjectName);
        }
// 241
        if (compareTo$val$593 == 0) {{
// 242
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
              try {
                subject.putOzLabel (aOzLabel);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              subject.putOzLabel (aOzLabel);
            }
// 243
            return this;
          }
        }
      }
    }
// 246
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._Dictionary_if getAllLabels () throws Exception  {
    checkSecureInvocation ();
// 427
    JP.go.ipa.oz.lib.standard._Dictionary_if tmpLabels = null, labels = null;
// 428
    JP.go.ipa.oz.lib.standard._StringComparator_if sc = (JP.go.ipa.oz.lib.standard._StringComparator_cl) (new JP.go.ipa.oz.lib.standard._StringComparator_cl ())._new_create ();
// 429
    labels = (JP.go.ipa.oz.lib.standard._Dictionary_cl) (new JP.go.ipa.oz.lib.standard._Dictionary_cl ())._new_create (sc);
// 430
    JP.go.ipa.oz.lib.standard._String_if labelName = null;
// 431
    JP.go.ipa.oz.user.ide.OzLabel_if tmpOzLabel = null;
// 432
    JP.go.ipa.oz.lib.standard._Iterator_if lblIterator = null;
// 433
    JP.go.ipa.oz.user.ide.Subject_if subject = null;
// 434
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$594;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subjects)) {
      try {
        iterator$val$594 = subjects.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$594 = subjects.iterator ();
    }
// 434
    JP.go.ipa.oz.lib.standard._Iterator_if sbjIterator = iterator$val$594;
// 435
    while (true) {
// 435
      boolean hasMoreElements$val$595;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbjIterator)) {
        try {
          hasMoreElements$val$595 = sbjIterator.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$595 = sbjIterator.hasMoreElements ();
      }
      if (!(hasMoreElements$val$595)) break;
      
      /* body */ _loop_1: {
// 436
        JP.go.ipa.oz.lang._Root_if nextElement$val$596;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbjIterator)) {
          try {
            nextElement$val$596 = sbjIterator.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$596 = sbjIterator.nextElement ();
        }
// 436
        subject = (JP.go.ipa.oz.user.ide.Subject_if) (nextElement$val$596);
// 437
        boolean getUsing$val$597;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
          try {
            getUsing$val$597 = subject.getUsing ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getUsing$val$597 = subject.getUsing ();
        }
// 437
        if (getUsing$val$597) {{
// 438
            JP.go.ipa.oz.lib.standard._Dictionary_if getOzLabels$val$598;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
              try {
                getOzLabels$val$598 = subject.getOzLabels ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getOzLabels$val$598 = subject.getOzLabels ();
            }
// 438
            tmpLabels = getOzLabels$val$598;
// 439
            JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$599;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpLabels)) {
              try {
                iterator$val$599 = tmpLabels.iterator ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              iterator$val$599 = tmpLabels.iterator ();
            }
// 439
            lblIterator = iterator$val$599;
// 440
            while (true) {
// 440
              boolean hasMoreElements$val$600;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
                try {
                  hasMoreElements$val$600 = lblIterator.hasMoreElements ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                hasMoreElements$val$600 = lblIterator.hasMoreElements ();
              }
              if (!(hasMoreElements$val$600)) break;
              
              /* body */ _loop_2: {
// 441
                JP.go.ipa.oz.lang._Root_if nextElement$val$601;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
                  try {
                    nextElement$val$601 = lblIterator.nextElement ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  nextElement$val$601 = lblIterator.nextElement ();
                }
// 441
                tmpOzLabel = (JP.go.ipa.oz.user.ide.OzLabel_if) (nextElement$val$601);
// 442
                JP.go.ipa.oz.lib.standard._String_if getOzLabelName$val$602;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpOzLabel)) {
                  try {
                    getOzLabelName$val$602 = tmpOzLabel.getOzLabelName ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  getOzLabelName$val$602 = tmpOzLabel.getOzLabelName ();
                }
// 442
                labelName = getOzLabelName$val$602;
// 443
                labels.put (labelName, tmpOzLabel);
              }
            }
          }
        }
      }
    }
// 447
    return labels;
  }
  
  public JP.go.ipa.oz.lib.standard._Dictionary_if getOzLabels (JP.go.ipa.oz.lib.standard._String_if subjectName) throws Exception  {
    checkSecureInvocation ();
// 176
    JP.go.ipa.oz.user.ide.Subject_if subject = null;
// 177
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$603;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subjects)) {
      try {
        iterator$val$603 = subjects.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$603 = subjects.iterator ();
    }
// 177
    JP.go.ipa.oz.lib.standard._Iterator_if sbjIterator = iterator$val$603;
// 178
    while (true) {
// 178
      boolean hasMoreElements$val$604;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbjIterator)) {
        try {
          hasMoreElements$val$604 = sbjIterator.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$604 = sbjIterator.hasMoreElements ();
      }
      if (!(hasMoreElements$val$604)) break;
      
      /* body */ _loop_1: {
// 179
        JP.go.ipa.oz.lang._Root_if nextElement$val$605;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbjIterator)) {
          try {
            nextElement$val$605 = sbjIterator.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$605 = sbjIterator.nextElement ();
        }
// 179
        subject = (JP.go.ipa.oz.user.ide.Subject_if) (nextElement$val$605);
// 180
        JP.go.ipa.oz.lib.standard._String_if getSubjectName$val$606;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
          try {
            getSubjectName$val$606 = subject.getSubjectName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSubjectName$val$606 = subject.getSubjectName ();
        }
// 180
        int compareTo$val$607;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSubjectName$val$606)) {
          try {
            compareTo$val$607 = getSubjectName$val$606.compareTo (subjectName);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          compareTo$val$607 = getSubjectName$val$606.compareTo (subjectName);
        }
// 180
        if (compareTo$val$607 == 0) {{
// 181
            JP.go.ipa.oz.lib.standard._Dictionary_if getOzLabels$val$608;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
              try {
                getOzLabels$val$608 = subject.getOzLabels ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getOzLabels$val$608 = subject.getOzLabels ();
            }
// 181
            return getOzLabels$val$608;
          }
        }
      }
    }
// 184
    return null;
  }
  
  public JP.go.ipa.oz.lib.standard._Dictionary_if getOzLabels () throws Exception  {
    checkSecureInvocation ();
// 167
    return getAllLabels ();
  }
  
  public void saveToFile (JP.go.ipa.oz.lib.standard._String_if fileName, JP.go.ipa.oz.lib.standard._String_if subjectName) throws Exception  {
    checkSecureInvocation ();
// 568
    JP.go.ipa.oz.user.ide.SchoolUtility_if schoolUtility = (JP.go.ipa.oz.user.ide.SchoolUtility_cl) (new JP.go.ipa.oz.user.ide.SchoolUtility_cl ())._new_create (subjects);
// 569
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) schoolUtility)) {
      try {
        schoolUtility.saveToFile (fileName, subjectName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      schoolUtility.saveToFile (fileName, subjectName);
    }
  }
  
  public void mergeSubject (JP.go.ipa.oz.user.ide.Subject_if subject) throws Exception  {
    checkSecureInvocation ();
// 451
    JP.go.ipa.oz.user.ide.Subject_if existSubject = null;
// 452
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$609;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subjects)) {
      try {
        iterator$val$609 = subjects.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$609 = subjects.iterator ();
    }
// 452
    JP.go.ipa.oz.lib.standard._Iterator_if sbjIterator = iterator$val$609;
// 453
    JP.go.ipa.oz.lib.standard._Plural_if clear$val$610;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) duplicates)) {
      try {
        clear$val$610 = duplicates.clear ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      clear$val$610 = duplicates.clear ();
    }
// 454
    while (true) {
// 454
      boolean hasMoreElements$val$611;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbjIterator)) {
        try {
          hasMoreElements$val$611 = sbjIterator.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$611 = sbjIterator.hasMoreElements ();
      }
      if (!(hasMoreElements$val$611)) break;
      
      /* body */ _loop_1: {
// 455
        JP.go.ipa.oz.lang._Root_if nextElement$val$612;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbjIterator)) {
          try {
            nextElement$val$612 = sbjIterator.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$612 = sbjIterator.nextElement ();
        }
// 455
        existSubject = (JP.go.ipa.oz.user.ide.Subject_if) (nextElement$val$612);
// 456
        JP.go.ipa.oz.lib.standard._String_if getSubjectName$val$613;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
          try {
            getSubjectName$val$613 = subject.getSubjectName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSubjectName$val$613 = subject.getSubjectName ();
        }
// 456
        JP.go.ipa.oz.lib.standard._String_if getSubjectName$val$614;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) existSubject)) {
          try {
            getSubjectName$val$614 = existSubject.getSubjectName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSubjectName$val$614 = existSubject.getSubjectName ();
        }
// 456
        int compareTo$val$615;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSubjectName$val$613)) {
          try {
            compareTo$val$615 = getSubjectName$val$613.compareTo (getSubjectName$val$614);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          compareTo$val$615 = getSubjectName$val$613.compareTo (getSubjectName$val$614);
        }
// 456
        if (compareTo$val$615 != 0) {{
// 457
            checkDuplicate (existSubject, subject);
          }
        }
      }
    }
// 461
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
      try {
        subject.setImported (true);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      subject.setImported (true);
    }
// 462
    putSubject (subject);
// 465
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 466
    JP.go.ipa.oz.lib.standard._String_if lblName = null, dupLblName = null;
// 467
    JP.go.ipa.oz.lib.standard._Set_if keys$val$616;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) duplicates)) {
      try {
        keys$val$616 = duplicates.keys ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      keys$val$616 = duplicates.keys ();
    }
// 467
    JP.go.ipa.oz.lib.standard._Set_if tmpSet = keys$val$616;
// 468
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$617;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpSet)) {
      try {
        iterator$val$617 = tmpSet.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$617 = tmpSet.iterator ();
    }
// 468
    JP.go.ipa.oz.lib.standard._Iterator_if tmpIterator = iterator$val$617;
// 469
    while (true) {
// 469
      boolean hasMoreElements$val$618;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpIterator)) {
        try {
          hasMoreElements$val$618 = tmpIterator.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$618 = tmpIterator.hasMoreElements ();
      }
      if (!(hasMoreElements$val$618)) break;
      
      /* body */ _loop_1: {
// 470
        JP.go.ipa.oz.lang._Root_if nextElement$val$619;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpIterator)) {
          try {
            nextElement$val$619 = tmpIterator.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$619 = tmpIterator.nextElement ();
        }
// 470
        lblName = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$619);
// 471
        JP.go.ipa.oz.lang._Root_if get$val$620;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) duplicates)) {
          try {
            get$val$620 = duplicates.get (lblName);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          get$val$620 = duplicates.get (lblName);
        }
// 471
        dupLblName = (JP.go.ipa.oz.lib.standard._String_if) (get$val$620);
// 472
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.println (lblName);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.println (lblName);
        }
// 473
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.println (dupLblName);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.println (dupLblName);
        }
      }
    }
// 475
    JP.go.ipa.oz.lib.standard._String_if string$98 = (new JP.go.ipa.oz.lib.standard._String_cl("-----------------------"));
    
// 475
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.println (string$98);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.println (string$98);
    }
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getLabelPath2 (JP.go.ipa.oz.lib.standard._String_if labelName) throws Exception  {
    checkSecureInvocation ();
// 397
    JP.go.ipa.oz.lib.standard._String_if ozHome = null;
// 398
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 399
    JP.go.ipa.oz.lib.standard._String_if getOzHome$val$621;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        getOzHome$val$621 = system.getOzHome ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzHome$val$621 = system.getOzHome ();
    }
// 399
    ozHome = getOzHome$val$621;
// 402
    JP.go.ipa.oz.lib.standard._String_if path = null;
// 403
    JP.go.ipa.oz.lib.standard._String_if string$99 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
    
// 403
    boolean startsWith$val$622;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozHome)) {
      try {
        startsWith$val$622 = ozHome.startsWith (string$99);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      startsWith$val$622 = ozHome.startsWith (string$99);
    }
// 403
    if (startsWith$val$622) {
// 404
      JP.go.ipa.oz.lib.standard._String_if getInterfaceID$val$623;
      getInterfaceID$val$623 = getInterfaceID (labelName);
// 404
      JP.go.ipa.oz.lib.standard._String_if replace$val$624;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getInterfaceID$val$623)) {
        try {
          replace$val$624 = getInterfaceID$val$623.replace ('.', '/');
        } finally {
          changeRunningToGreen ();
        }
      } else {
        replace$val$624 = getInterfaceID$val$623.replace ('.', '/');
      }
// 404
      path = replace$val$624;
    } else {
// 406
      JP.go.ipa.oz.lib.standard._String_if getInterfaceID$val$625;
      getInterfaceID$val$625 = getInterfaceID (labelName);
// 406
      JP.go.ipa.oz.lib.standard._String_if replace$val$626;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getInterfaceID$val$625)) {
        try {
          replace$val$626 = getInterfaceID$val$625.replace ('.', '\\');
        } finally {
          changeRunningToGreen ();
        }
      } else {
        replace$val$626 = getInterfaceID$val$625.replace ('.', '\\');
      }
// 406
      path = replace$val$626;
    }
// 408
    JP.go.ipa.oz.lib.standard._String_if string$100 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
    
// 408
    boolean startsWith$val$627;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozHome)) {
      try {
        startsWith$val$627 = ozHome.startsWith (string$100);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      startsWith$val$627 = ozHome.startsWith (string$100);
    }
// 408
    if (startsWith$val$627) {
// 409
      JP.go.ipa.oz.lib.standard._String_if string$101 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
      
// 409
      int lastIndexOf$val$628;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
        try {
          lastIndexOf$val$628 = path.lastIndexOf (string$101);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        lastIndexOf$val$628 = path.lastIndexOf (string$101);
      }
// 409
      JP.go.ipa.oz.lib.standard._String_if substring$val$629;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
        try {
          substring$val$629 = path.substring (0, lastIndexOf$val$628 + 1);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        substring$val$629 = path.substring (0, lastIndexOf$val$628 + 1);
      }
// 409
      path = substring$val$629;
    } else {
// 411
      JP.go.ipa.oz.lib.standard._String_if string$102 = (new JP.go.ipa.oz.lib.standard._String_cl("\\"));
      
// 411
      int lastIndexOf$val$630;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
        try {
          lastIndexOf$val$630 = path.lastIndexOf (string$102);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        lastIndexOf$val$630 = path.lastIndexOf (string$102);
      }
// 411
      JP.go.ipa.oz.lib.standard._String_if substring$val$631;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
        try {
          substring$val$631 = path.substring (0, lastIndexOf$val$630 + 1);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        substring$val$631 = path.substring (0, lastIndexOf$val$630 + 1);
      }
// 411
      path = substring$val$631;
    }
// 413
    return path;
  }
  
  public void checkDuplicate (JP.go.ipa.oz.user.ide.Subject_if subject1, JP.go.ipa.oz.user.ide.Subject_if subject2) throws Exception  {
    checkSecureInvocation ();
// 480
    JP.go.ipa.oz.lib.standard._Dictionary_if labels1 = null, labels2 = null;
// 481
    JP.go.ipa.oz.lib.standard._String_if labelName = null;
// 482
    JP.go.ipa.oz.lib.standard._String_if getSubjectName$val$632;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject1)) {
      try {
        getSubjectName$val$632 = subject1.getSubjectName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSubjectName$val$632 = subject1.getSubjectName ();
    }
// 482
    JP.go.ipa.oz.lib.standard._String_if subjectName1 = getSubjectName$val$632;
// 483
    JP.go.ipa.oz.lib.standard._String_if getSubjectName$val$633;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject2)) {
      try {
        getSubjectName$val$633 = subject2.getSubjectName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSubjectName$val$633 = subject2.getSubjectName ();
    }
// 483
    JP.go.ipa.oz.lib.standard._String_if subjectName2 = getSubjectName$val$633;
// 484
    JP.go.ipa.oz.lib.standard._StringBuffer_if tmp1 = null, tmp2 = null;
// 485
    JP.go.ipa.oz.user.ide.OzLabel_if tmpOzLabel = null;
// 486
    JP.go.ipa.oz.lib.standard._Dictionary_if getOzLabels$val$634;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject1)) {
      try {
        getOzLabels$val$634 = subject1.getOzLabels ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzLabels$val$634 = subject1.getOzLabels ();
    }
// 486
    labels1 = getOzLabels$val$634;
// 487
    JP.go.ipa.oz.lib.standard._Dictionary_if getOzLabels$val$635;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject2)) {
      try {
        getOzLabels$val$635 = subject2.getOzLabels ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzLabels$val$635 = subject2.getOzLabels ();
    }
// 487
    labels2 = getOzLabels$val$635;
// 488
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$636;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) labels1)) {
      try {
        iterator$val$636 = labels1.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$636 = labels1.iterator ();
    }
// 488
    JP.go.ipa.oz.lib.standard._Iterator_if lblIterator = iterator$val$636;
// 489
    while (true) {
// 489
      boolean hasMoreElements$val$637;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
        try {
          hasMoreElements$val$637 = lblIterator.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$637 = lblIterator.hasMoreElements ();
      }
      if (!(hasMoreElements$val$637)) break;
      
      /* body */ _loop_1: {
// 490
        JP.go.ipa.oz.lang._Root_if nextElement$val$638;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
          try {
            nextElement$val$638 = lblIterator.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$638 = lblIterator.nextElement ();
        }
// 490
        tmpOzLabel = (JP.go.ipa.oz.user.ide.OzLabel_if) (nextElement$val$638);
// 491
        JP.go.ipa.oz.lib.standard._String_if getOzLabelName$val$639;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpOzLabel)) {
          try {
            getOzLabelName$val$639 = tmpOzLabel.getOzLabelName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getOzLabelName$val$639 = tmpOzLabel.getOzLabelName ();
        }
// 491
        labelName = getOzLabelName$val$639;
// 492
        boolean containsKey$val$640;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) labels2)) {
          try {
            containsKey$val$640 = labels2.containsKey (labelName);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          containsKey$val$640 = labels2.containsKey (labelName);
        }
// 492
        if (containsKey$val$640) {{
// 493
            tmp1 = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (subjectName1);
// 494
            tmp2 = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (subjectName2);
// 495
            tmp1.append ((new JP.go.ipa.oz.lib.standard._String_cl(":")));
// 496
            tmp2.append ((new JP.go.ipa.oz.lib.standard._String_cl(":")));
// 497
            tmp1.append (labelName);
// 498
            tmp2.append (labelName);
// 499
            JP.go.ipa.oz.lib.standard._String_if asString$val$641;
            asString$val$641 = tmp1.asString ();
// 499
            JP.go.ipa.oz.lib.standard._String_if asString$val$642;
            asString$val$642 = tmp2.asString ();
// 499
            JP.go.ipa.oz.lib.standard._Dictionary_if put$val$643;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) duplicates)) {
              try {
                put$val$643 = duplicates.put (asString$val$641, asString$val$642);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              put$val$643 = duplicates.put (asString$val$641, asString$val$642);
            }
          }
        }
      }
    }
  }
  
  public void renameSubject (JP.go.ipa.oz.lib.standard._String_if oldSubjectName, JP.go.ipa.oz.lib.standard._String_if newSubjectName) throws Exception  {
    checkSecureInvocation ();
// 322
    JP.go.ipa.oz.lib.standard._Dictionary_if tmpLabels = null;
// 323
    JP.go.ipa.oz.user.ide.OzLabel_if tmpOzLabel = null;
// 324
    JP.go.ipa.oz.lib.standard._Iterator_if lblIterator = null;
// 325
    JP.go.ipa.oz.user.ide.Subject_if subject = null;
// 326
    JP.go.ipa.oz.user.ide.Subject_if sbj = (JP.go.ipa.oz.user.ide.Subject_cl) (new JP.go.ipa.oz.user.ide.Subject_cl ())._new_create (newSubjectName);
// 327
    JP.go.ipa.oz.lib.standard._Dictionary_if put$val$644;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subjects)) {
      try {
        put$val$644 = subjects.put (newSubjectName, sbj);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      put$val$644 = subjects.put (newSubjectName, sbj);
    }
// 328
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$645;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subjects)) {
      try {
        iterator$val$645 = subjects.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$645 = subjects.iterator ();
    }
// 328
    JP.go.ipa.oz.lib.standard._Iterator_if sbjIterator = iterator$val$645;
// 329
    while (true) {
// 329
      boolean hasMoreElements$val$646;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbjIterator)) {
        try {
          hasMoreElements$val$646 = sbjIterator.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$646 = sbjIterator.hasMoreElements ();
      }
      if (!(hasMoreElements$val$646)) break;
      
      /* body */ _loop_1: {
// 330
        JP.go.ipa.oz.lang._Root_if nextElement$val$647;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbjIterator)) {
          try {
            nextElement$val$647 = sbjIterator.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$647 = sbjIterator.nextElement ();
        }
// 330
        subject = (JP.go.ipa.oz.user.ide.Subject_if) (nextElement$val$647);
// 331
        JP.go.ipa.oz.lib.standard._String_if getSubjectName$val$648;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
          try {
            getSubjectName$val$648 = subject.getSubjectName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSubjectName$val$648 = subject.getSubjectName ();
        }
// 331
        int compareTo$val$649;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSubjectName$val$648)) {
          try {
            compareTo$val$649 = getSubjectName$val$648.compareTo (oldSubjectName);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          compareTo$val$649 = getSubjectName$val$648.compareTo (oldSubjectName);
        }
// 331
        if (compareTo$val$649 == 0) {{
// 332
            JP.go.ipa.oz.lib.standard._Dictionary_if getOzLabels$val$650;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
              try {
                getOzLabels$val$650 = subject.getOzLabels ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getOzLabels$val$650 = subject.getOzLabels ();
            }
// 332
            tmpLabels = getOzLabels$val$650;
// 333
            JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$651;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpLabels)) {
              try {
                iterator$val$651 = tmpLabels.iterator ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              iterator$val$651 = tmpLabels.iterator ();
            }
// 333
            lblIterator = iterator$val$651;
// 334
            while (true) {
// 334
              boolean hasMoreElements$val$652;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
                try {
                  hasMoreElements$val$652 = lblIterator.hasMoreElements ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                hasMoreElements$val$652 = lblIterator.hasMoreElements ();
              }
              if (!(hasMoreElements$val$652)) break;
              
              /* body */ _loop_2: {
// 335
                JP.go.ipa.oz.lang._Root_if nextElement$val$653;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
                  try {
                    nextElement$val$653 = lblIterator.nextElement ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  nextElement$val$653 = lblIterator.nextElement ();
                }
// 335
                tmpOzLabel = (JP.go.ipa.oz.user.ide.OzLabel_if) (nextElement$val$653);
// 336
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpOzLabel)) {
                  try {
                    tmpOzLabel.setSubjectName (newSubjectName);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  tmpOzLabel.setSubjectName (newSubjectName);
                }
// 337
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbj)) {
                  try {
                    sbj.putOzLabel (tmpOzLabel);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  sbj.putOzLabel (tmpOzLabel);
                }
              }
            }
// 339
            boolean isImported$val$654;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
              try {
                isImported$val$654 = subject.isImported ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              isImported$val$654 = subject.isImported ();
            }
// 339
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbj)) {
              try {
                sbj.setImported (isImported$val$654);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              sbj.setImported (isImported$val$654);
            }
// 340
            removeSubject (oldSubjectName);
// 341
            return;
          }
        }
      }
    }
  }
  
  public JP.go.ipa.oz.user.ide.Subject_if getSubject (JP.go.ipa.oz.lib.standard._String_if subjectName) throws Exception  {
    checkSecureInvocation ();
// 302
    JP.go.ipa.oz.user.ide.Subject_if sbj = null;
// 303
    JP.go.ipa.oz.lang._Root_if get$val$655;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subjects)) {
      try {
        get$val$655 = subjects.get (subjectName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      get$val$655 = subjects.get (subjectName);
    }
// 303
    sbj = (JP.go.ipa.oz.user.ide.Subject_if) (get$val$655);
// 304
    return sbj;
  }
  
  public JP.go.ipa.oz.user.ide.School_if removeOzLabels (JP.go.ipa.oz.lib.standard._String_if subjectName) throws Exception  {
    checkSecureInvocation ();
// 273
    JP.go.ipa.oz.lib.standard._Dictionary_if remove$val$656;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subjects)) {
      try {
        remove$val$656 = subjects.remove (subjectName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      remove$val$656 = subjects.remove (subjectName);
    }
// 274
    return this;
  }
  
  public void toDevelopState (JP.go.ipa.oz.lib.standard._String_if subjectName) throws Exception  {
    checkSecureInvocation ();
// 538
    JP.go.ipa.oz.user.ide.Subject_if subject = getSubject (subjectName);
// 539
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
      try {
        subject.setReleased (false);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      subject.setReleased (false);
    }
// 540
    JP.go.ipa.oz.lib.standard._String_if getGOL$val$657;
    getGOL$val$657 = getGOL ();
// 540
    JP.go.ipa.oz.lib.standard._String_if replace$val$658;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getGOL$val$657)) {
      try {
        replace$val$658 = getGOL$val$657.replace ('.', '_');
      } finally {
        changeRunningToGreen ();
      }
    } else {
      replace$val$658 = getGOL$val$657.replace ('.', '_');
    }
// 540
    JP.go.ipa.oz.lib.standard._String_if replace$val$659;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) (replace$val$658))) {
      try {
        replace$val$659 = (replace$val$658).replace (':', '_');
      } finally {
        changeRunningToGreen ();
      }
    } else {
      replace$val$659 = (replace$val$658).replace (':', '_');
    }
// 540
    JP.go.ipa.oz.lib.standard._String_if gol = replace$val$659;
// 542
    JP.go.ipa.oz.lib.standard._Dictionary_if getOzLabels$val$660;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
      try {
        getOzLabels$val$660 = subject.getOzLabels ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzLabels$val$660 = subject.getOzLabels ();
    }
// 542
    JP.go.ipa.oz.lib.standard._Dictionary_if labels = getOzLabels$val$660;
// 543
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$661;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) labels)) {
      try {
        iterator$val$661 = labels.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$661 = labels.iterator ();
    }
// 543
    JP.go.ipa.oz.lib.standard._Iterator_if lblIterator = iterator$val$661;
// 544
    JP.go.ipa.oz.lib.standard._String_if labelName = null, tmp = null;
// 545
    JP.go.ipa.oz.user.ide.OzLabel_if tmpOzLabel = null;
// 546
    while (true) {
// 546
      boolean hasMoreElements$val$662;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
        try {
          hasMoreElements$val$662 = lblIterator.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$662 = lblIterator.hasMoreElements ();
      }
      if (!(hasMoreElements$val$662)) break;
      
      /* body */ _loop_1: {
// 547
        JP.go.ipa.oz.lang._Root_if nextElement$val$663;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
          try {
            nextElement$val$663 = lblIterator.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$663 = lblIterator.nextElement ();
        }
// 547
        tmpOzLabel = (JP.go.ipa.oz.user.ide.OzLabel_if) (nextElement$val$663);
// 548
        JP.go.ipa.oz.lib.standard._String_if getInterfaceID$val$664;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpOzLabel)) {
          try {
            getInterfaceID$val$664 = tmpOzLabel.getInterfaceID ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getInterfaceID$val$664 = tmpOzLabel.getInterfaceID ();
        }
// 548
        boolean startsWith$val$665;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getInterfaceID$val$664)) {
          try {
            startsWith$val$665 = getInterfaceID$val$664.startsWith (gol);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          startsWith$val$665 = getInterfaceID$val$664.startsWith (gol);
        }
// 548
        if (startsWith$val$665) {{
// 549
            JP.go.ipa.oz.lib.standard._String_if getInterfaceID$val$666;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpOzLabel)) {
              try {
                getInterfaceID$val$666 = tmpOzLabel.getInterfaceID ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getInterfaceID$val$666 = tmpOzLabel.getInterfaceID ();
            }
// 549
            tmp = getInterfaceID$val$666;
// 550
            JP.go.ipa.oz.lib.standard._String_if string$103 = (new JP.go.ipa.oz.lib.standard._String_cl("."));
            
// 550
            int indexOf$val$667;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
              try {
                indexOf$val$667 = tmp.indexOf (string$103);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              indexOf$val$667 = tmp.indexOf (string$103);
            }
// 550
            JP.go.ipa.oz.lib.standard._String_if substring$val$668;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
              try {
                substring$val$668 = tmp.substring (indexOf$val$667 + 1);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              substring$val$668 = tmp.substring (indexOf$val$667 + 1);
            }
// 550
            tmp = substring$val$668;
// 551
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpOzLabel)) {
              try {
                tmpOzLabel.setInterfaceID (tmp);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              tmpOzLabel.setInterfaceID (tmp);
            }
// 552
            JP.go.ipa.oz.lib.standard._String_if getImplementationID$val$669;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpOzLabel)) {
              try {
                getImplementationID$val$669 = tmpOzLabel.getImplementationID ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getImplementationID$val$669 = tmpOzLabel.getImplementationID ();
            }
// 552
            tmp = getImplementationID$val$669;
// 553
            JP.go.ipa.oz.lib.standard._String_if string$104 = (new JP.go.ipa.oz.lib.standard._String_cl("."));
            
// 553
            int indexOf$val$670;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
              try {
                indexOf$val$670 = tmp.indexOf (string$104);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              indexOf$val$670 = tmp.indexOf (string$104);
            }
// 553
            JP.go.ipa.oz.lib.standard._String_if substring$val$671;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
              try {
                substring$val$671 = tmp.substring (indexOf$val$670 + 1);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              substring$val$671 = tmp.substring (indexOf$val$670 + 1);
            }
// 553
            tmp = substring$val$671;
// 554
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpOzLabel)) {
              try {
                tmpOzLabel.setImplementationID (tmp);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              tmpOzLabel.setImplementationID (tmp);
            }
          }
        }
      }
    }
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getImplementationID (JP.go.ipa.oz.lib.standard._String_if labelName) throws Exception  {
    checkSecureInvocation ();
// 91
    JP.go.ipa.oz.user.ide.OzLabel_if lbl = null;
// 92
    JP.go.ipa.oz.lib.standard._String_if implementationID = null;
// 93
    JP.go.ipa.oz.lib.standard._StringBuffer_if buf = null;
// 94
    JP.go.ipa.oz.user.ide.Subject_if subject = null;
// 96
    JP.go.ipa.oz.lib.standard._Dictionary_if getAllLabels$val$672;
    getAllLabels$val$672 = getAllLabels ();
// 96
    JP.go.ipa.oz.lang._Root_if get$val$673;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getAllLabels$val$672)) {
      try {
        get$val$673 = getAllLabels$val$672.get (labelName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      get$val$673 = getAllLabels$val$672.get (labelName);
    }
// 96
    lbl = (JP.go.ipa.oz.user.ide.OzLabel_if) (get$val$673);
// 97
    JP.go.ipa.oz.lib.standard._String_if getImplementationID$val$674;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lbl)) {
      try {
        getImplementationID$val$674 = lbl.getImplementationID ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getImplementationID$val$674 = lbl.getImplementationID ();
    }
// 97
    implementationID = getImplementationID$val$674;
// 98
    JP.go.ipa.oz.lib.standard._String_if getSubjectName$val$675;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lbl)) {
      try {
        getSubjectName$val$675 = lbl.getSubjectName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSubjectName$val$675 = lbl.getSubjectName ();
    }
// 98
    subject = getSubject (getSubjectName$val$675);
// 100
    JP.go.ipa.oz.lib.standard._String_if string$105 = (new JP.go.ipa.oz.lib.standard._String_cl("."));
    
// 100
    boolean startsWith$val$676;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) implementationID)) {
      try {
        startsWith$val$676 = implementationID.startsWith (string$105);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      startsWith$val$676 = implementationID.startsWith (string$105);
    }
// 100
    if (startsWith$val$676) {{
// 101
        buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz")));
// 102
        buf.append (implementationID);
      }
    } else {{
// 104
        boolean isReleased$val$677;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
          try {
            isReleased$val$677 = subject.isReleased ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isReleased$val$677 = subject.isReleased ();
        }
// 104
        if (isReleased$val$677) {{
// 105
            buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz.user.released.")));
// 108
            buf.append (implementationID);
          }
        } else {{
// 110
            buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz.user.")));
// 111
            buf.append (implementationID);
          }
        }
      }
    }
// 115
    return buf.asString ();
  }
  
  public JP.go.ipa.oz.user.ide.School_if removeSubject (JP.go.ipa.oz.lib.standard._String_if subjectName) throws Exception  {
    checkSecureInvocation ();
// 293
    JP.go.ipa.oz.lib.standard._Dictionary_if remove$val$678;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subjects)) {
      try {
        remove$val$678 = subjects.remove (subjectName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      remove$val$678 = subjects.remove (subjectName);
    }
// 294
    return this;
  }
  
  public JP.go.ipa.oz.user.ide.OzLabel_if getOzLabelOfImplementation (JP.go.ipa.oz.lib.standard._String_if implementationID) throws Exception  {
    checkSecureInvocation ();
// 221
    JP.go.ipa.oz.user.ide.OzLabel_if tmpOzLabel = null;
// 222
    JP.go.ipa.oz.lib.standard._Iterator_if lblIterator = null;
// 223
    JP.go.ipa.oz.lib.standard._Dictionary_if getAllLabels$val$679;
    getAllLabels$val$679 = getAllLabels ();
// 223
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$680;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getAllLabels$val$679)) {
      try {
        iterator$val$680 = getAllLabels$val$679.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$680 = getAllLabels$val$679.iterator ();
    }
// 223
    lblIterator = iterator$val$680;
// 224
    while (true) {
// 224
      boolean hasMoreElements$val$681;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
        try {
          hasMoreElements$val$681 = lblIterator.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$681 = lblIterator.hasMoreElements ();
      }
      if (!(hasMoreElements$val$681)) break;
      
      /* body */ _loop_1: {
// 225
        JP.go.ipa.oz.lang._Root_if nextElement$val$682;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
          try {
            nextElement$val$682 = lblIterator.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$682 = lblIterator.nextElement ();
        }
// 225
        tmpOzLabel = (JP.go.ipa.oz.user.ide.OzLabel_if) (nextElement$val$682);
// 226
        JP.go.ipa.oz.lib.standard._String_if getImplementationID$val$683;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpOzLabel)) {
          try {
            getImplementationID$val$683 = tmpOzLabel.getImplementationID ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getImplementationID$val$683 = tmpOzLabel.getImplementationID ();
        }
// 226
        int compareTo$val$684;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) (getImplementationID$val$683))) {
          try {
            compareTo$val$684 = (getImplementationID$val$683).compareTo (implementationID);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          compareTo$val$684 = (getImplementationID$val$683).compareTo (implementationID);
        }
// 226
        if ((compareTo$val$684) == 0) {
// 226
          return tmpOzLabel;
        }
      }
    }
// 228
    return null;
  }
  
  public JP.go.ipa.oz.lib.standard._Dictionary_if getSubjects () throws Exception  {
    checkSecureInvocation ();
// 312
    return subjects;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getInterfaceID (JP.go.ipa.oz.lib.standard._String_if labelName) throws Exception  {
    checkSecureInvocation ();
// 58
    JP.go.ipa.oz.user.ide.OzLabel_if lbl = null;
// 59
    JP.go.ipa.oz.lib.standard._String_if interfaceID = null;
// 60
    JP.go.ipa.oz.lib.standard._StringBuffer_if buf = null;
// 61
    JP.go.ipa.oz.user.ide.Subject_if subject = null;
// 63
    JP.go.ipa.oz.lib.standard._Dictionary_if getAllLabels$val$685;
    getAllLabels$val$685 = getAllLabels ();
// 63
    JP.go.ipa.oz.lang._Root_if get$val$686;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getAllLabels$val$685)) {
      try {
        get$val$686 = getAllLabels$val$685.get (labelName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      get$val$686 = getAllLabels$val$685.get (labelName);
    }
// 63
    lbl = (JP.go.ipa.oz.user.ide.OzLabel_if) (get$val$686);
// 64
    JP.go.ipa.oz.lib.standard._String_if getInterfaceID$val$687;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lbl)) {
      try {
        getInterfaceID$val$687 = lbl.getInterfaceID ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getInterfaceID$val$687 = lbl.getInterfaceID ();
    }
// 64
    interfaceID = getInterfaceID$val$687;
// 65
    JP.go.ipa.oz.lib.standard._String_if getSubjectName$val$688;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lbl)) {
      try {
        getSubjectName$val$688 = lbl.getSubjectName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSubjectName$val$688 = lbl.getSubjectName ();
    }
// 65
    subject = getSubject (getSubjectName$val$688);
// 67
    JP.go.ipa.oz.lib.standard._String_if string$106 = (new JP.go.ipa.oz.lib.standard._String_cl("."));
    
// 67
    boolean startsWith$val$689;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) interfaceID)) {
      try {
        startsWith$val$689 = interfaceID.startsWith (string$106);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      startsWith$val$689 = interfaceID.startsWith (string$106);
    }
// 67
    if (startsWith$val$689) {{
// 68
        buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz")));
// 69
        buf.append (interfaceID);
      }
    } else {{
// 71
        boolean isReleased$val$690;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
          try {
            isReleased$val$690 = subject.isReleased ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isReleased$val$690 = subject.isReleased ();
        }
// 71
        if (isReleased$val$690) {{
// 72
            buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz.user.released.")));
// 75
            buf.append (interfaceID);
          }
        } else {{
// 77
            buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz.user.")));
// 78
            buf.append (interfaceID);
          }
        }
      }
    }
// 82
    return buf.asString ();
  }
  
  public void toReleasState (JP.go.ipa.oz.lib.standard._String_if subjectName) throws Exception  {
    checkSecureInvocation ();
// 505
    JP.go.ipa.oz.user.ide.Subject_if subject = getSubject (subjectName);
// 506
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
      try {
        subject.setReleased (true);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      subject.setReleased (true);
    }
// 507
    JP.go.ipa.oz.lib.standard._String_if getGOL$val$691;
    getGOL$val$691 = getGOL ();
// 507
    JP.go.ipa.oz.lib.standard._String_if replace$val$692;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getGOL$val$691)) {
      try {
        replace$val$692 = getGOL$val$691.replace ('.', '_');
      } finally {
        changeRunningToGreen ();
      }
    } else {
      replace$val$692 = getGOL$val$691.replace ('.', '_');
    }
// 507
    JP.go.ipa.oz.lib.standard._String_if replace$val$693;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) (replace$val$692))) {
      try {
        replace$val$693 = (replace$val$692).replace (':', '_');
      } finally {
        changeRunningToGreen ();
      }
    } else {
      replace$val$693 = (replace$val$692).replace (':', '_');
    }
// 507
    JP.go.ipa.oz.lib.standard._String_if gol = replace$val$693;
// 509
    JP.go.ipa.oz.lib.standard._Dictionary_if getOzLabels$val$694;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
      try {
        getOzLabels$val$694 = subject.getOzLabels ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzLabels$val$694 = subject.getOzLabels ();
    }
// 509
    JP.go.ipa.oz.lib.standard._Dictionary_if labels = getOzLabels$val$694;
// 510
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$695;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) labels)) {
      try {
        iterator$val$695 = labels.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$695 = labels.iterator ();
    }
// 510
    JP.go.ipa.oz.lib.standard._Iterator_if lblIterator = iterator$val$695;
// 511
    JP.go.ipa.oz.lib.standard._String_if labelName = null;
// 512
    JP.go.ipa.oz.lib.standard._StringBuffer_if tmp = null;
// 513
    JP.go.ipa.oz.user.ide.OzLabel_if tmpOzLabel = null;
// 514
    while (true) {
// 514
      boolean hasMoreElements$val$696;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
        try {
          hasMoreElements$val$696 = lblIterator.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$696 = lblIterator.hasMoreElements ();
      }
      if (!(hasMoreElements$val$696)) break;
      
      /* body */ _loop_1: {
// 515
        JP.go.ipa.oz.lang._Root_if nextElement$val$697;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
          try {
            nextElement$val$697 = lblIterator.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$697 = lblIterator.nextElement ();
        }
// 515
        tmpOzLabel = (JP.go.ipa.oz.user.ide.OzLabel_if) (nextElement$val$697);
// 516
        JP.go.ipa.oz.lib.standard._String_if getInterfaceID$val$698;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpOzLabel)) {
          try {
            getInterfaceID$val$698 = tmpOzLabel.getInterfaceID ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getInterfaceID$val$698 = tmpOzLabel.getInterfaceID ();
        }
// 516
        boolean startsWith$val$699;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getInterfaceID$val$698)) {
          try {
            startsWith$val$699 = getInterfaceID$val$698.startsWith (gol);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          startsWith$val$699 = getInterfaceID$val$698.startsWith (gol);
        }
// 516
        if (!(startsWith$val$699)) {{
// 517
            tmp = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (gol);
// 519
            tmp.append ((new JP.go.ipa.oz.lib.standard._String_cl("_if.")));
// 520
            JP.go.ipa.oz.lib.standard._String_if getInterfaceID$val$700;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpOzLabel)) {
              try {
                getInterfaceID$val$700 = tmpOzLabel.getInterfaceID ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getInterfaceID$val$700 = tmpOzLabel.getInterfaceID ();
            }
// 520
            tmp.append (getInterfaceID$val$700);
// 521
            JP.go.ipa.oz.lib.standard._String_if asString$val$701;
            asString$val$701 = tmp.asString ();
// 521
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpOzLabel)) {
              try {
                tmpOzLabel.setInterfaceID (asString$val$701);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              tmpOzLabel.setInterfaceID (asString$val$701);
            }
// 522
            tmp = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (gol);
// 524
            tmp.append ((new JP.go.ipa.oz.lib.standard._String_cl("_cl.")));
// 525
            JP.go.ipa.oz.lib.standard._String_if getImplementationID$val$702;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpOzLabel)) {
              try {
                getImplementationID$val$702 = tmpOzLabel.getImplementationID ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getImplementationID$val$702 = tmpOzLabel.getImplementationID ();
            }
// 525
            tmp.append (getImplementationID$val$702);
// 526
            JP.go.ipa.oz.lib.standard._String_if asString$val$703;
            asString$val$703 = tmp.asString ();
// 526
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpOzLabel)) {
              try {
                tmpOzLabel.setImplementationID (asString$val$703);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              tmpOzLabel.setImplementationID (asString$val$703);
            }
          }
        }
      }
    }
// 529
    JP.go.ipa.oz.lib.standard._String_if getOzLabelName$val$704;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpOzLabel)) {
      try {
        getOzLabelName$val$704 = tmpOzLabel.getOzLabelName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzLabelName$val$704 = tmpOzLabel.getOzLabelName ();
    }
// 529
    JP.go.ipa.oz.lib.standard._String_if pkgName = getInterfaceID (getOzLabelName$val$704);
// 530
    JP.go.ipa.oz.lib.standard._String_if string$107 = (new JP.go.ipa.oz.lib.standard._String_cl("."));
    
// 530
    int lastIndexOf$val$705;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pkgName)) {
      try {
        lastIndexOf$val$705 = pkgName.lastIndexOf (string$107);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lastIndexOf$val$705 = pkgName.lastIndexOf (string$107);
    }
// 530
    JP.go.ipa.oz.lib.standard._String_if substring$val$706;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pkgName)) {
      try {
        substring$val$706 = pkgName.substring (0, lastIndexOf$val$705);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      substring$val$706 = pkgName.substring (0, lastIndexOf$val$705);
    }
// 530
    pkgName = substring$val$706;
// 531
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
      try {
        subject.setIfPackageName (pkgName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      subject.setIfPackageName (pkgName);
    }
// 532
    JP.go.ipa.oz.lib.standard._String_if getOzLabelName$val$707;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpOzLabel)) {
      try {
        getOzLabelName$val$707 = tmpOzLabel.getOzLabelName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzLabelName$val$707 = tmpOzLabel.getOzLabelName ();
    }
// 532
    pkgName = getImplementationID (getOzLabelName$val$707);
// 533
    JP.go.ipa.oz.lib.standard._String_if string$108 = (new JP.go.ipa.oz.lib.standard._String_cl("."));
    
// 533
    int lastIndexOf$val$708;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pkgName)) {
      try {
        lastIndexOf$val$708 = pkgName.lastIndexOf (string$108);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lastIndexOf$val$708 = pkgName.lastIndexOf (string$108);
    }
// 533
    JP.go.ipa.oz.lib.standard._String_if substring$val$709;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pkgName)) {
      try {
        substring$val$709 = pkgName.substring (0, lastIndexOf$val$708);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      substring$val$709 = pkgName.substring (0, lastIndexOf$val$708);
    }
// 533
    pkgName = substring$val$709;
// 534
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
      try {
        subject.setClPackageName (pkgName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      subject.setClPackageName (pkgName);
    }
  }
  
  public School_cl () throws Exception { super (); }
  
}

