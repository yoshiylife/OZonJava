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
 * List interface
 *
 * @version  $Id: _List_if.java,v 1.9 1997/06/24 07:11:15 nito Exp $
 * @see      _Component_if
 * @see      _ItemSelectable_if
 */


public interface _List_if
  extends JP.go.ipa.oz.lib.standard._Component_if,
          JP.go.ipa.oz.lib.standard._ItemSelectable_if
{


  //================================================== OZ public methods
  public void add(_String_if item) throws Exception;
  public void add(_String_if item, int index) throws Exception; //synchronized
  public void addActionListener(_ActionListener_if l) throws Exception; //synchronized
  public void addItem(_String_if item) throws Exception;
  public void addItem(_String_if item, int index) throws Exception; //synchronized
  public void addItemListener(_ItemListener_if l) throws Exception; //synchronized
  public void addNotify() throws Exception;
  //public boolean allowsMultipleSelections() throws Exception; //DEPRECATED
  //public void clear(){} //synchronized //DEPRECATED
  //public int countItems() throws Exception; //DEPRECATED
  public void delItem(int position) throws Exception; //synchronized
  //public void delItems(int start, int end) throws Exception; //synchronized //DEPRECATED
  public void deselect(int index) throws Exception; //synchronized
  public _String_if getItem(int index) throws Exception;
  public int getItemCount() throws Exception;
  public _Collection_if getItems() throws Exception; //synchronized
  public _Dimension_if getMinimumSize() throws Exception;
  public _Dimension_if getMinimumSize(int rows) throws Exception;
  public _Dimension_if getPreferredSize(int rows) throws Exception;
  //public _Dimension_if getPreferredSize() throws Exception; //DEPRECATED
  public int getRows() throws Exception;
  public int getSelectedIndex() throws Exception; //synchronized
  public _Collection_if getSelectedIndexes() throws Exception; //synchronized Integer Set
  public _String_if getSelectedItem() throws Exception; //synchronized
  public _Collection_if getSelectedItems() throws Exception; //synchronized
  public _Collection_if getSelectedObjects() throws Exception;
  public int getVisibleIndex() throws Exception;
  public boolean isIndexSelected(int index) throws Exception;
  public boolean isMultipleMode() throws Exception;
  //public boolean isSelected(int index) throws Exception; //DEPRECATED
  public void makeVisible(int index) throws Exception; //synchronized
  //public _Dimension_if minimumSize(int rows) throws Exception; //DEPRECATED
  //public _Dimension_if preferredSize(int rows) throws Exception; //DEPRECATED
  //public _Dimension_if preferredSize() throws Exception; //DEPRECATED
  public void remove(_String_if item) throws Exception; //synchronized
    //
  public void remove(int position) throws Exception; //synchronized
  public void removeActionListener(_ActionListener_if l) throws Exception; //synchronized
  public void removeAll() throws Exception; //synchronized
  public void removeItemListener(_ItemListener_if l) throws Exception; //synchronized
  public void removeNotify() throws Exception;
  public void replaceItem(_String_if newValue, int index) throws Exception; //synchronized
  public void select(int index) throws Exception; //synchronized
  public void setMultipleMode(boolean b) throws Exception; //synchronized
  //public void setMultipleSelections(boolean b) throws Exception; //synchronized //DEPRECATED
  public _String_if asString() throws Exception;

}

// EoF

