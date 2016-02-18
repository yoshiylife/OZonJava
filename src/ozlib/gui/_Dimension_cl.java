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
 * Dimension implementation
 *
 * @version  $Id: _Dimension_cl.java,v 1.10 1997/06/18 12:58:10 nito Exp $
 * @see      _Dimension_if
 */


public class _Dimension_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._Dimension_if
{

  static final java.lang.String  CN = "Dimension";
  java.awt.Dimension  _body;


  //================================================== constructors

  _Dimension_cl(java.awt.Dimension d)
    throws Exception
  {
    _body = d;
  }
    
  public _Dimension_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  /**------------------------------------------------------------------
   */
  public java.lang.Object _new_newDimension(_Dimension_if d)
    throws Exception
  {
    _body = new java.awt.Dimension(((_Dimension_cl)d)._body);
    return this;
  }

  /**------------------------------------------------------------------
   */
  public java.lang.Object _new_newDimension(int width, int height)
    throws Exception
  {
    _body = new java.awt.Dimension(width, height);
    return this;
  }


  //======================================== OZ method implementation

  /**------------------------------------------------------------------
   */
  public _String_if asString() //@
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = CN.concat("[width=")
      .concat(java.lang.Integer.toString(_body.width)).concat(",height=")
      .concat(java.lang.Integer.toString(_body.height)).concat("]");
    _String_if  rv = new _String_cl(rv_tmp);
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
  public int getWidth() //@
    throws Exception
  {
    checkSecureInvocation();
    return _body.width;
  }
    
  /**------------------------------------------------------------------
   */
  public _Dimension_if getSize()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Dimension  rv_tmp = new java.awt.Dimension(_body);
    _Dimension_if  rv = new _Dimension_cl(rv_tmp);
    return rv;
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
  public void setHeight(int height) //@
    throws Exception
  {
    checkSecureInvocation();
    _body.height = height;
  }

  /**------------------------------------------------------------------
   */
  public void setSize(_Dimension_if d)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Dimension  arg_d = ((_Dimension_cl)d)._body;
    _body.setSize(arg_d);
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


  //================================================== support methods

//  public java.lang.String toString()
//  {
//    return ((_String_cl)(asString()))._body;
//  }

}

// EoF
