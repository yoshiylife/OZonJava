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
 * $Id: Emitter.java,v 0.22 1997-11-19 16:11:28+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.3
 */

package JP.go.ipa.oz.compiler;

import java.io.*;
import JP.go.ipa.oz.system.*;

/**
  * A class processing output
  */

class Emitter {
  /**
    * indentaion space 
    */
  String indent;
  
  /**
    * current output target 
    */
  Output output;
  
  /**
    * flag;
    */
  boolean status;
  
  /**
    * flag whether print (false) or emit (true) 
    */
  int emitting;
  static int NOT_EMITTING = 0;
  static int EMITTING = 1;
  static int EMITTING_INFO = 2;
  
  
  /**
    * identifier postfix 
    */
  int postfix;
  
  /**
    * storage for indent, output, emitting and postfix 
    */
  static Emitter emitter_obj;

  /** 
    * previous storage 
    */
  Emitter previous_emitter_obj;

  /**
    * classes to need compilation
    */
  java.util.Vector need_compiles;

  /**
    * output directory for release compilation
    */
  String output_directory;

  /**
    * internally use 
    */
  Emitter () {
    indent = "";
    output = ozc.getLog ();
    need_compiles = new java.util.Vector ();
  }

  /**
    * get additional postfix value of identifier 
    *
    * @return postfix value
    */
  static int getPostfix () { return ++emitter_obj.postfix; }

  /**
    * get indentation string 
    *
    * @return indentation space string
    */
  static String getIndent () { return emitter_obj.indent; }

  /**
    * check if now emitting 
    *
    * @return if so true, otherwise false.
    */
  static boolean isEmitting () { return emitter_obj.emitting == EMITTING; }

  /**
    * check if now emitting for browser
    *
    * @return if so true, otherwise false.
    */
  static boolean isEmittingForBrowser () { 
    return emitter_obj.emitting == EMITTING_INFO; 
  }

  /**
    * add indentation 
    */
  static void indentPush () { emitter_obj.indent += "  "; }

  /**
    * reduce indentation 
    */
  static void indentPop () {  
    emitter_obj.indent = emitter_obj.indent.substring (2); 
  }
  
  /**
    * creating output file 
    * 
    * @param c emitting class
    * @return file name.
    */
  String create_output_file (ClassType c, String postfix) {
    String fc = c.getFullyQualifiedClassID ();
    String file_name = c.getClassID () + postfix;
    try {
      if (output_directory != null) {
	/* release compiltation */
	
	String path = output_directory + file_name;
	output = new Output (new FileWriter (path));
	return path;
      } else {
	OzClassFile file = OzClassFile.search (fc, file_name);
	output 
	  = new Output (new PrintWriter (file.getOutputStream (), true));
	String s = file.getPath ();
	return s;
      }
    } catch (Exception e) {
      OzcError.cannotCreateJavaFile (c);
      return null;
    }
  }

  /**
    * creating output file for java code
    * 
    * @param c emitting class
    * @return file name.
    */
  String create_output_file_for_java (ClassType c) {
    return create_output_file (c, OzcProperty.JAVA_SUFFIX);
  }

  /**
    * creating output file for browser
    * 
    * @param c emitting class
    * @return file name.
    */
  String create_output_file_for_browser (ClassType c) {
    return create_output_file (c, OzcProperty.CLASS_INFO_SUFFIX);
  }

  /**
    * creating output file for source copy
    * 
    * @param c emitting class
    * @return file name.
    */
  String create_output_file_for_source (ClassType c) {
    return create_output_file (c, OzcProperty.SOURCE_SUFFIX);
  }

  /**
    * start emitting  
    */
  static void initialize () {
    emitter_obj.emitting = EMITTING;
  }

  /** 
    * start parsing 
    */
  static void reset () {
    Emitter prev = emitter_obj;
    emitter_obj = new Emitter ();
    emitter_obj.previous_emitter_obj = prev;
  }
  
  /**
    * end emittig 
    */
  static void finish () {
    emitter_obj = emitter_obj.previous_emitter_obj;
  }

