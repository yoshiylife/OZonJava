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
 * SListIterator implementation
 *
 * @version  $Id: _SListIterator.java,v 1.6 1997/06/17 09:44:55 hgoto Exp $
 * @see      _Iterator_if
 * @see      _SList_cl
 */


public final class _SListIterator
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._Iterator_if
{

  _SList_if  target;
  _SListNode  current;
  int  index;


  //================================================== constructors

  _SListIterator(_SList_if list, _SListNode current, int index)
  {
    this.target = list;
    this.current = current;
    this.index = index;
  }

  //================================================== OZ methods

  //------------------------------------------------------------------
  public boolean atEnd()
  {
    checkSecureInvocation();
    if (current == null) {
      return true;
    } else {
      return false;
    }
  }

  //------------------------------------------------------------------
  public _Iterator_if duplicate()
  {
    checkSecureInvocation();
    return new _SListIterator(target, current, index);
  }

  //------------------------------------------------------------------
  public boolean hasMoreElements()
  {
    checkSecureInvocation();
    return !(this.atEnd());
  }

  //------------------------------------------------------------------
  public JP.go.ipa.oz.lang._Root_if nextElement() throws Exception
  {
    checkSecureInvocation();
    JP.go.ipa.oz.lang._Root_if  rv = get();
    forward(1);

    return rv;
  }

  //------------------------------------------------------------------
  /*
  public JP.go.ipa.oz.lang._Root_if nextElement(int n)
  {
    checkSecureInvocation();
    if (n < 0) {
    }

    JP.go.ipa.oz.lang._Root_if  rv = null;
    if (1 < n) {
      forward(n - 1);
    }
    rv = get();
    forward(1);

    return rv;
  }
  */


  //================================================== private methods

  //------------------------------------------------------------------
  void forward(int n)
  {
    for (int i = 0; i < n && current != null; i++) {
      current = current.next;
    }
  }

  JP.go.ipa.oz.lang._Root_if get() throws Exception
  {
    if (current == null) {
      _CollectionException_if  ex_cl
	= (_CollectionException_cl)new _CollectionException_cl()._new_init("NoMoreEelements");
      throw (new JP.go.ipa.oz.lang.OzException(ex_cl));
    }

    return current.value;
  }

}

// EoF

