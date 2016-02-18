package JP.go.ipa.oz.user.inter.wwps;

public class CompileThread_cl extends JP.go.ipa.oz.user.inter.wwps.WWPSExecuteThread_cl implements JP.go.ipa.oz.user.inter.wwps.CompileThread_if {
  JP.go.ipa.oz.user.ide.School_if school;
  JP.go.ipa.oz.lib.standard._String_if source;
  JP.go.ipa.oz.user.inter.wwps.CompilerServer_if compiler_server;
  
  public Object _new_create (JP.go.ipa.oz.user.inter.cgi.OzCGI_if c, JP.go.ipa.oz.user.inter.cgi.HTMLData_if h, JP.go.ipa.oz.user.inter.wwps.CompilerServer_if cs) throws Exception  {
// 216
    super._new_create (c, h);
// 217
    compiler_server = cs;
    return this;
  }
  
  public Object _new_createForTest (JP.go.ipa.oz.user.inter.cgi.OzCGI_if c, JP.go.ipa.oz.user.inter.cgi.HTMLData_if h, JP.go.ipa.oz.user.inter.wwps.CompilerServer_if cs) throws Exception  {
// 228
    super._new_create (c, h);
// 229
    compiler_server = cs;
// 230
    test_mode = true;
    return this;
  }
  
  void getSchool () throws Exception  {
// 185
    JP.go.ipa.oz.lib.standard._String_if school_name = null;
// 186
    JP.go.ipa.oz.lib.standard._String_if string$27 = (new JP.go.ipa.oz.lib.standard._String_cl("school_name"));
    
// 186
    JP.go.ipa.oz.lang._Root_if getValue$val$79;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        getValue$val$79 = html.getValue (string$27);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getValue$val$79 = html.getValue (string$27);
    }
// 186
    school_name = (JP.go.ipa.oz.lib.standard._String_if) (getValue$val$79);
// 187
    int length$val$80;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school_name)) {
      try {
        length$val$80 = school_name.length ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      length$val$80 = school_name.length ();
    }
// 187
    if (length$val$80 == 0) {{
// 188
        sendResult ((new JP.go.ipa.oz.lib.standard._String_cl("need school name.")));
// 189
        return;
      }
    }
// 192
    school = extractSchool (school_name, (new JP.go.ipa.oz.lib.standard._String_cl("school")));
// 193
    if (school != null) {
// 194
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) compiler_server)) {
        try {
          compiler_server.registerSchool (school_name, school);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        compiler_server.registerSchool (school_name, school);
      }
    } else {{
// 196
        JP.go.ipa.oz.user.ide.School_if searchSchool$val$81;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) compiler_server)) {
          try {
            searchSchool$val$81 = compiler_server.searchSchool (school_name);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          searchSchool$val$81 = compiler_server.searchSchool (school_name);
        }
// 196
        school = searchSchool$val$81;
// 198
        if (school == null) {{
// 199
            JP.go.ipa.oz.lib.standard._StringBuffer_if buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 200
            JP.go.ipa.oz.lib.standard._String_if string$28 = (new JP.go.ipa.oz.lib.standard._String_cl("not found school: "));
            
// 200
            JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$82;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
              try {
                append$val$82 = buf.append (string$28);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              append$val$82 = buf.append (string$28);
            }
// 201
            JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$83;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
              try {
                append$val$83 = buf.append (school_name);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              append$val$83 = buf.append (school_name);
            }
// 202
            JP.go.ipa.oz.lib.standard._String_if asString$val$84;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
              try {
                asString$val$84 = buf.asString ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              asString$val$84 = buf.asString ();
            }
// 202
            sendResult (asString$val$84);
// 203
            return;
          }
        }
      }
    }
  }
  
  public void run () throws Exception  {
    checkSecureInvocation ();
// 135
    try {
// 136
      JP.go.ipa.oz.lib.standard._Set_if sources = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create ();
// 138
      source = extractSource (sources);
// 140
      getSchool ();
// 142
      if (test_mode) {{
// 143
          sendResult ((new JP.go.ipa.oz.lib.standard._String_cl("done")));
// 144
          return;
        }
      }
// 148
      JP.go.ipa.oz.lib.standard._StringWriter_if log = (JP.go.ipa.oz.lib.standard._StringWriter_cl) (new JP.go.ipa.oz.lib.standard._StringWriter_cl ())._new_breed ();
// 150
      int size$val$85;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sources)) {
        try {
          size$val$85 = sources.size ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        size$val$85 = sources.size ();
      }
// 150
      if (size$val$85 == 0) {
// 151
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) compiler_server)) {
          try {
            compiler_server.compile (source, school, log);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          compiler_server.compile (source, school, log);
        }
      } else {{
// 153
          JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$86;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sources)) {
            try {
              iterator$val$86 = sources.iterator ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            iterator$val$86 = sources.iterator ();
          }
// 153
          JP.go.ipa.oz.lib.standard._Iterator_if it = iterator$val$86;
// 154
          while (true) {
// 154
            boolean hasMoreElements$val$87;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
              try {
                hasMoreElements$val$87 = it.hasMoreElements ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              hasMoreElements$val$87 = it.hasMoreElements ();
            }
            if (!(hasMoreElements$val$87)) break;
            
            /* body */ _loop_1: {
// 155
              JP.go.ipa.oz.lang._Root_if nextElement$val$88;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
                try {
                  nextElement$val$88 = it.nextElement ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                nextElement$val$88 = it.nextElement ();
              }
// 155
              source = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$88);
// 156
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) compiler_server)) {
                try {
                  compiler_server.compile (source, school, log);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                compiler_server.compile (source, school, log);
              }
            }
          }
        }
      }
