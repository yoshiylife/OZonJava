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
 * $Id: _ServerSocket_if.java,v 1.6 1997/07/23 07:47:46 nito Exp $
 */

package JP.go.ipa.oz.lib.standard;

public interface _ServerSocket_if
extends JP.go.ipa.oz.lang._Root_if
{
    public _InetAddress_if getInetAddress() throws Exception;
    public int getLocalPort() throws Exception;
    public _Socket_if accept() throws Exception;
    public void close() throws Exception;
    public void setSoTimeout(int arg_a) throws Exception;
    public int getSoTimeout() throws Exception;
    public void setSocketFactory(_SocketImplFactory_if arg_a) throws Exception;
}
