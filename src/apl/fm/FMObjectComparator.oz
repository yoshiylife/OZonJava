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
 * $Id: FMObjectComparator.oz,v 1.1 1997/11/28 07:17:51 hgoto Exp $
 */

class FMObjectComparator : Comparator {
	new create() {
	}

	public bool compare(Root src1,Root src2) {
		FMObject fm1,fm2;
		fm1 =| src1;
		fm2 =| src2;
		return fm1->isEqualFMObject(fm2);
	}

	public int hash(Root obj) {
		StringComparator strcmp;
		FMObject fmobj;
		String str;

		fmobj =| obj;
		strcmp=>create();

		str = fmobj->getIdentifier()->asString();
		return strcmp->hash(str);
	}

	public Comparator duplicate() {
		FMObjectComparator fc;
		fc=>create();

		return fc;
	}
}
