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
 * Choice interface
 *
 * @version  $Id: _Choice_if.java,v 1.10 1997/06/24 07:11:13 nito Exp $
 * @see      _Component_if
 * @see      _ItemSelectable_if
 */


public interface _Choice_if
  extends JP.go.ipa.oz.lib.standard._Component_if,
          JP.go.ipa.oz.lib.standard._ItemSelectable_if
{


  //================================================== OZ public methods
  public void add(_String_if item) throws Exception; //synchronized
  public void addItem(_String_if item) throws Exception; //synchronized
  public void addItemListener(_ItemListener_if l) throws Exception;
  public void addNotify() throws Exception;
  //public int countItems() throws Exception; //DEPRECATED ... getItemCount()
  public _String_if getItem(int index) throws Exception;
  public int getItemCount() throws Exception;
  public int getSelectedIndex() throws Exception;
  public _String_if getSelectedItem() throws Exception; //synchronized
  public _Collection_if getSelectedObjects() throws Exception; //synchronized
  public void insert(_String_if item, int index) throws Exception; //synchronized
  public void remove(_String_if item) throws Exception; //synchronized
  public void remove(int position) throws Exception; //synchronized
  public void removeAll() throws Exception; //synchronized
  public void removeItemListener(_ItemListener_if l) throws Exception;
  public void select(int position) throws Exception; //synchronized
  public void select(_String_if str) throws Exception; //synchronized
  public _String_if asString() throws Exception;

}

// EoF

