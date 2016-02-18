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
 * $Id: ExCellManager.java,v 2.1.1.1 1997/07/15 06:20:45 yoshi Exp $
 *
 * 注意: このファイルは vi で、hardtab=8, tabstop=4 として編集されている
 */

package JP.go.ipa.oz.system;

import java.io.PrintWriter;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Enumeration;

/**
 * エグゼキュータにロードされているセル（スレッドグループ）のテーブルを持ち、
 * GOD名からセルへの変換やセルの状態の遷移を行う。（セル管理系）
 * エグゼキュータはセルの操作をこのクラスを介して行う。
 * 通常のグローバルアクセスの受け入れでは、セルがテーブルに登録されている
 * ことが確認される。
 *
 * <DL><DT>
 * 【注意】<DD>
 * このクラスの目的は、エグゼキュータ本体のセル以外の
 * 全てのセル（スレッドグループ）を管理することにある。
 * </DL>
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:45 $
 * @author		Yasumitsu Yoshida
 *
 * @see	ExChannel#fork
 */
class ExCellManager
{
	/**
	 * エグゼキュータ実装のデバッグ用
	 */
	static final String CN = "ExCellManager";

	/**
	 * オブジェクトイメージファイル名
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * オブジェクトイメージのファイル名はセルを作成時に
	 * このクラスから与えることにより、その制御を可能にする。
	 * </DL>
	 *
	 */
	private static final String objectImageFilename = ".objectImage";

	/**
	 * GOD名をキーとしてセル（スレッドグループ）を得るためのテーブルである。
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * このテーブルへの登録は、保留／拒否は別として
	 * グローバルアクセスの受け入れを意味する。
	 * </DL>
	 */
	private static Dictionary cells = new Hashtable();

	/**
	 * シュットダウン処理が開始されたことを示すフラグである。
	 * シュットダウン処理が開始されると、セルの活性化や
	 * セルの活性化の過程で行われるテーブルへの登録はできなくなる。
	 */
	private static boolean shutdown = false;

	/**
	 * 指定されたGOD名を検索する。
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * シュットダウン処理の過程で不活性化される
	 * セル（グローバルオブジェクト）がグローバルアクセスを
	 * 必要とする可能性があるためにグローバルアクセスの
	 * 受け入れを拒否できない。
	 * </DL>
	 *
	 * @param	god		GODオブジェクト
	 * @return			セル、見つからなければ null を返す。
	 *
	 * @see	ExCellManager#cells
	 */
	static synchronized
	ExCell get(ExGOD god)
	{
		return (ExCell)cells.get(god);
	}

	/**
	 * 指定されたプロキシに対するを検索する。
	 *
	 * @param	proxy	プロキシ
	 * @return			セル、見つからなければ null を返す。
	 *
	 * @see	ExCellManager#cells
	 * @see	ExCellManager#get(ExGOD)
	 */
	static synchronized
	ExCell get(OzProxy proxy)
	throws ExIllegalCellStateException
	{
		try {
			return get(new ExGOD(proxy));
		} catch (ExCellIllegalOzHomeException e) {
			return null;
		}
	}

	/**
	 * 指定されたGOD名を登録する。
	 *
	 * @param	god		GODオブジェクト
	 * @param	cell	セル
	 * @return			既に登録されていたセル、登録されていなければ null を返す。
	 *
	 * @exception	ExIllegalCellStateException
	 *					シャットダウン処理のため新たなセルの登録はできない。
	 * @see	ExCellManager#cells
	 */
	static synchronized
	ExCell put(ExGOD god, ExCell cell)
	throws ExIllegalCellStateException
	{
		if (shutdown) {
			throw new ExIllegalCellStateException("shutdown in progress");
		}
		return (ExCell)cells.put(god,cell);
	}

	/**
	 * 指定されたGOD名を削除する。
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * シュットダウン処理の過程で、セル（スレッドグループ）から
	 * このメソッドが呼び出されるので、このメソッド自体を
	 * synchronizedにしてはならない。
	 * </DL>
	 *
	 * @param	god		GODオブジェクト
	 * @return			登録されていたセル、登録されていなければ null を返す。
	 *
	 * @see	ExCellManager#cells
	 */
	static
	ExCell remove(ExGOD god)
	{
		ExCell result;
		synchronized (cells) {
			result = (ExCell)cells.remove(god);
			if (cells.isEmpty()) {
				cells.notifyAll();
			}
		}
		return result;
	}

