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
 * $Id: ExAddressResolver.java,v 2.1 1997/12/04 04:55:19 yoshi Exp $
 *
 */

package	JP.go.ipa.oz.system;

import	java.io.DataInputStream;
import	java.io.DataOutputStream;
import	java.io.IOException;
import	java.io.InterruptedIOException;
import	java.lang.InterruptedException;
import	java.net.InetAddress;
import	java.net.Socket;
import	java.net.URL;
import	java.net.UnknownHostException;
import	java.util.Dictionary;
import	java.util.Enumeration;
import	java.util.Hashtable;

/**
 * OzHomeResolver と通信を行い異なるOZホーム間での通信アドレス解決を行う。
 * このクラスを使って作成されたオブジェクトは、OzHomeResolverと１対１の
 * 関係を持ち、OzHomeResolver への通信アドレス解決要求やOzHomeResolver
 * からの応答の監視を行う。このオブジェクトは、OzHomeResolver からの
 * 応答を監視する１つのスレッドを持ち、待機テーブルを使って応答に対応する
 * スレッドに通知（ディスパッチ）する。OzHomeResolver との通信にエラーが
 * 発生した場合、待機テーブルを使って待機中のスレッドに通信エラーを通知する。
 *
 * @version	$Revision: 2.1 $, $Date: 1997/12/04 04:55:19 $
 * @author	Yasumitsu Yoshida
 */
