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
 * $Id: ExCallerChannel.java,v 2.1.1.1 1997/07/15 06:20:45 yoshi Exp $
 *
 * ���: ���Υե������ vi �ǡ�hardtab=8, tabstop=4 �Ȥ����Խ�����Ƥ���
 */

package JP.go.ipa.oz.system;

/**
 * ExCallerChannel �� ExCalleeChannel ���Ф�ʤ���ExCalleeChannel ¦��
 * �¹Ԥ���᥽�åɤμ¹Խ�λ���Ԥ������Υ᥽�åɤ�����ͤ򵢤���ǽ����ġ�
 *
 * @see	ExProcess
 * @see	ExRemoteCallerChannel
 * @see	ExCalleeChannel
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:45 $
 * @author		Yasumitsu Yoshida
 */
interface
ExCallerChannel
{
	/**
	 * Callee ¦�ϡ�Caller ¦����ץ����ɣĤ�������롣
	 *
	 * @return	�ץ����ɣ�
	 */
	String pid();

	/**
	 * Callee ¦��������롣Callee ¦�κ�����ɬ�פʥ��֥������Ȥ�
	 * ʣ���������ȡ����Υ᥽�åɤ��������롣
	 *
	 * @param	proxy	�����Х륢��������ºݤ˹Ԥ����֥�������
	 * @exception	ExGOLFormatException
	 *					�����Х륪�֥������ȥ��������η������������ʤ���
	 * @exception	ExCellNotFoundException
	 *					���ꤵ�줿GOL���ĥ����Х륪�֥������Ȥ����Ĥ���ʤ���
	 * @exception	ExException
	 *					���������塼���������㳰��ȯ��������
	 *
	 * @see	ExChannel#fork
	 * @see	ExRemoteCallerChannel#fork
	 */
	void fork(OzProxy proxy)
	throws ExGOLFormatException, ExCellNotFoundException, ExException;

	/**
	 * Callee ¦�Υ᥽�åɼ¹Ԥν�λ���Ԥġ�Callee ¦����᥽�åɼ¹Ԥ�
	 * ��λ�����Τ������ȡ����Υ᥽�åɤ��������롣
	 *
	 * @return			�᥽�åɤ������
	 * @exception	Exception
	 *					�ƤӽФ����¦�Υ᥽�åɤ�ȯ�������㳰
	 *
	 * @see ExCallerChannel#done
	 * @see ExCalleeChannel#exit
	 */
	Object join() throws Exception;

	/**
	 * Callee ¦����᥽�åɼ¹Ԥν�λ�����Τ�����롣
	 *
	 * @param	status	�᥽�åɼ¹Ԥν�λ���֡�
	 *					�㳰��ȯ�����ƽ�λ�������ϡ�false �Ȥʤ롣
	 * @param	result	�᥽�åɤε����͡�
	 *					�㳰��ȯ�����ƽ�λ�������ϡ������㳰�򼨤����֥������ȡ�
	 * @exception	ExException
	 *					���������塼���������㳰��ȯ��������
	 *
	 * @see ExCalleeChannel#exit
	 */
	void done(boolean status, Object result) throws ExException;

	/**
	 * Caller ¦���Ф��Ƽ¹Ԥ����Ǥ����Τ��롣
	 * Caller ¦�� Callee ¦������С�Callee ¦�˼¹Ԥ����Ǥ����Τ��롣
	 *
	 * @exception	ExException
	 *				�¹�����㳰��ȯ���������ʾܺ�̤���
	 *
	 * @see ExCalleeChannel#abort
	 */
	void kill() throws ExException;

	/* Feb. 17th, 1998. getCallerOzHome() is added by Nishioka */
	/**
	 * ���Υ���ͥ���������륰���Х�᥽�åɵ�ư��Ԥä�
	 * ����Υ����ʤ� OZ �ۡ��� ID ���֤���
	 */
	String getCallerOzHome() throws OzCipherException;
}
