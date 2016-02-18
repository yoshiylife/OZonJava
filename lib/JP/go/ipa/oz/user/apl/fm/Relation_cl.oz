/*
 * $Id: Relation.oz,v 1.3 1998/02/02 03:40:08 hgoto Exp $
 */

/**
 * Relationは、FMObject間の関係を表すオブジェクトであり、
 * 関連元(src)と、関連先(dst)を取り扱う。
 */
class Relation : *Root {
	String name; 		// Link name
	Pointer src; 		// Source FMObject
	String srcRole;		// Source Role Name
	protected Pointer dst;	// Destination FMObject
	String dstRole;		// Destination Role Name
	bool available;		// Enable Link

	/**
	 * Relationの属性の初期化を行う。
	 */
	new create() {
		name => breed("UnKnown");
		src = null;
		srcRole => breed("UnKnown");
		dst = null;
		dstRole => breed("UnKnown");
		enable();
	}

	/**
	 * cloneRelationのためのコンストラクタ
	 */
	new create(String name, Pointer src, String srcRole,
		Pointer dst, String dstRole, bool available) {
		this->name => breed(name);
		if (src != null) {
			String sloc => breed(src->getLocation());
			String snm => breed(src->getName());
			this->src => create(sloc, snm);
		} else {
			this->src = null;
		}
		this->srcRole => breed(srcRole);
		if (dst != null) {
			String dloc => breed(dst->getLocation());
			String dnm => breed(dst->getName());
			this->dst => create(dloc, dnm);
		} else {
			this->dst = null;
		}
		this->dstRole => breed(dstRole);
		this->available = available;
	}

	/**
	 * (関連を削除する。
	 */
	public locked void delete() {
//System system=>create();
//system->println("Relation#delete()");
		FMObject obj = getObj();
		if (obj != null) {
			Relation r = obj->getRelation(this);
			if (r != null) {
				obj->remove(r);
			}
		}
	}

	/**
	 * (直接当Relationが保持される)関連元を設定する。
	 *
	 * @param	s	関連元のオブジェクト
	 */
	public locked void setSource(Pointer s) {
		src = s;
	}

	/**
	 * (直接Relationが保持される)関連元を返す。
	 *
	 * @return 	関連元
	 */
	public Pointer getSource() {
		return src;
	}

	/**
	 * 関連先のオブジェクト(のdead copy)を返す。
	 *
	 * @return	関連先のオブジェクト
	 */
	public FMObject get() {
		if (available) {
			return getObj();
		}

		return null;
	}

	protected FMObject getObj() {
//System system=>create();
//system->println("Relation#get()");
		if (dst != null) {
			FMContainer fed = dst->container();
			if (fed != null) {
				Overseer overseer=>create();
				FMObject rtn;
				rtn = fed->get(dst);
				overseer->permit(rtn);
				return rtn;
			}
		}
		return null;
	}

	/**
	 * 関連先のオブジェクトと結び付ける。
	 *
	 * @param ptr	関連対象のオブジェクトを指し示すポインタ
	 */	
	public locked void attach(Pointer ptr) {
//System system=>create();
//system->println("Relation#attach() ptr:"->concat(ptr->isGreen()?"G":"R"));
		Overseer over=>create();
		over->permit(ptr);
		FMObject obj = ptr->stuff();
//system->println("Relation#attach() obj:"->concat(obj->isGreen()?"G":"R"));
//obj->trace(200);
		over->permit(ptr);
		if (obj != null) {
			Relation r = obj->getRelation(this);
//system->println(r != null ? "Relations#attach() r nonull" :"Relations#attach() r null");
			if (r == null) {
				dst = ptr;
				r = cloneRelation();
				// Swap src <-> dst
				r->setSource(dst);
				r->setDestination(src);
				String s = r->getSrcRole();
				r->setSrcRole(r->getDstRole());
				r->setDstRole(s);
			/* 名前を代えないとattachできないため */	
				r->setName("_"->concat(r->getName()));
				obj->add(r);
				obj->commit();
//obj->trace(203);
			}
		}
	}

	/**
	 * 関連先のオブジェクトとの関連を解消する。
	 */
	public locked void detach() {
		if (isAvailable() != true) {
			enableWithoutLock(false);
			FMObject obj = getObj();
			if (obj  != null) {
				Relation r = obj->getRelation(this);
				if (r != null) {
					r->disable();
					obj->commit();
				}
			}
		}
	}

	/**
	 * 関連先のオブジェクトを指し示すポインタを返す。
	 *
	 * @return	関連先のオブジェクトを指し示すポインタ
	 */
	public Pointer destination() {
		return dst;
	}

	/**
	 * 関連先のオブジェクトを指し示すポインタを設定する。
	 *
	 * @param	d	関連先のオブジェクトを指し示すポインタ
	 */
	public locked void setDestination(Pointer d) {
		dst = d;
	}

	/**
	 * 関連名称を設定する。
	 *
	 * @param	n	関連名称
	 */
	public locked void setName(String n) {
		name = n;
	}

	/**
	 * 関連名称を問い合わせる。
	 *
	 * @return		関連名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 関連元の役割名称を設定する。
	 *
	 * @param	n	役割名称
	 */
	public locked void setSrcRole(String n) {
		srcRole = n;
	}

