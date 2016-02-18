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
 * $Id: ExProcessManager.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 *
 * ���: ���Υե������ vi �ǡ�hardtab=8, tabstop=4 �Ȥ����Խ�����Ƥ���
 */

package JP.go.ipa.oz.system;

import java.util.Hashtable;
import java.util.Enumeration;

/**
 * ExProcessManager �ϣϣڤΥץ����ʵ����ˤ��������
 * ���УɤǤ��� OzProcess ���������줿���֥������ȤȤ��μ���
 * �Ǥ��� ExProcess ���������줿���֥������Ȥ��Ϣ�Ť��롣
 *
 * @see OzProxy
 * @see OzProcess
 * @see ExProcess
 *
 * @version 	$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author		Yasumitsu Yoshida
 */
class ExProcessManager
{
	/**
	 * ���������塼�������ΥǥХå���
	 */
	static final String CN = "ExProcessManager";

	/**
	 * OzProcess ���������줿���֥������ȤȤ��μ���
	 * �Ǥ��� ExProcess ���������줿���֥������Ȥ�
	 * ��Ϣ�Ť��뤿��Υ�����ȯ�Ԥ��뤿��˺Ǹ��ȯ�Ԥ���
	 * �������ݻ����롣���Ѥ���Ƥ��ʤ������Ϻ����Ѥ���롣
	 * ���Υ�����ץ����ɣĤȸƤ֡����������ץ����ɣĤ�
	 * ����ͥ�����Ť����ʳ��ǥ��������塼�����̤���
	 * ����ξ����ղä�����礬���롣
	 */
	private static int lastProcessID = 0;

	/**
	 * OzProcess ���������줿���֥������ȤȤ��μ���
	 * �Ǥ��� ExProcess ���������줿���֥������Ȥ�
	 * ��Ϣ�Ť��뤿��ˡ��ץ����ɣĤ� ExProcess ������
	 * ���줿���֥������ȤȤ��Ф��ݻ�����ơ��֥�Ǥ��롣
	 */
	private static Hashtable exProcessTable = new Hashtable(10);

	/**
	 * ExProcessManager �ϥ��������塼���ˣ��ĤǤ��ꡢ
	 * ���饹�᥽�åɤΤߤ���ĤΤǡ����֥������Ȥ�
	 * ��������ɬ�פϤʤ���
	 */
	private
	ExProcessManager()
	{
		/* Nothing */
	}

	/**
	 * �Ǹ��ȯ�Ԥ����ץ����ɣĤ�ҥ�Ȥ�
	 * ���Ѥ���Ƥ��ʤ��ץ����ɣĤ����Ĥ���ޤǸ����򷫤��֤���
	 * �̾������������٤Υץ�����Ʊ���������뤳�Ȥ�
	 * �ͤ����ʤ��Τǡ����Ѥ���Ƥ��ʤ��ץ����ɣĤ�
	 * ���Ĥ���ʤ����ν����ϹԤäƤ��ʤ���
	 *
	 * @return	�ץ����ɣ�
	 */
	private static synchronized
	String findFreeProcessID()
	{
		int pid = lastProcessID ;
		do {
			if (pid == Integer.MAX_VALUE) {
				pid = 0;
			}
			pid ++;
			if (pid == lastProcessID) {
				Executor.error(CN,"findFreeProcessID","deadlock");
			}
		} while (exProcessTable.get(new Integer(pid)) != null);
		lastProcessID = pid;
		return Integer.toString(pid);
	}

	/**
	 * �������ϣڤΥץ�����������ơ��֥����Ͽ���롣
	 * �����������Υ᥽�åɤ�¹Ԥ��Ƥ��륹��åɤ�
	 * °���Ƥ��륻��˿���������åɤ�°�����롣
	 *
	 * @param	proxy	�ºݤΥ᥽�åɵ�ư��Ԥ����֥�������
	 * @param	object	�᥽�åɵ�ư��Ԥ��о�
	 * @param	args	�᥽�åɵ�ư��ɬ�פʾ���
	 * @return	�ץ����ɣ�
	 *
	 * @see ExProcessManager#findFreeProcessID
	 * @see ExProcessManager#exProcessTable
	 * @see OzProxy
	 * @see ExProcess#fork
	 */
	static
	String fork(Runnable proxy, Object object, Object[] args)
	{
		String pid = findFreeProcessID();
		ExProcess p = new ExProcess(pid);
		p.fork(proxy, object, args);
		exProcessTable.put(pid, p);
		return pid;
	}

