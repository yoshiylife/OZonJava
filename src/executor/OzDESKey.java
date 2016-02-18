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
 * $Id: OzDESKey.java,v 1.1 1998/01/08 04:38:02 xsun Exp $ 
 */

package JP.go.ipa.oz.crypt.DES;
import java.io.*;
import java.util.Date;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import JP.go.ipa.oz.system.OzSystem;
import JP.go.ipa.oz.system.OzCipher;
import JP.go.ipa.oz.system.OzKey;
import JP.go.ipa.oz.system.OzCipherException;

/**
 * <code>OzDESKey</code> holds key of <code>OzDESCipher</code> cryptosystem.
 *
 * @version	1.1, 11/26/97
 * @author	Sun Xiao
 * @see		JP.go.ipa.oz.system.OzDESCipher
 * @see 	JP.go.ipa.oz.system.OzKey
 */

final public class OzDESKey extends OzKey implements java.io.Serializable {
    /**
     * Message digest object to generate key from string.
     */
    private static String messageDigestName = "MD5";
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
    private static int keyStringLength = 64; // this must be a multiple of 8
    private static int keyByteLength = keyStringLength / 8;

    /**
     * Key string comprised of 64 characters each of which is `0' or `1'.
     */
    private String DESKey;

    /**
     * Expiration date of this key.
     * If no expiration date is specified, this field should be null.
     */
    private Date expirationDate;

    /**
     * Constructor for creating OzDESKey object by specified key.
     * 
     * @param key Specified key in <code>String</code>
     */
    OzDESKey(String key) throws OzCipherException {
	this.DESKey = key;
	checkDESKey();
	// System.out.println("OzDESKey(String key): " + this.DESKey);
    }

    /**
     * Constructor for creating OzDESKey object by specified key and its
     * expiration date.
     * 
     * @param	key		Specified key in <code>String</code>
     * @param	expirationDate	the expiration date of the key
     */
    OzDESKey(String key, Date expirationDate) throws OzCipherException{
	this.DESKey = key;
	this.expirationDate = expirationDate;
	checkDESKey();
	// System.out.println("OzDESKey(String key, Date date): " + this.DESKey);
    }

    /* Feb. 14th, 1998 added by Nishioka */
    /**
     * Constructor for creating OzDESKey object by specified key and its
     * expiration date.
     * 
     * @param	key		Specified key in <code>OzDESKey</code>
     * @param	expirationDate	the expiration date of the key
     */
    OzDESKey(OzDESKey key, Date expirationDate) throws OzCipherException {
	this.DESKey = key.DESKey;
	this.expirationDate = expirationDate;
	checkDESKey();
	// System.out.println("OzDESKey(OzDESKey key, Date date): " + this.DESKey);
    }

    /* Feb. 14th, 1998. Method checkDESKey is added by Nishioka */
    /**
     * Checks if the key string is in appropriate format.
     */
    private void checkDESKey() throws OzCipherException {
	if (this.DESKey.length() != this.keyStringLength) {
	    throw new
	      DESKeyWrongNumberException(String.valueOf(this.keyStringLength)
					 + "digits required: " + this.DESKey);
	}
	for (int i = 0; i < this.keyStringLength; i ++) {
	    int c = this.DESKey.charAt(i);
	    if (c != '0' && c != '1') {
		String m = "Only `0' and `1' can be used: " + this.DESKey;
		throw new DESKeyWrongNumberException(m);
	    }
	}
	if (isExpired()) {
	    throw new DESKeyExpiredException(expirationDate.toString());
	}
    }

    /* Jan. 26th, 1998 added by Nishioka */
    /**
     * Creates a DES key from a password.
     */
    public static OzDESKey genKey(String password) {
	// System.out.println("password: " + password);
	byte[] digest = md.digest(password.getBytes());
	int len = digest.length;
	StringBuffer buffer = new StringBuffer("");
	String result = null;
	int i = 0;
	try {
	    if (len >= OzDESKey.keyByteLength) {
		for (; i < OzDESKey.keyByteLength; i ++) {
		    String b = "00000000000000000000000000000000"
		      + Integer.toBinaryString(digest[i]);
		    buffer.append(b.substring(b.length()-8));
		}
		result = buffer.toString();
		// System.out.println("new key generated: " + result);
		return new OzDESKey(result);
	    } else {
		for (; i < len; i ++) {
		    String b = "00000000000000000000000000000000"
		      + Integer.toBinaryString(digest[i]);
		    buffer.append(b.substring(b.length()-8));
		}
		for (; i < OzDESKey.keyByteLength; i *= 2) {
		    buffer.append(result.toString());
		}
		result
		  = buffer.toString().substring(0, OzDESKey.keyStringLength);
		// System.out.println("new key generated: " + result);
		return new OzDESKey(result);
	    }
	} catch (OzCipherException e) {
	    e.printStackTrace(System.err);
	    throw new Error("Wrong Message Digest: " + result);
	}
    }

