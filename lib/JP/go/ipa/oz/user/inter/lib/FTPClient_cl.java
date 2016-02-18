package JP.go.ipa.oz.user.inter.lib;

public class FTPClient_cl extends JP.go.ipa.oz.user.inter.lib.FTP_cl implements JP.go.ipa.oz.user.inter.lib.FTPClient_if {
  
  public Object _new_create () throws Exception  {
// 14
    super._new_create ();
    return this;
  }
  
  JP.go.ipa.oz.lib.standard._Set_if get_pathnames_remote (JP.go.ipa.oz.lib.standard._String_if paths) throws Exception  {
// 146
    JP.go.ipa.oz.lib.standard._Set_if pathnames = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create ();
// 148
    int lastIndexOf$val$35;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) paths)) {
      try {
        lastIndexOf$val$35 = paths.lastIndexOf ('/');
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lastIndexOf$val$35 = paths.lastIndexOf ('/');
    }
// 148
    int slash = lastIndexOf$val$35;
// 149
    JP.go.ipa.oz.lib.standard._String_if dir = null;
// 150
    if (slash == -1) {
// 151
      dir = (new JP.go.ipa.oz.lib.standard._String_cl("."));
    } else {
// 153
      JP.go.ipa.oz.lib.standard._String_if substring$val$36;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) paths)) {
        try {
          substring$val$36 = paths.substring (0, slash);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        substring$val$36 = paths.substring (0, slash);
      }
// 153
      dir = substring$val$36;
    }
// 155
    if (list (dir) == null) {
// 155
      return null;
    }
// 157
    JP.go.ipa.oz.lib.standard._StringReader_if sr = (JP.go.ipa.oz.lib.standard._StringReader_cl) (new JP.go.ipa.oz.lib.standard._StringReader_cl ())._new_breed (getRecvData ());
// 158
    JP.go.ipa.oz.lib.standard._BufferedReader_if br = (JP.go.ipa.oz.lib.standard._BufferedReader_cl) (new JP.go.ipa.oz.lib.standard._BufferedReader_cl ())._new_breed (sr);
// 159
    JP.go.ipa.oz.user.inter.lib.WildcardFilter_if filter = (JP.go.ipa.oz.user.inter.lib.WildcardFilter_cl) (new JP.go.ipa.oz.user.inter.lib.WildcardFilter_cl ())._new_create (paths);
// 160
    JP.go.ipa.oz.lib.standard._Set_if result = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create ();
// 162
    while (true) {
      /* body */ _loop_1: {
// 163
        JP.go.ipa.oz.lib.standard._String_if readLine$val$37;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) br)) {
          try {
            readLine$val$37 = br.readLine ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          readLine$val$37 = br.readLine ();
        }
// 163
        JP.go.ipa.oz.lib.standard._String_if line = readLine$val$37;
// 164
        if (line == null) {
// 165
          break;
        }
// 167
        boolean accept$val$38;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) filter)) {
          try {
            accept$val$38 = filter.accept (null, line);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          accept$val$38 = filter.accept (null, line);
        }
// 167
        if (accept$val$38) {
// 168
          JP.go.ipa.oz.lib.standard._Set_if add$val$39;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) result)) {
            try {
              add$val$39 = result.add (line);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            add$val$39 = result.add (line);
          }
        }
      }
    }
