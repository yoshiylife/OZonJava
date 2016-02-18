/*
 * $Id: Actor.oz,v 1.2 1997/12/03 02:10:06 hgoto Exp $
 */
/**
 *
 *  Actor�Ͽͤ��ȿ��ʤɤΡ�¸�߾���Ϣ�������
 *  ���֥������ȤΤ������ݥ��饹�Ǥ��롣
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
	 * Actor��¸�߾������ꤹ��
	 *
	 * @param	place	¸�߾��
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
	 * Actor��¸�߾����������
	 */
	public String getPlace() {
		FMObject obj = getRelatedObject("Place");

		if  (obj != null) {
			return obj->getName();
		}
		return null;
	}

	/*
	 * Actor��Ϣ��������ꤹ��
	 *
	 * @param	access	Ϣ����
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
	 * Actor��Ϣ������������
	 */
	public String getAccess() {
		FMObject obj = getRelatedObject("Access");

		if  (obj != null) {
			return obj->getName();
		}
		return null;
	}

	/*
	 * Actor�ˤ���̾���������ɲä���
	 *
	 * @param	roleName	����̾��
	 */
	public void setRole(String roleName) {
		Actor actor=>create();
		actor->setName(roleName);
		FMContainer fed = federation();
		fed->add(actor);

		setRole(actor);
	}

	/*
	 * Actor�������ɲä���
	 *
	 * @param	actor	�ɲä������
	 */
	public void setRole(Actor actor) {
		Relation rel = createRelation("Role", actor);
		rel->setDstRole("Role");
		rel->setSrcRole("ParentRole");
	}

	public FMObject cloneSelf() {
		// ����FMObject�ʤΤϡ������Х饤�ɤ��뤿��
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

