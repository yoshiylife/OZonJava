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
 * $Id: OzLocalRepositoryManager.java,v 1.2 1997/11/20 05:22:28 yoshi Exp $
 */

package	JP.go.ipa.oz.system;

import	java.io.File;
import	java.io.FileInputStream;
import	java.io.FileNotFoundException;
import	java.io.FileOutputStream;
import	java.io.FilenameFilter;
import	java.io.IOException;
import	java.io.InputStream;
import	java.io.OutputStream;
import	java.util.Dictionary;
import	java.util.Enumeration ;
import	java.util.Hashtable;
import	java.util.zip.ZipEntry;
import	java.util.zip.ZipException;
import	java.util.zip.ZipFile;

/**
 * クラス OzLocalRepositoryManager は、ローカルリポジトリの操作機能を
 * 提供する Java API である。このクラスは、エグゼキュータの動作を前提としない。
 * このクラスには、static メソッドのみが定義される。
 * このクラスはエグゼキュータ外へ公開されるので、
 * セキュリティに十分注意して実装を行う必要がある。
 *
 * <DL><DT>
 * 【注意】<DD>
 * このクラスの実装で使用するクラス、または、 メソッド等はエグゼキュータの
 * 動作を前提とせずに、単独で動作するものでなければならない。
 * ただし、特定のプロパティ等が適切に設定されていることは前提とする。
 * </DL>
 *
 * @see OzClassFile
 *
 * @version		$Revision: 1.2 $, $Date: 1997/11/20 05:22:28 $
 * @author		Yasumitsu Yoshida
 */
public final
class OzLocalRepositoryManager
{

    /**
     * エグゼキュータ実装のデバッグ用
     */
    static final String CN = "OzLocalRepositoryManager";

    /**
     * 仮登録中を示すファイル名のベース名
     *
     * <DL><DT>
     * 【注意】<DD>
     * 正式なクラスアーカイブファイルが存在する場合は、
     * 仮登録中を示すファイルは無視される。
     * </DL>
     */
    private static final String triedFilenameKeyword = ".trial";

    /**
     * デバッグ用フラグ
     */
    private static boolean debug
	= (System.getProperty(OzLocalRepositoryManager.class.getName()+".debug") != null) ? true : false;

    /**
     * ローカルリポジトリのルートのパッケージ名
     */
    static final String repositoryPackageName = ExCodePath.ReleasedUserClassPackage;

    /**
     * ローカルリポジトリのルートのパッケージ名に対応するパス名
     */
    static final String repositoryPackagePath
	= repositoryPackageName.replace('.', File.separatorChar);

    /**
     * ローカルリポジトリのルートのフルパス名
     */
    static final String repositoryPath
	= OzClassFile.ozHomeClassStoragePath+File.separator+repositoryPackagePath;

    /**
     * クラスアーカイブファイルとトップパッケージ名のテーブル
     */
    static private final Dictionary zipFiles = new Hashtable();

    /**
     * 仮登録中かを調べるためのフィルター
     */
    static
    class TriedFilenameFilter
    implements FilenameFilter
    {
    	String key;

	TriedFilenameFilter(String key)
	{
	    this.key = key;
	}

	public
	boolean accept(File dir, String name)
	{
	    return name.startsWith(key);
	}
    }

