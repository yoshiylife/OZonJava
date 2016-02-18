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
 * $Id: OzCellManager.java,v 2.2 1997/11/07 05:10:57 yoshi Exp $
 *
 * 注意: このファイルは vi で、hardtab=8, tabstop=4 として編集されている
 */

package JP.go.ipa.oz.system;

/**
 * ランタイムサービスを提供するためのクラスである。
 * このクラスには、static メソッドのみが定義される。
 * このクラスはエグゼキュータ外へ公開されるので、
 * セキュリティに十分注意して実装を行う必要がある。
 *
 * <DL>
 * <DT>
 * 【注意】
 * <DD>
 * 現時点(Fri May 9 10:26:46 JST 1997)で、ExSecurityManager との
 * インタフェースが不明な点があるため、コメントのみで必要な
 * メソッド呼び出しを行っていない部分がある。
 * セキュリティ確保ができていないので実装しなおす必要がある。
 * </DL>
 *
 * @version		$Revision: 2.2 $, $Date: 1997/11/07 05:10:57 $
 * @author		Yasumitsu Yoshida
 */
public final
class OzCellManager
{
	/**
	 * エグゼキュータ実装のデバッグ用
	 */
	static final String CN = "OzCellManager";

	/**
	 * このクラスは static メソッド（クラスメソッド）のみを持つ。
	 * また、このクラスのオブジェクトを生成して使用しない。
	 * このクラスは public であり、また、エグゼキュータの実装に依存する
	 * 部分が含まれるので、このクラスのオブジェクトが外部に持ち出され
	 * ないようにする必要がある。
	 */
	private
	OzCellManager()
	{
		/* Nothing */
	}

	/**
	 * 引数 proxy で指定された GOD で識別することができる
	 * セル（グローバルオブジェクト）を引数 codePath で
	 * 指定されたクラス（クラス OzCell のサブクラス）を使って生成する。
	 * この生成されたセルを活性化する過程でそのセルのメソッド initialize を呼び出す。
	 * メソッド initialize が終了するまで、そのセルへのグローバルメソッド起動は
	 * 受け付けられるが、そのメソッドの実行は保留される。
	 * 但し、必ずしもそのメソッドが実行されるとは限らない。
	 * 結果として、メソッドの実行が行われずにグローバルメソッド起動自体が
	 * 例外となる場合もある。
	 * このランタイムサービスが例外で終了した場合は、既に利用されていなければ
	 * 引数 proxy で指定された GOD は再利用可能な状態になる。
	 * 但し、メソッド initialize の中で行われた操作については関知しない。
	 * また、メソッド initialize が例外で終了した場合もこのランタイムサービスは
	 * 例外で終了する。
	 * <DL>
	 * <DT>
	 * 【注意】
	 * <DD>
	 * この処理は、通常よりも多くのスタックが
	 * 消費されると思われるので別スレッドで行う。
	 * <DT>
	 * 【具体的な例外】
	 * <DD>
	 * Executor or ExCell の実装に依存するため、現在は記述していない。
	 * </DL>
	 *
	 * @param		codePath
	 * 					full-qualified-class-name
	 * @param		proxy
	 *					セル（グローバルオブジェクト）にアクセスするためのプロキシ
	 *
	 * @exception	ExCellException
	 *					セル（グローバルオブジェクト）の処理で例外が発生した。
	 * @exception	ExException
	 *					実行中に例外が発生した。
	 *
	 */
	public static
	void create(String codePath, OzProxy proxy)
	throws ExException, ExCellException
	{
		// セキュリティマネージャの呼出し
		if (Executor.securityManager != null) {
			Executor.securityManager.tryNewGlobalObject(codePath, proxy);
		}

		Object[] args = new Object[3];
		args[0] = new Integer(Executor.CREATE);
		args[1] = codePath;
		args[2] = new ExProxy(proxy);
		OzProcess p = Executor.syscall(args);
		try {
			try {
				p.join();
			} catch (ExProcessException e) {
				throw e.getException();
			}
		} catch (ExNoSuchProcessException e) {
			Executor.error(CN,"create","(codePath="+codePath+",proxy="+proxy+")",e);
			throw new ExException(e.getClass().getName());
		} catch (ExCellHookException e) {
			Executor.debug(CN,"create","(codePath="+codePath+",proxy="+proxy+")",e);
			Exception ee = e.getException();
			if (ee != null) {
				Executor.debug(CN,"create","(codePath="+codePath+",proxy="+proxy+")",ee);
			}
			throw e;
		} catch (ExException e) {
			throw e;
		} catch (Exception e) {
			Executor.error(CN,"create","(codePath="+codePath+",proxy="+proxy+")",e);
			throw new ExException(e.getClass().getName());
		}
	}

