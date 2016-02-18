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
 * ComponentEvent implementation
 *
 * @version  $Id: _ComponentEvent_cl.java,v 1.10 1997/07/04 02:27:07 nito Exp $
 * @see      _ComponentEvent_if
 * @see      _AWTEvent_cl
 */


public class _ComponentEvent_cl
  extends    JP.go.ipa.oz.lib.standard._AWTEvent_cl
  implements JP.go.ipa.oz.lib.standard._ComponentEvent_if
{

  public final int getCOMPONENT_FIRST() throws Exception
    { return _static_getCOMPONENT_FIRST(); }

  public static final int _static_getCOMPONENT_FIRST() throws Exception
    { return java.awt.event.ComponentEvent.COMPONENT_FIRST; }

  public final int getCOMPONENT_LAST() throws Exception
    { return _static_getCOMPONENT_LAST(); }

  public static final int _static_getCOMPONENT_LAST() throws Exception
    { return java.awt.event.ComponentEvent.COMPONENT_LAST; }

  public final int getCOMPONENT_MOVED() throws Exception
    { return _static_getCOMPONENT_MOVED(); }

  public static final int _static_getCOMPONENT_MOVED() throws Exception
    { return java.awt.event.ComponentEvent.COMPONENT_MOVED; }

  public final int getCOMPONENT_RESIZED() throws Exception
    { return _static_getCOMPONENT_RESIZED(); }

  public static final int _static_getCOMPONENT_RESIZED() throws Exception
    { return java.awt.event.ComponentEvent.COMPONENT_RESIZED; }

  public final int getCOMPONENT_SHOWN() throws Exception
    { return _static_getCOMPONENT_SHOWN(); }

  public static final int _static_getCOMPONENT_SHOWN() throws Exception
    { return java.awt.event.ComponentEvent.COMPONENT_SHOWN; }

  public final int getCOMPONENT_HIDDEN() throws Exception
    { return _static_getCOMPONENT_HIDDEN(); }

  public static final int _static_getCOMPONENT_HIDDEN() throws Exception
    { return java.awt.event.ComponentEvent.COMPONENT_HIDDEN; }



  static final java.lang.String  CN = "ComponentEvent";


  //================================================== constructors

  _ComponentEvent_cl(_OzComponentEvent ce)
    throws Exception
  {
    _body = ce;
  }

  public _ComponentEvent_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  public java.lang.Object _new_newComponentEvent(_Component_if source, int id)
    throws Exception
  {
    java.awt.Component  arg_source = (java.awt.Component)(((_Component_cl)source)._body);
    _OzComponentEvent  e = new _OzComponentEvent(arg_source, id);
    e.bind(this);
    _body = e;
    return this;
  }


  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public _String_if asString() //@
    throws Exception
  {
    java.lang.String  rv_tmp = CN.concat("[");
    // some infromation may be included !!!
    rv_tmp = rv_tmp.concat("]");
    if (rv_tmp == null) return null;
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _Component_if getComponent()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Component rv_tmp = ((java.awt.event.ComponentEvent)_body).getComponent();
    if (rv_tmp == null) return null;
    _Component_if  rv = (_Component_if)(((_OzHoldable)rv_tmp).oz());
    return rv;
  }

  //------------------------------------------------------------------
  public _String_if paramString()
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String rv_tmp = ((java.awt.event.ComponentEvent)_body).paramString();
    if (rv_tmp == null) return null;
    _String_cl  rv = new _String_cl(rv_tmp);
    return rv;
  }

}

// EoF

