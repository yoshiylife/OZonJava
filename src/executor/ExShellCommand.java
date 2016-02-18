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
 * $Id: ExShellCommand.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 *
 * ����: ���Υե������ vi �ǡ�hardtab=8, tabstop=4 �Ȥ����Խ�����Ƥ���
 */

package JP.go.ipa.oz.system;

/**
 * ������Υ��ޥ�ɤȤ�����Ͽ����ˤ�
 * ���Υ��饹��Ѿ����ʤ���Фʤ�ʤ���
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author		Yasumitsu Yoshida
 */
abstract 
class ExShellCommand
{
	/**
	 * ���ޥ�ɤδ�ñ�ʻȤ����ʲ��Ԥ�ޤޤʤ���
	 */
	String usage;

	/**
	 * ���ޥ�ɤδ�ñ�ʥ����ȡʲ��Ԥ�ޤޤʤ���
	 */
	String comment;

	/**
	 * ���Υ��ޥ�ɤ�¹Ԥ��롣
	 *
	 * @param	shell	���Υ��ޥ�ɤ�¹Ԥ���������
	 * @param	args	���Υ��ޥ�ɤ�¹Ԥ�����ΰ���
	 * @return	���Υ��ޥ�ɤ�¹Ԥ������
	 */
	abstract String action(ExShell shell, String[] args) throws Exception;
}