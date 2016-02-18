/*
 * $Id: Actor.oz,v 1.2 1997/12/03 02:10:06 hgoto Exp $
 */
/**
 *
 *  Actorは人や組織などの、存在場所と連絡先をもつ
 *  オブジェクトのための抽象クラスである。
 */
class Actor : *FMObject {

	new create() {
		super=>create();
	}

	new create(String nam) {
		super=>create();
		setName(nam);
	}

	/*
	 * Actorの存在場所を設定する
	 *
	 * @param	place	存在場所
	 */
	public void setPlace(String place) {
		SList list = findRelations("Place");
		Relation rel;
		FMObject obj;

		if  (list == null) {
			FMContainer fed = federation();
			obj=>create();
			fed->add(obj);

			rel = createRelation("Place",obj);
		} else {
			rel =| list->first();
			obj = rel->get();
		}
		obj->setName(place);
		obj->commit();
	}

	/*
	 * Actorの存在場所を取得する
	 */
	public String getPlace() {
		FMObject obj = getRelatedObject("Place");

		if  (obj != null) {
			return obj->getName();
		}
		return null;
	}

	/*
	 * Actorの連絡先を設定する
	 *
	 * @param	access	連絡先
	 */
	public void setAccess(String access) {
		SList list = findRelations("Access");
		Relation rel;
		FMObject obj;

		if  (list == null) {
			FMContainer fed = federation();
			obj=>create();
			fed->add(obj);

			rel = createRelation("Access",obj);
		} else {
			rel =| list->first();
			obj = rel->get();
		}
		obj->setName(access);
		obj->commit();
	}

	/* 
	 * Actorの連絡先を取得する
	 */
	public String getAccess() {
		FMObject obj = getRelatedObject("Access");

		if  (obj != null) {
			return obj->getName();
		}
		return null;
	}

	/*
	 * Actorにある名前の役割を追加する
	 *
	 * @param	roleName	役割の名前
	 */
	public void setRole(String roleName) {
		Actor actor=>create();
		actor->setName(roleName);
		FMContainer fed = federation();
		fed->add(actor);

		setRole(actor);
	}

	/*
	 * Actorに役割を追加する
	 *
	 * @param	actor	追加する役割
	 */
	public void setRole(Actor actor) {
		Relation rel = createRelation("Role", actor);
		rel->setDstRole("Role");
		rel->setSrcRole("ParentRole");
	}

	public FMObject cloneSelf() {
		// 型がFMObjectなのは、オーバライドするため
		Actor clone=>create(this);
		return clone;
	}

	new create(Actor a) {
		super=>create(a->getName(), a->getAllRelations(), a->getIdentifier());
	}

	public void trace(int mark) {
		System system=>create();
		PrintWriter pw=>breed(system->getStdout(), true);
		pw->print("Actor#trace(");
		pw->print(mark);
		pw->println(")");
		pw->println("---- super ----");
		super->trace(mark);
	}
}

