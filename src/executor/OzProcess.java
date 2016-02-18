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
 * $Id: OzProcess.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 *
 * ���: ���Υե������ vi �ǡ�hardtab=8, tabstop=4 �Ȥ����Խ�����Ƥ���
 */

package JP.go.ipa.oz.system;

/**
 * OzProcess �ϣϣڤΥץ��������뤿��Υ��饹�Ǥ��롣
 * OzProcess �������ϡ��ϣڤΥץ������������뤳�Ȥ��������롣
 * OzProcess ���������줿���֥������Ȥˤϡ��ϣڤΥץ�����
 * �Ф���ǥ��å����������뵡ǽ�Ϥʤ����ޤ���ɬ�פʤ���
 * ���μ¸��Τ���� OzProcess �� ExProcess ��ľ�ܤλ��ȴط���
 * �ߤ��˻������ˡ��ϣڤΥץ����ɣĤȸƤ֥����ˤ�ä�
 * ����դ����Ƥ��롣
 *
 * @see ExProcessManager
 * @see ExProcess
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author		Yasumitsu Yoshida
 */
public final
class OzProcess
{
	/**
	 * ���������塼�������ΥǥХå���
	 */
	static final String CN = "OzProcess";

	/**
	 * �ϣڤΥץ����μ�����ô�����֥������Ȥ򸡺����뤿���
	 * �����Ǥ��롣�ϣڤΥץ����ɣĤȸƤ֡�
	 */
	private String pid;

	/**
	 * ���������塼�������ǻ��Ѥ���ϣڤΥץ��������뤿���
	 * ���֥������Ȥ��������롣
	 *
	 * @param	pid	�ϣڤΥץ����ɣ�
	 */
	OzProcess(String pid)
	{
		this.pid = pid;
	}

	/**
	 * �ϣڤΥץ��������뤿��Υ��֥������Ȥ��������롣
	 * OzProcess ���������ϣڤΥץ����Υե��������������롣
	 *
	 * @param	proxy	�ºݤΥ᥽�åɵ�ư��Ԥ����֥�������
	 * @param	object	�᥽�åɵ�ư��Ԥ��о�
	 * @param	args	�᥽�åɵ�ư��ɬ�פʾ���
	 *
	 * @see	ExProcessManager#fork(Runnable,java.lang.Object,java.lang.Object[])
	 */
	public
	OzProcess(Runnable proxy, Object object, Object[] args)
	{
		pid = ExProcessManager.fork(proxy, object, args);
	}

	/**
	 * �ϣڤΥץ����ν�λ���Ԥġ�
	 *
	 * @return		�᥽�åɤ������
	 * @exception	ExNoSuchProcessException
	 *				���Υ��֥������Ȥ��б�����ϣڥץ����Ϥʤ���
	 * @exception	ExProcessException
	 *				��ή�Ԥ��оݤΣϣڥץ������㳰��λ������
	 *
	 * @see	ExProcessManager#toExProcess
	 * @see	ExProcess#join()
	 * @see	ExProcess#done
	 */
	public
	Object join()
	throws ExNoSuchProcessException, ExProcessException
	{
		ExProcess p = ExProcessManager.toExProcess(pid);
		Object result;
		try {
			result = p.join() ;
		} catch (Exception e) {
			throw new ExProcessException("pid="+pid,e);
		}
		return result;
	}

	/**
	 * ���ꤵ�줿���֤����ϣڤΥץ����ν�λ���Ԥġ�
	 * Ʊ���ץ������Ф���ʣ����� join ���Ԥ��뤳�Ȥ�
	 * ��θ����ɬ�פ����롣
	 *
	 * @param		timeout �ԤĻ��֡ʥߥ��á�, 0 ����ꤹ��ȥץ����ν�λ�ޤ��Ԥġ�
	 * @return		�᥽�åɤ������
	 * @exception	ExNoSuchProcessException
	 *				���Υ��֥������Ȥ��б�����ϣڥץ����Ϥʤ���
	 * @exception	ExProcessException
	 *				��ή�Ԥ��оݤΣϣڥץ������㳰��λ������
	 *
	 * @see	ExProcessManager#toExProcess
	 * @see	ExProcess#join(long)
	 * @see	ExProcess#done
	 */
	public
	Object join(long timeout)
	throws ExNoSuchProcessException, ExProcessException
	{
		ExProcess p = ExProcessManager.toExProcess(pid);
		Object result;
		try {
			result = p.join(timeout) ;
		} catch (Exception e) {
			throw new ExProcessException("pid="+pid,e);
		}
		return result;
	}

	/**
	 * �ϣڥץ������᥽�åɤ�¹��椫��Ĵ�٤롣
	 *
	 * @return		�᥽�åɤ�¹���Ǥ���� true ���֤���
	 * @exception	ExNoSuchProcessException
	 *				���Υ��֥������Ȥ��б�����ϣڥץ����Ϥʤ���
	 *
	 * @see	ExProcessManager#toExProcess
	 * @see	ExProcess#isAlive
	 */
	public
	boolean isAlive()
	throws ExNoSuchProcessException
	{
		ExProcess p = ExProcessManager.toExProcess(pid);
		return p.isAlive();
	}

	/**
	 * �ϣڤΥץ��������Ǥ��롣
	 *
	 * @exception	ExNoSuchProcessException
	 *				���Υ��֥������Ȥ��б�����ϣڥץ����Ϥʤ���
	 * @exception	ExException
	 *				�¹�����㳰��ȯ��������
	 *
	 * @see	ExProcessManager#toExProcess
	 * @see	ExProcess#kill
	 */
	public
	void kill()
	throws ExNoSuchProcessException, ExException
	{
		ExProcess p = ExProcessManager.toExProcess(pid);
		p.kill();
	}

	/**
	 * �ϣڤΥץ������˴����롣
	 *
	 * @see	ExProcessManager#detach
	 */
	protected
	void finalize()
	{
		ExProcessManager.detach(pid);
	}

	/**
	 * �ǥե���Ȥ�ɽ�����ƤˣϣڤΥץ����ɣĤ�ä���ɽ�����롣
	 *
	 */
	public
	String toString()
	{
		return CN + "@" + Integer.toHexString(hashCode()) + "[pid=" + pid + "]";
	}
}
