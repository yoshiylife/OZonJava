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
 * Cursor interface
 *
 * @version  $Id: _Cursor_if.java,v 1.11 1997/06/24 07:11:14 nito Exp $
 * @see      _Cursor_cl
 */


public interface _Cursor_if
  extends JP.go.ipa.oz.lang._Root_if
{

  public int getDEFAULT_CURSOR() throws Exception;
  public int getCROSSHAIR_CURSOR() throws Exception;
  public int getTEXT_CURSOR() throws Exception;
  public int getWAIT_CURSOR() throws Exception;
  public int getSW_RESIZE_CURSOR() throws Exception;
  public int getSE_RESIZE_CURSOR() throws Exception;
  public int getNW_RESIZE_CURSOR() throws Exception;
  public int getNE_RESIZE_CURSOR() throws Exception;
  public int getN_RESIZE_CURSOR() throws Exception;
  public int getS_RESIZE_CURSOR() throws Exception;
  public int getW_RESIZE_CURSOR() throws Exception;
  public int getE_RESIZE_CURSOR() throws Exception;
  public int getHAND_CURSOR() throws Exception;
  public int getMOVE_CURSOR() throws Exception;

  //================================================== OZ methods
  public _Cursor_if getDefaultCursor() throws Exception; //static
  //@public _Cursor_if getPredefinedCursor(int type) throws Exception; //static
  public boolean isDefault() throws Exception; //@
  public boolean isCrossHair() throws Exception; //@
  public boolean isText() throws Exception; //@
  public boolean isWait() throws Exception; //@
  public boolean isSWResize() throws Exception; //@
  public boolean isSEResize() throws Exception; //@
  public boolean isNWResize() throws Exception; //@
  public boolean isNEResize() throws Exception; //@
  public boolean isNResize() throws Exception; //@
  public boolean isSResize() throws Exception; //@
  public boolean isWResize() throws Exception; //@
  public boolean isEResize() throws Exception; //@
  public boolean isHand() throws Exception; //@
  public boolean isMove() throws Exception; //@
  public _String_if asString() throws Exception;

  //================================================== support methods
//  public java.lang.String toString();

}

// EoF
