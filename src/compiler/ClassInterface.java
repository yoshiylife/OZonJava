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
 * $Id: ClassInterface.java,v 0.20 1998-01-30 11:04:44+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.1.24
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representation type of class interface.
  * 
  * @see ClassType
  * @see Constants
  */

class ClassInterface extends ClassType implements Constants {
  /**
    * implementation for this (interface) 
    */
  private ClassImplementation implementation;
  
  /**
    * super interfaces 
    */
  protected ClassList super_interfaces;
  
  /**
    * flag, whether ceate this class instance dynamically 
    * 	for dynmaic instantiation, use interface java class name 
    */
  private boolean is_dynamic_instantiaion;
  
  /** 
    * class lists, in compiling implementaion, 
    * check whether all interface unchanged 
    */
  private java.util.Vector unchecked_super_interfaces;

  /** 
    * method lists, in compiling implementaion, 
    * check whether all methods implemented.
    */
  private java.util.Vector unchecked_methods;

  /**
    * proxy class for global object 
    */
  protected GlobalProxy proxy;

  /** 
    * create a representaion of class interace.
    *
    * @param class_name class name
    * @param cid interface class id
    * @param is_dynamic_instantiaion if instantiate dynamically
    * @param imp class implementation of this
    */
  ClassInterface (String class_name, String cid, 
		  boolean is_dynamic_instantiaion, ClassImplementation imp) {
    this (class_name, cid);
    implementation = imp;
    this.is_dynamic_instantiaion = is_dynamic_instantiaion;
  }

  /**
    * create a representaion of class interace.
    *
    * @param class_name class name
    * @param cid interface class id
    */
  ClassInterface (String class_name, String cid) { super (class_name, cid); }

  /**
    * create a representaion of class interace for null literal.
    */
  ClassInterface () { super (); }

  /**
    * set this implementaion 
    * 
    * @param imp class implementaion of this
    */
  void setImplementation (ClassImplementation imp) { 
    implementation = imp; 
  }

  /**
    * override 
    *
    * @see ClassType
    */
  boolean isClassInterface () { return true; }

  /**
    * access for implementation field
    *
    * @return implementation field */
  ClassImplementation getImplementation () { return implementation; }

  /**
    * override 
    *
    * @see ClasType
    */
  ClassList getSuperInterfaces () { return super_interfaces; }

  /**
    * access for proxy field
    *
    * @return proxy.
    */
  GlobalProxy getProxy () { return proxy; }

  /**
    * initialize (override)
    *
    * @param mod modifier
    * @param no_interfaces the number of interfaces
    * @see ClassType
    */
  void initialize (int mod, int no_interfaces) {
    super.initialize (mod);
    super_interfaces = new ClassList (no_interfaces == 0 ? 1 : no_interfaces);

    if (isGlobal () && (ClassType) this != School.CELL) createProxy ();
  }
    
  /**
    * override 
    *
    * @see ClassType
    */
  void initialize (int mod) { initialize (mod, 5); }
    
  /**
    * initialize 
    *
    * @param mod modifier
    * @param cid class id 
    * @see ClassType
    */
  void initialize (int mod, String cid) { 
    initialize (mod, 5); 
    class_id = cid;
  }
    
  /**
    * create proxy for global object 
    */
  void createProxy () {
    proxy = new GlobalProxy (this);
    proxy.copyToProxy (this);
  }

  /**
    * setup for checking integrity of interface.
    */
  void prepareForCheckIntegrity () {
    int i, size = super_interfaces.size ();
    unchecked_super_interfaces = new java.util.Vector (size);
    for (i = 0; i < size; i++) {
      ClassType c = super_interfaces.get (i);
      if (c != School.PROXY.getInterface ())
	unchecked_super_interfaces.addElement (c);
    }

    size = method_table.size ();
    unchecked_methods = new java.util.Vector (size);
    for (java.util.Enumeration enum = method_table.elements (); 
	 enum.hasMoreElements (); ) {
      unchecked_methods.addElement (enum.nextElement ());
    }
  }

  /**
    * check integrity of interface.
    */
  void checkIntegrity () {
    if (unchecked_super_interfaces.size () != 0) 
      OzcError.someSuperInterfaceDeleted (this, 
					  unchecked_super_interfaces);

    if (unchecked_methods.size () != 0)
      OzcError.someMethodsDeleted (this, unchecked_methods.elements ());
  }

  /**
    * check if a class is one of inherited interfaces.
    *
    * @param c class interface
    * @return if class is one of inherited interfaces true, otherwise false.
    */
  boolean containsAsSuperClass (ClassInterface c) {
    if (!load ()) return false;

    if (super_interfaces.contains (c)) return true;

    for (int i = 0, size = super_interfaces.size () ; i < size; i++) {
      ClassInterface c2 = (ClassInterface) super_interfaces.get (i);

      if (School.isSystem (c2)) break;

      if (c2.containsAsSuperClass (c)) return true;
    }

    return false;
  }