    /**
     * Returns cipher object corresponding to this key.
     */
    public OzCipher getCipher() {return new OzDESCipher();}

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
	if (key instanceof OzDESKey) {
	    return this.DESKey.equals(((OzDESKey)key).DESKey);
	} else {
	    return false;
	}
    }

    /* Feb. 14th, 1998 added by Nishioka */
    /**
     * DES encryption method. Data coming from specified
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
	byte h1[] = new byte[1];
	int  k1[] = new int[64];
	byte b[]  = new byte[8];
	byte ch[] = new byte[8];
	byte data_len[] = new byte[3];
	int i;

	DataInputStream dis;
	DataOutputStream dos;

	if (is instanceof DataInputStream) {
	    dis = (DataInputStream)is;
	} else {
	    dis = new DataInputStream(is);
	}
	if (os instanceof DataOutputStream) {
	    dos = (DataOutputStream)os;
	} else {
	    dos = new DataOutputStream(os);
	}

	try {
	    int c, h;

	    for (i = 0; i < 63; i ++){
		k1[i] = Character.getNumericValue(DESKey.charAt(i));
	    }

	    h = is.available();
	    int a, sum, n256, n8, n1; 

	    if (h == 8) {
		data_len[0] = 0;    /*  n256  */
		data_len[1] = 1;    /*  n8    */
		data_len[2] = 0;    /*  n1    */
	    } else if (h<8) {
		data_len[0] = 0;
		data_len[1] = 1;
		data_len[2] = (byte)h;
	    } else {
		a = h / 8;
		if ((h - a * 8) > 0) {
		    sum = a + 1;
		} else {
		    sum = a;
		}

		if ((sum * 8) == 256) {
		    data_len[0] = 1;
		    data_len[1] = 0;
		    data_len[2] = (byte)(h - a * 8);
		} else if ((sum * 8) < 256) {
		    data_len[0] = 0;
		    data_len[1] = (byte)sum;
		    data_len[2] = (byte)(h - a * 8);
		} else {
		    n256 = h / 256;
		    data_len[0] = (byte)n256;
		    n8 = sum - n256 * 256 / 8;
		    data_len[1] = (byte)n8;
		    n1 = h - a * 8;
		    data_len[2] = (byte)n1;
		}
	    }
	    os.write(data_len, 0, 3);

	    /* encryption  is made block by block  .
	       every block includes 8 bytes. */
	    int q = 1;
	    while (h >= 8) {
		dis.readFully(b, 0, 8);
		encal(b, k1, ch);
		dos.write(ch, 0, 8);
		h = is.available();
		q ++;
	    }

	    /* encryption is made block by block.
	       left bytes (less than 8 bytes) is encrypted in one block. */

	    if (h != 0) {
		for (int w = 0; w < 8; w ++) {
		    if (w < h) {
			b[w] = (byte)is.read();
		    } else {
			b[w] = 0;
		    }
		}
		encal(b, k1, ch);
		dos.write(ch, 0, 8);
	    }
	    dos.flush();
	} catch (IOException e) {
	    throw new OzCipherException("IO Exception in encoding: " + e);
	}
    }

    /* Feb. 14th, 1998 added by Nishioka */
    /**
     * オブジェクトを暗号化する。
     *
     * @param	o	暗号化するオブジェクト
     * @exception	OzCipherException
     *				実行中に例外が発生した。
     */
    /*
    final byte[] encode(Object o) throws OzCipherException {
	try {
	    PipedInputStream pi = new PipedInputStream();
	    PipedOutputStream po = new PipedOutputStream(pi);
	    ObjectOutputStream out = new ObjectOutputStream(po);
	    out.writeObject(o);
	    ByteArrayOutputStream bo = new ByteArrayOutputStream();
	    encode(pi, bo);
	    return bo.toByteArray();
	} catch (Exception e) {
	    throw new OzCipherException(e.toString());
	}
    }
    */

    /**
     * calculation.
     */
    private void encal(byte[] b, int[] k1, byte[] ch) {
  	int ch1[] = new int[8];
  	int ci1[] = new int[64];
  	int b1[]  = new int[8];
  	int a1[]  = new int[64];

	for (int i = 0; i < 8; i ++){
	    b1[i] = (int)b[i];
	}
	for (int i = 0; i < 8; i ++){
	    for (int j = 0; j < 8; j ++)
              a1[i * 8 + j] = (b1[i] >> (7 - j)) & 0x1;
	}

	/* implement the kernel encryption calculation of DES algorithm.
	   new  Des0().des(a1,k1,ci1); */

	Des0 des0 = new Des0();
	des0.des(a1, k1, ci1);

	for (int u = 0; u < 8; u ++) {
	    ch1[u] = 0;
	    for (int j = 0; j < 8; j ++) {
		ch1[u] *= 2;
		ch1[u] += ci1[u * 8 + j];
	    }
	}
   
	for (int i = 0; i < 8; i ++) {
	    ch[i] = (byte)ch1[i];
	}
    }

    /* Feb. 14th, 1998 added by Nishioka */
    /**
     * DES decryption method. Data encrypted by <code>OzDESCipher#encode</code>
     * coming from specified <code>InputStream</code> is decrypted using OzKey
     * and sent through specified <code>OutputStream</code>.<br>
     *
     * @param is Specified InputStream that data coming from
     * @param os Specified OutputStream that decrypted data is sending through
     * @excepiton OzCipherException if an error occurs during decryption
     * @see JP.go.ipa.oz.system.OzKey
     */
    public void decode(InputStream is, OutputStream os)
    throws OzCipherException {
	int k1[] = new int[64];
	byte data[] = new byte[8];
	byte ch[] = new byte[8];
	OzDESCipher des = null;
	int i;

	DataInputStream dis;
	DataOutputStream dos;
	if (is instanceof DataInputStream) {
	    dis = (DataInputStream)is;
	} else {
	    dis = new DataInputStream(is);
	}
	if (os instanceof DataOutputStream) {
	    dos = (DataOutputStream)os;
	} else {
	    dos = new DataOutputStream(os);
	}

	try {
	    for (i = 0; i < 63; i ++) {
		k1[i] = Character.getNumericValue(DESKey.charAt(i));
	    }

	    byte data_len[] = new byte[3];
	    dis.readFully(data_len, 0, 3);

	    for (i = 1; i < ((data_len[0] * 256 / 8) + data_len[1]); i ++) {
		dis.readFully(data, 0, 8);
	        dical(data,k1,ch);
		os.write(ch,0,8);	
	    }
	    if (data_len[2] == 0){
		dis.readFully(data, 0, 8);
		dical(data, k1, ch);
		os.write(ch, 0, 8);
	    } else {
		dis.readFully(data, 0, 8);
		dical(data, k1, ch);
		dos.write(ch, 0, data_len[2]);
	    }
	    dos.flush();
	} catch (IOException e) {
	    throw new OzCipherException("IO Exception in decoding: " + e);
	}
    }

    /**
     * calculation.
     */

    private void dical(byte[] b,int[] k1, byte[] ch) {
  	int ch1[] = new int[8];
  	int ci1[] = new int[64];
  	int b1[]  = new int[8];
  	int a1[]  = new int[64];

	for (int i = 0; i < 8; i ++) {
	    b1[i] = (int)b[i];
	}
	for (int i = 0; i < 8; i ++) {
	    for (int j = 0; j < 8; j ++) {
		a1[i * 8 + j] = (b1[i] >> (7 - j)) & 0x1;
	    }
	}
     
	// implement the kernel decryption calculation of DES algorithm.

	Des0 des0 = new Des0();
	des0.des_de(a1, k1, ci1);
  
	for (int i = 0; i < 8; i ++) {
	    ch1[i] = 0;
	    for (int j = 0; j < 8; j ++) {
		ch1[i] *= 2;
		ch1[i] += ci1[i * 8 + j];
	    }
	}
 
	for (int i = 0; i < 8; i ++){
	    ch[i] = (byte)ch1[i];
	}
    }
}

