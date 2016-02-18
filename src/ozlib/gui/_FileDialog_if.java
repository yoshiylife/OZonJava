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
 * FileDialog interface
 *
 * @version  $Id: _FileDialog_if.java,v 1.6 1997/06/24 07:11:14 nito Exp $
 * @see      _Dialog_if
 */


public interface _FileDialog_if
  extends JP.go.ipa.oz.lib.standard._Dialog_if
{


  public int getLOAD() throws Exception;
  public int getSAVE() throws Exception;
  //================================================== OZ methods
  public void addNotify() throws Exception;
  public _String_if getDirectory() throws Exception;
  public _String_if getFile() throws Exception;
  //*public _FilenameFilter_if getFilenameFilter() throws Exception;
  public int getMode() throws Exception;
  public void setDirectory(_String_if dir) throws Exception; //synchronized
  public void setFile(_String_if file) throws Exception; //synchronized
  //*public void setFilenameFilter(_FilenameFilter_if filter) throws Exception; //synchronized
  public void setMode(int mode) throws Exception;
  public _String_if asString() throws Exception;

}

// EoF