    /**
     * ログ記録のためのメッセージを出力する。
     * 但し、エグゼキュータの動作を前提にできないので、
     * メッセージは標準エラー出力に出力する。
     *
     * @param	methodName	メッセージに付加されるメソッド名
     * @param	message		出力するメッセージ
     */
    private static
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
    private static
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
     * 指定されたパッケージを含むクラスアーカイブファイルを検索し、
     * そのクラスアーカイブファイル名を返す。
     *
     * @param	packagePath
     *		検索するパッケージ名に対応する相対パス名
     * @param	trial
     *		true の時、検索過程で仮登録を考慮する。
     * @return	指定されたパッケージを含むクラスアーカイブファイルのファイル名を返す。
     *		見つからない場合は、null を返す。仮登録中のものが該当した場合は、
     *		そのファイルのベース名を返す。
     *
     */
    private static
    File findPackage(String packagePath, boolean trial)
    throws IOException
    {
	debug("findPackage", "("+packagePath+","+trial+")");
	File base = new File(OzClassFile.ozHomeClassStoragePath, packagePath);
	String parent = base.getParent();
	String packageEntryName = packagePath.replace(File.separatorChar, '/')+"/";
	boolean first = true;
	for (;;) {
	    File directory = new File(parent);
	    File file = new File(directory, base.getName()+".zip");
	    if (!file.getPath().startsWith(repositoryPath)) break;
	    debug("findPackage", "Test "+file.getPath());
	    if (file.exists()) {
		ZipFile zipFile = null;
		try {
		    zipFile = new ZipFile(file);
		    if (zipFile.getEntry(packageEntryName) != null) {
			debug("findPackage", packagePath+" is found in "+file.getPath());
			return file;
		    }
		} catch (IOException e) {
		    e.printStackTrace(System.err);
		    throw e;
		} finally {
		    if (zipFile != null) zipFile.close();
		}
	    }
	    if (trial) {
		if (!first) {
		    String triedBaseFilename = base.getName()+triedFilenameKeyword;
		    FilenameFilter filter = new TriedFilenameFilter(triedBaseFilename);
		    String lists[] = directory.list(filter);
		    if (lists != null && lists.length != 0) {
			file = new File(directory, triedBaseFilename);
			debug("findPackage", packagePath+" is found in "+file.getPath());
			return file;
		    }
		} else {
		    first = false;
		}
	    }
	    base = directory;
	    parent = base.getParent();
	}
	debug("findPackage", packagePath+" is not found.");
	return null;
    }

    /**
     * 引数 topPackageName で指定されたトップパッケージを
     * クラスアーカイブファイルが含み、
     * そのクラスアーカイブファイルに含まれるファイルの
     * パス名が少なくともトップパッケージに対応するパスを含み、
     * また、指定されたクラスアーカイブファイルに含まれるパッケージが
     * 既にトップパッケージとして登録されていないことを調べる。
     *
     * @param	topPackagePath	登録するトップパッケージ名に対応する相対パス名
     * @param	trial	登録するクラスアーカイブファイル名
     * @return	クラスアーカイブの内容が適切であれば true を返す。
     */
    private static
    boolean checkPackage(String topPackagePath, File trial)
    throws IOException
    {
	debug("checkPackage", "("+topPackagePath+","+trial.getPath()+")");
	boolean ok = false;
	String topPackageEntry = topPackagePath.replace(File.separatorChar, '/')+"/";
	int topPackageEntryLength = topPackageEntry.length();
	ZipFile zipFile = null;
	try {
	    zipFile = new ZipFile(trial);
	    Enumeration handle = zipFile.entries(); 
	    while (handle.hasMoreElements()) {
		ZipEntry entry = (ZipEntry)handle.nextElement();
		String path = entry.getName();
		if (path.startsWith(topPackageEntry)) {
		    if (entry.isDirectory()) {
			if (path.length() == topPackageEntryLength) {
			    debug("checkPackage", topPackagePath+" is found in "+zipFile.getName());
			    ok = true;
			}
			File child = new File(OzClassFile.ozHomeClassStoragePath, path);
			File target = new File(child.getParent());
			File directory = new File(target.getParent());
			File file = new File(directory, target.getName()+".zip");
			if (file.exists()) {
			    debug("checkPackage", topPackagePath+" is found in "+file.getPath());
			    return false;
			}
			FilenameFilter filter = new TriedFilenameFilter(target.getName()+triedFilenameKeyword);
			String lists[] = directory.list(filter);
			if (lists != null && lists.length != 0) {
			    for (int i = 0; i < lists.length; i ++) {
				File a = new File(directory, lists[i]);
				if (!trial.equals(a)) {
				    debug("checkPackage", topPackagePath+" is found in "+a.getPath());
				    return false;
				}
			    }
			}
		    }
		} else {
		    debug("checkPackage", path+" is found in "+ zipFile.getName());
		    return false;
		}
	    }
	} catch (IOException e) {
	    e.printStackTrace(System.err);
	    throw e;
	} finally {
	    if (zipFile != null) zipFile.close();
	}
	debug("checkPackage", trial.getPath()+" is "+(ok?"OK":"NG")+".");
	return ok;
    }

