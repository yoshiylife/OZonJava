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
 * $Id: ExCallerCipherInputStream.java,v 2.4 1997/12/25 00:45:28 xsun Exp $
 */
package JP.go.ipa.oz.system;

import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.*;

/***
 * ObjectInputStream for CallerChannel.
 * @version		$Revision: 2.4 $, $Date: 1997/12/25 00:45:28 $
 * @author		Yoichi Hamazaki
*/
final class ExCallerCipherInputStream {
    private String CN="ExCallerCipherInputStream";

    /*
     * These three fields (CipherType, CipherName and cipher) are not private,
     * only for the ExRemoteCallerChannel to pass them from InputStream to
     * OutputStream.
     */
    int CipherType;
    String CipherName;
    OzCipher cipher;

    private String calleeGol;
    private ExObjectInputStream oistream;
  
    /**
     * construct with destination and other parameters.
     *
     * @param stream ObjectInputStream
     */
    ExCallerCipherInputStream(ExObjectInputStream stream, String calleeGol) {
        oistream = stream;
        this.CipherType = ExCommCipher.Plain;
        this.calleeGol = calleeGol;
    }

    final Dictionary readList(ExObjectInputStream oistream)
    throws IOException, ClassNotFoundException {
	Dictionary list = new Hashtable();
	int listsu = oistream.readInt();
	for (int i = 0; i < listsu; i++) {
	    String name = (String)oistream.readUTF();
	    list.put(name, new Integer(1));
	    Executor.debug(CN, "readList", name);
	}
	return list;
    }

    /**
     * ���ȥ꡼��˰Ź沽�����񤭡�obj��񤭹���
     *
     * @return Object �ƤӽФ��줿���֥�������
     */
    final Object readObject() throws Exception {
	String      name;
	Dictionary  callerList;
	Object      Text;
	OzCipher    Cipher;
	ByteArrayOutputStream bostream;
	ByteArrayInputStream  bistream;
	ExObjectInputStream   oiStream;
	byte        buf[];
	int         listsu;
	int         pattern;
	int         counter;
	String[]    cellList;

	Executor.debug(CN, "readObject", ":start");

	Text = null;
	pattern = oistream.readInt();
	switch (pattern) {
	    // ʿʸ;
	  case ExCommCipher.Plain:
	    /* Feb. 20th, 1998.  replaced by Nishioka */
	    cellList = ExCommCipher.getCellCipherList(calleeGol);
	    int len = cellList.length;
	    for (int i = 0; i < len; i ++) {
		if (cellList[i].equals(ExCommCipher.PlainText)) {
		    Executor.debug(CN, "readObject", "accept plain");
		    this.CipherType = ExCommCipher.Plain;
		    this.CipherName = ExCommCipher.PlainText;
		    Text = oistream.readObject();
		    break;
		}
	    }
	    if (Text == null) {
		// ʿʸ������Ĥ��Ƥ�������������ϼ����Ȥ�ʤ��ΤǸ�ļ���;
		Executor.debug(CN, "readObject", "reject plain");
		this.CipherType = ExCommCipher.NegotiationStop;
		// ����Ǥ����ä������ä���Τ��ɤޤ�������ʤ�;
		oistream.readObject();
	    }
	    /*
	    CipherType = ExCommCipher.Plain;
	    CipherName = ExCommCipher.PlainText;
	    Text = oistream.readObject();
	    */
	    break;

	    // ��ĳ���;
	  case ExCommCipher.NegotiationStart:
	    Executor.debug(CN, "readObject", "negotiation start");
	    callerList = readList(oistream);
	    cellList = ExCommCipher.getCellCipherList(calleeGol);
	    listsu = cellList.length;
	    this.CipherName = null;
	    for (int i = 0; i < listsu; i ++) {
		name = cellList[i];
		if (callerList.get(name) != null) {
		    Executor.debug(CN, "readObject",
				   "negotiation OK name = " + name);
		    this.CipherName = name;
		    this.CipherType = ExCommCipher.Result;
		    break;
		} else {
		    Executor.debug(CN, "readObject",
				   "negotiation NG name = " + name);
		}
	    }
	    if (this.CipherName == null) {
		// �����ޤ��褿���Ĥμ���;
		this.CipherType = ExCommCipher.NegotiationStop;
	    }
	    Executor.debug(CN, "readObject",
			   "End of negotiation: type " + this.CipherType);
	    break;

	    // ����;
	  case ExCommCipher.Cryptogram:
	    Executor.debug(CN, "readObject", "Cryptogram");
	    this.CipherType = ExCommCipher.Cryptogram;
	    buf = (byte[])oistream.readObject();
	    if ((cipher = ExCipherTable.getCipher(this.CipherName)) == null) {
		throw new ExCommException("unavailable cryptosystem: "
					  + this.CipherName);
	    }
	    this.cipher = this.cipher.invoke(buf);
	    Text = this.cipher.decode((byte[])oistream.readObject());
	    break;

	    // ����å���;
	  case ExCommCipher.Cache:
	    Executor.debug(CN, "readObject", ":Cache");

	    callerList = readList(oistream);
	    this.CipherName = null;
	    name = oistream.readUTF();
	    cellList = ExCommCipher.getCellCipherList(calleeGol);
	    listsu = cellList.length;
	    for (int i = 0; i < listsu; i ++) {
		if (name.equals(cellList[i])) {
		    // �ޥå�����;
		    this.CipherName = name;
		    this.CipherType = ExCommCipher.Cryptogram;
		    if (this.CipherName.equals(ExCommCipher.PlainText)) {
			Text = oistream.readObject();
		    } else {
			buf = (byte[])oistream.readObject();
			this.cipher = ExCipherTable.getCipher(this.CipherName);
			if (this.cipher == null) {
			    throw
			      new ExCommException("unavailable cryptosystem: "
						  + this.CipherName);
			}
			this.cipher = this.cipher.invoke(buf);
			Text
			  = this.cipher.decode((byte[])oistream.readObject());
		    }
		    break;
		}
	    }
	    if (this.CipherName == null) {
		// �ޥå����ʤ��ä�;
		// �Ǥ⡢�����ä���ΤϤ��礦���ʤ������ɤ߼ΤƤ�;
		if (! name.equals(ExCommCipher.PlainText)) {
		    // ʿʸ����ʤ��Ȥ��ϡ�����ǥ󥷥�뤬��Ƥ뤫�顢;
		    // ������ɤ߼ΤƤ�;
		    oistream.readObject();
		}
		oistream.readObject();
		for (int i = 0; i < listsu; i ++) {
		    name = cellList[i];
		    if (callerList.get(name) != null) {
			this.CipherName = name;
			this.CipherType = ExCommCipher.Result;
			break;
		    }
		}
		if (this.CipherName == null) {
		    // �����ޤ��褿���Ĥμ���;
		    this.CipherType = ExCommCipher.NegotiationStop;
		}
	    }
	    break;

	  default:
	    Executor.syslog(CN, "readObject", "Negotiation Protocol Error");
	    Executor.debug(CN, "readObject",
			   "CipherType = " + this.CipherType);
	    throw new ExCommCipherException(CN
					    + " Negotiation Protocol Error");
	}
	Executor.debug(CN, "readObject", "end Type = " + this.CipherType);
	Executor.debug(CN, "readObject", "end Name = " + this.CipherName);
	return Text;
    }
}
