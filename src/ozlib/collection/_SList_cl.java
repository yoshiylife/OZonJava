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
 * SList implementation
 *
 * @version  $Id: _SList_cl.java,v 1.11 1998/01/27 08:00:39 hgoto Exp $
 * @see      _Sequence_if
 * @see      _SList_if
 * @see      _SListIterator
 * @see      _SListNode
 */


public class _SList_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._SList_if
{

  final static java.lang.String  CN = "SList";
  _SListNode  myHead;
  _SListNode  myTail;
  int  myLength;
  _Comparator_if  myComp;


  //================================================== constructors

  _SList_cl(_SList_if list) throws Exception
  {
    init(((_SList_cl)list).myComp.duplicate());
    _Iterator_if  it = list.iterator();
    while (it.hasMoreElements()) {
      pushBack(it.nextElement());
    }
  }

  public _SList_cl()
  {
  }


  //================================================== OZ constructors

  //------------------------------------------------------------------
  public Object _new_create() throws Exception
  {
    init(new _RootComparator_cl());
    return this;
  }

  //------------------------------------------------------------------
  public Object _new_create(_Comparator_if comp) throws Exception
  {
    if (comp == null) {
      _CollectionException_if  ex
        = (_CollectionException_cl)new _CollectionException_cl()._new_init("NullObject");
      throw (new JP.go.ipa.oz.lang.OzException(ex));
    }

    init(comp);
    return this;
  }


  //================================================== OZ methods