    /**
     * 新にローカルリポジトリにクラスアーカイブファイルを作成する。
     *
     * @param	topPackagePath	登録するクラスアーカイブファイルのトップパッケージ名
     * @param	delivery	クラスアーカイブファイルを作成する際の読み込み先を得る
     * @return	新規にクラスアーカイブファイルを作成した場合は、true を返す。
     */
    private static
    boolean download(String topPackagePath, ExClassDelivery delivery)
    throws IOException
    {
	File base = new File(OzClassFile.ozHomeClassStoragePath, topPackagePath);
	File directory = new File(base.getParent());
	File file = new File(directory, base.getName()+".zip");
	File trial = new File(directory, base.getName()+triedFilenameKeyword+"."+Executor.getID());
	try {
	    // 仮登録にてファイルをダウンロード
	    if (directory.exists()) {
		if (directory.isDirectory()) {
		    if (file.exists()) {
			if (file.isFile()) {
			    if (file.length() == delivery.length()) {
				debug("download", "Already downloaded: "+file.getPath());
				return false;
			    } else {
				syslog("download", "Incorrect length of downloaded file: "+file.getPath());
			    }
			} else {
			    String message = "Already none file exists: "+file.getPath();
			    syslog("download", message);
			    throw new IOException(message);
			}
		    }
		} else {
		    String message = "Already file exists: "+directory.getPath();
		    syslog("download", message);
		    throw new IOException(message);
		}
	    } else {
		debug("download", "mkdirs "+directory.getPath());
		directory.mkdirs();
	    }
	    delivery.download(trial);
	    if (file.exists()) {
	    	if (file.isFile()) {
		    debug("download", "Already downloaded by other executor: "+file.getPath());
		    return false;
		} else {
		    String message = "Already none file exists: "+file.getPath();
		    syslog("download", message);
		    throw new IOException(message);
		}
	    } else {
		// 引数 topPackagePath で指定されたトップパッケージが既に登録されているか？
		File zipFile = findPackage(topPackagePath, true);
		if (zipFile != null) {
		    trial.delete();
		    String message = topPackagePath+" is found in "+zipFile.getPath();
		    syslog("download", message);
		    throw new SecurityException(message);
		}
		// クラスアーカイブファイルの内容が適切か？
		if (!checkPackage(topPackagePath, trial)) {
		    trial.delete();
		    String message = "Illegal entry is found by "+topPackagePath;
		    syslog("download", message);
		    throw new SecurityException(message);
		}
		// 正式登録
		if (! trial.renameTo(file)) {
		    /* Never fail to rename if the file exists. */
		    String message = "Can't rename "+trial.getPath()+" to "+file.getPath();
		    syslog("download", message);
		    throw new IOException(message);
		}
		debug("download", "complete "+topPackagePath+" with "+file.getPath());
		return true;
	    }
	} finally {
	    if (trial.exists() && ! trial.delete()) {
		syslog("download", "Can't delete "+trial.getPath());
	    }
	}
    }

