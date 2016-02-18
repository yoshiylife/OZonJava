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

package JP.go.ipa.oz.system;

import java.io.*;
/* Jan. 26th, 1998 added by Nishioka */
import java.lang.reflect.*;

/**
 * OzCipher �ϡ��ǡ�����Ź沽�ޤ��ϡ����椹�뵡ǽ����ġ�
 *
 * @version		$Revision$, $Date$
 * @author		Tadayuki Higuchi
 * @author		Toshihiro Nishioka
 */

/* Jan. 27th, 1998 modified by Nishioka (implements Serializable) */
public abstract class OzCipher implements Serializable {
    /* Feb. 17th, 1998. added by Nishioka */
    /**
     * A system defined user name which indicates an untrusted user.
     */
    public static String Nobody = "nobody";

    /* Feb. 17th, 1998 added by Nishioka */
    private static String myOzHomeID = System.getProperty("oz.home.name");

    /* Jan. 25th, 1998. added by Nishioka */
    private static Class ozCipherClass;
    static {
	try {
	    ozCipherClass = Class.forName("JP.go.ipa.oz.system.OzCipher");
	} catch (ClassNotFoundException e) {
	    /* this cannot occur */
	}
    }
    static Object[] cryptosystemParameters = new Object[0];
    static Class[] cryptosystemParameterTypes = new Class[0];

    /**
     * �Ź沽����������롣
     *
     * @return	���������󥹥���
     */
    protected OzCipher() {}
  
    /**
     * �Ź沽��ǽ������ɬ�פʤ�Τ�������
     *
     * @exception	Exception
     *				�¹�����㳰��ȯ���������ʾܺ�̤���
     */
    protected void init() throws Exception {
	/* do nothing if not required */
    }
  
    /* Feb. 16th, 1998 added by Nishioka */
    /**
     * ����ǥ󥷥��Υǥ����ɤ��Ѥ��뤿��Υ��� (�ץ饤�١��ȥ���) ���֤���
     */
    protected abstract OzKey getPrivateKey() throws OzCipherException;

    /* Feb. 12th, 1998 added by Nishioka */
    /**
     * ǧ�ڤ�ȼ����⡼�ȥ᥽�åɵ�ư�θƤӽФ�¦�Υ��������塼������
     * ���������äơ��᥽�åɵ�ư��ɬ�פ��������򤵤��뤿��˸ƤӽФ�
     * ���󥿥ե�������ǧ�ڥ����ƥ४�֥������Ȥϡ������ǡ����ø���
     * ����ǥ󥷥����Ѱդ��뤳�Ȥ���Ԥ���Ƥ��롣
     *
     * @param	callee	�᥽�åɵ�ư�оݤΥ���� GOL
     *
     * @return	getCredential() ���Ф���Ŭ�ڤ��ͤ��֤���
     *		encode(InputStream, OutputStream) /
     *		decode(InputStream, OutputStream) ��
     *		���ȥ꡼���Ź�/����Ǥ��륪�֥������ȡ�
     *		getCredential() �� encode(InputStream, OutputStream) /
     *		decode(InputStream, OutputStream) ��
     *		�ɤν���ǸƤФ�뤫������Ǥ��롣 
     */
    protected abstract OzCipher invoke(String callee) throws OzCipherException;

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
    protected abstract byte[] getCredential() throws OzCipherException;

    /* Jan. 26th, 1998 modified by Nishioka
       (ExCommException -> OzCipherException) */
    /**
     * ���ȥ꡼���Ź沽���롣
     *
     * @param	in	�Ź沽����ǡ���
     * @param	key	�Ź沽��
     * @param	out	�Ź沽�����ǡ�����񤭹��ॹ�ȥ꡼��
     * @exception	OzCipherException
     *				�¹�����㳰��ȯ���������ʾܺ�̤���
     */
    public abstract void encode(InputStream in, OzKey key, OutputStream out)
      throws OzCipherException;
  
    /* Feb. 12th, 1998 added by Nishioka */
    /**
     * ���ȥ꡼���Ź沽���롣
     *
     * @param	in	�Ź沽����ǡ���
     * @param	out	�Ź沽�����ǡ�����񤭹��ॹ�ȥ꡼��
     * @exception	OzCipherException
     *				�¹�����㳰��ȯ���������ʾܺ�̤���
     */
    public abstract void encode(InputStream in, OutputStream out)
      throws OzCipherException;

