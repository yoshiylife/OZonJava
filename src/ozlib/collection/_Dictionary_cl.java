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
 * Dictionary implementation
 *
 * @version  $Id: _Dictionary_cl.java,v 1.9 1998/01/28 09:47:35 hgoto Exp $
 * @see      _Plural_if
 * @see      _Dictionary_if
 * @see      _DictionaryIterator
 */


public class _Dictionary_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._Dictionary_if
{

  static final java.lang.String  CN = "Dictionary";

  static final int   EXPANSION_UNIT   = 203;
  static final float EXPANSION_FACTOR = 0.8F;  // = 80%, cause expansion
  static final int   INT_MASK = 0x7FFFFFFF;

  int             mySize;  // #values
  _Comparator_if  compKeys, compValues;
  int             nBuckets; // #buckets = buckets.length
  float           expFactor;
  int             expLimit; // = nBuckets * expFactor
  _HashNode[]     buckets;


  //================================================== constructors

  public _Dictionary_cl()
  {
  }

  _Dictionary_cl(_Dictionary_if dic) throws Exception
  {
    copy(dic);
  }


  //======================================== OZ constructor implementation

  //------------------------------------------------------------------
  public Object _new_create() throws Exception
  {
    init(new _RootComparator_cl(), new _RootComparator_cl(),
    EXPANSION_UNIT, EXPANSION_FACTOR);
    return this;
  }

  //------------------------------------------------------------------
  public Object _new_create(_Comparator_if forKeys) throws Exception
  {
    if (forKeys == null) {
      _CollectionException_if  ex
	= (_CollectionException_cl)new _CollectionException_cl()._new_init("NullObject");
      throw (new JP.go.ipa.oz.lang.OzException(ex));
    }

    init(forKeys, new _RootComparator_cl(), EXPANSION_UNIT, EXPANSION_FACTOR);
    return this;
  }

  //------------------------------------------------------------------
  public Object _new_create(_Comparator_if forKeys, _Comparator_if forValues) throws Exception
  {
    if (forKeys == null || forValues == null) {
      _CollectionException_if  ex
	= (_CollectionException_cl)new _CollectionException_cl()._new_init("NullObject");
      throw (new JP.go.ipa.oz.lang.OzException(ex));
    }

    init(forKeys, forValues, EXPANSION_UNIT, EXPANSION_FACTOR);
    return this;
  }


  //======================================== OZ method implementation

  //------------------------------------------------------------------
  /**
   * Returns an Iterator which seeks the key-value association.
   */
  public _Iterator_if assocIterator() throws Exception
  {
    checkSecureInvocation();
    return (new _DictionaryIterator(buckets, first(), _DictionaryIterator.ASSOC));
  }

  //------------------------------------------------------------------
  public synchronized _String_if asString() throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = CN.concat("[size=")
      .concat(java.lang.Integer.toString(mySize)).concat("]");
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  /**
   * Remove all the values.
   */
  public synchronized _Plural_if clear() throws Exception
  {
    checkSecureInvocation();
    mySize = 0;
    nBuckets = EXPANSION_UNIT;
    expLimit = (int)(nBuckets * expFactor);
    buckets = new _HashNode[nBuckets];
    return this;
  }

  //------------------------------------------------------------------
  public synchronized boolean contains(JP.go.ipa.oz.lang._Root_if value) throws Exception
  {
    checkSecureInvocation();
    if (value == null) {
      _CollectionException_if  ex
	= (_CollectionException_cl)new _CollectionException_cl()._new_init("NullObject");
      throw (new JP.go.ipa.oz.lang.OzException(ex));
    }

    for (int  i = 0; i < nBuckets; i++) {
      if (buckets[i] != null) {
	for (_HashNode  nd = buckets[i]; nd != null; nd = nd.next) {
          if (compValues.compare(value, nd.value)) {
            // found
            return true;
	  }
	}
      }
    }

    return false;
  }

  //------------------------------------------------------------------
  public synchronized boolean containsKey(JP.go.ipa.oz.lang._Root_if key) throws Exception
  {
    checkSecureInvocation();
    if (key == null) {
      _CollectionException_if  ex
	= (_CollectionException_cl)new _CollectionException_cl()._new_init("NullObject");
      throw (new JP.go.ipa.oz.lang.OzException(ex));
    }

    int  hash = HASH(key);
    int  idx = hash % nBuckets;  // backet index

    for (_HashNode  nd = buckets[idx]; nd != null; nd = nd.next) {
      // different keys may have same hash code
      if (hash == nd.hashCode && compKeys.compare(key, nd.key)) {
        // found
        return true;
      }
    }

    return false;
  }