// 171
    return result;
  }
  
  public boolean conn (JP.go.ipa.oz.lib.standard._String_if host) throws Exception  {
    checkSecureInvocation ();
// 35
    return isOk (connect (host));
  }
  
  public boolean conn (JP.go.ipa.oz.lib.standard._String_if host, int port) throws Exception  {
    checkSecureInvocation ();
// 25
    return isOk (connect (host, port));
  }
  
  public JP.go.ipa.oz.lib.standard._String_if pwd () throws Exception  {
    checkSecureInvocation ();
// 229
    if (isOk (pwd ())) {
// 229
      return null;
    }
// 231
    JP.go.ipa.oz.lib.standard._String_if msg = getResponse ();
// 232
    JP.go.ipa.oz.lib.standard._String_if string$4 = (new JP.go.ipa.oz.lib.standard._String_cl("\""));
    
// 232
    int indexOf$val$40;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) msg)) {
      try {
        indexOf$val$40 = msg.indexOf (string$4);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      indexOf$val$40 = msg.indexOf (string$4);
    }
// 232
    int idx = indexOf$val$40;
// 233
    JP.go.ipa.oz.lib.standard._String_if string$5 = (new JP.go.ipa.oz.lib.standard._String_cl("\""));
    
// 233
    int indexOf$val$41;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) msg)) {
      try {
        indexOf$val$41 = msg.indexOf (string$5, idx + 1);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      indexOf$val$41 = msg.indexOf (string$5, idx + 1);
    }
// 233
    JP.go.ipa.oz.lib.standard._String_if substring$val$42;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) msg)) {
      try {
        substring$val$42 = msg.substring (idx + 1, indexOf$val$41);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      substring$val$42 = msg.substring (idx + 1, indexOf$val$41);
    }
// 233
    return substring$val$42;
  }
  
  public boolean binary () throws Exception  {
    checkSecureInvocation ();
// 311
    return isOk (type ((new JP.go.ipa.oz.lib.standard._String_cl("I"))));
  }
  
  public boolean mkdir (JP.go.ipa.oz.lib.standard._String_if pathname) throws Exception  {
    checkSecureInvocation ();
// 210
    return isOk (mkd (pathname));
  }
  
  public JP.go.ipa.oz.lib.standard._String_if dir (JP.go.ipa.oz.lib.standard._String_if path) throws Exception  {
    checkSecureInvocation ();
// 277
    if (!isOk (super.list (path))) {
// 279
      return null;
    }
// 279
    return getRecvData ();
  }
  
  public JP.go.ipa.oz.lib.standard._String_if dir () throws Exception  {
    checkSecureInvocation ();
// 265
    if (!isOk (super.list ())) {
// 267
      return null;
    }
// 267
    return getRecvData ();
  }
  
  JP.go.ipa.oz.lib.standard._Array_if get_pathnames_local (JP.go.ipa.oz.lib.standard._String_if paths) throws Exception  {
// 100
    JP.go.ipa.oz.lib.standard._Set_if pathnames = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create ();
// 102
    int lastIndexOf$val$43;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) paths)) {
      try {
        lastIndexOf$val$43 = paths.lastIndexOf ('/');
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lastIndexOf$val$43 = paths.lastIndexOf ('/');
    }
// 102
    int slash = lastIndexOf$val$43;
// 103
    JP.go.ipa.oz.lib.standard._File_if dir = null;
// 104
    if (slash == -1) {
// 105
      dir = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl(".")));
    } else {
// 107
      JP.go.ipa.oz.lib.standard._String_if substring$val$44;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) paths)) {
        try {
          substring$val$44 = paths.substring (0, slash);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        substring$val$44 = paths.substring (0, slash);
      }
// 107
      dir = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (substring$val$44);
    }
// 109
    JP.go.ipa.oz.user.inter.lib.WildcardFilter_if filter = (JP.go.ipa.oz.user.inter.lib.WildcardFilter_cl) (new JP.go.ipa.oz.user.inter.lib.WildcardFilter_cl ())._new_create (paths);
