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
 * EventListener interface
 *
 * @version  $Id: _EventListener_if.java,v 1.5 1997/07/17 07:36:44 nito Exp $
 */
public interface _EventListener_if extends JP.go.ipa.oz.lang._Root_if
{
  public void dispatch(_EventObject_if object, int type) throws Exception;
}

// EoF

