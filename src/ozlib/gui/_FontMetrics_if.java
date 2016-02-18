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
 * FontMetrics interface
 *
 * @version  $Id: _FontMetrics_if.java,v 1.9 1997/06/24 07:11:14 nito Exp $
 * @see      _Font_if
 * @see      _FontMetrics_cl
 */


public interface _FontMetrics_if
  extends JP.go.ipa.oz.lang._Root_if
{


  //================================================== OZ methods
  public int bytesWidth(_ByteArray_if data, int off, int len) throws Exception;
  public int charWidth(char ch) throws Exception;
  public int charWidth(int ch) throws Exception;
  public int charsWidth(_CharArray_if data, int off, int len) throws Exception;
  public int getAscent() throws Exception;
  public int getDescent() throws Exception;
  public _Font_if getFont() throws Exception;
  public int getHeight() throws Exception;
  public int getLeading() throws Exception;
  public int getMaxAdvance() throws Exception;
  public int getMaxAscent() throws Exception;
  //public int getMaxDecent() throws Exception; //DEPRECATED
  public int getMaxDescent() throws Exception;
  public _Sequence_if getWidths() throws Exception;
  public int stringWidth(_String_if str) throws Exception;
  public _String_if asString() throws Exception;

}

// EoF

