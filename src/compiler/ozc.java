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
 * $Id: ozc.java,v 0.47 1998-02-02 08:31:46+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.10
 */

package JP.go.ipa.oz.compiler;

import java.io.*;

/**
  * main class of OZ language compiler
  *
  * @see School
  * @see parser
  */

public class ozc extends JP.go.ipa.oz.system.OzSecure {
  /**
    * mode of compiler
    * 	if only_interface = true, compile class interface only,
    *  or compile everything
    */
  private boolean only_interface;

  /**
    * files of which interface has compiled already
    */
  private java.util.Vector compiled_files;

  /**
    * files of which interface has tried compilation already
    */
  private java.util.Vector compiled_interface;

  /**
    * files of which implementation has tried compilation already
    */
  private java.util.Vector compiled_implementation;

  /**
    * logging stream
    */
  private Output log;

  /**
    * domain name
    */
  protected String domain;

  /**
    * java source files
    */
  protected java.util.Vector java_srcs;

  /**
    * output directory for release compilation
    */
  protected String output_directory;

  /**
    * access for domain
    */
  static String getDomain () {
    return getOzc ().domain;
  }

  /**
    * table of classes readed from school
    */
  protected School school;

  /**
    * flag if parsing now
    */
  protected boolean parsing_now;

  /**
    * access school of current compiler
    */
  static School getSchool () {
    return getOzc ().school;
  }

  /* constants for command line options */
  static final String HELP = "-help";
  static final String INTERFACE = "-interface";
  static final String SCHOOL = "-school";
  static final String VERSION = "-version";
  static final String DOMAIN = "-domain";
  static final String SOURCE_SUFFIX = ".oz";
  static final String CLASS_SUFFIX = ".class";

  /* debug mode constants */
  static final int M_NORMAL = 0;
  static final int M_VERBOSE = 0x10;
  static final String VERBOSE = "-verbose";
  static final int M_VERBOSE_DEEPLY = 0x20;
  static final String VERBOSE_DEEPLY = "-check";
  static final int M_PRINT = 0x1;
  static final String PRINT = "-printtree";
  static final int M_SCANNER_DEBUG = 0x2;
  static final String SCANNER_DEBUG = "-scanner";
  static final int M_PARSER_DEBUG = 0x4;
  static final String PARSER_DEBUG = "-parser";
  static final int M_DEBUG = 0x8;
  static final String DEBUG = "-debug";
  static final int M_TEST = 0x40;
  static final String TEST = "-test";
  static final String DIR = "-dir";
  static final String LOG = "-log";

  static final String CAFE = "-cafe";

  /* property */
  static final String PROPERTY_KEY = "lib" + File.separator + "ozc.properties";
  static final String OZ_HOME_KEY = "oz.home";

  /**
    * debug mode
    */
  protected int debug = M_NORMAL;

  /**
    * oz compiler management table
    */
  static java.util.Hashtable ozc_table;

  /**
    * get ozc compiler object
    *
    * @return compiler
    */
  protected static ozc getOzc () {
    return (ozc) ozc_table.get (Thread.currentThread ());
  }

  /**
    * check whether now mode is verbose
    *
    * @return if so true, otherwise false
    */
  static boolean isVerbose () { return getOzc ()._isVerbose (); }

  /**
    * check whether now mode is verbose
    *
    * @return if so true, otherwise false
    */
  boolean _isVerbose () { return (debug & M_VERBOSE) != 0; }

  /**
    * check whether now mode is verbose deeply
    *
    * @return if so true, otherwise false
    */
  static boolean isVerboseDeeply () { return getOzc ()._isVerboseDeeply (); }

  /**
    * check whether now mode is verbose deeply
    *
    * @return if so true, otherwise false
    */
  boolean _isVerboseDeeply () { return (debug & M_VERBOSE_DEEPLY) != 0; }

  /**
    * check whether now mode is debugging parser
    *
    * @return if so true, otherwise false
    */
  static boolean isParserDebug () { return getOzc ()._isParserDebug (); }

  /**
    * check whether now mode is debugging parser
    *
    * @return if so true, otherwise false
    */
  boolean _isParserDebug () { return (debug & M_PARSER_DEBUG) != 0; }

  /**
    * check whether now mode is debugging scanner
    *
    * @return if so true, otherwise false
    */
  static boolean isScannerDebug () { return getOzc ()._isScannerDebug (); }

  /**
    * check whether now mode is debugging scanner
    *
    * @return if so true, otherwise false
    */
  boolean _isScannerDebug () { return (debug & M_SCANNER_DEBUG) != 0; }

