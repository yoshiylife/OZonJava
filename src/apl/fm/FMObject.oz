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
 * FMObjectは、Facility Manageidentifiernt Systemでの管理対象である
 *「リソース」を表すオブジェクトである。
 */
 
class FMObject : *Root {
	protected Pointer identifier;
	protected String name;
	protected Set relations;
	protected RelationComparator rc;

	/**
	 * FMObjectの生成
	 */
	new create() {
		rc=>create();
		relations => create(rc);
		name => breed("UnKnown");
	}

	/**
	 * 当FMObjectを指し示すためのポインタを設定する。
	 *
	 * @param	ptr	設定するポインタ
	 */
	public locked void setIdentifier(Pointer ptr) {
		identifier = ptr;
	}
	void setIdentifierWithoutLock(Pointer ptr) {
		identifier = ptr;
	}

	/**
	 * 当FMObjectを指し示すためのポインタを返す。
	 *
	 * @return	当FMObjectを指し示すためのポインタ
	 */
	public Pointer getIdentifier() {
		return identifier;
	}

	/**
	 * 当FMObjectが(物理的に)管理されているFMContainer(Cell)
	 * (へのプロキシ)を返す。
	 *
	 * @return	当FMObjectが管理されているFMContainerへのプロキシ
	 */

	public FMContainer federation() {
		return (identifier != null) ? identifier->container() : null;
	}

	/**
	 * 当FMObjectが(論理的に)管理されているPool
	 * (へのポインタ)を返す。
	 *
	 * @return	当FMObjectが管理されているPoolへのポインタ
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
	 * 当FMObjectの属性の変更をFMContainerで管理されているFMObjectの実体に
	 * 反映する。
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
	 * 引数の(FMContainer内部で管理されている)FMObjectの実体に対し、
	 * 属性値の更新を行う。ここでは、実体と属性値個々を比較し、
	 * 異なるものだけを更新する。属性を実際に更新した場合に限って
	 * FMObjectの値(実際にはFMContainer全体)をストレージへ書き出す。
	 * ただし、このストレージへの書き出しは、FMContainerによって
	 * 行う。
	 *
	 * @param	obj	更新を行うオブジェクト
	 *
	 * @return		更新数
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
			if (0 < (list->size())) { // 追加
				Iterator iter = list->iterator();
				while (iter->hasMoreElements()) {
					Relation r;r =| iter->nextElement();
					addWithoutLock(r);
					counter++;
				}
			}

			list = relations->difference(obj->getAllRelations());
			if (0 < (list->size())) { // 削除
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
	 * FMObjectの名称を設定する。
	 *
	 * @param	n	FMObject名称
	 */
	public locked void setName(String n) {
		name = n;
	}
	void setNameWithoutLock(String n) {
		name = n;
	}
	/**
	 * FMObjectの名称を返す。
	 *
	 * @return	FMObjectの名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 関連(SLOT)を追加する。すでに同じ関連が登録されている場合には、
	 * 登録を行わない。(同じ関連は、Relation#isEqualRelation()で調べる。)
	 *
	 * @param	r	追加する関連
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
	 * 関連(SLOT)を除去する。ただし、ここでは関連のリストから引数で示された
	 * 関連を除去するだけであり、実際の関連の削除や関連先のdetach()は別に
	 * 行う必要がある。
	 *
	 * @param	r	除去する関連
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
	 * 引数で指定された関連と同等の関連をFMObjectの管理下から返す。
	 *
	 * @param	rel	対象の関連
	 *
	 * @return		対象の関連と同等のもの
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
	 * 現在有効な関連だけからなる関連のリストを返す。
	 *
	 * @return	関連のリスト
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
	 * 無効状態の関連を含めすべての関連からなるリストを返す。
	 *
	 * @return		すべての関連のリスト
	 */
	public Set getAllRelations() {
		return relations;
	}

	 
	/**
	 * 指定された関連名称に合致した関連を複数抽出する。
	 *
	 * @param	s	関連名称
	 *
	 * @return		名称に合致した関連のリスト
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
	 * 指定された関連先を持つ複数の関連を抽出する。
	 * 抽出された関連は、それぞれ関連名称が異なる。
	 *
	 * @param	ptr	対象の関連先
	 *
	 * @return		合致した関連のリスト
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
	 * Set にgetComparatorがないため 
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
 * FMにおけるRelationに関する機能を簡単に利用できるように
 * するためのサービス
 */
	/*
	 * 自分自身と指定されたFMObjectとのあいだにRelationを作る
	 *
	 * @param	relName		関係の名前
	 *		destObj		関係を張る対象のオブジェクト
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
	 * 指定された関係の先にあるFMObjectを取得する
	 *
	 * @param	relName		FMObjectを取得したい関係の名前
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
	 * 現在、自身の保持しているすべての関係の名前のリストを取得する
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
 * 追加メソッド
 *
 */
	/*
	 * 引数に該当する全ての関連の先にあるオブジェクトを取得する
	 *
	 * @param	relName		指定する関連名
	 * @return	Set		FMObjectの集合
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
	 * 既に存在するRelationを他のFMObjectに対して張りかえる。
	 *
	 * @param	rel		既存のRelation
	 * 		destObj		Relation対象のFMObject
	 * @return	Relation	新しくなったRelation
	 */
	public Relation createRelation(Relation rel, FMObject destObj) {
		rel->detach();
		rel->setDestination(destObj->getIdentifier());
		rel->attach(destObj->getIdentifier());

		return rel;
	}

	/*
	 * FMObjectの消去
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
	 * LocalなFMContainer内での、FMObjectのコピー
	 * 基本的にFMObjectのサブクラスで再定義する。
	 */
	public FMObject cloneSelf() {
		FMObject clone;
		clone=>create(name, relations, identifier);
		return clone;
	}

	/*
	 * clone用のコンストラクタ
	 * 各アトリビュートの実体を複製するが、identifierは新規
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
