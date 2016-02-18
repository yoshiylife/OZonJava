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
 * BorderLayout implementation
 *
 * @version  $Id: _BorderLayout_cl.java,v 1.12 1997/07/25 02:19:37 nito Exp $
 * @see      _BorderLayout_if
 * @see      _LayoutManager2_if
 */


public class _BorderLayout_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._BorderLayout_if
{

  public final _String_if getNORTH()
    throws Exception
  {
    return _static_getNORTH();
  }

  public static final _String_if _static_getNORTH()
    throws Exception
  {
    return new _String_cl(java.awt.BorderLayout.NORTH);
  }


  public final _String_if getSOUTH()
    throws Exception
  {
    return _static_getSOUTH();
  }

  public static final _String_if _static_getSOUTH()
    throws Exception
  {
    return new _String_cl(java.awt.BorderLayout.SOUTH);
  }


  public final _String_if getEAST()
    throws Exception
  {
    return _static_getEAST();
  }

  public static final _String_if _static_getEAST()
    throws Exception
  {
    return new _String_cl(java.awt.BorderLayout.EAST);
  }


  public final _String_if getWEST()
    throws Exception
  {
    return _static_getWEST();
  }

  public static final _String_if _static_getWEST()
    throws Exception
  {
    return new _String_cl(java.awt.BorderLayout.WEST);
  }


  public final _String_if getCENTER()
    throws Exception
  {
    return _static_getCENTER();
  }

  public static final _String_if _static_getCENTER()
    throws Exception
  {
    return new _String_cl(java.awt.BorderLayout.CENTER);
  }




  final static java.lang.String  CN = "BorderLayout";
  _OzBorderLayout  _body;


  //================================================== constructors

  _BorderLayout_cl(_OzBorderLayout b)
    throws Exception
  {
    _body = b;
  }

  public _BorderLayout_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  //------------------------------------------------------------------
  public java.lang.Object _new_newBorderLayout()
    throws Exception
  {
    _OzBorderLayout  b = new _OzBorderLayout();
    b.bind(this);
    _body = b;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newBorderLayout(int hgap, int vgap)
    throws Exception
  {
    _OzBorderLayout  b = new _OzBorderLayout(hgap, vgap);
    b.bind(this);
    _body = b;
    return this;
  }


  //======================================== OZ method implementation

  //------------------------------------------------------------------
//  public void addLayoutComponent(_Component_if comp,
//				 JP.go.ipa.oz.lang._Root_if constraints)
//    throws Exception
//  {
//    checkSecureInvocation();
//    java.awt.Component  arg_comp = (java.awt.Component)(((_Component_cl)comp)._body);
//    _body.addLayoutComponent(arg_comp, constraints);
//  }
//
//  //------------------------------------------------------------------
//  public void addLayoutComponent(_String_if name, _Component_if comp) //DEPRECATED ... LayoutManager compatibility ONLY
//    throws Exception
//  {
//    checkSecureInvocation();
//    java.lang.String  arg_name = ((_String_cl)name)._body;
//    java.awt.Component  arg_comp = (java.awt.Component)(((_Component_cl)comp)._body);
//    _body.addLayoutComponent(arg_name, arg_comp);
//  }
//
//  //------------------------------------------------------------------
//  public _String_if asString() //@
//    throws Exception
//  {
//    checkSecureInvocation();
//    java.lang.String  rv_tmp = _body.toString();
//    _String_if  rv = new _String_cl(rv_tmp);
//    return rv;
//  }
//
//  //------------------------------------------------------------------
//  public int getHgap()
//    throws Exception
//  {
//    checkSecureInvocation();
//    return _body.getHgap();
//  }
//
//  //------------------------------------------------------------------
//  public float getLayoutAlignmentX(_Container_if parent)
//    throws Exception
//  {
//    checkSecureInvocation();
//    java.awt.Container  arg_parent = (java.awt.Container)(((_Container_cl)parent)._body);
//    return _body.getLayoutAlignmentX(arg_parent);
//  }
//
//  //------------------------------------------------------------------
//  public float getLayoutAlignmentY(_Container_if parent)
//    throws Exception
//  {
//    checkSecureInvocation();
//    java.awt.Container  arg_parent = (java.awt.Container)(((_Container_cl)parent)._body);
//    return _body.getLayoutAlignmentY(arg_parent);
//  }
//
//  //------------------------------------------------------------------
//  public int getVgap()
//    throws Exception
//  {
//    checkSecureInvocation();
//    return _body.getVgap();
//  }
//
//  //------------------------------------------------------------------
//  public void invalidateLayout(_Container_if target)
//    throws Exception
//  {
//    checkSecureInvocation();
//    java.awt.Container  arg_target = (java.awt.Container)(((_Container_cl)target)._body);
//    _body.invalidateLayout(arg_target);
//  }
//
//  //------------------------------------------------------------------
//  public void layoutContainer(_Container_if target)
//    throws Exception
//  {
//    checkSecureInvocation();
//    java.awt.Container  arg_target = (java.awt.Container)(((_Container_cl)target)._body);
//    _body.layoutContainer(arg_target);
//  }
//
//  //------------------------------------------------------------------
//  public _Dimension_if maximumLayoutSize(_Container_if target)
//    throws Exception
//  {
//    checkSecureInvocation();
//    java.awt.Container  arg_target = (java.awt.Container)(((_Container_cl)target)._body);
//    java.awt.Dimension  rv_tmp = _body.maximumLayoutSize(arg_target);
//    _Dimension_if  rv = new _Dimension_cl(rv_tmp);
//    return rv;
//  }
//
//  //------------------------------------------------------------------
//  public _Dimension_if minimumLayoutSize(_Container_if target)
//    throws Exception
//  {
//    checkSecureInvocation();
//    java.awt.Container  arg_target = (java.awt.Container)(((_Container_cl)target)._body);
//    java.awt.Dimension  rv_tmp = _body.minimumLayoutSize(arg_target);
//    _Dimension_if  rv = new _Dimension_cl(rv_tmp);
//    return rv;
//  }
//
//  //------------------------------------------------------------------
//  public _Dimension_if preferredLayoutSize(_Container_if target)
//    throws Exception
//  {
//    checkSecureInvocation();
//    java.awt.Container  arg_target = (java.awt.Container)(((_Container_cl)target)._body);
//    java.awt.Dimension  rv_tmp = _body.preferredLayoutSize(arg_target);
//    _Dimension_if  rv = new _Dimension_cl(rv_tmp);
//    return rv;
//  }
//
//  //------------------------------------------------------------------
//  public void removeLayoutComponent(_Component_if comp)
//    throws Exception
//  {
//    checkSecureInvocation();
//    java.awt.Component  arg_comp = (java.awt.Component)(((_Component_cl)comp)._body);
//    _body.removeLayoutComponent(arg_comp);
//  }
//
//  //------------------------------------------------------------------
//  public void setHgap(int hgap)
//    throws Exception
//  {
//    checkSecureInvocation();
//    _body.setHgap(hgap);
//  }
//
//  //------------------------------------------------------------------
//  public void setVgap(int vgap)
//    throws Exception
//  {
//    checkSecureInvocation();
//    _body.setVgap(vgap);
//  }
//
//
//  //================================================== support methods
//
//  //------------------------------------------------------------------
  public final java.lang.Object java()
    throws Exception
  {
    return _body;
  }
  
//  //------------------------------------------------------------------
//  public java.lang.String toString()
//  {
//    java.lang.String  rv = _body.toString();
//    return rv;
//  }
//
}

// EoF

