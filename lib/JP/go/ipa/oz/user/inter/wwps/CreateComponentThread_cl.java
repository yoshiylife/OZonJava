package JP.go.ipa.oz.user.inter.wwps;

public class CreateComponentThread_cl extends JP.go.ipa.oz.user.inter.wwps.WWPSExecuteThread_cl implements JP.go.ipa.oz.user.inter.wwps.CreateComponentThread_if {
  
  public Object _new_create (JP.go.ipa.oz.user.inter.cgi.OzCGI_if c, JP.go.ipa.oz.user.inter.cgi.HTMLData_if h) throws Exception  {
// 241
    super._new_create (c, h);
    return this;
  }
  
  public Object _new_createForTest (JP.go.ipa.oz.user.inter.cgi.OzCGI_if c, JP.go.ipa.oz.user.inter.cgi.HTMLData_if h) throws Exception  {
// 251
    super._new_create (c, h);
// 252
    test_mode = true;
    return this;
  }
  
  void send_subject_contents (JP.go.ipa.oz.user.ide.Subject_if sbj) throws Exception  {
// 259
    JP.go.ipa.oz.lib.standard._String_if getSubjectName$val$111;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbj)) {
      try {
        getSubjectName$val$111 = sbj.getSubjectName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSubjectName$val$111 = sbj.getSubjectName ();
    }
// 259
    JP.go.ipa.oz.lib.standard._String_if subject_name = getSubjectName$val$111;
// 261
    JP.go.ipa.oz.lib.standard._String_if string$38 = (new JP.go.ipa.oz.lib.standard._String_cl("text/html"));
    
// 261
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.startOutput (string$38);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.startOutput (string$38);
    }
// 262
    JP.go.ipa.oz.lib.standard._String_if string$39 = (new JP.go.ipa.oz.lib.standard._String_cl("html"));
    
// 262
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.beginTag (string$39);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.beginTag (string$39);
    }
// 263
    JP.go.ipa.oz.lib.standard._String_if string$40 = (new JP.go.ipa.oz.lib.standard._String_cl("head"));
    
// 263
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.beginTag (string$40);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.beginTag (string$40);
    }
// 264
    JP.go.ipa.oz.lib.standard._String_if string$41 = (new JP.go.ipa.oz.lib.standard._String_cl("title"));
    
// 264
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.beginTag (string$41);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.beginTag (string$41);
    }
// 265
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.addOutput (subject_name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.addOutput (subject_name);
    }
// 266
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.endTag ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.endTag ();
    }
// 267
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.endTag ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.endTag ();
    }
// 269
    JP.go.ipa.oz.lib.standard._String_if string$42 = (new JP.go.ipa.oz.lib.standard._String_cl("body"));
    
// 269
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.beginTag (string$42);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.beginTag (string$42);
    }
// 271
    JP.go.ipa.oz.lib.standard._String_if string$43 = (new JP.go.ipa.oz.lib.standard._String_cl("h1"));
    
// 271
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.beginTag (string$43);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.beginTag (string$43);
    }
// 272
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.addOutput (subject_name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.addOutput (subject_name);
    }
// 273
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.endTag ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.endTag ();
    }
// 275
    JP.go.ipa.oz.lib.standard._String_if getPackageName$val$112;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbj)) {
      try {
        getPackageName$val$112 = sbj.getPackageName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getPackageName$val$112 = sbj.getPackageName ();
    }
// 275
    JP.go.ipa.oz.lib.standard._String_if pakage = getPackageName$val$112;
// 276
    JP.go.ipa.oz.lib.standard._String_if string$44 = (new JP.go.ipa.oz.lib.standard._String_cl("h3"));
    
// 276
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.beginTag (string$44);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.beginTag (string$44);
    }
// 277
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.addOutput (pakage);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.addOutput (pakage);
    }
// 278
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.endTag ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.endTag ();
    }
// 280
    JP.go.ipa.oz.lib.standard._String_if string$45 = (new JP.go.ipa.oz.lib.standard._String_cl("pre"));
    
// 280
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.beginTag (string$45);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.beginTag (string$45);
    }
