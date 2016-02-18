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
 * $Id$
 */

package JP.go.ipa.oz.crypt.rotate;
import java.io.*;
import java.util.Date;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import JP.go.ipa.oz.system.OzSystem;
import JP.go.ipa.oz.system.OzCipher;
import JP.go.ipa.oz.system.OzKey;
import JP.go.ipa.oz.system.OzCipherException;

/**
 * <code>OzRotateKey</code> holds key of <code>OzRotateCipher</code>
 * cryptosystem.
 *
 * @version             $Revision$, $Date$
 * @author              Nishioka Toshihiro
 * @see			JP.go.ipa.oz.system.OzCipher
 * @see 		JP.go.ipa.oz.system.OzKey
 */

final public class OzRotateKey extends OzKey implements java.io.Serializable {
    /**
     * Message digest object to generate key from string.
     */
    private static final String messageDigestName = "MD5";
    private static MessageDigest md;
    static {
	try {
	    md = MessageDigest.getInstance(messageDigestName);
	} catch (NoSuchAlgorithmException e) {
	    throw new NoClassDefFoundError("Message Digest Class: "
					   + messageDigestName);
	}
    }

    /**
     * The length of the key string.
     */
    private static final int keyLength = 16;

    /**
     * Key string comprised of 64 characters each of which is `0' or `1'.
     */
    private byte[] encodekey;
    private byte[] decodekey;

    /**
     * Expiration date of this key.
     * If no expiration date is specified, this field should be null.
     */
    private Date expirationDate;

    /**
     * Constructor for creating OzRotateKey object by specified key.
     * 
     * @param key Specified key in <code>String</code>
     */
    OzRotateKey(byte[] key) throws OzCipherException {
	this.encodekey = key;
	checkKey();
    }

    /**
     * Constructor for creating OzRotateKey object by specified key and its
     * expiration date.
     * 
     * @param	key		Specified key in <code>String</code>
     * @param	expirationDate	the expiration date of the key
     */
    OzRotateKey(byte[] key, Date expirationDate) throws OzCipherException{
	this.encodekey = key;
	this.expirationDate = expirationDate;
	checkKey();
    }

    /**
     * Constructor for creating OzRotateKey object by specified key and its
     * expiration date.
     * 
     * @param	key		Specified key in <code>OzRotateKey</code>
     * @param	expirationDate	the expiration date of the key
     */
    OzRotateKey(OzRotateKey key, Date expirationDate)
    throws OzCipherException {
	this.encodekey = key.encodekey;
	this.expirationDate = expirationDate;
	checkKey();
    }

    /**
     * Checks if the key string is in appropriate format.
     */
    private void checkKey() throws OzCipherException {
	if (this.encodekey.length != OzRotateKey.keyLength) {
	    String m
	      = "Wrong key length: " + String.valueOf(OzRotateKey.keyLength)
		+ "bytes required: " + this.encodekey.length;
	    throw new OzCipherException(m);
	}
	if (isExpired()) {
	    throw new OzCipherException("key expired: " + expirationDate);
	}
	this.decodekey = new byte[OzRotateKey.keyLength];
	for (int i = 0; i < OzRotateKey.keyLength; i ++) {
	    this.decodekey[i] = (byte)-this.encodekey[i];
	}
    }

    /**
     * Creates a key from a password.
     */
    public static OzRotateKey genKey(String password) {
	try {
	    return new OzRotateKey(md.digest(password.getBytes()));
	} catch (OzCipherException e) {
	    e.printStackTrace(System.err);
	    throw new Error("Wrong Message Digest: " + md);
	}
    }

    /**
     * Returns cipher object corresponding to this key.
     */
    public OzCipher getCipher() {return new OzRotateCipher();}

    /**
     * Returns expiration date.
     */
    public Date getExpirationDate() {return expirationDate;}

    /**
     * Check if this key is expired.
     */
    boolean isExpired() {
	if (this.expirationDate == null) {
	    return false;
	} else {
	    return new Date().after(this.expirationDate);
	}
    }

    /**
     * Check if two key is same.
     */
    public boolean isEqualKey(OzKey key) {
	if (key instanceof OzRotateKey) {
	    for (int i = 0; i < OzRotateKey.keyLength; i ++) {
		if (this.encodekey[i] != ((OzRotateKey)key).encodekey[i]) {
		    return false;
		}
	    }
	    return true;
	} else {
	    return false;
	}
    }

    /**
     * Rotate encryption method. Data coming from specified
     * <code>InputStream</code> is encrypted using OzKey and sent through
     * specified <code>OutputStream</code>.<br>
     * 
     * @param is Specified InputStream that data coming from
     * @param os Specified OutputStream that encrypted data sending through
     *
     * @excepiton OzCipherException if an error occurs during encryption
     */
    public void encode(InputStream is, OutputStream os) 
    throws OzCipherException {
	code(is, encodekey, os);
    }

    /**
     * Rotate decryption method. Data encrypted by
     * <code>OzRotateCipher#encode</code> coming from specified
     * <code>InputStream</code> is decrypted using OzKey and sent through
     * specified <code>OutputStream</code>.<br>
     *
     * @param is Specified InputStream that data coming from
     * @param os Specified OutputStream that decrypted data is sending through
     * @excepiton OzCipherException if an error occurs during decryption
     * @see JP.go.ipa.oz.system.OzKey
     */
    public void decode(InputStream is, OutputStream os)
    throws OzCipherException {
	code(is, decodekey, os);
    }

    private void code(InputStream is, byte[] key, OutputStream os) 
    throws OzCipherException {
	try {
	    int len;
	    int keyp = 0;
	    byte[] buffer = new byte[OzRotateKey.keyLength];
	    while ((len = is.read(buffer, 0, OzRotateKey.keyLength)) != -1) {
		int buffp = 0;
		while (len > 0) {
		    int rest = OzRotateKey.keyLength - keyp;

		    if (len > rest) {
			code(buffer, buffp, key, keyp, rest);
			keyp = 0;
			buffp += rest;
			len -= rest;
		    } else {
			code(buffer, buffp, key, keyp, len);
			keyp += len;
			buffp += len;
			len = 0;
		    }
		}
		os.write(buffer, 0, buffp);
	    }
	} catch (IOException e) {
//tentative;
e.printStackTrace();
	    throw
	      new OzCipherException("IO exception while encoding/decoding");
	}
    }

    void code(byte[] buffer, int buffp, byte[] key, int keyp, int len) {
	for (int i = 0; i < len; i ++) {
	    buffer[buffp + i] += key[keyp + i];
	}
    }

    public byte[][] showKey() {
	byte[][] b = new byte[2][];
	b[0] = this.encodekey;
	b[1] = this.decodekey;
	return b;
    }
}