    /**
     * トップパッケージ名に対応するクラスアーカイブファイルを操作するための
     * オブジェクトを返す。対応するファイルが無い場合、引数 in からデータを
     * 読みだして、クラスアーカイブファイルの作成を試みる。
     *
     * @param	topPackageName	トップパッケージ名
     * @param	delivery	クラスアーカイブファイルを作成する際の読み込み先を得る
     * @param	onlyNew	true の時、新規作成した場合のみオブジェクトを返す。
     * @return	ロードしたクラスアーカイブファイルを操作するためのオブジェクトを返す。
     */
    private static
    ExZipFile load(String topPackageName, ExClassDelivery delivery, boolean onlyNew)
    throws IOException
    {
	debug("load", "("+topPackageName+",,"+onlyNew+")");
	ExZipFile zipFile = null;
	boolean transfered = false;
	for (;;) {
	    Object o = zipFiles.get(topPackageName);
	    if (o == null) {
		ExFakeObject current = new ExFakeObject();
		o = zipFiles.put(topPackageName, current);
		if (o == null) {
		    try {
			String topPackagePath = topPackageName.replace('.', File.separatorChar);
			File file = new File(OzClassFile.ozHomeClassStoragePath, topPackagePath+".zip");
			if (! file.exists() && delivery != null) {
			    debug("load", "***** READING "+topPackageName);
			    transfered = download(topPackagePath, delivery);
			}
			zipFile = new ExZipFile(file);
		    } catch (SecurityException e) {
			zipFiles.remove(topPackageName);
			current.abort();
			throw e;
		    } catch (IOException e) {
			zipFiles.remove(topPackageName);
			current.abort();
			throw e;
		    }
		    zipFiles.put(topPackageName, zipFile);
		    current.ready();
		    debug("load", "***** LOADED "+topPackageName+" from "+zipFile.getName());
		    break;
		} else {
		    if (o instanceof ExFakeObject) {
			debug("load","***** wait "+topPackageName);
			ExFakeObject fake = (ExFakeObject)o;
			if (fake.await()) {
			    current.ready();
			} else {
			    current.abort();
			    throw new IOException(topPackageName);
			}
		    } else {
			debug("load","***** reset "+topPackageName);
			zipFiles.put(topPackageName, o);
			current.ready();
			zipFile = (ExZipFile)o;
			break;
		    }
		}
	    } else {
		if (o instanceof ExFakeObject) {
		    debug("load","***** WAIT "+topPackageName);
		    ExFakeObject fake = (ExFakeObject)o;
		    if (! fake.await()) {
			throw new IOException(topPackageName);
		    }
		} else {
		    zipFile = (ExZipFile)o;
		    break;
		}
	    }
	    debug("load","***** RETRY "+topPackageName);
	}
	return onlyNew ? (transfered ? zipFile : null) : zipFile;
    }

    /**
     * @see	load(java.lang.String,java.io.InputStream,boolean)
     */
    static
    ExZipFile load(ExClassDelivery delivery)
    throws IOException
    {
	return load(delivery.getName(), delivery, false);
    }

    /**
     * @see	load(java.lang.String,java.io.InputStream,boolean)
     */
    static
    ExZipFile load(ExClassDelivery delivery, boolean onlyNew)
    throws IOException
    {
	return load(delivery.getName(), delivery, onlyNew);
    }

    /**
     * @see	load(java.lang.String,java.io.InputStream,boolean)
     */
    static
    ExZipFile load(String topPackageName)
    throws IOException
    {
	return load(topPackageName, null, false);
    }

