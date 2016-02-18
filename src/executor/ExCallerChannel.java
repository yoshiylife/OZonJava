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
 * $Id: ExCallerChannel.java,v 2.1.1.1 1997/07/15 06:20:45 yoshi Exp $
 *
 * 注意: このファイルは vi で、hardtab=8, tabstop=4 として編集されている
 */

package JP.go.ipa.oz.system;

/**
 * ExCallerChannel は ExCalleeChannel と対をなし、ExCalleeChannel 側で
 * 実行さるメソッドの実行終了を待ち、そのメソッドの戻り値を帰す機能を持つ。
 *
 * @see	ExProcess
 * @see	ExRemoteCallerChannel
 * @see	ExCalleeChannel
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:45 $
 * @author		Yasumitsu Yoshida
 */
interface
ExCallerChannel
{
	/**
	 * Callee 側は、Caller 側からプロセスＩＤを獲得する。
	 *
	 * @return	プロセスＩＤ
	 */
	String pid();

	/**
	 * Callee 側を作成する。Callee 側の作成と必要なオブジェクトの
	 * 複製が終わると、このメソッドは復帰する。
	 *
	 * @param	proxy	グローバルアクセスを実際に行うオブジェクト
	 * @exception	ExGOLFormatException
	 *					グローバルオブジェクトロケーションの形式が正しくない。
	 * @exception	ExCellNotFoundException
	 *					指定されたGOLをもつグローバルオブジェクトが見つからない。
	 * @exception	ExException
	 *					エグゼキュータ内部で例外が発生した。
	 *
	 * @see	ExChannel#fork
	 * @see	ExRemoteCallerChannel#fork
	 */
	void fork(OzProxy proxy)
	throws ExGOLFormatException, ExCellNotFoundException, ExException;

	/**
	 * Callee 側のメソッド実行の終了を待つ。Callee 側からメソッド実行の
	 * 終了の通知を受けると、このメソッドは復帰する。
	 *
	 * @return			メソッドの戻り値
	 * @exception	Exception
	 *					呼び出される側のメソッドで発生した例外
	 *
	 * @see ExCallerChannel#done
	 * @see ExCalleeChannel#exit
	 */
	Object join() throws Exception;

	/**
	 * Callee 側からメソッド実行の終了の通知を受ける。
	 *
	 * @param	status	メソッド実行の終了状態。
	 *					例外が発生して終了した場合は、false となる。
	 * @param	result	メソッドの帰り値。
	 *					例外が発生して終了した場合は、その例外を示すオブジェクト。
	 * @exception	ExException
	 *					エグゼキュータ内部で例外が発生した。
	 *
	 * @see ExCalleeChannel#exit
	 */
	void done(boolean status, Object result) throws ExException;

	/**
	 * Caller 側に対して実行の中断を通知する。
	 * Caller 側は Callee 側があれば、Callee 側に実行の中断を通知する。
	 *
	 * @exception	ExException
	 *				実行中に例外が発生した。（詳細未定）
	 *
	 * @see ExCalleeChannel#abort
	 */
	void kill() throws ExException;

	/* Feb. 17th, 1998. getCallerOzHome() is added by Nishioka */
	/**
	 * このチャネルを生成するグローバルメソッド起動を行った
	 * セルのオーナの OZ ホーム ID を返す。
	 */
	String getCallerOzHome() throws OzCipherException;
}
