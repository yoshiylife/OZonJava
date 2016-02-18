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
 * $Id: ExGOL.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 *
 * ���: ���Υե������ vi �ǡ�hardtab=8, tabstop=4 �Ȥ����Խ�����Ƥ���
 */

package JP.go.ipa.oz.system;

/**
 * �����Х륪�֥������ȥ���������GOL�ˤ��갷������Υ��饹�Ǥ��롣
 * ���Υ��饹��Ȥä��������줿���֥������Ȥϡ���˷����Ȥ���
 * ������ GOL ����������Υ��֥������Ȥ����� GOL �����ѤǤ��롣
 * �����������Υ��֥������ȤϾ���������Υ��������塼����ˤ���Ȥϸ¤�ʤ���
 * �ޤ���GOL ���б����륻��ʥ����Х륪�֥������ȡˤ�¸�ߤȤ�̵�ط��Ǥ��롣
 * �����Х륪�֥������ȥ���������GOL�ˤ�OZ�ۡ���̾��
 * �����Х륪�֥������ȥǥ��쥯�ȥ��GOD��̾��':'��Ϣ�뤷��ʸ����Ǥ��롣
 *
 * <DL><DT>
 * ����ա�<DD>
 * OZ�ۡ���̾�η�����':'���ڤ��ʸ����Ǥ��롣
 * </DL>
 *
 * @see	ExGOD
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author		Yoichi Hamazaki
 * @author		Yasumitsu Yoshida
 */
