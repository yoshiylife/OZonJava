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

package JP.go.ipa.oz.system;

import java.lang.reflect.*;
import java.io.*;
import java.net.*;
import java.util.*;

/***
 * ExCommCipher handles cache of cipher type of each terget GOL.
 * Packets Types of cipher type negotiation is defined also.
 *
 * @author Tadayuki Higuchi
 * @author Yoichi Hamazaki
 */
final class ExCommCipher {
    private static String CN = "ExCommCipher";
    private static final String fileSeparator = File.separator;

    /**
     * 平文
     */
    static public final String PlainText = new String("PlainText");

    /**
     * パケットタイプ
     */
    static public final int Plain = 0;
    static public final int PlainNegotiation = 1;  // no one use this;
    static public final int NegotiationStart = 2;
    static public final int NegotiationStop = 3;
    static public final int Result = 4;
    static public final int Cryptogram = 5;
    static public final int Cache = 6;
    static public final int CryptogramEnd = 7;
    static public final int NegotiationOk = 8;
    static public final int CipherStart = -1;

    /**
     * チャンネルタイプ
     */
    static public final int caller = 0;
    static public final int callee = 1;

    /**
     * データ受信実行タイプ
     */
    static public final int Exe = 0;
    static public final int ReCipher = 1;
    static public final int Error = 2;
    static public final int what = -1;

    /**
     * Hashtable to store cache of cipher type<br>
     * cipherCache is Hashtable of (String)GOD as key and
     * (Hashtable)CipherCacheOfThisCaller as value.
     */
    static Dictionary cipherCache = new Hashtable();

    /**
     * Hashtable to store know type of cipher for each object<br>
     * 
     * cipherTypes is Hashtable of (String)GOD as key and
     * (Hashtable)KnownCipherType as value.
     */
    private static Dictionary cipherTypes = new Hashtable();

    /**
     * キャッシュがあるかチェックをする。
     *
     * @return キャッシュにより、暗号化方式名を返す。
     * キャッシュが無いときは null を返す。
     *
     */
    public static synchronized String checkCache(String caller,
						 OzProxy calleeProxy)
    throws ExException {
	String calleeGolString = calleeProxy.getName();
	Executor.debug(CN, "checkCache", "callee: " + calleeGolString);
	ExGOD callerGod = newGOD(caller);
	Dictionary cipherCacheTable
	  = (Dictionary)cipherCache.get(callerGod.getName());

	if (cipherCacheTable == null) {
	    /* GOD/.ciphercache file has not been read */
	    cipherCacheTable = tryCacheFile(callerGod);
	    if (cipherCacheTable == null) {
		cipherCacheTable = new Hashtable();
	    }
	    {
		Hashtable t = (Hashtable)cipherCacheTable;
		java.util.Enumeration keys = t.keys();
		while (keys.hasMoreElements()) {
		    Executor.debug(CN, "checkCache",
				   "key: " + (String)keys.nextElement());
		}
	    }
	    cipherCache.put(callerGod.getName(), cipherCacheTable);
	}
	return (String)cipherCacheTable.get(calleeGolString);
    }

    private static ExGOD newGOD(String caller) throws ExException {
	try {
	    return new ExGOD(new ExGOL(caller));
	} catch (ExException e) {
	    Executor.debug(CN, "newGOD", "cannot find GOD: " + caller, e);
	    throw e;
	}
    }

    private static Dictionary tryCacheFile(ExGOD callerGod) {
	File cacheFile = new File(callerGod, ".ciphercache");
	if (cacheFile.exists() == true) {
	    Executor.debug(CN, "tryCacheFile", "file ok:" + cacheFile);
	    File cipherFile = new File(callerGod, ".cipher");
	    if (cacheFile.lastModified() < cipherFile.lastModified()) {
		/* .cipher is newer than .ciphercache. Discard .ciphercache. */
		Executor.debug(CN, "tryCacheFile", "obsolete cache");
		cacheFile.delete();
		return null;
	    } else {
		ObjectInputStream oistream;

		Executor.debug(CN, "tryCacheFile", "valid cache");
		try {
		    oistream
		      = new ObjectInputStream(new FileInputStream(cacheFile));
		} catch (IOException ioex) {
		    Executor.syslog(CN, "tryCacheFile",
				    "cache file open error. deleting it.",
				    ioex);
		    cacheFile.delete();
		    return null;
		}
		try {
		    return (Dictionary)oistream.readObject();
		} catch (IOException ioex) {
		    Executor.syslog(CN, "tryCacheFile",
				    "cache file read error. deleting it.",
				    ioex);
		    cacheFile.delete();
		    return null;
		} catch (ClassNotFoundException cnex) {
		    Executor.debug(CN, "tryCacheFile",
				   "cache file read error (class not found).",
				   cnex);
		    return null;
		} finally {
		    try {
			oistream.close();
		    } catch (IOException ioex) {
			// ignore
		    }
		}
	    }
	} else {
	    return null;
	}
    }

