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
 * InputEvent implementation
 *
 * @version  $Id: _InputEvent_cl.java,v 1.9 1997/06/18 12:58:11 nito Exp $
 * @see      _InputEvent_if
 * @see      _ComponentEvent_cl
 */


public abstract class _InputEvent_cl
  extends    JP.go.ipa.oz.lib.standard._ComponentEvent_cl
  implements JP.go.ipa.oz.lib.standard._InputEvent_if
{

  public final int getSHIFT_MASK() throws Exception
    { return _static_getSHIFT_MASK(); }

  public static final int _static_getSHIFT_MASK() throws Exception
    { return java.awt.event.InputEvent.SHIFT_MASK; }

  public final int getCTRL_MASK() throws Exception
    { return _static_getCTRL_MASK(); }

  public static final int _static_getCTRL_MASK() throws Exception
    { return java.awt.event.InputEvent.CTRL_MASK; }

  public final int getMETA_MASK() throws Exception
    { return _static_getMETA_MASK(); }

  public static final int _static_getMETA_MASK() throws Exception
    { return java.awt.event.InputEvent.META_MASK; }

  public final int getALT_MASK() throws Exception
    { return _static_getALT_MASK(); }

  public static final int _static_getALT_MASK() throws Exception
    { return java.awt.event.InputEvent.ALT_MASK; }

  public final int getBUTTON1_MASK() throws Exception
    { return _static_getBUTTON1_MASK(); }

  public static final int _static_getBUTTON1_MASK() throws Exception
    { return java.awt.event.InputEvent.BUTTON1_MASK; }

  public final int getBUTTON2_MASK() throws Exception
    { return _static_getBUTTON2_MASK(); }

  public static final int _static_getBUTTON2_MASK() throws Exception
    { return java.awt.event.InputEvent.BUTTON2_MASK; }

  public final int getBUTTON3_MASK() throws Exception
    { return _static_getBUTTON3_MASK(); }

  public static final int _static_getBUTTON3_MASK() throws Exception
    { return java.awt.event.InputEvent.BUTTON3_MASK; }



  //================================================== constructor

  protected _InputEvent_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  protected void _InputEvent_cl()
    throws Exception
  {
  }


  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public void consume()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.event.InputEvent)_body).consume();
  }

  //------------------------------------------------------------------
  public int getModifiers()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.event.InputEvent)_body).getModifiers();
  }

  //------------------------------------------------------------------
  public long getWhen()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.event.InputEvent)_body).getWhen();
  }

  //------------------------------------------------------------------
  public boolean isAltDown()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.event.InputEvent)_body).isAltDown();
  }

  //------------------------------------------------------------------
  public boolean isConsumed()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.event.InputEvent)_body).isConsumed();
  }

  //------------------------------------------------------------------
  public boolean isControlDown()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.event.InputEvent)_body).isControlDown();
  }

  //------------------------------------------------------------------
  public boolean isMetaDown()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.event.InputEvent)_body).isMetaDown();
  }

  //------------------------------------------------------------------
  public boolean isShiftDown()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.event.InputEvent)_body).isShiftDown();
  }

}

// EoF

