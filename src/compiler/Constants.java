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
 * $Id: Constants.java,v 0.8 1997-06-27 15:00:18+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1997.1.27
 */

package JP.go.ipa.oz.compiler;

/**
  * A class defined constants.
  */

interface Constants {
  /**
    * prefix of package included in JDK
    */
  static String JDK_PACKAGE_PREFIX = "java";

  /**
    * modifier values 
    */
  static int STATIC = 0x08;
  static int FINAL = 0x10;
  static int LOCKED = 0x20;
  static int TRANSIENT = 0x80;
  static int ABSTRACT = 0x400;
  static int ONCE = 0x1000;
  static int GLOBAL = 0x2000;

  /**
    * access modifier values
    */
  static int PRIVATE = 0x0;
  static int PUBLIC = 0x01;
  static int PROTECTED = 0x04;
  static int NEW = 0x4000;

  static int ACCESS_MASK = 0x07;
  /* static int JAVA_FINAL = 0x8000; */
}

/* EOF */



