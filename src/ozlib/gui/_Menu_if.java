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
 * Menu interface
 *
 * @version  $Id: _Menu_if.java,v 1.8 1997/06/24 07:11:16 nito Exp $
 * @see      _MenuContainer_if
 * @see      _menuItem_if
 */


public interface _Menu_if
  extends JP.go.ipa.oz.lib.standard._MenuItem_if,
          JP.go.ipa.oz.lib.standard._MenuContainer_if
{


  //================================================== OZ public methods
  public _MenuItem_if add(_MenuItem_if mi) throws Exception;  //synchronized
  public void add(_String_if label) throws Exception;
  public void addNotify() throws Exception;
  public void addSeparator() throws Exception;
  //public int countItems() throws Exception; //DEPRECATED
  public void insert(_MenuItem_if mi, int index) throws Exception; //synchronized
  public void insert(_String_if label, int index) throws Exception;
  public void insertSeparator(int index) throws Exception;
  public boolean isTearOff() throws Exception;
  public _MenuItem_if getItem(int index) throws Exception;
  public int getItemCount() throws Exception;
  public _String_if paramString() throws Exception;
  public void remove(int index) throws Exception;  // synchronized
  public void remove(_MenuComponent_if item) throws Exception;  //synchronized
  public void removeAll() throws Exception;  //synchronized
  public void removeNotify() throws Exception;
  public _String_if asString() throws Exception;

}

// EoF

