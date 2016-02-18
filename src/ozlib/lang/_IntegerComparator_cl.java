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
 * IntegerComparator interface
 *
 * @version  $Id: _IntegerComparator_cl.java,v 1.3 1997/10/02 06:04:57 hgoto Exp $
 * @see      _Comparator_if
 * @see      _IntegerComparator_if
 */


public class _IntegerComparator_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._IntegerComparator_if
{

  public _IntegerComparator_cl()
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
   * Return the hash code of a String.
   */
  public int hash(JP.go.ipa.oz.lang._Root_if arg1) throws Exception
  {
    checkSecureInvocation();
    if (!(arg1 instanceof _Integer_if)) {
      return arg1.hashCode();
    }
    return ((_Integer_if)arg1).intValue();
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
      if (!((arg1 instanceof _Integer_if) && (arg2 instanceof _Integer_if))) {
	return false;
      }
      if (((_Integer_if)arg1).intValue() == ((_Integer_if)arg2).intValue()) {
	return true;
      } else {
	return false;
      }
    }
  }

  public _Comparator_if duplicate()
    throws Exception
  {
    checkSecureInvocation();
    return (_Comparator_if)(new _IntegerComparator_cl()._new_create());
  }

}

// EoF

