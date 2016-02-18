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
 * PrintJob implementation
 *
 * @version  $Id: _PrintJob_cl.java,v 1.7 1997/06/17 04:03:34 nito Exp $
 * @see      _PrintJob_if
 */


public abstract class _PrintJob_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._PrintJob_if
{

  static final java.lang.String  CN = "PrintJob";
  java.awt.PrintJob  _body;


  //================================================== constructors

  public _PrintJob_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  public java.lang.Object _new_newPrintJob()
    throws Exception
  {
    return this;
  }


  //======================================== OZ method implementation

  public abstract _Graphics_if getGraphics() throws Exception;
  public abstract _Dimension_if getPageDimension() throws Exception;
  public abstract int getPageResolution() throws Exception;
  public abstract boolean lastPageFirst() throws Exception;
  public abstract void end() throws Exception;

  //-------------------------------------------------------------------
  public void finalize()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.PrintJob)_body).finalize();
  }

}

// EoF

