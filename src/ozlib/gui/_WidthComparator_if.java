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
 * WidthComparator interface
 *
 * @version  $Id: _WidthComparator_if.java,v 1.2 1997/06/24 07:11:17 nito Exp $
 * @see      _Comparator_if
 * @see      _WidthComprator_cl
 */


public interface _WidthComparator_if
  extends JP.go.ipa.oz.lib.standard._Comparator_if
{

  //================================================== OZ methods
  public int hash(JP.go.ipa.oz.lang._Root_if arg1) throws Exception;
  public boolean compare(JP.go.ipa.oz.lang._Root_if arg1, JP.go.ipa.oz.lang._Root_if arg2) throws Exception;
  public _Comparator_if duplicate() throws Exception;

}

// EoF
