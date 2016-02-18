package JP.go.ipa.oz.user.ide;

public class DirectoryFilter_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.ide.DirectoryFilter_if {
  
  public Object _new_create () throws Exception  {
    return this;
  }
  
  public boolean accept (JP.go.ipa.oz.lib.standard._File_if dir, JP.go.ipa.oz.lib.standard._String_if name) throws Exception  {
    checkSecureInvocation ();
// 36
    JP.go.ipa.oz.lib.standard._File_if dir$1 = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (dir, name);
// 37
    boolean isDirectory$val$18;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dir$1)) {
      try {
        isDirectory$val$18 = dir$1.isDirectory ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isDirectory$val$18 = dir$1.isDirectory ();
    }
// 37
    return isDirectory$val$18;
  }
  
  public DirectoryFilter_cl () throws Exception { super (); }
  
}

