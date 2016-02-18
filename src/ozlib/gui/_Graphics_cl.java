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
 * Graphics implementation
 *
 * @version  $Id: _Graphics_cl.java,v 1.12 1997/08/27 06:45:41 nito Exp $
 * @see      _Graphics_if
 */


package JP.go.ipa.oz.lib.standard;


public final class _Graphics_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._Graphics_if
{

  final static java.lang.String  CN = "Graphics";
  java.awt.Graphics  _body;


  //================================================== constructors

  protected _Graphics_cl()
    throws Exception
  {
  }

  protected _Graphics_cl(java.awt.Graphics g)
    throws Exception
  {
    _body = g;
  }

  //======================================== OZ constructor implementation

  protected java.lang.Object _new_newGraphics()
    throws Exception
  {
    return this;
  }


  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public _String_if asString() //@
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = _body.toString();
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  public void clearRect(int x, int y, int width, int height) throws Exception
  {
    checkSecureInvocation();
    _body.clearRect(x, y, width, height);
  }

  public void clipRect(int x, int y, int width, int height) throws Exception
  {
    checkSecureInvocation();
    _body.clipRect(x, y, width, height);
  }

  public void copyArea(int x, int y, int width, int height, int dx, int dy) throws Exception
  {
    checkSecureInvocation();
    _body.copyArea(x, y, width, height, dx, dy);
  }

  public _Graphics_if create() throws Exception
  {
    checkSecureInvocation();
    java.awt.Graphics g = null;
    if ((g = _body.create()) == null) return null;
    return new _Graphics_cl(g);
  }


  public _Graphics_if create(int x, int y, int width, int height) throws Exception
  {
    checkSecureInvocation();
    java.awt.Graphics g = null;
    if ((g = _body.create(x, y, width, height)) == null) return null;
    return new _Graphics_cl(g);
  }

  public void dispose()
  {
    checkSecureInvocation();
    _body.dispose();
  }


  //------------------------------------------------------------------
  public void draw3DRect(int x, int y, int width, int height, boolean raised) throws Exception
  {
    checkSecureInvocation();
    _body.draw3DRect(x, y, width, height, raised);
  }

