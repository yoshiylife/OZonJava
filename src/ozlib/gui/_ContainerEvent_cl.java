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
 * ContainerEvent implementation
 *
 * @version  $Id: _ContainerEvent_cl.java,v 1.10 1997/07/04 02:27:07 nito Exp $
 * @see      _ContainerEvent_if
 * @see      _ComponentEvent_cl
 */


public class _ContainerEvent_cl
  extends    JP.go.ipa.oz.lib.standard._ComponentEvent_cl
  implements JP.go.ipa.oz.lib.standard._ContainerEvent_if
{

  public final int getCONTAINER_FIRST() throws Exception
    { return _static_getCONTAINER_FIRST(); }

  public static final int _static_getCONTAINER_FIRST() throws Exception
    { return java.awt.event.ContainerEvent.CONTAINER_FIRST; }

  public final int getCONTAINER_LAST() throws Exception
    { return _static_getCONTAINER_LAST(); }

  public static final int _static_getCONTAINER_LAST() throws Exception
    { return java.awt.event.ContainerEvent.CONTAINER_LAST; }

  public final int getCOMPONENT_ADDED() throws Exception
    { return _static_getCOMPONENT_ADDED(); }

  public static final int _static_getCOMPONENT_ADDED() throws Exception
    { return java.awt.event.ContainerEvent.COMPONENT_ADDED; }

  public final int getCOMPONENT_REMOVED() throws Exception
    { return _static_getCOMPONENT_REMOVED(); }

  public static final int _static_getCOMPONENT_REMOVED() throws Exception
    { return java.awt.event.ContainerEvent.COMPONENT_REMOVED; }


  static final java.lang.String  CN = "ContainerEvent";


  //================================================== constructors

  _ContainerEvent_cl(_OzContainerEvent ce)
    throws Exception
  {
    _body = ce;
  }

  public _ContainerEvent_cl()
    throws Exception
  {
  }


  //======================================== OZ constructors implementation

  public java.lang.Object _new_newContainerEvent(_Component_if source, int id, _Component_if child)
    throws Exception
  {
    java.awt.Component  arg_source = (java.awt.Component)(((_Component_cl)source)._body);
    java.awt.Component  arg_child = (java.awt.Component)(((_Component_cl)child)._body);
    _OzContainerEvent  e = new _OzContainerEvent(arg_source, id, arg_child);
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
  public _Component_if getChild()
    throws Exception
  {
    checkSecureInvocation();
    _OzHoldable  rv_tmp = (_OzHoldable)((((java.awt.event.ContainerEvent)_body).getChild()));
    if (rv_tmp == null) return null;
    return (_Component_if)(rv_tmp.oz());
  }

  //------------------------------------------------------------------
  public _Container_if getContainer()
    throws Exception
  {
    checkSecureInvocation();
    _OzHoldable  rv_tmp = (_OzHoldable)((((java.awt.event.ContainerEvent)_body).getContainer()));
    if (rv_tmp == null) return null;
    return (_Container_if)(rv_tmp.oz());
  }

  //------------------------------------------------------------------
  public _String_if paramString()
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = ((java.awt.event.ContainerEvent)_body).paramString();
    if (rv_tmp == null) return null;
    _String_cl  rv = new _String_cl(rv_tmp);
    return rv;
  }

}

// EoF

