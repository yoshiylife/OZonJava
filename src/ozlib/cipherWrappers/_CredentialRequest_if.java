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

public interface _CredentialRequest_if extends _Root_if {
    public _String_if getCalleeOzHome();
    public long getNonce();
    public _ByteArray_if pack(_OzKey_if key) throws Exception;
    public _CredentialRequest_if unpack(_ByteArray_if ba, _OzKey_if key)
      throws Exception;
}
