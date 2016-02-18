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
 * $Id: ExProcess.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 *
 * 注意: このファイルは vi で、hardtab=8, tabstop=4 として編集されている
 */

package JP.go.ipa.oz.system;

/**
 * クラス ExProcess はＯＺのプロセスを実装するためのクラスである。
 * インタフェース ExCallerChannel の実装でもあり、全てのＯＺのプロセスは
 * このクラスで作成されたオブジェクトから始まる。
 *
 * @see ExCallerChannel
 * @see ExProcessManager
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author		Yasumitsu Yoshida
 */
class ExProcess
implements ExCallerChannel
{
	/**
	 * エグゼキュータ実装のデバッグ用
	 */
	static final String CN = "ExProcess";

	/**
	 * プロセスが属するセルの god を保持する。
	 */
	private String god;

	/**
	 * ExProcessManager によって割り当てられたプロセスＩＤを保持する。
	 */
	private String pid;

	/**
	 * 次のチャネル（呼び出される側）を保持し、チャネルの連鎖を構成する。
	 */
	private ExCalleeChannel callee;

	/**
	 * プロセスとして最初に起動されたメソッドの終了状態を保持する。
	 * そのメソッドが例外で終了した場合、false となる。
	 */
	private boolean status;

	/**
	 * プロセスとして最初に起動されたメソッドの戻り値を保持する。
	 */
	private Object result;

	/**
	 * ExProcessManager によって割り当てられたプロセスＩＤを
	 * 持つプロセスを操作するためのオブジェクトを生成する。
	 *
	 * @param	pid	プロセスＩＤ
	 */
	ExProcess(String pid)
	{
		this.pid = pid;
	}

	/**
	 * ExCallerChannel として、このオブジェクトのプロセスＩＤを返す。
	 *
	 * @return	プロセスＩＤ
	 */
	public
	String pid()
	{
		return pid;
	}

	/**
	 * ExCallerChannel として、このメソッドが実行されることはない。
	 *
	 * @param	proxy	実際にメソッドを呼び出すプロキシ
	 *
	 * @exception	ExException
	 *				実行中に例外が発生した。
	 *
	 * @see ExCell#fork
	 * @see ExCommSystem#fork
	 * @see ExCallerChannel#fork
	 */
	public
	void fork(OzProxy proxy)
	throws ExException
	{
		ExException e = new ExException("Illegal method call");
	    Executor.debug(CN,"fork","(proxy="+proxy+"): ",e);
		throw e;
	}

	/**
	 * 同じセルに属する新しいプロセスを作成し、実行を開始する。
	 *
	 * @param	proxy	実際にメソッドを呼び出すプロキシ
	 * @param	object	メソッドを呼び出す対象のオブジェクト
	 * @param	args	メソッドを呼び出す際に必要となる情報
	 *
	 * @see	ExCell#fork(ExCallerChannel,Object,Object[])
	 */
	public
	void fork(Runnable proxy, Object object, Object[] args)
	{
		ExCell cell = ExCell.currentCell();
		this.god = cell.getName();
		callee = cell.fork(this, proxy, object, args);
	}

	/**
	 * 直接に指定したセルに属する新しいプロセスを作成し、実行を開始する。
	 * エグゼキュータ内部の処理を行うためにExProcessManagerを
	 * 介して呼び出される。
	 *
	 * @param	cell	プロセスが属するセル
	 * @param	proxy	メソッドが実行されるオブジェクト
	 * @param	args	メソッドを呼び出す際に必要となる情報
	 *
	 * @see	ExCell#fork(ExCallerChannel,Object,Object[])
	 */
	void fork(ExCell cell, Runnable proxy, Object[] args)
	{
		this.god = cell.getName();
		callee = cell.fork(this, proxy, args);
	}

	/**
	 * メソッドの終了を待つ。
	 *
	 * @return	メソッドの戻り値
	 * @exception	Exception
	 *				呼び出される側のメソッドで発生した例外で、
	 *				このメソッド自身の例外はない。
	 *
	 * @see	ExProcess#join(long)
	 */
	public
	Object join()
	throws Exception
	{
		return join(0);
	}

	/**
	 * ExCallerChannel として、呼び出される側のメソッドの実行終了を待つ。
	 *
	 * @param	timeout	待ち時間
	 * @return	呼び出される側のメソッドの戻り値
	 * @exception	Exception
	 *				呼び出される側のメソッドで発生した例外で、
	 *				このメソッド自身の例外はない。
	 *
	 * @see	Object#join(long)
	 * @see	ExProcess#done
	 */
	public synchronized
	Object join(long timeout)
	throws Exception
	{
		// Executor.debug(CN,"join()","callee="+callee);
		while (callee != null) wait(timeout);
		// Executor.debug(CN,"join()","status="+status+",result="+result);
		if (!status) throw (Exception)result ;
		return result ;
	}

	/**
	 * ExCallerChannel として、呼び出される側からメソッドの実行終了を通知する。
	 *
	 * @param	status	メソッドが例外で終了した場合は、false を指定する。
	 * @param	result	メソッドの戻り値を指定する。
	 *
	 * @see	ExProcess#join(long)
	 * @see	ExProcess#status
	 * @see	ExProcess#result
	 * @see	ExCallerChannel#done
	 */
	public synchronized
	void done(boolean status, Object result)
	{
		// Executor.debug(CN,"done","("+status+","+result+")");
		this.status = status;
		this.result = result;
		callee = null;
		notifyAll();
	}

	/**
	 * ＯＺプロセスがメソッドを実行中かを調べる。
	 *
	 * @return		メソッドを実行中であれば true を返す。
	 */
	public synchronized
	boolean isAlive()
	{
		return (callee != null) ? true : false;
	}

	/**
	 * ExCallerChannel として、呼び出される側のスレッドの実行を中断する。
	 *
	 * @exception	ExException
	 *				実行中に例外が発生した。
	 *
	 * @see	ExCalleeChannel#abort
	 */
	public synchronized
	void kill()
	throws ExException
	{
	        try {
			if (callee == null) {
				Executor.debug(CN,"kill()",pid + ": process already done.");
			} else {
				callee.abort();
			}
		} catch (ExException e) {
			ThreadGroup g = Thread.currentThread().getThreadGroup();
			Executor.error(CN,"kill","channel="+this+",cell="+g,e);
			throw e;
		}
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
	 * デフォルトの表示内容にプロセスＩＤと GOD を加えて表示する。
	 */
	public
	String toString()
	{
		return CN + "@" + Integer.toHexString(hashCode()) + "[pid=" + pid + ",god=" + god + "]";
	}

	/* Feb. 17th, 1998. getCallerOzHome() is added by Nishioka */
	/**
	 * このチャネルを生成するグローバルメソッド起動を行った
	 * セルのオーナの OZ ホーム ID を返す。
	 * ExProcess の場合は、常に同じオーナなので、
	 * それを示すために null を返す。
	 */
	public String getCallerOzHome() throws OzCipherException {
		return null;
	}
}
