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
 * $Id: ExCellManager.java,v 2.1.1.1 1997/07/15 06:20:45 yoshi Exp $
 *
 * ���: ���Υե������ vi �ǡ�hardtab=8, tabstop=4 �Ȥ����Խ�����Ƥ���
 */

package JP.go.ipa.oz.system;

import java.io.PrintWriter;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Enumeration;

/**
 * ���������塼���˥��ɤ���Ƥ��륻��ʥ���åɥ��롼�סˤΥơ��֥�������
 * GOD̾���饻��ؤ��Ѵ��䥻��ξ��֤����ܤ�Ԥ����ʥ�������ϡ�
 * ���������塼���ϥ�������򤳤Υ��饹��𤷤ƹԤ���
 * �̾�Υ����Х륢�������μ�������Ǥϡ����뤬�ơ��֥����Ͽ����Ƥ���
 * ���Ȥ���ǧ����롣
 *
 * <DL><DT>
 * ����ա�<DD>
 * ���Υ��饹����Ū�ϡ����������塼�����ΤΥ���ʳ���
 * ���ƤΥ���ʥ���åɥ��롼�סˤ�������뤳�Ȥˤ��롣
 * </DL>
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:45 $
 * @author		Yasumitsu Yoshida
 *
 * @see	ExChannel#fork
 */
class ExCellManager
{
	/**
	 * ���������塼�������ΥǥХå���
	 */
	static final String CN = "ExCellManager";

	/**
	 * ���֥������ȥ��᡼���ե�����̾
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * ���֥������ȥ��᡼���Υե�����̾�ϥ�����������
	 * ���Υ��饹����Ϳ���뤳�Ȥˤ�ꡢ����������ǽ�ˤ��롣
	 * </DL>
	 *
	 */
	private static final String objectImageFilename = ".objectImage";

	/**
	 * GOD̾�򥭡��Ȥ��ƥ���ʥ���åɥ��롼�סˤ����뤿��Υơ��֥�Ǥ��롣
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * ���Υơ��֥�ؤ���Ͽ�ϡ���α�����ݤ��̤Ȥ���
	 * �����Х륢�������μ���������̣���롣
	 * </DL>
	 */
	private static Dictionary cells = new Hashtable();

	/**
	 * ����åȥ�������������Ϥ��줿���Ȥ򼨤��ե饰�Ǥ��롣
	 * ����åȥ�������������Ϥ����ȡ�����γ�������
	 * ����γ������β����ǹԤ���ơ��֥�ؤ���Ͽ�ϤǤ��ʤ��ʤ롣
	 */
	private static boolean shutdown = false;

	/**
	 * ���ꤵ�줿GOD̾�򸡺����롣
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * ����åȥ���������β������Գ����������
	 * ����ʥ����Х륪�֥������ȡˤ������Х륢��������
	 * ɬ�פȤ����ǽ�������뤿��˥����Х륢��������
	 * �����������ݤǤ��ʤ���
	 * </DL>
	 *
	 * @param	god		GOD���֥�������
	 * @return			���롢���Ĥ���ʤ���� null ���֤���
	 *
	 * @see	ExCellManager#cells
	 */
	static synchronized
	ExCell get(ExGOD god)
	{
		return (ExCell)cells.get(god);
	}

	/**
	 * ���ꤵ�줿�ץ������Ф���򸡺����롣
	 *
	 * @param	proxy	�ץ���
	 * @return			���롢���Ĥ���ʤ���� null ���֤���
	 *
	 * @see	ExCellManager#cells
	 * @see	ExCellManager#get(ExGOD)
	 */
	static synchronized
	ExCell get(OzProxy proxy)
	throws ExIllegalCellStateException
	{
		try {
			return get(new ExGOD(proxy));
		} catch (ExCellIllegalOzHomeException e) {
			return null;
		}
	}

	/**
	 * ���ꤵ�줿GOD̾����Ͽ���롣
	 *
	 * @param	god		GOD���֥�������
	 * @param	cell	����
	 * @return			������Ͽ����Ƥ������롢��Ͽ����Ƥ��ʤ���� null ���֤���
	 *
	 * @exception	ExIllegalCellStateException
	 *					����åȥ���������Τ��ῷ���ʥ������Ͽ�ϤǤ��ʤ���
	 * @see	ExCellManager#cells
	 */
	static synchronized
	ExCell put(ExGOD god, ExCell cell)
	throws ExIllegalCellStateException
	{
		if (shutdown) {
			throw new ExIllegalCellStateException("shutdown in progress");
		}
		return (ExCell)cells.put(god,cell);
	}

