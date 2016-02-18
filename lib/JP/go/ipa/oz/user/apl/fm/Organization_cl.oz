/*
 * $Id: Organization.oz,v 1.2 1998/02/02 03:40:08 hgoto Exp $
 */

class Organization : *Actor {
	/*
	 * �ȿ���������륪�֥�������
	 * �ȿ��ؤΥ��С����ɲá���������С��μ������Ǥ��롣
	 * �ޤ����ȿ��γ��ع�¤��¸���ǽ�Ǥ��롣
	 */
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
	protected void addContent(FMObject cont) {
		Pointer point;
		Overseer over=>create();

		over->permit(cont);
		point = cont->getIdentifier();
		pool->add(point);
		commit();
	}

	protected void addContent(Pointer point) {
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
	protected Set getContents(String name) {
		Overseer over=>create();
		FMObjectComparator fc=>create();
		Set result => create(fc);
		Iterator iter = pool->iterator();
		FMObject obj;
		Pointer point;

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
	protected Set getAll() {
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

	/*
	 * Pool�ˤ������Ǥ��ޤޤ�Ƥ��뤫��Ĵ�٤�
	 * �ޤޤ�Ƥ�����true���֤���
	 *
	 * @param	obj	Ĵ�٤�����
	 */
	protected bool contains(FMObject obj) {
		Overseer over=>create();
		Pointer point;
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
	protected bool contains(String name) {
		Overseer over=>create();
		Set result => create();
		Iterator iter = pool->iterator();
		FMObject obj;
		Pointer point;

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
	protected void remove(FMObject obj) {
		Overseer over=>create();
		Pointer point;
		point = obj->getIdentifier();
		over->permit(point);
		pool->remove(point);
	}

	/*
	 * ����̾������ĥ��֥������Ȥ���Pool����õ��
	 *
	 * @param	name	�õ�륪�֥������Ȥλ���̾��
	 */
	protected void remove(String name) {
		Overseer over=>create();
		Iterator iter = pool->iterator();
		FMObject obj;
		Pointer point;

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


	/*
	 * �ȿ��ؤΥ��С����ɲä�Ԥ�
	 *
	 * @param	mem		�ɲä�����С�
	 */
	public void addMember(Actor mem) {
		Overseer over=>create();
		over->permit(mem);
		addContent(mem);
	}

	/*
	 * ���Υ��С����ȿ��˽�°���Ƥ��뤫���ǧ����
	 *
	 * @param	mem		��ǧ������С��Υ��֥�������
	 * @return	true		��°����
	 * 		false		��°���ʤ�
	 */
	public bool isBelong(Actor mem) {
		Overseer over=>create();
		over->permit(mem);
		return contains(mem);
	}

	/*
	 * ����̾������ĥ��С����ȿ��˽�°���Ƥ��뤫���ǧ����
	 *
	 * @param	nam		��ǧ������С���̾��
	 * @return	true		��°����
	 *		false		��°���ʤ�
	 */
	public bool isBelong(String nam) {
		Overseer over=>create();
		over->permit(nam);
		return contains(nam);
	}

	/*
	 * ���ꤵ�줿���С����ȿ�����������
	 *
	 * @param	mem		���������С�
	 */
	public void removeMember(Actor mem) {
		Overseer over=>create();
		over->permit(mem);
		remove(mem);
	}

	/*
	 * ̾���ǻ��ꤵ�줿���С����ȿ�����������
	 *
	 * @param	nam		���������С���̾��
	 */
	public void removeMember(String nam) {
		Overseer over=>create();
		over->permit(nam);
		remove(nam);
	}

	/*
	 * �ȿ���°������С������ν�����֤�
	 *
	 * @return	���С�������ޤླྀ��
	 */
	public Set getMembers() {
		return getAll();
	}

	/*
	 * ���ꤷ��̾���˰��פ�����С����֤�
	 *
	 * @param	nam		�������������С���̾��
	 * @return	��������̾������ĥ��С��ν���
	 */
	public Set getMembers(String nam) {
		Overseer over=>create();
		over->permit(nam);
		return getContents(nam);
	}

	/*
	 * ���ꤷ��Actor�˰��פ�����С������֤�
	 *
	 * @param	act		�������������С���Ʊ��Υ��С�
	 * @return	����������С�
	 */ 
	public Actor getMember(Actor act) {
		Overseer over=>create();
		String nam;

		over->permit(act);
		nam = act->getName();
		over->permit(nam);
		return getMember(nam);
	}

	/*
	 * ���ꤷ��̾���˰��פ������С������֤�
	 *
	 * @param	nam		�������������С���̾��
	 * @return	����������С�
	 */
	public Actor getMember(String nam) {
		Overseer over=>create();
		Set resultList;
		Iterator iter;
		Actor act;

		over->permit(nam);
		resultList = getContents(nam);
		iter = resultList->iterator();
		act =| iter->nextElement();
		return act;
	}

	public void toGreen() {
		Overseer overseer=>create();
		overseer->permit(pool);
		overseer->permit(pc);
		super->toGreen();
	}

	public Set getMembersPool() {
		return pool;
	}

	public locked int update(FMObject obj) {
		// ������FMObject�ʤΤϡ������Х饤�ɤ��뤿��
		Overseer over=>create();
		over->permit(obj);
		Organization org;org =| obj;
		int counter = updateWithoutLock(org);

		if (pool != null) {
			Set list = org->getMembersPool()->difference(this->getMembersPool());
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

			list = getMembersPool()->difference(org->getMembersPool());
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
		Organization clone=>create(this);
		return clone;
	}

	new create(Organization o) {
		super=>create(o);
		pool =| o->getMembersPool()->duplicate();
	}
}
