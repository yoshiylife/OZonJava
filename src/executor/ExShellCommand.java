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
 * $Id: ExShellCommand.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 *
 * 注意: このファイルは vi で、hardtab=8, tabstop=4 として編集されている
 */

package JP.go.ipa.oz.system;

/**
 * シェルのコマンドとして登録するには
 * このクラスを継承しなければならない。
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author		Yasumitsu Yoshida
 */
abstract 
class ExShellCommand
{
	/**
	 * コマンドの簡単な使い方（改行を含まない）
	 */
	String usage;

	/**
	 * コマンドの簡単なコメント（改行を含まない）
	 */
	String comment;

	/**
	 * このコマンドを実行する。
	 *
	 * @param	shell	このコマンドを実行したシェル
	 * @param	args	このコマンドを実行する時の引数
	 * @return	このコマンドを実行した結果
	 */
	abstract String action(ExShell shell, String[] args) throws Exception;
}
