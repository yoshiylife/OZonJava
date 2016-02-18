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
 * Checkbox interface
 * --- A Checkbox object is a graphical user interface element
 * that has a boolean state.
 *
 * @version  $Id: _Checkbox_if.java,v 1.7 1997/06/13 08:49:47 nito Exp $
 * @see      _Component_if
 * @see      _ItemSelectable_if
 */


public interface _Checkbox_if
  extends JP.go.ipa.oz.lib.standard._Component_if,
          JP.go.ipa.oz.lib.standard._ItemSelectable_if
{


  //================================================== OZ methods
  public void addItemListener(_ItemListener_if l) throws Exception;
  public void addNotify() throws Exception;
  public _CheckboxGroup_if getCheckboxGroup() throws Exception;
  public _String_if getLabel() throws Exception;
  public _Collection_if getSelectedObjects() throws Exception;
  public boolean getState() throws Exception;
  public void removeItemListener(_ItemListener_if l) throws Exception;
  public void setCheckboxGroup(_CheckboxGroup_if g) throws Exception;
  public void setLabel(_String_if label) throws Exception; //synchronized
  public void setState(boolean state) throws Exception;

}

// EoF

