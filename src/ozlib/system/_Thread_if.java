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

package		JP.go.ipa.oz.lang;

public interface _Thread_if extends _Root_if
{
	public void join(long timeout) throws Exception;
	public void join() throws Exception;
	public boolean isAlive() throws Exception;
	public void interrupt() throws Exception;
	public boolean isInterrupted() throws Exception;
}