	/**
	 * 登録されているセル数を返す。
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * テーブルの状態（シュットダウン処理中かどうか等）に
	 * 関係なく問い合わせができるようにするために、
	 * このメソッド自体をsynchronizedにしてはならない。
	 * </DL>
	 *
	 * @return	登録されているセル数
	 */
	static
	int size()
	{
		return cells.size();
	}

	/**
	 * 登録されているセルがないかを調べる。
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * テーブルの状態（シュットダウン処理中かどうか等）に
	 * 関係なく問い合わせができるようにするために、
	 * このメソッド自体をsynchronizedにしてはならない。
	 * </DL>
	 *
	 * @return	登録されているセルがなければ、true を返す。
	 */
	static
	boolean isEmpty()
	{
		return cells.isEmpty();
	}

	/**
	 * 指定されたGODに結び付けられたセル（グローバルオブジェクト）が
	 * 存在するかどうかを調べる。
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * テーブルの状態（シュットダウン処理中かどうか等）に
	 * 関係なく問い合わせができるようにするために、
	 * このメソッド自体をsynchronizedにしてはならない。
	 * </DL>
	 *
	 * @param	god		調べる対象のセルを特定するためのGODオブジェクト
	 * @return			セルが存在している場合は、true を返す。
	 */
	static
	boolean exists(ExGOD god)
	{
		if (god.exists() && god.isDirectory()) {
			if (get(god) == null) {
				File objectImage = new File(god,objectImageFilename);
				if (ExAddressManager.exists(god) || objectImage.exists()) {
					return true;
				}
			} else {
				return true;
			}
		}
		return false;
	}

	/**
	 * シャットダウン処理が開始されたかどうかを調べる。
	 *
	 * @return	シャットダウン処理が開始されている場合、true を返す。
	 */
	static synchronized
	boolean isShutdown()
	{
		return shutdown;
	}

	/**
	 * シャットダウン処理として、全てのセルに対して非活性化の状態に
	 * なるように状態遷移を行う。既に、シャットダウン処理が開始されている
	 * 場合は何もしない。
	 *
	 * @return	既にシャットダウン処理が行われている場合は、false を返す。
	 */
	static private synchronized
	boolean shutdown()
	{
		ExGOD[] gods;
		int count = 0;

		// 新たなセルの活性化を禁止する。
		if (shutdown) return false;
		shutdown = true;

		// 登録されているセルのGODのリストを作成する。
		gods = new ExGOD[cells.size()];
		Enumeration keys = cells.keys();
		while (keys.hasMoreElements()) gods[count++] = (ExGOD)keys.nextElement();

		// 各セル毎に非活性化の処理を行うプロセスを生成する。
		for (int i = 0; i < count; i ++) {
			ExCell cell = get(gods[i]);
			if (cell == null) {
				// タイミングによりこの状態が発生するが、重要な問題ではない。
				Executor.error(CN,"shutdown","Warning: Not found cell with "+gods[i].getName());
			} else {
				try {
					/*
					 *  Executor#userGracePeriodをメソッド ExCellManager#quit に渡すために、
					 * ３番目のパラメータは指定しない。
					 */
					Object[] params = new Object[2];
					params[0] = new Integer(Executor.QUIT);
					params[1] = gods[i];
					Executor.syscall(params);
				} catch (Exception e) {
					Executor.error(CN,"shutdown","Ignore: Raised exception with "+gods[i].getName(),e);
				}
			}
		}

		return shutdown;
	}

