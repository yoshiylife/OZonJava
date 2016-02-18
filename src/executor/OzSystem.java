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
 * $Id: OzSystem.java,v 2.2 1997/11/07 05:10:58 yoshi Exp $
 *
 * 注意: このファイルは vi で、hardtab=8, tabstop=4 として編集されている
 */

package JP.go.ipa.oz.system;

import java.io.InputStream;
import java.io.PrintStream;

/**
 * ランタイムサービスを提供するためのクラスである。
 * このクラスには、static メソッドのみが定義される。
 * ExSecurityManager を直接に呼び出すことによりセキュリティを確保する。
 * このクラスはエグゼキュータ外へ公開されるので、
 * セキュリティに十分注意して実装を行う必要がある。
 * <DL>
 * <DT>
 * 【注意】
 * <DD>
 * 現時点(Thu May 8 13:47:42 JST 1997)で、ExSecurityManager との
 * インタフェースが不明な点があるため、コメントのみで必要な
 * メソッド呼び出しを行っていない部分がある。
 * セキュリティ確保ができていないので実装しなおす必要がある。
 * </DL>
 *
 * @version		$Revision: 2.2 $, $Date: 1997/11/07 05:10:58 $
 * @author		Yasumitsu Yoshida
 */
public final
class OzSystem
{
	/**
	 * エグゼキュータ実装のデバッグ用
	 */
	static final String CN = "OzSystem";

	/**
	 * このクラスは static メソッド（クラスメソッド）のみを持つ。
	 * また、このクラスのオブジェクトを生成して使用しない。
	 * このクラスは public であり、また、エグゼキュータの実装に依存する
	 * 部分が含まれるので、このクラスのオブジェクトが外部に持ち出され
	 * ないようにする必要がある。
	 */
	private
	OzSystem()
	{
		/* Nothing */
	}

	/**
	 * エグゼキュータの標準入力を得る。
	 * エグゼキュータの標準入力は必ずしも
	 * JavaVM の標準入力と一致するとは限らない。
	 * <DL>
	 * <DT>
	 * 【注意】
	 * <DD>
	 * 現在、少なくともSolaris(SPARC)版では標準入力(tty)からの入力待ちになると
	 * JavaVM のスケジューラが停止する。従って、標準入力からの入力待ちになる
	 * 状態では、他に実行可能なスレッドがあっても実行されない。
	 * </DL>
	 * @return		標準入力ストリーム
	 */
	public static
	InputStream getStdin()
	{
		// セキュリティマネージャの呼出し
		// ? Executor.getSecurityManager().ozCheckGetStdin()
		if (Executor.securityManager != null) {
			Executor.securityManager.tryGetStdin();
		}
		return Executor.stdin; // スクリプトが stdin に設定されているかもしれない。
	}

	/**
	 * エグゼキュータの標準出力を得る。
	 * エグゼキュータの標準出力は必ずしも
	 * JavaVM の標準出力と一致するとは限らない。
	 *
	 * @return		標準出力ストリーム
	 */
	public static
	PrintStream getStdout()
	{
		// セキュリティマネージャの呼出し
		// ? Executor.getSecurityManager().ozCheckGetStdout()
		if (Executor.securityManager != null) {
			Executor.securityManager.tryGetStdout();
		}
		return Executor.stdout;
	}

	/**
	 * エグゼキュータの標準エラー出力を得る。
	 * エグゼキュータの標準エラー出力は必ずしも
	 * JavaVM の標準エラー出力と一致するとは限らない。
	 *
	 * @return		標準エラー出力ストリーム
	 */
	public static
	PrintStream getStderr()
	{
		// セキュリティマネージャの呼出し
		// ? Executor.getSecurityManager().ozCheckGetStderr()
		if (Executor.securityManager != null) {
			Executor.securityManager.tryGetStderr();
		}
		return Executor.stderr;
	}

