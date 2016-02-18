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
 * $Id: OzCell.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 *
 * ���: ���Υե������ vi �ǡ�hardtab=8, tabstop=4 �Ȥ����Խ�����Ƥ���
 */

package JP.go.ipa.oz.system;

/**
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author		Yasumitsu Yoshida
 */
public
class OzCell
extends OzSecure
{
	/**
	 * ���������塼�������ΥǥХå���
	 */
	static final String CN = "OzCell";

	/**
	 * ����ʥ����Х륪�֥������ȡ˼��Ȥˤ�GOL�ʤ���
	 * ����ʥ����Х륪�֥������ȡˤ�GOL���ѹ�������ǽ�������롣
	 */

	/**
	 * �����Х륢�������κǽ��ʳ��ǡ����ԡ����󤵤�Ƥ����ץ������֥��֥������ȡ�
	 * ���Ф����Хץ�������������롣����ϥ����륢�������Ȱۤʤ����Ǥ��롣
	 * ���äơ����Υץ�����Ŭ�ڤʥ��饹��Ȥä��������줿���֥������ȤǤ��뤳�Ȥ�
	 * �Τ����ɬ�פ����롣
	 */
	String proxyClassName;

	/**
	 * �������ϣڤΥ���ʥ����Х륪�֥������ȡˤ�������롣�ϣڤΥ��֥������Ȥ�
	 * ɬ��������Ĥ�������ʥ����Х륪�֥������ȡˤο��Ͼ���п��Ǥ��롣
	 * ����ʥ����Х륪�֥������ȡˤμºݤ������ϥ��������塼�����Ԥ���
	 * �ޤ��������Х륢����������������ݤ˥ץ����Υ��饹̾��
	 * �����å����뤿��˥ץ����Υ��饹̾������˻��ꤹ��ɬ�פ����롣
	 *
	 * @param	proxyClassName	����������˻Ȥ�줿���饹���б�����
	 *							�ץ����Υѥå�����̾��ޤ९�饹̾����ꤹ�롣
	 * @return	���������󥹥���
	 */
	protected
	OzCell(String proxyClassName)
	{
		/*
		 * ���������奿�ʳ��ϥ���ʥ����Х륪�֥������ȡˤ������Ǥ��ʤ���
		 * �ޤ���proxyClassName �� null �Ǥ��äƤϤʤ�ʤ���
		 */
		if (proxyClassName == null) {
			throw new SecurityException(
						"According to mach the type of cell and its proxy, "
						+"OzCell and its descendant class should be constructed "
						+"with full-qualified-class-name of the proxy class"
					);
		}
		color = OzSecure.GREEN;
		this.proxyClassName = proxyClassName;
		Executor.debug(CN,"OzCell","() = "+this);
		Executor.debug(CN,"OzCell","proxy class = "+proxyClassName);
	}

	/**
	 * ���饹 OzProxy �Υ᥽�å� initialize ���б����������Х륢��������
	 * �ǽ��ʳ��Ȥ��ơ����ԡ����󤵤�Ƥ����ץ��������Υ᥽�åɤ�ƤӽФ���
	 * ���������塼���ϡ�����ʥ����Х륪�֥������ȡˤ�����������ˤϡ�
	 * ���饹 ExProxy ��Ȥä����������ץ�����𤷤Ƥ��Υ᥽�åɤ�ƤӽФ���
	 */
	protected
	void initialize()
	throws Exception
	{
		/* Nothing */
	}

	/**
	 * ���饹 OzProxy �Υ᥽�å� go ���б����������Х륢��������
	 * �ǽ��ʳ��Ȥ��ơ����ԡ����󤵤�Ƥ����ץ��������Υ᥽�åɤ�ƤӽФ���
	 * ���������塼���ϡ�����ʥ����Х륪�֥������ȡˤ������������ˤϡ�
	 * ���饹 ExProxy ��Ȥä����������ץ�����𤷤Ƥ��Υ᥽�åɤ�ƤӽФ���
	 */
	protected
	void go()
	throws Exception
	{
		/* Nothing */
	}

	/**
	 * ���饹 OzProxy �Υ᥽�å� quiet ���б����������Х륢��������
	 * �ǽ��ʳ��Ȥ��ơ����ԡ����󤵤�Ƥ����ץ��������Υ᥽�åɤ�ƤӽФ���
	 * ���������塼���ϡ�����ʥ����Х륪�֥������ȡˤ��Գ�����������ˤϡ�
	 * ���饹 ExProxy ��Ȥä����������ץ�����𤷤Ƥ��Υ᥽�åɤ�ƤӽФ���
	 */
	protected
	void quiet()
	throws Exception
	{
		/* Nothing */
	}

	/**
	 * ����ʥ����Х륪�֥������ȡˤ�GOD���֤���
	 *
	 * @return	GOD
	 */
	protected final
	String getName()
	throws ExException
	{
		ExCell cell = ExCell.currentCell();
		return cell.getName();
	}
}
