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
 * $Id: OzCell.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 *
 * 注意: このファイルは vi で、hardtab=8, tabstop=4 として編集されている
 */

package JP.go.ipa.oz.system;

/**
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author		Yasumitsu Yoshida
 */
public
class OzCell
extends OzSecure
{
	/**
	 * エグゼキュータ実装のデバッグ用
	 */
	static final String CN = "OzCell";

	/**
	 * セル（グローバルオブジェクト）自身にはGOLない。
	 * セル（グローバルオブジェクト）のGOLは変更される可能性がある。
	 */

	/**
	 * グローバルアクセスの最終段階で、コピーインされてきたプロキシ（赤オブジェクト）
	 * に対して緑プロセスが生成される。これはローカルアクセスと異なる点である。
	 * 従って、そのプロキシが適切なクラスを使って生成されたオブジェクトであることを
	 * 確かめる必要がある。
	 */
	String proxyClassName;

	/**
	 * 新しいＯＺのセル（グローバルオブジェクト）を作成する。ＯＺのオブジェクトは
	 * 必ず色を持つが、セル（グローバルオブジェクト）の色は常に緑色である。
	 * セル（グローバルオブジェクト）の実際の生成はエグゼキュータが行う。
	 * また、グローバルアクセスを受け入れる際にプロキシのクラス名を
	 * チェックするためにプロキシのクラス名を引数に指定する必要がある。
	 *
	 * @param	proxyClassName	セルの生成に使われたクラスに対応する
	 *							プロキシのパッケージ名を含むクラス名を指定する。
	 * @return	新しいインスタンス
	 */
	protected
	OzCell(String proxyClassName)
	{
		/*
		 * エグゼキュタ以外はセル（グローバルオブジェクト）を生成できない。
		 * また、proxyClassName が null であってはならない。
		 */
		if (proxyClassName == null) {
			throw new SecurityException(
						"According to mach the type of cell and its proxy, "
						+"OzCell and its descendant class should be constructed "
						+"with full-qualified-class-name of the proxy class"
					);
		}
		color = OzSecure.GREEN;
		this.proxyClassName = proxyClassName;
		Executor.debug(CN,"OzCell","() = "+this);
		Executor.debug(CN,"OzCell","proxy class = "+proxyClassName);
	}

	/**
	 * クラス OzProxy のメソッド initialize に対応し、グローバルアクセスの
	 * 最終段階として、コピーインされてきたプロキシがこのメソッドを呼び出す。
	 * エグゼキュータは、セル（グローバルオブジェクト）を生成する時には、
	 * クラス ExProxy を使って生成したプロキシを介してこのメソッドを呼び出す。
	 */
	protected
	void initialize()
	throws Exception
	{
		/* Nothing */
	}

	/**
	 * クラス OzProxy のメソッド go に対応し、グローバルアクセスの
	 * 最終段階として、コピーインされてきたプロキシがこのメソッドを呼び出す。
	 * エグゼキュータは、セル（グローバルオブジェクト）を活性化する時には、
	 * クラス ExProxy を使って生成したプロキシを介してこのメソッドを呼び出す。
	 */
	protected
	void go()
	throws Exception
	{
		/* Nothing */
	}

	/**
	 * クラス OzProxy のメソッド quiet に対応し、グローバルアクセスの
	 * 最終段階として、コピーインされてきたプロキシがこのメソッドを呼び出す。
	 * エグゼキュータは、セル（グローバルオブジェクト）を不活性化する時には、
	 * クラス ExProxy を使って生成したプロキシを介してこのメソッドを呼び出す。
	 */
	protected
	void quiet()
	throws Exception
	{
		/* Nothing */
	}

	/**
	 * セル（グローバルオブジェクト）のGODを返す。
	 *
	 * @return	GOD
	 */
	protected final
	String getName()
	throws ExException
	{
		ExCell cell = ExCell.currentCell();
		return cell.getName();
	}
}
