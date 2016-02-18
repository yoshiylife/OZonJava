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
 * EventObject interface
 *
 * @version  $Id: _EventObject_if.java,v 1.10 1997/11/26 01:49:27 hgoto Exp $
 */


public interface _EventObject_if
  extends JP.go.ipa.oz.lang._Root_if
{


  //================================================== OZ methods
  public JP.go.ipa.oz.lang._Root_if getSource() throws Exception;
  public _String_if asString() throws Exception;

  //================================================== support methods
//  public java.lang.String toString();

}

// EoF

