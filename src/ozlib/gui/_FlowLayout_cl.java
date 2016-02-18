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
 * FlowLayout implementation
 *
 * @version  $Id: _FlowLayout_cl.java,v 1.12 1997/07/25 02:19:37 nito Exp $
 * @see      _LayoutManager_if
 * @see      _FlowLayout_if
 */


public class _FlowLayout_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._FlowLayout_if
{

  public final int getLEFT() throws Exception
    { return _static_getLEFT(); }

  public static final int _static_getLEFT() throws Exception
    { return java.awt.FlowLayout.LEFT; }

  public final int getCENTER() throws Exception
    { return _static_getCENTER(); }

  public static final int _static_getCENTER() throws Exception
    { return java.awt.FlowLayout.CENTER; }

  public final int getRIGHT() throws Exception
    { return _static_getRIGHT(); }

  public static final int _static_getRIGHT() throws Exception
    { return java.awt.FlowLayout.RIGHT; }



  final static java.lang.String  CN = "FlowLayout";
  _OzFlowLayout  _body;


  //================================================== constructors

  _FlowLayout_cl(_OzFlowLayout fl)
    throws Exception
  {
    _body = fl;
  }

  public _FlowLayout_cl()
    throws Exception
  {
  }
  

  //======================================== OZ constructor implementation

  //------------------------------------------------------------------
  public java.lang.Object _new_newFlowLayout()
    throws Exception
  {
    _OzFlowLayout  f = new _OzFlowLayout();
    f.bind(this);
    _body = f;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newFlowLayout(int align)
    throws Exception
  {
    _OzFlowLayout  f = new _OzFlowLayout(align);
    f.bind(this);
    _body = f;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newFlowLayout(int align, int hgap, int vgap)
    throws Exception
  {
    _OzFlowLayout  f = new _OzFlowLayout(align, hgap, vgap);
    f.bind(this);
    _body = f;
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
//  public _String_if asString() //
//    throws Exception
//  {
//    checkSecureInvocation();
//    java.lang.String  rv_tmp = _body.toString();
//    _String_if  rv = new _String_cl(rv_tmp);
//    return rv;
//  }
//
//  //------------------------------------------------------------------
//  public int getAlignment()
//    throws Exception
//  {
//    checkSecureInvocation();
//    return _body.getAlignment();
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
//  public int getVgap()
//    throws Exception
//  {
//    checkSecureInvocation();
//     return _body.getVgap();
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
//    java.awt.Component  arg_target = (java.awt.Component)(((_Component_cl)comp)._body);
//    _body.removeLayoutComponent(arg_target);
//  }
//
//  //------------------------------------------------------------------
//  public void setAlignment(int align)
//    throws Exception
//  {
//    checkSecureInvocation();
//    _body.setAlignment(align);
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