	/**
	 * エグゼキュータのシェルのコマンド、あるいは、起動時に指定された
	 * グローバルオブジェクトは、その操作時に複数の指定された文字列の
	 * 配列を得ることができる。このメソッドはその複数の文字列を
	 * クラス String の配列として返す。
	 * 配列の最初の要素は操作方法により次のように設定される。
	 * <DL>
	 * <DT>
	 * エグゼキュータのシェルのコマンド操作の場合
	 * <DD>
	 * シェルのコマンド操作では、グローバルオブジェクトが獲得
	 * できる複数の文字列をオプションとして指定することができる。
	 * このオプションとして指定された最初の文字列がこのメソッドが
	 * が返す配列の最初の要素となる。その配列の最初の要素より後は、
	 * 指定された文字列が順に配列の要素として設定される。
	 * このオプションが指定されていない場合は、このメソッドはnullを返す。
	 * <DT>
	 * エグゼキュータの起動時に指定した場合
	 * <DD>
	 * エグゼキュータは起動時にコマンド名を必ず指定しなければならない。
	 * また、エグゼキュータのシェルのスクリプトに渡すための複数の文字列を
	 * オプションとして指定することができる。
	 * このメソッドが返す配列の最初の要素は、このコマンド名である。
	 * 配列の最初の要素より後は、このオプションとして指定された文字列が
	 * 順に配列の要素として設定される。
	 * </DL>
	 *
	 * @return		文字列の配列
	 * @exception	ExException
	 *					このメソッドから直接は発生しない。
	 */
	public static
	String[] getArguments()
	throws ExException
	{
		// セキュリティマネージャの呼出し
		if (Executor.securityManager != null) {
			Executor.securityManager.tryGetArguments();
		}

		ExCell cell = ExCell.currentCell();
		return cell.getArguments();
	}

	/**
	 * 標準出力に文字列(String)を出力し、最後に改行を行う。
	 * この標準出力とは、エグゼキュータが起動時に
	 * 設定されていた標準出力で、必ずしもエグゼキュータの標準出力と一致しない。
	 * 例えば、エグゼキュータは起動時の指定により、標準出力をファイルに
	 * 設定する場合も考えられるが、このメソッドはその設定の影響を受けない。
	 * このメソッドで出力される文字列は、同時に呼び出されたこのメソッドで
	 * 出力される文字列と混じることはない。但し、標準出力にこのメソッド
	 * 以外のメソッドを使って出力を行った場合はこの限りではない。
	 *
	 * @see	OzSystem#debugPrintln
	 */
	public static
	void println(String oneLine)
	{
		Executor.out.println(oneLine);
	}

	/**
	 * 標準出力に文字列(String)を出力し、最後に改行を行う。
	 * 通常は出力されないが、エグゼキュータの起動時の指定、あるいは、
	 * シェルからのコマンドにより出力を制御することができる。
	 *
	 * @see	OzSystem#println
	 */
	public static
	void debugPrintln(String oneLine)
	{
		ThreadGroup group = Thread.currentThread().getThreadGroup();
		if (group instanceof ExCell) {
			ExCell cell = (ExCell)group;
			if (cell.debug) {
				Executor.out.println(oneLine);
			}
		} else {
			if (Executor.debug) {
				Executor.out.println(oneLine);
			}
		}
	}

	/**
	 * このメソッドを呼び出しを実行したスレッドが属する
	 * セル（スレッドグループ）にユーザセキュリティオブジェクトを設定する。
	 *
	 * @param	us	ユーザセキュリティオブジェクト
	 * @exception	ExException
	 *					このメソッドから直接は発生しない。
	 * @exception	SecurityException
	 *					セキュリティマネージャが想定(ExSecurityManager)したものではない。
	 *
	 * @see	ExSecurityManager#setUserSecurity
	 * @see	OzUserSecurity
	 */
	public static
	void setUserSecurity(OzUserSecurity us)
	throws ExException
	{
		// セキュリティマネージャの呼出し
		// ? Executor.getSecurityManager().ozCheckSetUserSecurity(us)

		ExCell cell = ExCell.currentCell();
		SecurityManager sm = System.getSecurityManager();
		if (!(sm instanceof ExSecurityManager)) {
			SecurityException e = new SecurityException("Not security manager with OZ");
			Executor.debug(CN,"setUserSecurity",e);
			throw e;
		}
		ExSecurityManager oz = (ExSecurityManager)sm;
		oz.setUserSecurity(cell,us);
	}

	/**
	 * エグゼキュータのプロパティにキー oz.home で登録されている
	 * 内容を得る。
	 *
	 * @return		登録されている文字列
	 * @exception	ExException
	 *					発生しない。
	 *
	 * @see	java.lang.System#getProperty
	 */
	public static
	String getOzHome()
	throws ExException
	{
		return System.getProperty("oz.home");
	}

	/**
	 * エグゼキュータのプロパティにキー oz.home で登録されている
	 * 内容を得る。（前回との互換性を保つため）
	 *
	 * @deprecated As of previos executor system I/F
	 *
	 * @return		登録されている文字列
	 * @exception	ExException
	 *					発生しない。
	 *
	 * @see	java.lang.System#getProperty
	 */
	public static
	String getOzHomePath()
	throws ExException
	{
		return getOzHome();
	}
}