	/**
	 * ���ꤵ�줿GOD̾�������롣
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * ����åȥ���������β����ǡ�����ʥ���åɥ��롼�סˤ���
	 * ���Υ᥽�åɤ��ƤӽФ����Τǡ����Υ᥽�åɼ��Τ�
	 * synchronized�ˤ��ƤϤʤ�ʤ���
	 * </DL>
	 *
	 * @param	god		GOD���֥�������
	 * @return			��Ͽ����Ƥ������롢��Ͽ����Ƥ��ʤ���� null ���֤���
	 *
	 * @see	ExCellManager#cells
	 */
	static
	ExCell remove(ExGOD god)
	{
		ExCell result;
		synchronized (cells) {
			result = (ExCell)cells.remove(god);
			if (cells.isEmpty()) {
				cells.notifyAll();
			}
		}
		return result;
	}

	/**
	 * ��Ͽ����Ƥ��륻������֤���
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * �ơ��֥�ξ��֡ʥ���åȥ���������椫�ɤ������ˤ�
	 * �ط��ʤ��䤤��碌���Ǥ���褦�ˤ��뤿��ˡ�
	 * ���Υ᥽�åɼ��Τ�synchronized�ˤ��ƤϤʤ�ʤ���
	 * </DL>
	 *
	 * @return	��Ͽ����Ƥ��륻���
	 */
	static
	int size()
	{
		return cells.size();
	}

	/**
	 * ��Ͽ����Ƥ��륻�뤬�ʤ�����Ĵ�٤롣
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * �ơ��֥�ξ��֡ʥ���åȥ���������椫�ɤ������ˤ�
	 * �ط��ʤ��䤤��碌���Ǥ���褦�ˤ��뤿��ˡ�
	 * ���Υ᥽�åɼ��Τ�synchronized�ˤ��ƤϤʤ�ʤ���
	 * </DL>
	 *
	 * @return	��Ͽ����Ƥ��륻�뤬�ʤ���С�true ���֤���
	 */
	static
	boolean isEmpty()
	{
		return cells.isEmpty();
	}

	/**
	 * ���ꤵ�줿GOD�˷���դ���줿����ʥ����Х륪�֥������ȡˤ�
	 * ¸�ߤ��뤫�ɤ�����Ĵ�٤롣
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * �ơ��֥�ξ��֡ʥ���åȥ���������椫�ɤ������ˤ�
	 * �ط��ʤ��䤤��碌���Ǥ���褦�ˤ��뤿��ˡ�
	 * ���Υ᥽�åɼ��Τ�synchronized�ˤ��ƤϤʤ�ʤ���
	 * </DL>
	 *
	 * @param	god		Ĵ�٤��оݤΥ�������ꤹ�뤿���GOD���֥�������
	 * @return			���뤬¸�ߤ��Ƥ�����ϡ�true ���֤���
	 */
	static
	boolean exists(ExGOD god)
	{
		if (god.exists() && god.isDirectory()) {
			if (get(god) == null) {
				File objectImage = new File(god,objectImageFilename);
				if (ExAddressManager.exists(god) || objectImage.exists()) {
					return true;
				}
			} else {
				return true;
			}
		}
		return false;
	}

	/**
	 * ����åȥ�������������Ϥ��줿���ɤ�����Ĵ�٤롣
	 *
	 * @return	����åȥ�������������Ϥ���Ƥ����硢true ���֤���
	 */
	static synchronized
	boolean isShutdown()
	{
		return shutdown;
	}