  /**
    * generate executable code 
    *
    * @param source source file name
    * @param c_list emitting classes
    * @param dir output directory
    * @return if success true, otherwise false.
    */
  static boolean generate (String source, ClassList c_list, 
			   java.util.Vector java_files, String dir) {
    boolean status = true;

    synchronized (emitter_obj) {
      initialize ();

      if (dir != null) {
	if (dir.endsWith (File.separator))
	  emitter_obj.output_directory = dir;
	else
	  emitter_obj.output_directory = dir + File.separator;
      }

      status = emitter_obj.emitAll (source, c_list, java_files);

      for (int i = 0, size = emitter_obj.need_compiles.size (); i < size; i++) 
	status = !((ClassType) emitter_obj.need_compiles.elementAt (i)).compile (source) ? false : status;

      finish ();
    }

    return status ;
  }
    
  
  /**
    * java compiling 
    *
    * @param srcs java sources
    * @return if success true, otherwise false.
  private static boolean javaCompile (String srcs[]) {
    sun.tools.javac.Main javac = new sun.tools.javac.Main (ozc.getLog (), 
							   "ozc");

    if (ozc.isVerbose ()) {
      for (int i = 1; i < srcs.length; i++)
	ozc.debugln (srcs[i] + ": compiling java code.");
    }

    if (!javac.compile (srcs)) return false;
    
    return true;
  }
    */

  /**
    * emitting definitions of classes 
    *
    * @param source source file name
    * @param c_list emitting class
    * @return if success true, otherwise false
    */
  private boolean emitAll (String source, ClassList c_list, 
			   java.util.Vector j_srcs) {
    int size = c_list.size ();
    
    int j = 0;
    for (int i = 0; i < size; i++) {
      ClassType c = (ClassType) c_list.elementAt (i);
      
      if (isEmitting () && c.isProtected () && c instanceof ClassInterface) {
	/* interface of protected class not emitted */
	continue;
      }

      String src = create_output_file_for_java (c);
      if (src == null) return false;

      if (ozc.isVerbose ())
	ozc.debugln (src + ": emitting.");

      this.status = true;
      c.emitDefinition ();
      emitln ();
      output.close ();

      if (!this.status) return false;

      j_srcs.addElement (src);

      if (!c.isProxy ()) {
	src = create_output_file_for_browser (c);
	if (src == null) return false;

	emitting = EMITTING_INFO;

	if (ozc.isVerbose ())
	  ozc.debugln (src + ": emitting.");

	c.emitDefinitionForBrowser ();
	output.close ();
	
	emitting = EMITTING;

	if (c instanceof ClassImplementation) {
	  /* copy source file */
	  src = create_output_file_for_source (c);
	  if (src == null) return false;
	  copySource (source);
	}
      }
    }

    /*
    String[] j_srcs_non_protected = new String[j + 1];
    j_srcs_non_protected[0] = "-g";
    for (int i = 0; i < j; i++) 
      j_srcs_non_protected[i + 1] = j_srcs[i];
    
    return j_srcs_non_protected;
    */
    return true;
  }

  /** 
    * copy source file 
    *
    * @param source source file name
    */
  void copySource (String source) {
    try {
      FileReader src = new FileReader (source);
      char[] buffer = new char[1024];
      int len;
      
      while ((len = src.read (buffer, 0, buffer.length)) != -1) {
	output.output.write (buffer, 0, len);
      }
      
      src.close ();
      output.close ();
    } catch (FileNotFoundException e) {
      /* not reached */
    } catch (IOException e) {
      /* not reached */
    }
  }
  
  /**
    * printing and emitting primitive no line feed 
    *
    * @param s string value
    */
  static void emit (String s) {  
    emitter_obj.output.print (s); 
  }
  
  /**
    * printing and emitting primitive no line feed 
    *
    * @param o object value
    */
  static void emit (Object o) { 
    if (o != null) {
      emitter_obj.output.print (o);
    }
  }
  
  /**
    * printing and emitting primitive with line feed 
    *
    * @param s stirng value
    */
  static void emitln (String s) {
    emitter_obj.output.println (s);
    emit (emitter_obj.indent);
  }
  
  /**
    * printing and emitting line feed 
    */
  static void emitln () {
    emitter_obj.output.println ();
    emit (emitter_obj.indent);
  }

  /**
    * printing and emitting line feed with line number
    *
    * @param ln line number
    */
  static void emitln (int ln) {
    emitter_obj.output.println ();
    if (isEmitting ()) 
      emitter_obj.output.println ("// " + ln);
    emit (emitter_obj.indent);
  }

  /** 
    * printing all definition (for debug)
    */
  static void printAll (ClassList c_list) {
    emitter_obj.output = ozc.getLog ();
    for (int i = 0, size = c_list.size (); i < size; i++) {
      ClassType c = (ClassType) c_list.elementAt (i);

      c.emitDefinition ();
      emitln ();
    }
  }

  /**
    * add a class which should be compiled.
    *
    * @param c class
    */
  static void addToNeedCompiles (ClassType c) {
    if (!emitter_obj.need_compiles.contains (c))
      emitter_obj.need_compiles.addElement (c);
  }

  /**
    * set flag of emitting fail
    */
  static void cannotJavaCompile () {
    emitter_obj.status = false;
  }
}

/* EOF */
