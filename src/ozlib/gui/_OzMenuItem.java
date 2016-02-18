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
 * _OzMenuItem
 *
 * @version  $Id: _OzMenuItem.java,v 1.5 1997/06/18 12:58:13 nito Exp $
 * @see      _MenuItem_cl
 */


public final class _OzMenuItem
  extends    java.awt.MenuItem
  implements JP.go.ipa.oz.lib.standard._OzHoldable
{
  JP.go.ipa.oz.lang._Root_if  _oz;
  java.lang.Object            _java;

  //================================================== constructors

  public _OzMenuItem()
    throws Exception
  {
    super();
  }

  public _OzMenuItem(java.lang.String label)
    throws Exception
  {
    super(label);
  }

  public _OzMenuItem(java.lang.String label, java.awt.MenuShortcut s)
    throws Exception
  {
    super(label, s);
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
    throws Exception
  {
    _oz = ozobj;
    _java = this;
  }

}

// EoF
