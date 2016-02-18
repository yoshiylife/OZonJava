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
 * $Id: ExProxy.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 *
 * ���: ���Υե������ vi �ǡ�hardtab=8, tabstop=4 �Ȥ����Խ�����Ƥ���
 */

package JP.go.ipa.oz.system;

/**
 * ���������塼���Ͼ������ܤν����β����ǡ����Υ��饹��Ȥä���������
 * ���֥������Ȥ��ͳ���ơ�����ʥ����Х륪�֥������ȡˤؤ�
 * �����Х륢��������Ԥ���
 * ����������˹Ԥ��륰���Х륢�������ϡ����̤ʰ�������ɬ�פ����ꡢ
 * ���μ¸��Τ���Υ��饹�Ǥ��롣��â���������ξܺ٤�̤���
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author		Yasumitsu Yoshida
 */
final
class ExProxy
extends OzProxy
{
	/**
	 * ���������塼�������ΥǥХå���
	 */
	static final String CN = "ExProxy";

	/**
	 * OzSystem#getArguments()�Ǽ��Ф����ȤΤǤ���
	 * ʸ�����������Ǽ���롣
	 */
	private String[] arguments;

	/**
	 * ���������塼��������ʥ����Х륪�֥������ȡˤ�
	 * �����������뤿��Υץ�����������롣
	 *
	 * @param	proxy	�ץ���
	 * @exception	ExGOLFormatException
	 *					GOL �η������������ʤ���
	 */
	ExProxy(OzProxy proxy)
	throws ExException
	{
		super(proxy.getName());
		this.arguments = null;
	}

	/**
	 * ����ʥ����Х륪�֥������ȡˤ˥����������뤿��Υץ�����������롣
	 * ���Υ᥽�åɤ�ƤӽФ�������åɤ�°���륻��ʥ����Х륪�֥������ȡˤ�
	 * �����Х륪�֥������ȥ�����������ꤵ��롣
	 *
	 * @see	ExCell
	 */
	ExProxy()
	throws ExException
	{
		super();
	}

	/**
	 * ���������塼��������ʥ����Х륪�֥������ȡˤ�
	 * �����������뤿��Υץ�����������롣
	 *
	 * @param	gol	GOLʸ����
	 * @exception	ExGOLFormatException
	 *					GOL �η������������ʤ���
	 */
	ExProxy(String gol)
	throws ExException
	{
		super(gol);
		this.arguments = null;
	}

	/**
	 * ���������塼��������ʥ����Х륪�֥������ȡˤ�
	 * �����������뤿��Υץ�����������롣
	 *
	 * @param	gol			�����Х륪�֥������ȥ��������
	 * @param	arguments	OzSystem#getArguments�Ǽ��Ф�ʸ���������
	 * @exception	ExGOLFormatException
	 *					GOL �η������������ʤ���
	 */
	ExProxy(String gol, String[] arguments)
	throws ExException
	{
		super(gol);
		this.arguments = arguments;
	}

	/**
	 * ���������塼��������ʥ����Х륪�֥������ȡˤ�
	 * �����������뤿��Υץ�����������롣
	 *
	 * @param	god			GOD���֥�������
	 * @exception	ExGOLFormatException
	 *					GOL�Ȥ��Ƥ�GOD̾�η������������ʤ���
	 */
	ExProxy(ExGOD god)
	throws ExException
	{
		super(god.getName());
		this.arguments = null;
	}

	/**
	 * ���������塼��������ʥ����Х륪�֥������ȡˤ�
	 * �����������뤿��Υץ�����������롣
	 *
	 * @param	god			GOD���֥�������
	 * @param	arguments	OzSystem#getArguments�Ǽ��Ф�ʸ���������
	 * @exception	ExGOLFormatException
	 *					GOL�Ȥ��Ƥ�GOD̾�η������������ʤ���
	 */
	ExProxy(ExGOD god, String[] arguments)
	throws ExException
	{
		super(god.getName());
		this.arguments = arguments;
	}

	/**
	 * �����Х륢�������ν����β����κǽ��ʳ��Ȥ��ơ�
	 * ����ʥ����Х륪�֥������ȡˤؤΥ᥽�åɸƽФ���Ԥ���
	 *
	 * @param	invokee	�᥽�åɤ���ư����륻��ʥ����Х륪�֥������ȡ�
	 * @return		�᥽�åɤ������
	 *
	 * @exception	Exception
	 *				�㳰��ȯ�����뤬�����ξܺ٤ϥ�󥿥���Ǥ����狼��ʤ���
	 *
	 */
	protected Object invoke(OzCell invokee)
	throws Exception
	{
		ThreadGroup group = Thread.currentThread().getThreadGroup();
		ExCell cell = null;
		if (group instanceof ExCell) {
			cell = (ExCell)group;
		} else {
			Executor.error(CN,"invoke","illegal thread group = "+group.getClass().getName());
			throw new ExException(CN+"#invoke illegal thread group");
		}
		switch (selector) {
		case INITIALIZE:
			cell.setArguments(arguments);
			invokee.initialize();
			break;
		case GO:
			cell.setArguments(arguments);
			invokee.go();
			break;
		case QUIET:
			cell.setArguments(arguments);
			invokee.quiet();
			break;
		default:
			Executor.error(CN,"invoke","invalid selector = "+selector);
			throw new ExException(CN+"#invoke invalid selector");
		}
		return null;
	}
}
