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
 * ItemSelectable interface
 *
 * @version  $Id: _ItemSelectable_if.java,v 1.6 1997/06/13 08:49:52 nito Exp $
 */


public interface _ItemSelectable_if
  extends JP.go.ipa.oz.lang._Root_if
{

  //================================================== OZ methods
  public abstract void addItemListener(_ItemListener_if l) throws Exception;
  public abstract _Collection_if getSelectedObjects() throws Exception;
  public abstract void removeItemListener(_ItemListener_if l) throws Exception;

}

// EoF

