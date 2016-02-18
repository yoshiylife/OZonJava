/*
 * $Id: Organization.oz,v 1.2 1998/02/02 03:40:08 hgoto Exp $
 */

class Organization : *Actor {
	/*
	 * 組織を管理するオブジェクト
	 * 組織へのメンバーの追加・削除、メンバーの取得ができる。
	 * また、組織の階層構造も実現可能である。
	 */
	Set pool;
	PointerComparator pc;

	new create() {
		super=>create();
		pc=>create();
		pool=>create(pc);
	}

	/*
	 * Poolに要素を追加する
	 *
	 * @param	cont	追加する要素
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
	 * 指定された名前を持つFMObjectを返す。
	 *
	 * @param	name	指定する名前
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
	 * Poolに含まれるすべての要素を返す
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
	 * Poolにある要素が含まれているかを調べる
	 * 含まれていたらtrueを返す。
	 *
	 * @param	obj	調べる要素
	 */
	protected bool contains(FMObject obj) {
		Overseer over=>create();
		Pointer point;
		point = obj->getIdentifier();
		over->permit(point);
		return pool->contains(point);
	}

	/*
	 * Poolにある名前をもつ要素が含まれているかを調べる
	 * 含まれていたらtrueを返す。
	 *
	 * @param	name	調べる名前
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
	 * あるオブジェクトをPoolから消去する
	 *
	 * @param	obj	消去するオブジェクト
	 */
	protected void remove(FMObject obj) {
		Overseer over=>create();
		Pointer point;
		point = obj->getIdentifier();
		over->permit(point);
		pool->remove(point);
	}

	/*
	 * ある名前を持つオブジェクトを一つPoolから消去する
	 *
	 * @param	name	消去するオブジェクトの持つ名前
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
	 * 組織へのメンバーの追加を行う
	 *
	 * @param	mem		追加するメンバー
	 */
	public void addMember(Actor mem) {
		Overseer over=>create();
		over->permit(mem);
		addContent(mem);
	}

	/*
	 * そのメンバーが組織に所属しているかを確認する
	 *
	 * @param	mem		確認するメンバーのオブジェクト
	 * @return	true		所属する
	 * 		false		所属しない
	 */
	public bool isBelong(Actor mem) {
		Overseer over=>create();
		over->permit(mem);
		return contains(mem);
	}

	/*
	 * その名前を持つメンバーが組織に所属しているかを確認する
	 *
	 * @param	nam		確認するメンバーの名前
	 * @return	true		所属する
	 *		false		所属しない
	 */
	public bool isBelong(String nam) {
		Overseer over=>create();
		over->permit(nam);
		return contains(nam);
	}

	/*
	 * 指定されたメンバーを組織から削除する
	 *
	 * @param	mem		削除するメンバー
	 */
	public void removeMember(Actor mem) {
		Overseer over=>create();
		over->permit(mem);
		remove(mem);
	}

	/*
	 * 名前で指定されたメンバーを組織から削除する
	 *
	 * @param	nam		削除するメンバーの名前
	 */
	public void removeMember(String nam) {
		Overseer over=>create();
		over->permit(nam);
		remove(nam);
	}

	/*
	 * 組織に属するメンバー全員の集合を返す
	 *
	 * @return	メンバー全員を含む集合
	 */
	public Set getMembers() {
		return getAll();
	}

	/*
	 * 指定した名前に一致するメンバーを返す
	 *
	 * @param	nam		取得したいメンバーの名前
	 * @return	該当する名前を持つメンバーの集合
	 */
	public Set getMembers(String nam) {
		Overseer over=>create();
		over->permit(nam);
		return getContents(nam);
	}

	/*
	 * 指定したActorに一致するメンバーを一つ返す
	 *
	 * @param	act		取得したいメンバーと同一のメンバー
	 * @return	該当するメンバー
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
	 * 指定した名前に一致したメンバーを一つ返す
	 *
	 * @param	nam		取得したいメンバーの名前
	 * @return	該当するメンバー
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
		// 引数がFMObjectなのは、オーバライドするため
		Overseer over=>create();
		over->permit(obj);
		Organization org;org =| obj;
		int counter = updateWithoutLock(org);

		if (pool != null) {
			Set list = org->getMembersPool()->difference(this->getMembersPool());
			if (0 < (list->size())) { // 追加
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
			if (0 < (list->size())) { // 削除
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
		// 型がFMObjectなのは、オーバライドするため
		Organization clone=>create(this);
		return clone;
	}

	new create(Organization o) {
		super=>create(o);
		pool =| o->getMembersPool()->duplicate();
	}
}
