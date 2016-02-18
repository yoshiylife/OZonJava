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
 * Rectangle implementation
 *
 * @version  $Id: _Rectangle_cl.java,v 1.11 1997/07/04 02:27:09 nito Exp $
 * @see      _Rectangle_if
 */


package JP.go.ipa.oz.lib.standard;


public class _Rectangle_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._Rectangle_if
{

  static final java.lang.String  CN = "Rectangle";
  java.awt.Rectangle  _body;


  //================================================== constructors

  _Rectangle_cl(java.awt.Rectangle r)
    throws Exception
  {
    _body = r;
  }

  public _Rectangle_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  /**------------------------------------------------------------------
   */
  public java.lang.Object _new_newRectangle()
    throws Exception
  {
    _body = new java.awt.Rectangle();
    return this;
  }

  /**------------------------------------------------------------------
   */
  public java.lang.Object _new_newRectangle(_Rectangle_if r)
    throws Exception
  {
    java.awt.Rectangle  arg_r = ((_Rectangle_cl)r)._body;
    _body = new java.awt.Rectangle(arg_r);
    return this;
  }

  /**------------------------------------------------------------------
   */
  public java.lang.Object _new_newRectangle(int x, int y, int width, int height)
    throws Exception
  {
    _body = new java.awt.Rectangle(x, y, width, height);
    return this;
  }

  /**------------------------------------------------------------------
   */
  public java.lang.Object _new_newRectangle(int width, int height)
    throws Exception
  {
    _body = new java.awt.Rectangle(width, height);
    return this;
  }
    
  /**------------------------------------------------------------------
   */
  public java.lang.Object _new_newRectangle(_Point_if p, _Dimension_if d)
    throws Exception
  {
    java.awt.Point  p_tmp = ((_Point_cl)p)._body;
    java.awt.Dimension  d_tmp = ((_Dimension_cl)d)._body;
    _body = new java.awt.Rectangle(p_tmp, d_tmp);
    return this;
  }

  /**------------------------------------------------------------------
   */
  public java.lang.Object _new_newRectangle(_Point_if p)
    throws Exception
  {
    _body = new java.awt.Rectangle(((_Point_cl)p)._body);
    return this;
  }

  /**------------------------------------------------------------------
   */
  public java.lang.Object _new_newRectangle(_Dimension_if d)
    throws Exception
  {
    _body = new java.awt.Rectangle(((_Point_cl)d)._body);
    return this;
  }


  //======================================== OZ method implementation
    
  /**------------------------------------------------------------------
   */
  public void add(int newx, int newy)
    throws Exception
  {
    checkSecureInvocation();
    _body.add(newx, newy);
  }

  /**------------------------------------------------------------------
   */
  public void add(_Point_if pt)
    throws Exception
  {
    checkSecureInvocation();
    _body.add(((_Point_cl)pt)._body);
  }

  /**------------------------------------------------------------------
   */
  public void add(_Rectangle_if r)
    throws Exception
  {
    checkSecureInvocation();
    _body.add(((_Rectangle_cl)r)._body);
  }

  /**------------------------------------------------------------------
   */
  public _String_if asString() //@
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = CN.concat("[x=")
      .concat(java.lang.Integer.toString(getX())).concat(",y=")
      .concat(java.lang.Integer.toString(getY())).concat(",width=")
      .concat(java.lang.Integer.toString(getWidth())).concat(",height=")
      .concat(java.lang.Integer.toString(getHeight())).concat("]");
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  /**------------------------------------------------------------------
   */
  public boolean contains(_Point_if p)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Point  p_tmp = ((_Point_cl)p)._body;
    return _body.contains(p_tmp);
  }

  /**------------------------------------------------------------------
   */
  public boolean contains(int x, int y)
    throws Exception
  {
    checkSecureInvocation();
    return _body.contains(x, y);
  }

  /**------------------------------------------------------------------
   */
  public _Rectangle_if getBounds()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Rectangle  r_tmp = _body.getBounds();
    if (r_tmp == null) return null;
    JP.go.ipa.oz.lib.standard._Rectangle_cl  rv = new JP.go.ipa.oz.lib.standard._Rectangle_cl(r_tmp);
    return rv;
  }

  /**------------------------------------------------------------------
   */
  public int getHeight() //@
    throws Exception
  {
    checkSecureInvocation();
    return _body.height;
  }

  /**------------------------------------------------------------------
   */
  public _Point_if getLocation()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Point  j_p_tmp = _body.getLocation();
    if (j_p_tmp == null) return null;
    JP.go.ipa.oz.lib.standard._Point_cl  o_p_tmp = new JP.go.ipa.oz.lib.standard._Point_cl(j_p_tmp);
    return o_p_tmp;
  }

  /**------------------------------------------------------------------
   */
  public _Dimension_if getSize()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Dimension  j_d_tmp = _body.getSize();
    if (j_d_tmp == null) return null;
    JP.go.ipa.oz.lib.standard._Dimension_cl  o_d_tmp = new JP.go.ipa.oz.lib.standard._Dimension_cl(j_d_tmp);
    return o_d_tmp;
  }

  /**------------------------------------------------------------------
   */
  public int getWidth() //@
    throws Exception
  {
    checkSecureInvocation();
    return _body.width;
  }

  /**------------------------------------------------------------------
   */
  public int getX() //@
    throws Exception
  {
    checkSecureInvocation();
    return _body.x;
  }

  /**------------------------------------------------------------------
   */
  public int getY() //@
    throws Exception
  {
    checkSecureInvocation();
    return _body.y;
  }

  /**------------------------------------------------------------------
   */
  public void grow(int h, int v)
    throws Exception
  {
    checkSecureInvocation();
    _body.grow(h, v);
  }

  /**------------------------------------------------------------------
   */
