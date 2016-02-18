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
 * $Id: OzSystem.java,v 2.2 1997/11/07 05:10:58 yoshi Exp $
 *
 * ���: ���Υե������ vi �ǡ�hardtab=8, tabstop=4 �Ȥ����Խ�����Ƥ���
 */

package JP.go.ipa.oz.system;

import java.io.InputStream;
import java.io.PrintStream;

/**
 * ��󥿥��ॵ���ӥ����󶡤��뤿��Υ��饹�Ǥ��롣
 * ���Υ��饹�ˤϡ�static �᥽�åɤΤߤ��������롣
 * ExSecurityManager ��ľ�ܤ˸ƤӽФ����Ȥˤ�ꥻ�����ƥ�����ݤ��롣
 * ���Υ��饹�ϥ��������塼�����ظ��������Τǡ�
 * �������ƥ��˽�ʬ��դ��Ƽ�����Ԥ�ɬ�פ����롣
 * <DL>
 * <DT>
 * ����ա�
 * <DD>
 * ������(Thu May 8 13:47:42 JST 1997)�ǡ�ExSecurityManager �Ȥ�
 * ���󥿥ե��������������������뤿�ᡢ�����ȤΤߤ�ɬ�פ�
 * �᥽�åɸƤӽФ���ԤäƤ��ʤ���ʬ�����롣
 * �������ƥ����ݤ��Ǥ��Ƥ��ʤ��ΤǼ������ʤ���ɬ�פ����롣
 * </DL>
 *
 * @version		$Revision: 2.2 $, $Date: 1997/11/07 05:10:58 $
 * @author		Yasumitsu Yoshida
 */
public final
class OzSystem
{
	/**
	 * ���������塼�������ΥǥХå���
	 */
	static final String CN = "OzSystem";

	/**
	 * ���Υ��饹�� static �᥽�åɡʥ��饹�᥽�åɡˤΤߤ���ġ�
	 * �ޤ������Υ��饹�Υ��֥������Ȥ��������ƻ��Ѥ��ʤ���
	 * ���Υ��饹�� public �Ǥ��ꡢ�ޤ������������塼���μ����˰�¸����
	 * ��ʬ���ޤޤ��Τǡ����Υ��饹�Υ��֥������Ȥ������˻����Ф���
	 * �ʤ��褦�ˤ���ɬ�פ����롣
	 */
	private
	OzSystem()
	{
		/* Nothing */
	}

	/**
	 * ���������塼����ɸ�����Ϥ����롣
	 * ���������塼����ɸ�����Ϥ�ɬ������
	 * JavaVM ��ɸ�����ϤȰ��פ���Ȥϸ¤�ʤ���
	 * <DL>
	 * <DT>
	 * ����ա�
	 * <DD>
	 * ���ߡ����ʤ��Ȥ�Solaris(SPARC)�ǤǤ�ɸ������(tty)����������Ԥ��ˤʤ��
	 * JavaVM �Υ������塼�餬��ߤ��롣���äơ�ɸ�����Ϥ���������Ԥ��ˤʤ�
	 * ���֤Ǥϡ�¾�˼¹Բ�ǽ�ʥ���åɤ����äƤ�¹Ԥ���ʤ���
	 * </DL>
	 * @return		ɸ�����ϥ��ȥ꡼��
	 */
	public static
	InputStream getStdin()
	{
		// �������ƥ��ޥ͡�����θƽФ�
		// ? Executor.getSecurityManager().ozCheckGetStdin()
		if (Executor.securityManager != null) {
			Executor.securityManager.tryGetStdin();
		}
		return Executor.stdin; // ������ץȤ� stdin �����ꤵ��Ƥ��뤫�⤷��ʤ���
	}

	/**
	 * ���������塼����ɸ����Ϥ����롣
	 * ���������塼����ɸ����Ϥ�ɬ������
	 * JavaVM ��ɸ����ϤȰ��פ���Ȥϸ¤�ʤ���
	 *
	 * @return		ɸ����ϥ��ȥ꡼��
	 */
	public static
	PrintStream getStdout()
	{
		// �������ƥ��ޥ͡�����θƽФ�
		// ? Executor.getSecurityManager().ozCheckGetStdout()
		if (Executor.securityManager != null) {
			Executor.securityManager.tryGetStdout();
		}
		return Executor.stdout;
	}

