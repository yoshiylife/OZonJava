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
 * CheckboxMenuItem interface
 *
 * @version  $Id: _CheckboxMenuItem_if.java,v 1.9 1997/06/24 07:11:13 nito Exp $
 * @see      _ItemSelectable_if
 * @see      _MenuItem_if
 */


public interface _CheckboxMenuItem_if
  extends JP.go.ipa.oz.lib.standard._MenuItem_if,
          JP.go.ipa.oz.lib.standard._ItemSelectable_if
{


  //================================================== OZ methods
  public void addNotify() throws Exception;
  public void addItemListener(_ItemListener_if l) throws Exception; //synchronized
  public _Collection_if getSelectedObjects() throws Exception; //synchronized
  public boolean getState() throws Exception;
  public _String_if paramString() throws Exception;
  public void removeItemListener(_ItemListener_if l) throws Exception; //synchronized
  public void setState(boolean b) throws Exception; //synchronized
  public _String_if asString() throws Exception;

}

// EoF