/***
 * Calculation class for <code>encode</code> and <code>decode</code>.
 */

class Des0{
    int InitialTr[]={58,50,42,34,26,18,10,2,60,52,44,36,28,20,12,4,62,54,46,38,
		       30,22,14,6,64,56,48,40,32,24,16,8,57,49,41,33,25,17,9,1,
		       59,51,43,35,27,19,11,3,61,53,45,37,29,21,13,5,63,55,47,
		       39,31,23,15,7},
    FinalTr[]={40,8,48,16,56,24,64,32,39,7,47,15,55,23,63,31,38,6,46,14,
                 54,22,62,30,37,5,45,13,53,21,61,29,36,4,44,12,52,20,60,28,
                 35,3,43,11,51,19,59,27,34,2,42,10,50,18,58,26,33,1,41,9,
                 49,17,57,25},
    Swap[]={33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,
	      54,55,56,57,58,59,60,61,62,63,64,1,2,3,4,5,6,7,8,9,10,11,12,13,
	      14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32},
    keyTr1[]={57,49,41,33,25,17,9,1,58,50,42,34,26,18,10,2,59,51,43,35,27,
		19,11,3,60,52,44,36,63,55,47,39,31,23,15,7,62,54,46,38,30,22,
		14,6,61,53,45,37,29,21,13,5,28,20,12,4},
    keyTr2[]={14,17,11,24,1,5,3,28,15,6,21,10,23,19,12,4,26,8,16,7,27,20,
                13,2,41,52,31,37,47,55,30,40,51,45,33,48,44,49,39,56,34,53,
                46,42,50,36,29,32},
    etr[]={32,1,2,3,4,5,4,5,6,7,8,9,8,9,10,11,12,13,12,13,14,15,16,17,16,
             17,18,19,20,21,20,21,22,23,24,25,24,25,26,27,28,29,28,29,30,
             31,32,1},
    ptr[]={16,7,20,21,29,12,28,17,1,15,23,26,5,18,31,10,2,8,24,14,32,27,3,
             9,19,13,30,6,22,11,4,25};
    int s[][]={{14,4,13,1,2,15,11,8,3,10,6,12,5,9,0,7,0,15,7,4,14,2,13,1,
		  10,6,12,11,9,5,3,8,1,1,14,8,13,6,2,11,15,12,9,7,3,10,5,0,
		  15,12,8,2,4,9,1,7,5,11,3,14,10,0,6,13},
		 {15,1,8,14,6,11,3,4,9,7,2,13,12,0,5,10,3,13,4,7,15,2,8,14,
		    12,0,1,10,6,9,11,5,0,14,17,11,10,4,13,1,5,8,12,6,9,3,2,15,
		    13,8,10,1,3,15,4,2,11,6,7,12,0,5,14,9},
		 {10,0,9,14,6,3,15,5,1,13,12,7,11,4,2,8,13,7,0,9,3,4,6,10,
		    2,8,5,14,12,11,15,1,13,6,4,9,8,15,3,0,11,1,2,2,5,10,14,7,
		    1,10,13,0,6,9,8,7,4,15,14,3,11,5,2,12},
		 {7,13,14,3,0,6,9,10,1,2,8,5,11,12,4,15,13,8,11,5,6,15,0,3,
		    4,7,2,12,1,10,14,9,10,6,9,0,12,11,7,13,15,1,3,14,5,2,8,4,
		    3,15,0,6,10,1,13,8,9,4,5,11,12,7,2,14},
		 {2,12,4,1,7,10,11,6,8,5,3,15,13,0,14,9,14,11,2,12,4,7,13,1,
		    5,0,15,10,3,9,8,6,4,2,1,11,10,13,7,8,15,9,12,5,6,3,0,14,
		    11,8,12,7,1,14,2,13,6,15,0,9,10,4,5,3},
		 {12,1,10,15,9,2,6,8,0,13,3,4,14,7,5,11,10,15,4,2,7,12,9,5,
		    6,1,13,14,0,11,3,8,9,14,15,5,2,8,12,3,7,0,4,10,1,13,11,6,
		    4,3,2,12,9,5,15,10,11,14,1,7,6,0,8,13},
		 {4,11,2,14,15,0,8,13,3,12,9,7,5,10,6,1,13,0,11,7,4,9,1,10,
		    14,3,5,12,2,15,8,6,1,4,11,13,12,3,7,14,10,15,6,3,0,5,9,2,
		    6,11,13,8,1,4,10,7,9,5,0,15,14,2,3,12},
		 {13,2,8,4,6,15,11,1,10,9,3,14,5,0,12,7,1,15,13,8,10,3,7,4,
		    12,5,6,11,0,14,9,2,7,11,4,1,9,12,14,2,0,6,10,13,15,3,5,8,
		    2,1,14,7,4,10,8,13,15,12,9,0,3,5,6,11}},
    rots[]={1,1,2,2,2,2,2,2,1,2,2,2,2,2,2,1};

