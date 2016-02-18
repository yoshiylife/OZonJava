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
 * GridLayout implementation
 *
 * @version  $Id: _GridLayout_cl.java,v 1.10 1997/06/18 12:58:10 nito Exp $
 * @see      _LayoutManager_if
 * @see      _GridLayout_if
 */


public class _GridLayout_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._GridLayout_if
{

  final static java.lang.String  CN = "GridLayout";
  _OzGridLayout  _body;


  //================================================== constructors

  _GridLayout_cl(_OzGridLayout gl)
    throws Exception
  {
    _body = gl;
  }

  public _GridLayout_cl()
    throws Exception
  {
  }


  //================================================== OZ constructors

  //------------------------------------------------------------------
  public java.lang.Object _new_newGridLayout()
    throws Exception
  {
    _OzGridLayout  g = new _OzGridLayout();
    g.bind(this);
    _body = g;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newGridLayout(int rows, int cols)
    throws Exception
  {
    _OzGridLayout  g = new _OzGridLayout(rows, cols);
    g.bind(this);
    _body = g;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newGridLayout(int rows, int cols, int hgap, int vgap)
    throws Exception
  {
    _OzGridLayout  g;
    g = new _OzGridLayout(rows, cols, hgap, vgap);
    g.bind(this);
    _body = g;
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
//  public int getColumns()
//    throws Exception
//  {
//    checkSecureInvocation();
//    return _body.getColumns();
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
//  public int getRows()
//    throws Exception
//  {
//    checkSecureInvocation();
//    return _body.getRows();
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
//  public void layoutContainer(_Container_if parent)
//    throws Exception
//  {
//    checkSecureInvocation();
//    java.awt.Container  arg_parent = (java.awt.Container)(((_Container_cl)parent)._body);
//    _body.layoutContainer(arg_parent);
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
//  public void setColumns(int cols)
//    throws Exception
//  {
//    checkSecureInvocation();
//    _body.setColumns(cols);
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
//  public void setRows(int rows)
//    throws Exception
//  {
//    checkSecureInvocation();
//    _body.setRows(rows);
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
//    throws Exception
//  {
//    java.lang.String  rv = _body.toString();
//    return rv;
//  }

}

// EoF
