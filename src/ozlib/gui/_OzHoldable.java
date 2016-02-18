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

// OZ Class Library (AWT)


package JP.go.ipa.oz.lib.standard;


/**
 * _OzHolderble
 *
 * @version  $Id: _OzHoldable.java,v 1.4 1997/06/18 12:58:13 nito Exp $
 */

interface _OzHoldable
{
  JP.go.ipa.oz.lang._Root_if oz() throws Exception;
  java.lang.Object java() throws Exception;
  void bind(JP.go.ipa.oz.lang._Root_if ozobj) throws Exception;
}

// EoF

