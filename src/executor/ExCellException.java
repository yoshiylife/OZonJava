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
 * $Id: ExCellException.java,v 2.1.1.1 1997/07/15 06:20:45 yoshi Exp $
 *
 * ���: ���Υե������ vi �ǡ�hardtab=8, tabstop=4 �Ȥ����Խ�����Ƥ���
 */

package JP.go.ipa.oz.system;

/**
 * ����ʥ����Х륪�֥������ȡˤ˴�Ϣ�����㳰��ȯ��������
 *
 * <DL>
 * <DT>
 * ����ա�
 * <DD>
 * ������(Fri May 9 15:19:46 JST 1997)�Ǥϡ�ExException ��
 * ���֥��饹���ɤ����������ʤΤǡ������ǥ��󥰾���ص��Τ���
 * ExException �Υ��֥��饹�Ȥ��Ƥ��롣
 * </DL>
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:45 $
 * @author		Yasumitsu Yoshida
 *
 */
public
class ExCellException
extends ExException
{
	ExCellException()
	{
		super();
	}

	ExCellException(String message)
	{
		super(message);
	}
}
