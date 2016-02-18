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
 * PointComparator interface
 *
 * @version  $Id: _PointComparator_cl.java,v 1.6 1997/08/07 01:53:40 nito Exp $
 * @see      _Comparator_if
 * @see      _PointComparator_if
 */


public class _PointComparator_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._PointComparator_if
{

  public _PointComparator_cl()
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
    return arg1.hashCode();
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
      if (!((arg1 instanceof _Point_if) && (arg2 instanceof _Point_if))) {
	return false;
      }
      if ((((_Point_if)arg1).getX() == ((_Point_if)arg2).getX())
	&& (((_Point_if)arg1).getY() == ((_Point_if)arg2).getY())) {
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
    return (new _PointComparator_cl());
  }

}

// EoF