    /**
     * ローカルマシーン上に存在するクラスアーカイブファイルを、
     * ローカルリポジトリに登録し、コピーする。既に登録されている
     * クラスアーカイブファイルと同じトップパッケージの
     * クラスアーカイブファイルを登録することはできない。
     * また、既に登録されているクラスアーカイブファイルに
     * 含まれているパッケージをトップパッケージとする
     * クラスアーカイブファイルを登録することもできない。
     * 登録を試みた場合、パッケージ名をログに記録する。
     * また、登録の成功／失敗もログに記録する。
     *
     * @param	file		登録するzipファイル。
     * @param	topPackageName	トップパッケージ名。
     * @exception	IOException
     *			ファイル操作中に例外が発生した。
     * @exception	SecurityException
     *			既に登録されているクラスアーカイブファイルと同じ
     *			トップパッケージのクラスアーカイブファイルを登録
     *			しようとしたか、または、他のクラスアーカイブファイルに
     *			含まれているパッケージをトップパッケージとするような
     *			クラスアーカイブファイルを登録しようとした。
     *			あるいは、OZ のセキュリティマネージャが存在するとき、
     *			赤スレッドによって起動された。
     */
    public static
    void add(File file, String topPackageName)
    throws IOException
    {
	syslog("add", file.getPath()+"("+topPackageName+")");

	SecurityManager sm = System.getSecurityManager();
	if (sm instanceof ExSecurityManager) {
	    ((ExSecurityManager)sm).tryLocalRepositoryAdd(topPackageName);
	}
	// 登録条件の検査はセキュリティマネージャの存在に関係なく常に行う。

	// 引数 topPackageName が JP.go.ipa.oz.user.released で始まっているか？
	if (!topPackageName.startsWith(repositoryPackageName)) {
	    String message = topPackageName+" start without "+repositoryPackageName;
	    syslog("add", message);
	    throw new SecurityException(message);
	}

	try {
	    ExClassDelivery delivery =new ExClassDelivery(topPackageName, file);
	    try {
		ExZipFile zipFile = load(delivery, true); // Don't close zipFile
		if (zipFile == null) {
		    String message = topPackageName+" already exists.";
		    syslog("add", message);
		    throw new SecurityException(message);
		}
		syslog("add", file.getPath()+"("+topPackageName+") is stored as "+zipFile.getName());
	    } finally {
		delivery.close();
	    }
	} catch (IOException e) {
	    syslog("add", file.getPath()+"("+topPackageName+") is not stored.");
	    throw e;
	}
    }

    /**
     * ローカルリポジトリから、指定されたパッケージを含む
     * ZIPオブジェクト（クラスアーカイブファイル）を検索する。
     *
     * @param	packageName	検索対象のパッケージ名。
     * @return	指定されたパッケージを含むZIPオブジェクト
     * @exception	IOException
     *			ファイル操作中に例外が発生した。
     */
    static
    ExZipFile find(String packageName)
    {
	ExZipFile zipFile = null;
	String packageEntryName = packageName.replace('.', '/')+"/";
	while (packageName.startsWith(repositoryPackageName)) {
	    try {
		zipFile = load(packageName);
	    } catch (IOException e) {
		zipFile = null;
	    }
	    if (zipFile != null) {
		if (zipFile.getEntry(packageEntryName) != null) {
		    return zipFile;
		}
	    }
	    packageName = packageName.substring(0, packageName.lastIndexOf((int)'.'));
	}
	return null;
    }

    /**
     * ローカルリポジトリから、指定されたパッケージを含む
     * クラスアーカイブファイルを検索する。
     *
     * @param	packageName	検索対象のパッケージ名。
     * @return	指定されたパッケージを含むクラスアーカイブファイル。
     * @exception	IOException
     *			ファイル操作中に例外が発生した。
     *
     * @see	find(String)
     */
    public static
    File get(String packageName)
    throws IOException
    {
	ZipFile zipFile = find(packageName);
	return (zipFile != null) ? new File(zipFile.getName()) : null;
    }