	/**
	 * �������ϣڤΥץ�����������ơ��֥����Ͽ���롣
	 * �����������ꤵ�줿����˿���������åɤ�°�����롣
	 * ���������塼�������ν�����Ԥ�����˸ƤӽФ���롣
	 *
	 * @param	cell	����åɤ�°�����륻��
	 * @param	proxy	�ºݤΥ᥽�åɵ�ư��Ԥ����֥�������
	 * @param	args	�᥽�åɵ�ư��ɬ�פʾ���
	 * @return	�ץ����ɣ�
	 *
	 * @see ExProcessManager#findFreeProcessID
	 * @see ExProcessManager#exProcessTable
	 * @see OzProxy
	 * @see ExProcess#fork
	 */
	static
	String fork(ExCell cell, Runnable proxy, Object[] args)
	{
		String pid = findFreeProcessID();
		ExProcess p = new ExProcess(pid);
		p.fork(cell, proxy, args);
		exProcessTable.put(pid, p);
		return pid;
	}

	/**
	 * ���ꤵ�줿�ץ����ɣĤ� ExProcess �Ǻ������줿���֥������Ȥ�
	 * �Ѵ����롣
	 *
	 * @param		pid �ץ����ɣ�
	 * @return		ExProcess �Ǻ������줿���֥������Ȥ��֤���
	 * @exception	ExNoSuchProcessException
	 *				���ꤵ�줿�ץ����ɣĤ��б����륪�֥������Ȥ��ʤ���
	 *
	 * @see ExProcessManager#exProcessTable
	 * @see ExProcess
	 */
	static
	ExProcess toExProcess(String pid)
	throws ExNoSuchProcessException
	{
		ExProcess p = (ExProcess)exProcessTable.get(pid);
		if (p == null) throw new ExNoSuchProcessException(pid);
		return p;
	}

	/**
	 * ���ꤵ�줿�ץ����ɣĤ��б����� ExProcess �Ǻ������줿���֥������Ȥ�
	 * �ơ��֥뤫����������⤷���ꤵ�줿�ץ����ɣĤ�¸�ߤ��ʤ���С�
	 * �����ϰʳ��ν����ϹԤ�ʤ���
	 *
	 * @param	pid �ץ����ɣ�
	 *
	 * @see ExProcessManager#exProcessTable
	 * @see java.util.Hashtable#remove(java.lang.Object)
	 */
	static
	void detach(String pid)
	{
		if (exProcessTable.remove(pid) == null) {
			Executor.error(CN,"detach(pid="+pid+")",": do nothing");
		} else {
			Executor.debug(CN,"detach(pid="+pid+")");
		}
		/* for debug */
		if (exProcessTable.isEmpty()) {
			Executor.debug(CN,"detach","All processes detached.(last pid:"+lastProcessID+")");
		}
	}


	/*
	 * ����ʹߤϥǥХå��ȥ�����Τ���Υץ����Ǥ��롣
	 * �ʾܺ٤Ͼ�ά��
	 */
	static {

		/**
		 * �ץ���������������롣
		 */
		class List
		extends ExShellCommand
		{
			List()
			{
				usage = " ";
				comment = "list of processes";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (1 < args.length) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too many arguments");
				}

				Runtime runtime = Runtime.getRuntime();
				runtime.gc();
				runtime.runFinalization();
				Enumeration keys = exProcessTable.keys();
				while (keys.hasMoreElements()) {
					String key = (String)keys.nextElement();
					shell.stdout.println(exProcessTable.get(key));
				}

				return null;
			}
		}

		/**
		 * �ץ����ν�λ���ߤ롣
		 */
		class Kill
		extends ExShellCommand
		{
			Kill()
			{
				usage = " <process> [<process>...]";
				comment = "kill process";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length < 2) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too few arguments");
				}

				for (int i = 1, n = args.length; i < n; i ++) {
					OzProcess p = new OzProcess(args[i]);
					p.kill();
				}

				return null;
			}
		}

		/**
		 * �ץ����ν�λ���Ԥġ�
		 */
		class Join
		extends ExShellCommand
		{
			Join()
			{
				usage = " <process>";
				comment = "join process";
			}
			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length != 2) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too few or many arguments");
				}

				OzProcess p = new OzProcess(args[1]);
				p.join();

				return null;
			}
		}

		ExShell.append("ps",new List());
		ExShell.append("kill",new Kill());
		ExShell.append("join",new Join());
	}
}
