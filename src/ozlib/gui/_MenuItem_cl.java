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
 * MenuItem implementation
 *
 * @version  $Id: _MenuItem_cl.java,v 1.12 1997/07/04 02:27:09 nito Exp $
 * @see      _MenuItem_if
 * @see      _MenuComponent_cl
 */


public class _MenuItem_cl
  extends    JP.go.ipa.oz.lib.standard._MenuComponent_cl
  implements JP.go.ipa.oz.lib.standard._MenuItem_if
{

  static final java.lang.String  CN = "MenuItem";


  //================================================== constructors

  _MenuItem_cl(_OzMenuItem mi)
    throws Exception
  {
    _body = mi;
  }

  public _MenuItem_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  //------------------------------------------------------------------
  public java.lang.Object _new_newMenuItem()
    throws Exception
  {
    _OzMenuItem  mi = new _OzMenuItem();
    mi.bind(this);
    _body = mi;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newMenuItem(_String_if label)
    throws Exception
  {
    java.lang.String  arg_label = ((_String_cl)label)._body;
    _OzMenuItem  mi = new _OzMenuItem(arg_label);
    mi.bind(this);
    _body = mi;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newMenuItem(_String_if label, _MenuShortcut_if s)
    throws Exception
  {
    java.lang.String  arg_label = ((_String_cl)label)._body;
    java.awt.MenuShortcut  arg_s = ((_MenuShortcut_cl)s)._body;
    _OzMenuItem  mi = new _OzMenuItem(arg_label, arg_s);
    mi.bind(this);
    _body = mi;
    return this;
  }


  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public void addActionListener(_ActionListener_if l) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.event.ActionListener  arg_l
      = (java.awt.event.ActionListener)(((_ActionListener_cl)l)._body);
    ((java.awt.MenuItem)_body).addActionListener(arg_l);
  }

  //------------------------------------------------------------------
  public void addNotify()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.MenuItem)_body).addNotify();
  }

  //------------------------------------------------------------------
  public _String_if asString() //@
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = CN.concat("[label=")
      .concat(((java.awt.MenuItem)_body).getLabel()).concat("]");
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public void deleteShortcut()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.MenuItem)_body).deleteShortcut();
  }

  //public void disable(){}  // synchronized  //DEPRECATED
  //public void enable(){}  // synchronized  //DEPRECATED
  //public void enable(boolean b){}  //DEPRECATED

  //------------------------------------------------------------------
  public boolean isEnabled()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.MenuItem)_body).isEnabled();
  }

  //------------------------------------------------------------------
  public _String_if getActionCommand()
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = ((java.awt.MenuItem)_body).getActionCommand();
    if (rv_tmp == null) return null;
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _String_if getLabel()
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = ((java.awt.MenuItem)_body).getLabel();
    if (rv_tmp == null) return null;
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _MenuShortcut_if getShortcut()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.MenuShortcut  rv_tmp = ((java.awt.MenuItem)_body).getShortcut();
    if (rv_tmp == null) return null;
    _MenuShortcut_if  rv = new _MenuShortcut_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _String_if paramString()
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = ((java.awt.MenuItem)_body).paramString();
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public void removeActionListener(_ActionListener_if l)  //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.event.ActionListener  arg_l = ((_ActionListener_cl)l)._body;
    ((java.awt.MenuItem)_body).removeActionListener(arg_l);
  }

  //------------------------------------------------------------------
  public void setActionCommand(_String_if command)
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  arg_command = ((_String_cl)command)._body;
    ((java.awt.MenuItem)_body).setActionCommand(arg_command);
  }

  //------------------------------------------------------------------
  public void setEnabled(boolean b)  //synchronized
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.MenuItem)_body).setEnabled(b);
  }

  //------------------------------------------------------------------
  public void setLabel(_String_if label)  //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  arg_label = ((_String_cl)label)._body;
    ((java.awt.MenuItem)_body).setLabel(arg_label);
  }

  //------------------------------------------------------------------
  public void setShortcut(_MenuShortcut_if s)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.MenuShortcut  arg_s = ((_MenuShortcut_cl)s)._body;
    ((java.awt.MenuItem)_body).setShortcut(arg_s);
  }


  //================================================== protected methods
  //protected final void disableEvents(long eventsToDisable)
  //protected final void enableEvents(long eventsToEnable)
  //protected void processActionEvent(_ActionEvent_if e)
  //protected void processEvent(_AWTEvent_if e)


  //================================================== support methods

//  public java.lang.String toString()
//  {
//    return ((java.awt.MenuComponent)_body).toString();
//  }

}

// EoF

