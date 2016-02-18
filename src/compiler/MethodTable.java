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
 * $Id: MethodTable.java,v 0.19 1997-07-11 18:25:56+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.4
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing symbol table of methods
  * 
  * @see java.util.Hashtable
  * @see java.util.Enumeration
  * @see Identifier
  * @see MethodType
  */

class MethodTable extends java.util.Hashtable implements java.util.Enumeration {
  /**
    * table of which key is method siganature string 
    */
  private java.util.Hashtable by_name_table;

  /**
    * buffer to access this as enumeration
    */
  private java.util.Vector same_name_methods;
  private int same_name_methods_index;
  private java.util.Enumeration methods;

  /**
    * create a table
    */
  MethodTable () {
    super (10);
    by_name_table = new java.util.Hashtable (10);
  }

  /**
    * like elements of Enumeration
    *
    * @return representation as enumeration
    */
  public java.util.Enumeration elements () {
    methods = super.elements ();
    same_name_methods_index = 0;
    return this;
  }

  /**
    * like hasMoreElements of Enumeration
    *
    * @return if has more elements true, otherwise false
    */
  public boolean hasMoreElements () {
    if (same_name_methods_index == 0) {
      if (!methods.hasMoreElements ()) return false;

      same_name_methods = (java.util.Vector) methods.nextElement ();
      same_name_methods_index = same_name_methods.size ();
    }

    return true;
  }

  /**
    * like nextElement of Enumeration
    *
    * @return one element
    */
  public Object nextElement () {
    return same_name_methods.elementAt (--same_name_methods_index);
  }

  /**
    * search a exactly same method 
    *
    * @param method searching method
    * @return found method, if not found null
    */
  ClassMember search (ClassMember method) {
    ClassMember m = (ClassMember) by_name_table.get (method.type.toString ());

    if (m == null) return null;

    if (!((MethodType) m.type).return_type.isSame (((MethodType) method.type).return_type)) {
      /* overriding methods must be exactly same */
      OzcError.illegalOverride (method);
      return null;
    } 

    if ((m.isPublic () && !method.isPublic ()) ||
	(m.isProtected () && method.isPrivate ())) {
      /* overriding methods must be more publicity */
      OzcError.illegalOverridePublicity (method);
      return null;
    }

    return m;
  }

  /**
    * search a compatible method 
    *
    * @param name name of method
    * @param type signature and return type of method
    * @param access access level
    * @param modifier_mask searching modifier
    * @return found method, if not found null
    */
  ClassMember search (String name, MethodType type, int access,
		     int modifier_mask) {
    IdentifierList methods = (IdentifierList) get (name);

    if (methods == null) return null;

    java.util.Enumeration ms = methods.elements ();

    ClassMember more_specific = null;
    while (ms.hasMoreElements ()) {
      ClassMember m = (ClassMember) ms.nextElement ();

      int diff;
      try {
	diff = m.type.compare (type);
      } catch (TypeMismatch e) {
	continue;
      }

      if (diff < 0) continue;

      int m_access = m.getAccess ();

      if (access == Constants.PROTECTED) {
	if (m_access == Constants.PRIVATE) continue;
      } else if (access == Constants.PUBLIC) {
	if (m_access != Constants.PUBLIC) continue;
      }
	  
      if (modifier_mask > 0 &&
	  ((m.getModifier () & modifier_mask) == 0)) continue;

      if (diff == 0) return m;

      if (more_specific == null) {
	more_specific = m;
	continue;
      }

      try {
	if (((MethodType) m.type).isMoreSpecific ((MethodType) more_specific.type))
	  more_specific = m;
      } catch (OverloadingAmbiguous ex) {
	/* this overloading is ambiguous */
	OzcError.overloadingAmbiguous (m);
	return ClassMember.ANY;
      }
    }

    return more_specific;
  }

  /**
    * register a method 
    *
    * @param v method 
    */
  void register (ClassMember v) throws AlreadyDefined {
    IdentifierList methods = (IdentifierList) get (v.name);
    String ms = v.type.toString ();

    if (methods == null) {
      try {
	methods = new IdentifierList ();
	methods.addElement (v);
	put (v.name , methods);
	by_name_table.put (ms, v);
      } catch (NullPointerException ex) {
	ozc.catchException (ex);
      }

      return;
    }

    if (by_name_table.containsKey (ms))
      throw new AlreadyDefined ();

    methods.addElement (v);
    by_name_table.put (ms, v);
  }

  /**
    * unregister a method 
    *
    * @param v method
    */
  void unregister (ClassMember v) {
    same_name_methods.removeElement (v);

    if (same_name_methods.size () == 0)
      remove (v.name);
    by_name_table.remove (v.type.toString ());
  }

  /**
    * check if constructor and method have same name 
    *
    * @param v method
    */
  void check (ClassMember v) throws AlreadyDefined {
    String ms = v.type.toString ();

    if (by_name_table.containsKey (ms))
      throw new AlreadyDefined ();
  }

  /**
    * emit as interface
    */
  void emitInterface () { emit (null, true); }

  /**
    * emit as implementation
    *
    * @param proxy proxy of global object (cell)
    */
  void emitImplementation (GlobalProxy proxy) {  emit (proxy, false); }

  /**
    * emit all methods
    *
    * @param proxy proxy of global object (cell)
    * @param emitting_interface if emitting interface
    */
  private void emit (GlobalProxy proxy, boolean emitting_interface) {

    IdentifierList m_list;
    ClassMember m;
    MethodType mt;
    int method_number = 0;
    for (java.util.Enumeration ms = elements (); ms.hasMoreElements ();
	 method_number++) {
      m = (ClassMember) ms.nextElement ();
      if (proxy == null && m.isOverride ()) continue;

      if (!Emitter.isEmittingForBrowser ()) Emitter.emitln ();

      mt = (MethodType) m.type;

      if (!emitting_interface) {
	if (m.isOnce ()) {
	  /* emit flag for checking once method execution */
	  Emitter.emitln ("private boolean once_flag$" + method_number + ";");

	  Type rt = mt.getReturnType ();
	  if (!rt.isVoid ()) {
	    /* emit variable for result of once method execution */
	    Emitter.emitln ("private " + rt + " once_result$" + method_number 
			    + ";");
	  }
	}

	if (proxy != null) {
	  if (!m.isPublic () && !m.isNew ())
	    continue;
	  proxy.emitMethod (m);
	  continue;
	}

	if (m.isStatic ()) {
	  if (m.getName ().startsWith (OzcProperty.STATIC_PREFIX))
	    continue;

	  m.emitAsStatic (method_number);
	  continue;
	}

	Emitter.emit (m.modifiers ());
      } 

      Emitter.emit (mt);
      if (Emitter.isEmitting ()) {
	if (!emitting_interface) {
	  Emitter.emit (" ");
	  mt.emitBody (method_number);
	} else
	  Emitter.emit (";");
      } else if (Emitter.isEmittingForBrowser ()) {
	Emitter.emitln ();
      }
    }
  }
}

/* EOF */
