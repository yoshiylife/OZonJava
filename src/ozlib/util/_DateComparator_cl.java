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

/*
 * $Id: _DateComparator_cl.java,v 1.1 1997/08/22 05:37:53 hgoto Exp $
 */

package JP.go.ipa.oz.lib.standard;

public class _DateComparator_cl
  extends JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._DateComparator_if
{
  public Object _new_create() throws Exception
  {
    return this;
  }

  /**
   * Test if Dates are same.
   */
  public boolean compare(JP.go.ipa.oz.lang._Root_if arg1,
	JP.go.ipa.oz.lang._Root_if arg2) throws Exception 
  {
    checkSecureInvocation();
    if (arg1 == null || arg2 == null) {
      return (arg1 == null && arg2 == null);
    }
    if (arg1 instanceof _Date_cl && arg2 instanceof _Date_cl) {
      return ((_Date_if)arg1).isEqualDate((_Date_if)arg2);
    } else {
      return false;
    }
  }

  /**
   * Return the hash code of a Date.
   */
  public int hash(JP.go.ipa.oz.lang._Root_if arg1) throws Exception
  {
    checkSecureInvocation();
    if (!(arg1 instanceof _Date_cl)) {
      return arg1.hashCode();
    }
    return ((_Date_cl)arg1)._body.hashCode();
  }

  public _Comparator_if duplicate() throws Exception
  {
    checkSecureInvocation();	
    return (new _DateComparator_cl());
  }
}

// EoF
