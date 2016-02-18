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
 * Adjustable interface
 *
 * @version  $Id: _Adjustable_cl.java,v 1.5 1997/06/18 02:37:17 nito Exp $
 */


public abstract class _Adjustable_cl
  extends JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._Adjustable_if
{

  final static java.lang.String  CN = "Adjustable";
  java.awt.Adjustable  _body;


  //================================================== constructors

  protected _Adjustable_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  protected java.lang.Object _new_newAdjustable()
    throws Exception
  {
    return this;
  }


  //================================================== OZ methods
  public final int getHORIZONTAL() throws Exception
    { return _static_getHORIZONTAL(); }

  public static final int _static_getHORIZONTAL() throws Exception
    { return java.awt.Adjustable.HORIZONTAL; }

  public final int getVERTICAL() throws Exception
    { return _static_getVERTICAL(); }

  public static final int _static_getVERTICAL() throws Exception
    { return java.awt.Adjustable.VERTICAL; }

  public abstract void addAdjustmentListener(_AdjustmentListener_if l)throws Exception;
  public abstract int getBlockIncrement()throws Exception;
  public abstract int getMaximum()throws Exception;
  public abstract int getMinimum()throws Exception;
  public abstract int getOrientation()throws Exception;
  public abstract int getUnitIncrement()throws Exception;
  public abstract int getValue()throws Exception;
  public abstract int getVisibleAmount()throws Exception;
  public abstract void removeAdjustmentListener(_AdjustmentListener_if l)throws Exception;
  public abstract void setBlockIncrement(int b)throws Exception;
  public abstract void setMaximum(int max)throws Exception;
  public abstract void setMinimum(int min)throws Exception;
  public abstract void setUnitIncrement(int u)throws Exception;
  public abstract void setValue(int v)throws Exception;
  public abstract void setVisibleAmount(int v)throws Exception;

}

// EoF

