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
 * Polygon implementation
 *
 * @version  $Id: _Polygon_cl.java,v 1.14 1997/07/04 02:27:09 nito Exp $
 * @see      _Polygon_if
 */


public class _Polygon_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._Polygon_if
{

  static final java.lang.String  CN = "Polygon";
  java.awt.Polygon  _body;


  //================================================== constructors

  _Polygon_cl(java.awt.Polygon p)
    throws Exception
  {
    _body = p;
  }

  public _Polygon_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  /**------------------------------------------------------------------
   */
  public java.lang.Object _new_newPolygon()
    throws Exception
  {
    _body = new java.awt.Polygon();
    return this;
  }

  /**------------------------------------------------------------------
   */
  public java.lang.Object _new_newPolygon(_Sequence_if points)
    throws Exception
  {
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
      _body = new java.awt.Polygon(xpoints, ypoints, npoints);
      return this;
    } else return null;
  }

  //======================================== OZ method implementation

  /**------------------------------------------------------------------
   */
  public _Sequence_if getPoints()  //@
    throws Exception
  {
    int  npoints = _body.xpoints.length;
    _PointComparator_if comp = (_PointComparator_if)new _PointComparator_cl()._new_create();
    _Array_if pointArray = (_Array_if)new _Array_cl()._new_create(npoints, comp);

    for (int i = 0; i < npoints; i++) {
      _Point_if p = (_Point_if)new _Point_cl()._new_newPoint(_body.xpoints[i], _body.ypoints[i]);
      pointArray.putAt(i, p);
    }
    return pointArray;
  }
    
  /**------------------------------------------------------------------
   */
  public void setPoints(_Sequence_if points)  //@
    throws Exception
  {
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
      _body.xpoints = xpoints;
      _body.ypoints = ypoints;
    }
  }
    
  /**------------------------------------------------------------------
   */
  public void addPoint(_Point_if p)
    throws Exception
  {
    checkSecureInvocation();
    _body.addPoint(p.getX(), p.getY());
  }
    
  /**------------------------------------------------------------------
   */
  public void addPoint(int x, int y)
    throws Exception
  {
    checkSecureInvocation();
    _body.addPoint(x, y);
  }

  /**------------------------------------------------------------------
   */
  public synchronized _String_if asString() //@
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = CN.concat("[npoints=")
      .concat(Integer.toString(_body.npoints));
    java.lang.String  x_str, y_str;
    for (int i = 0; i < _body.npoints; i++) {
      x_str = java.lang.Integer.toString(_body.xpoints[i]);
      y_str = java.lang.Integer.toString(_body.ypoints[i]);
      rv_tmp = rv_tmp.concat(",").concat("(").concat(x_str).concat(",").concat(y_str).concat(")");
    }
    rv_tmp = rv_tmp.concat("]");
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  /**------------------------------------------------------------------
   */
  public boolean contains(_Point_if p)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Point  arg_p = ((_Point_cl)p)._body;
    return _body.contains(arg_p);
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
    java.awt.Rectangle  rv_tmp = _body.getBounds();
    if (rv_tmp == null) return null;
    _Rectangle_if  rv = new _Rectangle_cl(rv_tmp);
    return rv;
  }

  /**------------------------------------------------------------------
   */
  public int getNumberOfPoints()  //@
    throws Exception
  {
    checkSecureInvocation();
    return _body.npoints;
  }

  /**------------------------------------------------------------------
   */
  public _Point_if getPointAt(int i)  //@
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Point  rv_tmp = new java.awt.Point(_body.xpoints[i], _body.ypoints[i]);
    if (rv_tmp == null) return null;
    _Point_cl  rv = new _Point_cl(rv_tmp);
    return rv;
  }

  /**------------------------------------------------------------------
   */
  public void translate(int deltaX, int deltaY)
    throws Exception
  {
    checkSecureInvocation();
    _body.translate(deltaX, deltaY);
  }


  //================================================== support methods

//  public java.lang.String toString()
//  {
//    return ((_String_cl)(asString()))._body;
//  }

}

// EoF
