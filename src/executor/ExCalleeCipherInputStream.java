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

import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.*;

/***
* ObjectInputStream with cipher type negotiation and decryption
*  for ExRemoteCalleeChannel.
*
* @see ExRemoteCalleeChannel
* @see ExCallerCipherOutputStream 
* 
* @author Tadayuki Higuchi
* @author Yoichi Hamazaki
*/
final class ExCalleeCipherInputStream {
    private String CN="ExCalleeCipherInStream";

    /*
     * These three fields (CipherType, CipherName and cipher) are not private,
     * only for the ExRemoteCalleeChannel.
     */
    int CipherType;
    String CipherName;
    OzCipher cipher;

    private ExObjectInputStream oistream;

    /**
     * construct with destination and other parameters.
     * @param stream ObjectInputStream
     */
    ExCalleeCipherInputStream(ExObjectInputStream stream) {
        oistream = stream;
        this.CipherType = ExCommCipher.Plain;
    }

    /**
     * ���ȥ꡼��˰Ź沽�����񤭡�obj��񤭹���
     *
     * @return Object �ƤӽФ��줿���֥�������
     */
    final Object readObject() throws Exception {
	Object      Text;
	OzCipher    Cipher;
	ByteArrayOutputStream bostream;
	ByteArrayInputStream  bistream;
	ExObjectInputStream   oiStream;
	byte        buf[];
	int         pattern;

	Executor.debug(CN, "readObject", ":strat " );

	Text = null;
	pattern = oistream.readInt();

	Executor.debug(CN, "readObject", ":Pattern = " + pattern);

	switch (pattern) {
	    // ʿʸ;
	  case ExCommCipher.Plain:
	    Executor.debug(CN, "readObject", ":Plain");

	    this.CipherType = ExCommCipher.Plain;
	    this.CipherName = ExCommCipher.PlainText;
	    Text = oistream.readObject();
	    break;

	    // ��Ĥ����;
	  case ExCommCipher.NegotiationStop:
	    Executor.debug(CN, "readObject", "NegotiationStop");
	    this.CipherType = ExCommCipher.NegotiationStop;
	    break;

	    // ���;
	  case ExCommCipher.Result:
	    Executor.debug(CN, "readObject", "Result");

	    this.CipherName = oistream.readUTF();
	    if (this.CipherName.equals(ExCommCipher.PlainText)) {
		this.CipherType = ExCommCipher.Plain;
	    } else {
		this.CipherType = ExCommCipher.Cryptogram;
	    }
	    break;

	    // ����;
	  case ExCommCipher.Cryptogram:
	    Executor.debug(CN, "readObject", ":Cryptogram ");
	    this.CipherType = ExCommCipher.Cryptogram;
	    Text = this.cipher.decode((byte[])oistream.readObject());
	    Executor.debug(CN, "readObject", ":Cryptogram  end ");
	    break;

	    // ������ｪλ;
	  case ExCommCipher.NegotiationOk:
	    this.CipherType = ExCommCipher.NegotiationOk;
	    Text = new Integer(ExCommCipher.NegotiationOk);
	    break;

	  default:
	    Executor.syslog(CN, "readObject", "Negotiation Protocol Error");
	    Executor.debug(CN, "readObject",
			   "CipherType = " + this.CipherType);
	    throw new ExCommCipherException(CN
					    + " Negotiation Protocol Error");
	}
	Executor.debug(CN, "readObject", ":end Type = " + this.CipherType);
	Executor.debug(CN, "readObject", ":end Name = " + this.CipherName);
	return Text;
    }
}
