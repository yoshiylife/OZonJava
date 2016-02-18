/*
 * $Id: FMContainer.oz,v 1.2 1998/02/02 03:40:08 hgoto Exp $
 */
/**
 * FMContainerは、複数のFMObjectを管理するための(グローバルな)オブジェクトであり、
 * 管理対象のFMObjectの異動の記録をとる。
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
	 * FMContainer内にPointerで指し示されるFMObjectが存在するかを応える。
	 *
	 * @param	ptr	対象のFMObject
	 *
	 * @return		存在する場合にはtrue、ない場合には false
	 */
	public bool contains(Pointer ptr) {
		overseer->permit(ptr);
		String key = ptr->getName();
		return elements->containsKey(key);
	}

	/**
	 * FMContainerから、Pointerで指し示されるFMObjectを取得(dead copy)する。
	 *
	 * @param ptr	取得するFMObjectを指し示すIdentifier
	 *
	 * @return		Pointerで指し示されるFMObject(のdead copy)
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
	 * 以前、当FMContainerの管理下にあったFMObjectの移転先(のFMContainer)を
	 * 応える。
	 *
	 * @param	ptr	対象FMObjectの旧Identifier
	 *
	 * @return	移転先のFMContainerを指し示すIdentifier
	 */
	public Pointer find(Pointer ptr) {
		overseer->permit(ptr);
		return arch->find(ptr);
	}
	
 
	/**
	* 引数のFMObjectと同等なFMObjectを指し示すIdentifierを返す。
	* FMObjectの等価性はメソッドequals()によって調べる。
	*
	* @param	obj	Identifierの対象のFMObjectと同等なFMObject
	*
	* @return		引数のFMObjectと同等なFMObjectを指し示すIdentifier
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
	 * FMContainerに新たにFMObjectを登録する。この時に、FMObjectに対して 
	 * FMContainer内部のIdentifier、FMObject自身、そしてFMObjectの登録、
	 * 変更に関する記録が記述される「カルテ」が作成される。FMContainerでは、
	 * 直接FMObjectを管理するのではなく、このカルテを介して管理することになる。
	 * また、このメソッド add()の返値として、登録されたFMObjectをアクセスする
	 * ための IdentifierであるPointerが返される。
	 *
	 * @param obj	登録対象のFMObject
	 *
	 * @return 		登録したFMObjctを指し示すIdentifier
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
	 * 引数のIdentifierで指し示されるFMObjectをFMContainerの管理下から除去する。
	 *
	 * @param	id	除去対象のFMObjectを指し示すIdentifier
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
	 * このメソッドでは、当FMContainerの管理下にあるFMObjectを、他のFMContainerへ
	 * 移動する。このメソッドでは、FMObjectの管理下からの除去の
	 * 他に、その移転先となるFMContainerを記録する。こうすることによって、後に
	 * 他から移転先への照会を受けたときに応えることが可能となる。
	 *
	 * @param	oid	移動対象のFMObjectを指し示すIdentifier
	 * @param	fid	移動先のFMContainerを指し示すIdentifier
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
	 * FMContainerの管理下にあるFMObject値(属性、関連)を更新する。
	 * 更新は、引数で与えられたFMObjectのupdate()のメソッドに、更新対象の
	 * FMObjectを引数として更新を行わせる。
	 * update()では、更新した属性の数を返す。これが、1以上であれば、「カルテ」に
	 * 更新日時を記録し、Cellの情報を更新する。
	 *
	 * @param	ptr	更新対象のFMObject
	 * @param	obj	更新を行うFMObject
	 */
	public locked void commit(FMObject obj) {
		overseer->permit(obj);
//System system=>create();system->println("FMContainer#commit(FMObject):"->concat(obj->getName()));
//obj->trace(501);

		Pointer ptr = obj->getIdentifier();
//system->println("FMContainer#commit(FMObject)obj->getIdentifier:"->concat(ptr->asString()));
		FMObject value = get(ptr);
//value->trace(502);
		if (0 < (value->update(obj))) {		// 括弧はozcのために
			Karte karte = getKarte(ptr);
			karte->add();
//system->println(karte);
			flushCell();
		}
	}

	/**
	 * FMContainer内のLocalなIdentifier、FMObject、そして登録、更新日時よりなる
	 * FMContainerで管理されるFMObjectに対する情報である「カルテ」を返す。
	 *
	 * @param ptr	カルテ対象のFMObject
	 *
	 * @return		FMObjectに対するカルテ
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
