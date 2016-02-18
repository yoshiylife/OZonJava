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
 * MenuComponent interface
 *
 * @version  $Id: _MenuComponent_if.java,v 1.6 1997/06/13 08:49:53 nito Exp $
 * @see      _MenuComponent_cl
 */


public interface _MenuComponent_if
  extends JP.go.ipa.oz.lang._Root_if
{


  //================================================== OZ methods
  public void dispatchEvent(_AWTEvent_if e) throws Exception; //final
  public _Font_if getFont() throws Exception;
  public _String_if getName() throws Exception;
  public _MenuContainer_if getParent() throws Exception;
  //public _MenuComponentPeer_if getPeer() throws Exception; //DEPRECATED
  public boolean postEvent(_Event_if evt) throws Exception;
  public void removeNotify() throws Exception;
  public void setFont(_Font_if f) throws Exception;
  public void setName(_String_if name) throws Exception;

}

// EoF

