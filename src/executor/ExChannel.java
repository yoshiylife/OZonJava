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
 * $Id: ExChannel.java,v 2.2 1997/12/04 04:55:19 yoshi Exp $
 *
 * ���: ���Υե������ vi �ǡ�hardtab=8, tabstop=4 �Ȥ����Խ�����Ƥ���
 */

package JP.go.ipa.oz.system;

/**
 * ���饹 ExChannel �ϥ���ͥ�μ����Ǥ��롣
 *
 * @see	ExCallerChannel
 * @see	ExCalleeChannel
 *
 * @version		$Revision: 2.2 $, $Date: 1997/12/04 04:55:19 $
 * @author		Yasumitsu Yoshida
 */
class ExChannel
implements ExCalleeChannel, ExCallerChannel
{
	/**
	 * ���������塼�������ΥǥХå���
	 */
	static final String CN = "ExChannel";

	/**
	 * Ʊ��OZ�ۡ�����Υ����ưŪ�˳���������Ȥ����ե饰��
	 */
	static private boolean autoload = new Boolean(System.getProperty("oz.cell.autoload")).booleanValue();

	/**
	 * ExCalleeChannel �Ȥ���
	 */

	/**
	 * ExCalleeChannel �Ȥ��ơ�������λ�������ΤΤ����
	 * �ƤӽФ�¦�Υ���ͥ���ݻ����롣
	 *
	 * @see ExCalleeChannel
	 */
	private ExCallerChannel caller;

	/**
	 * ExCalleeChannel �Ȥ��ơ�����������åɾ�ǥ᥽�åɤ�
	 * �¹Ԥ���ݤˡ��᥽�åɤ�ƤӽФ��оݤ��ݻ����롣
	 *
	 * @see ExCalleeChannel
	 */
	private Object object;

	/**
	 * ExCalleeChannel �Ȥ��ơ�����������åɾ�ǥ᥽�åɤ�
	 * �¹Ԥ���ݤ�ɬ�פȤʤ������ݻ����롣
	 *
	 * @see ExCalleeChannel
	 */
	private Object[] arguments;

	/**
	 * ExCalleeChannel �Ȥ��ơ����ܡ��Ƚ�����Ԥ������
	 * �᥽�åɤ�¹Ԥ��Ƥ��륹��åɤ��ݻ����롣
	 *
	 * @see ExCalleeChannel
	 */
	private ExThread thread;

	/**
	 * ExCallerChannel �Ȥ��ơ��ƤӽФ����¦�Υ���ͥ��
	 * ���Ť��뤿��˥ץ����ɣĤ��ݻ����롣
	 *
	 * @see	ExCallerChannel
	 */
	private String pid;

	/**
	 * ExCallerChannel �Ȥ��ơ��ƤӽФ����¦�Ȥ�Ʊ����Ȥ뤿���
	 * �ƤӽФ����¦�Υ���ͥ���ݻ����롣
	 *
	 * @see	ExCallerChannel
	 */
	private ExCalleeChannel callee;

	/**
	 * ExCallerChannel �Ȥ��ơ�����ͥ�����Ƥ���¦�˥᥽�åɤν�λ���֤�
	 * �֤�����ˡ��ƤӽФ����¦�Υ���ͥ뤫���Ϥ��줿��λ���֤��ݻ����롣
	 *
	 * @see	ExCallerChannel
	 */
	private boolean status;

	/**
	 * ExCallerChannel �Ȥ��ơ�����ͥ�����Ƥ���¦�˥᥽�åɤ�����ͤ�
	 * �֤�����ˡ��ƤӽФ����¦�Υ���ͥ뤫���Ϥ��줿����ͤ��ݻ����롣
	 *
	 * @see	ExCallerChannel
	 */
	private Object result;

	/**
	 * Ʊ�쥨�������塼����ǤΥ���åɤ�Ϣ����������뤿��Υ���ͥ���������롣
	 *
	 * @param	caller		�ƤӽФ�¦�Υ���ͥ�
	 * @param	object		�᥽�åɤ�ƤӽФ��оݤΥ��֥�������
	 * @param	arguments	�᥽�åɤ�ƤӽФ������ɬ�פʾ���
	 *
	 * @see	ExCallerChannel
	 */
	ExChannel(ExCallerChannel caller, Object object, Object[] arguments)
	{
		this.pid = caller.pid();
		this.caller = caller;
		this.object = object;
		this.arguments = arguments;
	}

	/**
	 * ExCalleeChannel �Ȥ��ơ�����������åɾ�ǥ᥽�åɤ�
	 * �¹Ԥ���ݤˡ��᥽�åɤ�ƤӽФ��оݤ��֤���
	 *
	 * @return	�᥽�åɤ�ƤӽФ��оݤΥ��֥�������
	 *
	 * @see	ExChannel#object
	 * @see ExCalleeChannel#object
	 */
	public
	Object object()
	{
		Object object = this.object;
		this.object = null;
		return object;
	}

	/**
	 * ExCalleeChannel �Ȥ��ơ�����������åɾ�ǥ᥽�åɤ�
	 * �¹Ԥ���ݤ�ɬ�פȤʤ������֤���
	 *
	 * @return	�᥽�åɤ�¹Ԥ���ݤ�ɬ�פȤʤ������֤���
	 *
	 * @see	ExChannel#arguments
	 * @see ExCalleeChannel#arguments
	 */
	public
	Object[] arguments()
	{
		Object[] arguments = this.arguments;
		this.arguments = null;
		return arguments;
	}

	/**
	 * ExCalleeChannel �Ȥ��ơ��᥽�åɤμ¹Է�̤�ƤӽФ�¦�����Ť��롣
	 *
	 * @param	status	�᥽�åɤ��㳰�ǽ�λ�������ϡ�false ����ꤹ�롣
	 * @param	result	�᥽�åɤ�����ͤ���ꤹ�롣
	 * @exception	ExException
	 *				�¹�����㳰��ȯ��������
	 *
	 * @see	ExChannel#status
	 * @see	ExChannel#result
	 * @see ExCalleeChannel#exit
	 */
	public
	void exit(boolean status, Object result)
	throws ExException
	{
		Executor.debug(CN,"exit","("+status+","+result+")");

		/* SecurityException may occured at Executor.duplicate */
		/* For remote invocation, ExRemoteCallerChannel treat it */
		try {
			if (caller instanceof ExChannel) {
				caller.done(status, Executor.duplicate(result,true));
			} else {
				caller.done(status,result);
			}
		} catch (ExException e) {
			ThreadGroup g = Thread.currentThread().getThreadGroup();
			Executor.error(CN,"exit","channel="+this+" in "+g);
			throw e;
		}
	}

	/**
	 * ExCalleeChannel �Ȥ��ơ����Υ���ͥ�Υ���åɤμ¹Ԥ����Ǥ��롣
	 *
	 * @exception	ExException
	 *				�¹�����㳰��ȯ��������
	 *
	 * @see	ExChannel#kill
	 * @see	Thread#interrupt
	 * @see	ExCalleeChannel#abort
	 */
	public
	void abort()
	throws ExException
	{
		try {
			if (callee != null) kill();
			else thread.interrupt();
		} catch (ExException e) {
			ThreadGroup g = Thread.currentThread().getThreadGroup();
			Executor.error(CN,"abort","channel="+this+",cell="+g,e);
			throw e;
		}
	}

	/**
	 * ExCallerChannel �Ȥ��ơ��ץ����ɣĤ����ŤΤ���˵�ư����롣
	 *
	 * @return	�ץ����ɣ�
	 *
	 * @see	ExCallerChannel#pid
	 */
	public
	String pid()
	{
		return pid;
	}

	/**
	 * ExCallerChannel �Ȥ��ơ�����ͥ��Ϣ���˿����ʥ���ͥ��ä��롣
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * ����åȥ�������������Ϥ��줿��硢
	 * ����μ�ư�������ϹԤäƤϤʤ�ʤ���
	 * </DL>
	 *
	 * @param	proxy	�ºݤΥ᥽�åɵ�ư��Ԥ��ץ���
	 *
	 * @exception	ExCellNotFoundException
	 *					���� gol ���б����륰���Х륪�֥������Ȥ����Ĥ���ʤ���
	 * @exception	ExGOLFormatException
	 *					���ꤵ�줿 GOL �η������������ʤ���
	 * @exception	ExException	�¹�����㳰��ȯ��������
	 *
	 * @see ExCell#fork
	 * @see ExCommManager#fork
	 * @see ExCallerChannel#fork
	 */
	public synchronized
	  void fork(OzProxy proxy)
	    throws ExGOLFormatException, ExCellNotFoundException, ExException
	      {
		ExCell cell;
		ExGOL gol = new ExGOL(ExCell.currentCell().getName());
		
		if(proxy.inside()) {
		  cell = ExCellManager.get(proxy);
		  if(cell!=null){
		    try { 
		      callee = cell.fork((ExCallerChannel)this, (OzProxy)Executor.duplicate(proxy,true));
		    } catch (ClassNotFoundException e) {
		      Executor.error(CN,"fork(","proxy="+proxy+")",e);
		      throw new ExException(e.getClass().getName());
		    }	
		  } else { 
		    try{
		      callee=Executor.commManager.fork(this,proxy,gol.getName());
		    } catch (ExCellNotActiveException cnaex){
		      /* cell auto load */
		      if(autoload && !ExCellManager.isShutdown()){
			Executor.debug(CN,"fork","cell is not active. Try to load the cell "+proxy);
			try{
			  OzCellManager.go(proxy);
			} catch (ExException exex){
			  Executor.debug(CN,"fork","Cell auto load failed by exception",exex);
			  throw cnaex;
			}
			cell = ExCellManager.get(proxy);
			try { 
			  callee = cell.fork((ExCallerChannel)this, (OzProxy)Executor.duplicate(proxy,true));
			} catch (ClassNotFoundException e) {
			  Executor.error(CN,"fork(","proxy="+proxy+")",e);
			  throw new ExException(e.getClass().getName());
			}	
		      }
		    }
		  }
		} else {
		  /* other OZ home */
		  // throw new ExException("inter oz-home invocation is not implemented in this UNIT version");
		  callee=Executor.commManager.fork(this,proxy,gol.getName());
		}
	      }	 

	/**
	 * ExCallerChannel �Ȥ��ơ��ƤӽФ����¦�Υ᥽�åɤμ¹Խ�λ���Ԥġ�
	 *
	 * @return	�ƤӽФ����¦�Υ᥽�åɤ������
	 * @exception	Exception
	 *				�ƤӽФ����¦�Υ᥽�åɤ�ȯ�������㳰�ǡ�
	 *				���Υ᥽�åɼ��Ȥ��㳰�Ϥʤ���
	 */

public synchronized
Object join()
	throws Exception
	{
		Executor.debug(CN,"join()_enter","callee="+callee);
		while (callee != null) wait();
		Executor.debug(CN,"join()_result_arvailable","status="+status+",result="+result);
		if (!status) throw (Exception)result ;
		return result ;
	}

	/**
	 * ExCallerChannel �Ȥ��ơ��ƤӽФ����¦����᥽�åɤμ¹Խ�λ�����Τ��롣
	 *
	 * @param	status	�᥽�åɤ��㳰�ǽ�λ�������ϡ�false ����ꤹ�롣
	 * @param	result	�᥽�åɤ�����ͤ���ꤹ�롣
	 */
	public synchronized
	void done(boolean status, Object result)
	{
		Executor.debug(CN,"done","("+status+","+result+")");
		this.status = status;
		this.result = result;
		callee = null;
		notifyAll();
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
				throw new ExException("process already done.");
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
	 * ���뤬����ͥ�˥���åɤ������ơ����Υ���åɤμ¹Ԥ򳫻Ϥ��롣
	 *
	 * @param	thread	������Ƥ�줿����å�
	 */
	synchronized
	void start(ExThread thread)
	{
		this.thread = thread;
		this.thread.start();
	}

	/**
	 * �ǥե���Ȥ�ɽ�����Ƥ˥ץ����ɣĤ�ä���ɽ�����롣
	 */
	public
	String toString()
	{
		return CN + "@" + Integer.toHexString(hashCode()) + "[pid=" + pid + "]";
	}

	/* Feb. 17th, 1998. getCallerOzHome() is added by Nishioka */
	/**
	 * ���Υ���ͥ���������륰���Х�᥽�åɵ�ư��Ԥä�
	 * ����Υ����ʤ� OZ �ۡ��� ID ���֤���
	 * ExChannel �ξ��ϡ����Ʊ�������ʤʤΤǡ�
	 * ����򼨤������ null ���֤���
	 */
	public String getCallerOzHome() throws OzCipherException {
		return null;
	}

	/* Feb. 17th, 1998. callGetCallerOzHome() is added by Nishioka */
	/**
	 * ���Υ���ͥ��ƤӽФ�������ͥ����������
	 * �����Х�᥽�åɵ�ư��Ԥä�����Υ����ʤ� OZ �ۡ��� ID ���֤���
	 */
	public String callGetCallerOzHome() throws OzCipherException {
		return caller.getCallerOzHome();
	}
}
