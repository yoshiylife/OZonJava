package JP.go.ipa.oz.user.ide;

public class OzLabel_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.ide.OzLabel_if {
  JP.go.ipa.oz.lib.standard._String_if labelName;
  JP.go.ipa.oz.lib.standard._String_if interfaceID;
  JP.go.ipa.oz.lib.standard._String_if subjectName;
  JP.go.ipa.oz.lib.standard._String_if implementationID;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._String_if sname, JP.go.ipa.oz.lib.standard._String_if lname, JP.go.ipa.oz.lib.standard._String_if iname, JP.go.ipa.oz.lib.standard._String_if cname) throws Exception  {
// 75
    subjectName = sname;
// 76
    labelName = lname;
// 77
    interfaceID = iname;
// 78
    implementationID = cname;
    return this;
  }
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._String_if lname) throws Exception  {
// 62
    subjectName = (new JP.go.ipa.oz.lib.standard._String_cl("default"));
// 63
    labelName = lname;
    return this;
  }
  
  public Object _new_create () throws Exception  {
// 54
    subjectName = (new JP.go.ipa.oz.lib.standard._String_cl("default"));
    return this;
  }
  
  public void setOzLabelName (JP.go.ipa.oz.lib.standard._String_if name) throws Exception  {
    checkSecureInvocation ();
// 97
    labelName = name;
  }
  
  public void setSubjectName (JP.go.ipa.oz.lib.standard._String_if sname) throws Exception  {
    checkSecureInvocation ();
// 145
    subjectName = sname;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getInterfaceID () throws Exception  {
    checkSecureInvocation ();
// 105
    return interfaceID;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getImplementationID () throws Exception  {
    checkSecureInvocation ();
// 121
    return implementationID;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getOzLabelName () throws Exception  {
    checkSecureInvocation ();
// 89
    return labelName;
  }
  
  public void setInterfaceID (JP.go.ipa.oz.lib.standard._String_if ifID) throws Exception  {
    checkSecureInvocation ();
// 113
    interfaceID = ifID;
  }
  
  public void setImplementationID (JP.go.ipa.oz.lib.standard._String_if implID) throws Exception  {
    checkSecureInvocation ();
// 129
    implementationID = implID;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getSubjectName () throws Exception  {
    checkSecureInvocation ();
// 137
    return subjectName;
  }
  
  public OzLabel_cl () throws Exception { super (); }
  
}

