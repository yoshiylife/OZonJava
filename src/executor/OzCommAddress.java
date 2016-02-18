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
 * $Id: OzCommAddress.java,v 2.1 1997/12/04 04:55:20 yoshi Exp $
 *
 */

package	JP.go.ipa.oz.system;

/**
 * OzHomeResolver �������Х륪�֥������Ȥ��̿����ɥ쥹��
 * ɽ���������֥������Ȥ���ɬ�פʾ������Ф������
 * ���󥿥ե������Ǥ��롣
 *
 * @version	$Revision: 2.1 $, $Date: 1997/12/04 04:55:20 $
 * @author	Yasumitsu Yoshida
 */
public
interface
OzCommAddress
{
    /**
     * �����Х륪�֥������Ȥ��̿����ɥ쥹��
     * IP���ɥ쥹��ʬ��'.'���ڤ��ʸ����Ȥ��Ƽ��Ф���
     *
     * @return	'.'���ڤ��IP���ɥ쥹��ʸ����
     */
    public String getHostAddress();

    /**
     * �����Х륪�֥������Ȥ��̿����ɥ쥹��
     * �ݡ����ֹ���ʬ���֤���
     *
     * @return	�ݡ����ֹ�
     */
    public int getPort();
}
