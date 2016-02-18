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
 * $Id: ExCell.java,v 2.1.1.1 1997/07/15 06:20:45 yoshi Exp $
 *
 * ���: ���Υե������ vi �ǡ�hardtab=8, tabstop=4 �Ȥ����Խ�����Ƥ���
 */

package JP.go.ipa.oz.system;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ����ʥ����Х륪�֥������ȡˤ��ݻ��������Υ���ξ��֤��Ѳ���ƻ�����
 * ���륯�饹�Ǥ��롣���Υ��饹�Ǻ������줿���֥������Ȥϡ�
 * ���̤ˤϥ����ˤ��륻��Ȱ��а��¸�ߤ������Υ��뤬
 * ����դ����Ƥ���GOD�Υ�å���������Ƥ��롣
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:45 $
 * @author		Yasumitsu Yoshida
 */
final class ExCell
extends ThreadGroup
{
	/**
	 * ���������塼�������ΥǥХå���
	 */
	static final String CN = "ExCell";

	/**
	 * ���֤�ɽ����
	 */
	static final int FREE			= 0x0;
	static final int CREATED		= 0x1;
	static final int ACTIVE			= 0x2;
	static final int INACTIVE		= 0x3;
	static final int REMOVED		= 0x4;

	/**
	 * ����ʥ����Х륪�֥������ȡˤξ��֤�
	 * ɽ�����뤿��Υ��饹
	 */
	class Status
	{
		/**
		 * ���ܾ��֤�ɽ����
		 */
		private final int INITIALIZING	= 0x10;
		private final int ACTIVATING	= 0x11;
		private final int DEACTIVATING	= 0x12;
		private final int REMOVING		= 0x13;

		/**
		 * ���ߤξ���
		 */
		private int now;

		/**
		 * �����ǻ��ꤵ�줿���֤�ɽ�����֥������Ȥ�������롣
		 *
		 * <DL><DT>
		 * ����ա�<DD>
		 * �������ͤ���������Τ��ɤ�����Ĵ�٤Ƥʤ���
		 * </DL>
		 *
		 * @param	status	����ξ���
		 */
		Status(int status)
		{
			now = status;
		}

		/**
		 * �����ǻ��ꤵ�줿���֤ˤ��뤿������ܾ��֤ˤ��롣
		 * ���ܾ��֤�����֤���ꤹ�뤿��ˤϡ��᥽�å� commit ����
		 * �᥽�å� rollback �Τ��Ť줫��ƤӽФ��ʤ���Фʤ�ʤ���
		 *
		 * @param	status	����
		 * @return			���ܾ��֤ˤǤ������ϡ�true ���֤���
		 */
		synchronized
		boolean change(int status)
		{
			switch (status) {
			case ACTIVE:
				switch (now) {
				case CREATED:	now = INITIALIZING; break;
				case INACTIVE:	now = ACTIVATING; break;
				default:
					return false;
				}
				break;
			case INACTIVE:
				switch (now) {
				case ACTIVE:	now = DEACTIVATING; break;
				default:
					return false;
				}
				break;
			case REMOVED:
				switch (now) {
				case ACTIVE:	now = REMOVING; break;
				default:
					return false;
				}
				break;
			case FREE:
				switch (now) {
				case CREATED:	now = FREE; break;
				default:
					return false;
				}
				break;
			default:
				return false;
			}
			return true;
		}

		/**
		 * ���ܾ��֤���ľ���ξ��֤˳��ꤹ�롣
		 *
		 * @return	ľ���ξ��֤��᤹���Ȥ��Ǥ������ϡ�true���֤���
		 */
		synchronized
		boolean rollback()
		{
			switch (now) {
			case INITIALIZING:	now = CREATED; break;
			case ACTIVATING:	now = INACTIVE; break;
			case DEACTIVATING:	now = ACTIVE; break;
			case REMOVING:		now = ACTIVE; break;
			default:
				return false;
			}
			notifyAll();
			return true;
		}

		/**
		 * ���ܾ��֤�����֤���ꤹ�롣
		 *
		 * @return	���֤����Ǥ������ϡ�true���֤���
		 */
		synchronized
		boolean commit()
		{
			switch (now) {
			case INITIALIZING:	now = ACTIVE; break;
			case ACTIVATING:	now = ACTIVE; break;
			case DEACTIVATING:	now = INACTIVE; break;
			case REMOVING:		now = REMOVED; break;
			case REMOVED:		now = FREE; break;
			case INACTIVE:		now = FREE; break;
			default:
				return false;
			}
			notifyAll();
			return true;
		}

		/**
		 * �����Х륢������������ơ��᥽�åɤ�¹ԤǤ�����֤���Ĵ�٤롣
		 * ����ʥ����Х륪�֥������ȡˤ����ܾ��֤ξ��ϡ�
		 * ���֤����ꤹ��ޤ��Ԥġ�â�������ꤵ�줿�Ե����֤��вᤷ�����ġ�
		 * ���λ����Ǿ��֤��Ѳ����ʤ����ϡ�false ���֤���
		 *
		 * @param	waitTime	�Ե����֡ʥߥ��á�
		 * @return				�᥽�åɤ�¹ԤǤ�����֤ξ��ϡ�true ���֤���
		 */
		synchronized private
		boolean checkGlobalAccess(long waitTime)
		{
			int old;
			do {
				switch (now) {
				case ACTIVE:		return true;
				case INITIALIZING:	break;
				case ACTIVATING:	break;
				case DEACTIVATING:	break;
				case REMOVING:		break;
				default:
					return false;
				}
				try {
					Executor.debug(CN,"checkGlobalAccess","Pending global access, "+this);
					old = now;
					wait(waitTime);
					if (waitTime != 0 && old == now) return false;
				} catch (InterruptedException e) {
					Executor.error(CN,"checkGlobalAccess","Interrupted while waiting until " +this,e);
					return false;
				}
			} while (now != FREE);
			return false;
		}

		/**
		 * ��������ξ��֤ˤʤ�ޤ��Ԥġ�
		 *
		 * <DL><DT>
		 * ����ա�<DD>
		 * ��������ξ��֤Ȥϡ����Υ��뤬�����Х륢������������뤳�Ȥ�
		 * �Ǥ��ʤ����Ȥ����ꤷ�Ƥ��뤳�Ȥ򼨤���
		 * ���ΰ�̣�Ǥϡ�REMOVED����, INACTIVE���ܾ��֤���������ξ��֤�
		 * �ޤޤ�뤬��������ϥ����ɬ��FREE���֤��ͳ����Τǡ�
		 * ���Τ褦�ʼ����ˤ��Ƥ��롣
		 * �ʤ������̤��Գ������ϼ��˳������Ǥ��뤳�Ȥ�Ť˰�̣���Ƥ��뤬��
		 * ��������ˤϤ��Τ褦�ʰ�̣�ϴޤޤ�ʤ���
		 * </DL>
		 *
		 * @return			��������ξ��֤ˤʤäƤ�����ϡ�true ���֤���
		 * @exception	InterruptedException
		 *					�̾��ȯ�����ʤ���
		 */
		synchronized
		void watch()
		throws InterruptedException
		{
			while (now != FREE) wait();
		}

		/**
		 * �����ǻ��ꤵ�줿���֤��б�����ʸ������֤���
		 * ��˥ǥХå�����Ū�Ȥ���᥽�åɤǤ��롣
		 *
		 * @param	status	����
		 * @return			���֤��б�����ʸ����
		 */
		String toString(int status)
		{
			switch (status) {
				case FREE: 			return "FREE";
				case CREATED:		return "CREATED";
				case INITIALIZING:	return "INITIALIZING";
				case ACTIVE:		return "ACTIVE";
				case REMOVING:		return "REMOVING";
				case REMOVED:		return "REMOVED";
				case DEACTIVATING:	return "DEACTIVATING";
				case ACTIVATING:	return "ACTIVATING";
				case INACTIVE:		return "INACTIVE";
			}
			return "Unknown";
		}

		/**
		 * ����ʥ����Х륪�֥������ȡˤξ��֤����
		 */
		public
		String toString()
		{
			return toString(now);
		}
	}

	/**
	 * ����ʥ����Х륪�֥������ȡˤξ���
	 */
	private Status status;

	/**
	 * ���Υ��뤬����դ����Ƥ���GOD
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * GOD�Υ�å���������Ƥ���GOD���֥������Ȥ����ꤹ�롣
	 * </DL>
	 */
	private ExGOD god;

	/**
	 * ���֥������ȥ��᡼���Υե�����Υ١���̾
	 * ����ʥ���åɥ��롼�סˤ��������˻��ꤵ��롣
	 *
	 * @see	ExCellManager#objectImageFilename
	 */
	private String objectImageFilename;

	/**
	 * ����ʥ����Х륪�֥������ȡ�
	 */
	private OzCell globalObject = null;

	/**
	 * �桼���ץ����˰����Ϥ�ʸ���������
	 *
	 * @see	OzSystem#getArguments()
	 */
	private String[] arguments = null;

	/**
	 * ������Υ������ƥ���������륪�֥�������
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * �����ʻ��ͤǤϤʤ���
	 * </DL>
	 *
	 */
	private OzUserSecurity us = null;

	/**
	 * �ǥХå��Τ���Υ�å��������Ϥ�̵ͭ�Υե饰
	 */
	boolean debug = true;

	/**
	 * ����ʥ����Х륪�֥������ȡˤ����뤿���
	 * ���֥������Ȥ��б�����GOD���������
	 * ����GOD���å����֤ˤ��롣
	 *
	 * @param	god			GOD���֥�������
	 * @param	oiFilename	���֥������ȥ��᡼���ե�����Υ١���̾
	 * @param	created		���˺�������Ƥ��륻��ʥ����Х륪�֥������ȡ�
	 *						�ξ��ϡ�true ����ꤹ�롣
	 */
	private
	ExCell(ExGOD god, String oiFilename, boolean created)
	throws ExException
	{
		super(god.getName());
		setMaxPriority(Thread.NORM_PRIORITY);
		this.objectImageFilename = oiFilename;
		this.god = god;
		this.debug = Executor.debug;
		try {
			god.acquire();
		} catch (ExGODInvalidPathException e) {
			Executor.error(CN,"ExCell","(god="+god+")",e);
			throw new ExException(e.getClass().getName());
		} catch (ExGODInvalidStateException e) {
			if (created) {
				throw new ExIllegalCellStateException(e.getMessage());
			} else {
				throw new ExGODConflictException(god.getName());
			}
		}
		File objectImage = new File(god,oiFilename);
		if (objectImage.exists()) {
			if (created) {
				status = new Status(INACTIVE);
			} else {
				god.release();
				throw new ExGODConflictException(god.getName());
			}
		} else {
			if (!created) {
				status = new Status(CREATED);
			} else {
				god.release();
				throw new ExCellNotFoundException(god.getName());
			}
		}
	}

	/**
	 * ���˺������줿����ʥ����Х륪�֥������ȡˤ����뤿���
	 * ���֥������Ȥ���������б�����GOD���å����֤ˤ��롣
	 * ���󥹥ȥ饯���Ȥϰۤʤꡢ���פʥǥ��쥯�ȥ��������ʤ���
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * ���˺������줿����Ȥϡ������ˤ���Ȥ�����̣�ǤϤʤ���
	 * </DL>
	 *
	 * @param	god			GOD���֥�������
	 * @param	oiFilename	���֥������ȥ��᡼���ե�����̾
	 *
	 * @see	ExCell(ExGOD, String, boolean)
	 */
	static
	ExCell find(ExGOD god, String oiFilename)
	throws ExIllegalCellStateException, ExCellNotFoundException, ExException
	{
		if (god.exists() && god.isDirectory()) {
			try {
				return new ExCell(god,oiFilename,true);
			} catch (ExGODConflictException e) {
				Executor.error(CN,"find","(god="+god+")",e);
				throw new ExException(e.getClass().getName());
			}
		}
		throw new ExCellNotFoundException(god.getName());
	}

	/**
	 * �������������륻��ʥ����Х륪�֥������ȡˤ����뤿���
	 * ���֥������Ȥ��б�����GOD�������������GOD���å����֤ˤ��롣
	 *
	 * @param	god		GOD���֥�������
	 * @param	oiFilename	���֥������ȥ��᡼���ե�����̾
	 *
	 * @see	ExCell(ExGOD, String, boolean)
	 */
	ExCell(ExGOD god, String oiFilename)
	throws ExGODConflictException, ExException
	{
		this(god, oiFilename, false);
	}

	/**
	 * �����Х륪�֥������ȥǥ��쥯�ȥ�����������
	 * �����������롣����ϡ����������塼��������
	 * ������Ԥ�����Υ���åɤ�°���륹��åɥ��롼��
	 * �Ȥ��ƻ��Ѥ���롣
	 *
	 * @param	globalObject
	 *				�����Х륪�֥�������
	 * @param	god	OZ�ۡ��फ��Υ����Х륪�֥������ȥǥ��쥯�ȥ��
	 *				���Хѥ�̾����ꤹ�롣
	 */
	ExCell(OzCell globalObject, String god)
	{
		super(god);
		debug = Executor.debug;
		this.globalObject = globalObject;
		setMaxPriority(Thread.MAX_PRIORITY);
		status = new Status(ACTIVE);
	}

	/**
	 * �����Х륢������������ơ��᥽�åɤ�¹ԤǤ�����֤���Ĵ�٤롣
	 * ����ʥ����Х륪�֥������ȡˤ����ܾ��֤ξ��ϡ�
	 * ���֤����ꤹ��ޤ��Ԥġ�â�������ꤵ�줿�Ե����֤��вᤷ�����ġ�
	 * ���λ����Ǿ��֤��Ѳ����ʤ����ϡ�false ���֤���
	 *
	 * @param	waitTime	�Ե����֡ʥߥ��á�
	 * @return				�᥽�åɤ�¹ԤǤ�����֤ξ��ϡ�true ���֤���
	 */
	boolean checkGlobalAccess(long waitTime)
	{
		return status.checkGlobalAccess(waitTime);
	}

	/**
	 * ��������ξ��֤ˤʤ�ޤ��Ԥġ�
	 *
	 * @return			��������ξ��֤ˤʤäƤ�����ϡ�true ���֤���
	 * @exception	InterruptedException
	 *					�̾��ȯ�����ʤ���
	 */
	void watch()
	throws InterruptedException
	{
		status.watch();
	}

	/**
	 * ��������åɤ�ư��Ƥ��륻��ʥ���åɥ��롼�סˤ��֤���
	 * 
	 * @return	����ʥ���åɥ��롼�ס�
	 */
	static
	ExCell currentCell()
	{
		ThreadGroup group = Thread.currentThread().getThreadGroup();
		return (ExCell)group;
	}

	/**
	 * �������ץ������������뤹�뤿��ˡ����Υ���ʥ���åɥ��롼�סˤ�
	 * °���륹��åɤ����ͥ�Ȥ������������¹Ԥ򳫻Ϥ��롣
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * Ʊ�����Ȥߤ�ȤäƤ��뤬�������Х륢�������μ�������Ȥ�
	 * ������Ω�Ǥ���Τǡ��᥽�å� checkGlobalAccess ��ƤӽФ�ɬ�פϤʤ���
	 * </DL>
	 *
	 * @param	caller	�ƤӽФ�¦�Υ���ͥ롢�̾�ϥ��饹 ExProcess �Υ��֥�������
	 * @param	proxy	�̤Υ���åɤǼºݤΥ᥽�åɸƽФ���Ԥ����֥�������
	 * @param	object	�᥽�åɤθƽФ����Ԥ��륪�֥�������
	 * @param	args	�᥽�åɤθƽФ��˻Ȥ������
	 */
	ExChannel fork(ExCallerChannel caller, Runnable proxy, Object object, Object[] args)
	{
		Executor.debug(CN,"fork","("+caller+","+proxy+","+object+",)");
		ExChannel channel = new ExChannel(caller, object, args);
		ExThread t = new ExThread(this, proxy, channel);
		channel.start(t);
		return channel;
	}

	/**
	 * �����Х륢������������ơ��ºݤ˥᥽�åɤ�ƤӽФ������
	 * ������ץ����˹Ԥ碌�뤿��ˡ����Υ����°���륹��åɤ�
	 * ����ͥ�Ȥ������������¹Ԥ򳫻Ϥ��롣
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * ����ͥ����������ޤǡ�����ξ��֤��ѹ��Ǥ��ƤϤʤ�ʤ���
	 * ��̩�ˤϡ�����ʡ����饹 Status �Υ᥽�å� rollback ��
	 * �᥽�å� commit �μ¹Ԥ��å��ʶػߤǤϤʤ��ˤ���Ф褤����
	 * ������ϡ��᥽�å� change ����ޤ�Ƥ��μ¹Ԥ��å����Ƥ��롣
	 * </DL>
	 *
	 * @param	caller	�ƤӽФ�¦�Υ���ͥ�
	 * @param	proxy	�ºݤΥ᥽�åɤ�ƤӽФ����֥�������
	 * @return			����ͥ�
	 * @exception	ClassNotFoundException
	 *					�����Х륢��������Ԥ��ˤϡ����Υ����Х륪�֥������Ȥ�
	 *					���饹���ФˤʤäƤ���ץ����Υ��饹���ʤ���Фʤ�ʤ���
	 * @exception	ExCellNotActiveException
	 *					����ʥ����Х륪�֥������ȡˤϥ����Х륢��������
	 *					�����ơ��б�����᥽�åɤ��¹ԤǤ�����֤ǤϤʤ���
	 * @exception	ExCellNotFoundException
	 *					����ʥ����Х륪�֥������ȡˤ�¸�ߤ��ʤ���
	 */
	ExChannel fork(ExCallerChannel caller, OzProxy proxy)
	throws ClassNotFoundException, ExCellNotActiveException, ExCellNotFoundException
	{
		Executor.debug(CN,"fork","("+caller+","+proxy+")");
		ExChannel channel = null;
		if (proxy instanceof ExProxy) {
			channel = new ExChannel(caller, globalObject, null);
		} else {
			synchronized (status) {
				if (status.checkGlobalAccess(0)) {
					if (globalObject.proxyClassName == null) {
						Executor.syslog(CN,"fork","***** CAUTION proxy class name is null for "
													+globalObject.getClass().getName(),null);
					} else {
						Class c = Executor.loadClass(globalObject.proxyClassName);
						// checkProxy(c,proxy.getClass());
					}
					channel = new ExChannel(caller, globalObject, null);
				} else {
					if (ExCellManager.exists(god)) {
						throw new ExCellNotActiveException(getName());
					} else {
						throw new ExCellNotFoundException(getName());
					}
				}
			}
		}
		ExThread t = new ExThread(this, proxy, channel);
		t.color = ExThread.GREEN;
		channel.start(t);
		return channel;
	}

	/**
	 * �������ץ������������뤹�뤿��ˡ����Υ����°���륹��åɤ�
	 * ����ͥ�Ȥ������������¹Ԥ򳫻Ϥ��롣�����Х륪�֥������Ȥ�
	 * �Ф��ơ������륪�֥������ȤȤ��ƤΥ᥽�åɤθƽФ���Ԥ���
	 * ���������塼�������ν�����Ԥ������ExProcess��
	 * �𤷤ƸƤӽФ���롣
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * ��̩�ˤϡ�ACTIVE���֤Υ�å���ɬ�פǤ��뤬�����������塼������
	 * �ʥ��饹 Executor �Ǻ������줿����ˤ���ACTIVE���֤ˤʤ뤳�ȤϤʤ�
	 * �Τǡ���å����ά���Ƥ��롣
	 * </DL>
	 *
	 * @param	caller	�ƤӽФ�¦�Υ���ͥ롢�̾�ϥ��饹 ExProcess �Υ��֥�������
	 * @param	target	�̤Υ���åɤǼ¹Ԥ����᥽�åɤ���ĥ��֥�������
	 * @param	args	�᥽�åɤθƽФ��˻Ȥ������
	 * @return			����ͥ�
	 */
	ExChannel fork(ExCallerChannel caller, Runnable target, Object[] args)
	{
		Executor.debug(CN,"fork","(caller="+caller+",target="+target+",)");
		ExChannel channel = new ExChannel(caller, globalObject, args);
		ExThread t = new ExThread(this, target, channel);
		t.color = ExThread.GREEN;
		channel.start(t);
		return channel;
	}

	/**
	 * �����Х륪�֥������ȤΥ��饹���ФˤʤäƤ���ץ����Υ��饹��
	 * �Ѿ����Ƥ��뤫�ɤ�����Ĵ�٤롣
	 *
	 * @param	myClass		�����Х륪�֥������ȤΥ��饹���ФΥץ����Υ��饹
	 * @param	proxyClass	�������������饹����Ĵ�٤��о�
	 * @exception			SecurityException
	 *						���Ф�Ƥ����ץ����Υ��֥������Ȥϡ������Х륪�֥������Ȥ�
	 *						���饹���ФΥץ����Υ��饹��Ѿ����Ƥ��ʤ���
	 */
	void checkProxy(Class myClass, Class proxyClass)
	throws SecurityException
	{
		Executor.debug(CN,"checkProxy","("+myClass+","+proxyClass+")");
		//OzProxy p = new OzProxy((String)null);
		//if (globalObject.OZ_Proxy().getClass() != proxy.getClass() && p.getClass() != proxy.getClass()) {
		//	throw new SecurityException("Illegal class of proxy for global object.");
		//}
		do {
			if (myClass == proxyClass) return;
			myClass = myClass.getSuperclass();
		} while (myClass != null);
		throw new SecurityException("Illegal class of proxy for global object.");
	}

	/**
	 * ����������ʥ����Х륪�֥������ȡˤ���������ACTIVE ���֤ˤ��롣
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * ����ʥ���åɥ��롼�סˤΥ᥽�åɤǤϤ��뤬��
	 * ������ǻ��ꤵ�줿������ʸ���������ˤ򱿤֤���ȡ�
	 * ����ʥ����Х륪�֥������ȡˤؤΥ᥽�åɸƤӽФ���
	 * ���Υ��饹����Ω�����뤿��˥ץ�����ɬ�פˤʤäƤ��롣
	 * </DL>
	 *
	 * @param	codePath	�ѥå�����̾��ޤ९�饹̾����ꤹ�롣
	 * @param	proxy		����Υ᥽�åɤ�ƤӽФ�����Υץ�������ꤹ�롣
	 *
	 * @exception		ExIllegalCellStateException
	 *						��������Ԥ����Ȥ��Ǥ��륻��ʥ����Х륪�֥������ȡˤξ��֤ǤϤʤ���
	 * @exception		ExClassNotFoundException
	 *						���� codePath �ǻ��ꤵ�줿���饹�����Ĥ���ʤ���
	 * @exception		ExIllegalAccessException
	 *						����ʥ����Х륪�֥������ȡ���������ȯ�����롣
	 * @exception		ExInstantiationException
	 *						����ʥ����Х륪�֥������ȡ���������ȯ�����롣
	 * @exception		ExCellHookException
	 *						�����Х륪�֥������ȡʥץ����ˤΥ᥽�åɤ��㳰��λ������
	 * @exception		ExException
	 *						���������塼���������㳰��ȯ��������
	 */
	void initializing(String codePath, ExProxy proxy)
	throws ExException
	{
		if (status.change(ACTIVE)) {
			Executor.debug(CN,"initializing",getName()+" status is "+status);
		} else {
			throw new ExIllegalCellStateException("Illegal global object("+getName()+") status("+status+")");
		}
		try {
			try {
				Class c = Executor.loadClass(codePath);
				Object o = c.newInstance() ;
				globalObject = (OzCell)o ;
				ExCellManager.put(god,this);
				ExAddressManager.put(god,ExCommManager.executorAddress);
			} catch (ClassNotFoundException e) {
				throw new ExClassNotFoundException(e.getMessage());
			} catch (IllegalAccessException e) {
				throw new ExIllegalAccessException(e.getMessage());
			} catch (InstantiationException e) {
				throw new ExInstantiationException(e.getMessage());
			} catch (ExException e) {
				throw e;
			} catch (Exception e) {
				Executor.error(CN,"initializing","cell="+getName()+",codePath="+codePath,e);
				throw new ExException(e.getClass().getName());
			}
		} catch (ExException e) {
			globalObject = null;
			status.rollback();
			throw e;
		}

		/*
		 * ����catchʸ�Ǥϡ��桼��������㳰�Τ���ª�����ǽ�������뤬��
		 * �ǥХå��Τ����㳰�ΰ�����ԤäƤ��롣
		 * ����Ū�ˤϥ������ƥ��ۡ���ˤʤ�Τǡ�
		 * �㳰�ΰ����Ϥ��ʤ��褦���ѹ����������褤��
		 */
		try {
			proxy.initialize();
			status.commit();
		} catch (Error e) {
			Executor.error(CN,"initializing","codePath="+codePath+","+"proxy="+proxy,e);
			globalObject = null;
			status.rollback();
			throw e;
		} catch (Exception e) {
			Executor.debug(CN,"initializing","codePath="+codePath+","+"proxy="+proxy,e);
			ExAddressManager.remove(god);
			ExCellManager.remove(god);
			globalObject = null;
			status.rollback();
			throw new ExCellHookException("initialize",e);
		}
	}

	/**
	 * ����ʥ����Х륪�֥������ȡˤ� ACTIVE ���֤ˤ��롣
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * ����ʥ���åɥ��롼�סˤΥ᥽�åɤǤϤ��뤬��
	 * ������ǻ��ꤵ�줿������ʸ���������ˤ򱿤֤���ȡ�
	 * ����ʥ����Х륪�֥������ȡˤؤΥ᥽�åɸƤӽФ���
	 * ���Υ��饹����Ω�����뤿��˥ץ�����ɬ�פˤʤäƤ��롣
	 * </DL>
	 *
	 * @param	proxy		����Υ᥽�åɤ�ƤӽФ�����Υץ�������ꤹ�롣
	 *
	 * @exception		ExIllegalCellStateException
	 *						��������Ԥ����Ȥ��Ǥ��륻��ʥ����Х륪�֥������ȡˤξ��֤ǤϤʤ���
	 * @exception		ExClassNotFoundException
	 *						���֥������ȥ��᡼���ե����뤫�饪�֥������Ȥ�
	 *						�������ɬ�פʥ��饹�����Ĥ���ʤ���
	 * @exception		ExCellImageIOException
	 *						���֥������ȥ��᡼�����ɤ߹�������㳰��ȯ��������
	 * @exception		ExCellHookException
	 *						�����Х륪�֥������ȡʥץ����ˤΥ᥽�åɤ��㳰��λ������
	 * @exception		ExException
	 *						���������塼���������㳰��ȯ��������
	 */
	void activating(ExProxy proxy)
	throws ExException
	{
		if (status.change(ACTIVE)) {
			Executor.debug(CN,"activating",getName()+" status is "+status);
		} else {
			throw new ExIllegalCellStateException("Illegal global object("+getName()+") status("+status+")");
		}
		ExObjectInputStream in = null;
		try {
			try {
				File objectImage = new File(god,objectImageFilename);
				in = new ExObjectInputStream(new FileInputStream(objectImage));
				globalObject = (OzCell)in.readObject();
				in.close();
				ExCellManager.put(god,this);
				ExAddressManager.put(god,ExCommManager.executorAddress);
			} catch (ClassNotFoundException e) {
				throw new ExClassNotFoundException(e.getMessage());
			} catch (IOException e) {
				throw new ExCellImageIOException(e.getMessage());
			} catch (ExException e) {
				throw e;
			} catch (Exception e) {
				Executor.error(CN,"activating","proxy="+proxy,e);
				throw new ExException(e.getClass().getName());
			}
		} catch (ExException e) {
			globalObject = null;
			status.rollback();
			throw e;
		}

		/*
		 * ����catchʸ�Ǥϡ��桼��������㳰�Τ���ª�����ǽ�������뤬��
		 * �ǥХå��Τ����㳰�ΰ�����ԤäƤ��롣
		 * ����Ū�ˤϥ������ƥ��ۡ���ˤʤ�Τǡ�
		 * �㳰�ΰ����Ϥ��ʤ��褦���ѹ����������褤��
		 */
		try {
			proxy.go();
			status.commit();
		} catch (Error e) {
			Executor.error(CN,"activating","proxy="+proxy,e);
			globalObject = null;
			status.rollback();
			throw e;
		} catch (Exception e) {
			Executor.debug(CN,"activating","proxy="+proxy,e);
			ExAddressManager.remove(god);
			ExCellManager.remove(god);
			globalObject = null;
			status.rollback();
			throw new ExCellHookException("go",e);
		}
	}

	/**
	 * ����ʥ����Х륪�֥������ȡˤ� INACTIVE ���֤ˤ��롣
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * ����ʥ���åɥ��롼�סˤΥ᥽�åɤǤϤ��뤬��
	 * ������ǻ��ꤵ�줿������ʸ���������ˤ򱿤֤���ȡ�
	 * ����ʥ����Х륪�֥������ȡˤؤΥ᥽�åɸƤӽФ���
	 * ���Υ��饹����Ω�����뤿��˥ץ�����ɬ�פˤʤäƤ��롣
	 * </DL>
	 *
	 * @param	proxy		����Υ᥽�åɤ�ƤӽФ�����Υץ�������ꤹ�롣
	 *
	 * @exception		ExIllegalCellStateException
	 *						��������Ԥ����Ȥ��Ǥ��륻��ʥ����Х륪�֥������ȡˤξ��֤ǤϤʤ���
	 * @exception		ExCellHookException
	 *						�����Х륪�֥������ȡʥץ����ˤΥ᥽�åɤ��㳰��λ������
	 * @exception		ExException
	 *						���������塼���������㳰��ȯ��������
	 */
	void deactivating(ExProxy proxy)
	throws ExException
	{
		if (status.change(INACTIVE)) {
			Executor.debug(CN,"deactivating",getName()+" status is "+status);
		} else {
			throw new ExIllegalCellStateException("Illegal global object("+getName()+") status("+status+")");
		}

		/*
		 * ����catchʸ�Ǥϡ��桼��������㳰�Τ���ª�����ǽ�������뤬��
		 * �ǥХå��Τ����㳰�ΰ�����ԤäƤ��롣
		 * ����Ū�ˤϥ������ƥ��ۡ���ˤʤ�Τǡ�
		 * �㳰�ΰ����Ϥ��ʤ��褦���ѹ����������褤��
		 */
		try {
			proxy.quiet();
		} catch (Error e) {
			Executor.error(CN,"deactivating","proxy="+proxy,e);
			status.rollback();
			throw e;
		} catch (Exception e) {
			Executor.debug(CN,"deactivating","proxy="+proxy,e);
			throw new ExCellHookException("quiet",e);
		} finally {
			ExAddressManager.remove(god);
			ExCellManager.remove(god);
			status.commit();
		}
	}

	/**
	 * ����ʥ����Х륪�֥������ȡˤ� REMOVED ���֤ˤ��롣
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * ����ʥ���åɥ��롼�סˤΥ᥽�åɤǤϤ��뤬��
	 * ¾�ξ��֤��ѹ�����᥽�åɤ˹�碌�뤿���
	 * �ץ�����ɬ�פˤʤäƤ��롣
	 * </DL>
	 *
	 * @param	proxy		����Υ᥽�åɤ�ƤӽФ�����Υץ�������ꤹ�롣
	 *
	 * @exception	ExException
	 *					���������塼���������㳰��ȯ��������
	 */
	void removing(ExProxy proxy)
	throws ExException
	{
		if (status.change(REMOVED)) {
			Executor.debug(CN,"removing",getName()+" status is "+status);
		} else {
			throw new ExIllegalCellStateException("Illegal global object("+this+")");
		}
		try {
			File objectImage = new File(god,objectImageFilename);
			File backup = new File(god,objectImageFilename+"Backup");
			File tempolary = new File(god,objectImageFilename+"Tempolary");
			if (objectImage.exists() && ! objectImage.delete()) {
				Executor.error(CN,"remove","Fail to delete "+objectImage);
			}
			if (backup.exists() && ! backup.delete()) {
				Executor.error(CN,"remove","Fail to delete "+backup);
			}
			if (tempolary.exists() && ! tempolary.delete()) {
				Executor.error(CN,"remove","Fail to delete "+tempolary);
			}
		} catch (Exception e) {
			Executor.error(CN,"removing","proxy="+proxy,e);
			throw new ExException(e.getClass().getName());
		} finally {
			ExAddressManager.remove(god);
			ExCellManager.remove(god);
			status.commit();
		}
	}

	/**
	 * ����ʥ����Х륪�֥������ȡˤΥ��֥������ȥ᡼����
	 * ���ꤵ�줿�ե�����˽񤭹��ࡣ
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * ���Υ᥽�åɤ�¹���ϡ�����ξ��֤��ѹ��Ǥ��ƤϤʤ�ʤ���
	 * ��̩�ˤϡ�����ʡ����饹 Status �Υ᥽�å� rollback ��
	 * �᥽�å� commit �μ¹Ԥ��å��ʶػߤǤϤʤ��ˤ���Ф褤����
	 * ������ϡ��᥽�å� change ����ޤ�Ƥ��μ¹Ԥ��å����Ƥ��롣
	 * <DT>
	 * ����ա�<DD>
	 * �֥���å���פ��㳰���������ơ����Ū�ʥե�����˸��ߤ�
	 * ���֥������ȥ��᡼����񤭹������ǥե�����̾���ѹ��ˤ��
	 * ���֥������ȥ��᡼���Υե�������ѹ����Ƥ��롣
	 * �ǰ��ξ��֤����ꤷ�ơ������ΰ�Ϣ�ν�����Ԥ�ľ����
	 * ���֥������ȥ��᡼���Υե������Хå����åפȤ��ƻĤ��Ƥ��롣
	 * </DL>
	 *
	 * @param	oiFilename	���֥������ȥ��᡼���ե�����̾
	 * @exception		ExCellImageIOException
	 *						���֥������ȥ��᡼���Υե�����ؤν񤭹��ߤ��㳰��ȯ��������
	 * @exception		ExException
	 *						���������塼���������㳰��ȯ��������
	 */
	private
	void flush(String oiFilename)
	throws ExException
	{
		synchronized (status) {
			Executor.debug(CN,"flush","start "+this.getName());
			ExObjectOutputStream out = null;
			File objectImage = new File(god,oiFilename);
			File current = new File(god,oiFilename);
			File backup = new File(god,oiFilename+"Backup");
			File tempolary = new File(god,oiFilename+"Tempolary");
			try {
				out = new ExObjectOutputStream(new FileOutputStream(tempolary));
				out.writeObject(globalObject);
				out.close();
			} catch (IOException e) {
				Executor.error(CN,"flush","god="+getName(),e);
				if (! tempolary.delete()) {
					Executor.error(CN,"flush","Fail to delete "+tempolary);
				}
				throw new ExCellImageIOException(e.getMessage()+"("+getName()+")");
			}
			if (backup.exists() && ! backup.delete()) {
				Executor.error(CN,"flush","Fail to delete "+backup);
			}
			if (current.exists() && ! current.renameTo(backup)) {
				Executor.error(CN,"flush","Fail to rename "+current);
			}
			if (! tempolary.renameTo(objectImage)) {
				Executor.error(CN,"flush","Fail to rename "+tempolary);
			}
			Executor.debug(CN,"flush","finish "+this.getName());
		}
	}

	/**
	 * ����ʥ����Х륪�֥������ȡˤΥ��֥������ȥ᡼����
	 * �ե�����˽񤭹��ࡣ
	 *
	 * @exception		ExException
	 *						���������塼���������㳰��ȯ��������
	 *
	 * @see	ExCell#flush(String)
	 */
	void flush()
	throws ExException
	{
		flush(objectImageFilename);
	}

	/**
	 * ����ʥ���åɥ��롼�סˤ�����Ū�˳�������GOD�Υ�å��������롣
	 *
	 * @exception			ExException
	 *						�㳰��ȯ��������
	 */
	synchronized
	void free()
	throws ExException
	{
		try {
			god.release();
		} catch (Exception e) {
			Executor.error(CN,"free","god="+getName(),e);
			throw new ExException(e.getClass().getName());
		}
		status.change(FREE);
		status.commit();
		globalObject = null;
		setDaemon(true);
		if (activeCount()==0) destroy();
	}

	/**
	 * ���Υ����°���Ƥ��륹��åɤΰ�����ɽ�����롣
	 *
	 * @param	indent	�ƹԤ���Ƭ���������륹�ڡ�����ʸ������
	 */
	synchronized
	void list(PrintWriter out, int indent)
	{
		char[] chars = new char[indent];
		for (int i = 0; i < indent; i ++) chars[i] = ' ';
		String spaces = new String(chars);
		Thread[] list = new Thread[activeCount()];
		int n = enumerate(list);
		for (int i = 0; i < n; i ++) {
			if (list[i].getThreadGroup() == this) {
				if (list[i] instanceof ExThread) {
					ExThread t = (ExThread)list[i];
					out.println(spaces+t+" "+t.channel);
				} else {
					out.println(spaces+list[i]);
				}
			}
		}
	}

	/**
	 * �����ɽ����ǽ��ʸ������Ѵ����롣
	 * ����ΰ���ɽ����Ԥ��ݤ˴���Ū�˸ƤӽФ���뤳�Ȥ����ꤷ�Ƥ��롣
	 * ʸ��������Ƥˤϡ����饹̾����ʬ�˥ѥå�����̾��ޤޤʤ���
	 * ����ξ��֤�ɽ��ʸ������ɲä��Ƥ���������դ��롣
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * �����ǤϥǥХå�����Ū�˸ƤӽФ����⤢��Τǡ�
	 * ����ץ�����ƤˤϤ��Ƥ��ʤ���
	 * </DL>
	 *
	 * @see	ThreadGroup#getName
	 * @see	ThreadGroup#getMaxPriority
	 */
	public
	String toString()
	{
		return CN + "@" + Integer.toHexString(hashCode())
				+ "[name="+getName() + ",maxpri="+getMaxPriority() + ",status="+status+"]";
	}

	/**
	 * �桼���ץ����˰����Ϥ�ʸ���������򻲾Ȥ��롣
	 *
	 * @return	�桼���ץ������Ϥ�ʸ���������
	 *
	 * @see	OzSystem#getArguments()
	 * @see	ExCell#setArguments()
	 * @see	ExCell#arguments
	 */
	String[] getArguments()
	{
		return this.arguments;
	}

	/**
	 * �桼���ץ����˰����Ϥ�ʸ�������������ꤹ�롣
	 *
	 * @param	�桼���ץ������Ϥ�ʸ���������
	 *
	 * @see	OzSystem#getArguments()
	 * @see	ExCell#getArguments()
	 * @see	ExCell#arguments
	 */
	void setArguments(String[] arguments)
	{
		this.arguments = arguments;
	}

	/**
	 * ��������Υ������ƥ��Υݥꥷ����ô�����֥������Ȥ����ꤹ�롣
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * �����ʻ��ͤǤϤʤ���
	 * </DL>
	 *
	 * @param	us	�������ƥ��Υݥꥷ����ô�����֥�������
	 */
	void setUserSecurity(OzUserSecurity us)
	{
		this.us = us;
	}

	/**
	 * ��������Υ������ƥ��Υݥꥷ����ô�����֥������Ȥ򻲾Ȥ��롣
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * �����ʻ��ͤǤϤʤ���
	 * </DL>
	 *
	 * @return	us	�������ƥ��Υݥꥷ����ô�����֥�������
	 */
	OzUserSecurity getUserSecurity()
	{
		return us;
	}
}
