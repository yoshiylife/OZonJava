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

// OZ Collection Library (AWT)


package JP.go.ipa.oz.lib.standard;


/**
 * Shape interface
 *
 * @version  $Id: _Shape_if.java,v 1.4 1997/06/13 08:49:56 nito Exp $
 */


public interface _Shape_if
  extends JP.go.ipa.oz.lang._Root_if
{

  //================================================== OZ methods
  public _Rectangle_if getBounds() throws Exception;

}

// EoF

