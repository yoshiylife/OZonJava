/*
 Copyright(c) 1996-1998
 IPA, ETL, AT21, FSIABC, FXIS, InArc, MRI, NUL, SBC, Sharp, TEC, TIS

 All rights reserved.  No guarantee.
 This technology is a result of the Advanced Software  Enrichment 
 Project of Information-technology Promotion Agency, Japan (IPA).

 Permissions  to  use,  copy, modify and distribute this software
 are governed by the terms and conditions set forth in  the  file 
 COPYRIGHT, located on the top directory of this software.
 */

package JP.go.ipa.oz.lib.standard;

public class _ClassFile_cl extends _ClassProperty_cl implements _ClassFile_if {
  
  public Object _new_create (_String_if codePath) throws Exception  {

    int i = codePath.lastIndexOf ((new _String_cl(".")));

    _String_if s = codePath.substring (i+1);
    s = ((_String_cl)s).concat((new _String_cl(".class")));

    try {
      super._new_create (codePath, s);
    } catch (JP.go.ipa.oz.lang.OzException _exception_1) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_1 = _exception_1.getOzException ();
      if (_oz_exception_1 instanceof JP.go.ipa.oz.lib.standard._FileNotFoundException_if) {
        JP.go.ipa.oz.lib.standard._FileNotFoundException_if e = (JP.go.ipa.oz.lib.standard._FileNotFoundException_if) _oz_exception_1;
        JP.go.ipa.oz.lib.standard._ClassNotFoundException_if ee = (JP.go.ipa.oz.lib.standard._ClassNotFoundException_cl) (new JP.go.ipa.oz.lib.standard._ClassNotFoundException_cl ())._new_init ();
        throw new JP.go.ipa.oz.lang.OzException (ee);
      } else throw _exception_1;
    }
    return this;
  }
  
  public _ClassFile_cl () throws Exception { super (); }
  
}





