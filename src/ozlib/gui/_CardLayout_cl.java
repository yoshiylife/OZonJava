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
 * CardLayout implementation
 *
 * @version  $Id: _CardLayout_cl.java,v 1.9 1997/06/18 12:58:09 nito Exp $
 * @see      _LayoutManager2_if
 * @see      _CardLayout_if
 */


public class _CardLayout_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._LayoutManager2_if
{

   final static java.lang.String  CN = "CardLayout";
  _OzCardLayout  _body;


  //================================================== constructors

  _CardLayout_cl(_OzCardLayout c)
    throws Exception
  {
    _body = c;
  }

  public _CardLayout_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  //------------------------------------------------------------------
  public java.lang.Object _new_newCardLayout()
    throws Exception
  {
    _OzCardLayout  c = new _OzCardLayout();
    c.bind(this);
    _body = c;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newCardLayout(int hgap, int vgap)
    throws Exception
  {
    _OzCardLayout  c = new _OzCardLayout(hgap, vgap);
    c.bind(this);
    _body = c;
    return this;
  }


  //======================================== OZ method implementation

  //------------------------------------------------------------------
//  public void addLayoutComponent(_Component_if comp,
//				 JP.go.ipa.oz.lang._Root_if constraints)
//    throws Exception
//  {
//    checkSecureInvocation();
//    java.awt.Component  arg_comp
//      = (java.awt.Component)(((_Component_cl)comp)._body);
//    _body.addLayoutComponent(arg_comp, constraints);
//  }
//
//  //------------------------------------------------------------------
//  public void addLayoutComponent(_String_if name, _Component_if comp)
//       //deprecated ... LayoutManager compatibility ONLY
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
//  public void first(_Container_if parent)
//    throws Exception
//  {
//    checkSecureInvocation();
//    java.awt.Container  arg_parent = (java.awt.Container)(((_Container_cl)parent)._body);
//    _body.first(arg_parent);
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
//  public void last(_Container_if parent)
//    throws Exception
//  {
//    checkSecureInvocation();
//    java.awt.Container  arg_parent = (java.awt.Container)(((_Container_cl)parent)._body);
//    _body.last(arg_parent);
//  }
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
//  public _Dimension_if maximumLayoutSize(_Container_if target)
//    throws Exception
//  {
//    checkSecureInvocation();
//    java.awt.Container  arg_target = (java.awt.Container)(((_Container_cl)target)._body);
//    java.awt.Dimension rv_tmp = _body.maximumLayoutSize(arg_target);
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
//  public void next(_Container_if parent)
//    throws Exception
//  {
//    checkSecureInvocation();
//    java.awt.Container  arg_parent = (java.awt.Container)(((_Container_cl)parent)._body);
//    _body.next(arg_parent);
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
//  public void previous(_Container_if parent)
//    throws Exception
//  {
//    checkSecureInvocation();
//    java.awt.Container  arg_parent = (java.awt.Container)(((_Container_cl)parent)._body);
//    _body.previous(arg_parent);
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
//  //------------------------------------------------------------------
//  public void show(_Container_if parent, _String_if name)
//    throws Exception
//  {
//    checkSecureInvocation();
//    java.awt.Container  arg_parent = (java.awt.Container)(((_Container_cl)parent)._body);
//    java.lang.String  arg_name = ((_String_cl)name)._body;
//    _body.show(arg_parent, arg_name);
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
//
//  //------------------------------------------------------------------
//  public java.lang.String toString()
//  {
//    java.lang.String  rv = _body.toString();
//    return rv;
//  }
//
}

// EoF
