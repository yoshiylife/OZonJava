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
 * $Id: OzCondition.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 *
 * ���: ���Υե������ vi �ǡ�hardtab=8, tabstop=4 �Ȥ����Խ�����Ƥ���
 */

package JP.go.ipa.oz.system;

import java.io.Serializable;

/**
 * �ϣڤξ���ѿ���¸����롣�ϣڤΥ��֥������Ȥ��Фˤ��ƻ��Ѥ��롣
 *
 * @see		OzMonitor
 *
 * @version	$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author	Yasumitsu Yoshida
 */
public final
class OzCondition
implements Serializable
{
	/**
	 * ���������塼�������ΥǥХå���
	 */
	static String CN = "OzCondition";

	/**
	 * ���ξ���ѿ����Фˤʤ��˥��Ȥ��Ƥ�
	 * �ϣڤΥ��֥������Ȥ򵭲����롣
	 */
	private OzMonitor monitor;

	/**
	 * ���ξ���ѿ����Ե����֤����ä�����򥫥���Ȥ��롣
	 * �ǥХå��ѡ�
	 */
	private long waitCounter = 0; // for debug

	/**
	 * ���ξ���ѿ��˥����ʥ뤬�������줿����򥫥���Ȥ��롣
	 * �ǥХå��ѡ�
	 */
	private long signalCounter = 0; // for debug

	/**
	 * ���ꤵ�줿�ϣڤΥ��֥������Ȥ��˥��Ȥ��ƻ��Ѥ���
	 * ����ѿ��ʥ��֥������ȡˤ��������롣���ĤΣϣڤΥ��֥�������
	 * ���Ф���ʣ���ξ���ѿ����������뤳�Ȥ��Ǥ��롣
	 *
	 * @return	���������󥹥���
	 */
	public
	OzCondition(OzMonitor m)
	{
		monitor = m;
	}

	/**
	 * ����ѿ��˥����ʥ롢���뤤�ϡ����ꤵ�줿���֤��в�
	 * ����ޤ��Ե����롣���ꤵ�줿��˥������ξ���ѿ���
	 * ����������˻��ꤵ�줿��˥��Ȱۤʤ�����㳰�Ȥʤ롣
	 * class OzMonitor ���ͳ���ƸƤӽФ���롣
	 * ���Υ᥽�åɤ�ƤӽФ����ˡ���˥���������Ƥ��ʤ���Фʤ�ʤ���
	 *
	 * @param	m		���ξ���ѿ������Ѥ��Ƥ����˥�
	 * @param	timeout	�Ե�������֤�ߥ��äǻ���
	 * @exception	ExIllegalConditionException
	 *					��˥����ۤʤ����ѿ����Ф������Ԥ�줿��
	 * @exception	ExInterruptedException
	 *					����åɤ��Ф���kill���¹Ԥ��줿��
	 *
	 * @see	OzMonitor#enter
	 * @see	OzMonitor#leave
	 * @see	OzMonitor#waitCondition
	 * @see	OzMonitor#signal
	 * @see	OzMonitor#signalAll
	 * @see	OzCondition#signal
	 */
	void wait(OzMonitor m, long timeout)
	throws ExIllegalConditionException, ExInterruptedException, ExIllegalMonitorStateException
	{
		if (monitor != m) throw new ExIllegalConditionException();
		waitCondition(timeout);
		monitor.enter();
	}

	/**
	 * ����ѿ��˥����ʥ���������롣����ѿ����Ե����Ƥ���
	 * ����åɤ���Σ��ĤΤߤ��������塼��󥰤���롣
	 * Class OzMonitor ���ͳ���ƸƤӽФ���롣
	 * ���Υ᥽�åɤ�ƤӽФ����ˡ���˥���������Ƥ��ʤ���Фʤ�ʤ���
	 *
	 * @param	m		���ξ���ѿ������Ѥ��Ƥ����˥�
	 * @exception	ExIllegalConditionException
	 *					��˥����ۤʤ����ѿ����Ф������Ԥ�줿��
	 *
	 * @see	OzMonitor#enter
	 * @see	OzMonitor#leave
	 * @see	OzCondition#signal
	 * @see	OzCondition#signalAll
	 * @see	OzMonitor#signal
	 */
	synchronized
	void signal(OzMonitor m)
	throws ExIllegalConditionException
	{
	  if (monitor != m) throw new ExIllegalConditionException();
	  signalCounter ++; // for debug
	    notify(); // IllegalMonitorStateException ��ȯ���Ϥ��ꤨ�ʤ�
	}

	/**
	 * ����ѿ��˥����ʥ���������롣����ѿ����Ե����Ƥ���
	 * ���ƤΥ���åɤ��������塼��󥰤���롣
	 * Class OzMonitor ���ͳ���ƸƤӽФ���롣
	 *
	 * @param	m	���ξ���ѿ������Ѥ��Ƥ����˥�
	 * @exception	ExIllegalConditionException
	 *					��˥����ۤʤ����ѿ����Ф������Ԥ�줿��
	 *
	 * @see	OzCondition#signalAll
	 * @see	OzCondition#signal
	 * @see	OzMonitor#signalAll
	 */
	synchronized
	void signalAll(OzMonitor m)
	throws ExIllegalConditionException
	{
	  if (monitor != m) throw new ExIllegalConditionException();
	  signalCounter ++; // for debug
	    notifyAll(); // IllegalMonitorStateException ��ȯ���Ϥ��ꤨ�ʤ�
	}

	/**
	 * ����ѿ��˥����ʥ롢���뤤�ϡ����ꤵ�줿���֤��в�
	 * ����ޤ��Ե����롣�᥽�å� wait() �μ����Ǥ��롣
	 *
	 * @param	timeout	�Ե�������֤�ߥ��äǻ���
	 * @exception	InterruptedException
	 *					����åɤ��Ф���kill���¹Ԥ��줿��
	 *
	 * @see	OzCondition#wait
	 */
	private synchronized
	void waitCondition(long timeout)
	throws ExInterruptedException,ExIllegalMonitorStateException
	{
		//System.out.println(getClass().getName()+": waitCondition");
		monitor.leave();
		waitCounter ++; // for debug
		  try{
		wait(timeout); 		// IllegalMonitorStateException ��ȯ���Ϥ��ꤨ�ʤ�������monitor.leave()�ΤȤ����ȯ�����Ƥ���Ϥ���
	      } catch (InterruptedException iex){
		throw new ExInterruptedException("Interrupted while waiting at a condition variable");
	      }
	}

	/**
	 * �ǥե���Ȥ�ɽ�����Ƥ˾���ѿ����Ե�����ȥ����ʥ�����
	 * �ä���ɽ�����롣
	 *
	 * @see	OzCondition#waitCounter
	 * @see	OzCondition#signalCounter
	 */
	public
	String toString()
	{
		return super.toString()+"["+waitCounter+","+signalCounter+"]";
	}
}
