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
 * $Id: _Date_if.java,v 1.1 1997/08/19 09:52:13 hgoto Exp $
 */

package JP.go.ipa.oz.lib.standard;

public interface _Date_if
extends JP.go.ipa.oz.lang._Root_if, Cloneable
{
    public long getTime() throws Exception;
    public void setTime(long arg_a) throws Exception;
    public boolean before(_Date_if arg_a) throws Exception;
    public boolean after(_Date_if arg_a) throws Exception;
    public boolean isEqualDate(_Date_if arg_a) throws Exception;
    public _String_if asString() throws Exception;
}
