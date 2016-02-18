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
 * $Id: ExClassNotFoundException.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 *
 * ���: ���Υե������ vi �ǡ�hardtab=8, tabstop=4 �Ȥ����Խ�����Ƥ���
 */

package JP.go.ipa.oz.system;

/**
 * ���饹�����Ĥ���ʤ���
 * <DL>
 * <DT>
 * ����ա�
 * <DD>
 * ������(Fri May 9 10:10:12 JST 1997)�Ǥϡ������Ϥ�ž������
 * �㳰��ȯ��������̤Ȥ��ơ����饹�����ɤǤ��ʤ��ä����⡢
 * �����㳰��ȯ�����롣
 * </DL>
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author		Yasumitsu Yoshida
 *
 * @see	ExClassLoader#loadClass
 * @see	ExException
 * @see	java.lang.ClassNotFoundException
 */
public
class ExClassNotFoundException
extends ExException
{
	ExClassNotFoundException()
	{
		super();
	}

	ExClassNotFoundException(String message)
	{
		super(message);
	}
}
