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
 * StringComparator implements
 *
 * @version  $Id: _StringComparator_cl.java,v 1.4 1997/06/23 01:59:16 hgoto Exp $
 * @see      _Comparator_if
 * @see      _StringComparator_if
 */


public class _StringComparator_cl
  extends JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._StringComparator_if
{
  public Object _new_create() throws Exception
  {
    return this;
  }

  /**
   * Test if Strings are same.
   */
  public boolean compare(JP.go.ipa.oz.lang._Root_if arg1,
	JP.go.ipa.oz.lang._Root_if arg2) throws Exception 
  {
    checkSecureInvocation();
    if (arg1 == null || arg2 == null) {
      return (arg1 == null && arg2 == null);
    }
    if (arg1 instanceof _String_cl) {
      return ((_String_if)arg1).isequal(arg2);
    } else {
      return false;
    }
  }

  /**
   * Return the hash code of a String.
   */
  public int hash(JP.go.ipa.oz.lang._Root_if arg1) throws Exception
  {
    checkSecureInvocation();
    if (!(arg1 instanceof _String_cl)) {
      return arg1.hashCode();
    }
    return ((_String_cl)arg1)._body.hashCode();
  }

  public _Comparator_if duplicate() throws Exception
  {
    checkSecureInvocation();	
    return (new _StringComparator_cl());
  }
}

// EoF
