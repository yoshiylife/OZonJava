package JP.go.ipa.oz.user.inter.wwps;

public class RemoteExecuteThread_cl extends JP.go.ipa.oz.user.inter.cgi.ExecuteThread_cl implements JP.go.ipa.oz.user.inter.wwps.RemoteExecuteThread_if {
  
  public Object _new_create (JP.go.ipa.oz.user.inter.cgi.OzCGI_if c, JP.go.ipa.oz.user.inter.cgi.HTMLData_if h) throws Exception  {
// 269
    super._new_create (c, h);
    return this;
  }
  
  public Object _new_createForTest (JP.go.ipa.oz.user.inter.cgi.OzCGI_if c, JP.go.ipa.oz.user.inter.cgi.HTMLData_if h) throws Exception  {
// 279
    super._new_create (c, h);
// 280
    test_mode = true;
    return this;
  }
  
  void exec (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception  {
// 130
    try {
// 131
      JP.go.ipa.oz.lib.standard._ClassLoader_if cl = (JP.go.ipa.oz.lib.standard._ClassLoader_cl) (new JP.go.ipa.oz.lib.standard._ClassLoader_cl ())._new_create ();
// 132
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cl)) {
        try {
          cl.loadClass (cid);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        cl.loadClass (cid);
      }
    }
    catch (JP.go.ipa.oz.system.ExClassNotFoundException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 134
      JP.go.ipa.oz.lib.standard._String_if string$110 = (new JP.go.ipa.oz.lib.standard._String_cl("cannot execute that class for some reason: "));
      
// 134
      JP.go.ipa.oz.lib.standard._String_if concat$val$218;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$110)) {
        try {
          concat$val$218 = string$110.concat (cid);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        concat$val$218 = string$110.concat (cid);
      }
// 134
      sendResult (concat$val$218);
// 135
      return;
    }
// 139
    JP.go.ipa.oz.lib.standard._String_if exec_file = createPath ((new JP.go.ipa.oz.lib.standard._String_cl("exec")));
// 140
    JP.go.ipa.oz.lib.standard._String_if getRequestID$val$219;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        getRequestID$val$219 = html.getRequestID ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getRequestID$val$219 = html.getRequestID ();
    }
// 140
    JP.go.ipa.oz.lib.standard._String_if exec_log = createPath ((new JP.go.ipa.oz.lib.standard._String_cl("exec.log")), getRequestID$val$219);
// 142
    JP.go.ipa.oz.lib.standard._Writer_if file = null;
// 143
    JP.go.ipa.oz.lib.standard._FileWriter_if fw = null;
// 144
    JP.go.ipa.oz.lib.standard._StringWriter_if sw = null;
// 146
    if (test_mode) {{
// 147
        sw = (JP.go.ipa.oz.lib.standard._StringWriter_cl) (new JP.go.ipa.oz.lib.standard._StringWriter_cl ())._new_breed ();
// 148
        file = sw;
      }
    } else {{
// 150
        fw = (JP.go.ipa.oz.lib.standard._FileWriter_cl) (new JP.go.ipa.oz.lib.standard._FileWriter_cl ())._new_breed (exec_file);
// 151
        file = fw;
      }
    }
// 154
    JP.go.ipa.oz.lib.standard._StringBuffer_if command = null;
// 155
    JP.go.ipa.oz.lib.standard._File_if f = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (exec_file);
// 156
    JP.go.ipa.oz.lib.standard._StringBuffer_if path = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("\"")));
// 157
    char getSeparatorChar$val$220;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) f)) {
      try {
        getSeparatorChar$val$220 = f.getSeparatorChar ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSeparatorChar$val$220 = f.getSeparatorChar ();
    }
// 157
    if (getSeparatorChar$val$220 == '/') {{
// 158
        command = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("oz -f ")));
// 159
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$221;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
          try {
            append$val$221 = path.append (exec_log);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$221 = path.append (exec_log);
        }
      }
    } else {{
// 161
        command = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("oz.bat -f ")));
// 163
        int backslash = 0, prev_backslash = 0;
