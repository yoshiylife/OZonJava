package JP.go.ipa.oz.user.cda;

public class _CDAdebug_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.cda._CDAdebug_if {
  boolean on;
  JP.go.ipa.oz.lib.standard._System_if system;
  
  public Object _new_create () throws Exception  {
// 8
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 9
    on = false;
    return this;
  }
  
  public void println (JP.go.ipa.oz.lib.standard._String_if s, long l) throws Exception  {
    checkSecureInvocation ();
// 32
    if (on) {{
// 33
        JP.go.ipa.oz.lib.standard._Long_if L = (JP.go.ipa.oz.lib.standard._Long_cl) (new JP.go.ipa.oz.lib.standard._Long_cl ())._new_breed (l);
// 34
        JP.go.ipa.oz.lib.standard._String_if string$0 = (new JP.go.ipa.oz.lib.standard._String_cl(" "));
        
// 34
        JP.go.ipa.oz.lib.standard._String_if concat$val$0;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s)) {
          try {
            concat$val$0 = s.concat (string$0);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          concat$val$0 = s.concat (string$0);
        }
// 34
        JP.go.ipa.oz.lib.standard._String_if mes = concat$val$0;
// 34
        JP.go.ipa.oz.lib.standard._String_if asString$val$1;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) L)) {
          try {
            asString$val$1 = L.asString ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          asString$val$1 = L.asString ();
        }
// 34
        JP.go.ipa.oz.lib.standard._String_if concat$val$2;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) mes)) {
          try {
            concat$val$2 = mes.concat (asString$val$1);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          concat$val$2 = mes.concat (asString$val$1);
        }
// 34
        mes = concat$val$2;
// 35
        if (on) {
// 35
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
            try {
              system.println (mes);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            system.println (mes);
          }
        }
      }
    }
  }
  
  public void println (JP.go.ipa.oz.lib.standard._String_if s, int i) throws Exception  {
    checkSecureInvocation ();
// 24
    if (on) {{
// 25
        JP.go.ipa.oz.lib.standard._Integer_if I = (JP.go.ipa.oz.lib.standard._Integer_cl) (new JP.go.ipa.oz.lib.standard._Integer_cl ())._new_breed (i);
// 26
        JP.go.ipa.oz.lib.standard._String_if string$1 = (new JP.go.ipa.oz.lib.standard._String_cl(" "));
        
// 26
        JP.go.ipa.oz.lib.standard._String_if concat$val$3;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s)) {
          try {
            concat$val$3 = s.concat (string$1);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          concat$val$3 = s.concat (string$1);
        }
// 26
        JP.go.ipa.oz.lib.standard._String_if mes = concat$val$3;
// 26
        JP.go.ipa.oz.lib.standard._String_if asString$val$4;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) I)) {
          try {
            asString$val$4 = I.asString ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          asString$val$4 = I.asString ();
        }
// 26
        JP.go.ipa.oz.lib.standard._String_if concat$val$5;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) mes)) {
          try {
            concat$val$5 = mes.concat (asString$val$4);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          concat$val$5 = mes.concat (asString$val$4);
        }
// 26
        mes = concat$val$5;
// 27
        if (on) {
// 27
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
            try {
              system.println (mes);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            system.println (mes);
          }
        }
      }
    }
  }
  
  public void println (JP.go.ipa.oz.lib.standard._String_if s, JP.go.ipa.oz.lib.standard._String_if ss) throws Exception  {
    checkSecureInvocation ();
// 17
    if (on) {{
// 18
        JP.go.ipa.oz.lib.standard._String_if string$2 = (new JP.go.ipa.oz.lib.standard._String_cl(" "));
        
// 18
        JP.go.ipa.oz.lib.standard._String_if concat$val$6;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s)) {
          try {
            concat$val$6 = s.concat (string$2);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          concat$val$6 = s.concat (string$2);
        }
// 18
        JP.go.ipa.oz.lib.standard._String_if mes = concat$val$6;
// 18
        JP.go.ipa.oz.lib.standard._String_if concat$val$7;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) mes)) {
          try {
            concat$val$7 = mes.concat (ss);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          concat$val$7 = mes.concat (ss);
        }
// 18
        mes = concat$val$7;
// 19
        if (on) {
// 19
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
            try {
              system.println (mes);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            system.println (mes);
          }
        }
      }
    }
  }
  
  public void println (JP.go.ipa.oz.lib.standard._String_if s) throws Exception  {
    checkSecureInvocation ();
// 13
    if (on) {
// 13
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (s);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (s);
      }
    }
  }
  
  public _CDAdebug_cl () throws Exception { super (); }
  
}

