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
 * ArrayIterator implementation
 *
 * @version  $Id: _ArrayIterator.java,v 1.6 1997/06/17 09:44:54 hgoto Exp $
 * @see      _Iterator_if
 * @see      _Array_cl
 */


public final class _ArrayIterator
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._Iterator_if
{

  _Array_if  target;  /* keep the Array object
		       * because Array will be resized
		       * and _Root_if[] will be changed
		       */
  int  index;

  //================================================== constructors

  _ArrayIterator(_Array_if array, int i)
  {
    this.target = array;
    this.index = i;
  }

  //================================================== OZ methods

  //------------------------------------------------------------------
  public boolean atEnd() throws Exception
  {
    checkSecureInvocation();
    return target.size() <= this.index;
  }

  //------------------------------------------------------------------
  /*
  public _Iterator_if duplicate() throws Exception
  {
    checkSecureInvocation();
    _Iterator_if  rv = new _ArrayIterator(target, index);
    return rv;
  }
  */

  //------------------------------------------------------------------
  public JP.go.ipa.oz.lang._Root_if nextElement() throws Exception
  {
    checkSecureInvocation();
    JP.go.ipa.oz.lang._Root_if  rv = get();
    seek(1);
    return rv;
  }

  //------------------------------------------------------------------
  /*
  public JP.go.ipa.oz.lang._Root_if nextElement(int n) throws Exception
  {
    checkSecureInvocation();
    if (n < 0) {
      _CollectionException_if  ex_cl
	= (_CollectionException_cl)new _CollectionException_cl()._new_init("IllegalArgument");
      throw (new JP.go.ipa.oz.lang.OzException(ex_cl));
    }

    if (0 < n) {
      seek(n - 1);
    }
    JP.go.ipa.oz.lang._Root_if  rv = get();
    seek(1);
    return rv;
  }
  */

  //------------------------------------------------------------------
  public boolean hasMoreElements() throws Exception
  {
    checkSecureInvocation();
    return !(this.atEnd());
  }


  //================================================== private methods

  //------------------------------------------------------------------
  private void seek(int n)
  {
    index += n;
  }

  //------------------------------------------------------------------
  private JP.go.ipa.oz.lang._Root_if get() throws Exception
  {
    JP.go.ipa.oz.lang._Root_if  rv = null;
    rv = target.at(index);

    return rv;
  }

}

// EoF
