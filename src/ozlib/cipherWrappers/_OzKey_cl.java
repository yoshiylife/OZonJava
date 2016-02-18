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

import JP.go.ipa.oz.lang._Root_cl;
import JP.go.ipa.oz.system.OzKey;

public class _OzKey_cl extends _Root_cl implements _OzKey_if {
    OzKey _body;

    protected _OzKey_cl() {}
    protected _OzKey_cl(OzKey key) {_body = key;}
    public boolean isEqualKey(_OzKey_if key) throws Exception {
	return _body.isEqualKey(((_OzKey_cl)key)._body);
    }
}
