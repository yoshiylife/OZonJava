package JP.go.ipa.oz.user.misc.cell;

public class Stoppable_cl extends JP.go.ipa.oz.system.OzCell implements JP.go.ipa.oz.user.misc.cell.Stoppable_if {
  static final boolean _global_ = true;
  
  public void stop () throws Exception  {
    checkSecureInvocation ();
  }
  
  public Stoppable_cl () { super ("JP.go.ipa.oz.user.misc.cell.Stoppable_pcl"); }
  
  public Stoppable_cl (String proxy_id) { super (proxy_id); }
  
}

