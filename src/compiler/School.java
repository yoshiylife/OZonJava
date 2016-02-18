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
 * $Id: School.java,v 0.15 1997-07-07 10:25:57+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.9
 */

package JP.go.ipa.oz.compiler;

import java.io.*;

/**
  * A class handling school (symbol table of class name),
  *
  * @see java.util.Hashtable
  */

class School extends java.util.Hashtable {
  /**
    * scanner 
    */
  private scanner scan;
  
  /**
    * number of lines 
    */
  private int no_lines;

  /**
    * table of class id 
    */
  private java.util.Hashtable class_id_table;

  /**
    * Root class 
    */
  static ClassImplementation ROOT;

  /**
    * String class 
    */
  static ClassImplementation STRING;
  
  /**
    * Proxy of cell class
    */
  static ClassImplementation PROXY;
  
  /**
    * Cell class
    */
  static ClassImplementation CELL;
  
  /**
    * create new one 
    */
  School () {
    super ();
    class_id_table = new java.util.Hashtable ();
  }

  /**
    * search class 
    *
    * @param name name of class
    * @return class
    */
  ClassImplementation search (String name) {
    return (ClassImplementation) get (name);
  }

  /**
    * search class
    *
    * @param cid class id
    * @return class
    */
  ClassType searchAsClassID (String cid) {
    return (ClassType) class_id_table.get (cid);
  }

  /**
    * register class 
    *
    * @param c class
    * @param name class name
    */
  void register (ClassImplementation c, String name) {
    if (containsKey (name)) return;

    try {
      put (name, c);
      ClassInterface i = c.getInterface ();

      String if_id = null;
      if (i != null)
	if_id = i.getFullyQualifiedClassID ();
      if (if_id != null) 
	class_id_table.put (if_id, i);


      String impl_id = c.getFullyQualifiedClassID ();
      if (impl_id != null && if_id != impl_id)
	class_id_table.put (impl_id, c);

    } catch (NullPointerException ex) {
      ozc.catchException (ex);
    }
  }

  /**
    * loading school from file  to table of class 
    *
    * @param file file name
    */
  void load (String file) throws IOException {
    ClassInterface cif;

    cif = new ClassInterface (OzcProperty.OZ_ROOT, 
			      OzcProperty.ROOT_IF);
    ROOT = new ClassImplementation (OzcProperty.OZ_ROOT, 
				    OzcProperty.ROOT_CL, cif);
    register (ROOT, OzcProperty.OZ_ROOT);

    cif = new ClassInterface (OzcProperty.OZ_STRING, 
			      OzcProperty.STRING_IF);
    STRING = new ClassImplementation (OzcProperty.OZ_STRING, 
				      OzcProperty.STRING_CL, cif);
    register (STRING, OzcProperty.OZ_STRING);

    cif = new ClassInterface (OzcProperty.OZ_PROXY, 
			      OzcProperty.PROXY_IF);
    PROXY = new ClassImplementation (OzcProperty.OZ_PROXY, 
				     OzcProperty.PROXY_CL, cif);
    register (PROXY, OzcProperty.OZ_PROXY);

    CELL = new ClassImplementation (OzcProperty.OZ_CELL, 
				    OzcProperty.COMMON_CELL_ROOT, cif);
    register (CELL, OzcProperty.OZ_CELL);

    if (file == null) return;

    scan = new scanner (file);
    no_lines = 1;

    java_cup.runtime.token t = scan.getNextToken ();
  next_line:
    while (t.sym != sym.EOF) {
      String class_name;
      String if_id = null, impl_id = null;
      boolean which = false;
	
    one_line:
      {
	if (t.sym != sym.STRING_LITERAL)
	  {
	    skip_one_line (file);
	    continue;
	  }
	class_name = ((OzStrToken) t).str_val;
	class_name = class_name.substring (1, class_name.length () - 1);
	
	t = scan.getNextToken ();
	for (int i = 0; i < 2; i++) {
	  if (t.sym != sym.COMMA)
	    {
	      skip_one_line (file);
	      continue next_line;
	    }

	  t = scan.getNextToken ();
	  if (t.sym != sym.STRING_LITERAL)
	    {
	      skip_one_line (file);
	      continue next_line;
	    }

	  String buf = ((OzStrToken) t).str_val;
	  buf = buf.substring (1, buf.length () - 1);
	

	  if (i == 0)
	    if_id = buf;
	    else 
	      impl_id = buf;

	  t = scan.getNextToken ();
	  if (end_of_line (t)) {
	    break one_line;
	  }
	}
	
	if (t.sym != sym.COMMA)
	  {
	    skip_one_line (file);
	    continue next_line;
	  }
	
	t = scan.getNextToken ();
	if (t.sym == sym.TRUE)
	  which = true;
	else if (t.sym == sym.FALSE)
	  which = false;
	else
	  {
	    skip_one_line (file);
	    continue next_line;
	  }

	t = scan.getNextToken ();
	if (!end_of_line (t))
	  skip_one_line (file);
      }

      /* add class name postfix */
      if_id += OzcProperty.INTERFACE_POSTFIX;
      impl_id += OzcProperty.IMPLEMENTATION_POSTFIX;
	
      /* register one class to class table */
      ClassImplementation c 
	= new ClassImplementation (class_name, if_id, impl_id, which);
      register (c, class_name);

      /* setup OzObject and OzGlobalObject */
      if (impl_id.equals (OzcProperty.ROOT_CL))
	ROOT = c;
      if (impl_id.equals (OzcProperty.PROXY_CL))
	PROXY = c;
      if (impl_id.equals (OzcProperty.STRING_CL))
	STRING = c;
      if (impl_id.equals (OzcProperty.COMMON_CELL_ROOT))
	CELL = c;
    }
  }

  /**
    * check if class is system class 
    *
    * @param c class
    * @return if so true, otherwise false
    */
  static boolean isSystem (ClassType c) {
    if (c instanceof ClassImplementation)
      return c == ROOT || c == STRING || c == PROXY || c == CELL;
    else {
      ClassImplementation ci = ((ClassInterface) c).getImplementation ();
      return ci == ROOT || ci == STRING || ci == PROXY || ci == CELL;
    }
  }

  /**
    * skip to end of line 
    *
    * @param file file name
    */
  private void skip_one_line (String file) throws IOException  {
    ozc.debugln (file + ":" + no_lines + ": illegal entry.");
    while (!end_of_line (scan.getNextToken ())) ;
  }

  /**
    * check if encounter end of line 
    *
    * @param t token
    * @return if so true, otherwise false
    */
  private boolean end_of_line (java_cup.runtime.token t) {
    if (t.sym == sym.EOF)
      return true;

    if (no_lines < scan.line_no) {
      no_lines++;
      return true;
    } else 
      return false;
  }
}

/* EOF */
