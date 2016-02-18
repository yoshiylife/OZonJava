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
 * $Id: ExPrintStream.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 *
 * 注意: このファイルは vi で、hardtab=8, tabstop=4 として編集されている
 */

package JP.go.ipa.oz.system;

import java.io.PrintStream;
import java.io.OutputStream;
import java.util.Date;
import java.io.IOException;

/**
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author		Yasumitsu Yoshida
 */
class	ExPrintStream
extends	PrintStream
{
	public
	ExPrintStream(OutputStream out)
	{
		super(out,false);
	}

	public synchronized
	void write(int a)
	{
		super.write(a);
		if (a == '\n') {
			super.flush();
		}
	}

	public synchronized
	void write(byte a[], int off, int len)
	{
		super.write(a, off, len);
		if (a[off+len-1] == '\n') {
			super.flush();
		}
	}

	public synchronized
	void write(char a[])
	{
		super.print(a);
		if (a[a.length-1] == '\n') {
			super.flush();
		}
	}
}
