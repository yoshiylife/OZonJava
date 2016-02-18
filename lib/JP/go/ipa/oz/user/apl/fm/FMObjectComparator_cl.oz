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
