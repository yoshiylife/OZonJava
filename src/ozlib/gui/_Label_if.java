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
 * Label interface
 *
 * @version  $Id: _Label_if.java,v 1.8 1997/06/24 07:11:15 nito Exp $
 * @see      _Component_if
 */


public interface _Label_if
  extends JP.go.ipa.oz.lib.standard._Component_if
{


  //================================================== OZ methods
  public void addNotify() throws Exception;
  public void alignToCenter() throws Exception; //@
  public void alignToLeft() throws Exception; //@
  public void alignToRight() throws Exception; //@
  //@public int getAlignment() throws Exception;
  public boolean isAlignedToLeft() throws Exception; //@
  public boolean isAlignedToCenter() throws Exception; //@
  public boolean isAlignedToRight() throws Exception; //@
  public _String_if getText() throws Exception;
  //@public void setAlignment(int alignment) throws Exception; //synchronized
  public void setText(_String_if text) throws Exception; //synchronized
  public _String_if asString() throws Exception;

  //================================================== support methods
//  public java.lang.String toString(); //@

}

// EoF

