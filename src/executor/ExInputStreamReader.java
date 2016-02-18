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
 * $Id: ExInputStreamReader.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 *
 * ���: ���Υե������ vi �ǡ�hardtab=8, tabstop=4 �Ȥ����Խ�����Ƥ���
 */

package JP.go.ipa.oz.system;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * java.io.StreamTokenizer �Υ᥽�å� nextToken �Ǥ�
 * TT_EOL ���֤��褦�����ꤷ�������Խ�ü��ʸ�����ɤ߹���ȡ�
 * �⤦��ʸ���ɤ߹��⤦�Ȥ��롣
 * ���Τ���ˡ�����ʸ�������Ϥ��ʤ���TT_EOL���֤��ʤ���
 * �����Զ����н褹�뤿��Υ��饹�Ǥ��롣
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author		Yasumitsu Yoshida
 */
class	ExInputStreamReader
extends	InputStreamReader
{
	boolean eol = false;

	public
	ExInputStreamReader(InputStream in)
	{
		super(in);
	}

	public
	int read()
	throws IOException
	{
		int c;
		if (eol) {
			c = ' ';
			eol = false;
		} else {
			c = super.read();
			if (c == '\n') eol = true;
		}
		return c;
	}
}
