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
 * $Id: ExThread.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 *
 * ���: ���Υե������ vi �ǡ�hardtab=8, tabstop=4 �Ȥ����Խ�����Ƥ���
 */

package	JP.go.ipa.oz.system;

/**
 * ExThread �ϣϣڤΥץ����������륹��åɤǤ��롣���ʤ����
 * ��Ϣ�Υ���åɤ�Ϣ�����ϣڤΥץ����Ȥʤ롣ExThread ��
 * �ϣڤΥץ����������뤿��˥���ͥ�����������åɴ֤�
 * Ʊ�����롣�ޤ���ExThread �ϣϣڤΥץ����ο���ɽ������
 * ����˿��ξ������äƤ��롣���ο��ϥ���åɴ֤Ǽ����Ϥ���롣
 * �ޤ���ExThread �ϥ����°���Ƥ��롣������Ф������ˤ��
 * ����åɤ��ƶ����������⤢�롣ExThread �Υ��󥹥��󥹤�
 * ����μ¹ԤˤΤ߻Ȥ�졢�����Ѥ���ʤ���
 *
 * @see		ExChannel
 * @version	$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author	Yasumitsu Yoshida
 */
final
class ExThread
extends Thread
{
	/**
	 * ���������塼�������ΥǥХå���
	 */
	static final String CN = "ExThread";

	/**
	 * �ϣڤΥץ����������륹��åɤο����п��Ǥ��뤳�Ȥ�ɽ����
	 * �п��Σϣڥץ����ϰ����ʥץ����Ǥ���Ȥ���롣
	 *
	 * @see OzSecure#GREEN
	 */
	public static boolean GREEN = OzSecure.GREEN;

	/**
	 * �ϣڤΥץ����������륹��åɤο����ֿ��Ǥ��뤳�Ȥ�ɽ����
	 * �ֿ��Σϣڥץ����ϰ����Ǥʤ��ץ����Ǥ���Ȥ���롣
	 *
	 * @see OzSecure#RED
	 */
	public static boolean RED = OzSecure.RED;

	/**
	 * �ϣڤΥץ����������륹��åɤ�ɬ�� ExThread.GREEN �ޤ��ϡ�
	 * ExThread.RED �ο��Ǥ��롣���ο����ݻ����롣������ä�
	 * ����åɤο��ȸƤ֡�
	 */
	boolean color = RED;

	/**
	 * �ϣڤΥץ����������륹��åɤ�ɬ������ͥ���ġ�
	 *
	 */
	ExChannel channel;

	/**
	 * Flag indicates that the thread has been interrupted.
	 *
	 */
	boolean interrupted = false;

	/**
	 * ����åɤο��򿷤����������륹��åɤ����Ť��롣
	 *
	 * @param	target	�¹Ի��� this ����������ϣڤΥ��֥�������
	 * @see	ExThread#ExThread
	 */
	private
	void init(Runnable target)
	{
		Thread t = Thread.currentThread();
		if (t instanceof ExThread) {
			if (target instanceof OzSecure) {
				OzSecure secure = (OzSecure)target;
				if (secure.color == OzSecure.RED) color = RED;
				else color = ((ExThread)t).color;
			} else {
				color = RED;
			}
		} else {
			color = RED;
		}
	}

	/**
	 * ����������åɤ�����������ꤵ�줿�����°�����롣
	 *
	 * @param	cell	����åɤ�°���륻��
	 * @param	target	�¹Ի��� this ����������ϣڤΥ��֥�������
	 * @param	callee	�ƤӽФ���¦����ͥ�
	 * @see	ExThread#init
	 * @see	ExCell
	 * @see	ExCalleeChannel
	 */
	ExThread(ThreadGroup cell, Runnable target, ExChannel callee)
	{
		super(cell, target);
		init(target);
		channel = callee;
	}

	/**
	 */
	public void interrupt(){
	  interrupted=true;
	  super.interrupt();
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
	 * �ǥե���Ȥ�ɽ�����Ƥ˥���åɤο���ä���ɽ�����롣
	 *
	 * @see ExThread#GREEN
	 * @see ExThread#RED
	 * @see ExThread#color
	 */
	public
	String toString()
	{
	  return CN + "@" + Integer.toHexString(hashCode())
	    + "["
	      + getName()
		+ "," + getPriority()
		  + "," + getThreadGroup().getName()
		    + "," + ((color == GREEN) ? "GREEN" : "RED")
		      + "]";
	}

	/* Feb. 17th, 1998. getCallerOzHome() is added by Nishioka */
	/**
	 * ���Υ���åɤ��������륰���Х�᥽�åɵ�ư��Ԥä�
	 * ����Υ����ʤ� OZ �ۡ��� ID ���֤���
	 */
	public String getCallerOzHome() throws OzCipherException {
		return channel.callGetCallerOzHome();
	}
}
