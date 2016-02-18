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

package	JP.go.ipa.oz.lang;

public class _Thread_cl extends _Root_cl implements _Thread_if
{
    class Runnable extends JP.go.ipa.oz.system.OzRunnable
    {
	_Runnable_if	target;

	Runnable(_Runnable_if target)
	{
	    this.target = target;
	}

	public void run() throws Exception
	{
	    target.run();
	}
    }

    JP.go.ipa.oz.system.OzThread _body;

    public _Thread_cl() throws Exception
    {
	super();
    }

    public _Root_if _new_create(_Runnable_if target) throws Exception
    {
	_body = new JP.go.ipa.oz.system.OzThread(new Runnable(target));
	return this;
    }

    public void join(long timeout) throws Exception
    {
	checkSecureInvocation();
	_body.join(timeout);
    }

    public void join() throws Exception
    {
	checkSecureInvocation();
	_body.join(0);
    }

    public boolean isAlive() throws Exception
    {
	checkSecureInvocation();
	return _body.isAlive();
    }

    public void interrupt() throws Exception
    {
	checkSecureInvocation();
	_body.interrupt();
    }

    public boolean isInterrupted() throws Exception
    {
	checkSecureInvocation();
	return JP.go.ipa.oz.system.OzThread.interrupted();
    }
}
