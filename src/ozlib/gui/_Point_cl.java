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
 * Point implementation
 *
 * @version  $Id: _Point_cl.java,v 1.11 1997/07/04 02:27:09 nito Exp $
 * @see      _Point_cl
 */


public class _Point_cl
  extends JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._Point_if
{

  final static java.lang.String  CN = "Point";
  java.awt.Point  _body;

    
  //================================================== constructors

  _Point_cl(java.awt.Point p)
    throws Exception
  {
    _body = p;
  }

  public _Point_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  /**------------------------------------------------------------------
   */
  public java.lang.Object _new_newPoint()
    throws Exception
  {
    _body = new java.awt.Point();
    return this;
  }

  /**------------------------------------------------------------------
   */
  public java.lang.Object _new_newPoint(_Point_if p)
    throws Exception
  {
    java.awt.Point  arg_p = ((_Point_cl)p)._body;
    _body = new java.awt.Point(arg_p);
    return this;
  }

  /**------------------------------------------------------------------
   */
  public java.lang.Object _new_newPoint(int x, int y)
    throws Exception
  {
    _body = new java.awt.Point(x, y);
    return this;
  }


  //======================================== OZ method implementation

  /*------------------------------------------------------------------
   */
  public _String_if asString() //@
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = CN.concat("[x=")
      .concat(java.lang.Integer.toString(_body.x)).concat(",y=")
      .concat(java.lang.Integer.toString(_body.y)).concat("]");
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //public boolean equals(_Root_if obj);  // final in Root

  //------------------------------------------------------------------
  public _Point_if getLocation()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Point  rv_tmp = new java.awt.Point(_body.x, _body.y);
    if (rv_tmp == null) return null;
    _Point_if  rv = new _Point_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public int getX() //@
    throws Exception
  {
    checkSecureInvocation();
    return _body.x;
  }

  //------------------------------------------------------------------
  public int getY() //@
    throws Exception
  {
    checkSecureInvocation();
    return _body.y;
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

  //------------------------------------------------------------------
  public void move(int x, int y)
    throws Exception
  {
    checkSecureInvocation();
    _body.move(x, y);
  }

  //------------------------------------------------------------------
  public void setLocation(_Point_if p)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Point  arg_p = ((_Point_cl)p)._body;
    _body.setLocation(arg_p);
  }

  //------------------------------------------------------------------
  public void setLocation(int x, int y)
    throws Exception
  {
    checkSecureInvocation();
    _body.setLocation(x, y);
  }

  //------------------------------------------------------------------
  public void setX(int x) //@
    throws Exception
  {
    checkSecureInvocation();
    _body.x = x;
  }

  //------------------------------------------------------------------
  public void setY(int y) //@
    throws Exception
  {
    checkSecureInvocation();
    _body.y = y;
  }

  //------------------------------------------------------------------
  public void translate(int x, int y)
    throws Exception
  {
    checkSecureInvocation();
    _body.translate(x, y);
  }

  //================================================== support methods

//  public java.lang.String toString()
//  {
//    return ((_String_cl)(asString()))._body;
//  }

}

// EoF
