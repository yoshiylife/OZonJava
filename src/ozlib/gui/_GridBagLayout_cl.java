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
 * GridBagLayout implementation
 *
 * @version  $Id: _GridBagLayout_cl.java,v 1.11 1997/07/01 02:32:26 nito Exp $
 * @see      _GridBagLayout_if
 * @see      _LayoutManager2_if
 * @see      _GridBagConstraints_if
 */


public class _GridBagLayout_cl
  extends JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._GridBagLayout_if
{

  final static java.lang.String  CN = "GridBagLayout";
  _OzGridBagLayout  _body;


  //================================================== costructors

  _GridBagLayout_cl(_OzGridBagLayout gl)
    throws Exception
  {
    _body = gl;
  }

  public _GridBagLayout_cl()
    throws Exception
  {
  }


  //======================================== OZ costructor implementation

  public java.lang.Object _new_newGridBagLayout()
    throws Exception
  {
    _OzGridBagLayout  gl = new _OzGridBagLayout();
    gl.bind(this);
    _body = gl;
    return this;
  }


  //======================================== OZ method implementation

//  //------------------------------------------------------------------
//  public void addLayoutComponent(_String_if name, _Component_if comp)
//    throws Exception
//  {
//    checkSecureInvocation();
//    java.lang.String  arg_name = ((_String_cl)name)._body;
//    java.awt.Component  arg_comp = (java.awt.Component)(((_Component_cl)comp)._body);
//    _body.addLayoutComponent(arg_name, arg_comp);
//  }
//
//  //------------------------------------------------------------------
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
//  public _String_if asString() //@
//    throws Exception
//  {
//    checkSecureInvocation();
//    java.lang.String  rv_tmp = _body.toString();
//    _String_cl  rv = new _String_cl(rv_tmp);
//    return rv;
//  }
//
//  //------------------------------------------------------------------
//  public _GridBagConstraints_if getConstraints(_Component_if comp)
//    throws Exception
//  {
//    checkSecureInvocation();
//    java.awt.Component  arg_comp = (java.awt.Component)(((_Component_cl)comp)._body);
//    java.awt.GridBagConstraints  rv_tmp = _body.getConstraints(arg_comp);
//    _GridBagConstraints_if  rv = new _GridBagConstraints_cl(rv_tmp);
//    return rv;
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
//  //public int[][] getLayoutDimensions()
//  //{
//  //  checkSecureInvocation();
//  //  return _body.getLayoutDimensions();
//  //}
//
//  //------------------------------------------------------------------
//  public _Point_if getLayoutOrigin()
//    throws Exception
//  {
//    checkSecureInvocation();
//    java.awt.Point  rv_tmp = _body.getLayoutOrigin();
//    _Point_if  rv = new _Point_cl(rv_tmp);
//    return rv;
//  }
//
//  //------------------------------------------------------------------
//  //public double[][] getLayoutWeights()
//  //{
//  //  checkSecureInvocation();
//  //  return _body.getLayoutWeights();
//  //}
//
//  //------------------------------------------------------------------
//  public void layoutContainer(_Container_if parent)
//    throws Exception
//  {
//    checkSecureInvocation();
//    java.awt.Container  arg_parent = (java.awt.Container)(((_Container_cl)parent)._body);
//    _body.layoutContainer(arg_parent);
//  }
//
//  //------------------------------------------------------------------
//  public _Point_if location(int x, int y)
//    throws Exception
//  {
//    checkSecureInvocation();
//    java.awt.Point  rv_tmp = _body.location(x, y);
//    _Point_if  rv = new _Point_cl(rv_tmp);
//    return rv;
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
//  public _Dimension_if minimumLayoutSize(_Container_if parent)
//    throws Exception
//  {
//    checkSecureInvocation();
//    java.awt.Container  arg_parent = (java.awt.Container)(((_Container_cl)parent)._body);
//    java.awt.Dimension  rv_tmp = _body.minimumLayoutSize(arg_parent);
//    _Dimension_if  rv = new _Dimension_cl(rv_tmp);
//    return rv;
//  }
//
//  //------------------------------------------------------------------
//  public _Dimension_if preferredLayoutSize(_Container_if parent)
//    throws Exception
//  {
//    checkSecureInvocation();
//    java.awt.Container  arg_parent = (java.awt.Container)(((_Container_cl)parent)._body);
//    java.awt.Dimension  rv_tmp = _body.preferredLayoutSize(arg_parent);
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
  public void setConstraints(_Component_if comp, _GridBagConstraints_if constraints)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Component  arg_comp = (java.awt.Component)(((_Component_cl)comp)._body);
    java.awt.GridBagConstraints  arg_constraints = ((_GridBagConstraints_cl)constraints)._body;
    _body.setConstraints(arg_comp, arg_constraints);
  }


//  //================================================== support methods
//
//  //------------------------------------------------------------------
  public final java.lang.Object java()
    throws Exception
  {
    return _body;
  }
//  
//  //------------------------------------------------------------------
//  public java.lang.String toString()
//  {
//    java.lang.String  rv = _body.toString();
//    return rv;
//  }
//
//  //================================================== protected methods
//  //protected void AdjustForGravity(_GridBagConstraints_if constraints, _Rectangle_if r){}
//  //protected void ArrangeGrid(_Container_if parent){}
//  //protected _GridBagLayoutInfo_if GetLayoutInfo(_Container_if parent, int sizeflag){}
//  //protected _Dimension_if GetMinSize(_Container_if parent, _GridBagLayoutInfo_if info){}
//  //protected _GridBagConstraints_if lookupConstraints(_Component_if comp){}

}

// EoF
