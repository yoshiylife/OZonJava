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
 * 注意: このファイルは vi で、hardtab=8, tabstop=4 として編集されている
 */

package JP.go.ipa.oz.system;

/**
 * ExCalleeChannel は実行の際に必要となる情報をスレッドに伝える機能を持ち、
 * また、実行が終了した際の情報をExCallerChannel側に伝える機能を持つ。
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
	 * 実際にメソッドを呼び出す対象を得る。
	 * セキュリティ対策のために、２回目以降の呼出しには
	 * null を戻り値としなければならない。
	 *
	 * @return			メソッド起動の対象となるオブジェクト
	 * @exception	ExException
	 *					エグゼキュータ内部で例外が発生した。
	 *
	 */
	Object object() throws ExException;

	/**
	 * 実際にメソッドを呼び出すために必要な情報を得る。
	 * セキュリティ対策のために、２回目以降の呼出しには
	 * null を戻り値としなければならない。
	 *
	 * @return			メソッド起動に必要な情報が入っているオブジェクト
	 * @exception	ExException
	 *					エグゼキュータ内部で例外が発生した。
	 *
	 */
	Object[] arguments() throws ExException;

	/**
	 * メソッド実行の終了を Caller 側に通知する。
	 *
	 * @param	status	メソッド実行の終了状態。
	 *					例外が発生して終了した場合は、false となる。
	 * @param	result	メソッドの帰り値。
	 *					例外が発生して終了した場合は、その例外を示すオブジェクト。
	 * @exception	ExException
	 *					エグゼキュータ内部で例外が発生した。
	 *
	 */
	void exit(boolean status, Object result) throws ExException;

	/**
	 * Caller 側から実行の中断の通知を受ける。ただし、次の Callee 側があれば
	 * 次の Callee 側に実行の中断を要求した上で、実行の中断を行う。
	 * Callee 側自身からもExThreadを経由して呼び出されかもしれない？
	 *
	 * @exception	ExException
	 *					エグゼキュータ内部で例外が発生した。
	 *
	 * @see ExCallerChannel#kill
	 */
	void abort() throws ExException;
}
