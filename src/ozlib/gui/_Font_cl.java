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
 * Font implementation
 *
 * @version  $Id: _Font_cl.java,v 1.12 1997/07/04 02:27:08 nito Exp $
 * @see      _Font_if
 */


public class _Font_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._Font_if
{

  public final int getPLAIN() throws Exception
    { return _static_getPLAIN(); }

  public static final int _static_getPLAIN() throws Exception
    { return java.awt.Font.PLAIN; }

  public final int getBOLD() throws Exception
    { return _static_getBOLD(); }

  public static final int _static_getBOLD() throws Exception
    { return java.awt.Font.BOLD; }

  public final int getITALIC() throws Exception
    { return _static_getITALIC(); }

  public static final int _static_getITALIC() throws Exception
    { return java.awt.Font.ITALIC; }


  static final java.lang.String  CN = "Font";
  java.awt.Font  _body;


  //================================================== constructors

  _Font_cl(java.awt.Font f)
    throws Exception
  {
    _body = f;
  }

  public _Font_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  //------------------------------------------------------------------
  public java.lang.Object _new_newFont(_String_if name, int size)
    throws Exception
  {
    java.lang.String  arg_name = ((_String_cl)name)._body;
    _body = new java.awt.Font(arg_name, java.awt.Font.PLAIN, size);
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newFontAsBold(_String_if name, int size)
    throws Exception
  {
    java.lang.String  arg_name = ((_String_cl)name)._body;
    _body = new java.awt.Font(arg_name, java.awt.Font.BOLD, size);
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newFontAsItalic(_String_if name, int size)
    throws Exception
  {
    java.lang.String  arg_name = ((_String_cl)name)._body;
    _body = new java.awt.Font(arg_name, java.awt.Font.ITALIC, size);
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newFontAsBoldItalic(_String_if name, int size)
    throws Exception
  {
    java.lang.String  arg_name = ((_String_cl)name)._body;
    _body = new java.awt.Font(arg_name, java.awt.Font.BOLD + java.awt.Font.ITALIC, size);
    return this;
  }


  //======================================== OZ method implementation

  /**------------------------------------------------------------------
   */
  public _String_if asString() //@
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp
      = CN.concat("[family=").concat(_body.getFamily())
      .concat(",name=").concat(_body.getName())
      .concat(",style=").concat(getStyleString())
      .concat(",size=").concat(java.lang.Integer.toString(getSize()))
      .concat("]");
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _Font_if decode(_String_if str) //static
    throws Exception
  {
    checkSecureInvocation();
    return _static_decode(str);
  }

  public static _Font_if _static_decode(_String_if str)
    throws Exception
  {
    java.lang.String  arg_str = ((_String_cl)str)._body;
    java.awt.Font  tmp = java.awt.Font.decode(arg_str);
    if (tmp == null) return null;
    _Font_cl  rv = new _Font_cl(tmp);
    return rv;
  }

  //public boolean equals(JP.go.ipa.oz.system._Root_if obj){}  //final in Root

  //------------------------------------------------------------------
  public _String_if getFamily()
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = _body.getFamily();
    if (rv_tmp == null) return null;
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _Font_if getFont(_String_if nm) //static
    throws Exception
  {
    checkSecureInvocation();
    return _static_getFont(nm);
  }

  public static _Font_if _static_getFont(_String_if nm)
    throws Exception
  {
    java.lang.String  arg_nm = ((_String_cl)nm)._body;
    java.awt.Font  rv_tmp = java.awt.Font.getFont(arg_nm);
    if (rv_tmp == null) return null;
    _Font_cl  rv = new _Font_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _Font_if getFont(_String_if nm, _Font_if font) //static
    throws Exception
  {
    checkSecureInvocation();
    return _static_getFont(nm, font);
  }

  public static _Font_if _static_getFont(_String_if nm, _Font_if font)
    throws Exception
  {
    java.lang.String  arg_nm = ((_String_cl)nm)._body;
    java.awt.Font  arg_font = ((_Font_cl)font)._body;
    java.awt.Font  rv_tmp = java.awt.Font.getFont(arg_nm, arg_font);
    if (rv_tmp == null) return null;
    _Font_cl  rv = new _Font_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _String_if getName()
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = _body.getName();
    if (rv_tmp == null) return null;
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }
  
  //------------------------------------------------------------------
  //*public _FontPeer_if getPeer() {}

  //------------------------------------------------------------------
  public int getSize()
    throws Exception
  {
    checkSecureInvocation();
    return _body.getSize();
  }

  //public int getStyle() {} //@

  /**------------------------------------------------------------------
   * Return the style as a string.
   * Java Font#getStyle returns static integer to indicate the style.
   */
  java.lang.String getStyleString() //@
    throws Exception
  {
    checkSecureInvocation();
    switch (_body.getStyle()) {
    case java.awt.Font.PLAIN:
      return "plain";
    case java.awt.Font.BOLD:
      return "bold";
    case java.awt.Font.ITALIC:
      return "italic";
    case java.awt.Font.BOLD + java.awt.Font.ITALIC:
      return "bolditalic";
    }

    return "unknown";
  }

  /**------------------------------------------------------------------
   */
/*
  public int hashCode()
    throws Exception
  {
    return _body.hashCode();
  }
*/

  //------------------------------------------------------------------
  public boolean isBold()
    throws Exception
  {
    checkSecureInvocation();
    return _body.isBold();
  }

  //------------------------------------------------------------------
  public boolean isItalic()
    throws Exception
  {
    checkSecureInvocation();
    return _body.isItalic();
  }

  //------------------------------------------------------------------
  public boolean isPlain()
    throws Exception
  {
    checkSecureInvocation();
    return _body.isPlain();
  }


  //================================================== support methods
//  public java.lang.String toString()
//  {
//    return ((_String_cl)asString())._body;
//  }

}

// EoF