	/**
	 * 指定された時間が経過したら、全てのセルのスレッドを停止させ、
	 * GODの開放等の処理を行って、セルを強制的に非活性化の状態にする。
	 * 但し、対象となるセルがなければなにもしない。
	 *
	 * @param	gracePeriod		処理を開始するまでの待ち時間（ミリ秒）
	 */
	static synchronized
	void halt(long gracePeriod)
	throws InterruptedException
	{
		Executor.debug(CN,"halt","(gracePeriod="+gracePeriod+")");

		ExGOD[] gods;
		int count = 0;

		// 新たなセルの登録を禁止する。
		shutdown = true;

		// 登録されているセルのGODのリストを作成する。
		gods = new ExGOD[cells.size()];
		Enumeration keys = cells.keys();
		while (keys.hasMoreElements()) gods[count++] = (ExGOD)keys.nextElement();

		// 全てのスレッドを停止させる
		for (int i = 0; i < count; i ++) {
			ExCell cell = get(gods[i]);
			if (cell == null) {
				// タイミングによりこの状態が発生するが、重要な問題ではない。
				Executor.error(CN,"halt","Warning: Not found cell with "+gods[i].getName());
			} else {
				Executor.syslog(CN,"halt","***** FORCE TO STOP ALL THREAD "+cell.toString(),null);
				try {
					/*
					 * cells が空になるまで条件待ちしているスレッドがあるので、
					 * cells に対してメソッド remove を直接呼び出してはいけない。
					 */
					remove(gods[i]);
					cell.stop();
				} catch (Exception e) {
					Executor.error(CN,"halt","Ignore: Raised exception with "+cell,e);
				}
			}
		}

		// 各セルを強制的に非活性化する。
		if (gracePeriod != 0 && ! isEmpty()) Thread.sleep(gracePeriod);
		for (int i = 0; i < count; i ++) {
			Executor.syslog(CN,"halt","***** FORCE TO RELEASE GOD LOCK "+gods[i].getPath(),null);
			try {
				if (gods[i].knock()) gods[i].release();
			} catch (Exception e) {
				Executor.error(CN,"halt","Ignore: Raised exception with "+gods[i],e);
			}
		}

		Executor.debug(CN,"halt","return");
	}

	/**
	 * セル管理系を停止する。
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * シュットダウン処理の過程で、別スレッドでセルのテーブルの操作が
	 * 行われるので、このメソッド自体をsynchronizedにしてはならない。
	 * </DL>
	 *
	 * @param	gracePeriod	強制的に全てのセルを非活性化するまでの待機時間（ミリ秒）
	 */
	static
	void shutdown(long gracePeriod)
	throws Exception
	{
		Executor.debug(CN,"shutdown","(gracePeriod="+gracePeriod+")");

		// 全てのセルを不活性化する。
		if (shutdown()) {
			// 指定された時間が経過したら、強制的に全てのセルを非活性化する。
			Object[] params;
			params = new Object[2];
			params[0] = new Integer(Executor.HALT);
			params[1] = new Long(gracePeriod);
			Executor.syscall(params);
		}

		// 全てのセルが非活性化するまで待機する。
		synchronized (cells) {
			while (! cells.isEmpty()) {
				cells.wait();
			}
		}
		Executor.debug(CN,"shutdown","return");
	}

	/**
	 * セルの状態の確定を待って、セルを非活性化の状態にする。
	 * セルが活性化されていない、あるいは、指定した時間内に
	 * セルの状態が確定しなければ、何もしないで終了する。
	 *
	 * @param	god		非活性化するセルのGODオブジェクト
	 * @param	gracePeriod	セルの状態の確定を待つ時間（ミリ秒）
	 */
	static
	void quit(ExGOD god, long gracePeriod)
	throws ExException
	{
		Executor.debug(CN,"quit","(god="+god+",gracePeriod="+gracePeriod+")");
		ExCell cell = get(god);
		if (cell != null && cell.checkGlobalAccess(gracePeriod)) {
			try {
				Executor.syslog(CN,"quit","***** DEACTIVATE "+cell.toString(),null);
				cell.deactivating(new ExProxy(cell.getName()));
				cell.free();
				Executor.syslog(CN,"quit","***** COMPLETE   "+cell.toString(),null);
			} catch (ExException e) {
				cell.free();
				Executor.syslog(CN,"quit","***** INCOMPLETE "+cell.toString(),e);
			}
		}
		Executor.debug(CN,"quit","return");
	}

	/**
	 * クラス ExCellManager は１つのエグゼキュータに
	 * １つであり、動作中に実装が変更されることもない。
	 * 従って、クラス ExCellManager を使って
	 * オブジェクトを生成しないようにし、
	 * staticメソッドのみを定義する。
	 */
	private
	ExCellManager()
	{
		/* Nothing */
	}

	/**
	 * 新しいセル（グローバルオブジェクト）を作成する。
	 *
	 * @see	OzCellManager#create
	 */
	static
	void create(String codePath, ExProxy proxy)
	throws ExException
	{
		Executor.debug(CN,"create","(codePath="+codePath+",proxy="+proxy+")");
		ExGOD god = new ExGOD(proxy);
		if (isShutdown()) throw new ExIllegalCellStateException(god.getName());
		ExCell cell = new ExCell(god,objectImageFilename);
		try {
			cell.initializing(codePath,proxy);
		} catch (ExException e) {
			cell.free();
			throw e;
		}
	}

