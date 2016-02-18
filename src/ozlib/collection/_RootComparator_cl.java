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
 * RootComparator implements
 *
 * @version  $Id: _RootComparator_cl.java,v 1.7 1997/06/18 06:14:43 hgoto Exp $
 * @see      _Comparator_if
 * @see      _RootComparator_if
 */


public class _RootComparator_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._RootComparator_if
{

  //================================================== OZ methods

  //------------------------------------------------------------------
  /**
   * Test if objects are same.
   * If both objects are null, return true.
   */
  public boolean compare(JP.go.ipa.oz.lang._Root_if arg1,
			 JP.go.ipa.oz.lang._Root_if arg2) throws Exception
  {
    checkSecureInvocation();
    if (arg1 == null || arg2 == null) {
      if (arg1 == null && arg2 == null) {
        return true;
      } else {
        return false;
      }

    } else {
      //both are not null.
      return arg1.equals(arg2);
    }
  }

  /**
   * Return hash code of an object.
   */
  public int hash(JP.go.ipa.oz.lang._Root_if arg1) throws Exception
  {
    checkSecureInvocation();
    return arg1.hashCode();
  }

  public _Comparator_if duplicate() throws Exception
  {
    checkSecureInvocation();
    return (new _RootComparator_cl());
  }

}

// EoF

