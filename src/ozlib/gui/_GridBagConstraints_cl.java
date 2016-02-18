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
 * GridBagConstraints implementation
 *
 * @version  $Id: _GridBagConstraints_cl.java,v 1.12 1997/07/04 02:27:08 nito Exp $
 * @see      _GridBagConstraints_if
 * @see      _GridBagLayout_if
 */


public class _GridBagConstraints_cl
  extends JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._GridBagConstraints_if
{

  public final int getRELATIVE() throws Exception
    { return _static_getRELATIVE(); }

  public final static int _static_getRELATIVE() throws Exception
    { return java.awt.GridBagConstraints.RELATIVE; }

  public final int getREMAINDER() throws Exception
    { return _static_getREMAINDER(); }

  public final static int _static_getREMAINDER() throws Exception
    { return java.awt.GridBagConstraints.REMAINDER; }

  public final int getNONE() throws Exception
    { return _static_getNONE(); }

  public final static int _static_getNONE() throws Exception
    { return java.awt.GridBagConstraints.NONE; }

  public final int getBOTH() throws Exception
    { return _static_getBOTH(); }

  public final static int _static_getBOTH() throws Exception
    { return java.awt.GridBagConstraints.BOTH; }

  public final int getHORIZONTAL() throws Exception
    { return _static_getHORIZONTAL(); }

  public final static int _static_getHORIZONTAL() throws Exception
    { return java.awt.GridBagConstraints.HORIZONTAL; }

  public final int getVERTICAL() throws Exception
    { return _static_getVERTICAL(); }

  public final static int _static_getVERTICAL() throws Exception
    { return java.awt.GridBagConstraints.VERTICAL; }

  public final int getCENTER() throws Exception
    { return _static_getCENTER(); }

  public final static int _static_getCENTER() throws Exception
    { return java.awt.GridBagConstraints.CENTER; }

  public final int getNORTH() throws Exception
    { return _static_getNORTH(); }

  public final static int _static_getNORTH() throws Exception
    { return java.awt.GridBagConstraints.NORTH; }

  public final int getNORTHEAST() throws Exception
    { return _static_getNORTHEAST(); }

  public final static int _static_getNORTHEAST() throws Exception
    { return java.awt.GridBagConstraints.NORTHEAST; }

  public final int getEAST() throws Exception
    { return _static_getEAST(); }

  public final static int _static_getEAST() throws Exception
    { return java.awt.GridBagConstraints.EAST; }

  public final int getSOUTHEAST() throws Exception
    { return _static_getSOUTHEAST(); }

  public final static int _static_getSOUTHEAST() throws Exception
    { return java.awt.GridBagConstraints.SOUTHEAST; }

  public final int getSOUTH() throws Exception
    { return _static_getSOUTH(); }

  public final static int _static_getSOUTH() throws Exception
    { return java.awt.GridBagConstraints.SOUTH; }

  public final int getSOUTHWEST() throws Exception
    { return _static_getSOUTHWEST(); }

  public final static int _static_getSOUTHWEST() throws Exception
    { return java.awt.GridBagConstraints.SOUTHWEST; }

  public final int getWEST() throws Exception
    { return _static_getWEST(); }

  public final static int _static_getWEST() throws Exception
    { return java.awt.GridBagConstraints.WEST; }

  public final int getNORTHWEST() throws Exception
    { return _static_getNORTHWEST(); }

  public final static int _static_getNORTHWEST() throws Exception
    { return java.awt.GridBagConstraints.NORTHWEST; }


  public int getGridx() throws Exception
    { return _body.gridx; }

  public void setGridx(int arg) throws Exception
    { _body.gridx = arg; }

  public int getGridy() throws Exception
    { return _body.gridy; }

  public void setGridy(int arg) throws Exception
    { _body.gridy = arg; }

  public int getGridwidth() throws Exception
    { return _body.gridwidth; }

  public void setGridwidth(int arg) throws Exception
    { _body.gridwidth = arg; }

  public int getGridheight() throws Exception
    { return _body.gridheight; }

  public void setGridheight(int arg) throws Exception
    { _body.gridheight = arg; }

  public double getWeightx() throws Exception
    { return _body.weightx; }

  public void setWeightx(double arg) throws Exception
    { _body.weightx = arg; }

  public double getWeighty() throws Exception
    { return _body.weighty; }

  public void setWeighty(double arg) throws Exception
    { _body.weighty = arg; }

  public int getAnchor() throws Exception
    { return _body.anchor; }

  public void setAnchor(int arg) throws Exception
    { _body.anchor = arg; }

  public int getFill() throws Exception
    { return _body.fill; }

  public void setFill(int arg) throws Exception
    { _body.fill = arg; }

  public _Insets_if getInsets() throws Exception
    { return new _Insets_cl(_body.insets); }

  public void setInsets(_Insets_if arg) throws Exception
    { _body.insets = ((_Insets_cl)arg)._body; }

  public int getIpadx() throws Exception
    { return _body.ipadx; }

  public void setIpadx(int arg) throws Exception
    { _body.ipadx = arg; }

  public int getIpady() throws Exception
    { return _body.ipady; }

  public void setIpady(int arg) throws Exception
    { _body.ipady = arg; }


  static final java.lang.String  CN = "GridBagConstraints";
  java.awt.GridBagConstraints  _body;


  //================================================== constructors

  _GridBagConstraints_cl(java.awt.GridBagConstraints  gbc)
    throws Exception
  {
    _body = gbc;
  }

  public _GridBagConstraints_cl()
    throws Exception
  {
  }
  

  //======================================== OZ constructor implementation

  public java.lang.Object _new_newGridBagConstraints()
    throws Exception
  {
    _body = new java.awt.GridBagConstraints();
    return this;
  }


  //======================================== OZ method implementation

  public JP.go.ipa.oz.lang._Root_if duplicate() //<clone
    throws Exception
  {
    checkSecureInvocation();
    java.awt.GridBagConstraints  rv_tmp
      = (java.awt.GridBagConstraints)(_body.clone());
    if (rv_tmp == null) return null;
    _GridBagConstraints_if  rv = new _GridBagConstraints_cl(rv_tmp);
    return rv;
  }

}

// EoF
