/*
 * $Id: Pointer.oz,v 1.2 1997/12/03 02:10:07 hgoto Exp $
 */

/**
 * Pointerは、ネットワーク上に分散しているオブジェクトを指し示すための
 * ポインタである。このPointerを使って、対象のオブジェクトや、
 * そのオブジェクトが(物理的に)管理されているFMContainerを得ることができる。
 * また、指し示しているオブジェクトが他のFMContainerへ異動した場合でも、
 * FMContainerの管理記録を参照して追跡し、ポインタが更新される。
 *
 */
class Pointer : *Root {

	/**
	 * FMContainerを指し示す識別子(GOL)を文字列で表現したもの
	 */
	String location;

	/**
	 * FMContainer内で一意なローカルの識別子を文字列で表現したもの
	 */
	String name;

	/**
	 * Pointerオブジェクトの作成
	 *
	 * @param	loc	オブジェクトのロケーション、つまりFMContainerの識別子
	 * @param	nm	オブジェクトのFMContainer内のローカルな識別子
	 */
	new create(String loc, String nm) {
		location = loc;
		name = nm;
	}

	/**
	 * オブジェクトが(物理的に)管理されているFMContainerの識別子を返す。
	 *
	 * @return	オブジェクトが管理されているFMContainerの識別子を文字列で
	 *			示したもの(GOL)
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * オブジェクトが(物理的に)管理されるFMContainerを設定する。
	 *
	 * @param	loc	FMContainerの識別子を文字列で表現したもの(GOL)
	 */
	public void setLocation(String loc) {
		location = loc;
	}

	/**
	 * FMContainer内のローカルな識別子を文字列で表現したものを返す。
	 *
	 * @return	FMContainer内のローカルな識別子を文字列で表現したもの
	 */
	public String getName() {
		return name;
	}

	/**
	 * FMContainer内のローカルな識別子を文字列で設定する
	 *
	 * @param	n	FMContainer内のローカルな識別子を文字列で表現したもの
	 */
	public void setName(String n) {
		name = n;
	}

	/**
	 * オブジェクトが(物理的に)管理されているFMContainerを返す。
	 *
	 * @return FMContainerのプロキシ
	 */	 
	public FMContainer container() {
		FMContainer fed => bind(location);
		return fed;
	}

	/**
	 * Pointerが指し示すオブジェクトのdeadcopyを返す。
	 *
	 * @return Pointerが指し示すオブジェクトのdeadcopy
	 */
	public FMObject stuff() {
//System system=>create();
//system->println("Pointer#stuff()");
		FMObject rtn;
		FMContainer fed;
		Overseer overseer=>create();
		while ((fed = container()) != null) {
			if (fed->contains(this)) {
				rtn = fed->get(this);
				overseer->permit(rtn);
//system->println("Pointer#stuff()return "->concat(rtn->asString()));
				return rtn;
			}	
			Pointer newPtr = fed->find(this);
			if (newPtr == null)
				break;
			overseer->permit(newPtr);
			location = newPtr->getLocation();
			name = newPtr->getName();
		}
//system->println("Pointer#stuff()return null");
		return null;
	}

	/**
	 * 引数のPointerと同等かを調べる。
	 *
	 * @param	r	調査対象のPointer
	 *
	 * @return		同等であればtrueを、そうでなければfalseを返す。
	 */
	public bool isEqualPointer(Pointer ptr) {
		if (ptr == null) return false;
		return (location->isequal(ptr->getLocation())
			 && name->isequal(ptr->getName()));
	}



	public String asString() {
		StringBuffer rtn=>breed("[location=");
		rtn->append(location);
		rtn->append(", name=");
		rtn->append(name);
		rtn->append("]");
		return rtn->asString();	
	}

	public void toGreen() {
		Overseer overseer=>create();
		overseer->permit(location);
		overseer->permit(name);
	}

}

