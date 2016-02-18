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
 * Comparator interface
 *
 * @version  $Id: _Comparator_if.java,v 1.7 1997/06/18 06:14:43 hgoto Exp $
 */


public interface _Comparator_if
  extends JP.go.ipa.oz.lang._Root_if
{

  //================================================== OZ methods
  public boolean compare(JP.go.ipa.oz.lang._Root_if arg1,
                         JP.go.ipa.oz.lang._Root_if arg2) throws Exception;

  public int hash(JP.go.ipa.oz.lang._Root_if arg1) throws Exception;

  public _Comparator_if duplicate() throws Exception;

}

// EoF

