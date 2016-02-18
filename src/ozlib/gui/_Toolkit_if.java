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
 * Toolkit interface
 *
 * @version  $Id: _Toolkit_if.java,v 1.3 1997/06/13 08:49:57 nito Exp $
 * @see      _Toolkit_cl
 */


public interface _Toolkit_if
  extends JP.go.ipa.oz.lang._Root_if
{


  //================================================== OZ public methods
  public void beep() throws Exception;
  public int checkImage(_Image_if image, int width, int height,
			_ImageObserver_if observer) throws Exception;
  //*public _Image_if createImage(_ImageProducer_if producer) throws Exception;
  //*public _Image_if createImage(_ByteArray_if imagedata) throws Exception;
  //*public _Image_if createImage(_ByteArray_if imagedata, int imageoffset, int imagelength) throws Exception;
  //*public _ColorModel_if getColorModel() throws Exception;
  //@public _Toolkit_if getDefaultToolkit() throws Exception;  //static //synchronized
  public _Collection_if getFontList() throws Exception;
  //*public _FontMetrics_if getFontMetrics(_Font_if font) throws Exception;
  //*public _Image_if getImage(_String_if filename) throws Exception;
  //*public _Image_if getImage(_URL_if url) throws Exception;
  public int getMenuShortcutKeyMask() throws Exception;
  //*public _PrintJob_if getPrintJob(_Frame_if frame, _String_if jobtitle, _Properties_if props) throws Exception;
  public _String_if getProperty(_String_if key, _String_if defaultValue) throws Exception; //static
  public int getScreenResolution() throws Exception;
  public _Dimension_if getScreenSize() throws Exception;
  //*public _Clipboard_if getSystemClipboard() throws Exception;
  public _EventQueue_if getSystemEventQueue() throws Exception; //final
  public boolean prepareImage(_Image_if image, int width, int height,
			      _ImageObserver_if observer) throws Exception;
  public void sync() throws Exception;

}

// EoF