  public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) throws Exception
  {
    checkSecureInvocation();
    _body.drawArc(x, y, width, height, startAngle, arcAngle);
  }


  //------------------------------------------------------------------
  public void drawBytes(_ByteArray_if data, int offset, int length, int x, int y) throws Exception
  {
    checkSecureInvocation();
    _body.drawBytes(((_ByteArray_cl)data)._body, offset, length, x, y);
  }

  public void drawChars(_CharArray_if data, int offset, int length, int x, int y) throws Exception
  {
    checkSecureInvocation();
    _body.drawChars(((_CharArray_cl)data)._body, offset, length, x, y);
  }

  public void drawLine(int x1, int y1, int x2, int y2) throws Exception
  {
    checkSecureInvocation();
    _body.drawLine(x1, y1, x2, y2);
  }

  public void drawOval(int x, int y, int width, int height) throws Exception
  {
    checkSecureInvocation();
    _body.drawOval(x, y, width, height);
  }

  public void drawPolygon(_Sequence_if points) throws Exception
  {
    checkSecureInvocation();
    if (!(points.isEmpty())) {
      _Point_if p = null;
      int[] xpoints = new int[points.size()];
      int[] ypoints = new int[points.size()];
      int npoints = points.size();
      _Iterator_if it = points.iterator();
      for (int i = 0; (p = (_Point_if)it.nextElement()) != null; i++) {
        xpoints[i] = p.getX();
        ypoints[i] = p.getY();
      }
      _body.drawPolygon(xpoints, ypoints, npoints);
    }
  }


  //------------------------------------------------------------------
  public void drawPolygon(_Polygon_if p) throws Exception
  {
    checkSecureInvocation();
    java.awt.Polygon  arg_p = ((_Polygon_cl)p)._body;
    _body.drawPolygon(arg_p);
  }

  public void drawPolyline(_Sequence_if points) throws Exception
  {
    checkSecureInvocation();
    if (!(points.isEmpty())) {
      _Point_if p = null;
      int[] xpoints = new int[points.size()];
      int[] ypoints = new int[points.size()];
      int npoints = points.size();
      _Iterator_if it = points.iterator();
      for (int i = 0; (p = (_Point_if)it.nextElement()) != null; i++) {
        xpoints[i] = p.getX();
        ypoints[i] = p.getY();
      }
      _body.drawPolyline(xpoints, ypoints, npoints);
    }
  }


  //------------------------------------------------------------------
  public void drawRect(int x, int y, int width, int height) throws Exception
  {
    checkSecureInvocation();
    _body.drawRect(x, y, width, height);
  }

  public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) throws Exception
  {
    checkSecureInvocation();
    _body.drawRoundRect(x, y, width, height, arcWidth, arcHeight);
  }

  public void drawString(_String_if str, int x, int y) throws Exception
  {
    checkSecureInvocation();
    _body.drawString(((_String_cl)str)._body, x, y);
  }


  //------------------------------------------------------------------
  public void fill3DRect(int x, int y, int width, int height, boolean raised) throws Exception
  {
    checkSecureInvocation();
    _body.fill3DRect(x, y, width, height, raised);
  }

  public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) throws Exception
  {
    checkSecureInvocation();
    _body.fillArc(x, y, width, height, startAngle, arcAngle);
  }

  public void fillOval(int x, int y, int width, int height) throws Exception
  {
    checkSecureInvocation();
    _body.fillOval(x, y, width, height);
  }

  public void fillPolygon(_Sequence_if points) throws Exception
  {
    checkSecureInvocation();
    if (!(points.isEmpty())) {
      _Point_if p = null;
      int[] xpoints = new int[points.size()];
      int[] ypoints = new int[points.size()];
      int npoints = points.size();
      _Iterator_if it = points.iterator();
      for (int i = 0; (p = (_Point_if)it.nextElement()) != null; i++) {
        xpoints[i] = p.getX();
        ypoints[i] = p.getY();
      }
      _body.fillPolygon(xpoints, ypoints, npoints);
    }
  }


  //------------------------------------------------------------------
  public void fillPolygon(_Polygon_if p) throws Exception
  {
    checkSecureInvocation();
    java.awt.Polygon  arg_p = ((_Polygon_cl)p)._body;
    _body.fillPolygon(arg_p);
  }

  public void fillRect(int x, int y, int width, int height) throws Exception
  {
    checkSecureInvocation();
    _body.fillRect(x, y, width, height);
  }

  public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) throws Exception
  {
    checkSecureInvocation();
    _body.fillRoundRect(x, y, width, height, arcWidth, arcHeight);
  }


  //------------------------------------------------------------------
  public void finalize() throws Exception
  {
    checkSecureInvocation();
    _body.finalize();
  }

  public _Rectangle_if getClipBounds() throws Exception
  {
    checkSecureInvocation();
    java.awt.Rectangle r = null;
    if ((r = _body.getClipBounds()) == null) return null;
    return new _Rectangle_cl(r);
  }

  public _Color_if getColor() throws Exception
  {
    checkSecureInvocation();
    java.awt.Color c = null;
    if ((c = _body.getColor()) == null) return null;
    return new _Color_cl(c);
  }

  public _Font_if getFont() throws Exception
  {
    checkSecureInvocation();
    java.awt.Font f = null;
    if ((f = _body.getFont()) == null) return null;
    return new _Font_cl(f);
  }

  public _FontMetrics_if getFontMetrics() throws Exception
  {
    checkSecureInvocation();
    java.awt.FontMetrics fm = null;
    if ((fm = _body.getFontMetrics()) == null) return null;
    return new _FontMetrics_cl(fm);
  }

  public _FontMetrics_if getFontMetrics(_Font_if f) throws Exception
  {
    checkSecureInvocation();
    java.awt.FontMetrics fm = null;
    if ((fm = _body.getFontMetrics(((_Font_cl)f)._body)) == null) return null;
    return new _FontMetrics_cl(fm);
  }

  public void setClip(int x, int y, int width, int height) throws Exception
  {
    checkSecureInvocation();
    _body.setClip(x, y, width, height);
  }

  public void setColor(_Color_if c) throws Exception
  {
    checkSecureInvocation();
    _body.setColor(((_Color_cl)c)._body);
  }

  public void setFont(_Font_if font) throws Exception
  {
    checkSecureInvocation();
    _body.setFont(((_Font_cl)font)._body);
  }

  public void setPaintMode() throws Exception
  {
    checkSecureInvocation();
    _body.setPaintMode();
  }

  public void setXORMode(_Color_if c1) throws Exception
  {
    checkSecureInvocation();
    _body.setXORMode(((_Color_cl)c1)._body);
  }

  public void translate(int x, int y) throws Exception
  {
    checkSecureInvocation();
    _body.translate(x, y);
  }
}

// EoF
