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
 * MediaTracker implementation
 *
 * @version  $Id: _MediaTracker_cl.java,v 1.9 1997/06/18 12:58:11 nito Exp $
 * @see      _MediaTracker_if
 */


public class _MediaTracker_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._MediaTracker_if
{

  public final int getLOADING() throws Exception
    { return _static_getLOADING(); }

  public static final int _static_getLOADING() throws Exception
    { return java.awt.MediaTracker.LOADING; }

  public final int getABORTED() throws Exception
    { return _static_getABORTED(); }

  public static final int _static_getABORTED() throws Exception
    { return java.awt.MediaTracker.ABORTED; }

  public final int getERRORED() throws Exception
    { return _static_getERRORED(); }

  public static final int _static_getERRORED() throws Exception
    { return java.awt.MediaTracker.ERRORED; }

  public final int getCOMPLETE() throws Exception
    { return _static_getCOMPLETE(); }

  public static final int _static_getCOMPLETE() throws Exception
    { return java.awt.MediaTracker.COMPLETE; }


  static final java.lang.String  CN = "MediaTracker";
  java.awt.MediaTracker  _body;


  //================================================== constructors

  _MediaTracker_cl(java.awt.MediaTracker mt)
    throws Exception
  {
    _body = mt;
  }

  public _MediaTracker_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  //------------------------------------------------------------------
  public java.lang.Object _new_newMediaTracker(_Component_if comp)
    throws Exception
  {
    java.awt.Component  arg_comp = (java.awt.Component)(((_Component_cl)comp)._body);
    _body = new java.awt.MediaTracker(arg_comp);
    return this;
  }
  

  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public void addImage(_Image_if image, int id)
    throws Exception
  {
    java.awt.Image  arg_image = ((_Image_cl)image)._body;
    _body.addImage(arg_image, id);
  }

  //------------------------------------------------------------------
  public void addImage(_Image_if image, int id, int w, int h) // synchronized
    throws Exception
  {
    java.awt.Image  arg_image = ((_Image_cl)image)._body;
    _body.addImage(arg_image, id, w, h);
  }

  //------------------------------------------------------------------
  public _String_if asString() //@
    throws Exception
  {
    java.lang.String  rv_tmp = CN.concat("[").concat("]");
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public boolean checkAll()
    throws Exception
  {
    return _body.checkAll();
  }

  //------------------------------------------------------------------
  public boolean checkAll(boolean load)
    throws Exception
  {
    return _body.checkAll(load);
  }

  //------------------------------------------------------------------
  public boolean checkID(int id)
    throws Exception
  {
    return _body.checkID(id);
  }

  //------------------------------------------------------------------
  public boolean checkID(int id, boolean load)
    throws Exception
  {
    return _body.checkID(id, load);
  }

  //------------------------------------------------------------------ unsupport
  //public _Array_if getErrorsAny() // synchronized
  //{
  //  java.lang.Object[]  rv_tmp = _body.getErrorsAny();
  //  _Array_if rv = null;
  //
  //  if (0 < rv_tmp.length) {
  //    rv = new _Array_cl(rv_tmp.length, new _RootComparator_cl());
  //    for (int i = 0; i < rv_tmp.length; i++) {
  //	  rv.putAt(i, new _ErrorAny_cl(rv_tmp[i]));
  //    }
  //  }
  //
  //  return rv;
  //}

  //------------------------------------------------------------------ unsupport
  //public _Array_cl getErrorsID(int id) // synchronized
  //{
  //  java.lang.Object[]  rv_tmp = _body.getErrorsID(id);
  //  _Array_cl rv = null;
  //
  //  if (0 < rv_tmp.length) {
  //    rv = new _Array_cl(rv_tmp.length, new _RootComparator_cl());
  //    for (int i = 0; i < rv_tmp.length; i++) {
  //	  rv.putAt(i, new _ErrorID_cl(rv_tmp[i]));
  //    }
  //  }
  //
  //  return rv;
  //}

  //------------------------------------------------------------------
  public boolean isErrorAny() // synchronized
    throws Exception
  {
    return _body.isErrorAny();
  }

  //------------------------------------------------------------------
  public boolean isErrorID(int id) // synchronized
    throws Exception
  {
    return _body.isErrorID(id);
  }

  //------------------------------------------------------------------
  public void removeImage(_Image_if image) // synchronized
    throws Exception
  {
    java.awt.Image  arg_image = ((_Image_cl)image)._body;
    _body.removeImage(arg_image);
  }

  //------------------------------------------------------------------
  public void removeImage(_Image_if image, int id) // synchronized
    throws Exception
  {
    java.awt.Image  arg_image = ((_Image_cl)image)._body;
    _body.removeImage(arg_image, id);
  }

  //------------------------------------------------------------------
  public void removeImage(_Image_if image, int id, int width, int height) // synchronized
    throws Exception
  {
    java.awt.Image  arg_image = ((_Image_cl)image)._body;
    _body.removeImage(arg_image, id, width, height);
  }

  //------------------------------------------------------------------
  public int statusAll(boolean load)
    throws Exception
  {
    return _body.statusAll(load);
  }

  //------------------------------------------------------------------
  public int statusID(int id, boolean load)
    throws Exception
  {
    return _body.statusID(id, load);
  }

  //------------------------------------------------------------------
  public void waitForAll()
    throws Exception
  {
    try {
      _body.waitForAll();
    } catch (java.lang.InterruptedException ex) {
      _InterruptedException_if  ex_oz
	= (_InterruptedException_cl)(new _InterruptedException_cl()._new_init(ex.getMessage()));
      throw new JP.go.ipa.oz.lang.OzException(ex_oz);
    }
  }

  //------------------------------------------------------------------
  public boolean waitForAll(long ms) // synchronized
    throws Exception
  {
    try {
      return _body.waitForAll(ms);
    } catch (java.lang.InterruptedException ex) {
      _InterruptedException_if  ex_oz
	= (_InterruptedException_cl)(new _InterruptedException_cl()._new_init(ex.getMessage()));
      throw new JP.go.ipa.oz.lang.OzException(ex_oz);
    } 
  }

  //------------------------------------------------------------------
  public void waitForID(int id)
    throws Exception
  {
    try {
      _body.waitForID(id);
    } catch (java.lang.InterruptedException ex) {
      _InterruptedException_if  ex_oz
	= (_InterruptedException_cl)(new _InterruptedException_cl()._new_init(ex.getMessage()));
      throw new JP.go.ipa.oz.lang.OzException(ex_oz);
    } 
  }

  //------------------------------------------------------------------
  public boolean waitForID(int id, long ms) // synchronized
    throws Exception
  {
    try {
      return _body.waitForID(id, ms);
    } catch (java.lang.InterruptedException ex) {
      _InterruptedException_if  ex_oz
	= (_InterruptedException_cl)(new _InterruptedException_cl()._new_init(ex.getMessage()));
      throw new JP.go.ipa.oz.lang.OzException(ex_oz);
    } 
  }

}

// EoF

