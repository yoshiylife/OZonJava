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
 * $Id: _Proxy_cl.java,v 1.6 1997/06/30 07:40:00 hgoto Exp $
 *
 */
package JP.go.ipa.oz.lang;

/**
 * An implementation representing proxy class implementation part
 * in OZ programming language. The interface part is _Proxy_if
 * class.
 *
 * @see		_Proxy_if
 * @version	$Revision: 1.6 $, $Date: 1997/06/30 07:40:00 $
 */
public class _Proxy_cl
    extends JP.go.ipa.oz.system.OzProxy 
    implements _Proxy_if 
{
    protected _Proxy_cl(JP.go.ipa.oz.lib.standard._String_if g)
	throws Exception
    { 
	super (g.toString()); 
    }

    protected _Proxy_cl()
	throws Exception
    {
	super();
    }

    protected _Proxy_cl(JP.go.ipa.oz.lib.standard._String_if g, String c)
	throws Exception
    {
	super(g.toString());
	JP.go.ipa.oz.system.OzCellManager.create(c, this);
    }
	
    /*
     * This method is used by oz compiler for proxy code emitting.
     * Don't use it.
     */
    public Object _new_bind()
    {
	return this;
    }

    /*
     * This method is used by oz compiler for proxy code emitting.
     * Don't use it.
     */
    public Object _new_bind(JP.go.ipa.oz.lib.standard._String_if gol)
    {
	return this;
    }

    /*
     * This method is used by oz compiler for proxy code emitting.
     * Don't use it.
     */
    public Object _new_create(JP.go.ipa.oz.lib.standard._String_if gol)
    {
	return this;
    }
}
/* EOF */
