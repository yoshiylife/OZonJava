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
 * ActionEvent implementation
 *
 * @version  $Id: _ActionEvent_cl.java,v 1.12 1997/07/04 02:27:06 nito Exp $
 * @see      _ActionEvent_if
 * @see      _AWTEvent_cl
 */


public class _ActionEvent_cl
  extends    JP.go.ipa.oz.lib.standard._AWTEvent_cl
  implements JP.go.ipa.oz.lib.standard._ActionEvent_if
{

  public final int getSHIFT_MASK() throws Exception
    { return _static_getSHIFT_MASK(); }

  public static final int _static_getSHIFT_MASK() throws Exception
    { return java.awt.event.ActionEvent.SHIFT_MASK; }

  public final int getCTRL_MASK() throws Exception
    { return _static_getCTRL_MASK(); }

  public static final int _static_getCTRL_MASK() throws Exception
    { return java.awt.event.ActionEvent.CTRL_MASK; }

  public final int getMETA_MASK() throws Exception
    { return _static_getMETA_MASK(); }

  public static final int _static_getMETA_MASK() throws Exception
    { return java.awt.event.ActionEvent.META_MASK; }

  public final int getALT_MASK() throws Exception
    { return _static_getALT_MASK(); }

  public static final int _static_getALT_MASK() throws Exception
    { return java.awt.event.ActionEvent.ALT_MASK; }

  public final int getACTION_FIRST() throws Exception
    { return _static_getACTION_FIRST(); }

  public static final int _static_getACTION_FIRST() throws Exception
    { return java.awt.event.ActionEvent.ACTION_FIRST; }

  public final int getACTION_LAST() throws Exception
    { return _static_getACTION_LAST(); }

  public static final int _static_getACTION_LAST() throws Exception
    { return java.awt.event.ActionEvent.ACTION_LAST; }

  public final int getACTION_PERFORMED() throws Exception
    { return _static_getACTION_PERFORMED(); }

  public static final int _static_getACTION_PERFORMED() throws Exception
    { return java.awt.event.ActionEvent.ACTION_PERFORMED; }



  static final java.lang.String  CN = "ActionEvent";


  //================================================== constructors

  _ActionEvent_cl(_OzActionEvent ae)
    throws Exception
  {
    _body = ae;
  }

  public _ActionEvent_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  //------------------------------------------------------------------
  public java.lang.Object _new_newActionEvent(JP.go.ipa.oz.lang._Root_if source,
				  int id, _String_if command)
    throws Exception
  {
    java.lang.String  arg_command = ((_String_cl)command)._body;
    _OzActionEvent  e = new _OzActionEvent(source, id, arg_command);
    e.bind(this);
    _body = e;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newActionEvent(JP.go.ipa.oz.lang._Root_if source,
				  int id, _String_if command, int modifiers)
    throws Exception
  {
    java.lang.String  arg_command = ((_String_cl)command)._body;
    _OzActionEvent  e = new _OzActionEvent(source, id, arg_command, modifiers);
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
  public _String_if getActionCommand()
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = ((java.awt.event.ActionEvent)_body).getActionCommand();
    if (rv_tmp == null) return null;
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public int getModifiers()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.event.ActionEvent)_body).getModifiers();
  }

  //------------------------------------------------------------------
  public _String_if paramString()
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = ((java.awt.event.ActionEvent)_body).paramString();
    if (rv_tmp == null) return null;
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

}

// EoF