// 282
    JP.go.ipa.oz.lib.standard._Dictionary_if getOzLabels$val$113;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbj)) {
      try {
        getOzLabels$val$113 = sbj.getOzLabels ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzLabels$val$113 = sbj.getOzLabels ();
    }
// 282
    JP.go.ipa.oz.lib.standard._Dictionary_if labels = getOzLabels$val$113;
// 283
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$114;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) labels)) {
      try {
        iterator$val$114 = labels.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$114 = labels.iterator ();
    }
// 283
    JP.go.ipa.oz.lib.standard._Iterator_if it = iterator$val$114;
// 284
    JP.go.ipa.oz.lib.standard._StringBuffer_if buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 285
    while (true) {
// 285
      boolean hasMoreElements$val$115;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
        try {
          hasMoreElements$val$115 = it.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$115 = it.hasMoreElements ();
      }
      if (!(hasMoreElements$val$115)) break;
      
      /* body */ _loop_1: {
// 286
        JP.go.ipa.oz.user.ide.OzLabel_if ozlabel = null;
// 287
        JP.go.ipa.oz.lang._Root_if nextElement$val$116;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
          try {
            nextElement$val$116 = it.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$116 = it.nextElement ();
        }
// 287
        ozlabel = (JP.go.ipa.oz.user.ide.OzLabel_if) (nextElement$val$116);
// 288
        JP.go.ipa.oz.lib.standard._String_if getOzLabelName$val$117;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozlabel)) {
          try {
            getOzLabelName$val$117 = ozlabel.getOzLabelName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getOzLabelName$val$117 = ozlabel.getOzLabelName ();
        }
// 288
        JP.go.ipa.oz.lib.standard._String_if label = getOzLabelName$val$117;
// 289
        JP.go.ipa.oz.lib.standard._String_if getInterfaceID$val$118;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozlabel)) {
          try {
            getInterfaceID$val$118 = ozlabel.getInterfaceID ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getInterfaceID$val$118 = ozlabel.getInterfaceID ();
        }
// 289
        JP.go.ipa.oz.lib.standard._String_if if_id = getInterfaceID$val$118;
// 290
        JP.go.ipa.oz.lib.standard._String_if getImplementationID$val$119;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozlabel)) {
          try {
            getImplementationID$val$119 = ozlabel.getImplementationID ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getImplementationID$val$119 = ozlabel.getImplementationID ();
        }
// 290
        JP.go.ipa.oz.lib.standard._String_if impl_id = getImplementationID$val$119;
// 292
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$120;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$120 = buf.append ('\"');
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$120 = buf.append ('\"');
        }
// 293
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$121;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$121 = buf.append (label);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$121 = buf.append (label);
        }
// 294
        JP.go.ipa.oz.lib.standard._String_if string$46 = (new JP.go.ipa.oz.lib.standard._String_cl("\",\""));
        
// 294
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$122;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$122 = buf.append (string$46);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$122 = buf.append (string$46);
        }
// 295
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$123;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$123 = buf.append (if_id);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$123 = buf.append (if_id);
        }
// 296
        JP.go.ipa.oz.lib.standard._String_if string$47 = (new JP.go.ipa.oz.lib.standard._String_cl("\",\""));
        
// 296
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$124;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$124 = buf.append (string$47);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$124 = buf.append (string$47);
        }
// 297
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$125;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$125 = buf.append (impl_id);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$125 = buf.append (impl_id);
        }
// 298
        JP.go.ipa.oz.lib.standard._String_if string$48 = (new JP.go.ipa.oz.lib.standard._String_cl("\"\n"));
        
// 298
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$126;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$126 = buf.append (string$48);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$126 = buf.append (string$48);
        }
// 300
        JP.go.ipa.oz.lib.standard._String_if asString$val$127;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            asString$val$127 = buf.asString ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          asString$val$127 = buf.asString ();
        }
// 300
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
          try {
            html.addOutput (asString$val$127);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          html.addOutput (asString$val$127);
        }
// 302
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            buf.setLength (0);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          buf.setLength (0);
        }
      }
    }
// 305
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.endOutput ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.endOutput ();
    }
// 306
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cgi)) {
      try {
        cgi.sendResult (html);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      cgi.sendResult (html);
    }
  }
  
  boolean release_compile (JP.go.ipa.oz.user.ide.School_if sc, JP.go.ipa.oz.user.ide.Subject_if subject, JP.go.ipa.oz.lib.standard._String_if sbj_name) throws Exception  {
// 177
    JP.go.ipa.oz.lib.standard._Set_if sources = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create ();
// 178
    JP.go.ipa.oz.lib.standard._String_if source = null;
// 179
    try {
// 180
      source = extractSource (sources);
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_1) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_1 = _exception_1.getOzException ();
      if (_oz_exception_1 instanceof JP.go.ipa.oz.lib.standard._String_if) {
        JP.go.ipa.oz.lib.standard._String_if src = (JP.go.ipa.oz.lib.standard._String_if) _oz_exception_1;
// 182
        JP.go.ipa.oz.lib.standard._String_if string$49 = (new JP.go.ipa.oz.lib.standard._String_cl("illegal file: "));
        
// 182
        JP.go.ipa.oz.lib.standard._String_if concat$val$128;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$49)) {
          try {
            concat$val$128 = string$49.concat (src);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          concat$val$128 = string$49.concat (src);
        }
// 182
        sendResult (concat$val$128);
// 183
        return false;
      } else throw _exception_1;
    }
