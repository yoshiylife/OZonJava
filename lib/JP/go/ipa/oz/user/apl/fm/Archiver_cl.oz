/*
 * $Id: Archiver.oz,v 1.3 1998/02/02 03:40:08 hgoto Exp $
 */
/**
 * Archiverは、FMContainer内部の要素である FMObject の転出先を管理するための
 * グローバルな管理オブジェクトである。本来は、FMContainer内部に持つべき
 * ものであるが、これらはアクセス要求が少ないことと、余計な領域を消費するので、
 * FMContainerから分離させ、必要に応じ活性化させることとした。
 */

cell Archiver {
	Dictionary list;
	Overseer overseer;

	public void initialize() {
		PointerComparator pc=>create();
		list=>create(pc, pc);
		overseer=>create();
	}

	public void quiet() {
		flushCell();
	}

	public void add(Pointer oid, Pointer nid) {
		overseer->permit(oid);
		overseer->permit(nid);
		Association assoc => create(oid, nid);
		list->put(assoc);
	}

	public void remove(Pointer ptr) {
		overseer->permit(ptr);
		list->remove(ptr);
	}

	public Pointer find(Pointer ptr) {
		overseer->permit(ptr);
		Pointer rtn;
		rtn =| list->get(ptr);
		return rtn;
	}
		
}
