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
 * $Id: _InetAddress_if.java,v 1.7 1997/11/20 00:53:07 nito Exp $
 */

package JP.go.ipa.oz.lib.standard;

public interface _InetAddress_if
extends JP.go.ipa.oz.lang._Root_if
{
    public boolean isMulticastAddress() throws Exception;
    public _String_if getHostName() throws Exception;
    public _ByteArray_if getAddress() throws Exception;
    public _String_if getHostAddress() throws Exception;
    public boolean equalTo(JP.go.ipa.oz.lang._Root_if arg_a) throws Exception;
    public _String_if asString() throws Exception;
    public _InetAddress_if getByName(_String_if arg_a) throws Exception;
    public _Collection_if getAllByName(_String_if arg_a) throws Exception;
    public _InetAddress_if getLocalHost() throws Exception;
}
