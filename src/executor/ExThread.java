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
 * $Id: ExThread.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 *
 * 注意: このファイルは vi で、hardtab=8, tabstop=4 として編集されている
 */

package	JP.go.ipa.oz.system;

/**
 * ExThread はＯＺのプロセスを構成するスレッドである。すなわち、
 * 一連のスレッドの連鎖がＯＺのプロセスとなる。ExThread は
 * ＯＺのプロセスを構成するためにチャネルを持ち、スレッド間の
 * 同期を取る。また、ExThread はＯＺのプロセスの色を表現する
 * ために色の情報を持っている。この色はスレッド間で受け渡される。
 * また、ExThread はセルに属している。セルに対する操作により
 * スレッドが影響を受ける場合もある。ExThread のインスタンスは
 * １回の実行にのみ使われ、再利用されない。
 *
 * @see		ExChannel
 * @version	$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author	Yasumitsu Yoshida
 */
final
class ExThread
extends Thread
{
	/**
	 * エグゼキュータ実装のデバッグ用
	 */
	static final String CN = "ExThread";

	/**
	 * ＯＺのプロセスを構成するスレッドの色が緑色であることを表す。
	 * 緑色のＯＺプロセスは安全なプロセスであるとされる。
	 *
	 * @see OzSecure#GREEN
	 */
	public static boolean GREEN = OzSecure.GREEN;

	/**
	 * ＯＺのプロセスを構成するスレッドの色が赤色であることを表す。
	 * 赤色のＯＺプロセスは安全でないプロセスであるとされる。
	 *
	 * @see OzSecure#RED
	 */
	public static boolean RED = OzSecure.RED;

	/**
	 * ＯＺのプロセスを構成するスレッドは必ず ExThread.GREEN または、
	 * ExThread.RED の色である。その色を保持する。これを特に
	 * スレッドの色と呼ぶ。
	 */
	boolean color = RED;

	/**
	 * ＯＺのプロセスを構成するスレッドは必ずチャネルをもつ。
	 *
	 */
	ExChannel channel;

	/**
	 * Flag indicates that the thread has been interrupted.
	 *
	 */
	boolean interrupted = false;

	/**
	 * スレッドの色を新しく生成するスレッドに伝播する。
	 *
	 * @param	target	実行時に this に相当するＯＺのオブジェクト
	 * @see	ExThread#ExThread
	 */
	private
	void init(Runnable target)
	{
		Thread t = Thread.currentThread();
		if (t instanceof ExThread) {
			if (target instanceof OzSecure) {
				OzSecure secure = (OzSecure)target;
				if (secure.color == OzSecure.RED) color = RED;
				else color = ((ExThread)t).color;
			} else {
				color = RED;
			}
		} else {
			color = RED;
		}
	}

	/**
	 * 新しいスレッドを作成し、指定されたセルに属させる。
	 *
	 * @param	cell	スレッドが属するセル
	 * @param	target	実行時に this に相当するＯＺのオブジェクト
	 * @param	callee	呼び出され側チャネル
	 * @see	ExThread#init
	 * @see	ExCell
	 * @see	ExCalleeChannel
	 */
	ExThread(ThreadGroup cell, Runnable target, ExChannel callee)
	{
		super(cell, target);
		init(target);
		channel = callee;
	}

	/**
	 */
	public void interrupt(){
	  interrupted=true;
	  super.interrupt();
	}

	/**
	 * エグゼキュータ実装のデバッグ用
	 */
	protected
	void finalize()
	{
		// Executor.debug(CN,"finalize","instance removed");
	}

	/**
	 * デフォルトの表示内容にスレッドの色を加えて表示する。
	 *
	 * @see ExThread#GREEN
	 * @see ExThread#RED
	 * @see ExThread#color
	 */
	public
	String toString()
	{
	  return CN + "@" + Integer.toHexString(hashCode())
	    + "["
	      + getName()
		+ "," + getPriority()
		  + "," + getThreadGroup().getName()
		    + "," + ((color == GREEN) ? "GREEN" : "RED")
		      + "]";
	}

	/* Feb. 17th, 1998. getCallerOzHome() is added by Nishioka */
	/**
	 * このスレッドを生成するグローバルメソッド起動を行った
	 * セルのオーナの OZ ホーム ID を返す。
	 */
	public String getCallerOzHome() throws OzCipherException {
		return channel.callGetCallerOzHome();
	}
}
