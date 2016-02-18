package JP.go.ipa.oz.user.cda;

public class _DeliveryFile_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.cda._DeliveryFile_if {
  JP.go.ipa.oz.lib.standard._String_if topPackageName;
  long time;
  JP.go.ipa.oz.lib.standard._ByteArray_if contents;
  int length;
  JP.go.ipa.oz.lib.standard._String_if codePath;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._String_if c, JP.go.ipa.oz.lib.standard._String_if t, int i, JP.go.ipa.oz.lib.standard._ByteArray_if con) throws Exception  {
// 23
    codePath = c;
// 24
    topPackageName = t;
// 25
    length = i;
// 26
    contents = con;
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getTopPackageName () throws Exception  {
    checkSecureInvocation ();
// 38
    return topPackageName;
  }
  
  public long time () throws Exception  {
    checkSecureInvocation ();
// 31
    return time;
  }
  
  public int getLength () throws Exception  {
    checkSecureInvocation ();
// 42
    return length;
  }
  
  public void timeStamp (long l) throws Exception  {
    checkSecureInvocation ();
// 29
    time = l;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getPackageName () throws Exception  {
    checkSecureInvocation ();
// 34
    return codePath;
  }
  
  public JP.go.ipa.oz.lib.standard._ByteArray_if getContents () throws Exception  {
    checkSecureInvocation ();
// 46
    return contents;
  }
  
  public _DeliveryFile_cl () throws Exception { super (); }
  
}

