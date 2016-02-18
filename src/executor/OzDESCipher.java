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
 * $Id: OzDESCipher.java,v 1.3 1997/12/17 01:38:21 xsun Exp $
 */

package JP.go.ipa.oz.crypt.DES;
import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.Random;
import java.security.SecureRandom;
import JP.go.ipa.oz.system.OzCipher;
import JP.go.ipa.oz.system.OzKey;
import JP.go.ipa.oz.system.OzCipherException;
import JP.go.ipa.oz.system.OzSystem;

/**
 * This <code>OzDESCipher</code> class provides methods for encryption and 
 * decryption using DES cryptosystem.
 *
 * @version             1.1, 11/28/97
 * @author              Lina Wang
 * @author              Sun Xiao
 *
 */

public final class OzDESCipher extends OzCipher {
    /* Jan. 26th, 1998 modified by Nishioka
       added "JP.go.ipa.oz.crypt.DES." */
    static String myname = "JP.go.ipa.oz.crypt.DES.OzDESCipher";
    static String CN = "OzDESCipher";

    /* Feb. 13th, 1998 added by Nishioka */
    /**
     * random generator to generate nonces.
     */
    private static Random randomGenerator = new SecureRandom();

    /* Feb. 13th, 1998 added by Nishioka */
    /* Authentication Server Configurations */
    /* URL */
    private static String AuthenticationServerProperty
      = "oz.authentication.server";
    private static URL authenticationServerURL;
    static {
	String location = System.getProperty(AuthenticationServerProperty);
	if (location == null) {
	    authenticationServerURL = null;
	} else {
	    try {
		authenticationServerURL = new URL("http://" + location + "/");
	    } catch (MalformedURLException e) {
		authenticationServerURL = null;
	    }
	}
    }
    /* Retry interval */
    private static int AuthenticationServerConnectionInterval = 1000;
    /* Retry time */
    private static int AuthenticationServerConnectionRetry = 5;

    /* Feb. 15th, 1998 added by Nishioka */
    private static String myOzHomeID = System.getProperty("oz.home.name");

    /* Feb. 14th, 1998 added by Nishioka */
    /* Canonical form of OZ home location */
    private static String myOzHomePath;
    static {
	try {
	    myOzHomePath
	      = new File(System.getProperty("oz.home")).getCanonicalPath();
	} catch (IOException e) {
	    myOzHomePath = null;
	    e.printStackTrace(System.err);
	    throw new Error("OZ home not found: "
			    + System.getProperty("oz.home"));
	}
    }

    /* Feb. 14th, 1998 added by Nishioka */
    /* secure directory at OZ home */
    private static String SecureDirectoryName = "secure";
    private static String SecureDirectoryPath
      = myOzHomePath + File.separator + SecureDirectoryName;

    /* password file location */
    private static String PasswordFileName = "password";
    private static File passwordFile
      = new File(SecureDirectoryPath + File.separator + PasswordFileName);

    /* ticket file location */
    private static String DESKeyFileName = "key.des";
    private static File ticketFile
      = new File(SecureDirectoryPath + File.separator + DESKeyFileName);

    /* The on-meomry copy of the ticket */
    private static OzDESKey ticket;

    /* Feb. 13th, 1998 added by Nishioka */
    /**
     * OzDESCipher at caller side should have credentialPack which contains
     * the session key, the expiration date of the session key and the
     * credential to be transported to the callee.
     */
    private CredentialPack credentialPack;

    /* Feb. 13th, 1998 added by Nishioka */
    /**
     * OzDESCipher at callee side should have credential which contains 
     * the caller OZ home ID, the session key and the expiration date of the
     * session key.
     */
    private Credential credential;

    /* Feb. 16t, 1998 added by Nishioka */
    /**
     * key is set if either the credentialPack or the credential is set.
     * If key is set, encode/decode method can work.
     */
    private OzDESKey key;

    /* Feb. 13th, 1998 added by Nishioka */
    /**
     * Get the on-memory copy of the ticket.
     * If no ticket is set or the ticket is expired, the ticket file is read.
     */
    protected synchronized OzKey getPrivateKey() throws OzCipherException {
	if (OzDESCipher.ticket == null) {
	    try {
		ObjectInputStream is
		  = new ObjectInputStream(new FileInputStream(ticketFile));
		OzDESCipher.ticket = (OzDESKey)is.readObject();
	    } catch (IOException e) {
		// File I/O error.  Try to login.
	    } catch (ClassNotFoundException e) {
		// Any change on key class.  Try to login.
	    }
	}
	if (OzDESCipher.ticket == null || OzDESCipher.ticket.isExpired()) {
	    OzDESCipher.ticket = login();
	    savePrivateKey();
	}
	return OzDESCipher.ticket;
    }

