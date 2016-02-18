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
 * $Id: ExGOD.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 *
 * 注意: このファイルは vi で、hardtab=8, tabstop=4 として編集されている
 */

package JP.go.ipa.oz.system;

import java.io.File;
import java.io.FilenameFilter;
import java.io.FileOutputStream;
import java.util.Enumeration;

/**
 * このクラスはGOD（グローバルオブジェクトディレクトリ）を
 * 排他制御付きのファイル(java.io.File)として抽象化する。
 * このクラスによって生成したGODオブジェクトを使って、
 * エグゼキュータはGODの操作を行う。
 * GODをロック状態にしたGODオブジェクトのみがGODを
 * 非ロック状態にすることができる。
 * また、GODをロック状態にしたGODオブジェクトを
 * シリアライズの対象としてはならない。
 * GODオブジェクトは生成された当該エグゼキュータ上
 * でのみ有効であり、GODオブジェクトの存在が必ずしも
 * GODの存在を意味しない。
 *
 * <DL><DT>
 * 【注意】<DD>
 * GOD名の形式は'.'区切りの文字列であり、特定のＯＳのパスの
 * 区切りになる可能性のある文字やOZホーム名の区切り文字を含んではいけない。
 * また、文字列の両端が区切りの文字であってはならない。
 * <DT>
 * 【注意】<DD>
 * java.io.File が implements java.io.Serializable と
 * なっているため、クラスのＩ／Ｆとしてはシリアライズが
 * できることになるが、GODオブジェクトはクラス FileInputStream
 * の型の変数を持つので、少なくともロックを保持したままで
 * シリアライズすることはできなと思われる。
 * <DT>
 * 【メモ】<DD>
 * 「GOD名」は、GODの文字列での表現を意味する。
 * </DL>
 *
 * @see	ExGOL
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author		Yasumitsu Yoshida
 */
