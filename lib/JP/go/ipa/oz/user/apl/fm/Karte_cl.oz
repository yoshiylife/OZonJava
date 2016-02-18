/*
 * $Id: Karte.oz,v 1.2 1997/12/03 02:10:07 hgoto Exp $
 */
/**
 * Karte�ϡ�FMContainer����Ͽ���륢���������������ͤǤ��롣
 * FMObject�ȡ�FMObject���Ф���FMContainer�ؤ���Ͽ������
 * �����°���ι��������򶦤˵�Ͽ����
 */
class Karte : *Root {
	SList dates;
	Root value;

	new create(Root value) {
		this->value = value;
		DateComparator	dc=>create();
		dates => create(dc);
		Date d=>breed();
		dates->pushBack(d);		// ��Ͽ����
//System system=>create();
//system->println("Karte#create:"->concat(d->asString()));
	}
	
	public void add() {
		Date d=>breed();
		dates->pushBack(d);		// ��������
//System system=>create();
//system->println("Karte#add:"->concat(d->asString()));
	}

	public Root getValue() {
		return value;
	}

	public SList getDates() {
		return dates;
	}
	public String asString() {
		StringBuffer rtn=>breed(value->asString());
		Iterator iter = dates->iterator();
		while (iter->hasMoreElements()) {
			Date d;d =| iter->nextElement();	
			rtn->append("\n")->append(d->asString());
		}
		return rtn->asString();
	}
}

