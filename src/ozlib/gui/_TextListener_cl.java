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

// OZ Class Library A(WT)


package JP.go.ipa.oz.lib.standard;


/**
 * TextListener implementation
 *
 * @version  $Id: _TextListener_cl.java,v 1.11 1997/07/18 05:46:13 nito Exp $
 * @see      _TextListener_if
 */


public abstract class _TextListener_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._TextListener_if
{

  _OzTextListener  _body;
  _EventDispatchingQueue_if eventDispatchingQueue;

  static final int _TEXTVALUECHANGED_ = 0;
  //================================================== constructors

  public _TextListener_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  public java.lang.Object _new_newTextListener(_EventDispatchingQueue_if queue)
    throws Exception
  {
    checkSecureInvocation();
    eventDispatchingQueue = queue;
    _OzTextListener  l = new _OzTextListener(queue);
    l.bind(this);
    _body = l;
    return this;
  }


  //======================================== OZ method implementation

  public final void dispatch(_EventObject_if object, int type) throws Exception
  {
    checkSecureInvocation();
    _TextEvent_if event = null;
    event = (_TextEvent_if) (object);
    if (type == _TEXTVALUECHANGED_) textValueChanged(event);
  }

  public void textValueChanged(_TextEvent_if e) throws Exception {}

}

// EoF

