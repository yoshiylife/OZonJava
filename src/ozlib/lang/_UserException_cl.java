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

/*
 * $Id: _UserException_cl.java,v 1.4 1997/06/17 08:03:10 nito Exp $
 */
package JP.go.ipa.oz.lib.standard;

public class _UserException_cl
    extends JP.go.ipa.oz.lang._Root_cl
    implements _UserException_if
{
    static java.lang.String CN = "UserException";
    protected _String_if message;
        
    public _UserException_cl() throws Exception
    {
    }

    public java.lang.Object _new_init() throws Exception
    {
        message = new _String_cl( CN );
        return this;
    }
        
    public java.lang.Object _new_init( _String_if st ) throws Exception
    {
        message = st;
        return this;
    }
        
    public java.lang.Object _new_init( java.lang.String st ) throws Exception
    {
	if (st != null) {
            message = new _String_cl( st );
	} else {
            message = new _String_cl( CN );
	}
        return this;
    }
        
    public final _String_if asString()
    {
        checkSecureInvocation();
        java.lang.String  rv_tmp = CN.concat("[");
        if (message != null) {
            rv_tmp = rv_tmp.concat(((_String_cl)message)._body);
        }
        rv_tmp = rv_tmp.concat("]");
        return new _String_cl(rv_tmp);
    }
        
    public final _String_if getMessage()
    {
        return message;
    }
}
