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
 * Graphics interface
 *
 * @version  $Id: _Graphics_if.java,v 1.12 1997/08/27 06:45:41 nito Exp $
 */


public interface _Graphics_if
  extends JP.go.ipa.oz.lang._Root_if
{
  //================================================== OZ methods
  public void clearRect(int x, int y, int width, int height) throws Exception;
  public void clipRect(int x, int y, int width, int height) throws Exception;
  public void copyArea(int x, int y, int width, int height, int dx, int dy) throws Exception;
  public _Graphics_if create() throws Exception;
  //*public _Graphics_if create(int x, int y, int width, int height) throws Exception;
  public void dispose() throws Exception;
  public void draw3DRect(int x, int y, int width, int height, boolean raised) throws Exception;
  public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) throws Exception;
  public void drawBytes(_ByteArray_if data, int offset, int length, int x, int y) throws Exception;
  public void drawChars(_CharArray_if data, int offset, int length, int x, int y) throws Exception;
  public void drawLine(int x1, int y1, int x2, int y2) throws Exception;
  public void drawOval(int x, int y, int width, int height) throws Exception;
  public void drawPolygon(_Sequence_if points) throws Exception;
  public void drawPolygon(_Polygon_if p) throws Exception;
  public void drawPolyline(_Sequence_if points) throws Exception;
  public void drawRect(int x, int y, int width, int height) throws Exception;
  public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) throws Exception;
  public void drawString(_String_if str, int x, int y) throws Exception;
  public void fill3DRect(int x, int y, int width, int height, boolean raised) throws Exception;
  public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) throws Exception;
  public void fillOval(int x, int y, int width, int height) throws Exception;
  public void fillPolygon(_Sequence_if points) throws Exception;
  public void fillPolygon(_Polygon_if p) throws Exception;
  public void fillRect(int x, int y, int width, int height) throws Exception;
  public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) throws Exception;
  public void finalize() throws Exception;
  public _Rectangle_if getClipBounds() throws Exception;
  public _Color_if getColor() throws Exception;
  public _Font_if getFont() throws Exception;
  public _FontMetrics_if getFontMetrics() throws Exception;
  public _FontMetrics_if getFontMetrics(_Font_if f) throws Exception;
  public void setClip(int x, int y, int width, int height) throws Exception;
  public void setColor(_Color_if c) throws Exception;
  public void setFont(_Font_if font) throws Exception;
  public void setPaintMode() throws Exception;
  public void setXORMode(_Color_if c1) throws Exception;
  public void translate(int x, int y) throws Exception;
}

// EoF
