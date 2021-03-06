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
 * $Id: OzcProperty.java,v 0.12 1998-03-19 14:22:27+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1997.5.20
 */

package JP.go.ipa.oz.compiler;

import java.io.*;
import java.util.*;

/**
  * A class representing property of oz compiler 
  *
  * @see java.util.PropertyResourceBundle
  */

class OzcProperty extends PropertyResourceBundle {
  /* interface class id of language classes */
  static String ROOT_IF = "Root_if";
  static String PROXY_IF = "Proxy_if";
  static String STRING_IF = "String_if";
  static String EXCEPTION_IF = "Exception_if";

  /* implementation class id of language classes */
  static String ROOT_CL = "Root_cl";
  static String PROXY_CL = "Proxy_cl";
  static String STRING_CL = "String_cl";
  static String EXCEPTION_CL = "Exception_cl";

  /* class name of language classes */
  static String OZ_ROOT = "Root";
  static String OZ_PROXY = "Proxy";
  static String OZ_STRING = "String";
  static String OZ_CELL = "Cell";
  static String CONDITION = "Condition";
  static String OZ_EXCEPTION = "OzException";

  /* package prefixs */
  static String USER_PACKAGE_PREFIX = "UserPackage";
  static String SYSTEM_PACKAGE_PREFIX = "SystemPackage";
  static String LANG_PACKAGE_PREFIX = "LangPackage";

  /* root class names */
  static String COMMON_ROOT = "CommonRoot";
  static String COMMON_CELL_ROOT = "CommonCellRoot";
  static String CREATE_CELL = "CreateCell";

  /* utlity class name */
  static String UTILITY = "Utility";

  /* source suffix */
  static String SOURCE_SUFFIX = "SourceSuffix";
  static String CLASS_SUFFIX = "ClassSuffix";
  static String CLASS_INFO_SUFFIX = "ClassInfoSuffix";
  static String JAVA_SUFFIX = "JavaSuffix";

  /* method name for exception */
  static String GET_EXCEPTION = "GetExceptionMethod";

  /* prefix representing class modifier */
  static String GLOBAL_MODIFIER = "GlobalModifier";
  static String FINAL_MODIFIER = "FinalModifier";

  /* postfix for classe generated by compiler */
  static String PROTECTED_POSTFIX = "ProtectedPostfix";
  static String THROWABLE_POSTFIX = "ThrowablePostfix";

  /* proxy and cell class name and id postfix */
  static String PROXY_PREFIX = "ProxyPrefix";
  static String PROXY_PCL_POSTFIX = "ProxyPclPostfix";
  static String PROXY_PCC_POSTFIX = "ProxyPccPostfix";

  /* prefix representing member modifier */
  static String STATIC_PREFIX = "StaticPrefix";
  static String FINAL_PREFIX = "FinalPrefix";
  static String NEW_PREFIX = "NewPrefix";

  /* system exception property */
  static String SYSTEM_EXCEPTION = "SystemException";
  static String NUM_SYSTEM_EXCEPTION = "NumberOfSystemExceptions";

  /* postfix for class id */
  static String INTERFACE_POSTFIX = "InterfacePostfix";
  static String IMPLEMENTATION_POSTFIX = "ImplementationPostfix";

  /**
    * system exception table 
    */
  static Hashtable system_exceptions;

  /**
    * property 
    */
  static OzcProperty property;

