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
 * $Id: OzCellManager.java,v 2.2 1997/11/07 05:10:57 yoshi Exp $
 *
 * ���: ���Υե������ vi �ǡ�hardtab=8, tabstop=4 �Ȥ����Խ�����Ƥ���
 */

package JP.go.ipa.oz.system;

/**
 * ��󥿥��ॵ���ӥ����󶡤��뤿��Υ��饹�Ǥ��롣
 * ���Υ��饹�ˤϡ�static �᥽�åɤΤߤ��������롣
 * ���Υ��饹�ϥ��������塼�����ظ��������Τǡ�
 * �������ƥ��˽�ʬ��դ��Ƽ�����Ԥ�ɬ�פ����롣
 *
 * <DL>
 * <DT>
 * ����ա�
 * <DD>
 * ������(Fri May 9 10:26:46 JST 1997)�ǡ�ExSecurityManager �Ȥ�
 * ���󥿥ե��������������������뤿�ᡢ�����ȤΤߤ�ɬ�פ�
 * �᥽�åɸƤӽФ���ԤäƤ��ʤ���ʬ�����롣
 * �������ƥ����ݤ��Ǥ��Ƥ��ʤ��ΤǼ������ʤ���ɬ�פ����롣
 * </DL>
 *
 * @version		$Revision: 2.2 $, $Date: 1997/11/07 05:10:57 $
 * @author		Yasumitsu Yoshida
 */
public final
class OzCellManager
{
	/**
	 * ���������塼�������ΥǥХå���
	 */
	static final String CN = "OzCellManager";

	/**
	 * ���Υ��饹�� static �᥽�åɡʥ��饹�᥽�åɡˤΤߤ���ġ�
	 * �ޤ������Υ��饹�Υ��֥������Ȥ��������ƻ��Ѥ��ʤ���
	 * ���Υ��饹�� public �Ǥ��ꡢ�ޤ������������塼���μ����˰�¸����
	 * ��ʬ���ޤޤ��Τǡ����Υ��饹�Υ��֥������Ȥ������˻����Ф���
	 * �ʤ��褦�ˤ���ɬ�פ����롣
	 */
	private
	OzCellManager()
	{
		/* Nothing */
	}

