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
 * $Id: OzProcess.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 *
 * 注意: このファイルは vi で、hardtab=8, tabstop=4 として編集されている
 */

package JP.go.ipa.oz.system;

/**
 * OzProcess はＯＺのプロセスを操作するためのクラスである。
 * OzProcess の生成は、ＯＺのプロセスを生成することに相当する。
 * OzProcess で生成されたオブジェクトには、ＯＺのプロセスに
 * 対するデタッチに相当する機能はなく、また、必要ない。
 * この実現のために OzProcess と ExProcess は直接の参照関係を
 * 互いに持たずに、ＯＺのプロセスＩＤと呼ぶキーによって
 * 結び付けられている。
 *
 * @see ExProcessManager
 * @see ExProcess
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author		Yasumitsu Yoshida
 */
public final
class OzProcess
{
	/**
	 * エグゼキュータ実装のデバッグ用
	 */
	static final String CN = "OzProcess";

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
	OzProcess(String pid)
	{
		this.pid = pid;
	}

	/**
	 * ＯＺのプロセスを操作するためのオブジェクトを生成する。
	 * OzProcess の生成がＯＺのプロセスのフォークに相当する。
	 *
	 * @param	proxy	実際のメソッド起動を行うオブジェクト
	 * @param	object	メソッド起動を行う対象
	 * @param	args	メソッド起動に必要な情報
	 *
	 * @see	ExProcessManager#fork(Runnable,java.lang.Object,java.lang.Object[])
	 */
	public
	OzProcess(Runnable proxy, Object object, Object[] args)
	{
		pid = ExProcessManager.fork(proxy, object, args);
	}

	/**
	 * ＯＺのプロセスの終了を待つ。
	 *
	 * @return		メソッドの戻り値
	 * @exception	ExNoSuchProcessException
	 *				このオブジェクトに対応するＯＺプロセスはない。
	 * @exception	ExProcessException
	 *				合流待ち対象のＯＺプロセスが例外終了した。
	 *
	 * @see	ExProcessManager#toExProcess
	 * @see	ExProcess#join()
	 * @see	ExProcess#done
	 */
	public
	Object join()
	throws ExNoSuchProcessException, ExProcessException
	{
		ExProcess p = ExProcessManager.toExProcess(pid);
		Object result;
		try {
			result = p.join() ;
		} catch (Exception e) {
			throw new ExProcessException("pid="+pid,e);
		}
		return result;
	}

	/**
	 * 指定された時間だけＯＺのプロセスの終了を待つ。
	 * 同じプロセスに対して複数回の join が行われることを
	 * 考慮する必要がある。
	 *
	 * @param		timeout 待つ時間（ミリ秒）, 0 を指定するとプロセスの終了まで待つ。
	 * @return		メソッドの戻り値
	 * @exception	ExNoSuchProcessException
	 *				このオブジェクトに対応するＯＺプロセスはない。
	 * @exception	ExProcessException
	 *				合流待ち対象のＯＺプロセスが例外終了した。
	 *
	 * @see	ExProcessManager#toExProcess
	 * @see	ExProcess#join(long)
	 * @see	ExProcess#done
	 */
	public
	Object join(long timeout)
	throws ExNoSuchProcessException, ExProcessException
	{
		ExProcess p = ExProcessManager.toExProcess(pid);
		Object result;
		try {
			result = p.join(timeout) ;
		} catch (Exception e) {
			throw new ExProcessException("pid="+pid,e);
		}
		return result;
	}

	/**
	 * ＯＺプロセスがメソッドを実行中かを調べる。
	 *
	 * @return		メソッドを実行中であれば true を返す。
	 * @exception	ExNoSuchProcessException
	 *				このオブジェクトに対応するＯＺプロセスはない。
	 *
	 * @see	ExProcessManager#toExProcess
	 * @see	ExProcess#isAlive
	 */
	public
	boolean isAlive()
	throws ExNoSuchProcessException
	{
		ExProcess p = ExProcessManager.toExProcess(pid);
		return p.isAlive();
	}

	/**
	 * ＯＺのプロセスを中断する。
	 *
	 * @exception	ExNoSuchProcessException
	 *				このオブジェクトに対応するＯＺプロセスはない。
	 * @exception	ExException
	 *				実行中に例外が発生した。
	 *
	 * @see	ExProcessManager#toExProcess
	 * @see	ExProcess#kill
	 */
	public
	void kill()
	throws ExNoSuchProcessException, ExException
	{
		ExProcess p = ExProcessManager.toExProcess(pid);
		p.kill();
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
