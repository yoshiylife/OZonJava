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

// OZ Class Library (AWT)


package JP.go.ipa.oz.lib.standard;


/**
 * EventQueue implementation
 *
 * @version  $Id: _EventQueue_cl.java,v 1.9 1997/07/04 02:27:07 nito Exp $
 */


public class _EventQueue_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._EventQueue_if
{

  final static java.lang.String  CN = "EventQueue";
  java.awt.EventQueue  _body;


  //================================================== constructors

  _EventQueue_cl(java.awt.EventQueue q)
    throws Exception
  {
    _body = q;
  }

  public _EventQueue_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  public java.lang.Object _new_newEventQueue()
    throws Exception
  {
    _body = new java.awt.EventQueue();
    return this;
  }


  //================================================== OZ public methods

  //------------------------------------------------------------------
  public _AWTEvent_if getNextEvent() //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.AWTEvent  rv_tmp;
    try {
      rv_tmp = _body.getNextEvent();
    } catch (java.lang.InterruptedException ex) {
      _InterruptedException_if  ex_oz
	= (_InterruptedException_cl)(new _InterruptedException_cl()._new_init(ex.getMessage()));
      throw new JP.go.ipa.oz.lang.OzException(ex_oz);
    } 

    _AWTEvent_if  rv = (_AWTEvent_if)(((_OzHoldable)rv_tmp).oz());
    return rv;
  }

  //------------------------------------------------------------------
  public _AWTEvent_if peekEvent() //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.AWTEvent  rv_tmp = _body.peekEvent();
    if (rv_tmp == null) return null;
    _AWTEvent_if  rv = (_AWTEvent_if)(((_OzHoldable)rv_tmp).oz());
    return rv;
  }

  //------------------------------------------------------------------
  public _AWTEvent_if peekEvent(int id) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.AWTEvent  rv_tmp = _body.peekEvent(id);
    if (rv_tmp == null) return null;
    _AWTEvent_if  rv = (_AWTEvent_if)(((_OzHoldable)rv_tmp).oz());
    return rv;
  }

  //------------------------------------------------------------------
  public void postEvent(_AWTEvent_if e) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.AWTEvent  arg_e = (java.awt.AWTEvent)((((_AWTEvent_cl)e)._body).java());
    _body.postEvent(arg_e);
  }

}

// EoF