  //------------------------------------------------------------------
  public synchronized _Dictionary_if copy(_Dictionary_if dic) throws Exception
  {
    checkSecureInvocation();
    if (dic == null) {
      _CollectionException_if  ex
	= (_CollectionException_cl)new _CollectionException_cl()._new_init("NullObject");
      throw (new JP.go.ipa.oz.lang.OzException(ex));
    }

    synchronized(dic) {
      init(dic.getComparatorForKeys(), dic.getComparatorForValues(),
                    EXPANSION_UNIT, EXPANSION_FACTOR);

      _Iterator_if  it = dic.assocIterator();
      _Association_if  assoc;
      while (it.hasMoreElements()) {
        assoc = (_Association_if)(it.nextElement());
        put(assoc.key(), assoc.value());
      }
    }

    return this;
  }

  //------------------------------------------------------------------
  public _Plural_if duplicate() throws Exception
  {
    checkSecureInvocation();
    _Dictionary_if  rv = new _Dictionary_cl(this);
    return rv;
  }

  //------------------------------------------------------------------
  public synchronized JP.go.ipa.oz.lang._Root_if get(JP.go.ipa.oz.lang._Root_if key) throws Exception
  {
    checkSecureInvocation();
    if (key == null) {
      _CollectionException_if  ex
	= (_CollectionException_cl)new _CollectionException_cl()._new_init("NullObject");
      throw (new JP.go.ipa.oz.lang.OzException(ex));
    }

    int  hash = HASH(key);
    int  idx = hash % nBuckets;
    for (_HashNode  nd = buckets[idx]; nd != null; nd = nd.next) {
      // different keys may have same hash code
      if (hash == nd.hashCode && compKeys.compare(key, nd.key)) {
        // found
        return nd.value;
      }
    }

    return null;
  }

  //------------------------------------------------------------------
  public _Comparator_if getComparatorForKeys() throws Exception
  {
    checkSecureInvocation();
    return compKeys;
  }

  //------------------------------------------------------------------
  public _Comparator_if getComparatorForValues() throws Exception
  {
    checkSecureInvocation();
    return compValues;
  }

  //------------------------------------------------------------------
  public boolean isEmpty() throws Exception
  {
    return mySize == 0;
  }

  //------------------------------------------------------------------
  /**
   * Returns an Iterator which seeks the values.
   */
  public _Iterator_if iterator() throws Exception
  {
    checkSecureInvocation();
    return (new _DictionaryIterator(buckets, first(), _DictionaryIterator.VALUE));
  }

  //------------------------------------------------------------------
  /**
   * Returns an Iterator which seeks the keys.
   */
  public _Iterator_if keyIterator() throws Exception
  {
    checkSecureInvocation();
    return (new _DictionaryIterator(buckets, first(), _DictionaryIterator.KEY));
  }

  //------------------------------------------------------------------
  /**
   * Return the set of keys.
   * The Comparator for keys of this Dictionary is used as the one
   * of the returned Set.
   */
  public synchronized _Set_if keys() throws Exception
  {
    checkSecureInvocation();
    _Set_if  rv = (_Set_cl)new _Set_cl()._new_create(compKeys);
    _Iterator_if  keyIt = keyIterator();
    while (keyIt.hasMoreElements()) {
      rv.add(keyIt.nextElement());
    }

    return rv;
  }

  //------------------------------------------------------------------
  /**
   * @exception  JP.go.ipa.oz.lang.OzException  if the key or value
   *                                         of the Association is null
   */
  public _Dictionary_if put(_Association_if assoc) throws Exception
  {
    checkSecureInvocation();
    if (assoc == null) {
      _CollectionException_if  ex
	= (_CollectionException_cl)new _CollectionException_cl()._new_init("NullObject");
      throw (new JP.go.ipa.oz.lang.OzException(ex));
    }
    
    put(assoc.key(), assoc.value());
    return this;
  }

