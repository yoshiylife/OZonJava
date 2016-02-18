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
 * $Id: ExCipherTable.java,v 2.3 1997/12/22 06:50:26 xsun Exp $
 */
package JP.go.ipa.oz.system;

import java.io.*;
import java.util.*;
import java.net.*;
import java.lang.reflect.*;

/***
 * このクラスは、そのマシンで使用可能な認証システムの
 * 認証システムオブジェクトを表形式で保持している。
 *
 * @see ExSendPort
 *
 * @version		$Revision: 2.3 $, $Date: 1997/12/22 06:50:26 $
 * @author		Tadayuki Higuchi
 * @author              Y.Hamazaki
 * @author		Tadayuki Higuchi(revised by Y.Hamazaki)
 * @author		Toshihiro Nishioka
 */
final class ExCipherTable {
    private static String CN = "ExCipherTable";

    /**
     * name of host where the executor working.
     */
    private static String HostName;
    static {
	try {
	    String host = InetAddress.getLocalHost().getHostName();
	    /* Jan. 28th, 1998.  added by Nishioka (trimming the HostName) */
	    int i = host.indexOf('.');
	    if (i > 0) {
		ExCipherTable.HostName = host.substring(0, i);
	    } else {
		ExCipherTable.HostName = host;
	    }
	} catch (IOException e) {
	    Executor.message(CN, "<clinit>", "cannot get hostname", e);
	    throw new Error("cannot get hostname");
	}
    }

    /**
     * Hashtable of Ciphers.
     * Name of the cipher is key, and the cipher object is value 
     */ 
    private static final Dictionary CipherTable = getMachineCipherList();

    /**
     * Hashtable of Cipher's names.
     * Integer is key, and the name of the cipher is value.
     * 0 is always for the plain text.
     */
    static String[] CipherName;

    /**
     * このマシンで使用可能な認証システムのリストを、
     * $OZHOME/etc/encoders/<machine>.cipher から読み込み、
     * それらの認証システムオブジェクトをロードして初期化し、表にして返す。
     * ExCipherTable.CipherName に、
     * 初期化できた認証システムのリストをセットする。
     * ExCipherTable.CipherName の最初の要素は、
     * 常に ExCommCipher.PlainText である。
     *
     * @return	このマシンで使用可能な認証システムオブジェクトの表を返す。
     */
    private static final synchronized Dictionary getMachineCipherList() {
	String fs = File.separator;
	String etc
	  = System.getProperty("oz.home") + fs + "etc" + fs + "encoders";
	File directory = new File(etc);
	File cipher = new File(directory, ExCipherTable.HostName + ".cipher");
    
	Dictionary cipherList = new Hashtable();
    	if (cipher.exists() == true) {
	    try {
		BufferedReader br = new BufferedReader(new FileReader(cipher));
		Vector list = new Vector();
		String cipherName;
		list.addElement(ExCommCipher.PlainText);
		while ((cipherName = br.readLine()) != null) {
		    cipherName = cipherName.trim();
		    if (! cipherName.equals("") && ! cipherName.startsWith("#")
			&& ! cipherName.equals(ExCommCipher.PlainText)) {
			Executor.debug(CN, "getMachineCipherList",
				       "Adding " + cipherName);
			/* 認証オブジェクトの初期化に成功したものだけ格納 */
			try {
			    OzCipher Cipher = OzCipher.getCipher(cipherName);
			    Cipher.init();
			    cipherList.put(cipherName, Cipher);
			    list.addElement(cipherName);
			} catch (Exception ex) {
			    Executor.syslog(CN, "getMachineCipherList",
					    "Unavailable cryptosystem "
					    + cipherName, ex );
			}
		    }
		}
		ExCipherTable.CipherName = new String[list.size()];
		list.copyInto(ExCipherTable.CipherName);
		br.close();
	    } catch (IOException e) {
		throw new Error("IO Error in reading " + cipher.getPath());
	    }
	} else {
	    /* no $OZHOME/etc/encoders/<machine>.cipher:
	       only plain text available */
	    ExCipherTable.CipherName = new String[1];
	    ExCipherTable.CipherName[0] = ExCommCipher.PlainText;
	}
	return cipherList;
    }
  
    /**
     * Get Cipher object with cipher's name as key.
     *
     * @param  cipherName:  Cipher's name
     * @return An cipher object whose name is cipherName.
     *
     */
    static final OzCipher getCipher(String cipherName) {
	return (OzCipher)ExCipherTable.CipherTable.get(cipherName);
    }
}
