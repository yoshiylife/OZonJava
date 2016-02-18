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
 * FontMetrics implementation
 *
 * @version  $Id: _FontMetrics_cl.java,v 1.11 1997/08/27 06:45:40 nito Exp $
 * @see      _FontMetrics_if
 * @see      _Font_if
 */


public class _FontMetrics_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._FontMetrics_if
{

  final static java.lang.String  CN = "FontMetrics";
  java.awt.FontMetrics  _body;


  //================================================== constructors

  protected _FontMetrics_cl()
    throws Exception
  {
  }

  protected _FontMetrics_cl(java.awt.FontMetrics fm)
    throws Exception
  {
    _body = fm;
  }


  //======================================== OZ constructor implementation

  protected java.lang.Object _new_newFontMetrics()
    throws Exception
  {
    return this;
  }


  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public synchronized _String_if asString() //@
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = CN.concat("[").concat("]");
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public int bytesWidth(_ByteArray_if data, int off, int len)
    throws Exception
  {
    checkSecureInvocation();
    return _body.bytesWidth(((_ByteArray_cl)data)._body, off, len);
  }

  //------------------------------------------------------------------
  public int charWidth(char ch)
    throws Exception
  {
    checkSecureInvocation();
    return _body.charWidth(ch);
  }

  //------------------------------------------------------------------
  public int charWidth(int ch)
    throws Exception
  {
    checkSecureInvocation();
    return _body.charWidth(ch);
  }

  //------------------------------------------------------------------
  public int charsWidth(_CharArray_if data, int off, int len)
    throws Exception
  {
    checkSecureInvocation();
    return _body.charsWidth(((_CharArray_cl)data)._body, off, len);
  }

  //------------------------------------------------------------------
  public int getAscent()
    throws Exception
  {
    checkSecureInvocation();
    return _body.getAscent();
  }

  //------------------------------------------------------------------
  public int getDescent()
    throws Exception
  {
    checkSecureInvocation();
    return _body.getDescent();
  }

  //------------------------------------------------------------------
  public _Font_if getFont()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Font  rv_tmp = _body.getFont();
    _Font_if  rv = new _Font_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public int getHeight()
    throws Exception
  {
    checkSecureInvocation();
    return _body.getHeight();
  }

  //------------------------------------------------------------------
  public int getLeading()
    throws Exception
  {
    checkSecureInvocation();
    return _body.getLeading();
  }

  //------------------------------------------------------------------
  public int getMaxAdvance()
    throws Exception
  {
    checkSecureInvocation();
    return _body.getMaxAdvance();
  }

  //------------------------------------------------------------------
  public int getMaxAscent()
    throws Exception
  {
    checkSecureInvocation();
    return _body.getMaxAscent();
  }

  //public int getMaxDecent(){} //DEPRECATED

  //------------------------------------------------------------------
  public int getMaxDescent()
    throws Exception
  {
    checkSecureInvocation();
    return _body.getMaxDescent();
  }

  //------------------------------------------------------------------
  public _Sequence_if getWidths()
    throws Exception
  {
    checkSecureInvocation();
    int[] tmp_rv = _body.getWidths();
    _Array_if objects = (_Array_if)(new _Array_cl()._new_create(tmp_rv.length, new _WidthComparator_cl()));
    for (int i = 0; i < tmp_rv.length; i++) {
      objects.putAt(i, new _Width_cl(tmp_rv[i]));
    }
    return objects;
  }

  //------------------------------------------------------------------
  public int stringWidth(_String_if str)
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  arg_str = ((_String_cl)str)._body;
    return _body.stringWidth(arg_str);
  }


  //================================================== support methods

//  public java.lang.String toString()
//  {
//    return ((_String_cl)asString())._body;
//  }

}

// EoF
