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
 * InetAddressComparator interface
 *
 * @version  $Id: _InetAddressComparator_cl.java,v 1.3 1997/08/07 01:54:31 nito Exp $
 * @see      _Comparator_if
 * @see      _InetAddressComparator_if
 */


public class _InetAddressComparator_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements _InetAddressComparator_if
{

  public _InetAddressComparator_cl()
    throws Exception
  {
  }

  public java.lang.Object _new_create()
    throws Exception
  {
    return this;
  }
  //================================================== OZ methods

  //------------------------------------------------------------------
  /**
   * Return the hash code of a InetAddress.
   */
  public int hash(JP.go.ipa.oz.lang._Root_if arg1) throws Exception
  {
    checkSecureInvocation();
    if (!(arg1 instanceof _InetAddress_cl)) {
      return arg1.hashCode();
    }
    return ((_InetAddress_cl)arg1)._body.hashCode();
  }

  /**
   * Test if objects are same.
   * If both objects are null, return true.
   */
  public boolean compare(JP.go.ipa.oz.lang._Root_if arg1,
			 JP.go.ipa.oz.lang._Root_if arg2)
    throws Exception
  {
    checkSecureInvocation();
    if (arg1 == null || arg2 == null) {
      if (arg1 == null && arg2 == null) {
        return true;
      } else {
        return false;
      }
    } else {
      if (!((arg1 instanceof _InetAddress_cl) && (arg2 instanceof _InetAddress_cl))) {
	return false;
      }
      return ((_InetAddress_cl)arg1).equalTo((_InetAddress_if)arg2);
    }
  }

  public _Comparator_if duplicate()
    throws Exception
  {
    checkSecureInvocation();
    return (_Comparator_if)(new _InetAddressComparator_cl()._new_create());
  }

}

// EoF

