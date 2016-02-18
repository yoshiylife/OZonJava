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
 * Component implementation
 *
 * @version  $Id: _Component_cl.java,v 1.15 1997/08/20 05:18:52 nito Exp $
 * @see      _Component_if
 */


public abstract class _Component_cl
// extends    JP.go.ipa.oz.lang._Root_cl
 extends _ImageObserver_cl
 implements JP.go.ipa.oz.lib.standard._Component_if
{

  final static java.lang.String  CN = "Component";
  _OzHoldable  _body;

  //================================================== constructors

  protected _Component_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  protected java.lang.Object _new_newComponent()
    throws Exception
  {
    return this;
  }


  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public void add(_PopupMenu_if popup)  //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.PopupMenu  arg_popup = (java.awt.PopupMenu)(((_PopupMenu_cl)popup)._body);
    ((java.awt.Component)_body).add(arg_popup);
  }

  //------------------------------------------------------------------
  public void addComponentListener(_ComponentListener_if l) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.event.ComponentListener  arg_l = (java.awt.event.ComponentListener)(((_ComponentListener_cl)l)._body);
    ((java.awt.Component)_body).addComponentListener(arg_l);
  }

  //------------------------------------------------------------------
  public void addFocusListener(_FocusListener_if l) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.event.FocusListener  arg_l = (java.awt.event.FocusListener)(((_FocusListener_cl)l)._body);
    ((java.awt.Component)_body).addFocusListener(arg_l);
  }

  //------------------------------------------------------------------
  public void addKeyListener(_KeyListener_if l) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.event.KeyListener  arg_l = (java.awt.event.KeyListener)(((_KeyListener_cl)l)._body);
    ((java.awt.Component)_body).addKeyListener(arg_l);
  }

  //------------------------------------------------------------------
  public void addMouseListener(_MouseListener_if l) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.event.MouseListener  arg_l = (java.awt.event.MouseListener)(((_MouseListener_cl)l)._body);
    ((java.awt.Component)_body).addMouseListener(arg_l);
  }

  //------------------------------------------------------------------
  public void addMouseMotionListener(_MouseMotionListener_if l) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.event.MouseMotionListener  arg_l = (java.awt.event.MouseMotionListener)(((_MouseMotionListener_cl)l)._body);
    ((java.awt.Component)_body).addMouseMotionListener(arg_l);
  }

  //------------------------------------------------------------------
  public void addNotify()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Component)_body).addNotify();
  }

  public int checkImage(_Image_if image, _ImageObserver_if observer)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Image  arg_1 = (java.awt.Image)(((_Image_cl)image)._body);
    java.awt.image.ImageObserver  arg_2 = (java.awt.image.ImageObserver)(((_ImageObserver_cl)observer)._body);
    return ((java.awt.Component)_body).checkImage(arg_1, arg_2);
  }

  public int checkImage(_Image_if image, int width, int height, _ImageObserver_if observer)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Image  arg_1 = (java.awt.Image)(((_Image_cl)image)._body);
    java.awt.image.ImageObserver  arg_2 = (java.awt.image.ImageObserver)(((_ImageObserver_cl)observer)._body);
    return ((java.awt.Component)_body).checkImage(arg_1, width, height, arg_2);
  }


  //------------------------------------------------------------------
  public boolean contains(int x, int y)
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.Component)_body).contains(x, y);
  }

  //------------------------------------------------------------------
  public boolean contains(_Point_if p)
    throws Exception
  {
    java.awt.Point  arg_p = ((_Point_cl)p)._body;
    return ((java.awt.Component)_body).contains(arg_p);
  }

  //*public _Image_if createImage(_ImageProducer_ producer);
  //*public _Image_if createImage(int width, int height);

  //------------------------------------------------------------------
  public void dispatchEvent(_AWTEvent_if e)  //final
    throws Exception
  {
    checkSecureInvocation();
    java.awt.AWTEvent  arg_e = (java.awt.AWTEvent)(((_AWTEvent_cl)e)._body);
    ((java.awt.Component)_body).dispatchEvent(arg_e);
  }

  //------------------------------------------------------------------
  public void doLayout()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Component)_body).doLayout();
  }

  //------------------------------------------------------------------
  public boolean isEnabled()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.Component)_body).isEnabled();
  }
    
  //------------------------------------------------------------------
  public boolean isFocusTraversable()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.Component)_body).isFocusTraversable();
  }
    
  //------------------------------------------------------------------
  public boolean isShowing()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.Component)_body).isShowing();
  }

  //------------------------------------------------------------------
  public boolean isValid()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.Component)_body).isValid();
  }

  //------------------------------------------------------------------
  public boolean isVisible()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.Component)_body).isVisible();
  }

  //------------------------------------------------------------------
  public float getAlignmentX()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.Component)_body).getAlignmentX();
  }

  //------------------------------------------------------------------
  public float getAlignmentY()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.Component)_body).getAlignmentY();
  }

  //------------------------------------------------------------------
  public _Color_if getBackground()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Color  rv_tmp = ((java.awt.Component)_body).getBackground();
    if (rv_tmp == null) return null;
    _Color_cl  rv = new _Color_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _Rectangle_if getBounds()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Rectangle  rv_tmp = ((java.awt.Component)_body).getBounds();
    if (rv_tmp == null) return null;
    _Rectangle_cl  rv = new _Rectangle_cl(rv_tmp);
    return rv;
  }

  // The default ColorModel should be instantiated and
  // set to this component in the constructor !!!
  /*
  public _ColorModel_if getColorModel()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.image.ColorModel  rv_tmp = ((java.awt.Component)_body).getColorModel();
    if (rv_tmp == null) return null;
    _ColorModel_cl  rv = new _ColorModel_cl(rv_tmp);
    return rv;
  }
  */

  //------------------------------------------------------------------
  public _Component_if getComponentAt(int x, int y)
    throws Exception
  {
    checkSecureInvocation();
    _OzHoldable  rv_tmp = (_OzHoldable)(((java.awt.Component)_body).getComponentAt(x, y));
    if (rv_tmp == null) return null;
    _Component_if  rv = (_Component_if)(rv_tmp.oz());
    return rv;
  }

  //------------------------------------------------------------------
  public _Component_if getComponentAt(_Point_if p)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Point  arg_p = ((_Point_cl)p)._body;
    _OzHoldable  rv_tmp = (_OzHoldable)(((java.awt.Component)_body).getComponentAt(arg_p));
    if (rv_tmp == null) return null;
    _Component_if  rv = (_Component_if)(rv_tmp.oz());
    return rv;
  }

  //------------------------------------------------------------------
  public _Cursor_if getCursor()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Cursor  rv_tmp = ((java.awt.Component)_body).getCursor();
    if (rv_tmp == null) return null;
    _Cursor_if  rv = new _Cursor_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _Font_if getFont()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Font  rv_tmp = ((java.awt.Component)_body).getFont();
    if (rv_tmp == null) return null;
    _Font_if  rv = new _Font_cl(rv_tmp);
    return rv;
  }

  // The default FontMetrics should be instantiated and
  // set to this component in the constructor !!!
  /*
  public _FontMetrics_if getFontMetrics(_Font_if font)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Font  arg_font = ((_Font_cl)font)._body;
    java.awt.FontMetrics  rv_tmp = ((java.awt.Component)_body).getFontMetrics(arg_font);
    if (rv_tmp == null) return null;
    _FontMetrics_cl  rv = new _FontMetrics_cl(rv_tmp);
    return rv;
  }
  */

  //------------------------------------------------------------------
  public _Color_if getForeground()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Color  rv_tmp = ((java.awt.Component)_body).getForeground();
    if (rv_tmp == null) return null;
    _Color_cl  rv = new _Color_cl(rv_tmp);
    return rv;
  }

  /*
   *public _Graphics_if getGraphics()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Graphics  rv_tmp = ((java.awt.Component)_body).getGraphics();
    if (rv_tmp == null) return null;
    _Graphics_cl  rv = new _Graphics_cl(rv_tmp);
    return rv;
  }
  */

  public _Locale_if getLocale()
    throws Exception
  {
    checkSecureInvocation();
    java.util.Locale  rv_tmp = ((java.awt.Component)_body).getLocale();
    if (rv_tmp == null) return null;
    _Locale_cl  rv = new _Locale_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _Point_if getLocation()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Point  rv_tmp = ((java.awt.Component)_body).getLocation();
    if (rv_tmp == null) return null;
    _Point_cl  rv = new _Point_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _Point_if getLocationOnScreen()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Point  rv_tmp = ((java.awt.Component)_body).getLocationOnScreen();
    if (rv_tmp == null) return null;
    _Point_cl  rv = new _Point_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _Dimension_if getMaximumSize()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Dimension  rv_tmp = ((java.awt.Component)_body).getMaximumSize();
    if (rv_tmp == null) return null;
    _Dimension_cl  rv = new _Dimension_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _Dimension_if getMinimumSize()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Dimension  rv_tmp = ((java.awt.Component)_body).getMinimumSize();
    if (rv_tmp == null) return null;
    _Dimension_cl  rv = new _Dimension_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _String_if getName()
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = ((java.awt.Component)_body).getName();
    if (rv_tmp == null) return null;
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _Container_if getParent()
    throws Exception
  {
    checkSecureInvocation();
    _OzHoldable  rv_tmp = (_OzHoldable)(((java.awt.Component)_body).getParent());
    if (rv_tmp == null) return null;
    _Container_if  rv = (_Container_if)(rv_tmp.oz());
    return rv;
  }

  //------------------------------------------------------------------
  public _Dimension_if getPreferredSize()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Dimension  rv_tmp = ((java.awt.Component)_body).getPreferredSize();
    if (rv_tmp == null) return null;
    _Dimension_cl  rv = new _Dimension_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _Dimension_if getSize()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Dimension  rv_tmp = ((java.awt.Component)_body).getSize();
    if (rv_tmp == null) return null;
    _Dimension_cl  rv = new _Dimension_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _Toolkit_if getToolkit()
    throws Exception
  {
    _Toolkit_if  rv
	= new _Toolkit_cl(((java.awt.Component)_body).getToolkit());
    return rv;
  }

  //------------------------------------------------------------------
  /*
   *public final JP.go.ipa.oz.lang._Root_if getTreeLock()
    throws Exception
  {
    checkSecureInvocation();
  }
  */

  //------------------------------------------------------------------
  public boolean imageUpdate(_Image_if img, int flags, int x, int y, int w, int h)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Image  arg_img = ((_Image_cl)img)._body;
    return ((java.awt.Component)_body).imageUpdate(arg_img, flags, x, y, w, h);
  }

  //------------------------------------------------------------------
  public void invalidate()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Component)_body).invalidate();
  }

  //------------------------------------------------------------------
  public void list()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Component)_body).list();
  }
    
  //*public void list(_PrintStream_if out);
  //*public void list(_PrintStream_if out, int indent);
  public void list(_PrintWriter_if out)
    throws Exception
  {
    checkSecureInvocation();
    java.io.PrintWriter  arg_g = (java.io.PrintWriter)(((_PrintWriter_cl)out)._body);
    ((java.awt.Component)_body).list(arg_g);
  }

  public void list(_PrintWriter_if out, int indent)
    throws Exception
  {
    checkSecureInvocation();
    java.io.PrintWriter  arg_g = (java.io.PrintWriter)(((_PrintWriter_cl)out)._body);
    ((java.awt.Component)_body).list(arg_g, indent);
  }

