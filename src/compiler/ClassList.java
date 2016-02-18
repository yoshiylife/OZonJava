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
 * $Id: ClassList.java,v 0.7 1997-07-04 11:15:18+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.3
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representation list of class (for interface definition).
  *
  * @see ClasType
  * @see java.util.Vector
  */
class ClassList extends java.util.Vector {
  /**
    * table to search class by key
    */
  java.util.Hashtable key_hash;

  /** 
    * create new class list 
    */
  ClassList () {
    super ();
    key_hash = new java.util.Hashtable ();
  }

  /** 
    * create new class list 
    *
    * @param i initial size of list
    */
  ClassList (int i) {
    super (i);
    key_hash = new java.util.Hashtable (i);
  }

  /**
    * add a class with key
    *
    * @param key key string 
    * @param c class 
    */
  void add (String key, ClassType c) { 
    if (key_hash.containsKey (key)) {
      OzcError.multiplyDefined (c);
      return;
    }
    addElement (c); 
    try {
      key_hash.put (key, c);
    } catch (NullPointerException ex) {
      ozc.catchException (ex);
    }
  }

  /**
    * add a class with no key, key is name of class 
    *
    * param c class
    */
  void add (ClassType c) { add (c.name, c); }

  /**
    * get class 
    *
    * @param i index
    * @return class
    */
  ClassType get (int i) { return (ClassType) elementAt (i); }

  /**
    * check if a class contains 
    *
    * @param key name of class
    * @return if so true, otherwise false.
    */
  boolean contains (String key) { return key_hash.containsKey (key); }

  /**
    * remove a class.
    *
    * @param key name of class
    */
  void remove (String key) { 
    ClassType c;

    c = (ClassType) key_hash.get (key);
    if (c == null) return;
    removeElement (c);
    key_hash.remove (key);
  }

  /**
    * make list of class name string, separated by comma.
    *
    * @return comma separated string
    */
  String toStringWithComma () {
    StringBuffer s = new StringBuffer ();
    for (int i = 0; i < elementCount; i++) {
      if (Emitter.isEmittingForBrowser () || Emitter.isEmitting ())
	s.append (get(i).getFullyQualifiedClassID ());
      else
	s.append (get(i).name);
      if (i + 1 < elementCount) s.append (", ");
    }
    return s.toString ();
  }
}

/* EOF */
