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
 * $Id: ExCell.java,v 2.1.1.1 1997/07/15 06:20:45 yoshi Exp $
 *
 * 注意: このファイルは vi で、hardtab=8, tabstop=4 として編集されている
 */

package JP.go.ipa.oz.system;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * セル（グローバルオブジェクト）を保持し、そのセルの状態の変化や監視等の
 * 操作するクラスである。このクラスで作成されたオブジェクトは、
 * 一般にはメモリ上にあるセルと一対一に存在し、そのセルが
 * 結び付けられているGODのロックを獲得している。
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:45 $
 * @author		Yasumitsu Yoshida
 */
final class ExCell
extends ThreadGroup
{
	/**
	 * エグゼキュータ実装のデバッグ用
	 */
	static final String CN = "ExCell";

	/**
	 * 状態を表す値
	 */
	static final int FREE			= 0x0;
	static final int CREATED		= 0x1;
	static final int ACTIVE			= 0x2;
	static final int INACTIVE		= 0x3;
	static final int REMOVED		= 0x4;

	/**
	 * セル（グローバルオブジェクト）の状態を
	 * 表現するためのクラス
	 */
	class Status
	{
		/**
		 * 遷移状態を表す値
		 */
		private final int INITIALIZING	= 0x10;
		private final int ACTIVATING	= 0x11;
		private final int DEACTIVATING	= 0x12;
		private final int REMOVING		= 0x13;

		/**
		 * 現在の状態
		 */
		private int now;

		/**
		 * 引数で指定された状態を表すオブジェクトを作成する。
		 *
		 * <DL><DT>
		 * 【注意】<DD>
		 * 引数の値が正しいものかどうかは調べてない。
		 * </DL>
		 *
		 * @param	status	初期の状態
		 */
		Status(int status)
		{
			now = status;
		}

		/**
		 * 引数で指定された状態にするための遷移状態にする。
		 * 遷移状態から状態を確定するためには、メソッド commit か、
		 * メソッド rollback のいづれかを呼び出さなければならない。
		 *
		 * @param	status	状態
		 * @return			遷移状態にできた場合は、true を返す。
		 */
		synchronized
		boolean change(int status)
		{
			switch (status) {
			case ACTIVE:
				switch (now) {
				case CREATED:	now = INITIALIZING; break;
				case INACTIVE:	now = ACTIVATING; break;
				default:
					return false;
				}
				break;
			case INACTIVE:
				switch (now) {
				case ACTIVE:	now = DEACTIVATING; break;
				default:
					return false;
				}
				break;
			case REMOVED:
				switch (now) {
				case ACTIVE:	now = REMOVING; break;
				default:
					return false;
				}
				break;
			case FREE:
				switch (now) {
				case CREATED:	now = FREE; break;
				default:
					return false;
				}
				break;
			default:
				return false;
			}
			return true;
		}

		/**
		 * 遷移状態から直前の状態に確定する。
		 *
		 * @return	直前の状態に戻すことができた場合は、trueを返す。
		 */
		synchronized
		boolean rollback()
		{
			switch (now) {
			case INITIALIZING:	now = CREATED; break;
			case ACTIVATING:	now = INACTIVE; break;
			case DEACTIVATING:	now = ACTIVE; break;
			case REMOVING:		now = ACTIVE; break;
			default:
				return false;
			}
			notifyAll();
			return true;
		}

		/**
		 * 遷移状態から状態を確定する。
		 *
		 * @return	状態を確定できた場合は、trueを返す。
		 */
		synchronized
		boolean commit()
		{
			switch (now) {
			case INITIALIZING:	now = ACTIVE; break;
			case ACTIVATING:	now = ACTIVE; break;
			case DEACTIVATING:	now = INACTIVE; break;
			case REMOVING:		now = REMOVED; break;
			case REMOVED:		now = FREE; break;
			case INACTIVE:		now = FREE; break;
			default:
				return false;
			}
			notifyAll();
			return true;
		}

		/**
		 * グローバルアクセスを受けて、メソッドを実行できる状態かを調べる。
		 * セル（グローバルオブジェクト）が遷移状態の場合は、
		 * 状態が確定するまで待つ。但し、指定された待機時間が経過し、かつ、
		 * その時点で状態の変化がない場合は、false を返す。
		 *
		 * @param	waitTime	待機時間（ミリ秒）
		 * @return				メソッドを実行できる状態の場合は、true を返す。
		 */
		synchronized private
		boolean checkGlobalAccess(long waitTime)
		{
			int old;
			do {
				switch (now) {
				case ACTIVE:		return true;
				case INITIALIZING:	break;
				case ACTIVATING:	break;
				case DEACTIVATING:	break;
				case REMOVING:		break;
				default:
					return false;
				}
				try {
					Executor.debug(CN,"checkGlobalAccess","Pending global access, "+this);
					old = now;
					wait(waitTime);
					if (waitTime != 0 && old == now) return false;
				} catch (InterruptedException e) {
					Executor.error(CN,"checkGlobalAccess","Interrupted while waiting until " +this,e);
					return false;
				}
			} while (now != FREE);
			return false;
		}

		/**
		 * 非活性化の状態になるまで待つ。
		 *
		 * <DL><DT>
		 * 【注意】<DD>
		 * 非活性化の状態とは、そのセルがグローバルアクセスを受けることが
		 * できないことが確定していることを示す。
		 * この意味では、REMOVED状態, INACTIVE遷移状態も非活性化の状態に
		 * 含まれるが、実装上はセルは必ずFREE状態を経由するので、
		 * 次のような実装にしている。
		 * なお、一般に不活性化は次に活性化できることを暗に意味しているが、
		 * 非活性化にはそのような意味は含まれない。
		 * </DL>
		 *
		 * @return			非活性化の状態になっている場合は、true を返す。
		 * @exception	InterruptedException
		 *					通常は発生しない。
		 */
		synchronized
		void watch()
		throws InterruptedException
		{
			while (now != FREE) wait();
		}

		/**
		 * 引数で指定された状態に対応する文字列を返す。
		 * 主にデバッグを目的とするメソッドである。
		 *
		 * @param	status	状態
		 * @return			状態に対応する文字列
		 */
		String toString(int status)
		{
			switch (status) {
				case FREE: 			return "FREE";
				case CREATED:		return "CREATED";
				case INITIALIZING:	return "INITIALIZING";
				case ACTIVE:		return "ACTIVE";
				case REMOVING:		return "REMOVING";
				case REMOVED:		return "REMOVED";
				case DEACTIVATING:	return "DEACTIVATING";
				case ACTIVATING:	return "ACTIVATING";
				case INACTIVE:		return "INACTIVE";
			}
			return "Unknown";
		}

		/**
		 * セル（グローバルオブジェクト）の状態を印字
		 */
		public
		String toString()
		{
			return toString(now);
		}
	}

	/**
	 * セル（グローバルオブジェクト）の状態
	 */
	private Status status;

	/**
	 * このセルが結び付けられているGOD
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * GODのロックを獲得しているGODオブジェクトを設定する。
	 * </DL>
	 */
	private ExGOD god;

	/**
	 * オブジェクトイメージのファイルのベース名
	 * セル（スレッドグループ）の生成時に指定される。
	 *
	 * @see	ExCellManager#objectImageFilename
	 */
	private String objectImageFilename;

	/**
	 * セル（グローバルオブジェクト）
	 */
	private OzCell globalObject = null;

	/**
	 * ユーザプログラムに引き渡す文字列の配列
	 *
	 * @see	OzSystem#getArguments()
	 */
	private String[] arguments = null;

	/**
	 * セル毎のセキュリティを管理するオブジェクト
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * 正式な仕様ではない。
	 * </DL>
	 *
	 */
	private OzUserSecurity us = null;

	/**
	 * デバッグのためのメッセージ出力の有無のフラグ
	 */
	boolean debug = true;

	/**
	 * セル（グローバルオブジェクト）を操作するための
	 * オブジェクトと対応するGODを作成し、
	 * そのGODをロック状態にする。
	 *
	 * @param	god			GODオブジェクト
	 * @param	oiFilename	オブジェクトイメージファイルのベース名
	 * @param	created		既に作成されているセル（グローバルオブジェクト）
	 *						の場合は、true を指定する。
	 */
	private
	ExCell(ExGOD god, String oiFilename, boolean created)
	throws ExException
	{
		super(god.getName());
		setMaxPriority(Thread.NORM_PRIORITY);
		this.objectImageFilename = oiFilename;
		this.god = god;
		this.debug = Executor.debug;
		try {
			god.acquire();
		} catch (ExGODInvalidPathException e) {
			Executor.error(CN,"ExCell","(god="+god+")",e);
			throw new ExException(e.getClass().getName());
		} catch (ExGODInvalidStateException e) {
			if (created) {
				throw new ExIllegalCellStateException(e.getMessage());
			} else {
				throw new ExGODConflictException(god.getName());
			}
		}
		File objectImage = new File(god,oiFilename);
		if (objectImage.exists()) {
			if (created) {
				status = new Status(INACTIVE);
			} else {
				god.release();
				throw new ExGODConflictException(god.getName());
			}
		} else {
			if (!created) {
				status = new Status(CREATED);
			} else {
				god.release();
				throw new ExCellNotFoundException(god.getName());
			}
		}
	}

	/**
	 * 既に作成されたセル（グローバルオブジェクト）を操作するための
	 * オブジェクトを作成し、対応するGODをロック状態にする。
	 * コンストラクタとは異なり、不要なディレクトリを作成しない。
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * 既に作成されたセルとは、メモリ上にあるという意味ではない。
	 * </DL>
	 *
	 * @param	god			GODオブジェクト
	 * @param	oiFilename	オブジェクトイメージファイル名
	 *
	 * @see	ExCell(ExGOD, String, boolean)
	 */
	static
	ExCell find(ExGOD god, String oiFilename)
	throws ExIllegalCellStateException, ExCellNotFoundException, ExException
	{
		if (god.exists() && god.isDirectory()) {
			try {
				return new ExCell(god,oiFilename,true);
			} catch (ExGODConflictException e) {
				Executor.error(CN,"find","(god="+god+")",e);
				throw new ExException(e.getClass().getName());
			}
		}
		throw new ExCellNotFoundException(god.getName());
	}

	/**
	 * 新しく作成するセル（グローバルオブジェクト）を操作するための
	 * オブジェクトと対応するGODを作成し、そのGODをロック状態にする。
	 *
	 * @param	god		GODオブジェクト
	 * @param	oiFilename	オブジェクトイメージファイル名
	 *
	 * @see	ExCell(ExGOD, String, boolean)
	 */
	ExCell(ExGOD god, String oiFilename)
	throws ExGODConflictException, ExException
	{
		this(god, oiFilename, false);
	}

	/**
	 * グローバルオブジェクトディレクトリを獲得せずに
	 * セルを作成する。これは、エグゼキュータ内部の
	 * 処理を行うためのスレッドが属するスレッドグループ
	 * として使用される。
	 *
	 * @param	globalObject
	 *				グローバルオブジェクト
	 * @param	god	OZホームからのグローバルオブジェクトディレクトリの
	 *				相対パス名を指定する。
	 */
	ExCell(OzCell globalObject, String god)
	{
		super(god);
		debug = Executor.debug;
		this.globalObject = globalObject;
		setMaxPriority(Thread.MAX_PRIORITY);
		status = new Status(ACTIVE);
	}

	/**
	 * グローバルアクセスを受けて、メソッドを実行できる状態かを調べる。
	 * セル（グローバルオブジェクト）が遷移状態の場合は、
	 * 状態が確定するまで待つ。但し、指定された待機時間が経過し、かつ、
	 * その時点で状態の変化がない場合は、false を返す。
	 *
	 * @param	waitTime	待機時間（ミリ秒）
	 * @return				メソッドを実行できる状態の場合は、true を返す。
	 */
	boolean checkGlobalAccess(long waitTime)
	{
		return status.checkGlobalAccess(waitTime);
	}

	/**
	 * 非活性化の状態になるまで待つ。
	 *
	 * @return			非活性化の状態になっている場合は、true を返す。
	 * @exception	InterruptedException
	 *					通常は発生しない。
	 */
	void watch()
	throws InterruptedException
	{
		status.watch();
	}

	/**
	 * 当該スレッドが動作しているセル（スレッドグループ）を返す。
	 * 
	 * @return	セル（スレッドグループ）
	 */
	static
	ExCell currentCell()
	{
		ThreadGroup group = Thread.currentThread().getThreadGroup();
		return (ExCell)group;
	}

	/**
	 * 新しいプロセスを生成するするために、このセル（スレッドグループ）に
	 * 属するスレッドをチャネルとして生成し、実行を開始する。
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * 同じ仕組みを使っているが、グローバルアクセスの受け入れとは
	 * 全く独立であるので、メソッド checkGlobalAccess を呼び出す必要はない。
	 * </DL>
	 *
	 * @param	caller	呼び出し側のチャネル、通常はクラス ExProcess のオブジェクト
	 * @param	proxy	別のスレッドで実際のメソッド呼出しを行うオブジェクト
	 * @param	object	メソッドの呼出しが行われるオブジェクト
	 * @param	args	メソッドの呼出しに使われる引数
	 */
	ExChannel fork(ExCallerChannel caller, Runnable proxy, Object object, Object[] args)
	{
		Executor.debug(CN,"fork","("+caller+","+proxy+","+object+",)");
		ExChannel channel = new ExChannel(caller, object, args);
		ExThread t = new ExThread(this, proxy, channel);
		channel.start(t);
		return channel;
	}

	/**
	 * グローバルアクセスを受けて、実際にメソッドを呼び出すための
	 * 処理をプロキシに行わせるために、このセルに属するスレッドを
	 * チャネルとして生成し、実行を開始する。
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * チャネルを生成するまで、セルの状態を変更できてはならない。
	 * 厳密には、インナークラス Status のメソッド rollback と
	 * メソッド commit の実行をロック（禁止ではない）すればよいが、
	 * 実装上は、メソッド change 等も含めてその実行をロックしている。
	 * </DL>
	 *
	 * @param	caller	呼び出し側のチャネル
	 * @param	proxy	実際のメソッドを呼び出すオブジェクト
	 * @return			チャネル
	 * @exception	ClassNotFoundException
	 *					グローバルアクセスを行うには、そのグローバルオブジェクトの
	 *					クラスと対になっているプロキシのクラスがなければならない。
	 * @exception	ExCellNotActiveException
	 *					セル（グローバルオブジェクト）はグローバルアクセスを
	 *					受けて、対応するメソッドが実行できる状態ではない。
	 * @exception	ExCellNotFoundException
	 *					セル（グローバルオブジェクト）は存在しない。
	 */
	ExChannel fork(ExCallerChannel caller, OzProxy proxy)
	throws ClassNotFoundException, ExCellNotActiveException, ExCellNotFoundException
	{
		Executor.debug(CN,"fork","("+caller+","+proxy+")");
		ExChannel channel = null;
		if (proxy instanceof ExProxy) {
			channel = new ExChannel(caller, globalObject, null);
		} else {
			synchronized (status) {
				if (status.checkGlobalAccess(0)) {
					if (globalObject.proxyClassName == null) {
						Executor.syslog(CN,"fork","***** CAUTION proxy class name is null for "
													+globalObject.getClass().getName(),null);
					} else {
						Class c = Executor.loadClass(globalObject.proxyClassName);
						// checkProxy(c,proxy.getClass());
					}
					channel = new ExChannel(caller, globalObject, null);
				} else {
					if (ExCellManager.exists(god)) {
						throw new ExCellNotActiveException(getName());
					} else {
						throw new ExCellNotFoundException(getName());
					}
				}
			}
		}
		ExThread t = new ExThread(this, proxy, channel);
		t.color = ExThread.GREEN;
		channel.start(t);
		return channel;
	}

	/**
	 * 新しいプロセスを生成するするために、このセルに属するスレッドを
	 * チャネルとして生成し、実行を開始する。グローバルオブジェクトに
	 * 対して、ローカルオブジェクトとしてのメソッドの呼出しを行う。
	 * エグゼキュータ内部の処理を行うためにExProcessを
	 * 介して呼び出される。
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * 厳密には、ACTIVE状態のロックが必要であるが、エグゼキュータ本体
	 * （クラス Executor で作成されたセル）が非ACTIVE状態になることはない
	 * ので、ロックを省略している。
	 * </DL>
	 *
	 * @param	caller	呼び出し側のチャネル、通常はクラス ExProcess のオブジェクト
	 * @param	target	別のスレッドで実行されるメソッドを持つオブジェクト
	 * @param	args	メソッドの呼出しに使われる引数
	 * @return			チャネル
	 */
	ExChannel fork(ExCallerChannel caller, Runnable target, Object[] args)
	{
		Executor.debug(CN,"fork","(caller="+caller+",target="+target+",)");
		ExChannel channel = new ExChannel(caller, globalObject, args);
		ExThread t = new ExThread(this, target, channel);
		t.color = ExThread.GREEN;
		channel.start(t);
		return channel;
	}

	/**
	 * グローバルオブジェクトのクラスと対になっているプロキシのクラスを
	 * 継承しているかどうかを調べる。
	 *
	 * @param	myClass		グローバルオブジェクトのクラスと対のプロキシのクラス
	 * @param	proxyClass	条件を満たすクラスかを調べる対象
	 * @exception			SecurityException
	 *						運ばれてきたプロキシのオブジェクトは、グローバルオブジェクトの
	 *						クラスと対のプロキシのクラスを継承していない。
	 */
	void checkProxy(Class myClass, Class proxyClass)
	throws SecurityException
	{
		Executor.debug(CN,"checkProxy","("+myClass+","+proxyClass+")");
		//OzProxy p = new OzProxy((String)null);
		//if (globalObject.OZ_Proxy().getClass() != proxy.getClass() && p.getClass() != proxy.getClass()) {
		//	throw new SecurityException("Illegal class of proxy for global object.");
		//}
		do {
			if (myClass == proxyClass) return;
			myClass = myClass.getSuperclass();
		} while (myClass != null);
		throw new SecurityException("Illegal class of proxy for global object.");
	}

	/**
	 * 新しいセル（グローバルオブジェクト）を生成し、ACTIVE 状態にする。
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * セル（スレッドグループ）のメソッドではあるが、
	 * シェルで指定された引数（文字列の配列）を運ぶためと、
	 * セル（グローバルオブジェクト）へのメソッド呼び出しを
	 * このクラスと独立させるためにプロキシが必要になっている。
	 * </DL>
	 *
	 * @param	codePath	パッケージ名を含むクラス名を指定する。
	 * @param	proxy		セルのメソッドを呼び出すためのプロキシを指定する。
	 *
	 * @exception		ExIllegalCellStateException
	 *						その操作を行うことができるセル（グローバルオブジェクト）の状態ではない。
	 * @exception		ExClassNotFoundException
	 *						引数 codePath で指定されたクラスが見つからない。
	 * @exception		ExIllegalAccessException
	 *						セル（グローバルオブジェクト）生成時に発生する。
	 * @exception		ExInstantiationException
	 *						セル（グローバルオブジェクト）生成時に発生する。
	 * @exception		ExCellHookException
	 *						グローバルオブジェクト（プロキシ）のメソッドが例外終了した。
	 * @exception		ExException
	 *						エグゼキュータ内部で例外が発生した。
	 */
	void initializing(String codePath, ExProxy proxy)
	throws ExException
	{
		if (status.change(ACTIVE)) {
			Executor.debug(CN,"initializing",getName()+" status is "+status);
		} else {
			throw new ExIllegalCellStateException("Illegal global object("+getName()+") status("+status+")");
		}
		try {
			try {
				Class c = Executor.loadClass(codePath);
				Object o = c.newInstance() ;
				globalObject = (OzCell)o ;
				ExCellManager.put(god,this);
				ExAddressManager.put(god,ExCommManager.executorAddress);
			} catch (ClassNotFoundException e) {
				throw new ExClassNotFoundException(e.getMessage());
			} catch (IllegalAccessException e) {
				throw new ExIllegalAccessException(e.getMessage());
			} catch (InstantiationException e) {
				throw new ExInstantiationException(e.getMessage());
			} catch (ExException e) {
				throw e;
			} catch (Exception e) {
				Executor.error(CN,"initializing","cell="+getName()+",codePath="+codePath,e);
				throw new ExException(e.getClass().getName());
			}
		} catch (ExException e) {
			globalObject = null;
			status.rollback();
			throw e;
		}

		/*
		 * 次のcatch文では、ユーザ定義の例外のを捕捉する可能性があるが、
		 * デバッグのため例外の印字を行っている。
		 * 将来的にはセキュリティホールになるので、
		 * 例外の印字はしないように変更した方がよい。
		 */
		try {
			proxy.initialize();
			status.commit();
		} catch (Error e) {
			Executor.error(CN,"initializing","codePath="+codePath+","+"proxy="+proxy,e);
			globalObject = null;
			status.rollback();
			throw e;
		} catch (Exception e) {
			Executor.debug(CN,"initializing","codePath="+codePath+","+"proxy="+proxy,e);
			ExAddressManager.remove(god);
			ExCellManager.remove(god);
			globalObject = null;
			status.rollback();
			throw new ExCellHookException("initialize",e);
		}
	}

	/**
	 * セル（グローバルオブジェクト）を ACTIVE 状態にする。
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * セル（スレッドグループ）のメソッドではあるが、
	 * シェルで指定された引数（文字列の配列）を運ぶためと、
	 * セル（グローバルオブジェクト）へのメソッド呼び出しを
	 * このクラスと独立させるためにプロキシが必要になっている。
	 * </DL>
	 *
	 * @param	proxy		セルのメソッドを呼び出すためのプロキシを指定する。
	 *
	 * @exception		ExIllegalCellStateException
	 *						その操作を行うことができるセル（グローバルオブジェクト）の状態ではない。
	 * @exception		ExClassNotFoundException
	 *						オブジェクトイメージファイルからオブジェクトを
	 *						作成中に必要なクラスが見つからない。
	 * @exception		ExCellImageIOException
	 *						オブジェクトイメージの読み込み中に例外が発生した。
	 * @exception		ExCellHookException
	 *						グローバルオブジェクト（プロキシ）のメソッドが例外終了した。
	 * @exception		ExException
	 *						エグゼキュータ内部で例外が発生した。
	 */
	void activating(ExProxy proxy)
	throws ExException
	{
		if (status.change(ACTIVE)) {
			Executor.debug(CN,"activating",getName()+" status is "+status);
		} else {
			throw new ExIllegalCellStateException("Illegal global object("+getName()+") status("+status+")");
		}
		ExObjectInputStream in = null;
		try {
			try {
				File objectImage = new File(god,objectImageFilename);
				in = new ExObjectInputStream(new FileInputStream(objectImage));
				globalObject = (OzCell)in.readObject();
				in.close();
				ExCellManager.put(god,this);
				ExAddressManager.put(god,ExCommManager.executorAddress);
			} catch (ClassNotFoundException e) {
				throw new ExClassNotFoundException(e.getMessage());
			} catch (IOException e) {
				throw new ExCellImageIOException(e.getMessage());
			} catch (ExException e) {
				throw e;
			} catch (Exception e) {
				Executor.error(CN,"activating","proxy="+proxy,e);
				throw new ExException(e.getClass().getName());
			}
		} catch (ExException e) {
			globalObject = null;
			status.rollback();
			throw e;
		}

		/*
		 * 次のcatch文では、ユーザ定義の例外のを捕捉する可能性があるが、
		 * デバッグのため例外の印字を行っている。
		 * 将来的にはセキュリティホールになるので、
		 * 例外の印字はしないように変更した方がよい。
		 */
		try {
			proxy.go();
			status.commit();
		} catch (Error e) {
			Executor.error(CN,"activating","proxy="+proxy,e);
			globalObject = null;
			status.rollback();
			throw e;
		} catch (Exception e) {
			Executor.debug(CN,"activating","proxy="+proxy,e);
			ExAddressManager.remove(god);
			ExCellManager.remove(god);
			globalObject = null;
			status.rollback();
			throw new ExCellHookException("go",e);
		}
	}

	/**
	 * セル（グローバルオブジェクト）を INACTIVE 状態にする。
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * セル（スレッドグループ）のメソッドではあるが、
	 * シェルで指定された引数（文字列の配列）を運ぶためと、
	 * セル（グローバルオブジェクト）へのメソッド呼び出しを
	 * このクラスと独立させるためにプロキシが必要になっている。
	 * </DL>
	 *
	 * @param	proxy		セルのメソッドを呼び出すためのプロキシを指定する。
	 *
	 * @exception		ExIllegalCellStateException
	 *						その操作を行うことができるセル（グローバルオブジェクト）の状態ではない。
	 * @exception		ExCellHookException
	 *						グローバルオブジェクト（プロキシ）のメソッドが例外終了した。
	 * @exception		ExException
	 *						エグゼキュータ内部で例外が発生した。
	 */
	void deactivating(ExProxy proxy)
	throws ExException
	{
		if (status.change(INACTIVE)) {
			Executor.debug(CN,"deactivating",getName()+" status is "+status);
		} else {
			throw new ExIllegalCellStateException("Illegal global object("+getName()+") status("+status+")");
		}

		/*
		 * 次のcatch文では、ユーザ定義の例外のを捕捉する可能性があるが、
		 * デバッグのため例外の印字を行っている。
		 * 将来的にはセキュリティホールになるので、
		 * 例外の印字はしないように変更した方がよい。
		 */
		try {
			proxy.quiet();
		} catch (Error e) {
			Executor.error(CN,"deactivating","proxy="+proxy,e);
			status.rollback();
			throw e;
		} catch (Exception e) {
			Executor.debug(CN,"deactivating","proxy="+proxy,e);
			throw new ExCellHookException("quiet",e);
		} finally {
			ExAddressManager.remove(god);
			ExCellManager.remove(god);
			status.commit();
		}
	}

	/**
	 * セル（グローバルオブジェクト）を REMOVED 状態にする。
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * セル（スレッドグループ）のメソッドではあるが、
	 * 他の状態を変更するメソッドに合わせるために
	 * プロキシが必要になっている。
	 * </DL>
	 *
	 * @param	proxy		セルのメソッドを呼び出すためのプロキシを指定する。
	 *
	 * @exception	ExException
	 *					エグゼキュータ内部で例外が発生した。
	 */
	void removing(ExProxy proxy)
	throws ExException
	{
		if (status.change(REMOVED)) {
			Executor.debug(CN,"removing",getName()+" status is "+status);
		} else {
			throw new ExIllegalCellStateException("Illegal global object("+this+")");
		}
		try {
			File objectImage = new File(god,objectImageFilename);
			File backup = new File(god,objectImageFilename+"Backup");
			File tempolary = new File(god,objectImageFilename+"Tempolary");
			if (objectImage.exists() && ! objectImage.delete()) {
				Executor.error(CN,"remove","Fail to delete "+objectImage);
			}
			if (backup.exists() && ! backup.delete()) {
				Executor.error(CN,"remove","Fail to delete "+backup);
			}
			if (tempolary.exists() && ! tempolary.delete()) {
				Executor.error(CN,"remove","Fail to delete "+tempolary);
			}
		} catch (Exception e) {
			Executor.error(CN,"removing","proxy="+proxy,e);
			throw new ExException(e.getClass().getName());
		} finally {
			ExAddressManager.remove(god);
			ExCellManager.remove(god);
			status.commit();
		}
	}

	/**
	 * セル（グローバルオブジェクト）のオブジェクトメージを
	 * 指定されたファイルに書き込む。
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * このメソッドを実行中は、セルの状態を変更できてはならない。
	 * 厳密には、インナークラス Status のメソッド rollback と
	 * メソッド commit の実行をロック（禁止ではない）すればよいが、
	 * 実装上は、メソッド change 等も含めてその実行をロックしている。
	 * <DT>
	 * 【注意】<DD>
	 * 「クラッシュ」や例外等に備えて、一時的なファイルに現在の
	 * オブジェクトイメージを書き込んだ上でファイル名の変更により
	 * オブジェクトイメージのファイルを変更している。
	 * 最悪の状態を想定して、これらの一連の処理を行う直前の
	 * オブジェクトイメージのファイルをバックアップとして残している。
	 * </DL>
	 *
	 * @param	oiFilename	オブジェクトイメージファイル名
	 * @exception		ExCellImageIOException
	 *						オブジェクトイメージのファイルへの書き込みで例外が発生した。
	 * @exception		ExException
	 *						エグゼキュータ内部で例外が発生した。
	 */
	private
	void flush(String oiFilename)
	throws ExException
	{
		synchronized (status) {
			Executor.debug(CN,"flush","start "+this.getName());
			ExObjectOutputStream out = null;
			File objectImage = new File(god,oiFilename);
			File current = new File(god,oiFilename);
			File backup = new File(god,oiFilename+"Backup");
			File tempolary = new File(god,oiFilename+"Tempolary");
			try {
				out = new ExObjectOutputStream(new FileOutputStream(tempolary));
				out.writeObject(globalObject);
				out.close();
			} catch (IOException e) {
				Executor.error(CN,"flush","god="+getName(),e);
				if (! tempolary.delete()) {
					Executor.error(CN,"flush","Fail to delete "+tempolary);
				}
				throw new ExCellImageIOException(e.getMessage()+"("+getName()+")");
			}
			if (backup.exists() && ! backup.delete()) {
				Executor.error(CN,"flush","Fail to delete "+backup);
			}
			if (current.exists() && ! current.renameTo(backup)) {
				Executor.error(CN,"flush","Fail to rename "+current);
			}
			if (! tempolary.renameTo(objectImage)) {
				Executor.error(CN,"flush","Fail to rename "+tempolary);
			}
			Executor.debug(CN,"flush","finish "+this.getName());
		}
	}

	/**
	 * セル（グローバルオブジェクト）のオブジェクトメージを
	 * ファイルに書き込む。
	 *
	 * @exception		ExException
	 *						エグゼキュータ内部で例外が発生した。
	 *
	 * @see	ExCell#flush(String)
	 */
	void flush()
	throws ExException
	{
		flush(objectImageFilename);
	}

	/**
	 * セル（スレッドグループ）を論理的に開放し、GODのロックを開放する。
	 *
	 * @exception			ExException
	 *						例外が発生した。
	 */
	synchronized
	void free()
	throws ExException
	{
		try {
			god.release();
		} catch (Exception e) {
			Executor.error(CN,"free","god="+getName(),e);
			throw new ExException(e.getClass().getName());
		}
		status.change(FREE);
		status.commit();
		globalObject = null;
		setDaemon(true);
		if (activeCount()==0) destroy();
	}

	/**
	 * このセルに属しているスレッドの一覧を表示する。
	 *
	 * @param	indent	各行の先頭に挿入するスペースの文字数。
	 */
	synchronized
	void list(PrintWriter out, int indent)
	{
		char[] chars = new char[indent];
		for (int i = 0; i < indent; i ++) chars[i] = ' ';
		String spaces = new String(chars);
		Thread[] list = new Thread[activeCount()];
		int n = enumerate(list);
		for (int i = 0; i < n; i ++) {
			if (list[i].getThreadGroup() == this) {
				if (list[i] instanceof ExThread) {
					ExThread t = (ExThread)list[i];
					out.println(spaces+t+" "+t.channel);
				} else {
					out.println(spaces+list[i]);
				}
			}
		}
	}

	/**
	 * セルを表示可能な文字列に変換する。
	 * セルの一覧表示を行う際に間接的に呼び出されることを想定している。
	 * 文字列の内容には、クラス名の部分にパッケージ名を含まない、
	 * セルの状態を表す文字列を追加している点に注意する。
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * 現状ではデバッグを目的に呼び出す場合もあるので、
	 * シンプルな内容にはしていない。
	 * </DL>
	 *
	 * @see	ThreadGroup#getName
	 * @see	ThreadGroup#getMaxPriority
	 */
	public
	String toString()
	{
		return CN + "@" + Integer.toHexString(hashCode())
				+ "[name="+getName() + ",maxpri="+getMaxPriority() + ",status="+status+"]";
	}

	/**
	 * ユーザプログラムに引き渡す文字列の配列を参照する。
	 *
	 * @return	ユーザプログラムに渡す文字列の配列
	 *
	 * @see	OzSystem#getArguments()
	 * @see	ExCell#setArguments()
	 * @see	ExCell#arguments
	 */
	String[] getArguments()
	{
		return this.arguments;
	}

	/**
	 * ユーザプログラムに引き渡す文字列の配列を設定する。
	 *
	 * @param	ユーザプログラムに渡す文字列の配列
	 *
	 * @see	OzSystem#getArguments()
	 * @see	ExCell#getArguments()
	 * @see	ExCell#arguments
	 */
	void setArguments(String[] arguments)
	{
		this.arguments = arguments;
	}

	/**
	 * 当該セルのセキュリティのポリシーを担うオブジェクトを設定する。
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * 正式な仕様ではない。
	 * </DL>
	 *
	 * @param	us	セキュリティのポリシーを担うオブジェクト
	 */
	void setUserSecurity(OzUserSecurity us)
	{
		this.us = us;
	}

	/**
	 * 当該セルのセキュリティのポリシーを担うオブジェクトを参照する。
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * 正式な仕様ではない。
	 * </DL>
	 *
	 * @return	us	セキュリティのポリシーを担うオブジェクト
	 */
	OzUserSecurity getUserSecurity()
	{
		return us;
	}
}