/*****
  public void paint(_Graphics_if g)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Graphics  arg_g = ((_Graphics_cl)g)._body;
    ((java.awt.Component)_body).paint(arg_g);
  }
*****/

  public void paintAll(_Graphics_if g)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Graphics  arg_g = ((_Graphics_cl)g)._body;
    ((java.awt.Component)_body).paintAll(arg_g);
  }

  //------------------------------------------------------------------
  public boolean postEvent(_Event_if e) //DEPRECATED //MenuContainer interface compatibility ONLY
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Event  arg_e = ((_Event_cl)e)._body;
    return ((java.awt.Component)_body).postEvent(arg_e);
  }

  public boolean prepareImage(_Image_if image, _ImageObserver_if observer)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Image  arg_1 = (java.awt.Image)(((_Image_cl)image)._body);
    java.awt.image.ImageObserver  arg_2 = (java.awt.image.ImageObserver)(((_ImageObserver_cl)observer)._body);
    return ((java.awt.Component)_body).prepareImage(arg_1, arg_2);
  }

  public boolean prepareImage(_Image_if image, int width, int height, _ImageObserver_if observer)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Image  arg_1 = (java.awt.Image)(((_Image_cl)image)._body);
    java.awt.image.ImageObserver  arg_2 = (java.awt.image.ImageObserver)(((_ImageObserver_cl)observer)._body);
    return ((java.awt.Component)_body).prepareImage(arg_1, width, height, arg_2);
  }


  public void print(_Graphics_if g)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Graphics  arg_g = ((_Graphics_cl)g)._body;
    ((java.awt.Component)_body).print(arg_g);
  }

  public void printAll(_Graphics_if g)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Graphics  arg_g = ((_Graphics_cl)g)._body;
    ((java.awt.Component)_body).printAll(arg_g);
  }

  //------------------------------------------------------------------
  public void remove(_MenuComponent_if popup) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.MenuComponent  arg_popup = (java.awt.MenuComponent)(((_MenuComponent_cl)popup)._body);
    ((java.awt.Component)_body).remove(arg_popup);
  }

  //------------------------------------------------------------------
  public void removeComponentListener(_ComponentListener_if l) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.event.ComponentListener  arg_l = ((_ComponentListener_cl)l)._body;
    ((java.awt.Component)_body).removeComponentListener(arg_l);
  }

  //------------------------------------------------------------------
  public void removeFocusListener(_FocusListener_if l) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.event.FocusListener  arg_l = ((_FocusListener_cl)l)._body;
    ((java.awt.Component)_body).removeFocusListener(arg_l);
  }

  //------------------------------------------------------------------
  public void removeKeyListener(_KeyListener_if l) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.event.KeyListener  arg_l = ((_KeyListener_cl)l)._body;
    ((java.awt.Component)_body).removeKeyListener(arg_l);
  }

  //------------------------------------------------------------------
  public void removeMouseListener(_MouseListener_if l) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.event.MouseListener  arg_l = ((_MouseListener_cl)l)._body;
    ((java.awt.Component)_body).removeMouseListener(arg_l);
  }

  //------------------------------------------------------------------
  public void removeMouseMotionListener(_MouseMotionListener_if l) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.event.MouseMotionListener  arg_l = ((_MouseMotionListener_cl)l)._body;
    ((java.awt.Component)_body).removeMouseMotionListener(arg_l);
  }

  //------------------------------------------------------------------
  public void removeNotify()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Component)_body).removeNotify();
  }

  //------------------------------------------------------------------
  public void repaint()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Component)_body).repaint();
  }

  //------------------------------------------------------------------
  public void repaint(long tm)
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Component)_body).repaint(tm);
  }

  //------------------------------------------------------------------
  public void repaint(int x, int y, int width, int height)
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Component)_body).repaint(x, y, width, height);
  }

  //------------------------------------------------------------------
  public void repaint(long tm, int x, int y, int width, int height)
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Component)_body).repaint(tm, x, y, width, height);
  }

  //------------------------------------------------------------------
  public void requestFocus()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Component)_body).requestFocus();
  }

  //------------------------------------------------------------------
  public void setBackground(_Color_if c)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Color  arg_c = ((_Color_cl)c)._body;
    ((java.awt.Component)_body).setBackground(arg_c);
  }

  //------------------------------------------------------------------
  public void setBounds(int x, int y, int width, int height)
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Component)_body).setBounds(x, y, width, height);
  }

  //------------------------------------------------------------------
  public void setBounds(_Rectangle_if r)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Rectangle  arg_r = ((_Rectangle_cl)r)._body;
    ((java.awt.Component)_body).setBounds(arg_r);
  }

  //------------------------------------------------------------------
  public void setCursor(_Cursor_if cursor)  //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Cursor  arg_cursor = ((_Cursor_cl)cursor)._body;
    ((java.awt.Component)_body).setCursor(arg_cursor);
  }

  //------------------------------------------------------------------
  public void setEnabled(boolean b)
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Component)_body).setEnabled(b);
  }

  //------------------------------------------------------------------
  public void setFont(_Font_if f)  //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Font  arg_f = ((_Font_cl)f)._body;
    ((java.awt.Component)_body).setFont(arg_f);
  }

  //------------------------------------------------------------------
  public void setForeground(_Color_if c)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Color  arg_c = ((_Color_cl)c)._body;
    ((java.awt.Component)_body).setForeground(arg_c);
  }

  public void setLocale(_Locale_if l)
    throws Exception
  {
    checkSecureInvocation();
    java.util.Locale  arg_l = ((_Locale_cl)l)._body;
    ((java.awt.Component)_body).setLocale(arg_l);
  }

  //------------------------------------------------------------------
  public void setLocation(int x, int y)
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Component)_body).setLocation(x, y);
  }

  //------------------------------------------------------------------
  public void setLocation(_Point_if p)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Point  arg_p = ((_Point_cl)p)._body;
    ((java.awt.Component)_body).setLocation(arg_p);
  }

  //------------------------------------------------------------------
  public void setName(_String_if label)
    throws Exception
  {
    checkSecureInvocation();
    String  arg_label = ((_String_cl)label)._body;
    ((java.awt.Component)_body).setName(arg_label);
  }

  //------------------------------------------------------------------
  public void setSize(int width, int height)
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Component)_body).setSize(width, height);
  }

  //------------------------------------------------------------------
  public void setSize(_Dimension_if d)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Dimension  arg_d = ((_Dimension_cl)d)._body;
    ((java.awt.Component)_body).setSize(arg_d);
  }

  //------------------------------------------------------------------
  public void setVisible(boolean b)
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Component)_body).setVisible(b);
  }

  //------------------------------------------------------------------
  public void transferFocus()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Component)_body).transferFocus();
  }

/*****
  public void update(_Graphics_if g)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Graphics  arg_g = ((_Graphics_cl)g)._body;
    ((java.awt.Component)_body).update(arg_g);
  }
****/

  //------------------------------------------------------------------
  public void validate()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Component)_body).validate();
  }  


  //================================================== protected methods
  //protected final void disableEvents(long eventsToDisable){}
  //protected final void enableEvents(long eventsToEnable){}
  //protected _String_if paramString()
  //protected void processEvent(_AWTEvent_ e){}
  //protected void processComponentEvent(_ComponentEvent_if e){}
  //protected void processFocusEvent(_FocusEvent_if e){}
  //protected void processKeyEvent(_KeyEvent_if e){}
  //protected void processMouseEvent(_MouseEvent_if e){}
  //protected void processMouseMotionEvent(_MouseEvent_if e){}

  public void paint(_Graphics_if g) throws Exception
  {
    // define with subclassing.
  }

  public void update(_Graphics_if g) throws Exception
  {
    // define with subclassing.
  }

  public void dispatch(_Graphics_if g, int type) throws Exception
  {
    // define with subclassing.
  }


  //================================================== support methods

//  public java.lang.String toString()
//  {
//    return ((_String_cl)asString())._body;
//  }


}

// EoF

