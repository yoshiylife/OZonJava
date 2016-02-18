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
 * TextEvent implementation
 *
 * @version  $Id: _TextEvent_cl.java,v 1.10 1997/07/04 02:27:09 nito Exp $
 * @see      _TextEvent_if
 * @see      _AWTEvent_cl
 */


public class _TextEvent_cl
  extends    JP.go.ipa.oz.lib.standard._AWTEvent_cl
  implements JP.go.ipa.oz.lib.standard._TextEvent_if
{

  public final int getTEXT_FIRST() throws Exception
    { return _static_getTEXT_FIRST(); }

  public static final int _static_getTEXT_FIRST() throws Exception
    { return java.awt.event.TextEvent.TEXT_FIRST; }

  public final int getTEXT_LAST() throws Exception
    { return _static_getTEXT_LAST(); }

  public static final int _static_getTEXT_LAST() throws Exception
    { return java.awt.event.TextEvent.TEXT_LAST; }

  public final int getTEXT_VALUE_CHANGED() throws Exception
    { return _static_getTEXT_VALUE_CHANGED(); }

  public static final int _static_getTEXT_VALUE_CHANGED() throws Exception
    { return java.awt.event.TextEvent.TEXT_VALUE_CHANGED; }


  static final java.lang.String  CN = "TextEvent";


  //================================================== constructors

  _TextEvent_cl(_OzTextEvent te)
    throws Exception
  {
    _body = te;
  }

  public _TextEvent_cl()
    throws Exception
  {
  }


  //================================================== OZ constructors

  public java.lang.Object _new_newTextEvent(JP.go.ipa.oz.lang._Root_if source, int id)
    throws Exception
  {
    _OzTextEvent  e = new _OzTextEvent(source, id);
    e.bind(this);
    _body = e;
    return this;
  }


  //================================================== OZ methods

  //------------------------------------------------------------------
  public _String_if asString() //@
    throws Exception
  {
    java.lang.String  rv_tmp = CN.concat("[");
    // some infromation may be included !!!
    rv_tmp = rv_tmp.concat("]");
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  public _String_if paramString()
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = ((java.awt.event.TextEvent)_body).paramString();
    if (rv_tmp == null) return null;
    _String_cl  rv = new _String_cl(rv_tmp);
    return rv;
  }

}

// EoF