	/**
	 * ����åȥ���������Ȥ��ơ����ƤΥ�����Ф�����������ξ��֤�
	 * �ʤ�褦�˾������ܤ�Ԥ������ˡ�����åȥ�������������Ϥ���Ƥ���
	 * ���ϲ��⤷�ʤ���
	 *
	 * @return	���˥���åȥ�����������Ԥ��Ƥ�����ϡ�false ���֤���
	 */
	static private synchronized
	boolean shutdown()
	{
		ExGOD[] gods;
		int count = 0;

		// �����ʥ���γ�������ػߤ��롣
		if (shutdown) return false;
		shutdown = true;

		// ��Ͽ����Ƥ��륻���GOD�Υꥹ�Ȥ�������롣
		gods = new ExGOD[cells.size()];
		Enumeration keys = cells.keys();
		while (keys.hasMoreElements()) gods[count++] = (ExGOD)keys.nextElement();

		// �ƥ��������������ν�����Ԥ��ץ������������롣
		for (int i = 0; i < count; i ++) {
			ExCell cell = get(gods[i]);
			if (cell == null) {
				// �����ߥ󥰤ˤ�ꤳ�ξ��֤�ȯ�����뤬�����פ�����ǤϤʤ���
				Executor.error(CN,"shutdown","Warning: Not found cell with "+gods[i].getName());
			} else {
				try {
					/*
					 *  Executor#userGracePeriod��᥽�å� ExCellManager#quit ���Ϥ�����ˡ�
					 * �����ܤΥѥ�᡼���ϻ��ꤷ�ʤ���
					 */
					Object[] params = new Object[2];
					params[0] = new Integer(Executor.QUIT);
					params[1] = gods[i];
					Executor.syscall(params);
				} catch (Exception e) {
					Executor.error(CN,"shutdown","Ignore: Raised exception with "+gods[i].getName(),e);
				}
			}
		}

		return shutdown;
	}

	/**
	 * ���ꤵ�줿���֤��вᤷ���顢���ƤΥ���Υ���åɤ���ߤ�����
	 * GOD�γ������ν�����Ԥäơ��������Ū����������ξ��֤ˤ��롣
	 * â�����оݤȤʤ륻�뤬�ʤ���Фʤˤ⤷�ʤ���
	 *
	 * @param	gracePeriod		�����򳫻Ϥ���ޤǤ��Ԥ����֡ʥߥ��á�
	 */
	static synchronized
	void halt(long gracePeriod)
	throws InterruptedException
	{
		Executor.debug(CN,"halt","(gracePeriod="+gracePeriod+")");

		ExGOD[] gods;
		int count = 0;

		// �����ʥ������Ͽ��ػߤ��롣
		shutdown = true;

		// ��Ͽ����Ƥ��륻���GOD�Υꥹ�Ȥ�������롣
		gods = new ExGOD[cells.size()];
		Enumeration keys = cells.keys();
		while (keys.hasMoreElements()) gods[count++] = (ExGOD)keys.nextElement();

		// ���ƤΥ���åɤ���ߤ�����
		for (int i = 0; i < count; i ++) {
			ExCell cell = get(gods[i]);
			if (cell == null) {
				// �����ߥ󥰤ˤ�ꤳ�ξ��֤�ȯ�����뤬�����פ�����ǤϤʤ���
				Executor.error(CN,"halt","Warning: Not found cell with "+gods[i].getName());
			} else {
				Executor.syslog(CN,"halt","***** FORCE TO STOP ALL THREAD "+cell.toString(),null);
				try {
					/*
					 * cells �����ˤʤ�ޤǾ���Ԥ����Ƥ��륹��åɤ�����Τǡ�
					 * cells ���Ф��ƥ᥽�å� remove ��ľ�ܸƤӽФ��ƤϤ����ʤ���
					 */
					remove(gods[i]);
					cell.stop();
				} catch (Exception e) {
					Executor.error(CN,"halt","Ignore: Raised exception with "+cell,e);
				}
			}
		}

		// �ƥ������Ū������������롣
		if (gracePeriod != 0 && ! isEmpty()) Thread.sleep(gracePeriod);
		for (int i = 0; i < count; i ++) {
			Executor.syslog(CN,"halt","***** FORCE TO RELEASE GOD LOCK "+gods[i].getPath(),null);
			try {
				if (gods[i].knock()) gods[i].release();
			} catch (Exception e) {
				Executor.error(CN,"halt","Ignore: Raised exception with "+gods[i],e);
			}
		}

		Executor.debug(CN,"halt","return");
	}

