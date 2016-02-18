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
 * $Id: ClassImplementation.java,v 0.37 1998-01-30 11:04:43+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.1.24
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representation type of class implementation.
  *
  * @see ClassType
  * @see ClassInterface
  * @see GlobalProxy
  * @see ThrowableClass
  * @see Contants
  */

class ClassImplementation extends ClassType implements Constants {
  /**
    * interface for this 
    */
  protected ClassInterface interfase;
  
  /**
    * inherited implement 
    */
  protected ClassImplementation super_class;
  
  /**
    * table of defined attributes 
    */
  protected AttributeTable attribute_table;

  /**
    * table of defined constructor 
    */
  protected MethodTable constructor_table;
  
  /**
    * throwable class for exception handling 
  protected ThrowableClass throwable; */

  /**
    * create a class implementation representation
    * 
    * @param class_name class name
    * @param if_id interface class id
    * @param impl_id implementation class id
    * @param is_dynamic_instanciation if instantatiate dynamically
    */
  ClassImplementation (String class_name, String if_id, String impl_id,
		       boolean is_dynamic_instanciation) {
    super (class_name, impl_id);

    /* set this interface */
    if (if_id != null)
      interfase = (ClassInterface) ozc.getSchool ().searchAsClassID (if_id);
    if (!isProxy ()) {
      if (interfase != null)
	interfase.setImplementation (this);
      else
	interfase = new ClassInterface (class_name, if_id, 
					is_dynamic_instanciation, this);
    }
  }

  /**
    * create a class implementation representation
    * 
    * @param class_name class name
    * @param impl_id implementation class id
    * @param if class interface
    */
  ClassImplementation (String class_name, String impl_id,
		       ClassInterface cif) {
    super (class_name, impl_id);
    interfase = cif;
    if (interfase != null)
      interfase.setImplementation (this);
  }

  /**
    * for included class in a loaded class.
    * 
    * @param class_name class name
    * @param cid class id
    */
  ClassImplementation (String class_name, String cid) {
    this (class_name, cid /* + OzcProperty.INTERFACE_POSTFIX */, cid, false);
  }
 
  /** 
    * create a class implementation representation.
    * instantiation of this class is static.
    * 
    * @param class_name class name
    * @param if_id interface class id
    * @param impl_id implementation class id
    */
  ClassImplementation (String class_name, String if_id, String impl_id) {
    this (class_name, if_id, impl_id, false);
  }
     
  /**
    * for dummy class, not exists class in current specified school.
    *
    * @param class_name class name
    */
  ClassImplementation (String class_name) {
    this (class_name, null, null, false);

    /* not exist class, so not attempt to load */
    initialize ();
  }

  /**
    * access for super_class field.
    *
    * @return super_class field
    */
  ClassImplementation getSuperClass () { return super_class; }

  /**
    * access for interfase field.
    *
    * @return interfase filed
    */
  ClassInterface getInterface () { return interfase; }

  /**
    * access for constructor_table field.
    *
    * @return constructor_table field
    */
  MethodTable getConstructorTable () { return constructor_table; }

  /**
    * access for throwable field.
    *
    * @return throwable filed
  ThrowableClass getThrowable () { return throwable; } */

  /**
    * override 
    * 
    * @see ClassType
    */
  ClassList getSuperInterfaces () { return interfase.getSuperInterfaces (); }
    
  /**
    * override 
    *
    * @param ClassType
    */
  void initialize (int mod) {
    super.initialize (mod);
    attribute_table = new AttributeTable ();
    constructor_table = new MethodTable ();

/*     if (!isProxy () && !School.isSystem (this)) { */
/*       if (OzcProperty.search (name) == null) */
/* 	throwable = new ThrowableClass (this); */
/*     } */
  }
  
  /**
    * check if this class has constructor.
    * 
    * @return if has true, otherwise false.
    */
  boolean hasConstructor () { return constructor_table.size () > 0; }