  /**
    * check whether now mode is debugging this
    *
    * @return if so true, otherwise false
    */
  static boolean isDebug () { return getOzc ()._isDebug (); }

  /**
    * check whether now mode is debugging this
    *
    * @return if so true, otherwise false
    */
  boolean _isDebug () { return (debug & M_DEBUG) != 0; }

  /**
    * check whether now mode is print tree of result
    *
    * @return if so true, otherwise false
    */
  static boolean isPrint () { return getOzc ()._isPrint (); }

  /**
    * check whether now mode is print tree of result
    *
    * @return if so true, otherwise false
    */
  boolean _isPrint () { return (debug & M_PRINT) != 0; }

  /**
    * check whether now mode is testing
    *
    * @return if so true, otherwise false
    */
  static boolean isTest () { return getOzc ()._isTest (); }

  /**
    * check whether now mode is testing
    *
    * @return if so true, otherwise false
    */
  boolean _isTest () { return (debug & M_TEST) != 0; }

  /**
    * register compiler object to management table
    *
    * @param t current thread
    * @param o compiler
    */
  static void register (Thread t, ozc o) {
    ozc obj = (ozc) ozc_table.get (t);
    if (obj != null) {
      if (obj == o) return;

      ozc_table.remove (t);
    }
    try {
      ozc_table.put (t, o);
    } catch (NullPointerException e) {
      e.printStackTrace ();
      System.exit (-1);
    }
  }

  /**
    * main method
    *
    * @param av command line arguments
    */
  public static void main (String av[]) {
     if (av[0].equals (CAFE)) {
      java.util.Properties p = System.getProperties ();
      String oz_home = "f:\\oz\\OZ-Beta-R1";
      p.put (OZ_HOME_KEY, oz_home);
      StringBuffer s = new StringBuffer ();
      s.append (".;");
      s.append (oz_home + "\\lib;");
      s.append ("c:\\cafe\\java\\lib\\classes.zip;");
      s.append ("c:\\cafe\\java\\lib");
      p.put ("java.class.path", s.toString ());
      System.setProperties (p);
//      ozc.debugln ("java.class.path = " +
//		   System.getProperty ("java.class.path"));
    }

     (new ozc ())._compile (av);
  }

  /**
    * initialize
    *
    */
  public static void initialize () {
    /* loading property */
    String oz_home = System.getProperty (OZ_HOME_KEY);
    String ozc_property = oz_home + File.separator +
      PROPERTY_KEY;

    try {
      OzcProperty.load (new FileInputStream (ozc_property));
    } catch (IOException e) {
      System.err.println ("cannot open 'ozc.properties'.");
      System.exit (-1);
    }
    ozc_table = new java.util.Hashtable ();
  }

  /**
    * create new one
    */
  public ozc () {
    log = new Output (new PrintWriter (System.err, true));
    if (ozc_table == null) {
      initialize ();
    }
  }

  /**
    * start compilation
    *
    * @param av arguments
    * @return if success return true, otherwise false
    */
  public boolean compile (String av[]) {
    log = new Output (new PrintWriter (System.err, true));
    return _compile (av);
  }

  /**
    * start compilation
    *
    * @param av arguments
    * @param output logging  target
    * @return if success return true, otherwise false
    */
  public boolean compile (String av[], Output output) {
    log = output;
    return _compile (av);
  }

  /**
    * start compilation
    *
    * @param av arguments
    * @return if success return true, otherwise false
    */
  private boolean _compile (String av[]) {
    register (Thread.currentThread (), this);

    String sources[] = parse_options (av);
    if (sources == null) return false;

    compiled_files = new java.util.Vector ();
    compiled_interface = new java.util.Vector ();
    compiled_implementation = new java.util.Vector ();
    java_srcs = new java.util.Vector ();

    boolean status;

    if (isScannerDebug ()) {
      status = scanner_debug (sources);
    } else if (isParserDebug ()) {
      status = parser_debug (sources);
    } else {
      OzcProperty.setupSystemExceptions ();
      status = compileAll (sources);
    }
    if (isVerbose ()) ozc.debugln ("ozc done.");

    return status;
  }

  /**
    * check option string
    *
    * @param av option string
    * @param str comparing string
    * @return if match true, otherwise false
    */
  private boolean startsWith (String av, String str) {
    return av.equals (str) || av.regionMatches (0, str, 0, 2);
  }

