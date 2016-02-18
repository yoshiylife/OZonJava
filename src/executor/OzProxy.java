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
 * $Id: OzProxy.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 *
 * ���: ���Υե������ vi �ǡ�hardtab=8, tabstop=4 �Ȥ����Խ�����Ƥ���
 */

package JP.go.ipa.oz.system;

/**
 * �����Х륢��������Ԥ�����˥����륪�֥������Ȥȥ����Х륪�֥������Ȥ�
 * ��𤹤����ܤ����饹 OzProxy �Ǥ��롣OzProxy �ϥ��饹 OzCell ���б�����
 * OzCell ��Ѿ����륯�饹�ˤϡ����饹 OzProxy ��Ѿ������ơ��Υ��饹��
 * �б����롣�̾OzProxy ��Ѿ����륯�饹�ϥ���ѥ���ˤ�äƼ�ưŪ�˺�������롣
 * ���饹 OzProxy�����뤤�ϡ������Ѿ����륯�饹���������줿���֥������Ȥ�ץ���
 * �ȸƤ֡����Υץ����ϣ��ĤΥ���ʥ����Х륪�֥������ȡˤ��б����롣���Υץ�����
 * �����륢��������Ԥ��ȡ��ץ������Ȥ����ԡ������Ȥ���ơ��ƤӽФ�
 * ����ʥ����Х륪�֥������ȡ�¦�˥��ԡ����󤵤�롣
 * ���ξ�ǡ��ƤӽФ�¦�Υ��֥������Ȥ����äƥ���ʥ����Х륪�֥������ȡˤ�
 * �Ф��ƥ᥽�åɵ�ư��Ԥ���
 *
 * @see OzCell
 * @see	OzSecure
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author		Yasumitsu Yoshida
 */