	/**
	 * セル（グローバルオブジェクト）を活性化する。
	 *
	 * @see	OzCellManager#go
	 */
	static
	void activate(ExProxy proxy)
	throws ExException
	{
		Executor.debug(CN,"activate","(proxy="+proxy+")");
		ExGOD god = new ExGOD(proxy);
		if (isShutdown()) throw new ExIllegalCellStateException(god.getName());
		ExCell cell = ExCell.find(god,objectImageFilename);
		try {
			cell.activating(proxy);
		} catch (ExException e) {
			cell.free();
			throw e;
		}
	}

	/**
	 * セル（グローバルオブジェクト）を不活性化する。
	 *
	 * @see	OzCellManager#stop
	 */
	static
	void deactivate(ExProxy proxy)
	throws ExException
	{
		Executor.debug(CN,"deactivate","(proxy="+proxy+")");
		ExCell cell = get(proxy);
		if (cell == null) {
			throw new ExCellNotFoundException(proxy.getName());
		}
		try {
			cell.deactivating(proxy);
			cell.free();
		} catch (ExException e) {
			cell.free();
			throw e;
		}
	}

	/**
	 * セル（グローバルオブジェクト）を削除する。
	 *
	 * @see	OzCellManager#remove
	 */
	static
	void remove(ExProxy proxy)
	throws ExException
	{
		Executor.debug(CN,"remove","(proxy="+proxy+")");
		ExCell cell = get(proxy);
		if (cell == null) {
			throw new ExCellNotFoundException(proxy.getName());
		}
		try {
			cell.removing(proxy);
			cell.free();
		} catch (ExException e) {
			cell.free();
			throw e;
		}
	}

	/**
	 * セル（グローバルオブジェクト）をフラッシュする。
	 *
	 * @see	ExCell#flush
	 */
	static
	void flush(OzProxy proxy)
	throws ExException
	{
		Executor.debug(CN,"flush","(proxy="+proxy+")");
		ExCell cell = get(proxy);
		if (cell == null) {
			throw new ExCellNotFoundException(proxy.getName());
		}
		try {
			cell.flush();
		} catch (ExException e) {
			throw e;
		}
	}

