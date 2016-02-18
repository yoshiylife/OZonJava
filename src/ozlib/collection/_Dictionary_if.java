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
 * Dictionary interface
 *
 * @version  $Id: _Dictionary_if.java,v 1.7 1997/06/17 09:44:55 hgoto Exp $
 * @see      _Plural_if
 * @see      _Dictionary_cl
 */


public interface _Dictionary_if
  extends JP.go.ipa.oz.lib.standard._Plural_if
{

  //================================================== OZ methods
  public _Iterator_if assocIterator() throws Exception;
  public boolean contains(JP.go.ipa.oz.lang._Root_if value) throws Exception;
  public boolean containsKey(JP.go.ipa.oz.lang._Root_if key) throws Exception;
  public _Dictionary_if copy(_Dictionary_if dic) throws Exception;
  public JP.go.ipa.oz.lang._Root_if get(JP.go.ipa.oz.lang._Root_if key) throws Exception;
  public _Comparator_if getComparatorForKeys() throws Exception;
  public _Comparator_if getComparatorForValues() throws Exception;
  public _Iterator_if keyIterator() throws Exception;
  public _Set_if keys() throws Exception;
  public _Dictionary_if put(_Association_if assoc) throws Exception;
  public _Dictionary_if put(JP.go.ipa.oz.lang._Root_if key,
                            JP.go.ipa.oz.lang._Root_if value) throws Exception;
  public _Dictionary_if remove(JP.go.ipa.oz.lang._Root_if key) throws Exception;
  public _Set_if values() throws Exception;
}

// EoF

