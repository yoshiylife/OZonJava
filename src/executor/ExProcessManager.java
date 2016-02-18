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
 * $Id: ExProcessManager.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 *
 * 注意: このファイルは vi で、hardtab=8, tabstop=4 として編集されている
 */

package JP.go.ipa.oz.system;

import java.util.Hashtable;
import java.util.Enumeration;

/**
 * ExProcessManager はＯＺのプロセス（起点）を管理し、
 * ＡＰＩである OzProcess で生成されたオブジェクトとその実装
 * である ExProcess で生成されたオブジェクトを関連づける。
 *
 * @see OzProxy
 * @see OzProcess
 * @see ExProcess
 *
 * @version 	$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author		Yasumitsu Yoshida
 */
class ExProcessManager
{
	/**
	 * エグゼキュータ実装のデバッグ用
	 */
	static final String CN = "ExProcessManager";

	/**
	 * OzProcess で生成されたオブジェクトとその実装
	 * である ExProcess で生成されたオブジェクトを
	 * 関連づけるためのキーを発行するために最後に発行した
	 * キーを保持する。使用されていないキーは再利用される。
	 * このキーをプロセスＩＤと呼ぶ。ただし、プロセスＩＤは
	 * チャネルを伝播する段階でエグゼキュータを識別する
	 * ための情報が付加される場合がある。
	 */
	private static int lastProcessID = 0;

	/**
	 * OzProcess で生成されたオブジェクトとその実装
	 * である ExProcess で生成されたオブジェクトを
	 * 関連づけるために、プロセスＩＤと ExProcess で生成
	 * されたオブジェクトとの対を保持するテーブルである。
	 */
	private static Hashtable exProcessTable = new Hashtable(10);

	/**
	 * ExProcessManager はエグゼキュータに１つであり、
	 * クラスメソッドのみを持つので、オブジェクトを
	 * 生成する必要はない。
	 */
	private
	ExProcessManager()
	{
		/* Nothing */
	}

	/**
	 * 最後に発行したプロセスＩＤをヒントに
	 * 使用されていないプロセスＩＤが見つかるまで検索を繰り返す。
	 * 通常、約３万２千個程度のプロセスを同時生成することは
	 * 考えられないので、使用されていないプロセスＩＤが
	 * 見つからない場合の処理は行っていない。
	 *
	 * @return	プロセスＩＤ
	 */
	private static synchronized
	String findFreeProcessID()
	{
		int pid = lastProcessID ;
		do {
			if (pid == Integer.MAX_VALUE) {
				pid = 0;
			}
			pid ++;
			if (pid == lastProcessID) {
				Executor.error(CN,"findFreeProcessID","deadlock");
			}
		} while (exProcessTable.get(new Integer(pid)) != null);
		lastProcessID = pid;
		return Integer.toString(pid);
	}

	/**
	 * 新しいＯＺのプロセスを作成しテーブルに登録する。
	 * ただし、このメソッドを実行しているスレッドが
	 * 属しているセルに新しいスレッドを属させる。
	 *
	 * @param	proxy	実際のメソッド起動を行うオブジェクト
	 * @param	object	メソッド起動を行う対象
	 * @param	args	メソッド起動に必要な情報
	 * @return	プロセスＩＤ
	 *
	 * @see ExProcessManager#findFreeProcessID
	 * @see ExProcessManager#exProcessTable
	 * @see OzProxy
	 * @see ExProcess#fork
	 */
	static
	String fork(Runnable proxy, Object object, Object[] args)
	{
		String pid = findFreeProcessID();
		ExProcess p = new ExProcess(pid);
		p.fork(proxy, object, args);
		exProcessTable.put(pid, p);
		return pid;
	}

	/**
	 * 新しいＯＺのプロセスを作成しテーブルに登録する。
	 * ただし、指定されたセルに新しいスレッドを属させる。
	 * エグゼキュータ内部の処理を行うために呼び出される。
	 *
	 * @param	cell	スレッドを属させるセル
	 * @param	proxy	実際のメソッド起動を行うオブジェクト
	 * @param	args	メソッド起動に必要な情報
	 * @return	プロセスＩＤ
	 *
	 * @see ExProcessManager#findFreeProcessID
	 * @see ExProcessManager#exProcessTable
	 * @see OzProxy
	 * @see ExProcess#fork
	 */
	static
	String fork(ExCell cell, Runnable proxy, Object[] args)
	{
		String pid = findFreeProcessID();
		ExProcess p = new ExProcess(pid);
		p.fork(cell, proxy, args);
		exProcessTable.put(pid, p);
		return pid;
	}

	/**
	 * 指定されたプロセスＩＤを ExProcess で作成されたオブジェクトに
	 * 変換する。
	 *
	 * @param		pid プロセスＩＤ
	 * @return		ExProcess で作成されたオブジェクトを返す。
	 * @exception	ExNoSuchProcessException
	 *				指定されたプロセスＩＤに対応するオブジェクトがない。
	 *
	 * @see ExProcessManager#exProcessTable
	 * @see ExProcess
	 */
	static
	ExProcess toExProcess(String pid)
	throws ExNoSuchProcessException
	{
		ExProcess p = (ExProcess)exProcessTable.get(pid);
		if (p == null) throw new ExNoSuchProcessException(pid);
		return p;
	}

	/**
	 * 指定されたプロセスＩＤに対応する ExProcess で作成されたオブジェクトを
	 * テーブルから取り除く。もし指定されたプロセスＩＤが存在しなければ、
	 * ログ出力以外の処理は行わない。
	 *
	 * @param	pid プロセスＩＤ
	 *
	 * @see ExProcessManager#exProcessTable
	 * @see java.util.Hashtable#remove(java.lang.Object)
	 */
	static
	void detach(String pid)
	{
		if (exProcessTable.remove(pid) == null) {
			Executor.error(CN,"detach(pid="+pid+")",": do nothing");
		} else {
			Executor.debug(CN,"detach(pid="+pid+")");
		}
		/* for debug */
		if (exProcessTable.isEmpty()) {
			Executor.debug(CN,"detach","All processes detached.(last pid:"+lastProcessID+")");
		}
	}


	/*
	 * これ以降はデバッグとシェルのためのプログラムである。
	 * （詳細は省略）
	 */
	static {

		/**
		 * プロセス一覧を印字する。
		 */
		class List
		extends ExShellCommand
		{
			List()
			{
				usage = " ";
				comment = "list of processes";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (1 < args.length) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too many arguments");
				}

				Runtime runtime = Runtime.getRuntime();
				runtime.gc();
				runtime.runFinalization();
				Enumeration keys = exProcessTable.keys();
				while (keys.hasMoreElements()) {
					String key = (String)keys.nextElement();
					shell.stdout.println(exProcessTable.get(key));
				}

				return null;
			}
		}

		/**
		 * プロセスの終了を試みる。
		 */
		class Kill
		extends ExShellCommand
		{
			Kill()
			{
				usage = " <process> [<process>...]";
				comment = "kill process";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length < 2) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too few arguments");
				}

				for (int i = 1, n = args.length; i < n; i ++) {
					OzProcess p = new OzProcess(args[i]);
					p.kill();
				}

				return null;
			}
		}

		/**
		 * プロセスの終了を待つ。
		 */
		class Join
		extends ExShellCommand
		{
			Join()
			{
				usage = " <process>";
				comment = "join process";
			}
			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length != 2) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too few or many arguments");
				}

				OzProcess p = new OzProcess(args[1]);
				p.join();

				return null;
			}
		}

		ExShell.append("ps",new List());
		ExShell.append("kill",new Kill());
		ExShell.append("join",new Join());
	}
}
