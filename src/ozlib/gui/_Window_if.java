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
 * Window interface
 *
 * @version  $Id: _Window_if.java,v 1.7 1997/06/24 07:11:18 nito Exp $
 * @see      _Container_if
 */


public interface _Window_if
  extends JP.go.ipa.oz.lib.standard._Container_if
{


  //================================================== OZ public methods
  public void addNotify() throws Exception;
  public void addWindowListener(_WindowListener_if l) throws Exception; //synchronized
  public void dispose() throws Exception;
  public _Component_if getFocusOwner() throws Exception;
  public _Locale_if getLocale() throws Exception;
  public _Toolkit_if getToolkit() throws Exception;
  public _String_if getWarningString() throws Exception; //final
  public boolean isShowing() throws Exception;
  public void pack() throws Exception;
  //public boolean postEvent(_Event_if e) throws Exception;  //DEPRECATED ... dispatchEvent
  public void removeWindowListener(_WindowListener_if l) throws Exception;  //synchronized
  public void show() throws Exception;
  public void toBack() throws Exception;
  public void toFront() throws Exception;
  public _String_if asString() throws Exception;

}

// EoF

