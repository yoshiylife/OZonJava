/*
 * $Id: Pool.oz,v 1.3 1998/02/02 03:40:08 hgoto Exp $
 */

/*
 * PoolはFMObjectの集合をあらわすクラスである
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
	 * Poolに要素を追加する
	 *
	 * @param	cont	追加する要素
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
	 * 指定された名前を持つFMObjectを返す。
	 *
	 * @param	name	指定する名前
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
	 * Poolに含まれるすべての要素を返す
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
	 * Poolにある要素が含まれているかを調べる
	 * 含まれていたらtrueを返す。
	 *
	 * @param	obj	調べる要素
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
	 * Poolにある名前をもつ要素が含まれているかを調べる
	 * 含まれていたらtrueを返す。
	 *
	 * @param	name	調べる名前
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
	 * あるオブジェクトをPoolから消去する
	 *
	 * @param	obj	消去するオブジェクト
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
	 * ある名前を持つオブジェクトを一つPoolから消去する
	 *
	 * @param	name	消去するオブジェクトの持つ名前
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

			list = this->getPool()->difference(pl->getPool());
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