// 111
    return dir.list (filter);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if list (JP.go.ipa.oz.lib.standard._String_if path) throws Exception  {
    checkSecureInvocation ();
// 254
    if (!isOk (super.nlst (path))) {
// 256
      return null;
    }
// 256
    return getRecvData ();
  }
  
  public JP.go.ipa.oz.lib.standard._String_if list () throws Exception  {
    checkSecureInvocation ();
// 242
    if (!isOk (super.nlst ())) {
// 244
      return null;
    }
// 244
    return getRecvData ();
  }
  
  public boolean ascii () throws Exception  {
    checkSecureInvocation ();
// 320
    return isOk (type ((new JP.go.ipa.oz.lib.standard._String_cl("A"))));
  }
  
  public boolean cd (JP.go.ipa.oz.lib.standard._String_if pathname) throws Exception  {
    checkSecureInvocation ();
// 220
    return isOk (cwd (pathname));
  }
  
  public boolean disconnect () throws Exception  {
    checkSecureInvocation ();
// 288
    return isOk (quit ());
  }
  
  public boolean userAndPassword (JP.go.ipa.oz.lib.standard._String_if user, JP.go.ipa.oz.lib.standard._String_if pass) throws Exception  {
    checkSecureInvocation ();
// 299
    if (!isOk (user (user))) {
// 302
      return false;
    }
// 302
    return isOk (pass (pass));
  }
  
  public boolean get (JP.go.ipa.oz.lib.standard._String_if remote_file, JP.go.ipa.oz.lib.standard._String_if source_file) throws Exception  {
    checkSecureInvocation ();
// 182
    JP.go.ipa.oz.lib.standard._System_if sys = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 184
    try {
// 185
      JP.go.ipa.oz.lib.standard._String_if string$6 = (new JP.go.ipa.oz.lib.standard._String_cl("get "));
      
// 185
      JP.go.ipa.oz.lib.standard._String_if concat$val$45;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$6)) {
        try {
          concat$val$45 = string$6.concat (remote_file);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        concat$val$45 = string$6.concat (remote_file);
      }
// 185
      JP.go.ipa.oz.lib.standard._String_if string$7 = (new JP.go.ipa.oz.lib.standard._String_cl(" as "));
      
// 185
      JP.go.ipa.oz.lib.standard._String_if concat$val$46;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$45)) {
        try {
          concat$val$46 = concat$val$45.concat (string$7);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        concat$val$46 = concat$val$45.concat (string$7);
      }
// 185
      JP.go.ipa.oz.lib.standard._String_if concat$val$47;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$46)) {
        try {
          concat$val$47 = concat$val$46.concat (source_file);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        concat$val$47 = concat$val$46.concat (source_file);
      }
// 185
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
        try {
          sys.println (concat$val$47);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        sys.println (concat$val$47);
      }
// 187
      JP.go.ipa.oz.lib.standard._File_if f = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (source_file);
// 188
      JP.go.ipa.oz.lib.standard._FileOutputStream_if out = (JP.go.ipa.oz.lib.standard._FileOutputStream_cl) (new JP.go.ipa.oz.lib.standard._FileOutputStream_cl ())._new_breed (f);
// 190
      if (!isOk (retr (remote_file, out))) {
// 191
        return false;
      }
// 193
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) out)) {
        try {
          out.close ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        out.close ();
      }
// 194
      return true;
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_1) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_1 = _exception_1.getOzException ();
      if (_oz_exception_1 instanceof JP.go.ipa.oz.lib.standard._IOException_if) {
        JP.go.ipa.oz.lib.standard._IOException_if e = (JP.go.ipa.oz.lib.standard._IOException_if) _oz_exception_1;
// 197
        JP.go.ipa.oz.lib.standard._String_if string$8 = (new JP.go.ipa.oz.lib.standard._String_cl("cannot open file: "));
        
// 197
        JP.go.ipa.oz.lib.standard._String_if concat$val$48;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$8)) {
          try {
            concat$val$48 = string$8.concat (source_file);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          concat$val$48 = string$8.concat (source_file);
        }
// 197
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
          try {
            sys.println (concat$val$48);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          sys.println (concat$val$48);
        }
// 199
        return false;
      } else throw _exception_1;
    }
  }
  
  public boolean get (JP.go.ipa.oz.lib.standard._String_if files) throws Exception  {
    checkSecureInvocation ();
// 118
    int indexOf$val$49;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) files)) {
      try {
        indexOf$val$49 = files.indexOf ('*');
      } finally {
        changeRunningToGreen ();
      }
    } else {
      indexOf$val$49 = files.indexOf ('*');
    }
// 118
    if (indexOf$val$49 == -1) {{
// 120
        return get (files, files);
      }
    }
// 123
    JP.go.ipa.oz.lib.standard._Set_if paths_array = get_pathnames_remote (files);
// 124
    if (paths_array == null) {
// 124
      return false;
    }
// 125
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$50;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) paths_array)) {
      try {
        iterator$val$50 = paths_array.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$50 = paths_array.iterator ();
    }
// 125
    JP.go.ipa.oz.lib.standard._Iterator_if paths = iterator$val$50;
// 126
    boolean status = true;
// 128
    while (true) {
// 128
      boolean hasMoreElements$val$51;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) paths)) {
        try {
          hasMoreElements$val$51 = paths.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$51 = paths.hasMoreElements ();
      }
      if (!(hasMoreElements$val$51)) break;
      
      /* body */ _loop_1: {
// 129
        JP.go.ipa.oz.lib.standard._String_if path = null;
// 130
        JP.go.ipa.oz.lang._Root_if nextElement$val$52;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) paths)) {
          try {
            nextElement$val$52 = paths.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$52 = paths.nextElement ();
        }
// 130
        path = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$52);
// 132
        if (!get (path, path)) {
// 133
          status = false;
        }
      }
    }
