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
 * $Id: ExAddressManager.java,v 2.2 1997/12/04 04:55:19 yoshi Exp $
 *
 */

package	JP.go.ipa.oz.system;

import	java.io.File;
import	java.io.FileInputStream;
import	java.io.FileOutputStream;
import	java.io.IOException;
import	java.io.PrintWriter;
import	java.util.Dictionary;
import	java.util.Enumeration;
import	java.util.Hashtable;

/**
 * 使われた通信アドレスのテーブルを持ち、
 * GOLから通信アドレスへの変換やそのテーブルのメンテナンスを行う。
 * 通信アドレスはセルがグローバルアクセスを受け付けない状態であっても
 * 他のセルへのグローバルアクセスを行うのであれば必要である。
 * 但し、同じエグゼキュータ上のセルへのグローバルアクセスの場合は
 * 通信アドレスを必要としない。
 * GOD下のファイルのメンテナンスも同時に行う。
 *
 * <DL><DT>
 * 【メモ】<DD>
 * ユーザに公開するクラスを介して、リゾルバとのやりとりを
 * 行うための実装の役割を持つかもしれない。
 * </DL>
 *
 * @version	$Revision: 2.2 $, $Date: 1997/12/04 04:55:19 $
 * @author	Yasumitsu Yoshida
 */
final
class ExAddressManager
{
    /**
     * エグゼキュータ実装のデバッグ用
     */
    static final String CN = "ExAddressManager";

    /**
     * このクラスのデバッグ用フラグ
     */
    protected static boolean debug
	= (System.getProperty(ExAddressManager.class.getName()+".debug") != null) ? true : false;

    /**
     * 通信アドレスを書き込むファイル名
     */
    private static final String addressFilename = ".location";

    /**
     * GOL をキーとして通信アドレスを得るためのテーブルである。
     *
     * <DL><DT>
     * 【注意】<DD>
     * 異なるエグゼキュータ上のセル（グローバルオブジェクト）に
     * グローバルアクセスを行う際に、その戻り値を返すために
     * 通信アドレスが使われる。従って、グローバルアクセスが
     * 行われる前に、このテーブルに通信アドレスが登録されている
     * 必要がある。
     * </DL>
     */
    private static Dictionary addressCache = new Hashtable();

    protected static
    void debug(String methodName, String message)
    {
	if (debug) {
	    if (Executor.debug) {
		Executor.debug(CN, methodName, message);
	    } else {
		Executor.syslog(CN, methodName, message);
	    }
	}
    }

    protected static
    void debug(String methodName, Throwable ball)
    {
	if (debug) {
	    if (Executor.debug) {
		Executor.debug(CN, methodName, ball);
	    } else {
		Executor.syslog(CN, methodName, ball);
	    }
	}
    }

    protected static
    void debug(String methodName, String message, Throwable ball)
    {
	if (debug) {
	    if (Executor.debug) {
		Executor.debug(CN, methodName, message, ball);
	    } else {
		Executor.syslog(CN, methodName, message, ball);
	    }
	}
    }

    /**
     * クラス ExAddressManager は１つのエグゼキュータに
     * １つであり、動作中に実装が変更されることもない。
     * 従って、クラス ExAddressManager を使って
     * オブジェクトを生成しないようにし、
     * staticメソッドのみを定義する。
     */
    private
    ExAddressManager()
    {
	/* Nothing */
    }

