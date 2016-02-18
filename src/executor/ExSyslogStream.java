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
 * $Id: ExSyslogStream.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
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
class	ExSyslogStream
extends	PrintStream
{
	/**
	 * エグゼキュータ実装のデバッグ用
	 */
	static final String CN = "ExSyslogStream";

	boolean logHeader;

	public
	ExSyslogStream(PrintStream out)
	{
		super(out);
		logHeader = true;
	}

	void header()
	{
		String date = (new Date()).toString();
		StringBuffer buffer = new StringBuffer(date.substring(0,19));
		buffer.append(" ");
		// buffer.append(Executor.hostName);
		// buffer.append(" [");
		// buffer.append(Executor.portName); buffer.append("] ");
		logHeader = false;
		((PrintStream)out).print(buffer);
	}

	public synchronized
	void write(int a)
	{
		if (logHeader) header();
		super.write(a);
		if (a == '\n') {
			super.flush();
			logHeader = true;
		}
	}

	public synchronized
	void write(byte a[], int off, int len)
	{
		if (logHeader) header();
		super.write(a, off, len);
		if (a[off+len-1] == '\n') {
			super.flush();
			logHeader = true;
		}
	}

	public synchronized
	void write(char a[])
	{
		if (logHeader) header();
		super.print(a);
		if (a[a.length-1] == '\n') {
			super.flush();
			logHeader = true;
		}
	}
}
