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
 * MouseListener implementation
 *
 * @version  $Id: _MouseListener_cl.java,v 1.11 1997/07/18 05:46:13 nito Exp $
 * @see      _MouseListener_if
 */


public abstract class _MouseListener_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._MouseListener_if
{

  _OzMouseListener  _body;
  _EventDispatchingQueue_if eventDispatchingQueue;

  static final int _MOUSECLICKED_ = 0;
  static final int _MOUSEENTERED_ = 1;
  static final int _MOUSEEXITED_ = 2;
  static final int _MOUSEPRESSED_ = 3;
  static final int _MOUSERELEASED_ = 4;
  //================================================== constructors

  public _MouseListener_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  public java.lang.Object _new_newMouseListener(_EventDispatchingQueue_if queue)
    throws Exception
  {
    checkSecureInvocation();
    eventDispatchingQueue = queue;
    _OzMouseListener  l = new _OzMouseListener(queue);
    l.bind(this);
    _body = l;
    return this;
  }


  //======================================== OZ method implementation

  public final void dispatch(_EventObject_if object, int type) throws Exception
  {
    checkSecureInvocation();
    _MouseEvent_if event = null;
    event = (_MouseEvent_if) (object);
    if      (type == _MOUSECLICKED_)  mouseClicked(event);
    else if (type == _MOUSEENTERED_)  mouseEntered(event);
    else if (type == _MOUSEEXITED_)   mouseExited(event);
    else if (type == _MOUSEPRESSED_)  mousePressed(event);
    else if (type == _MOUSERELEASED_) mouseReleased(event);
  }

  public void mouseClicked(_MouseEvent_if e) throws Exception {}
  public void mouseEntered(_MouseEvent_if e) throws Exception {}
  public void mouseExited(_MouseEvent_if e) throws Exception {}
  public void mousePressed(_MouseEvent_if e) throws Exception {}
  public void mouseReleased(_MouseEvent_if e) throws Exception {}
}

// EoF