// 160
      sendResult (log);
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_1) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_1 = _exception_1.getOzException ();
      if (_oz_exception_1 instanceof JP.go.ipa.oz.lib.standard._String_if) {
        JP.go.ipa.oz.lib.standard._String_if zip = (JP.go.ipa.oz.lib.standard._String_if) _oz_exception_1;
// 162
        sendResult ((new JP.go.ipa.oz.lib.standard._String_cl("not zip file")));
      } else throw _exception_1;
    } finally {
// 165
      if (test_mode) {
// 165
        return;
      }
// 169
      JP.go.ipa.oz.lib.standard._File_if f = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (source);
// 170
      JP.go.ipa.oz.lib.standard._String_if getParent$val$89;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) f)) {
        try {
          getParent$val$89 = f.getParent ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getParent$val$89 = f.getParent ();
      }
// 170
      JP.go.ipa.oz.lib.standard._String_if getSeparator$val$90;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) f)) {
        try {
          getSeparator$val$90 = f.getSeparator ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getSeparator$val$90 = f.getSeparator ();
      }
// 170
      JP.go.ipa.oz.lib.standard._String_if concat$val$91;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getParent$val$89)) {
        try {
          concat$val$91 = getParent$val$89.concat (getSeparator$val$90);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        concat$val$91 = getParent$val$89.concat (getSeparator$val$90);
      }
// 170
      JP.go.ipa.oz.lib.standard._String_if dir = concat$val$91;
// 171
      JP.go.ipa.oz.lib.standard._System_if sys = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 172
      JP.go.ipa.oz.lib.standard._String_if string$29 = (new JP.go.ipa.oz.lib.standard._String_cl("run#"));
      
// 172
      JP.go.ipa.oz.lib.standard._String_if concat$val$92;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$29)) {
        try {
          concat$val$92 = string$29.concat (dir);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        concat$val$92 = string$29.concat (dir);
      }
// 172
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
        try {
          sys.debugPrintln (concat$val$92);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        sys.debugPrintln (concat$val$92);
      }
// 173
      JP.go.ipa.oz.user.inter.wwps.CompilerAgent_if ozc = (JP.go.ipa.oz.user.inter.wwps.CompilerAgent_cl) (new JP.go.ipa.oz.user.inter.wwps.CompilerAgent_cl ())._new_create (dir);
// 174
      boolean deleteAllFiles$val$93;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozc)) {
        try {
          deleteAllFiles$val$93 = ozc.deleteAllFiles ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        deleteAllFiles$val$93 = ozc.deleteAllFiles ();
      }
// 175
      (f = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (dir)).delete ();
    }
  }
  
  public CompileThread_cl () throws Exception { super (); }
  
}

