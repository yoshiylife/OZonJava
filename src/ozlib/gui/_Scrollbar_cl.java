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
 * Scrollbar implementation
 *
 * @version  $Id: _Scrollbar_cl.java,v 1.10 1997/06/18 12:58:15 nito Exp $
 * @see      _Scrollbar_if
 * @see      _Component_cl
 */


public class _Scrollbar_cl
  extends    JP.go.ipa.oz.lib.standard._Component_cl
  implements JP.go.ipa.oz.lib.standard._Scrollbar_if
{

  public final int getHORIZONTAL() throws Exception
    { return _static_getHORIZONTAL(); }

  public static final int _static_getHORIZONTAL() throws Exception
    { return java.awt.Scrollbar.HORIZONTAL; }

  public final int getVERTICAL() throws Exception
    { return _static_getVERTICAL(); }

  public static final int _static_getVERTICAL() throws Exception
    { return java.awt.Scrollbar.VERTICAL; }


  static final java.lang.String  CN = "Scrollbar";


  //================================================== constructors

  _Scrollbar_cl(_OzScrollbar sb)
    throws Exception
  {
    _body = sb;
  }

  public _Scrollbar_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  //------------------------------------------------------------------
  public java.lang.Object _new_newScrollbar()
    throws Exception
  {
    _OzScrollbar  sb = new _OzScrollbar();
    sb.bind(this);
    _body = sb;
    return this;
  }

  //------------------------------------------------------------------
  //@public java.lang.Object _new_newScrollbar(int orientation){}

  //------------------------------------------------------------------
  public java.lang.Object _new_newHorizontalScrollbar()  //@
    throws Exception
  {
    _OzScrollbar  sb = new _OzScrollbar(java.awt.Scrollbar.HORIZONTAL);
    sb.bind(this);
    _body = sb;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newHorizontalScrollbar(int value, int visible, int minimum, int maximum)  //@
    throws Exception
  {
    _OzScrollbar  sb = new _OzScrollbar(java.awt.Scrollbar.HORIZONTAL,
			     value, visible, minimum, maximum);
    sb.bind(this);
    _body = sb;
    return this;
  }

  //------------------------------------------------------------------
  //@public java.lang.Object _new_newScrollbar(int orientation, int value, int visible, int minimum, int maximum){}

  //------------------------------------------------------------------
  public java.lang.Object _new_newVerticalScrollbar()  //@
    throws Exception
  {
    _OzScrollbar  sb = new _OzScrollbar(java.awt.Scrollbar.VERTICAL);
    sb.bind(this);
    _body = sb;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newVerticalScrollbar(int value, int visible, int minimum, int maximum)  //@
    throws Exception
  {
    _OzScrollbar  sb = new _OzScrollbar(java.awt.Scrollbar.VERTICAL,
			     value, visible, minimum, maximum);
    sb.bind(this);
    _body = sb;
    return this;
  }


  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public void addAdjustmentListener(_AdjustmentListener_if l) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.event.AdjustmentListener  arg_l = (java.awt.event.AdjustmentListener)(((_AdjustmentListener_cl)l)._body);
    ((java.awt.Scrollbar)_body).addAdjustmentListener(arg_l);
  }

  //------------------------------------------------------------------
  public void addNotify()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Scrollbar)_body).addNotify();
  }

  //------------------------------------------------------------------
  public _String_if asString()
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = CN.concat("[");
    rv_tmp.concat("]");
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public int getBlockIncrement()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.Scrollbar)_body).getBlockIncrement();
  }

  //public int getLineIncrement() //DEPRECATED

  //------------------------------------------------------------------
  public int getMaximum()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.Scrollbar)_body).getMaximum();
  }

  //------------------------------------------------------------------
  public int getMinimum()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.Scrollbar)_body).getMinimum();
  }

  //------------------------------------------------------------------
  public int getOrientation() //for interface compatibility ONLY
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.Scrollbar)_body).getOrientation();
  }

  //public int getPageIncrement() //DEPRECATED

  //------------------------------------------------------------------
  public int getUnitIncrement()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.Scrollbar)_body).getUnitIncrement();
  }

  //------------------------------------------------------------------
  public int getValue()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.Scrollbar)_body).getValue();
  }

  //public int getVisible() //DEPRECATED

  //------------------------------------------------------------------
  public int getVisibleAmount()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.Scrollbar)_body).getVisibleAmount();
  }

  //------------------------------------------------------------------
  public boolean isHorizontal() //@
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.Scrollbar)_body).getOrientation() == java.awt.Scrollbar.HORIZONTAL;
  }

  //------------------------------------------------------------------
  public boolean isVertical() //@
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.Scrollbar)_body).getOrientation() == java.awt.Scrollbar.VERTICAL;
  }

  //------------------------------------------------------------------
  public void removeAdjustmentListener(_AdjustmentListener_if l) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.event.AdjustmentListener  arg_l = ((_AdjustmentListener_cl)l)._body;
    ((java.awt.Scrollbar)_body).removeAdjustmentListener(arg_l);
  }

  //------------------------------------------------------------------
  public void setBlockIncrement(int v) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Scrollbar)_body).setBlockIncrement(v);
  }

  //public void setLineIncrement(int v) //synchronized //DEPRECATED

  //------------------------------------------------------------------
  public void setMaximum(int newMaximum) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Scrollbar)_body).setMaximum(newMaximum);
  }

  //------------------------------------------------------------------
  public void setMinimum(int newMinimum) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Scrollbar)_body).setMinimum(newMinimum);
  }

  //------------------------------------------------------------------
  //@public void setOrientation(int orientation){} //synchronized

  //------------------------------------------------------------------
  public void setOrientationToHorizontal() //@
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Scrollbar)_body).setOrientation(java.awt.Scrollbar.HORIZONTAL);
  }

  //------------------------------------------------------------------
  public void setOrientationToVertical() //@
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Scrollbar)_body).setOrientation(java.awt.Scrollbar.VERTICAL);
  }

  //public void setPageIncrement(int v) //DEPRECATED

  //------------------------------------------------------------------
  public void setUnitIncrement(int v) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Scrollbar)_body).setUnitIncrement(v);
  }

  //------------------------------------------------------------------
  public void setValue(int newValue) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Scrollbar)_body).setValue(newValue);
  }

  //------------------------------------------------------------------
  public void setValues(int value, int visible, int minimum, int maximum) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Scrollbar)_body).setValues(value, visible, minimum, maximum);
  }

  //------------------------------------------------------------------
  public void setVisibleAmount(int newAmount) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Scrollbar)_body).setVisibleAmount(newAmount);
  }


  //================================================== protected methods
  //protected String paramString()
  //protected void processAdjustmentEvent(_AdjustmentEvent_if e)
  //protected void processEvent(_AWTEvent_if e)


  //================================================== support methods

//  public java.lang.String toString()
//  {
//    return ((_String_cl)asString())._body;
//  }

}

// EoF