    /* Jan. 27th, 1998 added by Nishioka */
    /**
     * ���֥������Ȥ�Ź沽���롣
     *
     * @param	o	�Ź沽���륪�֥�������
     * @param	key	�Ź沽��
     * @exception	OzCipherException
     *				�¹�����㳰��ȯ��������
     */
    public final byte[] encode(Object o, OzKey key)
    throws OzCipherException {
	try {
	    ByteArrayOutputStream bo = new ByteArrayOutputStream();
	    ObjectOutputStream out = new ExObjectOutputStream(bo);
	    out.writeObject(o);
	    out.close();
	    byte[] buffer = bo.toByteArray();
	    ByteArrayInputStream bi = new ByteArrayInputStream(buffer);
	    /*
	    System.out.println("before encoding");
	    printByteArray(buffer);
	    */
	    bo = new ByteArrayOutputStream();
	    encode(bi, key, bo);
	    buffer = bo.toByteArray();
	    /*
	    System.out.println("after encoding");
	    printByteArray(buffer);
	    */
	    return buffer;
	} catch (Exception e) {
	    throw new OzCipherException(e.toString());
	}
    }

    /* Feb. 17th, 1998 added by Nishioka */
    /**
     * ���֥������Ȥ�Ź沽���롣
     *
     * @param	o	�Ź沽���륪�֥�������
     * @exception	OzCipherException
     *				�¹�����㳰��ȯ��������
     */
    public final byte[] encode(Object o) throws OzCipherException {
	try {
	    ByteArrayOutputStream bo = new ByteArrayOutputStream();
	    ObjectOutputStream out = new ExObjectOutputStream(bo);
	    out.writeObject(o);
	    out.close();
	    byte[] buffer = bo.toByteArray();
	    ByteArrayInputStream bi = new ByteArrayInputStream(buffer);
	    /*
	    System.out.println("before encoding");
	    printByteArray(buffer);
	    */
	    bo = new ByteArrayOutputStream();
	    encode(bi, bo);
	    buffer = bo.toByteArray();
	    /*
	    System.out.println("after encoding");
	    printByteArray(buffer);
	    */
	    return buffer;
	} catch (Exception e) {
	    throw new OzCipherException(e.toString());
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
    protected abstract OzCipher invoke(byte[] credential)
      throws OzCipherException;

    /* Feb. 12th, 1998 added by Nishioka */
    /**
     * �ƤӽФ�¦�Υ���� OZ �ۡ��� ID ���֤���
     *
     * @return	invoke(byte[]) ���������줿���֥������ȤǤ���С�
     *		�ƤӽФ�¦�Υ���� OZ �ۡ��� ID ���֤���
     *		����ʤ���С� null ���֤���
     */
    protected abstract String getCaller() throws OzCipherException; 

    /* Jan. 26th, 1998 modified by Nishioka
       (ExCommException -> OzCipherException) */
    /**
     * ���ȥ꡼������椹�롣
     *
     * @param	in	�Ź沽�����ǡ������ɤ߹��ॹ�ȥ꡼��
     * @param	key	�Ź沽��
     * @param	out	���椷���ǡ�����񤭹��ॹ�ȥ꡼��
     * @exception	ExCommException
     *				�¹�����㳰��ȯ���������ʾܺ�̤���
     * @return	�Ź沽����̾
     */
    public abstract void decode(InputStream in, OzKey key, OutputStream out) 
      throws OzCipherException;

    /* Feb. 12th, 1998 added by Nishioka */
    /**
     * ���ȥ꡼������椹�롣
     *
     * @param	in	���椹��ǡ���
     * @param	out	���沽�����ǡ�����񤭹��ॹ�ȥ꡼��
     * @exception	OzCipherException
     *				�¹�����㳰��ȯ���������ʾܺ�̤���
     */
    public abstract void decode(InputStream in, OutputStream out)
      throws OzCipherException;

    /* Jan. 27th, 1998 added by Nishioka */
    /**
     * ���֥������Ȥ����椹�롣
     *
     * @param	ba	���椹�륪�֥�������
     * @param	key	�Ź沽��
     * @exception	OzCipherException
     *				�¹�����㳰��ȯ��������
     */
    public final Object decode(byte[] ba, OzKey key) throws OzCipherException {
	try {
	    /*
	    System.out.println("before decoding");
	    printByteArray(ba);
	    */
	    ByteArrayInputStream bi = new ByteArrayInputStream(ba);
	    ByteArrayOutputStream bo = new ByteArrayOutputStream();
	    decode(bi, key, bo);
	    ba = bo.toByteArray();
	    /*
	    System.out.println("after decoding");
	    printByteArray(ba);
	    */
	    bi = new ByteArrayInputStream(ba);
	    ObjectInputStream in = new ExObjectInputStream(bi);
	    return in.readObject();
	} catch (Exception e) {
	    throw new OzCipherException(e.toString());
	}
    }

    /* Feb. 14th, 1998 added by Nishioka */
    /**
     * ���֥������Ȥ����椹�롣
     *
     * @param	ba	���椹�륪�֥�������
     * @exception	OzCipherException
     *				�¹�����㳰��ȯ��������
     */
    public final Object decode(byte[] ba) throws OzCipherException {
	try {
	    ByteArrayInputStream bi = new ByteArrayInputStream(ba);
	    ByteArrayOutputStream bo = new ByteArrayOutputStream();
	    decode(bi, bo);
	    ba = bo.toByteArray();
	    bi = new ByteArrayInputStream(ba);
	    ObjectInputStream in = new ExObjectInputStream(bi);
	    return in.readObject();
	} catch (Exception e) {
	    throw new OzCipherException(e.toString());
	}
    }

    /* Jan. 25th, 1998 added by Nishioka */
    /**
     *  ����ư����Υ���åɤ��������������Х�᥽�åɵ�ư�θƽи���
     *  ���뤬°���Ƥ��� OZ �ۡ����̾�������롣
     *  �����Х�᥽�åɵ�ư�Τ��ȡ�������ǥ�����˥ե��������줿
     *  ����åɤξ��ϡ�
     *  �ե��������Υ���åɤθƤӽФ�����Ƶ�Ū��é�롣 
     */
    public static String getCallerOzHome() throws OzCipherException {
	String callerOzHome
	  = ((ExThread)Thread.currentThread()).getCallerOzHome();
	if (callerOzHome == null) {
	    return myOzHomeID;
	} else {
	    return callerOzHome;
	}
    }

    /* Jan. 25th, 1998 added by Nishioka */
    /**
     * ���ꤵ�줿�Ź楷���ƥ���б�����Ź沽������롣
     *
     * @param cryptosystemName
     *        �Ź沽��� Java �Υ��饹̾��
     *        OzCipher �Υ��֥��饹�Ǥʤ���Фʤ�ʤ���
     *        OZ �����ƥ��Ȥ߹��ߤ� DES �ξ�硢
     *        "JP.go.ipa.oz.system.OzDESCipher" ����ꤹ�롣 
     * @return cryptosystemName �˻��ꤵ�줿���饹�Υ��󥹥���
     */
    public static OzCipher getCipher(String cryptosystemName)
    throws OzCipherException {
	try {
	    Class clazz = Executor.loadClass(cryptosystemName);
	    if (ozCipherClass.isAssignableFrom(clazz)) {
		Constructor constructor
		  = clazz.getConstructor(cryptosystemParameterTypes);
		OzCipher cipher
		  = (OzCipher)constructor.newInstance(cryptosystemParameters);
		cipher.init();
		return cipher;
	    }
	} catch (Exception e) {
	}
	throw new OzCipherException("Not Found: " + cryptosystemName);
    }

    /* Jan. 25th, 1998 added by Nishioka */
    /**
     * �ѥ���ɤ򸵤˥��������� 
     */
    public abstract OzKey getKey(String password) throws OzCipherException;

    /* Jan. 26th, 1998 added by Nishioka */
    /**
     * log message ����Ϥ��롣
     */
    protected void message(String className, String message) {
	Executor.message(className, message);
    }

    /* Jan. 26th, 1998 added by Nishioka */
    /**
     * debug message ����Ϥ��롣
     */
    protected void debug(String className, String message) {
	Executor.debug(className, message);
    }

    private void printByteArray(byte[] ba) {
	int len = ba.length;
	StringBuffer buffer = new StringBuffer();
	for (int i = 0; i < len; ++ i) {
	    String hex = "00" + Integer.toHexString(ba[i]);
	    buffer.append(hex.substring(hex.length() - 2));
	}
	System.out.println(buffer.toString());
    }
}
