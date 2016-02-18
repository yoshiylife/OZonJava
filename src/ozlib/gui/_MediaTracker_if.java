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
 * MediaTracker interface
 *
 * @version  $Id: _MediaTracker_if.java,v 1.7 1997/06/24 07:11:16 nito Exp $
 * @see      _MediaTracker_cl
 */


public interface _MediaTracker_if
  extends    JP.go.ipa.oz.lang._Root_if
{

  public int getLOADING() throws Exception;
  public int getABORTED() throws Exception;
  public int getERRORED() throws Exception;
  public int getCOMPLETE() throws Exception;


  //================================================== OZ methods
  public void addImage(_Image_if image, int id) throws Exception;
  public void addImage(_Image_if image, int id, int w, int h) throws Exception; // synchronized
  public boolean checkAll() throws Exception;
  public boolean checkAll(boolean load) throws Exception;
  public boolean checkID(int id) throws Exception;
  public boolean checkID(int id, boolean load) throws Exception;
  //public _Array_if getErrorsAny() throws Exception; // synchronized // unsupport
  //public _Array_if getErrorsID(int id) throws Exception; // synchronized // unsupport
  public boolean isErrorAny() throws Exception; // synchronized
  public boolean isErrorID(int id) throws Exception; // synchronized
  public void removeImage(_Image_if image) throws Exception; // synchronized
  public void removeImage(_Image_if image, int id) throws Exception; // synchronized
  public void removeImage(_Image_if image, int id, int width, int height) throws Exception; // synchronized
  public int statusAll(boolean load) throws Exception;
  public int statusID(int id, boolean load) throws Exception;
  public void waitForAll() throws Exception;
  public boolean waitForAll(long ms) throws Exception; // synchronized
  public void waitForID(int id) throws Exception;
  public boolean waitForID(int id, long ms) throws Exception; // synchronized
  public _String_if asString() throws Exception;
}

// EoF

