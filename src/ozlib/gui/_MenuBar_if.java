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
 * MenuBar interface
 *
 * @version  $Id: _MenuBar_if.java,v 1.8 1997/06/24 07:11:16 nito Exp $
 * @see      _MenuContainer_if
 * @see      _MenuComponent_if
 */


public interface _MenuBar_if
  extends JP.go.ipa.oz.lib.standard._MenuComponent_if,
          JP.go.ipa.oz.lib.standard._MenuContainer_if
{


  //================================================== OZ methods
  public _Menu_if add(_Menu_if m) throws Exception;  //synchronized
  public void addNotify() throws Exception;
  //public int countMenus() throws Exception; //DEPRECATED
  public void deleteShortcut(_MenuShortcut_if s) throws Exception;
  public _Menu_if getHelpMenu() throws Exception;
  public _Menu_if getMenu(int i) throws Exception;
  public int getMenuCount() throws Exception;
  public _MenuItem_if getShortcutMenuItem(_MenuShortcut_if s) throws Exception;
  public void remove(int index) throws Exception;  //synchronized
  public void remove(_MenuComponent_if m) throws Exception;  //synchronized
  public void removeNotify() throws Exception;
  public void setHelpMenu(_Menu_if m) throws Exception;  //synchronized
  public _Iterator_if shortcuts() throws Exception;  //synchronized
  public _String_if asString() throws Exception;

}

// EoF

