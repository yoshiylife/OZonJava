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
 * _OzItemEvent
 *
 * @version  $Id: _OzItemEvent.java,v 1.5 1997/06/18 12:58:13 nito Exp $
 * @see      _ItemEvent_cl
 */


public final class _OzItemEvent
  extends    java.awt.event.ItemEvent
  implements JP.go.ipa.oz.lib.standard._OzHoldable
{
  JP.go.ipa.oz.lang._Root_if  _oz;
  java.lang.Object            _java;

  //================================================== constructors

  public _OzItemEvent(java.awt.ItemSelectable source, int id, java.lang.Object item, int stateChange)
    throws Exception
  {
    super(source, id, item, stateChange);
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

