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
 * $Id: ExObjectOutputStream.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 *
 * ���: ���Υե������ vi �ǡ�hardtab=8, tabstop=4 �Ȥ����Խ�����Ƥ���
 */

package	JP.go.ipa.oz.system;

import	java.io.OutputStream;
import	java.io.ObjectOutputStream;
import	java.io.IOException;

/**
 * ���֥������Ȥ�Serialize�������ȥ꡼��Ȥ��ƽ񤭽Ф���
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author		Yasumitsu Yoshida
 */
class ExObjectOutputStream
extends ObjectOutputStream
{
	/**
	 * ���������塼�������ΥǥХå���
	 */
	static String CN = "ExObjectOutputStream";

	/**
	 * ���֥������Ȥ�Serialize���뤿��ˡ����֥������Ȥ�
	 * ���ȥ꡼��˷���դ��롣
	 *
	 * @see	java.io.ObjectOutputStream#ObjectOutputStream
	 */
	public
	ExObjectOutputStream(OutputStream os)
	throws IOException
	{
		super(os);
	}
}
