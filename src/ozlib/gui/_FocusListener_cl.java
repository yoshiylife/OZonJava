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
 * FocusListener implementation
 *
 * @version  $Id: _FocusListener_cl.java,v 1.11 1997/07/18 05:46:13 nito Exp $
 * @see      _FocusListener_if
 */


public abstract class _FocusListener_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._FocusListener_if
{

  _OzFocusListener  _body;
  _EventDispatchingQueue_if eventDispatchingQueue;

  static final int _FOCUSGAINED_ = 0;
  static final int _FOCUSLOST_ = 1;
  //================================================== constructors

  public _FocusListener_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  public java.lang.Object _new_newFocusListener(_EventDispatchingQueue_if queue)
    throws Exception
  {
    checkSecureInvocation();
    eventDispatchingQueue = queue;
    _OzFocusListener  l = new _OzFocusListener(queue);
    l.bind(this);
    _body = l;
    return this;
  }


  //======================================== OZ method implementation

  public final void dispatch(_EventObject_if object, int type) throws Exception
  {
    checkSecureInvocation();
    _FocusEvent_if event = null;
    event = (_FocusEvent_if) (object);
    if      (type == _FOCUSGAINED_) focusGained(event);
    else if (type == _FOCUSLOST_)   focusLost(event);
  }

  public void focusGained(_FocusEvent_if e) throws Exception {}
  public void focusLost(_FocusEvent_if e) throws Exception {}
}

// EoF