    /* Feb. 13th, 1998 added by Nishioka */
    /**
     * Login
     */
    private OzDESKey login() throws OzCipherException {
	OzDESKey key = OzDESKey.genKey(getPassword());
	for (int retry = 0; retry < AuthenticationServerConnectionRetry;
	     ++ retry) {
	    Socket socket;
	    DataInputStream is;
	    DataOutputStream os;
	    try {
		socket = new Socket(authenticationServerURL.getHost(),
				    authenticationServerURL.getPort());
		is = new DataInputStream(socket.getInputStream());
		os = new DataOutputStream(socket.getOutputStream());
	    } catch (IOException e) {
		OzSystem.debugPrintln("OzDESCipher#login(): IO exception. "
				      + "Retrying: " + e);
		continue;
	    }
	    try {
		/* send `LOGIN' */
		os.writeUTF("LI");
		os.writeUTF(myOzHomeID);

		/* receive the response */
		String tag = is.readUTF();
		if (tag.equals("RL")) {
		    int len = is.readInt();
		    byte[] b = new byte[len];
		    is.readFully(b);
		    TicketPack tp = (TicketPack)decode(b, key);
		    OzDESKey t = new OzDESKey((OzDESKey)tp.getTicket(),
					      tp.getExpirationDate());
		    return t;
		} else if (tag.equals("ER")) {
		    String m = "OzDESCipher#login(): Login error. Retrying.";
		    OzSystem.debugPrintln(m);
		} else {
		    String m
		      = "OzDESCipher#login(): Protocol error. Retrying.";
		    OzSystem.debugPrintln(m);
		}
	    } catch (OzCipherException e) {
		String m = "OzDESCipher#login(): Data error. Retrying: " + e;
		OzSystem.debugPrintln(m);
	    } catch (IOException e) {
		String m = "OzDESCipher#login(): IO exception. Retrying: " + e;
		OzSystem.debugPrintln(m);
	    } finally {
		try {
		    is.close();
		    os.close();
		} catch (IOException e) {
		    // Cannot do more.
		}
	    }
	    try {
		Thread.sleep(AuthenticationServerConnectionInterval);
	    } catch (InterruptedException e) {
		// No care is required on interruption.
	    }
	}
	throw
	  new OzCipherException("Cannot connect to authentication server.");
    }

    /**
     * Saves the key string and expiration date of it to a specified file.
     */
    private void savePrivateKey() throws OzCipherException {
	try {
	    FileOutputStream fos = new FileOutputStream(ticketFile);
	    ObjectOutputStream os = new ObjectOutputStream(fos);
	    os.writeObject(ticket);
	    os.close();
	} catch (Exception e) {
	    throw new OzCipherException("Cannot save private key.");
	}
    }

    /**
     * Get user password from file.
     */
    static private String getPassword() throws OzCipherException {
	try {
	    InputStream is = new FileInputStream(passwordFile);
	    int len = is.available();
	    byte b[] = new byte[len];
	    is.read(b);
	    is.close();
	    return new String(b).trim();
	} catch (FileNotFoundException e) {
	    throw new OzCipherException("Password file not found: " + e);
	} catch (IOException e) {
	    throw new OzCipherException("IO Exception while "
					+ "reading password file: " + e);
	}
    }

    /* Feb. 12th, 1998 added by Nishioka */
    /**
     * ǧ�ڤ�ȼ����⡼�ȥ᥽�åɵ�ư�θƤӽФ�¦�Υ��������塼������
     * ���������äơ��᥽�åɵ�ư��ɬ�פ��������򤵤��뤿��˸ƤӽФ�
     * ���󥿥ե�������ǧ�ڥ����ƥ४�֥������Ȥϡ������ǡ����ø���
     * ����ǥ󥷥����Ѱդ��뤳�Ȥ���Ԥ���Ƥ��롣
     *
     * @param	callee	�᥽�åɵ�ư�оݤΥ����°���Ƥ��� OZ �ۡ���� ID
     *
     * @return	getCredential() ���Ф���Ŭ�ڤ��ͤ��֤���
     *		encode(InputStream, OutputStream) /
     *		decode(InputStream, OutputStream) ��
     *		���ȥ꡼���Ź�/����Ǥ��륪�֥������ȡ�
     *		getCredential() �� encode(InputStream, OutputStream) /
     *		decode(InputStream, OutputStream) ��
     *		�ɤν���ǸƤФ�뤫������Ǥ��롣 
     */
    protected OzCipher invoke(String callee) throws OzCipherException {
	/*
	 * tentative implementation
	 * ���μ����Ϥ��ޤꤤ�������ǤϤʤ���
	 * ͭ�����¤��ڤ�Ƥ��뤫�ɤ����˷���餺��
	 * ������ credential ����˹ԤäƤ��ޤ���
	 * �����ϡ������� cache ���٤���
	 */
	long nonce = randomGenerator.nextLong();
	OzDESCipher cipher = new OzDESCipher();
	CredentialPack cp = getCredentialPack(callee, nonce);
	checkCredentialPack(cp, nonce);
	cipher.credentialPack = cp;
	cipher.key = new OzDESKey((OzDESKey)cp.getSessionKey(),
				  cp.getExpirationDate());
	return cipher;
    }