	/**
	 * ��������Ϥ���ߤ��롣
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * ����åȥ���������β����ǡ��̥���åɤǥ���Υơ��֥����
	 * �Ԥ���Τǡ����Υ᥽�åɼ��Τ�synchronized�ˤ��ƤϤʤ�ʤ���
	 * </DL>
	 *
	 * @param	gracePeriod	����Ū�����ƤΥ���������������ޤǤ��Ե����֡ʥߥ��á�
	 */
	static
	void shutdown(long gracePeriod)
	throws Exception
	{
		Executor.debug(CN,"shutdown","(gracePeriod="+gracePeriod+")");

		// ���ƤΥ�����Գ��������롣
		if (shutdown()) {
			// ���ꤵ�줿���֤��вᤷ���顢����Ū�����ƤΥ��������������롣
			Object[] params;
			params = new Object[2];
			params[0] = new Integer(Executor.HALT);
			params[1] = new Long(gracePeriod);
			Executor.syscall(params);
		}

		// ���ƤΥ��뤬�����������ޤ��Ե����롣
		synchronized (cells) {
			while (! cells.isEmpty()) {
				cells.wait();
			}
		}
		Executor.debug(CN,"shutdown","return");
	}

	/**
	 * ����ξ��֤γ�����Ԥäơ��������������ξ��֤ˤ��롣
	 * ���뤬����������Ƥ��ʤ������뤤�ϡ����ꤷ���������
	 * ����ξ��֤����ꤷ�ʤ���С����⤷�ʤ��ǽ�λ���롣
	 *
	 * @param	god		����������륻���GOD���֥�������
	 * @param	gracePeriod	����ξ��֤γ�����ԤĻ��֡ʥߥ��á�
	 */
	static
	void quit(ExGOD god, long gracePeriod)
	throws ExException
	{
		Executor.debug(CN,"quit","(god="+god+",gracePeriod="+gracePeriod+")");
		ExCell cell = get(god);
		if (cell != null && cell.checkGlobalAccess(gracePeriod)) {
			try {
				Executor.syslog(CN,"quit","***** DEACTIVATE "+cell.toString(),null);
				cell.deactivating(new ExProxy(cell.getName()));
				cell.free();
				Executor.syslog(CN,"quit","***** COMPLETE   "+cell.toString(),null);
			} catch (ExException e) {
				cell.free();
				Executor.syslog(CN,"quit","***** INCOMPLETE "+cell.toString(),e);
			}
		}
		Executor.debug(CN,"quit","return");
	}

	/**
	 * ���饹 ExCellManager �ϣ��ĤΥ��������塼����
	 * ���ĤǤ��ꡢư����˼������ѹ�����뤳�Ȥ�ʤ���
	 * ���äơ����饹 ExCellManager ��Ȥä�
	 * ���֥������Ȥ��������ʤ��褦�ˤ���
	 * static�᥽�åɤΤߤ�������롣
	 */
	private
	ExCellManager()
	{
		/* Nothing */
	}

	/**
	 * ����������ʥ����Х륪�֥������ȡˤ�������롣
	 *
	 * @see	OzCellManager#create
	 */
	static
	void create(String codePath, ExProxy proxy)
	throws ExException
	{
		Executor.debug(CN,"create","(codePath="+codePath+",proxy="+proxy+")");
		ExGOD god = new ExGOD(proxy);
		if (isShutdown()) throw new ExIllegalCellStateException(god.getName());
		ExCell cell = new ExCell(god,objectImageFilename);
		try {
			cell.initializing(codePath,proxy);
		} catch (ExException e) {
			cell.free();
			throw e;
		}
	}

	/**
	 * ����ʥ����Х륪�֥������ȡˤ���������롣
	 *
	 * @see	OzCellManager#go
	 */
	static
	void activate(ExProxy proxy)
	throws ExException
	{
		Executor.debug(CN,"activate","(proxy="+proxy+")");
		ExGOD god = new ExGOD(proxy);
		if (isShutdown()) throw new ExIllegalCellStateException(god.getName());
		ExCell cell = ExCell.find(god,objectImageFilename);
		try {
			cell.activating(proxy);
		} catch (ExException e) {
			cell.free();
			throw e;
		}
	}

