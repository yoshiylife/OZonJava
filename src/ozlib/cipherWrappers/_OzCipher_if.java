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

import JP.go.ipa.oz.lang._Root_if;

public interface _OzCipher_if extends _Root_if {
    public _String_if getCallerOzHome() throws Exception;
    public _OzCipher_if getCipher(_String_if cipherName) throws Exception;
    public _OzKey_if getKey(_String_if password) throws Exception;
    public void encode(_InputStream_if in, _OzKey_if key, _OutputStream_if out)
      throws Exception;
    public void decode(_InputStream_if in, _OzKey_if key, _OutputStream_if out)
      throws Exception;
}
