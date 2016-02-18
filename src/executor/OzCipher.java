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
 * OzCipher は、データを暗号化または、復号する機能を持つ。
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
     * 暗号化器を生成する。
     *
     * @return	新しいインスタンス
     */
    protected OzCipher() {}
  
    /**
     * 暗号化器で初期化が必要なものを初期化。
     *
     * @exception	Exception
     *				実行中に例外が発生した。（詳細未定）
     */
    protected void init() throws Exception {
	/* do nothing if not required */
    }
  
    /* Feb. 16th, 1998 added by Nishioka */
    /**
     * クリデンシャルのデコードに用いるためのキー (プライベートキー) を返す。
     */
    protected abstract OzKey getPrivateKey() throws OzCipherException;

    /* Feb. 12th, 1998 added by Nishioka */
    /**
     * 認証を伴うリモートメソッド起動の呼び出し側のエグゼキュータが、
     * それに先だって、メソッド起動に必要な前処理をさせるために呼び出す
     * インタフェース。認証システムオブジェクトは、ここで、会話鍵や
     * クリデンシャルを用意することを期待されている。
     *
     * @param	callee	メソッド起動対象のセルの GOL
     *
     * @return	getCredential() に対して適切な値を返し、
     *		encode(InputStream, OutputStream) /
     *		decode(InputStream, OutputStream) で
     *		ストリームを暗号/復号できるオブジェクト。
     *		getCredential() と encode(InputStream, OutputStream) /
     *		decode(InputStream, OutputStream) が
     *		どの順序で呼ばれるかは不定である。 
     */
    protected abstract OzCipher invoke(String callee) throws OzCipherException;

    /* Feb. 12th, 1998 added by Nishioka */
    /**
     * メソッド起動の送信に先だって callee に送信する必要のある
     * データを返す。
     *
     * @return	invoke(String) で生成されたオブジェクトであれば、
     *		メソッド起動の送信に先だって callee に送信する必要のある
     *		データを返す。そのようなデータがないか、または、
     *		別の方法で 生成されたオブジェクトであれば、 null を返す。
     */
    protected abstract byte[] getCredential() throws OzCipherException;

    /* Jan. 26th, 1998 modified by Nishioka
       (ExCommException -> OzCipherException) */
    /**
     * ストリームを暗号化する。
     *
     * @param	in	暗号化するデータ
     * @param	key	暗号化鍵
     * @param	out	暗号化したデータを書き込むストリーム
     * @exception	OzCipherException
     *				実行中に例外が発生した。（詳細未定）
     */
    public abstract void encode(InputStream in, OzKey key, OutputStream out)
      throws OzCipherException;
  
    /* Feb. 12th, 1998 added by Nishioka */
    /**
     * ストリームを暗号化する。
     *
     * @param	in	暗号化するデータ
     * @param	out	暗号化したデータを書き込むストリーム
     * @exception	OzCipherException
     *				実行中に例外が発生した。（詳細未定）
     */
    public abstract void encode(InputStream in, OutputStream out)
      throws OzCipherException;

    /* Jan. 27th, 1998 added by Nishioka */
    /**
     * オブジェクトを暗号化する。
     *
     * @param	o	暗号化するオブジェクト
     * @param	key	暗号化鍵
     * @exception	OzCipherException
     *				実行中に例外が発生した。
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
     * オブジェクトを暗号化する。
     *
     * @param	o	暗号化するオブジェクト
     * @exception	OzCipherException
     *				実行中に例外が発生した。
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
     * 認証を伴うリモートメソッド起動を受信したエグゼキュータが、
     * 認証システムオブジェクトを得るために呼び出す。
     *
     * @param	credential	呼出側から渡された認証用のデータ
     * @return	getCaller() に対して適切な値を返し、
     *		encode(InputStream, OutputStream) /
     *		decode(InputStream, OutputStream) でストリームを
     *		暗号/復号できるオブジェクト。
     *		getCaller() と encode(InputStream, OutputStream) /
     *		decode(InputStream, OutputStream) がどの順序で呼ばれるかは、
     *		不定である。 
     */
    protected abstract OzCipher invoke(byte[] credential)
      throws OzCipherException;

    /* Feb. 12th, 1998 added by Nishioka */
    /**
     * 呼び出し側のセルの OZ ホーム ID を返す。
     *
     * @return	invoke(byte[]) で生成されたオブジェクトであれば、
     *		呼び出し側のセルの OZ ホーム ID を返す。
     *		さもなければ、 null を返す。
     */
    protected abstract String getCaller() throws OzCipherException; 

    /* Jan. 26th, 1998 modified by Nishioka
       (ExCommException -> OzCipherException) */
    /**
     * ストリームを復号する。
     *
     * @param	in	暗号化したデータを読み込むストリーム
     * @param	key	暗号化鍵
     * @param	out	復号したデータを書き込むストリーム
     * @exception	ExCommException
     *				実行中に例外が発生した。（詳細未定）
     * @return	暗号化方式名
     */
    public abstract void decode(InputStream in, OzKey key, OutputStream out) 
      throws OzCipherException;

    /* Feb. 12th, 1998 added by Nishioka */
    /**
     * ストリームを復号する。
     *
     * @param	in	復号するデータ
     * @param	out	復号化したデータを書き込むストリーム
     * @exception	OzCipherException
     *				実行中に例外が発生した。（詳細未定）
     */
    public abstract void decode(InputStream in, OutputStream out)
      throws OzCipherException;

    /* Jan. 27th, 1998 added by Nishioka */
    /**
     * オブジェクトを復号する。
     *
     * @param	ba	復号するオブジェクト
     * @param	key	暗号化鍵
     * @exception	OzCipherException
     *				実行中に例外が発生した。
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
     * オブジェクトを復号する。
     *
     * @param	ba	復号するオブジェクト
     * @exception	OzCipherException
     *				実行中に例外が発生した。
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
     *  現在動作中のスレッドを生成したグローバルメソッド起動の呼出元の
     *  セルが属している OZ ホームの名前を得る。
     *  グローバルメソッド起動のあと、セル内でローカルにフォークされた
     *  スレッドの場合は、
     *  フォーク元のスレッドの呼び出し元を再帰的に辿る。 
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
     * 指定された暗号システムに対応する暗号化器を得る。
     *
     * @param cryptosystemName
     *        暗号化器の Java のクラス名。
     *        OzCipher のサブクラスでなければならない。
     *        OZ システム組み込みの DES の場合、
     *        "JP.go.ipa.oz.system.OzDESCipher" を指定する。 
     * @return cryptosystemName に指定されたクラスのインスタンス
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
     * パスワードを元にキーを得る 
     */
    public abstract OzKey getKey(String password) throws OzCipherException;

    /* Jan. 26th, 1998 added by Nishioka */
    /**
     * log message を出力する。
     */
    protected void message(String className, String message) {
	Executor.message(className, message);
    }

    /* Jan. 26th, 1998 added by Nishioka */
    /**
     * debug message を出力する。
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