  /**
    * override 
    * 
    * @see ClassType
    */
  int compare (Type t) throws TypeMismatch {
    try {
      return super.compare (t);
    } catch (TypeMismatch e) {
      if (!t.isClass ()) throw e;

      /* this means inheriting 'OzObject' */
      if (super_class == null) return 1;

      return ((ClassType) t) .compare (super_class);
    }
  }

  /**
    * register super class 
    *
    * @param c super class
    */
  void registerSuperClass (ClassImplementation c) {
    super_class = c;
  }

  /**
    * check about super class 
    */
  void checkSuperClass () {
    if (super_class == null) return;

    if (isProxy ()) {
      if (super_class != School.PROXY && !super_class.isProxy ())
	super_class = super_class.getInterface ().getProxy ();
    } else 
      checkAsSuperClass (super_class);
  }
  
  /**
    * register an attribute 
    *
    * @param a attribute
    */
  void registerAttribute (ClassMember a) {
    attribute_table.register (a);
  }

  /**
    * register an dummy attribute for error processing 
    *
    * @param a attribute
    * @param a attribute name
    */
  void registerAttribute (ClassMember a, String name) {
    attribute_table.register (a, name);
  }
  
  /**
    * register one or more attributes 
    *
    * @param id_list identifiers of attribute
    * @param t type of attribute
    * @param m modifier of attribute
    * @param a access modifier of attribute
    * @param pos offset in file
    */
  void registerAttributes (IdentifierList id_list, Type t, int m, int a, 
			   int start, int end) {
    /* attribute must not be 'public' */
    if (a == PUBLIC) {
      OzcError.publicAttribute ();
      return;
    }

    if ((m & ONCE) != 0 ||
	(m & STATIC) != 0 ||
	(m & LOCKED) != 0 ||
	(m & ABSTRACT) != 0) {
      OzcError.illegalModifierAttribute ();
      return;
    }

    java.util.Enumeration ids = id_list.elements ();
    ClassMember id;

    while (ids.hasMoreElements ()) {
      id = (ClassMember) ids.nextElement ();
      id.setType (t, m, a, this, start, end);
      registerAttribute (id);
    }
  }

  /**
    * register a constructor 
    *
    * @param m constructor
    */
  void registerConstructor (ClassMember m) {
    try {
      constructor_table.register (m);
      method_table.check (m);
    } catch (AlreadyDefined ex) {
      /* multiply defined */
      OzcError.alreadyDefined (m);
    }
  }

  /**
    * search constructor 
    * 
    * @param name name of constructor
    * @param type signature and return type of constrcutor
    */
  ClassMember searchConstructor (String name, MethodType type) {
    if (!load ()) return null;

    ClassMember m = constructor_table.search (name, type, NEW, 0);

    if (m != null || !isProxy ()) return m;

    if (super_class == null)
      return School.PROXY.searchConstructor (name, type);
    else
      return super_class.searchConstructor (name, type);
  }
  
  /**
    * override 
    *
    * @see ClassType
    */
  void registerMethod (ClassMember m) {
    if (m.isAbstract ()) {
      if (m.isPrivate ()) {
	OzcError.cannotPrivateAbstract (m);
	return;
      }

      /* abstract method must check if implemented at sub class 
       * public abstract methods were registered in this interface */
      if (!m.isPublic ())
	abstract_methods.addElement (m);
    }

    super.registerMethod (m);
  }

  /**
    * search an attribute.
    *
    * @param name attribute name
    * @param access accessing mode 
    * @return if found attribute, otherwise null 
    */
  ClassMember searchAttribute (String name, int access) {
    if (!load ()) return ClassMember.ANY;

    ClassMember attr = (ClassMember) attribute_table.search (name);

    if (attr != null) {
      if (access == PRIVATE) return attr;

      if (attr.access == PROTECTED) return attr;
    }

    if (ozc.getOzc ().isParsing ()) return null;

    if (super_class != null)
      return super_class.searchAttribute (name, PROTECTED);

    return null;
  }
  
  /**
    * search an attribute.
    *
    * @param name private attribute name.
    * @return if found attribute, otherwise null 
    */
  ClassMember searchAttribute (String name) {
    return searchAttribute (name, PRIVATE);
  }

