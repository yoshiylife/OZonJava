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

// OZ Class Library (Collection)


package JP.go.ipa.oz.lib.standard;


/**
 * Association implementation
 *
 * @version  $Id: _Association_cl.java,v 1.9 1998/01/27 09:50:29 hgoto Exp $
 * @see      _Association_cl
 */


public final class _Association_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._Association_if
{

  JP.go.ipa.oz.lang._Root_if  myKey;
  JP.go.ipa.oz.lang._Root_if  myValue;


  //================================================== constructors

  public _Association_cl()
  {
  }

  _Association_cl(JP.go.ipa.oz.lang._Root_if key,
                  JP.go.ipa.oz.lang._Root_if value)
  {
    myKey = key;
    myValue = value;
  }


  //======================================== OZ constructor implementation

  /**------------------------------------------------------------------
   */
  public Object _new_create(JP.go.ipa.oz.lang._Root_if key,
                          JP.go.ipa.oz.lang._Root_if value) throws Exception
  {
    if (key == null || value == null) {
      _CollectionException_if  ex
	= (_CollectionException_cl)new _CollectionException_cl()._new_init("NullObject");
      throw (new JP.go.ipa.oz.lang.OzException(ex));
    }
    
    myKey = key;
    myValue = value;
    return this;
  }


  //======================================== OZ method implementation

  /**------------------------------------------------------------------
   */
  public _String_if asString() throws Exception
  {
    checkSecureInvocation();
    _String_if  s1 = new _String_cl("Association[");

    if (myKey != null) {
      s1 = s1.concat(myKey.asString()).concat(new _String_cl(", "));
    } else {
      s1 = s1.concat(new _String_cl("null, "));
    }
    if (myValue != null) {
      s1 = s1.concat(myValue.asString());
    } else {
      s1 = s1.concat(new _String_cl("null"));
    }
    s1 = s1.concat(new _String_cl("]"));

    return s1;
  }

  /**------------------------------------------------------------------
   * Create a shallow copy.
   */
  public _Association_if duplicate() throws Exception
  {
    checkSecureInvocation();
    return (new _Association_cl(myKey, myValue));
  }

  /**------------------------------------------------------------------
   */
  public JP.go.ipa.oz.lang._Root_if key() throws Exception
  {
    checkSecureInvocation();
    return myKey;
  }

  /**------------------------------------------------------------------
   */
  public _Association_if setValue(JP.go.ipa.oz.lang._Root_if value) throws Exception
  {
    checkSecureInvocation();
    if (value == null) {
      _CollectionException_if  ex
	= (_CollectionException_cl)new _CollectionException_cl()._new_init("NullObject");
      throw (new JP.go.ipa.oz.lang.OzException(ex));
    }
    
    myValue = value;
    return this;
  }

  /**------------------------------------------------------------------
   */
  public JP.go.ipa.oz.lang._Root_if value() throws Exception
  {
    checkSecureInvocation();
    return myValue;
  }


}

// EoF