    /**
     * 通信アドレスをファイルから読み込む。
     *
     * <DL><DT>
     * 【注意】<DD>
     * メソッドの戻り値として null を返してはならない。
     * </DL>
     *
     * @param	god	GODオブジェクト
     * @return		読み込んだ通信アドレス
     * @exception	ExCellNotFoundException
     *				指定された GOD のセル（グローバルオブジェクト）が見つからない。
     * @exception	ExCellNotActiveException
     *				指定された GOD のセル（グローバルオブジェクト）が活性化されていない。
     * @exception	ExException
     *				通信アドレスのファイルの読み込みに失敗した等。
     */
    private static
    ExCommAddress read(ExGOD god)
    throws ExCellNotFoundException, ExCellNotActiveException, ExException
    {
	debug("read","(god="+god+")");
	File location = new File(god,addressFilename);
/*
	File inactive = new File(god,ExGOD.unlockFilename);
	File objectImage = new File(god,ExCell.objectImageFilename);
*/
	debug("read","location="+location);
	if (ExCellManager.exists(god)) {
/*
	if (god.exists() && god.isDirectory() && (location.exists() || objectImage.exists())) {
	    if (! inactive.exists()) {
// for vi: }}
*/
	    if (god.knock()) {
		try {
		    ExCommAddress result;
		    ExObjectInputStream in = new ExObjectInputStream(new FileInputStream(location));
		    result = (ExCommAddress)in.readObject();
		    in.close();
		    debug("read","() = "+result+" from location="+location);
		    return result;
		} catch (Exception e) {
		    Executor.error(CN,"read","(god="+god+")",e);
		    throw new ExException(e.getClass().getName());
		}
	    } else {
		throw new ExCellNotActiveException(god.getName());
	    }
	}
	throw new ExCellNotFoundException(god.getName());
    }

    /**
     * 通信アドレスをファイルに書き込む
     *
     * @param	god	GODオブジェクト
     * @param	address	通信アドレス
     * @exception	ExCellNotFoundException
     *				指定された GOD のセル（グローバルオブジェクト）が見つからない。
     * @exception	ExCellNotActiveException
     *				指定された GOD のセル（グローバルオブジェクト）が活性化されていない。
     * @exception	ExException
     *				通信アドレスのファイルの書き込みに失敗した等。
     */
    private static
    void write(ExGOD god,ExCommAddress address)
    throws ExCellNotFoundException, ExCellNotActiveException, ExException
    {
	debug("write","(god="+god+",address="+address+")");
	File location = new File(god,addressFilename);
	debug("write","location="+location);
	if (god.exists() && god.isDirectory()) {
	    if (god.knock()) {
		try {
		    ExObjectOutputStream out = new ExObjectOutputStream(new FileOutputStream(location));
		    out.writeObject(address);
		    out.close();
		    debug("write","(god="+god+",address="+address+") ok");
		    return;
		} catch (Exception e) {
		    Executor.error(CN,"write","(god="+god+",address="+address+")",e);
		    throw new ExException(e.getClass().getName());
		}
	    } else {
		throw new ExCellNotActiveException(god.getName());
	    }
	}
	throw new ExCellNotFoundException(god.getName());
    }

    /**
     * 通信アドレスのファイルを削除する。
     *
     * @param	god	GODオブジェクト
     * @exception	ExCellNotFoundException
     *				指定された GOD のセル（グローバルオブジェクト）が見つからない。
     */
    private static
    void delete(ExGOD god)
    throws ExCellNotFoundException
    {
	debug("delete","(god="+god+")");
	File location = new File(god,addressFilename);
	if (god.exists() && god.isDirectory()) {
	    if (location.delete()) {
		debug("delete","location="+location);
		debug("delete","(god="+god+") ok");
	    } else {
		Executor.error(CN,"delete","location="+location);
	    }
	    return;
	}
	throw new ExCellNotFoundException(god.getName());
    }

