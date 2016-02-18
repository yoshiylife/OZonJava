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
 * $Id: OzCondition.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 *
 * 注意: このファイルは vi で、hardtab=8, tabstop=4 として編集されている
 */

package JP.go.ipa.oz.system;

import java.io.Serializable;

/**
 * ＯＺの条件変数を実現する。ＯＺのオブジェクトと対にして使用する。
 *
 * @see		OzMonitor
 *
 * @version	$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author	Yasumitsu Yoshida
 */
public final
class OzCondition
implements Serializable
{
	/**
	 * エグゼキュータ実装のデバッグ用
	 */
	static String CN = "OzCondition";

	/**
	 * この条件変数と対になるモニタとしての
	 * ＯＺのオブジェクトを記憶する。
	 */
	private OzMonitor monitor;

	/**
	 * この条件変数で待機状態に入った回数をカウントする。
	 * デバッグ用。
	 */
	private long waitCounter = 0; // for debug

	/**
	 * この条件変数にシグナルが送信された回数をカウントする。
	 * デバッグ用。
	 */
	private long signalCounter = 0; // for debug

	/**
	 * 指定されたＯＺのオブジェクトをモニタとして使用する
	 * 条件変数（オブジェクト）を生成する。１つのＯＺのオブジェクト
	 * に対して複数の条件変数を生成することができる。
	 *
	 * @return	新しいインスタンス
	 */
	public
	OzCondition(OzMonitor m)
	{
		monitor = m;
	}

	/**
	 * 条件変数にシグナル、あるいは、指定された時間が経過
	 * するまで待機する。指定されたモニタがこの条件変数を
	 * 生成する時に指定されたモニタと異なる場合は例外となる。
	 * class OzMonitor を経由して呼び出される。
	 * このメソッドを呼び出す前に、モニタを獲得していなければならない。
	 *
	 * @param	m		この条件変数が使用しているモニタ
	 * @param	timeout	待機する時間をミリ秒で指定
	 * @exception	ExIllegalConditionException
	 *					モニタが異なる条件変数に対して操作が行われた。
	 * @exception	ExInterruptedException
	 *					スレッドに対してkillが実行された。
	 *
	 * @see	OzMonitor#enter
	 * @see	OzMonitor#leave
	 * @see	OzMonitor#waitCondition
	 * @see	OzMonitor#signal
	 * @see	OzMonitor#signalAll
	 * @see	OzCondition#signal
	 */
	void wait(OzMonitor m, long timeout)
	throws ExIllegalConditionException, ExInterruptedException, ExIllegalMonitorStateException
	{
		if (monitor != m) throw new ExIllegalConditionException();
		waitCondition(timeout);
		monitor.enter();
	}

	/**
	 * 条件変数にシグナルを送信する。条件変数で待機している
	 * スレッドの中の１つのみがスケジューリングされる。
	 * Class OzMonitor を経由して呼び出される。
	 * このメソッドを呼び出す前に、モニタを獲得していなければならない。
	 *
	 * @param	m		この条件変数が使用しているモニタ
	 * @exception	ExIllegalConditionException
	 *					モニタが異なる条件変数に対して操作が行われた。
	 *
	 * @see	OzMonitor#enter
	 * @see	OzMonitor#leave
	 * @see	OzCondition#signal
	 * @see	OzCondition#signalAll
	 * @see	OzMonitor#signal
	 */
	synchronized
	void signal(OzMonitor m)
	throws ExIllegalConditionException
	{
	  if (monitor != m) throw new ExIllegalConditionException();
	  signalCounter ++; // for debug
	    notify(); // IllegalMonitorStateException の発生はありえない
	}

	/**
	 * 条件変数にシグナルを送信する。条件変数で待機している
	 * 全てのスレッドがスケジューリングされる。
	 * Class OzMonitor を経由して呼び出される。
	 *
	 * @param	m	この条件変数が使用しているモニタ
	 * @exception	ExIllegalConditionException
	 *					モニタが異なる条件変数に対して操作が行われた。
	 *
	 * @see	OzCondition#signalAll
	 * @see	OzCondition#signal
	 * @see	OzMonitor#signalAll
	 */
	synchronized
	void signalAll(OzMonitor m)
	throws ExIllegalConditionException
	{
	  if (monitor != m) throw new ExIllegalConditionException();
	  signalCounter ++; // for debug
	    notifyAll(); // IllegalMonitorStateException の発生はありえない
	}

	/**
	 * 条件変数にシグナル、あるいは、指定された時間が経過
	 * するまで待機する。メソッド wait() の実装である。
	 *
	 * @param	timeout	待機する時間をミリ秒で指定
	 * @exception	InterruptedException
	 *					スレッドに対してkillが実行された。
	 *
	 * @see	OzCondition#wait
	 */
	private synchronized
	void waitCondition(long timeout)
	throws ExInterruptedException,ExIllegalMonitorStateException
	{
		//System.out.println(getClass().getName()+": waitCondition");
		monitor.leave();
		waitCounter ++; // for debug
		  try{
		wait(timeout); 		// IllegalMonitorStateException の発生はありえない。既にmonitor.leave()のところで発生しているはず。
	      } catch (InterruptedException iex){
		throw new ExInterruptedException("Interrupted while waiting at a condition variable");
	      }
	}

	/**
	 * デフォルトの表示内容に条件変数の待機回数とシグナル回数を
	 * 加えて表示する。
	 *
	 * @see	OzCondition#waitCounter
	 * @see	OzCondition#signalCounter
	 */
	public
	String toString()
	{
		return super.toString()+"["+waitCounter+","+signalCounter+"]";
	}
}
