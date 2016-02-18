/*
 Copyright(c) 1996-1998
 IPA, ETL, AT21, FSIABC, FXIS, InArc, MRI, NUL, SBC, Sharp, TEC, TIS

 All rights reserved.  No guarantee.
 This technology is a result of the Advanced Software  Enrichment 
 Project of Information-technology Promotion Agency, Japan (IPA).

 Permissions  to  use,  copy, modify and distribute this software
 are governed by the terms and conditions set forth in  the  file 
 COPYRIGHT, located on the top directory of this software.
 */

/*
 * $Id: FMObject.oz,v 1.3 1998/02/02 03:40:08 hgoto Exp $
 */
/**
 * FMObject�ϡ�Facility Manageidentifiernt System�Ǥδ����оݤǤ���
 *�֥꥽�����פ�ɽ�����֥������ȤǤ��롣
 */
 
class FMObject : *Root {
	protected Pointer identifier;
	protected String name;
	protected Set relations;
	protected RelationComparator rc;

	/**
	 * FMObject������
	 */
	new create() {
		rc=>create();
		relations => create(rc);
		name => breed("UnKnown");
	}

	/**
	 * ��FMObject��ؤ���������Υݥ��󥿤����ꤹ�롣
	 *
	 * @param	ptr	���ꤹ��ݥ���
	 */
	public locked void setIdentifier(Pointer ptr) {
		identifier = ptr;
	}
	void setIdentifierWithoutLock(Pointer ptr) {
		identifier = ptr;
	}

	/**
	 * ��FMObject��ؤ���������Υݥ��󥿤��֤���
	 *
	 * @return	��FMObject��ؤ���������Υݥ���
	 */
	public Pointer getIdentifier() {
		return identifier;
	}

	/**
	 * ��FMObject��(ʪ��Ū��)��������Ƥ���FMContainer(Cell)
	 * (�ؤΥץ���)���֤���
	 *
	 * @return	��FMObject����������Ƥ���FMContainer�ؤΥץ���
	 */

	public FMContainer federation() {
		return (identifier != null) ? identifier->container() : null;
	}

	/**
	 * ��FMObject��(����Ū��)��������Ƥ���Pool
	 * (�ؤΥݥ���)���֤���
	 *
	 * @return	��FMObject����������Ƥ���Pool�ؤΥݥ���
	 */
	public Pointer container() {
		SList list = findRelations("Pool");
		FMObject obj;
		Pointer rtn;
		if (list->size() == 1) {
			obj =| list->first();
			rtn = obj->getIdentifier();
		} else {
			rtn = null;
		}
		return rtn;
	}

	/**
	 * ��FMObject��°�����ѹ���FMContainer�Ǵ�������Ƥ���FMObject�μ��Τ�
	 * ȿ�Ǥ��롣
	 *
	 */
	public locked void commit() {
//System system=>create();
//system->println("FMObject#commit()"->concat(this->asString()));
		String gol;
		gol = identifier->getLocation();
		FMContainer fed =>bind(gol);
		if (fed != null) {
			fed->commit(this);
		}
//system->println("commit end");
	}

