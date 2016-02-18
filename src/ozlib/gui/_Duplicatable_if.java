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
 * Duplicatable interface
 * Same as Java Cloneable, but we could not define a clone method
 * which returns _Root_if.
 *
 * @version  $Id: _Duplicatable_if.java,v 1.3 1997/06/13 08:49:49 nito Exp $
 * @see      _Duplicatable_cl
 */


public interface _Duplicatable_if
  extends JP.go.ipa.oz.lang._Root_if
{

  //================================================== OZ methods
  public JP.go.ipa.oz.lang._Root_if duplicate() throws Exception; //<clone

}

// EoF
