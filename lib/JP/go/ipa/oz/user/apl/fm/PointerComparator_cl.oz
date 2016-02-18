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
