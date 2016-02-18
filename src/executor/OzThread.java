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
 * $Id: OzThread.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 *
 * ���: ���Υե������ vi �ǡ�hardtab=8, tabstop=4 �Ȥ����Խ�����Ƥ���
 */

package JP.go.ipa.oz.system;

/**
 * OzThread �ϣϣڤΥץ��������뤿��Υ��饹�Ǥ��롣
 * OzThread �������ϡ��ϣڤΥץ������������뤳�Ȥ��������롣
 * OzThread ���������줿���֥������Ȥˤϡ��ϣڤΥץ�����
 * �Ф���ǥ��å����������뵡ǽ�Ϥʤ����ޤ���ɬ�פʤ���
 * ���μ¸��Τ���� OzThread �� ExProcess ��ľ�ܤλ��ȴط���
 * �ߤ��˻������ˡ��ϣڤΥץ����ɣĤȸƤ֥����ˤ�ä�
 * ����դ����Ƥ��롣
 *
 * @see ExProcessManager
 * @see ExProcess
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author		Yasumitsu Yoshida(modified Y.Hamazaki)
 */
public final
class OzThread
{
  /**
   * ���������塼�������ΥǥХå���
   */
  static String CN = "OzThread";
  
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
  OzThread(String pid)
    {
      this.pid = pid;
    }
  
  /**
   * �ϣڤΥץ��������뤿��Υ��֥������Ȥ��������롣
   * OzThread ���������ϣڤΥץ����Υե��������������롣
   *
   * @param	proxy	�ºݤΥ᥽�åɵ�ư��Ԥ����֥�������
   * @param	object	�᥽�åɵ�ư��Ԥ��о�
   * @param	args	�᥽�åɵ�ư��ɬ�פʾ���
   *
   * @see	ExProcessManager#fork(ExCell,Runnable,java.lang.Object[])
   */
  public
    OzThread(OzRunnable runnable)
      {
	//ExCell cell = ExCell.currentCell();
	ExRunnable proxy = new ExRunnable(runnable);
	pid = ExProcessManager.fork(proxy,proxy,null);
      }
  
  /**
   * ���ꤵ�줿���֤����ϣڤΥץ����ν�λ���Ԥġ�
   *
   * @exception	ExNoSuchThreadException
   *				���Υ��֥������Ȥ��б�����ϣڥץ����Ϥʤ���
   * @exception	ExThreadException
   *				��ή�Ԥ��оݤΣϣڥץ������㳰��λ������
   *
   * @see	ExProcessManager#toExProcess
   * @see	OzThread#join()
   * @see	OzThread#done
   */
  public
    void join(long timeout)
      throws ExNoSuchThreadException, ExInterruptedException,ExThreadException
	{
	  ExProcess p;
	  try{
	    p = ExProcessManager.toExProcess(pid);
	  } catch (ExNoSuchProcessException ensex){
	    throw new ExNoSuchThreadException("pid="+pid);
	  }
	  
	  try {
	    p.join(timeout) ;
	  } catch (InterruptedException iex){
	    throw new ExInterruptedException("Interrupted before joined");
	  } catch (Exception e) {
	    throw new ExThreadException("pid="+pid+" Exception="+e.getClass().getName());
	  }
	}
  

  /**
   * �ϣڥץ������᥽�åɤ�¹��椫��Ĵ�٤롣
   *
   * @return		�᥽�åɤ�¹���Ǥ���� true ���֤���
   * @exception	ExNoSuchThreadException
   *				���Υ��֥������Ȥ��б�����ϣڥץ����Ϥʤ���
   *
   * @see	ExProcessManager#toExProcess
   * @see	ExProcess#isAlive
   */
  public
    boolean isAlive()
      throws ExNoSuchThreadException
	{
	  ExProcess p;
	  try{
	    p = ExProcessManager.toExProcess(pid);
	  } catch (ExNoSuchProcessException nspex){
	    throw new ExNoSuchThreadException();
	  }
	  return p.isAlive();
	}
  
  /**
   * �ϣڤΥץ��������Ǥ��롣
   *
   * @exception	ExNoSuchThreadException
   *				���Υ��֥������Ȥ��б�����ϣڥץ����Ϥʤ���
   * @exception	ExException
   *				�¹�����㳰��ȯ��������
   *
   * @see	ExProcessManager#toExProcess
   * @see	ExProcess#kill
   */
  public
    void interrupt()
      throws ExNoSuchThreadException, ExException
	{
	  ExProcess p;
	  try{
	    p = ExProcessManager.toExProcess(pid);
	  }catch (ExNoSuchProcessException nspex){
	    throw new ExNoSuchThreadException();
	  }
	  p.kill();
	}

  public static boolean
    interrupted()
      throws ExException
	{
	  ExThread th = (ExThread)Thread.currentThread();
	  return th.interrupted;
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
