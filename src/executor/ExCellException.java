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
 * 注意: このファイルは vi で、hardtab=8, tabstop=4 として編集されている
 */

package JP.go.ipa.oz.system;

/**
 * セル（グローバルオブジェクト）に関連して例外が発生した。
 *
 * <DL>
 * <DT>
 * 【注意】
 * <DD>
 * 現時点(Fri May 9 15:19:46 JST 1997)では、ExException の
 * サブクラスかどうかは不明なので、コーディング上の便宜のため
 * ExException のサブクラスとしている。
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