	/**
	 * 引数 proxy で指定された GOD にあるオブジェクトイメージを
	 * 使ってセル（グローバルオブジェクト）を生成する。
	 * この生成されたセルを活性化する過程でそのセルのメソッド go を呼び出す。
	 * メソッド go が終了するまで、そのセルへのグローバルメソッド起動は
	 * 受け付けられるが、そのメソッドの実行は保留される。
	 * 但し、必ずしもそのメソッドが実行されるとは限らない。
	 * 結果として、メソッドの実行が行われずにグローバルメソッド起動自体が
	 * 例外となる場合もある。
	 * このランタイムサービスが例外で終了した場合、引数 proxy で
	 * 指定された GOD はこのランタイムサービスを呼び出す前の状態になる。
	 * 但し、メソッド go の中で行われた操作については関知しない。
	 * また、メソッド go が例外で終了した場合もこのランタイムサービスは
	 * 例外で終了する。
	 *
	 * <DL>
	 * <DT>
	 * 【注意】
	 * <DD>
	 * この処理は、通常よりも多くのスタックが
	 * 消費されると思われるので別スレッドで行う。
	 * <DT>
	 * 【具体的な例外】
	 * <DD>
	 * Executor or ExCell の実装に依存するため、現在は記述していない。
	 * </DL>
	 *
	 * @param		proxy
	 *					セル（グローバルオブジェクト）にアクセスするためのプロキシ
	 *
	 * @exception	ExCellException
	 *					セル（グローバルオブジェクト）の処理で例外が発生した。
	 * @exception	ExException
	 *					実行中に例外が発生した。
	 *
	 */
	public static
	void go(OzProxy proxy)
	throws ExException, ExCellException
	{
		// セキュリティマネージャの呼出し
		if (Executor.securityManager != null) {
			Executor.securityManager.tryGoGlobalObject(proxy);
		}

		Object[] args = new Object[2];
		args[0] = new Integer(Executor.GO);
		args[1] = new ExProxy(proxy);
		OzProcess p = Executor.syscall(args);
		try {
			try {
				p.join();
			} catch (ExProcessException e) {
				throw e.getException();
			}
		} catch (ExNoSuchProcessException e) {
			Executor.error(CN,"go","(proxy="+proxy+")",e);
			throw new ExException(e.getClass().getName());
		} catch (ExCellHookException e) {
			Executor.debug(CN,"go","(proxy="+proxy+")",e);
			Exception ee = e.getException();
			if (ee != null) {
				Executor.debug(CN,"go","(proxy="+proxy+")",ee);
			}
			throw e;
		} catch (ExException e) {
			throw e;
		} catch (Exception e) {
			Executor.error(CN,"go","(proxy="+proxy+")",e);
			throw new ExException(e.getClass().getName());
		}
	}

