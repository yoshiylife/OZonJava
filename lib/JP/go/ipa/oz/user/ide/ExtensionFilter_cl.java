package JP.go.ipa.oz.user.ide;

public class ExtensionFilter_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.ide.ExtensionFilter_if {
  JP.go.ipa.oz.lib.standard._String_if extension;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._String_if ex) throws Exception  {
// 26
    extension = ex;
    return this;
  }
  
  public boolean accept (JP.go.ipa.oz.lib.standard._File_if dir, JP.go.ipa.oz.lib.standard._String_if name) throws Exception  {
    checkSecureInvocation ();
// 39
    JP.go.ipa.oz.lib.standard._File_if dir$1 = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (dir, name);
// 40
    boolean endsWith$val$12;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) name)) {
      try {
        endsWith$val$12 = name.endsWith (extension);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      endsWith$val$12 = name.endsWith (extension);
    }
// 40
    if (endsWith$val$12) {
// 41
      return true;
    } else {
// 43
      return false;
    }
  }
  
  public ExtensionFilter_cl () throws Exception { super (); }
  
}

