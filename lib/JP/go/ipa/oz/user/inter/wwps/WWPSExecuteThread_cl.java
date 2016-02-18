package JP.go.ipa.oz.user.inter.wwps;

abstract public class WWPSExecuteThread_cl extends JP.go.ipa.oz.user.inter.cgi.ExecuteThread_cl implements JP.go.ipa.oz.user.inter.wwps.WWPSExecuteThread_if {
  
  public Object _new_create (JP.go.ipa.oz.user.inter.cgi.OzCGI_if c, JP.go.ipa.oz.user.inter.cgi.HTMLData_if h) throws Exception  {
// 264
    super._new_create (c, h);
    return this;
  }
  
  JP.go.ipa.oz.lib.standard._String_if extractOne (JP.go.ipa.oz.lib.standard._String_if file_name, JP.go.ipa.oz.lib.standard._ByteArray_if src) throws Exception  {
// 188
    JP.go.ipa.oz.lib.standard._System_if sys = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 190
    int lastIndexOf$val$139;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file_name)) {
      try {
        lastIndexOf$val$139 = file_name.lastIndexOf ('\\');
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lastIndexOf$val$139 = file_name.lastIndexOf ('\\');
    }
// 190
    int bs = lastIndexOf$val$139;
// 191
    if (bs < 0) {
// 192
      int lastIndexOf$val$140;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file_name)) {
        try {
          lastIndexOf$val$140 = file_name.lastIndexOf ('/');
        } finally {
          changeRunningToGreen ();
        }
      } else {
        lastIndexOf$val$140 = file_name.lastIndexOf ('/');
      }
// 192
      bs = lastIndexOf$val$140;
    }
// 193
    if (bs != -1) {{
// 194
        int length$val$141;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file_name)) {
          try {
            length$val$141 = file_name.length ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          length$val$141 = file_name.length ();
        }
// 194
        int len = length$val$141;
// 195
        JP.go.ipa.oz.lib.standard._String_if substring$val$142;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file_name)) {
          try {
            substring$val$142 = file_name.substring (bs + 1, len);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          substring$val$142 = file_name.substring (bs + 1, len);
        }
// 195
        file_name = substring$val$142;
      }
    }
// 198
    JP.go.ipa.oz.lib.standard._String_if source = createPath (file_name);
// 200
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
      try {
        sys.debugPrintln (source);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      sys.debugPrintln (source);
    }
// 202
    JP.go.ipa.oz.lib.standard._FileOutputStream_if file = (JP.go.ipa.oz.lib.standard._FileOutputStream_cl) (new JP.go.ipa.oz.lib.standard._FileOutputStream_cl ())._new_breed (source);
