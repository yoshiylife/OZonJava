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
 * ItemListener implementation
 *
 * @version  $Id: _ItemListener_cl.java,v 1.12 1997/07/18 05:46:13 nito Exp $
 * @see      _ItemListener_if
 */


public class _ItemListener_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._ItemListener_if
{

  _OzItemListener  _body;
  _EventDispatchingQueue_if eventDispatchingQueue;

  static final int _ITEMSTATECHANGED_ = 0;
  //================================================== constructors

  public _ItemListener_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  public java.lang.Object _new_newItemListener(_EventDispatchingQueue_if queue)
    throws Exception
  {
    checkSecureInvocation();
    eventDispatchingQueue = queue;
    _OzItemListener  l = new _OzItemListener(queue);
    l.bind(this);
    _body = l;
    return this;
  }


  //======================================== OZ method implementation

  public final void dispatch(_EventObject_if object, int type) throws Exception
  {
    checkSecureInvocation();
    _ItemEvent_if event = null;
    event = (_ItemEvent_if) (object);
    if (type == _ITEMSTATECHANGED_) itemStateChanged(event);
  }

  public void itemStateChanged(_ItemEvent_if e) throws Exception
  {
    // define with subclassing
  }

}

// EoF