	/**
	 * 関連元の役割名称を問い合わせる。
	 *
	 * @return		役割名称
	 */
	public String getSrcRole() {
		return srcRole;
	}

	/**
	 * 関連先の役割名称を設定する。
	 *
	 * @param	n	役割名称
	 */
	public locked void setDstRole(String n) {
		dstRole = n;
	}

	/**
	 * 関連先の役割名称を問い合わせる。
	 *
	 * @return		役割名称
	 */
	public String getDstRole() {
		return dstRole;
		}

	/**
	 * 引数で指示された側の役割名称を設定する。
	 *
	 * @param	n	役割名称
	 * @param	ptr	関連元、または関連先へのポインタ
	 */
	public locked void setRole(String n, Pointer ptr) {
		if (ptr->equals(src))
			srcRole = n;
		else if (ptr->equals(dst))
			dstRole = n;
	}

	/**
	 * 引数で指定された側の役割名称を問い合わせる。
	 *
	 * @param	ptr	関連元、または関連先
	 *
	 * @return		役割名称
	 */
	public String getRole(Pointer ptr) {
		if (ptr->equals(src))
			return getSrcRole();
		if (ptr->equals(dst))
			return getDstRole();
		return null;
	}

	/**
	 * 関連の有効・無効を制御する。ここでは、関連先側の関連をも
	 * 制御してる
	 *
	 * @param	b	有効であればtrueを、無効であればfalseを指定
	 */
	public locked void enable(bool b) {
		available = b;
		FMObject obj = getObj();
		if (obj != null) {
			Relation r = obj->getRelation(this);
			if (r != null) {
				r->enable(b);
				obj->commit();
			}
		}
	}

	void enableWithoutLock(bool b) {
		available = b;
		FMObject obj = getObj();
		if (obj != null) {
			Relation r = obj->getRelation(this);
			if (r != null) {
				r->enable(b);
				obj->commit();
			}
		}
	}


	/**
	 * 関連を有効とする。
	 */
	public void enable() {
		enable(true);
	}

	/**
	 * 関連を無効とする。
	 */
	public void disable() {
		enable(false);
	}

	/**
	 * 関連が有効か無効かを調べる。
	 *
	 * @return	有効であればtrueを、無効であればfalseを返す。
	 */
	public bool isAvailable() {
		return available;
	}

	public Relation cloneRelation() {

//System system=>create();
//system->println("Relation#cloneRelation name:"->concat(name));
//system->println("Relation#cloneRelation src:"->concat(src==null?"null":src->asString()));
//system->println("Relation#cloneRelation srcRole:"->concat(srcRole));
//system->println("Relation#cloneRelation dst:"->concat(dst==null?"null":dst->asString()));
//system->println("Relation#cloneRelation dstRole:"->concat(dstRole));
//system->println("Relation#cloneRelation available:"->concat(""->valueOf(available)));

		Relation r => create(name, src, srcRole, dst, dstRole, available);
//System sys=>create(); sys->println("Return : "->concat(r->asString()));
		return r;
	}

	/**
	 * 関連を比較する。関連は関連双方向へのポインタと、関連名称によって
	 * それが同等なものかを判断する。
	 *
	 * @param	比較対象のオブジェクト
	 *
	 * @return	同等であればtrue、異なればfalse
	 */
	public bool isEqualRelation(Relation r) {
		if (name->isequal(r->getName())) {
			Pointer rsrc = r->getSource();
			Pointer rdst = r->destination();
			if (src == null && dst == null) {
				return (rsrc == null && rdst == null);
			}
			if (src == null) {
				if (rsrc == null) {
					return dst->isEqualPointer(rdst);
				}
				if (rdst == null) {
					return dst->isEqualPointer(rsrc);
				}
				return false;
			}
			if (dst == null) {
				if (rdst == null) {
					return src->isEqualPointer(rsrc);
				}
				if (rsrc == null) {
					return src->isEqualPointer(rdst);
				}
				return false;
			}
			if ((src->isEqualPointer(rsrc)
			  && dst->isEqualPointer(rdst))
			||  (src->isEqualPointer(rdst)
			  && dst->isEqualPointer(rsrc))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 関連の名称による比較
	 *
	 * @param	名称
	 *
	 * @return 関連の名称と等しければtrueを、異なればfalseを返す。
	 */
	public bool isEqualRelation(String n) {
		return n->isequal(name);
	}


	public String asString() {
		StringBuffer rtn=>breed("[name=");
 
		rtn->append(name);
		rtn->append(", src=");
		rtn->append(src);
		rtn->append(", srcRole=");
		rtn->append(srcRole);
		rtn->append(", dst=");
		rtn->append(dst);
		rtn->append(", dstRole=");
		rtn->append(dstRole);
		rtn->append(", available=");
		rtn->append(available);
		rtn->append("]");
		return rtn->asString();
	}

	public void toGreen() {
		Overseer overseer=>create();
		overseer->permit(name);
		overseer->permit(src);
		overseer->permit(srcRole);
		overseer->permit(dst);
		overseer->permit(dstRole);
	}

	public void trace(int mark) {
		System system=>create();
		system->println("Relation#trace("
			->concat(""->valueOf(mark))->concat(")")
			->concat(asString()));
	}
}
