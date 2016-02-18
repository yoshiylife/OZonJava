/*
 * $Id: Karte.oz,v 1.2 1997/12/03 02:10:07 hgoto Exp $
 */
/**
 * Karteは、FMContainerに登録するアソシエーションの値である。
 * FMObjectと、FMObjectに対するFMContainerへの登録日時、
 * および属性の更新日時を共に記録する
 */
class Karte : *Root {
	SList dates;
	Root value;

	new create(Root value) {
		this->value = value;
		DateComparator	dc=>create();
		dates => create(dc);
		Date d=>breed();
		dates->pushBack(d);		// 登録日時
//System system=>create();
//system->println("Karte#create:"->concat(d->asString()));
	}
	
	public void add() {
		Date d=>breed();
		dates->pushBack(d);		// 更新日時
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