	/**
	 * ���� proxy �ǻ��ꤵ�줿 GOD �Ǽ��̤��뤳�Ȥ��Ǥ���
	 * ����ʥ����Х륪�֥������ȡˤ���� codePath ��
	 * ���ꤵ�줿���饹�ʥ��饹 OzCell �Υ��֥��饹�ˤ�Ȥä��������롣
	 * �����������줿������������������Ǥ��Υ���Υ᥽�å� initialize ��ƤӽФ���
	 * �᥽�å� initialize ����λ����ޤǡ����Υ���ؤΥ����Х�᥽�åɵ�ư��
	 * �����դ����뤬�����Υ᥽�åɤμ¹Ԥ���α����롣
	 * â����ɬ�����⤽�Υ᥽�åɤ��¹Ԥ����Ȥϸ¤�ʤ���
	 * ��̤Ȥ��ơ��᥽�åɤμ¹Ԥ��Ԥ�줺�˥����Х�᥽�åɵ�ư���Τ�
	 * �㳰�Ȥʤ���⤢�롣
	 * ���Υ�󥿥��ॵ���ӥ����㳰�ǽ�λ�������ϡ��������Ѥ���Ƥ��ʤ����
	 * ���� proxy �ǻ��ꤵ�줿 GOD �Ϻ����Ѳ�ǽ�ʾ��֤ˤʤ롣
	 * â�����᥽�å� initialize ����ǹԤ�줿���ˤĤ��Ƥϴ��Τ��ʤ���
	 * �ޤ����᥽�å� initialize ���㳰�ǽ�λ�������⤳�Υ�󥿥��ॵ���ӥ���
	 * �㳰�ǽ�λ���롣
	 * <DL>
	 * <DT>
	 * ����ա�
	 * <DD>
	 * ���ν����ϡ��̾����¿���Υ����å���
	 * ���񤵤��Ȼפ���Τ��̥���åɤǹԤ���
	 * <DT>
	 * �ڶ���Ū���㳰��
	 * <DD>
	 * Executor or ExCell �μ����˰�¸���뤿�ᡢ���ߤϵ��Ҥ��Ƥ��ʤ���
	 * </DL>
	 *
	 * @param		codePath
	 * 					full-qualified-class-name
	 * @param		proxy
	 *					����ʥ����Х륪�֥������ȡˤ˥����������뤿��Υץ���
	 *
	 * @exception	ExCellException
	 *					����ʥ����Х륪�֥������ȡˤν������㳰��ȯ��������
	 * @exception	ExException
	 *					�¹�����㳰��ȯ��������
	 *
	 */
	public static
	void create(String codePath, OzProxy proxy)
	throws ExException, ExCellException
	{
		// �������ƥ��ޥ͡�����θƽФ�
		if (Executor.securityManager != null) {
			Executor.securityManager.tryNewGlobalObject(codePath, proxy);
		}

		Object[] args = new Object[3];
		args[0] = new Integer(Executor.CREATE);
		args[1] = codePath;
		args[2] = new ExProxy(proxy);
		OzProcess p = Executor.syscall(args);
		try {
			try {
				p.join();
			} catch (ExProcessException e) {
				throw e.getException();
			}
		} catch (ExNoSuchProcessException e) {
			Executor.error(CN,"create","(codePath="+codePath+",proxy="+proxy+")",e);
			throw new ExException(e.getClass().getName());
		} catch (ExCellHookException e) {
			Executor.debug(CN,"create","(codePath="+codePath+",proxy="+proxy+")",e);
			Exception ee = e.getException();
			if (ee != null) {
				Executor.debug(CN,"create","(codePath="+codePath+",proxy="+proxy+")",ee);
			}
			throw e;
		} catch (ExException e) {
			throw e;
		} catch (Exception e) {
			Executor.error(CN,"create","(codePath="+codePath+",proxy="+proxy+")",e);
			throw new ExException(e.getClass().getName());
		}
	}

	/**
	 * ���� proxy �ǻ��ꤵ�줿 GOD �ˤ��륪�֥������ȥ��᡼����
	 * �Ȥäƥ���ʥ����Х륪�֥������ȡˤ��������롣
	 * �����������줿������������������Ǥ��Υ���Υ᥽�å� go ��ƤӽФ���
	 * �᥽�å� go ����λ����ޤǡ����Υ���ؤΥ����Х�᥽�åɵ�ư��
	 * �����դ����뤬�����Υ᥽�åɤμ¹Ԥ���α����롣
	 * â����ɬ�����⤽�Υ᥽�åɤ��¹Ԥ����Ȥϸ¤�ʤ���
	 * ��̤Ȥ��ơ��᥽�åɤμ¹Ԥ��Ԥ�줺�˥����Х�᥽�åɵ�ư���Τ�
	 * �㳰�Ȥʤ���⤢�롣
	 * ���Υ�󥿥��ॵ���ӥ����㳰�ǽ�λ������硢���� proxy ��
	 * ���ꤵ�줿 GOD �Ϥ��Υ�󥿥��ॵ���ӥ���ƤӽФ����ξ��֤ˤʤ롣
	 * â�����᥽�å� go ����ǹԤ�줿���ˤĤ��Ƥϴ��Τ��ʤ���
	 * �ޤ����᥽�å� go ���㳰�ǽ�λ�������⤳�Υ�󥿥��ॵ���ӥ���
	 * �㳰�ǽ�λ���롣
	 *
	 * <DL>
	 * <DT>
	 * ����ա�
	 * <DD>
	 * ���ν����ϡ��̾����¿���Υ����å���
	 * ���񤵤��Ȼפ���Τ��̥���åɤǹԤ���
	 * <DT>
	 * �ڶ���Ū���㳰��
	 * <DD>
	 * Executor or ExCell �μ����˰�¸���뤿�ᡢ���ߤϵ��Ҥ��Ƥ��ʤ���
	 * </DL>
	 *
	 * @param		proxy
	 *					����ʥ����Х륪�֥������ȡˤ˥����������뤿��Υץ���
	 *
	 * @exception	ExCellException
	 *					����ʥ����Х륪�֥������ȡˤν������㳰��ȯ��������
	 * @exception	ExException
	 *					�¹�����㳰��ȯ��������
	 *
	 */
	public static
	void go(OzProxy proxy)
	throws ExException, ExCellException
	{
		// �������ƥ��ޥ͡�����θƽФ�
		if (Executor.securityManager != null) {
			Executor.securityManager.tryGoGlobalObject(proxy);
		}

		Object[] args = new Object[2];
		args[0] = new Integer(Executor.GO);
		args[1] = new ExProxy(proxy);
		OzProcess p = Executor.syscall(args);
		try {
			try {
				p.join();
			} catch (ExProcessException e) {
				throw e.getException();
			}
		} catch (ExNoSuchProcessException e) {
			Executor.error(CN,"go","(proxy="+proxy+")",e);
			throw new ExException(e.getClass().getName());
		} catch (ExCellHookException e) {
			Executor.debug(CN,"go","(proxy="+proxy+")",e);
			Exception ee = e.getException();
			if (ee != null) {
				Executor.debug(CN,"go","(proxy="+proxy+")",ee);
			}
			throw e;
		} catch (ExException e) {
			throw e;
		} catch (Exception e) {
			Executor.error(CN,"go","(proxy="+proxy+")",e);
			throw new ExException(e.getClass().getName());
		}
	}

