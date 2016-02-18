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
 * FileDialog implementation
 *
 * @version  $Id: _FileDialog_cl.java,v 1.11 1997/07/04 02:27:07 nito Exp $
 * @see      _FileDialog_if
 * @see      _Dialog_cl
 */


public class _FileDialog_cl
  extends    JP.go.ipa.oz.lib.standard._Dialog_cl
  implements JP.go.ipa.oz.lib.standard._FileDialog_if
{

  public final int getLOAD() throws Exception
    { return _static_getLOAD(); }

  public static final int _static_getLOAD() throws Exception
    { return java.awt.FileDialog.LOAD; }

  public final int getSAVE() throws Exception
    { return _static_getSAVE(); }

  public static final int _static_getSAVE() throws Exception
    { return java.awt.FileDialog.SAVE; }


  static final java.lang.String  CN = "FileDialog";


  //================================================== constructors

  _FileDialog_cl(_OzFileDialog fd)
    throws Exception
  {
    _body = fd;
  }

  public _FileDialog_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  //------------------------------------------------------------------
  public java.lang.Object _new_newFileDialog(_Frame_if parent)
    throws Exception
  {
    java.awt.Frame  arg_parent = (java.awt.Frame)(((_Frame_cl)parent)._body);
    _OzFileDialog d = new _OzFileDialog(arg_parent);
    d.bind(this);
    _body = d;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newFileDialog(_Frame_if parent, _String_if title)
    throws Exception
  {
    java.awt.Frame  arg_parent = (java.awt.Frame)(((_Frame_cl)parent)._body);
    java.lang.String  arg_title = ((_String_cl)title)._body;
    _OzFileDialog d = new _OzFileDialog(arg_parent, arg_title);
    d.bind(this);
    _body = d;
    return this;
  }

  //------------------------------------------------------------------
  //@public java.lang.Object _new_newFileDialog(_Frame_if parent, _String_if title, int mode)

  //------------------------------------------------------------------
  public java.lang.Object _new_newFileLoadDialog(_Frame_if parent, _String_if title) //@
    throws Exception
  {
    java.awt.Frame  arg_parent = (java.awt.Frame)(((_Frame_cl)parent)._body);
    java.lang.String  arg_title = ((_String_cl)title)._body;
    _OzFileDialog d = new _OzFileDialog(arg_parent, arg_title,
					java.awt.FileDialog.LOAD);
    d.bind(this);
    _body = d;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newFileSaveDialog(_Frame_if parent, _String_if title) //@
    throws Exception
  {
    java.awt.Frame  arg_parent = (java.awt.Frame)(((_Frame_cl)parent)._body);
    java.lang.String  arg_title = ((_String_cl)title)._body;
    _OzFileDialog d = new _OzFileDialog(arg_parent, arg_title,
					java.awt.FileDialog.SAVE);
    d.bind(this);
    _body = d;
    return this;
  }


  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public void addNotify()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.FileDialog)_body).addNotify();
  }

  //------------------------------------------------------------------
  public _String_if asString()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Dimension  dim = ((java.awt.FileDialog)_body).getSize();
    java.lang.String  rv_tmp = CN.concat("[size=")
      .concat(java.lang.Integer.toString(dim.width)).concat("x")
      .concat(java.lang.Integer.toString(dim.height)).concat(",directory=")
      .concat(((java.awt.FileDialog)_body).getDirectory())
      .concat("]");
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _String_if getDirectory()
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = ((java.awt.FileDialog)_body).getDirectory();
    if (rv_tmp == null) return null;
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _String_if getFile()
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = ((java.awt.FileDialog)_body).getFile();
    if (rv_tmp == null) {
	return null;
    }
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  //*public _FilenameFilter_if getFilenameFilter()

  //------------------------------------------------------------------
  public int getMode()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.FileDialog)_body).getMode();
  }

  //------------------------------------------------------------------
  public void setDirectory(_String_if dir) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  arg_dir = ((_String_cl)dir)._body;
    ((java.awt.FileDialog)_body).setDirectory(arg_dir);
  }

  //------------------------------------------------------------------
  public void setFile(_String_if file) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  arg_file = ((_String_cl)file)._body;
    ((java.awt.FileDialog)_body).setFile(arg_file);
  }

  //------------------------------------------------------------------
  //*public void setFilenameFilter(_FilenameFilter_if filter) //synchronized

  //------------------------------------------------------------------
  public void setMode(int mode)
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.FileDialog)_body).setMode(mode);
  }


  //================================================== protected methods
  //protected String paramString()


  //================================================== support methods

//  public java.lang.String toString()
//    throws Exception
//  {
//    return ((_String_cl)asString())._body;
//  }

}

// EoF

