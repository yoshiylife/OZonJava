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
 * MouseListener interface
 *
 * @version  $Id: _MouseListener_if.java,v 1.4 1997/06/13 08:49:54 nito Exp $
 * @see      _EventListener_if
 */


public interface _MouseListener_if
  extends JP.go.ipa.oz.lib.standard._EventListener_if
{

  //================================================== OZ methods
  public void mouseClicked(_MouseEvent_if e) throws Exception;
  public void mousePressed(_MouseEvent_if e) throws Exception;
  public void mouseReleased(_MouseEvent_if e) throws Exception;
  public void mouseEntered(_MouseEvent_if e) throws Exception;
  public void mouseExited(_MouseEvent_if e) throws Exception;

}

// EoF

