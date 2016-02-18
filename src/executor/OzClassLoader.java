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
 * ��󥿥��ॵ���ӥ����󶡤��뤿��Υ��饹�Ǥ��롣
 * ���Υ��饹�ˤϡ�static �᥽�åɤΤߤ��������롣
 * ���Υ��饹�ϥ��������塼�����ظ��������Τǡ�
 * �������ƥ��˽�ʬ��դ��Ƽ�����Ԥ�ɬ�פ����롣
 * <DL>
 * <DT>
 * ����ա�<DD>
 * ������(Tue Sep 9 16:14:56 JST 1997)�ǡ�
 * �������ƥ��ޥ͡�����θƽФ���ɬ�פʤ���Ƚ�Ǥ��줿��
 * </DL>
 *
 * @version		$Revision: 2.2 $, $Date: 1997/11/07 05:10:58 $
 * @author		Yasumitsu Yoshida
 */
public final
class OzClassLoader
{
    /**
     * ���������塼�������ΥǥХå���
     */
    static final String CN = "OzClassLoader";

    /**
     * ���Υ��饹�� static �᥽�åɡʥ��饹�᥽�åɡˤΤߤ���ġ�
     * �ޤ������Υ��饹�Υ��֥������Ȥ��������ƻ��Ѥ��ʤ���
     * ���Υ��饹�� public �Ǥ��ꡢ�ޤ������������塼���μ����˰�¸����
     * ��ʬ���ޤޤ��Τǡ����Υ��饹�Υ��֥������Ȥ������˻����Ф���
     * �ʤ��褦�ˤ���ɬ�פ����롣
     */
    private
    OzClassLoader()
    {
	/* Nothing */
    }

    /**
     * ���ꤵ�줿���饹����ɤ������Υ��饹�Υ��֥������Ȥ��֤���
     * ���饹�Υ��ɤϡ����饹�������ȥ饤��ޤ�ƥ��饹������
     * �ԤäƤ��롣
     * <DL>
     * <DT>
     * ����ա�
     * <DD>
     * ���ν����ϡ��̾����¿���Υ����å���
     * ���񤵤��Ȼפ���Τ��̥���åɤǹԤ���
     * </DL>
     * @param	fullQualifiedCodePath
     *			�ѥå�����̾��ޤ९�饹̾
     * @return	���饹
     *
     * @exception ExClassNotFoundException
     *			���ꤵ�줿���饹�����Ĥ���ʤ��ä���
     * @exception ExException
     *			�¹�����㳰��ȯ��������
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
     * ���ꤵ�줿�ѥå�������ޤ९�饹���������֥ե����뤬
     * �������ݥ��ȥ��̵����硢�ͥåȥ���夫����󤻡�
     * �������ݥ��ȥ����Ͽ���롣
     * <DL>
     * <DT>
     * ����ա�
     * <DD>
     * ���ν����ϡ��̾����¿���Υ����å���
     * ���񤵤��Ȼפ���Τ��̥���åɤǹԤ���
     * </DL>
     * @param	packageName
     *			���󤻤����ѥå�������̾����
     * @exception ExClassNotFoundException
     *			�������륯�饹���������֥ե����뤬�ʤ���
     * @exception ExException
     *			�¹�����㳰��ȯ��������
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
