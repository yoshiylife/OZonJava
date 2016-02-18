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
 * Width implementation
 *
 * @version  $Id: _Width_cl.java,v 1.4 1997/06/17 07:13:58 nito Exp $
 * @see      _Width_cl
 */


public class _Width_cl
  extends JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._Width_if
{

  final static java.lang.String  CN = "Width";
  int  width;

    
  //================================================== constructors

  _Width_cl(int w)
    throws Exception
  {
    width = w;
  }

  public _Width_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  /**------------------------------------------------------------------
   */
  public java.lang.Object _new_newWidth(int w)
    throws Exception
  {
    width = w;
    return this;
  }


  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public int getWidth() //@
    throws Exception
  {
    checkSecureInvocation();
    return width;
  }

  //------------------------------------------------------------------
  public void setWidth(int w) //@
    throws Exception
  {
    checkSecureInvocation();
    width = w;
  }

}

// EoF
