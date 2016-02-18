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
 * $Id: _FileDescriptor_if.java,v 1.4 1997/06/16 05:30:46 xsun Exp $
 */

package JP.go.ipa.oz.lib.standard;

public interface _FileDescriptor_if
extends JP.go.ipa.oz.lang._Root_if
{
  
    public boolean valid() throws Exception;
    public void sync() throws Exception;
    public _FileDescriptor_if getIn() throws Exception;
    public _FileDescriptor_if getOut() throws Exception;
    public _FileDescriptor_if getErr() throws Exception;
}
