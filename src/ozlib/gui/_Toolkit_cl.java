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
 * Toolkit implementation
 *
 * @version  $Id: _Toolkit_cl.java,v 1.5 1997/07/04 02:27:10 nito Exp $
 * @see      _Toolkit_if
 */


public class _Toolkit_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._Toolkit_if
{

  static final java.lang.String  CN = "Toolkit";
  java.awt.Toolkit  _body;


  //================================================== constructors

  _Toolkit_cl(java.awt.Toolkit t)
    throws Exception
  {
    _body = t;
  }

  public _Toolkit_cl()
    throws Exception
  {
  }


  //================================================== OZ constructors

  public java.lang.Object _new_newToolkit()
    throws Exception
  {
    _body = java.awt.Toolkit.getDefaultToolkit();
    return this;
  }


  //================================================== OZ public methods

  //------------------------------------------------------------------
  public void beep()
    throws Exception
  {
    _body.beep();
  }

  //------------------------------------------------------------------
  public int checkImage(_Image_if image, int width, int height,
			_ImageObserver_if observer)
    throws Exception
  {
    java.awt.Image  arg_image = ((_Image_cl)image)._body;

    //** it is assumed that Component class is only the one
    // that implements ImageObserver interface.
    java.awt.image.ImageObserver  arg_observer =
      (java.awt.image.ImageObserver)(((_Component_cl)observer)._body);

    return _body.checkImage(arg_image, width, height, arg_observer);
  }

  //------------------------------------------------------------------
  /*
  public _Image_if createImage(_ImageProducer_if producer)
    throws Exception
  {
    _body.createImage(arg_producer);
  }
  */

  //------------------------------------------------------------------
  /*
  public _Image_if createImage(_ByteArray_if imagedata)
    throws Exception
  {
    _body.createImage(imagedata._body);
  }
  */

  //------------------------------------------------------------------
  /*
  public _Image_if createImage(_ByteArray_if imagedata, int imageoffset,
                               int imagelength)
    throws Exception
  {
    java.awt.Image  rv_tmp = _body.createImage(imagedata._body, imageoffset, imagelength);
  }
  */

  //------------------------------------------------------------------
  /*
  public _ColorModel_if getColorModel()
    throws Exception
  {
    java.awt.ColorModel  rv_tmp = _body.getColorModel();
  }
  */

  //@public _Toolkit_if getDefaultToolkit()  //static //synchronized

  //------------------------------------------------------------------
  public _Collection_if getFontList()
    throws Exception
  {
    java.lang.String[]  rv_tmp = _body.getFontList();
    _Array_if rv = null;
    if (rv_tmp != null) {
      rv = (_Array_if)new _Array_cl()._new_create(rv_tmp.length, new _StringComparator_cl());
      for (int i = 0; i < rv_tmp.length; i++) {
        rv.putAt(i, new _String_cl(rv_tmp[i]));
      }
    }
    return rv;
  }

  //------------------------------------------------------------------
  /*
  public _FontMetrics_if getFontMetrics(_Font_if font)
    throws Exception
  {
    java.awt.Font  arg_font = ((_Font_cl)font)._body;
    java.awt.FontMetrics  rv_tmp = _body.getFontMetrics();
    ...
  }
  */

  //------------------------------------------------------------------
  /*
  public _Image_if getImage(_String_if filename)
    throws Exception
  {
    java.lang.String  arg_filename = ((_String_cl)filename)._body;
    java.awt.Image  rv_tmp = _body.getIMage(arg_filename);
    ...
  }
  */

  //------------------------------------------------------------------
  //*public _Image_if getImage(_URL_if url)

  //------------------------------------------------------------------
  public int getMenuShortcutKeyMask()
    throws Exception
  {
    return _body.getMenuShortcutKeyMask();
  }

