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
 * Array implementation
 *
 * @version  $Id: _Array_cl.java,v 1.12 1998/01/27 07:59:45 hgoto Exp $
 * @see      _Sequence_if
 * @see      _Array_if
 * @see      _ArrayIterator
 */


public class _Array_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._Array_if
{

  static final java.lang.String  CN = "Array";
  JP.go.ipa.oz.lang._Root_if[]  myArray;
  _Comparator_if  myComp;


  //================================================== constructors

  _Array_cl(JP.go.ipa.oz.lang._Root_if a[], _Comparator_if c)
  {
    myArray = a;
    myComp = c;
  }

  public _Array_cl()
  {
  }


  //================================================== constructors

  //------------------------------------------------------------------
  public Object _new_create(int size) throws Exception
  {
    if (size < 0) {
      _CollectionException_if  ex
        = (_CollectionException_cl)new _CollectionException_cl()._new_init("IllegalArgument");
      throw (new JP.go.ipa.oz.lang.OzException(ex));
    }

    init(size, new _RootComparator_cl());
    return this;
  }

  //------------------------------------------------------------------
  public Object _new_create(int size, _Comparator_if comp) throws Exception
  {
    if (size < 0) {
      _CollectionException_if  ex
        = (_CollectionException_cl)new _CollectionException_cl()._new_init("IllegalArgument");
      throw (new JP.go.ipa.oz.lang.OzException(ex));
    }
    if (comp == null) {
      _CollectionException_if  ex
        = (_CollectionException_cl)new _CollectionException_cl()._new_init("NullObject");
      throw (new JP.go.ipa.oz.lang.OzException(ex));
    }
    init(size, comp);
    return this;
  }


  //================================================== public methods

  //------------------------------------------------------------------
  public _String_if asString() throws Exception
  {
    java.lang.String  rv_tmp = CN.concat("[size=")
      .concat(java.lang.Integer.toString(myArray.length)).concat("]");
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  /**
   * @exception  JP.go.ipa.oz.lang.OzException  if the index is out of range.
   */
  public JP.go.ipa.oz.lang._Root_if at(int index) throws Exception
  {
    checkSecureInvocation();
    JP.go.ipa.oz.lang._Root_if  rv;

    try {
      rv = myArray[index];
    } catch (java.lang.ArrayIndexOutOfBoundsException ex) {
      _CollectionException_if  ex_cl
	= (_CollectionException_cl)new _CollectionException_cl()._new_init("ArrayIndexOutOfBounds");
      throw (new JP.go.ipa.oz.lang.OzException(ex_cl));
    }

    return rv;
  }

  //------------------------------------------------------------------
  public synchronized _Plural_if clear() throws Exception
  {
    checkSecureInvocation();
    if (!isEmpty()) {
      for (int i = 0; i < myArray.length; i++) {
	myArray[i] = null;
      }
    }
    return this;
  }

  //------------------------------------------------------------------
  public boolean contains(JP.go.ipa.oz.lang._Root_if element) throws Exception
  {
    checkSecureInvocation();
    if (element == null) {
      _CollectionException_if  ex
	= (_CollectionException_cl)new _CollectionException_cl()._new_init("NullObject");
      throw (new JP.go.ipa.oz.lang.OzException(ex));
    }

    if (lookUp(element, 0) != -1) {
      return true;
    }
    return false;
  }

  //------------------------------------------------------------------
  /**
   * @exception  JP.go.ipa.oz.lang.OzException  if the cl is null.
   */
  public synchronized _Set_if difference(_Collection_if cl) throws Exception
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
  public synchronized _Plural_if duplicate() throws Exception
  {
    checkSecureInvocation();
    int  len = myArray.length;
    JP.go.ipa.oz.lang._Root_if[]  dupA
      = new JP.go.ipa.oz.lang._Root_if[len];
    java.lang.System.arraycopy(myArray, 0, dupA, 0, len);
    _Array_if  rv = new _Array_cl(dupA, myComp.duplicate());
    return rv;
  }

  //------------------------------------------------------------------
  public JP.go.ipa.oz.lang._Root_if first() throws Exception
  {
    checkSecureInvocation();
    if (0 < myArray.length) {
      return myArray[0];
    } else {
      return null;
    }
  }

  //------------------------------------------------------------------
  public int indexOf(JP.go.ipa.oz.lang._Root_if element) throws Exception
  {
    checkSecureInvocation();
    return lookUp(element, 0);
  }

  //------------------------------------------------------------------
  public int indexOf(JP.go.ipa.oz.lang._Root_if element, int start) throws Exception
  {
    checkSecureInvocation();
    return lookUp(element, start);
  }

  //------------------------------------------------------------------
  public synchronized final _Sequence_if infix(int start, int end) throws Exception
  {
    checkSecureInvocation();
    return sub(start, end);
  }

  //------------------------------------------------------------------
  /**
   * @exception  JP.go.ipa.oz.lang.OzException  if the cl is null.
   */
  public synchronized _Set_if intersect(_Collection_if cl) throws Exception
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
    return myArray.length == 0;
  }

