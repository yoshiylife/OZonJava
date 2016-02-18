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
 * $Id: PointerComparator.oz,v 1.2 1998/02/02 03:40:08 hgoto Exp $
 */

class PointerComparator : Comparator {
	new create() {
	}

	public bool compare(Root src1,Root src2) {
		Pointer po1,po2;
		po1 =| src1;
		po2 =| src2;
		Overseer over;
		over=>create();
		over->permit(po1);
		over->permit(po2);
		return po1->isEqualPointer(po2);
	}

	public int hash(Root obj) {
		StringComparator strcmp;
		Pointer point;
		String str;
		Overseer over;

		over=>create();
		// over->permit(obj);

		point =| obj;
		strcmp=>create();

		over->permit(point);
		str = point->asString();
		return strcmp->hash(str);
	}

	public Comparator duplicate() {
		PointerComparator pc;
		pc=>create();

		return pc;
	}
}
