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
 * SList interface
 *
 * @version  $Id: _SList_if.java,v 1.7 1997/06/17 09:44:55 hgoto Exp $
 * @see      _Sequence_if
 * @see      _SList_cl
 */


public interface _SList_if
  extends JP.go.ipa.oz.lib.standard._Sequence_if
{

  //================================================== OZ methods
  public _SList_if concatenate(_SList_if list) throws Exception;
  public _SList_if insertAfter(JP.go.ipa.oz.lang._Root_if prev,
			       JP.go.ipa.oz.lang._Root_if element) throws Exception;
  public _SList_if popFront()throws Exception;
  public _SList_if pushBack(JP.go.ipa.oz.lang._Root_if element) throws Exception;
  public _SList_if pushFront(JP.go.ipa.oz.lang._Root_if element) throws Exception;
  public _SList_if removeAfter(JP.go.ipa.oz.lang._Root_if prev) throws Exception;

}

// EoF

