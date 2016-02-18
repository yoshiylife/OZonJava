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
 * $Id: Executor.java,v 2.3 1997/12/04 04:55:20 yoshi Exp $
 *
 * 注意: このファイルは vi で、hardtab=8, tabstop=4 として編集されている
 */

package	JP.go.ipa.oz.system;

import	java.io.BufferedInputStream;
import	java.io.BufferedOutputStream;
import	java.io.ByteArrayInputStream;
import	java.io.ByteArrayOutputStream;
import	java.io.DataInputStream;
import	java.io.DataOutputStream;
import	java.io.File;
import	java.io.FileDescriptor;
import	java.io.FileInputStream;
import	java.io.FileOutputStream;
import	java.io.InputStream;
import	java.io.InputStreamReader; // Now, replace with ExInputStreamReader for the problem
import	java.io.OutputStream;
import	java.io.PrintStream;
import	java.io.PrintWriter;
import	java.io.Reader;
import	java.io.StringBufferInputStream;
import	java.io.StringReader;
import	java.io.StringReader;
import	java.lang.Runtime;
import	java.net.InetAddress;
import	java.net.ServerSocket;
import	java.net.Socket;
import	java.util.Date;
import	java.util.Properties;

/**
 * エグゼキュータ本体である。JavaVM によって最初にこのクラスのメソッド main() が
 * 起動される。エグゼキュータ本体は、スレッドグループを構成する必要があること、
 * エグゼキュータ自身の処理のためにプロセスを生成しなければならないこと
 * などの理由からクラス OzCell を継承し、１つのセルとして扱う。
 * エグゼキュータ本体へのアクセスは、通常のグローバルアクセスではなく、
 * プロセスの生成と実行の機能を使った特別な方法で行われるので、
 * 引数や戻り値のコピーは行われない。また、ユーザは、エグゼキュータ本体
 * であるグローバルオブジェクトの存在をプログラム上は認識できない。
 *
 * <DL><DT>
 * 【注意】<DD>
 * 現在、少なくともSolaris(SPARC)版では標準入力からの入力待ちになると
 * JavaVM のスケジューラが停止する。従って、標準入力からの入力待ちになる
 * 状態では、他のスレッドは実行されない。
 * </DL>
 *
 * @see	ExCell
 * @see OzCell
 *
 * @version		$Revision: 2.3 $, $Date: 1997/12/04 04:55:20 $
 * @author		Yasumitsu Yoshida
 */