	/**
	 * ������(FMContainer�����Ǵ�������Ƥ���)FMObject�μ��Τ��Ф���
	 * °���ͤι�����Ԥ��������Ǥϡ����Τ�°���͸ġ�����Ӥ���
	 * �ۤʤ��Τ����򹹿����롣°����ºݤ˹����������˸¤ä�
	 * FMObject����(�ºݤˤ�FMContainer����)�򥹥ȥ졼���ؽ񤭽Ф���
	 * �����������Υ��ȥ졼���ؤν񤭽Ф��ϡ�FMContainer�ˤ�ä�
	 * �Ԥ���
	 *
	 * @param	obj	������Ԥ����֥�������
	 *
	 * @return		������
	 */
	 public locked int update(FMObject obj) {
		return updateWithoutLock(obj);
	 }
	 protected int updateWithoutLock(FMObject obj) {
//System system=>create();
//system->println("FMObject#update(obj)");
//system->println(" this:");this->trace(300);
//Iterator dbi = this->getAllRelations()->iterator();
//while (dbi->hasMoreElements()) {
//	Relation dbr;dbr =| dbi->nextElement(); 
//	system->println(dbr->asString());
//}
//system->println("----");
//system->println(" obj:");obj->trace(301);
//dbi = obj->getAllRelations()->iterator();
//while (dbi->hasMoreElements()) {
//	Relation dbr;dbr =| dbi->nextElement(); 
//	system->println(dbr->asString());
//}
//system->println("----");


		int counter = 0;
		
		if (identifier != null && (identifier->isEqualPointer(obj->getIdentifier()) != true)) {
			setIdentifierWithoutLock(obj->getIdentifier());
			counter++;
		}
		if (name != null && (name->isequal(obj->getName()) != true)) {
			setNameWithoutLock(obj->getName());
			counter++;
		}
			
		if (relations != null) {
			Set list = obj->getAllRelations()->difference(relations);
			if (0 < (list->size())) { // �ɲ�
				Iterator iter = list->iterator();
				while (iter->hasMoreElements()) {
					Relation r;r =| iter->nextElement();
					addWithoutLock(r);
					counter++;
				}
			}

			list = relations->difference(obj->getAllRelations());
			if (0 < (list->size())) { // ���
				Iterator iter = list->iterator();
				while (iter->hasMoreElements()) {
					Relation r;r =| iter->nextElement();
					removeWithoutLock(r);
					counter++;
				}
			}
		}
//system->println("FMObject#update return:"->concat(""->valueOf(counter)));
		return counter;
	}

	/**
	 * FMObject��̾�Τ����ꤹ�롣
	 *
	 * @param	n	FMObject̾��
	 */
	public locked void setName(String n) {
		name = n;
	}
	void setNameWithoutLock(String n) {
		name = n;
	}
	/**
	 * FMObject��̾�Τ��֤���
	 *
	 * @return	FMObject��̾��
	 */
	public String getName() {
		return name;
	}

	/**
	 * ��Ϣ(SLOT)���ɲä��롣���Ǥ�Ʊ����Ϣ����Ͽ����Ƥ�����ˤϡ�
	 * ��Ͽ��Ԥ�ʤ���(Ʊ����Ϣ�ϡ�Relation#isEqualRelation()��Ĵ�٤롣)
	 *
	 * @param	r	�ɲä����Ϣ
	 */
	public locked void add(Relation r) {
//System system=>create();
//system->println("FMObject#add(Relation):"->concat(r->asString()));

		if (relations->contains(r) != true) {
			relations->add(r);
		}
	}

	void addWithoutLock(Relation r) {
//System system=>create();
//system->println("FMObject#addWoL(Relation):"->concat(r->asString()));

		if (relations->contains(r) != true) {
			relations->add(r);
		}
	}

	/**
	 * ��Ϣ(SLOT)�����롣�������������Ǥϴ�Ϣ�Υꥹ�Ȥ�������Ǽ����줿
	 * ��Ϣ����������Ǥ��ꡢ�ºݤδ�Ϣ�κ�����Ϣ���detach()���̤�
	 * �Ԥ�ɬ�פ����롣
	 *
	 * @param	r	������Ϣ
	 */
	public locked void remove(Relation r) {
//System system=>create();
//system->println("FMObject#remove(Relation):"->concat(r->asString()));
		if (relations->contains(r) == true) { // for avoid dead-lock
			relations->remove(r);
			r->delete();
		}
	}

	void removeWithoutLock(Relation r) {
//System system=>create();
//system->println("FMObject#removeWoL(Relation):"->concat(r->asString()));
		if (relations->contains(r) == true) { // for avoid dead-lock
			relations->remove(r);
			r->delete();
		}
//system->println("FMObject#removeWoL(Relation) END");
	}

	/**
	 * �����ǻ��ꤵ�줿��Ϣ��Ʊ���δ�Ϣ��FMObject�δ����������֤���
	 *
	 * @param	rel	�оݤδ�Ϣ
	 *
	 * @return		�оݤδ�Ϣ��Ʊ���Τ��
	 */
	public Relation getRelation(Relation rel) {
		Iterator iter = relations->iterator();
		while (iter->hasMoreElements()) {
			Relation r;r =| iter->nextElement();
			if (rel->isEqualRelation(r))
				return r;
		}
		return null;
	}

