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
 * $Id: ExGOL.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 *
 * 注意: このファイルは vi で、hardtab=8, tabstop=4 として編集されている
 */

package JP.go.ipa.oz.system;

/**
 * グローバルオブジェクトロケーション（GOL）を取り扱うためのクラスである。
 * このクラスを使って生成されたオブジェクトは、常に形式として
 * 正しい GOL を持ち、そのオブジェクトが持つ GOL は不変である。
 * しかし、そのオブジェクトは常に生成時のエグゼキュータ上にあるとは限らない。
 * また、GOL に対応するセル（グローバルオブジェクト）の存在とは無関係である。
 * グローバルオブジェクトロケーション（GOL）はOZホーム名と
 * グローバルオブジェクトディレクトリ（GOD）名を':'で連結した文字列である。
 *
 * <DL><DT>
 * 【注意】<DD>
 * OZホーム名の形式は':'区切りの文字列である。
 * </DL>
 *
 * @see	ExGOD
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author		Yoichi Hamazaki
 * @author		Yasumitsu Yoshida
 */
class ExGOL
extends OzSecure
{
	/**
	 * エグゼキュータ実装のデバッグ用
	 */
	static final String CN = "ExGOL";

	/**
	 * OZホーム名
	 */
	static final String ozHomeName = System.getProperty("oz.home.name");

	/**
	 * OZホーム名とGOD名の区切り文字
	 * 但し、便宜上のために文字列となっている。
	 */
	static final String homeSeparator = ":";

	/**
	 * グローバルオブジェクトロケーション(GOL)のOZホーム名(home)部分を保持する。
	 */
	private String home;

	/**
	 * グローバルオブジェクトロケーション(GOL)の
	 * グローバルオブジェクトディレクトリ名(GOD)部分を保持する。
	 */
	private String god;

	/**
	 * OZホーム名とGOD名が適切な形式であるかを調べる。
	 *
	 * @param	home	OZホーム名
	 * @param	god		GOD名
	 * @exception	ExGOLFormatException
	 *					GOL(GOD)の形式が正しくない。
	 */
	static void check(String home, String god)
	throws ExGOLFormatException
	{
		if (home != null) {
			int first = home.indexOf(homeSeparator);
			int last = home.lastIndexOf(homeSeparator);
			if (first < 0 || last < 0) {
				throw new ExGOLFormatException(
							"Not include oz home name separator '"+homeSeparator+"'");
			} else if (first != last) {
				throw new ExGOLFormatException(
							"Too many include oz home name separator '"+homeSeparator+"'");
			}
		}
		if (god != null) {
			ExGOD.check(god);
			if (0 <= god.indexOf(homeSeparator)) {
				throw new ExGOLFormatException(
							"GOD include oz home name separator '"+homeSeparator+"'");
			}
		}
	}

	/**
	 * このオブジェクトの初期設定を行う
	 *
	 * @param	home	OZホーム名
	 * @param	god		GOD名
	 * @exception	ExGOLFormatException
	 *					OZホーム名、あるいは、GOD名の形式が正しくない。
	 */
	private
	void init(String home, String god)
	throws ExGOLFormatException
	{
		check(home,god);
		this.home = home;
		this.god = god;
	}

	/**
	 * グローバルオブジェクトロケーション（GOL）、
	 * あるいは、グローバルオブジェクトディレクトリ（GOD）名を
	 * 指定してオブジェクトを作成する。
	 *
	 * @param	gol		グローバルオブジェクトロケーション
	 * @exception	ExGOLFormatException
	 *					GOL(GOD)の形式が正しくない。
	 */
	ExGOL(String gol)
	throws ExGOLFormatException
	{
		int last = gol.lastIndexOf(homeSeparator);
		String god;
		String home;
		if (0 <= last) {
			god = gol.substring(last+1);
			home = gol.substring(0,last);
		} else {
			god = gol;
			home = ozHomeName;
		}
		init(home,god);
	}

	/**
	 * OZホーム名とグローバルオブジェクトディレクトリ（GOD）名を
	 * 指定してオブジェクトを作成する。
	 *
	 * @param	home	OZホーム名
	 * @param	god		GOD名
	 * @exception	ExGOLFormatException
	 *					GOL(GOD)の形式が正しくない。
	 */
	ExGOL(String home, String god)
	throws ExGOLFormatException
	{
		init(home,god);
	}

	/**
	 * GODオブジェクトを指定してオブジェクトを作成する。
	 *
	 * @param	god	GODオブジェクト
	 * @exception	ExGOLFormatException
	 *					GODの形式が正しくない。
	 */
	ExGOL(ExGOD god)
	throws ExGOLFormatException
	{
		init(ozHomeName,god.getName());
	}

	/**
	 * 自分と同じGOLを持つかを調べる。
	 *
	 * @param	obj	比較対象のオブジェクト
	 * @return	GOL が一致すれば、true を返す。
	 */
	public
	boolean equals(Object obj)
	{
		if (obj != null) {
			String gol;
			if (obj instanceof ExGOL) {
				gol = ((ExGOL)obj).getName();
			} else if (obj instanceof String) {
				gol = (String)obj;
			} else {
				gol = obj.toString();
			}
			return gol.equals(getName());
		}
		return false;
	}

	/**
	 * OZホーム名が現在動作しているエグゼキュータのOZホーム名と
	 * 一致すかを調べる。
	 *
	 * @return	OZホーム名が同じならば true を返す。
	 */
	boolean inside()
	{
		return home.equals(ozHomeName);
	}

	/**
	 * OZホーム名を表す文字列を返す。
	 *
	 * @return	OZホーム名
	 */
	String getHome()
	{
		return home;
	}

	/**
	 * GOLが当該エグゼキュータが動作しているOZホーム内の
	 * セル（グローバルオブジェクト）を示している場合に、
	 * GOD名を返す。
	 *
	 * @return	GOD名
	 * @exception	ExCellIllegalOzHomeException
	 *					OZホーム名が異なるので意味がない。
	 */
	String getGOD()
	throws ExCellIllegalOzHomeException
	{
		if (!inside()) {
			throw new ExCellIllegalOzHomeException(home+" is outside of "+ozHomeName);
		}
		return god;
	}

	/**
	 * GOLを表す文字列を返す。
	 *
	 * @return	GOL
	 */
	String getName()
	{
		return home+homeSeparator+god;
	}

	/**
	 * GOLオブジェクト自身のハッシュ値は意味がない。
	 * GOLを表す文字列のハッシュ値を返す。
	 *
	 * @return		ハッシュ値
	 */
	public
	int hashCode()
	{
		return getName().hashCode();
	}

	/**
	 * デフォルトの表示内容に home と god を加えた
	 * 表示のための文字列を返す。
	 */
	public
	String toString()
	{
		String cn = getClass().getName();
		if (cn.startsWith(Executor.IPAoz)) {
			cn = cn.substring(Executor.IPAoz.length(),cn.length());
		}
		return cn+"@"+Integer.toHexString(hashCode())
				+"[home="+home+",god="+god+"]";
	}
}