	/**
	 * ���������塼����ɸ�२�顼���Ϥ����롣
	 * ���������塼����ɸ�२�顼���Ϥ�ɬ������
	 * JavaVM ��ɸ�२�顼���ϤȰ��פ���Ȥϸ¤�ʤ���
	 *
	 * @return		ɸ�२�顼���ϥ��ȥ꡼��
	 */
	public static
	PrintStream getStderr()
	{
		// �������ƥ��ޥ͡�����θƽФ�
		// ? Executor.getSecurityManager().ozCheckGetStderr()
		if (Executor.securityManager != null) {
			Executor.securityManager.tryGetStderr();
		}
		return Executor.stderr;
	}

	/**
	 * ���������塼���Υ�����Υ��ޥ�ɡ����뤤�ϡ���ư���˻��ꤵ�줿
	 * �����Х륪�֥������Ȥϡ�����������ʣ���λ��ꤵ�줿ʸ�����
	 * ��������뤳�Ȥ��Ǥ��롣���Υ᥽�åɤϤ���ʣ����ʸ�����
	 * ���饹 String ������Ȥ����֤���
	 * ����κǽ�����Ǥ������ˡ�ˤ�꼡�Τ褦�����ꤵ��롣
	 * <DL>
	 * <DT>
	 * ���������塼���Υ�����Υ��ޥ�����ξ��
	 * <DD>
	 * ������Υ��ޥ�����Ǥϡ������Х륪�֥������Ȥ�����
	 * �Ǥ���ʣ����ʸ����򥪥ץ����Ȥ��ƻ��ꤹ�뤳�Ȥ��Ǥ��롣
	 * ���Υ��ץ����Ȥ��ƻ��ꤵ�줿�ǽ��ʸ���󤬤��Υ᥽�åɤ�
	 * ���֤�����κǽ�����ǤȤʤ롣��������κǽ�����Ǥ���ϡ�
	 * ���ꤵ�줿ʸ���󤬽����������ǤȤ������ꤵ��롣
	 * ���Υ��ץ���󤬻��ꤵ��Ƥ��ʤ����ϡ����Υ᥽�åɤ�null���֤���
	 * <DT>
	 * ���������塼���ε�ư���˻��ꤷ�����
	 * <DD>
	 * ���������塼���ϵ�ư���˥��ޥ��̾��ɬ�����ꤷ�ʤ���Фʤ�ʤ���
	 * �ޤ������������塼���Υ�����Υ�����ץȤ��Ϥ������ʣ����ʸ�����
	 * ���ץ����Ȥ��ƻ��ꤹ�뤳�Ȥ��Ǥ��롣
	 * ���Υ᥽�åɤ��֤�����κǽ�����Ǥϡ����Υ��ޥ��̾�Ǥ��롣
	 * ����κǽ�����Ǥ���ϡ����Υ��ץ����Ȥ��ƻ��ꤵ�줿ʸ����
	 * �����������ǤȤ������ꤵ��롣
	 * </DL>
	 *
	 * @return		ʸ���������
	 * @exception	ExException
	 *					���Υ᥽�åɤ���ľ�ܤ�ȯ�����ʤ���
	 */
	public static
	String[] getArguments()
	throws ExException
	{
		// �������ƥ��ޥ͡�����θƽФ�
		if (Executor.securityManager != null) {
			Executor.securityManager.tryGetArguments();
		}

		ExCell cell = ExCell.currentCell();
		return cell.getArguments();
	}

