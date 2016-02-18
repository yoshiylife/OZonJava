package JP.go.ipa.oz.user.ide;

final public class CIRecordTokenizer_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.ide.CIRecordTokenizer_if {
  static final boolean _final_ = true;
  JP.go.ipa.oz.lib.standard._String_if record;
  char _final_LIST_END;
  int length;
  int current;
  char _final_LIST_BEGIN;
  JP.go.ipa.oz.lib.standard._String_if delimiters;
  
  public Object _new_newCIRecordTokenizer (JP.go.ipa.oz.lib.standard._String_if rec) throws Exception  {
// 26
    ((JP.go.ipa.oz.user.ide.CIRecordTokenizer_cl)this).record = rec;
// 27
    ((JP.go.ipa.oz.user.ide.CIRecordTokenizer_cl)this).delimiters = (new JP.go.ipa.oz.lib.standard._String_cl("\t\n\r ,"));
// 28
    ((JP.go.ipa.oz.user.ide.CIRecordTokenizer_cl)this).current = 0;
// 29
    int length$val$3;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rec)) {
      try {
        length$val$3 = rec.length ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      length$val$3 = rec.length ();
    }
// 29
    ((JP.go.ipa.oz.user.ide.CIRecordTokenizer_cl)this).length = length$val$3;
// 30
    _final_LIST_BEGIN = '(';
// 31
    _final_LIST_END = ')';
    return this;
  }
  
  void skipDelimiters () throws Exception  {
// 149
    while (true) {
      boolean bool$val$0;
      
      bool$val$0 = (current < length);
      if (bool$val$0) {
// 150
        char charAt$val$4;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) record)) {
          try {
            charAt$val$4 = record.charAt (current);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          charAt$val$4 = record.charAt (current);
        }
// 150
        int indexOf$val$5;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) delimiters)) {
          try {
            indexOf$val$5 = delimiters.indexOf (charAt$val$4);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          indexOf$val$5 = delimiters.indexOf (charAt$val$4);
        }
        bool$val$0 = indexOf$val$5 != -1;
      }
      if (!(bool$val$0)) break;
      
      /* body */ _loop_1: {
// 151
        current++;
      }
    }
  }
  
  public JP.go.ipa.oz.lib.standard._String_if nextList () throws Exception  {
    checkSecureInvocation ();
// 71
    int start = 0;
// 72
    int nest = 0;
// 73
    JP.go.ipa.oz.lib.standard._String_if rv = null;
// 75
    skipDelimiters ();
// 77
    char charAt$val$6;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) record)) {
      try {
        charAt$val$6 = record.charAt (current);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      charAt$val$6 = record.charAt (current);
    }
// 77
    if (charAt$val$6 == _final_LIST_BEGIN) {{
// 78
        current++;
      }
    } else {{
// 80
        JP.go.ipa.oz.user.ide.CIException_if ex = null;
// 81
        ex = (JP.go.ipa.oz.user.ide.CIException_cl) (new JP.go.ipa.oz.user.ide.CIException_cl ())._new_newCIException ((new JP.go.ipa.oz.lib.standard._String_cl("unexpected CID list begin character")));
// 82
        throw new JP.go.ipa.oz.lang.OzException (ex);
      }
    }
// 86
    start = current;
// 87
    nest = 0;
// 88
    while (true) {
      boolean bool$val$1;
      
      bool$val$1 = (current < length);
      if (bool$val$1) {
        boolean bool$val$2;
        
        bool$val$2 = nest > 0;
        if (!bool$val$2) {
// 89
          char charAt$val$7;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) record)) {
            try {
              charAt$val$7 = record.charAt (current);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            charAt$val$7 = record.charAt (current);
          }
          bool$val$2 = (charAt$val$7 != _final_LIST_END);
        }
        bool$val$1 = (bool$val$2);
      }
      if (!(bool$val$1)) break;
      
      /* body */ _loop_1: {
// 90
        char charAt$val$8;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) record)) {
          try {
            charAt$val$8 = record.charAt (current);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          charAt$val$8 = record.charAt (current);
        }
// 90
        if (charAt$val$8 == _final_LIST_BEGIN) {{
// 91
            nest++;
          }
        }
// 93
        char charAt$val$9;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) record)) {
          try {
            charAt$val$9 = record.charAt (current);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          charAt$val$9 = record.charAt (current);
        }
// 93
        if (charAt$val$9 == _final_LIST_END) {{
// 94
            nest--;
          }
        }
// 96
        current++;
      }
    }
