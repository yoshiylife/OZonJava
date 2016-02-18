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

// OZ Class Library (Collection)


package JP.go.ipa.oz.lib.standard;


/**
 * Association interface
 *
 * @version  $Id: _Association_if.java,v 1.7 1997/06/17 09:44:54 hgoto Exp $
 * @see      _Association_cl
 */


public interface _Association_if
  extends JP.go.ipa.oz.lang._Root_if
{

  //================================================== OZ methods
  public _Association_if duplicate() throws Exception;
  public JP.go.ipa.oz.lang._Root_if key() throws Exception;
  public _Association_if setValue(JP.go.ipa.oz.lang._Root_if value) throws Exception;
  public JP.go.ipa.oz.lang._Root_if value() throws Exception;

}

// EoF