  //------------------------------------------------------------------
  /*
  public _PrintJob_if getPrintJob(_Frame_if frame, _String_if jobtitle,
				  _Properties_if props)
    throws Exception
  {
    java.awt.Frame  arg_frame = (java.awt.Frame)(((_Frame_cl)frame)._body);
    java.lang.String  arg_jobtitle = ((_String_cl)jobtitle)._body;
    java.util.Properties  arg_props = ((_Properties_cl)props)._body;
    _body.getPrintJob(arg_frame, arg_jobtitle, arg_props);
    java.awt.PrintJob  rv_tmp = ...;
    return rv;
  }
  */

  //------------------------------------------------------------------
  public _String_if getProperty(_String_if key, _String_if defaultValue) //static
    throws Exception
  {
    java.lang.String  arg_key = ((_String_cl)key)._body;
    java.lang.String  arg_defaultValue = ((_String_cl)defaultValue)._body;
    java.lang.String  rv_tmp = _body.getProperty(arg_key, arg_defaultValue);
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public int getScreenResolution()
    throws Exception
  {
    return _body.getScreenResolution();
  }

  //------------------------------------------------------------------
  public _Dimension_if getScreenSize()
    throws Exception
  {
    java.awt.Dimension  rv_tmp = _body.getScreenSize();
    if (rv_tmp == null) return null;
    _Dimension_if  rv = new _Dimension_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  //*public _Clipboard_if getSystemClipboard()

  //------------------------------------------------------------------
  public _EventQueue_if getSystemEventQueue() //final
    throws Exception
  {
    java.awt.EventQueue  rv_tmp = _body.getSystemEventQueue();
    if (rv_tmp == null) return null;
    _EventQueue_if  rv = new _EventQueue_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public boolean prepareImage(_Image_if image, int width, int height,
			      _ImageObserver_if observer)
    throws Exception
  {
    java.awt.Image  arg_image = ((_Image_cl)image)._body;

    //** it is assumed that Component class is only the one
    // that implements ImageObserver interface.
    java.awt.image.ImageObserver  arg_observer =
      (java.awt.image.ImageObserver)(((_Component_cl)observer)._body);

    return _body.prepareImage(arg_image, width, height, arg_observer);
  }

  //------------------------------------------------------------------
  public void sync()
    throws Exception
  {
    _body.sync();
  }

  
  //================================================== protected methods
  //protected abstract ButtonPeer createButton(Button target)
  //protected abstract TextFieldPeer createTextField(TextField target)
  //protected abstract LabelPeer createLabel(Label target)
  //protected abstract ListPeer createList(List target)
  //protected abstract CheckboxPeer createCheckbox(Checkbox target)
  //protected abstract ScrollbarPeer createScrollbar(Scrollbar target)
  //protected abstract ScrollPanePeer createScrollPane(ScrollPane target)
  //protected abstract TextAreaPeer createTextArea(TextArea target)
  //protected abstract ChoicePeer createChoice(Choice target)
  //protected abstract FramePeer createFrame(Frame target)
  //protected abstract CanvasPeer createCanvas(Canvas target)
  //protected abstract PanelPeer createPanel(Panel target)
  //protected abstract WindowPeer createWindow(Window target)
  //protected abstract DialogPeer createDialog(Dialog target)
  //protected abstract MenuBarPeer createMenuBar(MenuBar target)
  //protected abstract MenuPeer createMenu(Menu target)
  //protected abstract PopupMenuPeer createPopupMenu(PopupMenu target)
  //protected abstract MenuItemPeer createMenuItem(MenuItem target)
  //protected abstract FileDialogPeer createFileDialog(FileDialog target)
  //protected abstract CheckboxMenuItemPeer createCheckboxMenuItem(CheckboxMenuItem target)
  //protected LightweightPeer createComponent(Component target)
  //protected abstract FontPeer getFontPeer(String name, int style)
  //protected void loadSystemColors(int systemColors[])
  //protected static Container getNativeContainer(Component c)
  //protected abstract EventQueue getSystemEventQueueImpl()

}

// EoF