    /**
     * ǧ�ڥ����Ф��� CredentialPack ���֥������Ȥ�����
     */
    private CredentialPack getCredentialPack(String callee, long nonce)
    throws OzCipherException {
	OzKey privateKey = getPrivateKey();
	for (int retry = 0; retry < AuthenticationServerConnectionRetry;
	     ++ retry) {
	    Socket socket;
	    DataInputStream is;
	    DataOutputStream os;
	    try {
		socket = new Socket(authenticationServerURL.getHost(),
				    authenticationServerURL.getPort());
		is = new DataInputStream(socket.getInputStream());
		os = new DataOutputStream(socket.getOutputStream());
	    } catch (IOException e) {
		continue;
	    }
	    try {
		/* send `GET CREDENTIAL' */
		os.writeUTF("GC");
		os.writeUTF(myOzHomeID);

		CredentialRequest cr = new CredentialRequest(callee, nonce);
		byte[] b = encode(cr, privateKey);
		int len = b.length;

		os.writeInt(len);
		os.write(b, 0, len);
		os.flush();

		String tag = is.readUTF();
		if (tag.equals("RC")) {
		    len = is.readInt();
		    b = new byte[len];
		    is.readFully(b);
		    try {
			return (CredentialPack)decode(b, privateKey);
		    } catch (OzCipherException e) {
			/* checks if the authentication server issues
			   the new ticket */
			OzDESKey k = (OzDESKey)getPrivateKey();
			if (k.isEqualKey((OzDESKey)privateKey)) {
			    throw e;
			} else {
			    return (CredentialPack)decode(b, k);
			}
		    }
		} else if (tag.equals("ER")) {
		    String m = "OzDESCipher#getCredentialPack(): "
		      + "Get credential error. Retrying";
		    OzSystem.debugPrintln(m);
		} else {
		    String m = "OzDESCipher#getCredentialPack(): "
		      + "Protocol error. Retrying";
		    OzSystem.debugPrintln(m);
		}
	    } catch (OzCipherException e) {
		String m = "OzDESCipher#getCredentialPack(): Data error. "
		  + "Retrying: " + e;
		OzSystem.debugPrintln(m);
	    } catch (IOException e) {
		String m = "OzDESCipher#getCredentialPack(): IO Exception. "
		  + "Retrying: " + e;
		OzSystem.debugPrintln(m);
	    } finally {
		try {
		    is.close();
		    os.close();
		} catch (IOException e) {
		    // Cannot do more.
		}
	    }
	}
	throw new OzCipherException("Cannot connect to authentication server");
    }

    private void checkCredentialPack(CredentialPack cp, long nonce)
    throws OzCipherException{
	if (cp.getNonce() != nonce
	    || new Date().after(cp.getExpirationDate())) {
	    String m = "Authentication Server is Faked.  Nonce: "
	      + cp.getNonce() + " for " + nonce + ", date: "
		+ cp.getExpirationDate() + " for " + new Date();
	    throw new OzCipherException(m);
	}
    }

    /* Feb. 12th, 1998 added by Nishioka */
    /**
     * �᥽�åɵ�ư������������ä� callee ����������ɬ�פΤ���
     * �ǡ������֤���
     *
     * @return	invoke(String) ���������줿���֥������ȤǤ���С�
     *		�᥽�åɵ�ư������������ä� callee ����������ɬ�פΤ���
     *		�ǡ������֤������Τ褦�ʥǡ������ʤ������ޤ��ϡ�
     *		�̤���ˡ�� �������줿���֥������ȤǤ���С� null ���֤���
     */
    public byte[] getCredential() {
	if (credentialPack == null) {
	    return null;
	} else {
	    return credentialPack.getCredential();
	}
    }

