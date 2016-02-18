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
 * Set implementation
 *
 * @version  $Id: _Set_cl.java,v 1.9 1997/08/18 07:26:04 hgoto Exp $
 * @see      _Collection_if
 * @see      _Set_if
 * @see      _SetIterator
 */


public class _Set_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._Set_if
{

  static final java.lang.String  CN = "Set";
  _Dictionary_if  hT;


  //================================================== constructors

  _Set_cl(_Dictionary_if dic)
  {
    hT = dic;
  }

  public _Set_cl()
  {
  }


  //======================================== OZ constructor implementation

  public Object _new_create() throws Exception
  {
    init(new _RootComparator_cl());
    return this;
  }

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


  //======================================== OZ method implementation

  //------------------------------------------------------------------
  /**
   * @exception  JP.go.ipa.oz.lang.OzException  if the element is null.
   */
  public synchronized _Set_if add(JP.go.ipa.oz.lang._Root_if element) throws Exception
  {
    checkSecureInvocation();
    if (element == null) {
      _CollectionException_if  ex
	= (_CollectionException_cl)new _CollectionException_cl()._new_init("NullObject");
      throw (new JP.go.ipa.oz.lang.OzException(ex));
    }

    hT.put(element, element);
    return this;
  }

  //------------------------------------------------------------------
  public _String_if asString() throws Exception
  {
    java.lang.String  rv_tmp = CN.concat("[size=")
      .concat(java.lang.Integer.toString(size())).concat("]");
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _Plural_if clear() throws Exception
  {
    checkSecureInvocation();
    hT.clear();
    return this;
  }

  //------------------------------------------------------------------
  public synchronized boolean contains(JP.go.ipa.oz.lang._Root_if element) throws Exception
  {
    checkSecureInvocation();
    if (element == null) {
      _CollectionException_if  ex
	= (_CollectionException_cl)new _CollectionException_cl()._new_init("NullObject");
      throw (new JP.go.ipa.oz.lang.OzException(ex));
    }

    return hT.containsKey(element);
  }

  //------------------------------------------------------------------
  /**
   * @exception  JP.go.ipa.oz.lang.OzException  if the element is null.
   */
  public synchronized _Set_if difference(_Collection_if cl) throws Exception
  {
    checkSecureInvocation();
    if (cl == null) {
      _CollectionException_if  ex
	= (_CollectionException_cl)new _CollectionException_cl()._new_init("NullObject");
      throw (new JP.go.ipa.oz.lang.OzException(ex));
    }

    _Set_if  rv = (_Set_cl)(duplicate());

    if (!rv.isEmpty()) {
      synchronized(cl) {
        JP.go.ipa.oz.lang._Root_if  element;
        _Iterator_if  it = rv.iterator();

        while (it.hasMoreElements()) {
          element = it.nextElement();
          if (element != null && cl.contains(element)) {
            rv.remove(element);
          }
        }
      }
    }

    return rv;
  }

  //------------------------------------------------------------------
  public synchronized _Plural_if duplicate() throws Exception
  {
    checkSecureInvocation();
    _Dictionary_if  cloneHT = (_Dictionary_if)(hT.duplicate());
    _Set_if  rv = new _Set_cl(cloneHT);
    return rv;
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

    _Comparator_if  comp = hT.getComparatorForKeys().duplicate();
    _Set_if  rv = (_Set_cl)new _Set_cl()._new_create(comp);
    _Collection_if  smaller, bigger;

    if (!isEmpty() && !cl.isEmpty()) {
      synchronized(cl) {
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
    }

    return rv;
  }

  //------------------------------------------------------------------
  public boolean isEmpty() throws Exception
  {
    checkSecureInvocation();
    return hT.isEmpty();
  }

  //------------------------------------------------------------------
  public _Iterator_if iterator() throws Exception
  {
    checkSecureInvocation();
    _Iterator_if  rv = hT.keyIterator();
    return rv;
  }

  //------------------------------------------------------------------
  /**
   * @exception  JP.go.ipa.oz.lang.OzException  if the element is null.
   */
  public synchronized _Collection_if remove(JP.go.ipa.oz.lang._Root_if element) throws Exception
  {
    checkSecureInvocation();
    if (element == null) {
      _CollectionException_if  ex
	= (_CollectionException_cl)new _CollectionException_cl()._new_init("NullObject");
      throw (new JP.go.ipa.oz.lang.OzException(ex));
    }

    hT.remove(element);
    return this;
  }

  //------------------------------------------------------------------
  public _Collection_if removeAll(JP.go.ipa.oz.lang._Root_if element) throws Exception
  {
    checkSecureInvocation();
    return remove(element);
  }

  //------------------------------------------------------------------
  public int size() throws Exception
  {
    checkSecureInvocation();
    return hT.size();
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

    _Set_if  rv = (_Set_if)(duplicate());
    if (!cl.isEmpty()) {
      synchronized(cl) {
        _Iterator_if  it = cl.iterator();
        JP.go.ipa.oz.lang._Root_if  element;

        while (it.hasMoreElements()) {
          element = it.nextElement();
          if (element != null) {
            rv.add(element);
          }
        }
      }
    }

    return rv;
  }


  //================================================== private methods

  private final void init(_Comparator_if c) throws Exception
  {
    hT = (_Dictionary_cl)new _Dictionary_cl()._new_create(c);
  }


}

// EoF