  /**
    * parsing and checking command options and args.
    *
    * @param av arguments
    * @return source file names
    */
  private String[] parse_options (String av[]) {
    String school_source = null;
    int i, size;
    boolean print_version = false;

    for (i = 0, size = av.length; i < size; i++) {
      if (av[i].endsWith (SOURCE_SUFFIX)) {
	break;

      } else if (av[i].equals (PRINT)) {
	debug |= M_PRINT;

      } else if (av[i].equals (SCANNER_DEBUG)) {
	debug |= M_SCANNER_DEBUG;

      } else if (av[i].equals (PARSER_DEBUG)) {
	debug |= M_PARSER_DEBUG;

      } else if (av[i].equals (DEBUG)) {
	debug |= M_DEBUG;

      } else if (av[i].equals (TEST)) {
	debug |= M_TEST;

      } else if (av[i].equals (VERSION)) {
	ozc.debugln (version.version_string);

	print_version = true;

      } else if (av[i].equals (LOG)) {
	if (i + 1 == size) {
	  printUsage ();
	  return null;
	}

	try {
	  log = new Output (new PrintWriter (new FileOutputStream (av[++i]), true));
	} catch (IOException e) {
	  OzcError.cannotOpenLog (av[++i]);
	  return null;
	}
      } else if (av[i].equals (CAFE)) {
	continue;

      } else if (av[i].equals (DIR)) {
	output_directory = av[++i];

      } else if (startsWith (av[i], HELP)) {
	printUsage ();
	return null;

      } else if (startsWith (av[i], INTERFACE)) {
	only_interface = true;

      } else if (startsWith (av[i], SCHOOL)) {
	if (i + 1 == size) {
	  /* one additional value need (name of school) */
	  return null;
	}
	school_source = av[++i];

      } else if (startsWith (av[i], VERBOSE)) {
	debug |= M_VERBOSE;

      } else if (startsWith (av[i], VERBOSE_DEEPLY)) {
	debug |= M_VERBOSE_DEEPLY;

      } else if (startsWith (av[i], DOMAIN)) {
	if (i + 1 == size) {
	  /* one additional value need (name of domain) */
	  return null;
	}
	domain = av[++i];

      } else {
	printUsage ();
	return null;
      }
    }

    if (size == i) {
    if (print_version) return null;

      /* must specify at least one source file */
      OzcError.noSourceFile ();
      return null;
    }

    String sources[] = new String[size - i];
    for (int j = 0; i < size; i++, j++) sources[j] = av[i];

    setupSchool (school_source);

    return sources;
  }

  /**
    * prepare school
    *
    * @param school_source school file name
    */
  protected void setupSchool (String school_source) {
    if (school_source != null) {
      if (isVerbose ())
	ozc.debugln (school_source + ": loading school.");
    }

    school = new School ();
    try {
      school.load (school_source);
    } catch (IOException e) {
      OzcError.cannotLoadSchool (school_source);
    }
  }

  /**
    * print usage
    */
  private void printUsage () {
    ozc.debugln ("Usage: ozc [-v] [-i] -s <school> <files...>");
  }

  /**
    * compiling all (toplevel)
    *
    * @param files source file names
    * @return if success true, otherwise false
    */
  private boolean compileAll (String files[]) {
    boolean status = true;

    for (int i = 0, size = files.length; i < size; i++) {
      if (!compile (files[i], only_interface))
	status = false;
    }

    for (java.util.Enumeration enum = compiled_files.elements ();
	 enum.hasMoreElements (); )
      if (!compile ((String) enum.nextElement (), false)) status = false;

    return javac () || status;
  }

  /**
    * compiling one file
    *
    * @param file source file name
    * @param only_interface if compiling only interface part
    * @return if success true, otherwise false
    */
  private boolean compile (String file, boolean only_interface) {
    ClassList cl;
    boolean already_parsing = parsing_now;
    parser p = new parser ();

    parsing_now = true;

    if (only_interface) {
      if (compiled_interface.contains (file))
	return false;

      compiled_interface.addElement (file);

      cl = p.parseInterface (file);
    } else {
      if (compiled_implementation.contains (file) ||
	  (compiled_interface.contains (file) &&
	   !compiled_files.contains (file))) {
	parsing_now = already_parsing;
	return false;
      }

      compiled_implementation.addElement (file);

      cl = p.parseImplementation (file);
    }

    parsing_now = already_parsing;

    boolean status = false;
    if (cl != null) {
      if (isPrint ()) {
	Emitter.printAll (cl);
	return true;
      }

      status = Emitter.generate (file, cl, java_srcs, output_directory);
    }

    if (!status) ozc.debugln (file + ": cannot compile.");

    if (!only_interface && compiled_files.contains (file))
      compiled_files.removeElement (file);

    return status;
  }

