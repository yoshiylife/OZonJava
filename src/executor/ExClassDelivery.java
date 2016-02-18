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
 * $Id: ExClassDelivery.java,v 1.1 1997/11/07 05:07:55 yoshi Exp $
 */

package	JP.go.ipa.oz.system;

import	java.io.File;
import	java.io.FileInputStream;
import	java.io.FileOutputStream;
import	java.io.IOException;
import	java.io.InputStream;
import	java.io.OutputStream;

/**
 * ローカルリポジトリにクラスアーカイブファイルを登録するための
 * クラス配送をクラス OzLocalRepositoryManager から統一的に
 * 扱えるようにする。クラスアーカイブファイルに関する必要な情報と
 * ファイルの内容をストリームとして提供するクラスである。
 *
 * <DL><DT>
 * 【注意】<DD>
 * このクラスは、クラス OzLocalRepositoryManager から呼び出されるため、
 * エグゼキュータの動作を前提とせずに単独で動作可能でなければならない。
 * ただし、特定のプロパティ等が適切に設定されていることは前提とする。
 * <DT>
 * 【コメント】<DD>
 * 現状では、このクラスを継承するクラスはないが、将来的には
 * このクラスを継承してクラス配送のプロトコル毎にクラスを
 * 作成した方がよいかもしれない。
 * </DL>
 *
 * @see OzLocalRepositoryManager
 * @see ExClassLoader
 *
 * @version		$Revision: 1.1 $, $Date: 1997/11/07 05:07:55 $
 * @author		Yasumitsu Yoshida
 */
class	ExClassDelivery
{

    /**
     * エグゼキュータ実装のデバッグ用
     */
    protected static String CN = "ExClassDelivery";

    /**
     * デバッグ用フラグ
     */
    protected static boolean debug
	= (System.getProperty(ExClassDelivery.class.getName()+".debug") != null) ? true : false;

    /**
     * string representing size of buffer to copy class archive file
     */
    static private String bufferSizeProperty
	= System.getProperty("oz.classDelivery.download.bufferSize");

    /**
     * Size of buffer to copy class archive file
     */
    static final int bufferSize
	= (bufferSizeProperty != null) ? Integer.parseInt(bufferSizeProperty) : 1024;

    /**
     * The length of the content
     */
    protected final long length;

    /**
     * Input stream to delivery class archive file.
     */
    protected final InputStream in;

    /**
     * Top package name of class archive file to delivery.
     */
    protected final String topPackageName;

    /**
     * The flag is true if the zip file is transfered.
     */
    protected boolean transfered;

    /**
     * ログ記録のためのメッセージを出力する。
     * 但し、エグゼキュータの動作を前提にできないので、
     * メッセージは標準エラー出力に出力する。
     *
     * @param	methodName	メッセージに付加されるメソッド名
     * @param	message		出力するメッセージ
     */
    protected
    void syslog(String methodName, String message)
    {
	System.err.println(CN+"#"+methodName+": "+message);
    }

    /**
     * このクラスの属性 debug がtrueならば、デバッグのための
     * メッセージを出力する。
     * 但し、エグゼキュータの動作を前提にできないので、
     * メッセージは標準エラー出力に出力する。
     * <DL><DT>
     * 【注意】<DD>
     * クラス Executor の属性 debug を参照しているが、
     * エグゼキュータの動作なしにこの属性がtrueとなることはない。
     * エグゼキュータが動作している場合、標準エラー出力は
     * ログ記録の対象となるためにこのような実装となっている。
     * </DL>
     *
     * @param	methodName	メッセージに付加されるメソッド名
     * @param	message		出力するメッセージ
     */
    protected
    void debug(String methodName, String message)
    {
	if (debug) {
	    if (Executor.debug) {
		Executor.debug(CN, methodName, message);
	    } else {
		System.err.println(CN+"#"+methodName+": "+message);
	    }
	}
    }

    /**
     * クラスアーカイブファイルを作成するために必要な情報と
     * ファイルの内容を取り出すストリームを提供するための
     * オブジェクトを生成する。
     *
     * @param	topPackageName	クラスアーカイブファイルのトップパッケージ名
     * @param	in		クラスアーカイブファイルの内容を読み出すためのストリーム
     * @param	length		クラスアーカイブファイルの長さ
     * @exception
     *		IOException	ファイル操作等の入出力で例外が発生した。
     */
    protected
    ExClassDelivery(String topPackageName, InputStream in, long length)
    throws IOException
    {
	this.topPackageName = topPackageName;
	this.length = length;
	this.in = in;
    }

    /**
     * クラスアーカイブファイルを作成するために必要な情報と
     * ファイルの内容を取り出すストリームを提供するための
     * オブジェクトを生成する。
     *
     * @param	topPackageName	クラスアーカイブファイルのトップパッケージ名
     * @param	file		ローカルにあるクラスアーカイブファイル
     * @exception
     *		IOException	ファイル操作等の入出力で例外が発生した。
     */
    protected
    ExClassDelivery(String topPackageName, File file)
    throws IOException
    {
	this.topPackageName = topPackageName;
	this.length = file.length();
	this.in = new FileInputStream(file);
    }

    /**
     * クラスアーカイブファイルをダウンロードし、
     * 指定されたファイルに保存する。
     *
     * @param	file		クラスアーカイブファイルを保存するファイル
     * @exception
     *		IOException	ファイル操作等の入出力で例外が発生した。
     *				あるいは、クラスアーカイブファイルの内容が不適切である。
     */
    void download(File file)
    throws IOException
    {
	OutputStream out = new FileOutputStream(file);
	byte[] buffer = new byte[bufferSize];
	int total = 0;
	int n;
	debug("download", "transfer "+file.getPath());
	while ((n = in.read(buffer)) != -1) {
	    out.write(buffer, 0, n);
	    total += n;
	}
	debug("download", "finished "+file.getPath());
	out.close(); out = null;
	debug("download", "total "+total+" bytes saved to "+file.getPath());
	if (total != length) {
	    String message = "Incorrect file length: "+file.getPath();
	    syslog("download", message);
	    throw new IOException(message);
	}
	transfered = true;
    }

    /**
     * 配送されるクラスアーカイブファイルが登録されるべき
     * トップパッケージ名を返す。
     *
     * @return	トップパッケージ名
     */
    String getName()
    {
	return topPackageName;
    }

    /**
     * 配送されるクラスアーカイブファイルの長さを返す。
     *
     * @return	クラスアーカイブファイルの長さ
     */
    long length()
    {
	return length;
    }

    /**
     * クラスアーカイブファイルの配送（ダウンロード）処理が
     * 行われたどうかを返す。
     *
     * @return	配送（ダウンロード）処理が行われた場合は、true を返す。
     */
    boolean isTransfered()
    {
	return transfered;
    }

    /**
     * クラス配送に使用したストリーム等を終了処理する。
     * @exception
     *		IOException	ファイル操作等の終了処理で例外が発生した。
     */
    void close()
    throws IOException
    {
	in.close();
    }

    /**
     * このクラスを使って作成されたオブジェクトの文字列表現として
     * トップパッケージ名を使用する。
     *
     * @return	トップパッケージ名
     */
    public
    String toString()
    {
	return getName();
    }
}
