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
 * Collection interface
 *
 * @version  $Id: _Collection_if.java,v 1.6 1997/06/17 09:44:54 hgoto Exp $
 * @see      _Plural_if
 */


public interface _Collection_if
  extends JP.go.ipa.oz.lib.standard._Plural_if
{

  //================================================== OZ methods
  public abstract boolean contains(JP.go.ipa.oz.lang._Root_if e) throws Exception;
  public abstract _Set_if difference(_Collection_if cl) throws Exception;
  public abstract _Set_if intersect(_Collection_if cl) throws Exception;
  public abstract _Collection_if remove(JP.go.ipa.oz.lang._Root_if e) throws Exception;
  public abstract _Collection_if removeAll(JP.go.ipa.oz.lang._Root_if e) throws Exception;
  public abstract _Set_if union(_Collection_if cl) throws Exception;

}

// EoF