	/**
	 * ���� proxy �ǻ��ꤵ�줿 GOD �Ǽ��̤���륻��ʥ����Х륪�֥������ȡˤ�
	 * ����Ū�˥���夫�������롣
	 * ���Υ�������夫������������Ǥ��Υ���Υ᥽�å� quiet ��ƤӽФ���
	 * �᥽�å� quiet ��ƤӽФ��������Ǥϡ����Υ���ؤΥ����Х�᥽�åɵ�ư��
	 * �����դ����ʤ����֤ˤʤäƤ��뤬�����Υ���˼¹���Υ���åɤ��ʤ�
	 * ���Ȥ��ݾڤ��ʤ���
	 * ���Υ�󥿥��ॵ���ӥ����㳰�ǽ�λ������硢
	 * <STRONG>
	 * ��̤���
	 * </STRONG>
	 * �Ǥ��롣
	 * �ޤ����᥽�å� quiet ���㳰�ǽ�λ�������⤳�Υ�󥿥��ॵ���ӥ���
	 * �㳰�ǽ�λ���롣
	 * �ʤ��������Х륪�֥������ȥ��᡼���� GOD �ؤ���¸�ϼ�ưŪ�ˤ�
	 * �Ԥ��ʤ��Τǡ������Х륪�֥������ȥ��᡼���� GOD ����¸���뤿���
	 * �᥽�åɤ�ɬ�פ˱����ƸƤӽФ�ɬ�פ����롣��������Ԥ�ʤ��ä���硢
	 * ����Υ�����������ˤϸŤ������Х륪�֥������ȥ��᡼�����Ȥ��롢
	 * ���뤤�ϡ������Х륪�֥������ȥ��᡼�����ʤ���Ф��� GOD ��
	 * �����Ѥ���뤳�Ȥˤʤ롣
	 *
	 * <DL>
	 * <DT>
	 * ����ա�
	 * <DD>
	 * ���ν����ϡ��̾����¿���Υ����å���
	 * ���񤵤��Ȼפ���Τ��̥���åɤǹԤ���
	 * <DT>
	 * �ڶ���Ū���㳰��
	 * <DD>
	 * Executor or ExCell �μ����˰�¸���뤿�ᡢ���ߤϵ��Ҥ��Ƥ��ʤ���
	 * </DL>
	 *
	 * @param		proxy
	 *					����ʥ����Х륪�֥������ȡˤ˥����������뤿��Υץ���
	 *
	 * @exception	ExCellException
	 *					����ʥ����Х륪�֥������ȡˤν������㳰��ȯ��������
	 * @exception	ExException
	 *					�¹�����㳰��ȯ��������
	 *
	 */
	public static
	void stop(OzProxy proxy)
	throws ExException, ExCellException
	{
		// �������ƥ��ޥ͡�����θƽФ�
		if (Executor.securityManager != null) {
			Executor.securityManager.tryStopGlobalObject(proxy);
		}

		Object[] args = new Object[2];
		args[0] = new Integer(Executor.STOP);
		args[1] = new ExProxy(proxy);
		OzProcess p = Executor.syscall(args);
		try {
			try {
				p.join();
			} catch (ExProcessException e) {
				throw e.getException();
			}
		} catch (ExNoSuchProcessException e) {
			Executor.error(CN,"stop","(proxy="+proxy+")",e);
			throw new ExException(e.getClass().getName());
		} catch (ExCellHookException e) {
			Executor.debug(CN,"stop","(proxy="+proxy+")",e);
			Exception ee = e.getException();
			if (ee != null) {
				Executor.debug(CN,"stop","(proxy="+proxy+")",ee);
			}
			throw e;
		} catch (ExException e) {
			throw e;
		} catch (Exception e) {
			Executor.error(CN,"stop","(proxy="+proxy+")",e);
			throw new ExException(e.getClass().getName());
		}
	}

