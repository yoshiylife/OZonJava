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
 * Iterator interface
 *
 * @version  $Id: _Iterator_if.java,v 1.6 1997/06/17 09:44:55 hgoto Exp $
 * @see      _Iterator_cl
 */


public interface _Iterator_if
  extends JP.go.ipa.oz.lang._Root_if
{

  //================================================== OZ methods
  public boolean atEnd() throws Exception;
  public boolean hasMoreElements() throws Exception;
  public JP.go.ipa.oz.lang._Root_if nextElement() throws Exception;
  //public JP.go.ipa.oz.lang._Root_if nextElement(int n) throws Exception;

}

// EoF

