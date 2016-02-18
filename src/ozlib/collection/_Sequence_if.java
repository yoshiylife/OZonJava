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

// OZ Collection Library


package JP.go.ipa.oz.lib.standard;


/**
 * Sequence interface
 *
 * @version  $Id: _Sequence_if.java,v 1.6 1997/06/17 09:44:55 hgoto Exp $
 * @see      _Collection_if
 */


public interface _Sequence_if
  extends JP.go.ipa.oz.lib.standard._Collection_if
{

  //================================================== OZ methods
  public abstract JP.go.ipa.oz.lang._Root_if first() throws Exception;
  public abstract int indexOf(JP.go.ipa.oz.lang._Root_if e) throws Exception;
  public abstract int indexOf(JP.go.ipa.oz.lang._Root_if e, int start) throws Exception;
  public abstract JP.go.ipa.oz.lang._Root_if last() throws Exception;
  public abstract int rIndexOf(JP.go.ipa.oz.lang._Root_if e) throws Exception;
  public abstract int rIndexOf(JP.go.ipa.oz.lang._Root_if e, int start) throws Exception;
  public abstract _Sequence_if prefix(int end) throws Exception;
  public abstract _Sequence_if infix(int start, int end) throws Exception;
  public abstract _Sequence_if postfix(int start) throws Exception;

}

// EoF