    /**
     * 指定された GOL に対応する通信アドレスの解決をキャッシュ
     * を使って行う。キャッシュ上にない場合は、通信アドレスの
     * のファイルを直接読み込むか、あるいは、OzHomeResolver に
     * 問い合わせてた上でキャッシュに登録する。
     *
     * @param	gol	GOL（グローバルオブジェクトロケーション）
     * @param	failed	通信が行うことができなかった通信アドレス
     * @return		通信アドレス
     * @exception	ExCellNotFoundException
     *				通信アドレスの解決の結果、指定された GOL に
     *				対応するセル（グローバルオブジェクト）は見つからなかった。
     * @exception	ExCellNotActiveException
     *				通信アドレスの解決の結果、指定された GOL に
     *				対応するセル（グローバルオブジェクト）は活性化されていなかった。
     * @exception	ExException
     *				エグゼキュータ内部の処理で予期していない例外が発生した。
     */
    private static
    ExCommAddress load(ExGOL gol, ExCommAddress failed)
    throws ExCellNotFoundException, ExCellNotActiveException, ExException
    {
	debug("load", "(gol="+gol+",failed="+failed+")");
	ExCommAddress result = null;
	for (;;) {
	    Object o = addressCache.get(gol);
	    if (o == null) {
		ExFakeObject current = new ExFakeObject();
		o = addressCache.put(gol, current);
		if (o == null) {
		    try {
			if (gol.inside()) {
			    ExGOD god = new ExGOD(gol);
			    result = read(god);
			} else {
			    Object[] args = new Object[3];
			    args[0] = new Integer(Executor.RESOLVE);
			    args[1] = gol.getName();
			    args[2] = failed;
			    OzProcess p = Executor.syscall(args);
			    try {
				result = (ExCommAddress)p.join();
			    } catch (ExProcessException e) {
				    throw e.getException();
			    }
			}
			addressCache.put(gol, result);
			current.ready();
			debug("load", "***** LOADED "+gol.getName()+" = "+result);
		    } catch (Exception e) {
			addressCache.remove(gol);
			current.abort();
			if (e instanceof ExCellNotFoundException) {
			    Executor.debug(CN,"load","(gol="+gol+",failed="+failed+")",e);
			    throw (ExCellNotFoundException)e;
			} else if (e instanceof ExCellNotActiveException) {
			    Executor.debug(CN,"load","(gol="+gol+",failed="+failed+")",e);
			    throw (ExCellNotActiveException)e;
			}
			Executor.error(CN,"load","(gol="+gol+",failed="+failed+")",e);
			throw new ExException(e.getClass().getName());
		    }
		} else {
		    if (o instanceof ExFakeObject) {
			debug("load","***** wait "+gol.getName());
			ExFakeObject fake = (ExFakeObject)o;
			if (fake.await()) {
			    current.ready();
			    /* Retry */
			} else {
			    current.abort();
			    throw new ExCellNotFoundException(gol.getName());
			}
		    } else {
			debug("load","***** reset "+gol.getName());
			addressCache.put(gol, o);
			current.ready();
			result = (ExCommAddress)o;
			break;
		    }
		}
	    } else {
		if (o instanceof ExFakeObject) {
		    debug("load","***** WAIT "+gol.getName());
		    ExFakeObject fake = (ExFakeObject)o;
		    if (! fake.await()) {
			throw new ExCellNotFoundException(gol.getName());
		    }
		} else {
		    result = (ExCommAddress)o;
		    break;
		}
	    }
	}
	debug("load", "(gol="+gol+",failed="+failed+") = "+result);
	return result;
    }

    /**
     * 指定された GOL の通信アドレスをキャッシュから削除する。
     *
     * @param	gol	GOL（グローバルオブジェクトロケーション）
     * @return		登録されていた通信アドレス、登録されていなければ null を返す。
     *
     * @see	ExAddressManager#addressCache
     */
    private static
    void remove(ExGOL gol)
    {
	debug("remove","(gol="+gol+")");
	for (;;) {
	    Object o = addressCache.remove(gol);
	    if (o != null) {
		if (o instanceof ExFakeObject) {
		    // 登録処理中なので処理の終了を待って、再度やり直す。
		    ExFakeObject fake = (ExFakeObject)o;
		    if (! fake.await()) {
			debug("remove","(gol="+gol+"): Aborted");
			break;
		    }
		} else {
		    break;
		}
	    } else {
		debug("remove","(gol="+gol+"): Not found");
		break;
	    }
	}
	debug("remove","(gol="+gol+") ok");
    }