class ExGOL
extends OzSecure
{
	/**
	 * ���������塼�������ΥǥХå���
	 */
	static final String CN = "ExGOL";

	/**
	 * OZ�ۡ���̾
	 */
	static final String ozHomeName = System.getProperty("oz.home.name");

	/**
	 * OZ�ۡ���̾��GOD̾�ζ��ڤ�ʸ��
	 * â�����ص���Τ����ʸ����ȤʤäƤ��롣
	 */
	static final String homeSeparator = ":";

	/**
	 * �����Х륪�֥������ȥ��������(GOL)��OZ�ۡ���̾(home)��ʬ���ݻ����롣
	 */
	private String home;

	/**
	 * �����Х륪�֥������ȥ��������(GOL)��
	 * �����Х륪�֥������ȥǥ��쥯�ȥ�̾(GOD)��ʬ���ݻ����롣
	 */
	private String god;

	/**
	 * OZ�ۡ���̾��GOD̾��Ŭ�ڤʷ����Ǥ��뤫��Ĵ�٤롣
	 *
	 * @param	home	OZ�ۡ���̾
	 * @param	god		GOD̾
	 * @exception	ExGOLFormatException
	 *					GOL(GOD)�η������������ʤ���
	 */
	static void check(String home, String god)
	throws ExGOLFormatException
	{
		if (home != null) {
			int first = home.indexOf(homeSeparator);
			int last = home.lastIndexOf(homeSeparator);
			if (first < 0 || last < 0) {
				throw new ExGOLFormatException(
							"Not include oz home name separator '"+homeSeparator+"'");
			} else if (first != last) {
				throw new ExGOLFormatException(
							"Too many include oz home name separator '"+homeSeparator+"'");
			}
		}
		if (god != null) {
			ExGOD.check(god);
			if (0 <= god.indexOf(homeSeparator)) {
				throw new ExGOLFormatException(
							"GOD include oz home name separator '"+homeSeparator+"'");
			}
		}
	}

	/**
	 * ���Υ��֥������Ȥν�������Ԥ�
	 *
	 * @param	home	OZ�ۡ���̾
	 * @param	god		GOD̾
	 * @exception	ExGOLFormatException
	 *					OZ�ۡ���̾�����뤤�ϡ�GOD̾�η������������ʤ���
	 */
	private
	void init(String home, String god)
	throws ExGOLFormatException
	{
		check(home,god);
		this.home = home;
		this.god = god;
	}

	/**
	 * �����Х륪�֥������ȥ���������GOL�ˡ�
	 * ���뤤�ϡ������Х륪�֥������ȥǥ��쥯�ȥ��GOD��̾��
	 * ���ꤷ�ƥ��֥������Ȥ�������롣
	 *
	 * @param	gol		�����Х륪�֥������ȥ��������
	 * @exception	ExGOLFormatException
	 *					GOL(GOD)�η������������ʤ���
	 */
	ExGOL(String gol)
	throws ExGOLFormatException
	{
		int last = gol.lastIndexOf(homeSeparator);
		String god;
		String home;
		if (0 <= last) {
			god = gol.substring(last+1);
			home = gol.substring(0,last);
		} else {
			god = gol;
			home = ozHomeName;
		}
		init(home,god);
	}

	/**
	 * OZ�ۡ���̾�ȥ����Х륪�֥������ȥǥ��쥯�ȥ��GOD��̾��
	 * ���ꤷ�ƥ��֥������Ȥ�������롣
	 *
	 * @param	home	OZ�ۡ���̾
	 * @param	god		GOD̾
	 * @exception	ExGOLFormatException
	 *					GOL(GOD)�η������������ʤ���
	 */
	ExGOL(String home, String god)
	throws ExGOLFormatException
	{
		init(home,god);
	}

	/**
	 * GOD���֥������Ȥ���ꤷ�ƥ��֥������Ȥ�������롣
	 *
	 * @param	god	GOD���֥�������
	 * @exception	ExGOLFormatException
	 *					GOD�η������������ʤ���
	 */
	ExGOL(ExGOD god)
	throws ExGOLFormatException
	{
		init(ozHomeName,god.getName());
	}

	/**
	 * ��ʬ��Ʊ��GOL����Ĥ���Ĵ�٤롣
	 *
	 * @param	obj	����оݤΥ��֥�������
	 * @return	GOL �����פ���С�true ���֤���
	 */
	public
	boolean equals(Object obj)
	{
		if (obj != null) {
			String gol;
			if (obj instanceof ExGOL) {
				gol = ((ExGOL)obj).getName();
			} else if (obj instanceof String) {
				gol = (String)obj;
			} else {
				gol = obj.toString();
			}
			return gol.equals(getName());
		}
		return false;
	}

	/**
	 * OZ�ۡ���̾������ư��Ƥ��륨�������塼����OZ�ۡ���̾��
	 * ���פ�����Ĵ�٤롣
	 *
	 * @return	OZ�ۡ���̾��Ʊ���ʤ�� true ���֤���
	 */
	boolean inside()
	{
		return home.equals(ozHomeName);
	}

	/**
	 * OZ�ۡ���̾��ɽ��ʸ������֤���
	 *
	 * @return	OZ�ۡ���̾
	 */
	String getHome()
	{
		return home;
	}

	/**
	 * GOL���������������塼����ư��Ƥ���OZ�ۡ������
	 * ����ʥ����Х륪�֥������ȡˤ򼨤��Ƥ�����ˡ�
	 * GOD̾���֤���
	 *
	 * @return	GOD̾
	 * @exception	ExCellIllegalOzHomeException
	 *					OZ�ۡ���̾���ۤʤ�Τǰ�̣���ʤ���
	 */
	String getGOD()
	throws ExCellIllegalOzHomeException
	{
		if (!inside()) {
			throw new ExCellIllegalOzHomeException(home+" is outside of "+ozHomeName);
		}
		return god;
	}

	/**
	 * GOL��ɽ��ʸ������֤���
	 *
	 * @return	GOL
	 */
	String getName()
	{
		return home+homeSeparator+god;
	}

	/**
	 * GOL���֥������ȼ��ȤΥϥå����ͤϰ�̣���ʤ���
	 * GOL��ɽ��ʸ����Υϥå����ͤ��֤���
	 *
	 * @return		�ϥå�����
	 */
	public
	int hashCode()
	{
		return getName().hashCode();
	}

	/**
	 * �ǥե���Ȥ�ɽ�����Ƥ� home �� god ��ä���
	 * ɽ���Τ����ʸ������֤���
	 */
	public
	String toString()
	{
		String cn = getClass().getName();
		if (cn.startsWith(Executor.IPAoz)) {
			cn = cn.substring(Executor.IPAoz.length(),cn.length());
		}
		return cn+"@"+Integer.toHexString(hashCode())
				+"[home="+home+",god="+god+"]";
	}
}