  /**
    * compile interface
    *
    * @param source file name
    * @return if success true, otherwise false
    */
  static boolean compileInterface (String file) {
    return getOzc ()._compileInterface (file);
  }

  /**
    * compile interface
    *
    * @param source file name
    * @return if success true, otherwise false
    */
  private boolean _compileInterface (String file) {
    if (!compile (file, true)) return false;
    if (!compiled_files.contains (file))
      compiled_files.addElement (file);
    return true;
  }

  /**
    * compile implementation
    *
    * @param source file name
    * @return if success true, otherwise false
    */
  static boolean compileImplementation (String file) {
    return getOzc ()._compileImplementation (file);
  }

  /**
    * compile implementation
    *
    * @param source file name
    * @return if success true, otherwise false
    */
  private boolean _compileImplementation (String file) {
    if (!compile (file, false)) {
      if (!compiled_files.contains (file))
	compiled_files.addElement (file);
      return false;
    }
    return true;
  }

  /**
    * catch ayn fatal exception (for debug)
    *
    * @param e exception
    */
  static void catchException (Exception e) {
    e.printStackTrace ();
    System.err.println (e.getMessage ());
    System.exit (-1);
  }

  /**
    * do debug of scanner
    *
    * @param file names
    * @return if surcess true, otherwise false
    */
  private boolean scanner_debug (String files[]) {
    boolean status = true;
    for (int i = 0; i < files.length; i++) {
      try {
	scanner s = new scanner (files[i]);
//	ozc.debugln ("start scanning for '" + files[i] + "'.");
	while (s.getNextToken ().sym != sym.EOF);
//	ozc.debugln ("end scanning for '" + files[i] + "'.");
      } catch (IOException e) {
	ozc.debugln ("cannot read '" + files[i] + "'.");
	status = false;
      }
    }
    return status;;
  }

  /**
    * do debug of parser
    *
    * @param file names
    * @return if surcess true, otherwise false
    */
  private boolean parser_debug (String files[]) {
    boolean status = true;
    for (int i = 0; i < files.length; i++) {
      parser p = new parser ();
//      ozc.debugln ("start parsing for '" + files[i] + "'.");
      if (!p.parseDebug (files[i], only_interface)) {
	ozc.debugln ("cannot read '" + files[i] + "'.");
	status = false;
      }
//      ozc.debugln ("end parsing for '" + files[i] + "'.");
    }
    return status;
  }

  /**
    * get logging target
    *
    * @return logging target
    */
  static Output getLog () {
    return ((ozc) ozc_table.get (Thread.currentThread ())).log;
  }

  /**
    * output log message
    *
    * @param str string
    */
  static void debug (String str) {
    Output output = getLog ();
    output.print (str);
  }

  /**
    * output log message with new line
    *
    * @param str string
    */
  static void debugln (String str) { getLog ().println (str); }

  /**
    * check if parsing now
    *
    * @return if so true, otherwise false
    */
  boolean isParsing () { return parsing_now; }

  /**
    * change status; end parsing
    */
  void endParsing () { parsing_now = false; }

  /**
    * execute java compilation
    *
    * @return if success true, otherwise false.
    */
  private boolean javac () {
    sun.tools.javac.Main javac = new sun.tools.javac.Main (ozc.getLog (),
							   "ozc");

    int size = java_srcs.size ();

    if (size == 0) return true;

    int parts = 10;
    boolean status = true;
    for (int i = 0, i_size = (size - 1) / parts + 1; i < i_size; i++) {
      int num = parts;
      if (i == i_size - 1 && size % parts != 0) 
	num = size % parts;

      int top = 1;
//      if (output_directory != null)
//	top = 3;

      String []java_files = new String[num + top];

      java_files[0] = "-g"; /* debug mode compilation */
//      if (output_directory != null) {
//	java_files[1] = "-d"; 
//	java_files[2] = output_directory;
//	top = 3;
//      }

      for (int j = 0; j < num; j++) {
	java_files[j + top] = (String) java_srcs.elementAt (j + i * parts);

	if (isVerbose ())
	  debugln (java_files[j + top] + ": compiling java code.");
      }

      if (!javac.compile (java_files)) 
	status = false;
    }

    return status;
  }
}

/* EOF */