// 105
    JP.go.ipa.oz.lib.standard._String_if substring$val$10;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) record)) {
      try {
        substring$val$10 = record.substring (start, current);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      substring$val$10 = record.substring (start, current);
    }
// 105
    rv = substring$val$10;
// 106
    char charAt$val$11;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) record)) {
      try {
        charAt$val$11 = record.charAt (current);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      charAt$val$11 = record.charAt (current);
    }
// 106
    if (charAt$val$11 == _final_LIST_END) {{
// 107
        current++;
      }
    }
// 110
    return rv;
  }
  
  public boolean hasMoreTokens () throws Exception  {
    checkSecureInvocation ();
// 40
    skipDelimiters ();
// 41
    return (current < length);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if nextToken () throws Exception  {
    checkSecureInvocation ();
// 48
    int start = 0;
// 50
    skipDelimiters ();
// 52
    if (length <= current) {{
// 53
        JP.go.ipa.oz.user.ide.CIException_if ex = null;
// 54
        ex = (JP.go.ipa.oz.user.ide.CIException_cl) (new JP.go.ipa.oz.user.ide.CIException_cl ())._new_newCIException ((new JP.go.ipa.oz.lib.standard._String_cl("no more tokens")));
// 55
        throw new JP.go.ipa.oz.lang.OzException (ex);
      }
    }
// 58
    start = current;
// 59
    while (true) {
      boolean bool$val$3;
      
      bool$val$3 = (current < length);
      if (bool$val$3) {
// 60
        char charAt$val$12;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) record)) {
          try {
            charAt$val$12 = record.charAt (current);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          charAt$val$12 = record.charAt (current);
        }
// 60
        int indexOf$val$13;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) delimiters)) {
          try {
            indexOf$val$13 = delimiters.indexOf (charAt$val$12);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          indexOf$val$13 = delimiters.indexOf (charAt$val$12);
        }
        bool$val$3 = (indexOf$val$13 == -1);
      }
      if (!(bool$val$3)) break;
      
      /* body */ _loop_1: {
// 61
        current++;
      }
    }
// 64
    JP.go.ipa.oz.lib.standard._String_if substring$val$14;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) record)) {
      try {
        substring$val$14 = record.substring (start, current);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      substring$val$14 = record.substring (start, current);
    }
// 64
    return substring$val$14;
  }
  
  public int countTokens () throws Exception  {
    checkSecureInvocation ();
// 117
    int tmpCurr = current;
// 118
    int count = 0;
// 120
    while (true) {
      if (!(tmpCurr < length)) break;
      
      /* body */ _loop_1: {
// 122
        while (true) {
          boolean bool$val$4;
          
          bool$val$4 = (tmpCurr < length);
          if (bool$val$4) {
// 123
            char charAt$val$15;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) record)) {
              try {
                charAt$val$15 = record.charAt (tmpCurr);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              charAt$val$15 = record.charAt (tmpCurr);
            }
// 123
            int indexOf$val$16;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) delimiters)) {
              try {
                indexOf$val$16 = delimiters.indexOf (charAt$val$15);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              indexOf$val$16 = delimiters.indexOf (charAt$val$15);
            }
            bool$val$4 = (indexOf$val$16 != -1);
          }
          if (!(bool$val$4)) break;
          
          /* body */ _loop_2: {
// 124
            tmpCurr++;
          }
        }
// 127
        if (length <= tmpCurr) {{
// 128
            break;
          }
        }
// 132
        while (true) {
          boolean bool$val$5;
          
          bool$val$5 = (tmpCurr < length);
          if (bool$val$5) {
// 133
            char charAt$val$17;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) record)) {
              try {
                charAt$val$17 = record.charAt (tmpCurr);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              charAt$val$17 = record.charAt (tmpCurr);
            }
// 133
            int indexOf$val$18;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) delimiters)) {
              try {
                indexOf$val$18 = delimiters.indexOf (charAt$val$17);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              indexOf$val$18 = delimiters.indexOf (charAt$val$17);
            }
            bool$val$5 = (indexOf$val$18 == -1);
          }
          if (!(bool$val$5)) break;
          
          /* body */ _loop_2: {
// 134
            tmpCurr++;
          }
        }
// 137
        count++;
      }
    }
// 140
    return count;
  }
  
  public CIRecordTokenizer_cl () throws Exception { super (); }
  
}

