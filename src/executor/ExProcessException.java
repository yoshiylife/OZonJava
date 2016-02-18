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
 * $Id: ExProcessException.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 *
 * 注意: このファイルは vi で、hardtab=8, tabstop=4 として編集されている
 */

package JP.go.ipa.oz.system;

/**
 * 処理対象のＯＺプロセスで例外が発生した。
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author		Yasumitsu Yoshida
 */
public
class ExProcessException
extends ExException
{
	Exception	ball = null;

	ExProcessException()
	{
		super();
    }

	ExProcessException(String msg)
	{
		super(msg);
    }

	ExProcessException(String msg, Exception ball)
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
