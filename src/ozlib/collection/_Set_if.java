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
 * Set interface
 *
 * @version  $Id: _Set_if.java,v 1.7 1997/06/17 09:44:56 hgoto Exp $
 * @see      _Collection_if
 * @see      _Set_cl
 */


public interface _Set_if
  extends JP.go.ipa.oz.lib.standard._Collection_if
{

  //================================================== OZ methods
  public _Set_if add(JP.go.ipa.oz.lang._Root_if element) throws Exception;

}

// EoF

