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
 * $Id: ExProxy.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 *
 * 注意: このファイルは vi で、hardtab=8, tabstop=4 として編集されている
 */

package JP.go.ipa.oz.system;

/**
 * エグゼキュータは状態遷移の処理の過程で、このクラスを使って生成した
 * オブジェクトを経由して、セル（グローバルオブジェクト）への
 * グローバルアクセスを行う。
 * 状態遷移中に行われるグローバルアクセスは、特別な扱いする必要があり、
 * その実現のためのクラスである。【但し、実装の詳細は未定】
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author		Yasumitsu Yoshida
 */
final
class ExProxy
extends OzProxy
{
	/**
	 * エグゼキュータ実装のデバッグ用
	 */
	static final String CN = "ExProxy";

	/**
	 * OzSystem#getArguments()で取り出すことのできる
	 * 文字列の配列を格納する。
	 */
	private String[] arguments;

	/**
	 * エグゼキュータがセル（グローバルオブジェクト）に
	 * アクセスするためのプロキシを作成する。
	 *
	 * @param	proxy	プロキシ
	 * @exception	ExGOLFormatException
	 *					GOL の形式が正しくない。
	 */
	ExProxy(OzProxy proxy)
	throws ExException
	{
		super(proxy.getName());
		this.arguments = null;
	}

	/**
	 * セル（グローバルオブジェクト）にアクセスするためのプロキシを作成する。
	 * このメソッドを呼び出したスレッドが属するセル（グローバルオブジェクト）の
	 * グローバルオブジェクトロケーションが設定される。
	 *
	 * @see	ExCell
	 */
	ExProxy()
	throws ExException
	{
		super();
	}

	/**
	 * エグゼキュータがセル（グローバルオブジェクト）に
	 * アクセスするためのプロキシを作成する。
	 *
	 * @param	gol	GOL文字列
	 * @exception	ExGOLFormatException
	 *					GOL の形式が正しくない。
	 */
	ExProxy(String gol)
	throws ExException
	{
		super(gol);
		this.arguments = null;
	}

	/**
	 * エグゼキュータがセル（グローバルオブジェクト）に
	 * アクセスするためのプロキシを作成する。
	 *
	 * @param	gol			グローバルオブジェクトロケーション
	 * @param	arguments	OzSystem#getArgumentsで取り出す文字列の配列
	 * @exception	ExGOLFormatException
	 *					GOL の形式が正しくない。
	 */
	ExProxy(String gol, String[] arguments)
	throws ExException
	{
		super(gol);
		this.arguments = arguments;
	}

	/**
	 * エグゼキュータがセル（グローバルオブジェクト）に
	 * アクセスするためのプロキシを作成する。
	 *
	 * @param	god			GODオブジェクト
	 * @exception	ExGOLFormatException
	 *					GOLとしてのGOD名の形式が正しくない。
	 */
	ExProxy(ExGOD god)
	throws ExException
	{
		super(god.getName());
		this.arguments = null;
	}

	/**
	 * エグゼキュータがセル（グローバルオブジェクト）に
	 * アクセスするためのプロキシを作成する。
	 *
	 * @param	god			GODオブジェクト
	 * @param	arguments	OzSystem#getArgumentsで取り出す文字列の配列
	 * @exception	ExGOLFormatException
	 *					GOLとしてのGOD名の形式が正しくない。
	 */
	ExProxy(ExGOD god, String[] arguments)
	throws ExException
	{
		super(god.getName());
		this.arguments = arguments;
	}

	/**
	 * グローバルアクセスの処理の過程の最終段階として、
	 * セル（グローバルオブジェクト）へのメソッド呼出しを行う。
	 *
	 * @param	invokee	メソッドが起動されるセル（グローバルオブジェクト）
	 * @return		メソッドの戻り値
	 *
	 * @exception	Exception
	 *				例外が発生するが、その詳細はランタイムでしかわからない。
	 *
	 */
	protected Object invoke(OzCell invokee)
	throws Exception
	{
		ThreadGroup group = Thread.currentThread().getThreadGroup();
		ExCell cell = null;
		if (group instanceof ExCell) {
			cell = (ExCell)group;
		} else {
			Executor.error(CN,"invoke","illegal thread group = "+group.getClass().getName());
			throw new ExException(CN+"#invoke illegal thread group");
		}
		switch (selector) {
		case INITIALIZE:
			cell.setArguments(arguments);
			invokee.initialize();
			break;
		case GO:
			cell.setArguments(arguments);
			invokee.go();
			break;
		case QUIET:
			cell.setArguments(arguments);
			invokee.quiet();
			break;
		default:
			Executor.error(CN,"invoke","invalid selector = "+selector);
			throw new ExException(CN+"#invoke invalid selector");
		}
		return null;
	}
}
