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
 * MenuShortcut implementation
 *
 * @version  $Id: _MenuShortcut_cl.java,v 1.10 1997/06/24 07:11:16 nito Exp $
 * @see      _MenuShortcut_if
 */


public class _MenuShortcut_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._MenuShortcut_if
{

  static final java.lang.String  CN = "MenuShortcut";
  java.awt.MenuShortcut  _body;


  //================================================== constructors

  _MenuShortcut_cl(java.awt.MenuShortcut s)
    throws Exception
  {
    _body = s;
  }

  public _MenuShortcut_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  //------------------------------------------------------------------
  public java.lang.Object _new_newMenuShortcut(int key)
    throws Exception
  {
    _body = new java.awt.MenuShortcut(key);
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newMenuShortcut(int key, boolean useShiftModifier)
    throws Exception
  {
    _body = new java.awt.MenuShortcut(key, useShiftModifier);
    return this;
  }


  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public _String_if asString() //@
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = _body.toString();
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public int getKey()
    throws Exception
  {
    checkSecureInvocation();
    return _body.getKey();
  }

  //------------------------------------------------------------------
  public boolean usesShiftModifier()
    throws Exception
  {
    checkSecureInvocation();
    return _body.usesShiftModifier();
  }


  //================================================== support methods

//  public java.lang.String toString()
//  {
//    java.lang.String  rv = _body.toString();
//    return rv;
//  }


  //================================================== protected methods
  //protected String paramString() {}

}

// EoF
