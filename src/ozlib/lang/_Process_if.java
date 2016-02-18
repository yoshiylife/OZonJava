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
 * $Id: _Process_if.java,v 1.1 1997/07/23 06:32:58 hgoto Exp $
 */

package JP.go.ipa.oz.lib.standard;

public abstract interface _Process_if
    extends JP.go.ipa.oz.lang._Root_if
{
    public _OutputStream_if getOutputStream() throws Exception;
    public _InputStream_if getInputStream() throws Exception;
    public _InputStream_if getErrorStream() throws Exception;
    public int waitFor() throws Exception;
    public int exitValue() throws Exception;
    public void destroy() throws Exception;
}