    void transpose(int[] data, int[] t, int n) {
	int x[] = new int[64] ;
	int i;

	scop(data, x);
	for (i = 0; i < n; i ++) {
	    data[i] = x[t[i] - 1];
	}
    }

    void rotate(int[] key) {
	int i;
	int x[] = new int[64];

	/* Feb. 16th, 1998. replaced by Nishioka */
	System.arraycopy(key, 1, x, 0, 55);
	/*
	scop(key, x);
	for (i = 0; i < 55; i ++) {
	    x[i] = x[i + 1];
	}
	*/
	x[27] = key[0];
	x[55] = key[28];
	scop(x, key);
    }

    void f(int[] key, int[] a, int[] x) {
	int r, k, j;
	int e[]    = new int[64],
	    y[]    = new int[64];

	scop(a, e);
	transpose(e, etr, 48);
	for (j = 0; j < 48; j ++) {
	    if (e[j] + key[j] == 1) {
		y[j] = 1;
	    } else {
		y[j] = 0;
	    }
	}
	for (k = 0; k < 8; k ++) {
	    r=32*y[6*k]+16*y[6*k+5]+8*y[6*k+1]+4*y[6*k+2]+2*y[6*k+3]+y[6*k+4];
	    x[4*k]=(s[k][r]/8) % 2;
	    x[4*k+1]=(s[k][r]/4) % 2;
	    x[4*k+2]=(s[k][r]/2) % 2;
	    x[4*k+3]=s[k][r] % 2;
	}
	transpose(x, ptr, 32);
    }

