package JP.go.ipa.oz.user.ide;

abstract public class CIType_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.ide.CIType_if {
  protected char typeCode;
  
  public abstract boolean isPrimitive () throws Exception  ;
  public abstract boolean isClass () throws Exception  ;
  public CIType_cl () throws Exception { super (); }
  
}

