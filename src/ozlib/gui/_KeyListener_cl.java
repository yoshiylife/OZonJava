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
 * KeyListener implementation
 *
 * @version  $Id: _KeyListener_cl.java,v 1.11 1997/07/18 05:46:13 nito Exp $
 * @see      _KeyListener_if
 */


public abstract class _KeyListener_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._KeyListener_if
{

  _OzKeyListener  _body;
  _EventDispatchingQueue_if eventDispatchingQueue;

  static final int _KEYPRESSED_ = 0;
  static final int _KEYRELEASED_ = 1;
  static final int _KEYTYPED_ = 2;
  //================================================== constructors

  public _KeyListener_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  public java.lang.Object _new_newKeyListener(_EventDispatchingQueue_if queue)
    throws Exception
  {
    checkSecureInvocation();
    eventDispatchingQueue = queue;
    _OzKeyListener  l = new _OzKeyListener(queue);
    l.bind(this);
    _body = l;
    return this;
  }


  //======================================== OZ method implementation

  public final void dispatch(_EventObject_if object, int type) throws Exception
  {
    checkSecureInvocation();
    _KeyEvent_if event = null;
    event = (_KeyEvent_if) (object);
    if      (type == _KEYPRESSED_)  keyPressed(event);
    else if (type == _KEYRELEASED_) keyReleased(event);
    else if (type == _KEYTYPED_)    keyTyped(event);
  }

  public void keyPressed(_KeyEvent_if e) throws Exception {}
  public void keyReleased(_KeyEvent_if e) throws Exception {}
  public void keyTyped(_KeyEvent_if e) throws Exception {}

}

// EoF

