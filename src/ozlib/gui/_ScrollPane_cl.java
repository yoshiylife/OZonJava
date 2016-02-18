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
 * scrollPane implementation
 *
 * @version  $Id: _ScrollPane_cl.java,v 1.13 1997/07/04 02:27:09 nito Exp $
 * @see      _ScrollPane_if
 * @see      _Container_cl
 */


public class _ScrollPane_cl
  extends    JP.go.ipa.oz.lib.standard._Container_cl
  implements JP.go.ipa.oz.lib.standard._ScrollPane_if
{
  public final int getSCROLLBARS_AS_NEEDED() throws Exception
    { return _static_getSCROLLBARS_AS_NEEDED(); }

  public static final int _static_getSCROLLBARS_AS_NEEDED() throws Exception
    { return java.awt.ScrollPane.SCROLLBARS_AS_NEEDED; }

  public final int getSCROLLBARS_ALWAYS() throws Exception
    { return _static_getSCROLLBARS_ALWAYS(); }

  public static final int _static_getSCROLLBARS_ALWAYS() throws Exception
    { return java.awt.ScrollPane.SCROLLBARS_ALWAYS; }

  public final int getSCROLLBARS_NEVER() throws Exception
    { return _static_getSCROLLBARS_NEVER(); }

  public static final int _static_getSCROLLBARS_NEVER() throws Exception
    { return java.awt.ScrollPane.SCROLLBARS_NEVER; }


  static final java.lang.String  CN = "ScrollPane";


  //================================================== constructors

  _ScrollPane_cl(_OzScrollPane sp)
    throws Exception
  {
    _body = sp;
  }

  public _ScrollPane_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  //------------------------------------------------------------------
  public java.lang.Object _new_newScrollPane()  //AS_NEEDED
    throws Exception
  {
    _OzScrollPane  sp = new _OzScrollPane();
    sp.bind(this);
    _body = sp;
    return this;
  }

  //------------------------------------------------------------------
  //@public java.lang.Object _new_newScrollPane(int scrollbarDisplayPolicy)

  public java.lang.Object _new_newScrollPaneWithScrollbars() //@ //ALWAYS
    throws Exception
  {
    _OzScrollPane  sp = new _OzScrollPane(java.awt.ScrollPane.SCROLLBARS_ALWAYS);
    sp.bind(this);
    _body = sp;
    return this;
  }

  public java.lang.Object _new_newScrollPaneWithNoScrollbars() //@ //NEVER
    throws Exception
  {
    _OzScrollPane  sp = new _OzScrollPane(java.awt.ScrollPane.SCROLLBARS_NEVER);
    sp.bind(this);
    _body = sp;
    return this;
  }


  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public void addNotify()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.ScrollPane)_body).addNotify();
  }

  //------------------------------------------------------------------
  public _String_if asString() //@
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = CN.concat("[")
      .concat("]");
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public void doLayout()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.ScrollPane)_body).doLayout();
  }

  //------------------------------------------------------------------
  public _Adjustable_if getHAdjustable()
    throws Exception
  {
    checkSecureInvocation();
    _OzHoldable  rv_tmp = (_OzHoldable)(((java.awt.ScrollPane)_body).getHAdjustable());
    if (rv_tmp == null) return null;
    _Adjustable_if  rv = (_Adjustable_if)(rv_tmp.oz());
    return rv;
  }

  //------------------------------------------------------------------
  public int getHScrollbarHeight()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.ScrollPane)_body).getHScrollbarHeight();
  }

  //------------------------------------------------------------------
  public int getScrollbarDisplayPolicy()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.ScrollPane)_body).getScrollbarDisplayPolicy();
  }

  //------------------------------------------------------------------
  public _Point_if getScrollPosition()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Point  rv_tmp = ((java.awt.ScrollPane)_body).getScrollPosition();
    if (rv_tmp == null) return null;
    _Point_if  rv = new _Point_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _Dimension_if getViewportSize()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Dimension  rv_tmp = ((java.awt.ScrollPane)_body).getViewportSize();
    if (rv_tmp == null) return null;
    _Dimension_if  rv = new _Dimension_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _Adjustable_if getVAdjustable()
    throws Exception
  {
    checkSecureInvocation();
    _OzHoldable  rv_tmp = (_OzHoldable)(((java.awt.ScrollPane)_body).getVAdjustable());
    if (rv_tmp == null) return null;
    _Adjustable_if  rv = (_Adjustable_if)(rv_tmp.oz());
    return rv;
  }

  //------------------------------------------------------------------
  public int getVScrollbarWidth()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.ScrollPane)_body).getVScrollbarWidth();
  }

  //public void layout(){} //DEPRECATED

  //------------------------------------------------------------------
  public _String_if paramString()
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = ((java.awt.ScrollPane)_body).paramString();
    if (rv_tmp == null) return null;
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public void printComponents(_Graphics_if g)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Graphics  arg_g = ((_Graphics_cl)g)._body;
    ((java.awt.ScrollPane)_body).printComponents(arg_g);
  }

  //------------------------------------------------------------------
  public final void setLayout(_LayoutManager_if mgr)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.LayoutManager  arg_mgr = (java.awt.LayoutManager)(((_OzHoldable)mgr).java());
    ((java.awt.ScrollPane)_body).setLayout(arg_mgr);
  }

  //------------------------------------------------------------------
  public final void setDefaultLayout() throws Exception
  {
    checkSecureInvocation();
    ((java.awt.ScrollPane)_body).setLayout(null);
  }

  //------------------------------------------------------------------
  public void setScrollPosition(int x, int y)
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.ScrollPane)_body).setScrollPosition(x, y);
  }

  //------------------------------------------------------------------
  public void setScrollPosition(_Point_if p)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Point  arg_p = ((_Point_cl)p)._body;
    ((java.awt.ScrollPane)_body).setScrollPosition(arg_p);
  }


  //================================================== protected methods
  //protected final void addImpl(_Component_if comp, JP.go.ipa.oz.lang._Root_if constraints, int index)


  //================================================== support methods

//  public java.lang.String toString()
//  {
//    return ((_String_cl)asString())._body;
//  }

}

// EoF

