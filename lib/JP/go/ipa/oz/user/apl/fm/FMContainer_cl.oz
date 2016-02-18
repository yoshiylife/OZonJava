/*
 * $Id: FMContainer.oz,v 1.2 1998/02/02 03:40:08 hgoto Exp $
 */
/**
 * FMContainer�ϡ�ʣ����FMObject��������뤿���(�����Х��)���֥������ȤǤ��ꡢ
 * �����оݤ�FMObject�ΰ�ư�ε�Ͽ��Ȥ롣
 */
cell FMContainer {
	int seqNumber;
	Dictionary elements;
	Archiver arch;
	Overseer overseer;

	public void initialize() {
		seqNumber = 0;
		StringComparator sc=>create();
		elements=>create(sc);
		System system=>create();
		arch=>create(system->getGOL()->concat("arch"));
		overseer=>create();
	}

	public void quiet() {
		flushCell();
	}

	/**
	 * FMContainer���Pointer�ǻؤ��������FMObject��¸�ߤ��뤫������롣
	 *
	 * @param	ptr	�оݤ�FMObject
	 *
	 * @return		¸�ߤ�����ˤ�true���ʤ����ˤ� false
	 */
	public bool contains(Pointer ptr) {
		overseer->permit(ptr);
		String key = ptr->getName();
		return elements->containsKey(key);
	}

	/**
	 * FMContainer���顢Pointer�ǻؤ��������FMObject�����(dead copy)���롣
	 *
	 * @param ptr	��������FMObject��ؤ�����Identifier
	 *
	 * @return		Pointer�ǻؤ��������FMObject(��dead copy)
	 */
	public FMObject get(Pointer ptr) {
		overseer->permit(ptr);
// System system=>create();system->println("FMContainer#get(Pointer):"->concat(ptr->asString()));
		FMObject rtn;
		Karte karte;
		String key = ptr->getName();
// system->println("FMContainer#get key = ptr->getName():"->concat(key));
		karte =| elements->get(key);
// system->println("FMContainer#get elements->get(key) is "->concat((karte == null)?"null":"not null"));
//this->trace(999);
		if (karte == null) {
// system->println("FMContainer#get():call archiver");
			ptr = arch->find(ptr);	
			if (ptr == null) {
// system->println("FMContainer#get() arch->find:null");
				 return null;
			}
			overseer->permit(ptr);
// system->println("FMContainer#get() arch->find:"->concat(ptr->asString()));
			return ptr->stuff();
		}
		rtn =| karte->getValue();
		return rtn;
	}


	/**
	 * ��������FMContainer�δ������ˤ��ä�FMObject�ΰ�ž��(��FMContainer)��
	 * �����롣
	 *
	 * @param	ptr	�о�FMObject�ε�Identifier
	 *
	 * @return	��ž���FMContainer��ؤ�����Identifier
	 */
	public Pointer find(Pointer ptr) {
		overseer->permit(ptr);
		return arch->find(ptr);
	}
	
 
	/**
	* ������FMObject��Ʊ����FMObject��ؤ�����Identifier���֤���
	* FMObject���������ϥ᥽�å�equals()�ˤ�ä�Ĵ�٤롣
	*
	* @param	obj	Identifier���оݤ�FMObject��Ʊ����FMObject
	*
	* @return		������FMObject��Ʊ����FMObject��ؤ�����Identifier
	*/
	public Pointer getIdentifier(FMObject obj) {
		overseer->permit(obj);
		Iterator iter = elements->assocIterator();
		while (iter->hasMoreElements()) {
			Association assoc;assoc =| iter->nextElement();
			Karte karte;karte =| assoc->value();
			FMObject fedobj;fedobj =| karte->getValue();
			if (obj->isEqualFMObject(fedobj)) {
				String key;key =| assoc->key();
				System system=>create();
 				Pointer ptr => create(system->getGOL(), key);
				return ptr;
			}
		}
		return null;
	}

	/**
	 * FMContainer�˿�����FMObject����Ͽ���롣���λ��ˡ�FMObject���Ф��� 
	 * FMContainer������Identifier��FMObject���ȡ�������FMObject����Ͽ��
	 * �ѹ��˴ؤ��뵭Ͽ�����Ҥ����֥���ơפ���������롣FMContainer�Ǥϡ�
	 * ľ��FMObject���������ΤǤϤʤ������Υ���Ƥ�𤷤ƴ������뤳�Ȥˤʤ롣
	 * �ޤ������Υ᥽�å� add()�����ͤȤ��ơ���Ͽ���줿FMObject�򥢥���������
	 * ����� Identifier�Ǥ���Pointer���֤���롣
	 *
	 * @param obj	��Ͽ�оݤ�FMObject
	 *
	 * @return 		��Ͽ����FMObjct��ؤ�����Identifier
	 */
	public locked Pointer add(FMObject obj) {
		overseer->permit(obj);
 		System system=>create();
//system->println("FMContainer#add(FMObject):"->concat(obj->getName()));

		Integer n => breed(seqNumber++);
		String key = n->asString();
		Karte karte=>create(obj);
		elements->put(key, karte);

		Pointer ptr => create(system->getGOL(), key);
		obj->setIdentifier(ptr);
		flushCell();
		return ptr;
	}

	/**
	 * ������Identifier�ǻؤ��������FMObject��FMContainer�δ������������롣
	 *
	 * @param	id	�����оݤ�FMObject��ؤ�����Identifier
	 */
	public locked void remove(Pointer ptr) {
		overseer->permit(ptr);
		String key = ptr->getName();
		elements->remove(key);
		flushCell();
	}

	void removeWithoutLock(Pointer ptr) {
		overseer->permit(ptr);
		String key = ptr->getName();
		elements->remove(key);
		flushCell();
	}

	/**
	 * ���Υ᥽�åɤǤϡ���FMContainer�δ������ˤ���FMObject��¾��FMContainer��
	 * ��ư���롣���Υ᥽�åɤǤϡ�FMObject�δ���������ν����
	 * ¾�ˡ����ΰ�ž��Ȥʤ�FMContainer��Ͽ���롣�������뤳�Ȥˤ�äơ����
	 * ¾�����ž��ؤξȲ��������Ȥ��˱����뤳�Ȥ���ǽ�Ȥʤ롣
	 *
	 * @param	oid	��ư�оݤ�FMObject��ؤ�����Identifier
	 * @param	fid	��ư���FMContainer��ؤ�����Identifier
	 */
	public locked Pointer move(Pointer oid, Pointer fid) {
// System system=>create();
// system->println("FMContainer#move(oid, fid)");
// system->println(" oid:"->concat(oid->asString()));
// system->println(" fid:"->concat(fid->asString()));
		overseer->permit(oid);
		overseer->permit(fid);
		FMObject obj = get(oid);
		if (obj == null) {
			return null;
		}
// system->println("FMContainer#mode() obj:"->concat(obj->asString()));
		removeWithoutLock(oid);
		FMContainer fed = fid->container();
		Pointer dst = fed->add(obj);
		arch->add(oid, dst);
		return dst;	
	}

	/**
	 * FMContainer�δ������ˤ���FMObject��(°������Ϣ)�򹹿����롣
	 * �����ϡ�������Ϳ����줿FMObject��update()�Υ᥽�åɤˡ������оݤ�
	 * FMObject������Ȥ��ƹ�����Ԥ碌�롣
	 * update()�Ǥϡ���������°���ο����֤������줬��1�ʾ�Ǥ���С��֥���ơפ�
	 * ����������Ͽ����Cell�ξ���򹹿����롣
	 *
	 * @param	ptr	�����оݤ�FMObject
	 * @param	obj	������Ԥ�FMObject
	 */
	public locked void commit(FMObject obj) {
		overseer->permit(obj);
//System system=>create();system->println("FMContainer#commit(FMObject):"->concat(obj->getName()));
//obj->trace(501);

		Pointer ptr = obj->getIdentifier();
//system->println("FMContainer#commit(FMObject)obj->getIdentifier:"->concat(ptr->asString()));
		FMObject value = get(ptr);
//value->trace(502);
		if (0 < (value->update(obj))) {		// ��̤�ozc�Τ����
			Karte karte = getKarte(ptr);
			karte->add();
//system->println(karte);
			flushCell();
		}
	}

	/**
	 * FMContainer���Local��Identifier��FMObject����������Ͽ�������������ʤ�
	 * FMContainer�Ǵ��������FMObject���Ф������Ǥ���֥���ơפ��֤���
	 *
	 * @param ptr	������оݤ�FMObject
	 *
	 * @return		FMObject���Ф��륫���
	 */
	public Karte getKarte(Pointer ptr) {
//System system=>create();
		overseer->permit(ptr);
//system->println("FMContainer#getKarte(Pointer)"->concat(ptr->asString()));
		String key = ptr->getName();
		Karte rtn;rtn =| elements->get(key);
		return rtn;

	}

	public void trace(int mark) {	// for DEBUG
		System system=>create();

		system->println("FMContainer#trace("
			->concat(""->valueOf(mark))->concat(")")
			->concat(" seqNumber:")->concat(""->valueOf(mark))
			->concat(" elements:")->concat(elements->asString()));

		Iterator ite = elements->assocIterator();
		Association asso;
		String key;
		Karte karte;
		FMObject obj;
		while (ite->hasMoreElements()) {
			asso =| ite->nextElement();
			key =| asso->key();
			karte =| asso->value();
			obj =| karte->getValue();
			system->println("FMContainer#trace elements key:"
				->concat(key)
				->concat(" value:")->concat(karte->asString()));
		}	

	}
}