	/**
	 * ����ʥ����Х륪�֥������ȡˤ��Գ��������롣
	 *
	 * @see	OzCellManager#stop
	 */
	static
	void deactivate(ExProxy proxy)
	throws ExException
	{
		Executor.debug(CN,"deactivate","(proxy="+proxy+")");
		ExCell cell = get(proxy);
		if (cell == null) {
			throw new ExCellNotFoundException(proxy.getName());
		}
		try {
			cell.deactivating(proxy);
			cell.free();
		} catch (ExException e) {
			cell.free();
			throw e;
		}
	}

	/**
	 * ����ʥ����Х륪�֥������ȡˤ������롣
	 *
	 * @see	OzCellManager#remove
	 */
	static
	void remove(ExProxy proxy)
	throws ExException
	{
		Executor.debug(CN,"remove","(proxy="+proxy+")");
		ExCell cell = get(proxy);
		if (cell == null) {
			throw new ExCellNotFoundException(proxy.getName());
		}
		try {
			cell.removing(proxy);
			cell.free();
		} catch (ExException e) {
			cell.free();
			throw e;
		}
	}

	/**
	 * ����ʥ����Х륪�֥������ȡˤ�ե�å��夹�롣
	 *
	 * @see	ExCell#flush
	 */
	static
	void flush(OzProxy proxy)
	throws ExException
	{
		Executor.debug(CN,"flush","(proxy="+proxy+")");
		ExCell cell = get(proxy);
		if (cell == null) {
			throw new ExCellNotFoundException(proxy.getName());
		}
		try {
			cell.flush();
		} catch (ExException e) {
			throw e;
		}
	}

