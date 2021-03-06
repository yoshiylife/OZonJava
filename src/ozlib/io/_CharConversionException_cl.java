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
 * $Id: _CharConversionException_cl.java,v 1.2 1997/06/17 10:12:56 xsun Exp $
*/

package JP.go.ipa.oz.lib.standard;

public class _CharConversionException_cl
	extends _IOException_cl
	implements _CharConversionException_if
{
	static java.lang.String CN = "CharConversionException";
	
	public _CharConversionException_cl() throws Exception
	{
	}

    public java.lang.Object _new_init() throws Exception
    {
	super._new_init();
	return this;
    }
	
    public java.lang.Object _new_init( _String_if st ) throws Exception
    {
	super._new_init( st );
	return this;
    }
	
    public java.lang.Object _new_init( java.lang.String st ) throws Exception
    {
	super._new_init( st );
	return this;
    }
}
