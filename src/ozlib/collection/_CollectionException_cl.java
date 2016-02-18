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
 * CollectionException implementation
 *
 * @version  $Id: _CollectionException_cl.java,v 1.11 1997/06/18 06:17:05 hgoto Exp $
 * @see      _CollectionException_if
 * @see      _RuntimeException_cl
 */


public final class _CollectionException_cl
  extends    _RuntimeException_cl
  implements _CollectionException_if
{
  static java.lang.String  CN = "CollectionException";


  //================================================== constructors

  public _CollectionException_cl() throws Exception
  {
  }


  //================================================== OZ constructor

  public Object _new_init() throws Exception
  {
    super._new_init();
    return this;
  }
  
  public Object _new_init(_String_if msg) throws Exception
  {
    super._new_init(msg);
    return this;
  }

  public Object _new_init(java.lang.String msg) throws Exception
  {
    super._new_init(msg);
    return this;
  }
}