  /**
    * override 
    *
    * @param abstract_methods list of abstract methods.
    */
  void getAbstractMethods (java.util.Hashtable abstract_methods) {
    if (!load ()) return;

    if (School.isSystem (this)) return;

    super.getAbstractMethods (abstract_methods);

    int from;

    if (implementation == null)
      from = 0;
    else {
      ClassType sc = implementation.getSuperClass ();
      if (sc != null && !School.isSystem (sc))
	from = 1;
      else 
	from = 0;
    }

  collect_abstract:
    for (int i = from, size = super_interfaces.size (); i < size; i++) {
      ClassInterface c = (ClassInterface) super_interfaces.get (i);

      if (School.isSystem (c)) break;

      for (int j = 0; j < i; j++) {
	ClassInterface c2 = (ClassInterface) super_interfaces.get (j);

	if (c2.containsAsSuperClass (c)) continue collect_abstract;
      }
      
      c.getAbstractMethods (abstract_methods);
    }
  }

  /**
    * register super interface.
    *
    * @param c class interface
    */
  void registerSuperInterface (ClassInterface c) {
    super_interfaces.add (c);
  }

  /**
    * register not found super interfaces as super interfaces again.
    */
  void checkSuperInterfaces () {
    for (int i = super_interfaces.size () - 1; i >= 0; i--) {
      ClassInterface c = (ClassInterface) super_interfaces.get (i);
      
      if (!c.load ()) continue;

      checkAsSuperClass (c);
    }
  }
  
  /**
    * override 
    *
    * @see ClassType
    */
  void registerMethod (ClassMember m) {
    /* method of interface part is implicitly abstract */
    abstract_methods.addElement (m);

    super.registerMethod (m);
  }

  /**
    * check for defined methods in this interface:
    *  whether overriding method is eqaul with that definition 
    */
  void checkMethods () {
    checkMethods (method_table);
  }

  /**
    * check :
    *  whether method is overriding one.
    *  whether overriding method is equal with that definition.
    *  
    *  @param mt checking methods
    */
  private void checkMethods (MethodTable mt) {
    for (java.util.Enumeration ms = mt.elements (); 
	 ms.hasMoreElements (); ) {
      ClassMember m = (ClassMember) ms.nextElement ();

      ClassMember md = null;
      for (int i = 0, size = super_interfaces.size (); i < size; i++) {
	md = super_interfaces.get (i).searchMethodDefinition (m);
	if (md != null) break;
      }
      
      /* not overrided */
      if (md == null) continue;
      
      /* mark overriding method from this interface */
      m.setOverride ();
      /* method_table.unregister (m); */
      
/*       if (md.isFinal ()) */
/* 	OzcError.cannotOverrideFinal (md); */
    }
  }

  /**
    * override 
    * 
    * @see ClassType
    */
  void check () {
    checkSuperInterfaces ();
    checkMethods ();
  }

  /**
    * override 
    *
    * @see ClassType
    */
  protected ClassMember searchInheritedMethod (String name, MethodType type, 
					       int access, int modifier_mask) {
    if (!load ()) return null;

    ClassMember m; 

    for (int i = 0, size = super_interfaces.size (); i < size; i++) {
      ClassType si = super_interfaces.get (i);
      si.setParserAction (action_obj);
      m = si.searchMethod (name, type, access, modifier_mask);
      if (m != null) return m;
    } 

    return null;
 }
  
  /**
    * override 
    *
    * @see ClassType
    */
  protected ClassMember searchMethodDefinition (ClassMember method) {
    ClassMember m;
    m = super.searchMethodDefinition (method);
    if (m != null) {
      if (unchecked_methods != null) unchecked_methods.removeElement (m);
      return m;
    }
      
    if (method.access == NEW) return null;
      
    for (int i = 0, size = super_interfaces.size (); i < size; i++) {
      m = super_interfaces.get (i).searchMethodDefinition (method);
      if (m != null) return m;
    }

    return null;
  }

  /**
    * check if a class contains as super interface.
    *
    * @param c class 
    * @return if so true, otherwise false.
    */
  boolean containsAsSuperInterface (ClassType c) {
    if (!load ()) return false; 

    if (super_interfaces.contains (c)) {
      unchecked_super_interfaces.removeElement (c);
      return true;
    }
    return false;
  }

  /**
    * override
    *
    * @see ClassType
    */
  void emitHeader () {
    Emitter.emit ("public interface " + class_id);
    if (super_interfaces.size () > 0) 
      Emitter.emit (" extends " + super_interfaces.toStringWithComma ()); 
  }
   
  /**
    * override
    *
    * @see ClassType
    */
  void emitBody () {
    method_table.emitInterface ();
  }

  /** 
    * override
    *
    * @see ClassType
    */
  void emitDefinitionForBrowser () {
    Emitter.emit ("i, " + getFullyQualifiedClassID ());
    Emitter.emit (", 0x" + Integer.toHexString (modifier));
    
    Emitter.emit (", (");
    if (super_interfaces.size () > 0)
      Emitter.emit (super_interfaces.toStringWithComma ());
    Emitter.emitln (")");

    method_table.emitInterface ();
  }
}

/* EOF */


