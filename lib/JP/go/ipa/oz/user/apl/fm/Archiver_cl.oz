/*
 * $Id: Archiver.oz,v 1.3 1998/02/02 03:40:08 hgoto Exp $
 */
/**
 * Archiver�ϡ�FMContainer���������ǤǤ��� FMObject ��ž�����������뤿���
 * �����Х�ʴ������֥������ȤǤ��롣����ϡ�FMContainer�����˻��Ĥ٤�
 * ��ΤǤ��뤬�������ϥ��������׵᤬���ʤ����Ȥȡ�;�פ��ΰ����񤹤�Τǡ�
 * FMContainer����ʬΥ������ɬ�פ˱��������������뤳�ȤȤ�����
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