	/**
	 * ����ͭ���ʴ�Ϣ��������ʤ��Ϣ�Υꥹ�Ȥ��֤���
	 *
	 * @return	��Ϣ�Υꥹ��
	 */
	public Set getRelations() {
		RelationComparator rc=>create();
		Set list=>create(rc);
		Iterator iter = relations->iterator();
		while (iter->hasMoreElements()) {
			Relation r;r =| iter->nextElement();
			if (r->isAvailable())
				list->add(r);
		}
		return list;
	}

	/**
	 * ̵�����֤δ�Ϣ��ޤ᤹�٤Ƥδ�Ϣ����ʤ�ꥹ�Ȥ��֤���
	 *
	 * @return		���٤Ƥδ�Ϣ�Υꥹ��
	 */
	public Set getAllRelations() {
		return relations;
	}

	 
	/**
	 * ���ꤵ�줿��Ϣ̾�Τ˹��פ�����Ϣ��ʣ����Ф��롣
	 *
	 * @param	s	��Ϣ̾��
	 *
	 * @return		̾�Τ˹��פ�����Ϣ�Υꥹ��
	 */
	public SList findRelations(String s) {
		RelationComparator rc=>create();
		SList list=>create(rc);
		Iterator iter = relations->iterator();
		while (iter->hasMoreElements()) {
			Relation r;r =| iter->nextElement();
			if (r->isEqualRelation(s)) {
				list->pushBack(r);
			}
		}
		return list;
	}

	/**
	 * ���ꤵ�줿��Ϣ������ʣ���δ�Ϣ����Ф��롣
	 * ��Ф��줿��Ϣ�ϡ����줾���Ϣ̾�Τ��ۤʤ롣
	 *
	 * @param	ptr	�оݤδ�Ϣ��
	 *
	 * @return		���פ�����Ϣ�Υꥹ��
	 */
	public SList findRelations(Pointer ptr) {
		RelationComparator rc=>create();
		SList list=>create(rc);
		Iterator iter = relations->iterator();
		while (iter->hasMoreElements()) {
			Relation rel;rel =| iter->nextElement();
			if (ptr->isEqualPointer(rel->destination())) {
				list->pushBack(rel);
			}
		}
		return list;
	}


	/*
	 * Set ��getComparator���ʤ����� 
	 */
	public RelationComparator getRelationComparator() {
		return rc;
	}
	


	public String asString() {
		return "["->concat(name)->concat("]")
			->concat(" identifier:")
			->concat(identifier!=null?identifier->getName():"null");
	}


	public void toGreen() {
		Overseer overseer=>create();
		overseer->permit(identifier);
		overseer->permit(name);
		overseer->permit(relations);
		Iterator iter = relations->iterator();
		while (iter->hasMoreElements()) {
			Relation r;r =| iter->nextElement();
			overseer->permit(r);
		}
		overseer->permit(rc);
	}

/*
 * FM�ˤ�����Relation�˴ؤ��뵡ǽ���ñ�����ѤǤ���褦��
 * ���뤿��Υ����ӥ�
 */
	/*
	 * ��ʬ���ȤȻ��ꤵ�줿FMObject�ȤΤ�������Relation����
	 *
	 * @param	relName		�ط���̾��
	 *		destObj		�ط���ĥ���оݤΥ��֥�������
	 */
	public Relation createRelation(String relName,FMObject destObj) {
		Relation rel=>create();
		Overseer over=>create();
		Pointer point;

		over->permit(relName);
		over->permit(destObj);
		point = destObj->getIdentifier();

		System sys=>create();sys->println(destObj->asString());
		sys->println(point->asString());


		rel->setName(relName);
		sys->println("Set Name");
		rel->setSource(identifier);
		sys->println("Set Source");
		rel->setDestination(point);
		sys->println("Set Destination");
		add(rel);
		sys->println("Add Relation");
		rel->attach(point);
		sys->println("Attach Relation");
		return rel;
	}

	/*
	 * ���ꤵ�줿�ط�����ˤ���FMObject���������
	 *
	 * @param	relName		FMObject������������ط���̾��
	 */
	public FMObject getRelatedObject(String relName) {
		SList relList = findRelations(relName);

		if (relList->size() != 0) {
			Relation rel;rel =| relList->first();
			return rel->get();
		}

		return null;
	}

