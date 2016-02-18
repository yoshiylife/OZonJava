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
 * DictionaryIterator implementation
 *
 * @version  $Id: _DictionaryIterator.java,v 1.6 1997/06/17 09:44:55 hgoto Exp $
 * @see      _Iterator_if
 * @see      _Dictionary_cl
 */


public final class _DictionaryIterator
  extends JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._Iterator_if
{
  /**
   * return types
   */
  static final int  ASSOC = 1;
  static final int  KEY   = 2;
  static final int  VALUE = 3;

  _HashNode[]   target;
                // only bucket array is needed rather than whole Dictionary
  _HashNode     current;
  int           mode;


  //================================================== constructors

  _DictionaryIterator(_HashNode[] buckets, _HashNode nd, int mode)
  {
    this.target = buckets;
    this.current = nd;
    this.mode = mode;
  }


  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public boolean atBegin()
  {
    checkSecureInvocation();
    if (target == null) {
      return false;
    }
    
    int  len = target.length;
    for (int i = 0; i < len; i++) {
      if (target[i] != null) {
        return current == target[i];
      }
    }

    return true;
  }

  //------------------------------------------------------------------
  public boolean atEnd()
  {
    checkSecureInvocation();
    return (current == null);
  }

  //------------------------------------------------------------------
  /*
  public JP.go.ipa.oz.lang._Root_if back()
  {
  }

  public JP.go.ipa.oz.lang._Root_if back(int n)
  {
  }
  */

  //------------------------------------------------------------------
  public _Iterator_if duplicate()
  {
    checkSecureInvocation();
    return (new _DictionaryIterator(target, current, mode));
  }

  //------------------------------------------------------------------
  public boolean hasMoreElements()
  {
    checkSecureInvocation();
    return (current != null);
  }

  //------------------------------------------------------------------
  public JP.go.ipa.oz.lang._Root_if nextElement() throws Exception
  {
    checkSecureInvocation();
    if (current == null) {
      _CollectionException_if  ex
	= (_CollectionException_cl)new _CollectionException_cl()._new_init("NoMoreElements");
      throw (new JP.go.ipa.oz.lang.OzException(ex));
    }

    JP.go.ipa.oz.lang._Root_if  rv = get();
    forward();

    return rv;
  }

  //------------------------------------------------------------------
  /**
   * @exception  NoSuchElementExceptio  if no more elements exist.
   */
  /*
  public JP.go.ipa.oz.lang._Root_if nextElement(int n)
  {
    checkSecureInvocation();
    if (n < 0) {
      _IllegalArgumentException_if  ex
         = (_IllegalArgumentException_cl)new _IllegalArgumentException_cl()._new_init();
      throw (new JP.go.ipa.oz.lang.OzException(ex));
    }

    if (current == null) {
      _CollectionException_if  ex
	= (_CollectionException_cl)new _CollectionException_cl()._new_init("NoMoreElements");
      throw (new JP.go.ipa.oz.lang.OzException(ex));
    }

    for (int i = 0; i < n; i++) {
      forward();
    }
    JP.go.ipa.oz.lang._Root_if  rv = get();

    return rv;
  }
  */


  //================================================== private methods

  //------------------------------------------------------------------
  /**
   * forward the current by one.
   */
  private void forward()
  {
    checkSecureInvocation();
    if (!atEnd()) {
      if (current.next != null) {
        current = current.next;

      } else {
        //current is the tail in the bucket, go to the next bucket.
        int  len = target.length;
        for (int idx = (current.hashCode % len) + 1; idx < len; idx++) {
          if (target[idx] != null) {
            // next node is found
            current = target[idx];
            return;
          }
        }
        // not found
        current = null;
      }
    }
  }

  //------------------------------------------------------------------
  /*
  private void backward(int n)
  {
    checkSecureInvocation();
    if (!atBegin()) {
      if (current.next != null) {
        current = current.next;

      } else {
        //current is the tail in the bucket, go to the next bucket.
        int  len = target.length;
        for (int idx = (current.hashCode % len) + 1; idx < len; idx++) {
          if (target[idx] != null) {
            // the node is found
            current = target[idx];
            return;
          }
        }
        // not found
        current = null;
      }
    }
  }
  */

  //------------------------------------------------------------------
  private JP.go.ipa.oz.lang._Root_if get()
  {
    checkSecureInvocation();
    JP.go.ipa.oz.lang._Root_if  rv = null;

    if (current != null) {
      switch (mode) {
      case ASSOC:
        rv = new _Association_cl(current.key, current.value);
        break;

      case KEY:
        rv = current.key;
        break;

      case VALUE:
        rv = current.value;
        break;
      }
    }

    return rv;
  }
}

// EoF

