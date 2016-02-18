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
 * List implementation
 *
 * @version  $Id: _List_cl.java,v 1.15 1997/07/04 02:27:08 nito Exp $
 * @see      _List_if
 * @see      _Component_cl
 * @see      _ItemSelectable_if
 */


public class _List_cl
  extends    JP.go.ipa.oz.lib.standard._Component_cl
  implements JP.go.ipa.oz.lib.standard._List_if
{

  static final java.lang.String  CN = "List";


  //================================================== constructors

  _List_cl(_OzList l)
    throws Exception
  {
    _body = l;
  }

  public _List_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  //------------------------------------------------------------------
  public java.lang.Object _new_newList()
    throws Exception
  {
    _OzList  l = new _OzList();
    l.bind(this);
    _body = l;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newList(int rows)
    throws Exception
  {
    _OzList  l = new _OzList(rows);
    l.bind(this);
    _body = l;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newList(int rows, boolean multipleMode)
    throws Exception
  {
    _OzList  l = new _OzList(rows, multipleMode);
    l.bind(this);
    _body = l;
    return this;
  }


  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public void add(_String_if item)
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  arg_item = ((_String_cl)item)._body;
    ((java.awt.List)_body).add(arg_item);
  }

  //------------------------------------------------------------------
  public void add(_String_if item, int index) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  arg_item = ((_String_cl)item)._body;
    ((java.awt.List)_body).add(arg_item, index);
  }

  //------------------------------------------------------------------
  public void addActionListener(_ActionListener_if l) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.event.ActionListener  arg_l = (java.awt.event.ActionListener)(((_ActionListener_cl)l)._body);
    ((java.awt.List)_body).addActionListener(arg_l);
  }

  //------------------------------------------------------------------
  public void addItem(_String_if item)
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  arg_item = ((_String_cl)item)._body;
    ((java.awt.List)_body).addItem(arg_item);
  }

  //------------------------------------------------------------------
  public void addItem(_String_if item, int index) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  arg_item = ((_String_cl)item)._body;
    ((java.awt.List)_body).addItem(arg_item, index);
  }

  //------------------------------------------------------------------
  public void addItemListener(_ItemListener_if l) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.event.ItemListener  arg_l = (java.awt.event.ItemListener)(((_ItemListener_cl)l)._body);
    ((java.awt.List)_body).addItemListener(arg_l);
  }

  //------------------------------------------------------------------
  public void addNotify()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.List)_body).addNotify();
  }

  //public boolean allowsMultipleSelections() //DEPRECATED

  //------------------------------------------------------------------
  public synchronized _String_if asString()
    throws Exception
  {
    checkSecureInvocation();
    int  count = getItemCount();
    java.lang.String  rv_tmp = CN.concat("[count=")
      .concat(java.lang.Integer.toString(count));
    for (int i = 0; i < count; i++) {
      rv_tmp = rv_tmp.concat(((java.awt.List)_body).getItem(i));
    }
    rv_tmp.concat("]");
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //public void clear(){} //DEPRECATED //synchronized
  //public int countItems() //DEPRECATED

  //------------------------------------------------------------------
  public void delItem(int position) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.List)_body).delItem(position);
  }

  //public void delItems(int start, int end) //synchronized //DEPRECATED

  //------------------------------------------------------------------
  public void deselect(int index) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.List)_body).deselect(index);
  }

  //------------------------------------------------------------------
  public _String_if getItem(int index)
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = ((java.awt.List)_body).getItem(index);
    if (rv_tmp == null) return null;
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public int getItemCount()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.List)_body).getItemCount();
  }

  //------------------------------------------------------------------
  public _Collection_if getItems() //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String[]  rv_tmp = ((java.awt.List)_body).getItems();
    _Array_if  rv = null;
    if (rv_tmp != null) {
      rv = (_Array_if)(new _Array_cl()._new_create(rv_tmp.length, new _StringComparator_cl()));
      for (int i = 0; i < rv_tmp.length; i++) {
	rv.putAt(i, new _String_cl(rv_tmp[i]));
      }
    }
    return rv;
  }

  //------------------------------------------------------------------
  public _Dimension_if getMinimumSize()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Dimension  rv_tmp = ((java.awt.List)_body).getMinimumSize();
    if (rv_tmp == null) return null;
    _Dimension_if  rv = new _Dimension_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _Dimension_if getMinimumSize(int rows)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Dimension  rv_tmp = ((java.awt.List)_body).getMinimumSize(rows);
    if (rv_tmp == null) return null;
    _Dimension_if  rv = new _Dimension_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _Dimension_if getPreferredSize(int rows)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Dimension  rv_tmp = ((java.awt.List)_body).getPreferredSize(rows);
    if (rv_tmp == null) return null;
    _Dimension_if  rv = new _Dimension_cl(rv_tmp);
    return rv;
  }

  //public _Dimension_if getPreferredSize() //DEPRECATED

  //------------------------------------------------------------------
  public int getRows()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.List)_body).getRows();
  }

  //------------------------------------------------------------------
  public int getSelectedIndex() //synchronized
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.List)_body).getSelectedIndex();
  }

  //------------------------------------------------------------------
  public _Collection_if getSelectedIndexes() //synchronized
    throws Exception
  {
    checkSecureInvocation();
    int[] tmp_rv = ((java.awt.List)_body).getSelectedIndexes();
    _Array_if rv = (_Array_if)(new _Array_cl()._new_create(tmp_rv.length, new _IntegerComparator_cl()));
    for (int i = 0; i < tmp_rv.length; i++) {
      rv.putAt(i, (_Integer_if)(new _Integer_cl()._new_breed(tmp_rv[i])));
    }
    return rv;
  }

  //------------------------------------------------------------------
  public _String_if getSelectedItem() //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = ((java.awt.List)_body).getSelectedItem();
    if (rv_tmp == null) return null;
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _Collection_if getSelectedItems() //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String[]  rv_tmp = ((java.awt.List)_body).getSelectedItems();
    _Array_if rv = null;
    if (rv_tmp != null) {
      rv = (_Array_if)(new _Array_cl()._new_create(rv_tmp.length, new _StringComparator_cl()));
      for (int i = 0; i < rv_tmp.length; i++) {
	rv.putAt(i, new _String_cl(rv_tmp[i]));
      }
    }
    return rv;
  }

  //------------------------------------------------------------------
  public _Collection_if getSelectedObjects()
    throws Exception
  {
    checkSecureInvocation();
    java.lang.Object[]  rv_tmp = ((java.awt.List)_body).getSelectedObjects();
    _Array_if rv = null;
    if (rv_tmp != null) {
      rv = (_Array_if)(new _Array_cl()._new_create(rv_tmp.length, new _RootComparator_cl()));
      for (int i = 0; i < rv_tmp.length; i++) {
	rv.putAt(i, new _String_cl((java.lang.String)(rv_tmp[i])));
      }
    }
    return rv;

  }

  //------------------------------------------------------------------
  public int getVisibleIndex()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.List)_body).getVisibleIndex();
  }

  //------------------------------------------------------------------
  public boolean isIndexSelected(int index)
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.List)_body).isIndexSelected(index);
  }

  //------------------------------------------------------------------
  public boolean isMultipleMode()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.List)_body).isMultipleMode();
  }

  //public boolean isSelected(int index) //DEPRECATED

  //------------------------------------------------------------------
  public void makeVisible(int index) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.List)_body).makeVisible(index);
  }

  //public _Dimension_if minimumSize(int rows) //DEPRECATED
  //public _Dimension_if preferredSize(int rows) //DEPRECATED
  //public _Dimension_if preferredSize() //DEPRECATED

  //------------------------------------------------------------------
  public void remove(_String_if item) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  arg_item = ((_String_cl)item)._body;
    ((java.awt.List)_body).remove(arg_item);
  }

  //------------------------------------------------------------------
  public void remove(int position) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.List)_body).remove(position);
  }

  //------------------------------------------------------------------
  public void removeActionListener(_ActionListener_if l) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.event.ActionListener  arg_l = ((_ActionListener_cl)l)._body;
    ((java.awt.List)_body).removeActionListener(arg_l);
  }

  //------------------------------------------------------------------
  public void removeAll() //synchronized
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.List)_body).removeAll();
  }

  //------------------------------------------------------------------
  public void removeItemListener(_ItemListener_if l) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.event.ItemListener  arg_l = ((_ItemListener_cl)l)._body;
    ((java.awt.List)_body).removeItemListener(arg_l);
  }

  //------------------------------------------------------------------
  public void removeNotify()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.List)_body).removeNotify();
  }

  //------------------------------------------------------------------
  public void replaceItem(_String_if newValue, int index) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  arg_newValue = ((_String_cl)newValue)._body;
    ((java.awt.List)_body).replaceItem(arg_newValue, index);
  }

  //------------------------------------------------------------------
  public void select(int index) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.List)_body).select(index);
  }

  //------------------------------------------------------------------
  public void setMultipleMode(boolean b) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.List)_body).setMultipleMode(b);
  }

  //public void setMultipleSelections(boolean b){} //synchronized //DEPRECATED


  //================================================== protected methods
  //protected _String_if paramString()
  //protected void processActionEvent(_ActionEvent_if e)
  //protected void processEvent(_AWTEvent_if e)
  //protected void processItemEvent(ItemEvent e)


  //================================================== support methods

//  public java.lang.String toString()
//  {
//    return ((_String_cl)asString())._body;
//  }

}

// EoF

