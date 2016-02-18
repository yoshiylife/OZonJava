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
 * $Id: OzcClassLoader.java,v 0.20 1998-01-30 11:05:01+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.1.9
 */

package JP.go.ipa.oz.compiler;

import java.io.*;
import java.lang.reflect.*;

/**
  * A class representing loader of class file.
  *
  * @see Constants
  */

class OzcClassLoader implements Constants {
  /**
    * get meta class object 
    *
    * @param cls class
    */
  private static Class getClass (ClassType cls) {
    String fc = cls.getFullyQualifiedClassID ();

    if (fc == null) return null;

    try {
      return Class.forName (fc);
    } catch (ClassNotFoundException e) {
      return null;
    } catch (IllegalAccessError e) {
      return null;
    } catch (NoClassDefFoundError e) {
      return null;
    }
  }

  /**
    * check if class has been compiled 
    *
    * @param cls class
    * @return if so true, otherwise false
    */
  static boolean exists (ClassType cls) {
    return getClass (cls) != null;
  }

  /**
    * loading class info. 
    *
    * @param cls class
    * @param action ParserAction instance
    */
  static boolean load (ClassType cls, ParserAction action) {
    Class cl = getClass (cls);
    
    /* not found */
    if (cl == null) return false;

    //JP.go.ipa.oz.system.OzSystem.println (cl.toString ());

    /* methods */
    Method[] md = cl.getDeclaredMethods ();
    /*
     * some classes not found 
     */
    if (md == null) return false;

    if (ozc.isVerbose ()) {
      if (cls.isClassInterface ())
	ozc.debugln (cls + ": loading class file of interface.");
      else
	ozc.debugln (cls + ": loading class file of implementation.");
    }

    try {
      /* init some tables of class */
      Class[] ifs = cl.getInterfaces ();
      int modifier = classModifiers (cl.getModifiers (), cl.isInterface ());
      int fd_top = 0;

      /* read special attributes for modifier */
      Field[] fd = cl.getDeclaredFields ();
      for (int i = 0; fd != null && i < fd.length; i++) {
	String name = fd[i].getName ();

	if (name.equals (OzcProperty.GLOBAL_MODIFIER) ) {
	  modifier |= GLOBAL;
	} else if (name.equals (OzcProperty.FINAL_MODIFIER) ) {
	  modifier |= FINAL;
	} else {
	  fd_top = i;
	  break;
	}
      }

      if (!cls.isClassInterface ()) {
	ClassImplementation ci = (ClassImplementation) cls;
	cls.initialize (modifier);

	if (!isNotSystem (ci) || !isNotJDK (ci)) 
	  ci.getInterface().initialize (modifier, 
					ifs == null ? 0 : ifs.length);

	Class sc = cl.getSuperclass ();
	if (sc != null) {
	  ClassType ct = (ClassType) convertType (sc, action);
	  if (ct != null /* && isNotJDK (ct) && isNotSystem (ct) */)
	    ci.registerSuperClass ((ClassImplementation) ct);
	}
      } else {
	ClassInterface ci = (ClassInterface) cls;
	if (ifs == null) 
	  ci.initialize (modifier, 0);
	else {
	  ci.initialize (modifier, ifs.length);
	  /* super interfaces */
	  for (int i = 0; i < ifs.length; i++) {
	    ClassType ct = (ClassType) convertType (ifs[i], action);
	    /*	    if (isNotJDK (ct) && isNotSystem (ct) ) */
	      ci.registerSuperInterface ((ClassInterface) ct);
	  }
	}
      }

      for (int i = 0; md != null && i < md.length; i++) {
	setMethod (md[i], cls, action);
      }

      if (cls.isClassInterface ()) return true;

      /* attributes */
      for (int i = fd_top; fd != null && i < fd.length; i++) {
	setAttribute (fd[i], cls, action);
      }
    } catch (Exception ex) {
      ozc.catchException (ex);
    }

    return true;
  }

  /**
    * check package of class is not JDK package 
    *
    * @param ct class
    * @return if so true, otherwise false
    */
  static boolean isNotJDK (ClassType ct) {
    String pk = ct.getPackage ();
    return pk != null && !pk.startsWith (JDK_PACKAGE_PREFIX);
  }

  /**
    * check package is not OZ system package 
    *
    * @param ct class
    * @return if so true, otherwise false
    */
  static boolean isNotSystem(ClassType ct) {
    String pk = ct.getPackage();
    return pk != null && !pk.startsWith (OzcProperty.SYSTEM_PACKAGE_PREFIX);
  }
  
