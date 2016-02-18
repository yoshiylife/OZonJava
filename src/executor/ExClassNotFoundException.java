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
 * 注意: このファイルは vi で、hardtab=8, tabstop=4 として編集されている
 */

package JP.go.ipa.oz.system;

/**
 * クラスが見つからない。
 * <DL>
 * <DT>
 * 【注意】
 * <DD>
 * 現時点(Fri May 9 10:10:12 JST 1997)では、入出力や転送等で
 * 例外が発生し、結果として、クラスがロードできなかった場合も、
 * この例外が発生する。
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