// 186
    if (source == null) {{
// 187
        JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$129;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sources)) {
          try {
            iterator$val$129 = sources.iterator ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          iterator$val$129 = sources.iterator ();
        }
// 187
        JP.go.ipa.oz.lib.standard._Iterator_if it = iterator$val$129;
// 188
        boolean hasMoreElements$val$130;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
          try {
            hasMoreElements$val$130 = it.hasMoreElements ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          hasMoreElements$val$130 = it.hasMoreElements ();
        }
// 188
        if (!hasMoreElements$val$130) {{
// 189
            sendResult ((new JP.go.ipa.oz.lib.standard._String_cl("no source was specified")));
// 190
            return false;
          }
        }
// 193
        JP.go.ipa.oz.lang._Root_if nextElement$val$131;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
          try {
            nextElement$val$131 = it.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$131 = it.nextElement ();
        }
// 193
        source = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$131);
      }
    }
// 196
    JP.go.ipa.oz.lib.standard._String_if dir = null;
// 197
    JP.go.ipa.oz.user.inter.wwps.CompilerAgent_if ozc = null;
// 199
    try {
// 200
      JP.go.ipa.oz.lib.standard._File_if src = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (source);
// 201
      JP.go.ipa.oz.lib.standard._String_if getParent$val$132;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) src)) {
        try {
          getParent$val$132 = src.getParent ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getParent$val$132 = src.getParent ();
      }
// 201
      JP.go.ipa.oz.lib.standard._String_if getSeparator$val$133;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) src)) {
        try {
          getSeparator$val$133 = src.getSeparator ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getSeparator$val$133 = src.getSeparator ();
      }
// 201
      JP.go.ipa.oz.lib.standard._String_if concat$val$134;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getParent$val$132)) {
        try {
          concat$val$134 = getParent$val$132.concat (getSeparator$val$133);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        concat$val$134 = getParent$val$132.concat (getSeparator$val$133);
      }
// 201
      dir = concat$val$134;
// 203
      ozc = (JP.go.ipa.oz.user.inter.wwps.CompilerAgent_cl) (new JP.go.ipa.oz.user.inter.wwps.CompilerAgent_cl ())._new_create (extractSchool (sbj_name, (new JP.go.ipa.oz.lib.standard._String_cl("school"))));
// 204
      JP.go.ipa.oz.lib.standard._StringWriter_if log = (JP.go.ipa.oz.lib.standard._StringWriter_cl) (new JP.go.ipa.oz.lib.standard._StringWriter_cl ())._new_breed ();
// 205
      if (!ozc.compileSubjectForRelease (dir, log)) {{
// 206
          sendResult ((new JP.go.ipa.oz.lib.standard._String_cl("compilation for release was failed")));
// 207
          return false;
        }
      }
// 210
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sc)) {
        try {
          sc.toReleasState (sbj_name);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        sc.toReleasState (sbj_name);
      }
// 211
      ozc.setSchool (sc);
// 213
      JP.go.ipa.oz.lib.standard._String_if getPackageName$val$135;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
        try {
          getPackageName$val$135 = subject.getPackageName ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getPackageName$val$135 = subject.getPackageName ();
      }
// 213
      JP.go.ipa.oz.lib.standard._String_if package_name = getPackageName$val$135;
// 215
      if (!ozc.release (dir, 3, (new JP.go.ipa.oz.lib.standard._String_cl("wwps-release")))) {
// 216
        return false;
      }
// 217
      JP.go.ipa.oz.lib.standard._String_if getReleaseDir$val$136;
      getReleaseDir$val$136 = ozc.getReleaseDir ();
// 217
      JP.go.ipa.oz.lib.standard._String_if string$50 = (new JP.go.ipa.oz.lib.standard._String_cl("wwps-release.zip"));
      
// 217
      JP.go.ipa.oz.lib.standard._String_if concat$val$137;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getReleaseDir$val$136)) {
        try {
          concat$val$137 = getReleaseDir$val$136.concat (string$50);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        concat$val$137 = getReleaseDir$val$136.concat (string$50);
      }
// 217
      JP.go.ipa.oz.lib.standard._File_if file = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (concat$val$137);
// 218
      try {
// 219
        JP.go.ipa.oz.lib.standard._LocalRepositoryManager_if localMgr = (JP.go.ipa.oz.lib.standard._LocalRepositoryManager_cl) (new JP.go.ipa.oz.lib.standard._LocalRepositoryManager_cl ())._new_create ();
// 220
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) localMgr)) {
          try {
            localMgr.add (file, package_name);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          localMgr.add (file, package_name);
        }
      }
      catch (java.lang.SecurityException _exception_e) {
        JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
        
// 222
        sendResult ((new JP.go.ipa.oz.lib.standard._String_cl("Local repository already has this subject")));
// 223
        return false;
      }
    } finally {
// 226
      ozc.deleteAllFiles ();
// 227
      JP.go.ipa.oz.lib.standard._File_if f = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (dir);
// 228
      boolean delete$val$138;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) f)) {
        try {
          delete$val$138 = f.delete ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        delete$val$138 = f.delete ();
      }
    }
