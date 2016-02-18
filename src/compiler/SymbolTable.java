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
 * $Id: SymbolTable.java,v 0.6 1998-01-30 11:05:10+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.4
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing symbol table of identifiers
  *
  * @see java.util.Hashtable
  */

class SymbolTable extends java.util.Hashtable {
  /**
    * upper level table 
    */
  SymbolTable upper;

  /**
    * create new one 
    */
  SymbolTable () { super (10); }

  /**
    * create new one 
    *
    * @param prev uppter level table
    */
  SymbolTable (SymbolTable prev) { 
    this (); 
    upper = prev;
  }

  /**
    * search any identifier 
    *
    * @param name identifier name
    * @return identifier
    */
  final Identifier search (String name) {
    Identifier n = (Identifier) get (name);

    if (n != null) return n;

    if (upper != null) return upper.search (name);

    return null;
  }

  /**
    * register one identifier 
    *
    * @param id identifier
    */
  void register (Identifier id) {
    /* additional:
     *  to use simple identifier name */
    if (upper != null && search (id.getName ()) != null)
      id.addPostfix ();

    if (containsKey (id.name)) {
      /* multiply defined arguments */
      OzcError.alreadyDefined (id);
      return;
    }
      
    register (id, id.name);
  }

  /**
    * register one identifier 
    *
    * @param id identifier
    * @param name identifier name
    */
  void register (Identifier id, String name) {
    try {
      put (name, id);
    } catch (NullPointerException ex) {
      ozc.catchException (ex);
    }
  }

  /**
    * register two or more identifiers 
    *
    * @param id_list list of identifiers
    */
  void register (IdentifierList id_list) {
    java.util.Enumeration ids = id_list.elements ();
    Identifier id;

    while (ids.hasMoreElements ()) {
      register ((Identifier) ids.nextElement ());
    }
  }

  /**
    * emit one element 
    *
    * @param i index
    */
  void emitElement (Identifier i) {
    StringBuffer s = new StringBuffer ();
    s.append (i.type);
    s.append (' ');
    s.append (i);
    s.append (";");
    Emitter.emit (s);
  }

  /**
    * emit all elements
    */
  void emit () {
    java.util.Enumeration as = elements ();
    Identifier a;
    while (as.hasMoreElements ()) {
      emitElement ((Identifier) as.nextElement ());
      Emitter.emitln ();
    }
  }
}

/* EOF */