  /**
    * set one method definition 
    *
    * @param mt method
    * @param c class
    * @param action ParserAction instance
    */
  private static void setMethod (Method mt, 
				 ClassType c, ParserAction action) {
    String name = mt.getName ();
    int modifiers = mt.getModifiers ();
    int amod = getAccessModifiers (modifiers);
    int mod = getAttributeModifiers (modifiers);

    Class[] args = mt.getParameterTypes ();

    IdentifierList il = new IdentifierList ();
    for (int i = 0, len = args.length; i < len; i++) {	
      Type type = convertType (args[i], action);
      Identifier id = new Identifier (type);
      il.add (id);
    }

    if (name.startsWith (OzcProperty.NEW_PREFIX)) {
      amod = NEW;
      name = name.substring (OzcProperty.NEW_PREFIX.length ());
    } else if (name.startsWith (OzcProperty.FINAL_PREFIX)) {
      mod |= FINAL;
      name = name.substring (OzcProperty.FINAL_PREFIX.length ());
    }

    if (Modifier.isAbstract (modifiers) && amod != NEW) 
      mod |= ABSTRACT;

    Type rt;
    if (amod == NEW)
      rt = PrimitiveType.VOID;
    else
      rt = convertType (mt.getReturnType (), action);

    MethodType mt2 = new MethodType (name, rt, il);
    ClassType ci = c;
    if (amod == PUBLIC) {
      if (!c.isClassInterface ())
	ci = ((ClassImplementation) c).getInterface ();

      /* if (!isNotSystem (c)) c = ci; */
    } 

    ClassMember method = new ClassMember (name, mt2, mod, amod, ci);
    mt2.setMethod (method);
    if (amod == NEW) {
      if (!c.isClassInterface ())
	((ClassImplementation) c).registerConstructor (method);
    } else {
      c.registerMethod (method);
    }
  }

  /**
    * set one attribute definition 
    * 
    * @param fd field (class member)
    * @param c class
    * @param action ParserAction instance
    */
  private static void setAttribute (Field fd, 
				    ClassType c, ParserAction action) {
    String name = fd.getName ();
    int modifiers = fd.getModifiers ();
    int amod = getAccessModifiers (modifiers);
    int mod = getAttributeModifiers (modifiers);

    ClassMember attr = new ClassMember (name, 
					convertType (fd.getType (), action), 
					mod, amod, c);
    ((ClassImplementation) c).registerAttribute (attr);
  }

  /**
    * parser java field modifiers 
    *
    * @param modifiers modifier value of Java class
    * @return modifier value of OZ class
    */
  private static int getAttributeModifiers (int modifiers) {
    int mod = 0;

    if (Modifier.isStatic (modifiers))
      mod |= STATIC;
    if (Modifier.isTransient (modifiers))
      mod |= TRANSIENT;
    if (Modifier.isFinal (modifiers))
      mod |= FINAL;

    return mod;
  }

  /**
    * parser java field modifiers 
    *
    * @param modifiers modifier value of Java class
    * @return modifier value of OZ class
    */
  private static int getAccessModifiers (int modifiers) {
    int amod = 0;
    
    if (Modifier.isPublic (modifiers))
      amod = PUBLIC;
    else if (Modifier.isProtected (modifiers))
      amod = PROTECTED;
    else 
      amod = PRIVATE;

    return amod;
  }

  /**
    * conversion from java internal type to this internal type 
    *
    * @param t type of Java
    * @param action ParserAction instance
    * @return converted type
    */ 
  private static Type convertType (Class t, ParserAction action) {
    if (t == Byte.TYPE) {
      return PrimitiveType.BYTE;
    }
    if (t == Character.TYPE) {
      return PrimitiveType.CHAR;
    }
    if (t == Short.TYPE) {
      return PrimitiveType.SHORT;
    }
    if (t == Integer.TYPE) {
      return PrimitiveType.INT;
    }
    if (t == Long.TYPE) {
      return PrimitiveType.LONG;
    }
    if (t == Float.TYPE) {
      return PrimitiveType.FLOAT;
    }
    if (t == Double.TYPE) {
      return PrimitiveType.DOUBLE;
    }
    if (t == Boolean.TYPE) {
      return PrimitiveType.BOOL;
    }
    if (t == Void.TYPE) {
      return PrimitiveType.VOID;
    }
    if (t.isArray ()) {
      return null;
    }
 
    /* class type */
    String name = t.getName ();

    if (name.equals (OzcProperty.CONDITION)) {
      return PrimitiveType.CONDITION;
    }

    ClassType c = ozc.getSchool ().searchAsClassID (name);
    if (c != null) {
      c.setParserAction (action);
      return c;
    }
    
    //JP.go.ipa.oz.system.OzSystem.println (name);

    Class cl;
    try {
      cl = Class.forName (name);
    } catch (ClassNotFoundException e) {
      return new ClassInterface (name, name);
    }

    if (cl.isInterface ())
      return new ClassInterface (name, name);
    else {
      Class[] ifs = cl.getInterfaces ();

      if (ifs != null && ifs.length > 0) {
	ClassImplementation ci = new ClassImplementation (name, ifs[0].getName (), name);
	ozc.getSchool ().register (ci, name);
	return ci;
      } else
	return new ClassImplementation (name, name);
    }
  }
  
  /**
    * parser java class modifiers 
    *
    * @param cl class
    * @param modifiers modifier value of Java class
    * @param name name of Java class
    * @return modifier value of OZ class
    */
  private static int classModifiers (int modifiers, boolean is_interface) {
    int mod = 0;

    if (Modifier.isFinal (modifiers)) 
      mod |= (FINAL /* | JAVA_FINAL */);
    if (Modifier.isStatic (modifiers))
      mod |= STATIC;
    if (!is_interface && Modifier.isAbstract (modifiers))
      mod |= ABSTRACT;
    if (Modifier.isPublic (modifiers))
      mod |= PUBLIC;

    return mod;
  }
}

/* EOF */