	/**
	 * ���� proxy �ǻ��ꤵ�줿 GOD �Ǽ��̤���륻��ʥ����Х륪�֥������ȡˤ�
	 * ����Ū�˥���夫��������GOD ������ѤǤ�����֤ˤ��롣
	 * ���Υ�󥿥��ॵ���ӥ����ƤӽФ�����ȡ�
	 * ���Υ���ؤΥ����Х�᥽�åɵ�ư�ϼ����դ����ʤ����֤ˤʤ롣
	 * ���Υ�󥿥��ॵ���ӥ����㳰�ǽ�λ������硢
	 * <STRONG>
	 * ��̤���
	 * </STRONG>
	 * �Ǥ��롣
	 *
	 * <DL>
	 * <DT>
	 * ����ա�
	 * <DD>
	 * ���ν����ϡ��̾����¿���Υ����å���
	 * ���񤵤��Ȼפ���Τ��̥���åɤǹԤ���
	 * <DT>
	 * �ڶ���Ū���㳰��
	 * <DD>
	 * Executor or ExCell �μ����˰�¸���뤿�ᡢ���ߤϵ��Ҥ��Ƥ��ʤ���
	 * </DL>
	 *
	 * @param		proxy
	 *					����ʥ����Х륪�֥������ȡˤ˥����������뤿��Υץ���
	 *
	 * @exception	ExCellException
	 *					����ʥ����Х륪�֥������ȡˤν������㳰��ȯ��������
	 * @exception	ExException
	 *					�¹�����㳰��ȯ��������
	 *
	 */
	public static
	void remove(OzProxy proxy)
	throws ExException, ExCellException
	{
		// �������ƥ��ޥ͡�����θƽФ�
		if (Executor.securityManager != null) {
			Executor.securityManager.tryRemoveGlobalObject(proxy);
		}

		Object[] args = new Object[2];
		args[0] = new Integer(Executor.REMOVE);
		args[1] = new ExProxy(proxy);
		OzProcess p = Executor.syscall(args);
		try {
			try {
				p.join();
			} catch (ExProcessException e) {
				throw e.getException();
			}
		} catch (ExNoSuchProcessException e) {
			Executor.error(CN,"remove","(proxy="+proxy+")",e);
			throw new ExException(e.getClass().getName());
		} catch (ExCellHookException e) {
			Executor.debug(CN,"remove","(proxy="+proxy+")",e);
			Exception ee = e.getException();
			if (ee != null) {
				Executor.debug(CN,"remove","(proxy="+proxy+")",ee);
			}
			throw e;
		} catch (ExException e) {
			throw e;
		} catch (Exception e) {
			Executor.error(CN,"remove","(proxy="+proxy+")",e);
			throw new ExException(e.getClass().getName());
		}
	}
}
