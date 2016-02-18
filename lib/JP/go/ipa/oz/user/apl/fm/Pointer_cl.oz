/*
 * $Id: Pointer.oz,v 1.2 1997/12/03 02:10:07 hgoto Exp $
 */

/**
 * Pointer�ϡ��ͥåȥ�����ʬ�����Ƥ��륪�֥������Ȥ�ؤ����������
 * �ݥ��󥿤Ǥ��롣����Pointer��Ȥäơ��оݤΥ��֥������Ȥ䡢
 * ���Υ��֥������Ȥ�(ʪ��Ū��)��������Ƥ���FMContainer�����뤳�Ȥ��Ǥ��롣
 * �ޤ����ؤ������Ƥ��륪�֥������Ȥ�¾��FMContainer�ذ�ư�������Ǥ⡢
 * FMContainer�δ�����Ͽ�򻲾Ȥ������פ����ݥ��󥿤���������롣
 *
 */
class Pointer : *Root {

	/**
	 * FMContainer��ؤ��������̻�(GOL)��ʸ�����ɽ���������
	 */
	String location;

	/**
	 * FMContainer��ǰ�դʥ�����μ��̻Ҥ�ʸ�����ɽ���������
	 */
	String name;

	/**
	 * Pointer���֥������Ȥκ���
	 *
	 * @param	loc	���֥������ȤΥ�������󡢤Ĥޤ�FMContainer�μ��̻�
	 * @param	nm	���֥������Ȥ�FMContainer��Υ�����ʼ��̻�
	 */
	new create(String loc, String nm) {
		location = loc;
		name = nm;
	}

	/**
	 * ���֥������Ȥ�(ʪ��Ū��)��������Ƥ���FMContainer�μ��̻Ҥ��֤���
	 *
	 * @return	���֥������Ȥ���������Ƥ���FMContainer�μ��̻Ҥ�ʸ�����
	 *			���������(GOL)
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * ���֥������Ȥ�(ʪ��Ū��)���������FMContainer�����ꤹ�롣
	 *
	 * @param	loc	FMContainer�μ��̻Ҥ�ʸ�����ɽ���������(GOL)
	 */
	public void setLocation(String loc) {
		location = loc;
	}

	/**
	 * FMContainer��Υ�����ʼ��̻Ҥ�ʸ�����ɽ��������Τ��֤���
	 *
	 * @return	FMContainer��Υ�����ʼ��̻Ҥ�ʸ�����ɽ���������
	 */
	public String getName() {
		return name;
	}

	/**
	 * FMContainer��Υ�����ʼ��̻Ҥ�ʸ��������ꤹ��
	 *
	 * @param	n	FMContainer��Υ�����ʼ��̻Ҥ�ʸ�����ɽ���������
	 */
	public void setName(String n) {
		name = n;
	}

	/**
	 * ���֥������Ȥ�(ʪ��Ū��)��������Ƥ���FMContainer���֤���
	 *
	 * @return FMContainer�Υץ���
	 */	 
	public FMContainer container() {
		FMContainer fed => bind(location);
		return fed;
	}

	/**
	 * Pointer���ؤ��������֥������Ȥ�deadcopy���֤���
	 *
	 * @return Pointer���ؤ��������֥������Ȥ�deadcopy
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
	 * ������Pointer��Ʊ������Ĵ�٤롣
	 *
	 * @param	r	Ĵ���оݤ�Pointer
	 *
	 * @return		Ʊ���Ǥ����true�򡢤����Ǥʤ����false���֤���
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

