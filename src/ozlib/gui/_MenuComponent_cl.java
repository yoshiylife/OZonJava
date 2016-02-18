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
 * MenuComponent implementation
 *
 * @version  $Id: _MenuComponent_cl.java,v 1.9 1997/07/04 02:27:08 nito Exp $
 * @see      _MenuComponent_if
 */


public abstract class _MenuComponent_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._MenuComponent_if
{

  static final java.lang.String  CN = "MenuComponent";
  _OzHoldable  _body;


  //================================================== constructors

  public _MenuComponent_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  public java.lang.Object _new_newMenuComponent() throws Exception {return this;}


  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public final void dispatchEvent(_AWTEvent_if e)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.AWTEvent  arg_e = (java.awt.AWTEvent)(((_AWTEvent_cl)e)._body);
    ((java.awt.MenuComponent)_body).dispatchEvent(arg_e);
  }

  //------------------------------------------------------------------
  public _Font_if getFont()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Font  rv_tmp = ((java.awt.MenuComponent)_body).getFont();
    if (rv_tmp == null) return null;
    _Font_cl  rv = new _Font_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _String_if getName()
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = ((java.awt.MenuComponent)_body).getName();
    if (rv_tmp == null) return null;
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _MenuContainer_if getParent()
    throws Exception
  {
    checkSecureInvocation();
    _OzHoldable  rv_tmp = (_OzHoldable)(((java.awt.MenuComponent)_body).getParent());
    if (rv_tmp == null) return null;
    _MenuContainer_if  rv = (_MenuContainer_if)(rv_tmp.oz());
    return rv;
  }

  //public _MenuComponentPeer_if getPeer(); //DEPRECATED

  //------------------------------------------------------------------
  public boolean postEvent(_Event_if evt)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Event  arg_evt = ((_Event_cl)evt)._body;
    return ((java.awt.MenuComponent)_body).postEvent(arg_evt);
  }

  //------------------------------------------------------------------
  public void removeNotify()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.MenuComponent)_body).removeNotify();
  }

  //------------------------------------------------------------------
  public void setFont(_Font_if f)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Font  arg_f = ((_Font_cl)f)._body;
    ((java.awt.MenuComponent)_body).setFont(arg_f);
  }

  //------------------------------------------------------------------
  public void setName(_String_if name)
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  arg_name = ((_String_cl)name)._body;
    ((java.awt.MenuComponent)_body).setName(arg_name);
  }


  // ================================================== protected methods
  //protected _String_if paramString(){}
  //protected void processEvent(_AWTEvent_if e){}

}

// EoF