// 203
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file)) {
      try {
        file.write (src);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      file.write (src);
    }
// 204
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file)) {
      try {
        file.close ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      file.close ();
    }
// 206
    return source;
  }
  
  JP.go.ipa.oz.lib.standard._String_if extractZipped (JP.go.ipa.oz.lib.standard._ByteArray_if src, JP.go.ipa.oz.lib.standard._Set_if sources) throws Exception  {
// 216
    JP.go.ipa.oz.lib.standard._String_if source = createPath ((new JP.go.ipa.oz.lib.standard._String_cl("wwps.zip")));
// 218
    JP.go.ipa.oz.lib.standard._System_if sys = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 219
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
      try {
        sys.debugPrintln (source);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      sys.debugPrintln (source);
    }
// 221
    JP.go.ipa.oz.lib.standard._FileOutputStream_if file = (JP.go.ipa.oz.lib.standard._FileOutputStream_cl) (new JP.go.ipa.oz.lib.standard._FileOutputStream_cl ())._new_breed (source);
// 222
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file)) {
      try {
        file.write (src);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      file.write (src);
    }
// 223
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file)) {
      try {
        file.close ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      file.close ();
    }
// 225
    try {
// 226
      JP.go.ipa.oz.lib.standard._ZipArchive_if zip = (JP.go.ipa.oz.lib.standard._ZipArchive_cl) (new JP.go.ipa.oz.lib.standard._ZipArchive_cl ())._new_create (source);
// 227
      JP.go.ipa.oz.lib.standard._Collection_if list$val$143;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) zip)) {
        try {
          list$val$143 = zip.list ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        list$val$143 = zip.list ();
      }
// 227
      JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$144;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) list$val$143)) {
        try {
          iterator$val$144 = list$val$143.iterator ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        iterator$val$144 = list$val$143.iterator ();
      }
// 227
      JP.go.ipa.oz.lib.standard._Iterator_if it = iterator$val$144;
// 228
      while (true) {
// 228
        boolean hasMoreElements$val$145;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
          try {
            hasMoreElements$val$145 = it.hasMoreElements ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          hasMoreElements$val$145 = it.hasMoreElements ();
        }
        if (!(hasMoreElements$val$145)) break;
        
        /* body */ _loop_1: {
// 229
          JP.go.ipa.oz.lib.standard._String_if ozsrc = null;
// 230
          JP.go.ipa.oz.lang._Root_if nextElement$val$146;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
            try {
              nextElement$val$146 = it.nextElement ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            nextElement$val$146 = it.nextElement ();
          }
// 230
          ozsrc = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$146);
// 232
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
            try {
              sys.debugPrintln (ozsrc);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            sys.debugPrintln (ozsrc);
          }
// 234
          JP.go.ipa.oz.lib.standard._File_if f = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (ozsrc);
// 235
          JP.go.ipa.oz.lib.standard._String_if getName$val$147;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) f)) {
            try {
              getName$val$147 = f.getName ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getName$val$147 = f.getName ();
          }
// 235
          JP.go.ipa.oz.lib.standard._String_if src$1 = createPath (getName$val$147);
// 237
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) zip)) {
            try {
              zip.extract (src$1, ozsrc);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            zip.extract (src$1, ozsrc);
          }
// 238
          JP.go.ipa.oz.lib.standard._Set_if add$val$148;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sources)) {
            try {
              add$val$148 = sources.add (src$1);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            add$val$148 = sources.add (src$1);
          }
        }
      }
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_2) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_2 = _exception_2.getOzException ();
      if (_oz_exception_2 instanceof JP.go.ipa.oz.lib.standard._ZipException_if) {
        JP.go.ipa.oz.lib.standard._ZipException_if e = (JP.go.ipa.oz.lib.standard._ZipException_if) _oz_exception_2;
// 241
        JP.go.ipa.oz.lib.standard._String_if getMessage$val$149;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) e)) {
          try {
            getMessage$val$149 = e.getMessage ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getMessage$val$149 = e.getMessage ();
        }
// 241
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
          try {
            sys.debugPrintln (getMessage$val$149);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          sys.debugPrintln (getMessage$val$149);
        }
// 243
        throw new JP.go.ipa.oz.lang.OzException (source);
      } else if (_oz_exception_2 instanceof JP.go.ipa.oz.lib.standard._FileNotFoundException_if) {
        JP.go.ipa.oz.lib.standard._FileNotFoundException_if e = (JP.go.ipa.oz.lib.standard._FileNotFoundException_if) _oz_exception_2;
// 245
        sys.debugPrintln (e.getMessage ());
// 247
        throw new JP.go.ipa.oz.lang.OzException (source);
      } else if (_oz_exception_2 instanceof JP.go.ipa.oz.lib.standard._IOException_if) {
        JP.go.ipa.oz.lib.standard._IOException_if e = (JP.go.ipa.oz.lib.standard._IOException_if) _oz_exception_2;
// 249
        sys.debugPrintln (e.getMessage ());
// 251
        throw new JP.go.ipa.oz.lang.OzException (source);
      } else throw _exception_2;
    }
// 254
    return source;
  }
  
  protected JP.go.ipa.oz.user.ide.School_if extractSchool (JP.go.ipa.oz.lib.standard._String_if school_name, JP.go.ipa.oz.lib.standard._String_if school_tag) throws Exception  {
// 126
    JP.go.ipa.oz.lib.standard._ByteArray_if school_src = null;
// 127
    JP.go.ipa.oz.lang._Root_if getValue$val$150;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        getValue$val$150 = html.getValue (school_tag);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getValue$val$150 = html.getValue (school_tag);
    }
