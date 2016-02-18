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
 * $Id: ExCalleeChannel.java,v 2.1.1.1 1997/07/15 06:20:45 yoshi Exp $
 *
 * ���: ���Υե������ vi �ǡ�hardtab=8, tabstop=4 �Ȥ����Խ�����Ƥ���
 */

package JP.go.ipa.oz.system;

/**
 * ExCalleeChannel �ϼ¹Ԥκݤ�ɬ�פȤʤ����򥹥�åɤ������뵡ǽ�������
 * �ޤ����¹Ԥ���λ�����ݤξ����ExCallerChannel¦�������뵡ǽ����ġ�
 *
 * @see	ExChannel
 * @see ExRemoteCalleeChannel
 * @see	ExCallerChannel
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:45 $
 * @author		Yasumitsu Yoshida
 */
interface
ExCalleeChannel
{
	/**
	 * �ºݤ˥᥽�åɤ�ƤӽФ��оݤ����롣
	 * �������ƥ��к��Τ���ˡ������ܰʹߤθƽФ��ˤ�
	 * null ������ͤȤ��ʤ���Фʤ�ʤ���
	 *
	 * @return			�᥽�åɵ�ư���оݤȤʤ륪�֥�������
	 * @exception	ExException
	 *					���������塼���������㳰��ȯ��������
	 *
	 */
	Object object() throws ExException;

	/**
	 * �ºݤ˥᥽�åɤ�ƤӽФ������ɬ�פʾ�������롣
	 * �������ƥ��к��Τ���ˡ������ܰʹߤθƽФ��ˤ�
	 * null ������ͤȤ��ʤ���Фʤ�ʤ���
	 *
	 * @return			�᥽�åɵ�ư��ɬ�פʾ������äƤ��륪�֥�������
	 * @exception	ExException
	 *					���������塼���������㳰��ȯ��������
	 *
	 */
	Object[] arguments() throws ExException;

	/**
	 * �᥽�åɼ¹Ԥν�λ�� Caller ¦�����Τ��롣
	 *
	 * @param	status	�᥽�åɼ¹Ԥν�λ���֡�
	 *					�㳰��ȯ�����ƽ�λ�������ϡ�false �Ȥʤ롣
	 * @param	result	�᥽�åɤε����͡�
	 *					�㳰��ȯ�����ƽ�λ�������ϡ������㳰�򼨤����֥������ȡ�
	 * @exception	ExException
	 *					���������塼���������㳰��ȯ��������
	 *
	 */
	void exit(boolean status, Object result) throws ExException;

	/**
	 * Caller ¦����¹Ԥ����Ǥ����Τ�����롣������������ Callee ¦�������
	 * ���� Callee ¦�˼¹Ԥ����Ǥ��׵ᤷ����ǡ��¹Ԥ����Ǥ�Ԥ���
	 * Callee ¦���Ȥ����ExThread���ͳ���ƸƤӽФ��줫�⤷��ʤ���
	 *
	 * @exception	ExException
	 *					���������塼���������㳰��ȯ��������
	 *
	 * @see ExCallerChannel#kill
	 */
	void abort() throws ExException;
}
