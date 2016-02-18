/*
 * $Id: Relation.oz,v 1.3 1998/02/02 03:40:08 hgoto Exp $
 */

/**
 * Relation�ϡ�FMObject�֤δط���ɽ�����֥������ȤǤ��ꡢ
 * ��Ϣ��(src)�ȡ���Ϣ��(dst)���갷����
 */
class Relation : *Root {
	String name; 		// Link name
	Pointer src; 		// Source FMObject
	String srcRole;		// Source Role Name
	protected Pointer dst;	// Destination FMObject
	String dstRole;		// Destination Role Name
	bool available;		// Enable Link

	/**
	 * Relation��°���ν������Ԥ���
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
	 * cloneRelation�Τ���Υ��󥹥ȥ饯��
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
	 * (��Ϣ�������롣
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
	 * (ľ����Relation���ݻ������)��Ϣ�������ꤹ�롣
	 *
	 * @param	s	��Ϣ���Υ��֥�������
	 */
	public locked void setSource(Pointer s) {
		src = s;
	}

	/**
	 * (ľ��Relation���ݻ������)��Ϣ�����֤���
	 *
	 * @return 	��Ϣ��
	 */
	public Pointer getSource() {
		return src;
	}

	/**
	 * ��Ϣ��Υ��֥�������(��dead copy)���֤���
	 *
	 * @return	��Ϣ��Υ��֥�������
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
	 * ��Ϣ��Υ��֥������Ȥȷ���դ��롣
	 *
	 * @param ptr	��Ϣ�оݤΥ��֥������Ȥ�ؤ������ݥ���
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
			/* ̾�����夨�ʤ���attach�Ǥ��ʤ����� */	
				r->setName("_"->concat(r->getName()));
				obj->add(r);
				obj->commit();
//obj->trace(203);
			}
		}
	}

	/**
	 * ��Ϣ��Υ��֥������ȤȤδ�Ϣ���ä��롣
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
	 * ��Ϣ��Υ��֥������Ȥ�ؤ������ݥ��󥿤��֤���
	 *
	 * @return	��Ϣ��Υ��֥������Ȥ�ؤ������ݥ���
	 */
	public Pointer destination() {
		return dst;
	}

	/**
	 * ��Ϣ��Υ��֥������Ȥ�ؤ������ݥ��󥿤����ꤹ�롣
	 *
	 * @param	d	��Ϣ��Υ��֥������Ȥ�ؤ������ݥ���
	 */
	public locked void setDestination(Pointer d) {
		dst = d;
	}

	/**
	 * ��Ϣ̾�Τ����ꤹ�롣
	 *
	 * @param	n	��Ϣ̾��
	 */
	public locked void setName(String n) {
		name = n;
	}

	/**
	 * ��Ϣ̾�Τ��䤤��碌�롣
	 *
	 * @return		��Ϣ̾��
	 */
	public String getName() {
		return name;
	}

	/**
	 * ��Ϣ�������̾�Τ����ꤹ�롣
	 *
	 * @param	n	���̾��
	 */
	public locked void setSrcRole(String n) {
		srcRole = n;
	}

	/**
	 * ��Ϣ�������̾�Τ��䤤��碌�롣
	 *
	 * @return		���̾��
	 */
	public String getSrcRole() {
		return srcRole;
	}

	/**
	 * ��Ϣ������̾�Τ����ꤹ�롣
	 *
	 * @param	n	���̾��
	 */
	public locked void setDstRole(String n) {
		dstRole = n;
	}

	/**
	 * ��Ϣ������̾�Τ��䤤��碌�롣
	 *
	 * @return		���̾��
	 */
	public String getDstRole() {
		return dstRole;
		}

	/**
	 * �����ǻؼ����줿¦�����̾�Τ����ꤹ�롣
	 *
	 * @param	n	���̾��
	 * @param	ptr	��Ϣ�����ޤ��ϴ�Ϣ��ؤΥݥ���
	 */
	public locked void setRole(String n, Pointer ptr) {
		if (ptr->equals(src))
			srcRole = n;
		else if (ptr->equals(dst))
			dstRole = n;
	}

	/**
	 * �����ǻ��ꤵ�줿¦�����̾�Τ��䤤��碌�롣
	 *
	 * @param	ptr	��Ϣ�����ޤ��ϴ�Ϣ��
	 *
	 * @return		���̾��
	 */
	public String getRole(Pointer ptr) {
		if (ptr->equals(src))
			return getSrcRole();
		if (ptr->equals(dst))
			return getDstRole();
		return null;
	}

	/**
	 * ��Ϣ��ͭ����̵�������椹�롣�����Ǥϡ���Ϣ��¦�δ�Ϣ���
	 * ���椷�Ƥ�
	 *
	 * @param	b	ͭ���Ǥ����true��̵���Ǥ����false�����
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
	 * ��Ϣ��ͭ���Ȥ��롣
	 */
	public void enable() {
		enable(true);
	}

	/**
	 * ��Ϣ��̵���Ȥ��롣
	 */
	public void disable() {
		enable(false);
	}

	/**
	 * ��Ϣ��ͭ����̵������Ĵ�٤롣
	 *
	 * @return	ͭ���Ǥ����true��̵���Ǥ����false���֤���
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
	 * ��Ϣ����Ӥ��롣��Ϣ�ϴ�Ϣ�������ؤΥݥ��󥿤ȡ���Ϣ̾�Τˤ�ä�
	 * ���줬Ʊ���ʤ�Τ���Ƚ�Ǥ��롣
	 *
	 * @param	����оݤΥ��֥�������
	 *
	 * @return	Ʊ���Ǥ����true���ۤʤ��false
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
	 * ��Ϣ��̾�Τˤ�����
	 *
	 * @param	̾��
	 *
	 * @return ��Ϣ��̾�Τ����������true�򡢰ۤʤ��false���֤���
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
