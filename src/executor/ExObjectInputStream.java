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
 * $Id: ExObjectInputStream.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 *
 * 注意: このファイルは vi で、hardtab=8, tabstop=4 として編集されている
 */

package	JP.go.ipa.oz.system;

import	java.io.InputStream;
import	java.io.ObjectInputStream;
import	java.io.ObjectStreamClass;
import	java.io.IOException;
import	java.io.StreamCorruptedException;

/**
 * Serializeされたオブジェクトをストリームとして読み出して、
 * オブジェクトを作成する。
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author		Yasumitsu Yoshida
 */
class ExObjectInputStream
extends ObjectInputStream
{
	/**
	 * エグゼキュータ実装のデバッグ用
	 */
	static final String CN = "ExObjectInputStream";

	/**
	 * Serializeされたオブジェクトからオブジェクトを作成するために、
	 * オブジェクトとストリームを結び付ける。
	 *
	 * @see	java.io.ObjectInputStream#ObjectInputStream
	 */
	public
	ExObjectInputStream(InputStream is)
	throws IOException, StreamCorruptedException
	{
		super(is);
	}

	/**
	 * オブジェクトをSerializeする時に必要になるクラスを
	 * OZのクラスローダを介して得る。
	 *
	 * 【注意】
	 *		クラスのロードはリトライを含めてOZのクラスローダが
	 *		行っているので、実際にはIOExceptionが発生していても
	 *		OZのクラスローダは、ClassNotFoundException を返す。
	 *		また、OZのクラスローダの呼出しをクラス Executor経由で
	 *		行っているのはクラス Executor に機能を集中するためである。
	 *		しかし、近い将来、クラス Executor の機能は複数のクラスに
	 *		分割される予定である。
	 *
	 * @see	java.io.ObjectInputStream#resolveClass
	 */
	protected
	Class resolveClass(ObjectStreamClass osClass)
	throws ClassNotFoundException
	{
		String cn = osClass.getName();
		try {
			return Executor.loadClass(cn);
		} catch (ClassNotFoundException e) {
			/*
			 * このメソッド resolveClass はコールバックなので
			 * ここでデバッグ情報を出力する必要がある。
			 */
			Executor.debug(CN,"resolveClass","("+cn+")",e);
			throw e;
		}
	}
}
