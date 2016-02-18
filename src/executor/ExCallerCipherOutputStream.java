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

import java.io.*;
import java.net.*;
import java.util.*;

/***
* ObjectOutputStream with cipher type negotiation and encryption
* for ExRemoteCallerChannel.
*
* @see ExRemoteCallerChannel
* @see ExCalleeCipherInputStream 
* 
* @author Tadayuki Higuchi
* @author Yoichi Hamazaki
*/
final class ExCallerCipherOutputStream {
    private String CN="ExCallerCipherOutStream";

    /*
     * These three fields (CipherType, CipherName and cipher) are not private,
     * only for the ExRemoteCallerChannel to pass them from InputStream to
     * OutputStream.
     */
    int CipherType;
    String CipherName;
    OzCipher cipher;

    private ExObjectOutputStream oostream;
  
    /**
     * construct with destination and other parameters.
     * @param stream ObjectOutputStream
     */
    ExCallerCipherOutputStream(ExObjectOutputStream stream) {
        oostream = stream;
        this.CipherType = ExCommCipher.Plain;
    }

    /**
     * ストリームに暗号化情報を書き、objを書き込む
     *
     * @param obj 暗号化するオブジェクト
     */
    final void writeObject(Object obj) throws IOException,ExCommException {
	OzCipher Cipher;

	switch (this.CipherType) {

	    // 平文送信;
	  case ExCommCipher.Plain:
	    Executor.debug(CN, "writeObject", "Plain:caller end");
	    this.CipherName = ExCommCipher.PlainText;
	    oostream.writeInt(this.CipherType);
	    oostream.writeObject(obj);
	    break;

	    // 交渉の中止;
	  case ExCommCipher.NegotiationStop:
	    Executor.debug(CN, "writeObject", "NegotiationStop");

	    oostream.writeInt(this.CipherType);
	    break;

	    // 暗号化方式;
	  case ExCommCipher.Result:
	    Executor.debug(CN, "writeObject", "Result");
	    oostream.writeInt(this.CipherType);
	    oostream.writeUTF(this.CipherName);
	    Executor.debug(CN, "writeObject",
			   "Result type = " + this.CipherType);
	    Executor.debug(CN, "writeObject",
			   "Result Name = " + this.CipherName);
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
		oostream.writeObject(this.cipher.encode(obj));
		Executor.debug(CN, "writeObject", "Cryptogram Cipher end");
	    }
	    break;

	    // 交渉正常終了;
	  case ExCommCipher.NegotiationOk:
	    oostream.writeInt(ExCommCipher.NegotiationOk);
	    break;

	  default:
	    Executor.syslog(CN, "writeObject", "Negotiation Protocol Error");
	    Executor.debug(CN, "writeObject",
			   "CipherType = " + this.CipherType);
	    throw new ExCommCipherException(CN
					    + " Negotiation Protocol Error");
	}
    }
}
