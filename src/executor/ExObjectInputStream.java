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
 * $Id: ExObjectInputStream.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 *
 * ���: ���Υե������ vi �ǡ�hardtab=8, tabstop=4 �Ȥ����Խ�����Ƥ���
 */

package	JP.go.ipa.oz.system;

import	java.io.InputStream;
import	java.io.ObjectInputStream;
import	java.io.ObjectStreamClass;
import	java.io.IOException;
import	java.io.StreamCorruptedException;

/**
 * Serialize���줿���֥������Ȥ򥹥ȥ꡼��Ȥ����ɤ߽Ф��ơ�
 * ���֥������Ȥ�������롣
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author		Yasumitsu Yoshida
 */
class ExObjectInputStream
extends ObjectInputStream
{
	/**
	 * ���������塼�������ΥǥХå���
	 */
	static final String CN = "ExObjectInputStream";

	/**
	 * Serialize���줿���֥������Ȥ��饪�֥������Ȥ�������뤿��ˡ�
	 * ���֥������Ȥȥ��ȥ꡼������դ��롣
	 *
	 * @see	java.io.ObjectInputStream#ObjectInputStream
	 */
	public
	ExObjectInputStream(InputStream is)
	throws IOException, StreamCorruptedException
	{
		super(is);
	}

	/**
	 * ���֥������Ȥ�Serialize�������ɬ�פˤʤ륯�饹��
	 * OZ�Υ��饹������𤷤����롣
	 *
	 * ����ա�
	 *		���饹�Υ��ɤϥ�ȥ饤��ޤ��OZ�Υ��饹������
	 *		�ԤäƤ���Τǡ��ºݤˤ�IOException��ȯ�����Ƥ��Ƥ�
	 *		OZ�Υ��饹�����ϡ�ClassNotFoundException ���֤���
	 *		�ޤ���OZ�Υ��饹�����θƽФ��򥯥饹 Executor��ͳ��
	 *		�ԤäƤ���Τϥ��饹 Executor �˵�ǽ���椹�뤿��Ǥ��롣
	 *		���������ᤤ���衢���饹 Executor �ε�ǽ��ʣ���Υ��饹��
	 *		ʬ�䤵���ͽ��Ǥ��롣
	 *
	 * @see	java.io.ObjectInputStream#resolveClass
	 */
	protected
	Class resolveClass(ObjectStreamClass osClass)
	throws ClassNotFoundException
	{
		String cn = osClass.getName();
		try {
			return Executor.loadClass(cn);
		} catch (ClassNotFoundException e) {
			/*
			 * ���Υ᥽�å� resolveClass �ϥ�����Хå��ʤΤ�
			 * �����ǥǥХå��������Ϥ���ɬ�פ����롣
			 */
			Executor.debug(CN,"resolveClass","("+cn+")",e);
			throw e;
		}
	}
}
