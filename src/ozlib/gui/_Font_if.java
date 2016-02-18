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
 * Font interface
 *
 * @version  $Id: _Font_if.java,v 1.11 1997/06/24 07:11:15 nito Exp $
 * @see      _Font_cl
 */


public interface _Font_if
  extends JP.go.ipa.oz.lang._Root_if
{
    public int getPLAIN() throws Exception;
    public int getBOLD() throws Exception;
    public int getITALIC() throws Exception;


  //================================================== OZ public methods
  public _String_if getFamily() throws Exception;
  public _String_if getName() throws Exception;
  //*public _FontPeer_if getPeer() throws Exception;
  //@public int getStyle() throws Exception;
  public int getSize() throws Exception;
  public boolean isPlain() throws Exception; //@
  public boolean isBold() throws Exception; //@
  public boolean isItalic() throws Exception; //@
  public _String_if asString() throws Exception;
  public _Font_if decode(_String_if str) throws Exception;


  //================================================== support methods
//  public java.lang.String toString();

}

// EoF
