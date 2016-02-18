package JP.go.ipa.oz.user.lib_dist.name;

final public class _Path_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.lib_dist.name._Path_if {
  static final boolean _final_ = true;
  JP.go.ipa.oz.lib.standard._String_if pathstring;
  
  public Object _new_breed (JP.go.ipa.oz.lib.standard._String_if s) throws Exception  {
// 6
    pathstring = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed (s);
    return this;
  }
  
  public final JP.go.ipa.oz.lib.standard._String_if asString () throws Exception  {
    checkSecureInvocation ();
// 10
    return pathstring;
  }
  
  public final boolean isequal (JP.go.ipa.oz.user.lib_dist.name._Path_if with) throws Exception  {
    checkSecureInvocation ();
// 14
    JP.go.ipa.oz.lib.standard._String_if asString$val$428;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) with)) {
      try {
        asString$val$428 = with.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$428 = with.asString ();
    }
// 14
    JP.go.ipa.oz.lib.standard._String_if withS = asString$val$428;
// 15
    boolean isequal$val$429;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pathstring)) {
      try {
        isequal$val$429 = pathstring.isequal (withS);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$429 = pathstring.isequal (withS);
    }
// 15
    return isequal$val$429;
  }
  
  public final boolean isEmpty () throws Exception  {
    checkSecureInvocation ();
// 59
    boolean tf = false;
// 59
    JP.go.ipa.oz.lib.standard._String_if string$113 = (new JP.go.ipa.oz.lib.standard._String_cl(""));
    
// 59
    boolean isequal$val$430;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pathstring)) {
      try {
        isequal$val$430 = pathstring.isequal (string$113);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$430 = pathstring.isequal (string$113);
    }
// 59
    tf = isequal$val$430;
// 60
    return tf;
  }
  
  public final JP.go.ipa.oz.user.lib_dist.name._Path_if makeLowerPath (JP.go.ipa.oz.lib.standard._String_if delimitor, JP.go.ipa.oz.lib.standard._String_if subdirname) throws Exception  {
    checkSecureInvocation ();
// 33
    JP.go.ipa.oz.lib.standard._String_if concat$val$431;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pathstring)) {
      try {
        concat$val$431 = pathstring.concat (delimitor);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$431 = pathstring.concat (delimitor);
    }
// 33
    JP.go.ipa.oz.lib.standard._String_if s = concat$val$431;
// 34
    JP.go.ipa.oz.lib.standard._String_if concat$val$432;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s)) {
      try {
        concat$val$432 = s.concat (subdirname);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$432 = s.concat (subdirname);
    }
// 34
    s = concat$val$432;
// 35
    JP.go.ipa.oz.user.lib_dist.name._Path_if p = (JP.go.ipa.oz.user.lib_dist.name._Path_cl) (new JP.go.ipa.oz.user.lib_dist.name._Path_cl ())._new_breed (s);
// 36
    return p;
  }
  
  public final JP.go.ipa.oz.user.lib_dist.name._Path_if UpperPath (JP.go.ipa.oz.lib.standard._String_if delimiter) throws Exception  {
    checkSecureInvocation ();
// 19
    int lastIndexOf$val$433;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pathstring)) {
      try {
        lastIndexOf$val$433 = pathstring.lastIndexOf (delimiter);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lastIndexOf$val$433 = pathstring.lastIndexOf (delimiter);
    }
// 19
    int delind = lastIndexOf$val$433;
// 20
    JP.go.ipa.oz.user.lib_dist.name._Path_if up = null;
// 21
    if (delind <= 0) {
// 21
      up = (JP.go.ipa.oz.user.lib_dist.name._Path_cl) (new JP.go.ipa.oz.user.lib_dist.name._Path_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("")));
    } else {
// 22
      JP.go.ipa.oz.lib.standard._String_if substring$val$434;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pathstring)) {
        try {
          substring$val$434 = pathstring.substring (0, delind);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        substring$val$434 = pathstring.substring (0, delind);
      }
// 22
      up = (JP.go.ipa.oz.user.lib_dist.name._Path_cl) (new JP.go.ipa.oz.user.lib_dist.name._Path_cl ())._new_breed (substring$val$434);
    }
// 23
    return up;
  }
  
  public final JP.go.ipa.oz.user.lib_dist.name._Path_if translateWith (JP.go.ipa.oz.user.lib_dist.name._Path_if from, JP.go.ipa.oz.user.lib_dist.name._Path_if to) throws Exception  {
    checkSecureInvocation ();
// 46
    JP.go.ipa.oz.lib.standard._String_if asString$val$435;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) from)) {
      try {
        asString$val$435 = from.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$435 = from.asString ();
    }
// 46
    JP.go.ipa.oz.lib.standard._String_if fromS = asString$val$435;
// 47
    JP.go.ipa.oz.lib.standard._String_if asString$val$436;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) to)) {
      try {
        asString$val$436 = to.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$436 = to.asString ();
    }
// 47
    JP.go.ipa.oz.lib.standard._String_if toS = asString$val$436;
// 48
    int length$val$437;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fromS)) {
      try {
        length$val$437 = fromS.length ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      length$val$437 = fromS.length ();
    }
// 48
    int fromSize = length$val$437;
// 50
    JP.go.ipa.oz.lib.standard._String_if substring$val$438;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pathstring)) {
      try {
        substring$val$438 = pathstring.substring (fromSize);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      substring$val$438 = pathstring.substring (fromSize);
    }
// 50
    JP.go.ipa.oz.lib.standard._String_if tail = substring$val$438;
// 52
    JP.go.ipa.oz.lib.standard._String_if concat$val$439;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) toS)) {
      try {
        concat$val$439 = toS.concat (tail);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$439 = toS.concat (tail);
    }
// 52
    JP.go.ipa.oz.lib.standard._String_if transed = concat$val$439;
// 54
    JP.go.ipa.oz.user.lib_dist.name._Path_if ret = (JP.go.ipa.oz.user.lib_dist.name._Path_cl) (new JP.go.ipa.oz.user.lib_dist.name._Path_cl ())._new_breed (transed);
// 55
    return ret;
  }
  
  public final JP.go.ipa.oz.lib.standard._String_if LowerName (JP.go.ipa.oz.lib.standard._String_if delimiter) throws Exception  {
    checkSecureInvocation ();
// 27
    int lastIndexOf$val$440;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pathstring)) {
      try {
        lastIndexOf$val$440 = pathstring.lastIndexOf (delimiter);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lastIndexOf$val$440 = pathstring.lastIndexOf (delimiter);
    }
// 27
    int delind = lastIndexOf$val$440;
// 28
    int length$val$441;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pathstring)) {
      try {
        length$val$441 = pathstring.length ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      length$val$441 = pathstring.length ();
    }
// 28
    int size = length$val$441;
// 29
    JP.go.ipa.oz.lib.standard._String_if substring$val$442;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pathstring)) {
      try {
        substring$val$442 = pathstring.substring (delind + 1);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      substring$val$442 = pathstring.substring (delind + 1);
    }
// 29
    return substring$val$442;
  }
  
  public _Path_cl () throws Exception { super (); }
  
}