// 231
    return true;
  }
  
  public void run () throws Exception  {
    checkSecureInvocation ();
// 134
    JP.go.ipa.oz.lib.standard._String_if catalog_name = null;
// 135
    JP.go.ipa.oz.lib.standard._String_if string$51 = (new JP.go.ipa.oz.lib.standard._String_cl("catalog"));
    
// 135
    JP.go.ipa.oz.lang._Root_if getValue$val$139;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        getValue$val$139 = html.getValue (string$51);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getValue$val$139 = html.getValue (string$51);
    }
// 135
    catalog_name = (JP.go.ipa.oz.lib.standard._String_if) (getValue$val$139);
// 136
    JP.go.ipa.oz.user.garage.SubjectGarage_if catalog = null;
// 137
    if (catalog_name != null) {
// 138
      catalog = new JP.go.ipa.oz.user.garage.SubjectGarage_pcl (catalog_name);
    }
// 140
    JP.go.ipa.oz.lib.standard._String_if subject_name = null;
// 141
    JP.go.ipa.oz.lib.standard._String_if string$52 = (new JP.go.ipa.oz.lib.standard._String_cl("subject"));
    
// 141
    JP.go.ipa.oz.lang._Root_if getValue$val$140;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        getValue$val$140 = html.getValue (string$52);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getValue$val$140 = html.getValue (string$52);
    }
// 141
    subject_name = (JP.go.ipa.oz.lib.standard._String_if) (getValue$val$140);
// 142
    JP.go.ipa.oz.user.ide.School_if sc = extractSchool (subject_name, (new JP.go.ipa.oz.lib.standard._String_cl("release_school")));
// 143
    JP.go.ipa.oz.user.ide.Subject_if getSubject$val$141;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sc)) {
      try {
        getSubject$val$141 = sc.getSubject (subject_name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSubject$val$141 = sc.getSubject (subject_name);
    }
// 143
    JP.go.ipa.oz.user.ide.Subject_if subject = getSubject$val$141;
// 145
    JP.go.ipa.oz.lib.standard._String_if sum = null;
// 146
    JP.go.ipa.oz.lib.standard._String_if string$53 = (new JP.go.ipa.oz.lib.standard._String_cl("summary"));
    
// 146
    JP.go.ipa.oz.lang._Root_if getValue$val$142;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        getValue$val$142 = html.getValue (string$53);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getValue$val$142 = html.getValue (string$53);
    }
// 146
    sum = (JP.go.ipa.oz.lib.standard._String_if) (getValue$val$142);
// 147
    JP.go.ipa.oz.user.ide.SubjectSummary_if summary = (JP.go.ipa.oz.user.ide.SubjectSummary_cl) (new JP.go.ipa.oz.user.ide.SubjectSummary_cl ())._new_create (subject_name, sum);
// 148
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
      try {
        subject.setSummary (summary);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      subject.setSummary (summary);
    }
// 150
    if (!release_compile (sc, subject, subject_name)) {{
// 151
        return;
      }
    }
// 154
    if (test_mode) {{
// 155
        send_subject_contents (subject);
// 156
        return;
      }
    }
// 159
    try {
// 160
      catalog.put (subject);
// 161
      sendResult ((new JP.go.ipa.oz.lib.standard._String_cl("registered")));
    }
    catch (JP.go.ipa.oz.system.ExCellNotFoundException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 163
      sendResult ((new JP.go.ipa.oz.lib.standard._String_cl("cannot found catalog")));
    }
  }
  
  public CreateComponentThread_cl () throws Exception { super (); }
  
}