// 136
    return status;
  }
  
  public boolean put (JP.go.ipa.oz.lib.standard._String_if source_file, JP.go.ipa.oz.lib.standard._String_if remote_file) throws Exception  {
    checkSecureInvocation ();
// 74
    JP.go.ipa.oz.lib.standard._System_if sys = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 76
    try {
// 77
      JP.go.ipa.oz.lib.standard._String_if string$9 = (new JP.go.ipa.oz.lib.standard._String_cl("put "));
      
// 77
      JP.go.ipa.oz.lib.standard._String_if concat$val$53;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$9)) {
        try {
          concat$val$53 = string$9.concat (source_file);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        concat$val$53 = string$9.concat (source_file);
      }
// 77
      JP.go.ipa.oz.lib.standard._String_if string$10 = (new JP.go.ipa.oz.lib.standard._String_cl(" as "));
      
// 77
      JP.go.ipa.oz.lib.standard._String_if concat$val$54;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$53)) {
        try {
          concat$val$54 = concat$val$53.concat (string$10);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        concat$val$54 = concat$val$53.concat (string$10);
      }
// 77
      JP.go.ipa.oz.lib.standard._String_if concat$val$55;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$54)) {
        try {
          concat$val$55 = concat$val$54.concat (remote_file);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        concat$val$55 = concat$val$54.concat (remote_file);
      }
// 77
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
        try {
          sys.println (concat$val$55);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        sys.println (concat$val$55);
      }
// 79
      JP.go.ipa.oz.lib.standard._File_if f = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (source_file);
// 80
      JP.go.ipa.oz.lib.standard._FileInputStream_if in = (JP.go.ipa.oz.lib.standard._FileInputStream_cl) (new JP.go.ipa.oz.lib.standard._FileInputStream_cl ())._new_breed (f);
// 82
      JP.go.ipa.oz.lib.standard._String_if status = stor (remote_file, in);
// 83
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) in)) {
        try {
          in.close ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        in.close ();
      }
// 85
      return isOk (status);
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_2) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_2 = _exception_2.getOzException ();
      if (_oz_exception_2 instanceof JP.go.ipa.oz.lib.standard._IOException_if) {
        JP.go.ipa.oz.lib.standard._IOException_if e = (JP.go.ipa.oz.lib.standard._IOException_if) _oz_exception_2;
// 87
        JP.go.ipa.oz.lib.standard._String_if string$11 = (new JP.go.ipa.oz.lib.standard._String_cl("cannot open file: "));
        
// 87
        JP.go.ipa.oz.lib.standard._String_if concat$val$56;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$11)) {
          try {
            concat$val$56 = string$11.concat (source_file);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          concat$val$56 = string$11.concat (source_file);
        }
// 87
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
          try {
            sys.println (concat$val$56);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          sys.println (concat$val$56);
        }
// 89
        return false;
      } else throw _exception_2;
    }
  }
  
  public boolean put (JP.go.ipa.oz.lib.standard._String_if files) throws Exception  {
    checkSecureInvocation ();
// 45
    int indexOf$val$57;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) files)) {
      try {
        indexOf$val$57 = files.indexOf ('*');
      } finally {
        changeRunningToGreen ();
      }
    } else {
      indexOf$val$57 = files.indexOf ('*');
    }
// 45
    if (indexOf$val$57 == -1) {{
// 48
        return put (files, files);
      }
    }
// 51
    JP.go.ipa.oz.lib.standard._Array_if paths_array = get_pathnames_local (files);
// 52
    if (paths_array == null) {
// 52
      return false;
    }
// 53
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$58;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) paths_array)) {
      try {
        iterator$val$58 = paths_array.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$58 = paths_array.iterator ();
    }
// 53
    JP.go.ipa.oz.lib.standard._Iterator_if paths = iterator$val$58;
// 54
    boolean status = true;
// 55
    while (true) {
// 55
      boolean hasMoreElements$val$59;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) paths)) {
        try {
          hasMoreElements$val$59 = paths.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$59 = paths.hasMoreElements ();
      }
      if (!(hasMoreElements$val$59)) break;
      
      /* body */ _loop_1: {
// 56
        JP.go.ipa.oz.lib.standard._String_if path = null;
// 57
        JP.go.ipa.oz.lang._Root_if nextElement$val$60;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) paths)) {
          try {
            nextElement$val$60 = paths.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$60 = paths.nextElement ();
        }
// 57
        path = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$60);
// 59
        if (!put (path, path)) {
// 60
          status = false;
        }
      }
    }
// 63
    return status;
  }
  
  public FTPClient_cl () throws Exception { super (); }
  
}

