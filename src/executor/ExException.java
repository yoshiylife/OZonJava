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
 * 注意: このファイルは vi で、hardtab=8, tabstop=4 として編集されている
 */

package JP.go.ipa.oz.system;

/**
 * エグゼキュータ内部の処理で例外が発生した。
 * 既に、ログ記録等の処理が行われている場合に発生させる。
 * また、この例外は呼出し元が詳細なエラーを受け取ってもそれに
 * 対応する処理を行えない、あるいは、その意味がない場合にも使われる。
 *
 * 【注意】
 * この例外を発生させる場合は、原因となった例外等を
 * メソッド Executor.error()を使ってログ記録すること。
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
