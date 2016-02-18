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
 * $Id: OzProxy.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 *
 * 注意: このファイルは vi で、hardtab=8, tabstop=4 として編集されている
 */

package JP.go.ipa.oz.system;

/**
 * グローバルアクセスを行うためにローカルオブジェクトとグローバルオブジェクトの
 * 仲介する役目がクラス OzProxy である。OzProxy はクラス OzCell に対応し、
 * OzCell を継承するクラスには、クラス OzProxy を継承した各々のクラスが
 * 対応する。通常、OzProxy を継承するクラスはコンパイラによって自動的に作成される。
 * クラス OzProxy、あるいは、それを継承するクラスで生成されたオブジェクトをプロキシ
 * と呼ぶ。このプロキシは１つのセル（グローバルオブジェクト）に対応する。このプロキシへ
 * ローカルアクセスを行うと、プロキシ自身がコピーアウトされて、呼び出す
 * セル（グローバルオブジェクト）側にコピーインされる。
 * その上で、呼び出し側のオブジェクトに代わってセル（グローバルオブジェクト）に
 * 対してメソッド起動を行う。
 *
 * @see OzCell
 * @see	OzSecure
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author		Yasumitsu Yoshida
 */
public
class OzProxy
extends OzSecure
implements Runnable
{
	/**
	 * エグゼキュータ実装のデバッグ用
	 */
	static String CN = "OzProxy";

	/**
	 * グローバルオブジェクトの通信アドレスを解決するためのキーになる。
	 * エグゼキュータ以外は直接にアクセスすることはできない。
	 */
	private ExGOL gol;

	/**
	 * 呼び出すことができるメソッドの番号のリスト
	 * エグゼキュータ内部専用なので、リフレクションを使う必要はない。
	 * エグゼキュータのみが使用する。
	 */
	static final int INITIALIZE = 0;
	static final int GO = 1;
	static final int QUIET = 2;

	/**
	 * 呼び出すメソッドの番号を格納する。
	 * エグゼキュータのみが使用する。
	 */
	int selector;

	/**
	 * セル（グローバルオブジェクト）にアクセスするためのプロキシを
	 * 作成する。プロキシは必ずグローバルオブジェクトロケーションを
	 * 持ち、その値は消滅するまで変わらない。
	 *
	 * @param	gol		グローバルオブジェクトロケーション
	 * @exception		ExGOLFormatException
	 *					GOL の形式が正しくない。
	 */
	public
	OzProxy(String gol)
	throws ExException
	{
		this.gol = new ExGOL(gol);
	}

	/**
	 * セル（グローバルオブジェクト）にアクセスするためのプロキシを作成する。
	 * このメソッドを呼び出したスレッドが属するセル（グローバルオブジェクト）の
	 * グローバルオブジェクトロケーションが設定される。
	 *
	 * @see	ExCell
	 */
	public
	OzProxy()
	throws ExException
	{
		ExCell cell = ExCell.currentCell();
		try {
			this.gol = new ExGOL(cell.getName());
		} catch (ExGOLFormatException e) {
			Executor.error(CN,"OzProxy","cell.getName() "+cell.getName(),e);
			throw new ExException(cell.getName());
		}
	}

	/**
	 * 自分と同じgolを持つかを調べる。
	 *
	 * @param	proxy	比較対象のプロキシ
	 * @return	gol が一致すれば、true を返す。
	 *
	 * @see	OzProxy@gol
	 */
	public
	boolean equals(Object proxy)
	{
		if ((proxy != null) && (proxy instanceof OzProxy)) {
			return gol.equals(((OzProxy)proxy).getName());
		}
		return false;
	}

	/**
	 * GOLを返す。
	 * エグゼキュータ内部で使用し、ユーザ（コンパイラを含む）には公開しない。
	 *
	 * @return	ExGOLを使って生成されたオブジェクト
	 *
	 * @see	OzProxy@gol
	 */
	final
	ExGOL getGOL()
	{
		return gol;
	}

	/**
	 * OZホーム名が現在動作しているエグゼキュータのOZホーム名と
	 * 一致すかを調べる。
	 *
	 * @return	OZホーム名が同じならば true を返す。
	 */
	boolean inside()
	{
		return gol.inside();
	}

	/**
	 * プロキシが持つグローバルオブジェクトロケーションを返す。
	 *
	 * @return	グローバルオブジェクトロケーション
	 *
	 * @see	OzProxy@gol
	 */
	public final
	String getName()
	{
		return gol.getName();
	}

	/**
	 * デフォルトの表示内容にＧＯＬを加えて表示する。
	 *
	 */
	public final
	String toString()
	{
		String cn = getClass().getName();
		if (cn.startsWith(Executor.IPAoz)) {
			cn = cn.substring(Executor.IPAoz.length(),cn.length());
		}
		return cn + "@" + Integer.toHexString(hashCode()) + "[gol=" + gol + "]";
	}

	/**
	 * グローバルアクセスのための処理を開始する。
	 * このメソッドはプロキシのローカルアクセスをグローバルアクセスに
	 * 変換すべきメソッドから呼び出される。
	 * １つのプロキシに同時に複数のローカルアクセス（グローバルアクセスのために）を
	 * 行うことを可能とするために、そのプロキシをコピーアウト終了するまでの間、
	 * プロキシの状態（参照しているオブジェクトを含む）が変化してはならない。
	 * このメソッドを呼び出す側はこの点に注意しなければならない。
	 * このメソッドを呼び出した後、メソッド join() を呼び出し、	
	 * グローバルインボークの終了とその戻り値を得なければならない。
	 * 連続してこのメソッドのみが呼び出されることをチャネルは想定していない。
	 *
	 * @exception	ExGOLFormatException
	 *				グローバルオブジェクトロケーションの形式が正しくない。
	 * @exception	ExCellNotFoundException
	 *				指定されたGOLをもつセル（グローバルオブジェクト）が見つからない。
	 * @exception	ExCellNotActiveException
	 *				指定されたGOLをもつセル（グローバルオブジェクト）は活性化されていない。
	 * @exception	ExException
	 *				実行中に例外が発生した。
	 *
	 * @see	OzProxy#join
	 * @see	ExChannel#fork
	 */
	protected final
	void fork()
	throws ExException
	{
		ExThread t = (ExThread)Thread.currentThread();
		ExCallerChannel caller = t.channel;
		caller.fork(this);
	}

	/**
	 * 直前に行なったグローバルアクセスの終了を待って、その戻り値を得る。
	 * メソッド fork() を呼び出した後、このメソッドを呼び出さなければならない。
	 *
	 * @exception	Exception
	 *				例外が発生するが、その詳細はランタイムでしかわからない。
	 *
	 * @see	OzProxy#fork
	 * @see	ExCallerChannel#join
	 * @see	ExChannel#join
	 */
	protected final
	Object join()
	throws Exception
	{
		ExThread t = (ExThread)Thread.currentThread();
		ExCallerChannel caller = t.channel;
		return caller.join();
	}

	/**
	 * コピーインしたセル上のスレッドで最初に呼び出される。
	 */
	public final
	void run()
	{
		Object result;
		boolean status;

		try {
			ExThread t = (ExThread)Thread.currentThread();
			ExCalleeChannel callee = t.channel;
			OzCell invokee = (OzCell)callee.object();
			try {
				result = invoke(invokee);
				status = true;
			} catch (Exception e) {
				Executor.debug(CN,"run",e);
				result = e;
				status = false;
			}
			callee.exit(status, result);
		} catch (Exception e) { // unexpect exception
			Executor.error(CN,"run",e);
		}
	}

	/**
	 * グローバルアクセスの過程の最終段階として、
	 * 実際にグローバルオブジェクトのメソッドを起動する。
	 * 注意点として、他のオブジェクトへのメソッドの起動を
	 * 新しいＯＺのプロセス上で行う場合、実際のメソッドの
	 * 起動はＯＺのプロセスを生成したオブジェクト側にある。
	 * つまり、OzProxyとOzProxyを継承するクラスには新しい
	 * ＯＺのプロセス生成上でメソッドを起動する仕組みとして
	 * ではなく、グローバルアクセスの過程の一部として
	 * このメソッドが起動される。
	 *
	 * @param	invokee	メソッドが起動されるセル（グローバルオブジェクト）
	 * @return			メソッドの戻り値
	 *
	 * @exception	Exception
	 *				例外が発生するが、その詳細はランタイムでしかわからない。
	 *
	 */
	protected Object invoke(OzCell invokee)
	throws Exception
	{
		switch (selector) {
		case INITIALIZE:
			invokee.initialize();
			break;
		case GO:
			invokee.go();
			break;
		case QUIET:
			invokee.quiet();
			break;
		default:
			Executor.error(CN,"invoke","invalid selector = "+selector);
			throw new ExException(CN+"#invoke invalid selector");
		}
		return null;
	}

	/**
	 * クラス OzCell のメソッド initialize に対する
	 * グローバルアクセスを行うためのメソッドである。
	 *
	 * <DL>
	 * <DT>
	 * 【注意】
	 * <DD>
	 * エグゼキュータは状態遷移の処理の過程で、セル（グローバルオブジェクト）の
	 * メソッド initialize を呼び出すが、このメソッドを経由しない。
	 * エグゼキュータはそのための専用のクラスを使う。
	 * </DL>
	 *
	 * @exception	Exception
	 *				例外が発生するが、その詳細はランタイムでしかわからない。
	 *
	 * @see	OzCell#initialize
	 */
	protected
	void initialize()
	throws Exception
	{
		enter();
		try {
			this.selector = INITIALIZE;
			fork();
		} catch (ExGOLFormatException e) {
			Executor.error(CN,"initialize","gol="+gol,e);
			throw new ExException(e.getClass().getName());
		} catch (Exception e) {
			Executor.debug(CN,"initialize","gol="+gol,e);
			throw e;
		} finally {
			leave();
		}
		join();
	}

	/**
	 * クラス OzCell のメソッド go に対する
	 * グローバルアクセスを行うためのメソッドである。
	 *
	 * <DL>
	 * <DT>
	 * 【注意】
	 * <DD>
	 * エグゼキュータは状態遷移の処理の過程で、セル（グローバルオブジェクト）の
	 * メソッド go を呼び出すが、このメソッドを経由しない。
	 * エグゼキュータはそのための専用のクラスを使う。
	 * </DL>
	 *
	 * @exception	Exception
	 *				例外が発生するが、その詳細はランタイムでしかわからない。
	 *
	 * @see	OzCell#go
	 */
	protected
	void go()
	throws Exception
	{
		enter();
		try {
			this.selector = GO;
			fork();
		} catch (ExGOLFormatException e) {
			Executor.error(CN,"go","gol="+gol,e);
			throw new ExException(e.getClass().getName());
		} catch (Exception e) {
			Executor.debug(CN,"go","gol="+gol,e);
			throw e;
		} finally {
			leave();
		}
		join();
	}

	/**
	 * クラス OzCell のメソッド quiet に対する
	 * グローバルアクセスを行うためのメソッドである。
	 *
	 * <DL>
	 * <DT>
	 * 【注意】
	 * <DD>
	 * エグゼキュータは状態遷移の処理の過程で、セル（グローバルオブジェクト）の
	 * メソッド quiet を呼び出すが、このメソッドを経由しない。
	 * エグゼキュータはそのための専用のクラスを使う。
	 * </DL>
	 *
	 * @exception	Exception
	 *				例外が発生するが、その詳細はランタイムでしかわからない。
	 *
	 * @see	OzCell#quiet
	 */
	protected
	void quiet()
	throws Exception
	{
		enter();
		try {
			this.selector = QUIET;
			fork();
		} catch (ExGOLFormatException e) {
			Executor.error(CN,"quiet","gol="+gol,e);
			throw new ExException(e.getClass().getName());
		} catch (Exception e) {
			Executor.debug(CN,"quiet","gol="+gol,e);
			throw e;
		} finally {
			leave();
		}
		join();
	}
}
