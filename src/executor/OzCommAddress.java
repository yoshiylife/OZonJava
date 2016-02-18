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
 * OzHomeResolver がグローバルオブジェクトの通信アドレスを
 * 表現したオブジェクトから必要な情報を取り出すための
 * インタフェースである。
 *
 * @version	$Revision: 2.1 $, $Date: 1997/12/04 04:55:20 $
 * @author	Yasumitsu Yoshida
 */
public
interface
OzCommAddress
{
    /**
     * グローバルオブジェクトの通信アドレスの
     * IPアドレス部分を'.'区切りの文字列として取り出す。
     *
     * @return	'.'区切りのIPアドレスの文字列
     */
    public String getHostAddress();

    /**
     * グローバルオブジェクトの通信アドレスの
     * ポート番号部分を返す。
     *
     * @return	ポート番号
     */
    public int getPort();
}
