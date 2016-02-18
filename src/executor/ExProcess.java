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
 * $Id: ExProcess.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 *
 * ���: ���Υե������ vi �ǡ�hardtab=8, tabstop=4 �Ȥ����Խ�����Ƥ���
 */

package JP.go.ipa.oz.system;

/**
 * ���饹 ExProcess �ϣϣڤΥץ�����������뤿��Υ��饹�Ǥ��롣
 * ���󥿥ե����� ExCallerChannel �μ����Ǥ⤢�ꡢ���ƤΣϣڤΥץ�����
 * ���Υ��饹�Ǻ������줿���֥������Ȥ���Ϥޤ롣
 *
 * @see ExCallerChannel
 * @see ExProcessManager
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author		Yasumitsu Yoshida
 */
class ExProcess
implements ExCallerChannel
{
	/**
	 * ���������塼�������ΥǥХå���
	 */
	static final String CN = "ExProcess";

	/**
	 * �ץ�����°���륻��� god ���ݻ����롣
	 */
	private String god;

	/**
	 * ExProcessManager �ˤ�äƳ�����Ƥ�줿�ץ����ɣĤ��ݻ����롣
	 */
	private String pid;

	/**
	 * ���Υ���ͥ�ʸƤӽФ����¦�ˤ��ݻ���������ͥ��Ϣ���������롣
	 */
	private ExCalleeChannel callee;

	/**
	 * �ץ����Ȥ��ƺǽ�˵�ư���줿�᥽�åɤν�λ���֤��ݻ����롣
	 * ���Υ᥽�åɤ��㳰�ǽ�λ������硢false �Ȥʤ롣
	 */
	private boolean status;

	/**
	 * �ץ����Ȥ��ƺǽ�˵�ư���줿�᥽�åɤ�����ͤ��ݻ����롣
	 */
	private Object result;

	/**
	 * ExProcessManager �ˤ�äƳ�����Ƥ�줿�ץ����ɣĤ�
	 * ���ĥץ��������뤿��Υ��֥������Ȥ��������롣
	 *
	 * @param	pid	�ץ����ɣ�
	 */
	ExProcess(String pid)
	{
		this.pid = pid;
	}

	/**
	 * ExCallerChannel �Ȥ��ơ����Υ��֥������ȤΥץ����ɣĤ��֤���
	 *
	 * @return	�ץ����ɣ�
	 */
	public
	String pid()
	{
		return pid;
	}

	/**
	 * ExCallerChannel �Ȥ��ơ����Υ᥽�åɤ��¹Ԥ���뤳�ȤϤʤ���
	 *
	 * @param	proxy	�ºݤ˥᥽�åɤ�ƤӽФ��ץ���
	 *
	 * @exception	ExException
	 *				�¹�����㳰��ȯ��������
	 *
	 * @see ExCell#fork
	 * @see ExCommSystem#fork
	 * @see ExCallerChannel#fork
	 */
	public
	void fork(OzProxy proxy)
	throws ExException
	{
		ExException e = new ExException("Illegal method call");
	    Executor.debug(CN,"fork","(proxy="+proxy+"): ",e);
		throw e;
	}

	/**
	 * Ʊ�������°���뿷�����ץ�������������¹Ԥ򳫻Ϥ��롣
	 *
	 * @param	proxy	�ºݤ˥᥽�åɤ�ƤӽФ��ץ���
	 * @param	object	�᥽�åɤ�ƤӽФ��оݤΥ��֥�������
	 * @param	args	�᥽�åɤ�ƤӽФ��ݤ�ɬ�פȤʤ����
	 *
	 * @see	ExCell#fork(ExCallerChannel,Object,Object[])
	 */
	public
	void fork(Runnable proxy, Object object, Object[] args)
	{
		ExCell cell = ExCell.currentCell();
		this.god = cell.getName();
		callee = cell.fork(this, proxy, object, args);
	}

	/**
	 * ľ�ܤ˻��ꤷ�������°���뿷�����ץ�������������¹Ԥ򳫻Ϥ��롣
	 * ���������塼�������ν�����Ԥ������ExProcessManager��
	 * �𤷤ƸƤӽФ���롣
	 *
	 * @param	cell	�ץ�����°���륻��
	 * @param	proxy	�᥽�åɤ��¹Ԥ���륪�֥�������
	 * @param	args	�᥽�åɤ�ƤӽФ��ݤ�ɬ�פȤʤ����
	 *
	 * @see	ExCell#fork(ExCallerChannel,Object,Object[])
	 */
	void fork(ExCell cell, Runnable proxy, Object[] args)
	{
		this.god = cell.getName();
		callee = cell.fork(this, proxy, args);
	}

	/**
	 * �᥽�åɤν�λ���Ԥġ�
	 *
	 * @return	�᥽�åɤ������
	 * @exception	Exception
	 *				�ƤӽФ����¦�Υ᥽�åɤ�ȯ�������㳰�ǡ�
	 *				���Υ᥽�åɼ��Ȥ��㳰�Ϥʤ���
	 *
	 * @see	ExProcess#join(long)
	 */
	public
	Object join()
	throws Exception
	{
		return join(0);
	}

	/**
	 * ExCallerChannel �Ȥ��ơ��ƤӽФ����¦�Υ᥽�åɤμ¹Խ�λ���Ԥġ�
	 *
	 * @param	timeout	�Ԥ�����
	 * @return	�ƤӽФ����¦�Υ᥽�åɤ������
	 * @exception	Exception
	 *				�ƤӽФ����¦�Υ᥽�åɤ�ȯ�������㳰�ǡ�
	 *				���Υ᥽�åɼ��Ȥ��㳰�Ϥʤ���
	 *
	 * @see	Object#join(long)
	 * @see	ExProcess#done
	 */
	public synchronized
	Object join(long timeout)
	throws Exception
	{
		// Executor.debug(CN,"join()","callee="+callee);
		while (callee != null) wait(timeout);
		// Executor.debug(CN,"join()","status="+status+",result="+result);
		if (!status) throw (Exception)result ;
		return result ;
	}

	/**
	 * ExCallerChannel �Ȥ��ơ��ƤӽФ����¦����᥽�åɤμ¹Խ�λ�����Τ��롣
	 *
	 * @param	status	�᥽�åɤ��㳰�ǽ�λ�������ϡ�false ����ꤹ�롣
	 * @param	result	�᥽�åɤ�����ͤ���ꤹ�롣
	 *
	 * @see	ExProcess#join(long)
	 * @see	ExProcess#status
	 * @see	ExProcess#result
	 * @see	ExCallerChannel#done
	 */
	public synchronized
	void done(boolean status, Object result)
	{
		// Executor.debug(CN,"done","("+status+","+result+")");
		this.status = status;
		this.result = result;
		callee = null;
		notifyAll();
	}

	/**
	 * �ϣڥץ������᥽�åɤ�¹��椫��Ĵ�٤롣
	 *
	 * @return		�᥽�åɤ�¹���Ǥ���� true ���֤���
	 */
	public synchronized
	boolean isAlive()
	{
		return (callee != null) ? true : false;
	}

	/**
	 * ExCallerChannel �Ȥ��ơ��ƤӽФ����¦�Υ���åɤμ¹Ԥ����Ǥ��롣
	 *
	 * @exception	ExException
	 *				�¹�����㳰��ȯ��������
	 *
	 * @see	ExCalleeChannel#abort
	 */
	public synchronized
	void kill()
	throws ExException
	{
	        try {
			if (callee == null) {
				Executor.debug(CN,"kill()",pid + ": process already done.");
			} else {
				callee.abort();
			}
		} catch (ExException e) {
			ThreadGroup g = Thread.currentThread().getThreadGroup();
			Executor.error(CN,"kill","channel="+this+",cell="+g,e);
			throw e;
		}
	}

	/**
	 * ���������塼�������ΥǥХå���
	 */
	protected
	void finalize()
	{
		// Executor.debug(CN,"finalize","instance removed");
	}

	/**
	 * �ǥե���Ȥ�ɽ�����Ƥ˥ץ����ɣĤ� GOD ��ä���ɽ�����롣
	 */
	public
	String toString()
	{
		return CN + "@" + Integer.toHexString(hashCode()) + "[pid=" + pid + ",god=" + god + "]";
	}

	/* Feb. 17th, 1998. getCallerOzHome() is added by Nishioka */
	/**
	 * ���Υ���ͥ���������륰���Х�᥽�åɵ�ư��Ԥä�
	 * ����Υ����ʤ� OZ �ۡ��� ID ���֤���
	 * ExProcess �ξ��ϡ����Ʊ�������ʤʤΤǡ�
	 * ����򼨤������ null ���֤���
	 */
	public String getCallerOzHome() throws OzCipherException {
		return null;
	}
}
