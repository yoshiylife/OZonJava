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
 * $Id: OzMonitor.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 *
 * ���: ���Υե������ vi �ǡ�hardtab=8, tabstop=4 �Ȥ����Խ�����Ƥ���
 */

package JP.go.ipa.oz.system;

import java.io.Serializable;

/**
 * OzMonitor �ϣϣڤΥΥ�ꥨ��ȥ��Ȥʥ�˥���ǽ�������
 * ����ѿ��μ¸��Τ���ΰ���������ô�äƤ��롣
 *
 * @see	OzCondition
 * @see	ExThread
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author		Yoichi Hamazaki (revised from OzObject by Yasumitsu Yoshida)
 */
public
class OzMonitor
implements Serializable
{
  /**
   * ���������塼�������ΥǥХå���
   */
  static String CN = "OzMonitor";

  /**
   * �ϣڤΥ��֥������Ȥϣ��ĤΥ�˥��Ȥ��Ƥε�ǽ����ġ�
   * ��˥�����å���򼨤��ե饰�Ǥ��롣
   */
  private transient boolean locked = false;

  /**
   * ��������˥�����������롣
   *
   * @return	���������󥹥���
   */
  public
    OzMonitor()
      {
      }

  /**
   * ��˥���������롣
   *
   * @exception	ExInterruptedException
   *					����åɤ��Ф���kill���¹Ԥ��줿��
   *
   * @see	OzMonitor#leave
   * @see	OzCondition
   */
  protected final synchronized
    void enter()
      throws ExInterruptedException
	{
	  try{
	    while (locked) wait(0); // IllegalMonitorStateException ��ȯ���Ϥ��ꤨ�ʤ�
	  } catch (InterruptedException iex){
	    throw new ExInterruptedException("Interrupted while waiting to enter");
	  }

	  locked = true;
	}

  /**
   * ��˥��������롣
   *
   * @exception ExIllegalMonitorStateException Leave monitor without enter.
   *
   * @see	OzMonitor#enter
   * @see	OzCondition
   */
  protected final synchronized
    void leave() 
      throws ExIllegalMonitorStateException
	{
	  if(!locked)
	    throw new ExIllegalMonitorStateException();
 
	  locked = false;
	  notifyAll();
      }
  
  /**
   * ����ѿ��˥����ʥ롢���뤤�ϡ����ꤵ�줿���֤��в�
   * ����ޤ��Ե����롣
   *
   * @param	cond	�Ե��������ѿ������
   * @param	timeout	�Ե�������֤�ߥ��äǻ���
   * @exception	ExExIllegalConditionException
   *					��˥����ۤʤ����ѿ����Ф������Ԥ�줿��
   * @exception	ExInterruptedException
   *					����åɤ��Ф���kill���¹Ԥ��줿��
   *
   * @see	OzMonitor#signal
   * @see	OzMonitor#signalAll
   * @see	OzCondition#wait
   */
  protected final
    void wait(OzCondition cond, long timeout)
      throws ExIllegalConditionException, ExInterruptedException,ExIllegalMonitorStateException
	{
	  cond.wait(this, timeout);
	}
  
  /**
   * ����ѿ��˥����ʥ���������롣����ѿ����Ե����Ƥ���
   * ����åɤ���Σ��ĤΤߤ��������塼��󥰤���롣
   * ���Υ᥽�åɤ�ƤӽФ����ˡ��᥽�å� enter ��ƤӽФ���
   * ��˥���������Ƥ��ʤ���Фʤ�ʤ���
   *
   * @param	cond	�����ʥ�������������ѿ������
   * @exception	ExIllegalConditionException
   *					��˥����ۤʤ����ѿ����Ф������Ԥ�줿��
   * @exception	ExInterruptedException
   *					����åɤ��Ф���kill���¹Ԥ��줿��
   *
   * @see	OzMonitor#enter
   * @see	OzMonitor#leave
   * @see	OzMonitor#signalAll
   * @see	OzCondition#signal
   */
  protected final
    void signal(OzCondition cond)
      throws ExIllegalConditionException
	{
	  cond.signal(this);
	}
  
  /**
   * ����ѿ��˥����ʥ���������롣����ѿ����Ե����Ƥ���
   * ���ƤΥ���åɤ��������塼��󥰤���롣
   * ���Υ᥽�åɤ�ƤӽФ����ˡ��᥽�å� enter ��ƤӽФ���
   * ��˥���������Ƥ��ʤ���Фʤ�ʤ���
   *
   * @param	cond	�����ʥ�������������ѿ������
   * @exception	ExIllegalConditionException
   *					��˥����ۤʤ����ѿ����Ф������Ԥ�줿��
   *
   * @see	OzMonitor#enter
   * @see	OzMonitor#leave
   * @see	OzMonitor#signal
   * @see	OzCondition#signalAll
   */
  protected final
    void signalAll(OzCondition cond)
      throws ExIllegalConditionException
	{
	  cond.signalAll(this);
	}
  
  /**
   * �ǥե���Ȥ�ɽ�����Ƥ˥�å��ξ�����ä���ɽ������
   *
   */
  public
    String toString()
      {
	return super.toString()+"["+(locked? "Locked":"Unlocked")+"]";
      }
}
