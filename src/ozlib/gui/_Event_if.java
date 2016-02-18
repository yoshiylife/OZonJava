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


/**
 * Event interface
 *
 * @version  $Id: _Event_if.java,v 1.13 1997/06/24 07:11:14 nito Exp $
 */


package JP.go.ipa.oz.lib.standard;


public interface _Event_if
  extends JP.go.ipa.oz.lang._Root_if
{

    public int getSHIFT_MASK() throws Exception;
    public int getCTRL_MASK() throws Exception;
    public int getMETA_MASK() throws Exception;
    public int getALT_MASK() throws Exception;
    public int getHOME() throws Exception;
    public int getEND() throws Exception;
    public int getPGUP() throws Exception;
    public int getPGDN() throws Exception;
    public int getUP() throws Exception;
    public int getDOWN() throws Exception;
    public int getLEFT() throws Exception;
    public int getRIGHT() throws Exception;
    public int getF1() throws Exception;
    public int getF2() throws Exception;
    public int getF3() throws Exception;
    public int getF4() throws Exception;
    public int getF5() throws Exception;
    public int getF6() throws Exception;
    public int getF7() throws Exception;
    public int getF8() throws Exception;
    public int getF9() throws Exception;
    public int getF10() throws Exception;
    public int getF11() throws Exception;
    public int getF12() throws Exception;
    public int getPRINT_SCREEN() throws Exception;
    public int getSCROLL_LOCK() throws Exception;
    public int getCAPS_LOCK() throws Exception;
    public int getNUM_LOCK() throws Exception;
    public int getPAUSE() throws Exception;
    public int getINSERT() throws Exception;
    public int getENTER() throws Exception;
    public int getBACK_SPACE() throws Exception;
    public int getTAB() throws Exception;
    public int getESCAPE() throws Exception;
    public int getDELETE() throws Exception;
    public int getWINDOW_DESTROY() throws Exception;
    public int getWINDOW_EXPOSE() throws Exception;
    public int getWINDOW_ICONIFY() throws Exception;
    public int getWINDOW_DEICONIFY() throws Exception;
    public int getWINDOW_MOVED() throws Exception;
    public int getKEY_PRESS() throws Exception;
    public int getKEY_RELEASE() throws Exception;
    public int getKEY_ACTION() throws Exception;
    public int getKEY_ACTION_RELEASE() throws Exception;
    public int getMOUSE_DOWN() throws Exception;
    public int getMOUSE_UP() throws Exception;
    public int getMOUSE_MOVE() throws Exception;
    public int getMOUSE_ENTER() throws Exception;
    public int getMOUSE_EXIT() throws Exception;
    public int getMOUSE_DRAG() throws Exception;
    public int getSCROLL_LINE_UP() throws Exception;
    public int getSCROLL_LINE_DOWN() throws Exception;
    public int getSCROLL_PAGE_UP() throws Exception;
    public int getSCROLL_PAGE_DOWN() throws Exception;
    public int getSCROLL_ABSOLUTE() throws Exception;
    public int getSCROLL_BEGIN() throws Exception;
    public int getSCROLL_END() throws Exception;
    public int getLIST_SELECT() throws Exception;
    public int getLIST_DESELECT() throws Exception;
    public int getACTION_EVENT() throws Exception;
    public int getLOAD_FILE() throws Exception;
    public int getSAVE_FILE() throws Exception;
    public int getGOT_FOCUS() throws Exception;
    public int getLOST_FOCUS() throws Exception;

  public JP.go.ipa.oz.lang._Root_if getTarget() throws Exception;
  public long getWhen() throws Exception;
  public int getId() throws Exception;
  public int getX() throws Exception;
  public int getY() throws Exception;
  public int getKey() throws Exception;
  public int getModifiers() throws Exception;
  public int getClickCount() throws Exception;
  public JP.go.ipa.oz.lang._Root_if getArgument() throws Exception;
  public _Event_if getEvent() throws Exception;

  //================================================== OZ public methods
  public boolean controlDown() throws Exception;
  public boolean metaDown() throws Exception;
  public boolean shiftDown() throws Exception;
  public void translate(int x, int y) throws Exception;
  public _String_if asString() throws Exception;

  //================================================== support methods
//  public java.lang.String toString();

}

// EoF