	/**
	 * 引数 proxy で指定された GOD で識別されるセル（グローバルオブジェクト）を
	 * 論理的にメモリ上から削除する。
	 * このセルをメモリ上から削除する過程でそのセルのメソッド quiet を呼び出す。
	 * メソッド quiet を呼び出した時点では、そのセルへのグローバルメソッド起動は
	 * 受け付けられない状態になっているが、そのセルに実行中のスレッドがない
	 * ことは保証しない。
	 * このランタイムサービスが例外で終了した場合、
	 * <STRONG>
	 * 【未定】
	 * </STRONG>
	 * である。
	 * また、メソッド quiet が例外で終了した場合もこのランタイムサービスは
	 * 例外で終了する。
	 * なお、グローバルオブジェクトイメージの GOD への保存は自動的には
	 * 行われないので、グローバルオブジェクトイメージを GOD へ保存するための
	 * メソッドを必要に応じて呼び出す必要がある。この操作を行わなかった場合、
	 * 次回のセルの生成時には古いグローバルオブジェクトイメージが使われる、
	 * あるいは、グローバルオブジェクトイメージがなければその GOD は
	 * 再利用されることになる。
	 *
	 * <DL>
	 * <DT>
	 * 【注意】
	 * <DD>
	 * この処理は、通常よりも多くのスタックが
	 * 消費されると思われるので別スレッドで行う。
	 * <DT>
	 * 【具体的な例外】
	 * <DD>
	 * Executor or ExCell の実装に依存するため、現在は記述していない。
	 * </DL>
	 *
	 * @param		proxy
	 *					セル（グローバルオブジェクト）にアクセスするためのプロキシ
	 *
	 * @exception	ExCellException
	 *					セル（グローバルオブジェクト）の処理で例外が発生した。
	 * @exception	ExException
	 *					実行中に例外が発生した。
	 *
	 */
	public static
	void stop(OzProxy proxy)
	throws ExException, ExCellException
	{
		// セキュリティマネージャの呼出し
		if (Executor.securityManager != null) {
			Executor.securityManager.tryStopGlobalObject(proxy);
		}

		Object[] args = new Object[2];
		args[0] = new Integer(Executor.STOP);
		args[1] = new ExProxy(proxy);
		OzProcess p = Executor.syscall(args);
		try {
			try {
				p.join();
			} catch (ExProcessException e) {
				throw e.getException();
			}
		} catch (ExNoSuchProcessException e) {
			Executor.error(CN,"stop","(proxy="+proxy+")",e);
			throw new ExException(e.getClass().getName());
		} catch (ExCellHookException e) {
			Executor.debug(CN,"stop","(proxy="+proxy+")",e);
			Exception ee = e.getException();
			if (ee != null) {
				Executor.debug(CN,"stop","(proxy="+proxy+")",ee);
			}
			throw e;
		} catch (ExException e) {
			throw e;
		} catch (Exception e) {
			Executor.error(CN,"stop","(proxy="+proxy+")",e);
			throw new ExException(e.getClass().getName());
		}
	}

	/**
	 * 引数 proxy で指定された GOD で識別されるセル（グローバルオブジェクト）を
	 * 論理的にメモリ上から削除し、GOD を再利用できる状態にする。
	 * このランタイムサービスが呼び出されれると、
	 * そのセルへのグローバルメソッド起動は受け付けられない状態になる。
	 * このランタイムサービスが例外で終了した場合、
	 * <STRONG>
	 * 【未定】
	 * </STRONG>
	 * である。
	 *
	 * <DL>
	 * <DT>
	 * 【注意】
	 * <DD>
	 * この処理は、通常よりも多くのスタックが
	 * 消費されると思われるので別スレッドで行う。
	 * <DT>
	 * 【具体的な例外】
	 * <DD>
	 * Executor or ExCell の実装に依存するため、現在は記述していない。
	 * </DL>
	 *
	 * @param		proxy
	 *					セル（グローバルオブジェクト）にアクセスするためのプロキシ
	 *
	 * @exception	ExCellException
	 *					セル（グローバルオブジェクト）の処理で例外が発生した。
	 * @exception	ExException
	 *					実行中に例外が発生した。
	 *
	 */
	public static
	void remove(OzProxy proxy)
	throws ExException, ExCellException
	{
		// セキュリティマネージャの呼出し
		if (Executor.securityManager != null) {
			Executor.securityManager.tryRemoveGlobalObject(proxy);
		}

		Object[] args = new Object[2];
		args[0] = new Integer(Executor.REMOVE);
		args[1] = new ExProxy(proxy);
		OzProcess p = Executor.syscall(args);
		try {
			try {
				p.join();
			} catch (ExProcessException e) {
				throw e.getException();
			}
		} catch (ExNoSuchProcessException e) {
			Executor.error(CN,"remove","(proxy="+proxy+")",e);
			throw new ExException(e.getClass().getName());
		} catch (ExCellHookException e) {
			Executor.debug(CN,"remove","(proxy="+proxy+")",e);
			Exception ee = e.getException();
			if (ee != null) {
				Executor.debug(CN,"remove","(proxy="+proxy+")",ee);
			}
			throw e;
		} catch (ExException e) {
			throw e;
		} catch (Exception e) {
			Executor.error(CN,"remove","(proxy="+proxy+")",e);
			throw new ExException(e.getClass().getName());
		}
	}
}
