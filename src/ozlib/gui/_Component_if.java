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
 * Component interface
 *
 * @version  $Id: _Component_if.java,v 1.10 1997/08/20 05:18:52 nito Exp $
 * @see      _MenuContainer_if
 * @see      _ImageObserver_if
 * @see      _Component_cl
 */


public interface _Component_if
  extends JP.go.ipa.oz.lib.standard._MenuContainer_if,
          JP.go.ipa.oz.lib.standard._ImageObserver_if
{

  //================================================== OZ methods
  public void add(_PopupMenu_if popup) throws Exception;  //synchronized
  public void addComponentListener(_ComponentListener_if l) throws Exception; //synchronized
  public void addFocusListener(_FocusListener_if l) throws Exception; //synchronized
  public void addKeyListener(_KeyListener_if l) throws Exception; //synchronized
  public void addMouseListener(_MouseListener_if l) throws Exception; //synchronized
  public void addMouseMotionListener(_MouseMotionListener_if l) throws Exception; //synchronized
  public void addNotify() throws Exception;
  public int checkImage(_Image_if image, _ImageObserver_if observer) throws Exception;
  public int checkImage(_Image_if image, int width, int height, _ImageObserver_if observer) throws Exception;
  public boolean contains(int x, int y) throws Exception;
  public boolean contains(_Point_if p) throws Exception;
  //*public _Image_if createImage(_ImageProducer_ producer) throws Exception;
  //*public _Image_if createImage(int width, int height) throws Exception;
  public void dispatchEvent(_AWTEvent_if e) throws Exception;  //final
  public void doLayout() throws Exception;
  public boolean isEnabled() throws Exception;
  public boolean isFocusTraversable() throws Exception;
  public boolean isShowing() throws Exception;
  public boolean isValid() throws Exception;
  public boolean isVisible() throws Exception;
  public float getAlignmentX() throws Exception;
  public float getAlignmentY() throws Exception;
  public _Color_if getBackground() throws Exception;
  public _Rectangle_if getBounds() throws Exception;
  //*public _ColorModel_if getColorModel() throws Exception;
  public _Component_if getComponentAt(int x, int y) throws Exception;
  public _Component_if getComponentAt(_Point_if p) throws Exception;
  public _Cursor_if getCursor() throws Exception;
  public _Font_if getFont() throws Exception;
  //*public _FontMetrics_if getFontMetrics(_Font_if font) throws Exception;
  public _Color_if getForeground() throws Exception;
  //*public _Graphics_if getGraphics() throws Exception;
  public _Locale_if getLocale()  throws Exception;
  public _Point_if getLocation() throws Exception;
  public _Point_if getLocationOnScreen() throws Exception;
  public _Dimension_if getMaximumSize() throws Exception;
  public _Dimension_if getMinimumSize() throws Exception;
  public _String_if getName() throws Exception;
  public _Container_if getParent() throws Exception;
  public _Dimension_if getPreferredSize() throws Exception;
  public _Dimension_if getSize() throws Exception;
  //*public JP.go.ipa.oz.lang._Root_if getTreeLock() throws Exception;  //final
  public boolean imageUpdate(_Image_if img, int flags, int x, int y, int w, int h) throws Exception;
  public void invalidate() throws Exception;
  public void list() throws Exception;
  //*public void list(_PrintStream_if out) throws Exception;
  //*public void list(_PrintStream_if out, int indent) throws Exception;
  public void list(_PrintWriter_if out) throws Exception;
  public void list(_PrintWriter_if out, int indent) throws Exception;
  public void paint(_Graphics_if g) throws Exception;
  public void paintAll(_Graphics_if g) throws Exception;
  public boolean postEvent(_Event_if e) throws Exception; //DEPRECATED //MenuContainer interface compatibility ONLY
  public boolean prepareImage(_Image_if image, _ImageObserver_if observer) throws Exception;
  public boolean prepareImage(_Image_if image, int width, int height, _ImageObserver_if observer) throws Exception;
  public void print(_Graphics_if g) throws Exception;
  public void printAll(_Graphics_if g) throws Exception;
  public void remove(_MenuComponent_if popup) throws Exception; //synchronized
  public void removeComponentListener(_ComponentListener_if l) throws Exception; //synchronized
  public void removeFocusListener(_FocusListener_if l) throws Exception; //synchronized
  public void removeKeyListener(_KeyListener_if l) throws Exception; //synchronized
  public void removeMouseListener(_MouseListener_if l) throws Exception; //synchronized
  public void removeMouseMotionListener(_MouseMotionListener_if l) throws Exception; //synchronized
  public void removeNotify() throws Exception;
  public void repaint() throws Exception;
  public void repaint(long tm) throws Exception;
  public void repaint(int x, int y, int width, int height) throws Exception;
  public void repaint(long tm, int x, int y, int width, int height) throws Exception;
  public void requestFocus() throws Exception;
  public void setBackground(_Color_if c) throws Exception;
  public void setBounds(int x, int y, int width, int height) throws Exception;
  public void setBounds(_Rectangle_if r) throws Exception;
  public void setCursor(_Cursor_if cursor) throws Exception;  //synchronized
  public void setEnabled(boolean b) throws Exception;
  public void setFont(_Font_if f) throws Exception;  //synchronized
  public void setForeground(_Color_if c) throws Exception;
  public void setLocale(_Locale_if l) throws Exception;
  public void setLocation(int x, int y) throws Exception;
  public void setLocation(_Point_if p) throws Exception;
  public void setName(_String_if name) throws Exception;
  public void setSize(int width, int height) throws Exception;
  public void setSize(_Dimension_if d) throws Exception;
  public void setVisible(boolean b) throws Exception;
  public void transferFocus() throws Exception;
  public void update(_Graphics_if g) throws Exception;
  public void validate() throws Exception;
  public _Toolkit_if getToolkit() throws Exception;

  public void dispatch(JP.go.ipa.oz.lib.standard._Graphics_if g, int t) throws Exception;
  //================================================== supported methods
//  public java.lang.String toString();

}

// EoF