final
class ExGOD
extends File
{
	/**
	 * エグゼキュータ実装のデバッグ用
	 */
	static final String CN = "ExGOD";

	/**
	 * OZホーム下のGODのルートへのパスを保持する。
	 * 但し、便宜上のためにファイルセパレータ
	 * (file.separator)文字で終端している。
	 */
	private static final
	String objectsPath = System.getProperty("oz.home")
							+separator+"objects"+separator;

	/**
	 * グローバルオブジェクトディレクトリ（GOD）名の区切り文字列
	 */
	static final String godSeparator = ".";

	/**
	 * グローバルオブジェクトディレクトリ（GOD）名の区切り文字
	 */
	static final char godSeparatorChar = godSeparator.charAt(0);

	/**
	 * 非ロック状態であることを示すファイル名
	 */
	private static final String unlockFilename = ".inactive";

	/**
	 * ロック状態であることを示すファイル名のベース名
	 */
	private static final String lockedBaseFilename = ".lock.";

	/**
	 * ロック状態であることを示すファイル名
	 */
	private static final
	String lockedFilename = lockedBaseFilename +Executor.getID();

	/**
	 * GOD名を保持する。
	 */
	private String god;

	/**
	 * 非ロック状態であることを示すファイルを保持する
	 */
	private File unlock;

	/**
	 * ロック状態であることを示すファイルを保持する
	 */
	private File locked;

	/**
	 * 排他制御ファイルへの出力を保持する。
	 * このGODオブジェクトがロックを獲得していことを示す。
	 *
	 * <DL><DT>
	 * 【メモ】<DD>
	 * GODへのデバッグ出力先として使える可能性がある。
	 * <DT>
	 * 【注意】<DD>
	 * Windows NT 版ではオープン中のファイルの名前を
	 * メソッド renameTo を使って変更することはできない。
	 * 恐らくは、メソッド delete を使って削除もできないと思われる。
	 * </DL>
	 */
	private FileOutputStream lock = null;

	/**
	 * GOD名が適切な形式であるかを調べる。
	 * 但し、そのGOD名がGOLの一部として適切な形式であるかは調べない。
	 *
	 * <DL><DT>
	 * 【メモ】<DD>
	 * 通常はクラス ExGOL を使って作成したオブジェクトを経由して
	 * GODオブジェクトを得るので、その時点でGOD名がGOLの一部として
	 * 適切な形式であることは確認されている。
	 * </DL>
	 *
	 * @param	god		GOD名
	 * @exception	ExGOLFormatException
	 *					GOD名の形式が正しくない。
	 */
	static void check(String god)
	throws ExGOLFormatException
	{
		if (god.startsWith(godSeparator)) {
			throw new ExGOLFormatException(
				"GOD start with separator '"+godSeparator+"'");
		}
		if (god.endsWith(godSeparator)) {
			throw new ExGOLFormatException(
				"GOD end with seprator '"+godSeparator+"'");
		}
		if (0 <= god.indexOf(pathSeparator)) {
			throw new ExGOLFormatException(
				"GOD include path separator '"+pathSeparator+"'");
		}
		if (0 <= god.indexOf(separator)) {
			throw new ExGOLFormatException(
				"GOD include file separator '"+separator+"'");
		}
	}

	/**
	 * 初期設定を行う
	 *
	 * @param	god		GOD名
	 */
	private
	void init0(String god)
	{
		this.god = god;
		unlock = new File(this,unlockFilename);
		locked = new File(this,lockedFilename);
	}

	/**
	 * GOD名が適切であることを確認した上で初期設定を行う
	 *
	 * @param	god		GOD名
	 * @exception	ExGOLFormatException
	 *					GOD名の形式が正しくない。
	 */
	private
	void init(String god)
	throws ExGOLFormatException
	{
		check(god);
		init0(god);
	}

	/**
	 * GOD名を指定してGODオブジェクトを作成する。
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * GOLの一部として不適切な形式のGOD名を指定してGODオブジェクトを
	 * 作成することができるので注意すること。
	 * </DL>
	 *
	 * @param	god		GOD名
	 * @exception	ExGOLFormatException
	 *					GODの形式が正しくない。
	 */
	public ExGOD(String god)
	throws ExGOLFormatException
	{
		super(objectsPath+god.replace(godSeparatorChar,separatorChar));
		init(god);
	}

	/**
	 * 親のGOD名を指定してGODオブジェクトを作成する。
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * GOLの一部として不適切な形式のGOD名を指定してGODオブジェクトを
	 * 作成することができるので注意すること。
	 * </DL>
	 *
	 * @param	god		GOD名
	 * @param	name	GOD名の区切り文字を含まない子のGOD名
	 * @exception	ExGOLFormatException
	 *					GOD名の形式が正しくない。
	 */
	public ExGOD(String god, String name)
	throws ExGOLFormatException
	{
		super(objectsPath+god.replace(godSeparatorChar,separatorChar),name);
		init(god+godSeparator+name);
	}

	/**
	 * 親のGODオブジェクトを指定してGODオブジェクトを作成する。
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * GOLの一部として不適切な形式のGOD名を指定してGODオブジェクトを
	 * 作成することができるので注意すること。
	 * </DL>
	 *
	 * @param	god		GODオブジェクト
	 * @param	name	GOD名の区切り文字を含まない子のGOD名
	 * @exception	ExGOLFormatException
	 *					GOD名の形式が正しくない。
	 */
	public ExGOD(ExGOD god, String name)
	throws ExGOLFormatException
	{
		super(god,name);
		init(god.getName()+godSeparator+name);
	}

	/**
	 * GOLオブジェクトを指定してGODオブジェクトを作成する。
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * GOLオブジェクトは常に形式として正しいGOD名を
	 * 持っているので、ここでは再度チェックはしない。
	 * </DL>
	 *
	 * @param	gol		GOLのオブジェクト
	 * @exception	ExCellIllegalOzHomeException
	 *					OZホーム名が異なるので意味がない。
	 */
	public ExGOD(ExGOL gol)
	throws ExCellIllegalOzHomeException
	{
		super(objectsPath+gol.getGOD().replace(godSeparatorChar,separatorChar));
		init0(gol.getGOD());
	}

	/**
	 * プロキシを指定してGODオブジェクトを作成する。
	 *
	 * @param	proxy	プロキシのオブジェクト
	 * @exception	ExCellIllegalOzHomeException
	 *					OZホーム名が異なるので意味がない。
	 */
	public ExGOD(OzProxy proxy)
	throws ExCellIllegalOzHomeException
	{
		this(proxy.getGOL());
	}

	/**
	 * セル（スレッドグループ）を指定してGODオブジェクトを作成する。
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * セル（スレッドグループ）は常に形式として正しいGOD名を
	 * 持っているので、ここでは再度チェックはしない。
	 * </DL>
	 *
	 * @param	cell	セル（スレッドグループ）
	 */
	public ExGOD(ExCell cell)
	{
		super(objectsPath+cell.getName().replace(godSeparatorChar,separatorChar));
		init0(cell.getName());
	}

	/**
	 * GODオブジェクトのGOD名を返す。
	 *
	 * @return	GOD名
	 */
	public
	String getName()
	{
		return god;
	}

	/**
	 * このオブジェクトを表示するための文字列を返す。
	 * 標準の内容にGOD名を付加する。
	 *
	 * return		このオブジェクトの表示のための文字列
	 */
	public
	String toString()
	{
		String cn = getClass().getName();
		if (cn.startsWith(Executor.IPAoz)) {
			cn = cn.substring(Executor.IPAoz.length(),cn.length());
		}
		return cn+"@"+Integer.toHexString(hashCode())
				+"[god="+god+","+(lock==null?"unlock":"locked")+"]";
	}

	/**
	 * GODをロック状態にする。
	 *
	 * @exception	ExGODInvalidPathException
	 *					GODを作れない、あるいは、既に同じ名前のファイルが
	 *					存在する。
	 * @exception	ExGODInvalidStateException
	 *					既にGODはロック状態である、あるいは、想定した状態ではない。
	 *					結果として、このGODオブジェクトはロックを獲得できていない。
	 * @exception	ExException
	 *					通常は起らない例外が発生し、GODの状態は不定である。
	 */
	synchronized
	void acquire()
	throws ExException, ExGODInvalidPathException, ExGODInvalidStateException
	{
		if (lock != null) {
			throw new ExGODInvalidStateException("Already acquired with "+this);
		}
		if (exists()) {
			if (isDirectory()) {
				if (unlock.exists()) {
					if (unlock.renameTo(locked)) {
						Executor.debug(CN,"acquire",getPath()+" is reused for "+this);
					} else {
						String message = "Not renamed unlock("+unlock+") to locked("+locked+")";
						throw new ExGODInvalidStateException(message);
					}
				} else {
					throw new ExGODInvalidStateException("Not found unlock("+unlock+")");
				}
			} else {
				throw new ExGODInvalidPathException("Already same name file("+getPath()+") exists");
			}
		} else {
			if (mkdirs()) {
				Executor.debug(CN,"acquire",getPath()+" is made for "+this);
			} else {
				if (exists()) {
					throw new ExGODInvalidStateException("Already directory("+getPath()+") exists");
				} else {
					throw new ExGODInvalidPathException("Not made direcotry("+getPath()+")");
				}
			}
		}
		try {
			lock = new FileOutputStream(locked);
		} catch (Exception e) {
			lock = null;
			Executor.error(CN,"acquire","Can't open FileOutputStream("+locked+")",e);
			Executor.error(CN,"acquire","Try to rename locked("+locked+") to unlock("+unlock+")");
			if (locked.renameTo(unlock)) {
				Executor.error(CN,"acquire",getPath()+"is released");
			} else {
				Executor.error(CN,"acquire",getPath()+"isn't released");
			}
			throw new ExException(e.getMessage());
		}
	}

	/**
	 * GODを非ロック状態にする。
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * Windows NT 版ではオープン中のファイルの名前を
	 * メソッド renameTo を使って変更することはできない。
	 * </DL>
	 *
	 * @exception	ExGODInvalidStateException
	 *					未だGODのロックを獲得していない、あるいは、想定した状態ではない。
	 *					結果として、このGODオブジェクトはロックの開放処理を完了していない。
	 * @exception	ExException
	 *					通常は起らない例外が発生し、GODの状態は不定である。
	 */
	synchronized
	void release()
	throws ExException, ExGODInvalidStateException
	{
		if (lock == null) {
			throw new ExGODInvalidStateException("Not yet acquired with "+this);
		}
		try {
			lock.close();
		} catch (Exception e) {
			Executor.error(CN,"release","Can't close lock("+lock+")",e);
		}
		lock = null;
		if (locked.exists()) {
			if (locked.renameTo(unlock)) {
				Executor.debug(CN,"release",getPath()+" is released");
			} else {
				Executor.error(CN,"release","Not renamed locked("+locked+") to unlock("+unlock+")");
				Executor.error(CN,"release",getPath()+" isn't released");
				throw new ExGODInvalidStateException("Maybe locked("+locked+") is referred by other");
			}
		} else {
			throw new ExGODInvalidStateException("Not found locked("+locked+")");
		}
	}

	/**
	 * GODを強制的に非ロック状態にする。
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * Windows NT 版ではオープン中のファイルを削除できない。
	 * </DL>
	 *
	 * @exception	ExGODInvalidPathException
	 *					GODが存在しない、あるいは、既に同じ名前のファイルが存在する。
	 * @exception	ExGODInvalidStateException
	 *					GODを参照中のエグゼキュータがあると思われる(Windows NT版)。
	 * @exception	ExException
	 *					通常は起らない例外が発生し、GODの状態は不定である。
	 */
	synchronized
	void recover()
	throws ExException, ExGODInvalidPathException, ExGODInvalidStateException
	{
		// ロック状態を示すファイルを閉じる。
		if (lock != null) {
			try {
				lock.close();
			} catch (Exception e) {
				Executor.error(CN,"recover","Can't close "+lock+", but continue",e);
			}
			lock = null;
		}

		// GODへのパスが正しいかを確かめる。
		if (exists()) {
			if (!isDirectory()) {
				throw new ExGODInvalidPathException("Not directory path("+getPath()+")");
			}
		} else {
			throw new ExGODInvalidPathException("Not found directory("+getPath()+")");
		}

		// 非ロック状態を示すファイルが存在するならば、ロック状態にすることを試みる。
		if (unlock.exists()) {
			Executor.error(CN,"recover","Try to renamed unlock("+unlock+") to locked("+locked+")");
			if (unlock.renameTo(locked)) {
				Executor.error(CN,"recover","Renamed unlock("+unlock+") to locked("+locked+")");
			} else {
				Executor.error(CN,"recover","Try to delete unlock("+unlock+")");
				if (unlock.delete()) {
					Executor.error(CN,"recover","Deleted unlock("+unlock+")");
				} else {
					Executor.error(CN,"recover","GIVE UP RECOVERY OF DIRECTORY("+getPath()+")");
					throw new ExGODInvalidStateException("Maybe unlock("+unlock+") is referred by other");
				}
			}
		}

		/**
		 * GODのロック状態を示すファイルのリストを得るためのフィルター
		 */
		class PrefixFilenameFilter
		implements FilenameFilter
		{
			String prefix;

			PrefixFilenameFilter(String prefix)
			{
				this.prefix = prefix;
			}

			public
			boolean accept(File dir, String name)
			{
				return name.startsWith(prefix);
			}
		}

		// ロック状態を示すファイルの残骸を削除する。
		String[] list = list(new PrefixFilenameFilter(lockedBaseFilename));
		for (int i = 0; i < list.length; i ++) {
			File file = new File(this,list[i]);
			if (!file.delete()) {
				Executor.error(CN,"recover","ABORTED RECOVERY OF DIRECTORY("+getPath()+")");
				throw new ExGODInvalidStateException("Maybe locked("+locked+") is referred by other");
			}
		}

		// ロック状態を示すファイルを作成する。
		FileOutputStream file = null;
		try {
			file = new FileOutputStream(locked);
			file.close();
		} catch (Exception e) {
			Executor.error(CN,"recover","Can't open FileOutputStream("+locked+")",e);
			throw new ExException(e.getMessage());
		}

		// そのファイルを非ロック状態を示すファイル名に変える。
		if (locked.renameTo(unlock)) {
			Executor.error(CN,"recover",getPath()+" is recovered");
		} else {
			Executor.error(CN,"recover","Not renamed locked("+locked+") to unlock("+unlock+")");
			Executor.error(CN,"recover","ABORTED RECOVERY OF DIRECTORY("+getPath()+")");
			throw new ExGODInvalidStateException("Maybe unlcok("+unlock+") exists");
		}
	}

	/**
	 * GOD がロック状態であるかを調べる。
	 *
	 * <DL><DT>
	 * 【注意】<DD>
	 * OSによっては、ファイルのパス名上は存在しないが、
	 * 実体（オープンしている）は存在する場合が考えられる。
	 * この場合、外部からは「見えない」ので false を返す。
	 * 従って、lock が null かどうかは調べない。
	 * </DL>
	 *
	 * @return	GODがロック状態ならば、true を返す。GODが不適切な場合も含めて、
	 *			GODがロック状態であることを確認できなければ false を返す。
	 *
	 */
	synchronized
	boolean knock()
	{
		if (exists()) {
			if (isDirectory()) {
				if (! unlock.exists()) {
					return true;
				}
			}
		}
		return false;
	}

	/*
	 * これ以降はデバッグとシェルのためのプログラムである。
	 * （詳細は省略）
	 */
	private static final java.util.Dictionary gods = new java.util.Hashtable();
	static {

		/*
		 * GODの獲得コマンド
		 */
		class Acquire
		extends ExShellCommand
		{
			Acquire()
			{
				usage = " <god>";
				comment = "acquire GOD";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length != 2) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too few or many arguments");
				}

				ExGOD god = new ExGOD(args[1]);
				god.acquire();
				gods.put(args[1],god);
				return null;
			}
		}

		/*
		 * GODの開放コマンド
		 */
		class Release
		extends ExShellCommand
		{
			Release()
			{
				usage = " [<god>]";
				comment = "release GOD or, list acquired gods";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (2 < args.length) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too many arguments");
				}

				if (args.length == 2) {
					ExGOD god = (ExGOD)gods.get(args[1]);
					if (god == null) {
						throw new IllegalArgumentException("Not found "+args[1]);
					}
					god.release();
					gods.remove(args[1]);
				} else {
					shell.stdout.println("-- Acquired god list --");
					Enumeration keys = gods.keys();
					while (keys.hasMoreElements()) {
						String key = (String)keys.nextElement();
						ExGOD god = (ExGOD)gods.get(key);
						if (god != null) shell.stdout.println(god.toString());
					}
				}

				return null;
			}
		}

		/*
		 * GODの修復コマンド
		 */
		class Recover
		extends ExShellCommand
		{
			Recover()
			{
				usage = " <god>";
				comment = "recover GOD";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length != 2) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too few or many arguments");
				}

				ExGOD god = new ExGOD(args[1]);
				if (god == null) {
					throw new IllegalArgumentException("Not found "+args[1]);
				}
				god.recover();
				return null;
			}
		}

		ExShell.append("acquire",new Acquire());
		ExShell.append("release",new Release());
		ExShell.append("recover",new Recover());
	}
}
