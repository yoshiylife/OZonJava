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
 * Plural interface
 *
 * @version  $Id: _Plural_if.java,v 1.6 1997/06/17 09:44:55 hgoto Exp $
 */


public interface _Plural_if
  extends JP.go.ipa.oz.lang._Root_if
{

  //================================================== OZ methods
  public _Plural_if clear() throws Exception;
  public _Plural_if duplicate() throws Exception;
  public boolean isEmpty() throws Exception;
  public _Iterator_if iterator() throws Exception;
  public int size() throws Exception;

}

// EoF

