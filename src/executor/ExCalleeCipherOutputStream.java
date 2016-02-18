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
 * $Id: ExCalleeCipherOutputStream.java,v 2.4 1997/12/25 00:45:28 xsun Exp $
 */
package JP.go.ipa.oz.system;

import java.io.*;
import java.net.*;
import java.util.*;
/* Jan. 25th, 1998 added by Nishioka */
import java.lang.reflect.*;

/***
 * ObjectOutputStream for CalleeChannel.
 * @version		$Revision: 2.4 $, $Date: 1997/12/25 00:45:28 $
 * @author		Yoichi Hamazaki
*/
final class ExCalleeCipherOutputStream {
    private String CN="ExCalleeCipherOutputStream";

    /*
     * These three fields (CipherType, CipherName and cipher) are not private,
     * only for the ExRemoteCalleeChannel.
     */
    int CipherType;
    String CipherName;
    OzCipher cipher;

    private String calleeGol;
    private String callerGol;
    private String[] CipherList;
    private OzProxy proxy;

    private ExObjectOutputStream oostream;

    /**
     * construct with destination and other parameters.
     * @param stream ObjectOutputStream
     */
    ExCalleeCipherOutputStream(ExObjectOutputStream stream,
			       OzProxy calleeProxy, String callerGol) {
        oostream = stream;
        this.CipherType = ExCommCipher.CipherStart;
        this.calleeGol = calleeProxy.getName();
        this.callerGol = callerGol;
	this.proxy=calleeProxy;
    }

    /**
     * ストリームに暗号化情報を書き、objを書き込む
     *
     * @param obj 暗号化するオブジェクト
     */
    final void writeObject(Object obj)
    throws IOException, ExCommException, ExException {
	int listsu;
	OzCipher c;
	String name;

	switch (this.CipherType) {
	    // 交渉開始;
	  case ExCommCipher.CipherStart:
	    Executor.debug(CN, "writeObject", "CipherStart");

	    this.CipherList = ExCommCipher.getCellCipherList(callerGol);
	    listsu = this.CipherList.length;

	    name = ExCommCipher.checkCache(callerGol, proxy);
	    c = null;
	    if (name != null
		&& (name.equals(ExCommCipher.PlainText)
		    || (c = ExCipherTable.getCipher(name)) != null)) {
		// キャッシュされていた認証システムで暗号化して送信;
		// でも、キャッシュが古い場合に備えて、リストも送っとく;
		this.CipherType = ExCommCipher.Cache;
		this.CipherName = name;
		oostream.writeInt(this.CipherType);
		oostream.writeInt(listsu);
		writeList(this.CipherList);

		Executor.debug(CN, "writeObject", "Cached cipher: " + name);

		oostream.writeUTF(name);
		if (name.equals(ExCommCipher.PlainText)) {
		    oostream.writeObject(obj);
		} else {
		    ExGOL calleeGolObject = new ExGOL(calleeGol);
		    this.cipher = c.invoke(calleeGolObject.getHome());
		    oostream.writeObject(this.cipher.getCredential());
		    oostream.writeObject(this.cipher.encode(obj));
		    this.CipherType = ExCommCipher.Cryptogram;
		}
	    } else {
		// キャッシュはなかったので、リストを送って交渉開始;
		this.CipherType = ExCommCipher.NegotiationStart;
		oostream.writeInt(this.CipherType);
		oostream.writeInt(listsu);
		writeList(this.CipherList);
	    }
	    break;

	    // 平文送信;
	  case ExCommCipher.Plain:
	    this.CipherName = ExCommCipher.PlainText;
	    oostream.writeInt(this.CipherType);
	    oostream.writeObject(obj);
	    Executor.debug(CN, "writeObject", "plain: sent");
	    break;

	    // 暗号文;
	  case ExCommCipher.Cryptogram:
	    Executor.debug(CN, "writeObject", "Cryptogram");

	    if (this.CipherName.equals(ExCommCipher.PlainText)) {
		oostream.writeInt(ExCommCipher.Plain);
		oostream.writeObject(obj);
	    } else {
		Executor.debug(CN, "writeObject", "Cryptogram Cipher");

		oostream.writeInt(ExCommCipher.Cryptogram);

		ExGOL calleeGolObject = new ExGOL(calleeGol);
		this.cipher = ExCipherTable.getCipher(this.CipherName);
		if (this.cipher == null) {
		    throw new ExCommException("unavailable cryptosystem: "
					      + this.CipherName);
		}
		this.cipher = this.cipher.invoke(calleeGolObject.getHome());
		oostream.writeObject(this.cipher.getCredential());
		oostream.writeObject(this.cipher.encode(obj));
		oostream.flush();
		Executor.debug(CN, "writeObject", "Cryptogram Cipher end");
	    }
	    break;

	  default:
	    Executor.syslog(CN, "writeObject",
			    "Negotiation Protocol Error. CipherType: "
			    + this.CipherType);
	    throw new ExCommCipherException("Negotiation Protocol Error");
	}
	Executor.debug(CN, "writeObject", "Type = " + this.CipherType);
	Executor.debug(CN, "writeObject", "Name = " + this.CipherName);
    }

    private void writeList(String[] list) throws IOException {
	int len = list.length;
	for (int i = 0; i < len; i ++) {
	    String n = list[i];
	    oostream.writeUTF(n);
	    Executor.debug(CN, "writeList", "name: " + n);
	}
    }
}