// 164
        while (true) {
          /* body */ _loop_1: {
// 165
            int indexOf$val$222;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) exec_log)) {
              try {
                indexOf$val$222 = exec_log.indexOf ('\\', prev_backslash);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              indexOf$val$222 = exec_log.indexOf ('\\', prev_backslash);
            }
// 165
            backslash = indexOf$val$222;
// 166
            if (backslash == -1) {{
// 167
                JP.go.ipa.oz.lib.standard._String_if substring$val$223;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) exec_log)) {
                  try {
                    substring$val$223 = exec_log.substring (prev_backslash);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  substring$val$223 = exec_log.substring (prev_backslash);
                }
// 167
                JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$224;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
                  try {
                    append$val$224 = path.append (substring$val$223);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  append$val$224 = path.append (substring$val$223);
                }
// 168
                break;
              }
            } else {
// 170
              JP.go.ipa.oz.lib.standard._String_if substring$val$225;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) exec_log)) {
                try {
                  substring$val$225 = exec_log.substring (prev_backslash, backslash);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                substring$val$225 = exec_log.substring (prev_backslash, backslash);
              }
// 170
              JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$226;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
                try {
                  append$val$226 = path.append (substring$val$225);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                append$val$226 = path.append (substring$val$225);
              }
            }
// 171
            JP.go.ipa.oz.lib.standard._String_if string$111 = (new JP.go.ipa.oz.lib.standard._String_cl("\\\\"));
            
// 171
            JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$227;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
              try {
                append$val$227 = path.append (string$111);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              append$val$227 = path.append (string$111);
            }
// 172
            prev_backslash = backslash + 1;
          }
        }
      }
    }
// 177
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$228;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
      try {
        append$val$228 = path.append ('\"');
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$228 = path.append ('\"');
    }
// 178
    JP.go.ipa.oz.lib.standard._String_if asString$val$229;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
      try {
        asString$val$229 = path.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$229 = path.asString ();
    }
// 178
    writeScript (file, cid, asString$val$229);
// 180
    command.append (exec_file);
// 182
    if (!test_mode) {
// 183
      fw.close ();
    }
// 185
    if (test_mode) {{
// 186
        sendResult (sw.asString ());
// 187
        return;
      }
    }
// 190
    try {
// 191
      JP.go.ipa.oz.lib.standard._Process_if process = (JP.go.ipa.oz.lib.standard._Process_cl) (new JP.go.ipa.oz.lib.standard._Process_cl ())._new_create (command.asString ());
// 194
      int waitFor$val$230;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) process)) {
        try {
          waitFor$val$230 = process.waitFor ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        waitFor$val$230 = process.waitFor ();
      }
// 196
      JP.go.ipa.oz.lib.standard._FileReader_if fr = (JP.go.ipa.oz.lib.standard._FileReader_cl) (new JP.go.ipa.oz.lib.standard._FileReader_cl ())._new_breed (exec_log);
// 197
      JP.go.ipa.oz.lib.standard._BufferedReader_if in = (JP.go.ipa.oz.lib.standard._BufferedReader_cl) (new JP.go.ipa.oz.lib.standard._BufferedReader_cl ())._new_breed (fr);
// 198
      JP.go.ipa.oz.lib.standard._StringWriter_if out = (JP.go.ipa.oz.lib.standard._StringWriter_cl) (new JP.go.ipa.oz.lib.standard._StringWriter_cl ())._new_breed ();
// 199
      while (true) {
        /* body */ _loop_1: {
// 200
          JP.go.ipa.oz.lib.standard._String_if readLine$val$231;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) in)) {
            try {
              readLine$val$231 = in.readLine ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            readLine$val$231 = in.readLine ();
          }
// 200
          JP.go.ipa.oz.lib.standard._String_if line = readLine$val$231;
// 201
          if (line == null) {
// 202
            break;
          }
// 204
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) out)) {
            try {
              out.write (line);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            out.write (line);
          }
// 205
          JP.go.ipa.oz.lib.standard._String_if string$112 = (new JP.go.ipa.oz.lib.standard._String_cl("\n"));
          
// 205
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) out)) {
            try {
              out.write (string$112);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            out.write (string$112);
          }
        }
      }
// 207
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) in)) {
        try {
          in.close ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        in.close ();
      }
// 209
      JP.go.ipa.oz.lib.standard._StringBuffer_if getBuffer$val$232;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) out)) {
        try {
          getBuffer$val$232 = out.getBuffer ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getBuffer$val$232 = out.getBuffer ();
      }
// 209
      int length$val$233;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getBuffer$val$232)) {
        try {
          length$val$233 = getBuffer$val$232.length ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        length$val$233 = getBuffer$val$232.length ();
      }
// 209
      if (length$val$233 == 0) {
// 210
        JP.go.ipa.oz.lib.standard._String_if string$113 = (new JP.go.ipa.oz.lib.standard._String_cl("no output"));
        
// 210
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) out)) {
          try {
            out.write (string$113);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          out.write (string$113);
        }
      }