// 127
    school_src = (JP.go.ipa.oz.lib.standard._ByteArray_if) (getValue$val$150);
// 129
    JP.go.ipa.oz.lib.standard._System_if sys = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 130
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
      try {
        sys.debugPrintln (school_name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      sys.debugPrintln (school_name);
    }
// 132
    int length$val$151;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school_src)) {
      try {
        length$val$151 = school_src.length ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      length$val$151 = school_src.length ();
    }
// 132
    if (length$val$151 == 0) {
// 133
      return null;
    }
// 135
    JP.go.ipa.oz.lib.standard._String_if school_src_name = createPath ((new JP.go.ipa.oz.lib.standard._String_cl("school.s")));
// 136
    JP.go.ipa.oz.lib.standard._FileOutputStream_if file = (JP.go.ipa.oz.lib.standard._FileOutputStream_cl) (new JP.go.ipa.oz.lib.standard._FileOutputStream_cl ())._new_breed (school_src_name);
// 137
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file)) {
      try {
        file.write (school_src);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      file.write (school_src);
    }
// 138
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file)) {
      try {
        file.close ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      file.close ();
    }
// 141
    JP.go.ipa.oz.user.ide.School_if school = (JP.go.ipa.oz.user.ide.School_cl) (new JP.go.ipa.oz.user.ide.School_cl ())._new_create ();
// 142
    JP.go.ipa.oz.user.ide.Subject_if sub = (JP.go.ipa.oz.user.ide.Subject_cl) (new JP.go.ipa.oz.user.ide.Subject_cl ())._new_create (school_name);
// 143
    JP.go.ipa.oz.user.ide.School_if putSubject$val$152;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
      try {
        putSubject$val$152 = school.putSubject (sub);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putSubject$val$152 = school.putSubject (sub);
    }
// 144
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
      try {
        school.loadFromFile (school_src_name, school_name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      school.loadFromFile (school_src_name, school_name);
    }
// 148
    if (!test_mode) {{
// 149
        JP.go.ipa.oz.lib.standard._File_if f = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (school_src_name);
// 150
        boolean delete$val$153;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) f)) {
          try {
            delete$val$153 = f.delete ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          delete$val$153 = f.delete ();
        }
      }
    }
// 156
    return school;
  }
  
  protected JP.go.ipa.oz.lib.standard._String_if extractSource (JP.go.ipa.oz.lib.standard._Set_if sources) throws Exception  {
// 166
    JP.go.ipa.oz.lib.standard._ByteArray_if src = null;
// 167
    JP.go.ipa.oz.lib.standard._String_if string$86 = (new JP.go.ipa.oz.lib.standard._String_cl("src"));
    
// 167
    JP.go.ipa.oz.lang._Root_if getValue$val$154;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        getValue$val$154 = html.getValue (string$86);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getValue$val$154 = html.getValue (string$86);
    }
// 167
    src = (JP.go.ipa.oz.lib.standard._ByteArray_if) (getValue$val$154);
// 169
    JP.go.ipa.oz.lib.standard._String_if filename = null;
// 170
    JP.go.ipa.oz.lib.standard._String_if string$87 = (new JP.go.ipa.oz.lib.standard._String_cl("srcfilename"));
    
// 170
    JP.go.ipa.oz.lang._Root_if getValue$val$155;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        getValue$val$155 = html.getValue (string$87);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getValue$val$155 = html.getValue (string$87);
    }
// 170
    filename = (JP.go.ipa.oz.lib.standard._String_if) (getValue$val$155);
// 172
    JP.go.ipa.oz.lib.standard._String_if string$88 = (new JP.go.ipa.oz.lib.standard._String_cl(".oz"));
    
// 172
    boolean endsWith$val$156;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) filename)) {
      try {
        endsWith$val$156 = filename.endsWith (string$88);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      endsWith$val$156 = filename.endsWith (string$88);
    }
// 172
    if (endsWith$val$156) {
// 173
      return extractOne (filename, src);
    } else {{
// 175
        extractZipped (src, sources);
// 176
        return null;
      }
    }
  }
  
  public WWPSExecuteThread_cl () throws Exception { super (); }
  
}