final
class ExAddressResolver
extends Thread
{
    /**
     * エグゼキュータ実装のデバッグ用
     */
    static final String CN = "ExAddressResolver";

    /**
     * このクラスのデバッグ用フラグ
     */
    protected static boolean debug
	= (System.getProperty(ExAddressResolver.class.getName()+".debug") != null) ? true : false;

    /**
     * OzHomeResolver からの応答のタイムアウト時間（秒）を表す文字列
     */
    static final String timeoutProperty
	= System.getProperty("oz.resolve.timeout");

    /**
     * OzHomeResolver からの応答のタイムアウト時間（ミリ秒）
     */
    static final long resolveTIMEOUT
	= ((timeoutProperty != null) ? Long.parseLong(timeoutProperty) : 30 ) * 1000; /* default */

    /**
     * 通信アドレス解決のリトライ回数を表す文字列
     */
    static final String retryProperty
	= System.getProperty("oz.resolve.retry");

    /**
     * 通信アドレス解決のリトライ回数を表す文字列
     */
    static final int resolveRETRY
	= (retryProperty != null) ? Integer.parseInt(retryProperty) : 5; /* default */

    /**
     * OzHomeResolver の通信アドレス（サーバポート）を表す文字列
     */
    static final String resolverProperty
	= System.getProperty("oz.home.resolver");

    /**
     * OzHomeResolver のＵＲＬ形式の通信アドレス（サーバポート）
     * <DL><DT>
     * 【注意】<DD>
     * 設定されない（値が null）こともある。
     * </DL>
     */
    static final String resolverURL
	= (resolverProperty != null) ? "http://"+resolverProperty+"/" : null;

    /**
     * 通信アドレス解決要求時のタグ
     */
    static final String requestTag = "REQ";

    /**
     * 通信アドレス解決成功応答時のタグ
     */
    static final String successResponseTag = "RES";

    /**
     * 通信アドレス解決失敗応答時のタグ
     */
    static final String failureResponseTag = "NA";

    /**
     * 無いことを示すIPアドレス
     */
    static final String  nothingHostAddress = "0.0.0.0";

    /**
     * リゾルバーを保持する変数(resolver)の排他制御に使用する。
     */
    private static final Object lock = new Object();

    /**
     * OzHomeResolverに対応するリゾルバーを保持する
     */
    private static ExAddressResolver resolver = null;

    /**
     * 何らかの問題が発生したことを示すフラグ
     */
    private boolean trouble = false;

    /**
     * OzHomeResolver からの応答のタイムアウト時間（ミリ秒）
     */
    private final long timeout;

     /**
      * OzHomeResolver とのTCPコネクションのソケット
      */
     private final Socket socket;

     /**
      * OzHomeResolver へのデータ送信用ストリーム
      */
     private final DataInputStream in;

     /**
      * OzHomeResolver からのデータ受信用ストリーム
      */
     private final DataOutputStream out;

    /**
     * OzHomeResolver からの応答を待つテーブル（待機テーブル）
     */
    private Dictionary standbys = new Hashtable();

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
     * OzHomeResolver と通信を行い異なるOZホーム間での通信アドレス解決を行う。
     *
     * @param	gol	通信アドレス解決を行う対象のGOL
     * @param	failed	前回の通信（グローバルアクセス）で失敗した通信アドレス
     *			但し、該当がなければ null を指定する。
     * @return	通信アドレスを返す。
     * @exception	ExCellNotFoundException
     *			指定されたGOLに対応する（セル）グローバルオブジェクトの
     *			通信アドレスを解決することができない。
     */
    static
    ExCommAddress resolve(String gol, ExCommAddress failed)
    throws ExCellNotFoundException
    {
	ExAddressResolver agent = null;
	for (int retry = 1; retry <= resolveRETRY; retry ++) {
	    try {
		synchronized (lock) {
		    if (resolver == null) {
			if (resolverURL == null) {
			    Executor.syslog(CN, "resolve", "oz.home.resolver is null");
			    throw new ExCellNotFoundException(gol);
			} else {
			    resolver = new ExAddressResolver(resolverURL, resolveTIMEOUT);
			    debug("resolve", "Created "+resolver);
			}
		    }
		    agent = resolver;
		}
		return agent.lookup(gol, failed);
	    } catch (ExCellNotFoundException e) {
		throw e;
	    } catch (Exception e) {
		debug("resolve", e);
		synchronized (lock) {
		    if (agent != null) {
			agent.close();
			debug("resolve", "Closed "+agent);
			if (agent == resolver) resolver = null;
			agent = null;
		    }
		}
	    }
	    Executor.syslog(CN, "resolve", "Retry["+retry+"/"+resolveRETRY+"] "+gol);
	    try {
		debug("resolve", "Sleep "+resolveTIMEOUT+" milliseconds");
		Thread.sleep(resolveTIMEOUT);
	    } catch (Exception e) {
		debug("resolve", e);
		/* Nothing to do */
	    }
	}
	debug("resolve", "Over retry max("+resolveRETRY+") "+gol);
	throw new ExCellNotFoundException(gol);
    }

    /**
     * OzHomeResolver とTCPコネクションを確立し、受信データを監視するスレッドの
     * 実行を開始する。
     *
     * @param	resolver	OzHomeResolver のURL
     * @param	timeout		OzHomeResolver からの応答のタイムアウト時間（ミリ秒）
     * @exception		IOException
     *				TCPコネクションの確立等に失敗した。
     */
    private
    ExAddressResolver(String url, long timeout)
    throws IOException
    {
	super("Watch response from resolver");
	URL resolver = new URL(url);
	socket = new Socket(resolver.getHost(), resolver.getPort());
	in = new DataInputStream(socket.getInputStream());
	out = new DataOutputStream(socket.getOutputStream());
	this.timeout = timeout;
	setDaemon(true);
	setPriority(Thread.MAX_PRIORITY);
	start();
	debug("ExAddressResolver","(url="+url+",timeout="+timeout+")");
    }

    /**
     * OzHomeResolver に通信アドレス解決要求のパケットを送信し、
     * 待ち合わせのためのオブジェクトを返す。
     * 但し、既に通信アドレス解決要求が行われているGOLの場合は、
     * パケットの送信を行わない。
     *
     * @param	gol	通信アドレス解決を行う対象GOL
     * @param	failed	前回の通信（グローバルアクセス）で失敗した通信アドレス
     *			但し、該当がなければ null を指定する。
     * @param	current	待機テーブルに登録する待ち合わせ用オブジェクト
     * @return	既に待機テーブルに登録されていた待ち合わせようオブジェクト
     * @exception	IOException
     *			パケットの送信を行うとしたが、失敗した。
     *
     */
    private synchronized
    ExFakeObject request(String gol, ExCommAddress failed, ExFakeObject current)
    throws IOException
    {
	if (trouble) {
	    throw new IOException("Trouble");
	}
	String ip = (failed == null) ? nothingHostAddress : failed.address.getHostAddress();
	int port = (failed == null) ? 0 : failed.port;
    	ExFakeObject before = (ExFakeObject)standbys.put(gol, current);
	if (before == null) {
	    try {
		debug("request", "Send "+gol+" "+ip+":"+port);
		out.writeUTF(requestTag);
		out.writeUTF(gol);
		out.writeUTF(ip);
		out.writeInt(port);
		out.flush();
	    } catch (IOException e) {
		trouble = true;
		throw e;
	    }
	} else {
	    debug("request", "Wait "+gol+" "+ip+":"+port);
	}
	return before;
    }

    /**
     * 同じGOLに対する通信アドレス解決要求に対する応答の待ち合わせを行う。
     * 
     * <DL><DT>
     * 【注意】<DD>
     * タイムアウト時もExCellNotFoundExceptionを発生する。
     * なお、タイムアウトの判断はこのメソッドで行われる。
     * </DL>
     * @param	gol	通信アドレス解決を行う対象のGOL
     * @param	failed	前回の通信（グローバルアクセス）で失敗した通信アドレス
     * @return	通信アドレスを返す。
     * @exception	Exception
     *			何らかの障害が発生し、通信アドレス解決の処理が正常に行われなかった。
     * @exception	ExCellNotFoundException
     *			指定されたGOLに対応する（セル）グローバルオブジェクトの
     *			通信アドレスを解決することができない。
     */
    private
    ExCommAddress lookup(String gol, ExCommAddress failed)
    throws Exception, ExCellNotFoundException
    {
	debug("lookup", "(go="+gol+",failed="+failed+")");
	ExCommAddress result = null;
	ExFakeObject current = new ExFakeObject();
	ExFakeObject before = null;
	before = request(gol, failed, current);
	if (before == null) {
	    if (current.await(timeout)) {
		result = (ExCommAddress)current.get();
	    } else {
		Exception e = (Exception)current.get();
		if (e == null) {
		    debug("lookup", "(go="+gol+",failed="+failed+") Timeout");
		} else {
		    throw e;
		}
	    }
	} else {
	    if (current.await(timeout)) {
		result = (ExCommAddress)current.get();
		before.ready(result);
	    } else {
		before.abort();
		Exception e = (Exception)current.get();
		if (e == null) {
		    debug("lookup", "(go="+gol+",failed="+failed+") Timeout");
		} else {
		    throw e;
		}
	    }
	}
	if (result == null) {
	    debug("lookup", "(go="+gol+",failed="+failed+") Not found");
	    throw new ExCellNotFoundException(gol);
	} else {
	    debug("lookup", "(go="+gol+",failed="+failed+") = "+result);
	}
	return result;
    }

    /**
     * OzHomeResolver からのパッケトを監視しているスレッドを終了させ、
     * TCPコネクション等を切断（クローズ）する。
     */
    private synchronized
    void close()
    {
	try {
	    interrupt();
	    in.close();
	    out.close();
	    socket.close();
	    join();
	} catch (Exception e) {
	    debug("close", e);
	}
    }

    /**
     * 当該オブジェクトで問題が発生し、以降の通信アドレス解決の処理が
     * 行えない状態であるという設定を行った上で、待機中のスレッドに
     * 通信アドレス解決の処理が中止されたことを通知する。
     *
     * @param	e	通信アドレス解決の処理が中止された直接の原因となった例外
     */
    private synchronized
    void abort(Exception e)
    {
	debug("abort", "Start");
	trouble = true;
	Enumeration keys = standbys.keys();
	while (keys.hasMoreElements()) {
	    String gol = (String)keys.nextElement();
	    ExFakeObject fake = (ExFakeObject)standbys.get(gol);
	    if (fake == null) {
		debug("abort", "? "+gol);
	    } else {
		fake.abort(e);
		debug("abort", gol);
	    }
	}
	debug("abort", "Finish");
    }

    /**
     * OzHomeResolver からの応答パケットを監視し、待機テーブルを使って
     * 対応するスレッドに通知する。
     */
    public
    void run()
    {
	try {
	    debug("run", "Start to watch response from resolver");
	    while (!isInterrupted()) {
		debug("run", "Wait to receive protocol tag");
		String tag = in.readUTF();
		if (tag.equals(successResponseTag)) {
		    String gol = in.readUTF();
		    String ip = in.readUTF();
		    int port = in.readInt();
		    debug("run", "Recv "+gol+" "+ip+":"+port);
		    ExFakeObject fake = (ExFakeObject)standbys.remove(gol);
		    if (fake != null) {
			try {
			    fake.ready(new ExCommAddress(InetAddress.getByName(ip), port, 0));
			} catch (UnknownHostException e) {
			    Executor.syslog(CN, "run", e);
			}
		    }
		} else if (tag.equals(failureResponseTag)) {
		    String gol = in.readUTF();
		    debug("run", "Recv "+gol+" not available");
		    ExFakeObject fake = (ExFakeObject)standbys.remove(gol);
		    if (fake != null) {
			fake.ready();
		    }
		} else {
		    Executor.syslog(CN, "run", "Illegal tag in response from resolver");
		    throw new IOException("Resolver protocol error");
		}
	    }
	    abort(null);
	    debug("run", "Finish to watch response from resolver");
	} catch (InterruptedIOException e) {
	    abort(e);
	    debug("run", "Finish to watch response from resolver", e);
	} catch (Exception e) {
	    abort(e);
	    Executor.syslog(CN, "run", "Aborted to watch response from resolver", e);
	}
    }
}