    /**
     * キャッシュを作成する。
     *
     * @param 
     */
    public static synchronized void makeCache(String caller, String callee,
					      String name)
    throws ExException {
	Dictionary cipherCacheTable;
	ExGOD callerGod = newGOD(caller);

	cipherCacheTable = (Dictionary)cipherCache.get(callerGod.getName());
	if (cipherCacheTable != null) {
	    String registeredName = (String)cipherCacheTable.put(callee, name);
	    if (registeredName != null && registeredName.equals(name)) {
		/* the cipher has already been registered.  no need to save. */
		return;
	    }
	} else {
	    cipherCacheTable = new Hashtable();
	    cipherCacheTable.put(callee, name);
	    cipherCache.put(callerGod.getName(), cipherCacheTable);
	}

	Executor.debug("ExCommCipher#makeCache: saving cache");

	File cacheFile = new File(callerGod, ".ciphercache");
	if (cacheFile.exists()) {
	    File tmpFile = new File(callerGod, "ciphercache.tmp");
	    if (writeToFile(cipherCacheTable, tmpFile)) {
		if (cacheFile.delete()) {
		    tmpFile.renameTo(cacheFile);
		} else {
		    tmpFile.delete();
		}
	    }
	} else {
	    writeToFile(cipherCacheTable, cacheFile);
	}
	Executor.debug("ExCommCipher#makeCache: End");
    }

    private static boolean writeToFile(Object o, File file) {
	ObjectOutputStream oostream;

	try {
	    oostream = new ObjectOutputStream(new FileOutputStream(file));
	} catch (IOException e) {
	    file.delete();
	    return false;
	}
	try {
	    oostream.writeObject(o);
	} catch (IOException ioex) {
	    file.delete();
	    return false;
	} finally {
	    try {
		oostream.close();
	    } catch (IOException ioex) {
		/* ignore */
	    }
	}
	return true;
    }

    /**
     * セルの .cipher の内容を表す Dictionary を得る。
     * マシンの暗号化リストにないものは含まれていない。
     *
     * @param	gol	callee GOL
     * @return	セルの .cipher の内容を表す Dictionary を返す。
     *		マシンのリストにないものは含まれていない。
     *		.cipher がない場合はマシンのリストそのものを返す。
     * @exception ExGOLFormatException
     *		when argument gol is in illegal format.
     * @exception ExCommCipherException
     *		when other recoverable error occured.
     */
    public static synchronized String[] getCellCipherList(String gol)
    throws ExException {
	Executor.debug(CN, "getCellCipherList", gol);
	ExGOD god = newGOD(gol);
	String[] cellCipherList
	  = (String[])ExCommCipher.cipherTypes.get(god.getName());

	if (cellCipherList == null) {
	    cellCipherList = readCipherFile(god);
	    ExCommCipher.cipherTypes.put(god.getName(), cellCipherList);
	}
	return cellCipherList;
    }

    private static String[] readCipherFile(ExGOD god)
    throws ExCommCipherException {
	File cipherFile = new File(god, ".cipher");

	if (cipherFile.exists()) {
	    Executor.debug(CN, "readCipherFile",
			   "reading " + cipherFile.getPath());
	    BufferedReader distream;
	    try {
		distream = new BufferedReader(new FileReader(cipherFile));
	    } catch (FileNotFoundException e) {
		Executor.syslog(CN, "readCipherFile",
				"open failed: " + cipherFile, e);
		throw new ExCommCipherException("open failed: " + cipherFile);
	    }

	    Vector list = new Vector();
	    boolean emptyfile = true;
	    try {
		String name;
		while ((name = distream.readLine()) != null) {
		    name = name.trim();
		    if (! name.startsWith("#") && ! name.equals("")) {
			emptyfile = false;
			if (name.equals(ExCommCipher.PlainText)
			    || ExCipherTable.getCipher(name) != null) {
			    list.addElement(name);
			    Executor.debug(CN, "readCipherFile", name);
			}
		    }
		}
	    } catch (IOException e) {
		Executor.syslog(CN, "readCipherFile",
				"IOException while reading " + cipherFile, e);
		throw new ExCommCipherException("read error: " + cipherFile);
	    } finally {
		try {
		    distream.close();
		} catch (IOException e) {
		    // ignore
		}
	    }
	    /*
	    空の .cipher ファイルがあったらどっちに解釈すべきか？
	    現在は、安全側を選択している。
	    .cipher がないとみなすべきならば、以下の if 文を活かせばよい。
	    if (emptyfile) {
		Executor.debug(CN, "readCipherFile",
			       cipherFile.getPath() + " is empty");
		return ExCipherTable.CipherName;
	    } else {
	    */
		String[] cellCipherList = new String[list.size()];
		list.copyInto(cellCipherList);
		return cellCipherList;
	    //}
	} else {
	    Executor.debug(CN, "readCipherFile",
			   cipherFile.getPath() + "doesn't exist");
	    return ExCipherTable.CipherName;
	}
    }
}
