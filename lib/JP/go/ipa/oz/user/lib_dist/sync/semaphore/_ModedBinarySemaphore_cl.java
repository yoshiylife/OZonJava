package JP.go.ipa.oz.user.lib_dist.sync.semaphore;

public class _ModedBinarySemaphore_cl extends JP.go.ipa.oz.user.lib_dist.sync.semaphore._BinarySemaphore_cl implements JP.go.ipa.oz.user.lib_dist.sync.semaphore._ModedBinarySemaphore_if {
  
  public Object _new_create () throws Exception  {
// 22
    super._new_create ();
    return this;
  }
  
  public void exclusiveP () throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 16
      P (true);
    } finally {
      leave ();
    }
  }
  
  public void sharedP () throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 19
      P (false);
    } finally {
      leave ();
    }
  }
  
  public _ModedBinarySemaphore_cl () throws Exception { super (); }
  
}