    /**
     * パッケージ名の集合を指定して、それらのパッケージが含まれる
     * クラスアーカイブファイルを検索し、コンパイル時に必要な
     * CLASSPATH を計算する。この CLASSPATH には次のものが順に含まれる。
     * <UL>
     * <LI>システムプロパティ java.class.path の内容
     * <LI>指定されたパッケージを含むクラスアーカイブファイルのパス名の並び
     * </UL>
     * パッケージの検索は、ローカルジポジトリのみを対象し、
     * このメソッドの呼び出しによってクラスアーカイブファイル等の
     * クラス配送は行われない。
     *
     * @param	packageNames	 検索対象のパッケージ名の集合。
     * @return	プラットフォームに依存した CLASSPATH の文字列。
     * @exception	ClassNotFoundException
     *			ローカルリポジトリに適切なクラスアーカイブファイルが
     *			見つからない。見つからないパッケージが１つでもあれば、
     *			この例外が発生する。
     * @exception	IOException
     *			ファイル操作中に例外が発生した。
     */
    public static
    String classPath(String[] packageNames)
    throws ClassNotFoundException, IOException
    {
	String classPath = System.getProperty("java.class.path");
	Dictionary works = new Hashtable();
	for (int i = 0; i < packageNames.length ; i ++) {
	    String packagePath = packageNames[i].replace('.', File.separatorChar);
	    File file = findPackage(packagePath, false);
	    if (file == null) {
		throw new ClassNotFoundException(packageNames[i]);
	    }
	    if (works.get(file.getPath()) == null) {
		classPath = classPath + File.pathSeparator + file.getPath();
		works.put(file.getPath(), file);
	    }
	}
	return classPath;
    }

    /**
     * 指定されたパッケージをトップパッケージとするクラスアーカイブファイルを
     * ローカルリポジトリから削除する。
     * <DL><DT>
     * 【注意】<DD>
     * ローカルリポジトリ中のファイルを物理的に削除する。
     * この操作により、既にそのクラスアーカイブファイルを
     * 参照している当該エグゼキュータを含めたエグゼキュータへの
     * 考慮は全くない。また、システムの特性上、このメソッドが
     * 例外なしに終了した場合であっても、クラスアーカイブファイルが
     * 削除されているとは限らない。他のエグゼキュータにより、
     * そのクラスアーカイブファイルが配送されて来るからである。
     * </DL>
     *
     * @param	topPackageName	削除するクラスアーカイブファイルの
     *				トップパッケージ名。
     * @exception	ClassNotFoundException
     *			指定されたパッケージをトップパッケージとする
     *			クラスアーカイブファイルがローカルリポジトリに
     *			見つからない。
     * @exception	IOException
     *			ファイル操作中に例外が発生した。
     * @exception	SecurityException
     *			OZ のセキュリティマネージャが存在するとき、
     *			赤スレッドによって起動された。
     */
    public static
    void remove(String topPackageName)
    throws ClassNotFoundException, IOException
    {
	SecurityManager sm = System.getSecurityManager();
	if (sm instanceof ExSecurityManager) {
	    ((ExSecurityManager)sm).tryLocalRepositoryRemove(topPackageName);
	}

	String path = topPackageName.replace('.', File.separatorChar);
	File target = new File(OzClassFile.ozHomeClassStoragePath,path+".zip");
	if (!target.exists()) {
	    throw new ClassNotFoundException("top package: "+topPackageName);
	}
	for (;;) {
	    Object o = zipFiles.remove(topPackageName);
	    if (o != null) {
		if (o instanceof ExFakeObject) {
		    // 登録処理中なので処理の終了を待って、再度やり直す。
		    ExFakeObject fake = (ExFakeObject)o;
		    if (! fake.await()) {
			break;
		    }
		} else {
		    ZipFile zipFile = (ZipFile)o;
		    zipFile.close();
		}
	    } else {
		break;
	    }
	}
	target.delete();
    }

    /**
     * このクラスは static メソッド（クラスメソッド）のみを持つ。
     * また、このクラスのオブジェクトを生成して使用しない。
     * このクラスは public であり、また、エグゼキュータの実装に依存する
     * 部分が含まれるので、このクラスのオブジェクトが外部に持ち出され
     * ないようにする必要がある。
     */
    private
    OzLocalRepositoryManager()
    {
	/* Nothing */
    }

}
