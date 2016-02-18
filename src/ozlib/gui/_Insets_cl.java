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
 * Insets implementation
 *
 * @version  $Id: _Insets_cl.java,v 1.13 1997/07/04 02:27:08 nito Exp $
 * @see      _Insets_if
 */


public class _Insets_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._Insets_if
{

  static final java.lang.String  CN = "Insets";
  java.awt.Insets  _body;

  //================================================== constructors

  _Insets_cl(java.awt.Insets i)
    throws Exception
  {
    _body = i;
  }

  public _Insets_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  /**------------------------------------------------------------------
   */
  public java.lang.Object _new_newInsets(int top, int left, int bottom, int right)
    throws Exception
  {
    _body = new java.awt.Insets(top, left, bottom, right);
    return this;
  }


  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public _String_if asString() //@
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp
      = CN.concat("[top=").concat(java.lang.Integer.toString(_body.top))
      .concat(",left=").concat(java.lang.Integer.toString(_body.left))
      .concat(",bottom=").concat(java.lang.Integer.toString(_body.bottom))
      .concat(",right=").concat(java.lang.Integer.toString(_body.right))
      .concat("]");
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public JP.go.ipa.oz.lang._Root_if duplicate()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Insets  rv_tmp = (java.awt.Insets)(_body.clone());
    if (rv_tmp == null) return null;
    _Insets_if  rv = new _Insets_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public int getBottom() //@
    throws Exception
  {
    checkSecureInvocation();
    return _body.bottom;
  }

  //------------------------------------------------------------------
  public int getLeft() //@
    throws Exception
  {
    checkSecureInvocation();
    return _body.left;
  }

  //------------------------------------------------------------------
  public int getRight() //@
    throws Exception
  {
    checkSecureInvocation();
    return _body.right;
  }

  //------------------------------------------------------------------
  public int getTop() //@
    throws Exception
  {
    checkSecureInvocation();
    return _body.top;
  }

  /**------------------------------------------------------------------
   */
  public synchronized void set(int top, int left, int bottom, int right) //@
    throws Exception
  {
    _body.top = top;
    _body.left = left;
    _body.bottom = bottom;
    _body.right = right;
  }

  //------------------------------------------------------------------
  public void setBottom(int bottom) //@
    throws Exception
  {
    checkSecureInvocation();
    _body.bottom = bottom;
  }

  //------------------------------------------------------------------
  public void setLeft(int left) //@
    throws Exception
  {
    checkSecureInvocation();
    _body.left = left;
  }

  //------------------------------------------------------------------
  public void setRight(int right) //@
    throws Exception
  {
    checkSecureInvocation();
    _body.right = right;
  }

  //------------------------------------------------------------------
  public void setTop(int top) //@
    throws Exception
  {
    checkSecureInvocation();
    _body.top = top;
  }


  //================================================== support methods
//  public java.lang.String toString()
//  {
//    return ((_String_cl)(asString()))._body;
//  }

}

// EoF
