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
 * Dialog interface
 *
 * @version  $Id: _Dialog_if.java,v 1.5 1997/06/24 07:11:14 nito Exp $
 * @see      _Window_if
 */


public interface _Dialog_if
  extends JP.go.ipa.oz.lib.standard._Window_if
{


  //================================================== OZ methods
  public void addNotify() throws Exception;
  public _String_if getTitle() throws Exception;
  public boolean isModal() throws Exception;
  public boolean isResizable() throws Exception;
  public void setModal(boolean b) throws Exception;
  public void setResizable(boolean resizable) throws Exception; //synchronized
  public void setTitle(_String_if title) throws Exception; //synchronized
  public void show() throws Exception;
  public _String_if asString() throws Exception;

}

// EoF