    /* Jan. 26th, 1998 added by Nishioka */
    /**
     * Creates a DES key from a password.
     */
    public OzKey getKey(String password) {
	return OzDESKey.genKey(password);
    }

    /* Jan. 26th, 1998 modified by Nishioka
       (ExCommException -> OzCipherException) */
    /**
     * DES encryption method. Data coming from specified
     * <code>InputStream</code> is encrypted using OzKey and sent through
     * specified <code>OutputStream</code>.<br>
     * 
     * @param is Specified InputStream that data coming from
     * @param os Specified OutputStream that encrypted data sending through
     * @param key DES key used for the encryption
     *
     * @excepiton OzCipherException if an error occurs during encryption
     */
    public void encode(InputStream is, OzKey key, OutputStream os) 
    throws OzCipherException {
	((OzDESKey)key).encode(is, os);
    }

    /* Jan. 26th, 1998 modified by Nishioka
       (ExCommException -> OzCipherException) */
    /**
     * ���ȥ꡼���Ź沽���롣
     *
     * @param	in	�Ź沽����ǡ���
     * @param	out	�Ź沽�����ǡ�����񤭹��ॹ�ȥ꡼��
     * @exception	OzCipherException
     *				�¹�����㳰��ȯ���������ʾܺ�̤���
     */
    public void encode(InputStream in, OutputStream out)
    throws OzCipherException {
	if (key == null) {
	    throw new OzCipherException("No key is set.");
	} else {
	    encode(in, key, out);
	}
    }
  
    /* Feb. 12th, 1998 added by Nishioka */
    /**
     * ǧ�ڤ�ȼ����⡼�ȥ᥽�åɵ�ư������������������塼������
     * ǧ�ڥ����ƥ४�֥������Ȥ����뤿��˸ƤӽФ���
     *
     * @param	credential	�ƽ�¦�����Ϥ��줿ǧ���ѤΥǡ���
     * @return	getCaller() ���Ф���Ŭ�ڤ��ͤ��֤���
     *		encode(InputStream, OutputStream) /
     *		decode(InputStream, OutputStream) �ǥ��ȥ꡼���
     *		�Ź�/����Ǥ��륪�֥������ȡ�
     *		getCaller() �� encode(InputStream, OutputStream) /
     *		decode(InputStream, OutputStream) ���ɤν���ǸƤФ�뤫�ϡ�
     *		����Ǥ��롣 
     */
    public OzCipher invoke(byte[] credential) throws OzCipherException {
	Credential c = (Credential)decode(credential, getPrivateKey());
	OzDESCipher cipher = new OzDESCipher();
	cipher.credential = c;
	cipher.key = new OzDESKey((OzDESKey)c.getSessionKey(),
				  c.getExpirationDate());
	return cipher;
    }

    /* Feb. 12th, 1998 added by Nishioka */
    /**
     * �ƤӽФ�¦�Υ���� OZ �ۡ��� ID ���֤���
     *
     * @return	invoke(byte[]) ���������줿���֥������ȤǤ���С�
     *		�ƤӽФ�¦�Υ���� OZ �ۡ��� ID ���֤���
     *		����ʤ���С� null ���֤���
     */
    public String getCaller() throws OzCipherException {
	if (credential == null) {
	    return null;
	} else {
	    return credential.getCallerOzHome();
	}
    }

    /* Jan. 26th, 1998 modified by Nishioka
       (ExCommException -> OzCipherException) */
    /**
     * DES decryption method. Data encrypted by <code>OzDESCipher#encode</code>
     * coming from specified <code>InputStream</code> is decrypted using OzKey
     * and sent through specified <code>OutputStream</code>.<br>
     *
     * @param is Specified InputStream that data coming from
     * @param os Specified OutputStream that decrypted data is sending through
     * @param key DES key used for the decryption
     * @excepiton OzCipherException if an error occurs during decryption
     * @see JP.go.ipa.oz.system.OzKey
     */

    public void decode(InputStream is, OzKey key, OutputStream os)
    throws OzCipherException {
	OzDESKey deskey = (OzDESKey)key;
	deskey.decode(is, os);
    }

    /* Feb. 12th, 1998 added by Nishioka */
    /**
     * ���ȥ꡼������椹�롣
     *
     * @param	in	���椹��ǡ���
     * @param	out	���沽�����ǡ�����񤭹��ॹ�ȥ꡼��
     * @exception	OzCipherException
     *				�¹�����㳰��ȯ���������ʾܺ�̤���
     */
    public void decode(InputStream in, OutputStream out)
    throws OzCipherException {
	if (key == null) {
	    throw new OzCipherException("No key is set.");
	} else {
	    decode(in, key, out);
	}
    }
}