  //------------------------------------------------------------------
  public _String_if asString() throws Exception
  {
    java.lang.String  rv_tmp = CN.concat("[size=")
      .concat(java.lang.Integer.toString(myLength)).concat("]");
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public synchronized _Plural_if clear() throws Exception
  {
    checkSecureInvocation();
    myHead = myTail = null;
    myLength = 0;

    return this;
  }

  //------------------------------------------------------------------
  public _SList_if concatenate(_SList_if list) throws Exception
  {
    checkSecureInvocation();
    if (list == null) {
      _CollectionException_if  ex
	= (_CollectionException_cl)new _CollectionException_cl()._new_init("NullObject");
      throw (new JP.go.ipa.oz.lang.OzException(ex));
    }

    _SList_if  rv = new _SList_cl(this);
    _Iterator_if  it = list.iterator();

    while (it.hasMoreElements()) {
      rv.pushBack(it.nextElement());
    }

    return rv;
  }

  //------------------------------------------------------------------
  public boolean contains(JP.go.ipa.oz.lang._Root_if value) throws Exception
  {
    checkSecureInvocation();
    if (value == null) {
      _CollectionException_if  ex
	= (_CollectionException_cl)new _CollectionException_cl()._new_init("NullObject");
      throw (new JP.go.ipa.oz.lang.OzException(ex));
    }

    if (find(value) != null) {
      return true;
    } else {
      return false;
    }
  }

  //------------------------------------------------------------------
  public _Set_if difference(_Collection_if cl) throws Exception
  {
    checkSecureInvocation();
    if (cl == null) {
      _CollectionException_if  ex
	= (_CollectionException_cl)new _CollectionException_cl()._new_init("NullObject");
      throw (new JP.go.ipa.oz.lang.OzException(ex));
    }

    _Set_if  rv = asSet();

    if (!rv.isEmpty()) {
      JP.go.ipa.oz.lang._Root_if  element;
      _Iterator_if  it = rv.iterator();

      while (it.hasMoreElements()) {
        element = it.nextElement();
        if (element != null && cl.contains(element)) {
          rv.remove(element);
        }
      }
    }

    return rv;
  }

  //------------------------------------------------------------------
  public _Plural_if duplicate() throws Exception
  {
    checkSecureInvocation();
    return createSub(0, myLength);
  }

  //------------------------------------------------------------------
  public JP.go.ipa.oz.lang._Root_if first() throws Exception
  {
    checkSecureInvocation();
    if (!isEmpty()) {
      return myHead.value;
    } else {
      return null;
    }
  }

  //------------------------------------------------------------------
  /**
   * @return  the index of the value, -1 if the value is not found
   */
  public int indexOf(JP.go.ipa.oz.lang._Root_if value) throws Exception
  {
    checkSecureInvocation();
    return findIndex(value, 0);
  }

  //------------------------------------------------------------------
  /**
   * @return  the index of the value, -1 if the value is not found
   */
  public int indexOf(JP.go.ipa.oz.lang._Root_if value, int start) throws Exception
  {
    checkSecureInvocation();
    return findIndex(value, start);
  }

  //------------------------------------------------------------------
  public _Sequence_if infix(int start, int end) throws Exception
  {
    checkSecureInvocation();
    return createSub(start, end);
  }

  //------------------------------------------------------------------
  public synchronized _SList_if insertAfter(JP.go.ipa.oz.lang._Root_if prev,
                                            JP.go.ipa.oz.lang._Root_if element) throws Exception
  {
    checkSecureInvocation();
    _SListNode  prevNode = find(prev);

    if (prevNode == null) {
      _CollectionException_if  ex
	= (_CollectionException_cl)new _CollectionException_cl()._new_init("NoSuchObject");
      throw (new JP.go.ipa.oz.lang.OzException(ex));
    } else {
      _SListNode  newNode = new _SListNode(element);
      if (myTail == prevNode) {
	myTail = newNode;
      }
      newNode.next = prevNode.next;
      prevNode.next = newNode;
      myLength++;
    }

    return this;
  }

  //------------------------------------------------------------------
  public _Set_if intersect(_Collection_if cl) throws Exception
  {
    checkSecureInvocation();
    if (cl == null) {
      _CollectionException_if  ex
	= (_CollectionException_cl)new _CollectionException_cl()._new_init("NullObject");
      throw (new JP.go.ipa.oz.lang.OzException(ex));
    }

    _Set_if  rv = (_Set_cl)new _Set_cl()._new_create(myComp.duplicate());
    _Collection_if  smaller, bigger;

    if (!isEmpty() && !cl.isEmpty()) {
      if (this.size() < cl.size()) {
        smaller = this;
        bigger = cl;
      } else {
        smaller = cl;
        bigger = this;
      }

      JP.go.ipa.oz.lang._Root_if  element;
      _Iterator_if  it = bigger.iterator();

      while (it.hasMoreElements()) {
        element = it.nextElement();
        if (element != null && smaller.contains(element)) {
          rv.add(element);
        }
      }
    }

    return rv;
  }

  //------------------------------------------------------------------
  public boolean isEmpty() throws Exception
  {
    checkSecureInvocation();
    return myLength == 0;
  }

  //------------------------------------------------------------------
  public _Iterator_if iterator() throws Exception
  {
    checkSecureInvocation();
    return (new _SListIterator(this, myHead, 0));
  }

  //------------------------------------------------------------------
  public JP.go.ipa.oz.lang._Root_if last() throws Exception
  {
    checkSecureInvocation();
    if (isEmpty()) {
      return null;
    }

    return myTail.value;
  }

  //------------------------------------------------------------------
  public synchronized _SList_if popFront() throws Exception
  {
    checkSecureInvocation();
    if (!isEmpty()) {
      myHead = myHead.next;
      if (myLength == 1) {
        // the last element is removed
        myTail = null;
      }
      myLength--;
    }

    return this;
  }

  //------------------------------------------------------------------
  public _Sequence_if postfix(int start) throws Exception
  {
    checkSecureInvocation();
    return createSub(start, myLength);
  }

  //------------------------------------------------------------------
  public _Sequence_if prefix(int end) throws Exception
  {
    checkSecureInvocation();
    return createSub(0, end);
  }

  //------------------------------------------------------------------
  public synchronized _SList_if pushBack(JP.go.ipa.oz.lang._Root_if element) throws Exception
  {
    checkSecureInvocation();
    _SListNode  item = new _SListNode(element);

    if (isEmpty()) {
      myHead = item;
    } else {
      myTail.next = item;
    }
    myTail = item;
    myLength++;

    return this;
  }

  //------------------------------------------------------------------
  public synchronized _SList_if pushFront(JP.go.ipa.oz.lang._Root_if element) throws Exception
  {
    checkSecureInvocation();
    _SListNode  item = new _SListNode(element, myHead);

    myHead = item;
    if (isEmpty()) {
      myTail = item;
    }
    myLength++;

    return this;
  }

  //------------------------------------------------------------------
  public synchronized _Collection_if remove(JP.go.ipa.oz.lang._Root_if element) throws Exception
  {
    checkSecureInvocation();
    if (!isEmpty()) {
      if (myComp.compare(element, myHead.value)) {
	if (myLength == 1) {
        // the last element in the list
          clear();			// reset myHead,myTail,myLength
	} else {
	  myHead = myHead.next;		// not tail
	  myLength--;
	}
      } else {
        // multiple elements exist
        _SListNode  item = findPrev(element);
	if (item != null) {
	  if (item.next == myTail) {
	    myTail = item;   
	  }
	  item.next = (item.next).next;
	  myLength--;
	}
      }
    }
    
    return this;
  }

  //------------------------------------------------------------------
  public synchronized _SList_if removeAfter(JP.go.ipa.oz.lang._Root_if prev) throws Exception
  {
    checkSecureInvocation();
    if (1 < myLength) {
      _SListNode  item = find(prev);
      if (item != null && item != myTail) {
	if (item.next == myTail) {
	  myTail = item;   
	}
        item.next = (item.next).next;
        myLength--;

        return this;
      }
    }

    _CollectionException_if  ex
	= (_CollectionException_cl)new _CollectionException_cl()._new_init("NoSuchElement");
    throw (new JP.go.ipa.oz.lang.OzException(ex));
  }

  //------------------------------------------------------------------
  public synchronized _Collection_if removeAll(JP.go.ipa.oz.lang._Root_if element) throws Exception
  {
    if (!isEmpty()) {
      _SListNode  nd1, nd2 = null;
      for (nd1 = myHead; nd1 != null;nd1 = nd1.next) {
        if (myComp.compare(element, nd1.value)) {
	  // found, remove this nd1 !!!
	  if (nd2 == null) {
	    //nd1 is head
	    myHead = nd1.next;
	  } else {
	    nd2.next = nd1.next;
	  }
	  myLength--;
	} else {
	  nd2 = nd1;
	}
      }
      if (nd2 == null || nd2.next == null) {	// myTail is removed
	myTail = nd2;
      }
    }
    
    return this;
  }

  //------------------------------------------------------------------
  /**
   * @return  the index of the value, -1 if the value is not found
   */
  public int rIndexOf(JP.go.ipa.oz.lang._Root_if value) throws Exception
  {
    checkSecureInvocation();
    return findRIndex(value, myLength);
  }

  //------------------------------------------------------------------
  /**
   * @return  the index of the value, -1 if the value is not found
   */
  public int rIndexOf(JP.go.ipa.oz.lang._Root_if value, int upperBound) throws Exception
  {
    checkSecureInvocation();
    return findRIndex(value, upperBound);
  }

  //------------------------------------------------------------------
  public int size() throws Exception
  {
    checkSecureInvocation();
    return myLength;
  }

  //------------------------------------------------------------------
  public _Set_if union(_Collection_if cl) throws Exception
  {
    checkSecureInvocation();
    if (cl == null) {
      _CollectionException_if  ex
	= (_CollectionException_cl)new _CollectionException_cl()._new_init("NullObject");
      throw (new JP.go.ipa.oz.lang.OzException(ex));
    }

    _Set_if  rv = asSet();

    if (!cl.isEmpty()) {
      _Iterator_if  it = cl.iterator();
      JP.go.ipa.oz.lang._Root_if  element;

      while (it.hasMoreElements()) {
        element = it.nextElement();
        if (element != null) {
          rv.add(element);
        }
      }
    }

    return rv;
  }


  //================================================== private methods

  //------------------------------------------------------------------
  /**
   * Return a set of elements.
   */
  _Set_if asSet() throws Exception
  {
    _Set_if  rv = (_Set_cl)new _Set_cl()._new_create(myComp.duplicate());
    _Iterator_if  it = iterator();
    JP.go.ipa.oz.lang._Root_if  element;

    while (it.hasMoreElements()) {
      element = it.nextElement();
      if (element != null) {
	rv.add(element);
      }
    }

    return rv;
  }

  //------------------------------------------------------------------
  _SListNode find(JP.go.ipa.oz.lang._Root_if element) throws Exception
  {
    if (!isEmpty()) {
      for (_SListNode  ptr = myHead; ptr != null; ptr = ptr.next) {
	if (myComp.compare(element, ptr.value)) {
	  return ptr;
	}
      }
    }
    return null;
  }

  //------------------------------------------------------------------
  /**
   * Find the SListNode whose value equals to element, and
   * located after the item.
   */
  _SListNode findAfter(_SListNode item, JP.go.ipa.oz.lang._Root_if element) throws Exception
  {
    if (!isEmpty()) {
      //item is checked at first
      for (_SListNode  ptr = item; ptr != null; ptr = ptr.next) {
	if (myComp.compare(element, ptr.value)) {
	  return ptr;
	}
      }
    }
    return null;
  }

  //------------------------------------------------------------------
  /**
   * @return  the index of the value, -1 if the value is not found
   */
  int findIndex(JP.go.ipa.oz.lang._Root_if value, int start) throws Exception
  {
    int  index;

    if (start < myLength) {
      _SListNode  ptr = myHead;
      // forward the pointer to the start position
      for (index = 0; index < start; ptr = ptr.next, index++) {
	// nothing
      }
      for ( ; ptr != null; ptr = ptr.next, index++) {
	if (myComp.compare(value, ptr.value)) {
	  return index;
	}
      }
    }

    return -1;
  }

  //------------------------------------------------------------------
  _SListNode findPrev(JP.go.ipa.oz.lang._Root_if element) throws Exception
  {
    if (2 <= myLength) {
      _SListNode  ptr1, ptr2;
      for (ptr2 = myHead, ptr1 = myHead.next;
	   ptr1 != null;
	   ptr2 = ptr1, ptr1 = ptr1.next) {
	if (myComp.compare(element, ptr1.value)) {
	  return ptr2;
	}
      }
    }
    return null;
  }

  //------------------------------------------------------------------
  /**
   * @return  the index of the value, -1 if the value is not found
   */
  int findRIndex(JP.go.ipa.oz.lang._Root_if value, int upper) throws Exception
  {
    int  last = -1;
    for (int i = 0,j; i < upper; i = j + 1) {
      if ((j = findIndex(value, i)) < 0) break;
      if (j < upper) {
	last = j;
      }
    }

    return last;
  }

  //------------------------------------------------------------------
  void init(_Comparator_if comp) throws Exception
  {
    clear();
    myComp = comp;
  }

  //------------------------------------------------------------------
  /**
   * create a subsequence [start, end),
   * i.e. the value whose index is end is not included.
   */
  _Sequence_if createSub(int start, int end) throws Exception
  {
    _SList_if  rv = null;

    if (start < myLength && start < end) {
      rv = new _SList_cl();

      ((_SList_cl)rv).init(myComp.duplicate());

      _SListNode  item;
      int  i;
      for (i = start, item = nodeAt(start);
	   item != null && i < end;
	   i++, item = item.next) {
	rv.pushBack(item.value);
      }

    } else {
      _CollectionException_if  ex
	= (_CollectionException_cl)new _CollectionException_cl()._new_init("IllegalArgument");
      throw (new JP.go.ipa.oz.lang.OzException(ex));
    }

    return rv;
  }

  //------------------------------------------------------------------
  _SListNode nodeAt(int index) throws Exception
  {
    if (index < 0 && myLength <= index) {
      _CollectionException_if  ex
	= (_CollectionException_cl)new _CollectionException_cl()._new_init("IllegalArgument");
      throw (new JP.go.ipa.oz.lang.OzException(ex));
    }

    if (!isEmpty()) {
      _SListNode ptr = myHead;
      for (int i = 0; i != index; i++) {
	ptr = ptr.next;
      }
      return ptr;
    }

    return null;
  }

  //------------------------------------------------------------------
  _SListNode tail()
  {
    return myTail;
  }


}

// EoF
