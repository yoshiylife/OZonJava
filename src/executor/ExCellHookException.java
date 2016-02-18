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
 * $Id: ExCellHookException.java,v 2.1.1.1 1997/07/15 06:20:45 yoshi Exp $
 *
 * ���: ���Υե������ vi �ǡ�hardtab=8, tabstop=4 �Ȥ����Խ�����Ƥ���
 */

package JP.go.ipa.oz.system;

/**
 * ������Ф���桼������Υ᥽�åɸƽФ��Ǥ��㳰
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:45 $
 * @author		Yasumitsu Yoshida
 */
public
class ExCellHookException
extends ExException
{
	Exception	ball = null;

	ExCellHookException()
	{
		super();
    }

	ExCellHookException(String msg)
	{
		super(msg);
    }

	ExCellHookException(String msg, Exception ball)
	{
		super(msg);
		this.ball = ball;
    }

	public
	Exception getException()
	{
		return ball;
	}
}