	/**
	 * ɸ����Ϥ�ʸ����(String)����Ϥ����Ǹ�˲��Ԥ�Ԥ���
	 * ����ɸ����ϤȤϡ����������塼������ư����
	 * ���ꤵ��Ƥ���ɸ����Ϥǡ�ɬ�����⥨�������塼����ɸ����ϤȰ��פ��ʤ���
	 * �㤨�С����������塼���ϵ�ư���λ���ˤ�ꡢɸ����Ϥ�ե������
	 * ���ꤹ�����ͤ����뤬�����Υ᥽�åɤϤ�������αƶ�������ʤ���
	 * ���Υ᥽�åɤǽ��Ϥ����ʸ����ϡ�Ʊ���˸ƤӽФ��줿���Υ᥽�åɤ�
	 * ���Ϥ����ʸ����Ⱥ����뤳�ȤϤʤ���â����ɸ����Ϥˤ��Υ᥽�å�
	 * �ʳ��Υ᥽�åɤ�Ȥäƽ��Ϥ�Ԥä����Ϥ��θ¤�ǤϤʤ���
	 *
	 * @see	OzSystem#debugPrintln
	 */
	public static
	void println(String oneLine)
	{
		Executor.out.println(oneLine);
	}

	/**
	 * ɸ����Ϥ�ʸ����(String)����Ϥ����Ǹ�˲��Ԥ�Ԥ���
	 * �̾�Ͻ��Ϥ���ʤ��������������塼���ε�ư���λ��ꡢ���뤤�ϡ�
	 * �����뤫��Υ��ޥ�ɤˤ����Ϥ����椹�뤳�Ȥ��Ǥ��롣
	 *
	 * @see	OzSystem#println
	 */
	public static
	void debugPrintln(String oneLine)
	{
		ThreadGroup group = Thread.currentThread().getThreadGroup();
		if (group instanceof ExCell) {
			ExCell cell = (ExCell)group;
			if (cell.debug) {
				Executor.out.println(oneLine);
			}
		} else {
			if (Executor.debug) {
				Executor.out.println(oneLine);
			}
		}
	}

	/**
	 * ���Υ᥽�åɤ�ƤӽФ���¹Ԥ�������åɤ�°����
	 * ����ʥ���åɥ��롼�סˤ˥桼���������ƥ����֥������Ȥ����ꤹ�롣
	 *
	 * @param	us	�桼���������ƥ����֥�������
	 * @exception	ExException
	 *					���Υ᥽�åɤ���ľ�ܤ�ȯ�����ʤ���
	 * @exception	SecurityException
	 *					�������ƥ��ޥ͡����㤬����(ExSecurityManager)������ΤǤϤʤ���
	 *
	 * @see	ExSecurityManager#setUserSecurity
	 * @see	OzUserSecurity
	 */
	public static
	void setUserSecurity(OzUserSecurity us)
	throws ExException
	{
		// �������ƥ��ޥ͡�����θƽФ�
		// ? Executor.getSecurityManager().ozCheckSetUserSecurity(us)

		ExCell cell = ExCell.currentCell();
		SecurityManager sm = System.getSecurityManager();
		if (!(sm instanceof ExSecurityManager)) {
			SecurityException e = new SecurityException("Not security manager with OZ");
			Executor.debug(CN,"setUserSecurity",e);
			throw e;
		}
		ExSecurityManager oz = (ExSecurityManager)sm;
		oz.setUserSecurity(cell,us);
	}

	/**
	 * ���������塼���Υץ�ѥƥ��˥��� oz.home ����Ͽ����Ƥ���
	 * ���Ƥ����롣
	 *
	 * @return		��Ͽ����Ƥ���ʸ����
	 * @exception	ExException
	 *					ȯ�����ʤ���
	 *
	 * @see	java.lang.System#getProperty
	 */
	public static
	String getOzHome()
	throws ExException
	{
		return System.getProperty("oz.home");
	}

	/**
	 * ���������塼���Υץ�ѥƥ��˥��� oz.home ����Ͽ����Ƥ���
	 * ���Ƥ����롣������Ȥθߴ������ݤĤ����
	 *
	 * @deprecated As of previos executor system I/F
	 *
	 * @return		��Ͽ����Ƥ���ʸ����
	 * @exception	ExException
	 *					ȯ�����ʤ���
	 *
	 * @see	java.lang.System#getProperty
	 */
	public static
	String getOzHomePath()
	throws ExException
	{
		return getOzHome();
	}
}
