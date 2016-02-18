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
 * $Id: OzOzc_cl.java,v 0.20 1997-11-13 16:44:05+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1997.5.27
 */

package JP.go.ipa.oz.compiler;

import JP.go.ipa.oz.lib.standard.*;
import JP.go.ipa.oz.system.*;

/**
  * main class to use with OZ level school
  *
  * @see OzOzc_if
  * @see ozc
  */

public class OzOzc_cl extends ozc implements OzOzc_if {
  /**
    * compiler 
    */
  OzSchool_if oz_school;
  
  /**
    * access for compiler field
    *
    * @return compiler
    */
  private static OzSchool_if getOzSchool () {
    OzSchool_if sc = ((OzOzc_cl) getOzc ()).oz_school;
    //    OzSystem.println ("OzSchool_if: " + sc.getClass ().getClassLoader ());
    return sc;
  }

  /**
    * contructor for OZ 
    *
    * return this
    */
  public Object _new_create () {
    return this;
  }

  /**
    * invoke compilation 
    *
    * @param source source file name
    * @param dir output directory
    * @return if sucess true, otherwise false
    */
  public boolean compile (_String_if source, OzSchool_if sc, _String_if dir) {
    String[] av = new String [1];
    av[0] = convertToString (source);
    oz_school = sc;
    if (dir != null)
      output_directory = dir.toString ();
    return compile (av);
  }

  /**
    * invoke compilation 
    *
    * @param source source file name
    * @return if sucess true, otherwise false
    */
  public boolean compile (_String_if source, OzSchool_if sc) {
    _String_if dir = null;
    return compile (source, sc, dir);
  }

  /**
    * invoke compilation 
    *
    * @param source source file name
    * @param output logging destination
    * @param dir output directory
    * @return if sucess true, otherwise false
    */
  public boolean compile (_String_if source, OzSchool_if sc, 
			  _Writer_if output, _String_if dir) {
    
    // JP.go.ipa.oz.system.OzSystem.println (sc instanceof OzSchool_if ? "true" : "false");
    // OzSystem.println ("OzSchool_if: " + sc.getClass ().getClassLoader ());
    
    String[] av = new String [2];
    av[0] = ozc.VERBOSE;
    av[1] = convertToString (source);
    oz_school = sc;
    if (dir != null)
      output_directory = dir.toString ();
    return compile (av, new OzOutput (output));
  }

  /**
    * invoke compilation 
    *
    * @param source source file name
    * @param output logging destination
    * @return if sucess true, otherwise false
    */
  public boolean compile (_String_if source, OzSchool_if sc, 
			  _Writer_if output) {
    return compile (source, sc, output, null);
  }

  /**
    * invoke compilation of interface
    *
    * @param source source file name
    * @param dir output directory
    * @return if sucess true, otherwise false
    */
  public boolean compileInterface (_String_if source, OzSchool_if sc,
				   _String_if dir) {
    String[] av = new String [2];
    av[0] = ozc.INTERFACE;
    av[1] = convertToString (source);
    oz_school = sc;
    if (dir != null)
      output_directory = dir.toString ();
    return compile (av);
  }

  /**
    * invoke compilation of interface
    *
    * @param source source file name
    * @return if sucess true, otherwise false
    */
  public boolean compileInterface (_String_if source, OzSchool_if sc) {
    _String_if dir = null;
    return compileInterface (source, sc, dir);
  }

  /**
    * invoke compilation of interface
    *
    * @param source source file name
    * @param output logging destination
    * @param dir output directory
    * @return if sucess true, otherwise false
    */
  public boolean compileInterface (_String_if source, OzSchool_if sc, 
				   _Writer_if output, _String_if dir) {
    String[] av = new String [3];
    av[0] = ozc.INTERFACE;
    av[1] = ozc.VERBOSE;
    av[2] = convertToString (source);
    oz_school = sc;
    if (dir != null)
      output_directory = dir.toString ();
    return compile (av, new OzOutput (output));
  }

  /**
    * invoke compilation of interface
    *
    * @param source source file name
    * @param output logging destination
    * @return if sucess true, otherwise false
    */
  public boolean compileInterface (_String_if source, OzSchool_if sc, 
				   _Writer_if output) {
    return compileInterface (source, sc, output, null);
  }

  /**
    * override (do nothing here) 
    *
    * @see ozc
  protected void setupSchool (String s) { 
    super.setupSchool ("/user/otokawa/oz/ozc/jdk-1.1/work/lib/JP/go/ipa/oz/user/test_0/school.s");
  } 
    */

  /**
    * convert OZ String to Java String
    */
  static private String convertToString (_String_if s) {
    if (s == null) return null;
    return s.toString ();
  }

  /**
    * search class id for interface 
    *
    * @param name name of class interface
    * @return class id
    */
  static String searchInterface (String name) {
    try {
      _String_if cid = getOzSchool ().getInterfaceID (new _String_cl (name));
      // JP.go.ipa.oz.system.OzSystem.println ("" + cid);
      return convertToString (cid);
    } catch (Exception e) {
      return null;
    }
  }

  /**
    * search class name as interface
    *
    * @param name class id
    * @return class name
    */
  static String searchAsInterface (String cid) {
    //    cid = cid.substring (0, cid.lastIndexOf ('_'));
    try {
      _String_if name 
	= getOzSchool ().getNameOfInterface (new _String_cl (cid));
      /*
      if (name == null) {
	String domain = getOzc ().domain;
	if (!cid.startsWith (domain)) return null;
	cid = cid.substring (domain.length ());
	//JP.go.ipa.oz.system.OzSystem.println ("search: " + cid);
	name = getOzSchool ().getNameOfInterface (new _String_cl (cid));      
      }
      */
      return convertToString (name);
    } catch (Exception e) {
      return null;
    }
  }

  /**
    * search class name as implementation
    *
    * @param name class id
    * @return class name
    */
  static String searchAsImplementation (String cid) {
    /*
    int index = cid.lastIndexOf ('_');
    if (index > 0)
      cid = cid.substring (0, index);
      */
    try {
      _String_if name 
	= getOzSchool ().getNameOfImplementation (new _String_cl (cid));
      /*
      if (name == null) {
	String domain = getOzc ().domain;
	if (!cid.startsWith (domain)) return null;
	cid = cid.substring (domain.length ());
	//JP.go.ipa.oz.system.OzSystem.println ("search: " + cid);
	name = getOzSchool ().getNameOfImplementation (new _String_cl (cid));      
      }
      */
      return convertToString (name);
    } catch (Exception e) {
      return null;
    }
  }

  /** 
    * search class id for implementation 
    *
    * @param name name of class implementation
    * @return class id
    */
  static String searchImplementation (String name) {
    try {
      _String_if cid 
	= getOzSchool ().getImplementationID (new _String_cl (name));
      return convertToString (cid);
    } catch (Exception e) {
      return null;
    }
  }

  /**
    * display usage 
    *
    * @return usage string
    */
  public _String_if displayUsage () {
    String[] av = new String [1];
    av[0] = ozc.HELP;
    java.io.StringWriter out = new java.io.StringWriter ();
    compile (av, new Output (out));
    return new _String_cl (out.toString ());
  }

  /**
    * set domain name
    *
    * @param name domain name
    */
  public void setDomain (_String_if name) {
    domain = name.toString ();
  }


  /**
    * prepare school
    *
    * @param school_source school file name
    */
  protected void setupSchool (String not_used) {
    school = new OzSchool ();
    try {
      school.load (null);
    } catch (java.io.IOException e) {
      OzcError.cannotLoadSchool (null);
    }
  }
}

/* EOF */