  /**
    * override 
    *
    * @see ClassType
    */
  protected ClassMember searchInheritedMethod (String name, MethodType type, 
					       int access, int modifier_mask) {
    if ((modifier_mask & STATIC) == 0 /* && !isProtected () */) {
      ClassMember m = interfase.searchInheritedMethod (name, type, access, 
						       modifier_mask);
      if (m != null) return m;
    }

    if (super_class != null) {
      super_class.setParserAction (action_obj);
      return super_class.searchMethod (name, type, access, modifier_mask);
    }

    return null; 
  }

  /**
    * override 
    *
    * @see ClassType
    */
  protected ClassMember searchMethodDefinition (ClassMember method) {
    ClassMember m = super.searchMethodDefinition (method);
    if (m != null) return m;

    if (super_class != null) 
      return super_class.searchMethodDefinition (method);

    return null; 
  }
  
  /**
    * collect all abstract methods.
    *
    * @param abstract_methods checking abstract methods (list)
    */
  void getAbstractMethods (java.util.Hashtable abstract_methods) {
    if (School.isSystem (this)) return;

    super.getAbstractMethods (abstract_methods);

    if (super_class != null && super_class.isAbstract ()) 
      super_class.getAbstractMethods (abstract_methods);

    interfase.getAbstractMethods (abstract_methods);
  }

  /**
    * check:
    *  whether overriding method is eqaul with that definition 
    */
  void checkMethods () { checkMethods (null); }

  /**
    * check:
    *  whether overriding method is eqaul with that definition 
    *  whether implement any abstract method
    *
    * @param abstract_methods checking abstract methods (list)
    */
  private void checkMethods (java.util.Hashtable abstract_methods) {
    if (!load ()) {
      OzcError.cannotLoadFile (this);
      return;
    }

    //JP.go.ipa.oz.system.OzSystem.println (this.toString ());
    //JP.go.ipa.oz.system.OzSystem.println (this.getInterface ().toString ());

    if (super_class != null && !School.isSystem (super_class))
      /*	OzcClassLoader.isNotSystem (super_class) &&
	OzcClassLoader.isNotJDK (super_class)) */
      super_class.checkMethods (abstract_methods);

    for (java.util.Enumeration ms = method_table.elements (); 
	 ms.hasMoreElements (); ) {
      ClassMember m = (ClassMember) ms.nextElement ();

      if (m.isNew ()) continue;

      ClassMember md = null;
      
      if (m.isPublic () /* && !isProtected () */ && interfase != null)
	md = interfase.searchMethodDefinition (m);

      ClassMember md_impl = null;
      if (super_class != null) {
	md_impl = super_class.searchMethodDefinition (m);

	if (md == null) md = md_impl;
      } 
	
      if (md == null) {
	if (m.isPublic () && /* !isProtected () && */
	    !m.getName ().startsWith (OzcProperty.STATIC_PREFIX))
	  OzcError.notDefinedAsInterface (m);
	continue;
      }
      
      m.setDefinedClass (md.getDefinedClass ());
      
      /* implemented abstract method */
      if (abstract_methods != null && (!m.isAbstract () || isProxy ()) &&
	  (md.isAbstract () || md.isPublic ()))
	abstract_methods.remove (m.type.toString ());

      if (md_impl != null && md_impl.isFinal ())
	OzcError.cannotOverrideFinal (m);
    }
  }

  /**
    * check for each constructor body 
    */
  private void checkConstructors () {
    for (java.util.Enumeration ms = constructor_table.elements (); 
	 ms.hasMoreElements (); ) {
      ClassMember m = (ClassMember) ms.nextElement ();

      MethodType mtype = (MethodType) m.getType ();
      mtype.check ();
    }
  }

