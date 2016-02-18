package JP.go.ipa.oz.user.inter.wwps;

public class DownloadThread_cl extends JP.go.ipa.oz.user.inter.wwps.WWPSExecuteThread_cl implements JP.go.ipa.oz.user.inter.wwps.DownloadThread_if {
  JP.go.ipa.oz.lib.standard._String_if class_id;
  JP.go.ipa.oz.user.inter.wwps.CompilerServer_if compiler_server;
  
  public Object _new_create (JP.go.ipa.oz.user.inter.cgi.OzCGI_if c, JP.go.ipa.oz.user.inter.cgi.HTMLData_if h, JP.go.ipa.oz.user.inter.wwps.CompilerServer_if cs) throws Exception  {
// 303
    super._new_create (c, h);
// 304
    compiler_server = cs;
    return this;
  }
  
  public void run () throws Exception  {
    checkSecureInvocation ();
// 253
    extractClassID ();
// 257
    try {
// 258
      sendFile ();
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_2) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_2 = _exception_2.getOzException ();
      if (_oz_exception_2 instanceof JP.go.ipa.oz.lib.standard._FileNotFoundException_if) {
        JP.go.ipa.oz.lib.standard._FileNotFoundException_if e = (JP.go.ipa.oz.lib.standard._FileNotFoundException_if) _oz_exception_2;
// 260
        sendResult ((new JP.go.ipa.oz.lib.standard._String_cl("not found class file.")));
      } else throw _exception_2;
    }
  }
  
  void extractClassID () throws Exception  {
// 268
    JP.go.ipa.oz.lib.standard._String_if string$30 = (new JP.go.ipa.oz.lib.standard._String_cl("class"));
    
// 268
    JP.go.ipa.oz.lang._Root_if getValue$val$94;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        getValue$val$94 = html.getValue (string$30);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getValue$val$94 = html.getValue (string$30);
    }
// 268
    class_id = (JP.go.ipa.oz.lib.standard._String_if) (getValue$val$94);
  }
  
  void sendFile () throws Exception  {
// 275
    int lastIndexOf$val$95;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) class_id)) {
      try {
        lastIndexOf$val$95 = class_id.lastIndexOf ('.');
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lastIndexOf$val$95 = class_id.lastIndexOf ('.');
    }
// 275
    int dot = lastIndexOf$val$95;
// 276
    JP.go.ipa.oz.lib.standard._String_if substring$val$96;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) class_id)) {
      try {
        substring$val$96 = class_id.substring (dot + 1);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      substring$val$96 = class_id.substring (dot + 1);
    }
// 276
    JP.go.ipa.oz.lib.standard._String_if string$31 = (new JP.go.ipa.oz.lib.standard._String_cl(".class"));
    
// 276
    JP.go.ipa.oz.lib.standard._String_if concat$val$97;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) substring$val$96)) {
      try {
        concat$val$97 = substring$val$96.concat (string$31);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$97 = substring$val$96.concat (string$31);
    }
// 276
    JP.go.ipa.oz.lib.standard._String_if file = concat$val$97;
// 277
    JP.go.ipa.oz.lib.standard._ClassProperty_if cp = (JP.go.ipa.oz.lib.standard._ClassProperty_cl) (new JP.go.ipa.oz.lib.standard._ClassProperty_cl ())._new_create (class_id, file);
// 279
    JP.go.ipa.oz.lib.standard._DataInputStream_if in = null;
// 280
    try {
// 281
      JP.go.ipa.oz.lib.standard._InputStream_if getInputStream$val$98;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cp)) {
        try {
          getInputStream$val$98 = cp.getInputStream ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getInputStream$val$98 = cp.getInputStream ();
      }
// 281
      in = (JP.go.ipa.oz.lib.standard._DataInputStream_cl) (new JP.go.ipa.oz.lib.standard._DataInputStream_cl ())._new_breed (getInputStream$val$98);
// 282
      int size = 0;
// 284
      long length$val$99;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cp)) {
        try {
          length$val$99 = cp.length ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        length$val$99 = cp.length ();
      }
// 284
      size = (int) (length$val$99);
// 285
      sendFile (in, file, size);
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_3) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_3 = _exception_3.getOzException ();
      if (_oz_exception_3 instanceof JP.go.ipa.oz.lib.standard._IOException_if) {
        JP.go.ipa.oz.lib.standard._IOException_if e = (JP.go.ipa.oz.lib.standard._IOException_if) _oz_exception_3;
// 287
        sendResult ((new JP.go.ipa.oz.lib.standard._String_cl("not found class file")));
// 288
        return;
      } else throw _exception_3;
    } finally {
// 290
      if (in != null) {
// 291
        in.close ();
      }
    }
  }
  
  public DownloadThread_cl () throws Exception { super (); }
  
}

