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
 * Array interface
 *
 * @version  $Id: _Array_if.java,v 1.7 1997/06/17 09:44:54 hgoto Exp $
 * @see      _Sequence_if
 * @see      _Array_cl
 */


public interface _Array_if
  extends JP.go.ipa.oz.lib.standard._Sequence_if
{

  //================================================== OZ methods
  public JP.go.ipa.oz.lang._Root_if at(int index) throws Exception;
  public _Array_if putAt(int index, JP.go.ipa.oz.lang._Root_if element) throws Exception;
  public _Array_if removeAt(int index) throws Exception;
  public _Array_if resize(int size) throws Exception;

}

// EoF