// 212
      sendResult (out);
    } finally {
// 215
      boolean delete$val$234;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) f)) {
        try {
          delete$val$234 = f.delete ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        delete$val$234 = f.delete ();
      }
// 216
      JP.go.ipa.oz.lib.standard._String_if getParent$val$235;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) f)) {
        try {
          getParent$val$235 = f.getParent ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getParent$val$235 = f.getParent ();
      }
// 216
      (f = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (getParent$val$235)).delete ();
// 217
      f = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (exec_log);
// 218
      f.delete ();
    }
  }
  
  void writeScript (JP.go.ipa.oz.lib.standard._Writer_if file, JP.go.ipa.oz.lib.standard._String_if cid, JP.go.ipa.oz.lib.standard._String_if log_file) throws Exception  {
// 226
    JP.go.ipa.oz.lib.standard._String_if param = null;
// 227
    JP.go.ipa.oz.lib.standard._String_if string$114 = (new JP.go.ipa.oz.lib.standard._String_cl("param"));
    
// 227
    JP.go.ipa.oz.lang._Root_if getValue$val$236;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        getValue$val$236 = html.getValue (string$114);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getValue$val$236 = html.getValue (string$114);
    }
// 227
    param = (JP.go.ipa.oz.lib.standard._String_if) (getValue$val$236);
// 228
    JP.go.ipa.oz.lib.standard._String_if getRequestID$val$237;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        getRequestID$val$237 = html.getRequestID ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getRequestID$val$237 = html.getRequestID ();
    }
// 228
    JP.go.ipa.oz.lib.standard._String_if gid = getRequestID$val$237;
// 229
    JP.go.ipa.oz.lib.standard._StringBuffer_if buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("create ")));
// 231
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$238;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        append$val$238 = buf.append (gid);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$238 = buf.append (gid);
    }
// 232
    JP.go.ipa.oz.lib.standard._String_if string$115 = (new JP.go.ipa.oz.lib.standard._String_cl(" "));
    
// 232
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$239;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        append$val$239 = buf.append (string$115);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$239 = buf.append (string$115);
    }
// 233
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$240;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        append$val$240 = buf.append (cid);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$240 = buf.append (cid);
    }
// 234
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$241;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        append$val$241 = buf.append (' ');
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$241 = buf.append (' ');
    }
// 235
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$242;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        append$val$242 = buf.append (log_file);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$242 = buf.append (log_file);
    }
// 236
    if (param != null) {{
// 237
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$243;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$243 = buf.append (' ');
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$243 = buf.append (' ');
        }
// 238
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$244;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$244 = buf.append (param);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$244 = buf.append (param);
        }
      }
    }
// 240
    JP.go.ipa.oz.lib.standard._String_if string$116 = (new JP.go.ipa.oz.lib.standard._String_cl(";\n"));
    
// 240
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$245;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        append$val$245 = buf.append (string$116);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$245 = buf.append (string$116);
    }
// 241
    JP.go.ipa.oz.lib.standard._String_if asString$val$246;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        asString$val$246 = buf.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$246 = buf.asString ();
    }
// 241
    int length$val$247;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        length$val$247 = buf.length ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      length$val$247 = buf.length ();
    }
// 241
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file)) {
      try {
        file.write (asString$val$246, 0, length$val$247);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      file.write (asString$val$246, 0, length$val$247);
    }
// 243
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        buf.setLength (0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      buf.setLength (0);
    }
// 244
    JP.go.ipa.oz.lib.standard._String_if string$117 = (new JP.go.ipa.oz.lib.standard._String_cl("stop "));
    
// 244
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$248;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        append$val$248 = buf.append (string$117);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$248 = buf.append (string$117);
    }
// 245
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$249;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        append$val$249 = buf.append (gid);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$249 = buf.append (gid);
    }
// 246
    JP.go.ipa.oz.lib.standard._String_if string$118 = (new JP.go.ipa.oz.lib.standard._String_cl(";\n"));
    
// 246
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$250;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        append$val$250 = buf.append (string$118);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$250 = buf.append (string$118);
    }
// 247
    JP.go.ipa.oz.lib.standard._String_if asString$val$251;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        asString$val$251 = buf.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$251 = buf.asString ();
    }
