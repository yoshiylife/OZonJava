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

// OZ Class Library (UTIL)


package JP.go.ipa.oz.lib.standard;


/**
 * Locale interface
 *
 * @version $Id: _Locale_if.java,v 1.8 1997/06/24 07:11:16 nito Exp $
 */


public interface _Locale_if
  extends JP.go.ipa.oz.lang._Root_if,
          JP.go.ipa.oz.lib.standard._Duplicatable_if
{

    public _Locale_if getENGLISH() throws Exception;
    public _Locale_if getFRENCH() throws Exception;
    public _Locale_if getGERMAN() throws Exception;
    public _Locale_if getITALIAN() throws Exception;
    public _Locale_if getJAPANESE() throws Exception;
    public _Locale_if getKOREAN() throws Exception;
    public _Locale_if getCHINESE() throws Exception;
    public _Locale_if getSIMPLIFIED_CHINESE() throws Exception;
    public _Locale_if getTRADITIONAL_CHINESE() throws Exception;
    public _Locale_if getFRANCE() throws Exception;
    public _Locale_if getGERMANY() throws Exception;
    public _Locale_if getITALY() throws Exception;
    public _Locale_if getJAPAN() throws Exception;
    public _Locale_if getKOREA() throws Exception;
    public _Locale_if getCHINA() throws Exception;
    public _Locale_if getPRC() throws Exception;
    public _Locale_if getTAIWAN() throws Exception;
    public _Locale_if getUK() throws Exception;
    public _Locale_if getUS() throws Exception;
    public _Locale_if getCANADA() throws Exception;
    public _Locale_if getCANADA_FRENCH() throws Exception;

  //================================================== OZ public methods
  public JP.go.ipa.oz.lang._Root_if duplicate() throws Exception;
  public _String_if getCountry() throws Exception;
  public _Locale_if getDefault() throws Exception;  //static
  public _String_if getDisplayCountry(_Locale_if inLocale) throws Exception;
  public _String_if getDisplayLanguage(_Locale_if inLocale) throws Exception;
  public _String_if getDisplayName(_Locale_if inLocale) throws Exception;
  public _String_if getDisplayVariant(_Locale_if inLocale) throws Exception;
  public _String_if getISO3Country() throws Exception;
  public _String_if getISO3Language() throws Exception;
  public _String_if getLanguage() throws Exception;
  public _String_if getVariant() throws Exception;
  public void setDefault(_Locale_if newLocale) throws Exception;  //static
  public _String_if asString() throws Exception;

}

// EoF

