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
 * MenuItem interface
 *
 * @version  $Id: _MenuItem_if.java,v 1.6 1997/06/24 07:11:16 nito Exp $
 * @see      _MenuComponent_if
 */
 

public interface _MenuItem_if
  extends JP.go.ipa.oz.lib.standard._MenuComponent_if
{


  //================================================== OZ public methods
  public void addActionListener(_ActionListener_if l) throws Exception;  //synchronized
  public void addNotify() throws Exception;
  public void deleteShortcut() throws Exception;
  //public void disable() throws Exception;  // synchronized  //DEPRECATED
  //public void enable() throws Exception;  // synchronized  //DEPRECATED
  //public void enable(boolean b) throws Exception;  //DEPRECATED
  public boolean isEnabled() throws Exception;
  public _String_if getActionCommand() throws Exception;
  public _String_if getLabel() throws Exception;
  public _MenuShortcut_if getShortcut() throws Exception;
  public _String_if paramString() throws Exception;
  public void removeActionListener(_ActionListener_if l) throws Exception;  //synchronized
  public void setActionCommand(_String_if command) throws Exception;
  public void setEnabled(boolean b) throws Exception;  //synchronized
  public void setLabel(_String_if label) throws Exception;  //synchronized
  public void setShortcut(_MenuShortcut_if s) throws Exception;
  public _String_if asString() throws Exception;

}

// EoF

