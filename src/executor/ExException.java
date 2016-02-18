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
 * $Id: ExException.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 *
 * ���: ���Υե������ vi �ǡ�hardtab=8, tabstop=4 �Ȥ����Խ�����Ƥ���
 */

package JP.go.ipa.oz.system;

/**
 * ���������塼�������ν������㳰��ȯ��������
 * ���ˡ�����Ͽ���ν������Ԥ��Ƥ������ȯ�������롣
 * �ޤ��������㳰�ϸƽФ������ܺ٤ʥ��顼�������äƤ⤽���
 * �б����������Ԥ��ʤ������뤤�ϡ����ΰ�̣���ʤ����ˤ�Ȥ��롣
 *
 * ����ա�
 * �����㳰��ȯ����������ϡ������Ȥʤä��㳰����
 * �᥽�å� Executor.error()��Ȥäƥ���Ͽ���뤳�ȡ�
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author		Yasumitsu Yoshida
 */
public
class ExException
extends Exception
{
	ExException()
	{
		super();
    }

	ExException(String msg)
	{
		super(msg);
    }
}
