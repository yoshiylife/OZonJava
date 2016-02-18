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
 * $Id: OzClassLoader.java,v 2.2 1997/11/07 05:10:58 yoshi Exp $
 *
 */

package JP.go.ipa.oz.system;

/**
 * ランタイムサービスを提供するためのクラスである。
 * このクラスには、static メソッドのみが定義される。
 * このクラスはエグゼキュータ外へ公開されるので、
 * セキュリティに十分注意して実装を行う必要がある。
 * <DL>
 * <DT>
 * 【注意】<DD>
 * 現時点(Tue Sep 9 16:14:56 JST 1997)で、
 * セキュリティマネージャの呼出しは必要ないと判断された。
 * </DL>
 *
 * @version		$Revision: 2.2 $, $Date: 1997/11/07 05:10:58 $
 * @author		Yasumitsu Yoshida
 */
public final
class OzClassLoader
{
    /**
     * エグゼキュータ実装のデバッグ用
     */
    static final String CN = "OzClassLoader";

    /**
     * このクラスは static メソッド（クラスメソッド）のみを持つ。
     * また、このクラスのオブジェクトを生成して使用しない。
     * このクラスは public であり、また、エグゼキュータの実装に依存する
     * 部分が含まれるので、このクラスのオブジェクトが外部に持ち出され
     * ないようにする必要がある。
     */
    private
    OzClassLoader()
    {
	/* Nothing */
    }

    /**
     * 指定されたクラスをロードし、そのクラスのオブジェクトを返す。
     * クラスのロードは、クラス配送やリトライを含めてクラスローダが
     * 行っている。
     * <DL>
     * <DT>
     * 【注意】
     * <DD>
     * この処理は、通常よりも多くのスタックが
     * 消費されると思われるので別スレッドで行う。
     * </DL>
     * @param	fullQualifiedCodePath
     *			パッケージ名を含むクラス名
     * @return	クラス
     *
     * @exception ExClassNotFoundException
     *			指定されたクラスが見つからなかった。
     * @exception ExException
     *			実行中に例外が発生した。
     *
     * @see ExClassLoader#loadClass
     */
    public static
    Class loadClass(String fullQualifiedCodePath)
    throws ExException, ExClassNotFoundException
    {
	Object[] args = new Object[2];
	args[0] = new Integer(Executor.LOADCLASS);
	args[1] = fullQualifiedCodePath;
	OzProcess p = Executor.syscall(args);
	Class c = null;
	try {
	    try {
		c = (Class)p.join();
	    } catch (ExProcessException e) {
		throw e.getException();
	    }
	} catch (SecurityException e) {
	    Executor.debug(CN,"loadClass","(fullQualifiedCodePath="+fullQualifiedCodePath+")",e);
	    throw new SecurityException(e.getMessage());
	} catch (ExNoSuchProcessException e) {
	    Executor.error(CN,"loadClass","(fullQualifiedCodePath="+fullQualifiedCodePath+")",e);
	    throw new ExException(e.getClass().getName());
	} catch (ClassNotFoundException e) {
	    Executor.debug(CN,"loadClass","(fullQualifiedCodePath="+fullQualifiedCodePath+")",e);
	    throw new ExClassNotFoundException(e.getMessage());
	} catch (Exception e) {
	    Executor.error(CN,"loadClass","(fullQualifiedCodePath="+fullQualifiedCodePath+")",e);
	    throw new ExException(e.getClass().getName());
	}
	return c;
    }

    /**
     * 指定されたパッケージを含むクラスアーカイブファイルが
     * ローカルリポジトリに無い場合、ネットワーク上から取り寄せ、
     * ローカルリポジトリに登録する。
     * <DL>
     * <DT>
     * 【注意】
     * <DD>
     * この処理は、通常よりも多くのスタックが
     * 消費されると思われるので別スレッドで行う。
     * </DL>
     * @param	packageName
     *			取り寄せたいパッケージの名前。
     * @exception ExClassNotFoundException
     *			該当するクラスアーカイブファイルがない。
     * @exception ExException
     *			実行中に例外が発生した。
     *
     * @see ExClassLoader#loadPackage
     */
    public static
    void loadPackage(String packageName)
    throws ExException, ExClassNotFoundException
    {
	Object[] args = new Object[2];
	args[0] = new Integer(Executor.LOADPACKAGE);
	args[1] = packageName;
	OzProcess p = Executor.syscall(args);
	try {
	    try {
		p.join();
	    } catch (ExProcessException e) {
		throw e.getException();
	    }
	} catch (SecurityException e) {
	    Executor.debug(CN,"loadPackage","(packageName="+packageName+")",e);
	    throw new SecurityException(e.getMessage());
	} catch (ExNoSuchProcessException e) {
	    Executor.error(CN,"loadPackage","(packageName="+packageName+")",e);
	    throw new ExException(e.getClass().getName());
	} catch (ClassNotFoundException e) {
	    Executor.debug(CN,"loadPackage","(packageName="+packageName+")",e);
	    throw new ExClassNotFoundException(e.getMessage());
	} catch (Exception e) {
	    Executor.error(CN,"loadPackage","(packageName="+packageName+")",e);
	    throw new ExException(e.getClass().getName());
	}
    }

}
