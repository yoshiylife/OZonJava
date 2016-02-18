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
 * _OzCheckbox
 *
 * @version  $Id: _OzCheckbox.java,v 1.5 1997/06/18 12:58:12 nito Exp $
 * @see      _Checkbox_cl
 */


public final class _OzCheckbox
  extends    java.awt.Checkbox
  implements JP.go.ipa.oz.lib.standard._OzHoldable
{
  JP.go.ipa.oz.lang._Root_if  _oz;
  java.lang.Object              _java;

  //================================================== constructors

  public _OzCheckbox()
    throws Exception
  {
    super();
  }

  public _OzCheckbox(java.lang.String label)
    throws Exception
  {
    super(label);
  }

  public _OzCheckbox(java.lang.String label, boolean state)
    throws Exception
  {
    super(label, state);
  }

  public _OzCheckbox(java.lang.String label, boolean state, java.awt.CheckboxGroup group)
    throws Exception
  {
    super(label, state, group);
  }

  public _OzCheckbox(java.lang.String label, java.awt.CheckboxGroup group, boolean state)
    throws Exception
  {
    super(label, group, state);
  }

  //================================================== methods

  public JP.go.ipa.oz.lang._Root_if oz()
    throws Exception
  {
    return _oz;
  }

  public java.lang.Object java()
    throws Exception
  {
    return _java;
  }

  public void bind(JP.go.ipa.oz.lang._Root_if ozobj)
  {
    _oz = ozobj;
    _java = this;
  }

}

// EoF