  /**
    * create property 
    *
    * @param in property source
    */
  OzcProperty (InputStream in) throws IOException { 
    super (in); 

    ROOT_IF = (String) handleGetObject (ROOT_IF);
    PROXY_IF = (String) handleGetObject (PROXY_IF);
    STRING_IF = (String) handleGetObject (STRING_IF);
    EXCEPTION_IF = (String) handleGetObject (EXCEPTION_IF);

    ROOT_CL = (String) handleGetObject (ROOT_CL);
    PROXY_CL = (String) handleGetObject (PROXY_CL);
    STRING_CL = (String) handleGetObject (STRING_CL);
    EXCEPTION_CL = (String) handleGetObject (EXCEPTION_CL);

    OZ_ROOT = (String) handleGetObject (OZ_ROOT);
    OZ_PROXY = (String) handleGetObject (OZ_PROXY);
    OZ_CELL = (String) handleGetObject (OZ_CELL);
    OZ_STRING = (String) handleGetObject (OZ_STRING);
    CONDITION = (String) handleGetObject (CONDITION);
    OZ_EXCEPTION = (String) handleGetObject (OZ_EXCEPTION);

    USER_PACKAGE_PREFIX = (String) handleGetObject (USER_PACKAGE_PREFIX);
    SYSTEM_PACKAGE_PREFIX = (String) handleGetObject (SYSTEM_PACKAGE_PREFIX);
    LANG_PACKAGE_PREFIX = (String) handleGetObject (LANG_PACKAGE_PREFIX);

    COMMON_ROOT = (String) handleGetObject (COMMON_ROOT);
    COMMON_CELL_ROOT = (String) handleGetObject (COMMON_CELL_ROOT);
    CREATE_CELL = (String) handleGetObject (CREATE_CELL);

    UTILITY = (String) handleGetObject (UTILITY);

    SOURCE_SUFFIX = (String) handleGetObject (SOURCE_SUFFIX);
    CLASS_SUFFIX = (String) handleGetObject (CLASS_SUFFIX);
    CLASS_INFO_SUFFIX = (String) handleGetObject (CLASS_INFO_SUFFIX);
    JAVA_SUFFIX = (String) handleGetObject (JAVA_SUFFIX);

    GET_EXCEPTION = (String) handleGetObject (GET_EXCEPTION);

    GLOBAL_MODIFIER = (String) handleGetObject (GLOBAL_MODIFIER);
    FINAL_MODIFIER = (String) handleGetObject (FINAL_MODIFIER);

    PROTECTED_POSTFIX = (String) handleGetObject (PROTECTED_POSTFIX);

    PROXY_PREFIX = (String) handleGetObject (PROXY_PREFIX);
    PROXY_PCL_POSTFIX = (String) handleGetObject (PROXY_PCL_POSTFIX);
    PROXY_PCC_POSTFIX = (String) handleGetObject (PROXY_PCC_POSTFIX);

    STATIC_PREFIX = (String) handleGetObject (STATIC_PREFIX);
    FINAL_PREFIX = (String) handleGetObject (FINAL_PREFIX);
    NEW_PREFIX = (String) handleGetObject (NEW_PREFIX);

    INTERFACE_POSTFIX = (String) handleGetObject (INTERFACE_POSTFIX);
    IMPLEMENTATION_POSTFIX = (String) handleGetObject (IMPLEMENTATION_POSTFIX);

  }

  /**
    * load property from file
    *
    * @param in source
    */
  static void load (InputStream in) throws IOException {
    property = new OzcProperty (in);
  }

  /**
    * setup system exception table 
    */
  static void setupSystemExceptions () {
    system_exceptions = new Hashtable ();

    int num 
      = Integer.parseInt ((String) property.handleGetObject (NUM_SYSTEM_EXCEPTION));
    for (int i = 0; i < num; i++) {
      String exception;
      try {
	exception = (String) property.handleGetObject (SYSTEM_EXCEPTION + i);
      } catch (Exception e) {
	continue;
      }

      if (exception == null) continue;
      
      int delimit = exception.indexOf (" ");
      String oz = exception.substring (0, delimit).trim ();
      String java 
	= exception.substring (delimit + 1, exception.length ()).trim ();

      try {
	system_exceptions.put (oz, java);
	ClassInterface cif = new ClassInterface (oz,
						 OzcProperty.EXCEPTION_IF);
	ClassImplementation c 
	  = new ClassImplementation (oz,
				     OzcProperty.EXCEPTION_CL, cif);
	ozc.getSchool ().register (c, oz);
      } catch (Exception e) {
	ozc.catchException (e);
      }
    }
  }

  /**
    * search system exception 
    * 
    * @param name exception name
    * @return system exception class name
    */
  static String search (String name) {
    return (String) system_exceptions.get (name);
  }

  /**
    * search error message 
    *
    * @param key key of error message
    * @return error message string
    */
  static String getErrorMessage (String key) {
    return (String) property.handleGetObject (key);
  }
}

/* EOF */