	/*
	 * これ以降はデバッグとシェルのためのプログラムである。
	 * （詳細は省略）
	 */
	static {

		/**
		 * セル（グローバルオブジェクト）を作成するコマンド
		 */
		class Create
		extends ExShellCommand
		{
			Create()
			{
				usage = " <god> <class> [args...]";
				comment = "create global object";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length < 3) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too few arguments");
				}

				String codePath = (String)args[2];
				if (codePath.startsWith("released.")) {
					codePath = Executor.IPAozUser+codePath;
				} else if (codePath.startsWith("user.")) {
					codePath = Executor.IPAoz+codePath;
				} else if (codePath.startsWith("system.")) {
					codePath = Executor.IPAoz+codePath;
				} else if (codePath.startsWith("tools.")) {
					codePath = Executor.IPA+codePath;
				} else if (codePath.startsWith("tests.")) {
					codePath = Executor.IPA+codePath;
				}

				String[] newArgs;
				if (3 < args.length) {
					newArgs = new String[args.length-3];
					System.arraycopy(args, 3, newArgs, 0, args.length-3);
				} else newArgs = null;
				OzProxy proxy = new ExProxy(args[1],newArgs);
				try {
					Object[] argv = new Object[3];
					argv[0] = new Integer(Executor.CREATE);
					argv[1] = codePath;
					argv[2] = proxy;
					OzProcess p = Executor.syscall(argv);
					p.join();
				} catch (ExProcessException e) {
					Exception ee = e.getException();
					throw e.getException();
				}

				return proxy.getName();
			}
		}

		/**
		 * セル（グローバルオブジェクト）を活性化するコマンド
		 */
		class Activate
		extends ExShellCommand
		{
			Activate()
			{
				usage = " <god> [args...]";
				comment = "activate global object";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length < 2) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too few arguments");
				}

				String[] newArgs;
				if (2 < args.length) {
					newArgs = new String[args.length-2];
					System.arraycopy(args, 2, newArgs, 0, args.length-2);
				} else newArgs = null;
				OzProxy proxy = new ExProxy(args[1],newArgs);
				try {
					Object[] argv = new Object[2];
					argv[0] = new Integer(Executor.GO);
					argv[1] = proxy;
					OzProcess p = Executor.syscall(argv);
					p.join();
				} catch (ExProcessException e) {
					throw e.getException();
				}

				return proxy.getName();
			}
		}

		/**
		 * セル（グローバルオブジェクト）を不活性化するコマンド
		 */
		class Deactivate
		extends ExShellCommand
		{
			Deactivate()
			{
				usage = " <god> [args...]";
				comment = "deactivate global object";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length < 2) {
					shell.stderr.println("Usage: "+args[0]+"usage");
					throw new IllegalArgumentException("Too few arguments");
				}

				String[] newArgs;
				if (2 < args.length) {
					newArgs = new String[args.length-2];
					System.arraycopy(args, 2, newArgs, 0, args.length-2);
				} else newArgs = null;
				OzProxy proxy = new ExProxy(args[1],newArgs);
				try {
					Object[] argv = new Object[2];
					argv[0] = new Integer(Executor.STOP);
					argv[1] = proxy;
					OzProcess p = Executor.syscall(argv);
					p.join();
				} catch (ExProcessException e) {
					throw e.getException();
				}

				return proxy.getName();
			}
		}

		/**
		 * セル（グローバルオブジェクト）を削除するコマンド
		 */
		class Remove
		extends ExShellCommand
		{
			Remove()
			{
				usage = " <god>";
				comment = "remove global object";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length != 2) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too few or many arguments");
				}

				OzProxy proxy = new ExProxy(args[1]);
				try {
					Object[] argv = new Object[2];
					argv[0] = new Integer(Executor.REMOVE);
					argv[1] = proxy;
					OzProcess p = Executor.syscall(argv);
					p.join();
				} catch (ExProcessException e) {
					throw e.getException();
				}

				return proxy.getName();
			}
		}

		/**
		 * セル（グローバルオブジェクト）の一覧を印字するコマンド
		 */
		class ListCell
		extends ExShellCommand
		{
			ListCell()
			{
				usage = " [<god]";
				comment = "list of cells on memory";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (2 < args.length) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too many arguments");
				}

				if (args.length == 2) {
					ExCell cell = get(new ExGOD(args[1]));
					if (cell != null) {
						shell.stdout.println(cell+" "+args[1]);
					}
				} else {
					Enumeration keys = cells.keys();
					while (keys.hasMoreElements()) {
						ExGOD god = (ExGOD)keys.nextElement();
						shell.stdout.println(get(god)+" "+god.getName());
					}
				}
				return null;
			}
		}

		/**
		 * セル（グローバルオブジェクト）の全スレッドを一時停止するコマンド
		 */
		class Suspend
		extends ExShellCommand
		{
			Suspend()
			{
				usage = " <god>";
				comment = "suspend all thread in cell";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length != 2) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too few or many arguments");
				}

				ThreadGroup g = Thread.currentThread().getThreadGroup().getParent();
				ThreadGroup[] list = new ThreadGroup[g.activeGroupCount()];
				int n = g.enumerate(list);
				for (int i = 0; i < n; i ++) {
					if (list[i].getName().equals(args[1])) {
						list[i].suspend();
						break;
					}
				}

				return null;
			}
		}

		/**
		 * セル（グローバルオブジェクト）の全スレッドを再開するコマンド
		 */
		class Resume
		extends ExShellCommand
		{
			Resume()
			{
				usage = " <god>";
				comment = "resume all thread in cell";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length != 2) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too few or many arguments");
				}

				ThreadGroup g = Thread.currentThread().getThreadGroup().getParent();
				ThreadGroup[] list = new ThreadGroup[g.activeGroupCount()];
				int n = g.enumerate(list);
				for (int i = 0; i < n; i ++) {
					if (list[i].getName().equals(args[1])) {
						list[i].resume();
						break;
					}
				}
				return null;
			}
		}


		/**
		 * セル（グローバルオブジェクト）を監視する。
		 */
		class Watch
		extends ExShellCommand
		{
			Watch()
			{
				usage = " <god>";
				comment = "watch cell to inactive";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length != 2) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too few or many arguments");
				}

				ExGOD god = new ExGOD(args[1]);
				ExCell cell = ExCellManager.get(god);
				if (cell == null) {
					throw new ExCellNotFoundException(god.getName());
				}
				cell.watch();
				return null;
			}
		}

		/**
		 * セル（グローバルオブジェクト）の状態を印字する。
		 */
		class Stat
		extends ExShellCommand
		{
			Stat()
			{
				usage = " <god>";
				comment = "print status of cell";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (2 != args.length) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too few or many arguments");
				}

				ExCell cell = get(new ExGOD(args[1]));
				if (cell != null) {
					shell.stdout.println(args[1]+" "+cell);
				} else {
					ExGOD god = new ExGOD(args[1]);
					File objectImage = new File(god,objectImageFilename);
					if (god.exists() && god.isDirectory()) {
						if (god.knock()) {
							if (ExAddressManager.exists(god)) {
								shell.stdout.println(args[1]+" Active");
							} else {
								shell.stdout.println(args[1]+" Acquired");
							}
						} else {
							if (objectImage.exists()) {
								shell.stdout.println(args[1]+" Inactive");
							} else {
								shell.stdout.println(args[1]+" Released");
							}
						}
					} else {
						shell.stdout.println(args[1]+" Nothing");
					}
				}

				return null;
			}
		}

		/**
		 * スレッド一覧を印字する。
		 */
		class ListThread
		extends ExShellCommand
		{
			ListThread()
			{
				usage = " [<god>]";
				comment = "list of threads";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (2 < args.length) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too many arguments");
				}

				ThreadGroup g = Thread.currentThread().getThreadGroup().getParent();
				ThreadGroup[] list = new ThreadGroup[g.activeGroupCount()];
				int n = g.enumerate(list);
				boolean specify = (args.length == 2) ? true : false;
				for (int i = 0; i < n; i ++) {
					if (!specify || list[i].getName().equals(args[1])) {
						shell.stdout.println(list[i]);
						if (list[i] instanceof ExCell) {
							ExCell cell = (ExCell)list[i];
							cell.list(shell.stdout,4);
						}
						if (specify) break;
					}
				}

				return null;
			}
		}

		/**
		 * グローバルオブジェクトのディレクトリを表示する。
		 */
		class ListGOD
		extends ExShellCommand
		{
			ListGOD()
			{
				usage = " [-a] [<path>]";
				comment = "list of GOD";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length > 3) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too many arguments");
				}

				FilenameFilter filter = null;
				String dirname = null;
				File path;
				int i;
				for (i = 1; i < args.length; i ++) {
					if (args[i].startsWith("-")) {
						if (args[i].equals("-a")) {
							filter =
								new FilenameFilter() {
										public
										boolean accept(File dir, String name)
										{
											return true;
										}
									};
							dirname = "";
						} else {
							shell.stderr.println("Usage: "+args[0]+usage);
							throw new IllegalArgumentException("Too many arguments");
						}
					} else break;
				}
				if (i == args.length) {
					if (dirname == null) dirname = "";
					path = new ExGOD("");
				} else {
					if (args.length-i == 1) {
						if (dirname == null) dirname = args[i]+".";
						path = new ExGOD(args[i]);
					} else {
							shell.stderr.println("Usage: "+args[0]+usage);
							throw new IllegalArgumentException("Too many arguments");
					}
				}
				if (filter == null) {
					filter =
						new FilenameFilter() {
							public
							boolean accept(File dir, String name)
							{
								File file = new File(dir, name);
								if (file.isDirectory()) {
									File objectImage = new File(file, objectImageFilename);
									if (objectImage.exists()) return true;
								}
								return false;
								// File path = new File(dir,name);
								// return path.isDirectory();
							}
						};
				}

				if (!path.exists()) {
					shell.stderr.println(args[0]+": "+path+" is not found.");
				} else if (path.isDirectory()) {
					String[] list = path.list(filter);
					for (int j = 0, n = list.length; j < n; j ++) {
						shell.stdout.println(dirname+list[j]);
					}
				} else {
					shell.stdout.println(args[0]+": " + args[i] + " is not directory.");
				}

				return null;
			}
		}

		ExShell.append("create",new Create());
		ExShell.append("go",new Activate());
		ExShell.append("stop",new Deactivate());
		ExShell.append("remove",new Remove());
		ExShell.append("gols",new ListCell());
		ExShell.append("suspend",new Suspend());
		ExShell.append("resume",new Resume());
		ExShell.append("watch",new Watch());
		ExShell.append("status",new Stat());
		ExShell.append("ts",new ListThread());
		ExShell.append("ls",new ListGOD());
	}
}
