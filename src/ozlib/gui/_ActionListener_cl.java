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
 * ActionListener implementation
 *
 * @version  $Id: _ActionListener_cl.java,v 1.12 1997/07/18 05:46:12 nito Exp $
 * @see      _ActionListener_if
 */


public class _ActionListener_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._ActionListener_if
{

  _OzActionListener  _body;
  _EventDispatchingQueue_if eventDispatchingQueue;

  static final int _ACTIONPERFORMED_ = 0;

  //================================================== constructors

  public _ActionListener_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  public java.lang.Object _new_newActionListener(_EventDispatchingQueue_if queue)
    throws Exception
  {
    checkSecureInvocation();
    eventDispatchingQueue = queue;
    _OzActionListener l = new _OzActionListener(queue);
    l.bind(this);
    _body = l;
    return this;
  }

  //======================================== OZ method implementation

  public final void dispatch(_EventObject_if object, int type) throws Exception
  {
    checkSecureInvocation();
    _ActionEvent_if event = null;
    event = (_ActionEvent_if) (object);
    if (type == _ACTIONPERFORMED_) actionPerformed(event);
  }

  public void actionPerformed(_ActionEvent_if e) throws Exception
  {
     // define with subclassing.
  }
}

// EoF

