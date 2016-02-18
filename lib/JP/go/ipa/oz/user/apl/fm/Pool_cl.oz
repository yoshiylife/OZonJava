/*
 * $Id: Pool.oz,v 1.3 1998/02/02 03:40:08 hgoto Exp $
 */

/*
 * Pool��FMObject�ν���򤢤�魯���饹�Ǥ���
 */
class Pool : *FMObject {
	Set pool;
	PointerComparator pc;

	new create() {
		super=>create();
		pc=>create();
		pool=>create(pc);
	}

	/*
	 * Pool�����Ǥ��ɲä���
	 *
	 * @param	cont	�ɲä�������
	 */
	public void addContent(FMObject cont) {
		Overseer over=>create();
		over->permit(cont);
		addContentInternal(cont);
	}

	protected void addContentInternal(FMObject cont) {
		Overseer over=>create();
		Pointer point;
		Pointer addpoint;
		over->permit(cont);
//System system=>create();system->println("Pool#addContent");

		point = cont->getIdentifier();
		over->permit(point);
		//addpoint=>create(point->getLocation(),point->getName());
		pool->add(point);
		commit();
	}

	public void addContent(Point point) {
		Overseer over=>create();
		over->permit(point);
		pool->add(point);
		commit();
	}

	/*
	 * ���ꤵ�줿̾�������FMObject���֤���
	 *
	 * @param	name	���ꤹ��̾��
	 */
	public Set getContents(String name) {
		Overseer over=>create();
		FMObjectComparator fc=>create();
		Set result => create(fc);
		Iterator iter = pool->iterator();
		FMObject obj;
		Pointer point;
		over->permit(name);

		while (iter->hasMoreElements()) {
			point =| iter->nextElement();
			obj = point->stuff();
			over->permit(obj);
			if (obj->getName()->isequal(name)) {
				result->add(obj);
			}
		}
		return result;
	}

	/*
	 * Pool�˴ޤޤ�뤹�٤Ƥ����Ǥ��֤�
	 */
	public Set getAll() {
		Overseer over=>create();
		Set result;
		Iterator iter;
		Pointer point;
		FMObject obj;
		FMObjectComparator fc;

		fc=>create();
		result=>create(fc);
		iter = pool->iterator();

		while(iter->hasMoreElements()) {
			point =| iter->nextElement();
			obj = point->stuff();
			over->permit(obj);
			result->add(obj);
		}

		return result;
	}

	public Set getPool() {
		return pool;
	}

	/*
	 * Pool�ˤ������Ǥ��ޤޤ�Ƥ��뤫��Ĵ�٤�
	 * �ޤޤ�Ƥ�����true���֤���
	 *
	 * @param	obj	Ĵ�٤�����
	 */
	public bool contains(FMObject obj) {
		Overseer over=>create();
		Pointer point;
		over->permit(obj);
		point = obj->getIdentifier();
		over->permit(point);
		return pool->contains(point);
	}

	/*
	 * Pool�ˤ���̾���������Ǥ��ޤޤ�Ƥ��뤫��Ĵ�٤�
	 * �ޤޤ�Ƥ�����true���֤���
	 *
	 * @param	name	Ĵ�٤�̾��
	 */
	public bool contains(String name) {
		Overseer over=>create();
		Set result => create();
		Iterator iter = pool->iterator();
		FMObject obj;
		Pointer point;

		over->permit(name);
		while (iter->hasMoreElements()) {
			point =| iter->nextElement();
			obj = point->stuff();
			over->permit(obj);
			if (obj->getName()->isequal(name)) {
				result->add(obj);
			}
		}

		if ((result->size()) > 0) return true;
		return false;
	}

	/*
	 * ���륪�֥������Ȥ�Pool����õ��
	 *
	 * @param	obj	�õ�륪�֥�������
	 */
	public void remove(FMObject obj) {
		Overseer over=>create();
		Pointer point;

		over->permit(obj);
		point = obj->getIdentifier();
		over->permit(point);
		pool->remove(point);
	}

	/*
	 * ����̾������ĥ��֥������Ȥ���Pool����õ��
	 *
	 * @param	name	�õ�륪�֥������Ȥλ���̾��
	 */
	public void remove(String name) {
		Overseer over=>create();
		Iterator iter = pool->iterator();
		FMObject obj;
		Pointer point;

		over->permit(name);
		while (iter->hasMoreElements()) {
			point =| iter->nextElement();
			obj = point->stuff();
			over->permit(obj);
			if (obj->getName()->isequal(name)) {
				pool->remove(point);
				break;
			}
		}
	}
	public void toGreen() {
		Pointer point;
		Overseer overseer=>create();

		overseer->permit(pool);
		//Iterator iter = pool->iterator();
		//while (iter->hasMoreElements()) {
		//	FMObject obj;
		//	point =| iter->nextElement();
		//	obj = point->stuff();
		//	overseer->permit(obj);
		//}
		overseer->permit(pc);
		super->toGreen();
	}

	public locked int update(FMObject obj) {
		Overseer over=>create();
		Pool pl;pl =| obj;
		int counter = updateWithoutLock(pl);

		if (pool != null) {
			Set list = pl->getPool()->difference(this->getPool());
			if (0 < (list->size())) { // �ɲ�
				Iterator iter = list->iterator();
				while (iter->hasMoreElements()) {
					Pointer point;

					point =| iter->nextElement();
					over->permit(point);
					pool->add(point);
					counter++;
				}
			}

			list = this->getPool()->difference(pl->getPool());
			if (0 < (list->size())) { // ���
				Iterator iter = list->iterator();
				while (iter->hasMoreElements()) {
					Pointer point;

					point =| iter->nextElement();
					pool->remove(point);
					counter++;
				}
			}
		}

		return counter;
	}

	public FMObject cloneSelf() {
		// ����FMObject�ʤΤϡ������Х饤�ɤ��뤿��
		Pool clone=>create(this);
		return clone;
	}

	new create(Pool p) {
		Overseer over=>create();
		super=>create(p->getName(), p->getAllRelations(), p->getIdentifier());
		PointerComparator fc=>create();
		pool=>create(fc);
		Iterator iter = p->getAll()->iterator();
		while (iter->hasMoreElements()) {
			Pointer point;
			FMObject o;
			point =| iter->nextElement();
			o = point->stuff();
			over->permit(o);
			addContent(o);
		}
	}
}
