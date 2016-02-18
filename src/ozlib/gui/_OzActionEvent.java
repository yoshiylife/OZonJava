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
 * _OzActionEvent
 *
 * @version  $Id: _OzActionEvent.java,v 1.5 1997/06/18 12:58:11 nito Exp $
 * @see      _ActionEvent_cl
 */


public final class _OzActionEvent
  extends    java.awt.event.ActionEvent
  implements JP.go.ipa.oz.lib.standard._OzHoldable
{
  JP.go.ipa.oz.lang._Root_if  _oz;
  java.lang.Object            _java;

  //================================================== constructors

  public _OzActionEvent(java.lang.Object source, int id, java.lang.String command)
    throws Exception
  {
    super(source, id, command);
  }

  public _OzActionEvent(java.lang.Object source, int id, java.lang.String command, int modifiers)
    throws Exception
  {
    super(source, id, command, modifiers);
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

