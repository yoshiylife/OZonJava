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
 * $Id: OzThread.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 *
 * 注意: このファイルは vi で、hardtab=8, tabstop=4 として編集されている
 */

package JP.go.ipa.oz.system;

/**
 * OzThread はＯＺのプロセスを操作するためのクラスである。
 * OzThread の生成は、ＯＺのプロセスを生成することに相当する。
 * OzThread で生成されたオブジェクトには、ＯＺのプロセスに
 * 対するデタッチに相当する機能はなく、また、必要ない。
 * この実現のために OzThread と ExProcess は直接の参照関係を
 * 互いに持たずに、ＯＺのプロセスＩＤと呼ぶキーによって
 * 結び付けられている。
 *
 * @see ExProcessManager
 * @see ExProcess
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author		Yasumitsu Yoshida(modified Y.Hamazaki)
 */
public final
class OzThread
{
  /**
   * エグゼキュータ実装のデバッグ用
   */
  static String CN = "OzThread";
  
  /**
   * ＯＺのプロセスの実装を担うオブジェクトを検索するための
   * キーである。ＯＺのプロセスＩＤと呼ぶ。
   */
  private String pid;
  
  /**
   * エグゼキュータ内部で使用するＯＺのプロセスを操作するための
   * オブジェクトを生成する。
   *
   * @param	pid	ＯＺのプロセスＩＤ
   */
  OzThread(String pid)
    {
      this.pid = pid;
    }
  
  /**
   * ＯＺのプロセスを操作するためのオブジェクトを生成する。
   * OzThread の生成がＯＺのプロセスのフォークに相当する。
   *
   * @param	proxy	実際のメソッド起動を行うオブジェクト
   * @param	object	メソッド起動を行う対象
   * @param	args	メソッド起動に必要な情報
   *
   * @see	ExProcessManager#fork(ExCell,Runnable,java.lang.Object[])
   */
  public
    OzThread(OzRunnable runnable)
      {
	//ExCell cell = ExCell.currentCell();
	ExRunnable proxy = new ExRunnable(runnable);
	pid = ExProcessManager.fork(proxy,proxy,null);
      }
  
  /**
   * 指定された時間だけＯＺのプロセスの終了を待つ。
   *
   * @exception	ExNoSuchThreadException
   *				このオブジェクトに対応するＯＺプロセスはない。
   * @exception	ExThreadException
   *				合流待ち対象のＯＺプロセスが例外終了した。
   *
   * @see	ExProcessManager#toExProcess
   * @see	OzThread#join()
   * @see	OzThread#done
   */
  public
    void join(long timeout)
      throws ExNoSuchThreadException, ExInterruptedException,ExThreadException
	{
	  ExProcess p;
	  try{
	    p = ExProcessManager.toExProcess(pid);
	  } catch (ExNoSuchProcessException ensex){
	    throw new ExNoSuchThreadException("pid="+pid);
	  }
	  
	  try {
	    p.join(timeout) ;
	  } catch (InterruptedException iex){
	    throw new ExInterruptedException("Interrupted before joined");
	  } catch (Exception e) {
	    throw new ExThreadException("pid="+pid+" Exception="+e.getClass().getName());
	  }
	}
  

  /**
   * ＯＺプロセスがメソッドを実行中かを調べる。
   *
   * @return		メソッドを実行中であれば true を返す。
   * @exception	ExNoSuchThreadException
   *				このオブジェクトに対応するＯＺプロセスはない。
   *
   * @see	ExProcessManager#toExProcess
   * @see	ExProcess#isAlive
   */
  public
    boolean isAlive()
      throws ExNoSuchThreadException
	{
	  ExProcess p;
	  try{
	    p = ExProcessManager.toExProcess(pid);
	  } catch (ExNoSuchProcessException nspex){
	    throw new ExNoSuchThreadException();
	  }
	  return p.isAlive();
	}
  
  /**
   * ＯＺのプロセスを中断する。
   *
   * @exception	ExNoSuchThreadException
   *				このオブジェクトに対応するＯＺプロセスはない。
   * @exception	ExException
   *				実行中に例外が発生した。
   *
   * @see	ExProcessManager#toExProcess
   * @see	ExProcess#kill
   */
  public
    void interrupt()
      throws ExNoSuchThreadException, ExException
	{
	  ExProcess p;
	  try{
	    p = ExProcessManager.toExProcess(pid);
	  }catch (ExNoSuchProcessException nspex){
	    throw new ExNoSuchThreadException();
	  }
	  p.kill();
	}

  public static boolean
    interrupted()
      throws ExException
	{
	  ExThread th = (ExThread)Thread.currentThread();
	  return th.interrupted;
	}
  
  /**
   * ＯＺのプロセスを破棄する。
   *
   * @see	ExProcessManager#detach
   */
  protected
    void finalize()
      {
	ExProcessManager.detach(pid);
      }
  
  /**
   * デフォルトの表示内容にＯＺのプロセスＩＤを加えて表示する。
   *
   */
  public
    String toString()
      {
	return CN + "@" + Integer.toHexString(hashCode()) + "[pid=" + pid + "]";
      }
}
