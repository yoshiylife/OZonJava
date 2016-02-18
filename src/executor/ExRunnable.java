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
 * $Id: ExRunnable.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 */

package JP.go.ipa.oz.system;

/***
 * ExRunnable is a class to be used to fork thread.<br>
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author		Yoichi Hamazaki
 */

final class ExRunnable
extends OzSecure
implements Runnable
{
  OzRunnable target;

  ExRunnable(OzRunnable t)
    {
      target=t;
	  color=t.color;
    }

  public void run()
    {
      try{
	target.run();
      }catch (Exception ex){
	Executor.syslog("ExRunnable","run"," run of OzRunnable treminated with exception",ex);
      }finally{
	ExCalleeChannel callee = ((ExThread)Thread.currentThread()).channel;
	try{
	  callee.exit(true,null);
	} catch (ExException exex){
	  Executor.syslog("ExRunnable","run","Exception at ExCalleeChannel.exit",exex);
	}
      }
    }

}
