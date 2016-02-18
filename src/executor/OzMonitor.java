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
 * $Id: OzMonitor.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 *
 * 注意: このファイルは vi で、hardtab=8, tabstop=4 として編集されている
 */

package JP.go.ipa.oz.system;

import java.io.Serializable;

/**
 * OzMonitor はＯＺのノンリエントラントなモニタ機能を持ち、
 * 条件変数の実現のための一部の役割を担っている。
 *
 * @see	OzCondition
 * @see	ExThread
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author		Yoichi Hamazaki (revised from OzObject by Yasumitsu Yoshida)
 */
public
class OzMonitor
implements Serializable
{
  /**
   * エグゼキュータ実装のデバッグ用
   */
  static String CN = "OzMonitor";

  /**
   * ＯＺのオブジェクトは１つのモニタとしての機能を持つ。
   * モニタがロック中を示すフラグである。
   */
  private transient boolean locked = false;

  /**
   * 新しいモニターを作成する。
   *
   * @return	新しいインスタンス
   */
  public
    OzMonitor()
      {
      }

  /**
   * モニタを獲得する。
   *
   * @exception	ExInterruptedException
   *					スレッドに対してkillが実行された。
   *
   * @see	OzMonitor#leave
   * @see	OzCondition
   */
  protected final synchronized
    void enter()
      throws ExInterruptedException
	{
	  try{
	    while (locked) wait(0); // IllegalMonitorStateException の発生はありえない
	  } catch (InterruptedException iex){
	    throw new ExInterruptedException("Interrupted while waiting to enter");
	  }

	  locked = true;
	}

  /**
   * モニタを開放する。
   *
   * @exception ExIllegalMonitorStateException Leave monitor without enter.
   *
   * @see	OzMonitor#enter
   * @see	OzCondition
   */
  protected final synchronized
    void leave() 
      throws ExIllegalMonitorStateException
	{
	  if(!locked)
	    throw new ExIllegalMonitorStateException();
 
	  locked = false;
	  notifyAll();
      }
  
  /**
   * 条件変数にシグナル、あるいは、指定された時間が経過
   * するまで待機する。
   *
   * @param	cond	待機する条件変数を指定
   * @param	timeout	待機する時間をミリ秒で指定
   * @exception	ExExIllegalConditionException
   *					モニタが異なる条件変数に対して操作が行われた。
   * @exception	ExInterruptedException
   *					スレッドに対してkillが実行された。
   *
   * @see	OzMonitor#signal
   * @see	OzMonitor#signalAll
   * @see	OzCondition#wait
   */
  protected final
    void wait(OzCondition cond, long timeout)
      throws ExIllegalConditionException, ExInterruptedException,ExIllegalMonitorStateException
	{
	  cond.wait(this, timeout);
	}
  
  /**
   * 条件変数にシグナルを送信する。条件変数で待機している
   * スレッドの中の１つのみがスケジューリングされる。
   * このメソッドを呼び出す前に、メソッド enter を呼び出し、
   * モニタを獲得していなければならない。
   *
   * @param	cond	シグナルを送信する条件変数を指定
   * @exception	ExIllegalConditionException
   *					モニタが異なる条件変数に対して操作が行われた。
   * @exception	ExInterruptedException
   *					スレッドに対してkillが実行された。
   *
   * @see	OzMonitor#enter
   * @see	OzMonitor#leave
   * @see	OzMonitor#signalAll
   * @see	OzCondition#signal
   */
  protected final
    void signal(OzCondition cond)
      throws ExIllegalConditionException
	{
	  cond.signal(this);
	}
  
  /**
   * 条件変数にシグナルを送信する。条件変数で待機している
   * 全てのスレッドがスケジューリングされる。
   * このメソッドを呼び出す前に、メソッド enter を呼び出し、
   * モニタを獲得していなければならない。
   *
   * @param	cond	シグナルを送信する条件変数を指定
   * @exception	ExIllegalConditionException
   *					モニタが異なる条件変数に対して操作が行われた。
   *
   * @see	OzMonitor#enter
   * @see	OzMonitor#leave
   * @see	OzMonitor#signal
   * @see	OzCondition#signalAll
   */
  protected final
    void signalAll(OzCondition cond)
      throws ExIllegalConditionException
	{
	  cond.signalAll(this);
	}
  
  /**
   * デフォルトの表示内容にロックの状況を加えて表示する
   *
   */
  public
    String toString()
      {
	return super.toString()+"["+(locked? "Locked":"Unlocked")+"]";
      }
}