/*
  public int hashCode()
    throws Exception
  {
    return _body.hashCode();
  }
*/

  /**------------------------------------------------------------------
   */
  public boolean intersects(_Rectangle_if r)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Rectangle  tmp = ((_Rectangle_cl)r)._body;
    return _body.intersects(tmp);
  }

  /**------------------------------------------------------------------
   */
  public _Rectangle_if intersection(_Rectangle_if r)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Rectangle  arg_tmp = ((_Rectangle_cl)r)._body;
    java.awt.Rectangle  rv_tmp = _body.intersection(arg_tmp);
    if (rv_tmp == null) return null;
    JP.go.ipa.oz.lib.standard._Rectangle_cl  rv = new JP.go.ipa.oz.lib.standard._Rectangle_cl(rv_tmp);
    return rv;
  }

  /**------------------------------------------------------------------
   */
  public boolean isEmpty()
    throws Exception
  {
    checkSecureInvocation();
    return _body.isEmpty();
  }

  /**------------------------------------------------------------------
   */
  public void setBounds(int x, int y, int width, int height)
    throws Exception
  {
    checkSecureInvocation();
    _body.setBounds(x, y, width, height);
  }

  /**------------------------------------------------------------------
   */
  public void setBounds(_Rectangle_if r)
    throws Exception
  {
    checkSecureInvocation();
    _body.setBounds(((_Rectangle_cl)r)._body);
  }

  /**------------------------------------------------------------------
   */
  public void setHeight(int height) //@
    throws Exception
  {
    checkSecureInvocation();
    _body.height = height;
  }

  /**------------------------------------------------------------------
   */
  public void setLocation(_Point_if p)
    throws Exception
  {
    checkSecureInvocation();
    _body.setLocation(((_Point_cl)p)._body);
  }

  /**------------------------------------------------------------------
   */
  public void setLocation(int x, int y)
    throws Exception
  {
    checkSecureInvocation();
    _body.setLocation(x, y);
  }

  /**------------------------------------------------------------------
   */
  public void setSize(_Dimension_if d)
    throws Exception
  {
    checkSecureInvocation();
    _body.setSize(((_Dimension_cl)d)._body);
  }

  /**------------------------------------------------------------------
   */
  public void setSize(int width, int height)
    throws Exception
  {
    checkSecureInvocation();
    _body.setSize(width, height);
  }

  /**------------------------------------------------------------------
   */
  public void setWidth(int width) //@
    throws Exception
  {
    checkSecureInvocation();
    _body.width = width;
  }

  /**------------------------------------------------------------------
   */
  public void setX(int x) //@
    throws Exception
  {
    checkSecureInvocation();
    _body.x = x;
  }

  /**------------------------------------------------------------------
   */
  public void setY(int y) //@
    throws Exception
  {
    checkSecureInvocation();
    _body.y = y;
  }

  /**------------------------------------------------------------------
   */
  public void translate(int x, int y)
    throws Exception
  {
    checkSecureInvocation();
    _body.translate(x, y);
  }

  /**------------------------------------------------------------------
   */
  public _Rectangle_if union(_Rectangle_if r)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Rectangle  arg_tmp = ((_Rectangle_cl)r)._body;
    java.awt.Rectangle  rv_tmp = _body.union(arg_tmp);
    if (rv_tmp == null) return null;
    JP.go.ipa.oz.lib.standard._Rectangle_cl  rv = new JP.go.ipa.oz.lib.standard._Rectangle_cl(rv_tmp);
    return rv;
  }


  //================================================== support methods

//  public java.lang.String toString()
//  {
//    return ((_String_cl)(asString()))._body;
//  }

}

// EoF