  //------------------------------------------------------------------
  /**
   * @exception  JP.go.ipa.oz.lang.OzException  if the key or value is null
   */
  public synchronized _Dictionary_if put(JP.go.ipa.oz.lang._Root_if key,
                                         JP.go.ipa.oz.lang._Root_if value) throws Exception
  {
    checkSecureInvocation();
    if (key == null || value == null) {
      _CollectionException_if  ex
	= (_CollectionException_cl)new _CollectionException_cl()._new_init("NullObject");
      throw (new JP.go.ipa.oz.lang.OzException(ex));
    }

    int  hash = HASH(key);
    int  idx = hash % nBuckets;  // backet index

    // test if same key already exists
    for (_HashNode  nd = buckets[idx]; nd != null; nd = nd.next) {
      // different keys may have same hash code
      if (hash == nd.hashCode && compKeys.compare(key, nd.key)) {
        // found and replace
        nd.key = key;
        nd.value = value;

        return this;
      }
    }

    // add the value
    _HashNode  nd = new _HashNode(key, value, hash);
    nd.next = buckets[idx];
    buckets[idx] = nd;

    mySize++;
    if (expLimit < mySize) {
      expand();
    }

    return this;
  }

  //------------------------------------------------------------------
  /**
   * @exception  JP.go.ipa.oz.lang.OzException  if the key is null.
   */
  public synchronized _Dictionary_if remove(JP.go.ipa.oz.lang._Root_if key) throws Exception
  {
    checkSecureInvocation();
    if (key == null) {
      _CollectionException_if  ex
	= (_CollectionException_cl)new _CollectionException_cl()._new_init("NullObject");
      throw (new JP.go.ipa.oz.lang.OzException(ex));
    }

    int  hash = HASH(key);
    int  idx = hash % nBuckets;  // backet index

    _HashNode  nd1, nd2;
    for (nd1 = buckets[idx], nd2 = null;
         nd1 != null; nd2 = nd1, nd1 = nd1.next) {
      // different keys may have same hash code
      if (hash == nd1.hashCode && compKeys.compare(key, nd1.key)) {
        // found and remove
        if (nd2 == null) {
          buckets[idx] = nd1.next;
        } else {
          nd2.next = nd1.next;
        }
        mySize--;
      }
    }

    return this;
  }

  //------------------------------------------------------------------
  public int size() throws Exception
  {
    checkSecureInvocation();
    return mySize;
  }

  //------------------------------------------------------------------
  public synchronized _Set_if values() throws Exception
  {
    checkSecureInvocation();
    _Set_if  rv = (_Set_cl)new _Set_cl()._new_create(compValues);
    _Iterator_if  it = iterator();
    while (it.hasMoreElements()) {
      rv.add(it.nextElement());
    }

    return rv;
  }


  //================================================== private methods

  //------------------------------------------------------------------
  private final int HASH(JP.go.ipa.oz.lang._Root_if key) throws Exception
  {
    return (compKeys.hash(key) & INT_MASK);
  }

  //------------------------------------------------------------------
  private void init(_Comparator_if forKeys, _Comparator_if forValues,
                    int initSize, float factor)
  {
    mySize = 0;
    compKeys = forKeys;
    compValues = forValues;
    nBuckets = initSize;
    expFactor = factor;
    expLimit = (int)(nBuckets * expFactor);
    buckets = new _HashNode[nBuckets];
  }

  //------------------------------------------------------------------
  /**
   * Don't call this method in non-synchronized method !
   */
  private void expand()
  {
    int  newLen = nBuckets * 2 + 1;
    _HashNode[]  newBuckets = new _HashNode[newLen];
    _HashNode  nd1, nd2;
    int idx;
    for (int i = 0; i < nBuckets; i++) {
      nd1 = buckets[i];
      while (nd1 != null) {
        nd2 = nd1;
        nd1 = nd2.next;
        idx = nd2.hashCode % newLen;
        nd2.next = newBuckets[idx];
        newBuckets[idx] = nd2;
      }
    }

    buckets = newBuckets;
    nBuckets = newLen;
    expLimit = (int)(nBuckets * expFactor);
  }

  //------------------------------------------------------------------
  /**
   * find the first HashNode.
   */
  private _HashNode first() throws Exception
  {
    if (!isEmpty()) {
      for (int i = 0; i < nBuckets; i++) {
        if (buckets[i] != null) {
          return buckets[i];
        }
      }
    }

    return null;
  }


}

// EoF