final
class Executor
extends OzCell
implements Runnable
{
	/**
	 * エグゼキュータ実装のデバッグ用
	 */
	static final String CN = "Executor";

	static final String IPA = "JP.go.ipa.";
	static final String IPAoz = IPA+"oz.";
	static final String IPAozSystem = IPAoz+"system.";
	static final String IPAozUser = IPAoz+"user.";

	/**
	 * ランタイムサービス番号
	 */
	// クラス Executor で実装されているもの
	static final int BOOT		= 0x00;	// エグゼキュータの起動
	static final int EXIT		= 0x01; // エグゼキュータの終了
	static final int SYSLOG		= 0x02;	// エグゼキュータのログへの出力
	static final int HALT		= 0x03; // エグゼキュータの停止（終了ではない）
	static final int ECHO		= 0x0f; // エコーバック（実験）

	// クラス ExCellManager で実装されているもの
	static final int CREATE		= 0x10;	// セル（グローバルオブジェクト）の生成
	static final int GO			= 0x11;	// セル（グローバルオブジェクト）の活性化
	static final int STOP		= 0x12;	// セル（グローバルオブジェクト）の不活性化
	static final int REMOVE		= 0x13;	// セル（グローバルオブジェクト）の削除
	static final int FLUSH		= 0x14;	// セル（グローバルオブジェクト）のイメージの保存
	static final int QUIT		= 0x15;	// セル（グローバルオブジェクト）の非活性化

	// クラス ExClassLoader で実装されているもの
	static final int LOADCLASS	= 0x20; // クラスのロード
	static final int LOADPACKAGE	= 0x21; // アーカイブの配送

	// クラス ExAddressResolver で実装されているもの
	static final int RESOLVE	= 0x30; // 異なるOZホームの通信アドレス解決

	/**
	 * コマンドの実行時に例外が発生した時、直ちにエグゼキュータを終了するというフラグである。
	 * （未実装）
	 */
	static boolean quitOnException = false;

	/**
	 * 直ちにエグゼキュータを終了する場合、グローバルオブジェクトの不活性化等の通常の処理を
	 * 行わないというフラグである。
	 * （未実装）
	 */
	static boolean exitImmediately = false;

	/**
	 * 実験のため
	 */
	static boolean remote = false;

	/**
	 * 冗長表示
	 * （未実装）
	 */
	static boolean verbose = false;

	/**
	 * デバッグ
	 */
	static boolean debug = false;

	/**
	 * 標準入力
	 */
	static InputStream in;
	static InputStream stdin;

	/**
	 * 標準出力
	 */
	static PrintStream out;
	static PrintStream stdout;

	/**
	 * 標準エラー出力
	 */
	static PrintStream err;
	static PrintStream stderr;

	/**
	 * ログ出力
	 */
	static PrintStream stdlog;

	/**
	 * 通信システム
	 */
	static ExCommManager commManager;

	/**
	 * クラスローダ
	 */
	static ExClassLoader classLoader;

	/**
	 * セキュリティマネージャ
	 */
	static ExSecurityManager securityManager;

	/**
	 * 暗号化通信
	 */
//	static ExCipherTable cipherTable;

	/**
	 * エグゼキュータに固有な文字列を作成するために
	 * ホスト名とポート番号を使う。
	 */
	static private ServerSocket serverport;
	static private InetAddress localhost;
	static private String hostName;
	static private String portName;

	static {
	    /*
	     * プロセス固有のファイル名を生成するために
	     * サーバソケットを開いてポート番号とホスト名を獲得する。
	     * このサーバソケットは、将来、エグゼキュータ間の
	     * メンテナンスに使用されるかもしれない。
	     */
	    try {
		serverport = new ServerSocket(0,5);
		localhost = InetAddress.getLocalHost();
		hostName = localhost.getHostName();
		if (hostName == null) hostName = localhost.getHostAddress();
		StringBuffer buffer = new StringBuffer();
		buffer.append(serverport.getLocalPort());
		buffer.reverse();
		for (int i = buffer.length(); i < 5; i ++) {
			buffer.append('0');
		}
		buffer.reverse();
		portName = buffer.toString();
	    } catch(Exception e) {
		e.printStackTrace(System.err);
		System.exit(1);
	    }
	}

	/**
	 * エグゼキュータに固有な文字列を返す。
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * エグゼキュータの動作を前提としないクラスからも、
	 * 呼び出される場合がある。
	 * </DL>
	 *
	 * @return		エグゼキュータに固有な文字列
	 */
	static
	String getID()
	{
		return hostName+"."+portName;
	}

	/**
	 * public のメソッド main が２度呼び出されないようにするためのフラグである。
	 */
	static private boolean started = false;

	/**
	 * コマンド行の入力を促すプロンプトを出力する。
	 */
	static private boolean printPrompt = true;

	/**
	 * エグゼキュータのシステムを稼働させるために必要なスレッドが
	 * 属するスレッドグループである。特別なセルであるため、
	 * 通信アドレスのテーブルやグローバルオブジェクトのテーブルに
	 * 登録されない。
	 */
	static private ExCell exCell;

	/**
	 * プログラムの作成を容易にするためと、グローバルオブジェクト
	 * として扱うためにインスタンスを作成する。
	 * エグゼキュータ本体である。
	 */
	static private Executor executor;

	/**
	 * 起動時に指定された最初に活性化する
	 * セルのGODを保持する。
	 */
	static private ExGOD initCellGOD = null;

	/**
	 * 通常の手続きによりセルを非活性化の状態にする試みから、
	 * 強制的にセルを非活性化の状態にする処理を行うまでの
	 * 待ち時間（単位はミリ秒、デフォルトは60秒）である。 
	 */
	static private long userGracePeriod = 60000;

	/**
	 * システムが強制的にセルを非活性化の状態に
	 * する処理の過程で、最終的な処理を開始するまでの
	 * 待ち時間（単位はミリ秒、デフォルトは10秒）である。 
	 */
	static private long systemGracePeriod = 10000;

	/**
	 * OZのセキュリティマネージャを設定しないというフラグである。
	 * （実験のため）
	 */
	static private boolean noSecurity = false;

	/**
	 * エグゼキュータを起動するためのメソッドである。
	 * JavaVM によって最初にこのクラスのメソッド main() が起動される。
	 *
	 * ・static 領域の設定とjavaVMの起動時に指定された文字列
	 * 　（オプション等）の解析を行う。
	 * ・エグゼキュータ本体のセル（グローバルオブジェクト）を生成する。
	 * ・そのグローバルオブジェクトを活性化する。
	 *
	 * @param	args	javaVMの起動時に指定された文字列（クラス String）
	 *					の配列が渡される。
	 * @exception	Exception
	 *					エグゼキュータの起動処理中に予期しない例外が発生した。
	 */
	public static
	void main(String args[])
	throws Exception
	{
		/*
		 * クラス Executor は public ではないが、
		 * メソッド main は public メソッドなので
		 * 念のため２重起動されないようにする。
		 */
		if (started) {
			error(CN,"main","*CAUTION* Illegal called");
			return;
		} else started = true;

		/*
		 * プロパティの読み込み
		 */
		String ozHome = System.getProperty("oz.home");
		if (ozHome == null) {
			System.err.println("Not found property 'oz.home'");
			System.exit(2);
		} else {
			File libdir = new File(ozHome,"lib");
			File file = new File(libdir,"oz.properties");
			try {
				loadProperties(file);
			} catch (Exception e) {
				System.err.println("Can't load properties from "+file);
				System.exit(3);
			}
		}

		/*
		 * GCで、標準入力、標準出力、標準エラー出力が
		 * クローズされないように参照を保存し、以後の
		 * クラス System の in, out, err の変更に備える。
		 */
		in = System.in;
		out = new ExPrintStream(System.out);
		err = new ExPrintStream(System.err);

		/*
		 * ログの出力先となるファイルを開き、
		 * そのファイルに起動メッセージを出力する。
		 */
		File log = ozFile("logs",getID(),".log");
		out.println("Logging file is "+log);
		stdlog = new ExSyslogStream(new ExPrintStream(new FileOutputStream(log)));
		stdlog.print("OZ Executor start");
		stdlog.println(" on Java "+System.getProperty("java.version"));

		/*
		 * 標準入力から読み込まれると、JavaVMのスケジューラが停止するので
		 * System.in を使えないようにする。
		 */
		System.setIn(null);

		/*
		 * システムの標準出力、標準エラー出力をログ出力に変更する。
		 */
		System.setOut(stdlog);
		System.setErr(stdlog);

		/*
		 * エグゼキュータの標準入力、標準出力、標準エラー出力を設定する。
		 */
		stdin = null; // オプションの解釈時に設定される。
		stdout = out;
		stderr = err;

		/*
		 * コマンドラインに指定された引数の解析
		 */

		// 少なくともコマンド名が指定されなかればならない。
		int argc = (args == null) ? 0 : args.length;
		if (argc < 1) usage(1);

		// 一番目の引数から文字 - で始まるオプション（引数を含む）の解釈を行う。
		int i;
		for (i = 0; i < argc; i ++) {
			String token = args[i];
			if (!token.startsWith("-")) {
				// 文字 - で始まらないのでオプションは終わりである。
				break;
			} else if (token.equals("-i")) {
				// 会話型動作の指定
				// 実はこの動作はデフォルトなのでこの部分では何もしない。
			} else if (token.equals("-s")) {
				// プロンプトの出力を行わない指定
				printPrompt = printPrompt ? false : true;
			} else if (token.equals("-q")) {
				// コマンド実行中に例外が発生したら通常の終了手続きを開始する。
				quitOnException = true;
			} else if (token.equals("-e")) {
				// エグゼキュータを終了する時に、通常の終了手続きを取らずに終了する。
				exitImmediately = true;
			} else if (token.equals("-f")) {
				// 形式：-f <file name>
				// <filename>からコマンド行を読み込む。
				i ++;
				if (argc <= i) {
					err.println("option "+token+": need <file name>.");
					error(CN,"main","option "+token+" need <file name>.");
					usage(1);
				}
				if (stdin != null) {
					err.println("Ignore option: "+token+" "+args[i]);
					error(CN,"main","Already specified input to read command.");
					error(CN,"main","Ignore option "+token+" "+args[i]);
				} else {
					File file = new File(args[i]);
					try {
						if (!file.isDirectory()) {
							stdin = new FileInputStream(file);
						} else {
							err.println(file.toString()+" is directory.");
							error(CN,"main",file.toString()+" is directory.");
							error(CN,"main","in progress option "+token);
							System.exit(8);
						}
					} catch (Exception e) {
						err.println("Not Found file: "+file);
						error(CN,"main","Not Found file "+file);
						error(CN,"main","in progress option "+token,e);
						System.exit(9);
					}
				}
				printPrompt = false;
			} else if (token.equals("-o")) {
				i ++;
				if (argc <= i) {
					err.println("option "+token+": need <god>.");
					error(CN,"main","option "+token+" need <god>.");
					usage(1);
				}
				try {
					initCellGOD = new ExGOD(args[i]);
					if (!initCellGOD.exists() || !initCellGOD.isDirectory()) {
						err.println("Not found GOD: "+initCellGOD);
						error(CN,"main","Not found GOD "+initCellGOD);
						error(CN,"main","in progress option "+token);
						System.exit(10);
					}
				} catch (Exception e) {
					err.println("Invalid god: "+args[i]);
					error(CN,"main","Invalid god "+args[i]);
					error(CN,"main","in progress option "+token,e);
					System.exit(11);
				}
				printPrompt = false;
			} else if (token.equals("-g")) {
				// デバッグ用フラグを立てる。
				debug = true;
			} else if (token.equals("-v")) {
				// 冗長表示用フラグを立てる。
				verbose = true;
			} else if (token.equals("-h")) {
				// JavaVMから直にこのメソッドを起動する時の使用方法を表示し、終了状態０で終了する。
				usage(0);
			} else if (token.equals("-t")) {
				printPrompt = true;
				remote = true;
			} else if (token.equals("-n")) {
				noSecurity = true;
				stdlog.println("***** NO SECURITY MANAGER *****");
			} else {
				// わけが分からないオプションは無視する。
				err.println("Ignore option: "+token);
				error(CN,"main","Ignore option "+token);
			}
		}

		// エグゼキュータ本体に引き渡す引数（位置パラメータ）を設定する。
		// 少なくともコマンド名に対応する引数（$0 に対応）が必要である。
		if (argc <= i) usage(1); // 引数はもうないので、終了状態１で終了する。
		String[] arguments = new String[argc-i];
		for (int j = 0; i < argc; i ++, j ++) {
			arguments[j] = args[i];
			// Executor.debug(CN,"main","$"+j+"="+args[i]);
		}

		/*
		 * エグゼキュータのパラメータの設定
		 */
		String param;
		param = System.getProperty("oz.user.grace.period");
		if (param != null) {
			try {
				userGracePeriod = Long.parseLong(param);
			} catch (Exception e) {
				error(CN,"main","Warning property oz.user.grace.period",e);
			}
		}
		param = System.getProperty("oz.system.grace.period");
		if (param != null) {
			try {
				systemGracePeriod = Long.parseLong(param);
			} catch (Exception e) {
				error(CN,"main","Warning property oz.system.grace.period",e);
			}
		}

		/*
		 * クラスローダを生成する。
		 */
		classLoader = new ExClassLoader();

		/*
		 * セキュリティマネージャを設定する。
		 */
		if (! noSecurity) {
			String value = System.getProperty("oz.security.executionConfirmer");
			if (value == null || value.length() == 0) {
			    securityManager = new ExSecurityManager();
			} else {
			    securityManager = new ExSecurityManager(value);
			}
			System.setSecurityManager(securityManager);
		}

		/*
		 * 通信系を起動する。
		 */
		try {
	  		commManager = new ExCommManager();
		} catch (Exception e) {
			error(CN,"main","in progress for communication system",e);
			System.exit(4);
		}

		/*
		 * 暗号化テーブルを生成する。
		 */
/*
		try {
	  		cipherTable = new ExCipherTable();
		} catch (Exception e) {
			error(CN,"main","in progress for Cipher system",e);
			System.exit(5);
		}
*/

		/*
		 * シェルに予めコマンドを登録する必要のあるクラスで、
		 * この時点で未ロードのクラスについて、そのクラスを
		 * 参照することにより、シェルにコマンドを登録させる。
		 */
		Executor.debug(CN, "main", "load "+ExGOD.class.getName());
		Executor.debug(CN, "main", "load "+ExCellManager.class.getName());

		/*
		 * エグゼキュータ本体であるグローバルオブジェクトと
		 * エグゼキュータの処理を行うスレッドが属するセルを
		 * 活性化するのための特別な処理を行う。
		 */
		try {
			Class c = Executor.loadClass(IPAozSystem+"Executor");
			executor = (Executor)c.newInstance();
			exCell = new ExCell(executor,"Executor");
			Object[] argv = new Object[2];
			argv[0] = new Integer(BOOT);
			argv[1] = arguments;
			String pid = ExProcessManager.fork(exCell, executor, argv);
			OzProcess p = new OzProcess(pid);
			p.join();
		} catch (Exception e) {
			error(CN,"main","in activating Executor",e);
			if (e instanceof ExProcessException) {
				Exception ex = ((ExProcessException)e).getException();
				error(CN,"main","boot process",ex);
			}
			System.exit(6);
		}
		/*
		 * 通常、ブートプロセスが終了することはない。
		 */
		error(CN,"main","Warning: BOOT PROCESS EXITED");
	}

	/**
	 * Usageを表示して、JavaVmを終了する。
	 *
	 * @param	status	終了状態。一般に、０は正常を意味する。
	 */
	static
	void usage(int status)
	{
		err.println("Usage: java [<java options>...] -Doz.home=<oz home directory>");
		err.println("            "+IPAozSystem+"Executor [<executor options>...]");
		err.println("            <command name> [<position parameters>...]");
		err.println("");
		err.println("executor options:");
		err.println("-i          read commands from stdin(default)");
		err.println("-s          no prompt");
		err.println("-f <file>   read commands from <file>");
		err.println("-g          all debug message on");
		err.println("-h          print this message");
		err.println("-o <god>    activate cell with <god>");
		err.println("-t          remote console(for test)");
		err.println("-n          no security(for test)");
		System.exit(status);
	}

	/**
	 * プロパティをロードする。
	 */
	static private
	void loadProperties(File file)
	throws Exception
	{
		FileInputStream in = new FileInputStream(file);
		Properties props = new Properties(System.getProperties());
		props.load(in);
		in.close();
		System.setProperties(props);
	}

	/**
	 * 既にファイルが存在する場合は、バックアップファイルを作成する。
	 *
	 * @param	dirName		ファイルを作成するディレクトリ名
	 * @param	fileName	拡張子を除くファイル名
	 * @param	suffix		拡張子名
	 * @return				ファイルを示すオブジェクト
	 * @exception		ExException
	 *						エグゼキュータ内部で例外が発生した。
	 */
	static
	File ozFile(String dirName, String fileName, String suffix)
	throws ExException
	{
		File dir = new File(System.getProperty("oz.home"),dirName);
		File file = new File(dir,fileName+suffix);
		if (dir.exists()) {
			if (!dir.isDirectory()) {
				ExException e = new ExException(dir.toString()+" is not directory.");
				Executor.error(CN,"ozFile","(dirName="+dirName+",fileName="+fileName+",suffix="+suffix+")",e);
				throw e;
			}
		} else {
			if (!dir.mkdirs()) {
				ExException e = new ExException("Can't make directory "+dir);
				Executor.error(CN,"ozFile","(dirName="+dirName+",fileName="+fileName+",suffix="+suffix+")",e);
				throw e;
			}
		}
		if (file.exists()) {
			File backup = new File(dir,fileName+".bak");
			if (backup.exists()) backup.delete();
			file.renameTo(backup);
			file = new File(dir,fileName+suffix);
		}
		return file;
	}

	/**
	 * 形式化されたメッセージ出力を行う。
	 * 一般形式：header className#methodName: message
	 *					stack trace...
	 * message が ( で始まる場合は、: は出力されない。
	 * message が null の場合は、()が出力される。
	 *
	 * @param	out			メッセージの出力先
	 * @param	header		メッセージを出力するに先立って出力する文字列。
	 * @param	className	メッセージを出力しようとしているクラス名
	 * @param	methodName	メッセージを出力しようとしているメソッド名
	 * @param	message		出力するメッセージの文字列
	 * @param	exception	メッセージを出力する原因になった例外
	 */
	private static
	void message(PrintStream out, String header, String className, String methodName, String message, Throwable exception)
	{
		try {
			if (className == null) {
				out.println((header==null)?message:header+message);
			} else {
				StringBuffer buffer = new StringBuffer();
				if (header != null) buffer.append(header);
				buffer.append(className);
				if (methodName == null) {
					buffer.append(": ");
				} else {
					buffer.append("#"+methodName);
					if (message == null) {
						buffer.append("()");
					} else if (!message.startsWith("(")) {
						buffer.append(": ");
					}
				}
				if (message != null) buffer.append(message);
				out.println(buffer);
			}
			if (exception != null) {
				exception.printStackTrace(out);
			}
		} catch (Throwable e) {
			e.printStackTrace(stderr);
		}
	}

	/**
	 * 形式化されたメッセージ出力を行うための、省略形式のメソッドである。
	 * 詳細は省略する。
	 *
	 * @see	Executor#message(java.io.PrintStream,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.Throwable);
	 */
	static
	void message(String className, String methodName, String message, Throwable exception)
	{
		Executor.message(stdout, null, className, methodName, message, exception);
	}

	/**
	 * 形式化されたメッセージ出力を行うための、省略形式のメソッドである。
	 * 詳細は省略する。
	 *
	 * @see	Executor#message(java.io.PrintStream,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.Throwable);
	 */
	static
	void message(String className, String methodName, Throwable exception)
	{
		Executor.message(className, methodName, null, exception);
	}

	/**
	 * 形式化されたメッセージ出力を行うための、省略形式のメソッドである。
	 * 詳細は省略する。
	 *
	 * @see	Executor#message(java.io.PrintStream,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.Throwable);
	 */
	static
	void message(String className, String methodName, String message)
	{
		Executor.message(className, methodName, message, null);
	}

	/**
	 * 形式化されたメッセージ出力を行うための、省略形式のメソッドである。
	 * 詳細は省略する。
	 *
	 * @see	Executor#message(java.io.PrintStream,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.Throwable);
	 */
	static
	void message(String className, String message)
	{
		Executor.message(className, null, message, null);
	}

	/**
	 * 形式化されたメッセージ出力を行うための、省略形式のメソッドである。
	 * 詳細は省略する。
	 *
	 * @see	Executor#message(java.io.PrintStream,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.Throwable);
	 */
	static
	void message(String message)
	{
		Executor.message(null, null, message, null);
	}

	/**
	 * 形式化されたデバッグ用メッセージ出力を行う。
	 * 詳細は省略する。
	 *
	 * @see	Executor#message(java.io.PrintStream,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.Throwable);
	 */
	static
	void debug(String className, String methodName, String message, Throwable exception)
	{
		if (!debug) return;
		Executor.message(stdout, null, className, methodName, message, exception);
	}

	/**
	 * 形式化されたデバッグ用メッセージ出力を行うための、省略形式のメソッドである。
	 * 詳細は省略する。
	 *
	 * @see	Executor#debug(java.lang.String,java.lang.String,java.lang.String,java.lang.Throwable);
	 */
	static
	void debug(String className, String methodName, Throwable exception)
	{
		Executor.debug(className, methodName, null, exception);
	}

	/**
	 * 形式化されたデバッグ用メッセージ出力を行うための、省略形式のメソッドである。
	 * 詳細は省略する。
	 *
	 * @see	Executor#debug(java.lang.String,java.lang.String,java.lang.String,java.lang.Throwable);
	 */
	static
	void debug(String className, String methodName, String message)
	{
		debug(className, methodName, message, null);
	}

	/**
	 * 形式化されたデバッグ用メッセージ出力を行うための、省略形式のメソッドである。
	 * 詳細は省略する。
	 *
	 * @see	Executor#debug(java.lang.String,java.lang.String,java.lang.String,java.lang.Throwable);
	 */
	static
	void debug(String className, String message)
	{
		debug(className, null, message, null);
	}

	/**
	 * 形式化されたデバッグ用メッセージ出力を行うための、省略形式のメソッドである。
	 * 詳細は省略する。
	 *
	 * @see	Executor#debug(java.lang.String,java.lang.String,java.lang.String,java.lang.Throwable);
	 */
	static
	void debug(String message)
	{
		debug(null, null, message, null);
	}

	/**
	 * 形式化されたエラーメッセージ出力を行う。
	 * 詳細は省略する。
	 *
	 * @see	Executor#message(java.io.PrintStream,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.Throwable);
	 */
	static
	void error(String className, String methodName, String message, Throwable exception)
	{
		// Executor.message(stderr, null, className, methodName, message, exception);
		synchronized (stdlog) {
			Executor.message(stdlog, null, className, methodName, message, exception);
		}
	}

	/**
	 * 形式化されたエラーメッセージ出力を行うための、省略形式のメソッドである。
	 * 詳細は省略する。
	 *
	 * @see	Executor#error(java.lang.String,java.lang.String,java.lang.String,java.lang.Throwable);
	 */
	static
	void error(String className, String methodName, Throwable exception)
	{
		error(className, methodName, null, exception);
	}

	/**
	 * 形式化されたエラーメッセージ出力を行うための、省略形式のメソッドである。
	 * 詳細は省略する。
	 *
	 * @see	Executor#error(java.lang.String,java.lang.String,java.lang.String,java.lang.Throwable);
	 */
	static
	void error(String className, String methodName, String message)
	{
		error(className, methodName, message, null);
	}

	/**
	 * 形式化されたエラーメッセージ出力を行うための、省略形式のメソッドである。
	 * 詳細は省略する。
	 *
	 * @see	Executor#error(java.lang.String,java.lang.String,java.lang.String,java.lang.Throwable);
	 */
	static
	void error(String className, String message)
	{
		error(className, null, message, null);
	}

	/**
	 * 形式化されたエラーメッセージ出力を行うための、省略形式のメソッドである。
	 * 詳細は省略する。
	 *
	 * @see	Executor#error(java.lang.String,java.lang.String,java.lang.String,java.lang.Throwable);
	 */
	static
	void error(String message)
	{
		error(null, null, message, null);
	}

	/**
	 * 形式化されたメッセージをログに出力する。
	 * 詳細は省略する。
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * 初期化時（クラスのロード等）は、エグゼキュータ自身が
	 * 起動されていないので、メッセージをログに出力するための
	 * スレッドを生成できない。
	 * </DL>
	 *
	 * @see	Executor#message(PrintStream, String, String, String, String, Throwable)
	 */
	static
	void syslog(String className, String methodName, String message, Throwable exception)
	{
		if (exCell == null) {
			synchronized (stdlog) {
				message(stdlog, null, className, methodName, message, exception);
			}
		} else {
			Object[] params = new Object[5];
			params[0] = new Integer(Executor.SYSLOG);
			params[1] = className;
			params[2] = methodName;
			params[3] = message;
			params[4] = exception;
			try {
				syscall(params).join();
			} catch (ExProcessException e) {
				Executor.error(CN,"syslog","From "+className, e.getException());
			} catch (Exception e) {
				Executor.error(CN,"syslog","From "+className, e);
			}
		}
	}

	/**
	 * 形式化されたメッセージをログに出力するための、省略形式のメソッドである。
	 * 詳細は省略する。
	 */
	static
	void syslog(String className, String methodName, Throwable exception)
	{
		syslog(className, methodName, null, exception);
	}

	/**
	 * 形式化されたメッセージをログに出力するための、省略形式のメソッドである。
	 * 詳細は省略する。
	 */
	static
	void syslog(String className, String methodName, String message)
	{
		syslog(className, methodName, message, null);
	}

	/**
	 * 形式化されたメッセージをログに出力するための、省略形式のメソッドである。
	 * 詳細は省略する。
	 */
	static
	void syslog(String className, String message)
	{
		syslog(className, null, message, null);
	}

	/**
	 * オブジェクトをその参照も含めて複製する。緑プロセスのみが
	 * 緑オブジェクトを緑オブジェクトとして複製することが可能である。
	 *
	 * @param	srcObj	複製するオブジェクト
	 * @param	secure	緑プロセスの時に意味があり、true ならば、
	 *					緑オブジェクトを赤オブジェクトとして複製する。
	 * @exception	ExException
	 *					エグゼキュータ内部で例外が発生した。
	 */
	static
	Object duplicate(Object srcObj,boolean secure)
	throws ExException
	{
		Object newObj = null;
		boolean action = true;

		// Executor.debug(CN,"duplicate","("+srcObj+")");
		if (srcObj == null) return newObj;
		ByteArrayOutputStream byteOutputs = new ByteArrayOutputStream(128);
		ExObjectInputStream objectInputs;
		try {
			ExObjectOutputStream objectOutputs = new ExObjectOutputStream(byteOutputs);
			objectOutputs.writeObject(srcObj);
			// Executor.debug(CN,"duplicate","buffer length = "+byteOutputs.toByteArray().length);
			ByteArrayInputStream byteInputs = new ByteArrayInputStream(byteOutputs.toByteArray());
			objectInputs = new ExObjectInputStream(byteInputs);
		} catch (Exception e) {
			/*
			 * 次の例外が想定されるが、処理が同じ記述になるため Exception としてまとめている。
			 * IOException, StreamCorruptedException
			 */
			Executor.error(CN,"duplicate(","srcObj="+srcObj+",secure="+secure,e);
			throw new ExException(e.getClass().getName());
		}
		if (secure) {
			Thread current = Thread.currentThread();
			if (current instanceof ExThread) {
				ExThread t = (ExThread)current;
				if (t.color == ExThread.GREEN) {
					try {
						t.color = ExThread.RED;
						action = false;
						newObj = objectInputs.readObject();
					} catch (Exception e) {
						/*
						 * 次の例外が想定されるが、処理が同じ記述になるため Exception としてまとめている。
						 * OptionalDataException IOException ClassNotFoundException
						 */
						Executor.error(CN,"duplicate(","srcObj="+srcObj+",secure="+secure,e);
						throw new ExException(e.getClass().getName());
					} finally {
						t.color = ExThread.GREEN;
					}
				}
			}
		}
		try {
			if (action) newObj = objectInputs.readObject();
			// Executor.debug(CN,"duplicate","() = "+newObj);
		} catch (Exception e) {
			/*
			 * 次の例外が想定されるが、処理が同じ記述になるため Exception としてまとめている。
			 * OptionalDataException ClassNotFoundException
			 */
			Executor.error(CN,"duplicate(","srcObj="+srcObj+",secure="+secure,e);
			throw new ExException(e.getClass().getName());
		}

		return (Object)newObj;
	}

	/**
	 * ランタイムサービスを処理するためのプロセスを生成する。
	 *
	 * @param	params	ランタイムサービスのパラメータ
	 */
	static
	OzProcess syscall(Object[] params)
	{
		String pid = ExProcessManager.fork(exCell,executor,params);
		return new OzProcess(pid);
	}

	/**
	 * クラスのロードを高速に行うために
	 * クラスローダを直接呼び出す。
	 *
	 * @param	codePath	クラスのfull qualified class name
	 * @return				classオブジェクト
	 */
	static
	Class loadClass(String codePath)
	throws ClassNotFoundException
	{
		Executor.debug(CN,"loadClass","("+codePath+")");
		Class c = null;
		try {
			c = classLoader.loadClass(codePath);
		} catch (ClassNotFoundException e) {
			Executor.debug(CN,"loadClass","codePath="+codePath,e);
			throw e;
		}
		return c;
	}


/*
 * これ以降はインスタンスとしての動作を記述する。
 */



	/**
	 * エグゼキュータは特別なグローバルオブジェクトであり、
	 * プロキシはない。
	 */
	Executor()
	throws Exception
	{
		super(""); // 例外を発生させないために、空文字列を指定。
	}

	/**
	 * OZの最初のプロセスとして起動されるメソッドである。
	 * エグゼキュータの起動は、このメソッドの呼出しで完了する。
	 * 通常、このメソッドが終了することはない。
	 *
	 * @param	args	JavaVMを起動した時に指定されたコマンド名と
	 *					位置パラメータの配列を指定する。
	 * @exception	Exception
	 *					例外の発生は、何らかのバグか障害を意味する。
	 *					
	 */
	private
	void boot(String[] args)
	throws Exception
	{
		/*
		 * 標準入力を決定する。
		 */
		if (remote) {
			 // リモートのコンソールを作成する。但し、実験のための実装である。
			out.println("Wait to accept for "+getID());
			Socket socket = serverport.accept();
			message(CN,"Remote console is "+socket);
			syslog(CN,"Remote console is "+socket);
			socket.setTcpNoDelay(true);
			stdin = new BufferedInputStream(socket.getInputStream());
			stdout = new ExPrintStream(socket.getOutputStream());
			stderr = new ExPrintStream(socket.getOutputStream());
		} else if (stdin == null) {
			// デフォルト動作の設定を行う。
			if (stdin == null) {
				// コマンドの読み込み先の指示がないのでデフォルト動作の設定をする。
				stdin = Executor.in;
			}
		}

		/*
		 * エグゼキュータが動作していることを確認するための
		 * エコーバックである。但し、実験のための実装である。
		 */
		if (! remote) {
			Object[] params = new Object[2];
			params[0] = new Integer(Executor.ECHO);
			params[1] = null;
			new OzProcess(this, this, params);
		}

		/*
		 * エグゼキュータのシェルを起動する。
		 */
		Reader in;
		if (initCellGOD == null) in = new ExInputStreamReader(stdin);
		else in = new StringReader("go "+initCellGOD.getName()+" $0 $*;"+"watch "+initCellGOD.getName()+";");
		ExShell shell = new ExShell(in, new PrintWriter(stdout,true), new PrintWriter(stderr,true));
		if (printPrompt) {
			shell.action(CN+">", args);
		} else {
			shell.action(args);
		}
		exit(0);
	}

	/**
	 * 指定された時間が経過した後、強制的にエグゼキュータを停止させ、
	 * エグゼキュータの終了が行える状態にする。
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * 次回の起動（セルの活性化）に支障がないように、
	 * 最低限の処理を行うように最大限の動作するが、
	 * エグゼキュータの終了は行わない。
	 * <DT>
	 * 【メモ】<DD>
	 * 例外をthrowしないこと。
	 * </DL>
	 *
	 * @param	gracePeriod		処理を開始するまでの待ち時間（ミリ秒）
	 */
	private
	void halt(long gracePeriod)
	{
		Executor.debug(CN,"halt","("+gracePeriod+")"); // for debug

		/*
		 * 無条件に全てのセルを非活性化の状態にする。
		 */
		try {
			if (gracePeriod != 0) Thread.sleep(gracePeriod);
			ExCellManager.halt(systemGracePeriod);
		} catch (Exception e) {
			error(CN,"halt","halt ExCellManager in progress",e);
		}

		return;
	}

	/**
	 * エグゼキュータを終了する。
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * 終了処理を開始したら、例外が発生しても
	 * 終了処理を停止してならない。
	 * <DT>
	 * 【注意】<DD>
	 * ブートアップ後のエグゼキュータは、必ずこのメソッドで
	 * 終了させなければならない。
	 * <DT>
	 * 【メモ】<DD>
	 * 例外をthrowしないこと。
	 * </DL>
	 *
	 * @param	status	終了ステータス
	 */
	private
	void exit(int status)
	{
		Executor.debug(CN,"exit","("+status+")"); // for debug

		/*
		 * セル管理系を停止する。
		 */
		stdlog.println("***** SHUTDOWN: CellManager *****");
		try {
			ExCellManager.shutdown(userGracePeriod);
		} catch (Exception e) {
			error(CN,"exit","shutdown cell manager in progress",e);
		}

		/*
		 * 通信管理系を停止する。
		 */
		nice(2);
		stdlog.println("***** SHUTDOWN: CommManager *****");
		try {
			commManager.shutdown();
		} catch (Exception e) {
			error(CN,"exit","shutdown communication manager in progress",e);
		}

		nice(-2);
		stdlog.println("OZ Executor exit("+status+")");
		System.exit(status);
		return;
	}

	/**
	 * エグゼキュータが動作していることを確認するための
	 * エコーバックである。但し、実験のための実装である。
	 */
	private
	void echo(Socket socket)
	throws Exception
	{
		if (socket == null) {
			while (true) {
				socket = serverport.accept();
				Object[] args = new Object[2];
				args[0] = new Integer(Executor.ECHO);
				args[1] = socket;
				new OzProcess(this, this, args);
			}
		} else {
			InputStream in = new BufferedInputStream(socket.getInputStream());
			OutputStream out = new BufferedOutputStream(socket.getOutputStream());
			try {
				while (true) {
					int data = in.read();
					out.write(data);
				}
			} catch (Exception e) {
			}
		}
	}

	/**
	 * このメソッドを実行しているスレッドの優先順位を下げる。
	 *
	 * @param	decrement	優先順位を下げる度合いの値
	 */
	private
	void nice(int decrement)
	{
		ExThread t = (ExThread)Thread.currentThread();
		t.setPriority(t.getPriority()-decrement);
	}

	/**
	 * エグゼキュータは多くのタイムサービスを
	 * 別スレッドで実行する。
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * このメソッドの実行は最大の優先順位で行う。
	 * メソッド invoke では必要な優先順位の変更が
	 * 行われることを仮定する。
	 * <DT>
	 * 【メモ】<DD>
	 * 必ずしも必要でない部分が含まれているが、
	 * チャネルの実装の仕組みに合わせて
	 * デバッグを容易にするためである。
	 * </DL>
	 */
	public
	void run()
	{
		Object result;
		boolean status;

		try {
			ExThread t = (ExThread)Thread.currentThread();
			t.setPriority(Thread.MAX_PRIORITY);
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
	 * 新しいプロセスを生成して処理を実行するために呼び出される。
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * スレッド優先順位は最大に設定されていることを前提にしている。
	 * <DT>
	 * 【メモ】<DD>
	 * 必ずしも必要でない部分が含まれているが、
	 * チャネルの実装の仕組みに合わせて
	 * デバッグを容易にするためである。
	 * </DL>
	 *
	 * @param	object	メソッドを呼び出す対象
	 * @param	args	メソッドを呼び出す際に必要となる情報
	 * @return			メソッドの実行結果
	 *
	 */
	protected
	Object invoke(Object object,Object[] args)
	throws Exception
	{
		Object result = null;
		int selector = ((Integer)args[0]).intValue();
		Executor.debug(CN,"invoke","RUNTIME SERVICE No."+selector);
		switch (selector) {

		// クラス Executor で実装されているもの
		case BOOT:
			/* Maximum priprity */
			boot((String[])args[1]);
			break;
		case EXIT:
			/* Maximum priprity */
			exit(((Integer)args[1]).intValue());
			break;
		case SYSLOG:
			/* Maximum priprity */
			synchronized (stdlog) {
				message(stdlog, null, (String)args[1], (String)args[2], (String)args[3], (Throwable)args[4]);
			}
			break;
		case HALT:
			nice(1);
			halt(((Long)args[1]).longValue());
			break;
		case ECHO:
			/* Maximum priprity */
			echo((Socket)args[1]);
			break;

		// クラス ExCellManager で実装されているもの
		case CREATE:
			nice(3);
			ExCellManager.create((String)args[1], (ExProxy)args[2]);
			break;
		case GO:
			nice(3);
			ExCellManager.activate((ExProxy)args[1]);
			break;
		case STOP:
			nice(2);
			ExCellManager.deactivate((ExProxy)args[1]);
			break;
		case REMOVE:
			nice(2);
			ExCellManager.remove((ExProxy)args[1]);
			break;
		case FLUSH:
			/* Maximum priprity */
			ExCellManager.flush((ExProxy)args[1]);
			break;
		case QUIT:
			/* Maximum priprity */
			if (args.length == 3 && args[2] != null) {
				long gracePeriod = Long.parseLong((String)args[2]);
				ExCellManager.quit((ExGOD)args[1],gracePeriod);
			} else {
				ExCellManager.quit((ExGOD)args[1],userGracePeriod);
			}
			break;

		// クラス ExClassLoader で実装されているもの
		case LOADCLASS:
			nice(3);
			result = classLoader.loadClass((String)args[1]);
			break;
		case LOADPACKAGE:
			nice(3);
			classLoader.loadPackage((String)args[1]);
			break;

		// クラス ExAddressResolver で実装されているもの
		case RESOLVE:
			/* Maximum priprity */
			result = ExAddressResolver.resolve((String)args[1], (ExCommAddress)args[2]);
			break;

		default:
			throw new Exception(CN+": invalid fork selector = "+selector);
		}
		return result;
	}

	public
	String toString()
	{
		return CN;
	}


	/*
	 * これ以降はデバッグとシェルのためのプログラムである。
	 * （詳細は省略）
	 */
	static {

		/**
		 * クラスをロードする。
		 * （本来なら、ExClassLoader で登録して欲しい）
		 */
		class Load
		extends ExShellCommand
		{
			Load()
			{
				usage = " <codePath>|<package name>. [...]";
				comment = "load class or package";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length != 2) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too few or many arguments");
				}

				for (int i = 1; i < args.length; i ++ ) {
					String codePath = (String)args[i];
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
					if (codePath.endsWith(".")) {
					    codePath = codePath.substring(0,codePath.length()-1);
					    OzClassLoader.loadPackage(codePath);
					} else {
					    OzClassLoader.loadClass(codePath);
					}
				}

				return null;
			}
		}

		/**
		 * メモリが回収されなくなるまでGCを実行する。
		 */
		class GarbageCollect
		extends ExShellCommand
		{
			GarbageCollect()
			{
				usage = " ";
				comment = "do GC";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length != 1) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too many arguments");
				}

				/*
				 * メモリの回収ができなくなるまでGCを行う。
				 */
				Runtime runtime = Runtime.getRuntime();
				long size = 0;
				long a;
				long b = runtime.freeMemory();
				do {
					a = b;
					shell.stdout.print(".");
					shell.stdout.flush();
					runtime.gc();
					runtime.runFinalization();
					b = runtime.freeMemory();
					size += (b - a);
				} while( a != b );
				shell.stdout.println("\nGC size: "+size);

				return null;
			}
		}

		/**
		 * デバッグのためのフラグをon/offする。
		 */
		class Debug
		extends ExShellCommand
		{
			Debug()
			{
				usage = " [<god>] [true|false]";
				comment = "debug flag on/off";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length > 3) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too many arguments");
				}

				String gol = Executor.CN;
				boolean debug = true;
				if (args.length == 1) {
					debug = Executor.debug;
				} else {
					String arg = args[args.length-1].toLowerCase();
					if (arg.equals("true")||arg.equals("on")) {
						if (args.length == 2) {
							debug = Executor.debug = true;
						} else {
							ExCell cell = ExCellManager.get(new ExGOD(args[1]));
							if (cell == null) {
								throw new IllegalArgumentException(args[0]+": Not found cell("+args[1]+")");
							}
							gol = cell.getName();
							debug = cell.debug = true;
						}
					} else if (arg.equals("false")||arg.equals("off")) {
						if (args.length == 2) {
							debug = Executor.debug = false;
						} else {
							ExCell cell = ExCellManager.get(new ExGOD(args[1]));
							if (cell == null) {
								throw new IllegalArgumentException(args[0]+": Not found cell("+args[1]+")");
							}
							gol = cell.getName();
							debug = cell.debug = false;
						}
					} else {
						if (args.length == 3) {
							throw new IllegalArgumentException(args[0]+": Unknown keyword '"+args[2]+"'");
						}
						ExCell cell = ExCellManager.get(new ExGOD(args[1]));
						if (cell == null) {
							throw new IllegalArgumentException(args[0]+": Not found cell("+args[1]+")");
						}
						gol = cell.getName();
						debug = cell.debug;
					}
				}

				shell.stdout.println(gol+" debug is "+debug);
				return null;
			}
		}

		/**
		 * エグゼキュータを終了する。
		 */
		class Exit
		extends ExShellCommand
		{
			Exit()
			{
				usage = " [<status>]";
				comment = "exit executor";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (shell.subShell) {
					Executor.debug(CN,"Exit","subshell don't exit executor");
					return null;
				}

				if (args.length > 2) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too many arguments");
				}

				int status = 0;
				if (args.length == 2) {
					status = Integer.parseInt(args[1]);
				}

				if (ExCellManager.isEmpty()) {
					/*
					 * 終了処理が開始される前に、新たなセルが活性化される可能がある。
					 * しかし、このコマンドでは永遠に終了できなくので無視する。
					 */
					Object[] params;
					params = new Object[2];
					params[0] = new Integer(Executor.EXIT);
					params[1] = new Integer(status);
					syscall(params).join();
				} else {
					shell.stderr.println("Found "+ExCellManager.size()+" active cell(s)");
				}

				return null;
			}
		}

		/**
		 * エグゼキュータを強制終了する。
		 */
		class Quit
		extends ExShellCommand
		{
			Quit()
			{
				usage = " ";
				comment = "quit executor";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (shell.subShell) {
					Executor.debug(CN,"Quit","subshell don't quit executor");
					return null;
				}

				if (args.length != 1) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too many arguments");
				}

				Object[] params;

				/*
				 * セルを強制的に非活性化の状態にする。
				 */
				params = new Object[2];
				params[0] = new Integer(HALT);
				params[1] = new Long(0);
				try {
					Executor.syscall(params).join();
				} catch (ExProcessException e) {
					throw e.getException();
				}

				/*
				 * エグゼキュータを終了する。
				 */
				params = new Object[2];
				params[0] = new Integer(EXIT);
				params[1] = new Integer(0);
				try {
					Executor.syscall(params).join();
				} catch (ExProcessException e) {
					throw e.getException();
				}

				/*
				 * これ以降が実行されることはない。
				 */

				return null;
			}
		}

		/**
		 * エグゼキュータを通常終了する。
		 */
		class Shutdown
		extends ExShellCommand
		{
			Shutdown()
			{
				usage = " ";
				comment = "shutdown executor";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (shell.subShell) {
					Executor.debug(CN,"Shutdown","subshell don't shutdown executor");
					return null;
				}

				if (args.length != 1) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too many arguments");
				}

				/*
				 * エグゼキュータを終了する。
				 */
				Object[] params;
				params = new Object[2];
				params[0] = new Integer(EXIT);
				params[1] = new Integer(0);
				try {
					Executor.syscall(params).join();
				} catch (ExProcessException e) {
					throw e.getException();
				}

				/*
				 * これ以降が実行されることはない。
				 */

				return null;
			}
		}

		/**
		 * プロパティ一覧を印字する。
		 */
		class Prop
		extends ExShellCommand
		{
			Prop()
			{
				usage = " [<key>]";
				comment = "print system properties";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length == 1) {
					Properties props = System.getProperties();
					props.list(shell.stdout);
				} else {
					for (int i = 1; i < args.length; i ++) {
						String value = System.getProperty(args[i]);
						if (value != null) {
							shell.stdout.println(args[i]+"="+value);
						} else {
							shell.stdout.println(args[i]+" is not found");
						}
					}
				}

				return null;
			}
		}

		ExShell.append("exit",new Exit());
		ExShell.append("load",new Load());
		ExShell.append("gc",new GarbageCollect());
		ExShell.append("debug",new Debug());
		ExShell.append("quit",new Quit());
		ExShell.append("shutdown",new Shutdown());
		ExShell.append("prop",new Prop());
	}
}