    /**
     * 指定された GOL に対応する通信アドレスの解決を行う。
     * 通信アドレスの解決に失敗した場合は例外を発生する。
     * このメソッドは当該エグゼキュータと同じOZホーム内の
     * セル（グローバルオブジェクト）の通信アドレスの解決を行う。
     * また、その通信アドレスが無効であることが判明すると、
     * セル管理を呼び出して、対応する GOD のリカバリーを行う。
     *
     * @param	gol	GOL（グローバルオブジェクトロケーション）
     * @param	failed	通信が行うことができなかった通信アドレス
     * @return		通信アドレス
     * @exception	ExCellNotFoundException
     *				通信アドレスの解決の結果、指定された GOL に
     *				対応するセル（グローバルオブジェクト）は見つからなかった。
     * @exception	ExCellNotActiveException
     *				通信アドレスの解決の結果、指定された GOL に
     *				対応するセル（グローバルオブジェクト）は活性化されていなかった。
     * @exception	ExException
     *				エグゼキュータ内部の処理で予期していない例外が発生した。
     *
     * @see	addressCache
     */
    static
    ExCommAddress resolve(ExGOL gol, ExCommAddress failed)
    throws ExCellNotFoundException, ExCellNotActiveException, ExException
    {
	debug("resolve", "(gol="+gol+",failed="+failed+")");
	ExCommAddress result = null;
	result = load(gol, failed);

	if (failed != null && failed.equals(result)) {
	    remove(gol);
	    result = load(gol, failed);
	    if (failed.equals(result)) {
		String message = "New resolved address is the failed address.";
		Executor.syslog(CN, "resolve", "(gol="+gol+",failed="+failed+"): "+message);
		throw new ExCellNotFoundException(gol.getName());
	    }
	}
	debug("resolve", "(gol="+gol+",failed="+failed+") = "+result);
	return result;
    }

    /**
     * 指定された GOD のファイルに通信アドレスを
     * 書き出した上で、対応するGOLの通信アドレスをキャッシュに登録する。
     *
     * @param	god	GODオブジェクト
     * @param	address	通信アドレス
     * @return		既に登録されていた通信アドレス、登録されていなければ null を返す。
     *
     * @see	ExAddressManager#addressCache
     */
    static
    ExCommAddress put(ExGOD god, ExCommAddress address)
    throws ExCellNotFoundException, ExCellNotActiveException, ExGOLFormatException, ExException
    {
	debug("put", "(god="+god+",address="+address+")");
	ExCommAddress result;
	write(god, address);
	result = load(new ExGOL(god), null);
	debug("put", "(god="+god+",address="+address+") = "+address);
	return result;
    }

    /**
     * 指定された GOD の通信アドレスのファイルを
     * 削除した上で、対応するGOLの通信アドレスをキャッシュから削除する。
     *
     * @param	god	GODオブジェクト
     * @return		既に登録されていた通信アドレス、登録されていなければ null を返す。
     *
     * @see	ExAddressManager#addressCache
     */
    static
    void remove(ExGOD god)
    throws ExCellNotFoundException, ExGOLFormatException
    {
	debug("remove", "(god="+god+")");
	delete(god);
	remove(new ExGOL(god));
    }

    /**
     * 指定された GOD に有効な通信アドレスのファイルが
     * あるかを調べる。
     */
    static
    boolean exists(ExGOD god)
    {
	if (god.knock()) {
	    File location = new File(god,addressFilename);
	    return location.exists();
	}
	return false;
    }

    /*
     * これ以降はデバッグとシェルのためのプログラムである。
     * （詳細は省略）
     */
    static {

	/*
	 * 通信アドレス（キャッシュ）の表示コマンド
	 */
	class List
	extends ExShellCommand
	{
	    List()
	    {
		usage = " [<gol>]";
		comment = "list of addresses in cache";
	    }

	    String action(ExShell shell, String[] args)
	    throws Exception
	    {
		if (2 < args.length) {
		    shell.stderr.println("Usage: "+args[0]+usage);
		    throw new IllegalArgumentException("Too many arguments");
		}
		if (args.length == 2) {
		    shell.stdout.println(resolve(new ExGOL(args[1]),null));
		} else {
		    Enumeration keys = addressCache.keys();
		    while (keys.hasMoreElements()) {
			ExGOL gol = (ExGOL)keys.nextElement();
			shell.stdout.println(resolve(gol,null)+" "+gol.getName());
		    }
		}

		return null;
	    }
	}

	ExShell.append("address",new List());
    }
}