	/*
	 * ���ߡ����Ȥ��ݻ����Ƥ��뤹�٤Ƥδط���̾���Υꥹ�Ȥ��������
	 */
	public Set getAllRelationName() {
//System system=>create();
//system->println("FMObject#getAllRelationName:START");
		Set list = getAllRelations();
		StringComparator sc=>create();
		Set result => create(sc);
		Iterator iter = list->iterator();

		while(iter->hasMoreElements()) {
			Relation rel;rel =| iter->nextElement();
			result->add(rel->getName());
		}
//system->println("FMObject#getAllRelationName:END");
		return result;
	}

/*
 * �ɲå᥽�å�
 *
 */
	/*
	 * �����˳����������Ƥδ�Ϣ����ˤ��륪�֥������Ȥ��������
	 *
	 * @param	relName		���ꤹ���Ϣ̾
	 * @return	Set		FMObject�ν���
	 */
	public Set getRelatedObjects(String relName) {
		Set result;
		SList relList;
		Iterator iter;

		result=>create();
		relList = findRelations(relName);

		iter = relList->iterator();
		while(iter->hasMoreElements()) {
			Relation rel;
			rel =| iter->nextElement();
			if (rel->isAvailable()) {
				FMObject obj;
				obj = rel->get();
				if (obj != null) {
					result->add(obj);
				}
			}
		}

		return result;
	}

	/*
	 * ����¸�ߤ���Relation��¾��FMObject���Ф���ĥ�꤫���롣
	 *
	 * @param	rel		��¸��Relation
	 * 		destObj		Relation�оݤ�FMObject
	 * @return	Relation	�������ʤä�Relation
	 */
	public Relation createRelation(Relation rel, FMObject destObj) {
		rel->detach();
		rel->setDestination(destObj->getIdentifier());
		rel->attach(destObj->getIdentifier());

		return rel;
	}

	/*
	 * FMObject�ξõ�
	 */
	public void delete() {
		FMContainer fed;
		Iterator iter;

		fed = federation();
		iter = relations->iterator();
		while(iter->hasMoreElements()) {
			Relation rel;
			rel =| iter->nextElement();
			rel->delete();
		}

		fed->remove(identifier);
	}

	/*
	 * Local��FMContainer��ǤΡ�FMObject�Υ��ԡ�
	 * ����Ū��FMObject�Υ��֥��饹�Ǻ�������롣
	 */
	public FMObject cloneSelf() {
		FMObject clone;
		clone=>create(name, relations, identifier);
		return clone;
	}

	/*
	 * clone�ѤΥ��󥹥ȥ饯��
	 * �ƥ��ȥ�ӥ塼�Ȥμ��Τ�ʣ�����뤬��identifier�Ͽ���
	 */
	new create(String oname, Set orelations, Pointer oid) {
		Overseer overseer=>create();

		/* copy name */
		name=>breed(oname);

		/* create new relations */
		rc=>create();
		relations=>create(rc);

		if (oid == null) {
			return;	
		}
		/* get new identifier  */
		FMContainer fed;
		fed = oid->container();
		identifier = fed->add(this);
		overseer->permit(identifier);
		
		/* copy relations with new identifier */
		Iterator iter;
		iter = orelations->iterator();
		while(iter->hasMoreElements()) {
			Relation orel;
			Relation rel;
			orel =| iter->nextElement();
			rel = orel->cloneRelation();
			rel->setSource(identifier);
			add(rel);
		}
		commit();
	}

	public bool isEqualFMObject(FMObject obj) {
		String oname;
		if (obj == null) return false;
		oname = obj->getName();
		if (name == null || oname == null) {
			return (name == null && oname == null);
		}
		return name->isequal(oname);
	}

	public void trace(int mark) {	// for DEBUG
		System system=>create();
		system->println("FMObject#trace("->concat(""->valueOf(mark))
			->concat(")")
			->concat(" Thread:")->concat(runningIsGreen()?"G":"R")
			->concat(" this:")->concat(this->isGreen()?"G":"R")
			->concat(" name:")->concat(name->isGreen()?"G":"R")
			->concat("(")->concat(name)->concat(")")
			->concat(" relations:")->concat(relations->isGreen()?"G":"R")
			->concat("(")->concat(relations->asString())->concat(")")
			->concat(" identifier:")
			->concat(identifier!=null
				?(identifier->isGreen()?"G":"R")
					->concat(identifier->asString())
				:"null"));
	}
}
