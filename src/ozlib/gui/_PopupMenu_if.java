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
 * PopupMenu interface
 *
 * @version  $Id: _PopupMenu_if.java,v 1.7 1997/06/24 07:11:17 nito Exp $
 * @see      _Menu_if
 */


public interface _PopupMenu_if
  extends JP.go.ipa.oz.lib.standard._Menu_if
{


  //================================================== OZ methods
  public void addNotify() throws Exception; //synchronized
  public void show(_Component_if origin, int x, int y) throws Exception;
  public _String_if asString() throws Exception;
}

// EoF

