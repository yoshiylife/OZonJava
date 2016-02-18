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
 * $Id: ExChannel.java,v 2.2 1997/12/04 04:55:19 yoshi Exp $
 *
 * 注意: このファイルは vi で、hardtab=8, tabstop=4 として編集されている
 */

package JP.go.ipa.oz.system;

/**
 * クラス ExChannel はチャネルの実装である。
 *
 * @see	ExCallerChannel
 * @see	ExCalleeChannel
 *
 * @version		$Revision: 2.2 $, $Date: 1997/12/04 04:55:19 $
 * @author		Yasumitsu Yoshida
 */
class ExChannel
implements ExCalleeChannel, ExCallerChannel
{
	/**
	 * エグゼキュータ実装のデバッグ用
	 */
	static final String CN = "ExChannel";

	/**
	 * 同じOZホーム内のセルを自動的に活性化するというフラグ。
	 */
	static private boolean autoload = new Boolean(System.getProperty("oz.cell.autoload")).booleanValue();

	/**
	 * ExCalleeChannel として
	 */

	/**
	 * ExCalleeChannel として、処理終了等の通知のために
	 * 呼び出し側のチャネルを保持する。
	 *
	 * @see ExCalleeChannel
	 */
	private ExCallerChannel caller;

	/**
	 * ExCalleeChannel として、新しいスレッド上でメソッドを
	 * 実行する際に、メソッドを呼び出す対象を保持する。
	 *
	 * @see ExCalleeChannel
	 */
	private Object object;

	/**
	 * ExCalleeChannel として、新しいスレッド上でメソッドを
	 * 実行する際に必要となる情報を保持する。
	 *
	 * @see ExCalleeChannel
	 */
	private Object[] arguments;

	/**
	 * ExCalleeChannel として、アボート処理を行うために
	 * メソッドを実行しているスレッドを保持する。
	 *
	 * @see ExCalleeChannel
	 */
	private ExThread thread;

	/**
	 * ExCallerChannel として、呼び出される側のチャネルに
	 * 伝播するためにプロセスＩＤを保持する。
	 *
	 * @see	ExCallerChannel
	 */
	private String pid;

	/**
	 * ExCallerChannel として、呼び出される側との同期をとるために
	 * 呼び出される側のチャネルを保持する。
	 *
	 * @see	ExCallerChannel
	 */
	private ExCalleeChannel callee;

	/**
	 * ExCallerChannel として、チャネルを操作している側にメソッドの終了状態を
	 * 返すために、呼び出される側のチャネルから渡された終了状態を保持する。
	 *
	 * @see	ExCallerChannel
	 */
	private boolean status;

	/**
	 * ExCallerChannel として、チャネルを操作している側にメソッドの戻り値を
	 * 返すために、呼び出される側のチャネルから渡された戻り値を保持する。
	 *
	 * @see	ExCallerChannel
	 */
	private Object result;

	/**
	 * 同一エグゼキュータ上でのスレッドの連鎖を形成するためのチャネルを生成する。
	 *
	 * @param	caller		呼び出し側のチャネル
	 * @param	object		メソッドを呼び出す対象のオブジェクト
	 * @param	arguments	メソッドを呼び出すために必要な情報
	 *
	 * @see	ExCallerChannel
	 */
	ExChannel(ExCallerChannel caller, Object object, Object[] arguments)
	{
		this.pid = caller.pid();
		this.caller = caller;
		this.object = object;
		this.arguments = arguments;
	}

	/**
	 * ExCalleeChannel として、新しいスレッド上でメソッドを
	 * 実行する際に、メソッドを呼び出す対象を返す。
	 *
	 * @return	メソッドを呼び出す対象のオブジェクト
	 *
	 * @see	ExChannel#object
	 * @see ExCalleeChannel#object
	 */
	public
	Object object()
	{
		Object object = this.object;
		this.object = null;
		return object;
	}

	/**
	 * ExCalleeChannel として、新しいスレッド上でメソッドを
	 * 実行する際に必要となる情報を返す。
	 *
	 * @return	メソッドを実行する際に必要となる情報を返す。
	 *
	 * @see	ExChannel#arguments
	 * @see ExCalleeChannel#arguments
	 */
	public
	Object[] arguments()
	{
		Object[] arguments = this.arguments;
		this.arguments = null;
		return arguments;
	}

	/**
	 * ExCalleeChannel として、メソッドの実行結果を呼び出し側に伝播する。
	 *
	 * @param	status	メソッドが例外で終了した場合は、false を指定する。
	 * @param	result	メソッドの戻り値を指定する。
	 * @exception	ExException
	 *				実行中に例外が発生した。
	 *
	 * @see	ExChannel#status
	 * @see	ExChannel#result
	 * @see ExCalleeChannel#exit
	 */
	public
	void exit(boolean status, Object result)
	throws ExException
	{
		Executor.debug(CN,"exit","("+status+","+result+")");

		/* SecurityException may occured at Executor.duplicate */
		/* For remote invocation, ExRemoteCallerChannel treat it */
		try {
			if (caller instanceof ExChannel) {
				caller.done(status, Executor.duplicate(result,true));
			} else {
				caller.done(status,result);
			}
		} catch (ExException e) {
			ThreadGroup g = Thread.currentThread().getThreadGroup();
			Executor.error(CN,"exit","channel="+this+" in "+g);
			throw e;
		}
	}

	/**
	 * ExCalleeChannel として、このチャネルのスレッドの実行を中断する。
	 *
	 * @exception	ExException
	 *				実行中に例外が発生した。
	 *
	 * @see	ExChannel#kill
	 * @see	Thread#interrupt
	 * @see	ExCalleeChannel#abort
	 */
	public
	void abort()
	throws ExException
	{
		try {
			if (callee != null) kill();
			else thread.interrupt();
		} catch (ExException e) {
			ThreadGroup g = Thread.currentThread().getThreadGroup();
			Executor.error(CN,"abort","channel="+this+",cell="+g,e);
			throw e;
		}
	}

	/**
	 * ExCallerChannel として、プロセスＩＤの伝播のために起動される。
	 *
	 * @return	プロセスＩＤ
	 *
	 * @see	ExCallerChannel#pid
	 */
	public
	String pid()
	{
		return pid;
	}

	/**
	 * ExCallerChannel として、チャネルの連鎖に新たなチャネルを加える。
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * シュットダウン処理が開始された場合、
	 * セルの自動活性化は行ってはならない。
	 * </DL>
	 *
	 * @param	proxy	実際のメソッド起動を行うプロキシ
	 *
	 * @exception	ExCellNotFoundException
	 *					引数 gol に対応するグローバルオブジェクトが見つからない。
	 * @exception	ExGOLFormatException
	 *					指定された GOL の形式が正しくない。
	 * @exception	ExException	実行中に例外が発生した。
	 *
	 * @see ExCell#fork
	 * @see ExCommManager#fork
	 * @see ExCallerChannel#fork
	 */
	public synchronized
	  void fork(OzProxy proxy)
	    throws ExGOLFormatException, ExCellNotFoundException, ExException
	      {
		ExCell cell;
		ExGOL gol = new ExGOL(ExCell.currentCell().getName());
		
		if(proxy.inside()) {
		  cell = ExCellManager.get(proxy);
		  if(cell!=null){
		    try { 
		      callee = cell.fork((ExCallerChannel)this, (OzProxy)Executor.duplicate(proxy,true));
		    } catch (ClassNotFoundException e) {
		      Executor.error(CN,"fork(","proxy="+proxy+")",e);
		      throw new ExException(e.getClass().getName());
		    }	
		  } else { 
		    try{
		      callee=Executor.commManager.fork(this,proxy,gol.getName());
		    } catch (ExCellNotActiveException cnaex){
		      /* cell auto load */
		      if(autoload && !ExCellManager.isShutdown()){
			Executor.debug(CN,"fork","cell is not active. Try to load the cell "+proxy);
			try{
			  OzCellManager.go(proxy);
			} catch (ExException exex){
			  Executor.debug(CN,"fork","Cell auto load failed by exception",exex);
			  throw cnaex;
			}
			cell = ExCellManager.get(proxy);
			try { 
			  callee = cell.fork((ExCallerChannel)this, (OzProxy)Executor.duplicate(proxy,true));
			} catch (ClassNotFoundException e) {
			  Executor.error(CN,"fork(","proxy="+proxy+")",e);
			  throw new ExException(e.getClass().getName());
			}	
		      }
		    }
		  }
		} else {
		  /* other OZ home */
		  // throw new ExException("inter oz-home invocation is not implemented in this UNIT version");
		  callee=Executor.commManager.fork(this,proxy,gol.getName());
		}
	      }	 

	/**
	 * ExCallerChannel として、呼び出される側のメソッドの実行終了を待つ。
	 *
	 * @return	呼び出される側のメソッドの戻り値
	 * @exception	Exception
	 *				呼び出される側のメソッドで発生した例外で、
	 *				このメソッド自身の例外はない。
	 */

public synchronized
Object join()
	throws Exception
	{
		Executor.debug(CN,"join()_enter","callee="+callee);
		while (callee != null) wait();
		Executor.debug(CN,"join()_result_arvailable","status="+status+",result="+result);
		if (!status) throw (Exception)result ;
		return result ;
	}

	/**
	 * ExCallerChannel として、呼び出される側からメソッドの実行終了を通知する。
	 *
	 * @param	status	メソッドが例外で終了した場合は、false を指定する。
	 * @param	result	メソッドの戻り値を指定する。
	 */
	public synchronized
	void done(boolean status, Object result)
	{
		Executor.debug(CN,"done","("+status+","+result+")");
		this.status = status;
		this.result = result;
		callee = null;
		notifyAll();
	}

	/**
	 * ExCallerChannel として、呼び出される側のスレッドの実行を中断する。
	 *
	 * @exception	ExException
	 *				実行中に例外が発生した。
	 *
	 * @see	ExCalleeChannel#abort
	 */
	public synchronized
	void kill()
	throws ExException
	{
		try {
			if (callee == null) {
				throw new ExException("process already done.");
			} else {
				callee.abort();
			}
		} catch (ExException e) {
			ThreadGroup g = Thread.currentThread().getThreadGroup();
			Executor.error(CN,"kill","channel="+this+",cell="+g,e);
			throw e;
		}
	}

	/**
	 * セルがチャネルにスレッドを割り当て、そのスレッドの実行を開始する。
	 *
	 * @param	thread	割り当てられたスレッド
	 */
	synchronized
	void start(ExThread thread)
	{
		this.thread = thread;
		this.thread.start();
	}

	/**
	 * デフォルトの表示内容にプロセスＩＤを加えて表示する。
	 */
	public
	String toString()
	{
		return CN + "@" + Integer.toHexString(hashCode()) + "[pid=" + pid + "]";
	}

	/* Feb. 17th, 1998. getCallerOzHome() is added by Nishioka */
	/**
	 * このチャネルを生成するグローバルメソッド起動を行った
	 * セルのオーナの OZ ホーム ID を返す。
	 * ExChannel の場合は、常に同じオーナなので、
	 * それを示すために null を返す。
	 */
	public String getCallerOzHome() throws OzCipherException {
		return null;
	}

	/* Feb. 17th, 1998. callGetCallerOzHome() is added by Nishioka */
	/**
	 * このチャネルを呼び出したチャネルを生成した
	 * グローバルメソッド起動を行ったセルのオーナの OZ ホーム ID を返す。
	 */
	public String callGetCallerOzHome() throws OzCipherException {
		return caller.getCallerOzHome();
	}
}
