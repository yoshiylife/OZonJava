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
 * EventObject implementation
 *
 * @version  $Id: _EventObject_cl.java,v 1.12 1997/11/26 01:40:40 hgoto Exp $
 * @see      _EventObject_if
 */


public class _EventObject_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._EventObject_if
{

  static final java.lang.String  CN = "EventObject";
  _OzHoldable  _body;
  //java.util.EventObject  _body;


  //================================================== constructors

  _EventObject_cl(_OzEventObject eo)
    throws Exception
  {
    _body = eo;
  }

  public _EventObject_cl()
    throws Exception
  {
  }


  //================================================== OZ constructors

  public java.lang.Object _new_newEventObject(JP.go.ipa.oz.lang._Root_if source)
    throws Exception
  {
    _OzEventObject  e = new _OzEventObject(source);
    e.bind(this);
    _body = e;
    return this;
  }


  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public _String_if asString() //@
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = CN.concat("[source=")
      .concat(((_String_cl)(getSource().asString()))._body)
      .concat("]");
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public JP.go.ipa.oz.lang._Root_if getSource()
    throws Exception
  {
    _OzHoldable  j;
    checkSecureInvocation();
    j = (_OzHoldable)((java.util.EventObject)_body).getSource();
    return (JP.go.ipa.oz.lang._Root_if)(j.oz());
  }


  //================================================== support methods

//  public java.lang.String toString()
//  {
//    return ((_String_cl)asString())._body;
//  }

}

// EoF