public
class OzProxy
extends OzSecure
implements Runnable
{
	/**
	 * ���������塼�������ΥǥХå���
	 */
	static String CN = "OzProxy";

	/**
	 * �����Х륪�֥������Ȥ��̿����ɥ쥹���褹�뤿��Υ����ˤʤ롣
	 * ���������塼���ʳ���ľ�ܤ˥����������뤳�ȤϤǤ��ʤ���
	 */
	private ExGOL gol;

	/**
	 * �ƤӽФ����Ȥ��Ǥ���᥽�åɤ��ֹ�Υꥹ��
	 * ���������塼���������ѤʤΤǡ���ե쥯������Ȥ�ɬ�פϤʤ���
	 * ���������塼���Τߤ����Ѥ��롣
	 */
	static final int INITIALIZE = 0;
	static final int GO = 1;
	static final int QUIET = 2;

	/**
	 * �ƤӽФ��᥽�åɤ��ֹ���Ǽ���롣
	 * ���������塼���Τߤ����Ѥ��롣
	 */
	int selector;

	/**
	 * ����ʥ����Х륪�֥������ȡˤ˥����������뤿��Υץ�����
	 * �������롣�ץ�����ɬ�������Х륪�֥������ȥ���������
	 * �����������ͤϾ��Ǥ���ޤ��Ѥ��ʤ���
	 *
	 * @param	gol		�����Х륪�֥������ȥ��������
	 * @exception		ExGOLFormatException
	 *					GOL �η������������ʤ���
	 */
	public
	OzProxy(String gol)
	throws ExException
	{
		this.gol = new ExGOL(gol);
	}

	/**
	 * ����ʥ����Х륪�֥������ȡˤ˥����������뤿��Υץ�����������롣
	 * ���Υ᥽�åɤ�ƤӽФ�������åɤ�°���륻��ʥ����Х륪�֥������ȡˤ�
	 * �����Х륪�֥������ȥ�����������ꤵ��롣
	 *
	 * @see	ExCell
	 */
	public
	OzProxy()
	throws ExException
	{
		ExCell cell = ExCell.currentCell();
		try {
			this.gol = new ExGOL(cell.getName());
		} catch (ExGOLFormatException e) {
			Executor.error(CN,"OzProxy","cell.getName() "+cell.getName(),e);
			throw new ExException(cell.getName());
		}
	}

	/**
	 * ��ʬ��Ʊ��gol����Ĥ���Ĵ�٤롣
	 *
	 * @param	proxy	����оݤΥץ���
	 * @return	gol �����פ���С�true ���֤���
	 *
	 * @see	OzProxy@gol
	 */
	public
	boolean equals(Object proxy)
	{
		if ((proxy != null) && (proxy instanceof OzProxy)) {
			return gol.equals(((OzProxy)proxy).getName());
		}
		return false;
	}

	/**
	 * GOL���֤���
	 * ���������塼�������ǻ��Ѥ����桼���ʥ���ѥ����ޤ�ˤˤϸ������ʤ���
	 *
	 * @return	ExGOL��Ȥä��������줿���֥�������
	 *
	 * @see	OzProxy@gol
	 */
	final
	ExGOL getGOL()
	{
		return gol;
	}

	/**
	 * OZ�ۡ���̾������ư��Ƥ��륨�������塼����OZ�ۡ���̾��
	 * ���פ�����Ĵ�٤롣
	 *
	 * @return	OZ�ۡ���̾��Ʊ���ʤ�� true ���֤���
	 */
	boolean inside()
	{
		return gol.inside();
	}

	/**
	 * �ץ��������ĥ����Х륪�֥������ȥ����������֤���
	 *
	 * @return	�����Х륪�֥������ȥ��������
	 *
	 * @see	OzProxy@gol
	 */
	public final
	String getName()
	{
		return gol.getName();
	}

	/**
	 * �ǥե���Ȥ�ɽ�����Ƥˣǣϣ̤�ä���ɽ�����롣
	 *
	 */
	public final
	String toString()
	{
		String cn = getClass().getName();
		if (cn.startsWith(Executor.IPAoz)) {
			cn = cn.substring(Executor.IPAoz.length(),cn.length());
		}
		return cn + "@" + Integer.toHexString(hashCode()) + "[gol=" + gol + "]";
	}

	/**
	 * �����Х륢�������Τ���ν����򳫻Ϥ��롣
	 * ���Υ᥽�åɤϥץ����Υ����륢�������򥰥��Х륢��������
	 * �Ѵ����٤��᥽�åɤ���ƤӽФ���롣
	 * ���ĤΥץ�����Ʊ����ʣ���Υ����륢�������ʥ����Х륢�������Τ���ˡˤ�
	 * �Ԥ����Ȥ��ǽ�Ȥ��뤿��ˡ����Υץ����򥳥ԡ������Ƚ�λ����ޤǤδ֡�
	 * �ץ����ξ��֡ʻ��Ȥ��Ƥ��륪�֥������Ȥ�ޤ�ˤ��Ѳ����ƤϤʤ�ʤ���
	 * ���Υ᥽�åɤ�ƤӽФ�¦�Ϥ���������դ��ʤ���Фʤ�ʤ���
	 * ���Υ᥽�åɤ�ƤӽФ����塢�᥽�å� join() ��ƤӽФ���	
	 * �����Х륤��ܡ����ν�λ�Ȥ�������ͤ����ʤ���Фʤ�ʤ���
	 * Ϣ³���Ƥ��Υ᥽�åɤΤߤ��ƤӽФ���뤳�Ȥ����ͥ�����ꤷ�Ƥ��ʤ���
	 *
	 * @exception	ExGOLFormatException
	 *				�����Х륪�֥������ȥ��������η������������ʤ���
	 * @exception	ExCellNotFoundException
	 *				���ꤵ�줿GOL���ĥ���ʥ����Х륪�֥������ȡˤ����Ĥ���ʤ���
	 * @exception	ExCellNotActiveException
	 *				���ꤵ�줿GOL���ĥ���ʥ����Х륪�֥������ȡˤϳ���������Ƥ��ʤ���
	 * @exception	ExException
	 *				�¹�����㳰��ȯ��������
	 *
	 * @see	OzProxy#join
	 * @see	ExChannel#fork
	 */
	protected final
	void fork()
	throws ExException
	{
		ExThread t = (ExThread)Thread.currentThread();
		ExCallerChannel caller = t.channel;
		caller.fork(this);
	}

	/**
	 * ľ���˹Ԥʤä������Х륢�������ν�λ���Ԥäơ���������ͤ����롣
	 * �᥽�å� fork() ��ƤӽФ����塢���Υ᥽�åɤ�ƤӽФ��ʤ���Фʤ�ʤ���
	 *
	 * @exception	Exception
	 *				�㳰��ȯ�����뤬�����ξܺ٤ϥ�󥿥���Ǥ����狼��ʤ���
	 *
	 * @see	OzProxy#fork
	 * @see	ExCallerChannel#join
	 * @see	ExChannel#join
	 */
	protected final
	Object join()
	throws Exception
	{
		ExThread t = (ExThread)Thread.currentThread();
		ExCallerChannel caller = t.channel;
		return caller.join();
	}

	/**
	 * ���ԡ����󤷤������Υ���åɤǺǽ�˸ƤӽФ���롣
	 */
	public final
	void run()
	{
		Object result;
		boolean status;

		try {
			ExThread t = (ExThread)Thread.currentThread();
			ExCalleeChannel callee = t.channel;
			OzCell invokee = (OzCell)callee.object();
			try {
				result = invoke(invokee);
				status = true;
			} catch (Exception e) {
				Executor.debug(CN,"run",e);
				result = e;
				status = false;
			}
			callee.exit(status, result);
		} catch (Exception e) { // unexpect exception
			Executor.error(CN,"run",e);
		}
	}

	/**
	 * �����Х륢�������β����κǽ��ʳ��Ȥ��ơ�
	 * �ºݤ˥����Х륪�֥������ȤΥ᥽�åɤ�ư���롣
	 * ������Ȥ��ơ�¾�Υ��֥������ȤؤΥ᥽�åɤε�ư��
	 * �������ϣڤΥץ�����ǹԤ���硢�ºݤΥ᥽�åɤ�
	 * ��ư�ϣϣڤΥץ����������������֥�������¦�ˤ��롣
	 * �ĤޤꡢOzProxy��OzProxy��Ѿ����륯�饹�ˤϿ�����
	 * �ϣڤΥץ���������ǥ᥽�åɤ�ư������ȤߤȤ���
	 * �ǤϤʤ��������Х륢�������β����ΰ����Ȥ���
	 * ���Υ᥽�åɤ���ư����롣
	 *
	 * @param	invokee	�᥽�åɤ���ư����륻��ʥ����Х륪�֥������ȡ�
	 * @return			�᥽�åɤ������
	 *
	 * @exception	Exception
	 *				�㳰��ȯ�����뤬�����ξܺ٤ϥ�󥿥���Ǥ����狼��ʤ���
	 *
	 */
	protected Object invoke(OzCell invokee)
	throws Exception
	{
		switch (selector) {
		case INITIALIZE:
			invokee.initialize();
			break;
		case GO:
			invokee.go();
			break;
		case QUIET:
			invokee.quiet();
			break;
		default:
			Executor.error(CN,"invoke","invalid selector = "+selector);
			throw new ExException(CN+"#invoke invalid selector");
		}
		return null;
	}

	/**
	 * ���饹 OzCell �Υ᥽�å� initialize ���Ф���
	 * �����Х륢��������Ԥ�����Υ᥽�åɤǤ��롣
	 *
	 * <DL>
	 * <DT>
	 * ����ա�
	 * <DD>
	 * ���������塼���Ͼ������ܤν����β����ǡ�����ʥ����Х륪�֥������ȡˤ�
	 * �᥽�å� initialize ��ƤӽФ��������Υ᥽�åɤ��ͳ���ʤ���
	 * ���������塼���Ϥ��Τ�������ѤΥ��饹��Ȥ���
	 * </DL>
	 *
	 * @exception	Exception
	 *				�㳰��ȯ�����뤬�����ξܺ٤ϥ�󥿥���Ǥ����狼��ʤ���
	 *
	 * @see	OzCell#initialize
	 */
	protected
	void initialize()
	throws Exception
	{
		enter();
		try {
			this.selector = INITIALIZE;
			fork();
		} catch (ExGOLFormatException e) {
			Executor.error(CN,"initialize","gol="+gol,e);
			throw new ExException(e.getClass().getName());
		} catch (Exception e) {
			Executor.debug(CN,"initialize","gol="+gol,e);
			throw e;
		} finally {
			leave();
		}
		join();
	}

	/**
	 * ���饹 OzCell �Υ᥽�å� go ���Ф���
	 * �����Х륢��������Ԥ�����Υ᥽�åɤǤ��롣
	 *
	 * <DL>
	 * <DT>
	 * ����ա�
	 * <DD>
	 * ���������塼���Ͼ������ܤν����β����ǡ�����ʥ����Х륪�֥������ȡˤ�
	 * �᥽�å� go ��ƤӽФ��������Υ᥽�åɤ��ͳ���ʤ���
	 * ���������塼���Ϥ��Τ�������ѤΥ��饹��Ȥ���
	 * </DL>
	 *
	 * @exception	Exception
	 *				�㳰��ȯ�����뤬�����ξܺ٤ϥ�󥿥���Ǥ����狼��ʤ���
	 *
	 * @see	OzCell#go
	 */
	protected
	void go()
	throws Exception
	{
		enter();
		try {
			this.selector = GO;
			fork();
		} catch (ExGOLFormatException e) {
			Executor.error(CN,"go","gol="+gol,e);
			throw new ExException(e.getClass().getName());
		} catch (Exception e) {
			Executor.debug(CN,"go","gol="+gol,e);
			throw e;
		} finally {
			leave();
		}
		join();
	}

	/**
	 * ���饹 OzCell �Υ᥽�å� quiet ���Ф���
	 * �����Х륢��������Ԥ�����Υ᥽�åɤǤ��롣
	 *
	 * <DL>
	 * <DT>
	 * ����ա�
	 * <DD>
	 * ���������塼���Ͼ������ܤν����β����ǡ�����ʥ����Х륪�֥������ȡˤ�
	 * �᥽�å� quiet ��ƤӽФ��������Υ᥽�åɤ��ͳ���ʤ���
	 * ���������塼���Ϥ��Τ�������ѤΥ��饹��Ȥ���
	 * </DL>
	 *
	 * @exception	Exception
	 *				�㳰��ȯ�����뤬�����ξܺ٤ϥ�󥿥���Ǥ����狼��ʤ���
	 *
	 * @see	OzCell#quiet
	 */
	protected
	void quiet()
	throws Exception
	{
		enter();
		try {
			this.selector = QUIET;
			fork();
		} catch (ExGOLFormatException e) {
			Executor.error(CN,"quiet","gol="+gol,e);
			throw new ExException(e.getClass().getName());
		} catch (Exception e) {
			Executor.debug(CN,"quiet","gol="+gol,e);
			throw e;
		} finally {
			leave();
		}
		join();
	}
}
