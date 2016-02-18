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


/**
 * Button interface
 *
 * @version  $Id: _Button_if.java,v 1.7 1997/06/24 07:11:13 nito Exp $
 * @see      _Component_if
 * @see      _Button_cl
 */


package JP.go.ipa.oz.lib.standard;


public interface _Button_if
  extends JP.go.ipa.oz.lib.standard._Component_if
{


  //==================================================  OZ methods
  public void addActionListener(_ActionListener_if l) throws Exception; //synchronized
  public void addNotify() throws Exception;
  public _String_if getActionCommand() throws Exception;
  public _String_if getLabel() throws Exception;
  public void removeActionListener(_ActionListener_if l) throws Exception; //synchronized
  public void setActionCommand(_String_if command) throws Exception;
  public void setLabel(_String_if label) throws Exception;  //synchronized
  public _String_if asString() throws Exception;

}

// EoF