  //------------------------------------------------------------------
  public _Iterator_if iterator() throws Exception
  {
    return (new _ArrayIterator(this, 0));
  }

  //------------------------------------------------------------------
  public JP.go.ipa.oz.lang._Root_if last() throws Exception
  {
    checkSecureInvocation();
    if (0 < myArray.length) {
      return myArray[myArray.length - 1];
    } else {
      return null;
    }
  }

  //------------------------------------------------------------------
  public synchronized final _Sequence_if postfix(int start) throws Exception
  {
    checkSecureInvocation();
    return sub(start, myArray.length);
  }

  //------------------------------------------------------------------
  public synchronized final _Sequence_if prefix(int end) throws Exception
  {
    checkSecureInvocation();
    return sub(0, end);
  }

  //------------------------------------------------------------------
  /**
   * Set the value to the position.
   * The value can be null.
   *
   * @exception  JP.go.ipa.oz.lang.OzException  if index is out of range.
   */
  public synchronized final _Array_if putAt(int index,
					    JP.go.ipa.oz.lang._Root_if value) throws Exception
  {
    checkSecureInvocation();
    try {
      myArray[index] = value;
    } catch (java.lang.ArrayIndexOutOfBoundsException ex_java) {
      _CollectionException_if  ex
	= (_CollectionException_cl)new _CollectionException_cl()._new_init("ArrayIndexOutOfBounds");
      throw (new JP.go.ipa.oz.lang.OzException(ex));
    }

    return this;
  }

  //------------------------------------------------------------------
  public synchronized _Collection_if remove(JP.go.ipa.oz.lang._Root_if element) throws Exception
  {
    checkSecureInvocation();
    if (element == null) {
      _CollectionException_if  ex
	= (_CollectionException_cl)new _CollectionException_cl()._new_init("NullObject");
      throw (new JP.go.ipa.oz.lang.OzException(ex));
    }

    int  index = lookUp(element, 0);
    if (index != -1) {
      myArray[index] = null;
    }

    return this;
  }

  //------------------------------------------------------------------
  /**
   * @exception  JP.go.ipa.oz.lang.OzException  if the element is null.
   */
  public synchronized _Collection_if removeAll(JP.go.ipa.oz.lang._Root_if element) throws Exception
  {
    checkSecureInvocation();
    if (element == null) {
      _CollectionException_if  ex
	= (_CollectionException_cl)new _CollectionException_cl()._new_init("NullObject");
      throw (new JP.go.ipa.oz.lang.OzException(ex));
    }

    for (int  index = lookUp(element, 0);
         index != -1;
         index = lookUp(element, index)) {
      if (index != -1) {
        myArray[index] = null;
      }
    }

    return this;
  }

