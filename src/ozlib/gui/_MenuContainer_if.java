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
 * MenuContainer interface
 *
 * @version  $Id: _MenuContainer_if.java,v 1.4 1997/06/13 08:49:53 nito Exp $
 */


public interface _MenuContainer_if
  extends JP.go.ipa.oz.lang._Root_if
{

  //================================================== OZ methods
  public _Font_if getFont() throws Exception;
  public boolean postEvent(_Event_if evt) throws Exception;
  public void remove(_MenuComponent_if comp) throws Exception;

}

// EoF