  /**
    * override 
    *
    * @see ClassType
    */
  void check () {
    checkSuperClass ();

    if (!isAbstract () && !isProxy ()) {
      java.util.Hashtable abstract_methods = new java.util.Hashtable ();
      getAbstractMethods (abstract_methods);
      
      /*
      ozc.debugln (this + ": abstract methods");
      OzcError.printMethods (abstract_methods.elements ());
      */

      checkMethods (abstract_methods);
      checkConstructors ();

      if (abstract_methods.size () != 0)
	OzcError.someAbstractMethodsNotImplemented (abstract_methods.elements ());
    } else {
      checkMethods ();
      checkConstructors ();
    }

    for (java.util.Enumeration ms = method_table.elements (); 
	 ms.hasMoreElements (); ) {
      ClassMember m = (ClassMember) ms.nextElement ();

      if (m.isAbstract ()) continue;

      MethodType mtype = (MethodType) m.getType ();
      if (mtype.getBody () != null) mtype.check ();
    }
    
    for (java.util.Enumeration ms = attribute_table.elements (); 
	 ms.hasMoreElements (); ) {
      ClassMember m = (ClassMember) ms.nextElement ();

      if (super_class.searchAttribute (m.name, PROTECTED) != null) {
	OzcError.cannotHide (m);
      }
    }
    
    if (!isProtected () && !isProxy ()) interfase.checkIntegrity ();
  }

  /**
    * check if a class contains as super class.
    * 
    * @param c class
    */
  boolean containsAsSuperClass (ClassImplementation c) {
    /* implmentation inheritance represent as interface inheritance
     * in interface definition. */
    return interfase.containsAsSuperInterface (c.getInterface ()) ||
      c == School.ROOT || c == School.CELL;
  }

  /** 
    * override
    *
    * @see ClassType
    */
  void emitHeader () {
    emitModifier ();

    if (Emitter.isEmitting ()) {
      Emitter.emit ("public class " + class_id + " extends ");
      if (super_class == null) {
	if (isProxy ()) {
	  String cid = interfase.getProxy ().toString () /* + OzcProperty.PROXY_PCL_POSTFIX */;
	  Emitter.emit (cid);
	}
      } else {
	Emitter.emit (super_class);
      }

      if (interfase != null && !isProtected ())
	Emitter.emit (" implements " + interfase);
    } else {
      if (isGlobal ()) 
	Emitter.emit ("cell " + name);
      else
	Emitter.emit ("class " + name);

      ClassList si = interfase.getSuperInterfaces ();
      if (si.size () > 0 || super_class != null) {
	Emitter.emit (" : ");
	if (super_class != null) {
	  Emitter.emit ("*");
	  Emitter.emit (super_class);

	  if (si.size () > 0) {
	    Emitter.emit (", ");
	    Emitter.emit (si.toStringWithComma ());
	  }
	}
      }
    }
  }

  /**
    * override 
    *
    * @see ClassType 
    */
  void emitBody () {
    GlobalProxy gp = isProxy () ? (GlobalProxy) this : null;

    if (!isProxy ()) {
      /* emit attributes */
      attribute_table.emit ();
    } 

    /* emit constructors */
    if (!isProxy ()) constructor_table.emitImplementation (gp);
    
    /* emit methods */
    method_table.emitImplementation (gp);
    
    if (isProxy ()) return;

    if (Emitter.isEmitting ()) {
      Emitter.emitln ();
      if (isGlobal ()) {
	Emitter.emitln ("public " + class_id + " () { super (\"" 
			+ interfase.getProxy () + 
			/* OzcProperty.PROXY_PCL_POSTFIX + */ "\"); }");
	Emitter.emitln ();
	Emitter.emitln ("public " + class_id + 
			" (String proxy_id) { super (proxy_id); }");
      } else {
	Emitter.emitln ("public " + class_id + 
			" () throws Exception { super (); }");
      }
    }
  }

  /** 
    * override
    *
    * @see ClassType
    */
  void emitDefinitionForBrowser () {
    Emitter.emit ("j, " + getFullyQualifiedClassID ());
    Emitter.emit (", 0x" + Integer.toHexString (modifier));
    Emitter.emit (", " + interfase.getFullyQualifiedClassID ());
    if (super_class != null)
      Emitter.emit (", " + super_class.getFullyQualifiedClassID ());
    Emitter.emitln ();
    
    attribute_table.emit ();
    constructor_table.emitInterface ();
    method_table.emitInterface ();
  }
}

/* EOF */