	/*
	 * ����ʹߤϥǥХå��ȥ�����Τ���Υץ����Ǥ��롣
	 * �ʾܺ٤Ͼ�ά��
	 */
	static {

		/**
		 * ����ʥ����Х륪�֥������ȡˤ�������륳�ޥ��
		 */
		class Create
		extends ExShellCommand
		{
			Create()
			{
				usage = " <god> <class> [args...]";
				comment = "create global object";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length < 3) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too few arguments");
				}

				String codePath = (String)args[2];
				if (codePath.startsWith("released.")) {
					codePath = Executor.IPAozUser+codePath;
				} else if (codePath.startsWith("user.")) {
					codePath = Executor.IPAoz+codePath;
				} else if (codePath.startsWith("system.")) {
					codePath = Executor.IPAoz+codePath;
				} else if (codePath.startsWith("tools.")) {
					codePath = Executor.IPA+codePath;
				} else if (codePath.startsWith("tests.")) {
					codePath = Executor.IPA+codePath;
				}

				String[] newArgs;
				if (3 < args.length) {
					newArgs = new String[args.length-3];
					System.arraycopy(args, 3, newArgs, 0, args.length-3);
				} else newArgs = null;
				OzProxy proxy = new ExProxy(args[1],newArgs);
				try {
					Object[] argv = new Object[3];
					argv[0] = new Integer(Executor.CREATE);
					argv[1] = codePath;
					argv[2] = proxy;
					OzProcess p = Executor.syscall(argv);
					p.join();
				} catch (ExProcessException e) {
					Exception ee = e.getException();
					throw e.getException();
				}

				return proxy.getName();
			}
		}

		/**
		 * ����ʥ����Х륪�֥������ȡˤ���������륳�ޥ��
		 */
		class Activate
		extends ExShellCommand
		{
			Activate()
			{
				usage = " <god> [args...]";
				comment = "activate global object";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length < 2) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too few arguments");
				}

				String[] newArgs;
				if (2 < args.length) {
					newArgs = new String[args.length-2];
					System.arraycopy(args, 2, newArgs, 0, args.length-2);
				} else newArgs = null;
				OzProxy proxy = new ExProxy(args[1],newArgs);
				try {
					Object[] argv = new Object[2];
					argv[0] = new Integer(Executor.GO);
					argv[1] = proxy;
					OzProcess p = Executor.syscall(argv);
					p.join();
				} catch (ExProcessException e) {
					throw e.getException();
				}

				return proxy.getName();
			}
		}

		/**
		 * ����ʥ����Х륪�֥������ȡˤ��Գ��������륳�ޥ��
		 */
		class Deactivate
		extends ExShellCommand
		{
			Deactivate()
			{
				usage = " <god> [args...]";
				comment = "deactivate global object";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length < 2) {
					shell.stderr.println("Usage: "+args[0]+"usage");
					throw new IllegalArgumentException("Too few arguments");
				}

				String[] newArgs;
				if (2 < args.length) {
					newArgs = new String[args.length-2];
					System.arraycopy(args, 2, newArgs, 0, args.length-2);
				} else newArgs = null;
				OzProxy proxy = new ExProxy(args[1],newArgs);
				try {
					Object[] argv = new Object[2];
					argv[0] = new Integer(Executor.STOP);
					argv[1] = proxy;
					OzProcess p = Executor.syscall(argv);
					p.join();
				} catch (ExProcessException e) {
					throw e.getException();
				}

				return proxy.getName();
			}
		}

		/**
		 * ����ʥ����Х륪�֥������ȡˤ������륳�ޥ��
		 */
		class Remove
		extends ExShellCommand
		{
			Remove()
			{
				usage = " <god>";
				comment = "remove global object";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length != 2) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too few or many arguments");
				}

				OzProxy proxy = new ExProxy(args[1]);
				try {
					Object[] argv = new Object[2];
					argv[0] = new Integer(Executor.REMOVE);
					argv[1] = proxy;
					OzProcess p = Executor.syscall(argv);
					p.join();
				} catch (ExProcessException e) {
					throw e.getException();
				}

				return proxy.getName();
			}
		}

		/**
		 * ����ʥ����Х륪�֥������ȡˤΰ�����������륳�ޥ��
		 */
		class ListCell
		extends ExShellCommand
		{
			ListCell()
			{
				usage = " [<god]";
				comment = "list of cells on memory";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (2 < args.length) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too many arguments");
				}

				if (args.length == 2) {
					ExCell cell = get(new ExGOD(args[1]));
					if (cell != null) {
						shell.stdout.println(cell+" "+args[1]);
					}
				} else {
					Enumeration keys = cells.keys();
					while (keys.hasMoreElements()) {
						ExGOD god = (ExGOD)keys.nextElement();
						shell.stdout.println(get(god)+" "+god.getName());
					}
				}
				return null;
			}
		}

		/**
		 * ����ʥ����Х륪�֥������ȡˤ�������åɤ�����ߤ��륳�ޥ��
		 */
		class Suspend
		extends ExShellCommand
		{
			Suspend()
			{
				usage = " <god>";
				comment = "suspend all thread in cell";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length != 2) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too few or many arguments");
				}

				ThreadGroup g = Thread.currentThread().getThreadGroup().getParent();
				ThreadGroup[] list = new ThreadGroup[g.activeGroupCount()];
				int n = g.enumerate(list);
				for (int i = 0; i < n; i ++) {
					if (list[i].getName().equals(args[1])) {
						list[i].suspend();
						break;
					}
				}

				return null;
			}
		}

		/**
		 * ����ʥ����Х륪�֥������ȡˤ�������åɤ�Ƴ����륳�ޥ��
		 */
		class Resume
		extends ExShellCommand
		{
			Resume()
			{
				usage = " <god>";
				comment = "resume all thread in cell";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length != 2) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too few or many arguments");
				}

				ThreadGroup g = Thread.currentThread().getThreadGroup().getParent();
				ThreadGroup[] list = new ThreadGroup[g.activeGroupCount()];
				int n = g.enumerate(list);
				for (int i = 0; i < n; i ++) {
					if (list[i].getName().equals(args[1])) {
						list[i].resume();
						break;
					}
				}
				return null;
			}
		}


		/**
		 * ����ʥ����Х륪�֥������ȡˤ�ƻ뤹�롣
		 */
		class Watch
		extends ExShellCommand
		{
			Watch()
			{
				usage = " <god>";
				comment = "watch cell to inactive";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length != 2) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too few or many arguments");
				}

				ExGOD god = new ExGOD(args[1]);
				ExCell cell = ExCellManager.get(god);
				if (cell == null) {
					throw new ExCellNotFoundException(god.getName());
				}
				cell.watch();
				return null;
			}
		}

		/**
		 * ����ʥ����Х륪�֥������ȡˤξ��֤�������롣
		 */
		class Stat
		extends ExShellCommand
		{
			Stat()
			{
				usage = " <god>";
				comment = "print status of cell";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (2 != args.length) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too few or many arguments");
				}

				ExCell cell = get(new ExGOD(args[1]));
				if (cell != null) {
					shell.stdout.println(args[1]+" "+cell);
				} else {
					ExGOD god = new ExGOD(args[1]);
					File objectImage = new File(god,objectImageFilename);
					if (god.exists() && god.isDirectory()) {
						if (god.knock()) {
							if (ExAddressManager.exists(god)) {
								shell.stdout.println(args[1]+" Active");
							} else {
								shell.stdout.println(args[1]+" Acquired");
							}
						} else {
							if (objectImage.exists()) {
								shell.stdout.println(args[1]+" Inactive");
							} else {
								shell.stdout.println(args[1]+" Released");
							}
						}
					} else {
						shell.stdout.println(args[1]+" Nothing");
					}
				}

				return null;
			}
		}

		/**
		 * ����åɰ�����������롣
		 */
		class ListThread
		extends ExShellCommand
		{
			ListThread()
			{
				usage = " [<god>]";
				comment = "list of threads";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (2 < args.length) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too many arguments");
				}

				ThreadGroup g = Thread.currentThread().getThreadGroup().getParent();
				ThreadGroup[] list = new ThreadGroup[g.activeGroupCount()];
				int n = g.enumerate(list);
				boolean specify = (args.length == 2) ? true : false;
				for (int i = 0; i < n; i ++) {
					if (!specify || list[i].getName().equals(args[1])) {
						shell.stdout.println(list[i]);
						if (list[i] instanceof ExCell) {
							ExCell cell = (ExCell)list[i];
							cell.list(shell.stdout,4);
						}
						if (specify) break;
					}
				}

				return null;
			}
		}

		/**
		 * �����Х륪�֥������ȤΥǥ��쥯�ȥ��ɽ�����롣
		 */
		class ListGOD
		extends ExShellCommand
		{
			ListGOD()
			{
				usage = " [-a] [<path>]";
				comment = "list of GOD";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length > 3) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too many arguments");
				}

				FilenameFilter filter = null;
				String dirname = null;
				File path;
				int i;
				for (i = 1; i < args.length; i ++) {
					if (args[i].startsWith("-")) {
						if (args[i].equals("-a")) {
							filter =
								new FilenameFilter() {
										public
										boolean accept(File dir, String name)
										{
											return true;
										}
									};
							dirname = "";
						} else {
							shell.stderr.println("Usage: "+args[0]+usage);
							throw new IllegalArgumentException("Too many arguments");
						}
					} else break;
				}
				if (i == args.length) {
					if (dirname == null) dirname = "";
					path = new ExGOD("");
				} else {
					if (args.length-i == 1) {
						if (dirname == null) dirname = args[i]+".";
						path = new ExGOD(args[i]);
					} else {
							shell.stderr.println("Usage: "+args[0]+usage);
							throw new IllegalArgumentException("Too many arguments");
					}
				}
				if (filter == null) {
					filter =
						new FilenameFilter() {
							public
							boolean accept(File dir, String name)
							{
								File file = new File(dir, name);
								if (file.isDirectory()) {
									File objectImage = new File(file, objectImageFilename);
									if (objectImage.exists()) return true;
								}
								return false;
								// File path = new File(dir,name);
								// return path.isDirectory();
							}
						};
				}

				if (!path.exists()) {
					shell.stderr.println(args[0]+": "+path+" is not found.");
				} else if (path.isDirectory()) {
					String[] list = path.list(filter);
					for (int j = 0, n = list.length; j < n; j ++) {
						shell.stdout.println(dirname+list[j]);
					}
				} else {
					shell.stdout.println(args[0]+": " + args[i] + " is not directory.");
				}

				return null;
			}
		}

		ExShell.append("create",new Create());
		ExShell.append("go",new Activate());
		ExShell.append("stop",new Deactivate());
		ExShell.append("remove",new Remove());
		ExShell.append("gols",new ListCell());
		ExShell.append("suspend",new Suspend());
		ExShell.append("resume",new Resume());
		ExShell.append("watch",new Watch());
		ExShell.append("status",new Stat());
		ExShell.append("ts",new ListThread());
		ExShell.append("ls",new ListGOD());
	}
}