    void des(int[] plaintext, int[] key, int[] ciphertext) {
	int i,j;
	int a[] = new int[64],
	    b[] = new int[64],
	    x[] = new int[64],
	    kk[] = new int[64],
	    ikey[] = new int[64];

	scop(key, kk);
	scop(plaintext, a);
	transpose(a, InitialTr, 64);
	transpose(kk, keyTr1, 56);
	for(i = 0; i < 16; i ++){
	    scop(a, b);
	    for (j = 0; j < 32; j ++) {
		a[j] = b[j + 32];
	    }
	    /* Feb. 16th, 1998. replaced by Nishioka */
	    int[] kkcopy = new int[64];
	    System.arraycopy(kk, rots[i], kkcopy, 0, 28 - rots[i]);
	    System.arraycopy(kk, 28 + rots[i], kkcopy, 28, 28 - rots[i]);
	    System.arraycopy(kk, 0, kkcopy, 28 - rots[i], rots[i]);
	    System.arraycopy(kk, 28, kkcopy, 56 - rots[i], rots[i]);
	    System.arraycopy(kkcopy, 0, kk, 0, 64);
	    /*
	    for (j = 0; j < rots[i]; j ++) {
		rotate(kk);
	    }
	    */
	    scop(kk, ikey);
	    transpose(ikey, keyTr2, 48);
	    f(ikey, a, x);
	    for (j = 0; j < 32; j ++) {
		if (b[j] + x[j] == 1) {
		    a[j + 32] = 1;
		} else {
		    a[j + 32] = 0;
		}
	    }
	}
	transpose(a, FinalTr, 64);
	scop(a, ciphertext);
    }

    void des_de(int[] ciphertext, int[] key, int[] plaintext) {
	int i, j, k;
	int a[] = new int[64],
	    b[] = new int[64],
	    x[] = new int[64],
	    kk[] = new int[64],
	    ikey[] = new int[64];

	scop(key, kk);
	scop(ciphertext, a);
	transpose(a, InitialTr, 64);
	transpose(kk, keyTr1, 56);
	for(i = 0; i < 16; i ++){
	    scop(a, b);
	    scop(kk, ikey);
	    for (j = 0; j < 16 - i; j ++) {
		/* Feb. 16th, 1998. replaced by Nishioka */
		int[] icopy = new int[64];
		System.arraycopy(ikey, rots[j], icopy, 0, 28 - rots[j]);
		System.arraycopy(ikey, 28 + rots[j], icopy, 28, 28 - rots[j]);
		System.arraycopy(ikey, 0, icopy, 28 - rots[j], rots[j]);
		System.arraycopy(ikey, 28, icopy, 56 - rots[j], rots[j]);
		System.arraycopy(icopy, 0, ikey, 0, 64);
		/*
		for (k = 0; k < rots[j]; k ++) {
		    rotate(ikey);
		}
		*/
	    }
	    transpose(ikey, keyTr2, 48);
	    f(ikey, a, x);
	    for (j = 0; j < 32; j ++) {
		a[j + 32] = b[j];
	    }
	    for (j = 0; j < 32; j ++) {
		if (b[j + 32] + x[j] == 1) {
		    a[j] = 1;
		} else {
		    a[j] = 0;
		}
	    }
	}
	transpose(a, FinalTr, 64);
	scop(a, plaintext);
    }

    private void scop(int[] a, int[] re) {System.arraycopy(a, 0, re, 0, 64);}
}
