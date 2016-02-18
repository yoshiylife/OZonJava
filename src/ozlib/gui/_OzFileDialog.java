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
 * _OzFileDialog
 *
 * @version  $Id: _OzFileDialog.java,v 1.4 1997/06/18 12:58:12 nito Exp $
 * @see      _FileDialog_cl
 */


public final class _OzFileDialog
  extends    java.awt.FileDialog
  implements JP.go.ipa.oz.lib.standard._OzHoldable
{
  JP.go.ipa.oz.lang._Root_if  _oz;
  java.lang.Object              _java;

  //================================================== constructors

  public _OzFileDialog(java.awt.Frame parent)
    throws Exception
  {
    super(parent);
  }

  public _OzFileDialog(java.awt.Frame parent, java.lang.String title)
    throws Exception
  {
    super(parent, title);
  }

  public _OzFileDialog(java.awt.Frame parent, java.lang.String title, int mode)
    throws Exception
  {
    super(parent, title, mode);
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
