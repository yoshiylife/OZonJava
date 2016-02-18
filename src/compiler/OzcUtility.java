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
 * $Id: OzcUtility.java,v 0.1 1998-03-19 14:22:36+09 otokawa Exp $
 */

package JP.go.ipa.oz.compiler;

import java.lang.reflect.Method;

/**
  * A class supporting compiler in run-time
  */

public class OzcUtility {
  /** 
    * search method by name
    *
    * @param class_name class name
    * @param name method name
    * @param types argument types
    * @return method object
    */
  public static Method searchMethod (String class_name, String name, Class[] types) {
    try {
      Class cl = Class.forName (class_name);
      return cl.getMethod (name, types);
    } catch (ClassNotFoundException e) {
      return null;
    } catch (NoSuchMethodException e) {
      return null;
    } catch (SecurityException e) {
      return null;
    }
  }
}

/* EOF */
