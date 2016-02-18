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
 * $Id: Overseer.oz,v 1.1 1997/11/28 07:17:51 hgoto Exp $
 */

class Overseer {
	new create() {
	}

	public void permit(Root r) {
		if (r != null && r->isRed()) {
			turnGreen(r);
			r->toGreen();
// System system=>create();system->println("Overseer#permit "->concat(r->asString()));
		}
	}	
}
