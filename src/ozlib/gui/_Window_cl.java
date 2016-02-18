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

// OZ Clsss Library (AWT)


package JP.go.ipa.oz.lib.standard;


/**
 * Window implementation
 *
 * @version  $Id: _Window_cl.java,v 1.12 1997/07/04 02:27:10 nito Exp $
 * @see      _Window_if
 * @see      _Container_cl
 */


public class _Window_cl
  extends    JP.go.ipa.oz.lib.standard._Container_cl
  implements JP.go.ipa.oz.lib.standard._Window_if
{

  static final java.lang.String  CN = "Window";


  //================================================== constructors

  _Window_cl(_OzWindow w)
    throws Exception
  {
    _body = w;
  }

  public _Window_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  public java.lang.Object _new_newWindow(_Frame_if parent)
    throws Exception
  {
    java.awt.Frame  arg_parent = (java.awt.Frame)((((_Frame_cl)parent)._body).java());
    _OzWindow w = new _OzWindow(arg_parent);
    w.bind(this);
    _body = w;
    return this;
  }


  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public void addNotify()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Window)_body).addNotify();
  }

  //------------------------------------------------------------------
  public void addWindowListener(_WindowListener_if l) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.event.WindowListener  arg_l = (java.awt.event.WindowListener)(((_WindowListener_cl)l)._body);
    ((java.awt.Window)_body).addWindowListener(arg_l);
  }

  //------------------------------------------------------------------
  public _String_if asString()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Dimension  dim = ((java.awt.Window)_body).getSize();
    java.lang.String  rv_tmp = CN.concat("[size=")
      .concat(java.lang.Integer.toString(dim.width)).concat("x")
      .concat(java.lang.Integer.toString(dim.height)).concat("]");
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public void dispose()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Window)_body).dispose();
  }

  //------------------------------------------------------------------
  public _Component_if getFocusOwner()
    throws Exception
  {
    checkSecureInvocation();
    _OzHoldable  rv_tmp = (_OzHoldable)(((java.awt.Window)_body).getFocusOwner());
    if (rv_tmp == null) return null;
    _Component_if  rv = (_Component_if)(rv_tmp.oz());
    return rv;
  }

  //------------------------------------------------------------------
  public _Locale_if getLocale()
    throws Exception
  {
    checkSecureInvocation();
    java.util.Locale  rv_tmp = (java.util.Locale)(((java.awt.Window)_body).getLocale());
    if (rv_tmp == null) return null;
    return new _Locale_cl(rv_tmp);
  }


  //------------------------------------------------------------------
  public _Toolkit_if getToolkit()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Toolkit  rv_tmp = (java.awt.Toolkit)(((java.awt.Window)_body).getToolkit());
    if (rv_tmp == null) return null;
    return new _Toolkit_cl(rv_tmp);
  }


  //------------------------------------------------------------------
  public final _String_if getWarningString()
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = ((java.awt.Window)_body).getWarningString();
    if (rv_tmp == null) return null;
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public boolean isShowing()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.Window)_body).isShowing();
  }

  //------------------------------------------------------------------
  public void pack()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Window)_body).pack();
  }

  //public boolean postEvent(_Event_if e);  //DEPRECATED ... dispatchEvent

  //------------------------------------------------------------------
  public void removeWindowListener(_WindowListener_if l) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.event.WindowListener  arg_l = ((_WindowListener_cl)l)._body;
    ((java.awt.Window)_body).removeWindowListener(arg_l);
  }

  //------------------------------------------------------------------
  public void show()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Window)_body).show();
  }

  //------------------------------------------------------------------
  public void toBack()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Window)_body).toBack();
  }

  //------------------------------------------------------------------
  public void toFront()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Window)_body).toFront();
  }


  //================================================== protected methods
  //protected void processEvent(_AWTEvent_if e);
  //protected void processWindowEvent(_WindowEvent_if e);


  //================================================== support methods

//  public java.lang.String toString()
//  {
//    return ((_String_cl)asString())._body;
//  }

}

// EoF

