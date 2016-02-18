package JP.go.ipa.oz.user.ide;

final public class CBMemberLabel_cl extends JP.go.ipa.oz.lib.standard._Label_cl implements JP.go.ipa.oz.user.ide.CBMemberLabel_if {
  static final boolean _final_ = true;
  JP.go.ipa.oz.lib.standard._System_if system;
  JP.go.ipa.oz.user.ide.CIMember_if targetMember;
  
  public Object _new_newCBMemberLabel (JP.go.ipa.oz.lib.standard._String_if label) throws Exception  {
// 25
    if (label == null) {{
// 26
        super._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("")));
      }
    } else {{
// 28
        super._new_newLabel (label);
      }
    }
// 30
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
    return this;
  }
  
  public void setMember (JP.go.ipa.oz.user.ide.CIMember_if m) throws Exception  {
    checkSecureInvocation ();
// 46
    targetMember = m;
  }
  
  public JP.go.ipa.oz.user.ide.CIMember_if getMember () throws Exception  {
    checkSecureInvocation ();
// 39
    return targetMember;
  }
  
  public CBMemberLabel_cl () throws Exception { super (); }
  
}

