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
 * $Id: ExShell.java,v 2.2 1997/12/04 04:55:20 yoshi Exp $
 *
 * 注意: このファイルは vi で、hardtab=8, tabstop=4 として編集されている
 */

package JP.go.ipa.oz.system;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Stack;

/**
 * ストリームからコマンド行を読み込んで解釈し、
 * コマンド名に対応するコマンドを実行する。
 *
 * 現在、少なくともSolaris(SPARC)版では標準入力からの入力待ちになると
 * JavaVM のスケジューラが停止する。従って、標準入力からの入力待ちになる
 * 状態では、他のスレッドは実行されない。
 *
 * @version		$Revision: 2.2 $, $Date: 1997/12/04 04:55:20 $
 * @author		Yasumitsu Yoshida
 */
class ExShell
extends OzSecure
implements Runnable
{
	/**
	 * エグゼキュータ実装のデバッグ用
	 */
	static final String CN = "ExShell";

	/**
	 * コマンド名とそれに対応する処理を行うオブジェクト
	 * （コマンド）のテーブルである。
	 */
	private static final Dictionary commands = new Hashtable();

	/**
	 * テーブルに指定されたコマンド名でコマンドを登録する。
	 *
	 * @param	cmdName	コマンド名
	 * @param	cmdObj	コマンド
	 * @return	既に登録されているコマンドがあった場合は、
	 *			そのコマンドを返す。それ以外は null を返す。
	 */
	static synchronized
	ExShellCommand append(String cmdName, ExShellCommand cmdObj)
	{
		ExShellCommand oldCmd;
		oldCmd = (ExShellCommand)commands.put(cmdName,cmdObj);
		if (oldCmd != null) {
			Executor.error(CN,"append","Replaced "+oldCmd+" with "+cmdObj+" for "+cmdName);
		}
		return oldCmd;
	}

	/**
	 * テーブルを指定されたコマンド名で検索し、
	 * コマンドを取り出す。
	 *
	 * @param	cmdName	コマンド名
	 * @return	見つかったコマンドを返す。それ以外は null を返す。
	 */
	static synchronized
	ExShellCommand search(String cmdName)
	{
		return (ExShellCommand)commands.get(cmdName);
	}

	/**
	 * テーブルからコマンド名で登録されている
	 * コマンドを削除する。
	 *
	 * @param	cmdName	コマンド名
	 * @return	削除したコマンドを返す。それ以外は null を返す。
	 */
	static synchronized
	ExShellCommand remove(String cmdName)
	{
		return (ExShellCommand)commands.remove(cmdName);
	}

	/**
	 * 最後に実行したコマンドの戻り文字列を保持する。
	 */
	String lastValue;

	/**
	 * 標準入力
	 */
	Reader stdin;

	/**
	 * 標準出力
	 */
	PrintWriter stdout;

	/**
	 * 標準エラー出力
	 */
	PrintWriter stderr;

	/**
	 * シェルのコマンドとしてシェルが
	 * 起動されたことを示すフラグ
	 */
	boolean subShell = false;

	/**
	 * コマンドループを中断する。
	 */
	boolean quit = false;

	/**
	 * ストリームからコマンド行を読み込んで解釈し、
	 * コマンド名に対応するコマンドを実行する
	 * オブジェクトを作成する。
	 *
	 * @param	stdin	標準入力
	 * @param	stdout	標準出力
	 * @param	stderr	標準エラー出力
	 */
	ExShell(Reader stdin, PrintWriter stdout, PrintWriter stderr)
	throws Exception
	{
		this.stdin = stdin;
		this.stdout = stdout;
		this.stderr = stderr;
		subShell = false;
	}

	/**
	 * ストリームからコマンド行を読み込んで解釈し、
	 * コマンド名に対応するコマンドを実行する
	 * オブジェクトを作成する。
	 * 但し、シェルのコマンドとしてシェルが
	 * 起動されたことを示すフラグがtrueに設定される。
	 *
	 * @param	parent	作成操作を行ったシェル
	 * @param	stdin	標準入力
	 */
	ExShell(ExShell parent, Reader stdin)
	throws Exception
	{
		this.stdin = stdin;
		this.stdout = parent.stdout;
		this.stderr = parent.stderr;
		subShell = true;
	}

	/**
	 * ストリームからコマンド行を読み込んで解釈し、
	 * コマンド名に対応するコマンドを実行する
	 * という動作をストリームが終端に達するまで繰り返す。
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * 同時に複数スレッドでこのメソッドを実行してはならない。
	 * </DL>
	 *
	 * @param	prompt		コマンド入力を促すプロンプト文字列
	 *						（nullを指定してもよい）
	 * @param	parameters	位置パラメータが指定された時の置換する
	 *						文字列の配列を持つ。$0 は配列の最初の要素に
	 *						対応し、通常はエグゼキュータを起動するための
	 *						スクリプトのファイル名が入る。
	 * @return	最後に実行したコマンドが返した文字列
	 *
	 * @see	OzSystem#getArguments()
	 */
	synchronized
	String action(String prompt, String[] parameters)
	throws Exception
	{
		StreamTokenizer st = new StreamTokenizer(stdin);
		st.commentChar('#');
		st.ordinaryChar('$');
		st.ordinaryChar(';');
		st.ordinaryChar('&');
		st.quoteChar('"');
		st.ordinaryChar('-');
		st.wordChars('-','-');
		st.wordChars('_','_');
		st.wordChars(':',':');
		st.eolIsSignificant(true);
		st.slashSlashComments(false);
		st.slashStarComments(false);

		int status = st.TT_EOL;
		try {
			do {
				if (status == st.TT_EOL && prompt != null) {
					stdout.print(prompt);
				}
				if (stdout != null) {
					stdout.flush();
				}
				status = doLine(st,parameters);
			} while (! quit  && status != st.TT_EOF);
		} catch (Exception e) {
			Executor.error(CN,"action","(prompt="+prompt+",...)",e);
		}
		return lastValue;
	}

	synchronized
	String action(String[] args)
	throws Exception
	{
		return action(null,args);
	}

	/**
	 * コマンド行を読み込んで１つのコマンドを実行する。
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * コマンド行は、コマンド区切り文字、あるいは、
	 * 行区切り文字まで文字列を意味する。
	 * </DL>
	 *
	 * @param	st			このストリームからコマンド行を読み込む
	 * @param	parameters	位置パラメータの展開に使用する文字列の配列
	 * @return	ストリームの状態を返す。
	 *
	 * @see	ExShell#action
	 */
	private int doLine(StreamTokenizer st, String[] parameters)
	throws Exception
	{
		int result = 0;
		int lineno = st.lineno();
		Stack stack = null;
		eol:
		for (stack = new Stack();;) {
			try {
				int ttype = st.nextToken();
				switch (ttype) {
				case st.TT_EOL:
					result = st.TT_EOL;
					break eol;
				case st.TT_EOF:
					result = st.TT_EOF;
					break eol;
				case st.TT_NUMBER:
					Integer inum = new Integer((int)st.nval);
					stack.push(inum.toString());
					break;
				case st.TT_WORD:
					stack.push(st.sval);
					break;
				case '$':
					switch (st.nextToken()) {
					case '?':
						stack.push(lastValue);
					case '*':
						for (int i = 1; i < parameters.length; ++ i) {
							stack.push(parameters[i]);
						}
						break;
					case st.TT_NUMBER:
						int position = (int)st.nval;
						stack.push(position < parameters.length ? parameters[position]: null);
						break;
					default:
						stderr.println(CN+": $ parameter error at "+lineno);
					}
					break;
				case ';':
					result = ';';
					break eol;
				case '"':
					stack.push(st.sval);
					break;
				case '\'':
					stack.push(st.sval);
					break;
				case '&':
					char c[] = new char[1];
					c[0] = '&';
					stack.push(new String(c));
					break;
				default: stderr.print(CN+": ? "+(char)st.ttype);
				}
			} catch (IOException e) {
				throw e;
			} catch (Exception e) {
				Executor.error(CN,"doline",e);
			}
		}
		if (!stack.empty()) {
			try {
				String s = (String)stack.peek();
				if (s.equals("&")) {
					stack.pop();
					String[] args;
					args = new String[stack.size()];
					for (int i = args.length-1; 0 <= i ; i --) {
						args[i] = (String)stack.pop();
					}
					new OzProcess(this, this, (Object[])args);
				} else {
					String[] args;
					args = new String[stack.size()];
					for (int i = args.length-1; 0 <= i ; i --) {
						args[i] = (String)stack.pop();
					}
					lastValue = call(args);
				}
			} catch (IllegalArgumentException e) {
				stderr.println(e.getMessage());
			} catch (ExCellHookException e) {
				stderr.println(e);
				e.getException().printStackTrace(stderr);
			} catch (Exception e) {
				// stderr.println(e);
				e.printStackTrace(stderr);
			}
		}
		return result;
	}

	/**
	 * コマンド名に対応するコマンドを検索し、実行する。
	 *
	 * @param	args	コマンド行に指定された文字列の配列
	 * @return	コマンドを実行した結果として得られた文字列
	 */
	private
	String call(String[] args)
	throws Exception
	{
		if (Executor.debug) {
			int n = args.length ;
			for (int i = 0; i < n; i ++) {
				Executor.debug(CN,"call","args["+i+"]="+args[i]);
			}
		}
		ExShellCommand cmd = search(args[0]);
		if (cmd == null) {
			throw new IllegalArgumentException("Unknown command: "+args[0]);
		}
		return cmd.action(this,args);
	}

	/**
	 * 新しいスレッドでコマンドを実行するために、
	 * そのスレッドで最初に実行される。
	 */
	public final
	void run()
	{
		Object result;
		boolean status;

		try {
			ExThread t = (ExThread)Thread.currentThread();
			ExCalleeChannel callee = t.channel;
			Object object = callee.object();
			Object[] arguments = callee.arguments();
			try {
				result = invoke(object, arguments);
				status = true;
			} catch (Exception e) {
				Executor.debug(CN,"run",e);
				result = e;
				status = false;
			}
			callee.exit(status, result);
		} catch (Exception e) { // unexpect exception
			Executor.error(CN,"run",e);
		}
	}

	/**
	 * 新しいスレッドでコマンドを実行する。
	 *
	 * @param	object	コマンド呼出しの対象
	 * @param	argv	コマンド呼出し時の引数
	 */
	protected
	Object invoke(Object object, Object[] argv)
	throws Exception
	{
		ExShell shell = (ExShell)object;
		String[] args = (String[])argv;
		return shell.call(args);
	}

	/*
	 * これ以降はデバッグとシェルのためのプログラムである。
	 * （詳細は省略）
	 */
	static {

		/**
		 * サブシェルを実行する。
		 */
		class Shell
		extends ExShellCommand
		{
			Shell()
			{
				usage = " <file> [args...]";
				comment = "read command from file";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length < 2) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too few arguments");
				}

				String fileSeparator = System.getProperty("file.separator");
				String ozHome = System.getProperty("oz.home");
				File file = new File(ozHome,args[1].replace('.',fileSeparator.charAt(0)));
				if (!file.exists()) {
					shell.stderr.println(args[0]+": "+file+" is not found.");
				} else if (!file.isDirectory()) {
					FileReader in = new FileReader(file);
					String[] newArgs;
					if (2 < args.length) {
						newArgs = new String[args.length-1];
						System.arraycopy(args, 1, newArgs, 0, args.length-1);
					} else {
						newArgs = new String[1];
						newArgs[0] = args[1];
					}
					new ExShell(shell,in).action(null,newArgs);
				} else {
					shell.stderr.println(args[0]+": "+file+" is not file.");
				}

				return null;
			}
		}

		/**
		 * 引数を印字する。
		 */
		class Echo
		extends ExShellCommand
		{
			Echo()
			{
				usage = " [args...]";
				comment = "print arguments";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				int n = args.length;
				if (1 < n) {
					shell.stdout.print(args[1]);
					for (int i = 2; i < n; i ++) {
						shell.stdout.print(" "+args[i]);
					}
				}
				shell.stdout.println();
				return null;
			}
		}

		/**
		 * シェルの実行を一時停止する。
		 */
		class Sleep
		extends ExShellCommand
		{
			Sleep()
			{
				usage = " <milli seconds>";
				comment = "shell to sleep";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length != 2) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too few or many arguments");
				}

				long millis = Long.parseLong(args[1]);
				Thread.sleep(millis);

				return null;
			}
		}

		/**
		 * メソッドトレースをon/offする。
		 */
		class Trace
		extends ExShellCommand
		{
			Trace()
			{
				usage = " true|false";
				comment = "trace on/off";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length != 2) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too many arguments");
				}

				boolean flag;
				String arg = args[args.length-1].toLowerCase();
				if (arg.equals("true")||arg.equals("on")) flag = true;
				else if (arg.equals("false")||arg.equals("off")) flag = false;
				else throw new IllegalArgumentException("Invalid arguments");

				Runtime.getRuntime().traceMethodCalls(flag);

				return null;
			}
		}

		/**
		 * コマンド一覧を印字する。
		 */
		class Help
		extends ExShellCommand
		{
			Help()
			{
				usage = " ";
				comment = "print commands";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length > 1) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too many arguments");
				}

				Enumeration keys = commands.keys();
				while (keys.hasMoreElements()) {
					String key = (String)keys.nextElement();
					ExShellCommand cmd = (ExShellCommand)commands.get(key);
					if (cmd != null) {
						String str = key+cmd.usage;
						if (str.length()< 32) {
							StringBuffer buffer = new StringBuffer(str);
							for (int i = 32-buffer.length(); 0 < i; i --) buffer.append(' ');
							str = buffer.toString();
						}
						shell.stdout.println(str+";# "+cmd.comment);
					}
				}
				return null;
			}
		}

		ExShell.append("shell", new Shell());
		ExShell.append("echo", new Echo());
		ExShell.append("sleep", new Sleep());
		ExShell.append("trace", new Trace());
		ExShell.append("help", new Help());
	}
}