  //------------------------------------------------------------------
  /**
   * @exception  JP.go.ipa.oz.lang.OzException  if index is out of range.
   */
  public synchronized final _Array_if removeAt(int index) throws Exception
  {
    checkSecureInvocation();
    try {
      myArray[index] = null;
    } catch (java.lang.ArrayIndexOutOfBoundsException ex_java) {
      _CollectionException_if  ex
	= (_CollectionException_cl)new _CollectionException_cl()._new_init("ArrayIndexOutOfBounds");
      throw (new JP.go.ipa.oz.lang.OzException(ex));
    }

    return this;
  }

  //------------------------------------------------------------------
  /**
   * @exception  JP.go.ipa.oz.lang.OzException  if size is less than zero.
   */
  public synchronized _Array_if resize(int size) throws Exception
  {
    checkSecureInvocation();
    if (size < 0) {
      _CollectionException_if  ex
	= (_CollectionException_cl)new _CollectionException_cl()._new_init("IllegalArgument");
      throw (new JP.go.ipa.oz.lang.OzException(ex));
    }

    if (myArray.length != size) {
      JP.go.ipa.oz.lang._Root_if  tmp[]
	= new JP.go.ipa.oz.lang._Root_if[size];
      int  len = myArray.length < size ? myArray.length : size;
      for (int i = 0; i < len; i++) {
	tmp[i] = myArray[i];
      }
      myArray = tmp;
    }
    return this;
  }

  //------------------------------------------------------------------
  public int rIndexOf(JP.go.ipa.oz.lang._Root_if element) throws Exception
  {
    checkSecureInvocation();
    return lookDown(element, myArray.length - 1);
  }

  //------------------------------------------------------------------
  public int rIndexOf(JP.go.ipa.oz.lang._Root_if element, int start) throws Exception
  {
    checkSecureInvocation();
    return lookDown(element, start - 1);
  }

  //------------------------------------------------------------------
  public int size() throws Exception
  {
    checkSecureInvocation();
    return myArray.length;
  }

  //------------------------------------------------------------------
  /**
   * @exception  JP.go.ipa.oz.lang.OzException  if the cl is null.
   */
  public synchronized _Set_if union(_Collection_if cl) throws Exception
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
  _Set_if asSet() throws Exception
  {
    _Set_if  rv = (_Set_cl)new _Set_cl()._new_create(myComp.duplicate());
    for (int i = 0; i < myArray.length; i++) {
      rv.add(myArray[i]);
    }
    return rv;
  }

  //------------------------------------------------------------------
  int lookDown(JP.go.ipa.oz.lang._Root_if element, int start) throws Exception
  {
    if (!isEmpty() && element != null) {
      for (int i = start; 0 <= i; i--) {
	if (myArray[i] != null && myComp.compare(element, myArray[i])) {
	  return i;
	}
      }
    }
    return -1;
  }

  //------------------------------------------------------------------
  int lookUp(JP.go.ipa.oz.lang._Root_if element, int start) throws Exception
  {
    if (!isEmpty() && element != null) {
      for (int i = start; i < myArray.length; i++) {
	if (myArray[i] != null && myComp.compare(element, myArray[i])) {
	  return i;
	}
      }
    }
    return -1;
  }

  //------------------------------------------------------------------
  void init(int size, _Comparator_if comp)
  {
    myArray = new JP.go.ipa.oz.lang._Root_if[size];
    myComp = comp;
  }

  //------------------------------------------------------------------
  _Array_if sub(int start, int end) throws Exception
  {
    int  len = end - start;
    JP.go.ipa.oz.lang._Root_if[]  a
      = new JP.go.ipa.oz.lang._Root_if[len];
    java.lang.System.arraycopy(myArray, start, a, 0, len);
    _Array_if  rv = new _Array_cl(a, myComp.duplicate());
    return rv;
  }
    

}

// EoF