// 247
    int length$val$252;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        length$val$252 = buf.length ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      length$val$252 = buf.length ();
    }
// 247
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file)) {
      try {
        file.write (asString$val$251, 0, length$val$252);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      file.write (asString$val$251, 0, length$val$252);
    }
// 249
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        buf.setLength (0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      buf.setLength (0);
    }
// 250
    JP.go.ipa.oz.lib.standard._String_if string$119 = (new JP.go.ipa.oz.lib.standard._String_cl("go "));
    
// 250
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$253;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        append$val$253 = buf.append (string$119);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$253 = buf.append (string$119);
    }
// 251
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$254;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        append$val$254 = buf.append (gid);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$254 = buf.append (gid);
    }
// 252
    JP.go.ipa.oz.lib.standard._String_if string$120 = (new JP.go.ipa.oz.lib.standard._String_cl(";\n"));
    
// 252
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$255;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        append$val$255 = buf.append (string$120);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$255 = buf.append (string$120);
    }
// 253
    JP.go.ipa.oz.lib.standard._String_if asString$val$256;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        asString$val$256 = buf.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$256 = buf.asString ();
    }
// 253
    int length$val$257;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        length$val$257 = buf.length ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      length$val$257 = buf.length ();
    }
// 253
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file)) {
      try {
        file.write (asString$val$256, 0, length$val$257);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      file.write (asString$val$256, 0, length$val$257);
    }
// 255
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        buf.setLength (0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      buf.setLength (0);
    }
// 256
    JP.go.ipa.oz.lib.standard._String_if string$121 = (new JP.go.ipa.oz.lib.standard._String_cl("remove "));
    
// 256
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$258;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        append$val$258 = buf.append (string$121);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$258 = buf.append (string$121);
    }
// 257
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$259;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        append$val$259 = buf.append (gid);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$259 = buf.append (gid);
    }
// 258
    JP.go.ipa.oz.lib.standard._String_if string$122 = (new JP.go.ipa.oz.lib.standard._String_cl(";\n"));
    
// 258
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$260;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        append$val$260 = buf.append (string$122);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$260 = buf.append (string$122);
    }
// 259
    JP.go.ipa.oz.lib.standard._String_if asString$val$261;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        asString$val$261 = buf.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$261 = buf.asString ();
    }
// 259
    int length$val$262;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        length$val$262 = buf.length ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      length$val$262 = buf.length ();
    }
// 259
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file)) {
      try {
        file.write (asString$val$261, 0, length$val$262);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      file.write (asString$val$261, 0, length$val$262);
    }
  }
  
  public void run () throws Exception  {
    checkSecureInvocation ();
// 104
    JP.go.ipa.oz.lib.standard._String_if cid = extractClassID ();
// 105
    if (cid == null) {{
// 106
        sendResult ((new JP.go.ipa.oz.lib.standard._String_cl("cannot find class ID")));
// 107
        return;
      }
    }
// 110
    exec (cid);
  }
  
  JP.go.ipa.oz.lib.standard._String_if extractClassID () throws Exception  {
// 117
    JP.go.ipa.oz.lib.standard._String_if cid = null;
// 118
    JP.go.ipa.oz.lib.standard._String_if string$123 = (new JP.go.ipa.oz.lib.standard._String_cl("class"));
    
// 118
    JP.go.ipa.oz.lang._Root_if getValue$val$263;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        getValue$val$263 = html.getValue (string$123);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getValue$val$263 = html.getValue (string$123);
    }
// 118
    cid = (JP.go.ipa.oz.lib.standard._String_if) (getValue$val$263);
// 120
    JP.go.ipa.oz.lib.standard._String_if string$124 = (new JP.go.ipa.oz.lib.standard._String_cl("."));
    
// 120
    boolean startsWith$val$264;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cid)) {
      try {
        startsWith$val$264 = cid.startsWith (string$124);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      startsWith$val$264 = cid.startsWith (string$124);
    }
// 120
    if (startsWith$val$264) {
// 121
      JP.go.ipa.oz.lib.standard._String_if string$125 = (new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz"));
      
// 121
      JP.go.ipa.oz.lib.standard._String_if concat$val$265;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$125)) {
        try {
          concat$val$265 = string$125.concat (cid);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        concat$val$265 = string$125.concat (cid);
      }
// 123
      return concat$val$265;
    }
// 123
    return cid;
  }
  
  public RemoteExecuteThread_cl () throws Exception { super (); }
  
}

